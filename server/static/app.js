const API = '/api';

// Tab switching
function switchTab(tab) {
  document.querySelectorAll('.tab-content').forEach(s => s.classList.remove('active'));
  document.querySelectorAll('.tab').forEach(t => t.classList.remove('active'));
  document.getElementById('tab-' + tab).classList.add('active');
  document.querySelector(`[data-tab="${tab}"]`).classList.add('active');

  const loaders = { timeline: loadTimeline, people: loadPeople, places: loadPlaces, albums: loadAlbums, memories: loadMemories };
  if (loaders[tab]) loaders[tab]();
}

// Fetch helper
async function api(path) {
  try {
    const r = await fetch(API + path);
    return await r.json();
  } catch (e) { console.error('API error:', path, e); return null; }
}

// Stats + Recent
async function loadOverview() {
  const [photos, people, places, albums] = await Promise.all([
    api('/photos?limit=50'), api('/people/'), api('/places/'), api('/albums/')
  ]);

  const totalPhotos = photos?.total || photos?.length || 0;
  const favs = 0; // no favorites endpoint yet
  const statsHtml = [
    { n: totalPhotos, l: 'Photos', icon: '📷' },
    { n: favs, l: 'Favorites', icon: '⭐' },
    { n: albums?.length || 0, l: 'Albums', icon: '📁' },
    { n: people?.length || 0, l: 'People', icon: '👤' },
    { n: places?.length || 0, l: 'Places', icon: '📍' },
  ].map(s => `<div class="stat-card"><div class="number">${s.n}</div><div class="label">${s.icon} ${s.l}</div></div>`).join('');
  document.getElementById('statsGrid').innerHTML = statsHtml;

  const items = photos?.photos || photos || [];
  document.getElementById('recentPhotos').innerHTML = items.slice(0, 50).map(p => {
    const d = p.date_taken || p.created_at || '';
    const short = d ? new Date(d).toLocaleDateString() : '';
    return `<div class="photo-tile"><span class="icon">🖼️</span><span class="date">${short}</span></div>`;
  }).join('') || '<p style="color:var(--text-dim)">No photos yet</p>';
}

// Timeline
async function loadTimeline() {
  const el = document.getElementById('timelineContent');
  if (el.dataset.loaded) return;
  el.innerHTML = 'Loading...';
  const data = await api('/timeline/?limit=500');
  const items = data?.timeline || data || [];

  // Group by date
  const groups = {};
  items.forEach(p => {
    const d = (p.date_taken || p.created_at || '').split('T')[0] || 'Unknown';
    (groups[d] = groups[d] || []).push(p);
  });

  el.innerHTML = Object.entries(groups).sort((a,b) => b[0].localeCompare(a[0])).map(([date, photos]) =>
    `<div class="timeline-group">
      <div class="timeline-header" onclick="this.nextElementSibling.classList.toggle('open')">
        <span>${date}</span><span>${photos.length} photo${photos.length>1?'s':''}</span>
      </div>
      <div class="timeline-photos">${photos.map(p =>
        `<div class="photo-tile"><span class="icon">🖼️</span><span class="date">${(p.filename||'').substring(0,15)}</span></div>`
      ).join('')}</div>
    </div>`
  ).join('') || '<p style="color:var(--text-dim)">No timeline data</p>';
  el.dataset.loaded = '1';
}

// People
async function loadPeople() {
  const el = document.getElementById('peopleContent');
  if (el.dataset.loaded) return;
  el.innerHTML = 'Loading...';
  const data = await api('/people/');
  const people = data || [];
  el.innerHTML = people.map(p =>
    `<div class="card"><h3>👤 ${p.name || 'Unknown #' + p.id}</h3><div class="meta">${p.photo_count || 0} photos</div></div>`
  ).join('') || '<p style="color:var(--text-dim)">No people detected yet</p>';
  el.dataset.loaded = '1';
}

// Places
async function loadPlaces() {
  const el = document.getElementById('placesContent');
  if (el.dataset.loaded) return;
  el.innerHTML = 'Loading...';
  const data = await api('/places/');
  const places = data || [];
  el.innerHTML = places.map(p =>
    `<div class="card"><h3>📍 ${p.name || p.city || p.country || 'Unknown'}</h3><div class="meta">${p.photo_count || 0} photos</div></div>`
  ).join('') || '<p style="color:var(--text-dim)">No location data</p>';
  el.dataset.loaded = '1';
}

// Albums
async function loadAlbums() {
  const el = document.getElementById('albumsContent');
  el.innerHTML = 'Loading...';
  const data = await api('/albums/');
  const albums = data || [];
  el.innerHTML = albums.map(a =>
    `<div class="card"><h3>📁 ${a.name}</h3><div class="meta">${a.photo_count || 0} photos</div></div>`
  ).join('') || '<p style="color:var(--text-dim)">No albums yet</p>';
}

async function createAlbum() {
  const input = document.getElementById('newAlbumName');
  const name = input.value.trim();
  if (!name) return;
  await fetch(API + '/albums/', { method: 'POST', headers: { 'Content-Type': 'application/json' }, body: JSON.stringify({ name }) });
  input.value = '';
  loadAlbums();
}

// Memories
async function loadMemories() {
  const el = document.getElementById('memoriesContent');
  el.innerHTML = 'Loading...';
  const data = await api('/timeline/on-this-day');
  const items = data?.memories || data || [];

  if (!items.length) {
    el.innerHTML = '<p style="color:var(--text-dim)">No memories for today</p>';
    return;
  }

  // Group by year
  const years = {};
  items.forEach(p => {
    const y = (p.date_taken || '').substring(0, 4) || '?';
    (years[y] = years[y] || []).push(p);
  });

  el.innerHTML = Object.entries(years).sort((a,b) => a[0]-b[0]).map(([year, photos]) =>
    `<div class="memory-year"><h3>${year} — ${photos.length} photo${photos.length>1?'s':''}</h3>
    <div class="photo-grid">${photos.map(p =>
      `<div class="photo-tile"><span class="icon">🖼️</span><span class="date">${(p.filename||'').substring(0,15)}</span></div>`
    ).join('')}</div></div>`
  ).join('');
}

// Search
async function doSearch() {
  const q = document.getElementById('searchInput').value.trim();
  if (!q) return;
  document.getElementById('searchTab').style.display = '';
  switchTab('search-results');
  const el = document.getElementById('searchResults');
  el.innerHTML = 'Searching...';
  const data = await api('/search?q=' + encodeURIComponent(q));
  const items = data?.results || data || [];
  el.innerHTML = items.map(p =>
    `<div class="photo-tile"><span class="icon">🖼️</span><span class="date">${(p.filename||'').substring(0,15)}</span></div>`
  ).join('') || '<p style="color:var(--text-dim)">No results</p>';
}

document.getElementById('searchInput').addEventListener('keydown', e => { if (e.key === 'Enter') doSearch(); });

// Init
loadOverview();
lucide.createIcons();
