  D  Tiff header had invalid endian marker 0x45,0x78,0x69,0x66.
2025-11-24 16:13:45.124 11672-11672 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-11-24 16:13:46.973 11672-18934 BotApi                  com.akslabs.cloudgallery             I  Received 0 updates from Telegram
2025-11-24 16:13:46.973 11672-18934 BotApi                  com.akslabs.cloudgallery             I  Scan complete: Found 0 media files
2025-11-24 16:13:46.974 11672-18934 Historical...eDiscovery com.akslabs.cloudgallery             D  Batch 1: Found 0 media files
2025-11-24 16:13:46.974 11672-18934 Historical...eDiscovery com.akslabs.cloudgallery             I  Batch 1: Processing 0 new files
2025-11-24 16:13:46.979 11672-18934 Historical...eDiscovery com.akslabs.cloudgallery             I  No more messages to scan
2025-11-24 16:13:46.979 11672-18934 Historical...eDiscovery com.akslabs.cloudgallery             I  No new images found to sync
2025-11-24 16:13:46.979 11672-18934 Historical...eDiscovery com.akslabs.cloudgallery             I  === HISTORICAL IMAGE DISCOVERY COMPLETE ===
2025-11-24 16:13:46.979 11672-18934 Historical...eDiscovery com.akslabs.cloudgallery             I  Total batches processed: 1
2025-11-24 16:13:46.979 11672-18934 Historical...eDiscovery com.akslabs.cloudgallery             I  Total new files discovered: 0
2025-11-24 16:13:46.980 11672-18934 CloudPhotoSyncService   com.akslabs.cloudgallery             D  Updated last sync timestamp to: 1763981026979
2025-11-24 16:13:46.980 11672-18934 CloudPhotoSyncService   com.akslabs.cloudgallery             I  === FULL CLOUD PHOTO SYNC COMPLETE ===
2025-11-24 16:13:46.980 11672-18934 CloudPhotoSyncWorker    com.akslabs.cloudgallery             I  Cloud photo sync completed successfully: 0 new files
2025-11-24 16:13:46.980 11672-18934 CloudPhotoSyncWorker    com.akslabs.cloudgallery             I  === CLOUD PHOTO SYNC WORKER FINISHED ===
2025-11-24 16:13:46.984 11672-18941 WM-WorkerWrapper        com.akslabs.cloudgallery             I  Worker result SUCCESS for Work [ id=63ebc9c0-ce1e-4f80-85bf-accaeda1a5cd, tags={ com.akslabs.cloudgallery.workers.CloudPhotoSyncWorker } ]
2025-11-24 16:13:46.995 11672-11672 WM-SystemFgDispatcher   com.akslabs.cloudgallery             I  Stopping foreground service
2025-11-24 16:13:47.483 11672-11672 InsetsController        com.akslabs.cloudgallery             D  hide(ime(), fromIme=false)
2025-11-24 16:13:47.483 11672-11672 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:5067b164: onCancelled at PHASE_CLIENT_ALREADY_HIDDEN
2025-11-24 16:13:49.080 11672-11672 WindowOnBackDispatcher  com.akslabs.cloudgallery             W  sendCancelIfRunning: isInProgress=false callback=androidx.compose.ui.window.Api33Impl$$ExternalSyntheticLambda0@acbdbc1
2025-11-24 16:13:49.089 11672-18924 HWUI                    com.akslabs.cloudgallery             D  endAllActiveAnimators on 0x783b172e00 (UnprojectedRipple) with handle 0x789a0dac20
2025-11-24 16:13:50.749 11672-11672 MainViewModel           com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-11-24 16:13:50.802 11672-11672 AndroidRuntime          com.akslabs.cloudgallery             E  FATAL EXCEPTION: main (Explain with AI)
                                                                                                    Process: com.akslabs.cloudgallery, PID: 11672
                                                                                                    java.lang.IllegalStateException: An instance of PagingSource was re-used when Pager expected to create a new
                                                                                                    instance. Ensure that the pagingSourceFactory passed to Pager always returns a
                                                                                                    new instance of PagingSource.
                                                                                                    	at androidx.paging.PageFetcher.generateNewPagingSource(PageFetcher.kt:215)
                                                                                                    	at androidx.paging.PageFetcher.access$generateNewPagingSource(PageFetcher.kt:32)
                                                                                                    	at androidx.paging.PageFetcher$flow$1$2.invokeSuspend(PageFetcher.kt:73)
                                                                                                    	at androidx.paging.PageFetcher$flow$1$2.invoke(Unknown Source:15)
                                                                                                    	at androidx.paging.PageFetcher$flow$1$2.invoke(Unknown Source:13)
                                                                                                    	at androidx.paging.FlowExtKt$simpleScan$1$1.emit(FlowExt.kt:56)
                                                                                                    	at androidx.paging.ConflatedEventBus$special$$inlined$mapNotNull$1$2.emit(Emitters.kt:225)
                                                                                                    	at kotlinx.coroutines.flow.StateFlowImpl.collect(StateFlow.kt:396)
                                                                                                    	at kotlinx.coroutines.flow.StateFlowImpl$collect$1.invokeSuspend(Unknown Source:15)
                                                                                                    	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
                                                                                                    	at kotlinx.coroutines.DispatchedTaskKt.resume(DispatchedTask.kt:231)
                                                                                                    	at kotlinx.coroutines.DispatchedTaskKt.resumeUnconfined(DispatchedTask.kt:187)
                                                                                                    	at kotlinx.coroutines.DispatchedTaskKt.dispatch(DispatchedTask.kt:159)
                                                                                                    	at kotlinx.coroutines.CancellableContinuationImpl.dispatchResume(CancellableContinuationImpl.kt:466)
                                                                                                    	at kotlinx.coroutines.CancellableContinuationImpl.resumeImpl(CancellableContinuationImpl.kt:500)
                                                                                                    	at kotlinx.coroutines.CancellableContinuationImpl.resumeImpl$default(CancellableContinuationImpl.kt:489)
                                                                                                    	at kotlinx.coroutines.CancellableContinuationImpl.resumeWith(CancellableContinuationImpl.kt:364)
                                                                                                    	at kotlinx.coroutines.flow.StateFlowSlot.makePending(StateFlow.kt:286)
                                                                                                    	at kotlinx.coroutines.flow.StateFlowImpl.updateState(StateFlow.kt:349)
                                                                                                    	at kotlinx.coroutines.flow.StateFlowImpl.setValue(StateFlow.kt:316)
                                                                                                    	at androidx.paging.ConflatedEventBus.send(ConflatedEventBus.kt:33)
                                                                                                    	at androidx.paging.PageFetcher.refresh(PageFetcher.kt:140)
                                                                                                    	at androidx.paging.PageFetcher$PagerUiReceiver.refresh(PageFetcher.kt:237)
                                                                                                    	at androidx.paging.PagingDataPresenter.refresh(PagingDataPresenter.kt:321)
                                                                                                    	at androidx.paging.compose.LazyPagingItems.refresh(LazyPagingItems.kt:154)
                                                                                                    	at com.akslabs.cloudgallery.ui.main.MainPageKt$MainPage$5$3$2$3.invoke(MainPage.kt:271)
                                                                                                    	at com.akslabs.cloudgallery.ui.main.MainPageKt$MainPage$5$3$2$3.invoke(MainPage.kt:262)
                                                                                                    	at com.akslabs.cloudgallery.ui.main.MainPageKt$SelectionTopAppBar$deleteRequestLauncher$1.invoke(MainPage.kt:482)
                                                                                                    	at com.akslabs.cloudgallery.ui.main.MainPageKt$SelectionTopAppBar$deleteRequestLauncher$1.invoke(MainPage.kt:475)
                                                                                                    	at androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$1$1.invoke$lambda$0(ActivityResultRegistry.kt:104)
                                                                                                    	at androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$1$1.$r8$lambda$VLs2Oqd6MzDD-LGilzyhNhDSH_4(Unknown Source:0)
                                                                                                    	at androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$1$1$$ExternalSyntheticLambda0.onActivityResult(D8$$SyntheticClass:0)
                                                                                                    	at androidx.activity.result.ActivityResultRegistry.doDispatch(ActivityResultRegistry.kt:350)
                                                                                                    	at androidx.activity.result.ActivityResultRegistry.dispatchResult(ActivityResultRegistry.kt:311)
                                                                                                    	at androidx.activity.ComponentActivity.onActivityResult(ComponentActivity.kt:756)
                                                                                                    	at android.app.Activity.onActivityResult(Activity.java:7626)
                                                                                                    	at android.app.Activity.internalDispatchActivityResult(Activity.java:9546)
                                                                                                    	at android.app.Activity.dispatchActivityResult(Activity.java:9523)
                                                                                                    	at android.app.ActivityThread.deliverResults(ActivityThread.java:6174)
                                                                                                    	at android.app.ActivityThread.handleSendResult(ActivityThread.java:6224)
                                                                                                    	at android.app.servertransaction.ActivityResultItem.execute(ActivityResultItem.java:78)
                                                                                                    	at android.app.servertransaction.ActivityTransactionItem.execute(ActivityTransactionItem.java:63)
2025-11-24 16:13:50.804 11672-11672 AndroidRuntime          com.akslabs.cloudgallery             E  	at android.app.servertransaction.TransactionExecutor.executeNonLifecycleItem(TransactionExecutor.java:133) (Explain with AI)
                                                                                                    	at android.app.servertransaction.TransactionExecutor.executeTransactionItems(TransactionExecutor.java:103)
                                                                                                    	at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:80)
                                                                                                    	at android.app.ActivityThread$H.handleMessage(ActivityThread.java:2823)
                                                                                                    	at android.os.Handler.dispatchMessage(Handler.java:110)
                                                                                                    	at android.os.Looper.loopOnce(Looper.java:248)
                                                                                                    	at android.os.Looper.loop(Looper.java:338)
                                                                                                    	at android.app.ActivityThread.main(ActivityThread.java:9073)
                                                                                                    	at java.lang.reflect.Method.invoke(Native Method)
                                                                                                    	at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:596)
                                                                                                    	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:932)
                                                                                                    	Suppressed: kotlinx.coroutines.internal.DiagnosticCoroutineContextException: [StandaloneCoroutine{Cancelling}@4c27cce, Dispatchers.Main.immediate]
2025-11-24 16:13:50.855 11672-11672 Process                 com.akslabs.cloudgallery             I  Sending signal. PID: 11672 SIG: 9
2025-11-24 16:13:50.883  1969-2279  InputDispatcher         system_server                        E  channel 'e925f05 com.akslabs.cloudgallery/com.akslabs.cloudgallery.ui.MainActivity' ~ Channel is unrecoverably broken and will be disposed!
