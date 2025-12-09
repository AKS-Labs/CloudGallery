# Implementation Plan for Three Features

## Overview
Three related features to improve the backup and selection experience in CloudGallery.

---

## **FEATURE 1: Cancel Upload on Network Type Change or Auto Backup Disable**

### Problem
- User may have active uploads/backups happening
- If user changes network type or disables auto backup while upload is in progress, the app should cancel ongoing uploads
- Next auto backup interval should still work normally

### Solution Architecture

#### 1.1 Add UploadState Management to MainViewModel
- Add a `StateFlow<Boolean>` to track if **any** upload is in progress
- Observe all backup-related work (periodic, instant, and manual)
- Update state when work starts/finishes

#### 1.2 Observe Work Status in SettingsScreen
- Listen to backup work status in Settings
- When user changes network type or disables auto backup toggle:
  - Cancel all ongoing manual uploads (tag: "manual_backup")
  - Cancel instant uploads (tag: "instant_upload")
  - Do NOT cancel periodic backup work (it will reschedule normally)
  - Show toast: "Active uploads cancelled. Auto backup will resume on next interval"

#### 1.3 Implementation Details
**Files to modify:**
- `MainViewModel.kt` - Add `isUploadingFlow` StateFlow
- `SettingsScreen.kt` - Add work cancellation logic in:
  - Network type change `onValueChange`
  - Auto backup toggle disable callback

**What to cancel:**
- Manual backup: `workManager.cancelAllWorkByTag("manual_backup")`
- Instant uploads: `workManager.cancelAllWorkByTag("instant_upload")`
- Keep periodic scheduled work (will reschedule automatically)

---

## **FEATURE 2: BottomToolbarFAB Animation Control**

### Current Behavior
- Animation only shows when user manually clicks the FAB button
- No animation indicator for auto periodic backups
- Animation doesn't reflect actual upload status

### Desired Behavior
- Show animation whenever **ANY** uploading is happening (manual, instant, or periodic)
- Hide animation when all uploads complete
- Clicking FAB while animating = stop all uploads
- Auto periodic backup continues on next interval without issues

### Solution Architecture

#### 2.1 Create Upload State Tracking
**In MainViewModel:**
```kotlin
private val _uploadStateFlow = MutableStateFlow(false)
val isUploading: StateFlow<Boolean> = _uploadStateFlow.asStateFlow()

// Observe all work tags:
// - "manual_backup"
// - "instant_upload"  
// - "PERIODIC_PHOTO_BACKUP_WORK" (periodic, but track separately)
```

#### 2.2 Observe Work Status
- Use `WorkManager.getWorkInfosByTagFlow()` for each upload type
- Track states: ENQUEUED, RUNNING
- Update `_uploadStateFlow` = true if ANY work is ENQUEUED or RUNNING
- Update `_uploadStateFlow` = false if ALL work is SUCCEEDED, FAILED, or CANCELLED

#### 2.3 Modify BottomToolbarFAB
- Remove local `isUploading` state
- Subscribe to `viewModel.isUploading` StateFlow
- Animation shows when `isUploading == true` (from ViewModel, not local state)
- Button click behavior:
  - If uploading: Cancel all work with tags ("manual_backup", "instant_upload")
  - Keep periodic work running (will retry on next interval)
  - Show toast: "Upload stopped"

#### 2.4 Implementation Details
**Files to modify:**
- `MainViewModel.kt` - Add upload state flow and work observation
- `bottomToolbarFAB.kt` - Replace local state with ViewModel state, add click logic

**Work observation pseudocode:**
```kotlin
// Observe all manual and instant uploads
WorkModule.observeWorkerByTag("manual_backup")
WorkModule.observeWorkerByTag("instant_upload")
// Update state if any work is ENQUEUED or RUNNING
```

---

## **FEATURE 3: Select All / Deselect All Toggle**

### Current Bug
- Select All button only works to select
- Clicking again does NOT deselect all items
- Button disabled when all are selected (can't click to deselect)

### Root Cause
- Button has `enabled = !areAllSelected` constraint
- When `areAllSelected == true`, button is disabled
- Function checks `if (areAllSelected)` then clear, else select
- But button is disabled, so click never reaches the function

### Solution

#### 3.1 Fix the Button Enable Logic
**In MainPage.kt TopAppBar actions:**

Change from:
```kotlin
enabled = !areAllSelected
```

To:
```kotlin
enabled = true  // Always enabled for toggle functionality
```

#### 3.2 Update Visual Feedback
- Icon already shows correct description: "Deselect All" when `areAllSelected`
- Icon color already correct: primary color when all selected
- No other changes needed

#### 3.3 Implementation Details
**File to modify:**
- `MainPage.kt` - Line ~751 in TopAppBar actions
  - Remove the `enabled = !areAllSelected` constraint
  - Set `enabled = true`

**That's it!** The `toggleSelectAll()` function already handles both cases:
```kotlin
fun toggleSelectAll() {
    if (areAllSelected) {
        clearSelection()  // Deselect all
    } else {
        // Select all logic...
    }
}
```

---

## Implementation Order (Recommended)

### Phase 1: Fix Select All (Easiest - 5 minutes)
1. Modify MainPage.kt select all button enable constraint

### Phase 2: Add Upload State Tracking (Medium - 20 minutes)
1. Add StateFlow to MainViewModel
2. Create work observation method in WorkModule
3. Update MainViewModel to observe work

### Phase 3: Update BottomToolbarFAB (Medium - 15 minutes)
1. Inject MainViewModel into BottomToolbarFAB
2. Remove local isUploading state
3. Subscribe to ViewModel.isUploading
4. Update click handler for cancel logic

### Phase 4: Add Network Type & Disable Auto Backup Cancellation (Medium - 15 minutes)
1. Add work cancellation to SettingsScreen network type change
2. Add work cancellation to auto backup disable toggle
3. Add appropriate toast messages

---

## Testing Checklist

### Feature 1: Cancel on Network/Disable
- [ ] Start manual upload
- [ ] Change network type while uploading → cancels
- [ ] Start manual upload
- [ ] Disable auto backup toggle while uploading → cancels
- [ ] Verify periodic backup resumes on next interval without issues

### Feature 2: FAB Animation Control
- [ ] Manual upload starts → FAB animates
- [ ] Manual upload completes → FAB stops animating
- [ ] Auto periodic backup starts → FAB animates
- [ ] Auto periodic backup completes → FAB stops animating
- [ ] Click FAB while animating → stops upload, shows toast
- [ ] Periodic backup continues on next interval

### Feature 3: Select All Toggle
- [ ] Click Select All → all items selected
- [ ] Click Select All again → all items deselected
- [ ] Icon text changes appropriately
- [ ] Icon color changes appropriately

---

## Risk Assessment

### Low Risk ✓
- Feature 3 (Select All toggle) - Just removing a constraint
- Feature 2 & 1 work observation - Using existing WorkManager APIs

### Medium Risk
- Cancelling uploads - Need to ensure periodic backup can reschedule
- StateFlow updates - Need to ensure all work tags are monitored

### Mitigation
- Use try-catch for work cancellation
- Test periodic backup resumption thoroughly
- Monitor LogCat for work state changes
