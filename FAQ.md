# Chitralaya CloudGallery – FAQ

> **Disclaimer / Transparency Note:**  
> I, Aditya from AKS-Labs, have shared this information **to the best of my knowledge**.  
> I have tried to be as transparent as possible about how Chitralaya CloudGallery works.  
> Still, you should **not solely rely on this information** — research and understand how Telegram handles your data by reading their **updated policies**.  
> If you have questions, you can join the **[AKS-Labs Telegram group](https://t.me/AKSLabs)** and ask freely without hesitation.  

Chitralaya CloudGallery backs up your photos **directly to your own Telegram account** using your bot token and chat ID No Sign-Up Required.  
No third-party servers, no hidden processing — just your device and Telegram.

---

## 📌 Table of Contents

1. [Does Telegram disclose user data?](#q1-does-telegram-disclose-user-data)  
2. [Is Telegram storage encrypted?](#q2-is-telegram-storage-encrypted)  
3. [Who controls my photos?](#q3-who-controls-my-photos)  
4. [Can the developer access my photos?](#q4-can-the-developer-access-my-photos)  
5. [What happens if I uninstall the app?](#q5-what-happens-if-i-uninstall-the-app)  
6. [What if I lose my phone?](#q6-what-if-i-lose-my-phone)  
7. [What if my bot token is leaked?](#q7-what-if-my-bot-token-is-leaked)  
8. [Does Chitralaya CloudGallery compress or modify photos?](#q8-does-chitralaya-cloudgallery-compress-or-modify-photos)  
9. [How is this different from normal Telegram uploads?](#q9-how-is-this-different-from-normal-telegram-uploads)  
10. [What if Telegram bans or suspends my account?](#q10-what-if-telegram-bans-or-suspends-my-account)  
11. [Can I download my photos back from Telegram?](#q11-can-i-download-my-photos-back-from-telegram)  
12. [Is Chitralaya CloudGallery open source?](#q12-is-chitralaya-cloudgallery-open-source)  
13. [Does this count against Telegram’s storage limit?](#q13-does-this-count-against-telegrams-storage-limit)  
14. [Can Telegram staff see my photos?](#q14-can-telegram-staff-see-my-photos)  
15. [Can I share my bot with family to store their photos?](#q15-can-i-share-my-bot-with-family-to-store-their-photos)  
16. [Does Chitralaya CloudGallery work offline?](#q16-does-chitralaya-cloudgallery-work-offline)  
17. [What if Telegram removes bots in the future?](#q17-what-if-telegram-removes-bots-in-the-future)  
18. [Why use Chitralaya CloudGallery?](#q18-why-use-chitralaya-cloudgallery)  
19. [How does it compare with Google Photos?](#q19-how-does-it-compare-with-google-photos)  
20. [Why choose Chitralaya CloudGallery over Google Photos?](#q20-why-choose-chitralaya-cloudgallery-over-google-photos)  
21. [Support & Future Features](#support--future-features)

---

## 🔹 Part 1: General Questions About Chitralaya CloudGallery

### Q1: Does Telegram disclose user data?  
➡️ According to **Telegram’s Privacy Policy**:  
- Telegram may share **basic account info** (phone, IP, metadata) if legally required.  
- No public cases exist of Telegram sharing **media or photos**, except in very serious criminal cases.  
- Cloud chats are **not end-to-end encrypted**, but are encrypted in transit and at rest.

---

### Q2: Is Telegram storage encrypted?  
➡️ Yes, but **not fully end-to-end**.  
- Data is encrypted in transit and at rest.  
- Telegram technically can access your files, but there are no reports of misuse.

---

### Q3: Who controls my photos?  
➡️ **You do.**  
- Your bot token and chat ID are stored securely in **Android KeyStore (AES encryption)** on your device.  
- Photos are stored **only in your Telegram account**, accessible only by you.  
- No third-party servers or apps can access your media.

---

### Q4: Can the developer access my photos?  
➡️ **No.**  
- Chitralaya CloudGallery never uploads to any server.  
- Only **you and Telegram** can access your uploaded files.

---

### Q5: What happens if I uninstall the app?  
➡️ Your photos remain safe in your Telegram account.  
- The app only uploads; uninstalling doesn’t delete your photos.  

**Important Note:**  
- If you uninstall and reinstall the app with the same credentials, **you will not see old previously uploaded images** in the app because the Telegram Bot API **cannot read old messages without the correct chat IDs**.  
- To solve this, the app creates a **local database** on your device storing synced images, chat IDs, and metadata.  
- This database allows you to:  
  - Import it when reinstalling the app.  
  - Use it on another device to see previously synced images.  
- **Security Note:**  
  - The database is stored as a readable JSON file and is **not encrypted**.  
  - Anyone who gets access to this file can read its contents.  
  - You are responsible for keeping it safe.  
  - For safety, the app **daily syncs this database to your chosen Telegram chat** so you can restore it if lost.

---

### Q6: What if I lose my phone?  
➡️ Your photos are still in Telegram.  
- You can log in on another device to access all files.  
- Just keep your **Telegram credentials** safe.

---

### Q7: What if my bot token is leaked?  
➡️ Even if someone has your bot token, **they cannot access your old images**.  
- Telegram Bot API **cannot read old messages** without the correct chat ID.  
- They can **only upload new images** to the same bot, not access previously uploaded media.

---

### Q8: Does Chitralaya CloudGallery compress or modify photos?  
➡️ **No.**  
- All photos are uploaded **exactly as they are**, no compression, no resizing, no AI processing.

---

### Q9: How is this different from normal Telegram uploads?  
➡️ Normal uploads are **manual**.  
- Chitralaya CloudGallery automates full-device photo backup directly to your bot chat.  
- **Enhanced Gallery Experience:**  
  - Browse photos in a beautiful gallery interface.  
  - Download images directly from the app.  
  - Schedule automatic backups.  
  - See both local and synced images together.  
  - Completely ad-free for smooth experience.

---

### Q10: What if Telegram bans or suspends my account?  
➡️ Telegram bans are very rare, usually due to policy violations.  
- **Family Account Workaround:** If you add a secondary or family member’s account to the group/channel where you are uploading, you can still access your uploaded media through that account.  
- Otherwise, always maintain **Telegram compliance** to avoid account issues.

---

### Q11: Can I download my photos back from Telegram?  
➡️ Yes, you can:  
- Directly via Telegram app or Telegram Desktop.  
- **Or using Chitralaya CloudGallery**, which allows downloading within the app.

---

### Q12: Is Chitralaya CloudGallery open source?  
➡️ **Yes.**  
- Full code is on GitHub.  
- Anyone can audit it for security or privacy.

---

### Q13: Does this count against Telegram’s storage limit?  
➡️ Telegram doesn’t have a strict limit for personal cloud/bot storage.  
- Practically **unlimited** for normal users.

---

### Q14: Can Telegram staff see my photos?  
➡️ Theoretically, Telegram staff **could access chats**, but they **respect user privacy**.  
- They only share **identification data** such as IP, phone number, or metadata on valid legal request or in severe illegal/criminal cases.  
- Please consider reading **Telegram’s privacy policy** for full details.

---

### Q15: Can I share my bot with family to store their photos?  
➡️ Technically yes, but **not recommended** with the same token.  
- Create **separate bots** for each user for safety.

---

### Q16: Does Chitralaya CloudGallery work offline?  
➡️ No.  
- Internet is required to upload photos via Telegram Bot API.

---

### Q17: What if Telegram removes bots in the future?  
➡️ Chitralaya CloudGallery may stop uploading new photos, but **already uploaded media will likely remain accessible** in your Telegram account.

---

### Q18: Why use Chitralaya CloudGallery?  
➡️ It offers:  
- Full control (your bot, your account, your rules)  
- Unlimited storage  
- **No AI, no compression, no hidden processing**  
- Transparent, open-source backup solution  

---

## 🔹 Part 2: Comparing Chitralaya CloudGallery with Google Photos

### Q19: How does it compare with Google Photos?  

- **True Privacy & No AI Processing**  
- **Full-Quality Storage**  
- **Data Control**  
- **Transparent & Ad-Free**  
- **Unlimited Storage Potential**  
- **Cross-Device Safety**  
- **Open Source & Trustworthy**

*(All points elaborated above in previous sections.)*

---

### Q20: Why choose Chitralaya CloudGallery over Google Photos?  
➡️ Because it gives:  
- **Full user control** (your bot, your token, your chat)  
- **Unlimited storage**  
- **No AI or hidden processing**  
- Photos remain private **between you and Telegram only**

---

## 💖 Support & Future Features

If you like my work, please consider **donating** to this project so it can stay alive and I can implement more features:  

**Planned Features:**  
1. OCR search in-app & Telegram (search images by text inside them)  
2. Batch select & upload  
3. Batch select & delete  
4. More beautiful M3 expressive UI/UX  
5. Configure multiple bots  
6. Folder-specific uploads  
7. Your suggestions! Share on **[AKS-Labs Telegram group](https://t.me/AKSLabs)**

---

✅ **Bottom Line:**  
Chitralaya CloudGallery is **open-source, transparent, and provides unlimited user-controlled storage** — a strong, practical alternative to Google Photos or iCloud.
