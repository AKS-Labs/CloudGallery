--------- beginning of system
--------- beginning of main
2025-08-12 21:16:07.841 23853-23853 bs.cloudgallery         com.akslabs.cloudgallery             I  Late-enabling -Xcheck:jni
2025-08-12 21:16:07.888 23853-23853 bs.cloudgallery         com.akslabs.cloudgallery             I  Using CollectorTypeCC GC.
2025-08-12 21:16:07.937 23853-23853 nativeloader            com.akslabs.cloudgallery             D  Load libframework-connectivity-tiramisu-jni.so using APEX ns com_android_tethering for caller /apex/com.android.tethering/javalib/framework-connectivity-t.jar: ok
2025-08-12 21:16:07.989 23853-23853 re-initialized>         com.akslabs.cloudgallery             W  type=1400 audit(0.0:8729): avc:  granted  { execute } for  path="/data/data/com.akslabs.cloudgallery/code_cache/startup_agents/b13c65d9-agent.so" dev="mmcblk0p61" ino=282303 scontext=u:r:untrusted_app:s0:c44,c259,c512,c768 tcontext=u:object_r:app_data_file:s0:c44,c259,c512,c768 tclass=file app=tw.nekomimi.nekogram
2025-08-12 21:16:08.001 23853-23853 nativeloader            com.akslabs.cloudgallery             D  Load /data/user/0/com.akslabs.cloudgallery/code_cache/startup_agents/b13c65d9-agent.so using system ns (caller=<unknown>): ok
2025-08-12 21:16:08.018 23853-23853 bs.cloudgallery         com.akslabs.cloudgallery             W  DexFile /data/data/com.akslabs.cloudgallery/code_cache/.studio/instruments-462f9421.jar is in boot class path but is not in a known location
2025-08-12 21:16:08.198 23853-23853 bs.cloudgallery         com.akslabs.cloudgallery             W  Redefining intrinsic method java.lang.Thread java.lang.Thread.currentThread(). This may cause the unexpected use of the original definition of java.lang.Thread java.lang.Thread.currentThread()in methods that have already been compiled.
2025-08-12 21:16:08.198 23853-23853 bs.cloudgallery         com.akslabs.cloudgallery             W  Redefining intrinsic method boolean java.lang.Thread.interrupted(). This may cause the unexpected use of the original definition of boolean java.lang.Thread.interrupted()in methods that have already been compiled.
2025-08-12 21:16:08.268 23853-23853 ApplicationLoaders      com.akslabs.cloudgallery             D  Returning zygote-cached class loader: /system_ext/framework/androidx.window.extensions.jar
2025-08-12 21:16:08.268 23853-23853 ApplicationLoaders      com.akslabs.cloudgallery             D  Returning zygote-cached class loader: /system_ext/framework/androidx.window.sidecar.jar
2025-08-12 21:16:08.297 23853-23853 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes12.dm': No such file or directory
2025-08-12 21:16:08.299 23853-23853 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes14.dm': No such file or directory
2025-08-12 21:16:08.304 23853-23853 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes5.dm': No such file or directory
2025-08-12 21:16:08.311 23853-23853 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes6.dm': No such file or directory
2025-08-12 21:16:08.318 23853-23853 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/app/~~wiTnRMMtAhqZJtP8yZB06Q==/com.akslabs.cloudgallery-jVXlUrFajJvLrcpWs8O6tA==/base.dm': No such file or directory
2025-08-12 21:16:08.318 23853-23853 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/app/~~wiTnRMMtAhqZJtP8yZB06Q==/com.akslabs.cloudgallery-jVXlUrFajJvLrcpWs8O6tA==/base.dm': No such file or directory
2025-08-12 21:16:09.133 23853-23853 nativeloader            com.akslabs.cloudgallery             D  Configuring clns-7 for other apk /data/app/~~wiTnRMMtAhqZJtP8yZB06Q==/com.akslabs.cloudgallery-jVXlUrFajJvLrcpWs8O6tA==/base.apk. target_sdk_version=34, uses_libraries=, library_path=/data/app/~~wiTnRMMtAhqZJtP8yZB06Q==/com.akslabs.cloudgallery-jVXlUrFajJvLrcpWs8O6tA==/lib/arm64:/data/app/~~wiTnRMMtAhqZJtP8yZB06Q==/com.akslabs.cloudgallery-jVXlUrFajJvLrcpWs8O6tA==/base.apk!/lib/arm64-v8a, permitted_path=/data:/mnt/expand:/data/user/0/com.akslabs.cloudgallery
2025-08-12 21:16:09.177 23853-23853 GraphicsEnvironment     com.akslabs.cloudgallery             V  Currently set values for:
2025-08-12 21:16:09.177 23853-23853 GraphicsEnvironment     com.akslabs.cloudgallery             V    angle_gl_driver_selection_pkgs=[com.android.angle, com.linecorp.b612.android, com.campmobile.snow, com.google.android.apps.tachyon]
2025-08-12 21:16:09.177 23853-23853 GraphicsEnvironment     com.akslabs.cloudgallery             V    angle_gl_driver_selection_values=[angle, native, native, native]
2025-08-12 21:16:09.177 23853-23853 GraphicsEnvironment     com.akslabs.cloudgallery             V  com.akslabs.cloudgallery is not listed in per-application setting
2025-08-12 21:16:09.177 23853-23853 GraphicsEnvironment     com.akslabs.cloudgallery             V  Neither updatable production driver nor prerelease driver is supported.
2025-08-12 21:16:09.210 23853-23853 WM-WrkMgrInitializer    com.akslabs.cloudgallery             D  Initializing WorkManager with default configuration.
2025-08-12 21:16:09.309 23853-23853 WM-PackageManagerHelper com.akslabs.cloudgallery             D  Skipping component enablement for androidx.work.impl.background.systemjob.SystemJobService
2025-08-12 21:16:09.310 23853-23853 WM-Schedulers           com.akslabs.cloudgallery             D  Created SystemJobScheduler and enabled SystemJobService
2025-08-12 21:16:09.671 23853-23853 EngineFactory           com.akslabs.cloudgallery             I  Provider GmsCore_OpenSSL not available
2025-08-12 21:16:09.698 23853-23853 ImageLoaderModule       com.akslabs.cloudgallery             I  === INITIALIZING IMAGE LOADERS ===
2025-08-12 21:16:09.841 23853-23853 ImageLoaderModule       com.akslabs.cloudgallery             D  Created OkHttpClient with 30s connect, 60s read/write timeouts
2025-08-12 21:16:09.841 23853-23853 ImageLoaderModule       com.akslabs.cloudgallery             D  Creating remoteImageLoader...
2025-08-12 21:16:09.844 23853-23853 ImageLoaderModule       com.akslabs.cloudgallery             I  remoteImageLoader created successfully
2025-08-12 21:16:09.844 23853-23853 ImageLoaderModule       com.akslabs.cloudgallery             D  Creating thumbnailImageLoader...
2025-08-12 21:16:09.844 23853-23853 ImageLoaderModule       com.akslabs.cloudgallery             I  thumbnailImageLoader created successfully
2025-08-12 21:16:09.844 23853-23853 ImageLoaderModule       com.akslabs.cloudgallery             I  === IMAGE LOADERS INITIALIZATION COMPLETE ===
2025-08-12 21:16:09.844 23853-23853 ImageLoaderModule       com.akslabs.cloudgallery             I  Available loaders:
2025-08-12 21:16:09.844 23853-23853 ImageLoaderModule       com.akslabs.cloudgallery             I  - defaultImageLoader: ✓
2025-08-12 21:16:09.844 23853-23853 ImageLoaderModule       com.akslabs.cloudgallery             I  - remoteImageLoader: ✓
2025-08-12 21:16:09.845 23853-23853 ImageLoaderModule       com.akslabs.cloudgallery             I  - thumbnailImageLoader: ✓
2025-08-12 21:16:09.976 23853-23853 Choreographer           com.akslabs.cloudgallery             I  Skipped 36 frames!  The application may be doing too much work on its main thread.
2025-08-12 21:16:10.112 23853-23877 DatabaseDebugHelper     com.akslabs.cloudgallery             I  === DATABASE DEBUG REPORT ===
2025-08-12 21:16:10.131 23853-23853 MainActivity            com.akslabs.cloudgallery             W  Invalid sync timestamp format, resetting to 0
                                                                                                    java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Long
                                                                                                    	at android.app.SharedPreferencesImpl.getLong(SharedPreferencesImpl.java:337)
                                                                                                    	at com.akslabs.cloudgallery.data.localdb.Preferences.getLong(Preferences.kt:55)
                                                                                                    	at com.akslabs.cloudgallery.ui.MainActivity$initializeCloudPhotoSync$1.invokeSuspend(MainActivity.kt:167)
                                                                                                    	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
                                                                                                    	at kotlinx.coroutines.internal.DispatchedContinuationKt.resumeCancellableWith(DispatchedContinuation.kt:363)
                                                                                                    	at kotlinx.coroutines.intrinsics.CancellableKt.startCoroutineCancellable(Cancellable.kt:26)
                                                                                                    	at kotlinx.coroutines.intrinsics.CancellableKt.startCoroutineCancellable$default(Cancellable.kt:21)
                                                                                                    	at kotlinx.coroutines.CoroutineStart.invoke(CoroutineStart.kt:88)
                                                                                                    	at kotlinx.coroutines.AbstractCoroutine.start(AbstractCoroutine.kt:123)
                                                                                                    	at kotlinx.coroutines.BuildersKt__Builders_commonKt.launch(Builders.common.kt:52)
                                                                                                    	at kotlinx.coroutines.BuildersKt.launch(Unknown Source:1)
                                                                                                    	at kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(Builders.common.kt:43)
                                                                                                    	at kotlinx.coroutines.BuildersKt.launch$default(Unknown Source:1)
                                                                                                    	at com.akslabs.cloudgallery.ui.MainActivity.initializeCloudPhotoSync(MainActivity.kt:156)
                                                                                                    	at com.akslabs.cloudgallery.ui.MainActivity.onCreate(MainActivity.kt:55)
                                                                                                    	at android.app.Activity.performCreate(Activity.java:9019)
                                                                                                    	at android.app.Activity.performCreate(Activity.java:8997)
                                                                                                    	at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1530)
                                                                                                    	at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:4111)
                                                                                                    	at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:4316)
                                                                                                    	at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:222)
                                                                                                    	at android.app.servertransaction.TransactionExecutor.executeNonLifecycleItem(TransactionExecutor.java:133)
                                                                                                    	at android.app.servertransaction.TransactionExecutor.executeTransactionItems(TransactionExecutor.java:103)
                                                                                                    	at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:80)
                                                                                                    	at android.app.ActivityThread$H.handleMessage(ActivityThread.java:2719)
                                                                                                    	at android.os.Handler.dispatchMessage(Handler.java:109)
                                                                                                    	at android.os.Looper.loopOnce(Looper.java:232)
                                                                                                    	at android.os.Looper.loop(Looper.java:317)
                                                                                                    	at android.app.ActivityThread.main(ActivityThread.java:8782)
                                                                                                    	at java.lang.reflect.Method.invoke(Native Method)
                                                                                                    	at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:595)
                                                                                                    	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:871)
2025-08-12 21:16:10.141 23853-23877 DatabaseDebugHelper     com.akslabs.cloudgallery             I  Database version: 4
2025-08-12 21:16:10.169 23853-23853 DesktopModeFlagsUtil    com.akslabs.cloudgallery             D  Toggle override initialized to: OVERRIDE_UNSET
2025-08-12 21:16:10.195 23853-23879 DatabaseDebugHelper     com.akslabs.cloudgallery             I  Record counts:
2025-08-12 21:16:10.195 23853-23879 DatabaseDebugHelper     com.akslabs.cloudgallery             I    Total photos: 943
2025-08-12 21:16:10.195 23853-23879 DatabaseDebugHelper     com.akslabs.cloudgallery             I    Photos with remoteId: 1
2025-08-12 21:16:10.195 23853-23879 DatabaseDebugHelper     com.akslabs.cloudgallery             I    Total remote photos: 1
2025-08-12 21:16:10.195 23853-23879 DatabaseDebugHelper     com.akslabs.cloudgallery             I  Sample uploaded photos:
2025-08-12 21:16:10.195 23853-23879 DatabaseDebugHelper     com.akslabs.cloudgallery             I    Photo: localId=1000009071, remoteId=BQACAgUAAyEGAASeEFIcAAIIv2ibV7vosK9RIOpe3J32wlOShb3xAAKuFAACMD_hVIU9jX-FnRurNgQ, type=png
2025-08-12 21:16:10.195 23853-23879 DatabaseDebugHelper     com.akslabs.cloudgallery             I  Sample remote photos:
2025-08-12 21:16:10.195 23853-23879 DatabaseDebugHelper     com.akslabs.cloudgallery             I    RemotePhoto: remoteId=BQACAgUAAyEGAASeEFIcAAIIv2ibV7vosK9RIOpe3J32wlOShb3xAAKuFAACMD_hVIU9jX-FnRurNgQ, type=png, fileName=59001581396751298263367404095608898552.png
2025-08-12 21:16:10.195 23853-23879 DatabaseDebugHelper     com.akslabs.cloudgallery             I  === END DATABASE DEBUG REPORT ===
2025-08-12 21:16:10.645 23853-23859 bs.cloudgallery         com.akslabs.cloudgallery             I  Compiler allocated 4431KB to compile void android.view.ViewRootImpl.performTraversals()
2025-08-12 21:16:10.863 23853-23853 bs.cloudgallery         com.akslabs.cloudgallery             W  Method boolean androidx.compose.runtime.snapshots.SnapshotStateList.conditionalUpdate(boolean, kotlin.jvm.functions.Function1) failed lock verification and will run slower.
                                                                                                    Common causes for lock verification issues are non-optimized dex code
                                                                                                    and incorrect proguard optimizations.
2025-08-12 21:16:10.863 23853-23853 bs.cloudgallery         com.akslabs.cloudgallery             W  Method boolean androidx.compose.runtime.snapshots.SnapshotStateList.conditionalUpdate$default(androidx.compose.runtime.snapshots.SnapshotStateList, boolean, kotlin.jvm.functions.Function1, int, java.lang.Object) failed lock verification and will run slower.
2025-08-12 21:16:10.863 23853-23853 bs.cloudgallery         com.akslabs.cloudgallery             W  Method java.lang.Object androidx.compose.runtime.snapshots.SnapshotStateList.mutate(kotlin.jvm.functions.Function1) failed lock verification and will run slower.
2025-08-12 21:16:10.864 23853-23853 bs.cloudgallery         com.akslabs.cloudgallery             W  Method void androidx.compose.runtime.snapshots.SnapshotStateList.update(boolean, kotlin.jvm.functions.Function1) failed lock verification and will run slower.
2025-08-12 21:16:10.864 23853-23853 bs.cloudgallery         com.akslabs.cloudgallery             W  Method void androidx.compose.runtime.snapshots.SnapshotStateList.update$default(androidx.compose.runtime.snapshots.SnapshotStateList, boolean, kotlin.jvm.functions.Function1, int, java.lang.Object) failed lock verification and will run slower.
2025-08-12 21:16:11.450 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  🚀 === LOCAL VIEW MODEL INITIALIZED ===
2025-08-12 21:16:11.451 23853-23853 LocalViewModel          com.akslabs.cloudgallery             I  === LOCAL PHOTOS DATABASE DEBUG ===
2025-08-12 21:16:11.472 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:11.472 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:11.474 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:11.489 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:11.491 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📊 Local photos count updated: 0
2025-08-12 21:16:11.509 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:11.598 23853-23874 AdrenoGLES-0            com.akslabs.cloudgallery             I  QUALCOMM build                   : 95db91f, Ifbc588260a
                                                                                                    Build Date                       : 09/24/20
                                                                                                    OpenGL ES Shader Compiler Version: EV031.32.02.01
                                                                                                    Local Branch                     : mybrancheafe5b6d-fb5b-f1b0-b904-5cb90179c3e0
                                                                                                    Remote Branch                    : quic/gfx-adreno.lnx.1.0.r114-rel
                                                                                                    Remote Branch                    : NONE
                                                                                                    Reconstruct Branch               : NOTHING
2025-08-12 21:16:11.598 23853-23874 AdrenoGLES-0            com.akslabs.cloudgallery             I  Build Config                     : S P 10.0.7 AArch64
2025-08-12 21:16:11.598 23853-23874 AdrenoGLES-0            com.akslabs.cloudgallery             I  Driver Path                      : /vendor/lib64/egl/libGLESv2_adreno.so
2025-08-12 21:16:11.617 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:11.618 23853-23874 AdrenoGLES-0            com.akslabs.cloudgallery             I  PFP: 0x016ee190, ME: 0x00000000
2025-08-12 21:16:11.679 23853-23891 Gralloc4                com.akslabs.cloudgallery             I  mapper 4.x is not supported
2025-08-12 21:16:11.680 23853-23891 Gralloc3                com.akslabs.cloudgallery             W  mapper 3.x is not supported
2025-08-12 21:16:11.687 23853-23891 Gralloc2                com.akslabs.cloudgallery             I  Adding additional valid usage bits: 0x8202000
2025-08-12 21:16:11.727 23853-23879 CloudPhotoSyncWorker    com.akslabs.cloudgallery             I  === CLOUD PHOTO SYNC WORKER STARTED ===
2025-08-12 21:16:11.739 23853-23873 WM-Processor            com.akslabs.cloudgallery             I  Moving WorkSpec (a565079e-ca11-4de3-b93b-1661b3131310) to the foreground
2025-08-12 21:16:11.745 23853-23864 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1425ms; Flags=1, FrameTimelineVsyncId=66975360, IntendedVsync=123123794036251, Vsync=123123794036251, InputEventId=0, HandleInputStart=123123810352874, AnimationStart=123123810355218, PerformTraversalsStart=123123810356155, DrawStart=123125168594957, FrameDeadline=123123810702917, FrameInterval=123123810343551, FrameStartTime=16666817, SyncQueued=123125202891363, SyncStart=123125203263342, IssueDrawCommandsStart=123125204107561, SwapBuffers=123125217320165, FrameCompleted=123125220272248, DequeueBufferDuration=17552, QueueBufferDuration=401614, GpuCompleted=123125220272248, SwapBuffersCompleted=123125218588238, DisplayPresentTime=18013092839424, CommandSubmissionCompleted=123125217320165, 
2025-08-12 21:16:11.763 23853-23879 CloudPhotoSyncService   com.akslabs.cloudgallery             I  === STARTING FULL CLOUD PHOTO SYNC ===
2025-08-12 21:16:11.769 23853-23879 CloudPhotoSyncService   com.akslabs.cloudgallery             D  Found configured group/channel ID: -1002651869724
2025-08-12 21:16:11.769 23853-23878 CloudPhotoSyncService   com.akslabs.cloudgallery             I  Syncing with channel ID: -1002651869724
2025-08-12 21:16:11.769 23853-23878 CloudPhotoSyncService   com.akslabs.cloudgallery             W  ⚠️  TELEGRAM BOT API LIMITATION:
2025-08-12 21:16:11.769 23853-23878 CloudPhotoSyncService   com.akslabs.cloudgallery             W  Bot API can only access messages from the last 24 hours
2025-08-12 21:16:11.769 23853-23878 CloudPhotoSyncService   com.akslabs.cloudgallery             W  Historical images older than 24 hours cannot be retrieved via Bot API
2025-08-12 21:16:11.769 23853-23878 CloudPhotoSyncService   com.akslabs.cloudgallery             W  This is a Telegram platform limitation, not an app bug
2025-08-12 21:16:11.770 23853-23878 CloudPhotoSyncService   com.akslabs.cloudgallery             D  Last sync: 0, Current: 1755013571770, Should sync: true
2025-08-12 21:16:11.773 23853-23877 CloudPhotoSyncService   com.akslabs.cloudgallery             I  Current database has 1 RemotePhoto records
2025-08-12 21:16:11.773 23853-23877 CloudPhotoSyncService   com.akslabs.cloudgallery             I  Performing incremental sync
2025-08-12 21:16:11.775 23853-23877 Historical...eDiscovery com.akslabs.cloudgallery             I  === STARTING HISTORICAL IMAGE DISCOVERY ===
2025-08-12 21:16:11.776 23853-23877 Historical...eDiscovery com.akslabs.cloudgallery             I  Channel ID: -1002651869724
2025-08-12 21:16:11.776 23853-23877 Historical...eDiscovery com.akslabs.cloudgallery             I  Config: ScanConfig(channelId=-1002651869724, batchSize=100, maxFiles=1000, includePhotos=true, includeDocuments=true, includeVideos=true)
2025-08-12 21:16:11.778 23853-23878 Historical...eDiscovery com.akslabs.cloudgallery             I  Found 1 existing RemotePhoto records
2025-08-12 21:16:11.778 23853-23878 Historical...eDiscovery com.akslabs.cloudgallery             D  Processing batch 1 (offset: null)
2025-08-12 21:16:11.805 23853-23878 BotApi                  com.akslabs.cloudgallery             D  === SCANNING CHANNEL FOR MEDIA ===
2025-08-12 21:16:11.806 23853-23878 BotApi                  com.akslabs.cloudgallery             D  Channel ID: -1002651869724, Limit: 100, Offset: null
2025-08-12 21:16:11.809 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:11.809 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 0
2025-08-12 21:16:11.810 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 0
2025-08-12 21:16:11.810 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:11.810 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:11.810 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:11.810 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:11.811 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  LocalPhotos itemCount is 0!
2025-08-12 21:16:11.811 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:11.901 23853-23853 Choreographer           com.akslabs.cloudgallery             I  Skipped 91 frames!  The application may be doing too much work on its main thread.
2025-08-12 21:16:12.021 23853-23853 LocalViewModel          com.akslabs.cloudgallery             I  Total Photo records in database: 943
2025-08-12 21:16:12.021 23853-23853 LocalViewModel          com.akslabs.cloudgallery             I  ✅ Photo records found:
2025-08-12 21:16:12.021 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[0]: localId=1000009768, pathUri=content://media/external/images/media/1000009768, remoteId=null, photoType=png
2025-08-12 21:16:12.021 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[1]: localId=1000009760, pathUri=content://media/external/images/media/1000009760, remoteId=null, photoType=png
2025-08-12 21:16:12.021 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[2]: localId=1000009759, pathUri=content://media/external/images/media/1000009759, remoteId=null, photoType=jpg
2025-08-12 21:16:12.021 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[3]: localId=1000009758, pathUri=content://media/external/images/media/1000009758, remoteId=null, photoType=png
2025-08-12 21:16:12.021 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[4]: localId=1000009757, pathUri=content://media/external/images/media/1000009757, remoteId=null, photoType=jpg
2025-08-12 21:16:12.021 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[5]: localId=1000009756, pathUri=content://media/external/images/media/1000009756, remoteId=null, photoType=jpg
2025-08-12 21:16:12.021 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[6]: localId=1000009755, pathUri=content://media/external/images/media/1000009755, remoteId=null, photoType=png
2025-08-12 21:16:12.021 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[7]: localId=1000009754, pathUri=content://media/external/images/media/1000009754, remoteId=null, photoType=jpg
2025-08-12 21:16:12.021 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[8]: localId=1000009753, pathUri=content://media/external/images/media/1000009753, remoteId=null, photoType=jpg
2025-08-12 21:16:12.021 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[9]: localId=1000009752, pathUri=content://media/external/images/media/1000009752, remoteId=null, photoType=png
2025-08-12 21:16:12.021 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  ... and 933 more records
2025-08-12 21:16:12.021 23853-23853 LocalViewModel          com.akslabs.cloudgallery             I  Testing Local PagingSource directly...
2025-08-12 21:16:12.022 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:12.022 23853-23853 LocalViewModel          com.akslabs.cloudgallery             I  Local total count flow created: SafeFlow
2025-08-12 21:16:12.022 23853-23853 LocalViewModel          com.akslabs.cloudgallery             I  === END LOCAL PHOTOS DATABASE DEBUG ===
2025-08-12 21:16:12.022 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📊 Local photos count updated: 943
2025-08-12 21:16:12.031 23853-23853 WM-SystemFgDispatcher   com.akslabs.cloudgallery             I  Started foreground service Intent { act=ACTION_START_FOREGROUND cmp=com.akslabs.cloudgallery/androidx.work.impl.foreground.SystemForegroundService (has extras) }
2025-08-12 21:16:12.035 23853-23864 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1642ms; Flags=0, FrameTimelineVsyncId=66975443, IntendedVsync=123123877375041, Vsync=123125394073770, InputEventId=0, HandleInputStart=123125399621467, AnimationStart=123125399624436, PerformTraversalsStart=123125500220321, DrawStart=123125502124540, FrameDeadline=123125244049179, FrameInterval=123125398762248, FrameStartTime=16667019, SyncQueued=123125516423342, SyncStart=123125516712144, IssueDrawCommandsStart=123125516812769, SwapBuffers=123125518186727, FrameCompleted=123125520511623, DequeueBufferDuration=16354, QueueBufferDuration=360521, GpuCompleted=123125520511623, SwapBuffersCompleted=123125519144488, DisplayPresentTime=72904454214516736, CommandSubmissionCompleted=123125518186727, 
2025-08-12 21:16:12.075 23853-23853 WindowOnBackDispatcher  com.akslabs.cloudgallery             W  OnBackInvokedCallback is not enabled for the application.
                                                                                                    Set 'android:enableOnBackInvokedCallback="true"' in the application manifest.
2025-08-12 21:16:12.149 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  🚀 === LOCAL VIEW MODEL INITIALIZED ===
2025-08-12 21:16:12.149 23853-23853 LocalViewModel          com.akslabs.cloudgallery             I  === LOCAL PHOTOS DATABASE DEBUG ===
2025-08-12 21:16:12.156 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:12.156 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:12.156 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:12.160 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:12.162 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📊 Local photos count updated: 0
2025-08-12 21:16:12.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:12.304 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:12.304 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 0
2025-08-12 21:16:12.304 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 0
2025-08-12 21:16:12.305 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:12.305 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:12.305 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:12.305 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:12.305 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  LocalPhotos itemCount is 0!
2025-08-12 21:16:12.305 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:12.384 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📊 Local photos count updated: 943
2025-08-12 21:16:12.384 23853-23853 LocalViewModel          com.akslabs.cloudgallery             I  Total Photo records in database: 943
2025-08-12 21:16:12.384 23853-23853 LocalViewModel          com.akslabs.cloudgallery             I  ✅ Photo records found:
2025-08-12 21:16:12.384 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[0]: localId=1000009768, pathUri=content://media/external/images/media/1000009768, remoteId=null, photoType=png
2025-08-12 21:16:12.384 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[1]: localId=1000009760, pathUri=content://media/external/images/media/1000009760, remoteId=null, photoType=png
2025-08-12 21:16:12.384 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[2]: localId=1000009759, pathUri=content://media/external/images/media/1000009759, remoteId=null, photoType=jpg
2025-08-12 21:16:12.384 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[3]: localId=1000009758, pathUri=content://media/external/images/media/1000009758, remoteId=null, photoType=png
2025-08-12 21:16:12.384 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[4]: localId=1000009757, pathUri=content://media/external/images/media/1000009757, remoteId=null, photoType=jpg
2025-08-12 21:16:12.384 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[5]: localId=1000009756, pathUri=content://media/external/images/media/1000009756, remoteId=null, photoType=jpg
2025-08-12 21:16:12.384 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[6]: localId=1000009755, pathUri=content://media/external/images/media/1000009755, remoteId=null, photoType=png
2025-08-12 21:16:12.384 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[7]: localId=1000009754, pathUri=content://media/external/images/media/1000009754, remoteId=null, photoType=jpg
2025-08-12 21:16:12.385 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[8]: localId=1000009753, pathUri=content://media/external/images/media/1000009753, remoteId=null, photoType=jpg
2025-08-12 21:16:12.385 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[9]: localId=1000009752, pathUri=content://media/external/images/media/1000009752, remoteId=null, photoType=png
2025-08-12 21:16:12.386 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  ... and 933 more records
2025-08-12 21:16:12.386 23853-23853 LocalViewModel          com.akslabs.cloudgallery             I  Testing Local PagingSource directly...
2025-08-12 21:16:12.386 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:12.387 23853-23853 LocalViewModel          com.akslabs.cloudgallery             I  Local total count flow created: SafeFlow
2025-08-12 21:16:12.387 23853-23853 LocalViewModel          com.akslabs.cloudgallery             I  === END LOCAL PHOTOS DATABASE DEBUG ===
2025-08-12 21:16:12.658 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:12.870 23853-23879 ContentValues           com.akslabs.cloudgallery             D  doWork: []
2025-08-12 21:16:12.871 23853-23879 Sync MediaStore         com.akslabs.cloudgallery             D  doWork: Success
2025-08-12 21:16:12.875 23853-23870 WM-WorkerWrapper        com.akslabs.cloudgallery             I  Worker result SUCCESS for Work [ id=5cdaf16a-4ad2-4527-afbb-c988253aceaa, tags={ com.akslabs.cloudgallery.workers.SyncDbMediaStoreWorker } ]
2025-08-12 21:16:14.876 23853-23853 JobService              com.akslabs.cloudgallery             W  onNetworkChanged() not implemented in androidx.work.impl.background.systemjob.SystemJobService. Must override in a subclass.
2025-08-12 21:16:14.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:14.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:14.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:14.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:14.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:14.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:14.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:14.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:14.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:14.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:14.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:14.886 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:14.886 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:14.886 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:14.886 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:14.886 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:14.886 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:14.886 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:14.902 23853-23915 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=2523ms; Flags=0, FrameTimelineVsyncId=66977034, IntendedVsync=123125860200673, Vsync=123125910200563, InputEventId=0, HandleInputStart=123125920939071, AnimationStart=123125920943550, PerformTraversalsStart=123126212033706, DrawStart=123126212152248, FrameDeadline=123125910190563, FrameInterval=123125920872092, FrameStartTime=16666630, SyncQueued=123128369732143, SyncStart=123128369892612, IssueDrawCommandsStart=123128370238393, SwapBuffers=123128372613653, FrameCompleted=123128383723393, DequeueBufferDuration=21771, QueueBufferDuration=370573, GpuCompleted=123128383723393, SwapBuffersCompleted=123128373363133, DisplayPresentTime=0, CommandSubmissionCompleted=123128372613653, 
2025-08-12 21:16:14.916 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.916 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 0
2025-08-12 21:16:14.916 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[0] RENDERING with data: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:14.916 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.916 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 1
2025-08-12 21:16:14.916 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[1] RENDERING with data: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:14.916 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.916 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 2
2025-08-12 21:16:14.916 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[2] RENDERING with data: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:14.917 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.917 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 3
2025-08-12 21:16:14.917 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[3] RENDERING with data: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:14.918 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.918 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 4
2025-08-12 21:16:14.918 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[4] RENDERING with data: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:14.918 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.918 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 5
2025-08-12 21:16:14.918 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[5] RENDERING with data: localId=1000009756, pathUri=content://media/external/images/media/1000009756
2025-08-12 21:16:14.918 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.918 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 6
2025-08-12 21:16:14.918 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[6] RENDERING with data: localId=1000009755, pathUri=content://media/external/images/media/1000009755
2025-08-12 21:16:14.918 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.918 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 7
2025-08-12 21:16:14.918 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[7] RENDERING with data: localId=1000009754, pathUri=content://media/external/images/media/1000009754
2025-08-12 21:16:14.918 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.918 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 8
2025-08-12 21:16:14.918 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[8] RENDERING with data: localId=1000009753, pathUri=content://media/external/images/media/1000009753
2025-08-12 21:16:14.918 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.918 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 9
2025-08-12 21:16:14.919 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[9] RENDERING with data: localId=1000009752, pathUri=content://media/external/images/media/1000009752
2025-08-12 21:16:14.919 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.919 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 10
2025-08-12 21:16:14.919 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[10] RENDERING with data: localId=1000009751, pathUri=content://media/external/images/media/1000009751
2025-08-12 21:16:14.919 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.919 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 11
2025-08-12 21:16:14.919 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[11] RENDERING with data: localId=1000009750, pathUri=content://media/external/images/media/1000009750
2025-08-12 21:16:14.919 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.919 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 12
2025-08-12 21:16:14.919 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[12] RENDERING with data: localId=1000009749, pathUri=content://media/external/images/media/1000009749
2025-08-12 21:16:14.919 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.919 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 13
2025-08-12 21:16:14.919 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[13] RENDERING with data: localId=1000009748, pathUri=content://media/external/images/media/1000009748
2025-08-12 21:16:14.919 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.919 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 14
2025-08-12 21:16:14.919 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[14] RENDERING with data: localId=1000009747, pathUri=content://media/external/images/media/1000009747
2025-08-12 21:16:14.919 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.919 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 15
2025-08-12 21:16:14.919 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[15] RENDERING with data: localId=1000009746, pathUri=content://media/external/images/media/1000009746
2025-08-12 21:16:14.920 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.920 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 16
2025-08-12 21:16:14.920 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[16] RENDERING with data: localId=1000009745, pathUri=content://media/external/images/media/1000009745
2025-08-12 21:16:14.920 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.920 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 17
2025-08-12 21:16:14.920 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[17] RENDERING with data: localId=1000009744, pathUri=content://media/external/images/media/1000009744
2025-08-12 21:16:14.920 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.920 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 18
2025-08-12 21:16:14.920 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[18] RENDERING with data: localId=1000009743, pathUri=content://media/external/images/media/1000009743
2025-08-12 21:16:14.920 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.920 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 19
2025-08-12 21:16:14.920 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[19] RENDERING with data: localId=1000009742, pathUri=content://media/external/images/media/1000009742
2025-08-12 21:16:14.920 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.920 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 20
2025-08-12 21:16:14.920 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[20] RENDERING with data: localId=1000009741, pathUri=content://media/external/images/media/1000009741
2025-08-12 21:16:14.920 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.920 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 21
2025-08-12 21:16:14.920 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[21] RENDERING with data: localId=1000009740, pathUri=content://media/external/images/media/1000009740
2025-08-12 21:16:14.921 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.921 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 22
2025-08-12 21:16:14.921 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[22] RENDERING with data: localId=1000009739, pathUri=content://media/external/images/media/1000009739
2025-08-12 21:16:14.921 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.921 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 23
2025-08-12 21:16:14.921 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[23] RENDERING with data: localId=1000009738, pathUri=content://media/external/images/media/1000009738
2025-08-12 21:16:14.921 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.921 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 24
2025-08-12 21:16:14.921 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[24] RENDERING with data: localId=1000009736, pathUri=content://media/external/images/media/1000009736
2025-08-12 21:16:14.921 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.921 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 25
2025-08-12 21:16:14.921 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[25] RENDERING with data: localId=1000009725, pathUri=content://media/external/images/media/1000009725
2025-08-12 21:16:14.921 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.921 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 26
2025-08-12 21:16:14.921 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[26] RENDERING with data: localId=1000009724, pathUri=content://media/external/images/media/1000009724
2025-08-12 21:16:14.921 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.921 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 27
2025-08-12 21:16:14.921 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[27] RENDERING with data: localId=1000009723, pathUri=content://media/external/images/media/1000009723
2025-08-12 21:16:14.921 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.921 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 28
2025-08-12 21:16:14.922 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[28] RENDERING with data: localId=1000009722, pathUri=content://media/external/images/media/1000009722
2025-08-12 21:16:14.922 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.922 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 29
2025-08-12 21:16:14.922 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[29] RENDERING with data: localId=1000009721, pathUri=content://media/external/images/media/1000009721
2025-08-12 21:16:14.922 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.922 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 30
2025-08-12 21:16:14.922 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[30] RENDERING with data: localId=1000009720, pathUri=content://media/external/images/media/1000009720
2025-08-12 21:16:14.922 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.922 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 31
2025-08-12 21:16:14.922 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[31] RENDERING with data: localId=1000009605, pathUri=content://media/external/images/media/1000009605
2025-08-12 21:16:14.922 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.922 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 32
2025-08-12 21:16:14.922 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[32] RENDERING with data: localId=1000009604, pathUri=content://media/external/images/media/1000009604
2025-08-12 21:16:14.922 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.922 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 33
2025-08-12 21:16:14.922 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[33] RENDERING with data: localId=1000009544, pathUri=content://media/external/images/media/1000009544
2025-08-12 21:16:14.922 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.923 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 34
2025-08-12 21:16:14.923 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[34] RENDERING with data: localId=1000009538, pathUri=content://media/external/images/media/1000009538
2025-08-12 21:16:14.923 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.923 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 35
2025-08-12 21:16:14.923 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[35] RENDERING with data: localId=1000009532, pathUri=content://media/external/images/media/1000009532
2025-08-12 21:16:14.923 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.923 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 36
2025-08-12 21:16:14.923 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[36] RENDERING with data: localId=1000009314, pathUri=content://media/external/images/media/1000009314
2025-08-12 21:16:14.923 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.923 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 37
2025-08-12 21:16:14.923 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[37] RENDERING with data: localId=1000009284, pathUri=content://media/external/images/media/1000009284
2025-08-12 21:16:14.923 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.923 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 38
2025-08-12 21:16:14.923 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[38] RENDERING with data: localId=1000009251, pathUri=content://media/external/images/media/1000009251
2025-08-12 21:16:14.923 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.923 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 39
2025-08-12 21:16:14.923 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[39] RENDERING with data: localId=1000009249, pathUri=content://media/external/images/media/1000009249
2025-08-12 21:16:14.924 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.924 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 40
2025-08-12 21:16:14.924 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[40] RENDERING with data: localId=1000009212, pathUri=content://media/external/images/media/1000009212
2025-08-12 21:16:14.924 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.924 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 41
2025-08-12 21:16:14.924 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[41] RENDERING with data: localId=1000009211, pathUri=content://media/external/images/media/1000009211
2025-08-12 21:16:14.924 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.924 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 42
2025-08-12 21:16:14.924 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[42] RENDERING with data: localId=1000009181, pathUri=content://media/external/images/media/1000009181
2025-08-12 21:16:14.924 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.924 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 43
2025-08-12 21:16:14.924 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[43] RENDERING with data: localId=1000009162, pathUri=content://media/external/images/media/1000009162
2025-08-12 21:16:14.924 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.924 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 44
2025-08-12 21:16:14.924 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[44] RENDERING with data: localId=1000009143, pathUri=content://media/external/images/media/1000009143
2025-08-12 21:16:14.925 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.925 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 45
2025-08-12 21:16:14.925 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[45] RENDERING with data: localId=1000009125, pathUri=content://media/external/images/media/1000009125
2025-08-12 21:16:14.925 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.925 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 46
2025-08-12 21:16:14.925 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[46] RENDERING with data: localId=1000009078, pathUri=content://media/external/images/media/1000009078
2025-08-12 21:16:14.925 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.925 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 47
2025-08-12 21:16:14.925 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[47] RENDERING with data: localId=1000009075, pathUri=content://media/external/images/media/1000009075
2025-08-12 21:16:14.925 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.925 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 48
2025-08-12 21:16:14.925 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[48] RENDERING with data: localId=1000009074, pathUri=content://media/external/images/media/1000009074
2025-08-12 21:16:14.925 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.925 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 49
2025-08-12 21:16:14.925 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[49] RENDERING with data: localId=1000009072, pathUri=content://media/external/images/media/1000009072
2025-08-12 21:16:14.925 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.925 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 50
2025-08-12 21:16:14.925 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[50] RENDERING with data: localId=1000009071, pathUri=content://media/external/images/media/1000009071
2025-08-12 21:16:14.925 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.925 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 51
2025-08-12 21:16:14.926 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[51] RENDERING with data: localId=1000009058, pathUri=content://media/external/images/media/1000009058
2025-08-12 21:16:14.926 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.926 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 52
2025-08-12 21:16:14.926 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[52] RENDERING with data: localId=1000009057, pathUri=content://media/external/images/media/1000009057
2025-08-12 21:16:14.926 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.926 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 53
2025-08-12 21:16:14.926 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[53] RENDERING with data: localId=1000009054, pathUri=content://media/external/images/media/1000009054
2025-08-12 21:16:14.926 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:14.926 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 54
2025-08-12 21:16:14.926 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[54] RENDERING with data: localId=1000009053, pathUri=content://media/external/images/media/1000009053
2025-08-12 21:16:14.976 23853-23853 Choreographer           com.akslabs.cloudgallery             I  Skipped 138 frames!  The application may be doing too much work on its main thread.
2025-08-12 21:16:15.038 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:15.352 23853-23915 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=2687ms; Flags=0, FrameTimelineVsyncId=66977157, IntendedVsync=123126157539374, Vsync=123128457563570, InputEventId=0, HandleInputStart=123128474366466, AnimationStart=123128474369435, PerformTraversalsStart=123128769171153, DrawStart=123128770588497, FrameDeadline=123128414861765, FrameInterval=123128473899330, FrameStartTime=16666842, SyncQueued=123128832794174, SyncStart=123128833107247, IssueDrawCommandsStart=123128833322612, SwapBuffers=123128834953184, FrameCompleted=123128845462143, DequeueBufferDuration=17969, QueueBufferDuration=267969, GpuCompleted=123128845462143, SwapBuffersCompleted=123128835531101, DisplayPresentTime=50367081480192, CommandSubmissionCompleted=123128834953184, 
2025-08-12 21:16:15.449 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:15.449 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:15.449 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:15.449 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:15.449 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: Loading(endOfPaginationReached=false)
2025-08-12 21:16:15.449 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:15.449 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:15.449 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  APPEND is currently LOADING (scrolling down)
2025-08-12 21:16:15.449 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:15.449 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:15.449 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:15.449 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:15.450 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:15.450 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:15.450 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:15.450 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:15.450 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:15.450 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:15.450 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:15.517 23853-23853 Choreographer           com.akslabs.cloudgallery             I  Skipped 31 frames!  The application may be doing too much work on its main thread.
2025-08-12 21:16:15.554 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:16.259 23853-24004 ProfileInstaller        com.akslabs.cloudgallery             D  Installing profile for com.akslabs.cloudgallery
2025-08-12 21:16:16.268 23853-23915 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1263ms; Flags=0, FrameTimelineVsyncId=66978170, IntendedVsync=123128490888070, Vsync=123129007559211, InputEventId=0, HandleInputStart=123129015839539, AnimationStart=123129015842559, PerformTraversalsStart=123129566153184, DrawStart=123129566264278, FrameDeadline=123128878901110, FrameInterval=123129014532351, FrameStartTime=16666811, SyncQueued=123129745979486, SyncStart=123129746278705, IssueDrawCommandsStart=123129746632559, SwapBuffers=123129747732767, FrameCompleted=123129755161934, DequeueBufferDuration=16823, QueueBufferDuration=277187, GpuCompleted=123129755161934, SwapBuffersCompleted=123129748355320, DisplayPresentTime=72904454231491835, CommandSubmissionCompleted=123129747732767, 
2025-08-12 21:16:16.379 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:16.719 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:16.956 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:16.956 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:16.956 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:16.956 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:16.956 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:16.956 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:16.956 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:16.957 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:16.957 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:16.957 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:16.957 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:16.957 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:16.957 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:16.957 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 224
2025-08-12 21:16:16.957 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:16.957 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:16.957 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:16.957 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:19.042 23853-23860 bs.cloudgallery         com.akslabs.cloudgallery             I  Background concurrent copying GC freed 15MB AllocSpace bytes, 132(2916KB) LOS objects, 49% free, 8519KB/16MB, paused 183us,45us total 182.668ms
2025-08-12 21:16:19.088 23853-23853 WindowOnBackDispatcher  com.akslabs.cloudgallery             W  OnBackInvokedCallback is not enabled for the application.
                                                                                                    Set 'android:enableOnBackInvokedCallback="true"' in the application manifest.
2025-08-12 21:16:20.465 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:20.689 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:20.697 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  🚀 === LOCAL VIEW MODEL INITIALIZED ===
2025-08-12 21:16:20.697 23853-23853 LocalViewModel          com.akslabs.cloudgallery             I  === LOCAL PHOTOS DATABASE DEBUG ===
2025-08-12 21:16:20.710 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:20.710 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:20.711 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:20.714 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:20.715 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📊 Local photos count updated: 0
2025-08-12 21:16:20.718 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:20.892 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:20.892 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 0
2025-08-12 21:16:20.892 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 0
2025-08-12 21:16:20.892 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:20.892 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:20.892 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:20.892 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:20.893 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  LocalPhotos itemCount is 0!
2025-08-12 21:16:20.893 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:20.951 23853-23853 WindowOnBackDispatcher  com.akslabs.cloudgallery             W  sendCancelIfRunning: isInProgress=false callback=android.view.ViewRootImpl$$ExternalSyntheticLambda11@c54ed04
2025-08-12 21:16:20.986 23853-23853 LocalViewModel          com.akslabs.cloudgallery             I  Total Photo records in database: 943
2025-08-12 21:16:20.986 23853-23853 LocalViewModel          com.akslabs.cloudgallery             I  ✅ Photo records found:
2025-08-12 21:16:20.986 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[0]: localId=1000009768, pathUri=content://media/external/images/media/1000009768, remoteId=null, photoType=png
2025-08-12 21:16:20.986 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[1]: localId=1000009760, pathUri=content://media/external/images/media/1000009760, remoteId=null, photoType=png
2025-08-12 21:16:20.986 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[2]: localId=1000009759, pathUri=content://media/external/images/media/1000009759, remoteId=null, photoType=jpg
2025-08-12 21:16:20.986 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[3]: localId=1000009758, pathUri=content://media/external/images/media/1000009758, remoteId=null, photoType=png
2025-08-12 21:16:20.986 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[4]: localId=1000009757, pathUri=content://media/external/images/media/1000009757, remoteId=null, photoType=jpg
2025-08-12 21:16:20.986 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[5]: localId=1000009756, pathUri=content://media/external/images/media/1000009756, remoteId=null, photoType=jpg
2025-08-12 21:16:20.986 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[6]: localId=1000009755, pathUri=content://media/external/images/media/1000009755, remoteId=null, photoType=png
2025-08-12 21:16:20.986 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[7]: localId=1000009754, pathUri=content://media/external/images/media/1000009754, remoteId=null, photoType=jpg
2025-08-12 21:16:20.986 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[8]: localId=1000009753, pathUri=content://media/external/images/media/1000009753, remoteId=null, photoType=jpg
2025-08-12 21:16:20.986 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Photo[9]: localId=1000009752, pathUri=content://media/external/images/media/1000009752, remoteId=null, photoType=png
2025-08-12 21:16:20.987 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  ... and 933 more records
2025-08-12 21:16:20.987 23853-23853 LocalViewModel          com.akslabs.cloudgallery             I  Testing Local PagingSource directly...
2025-08-12 21:16:20.987 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:20.987 23853-23853 LocalViewModel          com.akslabs.cloudgallery             I  Local total count flow created: SafeFlow
2025-08-12 21:16:20.987 23853-23853 LocalViewModel          com.akslabs.cloudgallery             I  === END LOCAL PHOTOS DATABASE DEBUG ===
2025-08-12 21:16:20.987 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📊 Local photos count updated: 943
2025-08-12 21:16:21.047 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:21.078 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:21.078 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:21.078 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:21.078 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:21.078 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:21.078 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:21.078 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:21.078 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:21.078 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:21.078 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:21.078 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:21.078 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:21.078 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:21.079 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:21.079 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:21.079 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:21.079 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:21.079 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:21.346 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:21.346 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:21.346 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:21.360 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:21.377 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:21.400 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:21.400 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:21.401 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:21.401 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:21.401 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:21.401 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:21.401 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:21.401 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:21.401 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:21.401 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:21.401 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:21.401 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:21.401 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:21.401 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:21.401 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:21.401 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:21.401 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:21.402 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:21.458 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:21.691 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:21.691 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:21.691 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:21.707 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:22.104 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:22.104 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:22.104 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:22.104 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:22.104 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:22.104 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:22.104 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:22.104 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:22.104 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:22.104 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:22.104 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:22.104 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:22.104 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:22.104 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:22.104 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:22.104 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:22.104 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:22.104 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:22.106 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  ❌ Error collecting from localPhotosFlow
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@402768
2025-08-12 21:16:22.118 23853-23888 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=730ms; Flags=0, FrameTimelineVsyncId=66981780, IntendedVsync=123134874234027, Vsync=123134890900623, InputEventId=0, HandleInputStart=123134906988859, AnimationStart=123134906991620, PerformTraversalsStart=123135184550109, DrawStart=123135184648859, FrameDeadline=123134931605185, FrameInterval=123134906977661, FrameStartTime=16666596, SyncQueued=123135595860265, SyncStart=123135596130265, IssueDrawCommandsStart=123135596753234, SwapBuffers=123135597852921, FrameCompleted=123135605483911, DequeueBufferDuration=18438, QueueBufferDuration=313490, GpuCompleted=123135605483911, SwapBuffersCompleted=123135598467036, DisplayPresentTime=72904454231819012, CommandSubmissionCompleted=123135597852921, 
2025-08-12 21:16:22.125 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  ❌ Error collecting from localPhotosCount
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@402768
2025-08-12 21:16:22.139 23853-23853 Choreographer           com.akslabs.cloudgallery             I  Skipped 40 frames!  The application may be doing too much work on its main thread.
2025-08-12 21:16:22.147 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:22.216 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:22.216 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:22.216 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:22.216 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:22.216 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:22.216 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:22.216 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:22.216 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:22.216 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:22.216 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:22.216 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:22.216 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:22.216 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:22.216 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:22.216 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:22.216 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:22.216 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:22.216 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:22.218 23853-23888 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=750ms; Flags=0, FrameTimelineVsyncId=66981824, IntendedVsync=123134960206344, Vsync=123135626845664, InputEventId=0, HandleInputStart=123135637878130, AnimationStart=123135637881255, PerformTraversalsStart=123135700334796, DrawStart=123135700443651, FrameDeadline=123135624230917, FrameInterval=123135637126724, FrameStartTime=16665983, SyncQueued=123135706030734, SyncStart=123135706135317, IssueDrawCommandsStart=123135706356359, SwapBuffers=123135707083182, FrameCompleted=123135710481359, DequeueBufferDuration=17709, QueueBufferDuration=271406, GpuCompleted=123135710481359, SwapBuffersCompleted=123135707797036, DisplayPresentTime=72057628414509916, CommandSubmissionCompleted=123135707083182, 
2025-08-12 21:16:22.260 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:22.450 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:22.450 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:22.450 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:22.463 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:23.135 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:23.135 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:23.135 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:23.136 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:23.136 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:23.136 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:23.136 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:23.136 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:23.136 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:23.136 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:23.136 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:23.136 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:23.136 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:23.136 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:23.136 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:23.136 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:23.136 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:23.136 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:23.142 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.142 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 1
2025-08-12 21:16:23.142 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[1] RENDERING with data: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:23.142 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.142 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 2
2025-08-12 21:16:23.142 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[2] RENDERING with data: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:23.142 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.142 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 3
2025-08-12 21:16:23.142 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[3] RENDERING with data: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:23.142 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.142 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 4
2025-08-12 21:16:23.142 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[4] RENDERING with data: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:23.142 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.142 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 5
2025-08-12 21:16:23.142 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[5] RENDERING with data: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:23.143 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.143 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 6
2025-08-12 21:16:23.143 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[6] RENDERING with data: localId=1000009756, pathUri=content://media/external/images/media/1000009756
2025-08-12 21:16:23.143 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.143 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 7
2025-08-12 21:16:23.143 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[7] RENDERING with data: localId=1000009755, pathUri=content://media/external/images/media/1000009755
2025-08-12 21:16:23.143 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.143 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 8
2025-08-12 21:16:23.143 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[8] RENDERING with data: localId=1000009754, pathUri=content://media/external/images/media/1000009754
2025-08-12 21:16:23.143 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.143 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 9
2025-08-12 21:16:23.143 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[9] RENDERING with data: localId=1000009753, pathUri=content://media/external/images/media/1000009753
2025-08-12 21:16:23.143 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.143 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 10
2025-08-12 21:16:23.143 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[10] RENDERING with data: localId=1000009752, pathUri=content://media/external/images/media/1000009752
2025-08-12 21:16:23.143 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.143 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 11
2025-08-12 21:16:23.143 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[11] RENDERING with data: localId=1000009751, pathUri=content://media/external/images/media/1000009751
2025-08-12 21:16:23.143 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.143 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 12
2025-08-12 21:16:23.143 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[12] RENDERING with data: localId=1000009750, pathUri=content://media/external/images/media/1000009750
2025-08-12 21:16:23.143 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.144 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 13
2025-08-12 21:16:23.144 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[13] RENDERING with data: localId=1000009749, pathUri=content://media/external/images/media/1000009749
2025-08-12 21:16:23.144 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.144 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 14
2025-08-12 21:16:23.144 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[14] RENDERING with data: localId=1000009748, pathUri=content://media/external/images/media/1000009748
2025-08-12 21:16:23.144 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.144 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 15
2025-08-12 21:16:23.144 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[15] RENDERING with data: localId=1000009747, pathUri=content://media/external/images/media/1000009747
2025-08-12 21:16:23.144 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.144 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 16
2025-08-12 21:16:23.144 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[16] RENDERING with data: localId=1000009746, pathUri=content://media/external/images/media/1000009746
2025-08-12 21:16:23.144 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.144 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 17
2025-08-12 21:16:23.144 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[17] RENDERING with data: localId=1000009745, pathUri=content://media/external/images/media/1000009745
2025-08-12 21:16:23.144 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.144 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 18
2025-08-12 21:16:23.144 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[18] RENDERING with data: localId=1000009744, pathUri=content://media/external/images/media/1000009744
2025-08-12 21:16:23.144 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.144 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 19
2025-08-12 21:16:23.144 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[19] RENDERING with data: localId=1000009743, pathUri=content://media/external/images/media/1000009743
2025-08-12 21:16:23.144 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.144 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 20
2025-08-12 21:16:23.144 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[20] RENDERING with data: localId=1000009742, pathUri=content://media/external/images/media/1000009742
2025-08-12 21:16:23.145 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.145 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 21
2025-08-12 21:16:23.145 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[21] RENDERING with data: localId=1000009741, pathUri=content://media/external/images/media/1000009741
2025-08-12 21:16:23.145 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.145 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 22
2025-08-12 21:16:23.145 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[22] RENDERING with data: localId=1000009740, pathUri=content://media/external/images/media/1000009740
2025-08-12 21:16:23.145 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.145 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 23
2025-08-12 21:16:23.145 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[23] RENDERING with data: localId=1000009739, pathUri=content://media/external/images/media/1000009739
2025-08-12 21:16:23.145 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.145 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 24
2025-08-12 21:16:23.145 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[24] RENDERING with data: localId=1000009738, pathUri=content://media/external/images/media/1000009738
2025-08-12 21:16:23.145 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.145 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 25
2025-08-12 21:16:23.145 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[25] RENDERING with data: localId=1000009736, pathUri=content://media/external/images/media/1000009736
2025-08-12 21:16:23.145 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.145 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 26
2025-08-12 21:16:23.145 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[26] RENDERING with data: localId=1000009725, pathUri=content://media/external/images/media/1000009725
2025-08-12 21:16:23.145 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.145 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 27
2025-08-12 21:16:23.145 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[27] RENDERING with data: localId=1000009724, pathUri=content://media/external/images/media/1000009724
2025-08-12 21:16:23.145 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.145 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 28
2025-08-12 21:16:23.145 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[28] RENDERING with data: localId=1000009723, pathUri=content://media/external/images/media/1000009723
2025-08-12 21:16:23.146 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.146 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 29
2025-08-12 21:16:23.146 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[29] RENDERING with data: localId=1000009722, pathUri=content://media/external/images/media/1000009722
2025-08-12 21:16:23.146 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.146 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 30
2025-08-12 21:16:23.146 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[30] RENDERING with data: localId=1000009721, pathUri=content://media/external/images/media/1000009721
2025-08-12 21:16:23.146 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.146 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 31
2025-08-12 21:16:23.146 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[31] RENDERING with data: localId=1000009720, pathUri=content://media/external/images/media/1000009720
2025-08-12 21:16:23.146 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.146 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 33
2025-08-12 21:16:23.146 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[33] RENDERING with data: localId=1000009605, pathUri=content://media/external/images/media/1000009605
2025-08-12 21:16:23.146 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.146 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 34
2025-08-12 21:16:23.146 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[34] RENDERING with data: localId=1000009604, pathUri=content://media/external/images/media/1000009604
2025-08-12 21:16:23.146 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.146 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 36
2025-08-12 21:16:23.146 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[36] RENDERING with data: localId=1000009544, pathUri=content://media/external/images/media/1000009544
2025-08-12 21:16:23.146 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.146 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 37
2025-08-12 21:16:23.146 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[37] RENDERING with data: localId=1000009538, pathUri=content://media/external/images/media/1000009538
2025-08-12 21:16:23.146 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:23.146 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 38
2025-08-12 21:16:23.146 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[38] RENDERING with data: localId=1000009532, pathUri=content://media/external/images/media/1000009532
2025-08-12 21:16:23.150 23853-23866 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=931ms; Flags=0, FrameTimelineVsyncId=66982162, IntendedVsync=123135707527245, Vsync=123135740860369, InputEventId=0, HandleInputStart=123135755300526, AnimationStart=123135755303026, PerformTraversalsStart=123135769625994, DrawStart=123135769726046, FrameDeadline=123135748174894, FrameInterval=123135755289119, FrameStartTime=16666562, SyncQueued=123136631503598, SyncStart=123136631815265, IssueDrawCommandsStart=123136632101515, SwapBuffers=123136634661619, FrameCompleted=123136639084536, DequeueBufferDuration=16719, QueueBufferDuration=288125, GpuCompleted=123136639084536, SwapBuffersCompleted=123136635569484, DisplayPresentTime=0, CommandSubmissionCompleted=123136634661619, 
2025-08-12 21:16:23.154 23853-23853 Choreographer           com.akslabs.cloudgallery             I  Skipped 53 frames!  The application may be doing too much work on its main thread.
2025-08-12 21:16:23.156 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:23.284 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:23.284 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:23.284 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:23.284 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:23.284 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:23.284 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:23.284 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:23.284 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:23.284 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:23.284 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:23.284 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:23.284 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:23.284 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:23.284 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:23.284 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:23.284 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:23.284 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:23.284 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:23.285 23853-23866 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1019ms; Flags=0, FrameTimelineVsyncId=66982191, IntendedVsync=123135757527342, Vsync=123136640855446, InputEventId=0, HandleInputStart=123136651990994, AnimationStart=123136651993911, PerformTraversalsStart=123136767895421, DrawStart=123136767985577, FrameDeadline=123136662188049, FrameInterval=123136651540942, FrameStartTime=16666568, SyncQueued=123136772652869, SyncStart=123136772929536, IssueDrawCommandsStart=123136773186098, SwapBuffers=123136773931306, FrameCompleted=123136776818546, DequeueBufferDuration=18021, QueueBufferDuration=280678, GpuCompleted=123136776818546, SwapBuffersCompleted=123136774667192, DisplayPresentTime=0, CommandSubmissionCompleted=123136773931306, 
2025-08-12 21:16:23.327 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:23.341 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:23.341 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:23.341 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:23.355 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:23.690 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:23.690 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:23.690 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:23.690 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:23.690 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:23.690 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:23.690 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:23.690 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:23.690 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:23.690 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:23.690 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:23.690 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:23.690 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:23.690 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:23.690 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:23.690 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:23.690 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:23.690 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:23.699 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:23.754 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:23.754 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:23.754 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:23.754 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:23.754 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:23.754 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:23.754 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:23.754 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:23.754 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:23.754 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:23.754 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:23.754 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:23.754 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:23.754 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:23.755 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:23.755 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:23.755 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:23.755 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:23.798 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:23.956 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:23.956 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:23.957 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:23.968 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:24.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:24.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:24.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:24.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:24.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:24.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:24.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:24.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:24.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:24.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:24.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:24.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:24.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:24.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:24.549 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:24.549 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:24.549 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:24.549 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:24.554 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.554 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 1
2025-08-12 21:16:24.554 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[1] RENDERING with data: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:24.554 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.554 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 2
2025-08-12 21:16:24.554 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[2] RENDERING with data: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:24.555 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.555 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 3
2025-08-12 21:16:24.555 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[3] RENDERING with data: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:24.555 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.555 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 4
2025-08-12 21:16:24.555 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[4] RENDERING with data: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:24.555 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.555 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 5
2025-08-12 21:16:24.555 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[5] RENDERING with data: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:24.555 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.555 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 6
2025-08-12 21:16:24.555 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[6] RENDERING with data: localId=1000009756, pathUri=content://media/external/images/media/1000009756
2025-08-12 21:16:24.555 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.555 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 7
2025-08-12 21:16:24.555 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[7] RENDERING with data: localId=1000009755, pathUri=content://media/external/images/media/1000009755
2025-08-12 21:16:24.555 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.555 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 8
2025-08-12 21:16:24.555 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[8] RENDERING with data: localId=1000009754, pathUri=content://media/external/images/media/1000009754
2025-08-12 21:16:24.555 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.555 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 9
2025-08-12 21:16:24.555 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[9] RENDERING with data: localId=1000009753, pathUri=content://media/external/images/media/1000009753
2025-08-12 21:16:24.555 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.555 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 10
2025-08-12 21:16:24.555 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[10] RENDERING with data: localId=1000009752, pathUri=content://media/external/images/media/1000009752
2025-08-12 21:16:24.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 11
2025-08-12 21:16:24.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[11] RENDERING with data: localId=1000009751, pathUri=content://media/external/images/media/1000009751
2025-08-12 21:16:24.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 12
2025-08-12 21:16:24.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[12] RENDERING with data: localId=1000009750, pathUri=content://media/external/images/media/1000009750
2025-08-12 21:16:24.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 13
2025-08-12 21:16:24.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[13] RENDERING with data: localId=1000009749, pathUri=content://media/external/images/media/1000009749
2025-08-12 21:16:24.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 14
2025-08-12 21:16:24.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[14] RENDERING with data: localId=1000009748, pathUri=content://media/external/images/media/1000009748
2025-08-12 21:16:24.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 15
2025-08-12 21:16:24.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[15] RENDERING with data: localId=1000009747, pathUri=content://media/external/images/media/1000009747
2025-08-12 21:16:24.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 16
2025-08-12 21:16:24.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[16] RENDERING with data: localId=1000009746, pathUri=content://media/external/images/media/1000009746
2025-08-12 21:16:24.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 17
2025-08-12 21:16:24.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[17] RENDERING with data: localId=1000009745, pathUri=content://media/external/images/media/1000009745
2025-08-12 21:16:24.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 18
2025-08-12 21:16:24.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[18] RENDERING with data: localId=1000009744, pathUri=content://media/external/images/media/1000009744
2025-08-12 21:16:24.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 19
2025-08-12 21:16:24.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[19] RENDERING with data: localId=1000009743, pathUri=content://media/external/images/media/1000009743
2025-08-12 21:16:24.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 20
2025-08-12 21:16:24.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[20] RENDERING with data: localId=1000009742, pathUri=content://media/external/images/media/1000009742
2025-08-12 21:16:24.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 21
2025-08-12 21:16:24.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[21] RENDERING with data: localId=1000009741, pathUri=content://media/external/images/media/1000009741
2025-08-12 21:16:24.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 22
2025-08-12 21:16:24.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[22] RENDERING with data: localId=1000009740, pathUri=content://media/external/images/media/1000009740
2025-08-12 21:16:24.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 23
2025-08-12 21:16:24.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[23] RENDERING with data: localId=1000009739, pathUri=content://media/external/images/media/1000009739
2025-08-12 21:16:24.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 24
2025-08-12 21:16:24.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[24] RENDERING with data: localId=1000009738, pathUri=content://media/external/images/media/1000009738
2025-08-12 21:16:24.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 25
2025-08-12 21:16:24.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[25] RENDERING with data: localId=1000009736, pathUri=content://media/external/images/media/1000009736
2025-08-12 21:16:24.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 26
2025-08-12 21:16:24.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[26] RENDERING with data: localId=1000009725, pathUri=content://media/external/images/media/1000009725
2025-08-12 21:16:24.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 27
2025-08-12 21:16:24.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[27] RENDERING with data: localId=1000009724, pathUri=content://media/external/images/media/1000009724
2025-08-12 21:16:24.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 28
2025-08-12 21:16:24.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[28] RENDERING with data: localId=1000009723, pathUri=content://media/external/images/media/1000009723
2025-08-12 21:16:24.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 29
2025-08-12 21:16:24.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[29] RENDERING with data: localId=1000009722, pathUri=content://media/external/images/media/1000009722
2025-08-12 21:16:24.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 30
2025-08-12 21:16:24.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[30] RENDERING with data: localId=1000009721, pathUri=content://media/external/images/media/1000009721
2025-08-12 21:16:24.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 31
2025-08-12 21:16:24.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[31] RENDERING with data: localId=1000009720, pathUri=content://media/external/images/media/1000009720
2025-08-12 21:16:24.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 33
2025-08-12 21:16:24.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[33] RENDERING with data: localId=1000009605, pathUri=content://media/external/images/media/1000009605
2025-08-12 21:16:24.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 34
2025-08-12 21:16:24.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[34] RENDERING with data: localId=1000009604, pathUri=content://media/external/images/media/1000009604
2025-08-12 21:16:24.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 36
2025-08-12 21:16:24.559 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[36] RENDERING with data: localId=1000009544, pathUri=content://media/external/images/media/1000009544
2025-08-12 21:16:24.559 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.559 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 37
2025-08-12 21:16:24.559 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[37] RENDERING with data: localId=1000009538, pathUri=content://media/external/images/media/1000009538
2025-08-12 21:16:24.559 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:24.559 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 38
2025-08-12 21:16:24.559 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[38] RENDERING with data: localId=1000009532, pathUri=content://media/external/images/media/1000009532
2025-08-12 21:16:24.565 23853-23853 Choreographer           com.akslabs.cloudgallery             I  Skipped 45 frames!  The application may be doing too much work on its main thread.
2025-08-12 21:16:24.567 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:24.568 23853-23866 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=809ms; Flags=0, FrameTimelineVsyncId=66982770, IntendedVsync=123137240860221, Vsync=123137290859862, InputEventId=0, HandleInputStart=123137294122296, AnimationStart=123137294124900, PerformTraversalsStart=123137306324744, DrawStart=123137306422452, FrameDeadline=123137278865264, FrameInterval=123137294110681, FrameStartTime=16666547, SyncQueued=123138044055368, SyncStart=123138044364848, IssueDrawCommandsStart=123138044647296, SwapBuffers=123138046435577, FrameCompleted=123138051132035, DequeueBufferDuration=17708, QueueBufferDuration=355520, GpuCompleted=123138051132035, SwapBuffersCompleted=123138047380264, DisplayPresentTime=72057628414509983, CommandSubmissionCompleted=123138046435577, 
2025-08-12 21:16:24.673 23853-23853 JobService              com.akslabs.cloudgallery             W  onNetworkChanged() not implemented in androidx.work.impl.background.systemjob.SystemJobService. Must override in a subclass.
2025-08-12 21:16:24.678 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:24.678 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:24.678 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:24.678 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:24.678 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:24.678 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:24.678 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:24.678 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:24.678 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:24.678 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:24.678 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:24.678 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:24.678 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:24.678 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:24.679 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:24.679 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:24.679 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:24.679 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:24.685 23853-23866 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=863ms; Flags=0, FrameTimelineVsyncId=66982806, IntendedVsync=123137307528503, Vsync=123138057525053, InputEventId=0, HandleInputStart=123138063614066, AnimationStart=123138063617400, PerformTraversalsStart=123138163867452, DrawStart=123138163951983, FrameDeadline=123138078854356, FrameInterval=123138063020577, FrameStartTime=16666590, SyncQueued=123138167885264, SyncStart=123138168164223, IssueDrawCommandsStart=123138168410629, SwapBuffers=123138169151306, FrameCompleted=123138171803077, DequeueBufferDuration=17813, QueueBufferDuration=270885, GpuCompleted=123138171803077, SwapBuffersCompleted=123138169870889, DisplayPresentTime=0, CommandSubmissionCompleted=123138169151306, 
2025-08-12 21:16:24.720 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:24.733 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:24.733 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:24.734 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:24.748 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:25.047 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:25.047 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:25.048 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:25.048 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:25.048 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:25.048 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:25.048 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:25.048 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:25.048 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:25.048 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:25.048 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:25.048 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:25.048 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:25.048 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:25.048 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:25.048 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:25.048 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:25.048 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:25.056 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:25.101 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:25.101 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:25.101 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:25.101 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:25.101 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:25.101 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:25.101 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:25.101 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:25.101 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:25.101 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:25.101 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:25.101 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:25.101 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:25.101 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:25.101 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:25.101 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:25.101 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:25.101 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:25.143 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:25.284 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:25.284 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:25.284 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:25.296 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:25.791 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:25.791 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:25.791 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:25.791 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:25.791 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:25.791 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:25.791 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:25.792 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:25.792 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:25.792 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:25.792 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:25.792 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:25.792 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:25.792 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:25.792 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:25.792 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:25.792 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:25.792 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:25.797 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.797 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 1
2025-08-12 21:16:25.797 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[1] RENDERING with data: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:25.797 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.797 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 2
2025-08-12 21:16:25.797 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[2] RENDERING with data: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:25.797 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.797 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 3
2025-08-12 21:16:25.798 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[3] RENDERING with data: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:25.798 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.798 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 4
2025-08-12 21:16:25.798 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[4] RENDERING with data: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:25.798 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.798 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 5
2025-08-12 21:16:25.798 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[5] RENDERING with data: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:25.798 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.798 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 6
2025-08-12 21:16:25.798 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[6] RENDERING with data: localId=1000009756, pathUri=content://media/external/images/media/1000009756
2025-08-12 21:16:25.798 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.798 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 7
2025-08-12 21:16:25.798 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[7] RENDERING with data: localId=1000009755, pathUri=content://media/external/images/media/1000009755
2025-08-12 21:16:25.798 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.798 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 8
2025-08-12 21:16:25.798 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[8] RENDERING with data: localId=1000009754, pathUri=content://media/external/images/media/1000009754
2025-08-12 21:16:25.798 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.798 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 9
2025-08-12 21:16:25.798 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[9] RENDERING with data: localId=1000009753, pathUri=content://media/external/images/media/1000009753
2025-08-12 21:16:25.798 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.798 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 10
2025-08-12 21:16:25.798 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[10] RENDERING with data: localId=1000009752, pathUri=content://media/external/images/media/1000009752
2025-08-12 21:16:25.798 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.798 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 11
2025-08-12 21:16:25.798 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[11] RENDERING with data: localId=1000009751, pathUri=content://media/external/images/media/1000009751
2025-08-12 21:16:25.799 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.799 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 12
2025-08-12 21:16:25.799 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[12] RENDERING with data: localId=1000009750, pathUri=content://media/external/images/media/1000009750
2025-08-12 21:16:25.799 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.799 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 13
2025-08-12 21:16:25.799 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[13] RENDERING with data: localId=1000009749, pathUri=content://media/external/images/media/1000009749
2025-08-12 21:16:25.799 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.799 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 14
2025-08-12 21:16:25.799 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[14] RENDERING with data: localId=1000009748, pathUri=content://media/external/images/media/1000009748
2025-08-12 21:16:25.799 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.799 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 15
2025-08-12 21:16:25.799 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[15] RENDERING with data: localId=1000009747, pathUri=content://media/external/images/media/1000009747
2025-08-12 21:16:25.799 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.799 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 16
2025-08-12 21:16:25.799 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[16] RENDERING with data: localId=1000009746, pathUri=content://media/external/images/media/1000009746
2025-08-12 21:16:25.799 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.799 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 17
2025-08-12 21:16:25.799 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[17] RENDERING with data: localId=1000009745, pathUri=content://media/external/images/media/1000009745
2025-08-12 21:16:25.799 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.799 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 18
2025-08-12 21:16:25.799 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[18] RENDERING with data: localId=1000009744, pathUri=content://media/external/images/media/1000009744
2025-08-12 21:16:25.799 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.799 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 19
2025-08-12 21:16:25.799 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[19] RENDERING with data: localId=1000009743, pathUri=content://media/external/images/media/1000009743
2025-08-12 21:16:25.799 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.799 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 20
2025-08-12 21:16:25.800 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[20] RENDERING with data: localId=1000009742, pathUri=content://media/external/images/media/1000009742
2025-08-12 21:16:25.800 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.800 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 21
2025-08-12 21:16:25.800 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[21] RENDERING with data: localId=1000009741, pathUri=content://media/external/images/media/1000009741
2025-08-12 21:16:25.800 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.800 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 22
2025-08-12 21:16:25.800 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[22] RENDERING with data: localId=1000009740, pathUri=content://media/external/images/media/1000009740
2025-08-12 21:16:25.800 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.800 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 23
2025-08-12 21:16:25.800 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[23] RENDERING with data: localId=1000009739, pathUri=content://media/external/images/media/1000009739
2025-08-12 21:16:25.800 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.800 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 24
2025-08-12 21:16:25.800 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[24] RENDERING with data: localId=1000009738, pathUri=content://media/external/images/media/1000009738
2025-08-12 21:16:25.800 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.800 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 25
2025-08-12 21:16:25.800 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[25] RENDERING with data: localId=1000009736, pathUri=content://media/external/images/media/1000009736
2025-08-12 21:16:25.800 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.800 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 26
2025-08-12 21:16:25.800 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[26] RENDERING with data: localId=1000009725, pathUri=content://media/external/images/media/1000009725
2025-08-12 21:16:25.800 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.800 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 27
2025-08-12 21:16:25.800 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[27] RENDERING with data: localId=1000009724, pathUri=content://media/external/images/media/1000009724
2025-08-12 21:16:25.800 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.800 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 28
2025-08-12 21:16:25.800 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[28] RENDERING with data: localId=1000009723, pathUri=content://media/external/images/media/1000009723
2025-08-12 21:16:25.800 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.800 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 29
2025-08-12 21:16:25.801 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[29] RENDERING with data: localId=1000009722, pathUri=content://media/external/images/media/1000009722
2025-08-12 21:16:25.801 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.801 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 30
2025-08-12 21:16:25.801 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[30] RENDERING with data: localId=1000009721, pathUri=content://media/external/images/media/1000009721
2025-08-12 21:16:25.801 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.801 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 31
2025-08-12 21:16:25.801 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[31] RENDERING with data: localId=1000009720, pathUri=content://media/external/images/media/1000009720
2025-08-12 21:16:25.801 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.801 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 33
2025-08-12 21:16:25.801 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[33] RENDERING with data: localId=1000009605, pathUri=content://media/external/images/media/1000009605
2025-08-12 21:16:25.801 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.801 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 34
2025-08-12 21:16:25.801 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[34] RENDERING with data: localId=1000009604, pathUri=content://media/external/images/media/1000009604
2025-08-12 21:16:25.801 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.801 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 36
2025-08-12 21:16:25.801 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[36] RENDERING with data: localId=1000009544, pathUri=content://media/external/images/media/1000009544
2025-08-12 21:16:25.801 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.801 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 37
2025-08-12 21:16:25.801 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[37] RENDERING with data: localId=1000009538, pathUri=content://media/external/images/media/1000009538
2025-08-12 21:16:25.801 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:25.801 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 38
2025-08-12 21:16:25.801 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[38] RENDERING with data: localId=1000009532, pathUri=content://media/external/images/media/1000009532
2025-08-12 21:16:25.807 23853-23853 Choreographer           com.akslabs.cloudgallery             I  Skipped 39 frames!  The application may be doing too much work on its main thread.
2025-08-12 21:16:25.809 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:25.818 23853-23866 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=707ms; Flags=0, FrameTimelineVsyncId=66983387, IntendedVsync=123138590861983, Vsync=123138624195275, InputEventId=0, HandleInputStart=123138639383545, AnimationStart=123138639386097, PerformTraversalsStart=123138650507243, DrawStart=123138650608858, FrameDeadline=123138628858929, FrameInterval=123138639372504, FrameStartTime=16666646, SyncQueued=123139287409430, SyncStart=123139287685941, IssueDrawCommandsStart=123139287967451, SwapBuffers=123139289737555, FrameCompleted=123139298646826, DequeueBufferDuration=18958, QueueBufferDuration=345469, GpuCompleted=123139298646826, SwapBuffersCompleted=123139290374378, DisplayPresentTime=72904454231491527, CommandSubmissionCompleted=123139289737555, 
2025-08-12 21:16:25.912 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:25.912 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:25.912 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:25.912 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:25.912 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:25.912 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:25.912 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:25.912 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:25.912 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:25.912 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:25.912 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:25.912 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:25.912 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:25.913 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:25.913 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:25.913 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:25.913 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:25.913 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:25.918 23853-23866 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=763ms; Flags=0, FrameTimelineVsyncId=66983414, IntendedVsync=123138643531117, Vsync=123139293531403, InputEventId=0, HandleInputStart=123139305561358, AnimationStart=123139305564222, PerformTraversalsStart=123139398128805, DrawStart=123139398222451, FrameDeadline=123139324194427, FrameInterval=123139305112295, FrameStartTime=16666674, SyncQueued=123139402428441, SyncStart=123139402755889, IssueDrawCommandsStart=123139403010889, SwapBuffers=123139403772451, FrameCompleted=123139407844743, DequeueBufferDuration=19375, QueueBufferDuration=270469, GpuCompleted=123139407844743, SwapBuffersCompleted=123139404465003, DisplayPresentTime=72057628414510137, CommandSubmissionCompleted=123139403772451, 
2025-08-12 21:16:25.954 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:25.967 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:25.967 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:25.967 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:25.979 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:26.236 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:26.237 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:26.237 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:26.237 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:26.237 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:26.237 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:26.237 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:26.237 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:26.237 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:26.237 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:26.237 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:26.237 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:26.237 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:26.237 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:26.237 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:26.237 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:26.237 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:26.237 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:26.245 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:26.286 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:26.286 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:26.286 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:26.287 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:26.287 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:26.287 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:26.287 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:26.287 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:26.287 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:26.287 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:26.287 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:26.287 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:26.287 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:26.287 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:26.287 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:26.287 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:26.287 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:26.287 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:26.328 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:26.457 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:26.457 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:26.457 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:26.468 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:26.998 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:26.999 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:26.999 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:26.999 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:26.999 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:26.999 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:26.999 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:26.999 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:26.999 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:26.999 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:26.999 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:26.999 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:26.999 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:26.999 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:26.999 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:26.999 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:26.999 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:26.999 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:27.005 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.005 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 1
2025-08-12 21:16:27.005 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[1] RENDERING with data: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:27.005 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.005 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 2
2025-08-12 21:16:27.005 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[2] RENDERING with data: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:27.005 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.005 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 3
2025-08-12 21:16:27.005 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[3] RENDERING with data: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:27.005 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.005 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 4
2025-08-12 21:16:27.005 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[4] RENDERING with data: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:27.005 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.005 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 5
2025-08-12 21:16:27.005 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[5] RENDERING with data: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:27.005 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.005 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 6
2025-08-12 21:16:27.005 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[6] RENDERING with data: localId=1000009756, pathUri=content://media/external/images/media/1000009756
2025-08-12 21:16:27.005 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.005 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 7
2025-08-12 21:16:27.005 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[7] RENDERING with data: localId=1000009755, pathUri=content://media/external/images/media/1000009755
2025-08-12 21:16:27.005 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.006 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 8
2025-08-12 21:16:27.006 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[8] RENDERING with data: localId=1000009754, pathUri=content://media/external/images/media/1000009754
2025-08-12 21:16:27.006 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.006 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 9
2025-08-12 21:16:27.006 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[9] RENDERING with data: localId=1000009753, pathUri=content://media/external/images/media/1000009753
2025-08-12 21:16:27.006 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.006 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 10
2025-08-12 21:16:27.006 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[10] RENDERING with data: localId=1000009752, pathUri=content://media/external/images/media/1000009752
2025-08-12 21:16:27.006 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.006 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 11
2025-08-12 21:16:27.006 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[11] RENDERING with data: localId=1000009751, pathUri=content://media/external/images/media/1000009751
2025-08-12 21:16:27.006 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.006 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 12
2025-08-12 21:16:27.006 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[12] RENDERING with data: localId=1000009750, pathUri=content://media/external/images/media/1000009750
2025-08-12 21:16:27.006 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.006 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 13
2025-08-12 21:16:27.006 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[13] RENDERING with data: localId=1000009749, pathUri=content://media/external/images/media/1000009749
2025-08-12 21:16:27.006 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.006 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 14
2025-08-12 21:16:27.006 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[14] RENDERING with data: localId=1000009748, pathUri=content://media/external/images/media/1000009748
2025-08-12 21:16:27.006 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.006 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 15
2025-08-12 21:16:27.006 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[15] RENDERING with data: localId=1000009747, pathUri=content://media/external/images/media/1000009747
2025-08-12 21:16:27.006 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.006 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 16
2025-08-12 21:16:27.006 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[16] RENDERING with data: localId=1000009746, pathUri=content://media/external/images/media/1000009746
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 17
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[17] RENDERING with data: localId=1000009745, pathUri=content://media/external/images/media/1000009745
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 18
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[18] RENDERING with data: localId=1000009744, pathUri=content://media/external/images/media/1000009744
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 19
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[19] RENDERING with data: localId=1000009743, pathUri=content://media/external/images/media/1000009743
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 20
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[20] RENDERING with data: localId=1000009742, pathUri=content://media/external/images/media/1000009742
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 21
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[21] RENDERING with data: localId=1000009741, pathUri=content://media/external/images/media/1000009741
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 22
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[22] RENDERING with data: localId=1000009740, pathUri=content://media/external/images/media/1000009740
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 23
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[23] RENDERING with data: localId=1000009739, pathUri=content://media/external/images/media/1000009739
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 24
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[24] RENDERING with data: localId=1000009738, pathUri=content://media/external/images/media/1000009738
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 25
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[25] RENDERING with data: localId=1000009736, pathUri=content://media/external/images/media/1000009736
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 26
2025-08-12 21:16:27.007 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[26] RENDERING with data: localId=1000009725, pathUri=content://media/external/images/media/1000009725
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 27
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[27] RENDERING with data: localId=1000009724, pathUri=content://media/external/images/media/1000009724
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 28
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[28] RENDERING with data: localId=1000009723, pathUri=content://media/external/images/media/1000009723
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 29
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[29] RENDERING with data: localId=1000009722, pathUri=content://media/external/images/media/1000009722
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 30
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[30] RENDERING with data: localId=1000009721, pathUri=content://media/external/images/media/1000009721
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 31
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[31] RENDERING with data: localId=1000009720, pathUri=content://media/external/images/media/1000009720
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 33
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[33] RENDERING with data: localId=1000009605, pathUri=content://media/external/images/media/1000009605
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 34
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[34] RENDERING with data: localId=1000009604, pathUri=content://media/external/images/media/1000009604
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 36
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[36] RENDERING with data: localId=1000009544, pathUri=content://media/external/images/media/1000009544
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 37
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[37] RENDERING with data: localId=1000009538, pathUri=content://media/external/images/media/1000009538
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 38
2025-08-12 21:16:27.008 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[38] RENDERING with data: localId=1000009532, pathUri=content://media/external/images/media/1000009532
2025-08-12 21:16:27.016 23853-23853 Choreographer           com.akslabs.cloudgallery             I  Skipped 41 frames!  The application may be doing too much work on its main thread.
2025-08-12 21:16:27.018 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:27.019 23853-23888 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=732ms; Flags=0, FrameTimelineVsyncId=66983932, IntendedVsync=123139774197246, Vsync=123139824197250, InputEventId=0, HandleInputStart=123139824335055, AnimationStart=123139824337712, PerformTraversalsStart=123139835008284, DrawStart=123139835111930, FrameDeadline=123139812199015, FrameInterval=123139824323389, FrameStartTime=16666668, SyncQueued=123140494682659, SyncStart=123140494879430, IssueDrawCommandsStart=123140495197086, SwapBuffers=123140497129951, FrameCompleted=123140506477659, DequeueBufferDuration=18333, QueueBufferDuration=306927, GpuCompleted=123140506477659, SwapBuffersCompleted=123140497802295, DisplayPresentTime=288234774198222848, CommandSubmissionCompleted=123140497129951, 
2025-08-12 21:16:27.125 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:27.125 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:27.125 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:27.125 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:27.125 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:27.125 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:27.125 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:27.125 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:27.125 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:27.125 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:27.125 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:27.125 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:27.125 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:27.125 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:27.125 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:27.125 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:27.126 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:27.126 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:27.135 23853-23888 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=792ms; Flags=0, FrameTimelineVsyncId=66983959, IntendedVsync=123139826866189, Vsync=123140510200643, InputEventId=0, HandleInputStart=123140514135211, AnimationStart=123140514139013, PerformTraversalsStart=123140611310680, DrawStart=123140611405420, FrameDeadline=123140524197304, FrameInterval=123140513340836, FrameStartTime=16666694, SyncQueued=123140615565836, SyncStart=123140615702972, IssueDrawCommandsStart=123140615950472, SwapBuffers=123140616654847, FrameCompleted=123140619511774, DequeueBufferDuration=18177, QueueBufferDuration=267240, GpuCompleted=123140619511774, SwapBuffersCompleted=123140617439795, DisplayPresentTime=72904454214516736, CommandSubmissionCompleted=123140616654847, 
2025-08-12 21:16:27.170 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:27.183 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:27.183 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:27.184 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:27.195 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:27.463 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:27.463 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:27.463 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:27.463 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:27.463 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:27.464 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:27.464 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:27.464 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:27.464 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:27.464 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:27.464 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:27.464 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:27.464 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:27.464 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:27.464 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:27.464 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:27.464 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:27.464 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:27.474 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:27.534 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:27.535 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:27.535 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:27.535 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:27.535 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:27.535 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:27.535 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:27.535 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:27.535 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:27.535 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:27.535 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:27.535 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:27.535 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:27.535 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:27.535 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:27.535 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:27.535 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:27.535 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:27.592 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:27.711 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:27.711 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:27.712 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:27.722 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:28.166 23853-23853 JobService              com.akslabs.cloudgallery             W  onNetworkChanged() not implemented in androidx.work.impl.background.systemjob.SystemJobService. Must override in a subclass.
2025-08-12 21:16:28.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:28.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:28.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:28.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:28.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:28.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:28.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:28.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:28.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:28.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:28.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:28.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:28.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:28.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:28.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:28.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:28.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:28.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:28.172 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.172 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 1
2025-08-12 21:16:28.172 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[1] RENDERING with data: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:28.173 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.173 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 2
2025-08-12 21:16:28.173 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[2] RENDERING with data: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:28.173 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.173 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 3
2025-08-12 21:16:28.173 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[3] RENDERING with data: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:28.173 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.173 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 4
2025-08-12 21:16:28.173 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[4] RENDERING with data: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:28.173 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.173 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 5
2025-08-12 21:16:28.173 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[5] RENDERING with data: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:28.173 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.173 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 6
2025-08-12 21:16:28.173 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[6] RENDERING with data: localId=1000009756, pathUri=content://media/external/images/media/1000009756
2025-08-12 21:16:28.173 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.173 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 7
2025-08-12 21:16:28.173 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[7] RENDERING with data: localId=1000009755, pathUri=content://media/external/images/media/1000009755
2025-08-12 21:16:28.173 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.173 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 8
2025-08-12 21:16:28.173 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[8] RENDERING with data: localId=1000009754, pathUri=content://media/external/images/media/1000009754
2025-08-12 21:16:28.173 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.173 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 9
2025-08-12 21:16:28.173 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[9] RENDERING with data: localId=1000009753, pathUri=content://media/external/images/media/1000009753
2025-08-12 21:16:28.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 10
2025-08-12 21:16:28.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[10] RENDERING with data: localId=1000009752, pathUri=content://media/external/images/media/1000009752
2025-08-12 21:16:28.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 11
2025-08-12 21:16:28.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[11] RENDERING with data: localId=1000009751, pathUri=content://media/external/images/media/1000009751
2025-08-12 21:16:28.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 12
2025-08-12 21:16:28.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[12] RENDERING with data: localId=1000009750, pathUri=content://media/external/images/media/1000009750
2025-08-12 21:16:28.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 13
2025-08-12 21:16:28.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[13] RENDERING with data: localId=1000009749, pathUri=content://media/external/images/media/1000009749
2025-08-12 21:16:28.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 14
2025-08-12 21:16:28.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[14] RENDERING with data: localId=1000009748, pathUri=content://media/external/images/media/1000009748
2025-08-12 21:16:28.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 15
2025-08-12 21:16:28.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[15] RENDERING with data: localId=1000009747, pathUri=content://media/external/images/media/1000009747
2025-08-12 21:16:28.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 16
2025-08-12 21:16:28.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[16] RENDERING with data: localId=1000009746, pathUri=content://media/external/images/media/1000009746
2025-08-12 21:16:28.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 17
2025-08-12 21:16:28.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[17] RENDERING with data: localId=1000009745, pathUri=content://media/external/images/media/1000009745
2025-08-12 21:16:28.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 18
2025-08-12 21:16:28.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[18] RENDERING with data: localId=1000009744, pathUri=content://media/external/images/media/1000009744
2025-08-12 21:16:28.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 19
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[19] RENDERING with data: localId=1000009743, pathUri=content://media/external/images/media/1000009743
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 20
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[20] RENDERING with data: localId=1000009742, pathUri=content://media/external/images/media/1000009742
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 21
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[21] RENDERING with data: localId=1000009741, pathUri=content://media/external/images/media/1000009741
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 22
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[22] RENDERING with data: localId=1000009740, pathUri=content://media/external/images/media/1000009740
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 23
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[23] RENDERING with data: localId=1000009739, pathUri=content://media/external/images/media/1000009739
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 24
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[24] RENDERING with data: localId=1000009738, pathUri=content://media/external/images/media/1000009738
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 25
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[25] RENDERING with data: localId=1000009736, pathUri=content://media/external/images/media/1000009736
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 26
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[26] RENDERING with data: localId=1000009725, pathUri=content://media/external/images/media/1000009725
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 27
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[27] RENDERING with data: localId=1000009724, pathUri=content://media/external/images/media/1000009724
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 28
2025-08-12 21:16:28.175 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[28] RENDERING with data: localId=1000009723, pathUri=content://media/external/images/media/1000009723
2025-08-12 21:16:28.176 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.176 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 29
2025-08-12 21:16:28.176 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[29] RENDERING with data: localId=1000009722, pathUri=content://media/external/images/media/1000009722
2025-08-12 21:16:28.176 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.176 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 30
2025-08-12 21:16:28.176 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[30] RENDERING with data: localId=1000009721, pathUri=content://media/external/images/media/1000009721
2025-08-12 21:16:28.176 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.176 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 31
2025-08-12 21:16:28.176 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[31] RENDERING with data: localId=1000009720, pathUri=content://media/external/images/media/1000009720
2025-08-12 21:16:28.176 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.176 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 33
2025-08-12 21:16:28.176 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[33] RENDERING with data: localId=1000009605, pathUri=content://media/external/images/media/1000009605
2025-08-12 21:16:28.176 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.176 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 34
2025-08-12 21:16:28.176 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[34] RENDERING with data: localId=1000009604, pathUri=content://media/external/images/media/1000009604
2025-08-12 21:16:28.176 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.176 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 36
2025-08-12 21:16:28.176 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[36] RENDERING with data: localId=1000009544, pathUri=content://media/external/images/media/1000009544
2025-08-12 21:16:28.176 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.176 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 37
2025-08-12 21:16:28.176 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[37] RENDERING with data: localId=1000009538, pathUri=content://media/external/images/media/1000009538
2025-08-12 21:16:28.176 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:28.176 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 38
2025-08-12 21:16:28.176 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[38] RENDERING with data: localId=1000009532, pathUri=content://media/external/images/media/1000009532
2025-08-12 21:16:28.182 23853-23853 Choreographer           com.akslabs.cloudgallery             I  Skipped 35 frames!  The application may be doing too much work on its main thread.
2025-08-12 21:16:28.184 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:28.268 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:28.268 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:28.268 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:28.268 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:28.268 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:28.268 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:28.268 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:28.268 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:28.268 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:28.268 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:28.269 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:28.269 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:28.269 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:28.269 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:28.269 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:28.269 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:28.269 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:28.269 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:28.311 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:28.324 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:28.324 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:28.324 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:28.335 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:28.547 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:28.547 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:28.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:28.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:28.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:28.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:28.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:28.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:28.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:28.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:28.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:28.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:28.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:28.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:28.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:28.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:28.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:28.548 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:28.555 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:28.589 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:28.589 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:28.589 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:28.589 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:28.589 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:28.589 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:28.589 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:28.589 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:28.589 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:28.589 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:28.589 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:28.589 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:28.589 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:28.589 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:28.589 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:28.589 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:28.589 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:28.589 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:28.629 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:28.733 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:28.733 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:28.734 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:28.744 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:29.159 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:29.159 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:29.159 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:29.159 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:29.159 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:29.160 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:29.160 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:29.160 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:29.160 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:29.160 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:29.160 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:29.160 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:29.160 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:29.160 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:29.160 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:29.160 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:29.160 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:29.160 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:29.165 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.165 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 1
2025-08-12 21:16:29.165 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[1] RENDERING with data: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:29.165 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.165 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 2
2025-08-12 21:16:29.165 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[2] RENDERING with data: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 3
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[3] RENDERING with data: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 4
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[4] RENDERING with data: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 5
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[5] RENDERING with data: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 6
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[6] RENDERING with data: localId=1000009756, pathUri=content://media/external/images/media/1000009756
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 7
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[7] RENDERING with data: localId=1000009755, pathUri=content://media/external/images/media/1000009755
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 8
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[8] RENDERING with data: localId=1000009754, pathUri=content://media/external/images/media/1000009754
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 9
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[9] RENDERING with data: localId=1000009753, pathUri=content://media/external/images/media/1000009753
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 10
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[10] RENDERING with data: localId=1000009752, pathUri=content://media/external/images/media/1000009752
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 11
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[11] RENDERING with data: localId=1000009751, pathUri=content://media/external/images/media/1000009751
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 12
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[12] RENDERING with data: localId=1000009750, pathUri=content://media/external/images/media/1000009750
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 13
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[13] RENDERING with data: localId=1000009749, pathUri=content://media/external/images/media/1000009749
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 14
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[14] RENDERING with data: localId=1000009748, pathUri=content://media/external/images/media/1000009748
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 15
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[15] RENDERING with data: localId=1000009747, pathUri=content://media/external/images/media/1000009747
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 16
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[16] RENDERING with data: localId=1000009746, pathUri=content://media/external/images/media/1000009746
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 17
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[17] RENDERING with data: localId=1000009745, pathUri=content://media/external/images/media/1000009745
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 18
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[18] RENDERING with data: localId=1000009744, pathUri=content://media/external/images/media/1000009744
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 19
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[19] RENDERING with data: localId=1000009743, pathUri=content://media/external/images/media/1000009743
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 20
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[20] RENDERING with data: localId=1000009742, pathUri=content://media/external/images/media/1000009742
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 21
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[21] RENDERING with data: localId=1000009741, pathUri=content://media/external/images/media/1000009741
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 22
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[22] RENDERING with data: localId=1000009740, pathUri=content://media/external/images/media/1000009740
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 23
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[23] RENDERING with data: localId=1000009739, pathUri=content://media/external/images/media/1000009739
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 24
2025-08-12 21:16:29.167 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[24] RENDERING with data: localId=1000009738, pathUri=content://media/external/images/media/1000009738
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 25
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[25] RENDERING with data: localId=1000009736, pathUri=content://media/external/images/media/1000009736
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 26
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[26] RENDERING with data: localId=1000009725, pathUri=content://media/external/images/media/1000009725
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 27
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[27] RENDERING with data: localId=1000009724, pathUri=content://media/external/images/media/1000009724
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 28
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[28] RENDERING with data: localId=1000009723, pathUri=content://media/external/images/media/1000009723
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 29
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[29] RENDERING with data: localId=1000009722, pathUri=content://media/external/images/media/1000009722
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 30
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[30] RENDERING with data: localId=1000009721, pathUri=content://media/external/images/media/1000009721
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 31
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[31] RENDERING with data: localId=1000009720, pathUri=content://media/external/images/media/1000009720
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 33
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[33] RENDERING with data: localId=1000009605, pathUri=content://media/external/images/media/1000009605
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 34
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[34] RENDERING with data: localId=1000009604, pathUri=content://media/external/images/media/1000009604
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 36
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[36] RENDERING with data: localId=1000009544, pathUri=content://media/external/images/media/1000009544
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 37
2025-08-12 21:16:29.168 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[37] RENDERING with data: localId=1000009538, pathUri=content://media/external/images/media/1000009538
2025-08-12 21:16:29.169 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:29.169 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 38
2025-08-12 21:16:29.169 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[38] RENDERING with data: localId=1000009532, pathUri=content://media/external/images/media/1000009532
2025-08-12 21:16:29.175 23853-23853 Choreographer           com.akslabs.cloudgallery             I  Skipped 32 frames!  The application may be doing too much work on its main thread.
2025-08-12 21:16:29.176 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:29.277 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:29.277 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:29.277 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:29.277 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:29.277 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:29.277 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:29.277 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:29.277 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:29.277 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:29.277 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:29.277 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:29.277 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:29.277 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:29.277 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:29.277 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:29.277 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:29.278 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:29.278 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:29.324 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:29.336 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:29.336 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:29.337 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:29.347 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:29.581 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:29.581 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:29.581 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:29.581 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:29.581 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:29.581 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:29.581 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:29.581 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:29.581 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:29.581 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:29.581 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:29.581 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:29.582 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:29.582 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:29.582 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:29.582 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:29.582 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:29.582 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:29.589 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:29.620 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:29.620 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:29.620 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:29.620 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:29.620 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:29.620 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:29.620 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:29.620 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:29.620 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:29.620 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:29.620 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:29.620 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:29.620 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:29.620 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:29.621 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:29.621 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:29.621 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:29.621 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:29.661 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:29.766 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:29.767 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:29.767 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:29.776 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:30.184 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:30.184 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:30.184 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:30.184 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:30.184 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:30.184 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:30.184 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:30.184 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:30.184 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:30.184 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:30.184 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:30.184 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:30.184 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:30.184 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:30.184 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:30.184 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:30.184 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:30.184 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:30.189 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.189 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 1
2025-08-12 21:16:30.189 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[1] RENDERING with data: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:30.189 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.189 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 2
2025-08-12 21:16:30.189 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[2] RENDERING with data: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:30.189 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.189 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 3
2025-08-12 21:16:30.189 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[3] RENDERING with data: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:30.189 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.189 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 4
2025-08-12 21:16:30.189 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[4] RENDERING with data: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:30.189 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 5
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[5] RENDERING with data: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 6
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[6] RENDERING with data: localId=1000009756, pathUri=content://media/external/images/media/1000009756
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 7
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[7] RENDERING with data: localId=1000009755, pathUri=content://media/external/images/media/1000009755
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 8
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[8] RENDERING with data: localId=1000009754, pathUri=content://media/external/images/media/1000009754
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 9
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[9] RENDERING with data: localId=1000009753, pathUri=content://media/external/images/media/1000009753
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 10
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[10] RENDERING with data: localId=1000009752, pathUri=content://media/external/images/media/1000009752
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 11
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[11] RENDERING with data: localId=1000009751, pathUri=content://media/external/images/media/1000009751
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 12
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[12] RENDERING with data: localId=1000009750, pathUri=content://media/external/images/media/1000009750
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 13
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[13] RENDERING with data: localId=1000009749, pathUri=content://media/external/images/media/1000009749
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 14
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[14] RENDERING with data: localId=1000009748, pathUri=content://media/external/images/media/1000009748
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 15
2025-08-12 21:16:30.190 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[15] RENDERING with data: localId=1000009747, pathUri=content://media/external/images/media/1000009747
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 16
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[16] RENDERING with data: localId=1000009746, pathUri=content://media/external/images/media/1000009746
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 17
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[17] RENDERING with data: localId=1000009745, pathUri=content://media/external/images/media/1000009745
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 18
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[18] RENDERING with data: localId=1000009744, pathUri=content://media/external/images/media/1000009744
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 19
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[19] RENDERING with data: localId=1000009743, pathUri=content://media/external/images/media/1000009743
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 20
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[20] RENDERING with data: localId=1000009742, pathUri=content://media/external/images/media/1000009742
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 21
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[21] RENDERING with data: localId=1000009741, pathUri=content://media/external/images/media/1000009741
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 22
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[22] RENDERING with data: localId=1000009740, pathUri=content://media/external/images/media/1000009740
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 23
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[23] RENDERING with data: localId=1000009739, pathUri=content://media/external/images/media/1000009739
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 24
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[24] RENDERING with data: localId=1000009738, pathUri=content://media/external/images/media/1000009738
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 25
2025-08-12 21:16:30.191 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[25] RENDERING with data: localId=1000009736, pathUri=content://media/external/images/media/1000009736
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 26
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[26] RENDERING with data: localId=1000009725, pathUri=content://media/external/images/media/1000009725
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 27
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[27] RENDERING with data: localId=1000009724, pathUri=content://media/external/images/media/1000009724
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 28
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[28] RENDERING with data: localId=1000009723, pathUri=content://media/external/images/media/1000009723
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 29
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[29] RENDERING with data: localId=1000009722, pathUri=content://media/external/images/media/1000009722
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 30
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[30] RENDERING with data: localId=1000009721, pathUri=content://media/external/images/media/1000009721
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 31
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[31] RENDERING with data: localId=1000009720, pathUri=content://media/external/images/media/1000009720
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 33
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[33] RENDERING with data: localId=1000009605, pathUri=content://media/external/images/media/1000009605
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 34
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[34] RENDERING with data: localId=1000009604, pathUri=content://media/external/images/media/1000009604
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 36
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[36] RENDERING with data: localId=1000009544, pathUri=content://media/external/images/media/1000009544
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 37
2025-08-12 21:16:30.192 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[37] RENDERING with data: localId=1000009538, pathUri=content://media/external/images/media/1000009538
2025-08-12 21:16:30.193 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:30.193 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 38
2025-08-12 21:16:30.193 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[38] RENDERING with data: localId=1000009532, pathUri=content://media/external/images/media/1000009532
2025-08-12 21:16:30.198 23853-23853 Choreographer           com.akslabs.cloudgallery             I  Skipped 32 frames!  The application may be doing too much work on its main thread.
2025-08-12 21:16:30.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:30.279 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:30.279 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:30.279 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:30.279 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:30.279 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:30.279 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:30.279 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:30.279 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:30.279 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:30.279 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:30.279 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:30.279 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:30.279 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:30.279 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:30.279 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:30.279 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:30.279 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:30.279 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:30.318 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:30.329 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:30.329 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:30.330 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:30.339 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:30.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:30.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:30.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:30.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:30.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:30.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:30.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:30.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:30.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:30.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:30.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:30.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:30.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:30.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:30.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:30.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:30.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:30.556 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:30.563 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:30.592 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:30.592 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:30.592 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:30.592 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:30.592 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:30.592 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:30.592 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:30.592 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:30.592 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:30.592 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:30.592 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:30.593 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:30.593 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:30.593 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:30.593 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:30.593 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:30.593 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:30.593 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:30.632 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:30.727 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:30.727 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:30.727 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:30.735 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:31.090 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:31.090 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:31.090 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:31.090 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:31.090 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:31.090 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:31.090 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:31.090 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:31.090 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:31.090 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:31.090 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:31.090 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:31.090 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:31.090 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:31.090 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:31.090 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:31.090 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:31.090 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:31.095 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.095 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 1
2025-08-12 21:16:31.095 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[1] RENDERING with data: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:31.095 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.095 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 2
2025-08-12 21:16:31.095 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[2] RENDERING with data: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:31.095 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.095 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 3
2025-08-12 21:16:31.095 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[3] RENDERING with data: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:31.095 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.095 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 4
2025-08-12 21:16:31.095 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[4] RENDERING with data: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 5
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[5] RENDERING with data: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 6
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[6] RENDERING with data: localId=1000009756, pathUri=content://media/external/images/media/1000009756
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 7
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[7] RENDERING with data: localId=1000009755, pathUri=content://media/external/images/media/1000009755
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 8
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[8] RENDERING with data: localId=1000009754, pathUri=content://media/external/images/media/1000009754
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 9
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[9] RENDERING with data: localId=1000009753, pathUri=content://media/external/images/media/1000009753
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 10
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[10] RENDERING with data: localId=1000009752, pathUri=content://media/external/images/media/1000009752
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 11
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[11] RENDERING with data: localId=1000009751, pathUri=content://media/external/images/media/1000009751
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 12
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[12] RENDERING with data: localId=1000009750, pathUri=content://media/external/images/media/1000009750
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 13
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[13] RENDERING with data: localId=1000009749, pathUri=content://media/external/images/media/1000009749
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 14
2025-08-12 21:16:31.096 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[14] RENDERING with data: localId=1000009748, pathUri=content://media/external/images/media/1000009748
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 15
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[15] RENDERING with data: localId=1000009747, pathUri=content://media/external/images/media/1000009747
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 16
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[16] RENDERING with data: localId=1000009746, pathUri=content://media/external/images/media/1000009746
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 17
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[17] RENDERING with data: localId=1000009745, pathUri=content://media/external/images/media/1000009745
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 18
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[18] RENDERING with data: localId=1000009744, pathUri=content://media/external/images/media/1000009744
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 19
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[19] RENDERING with data: localId=1000009743, pathUri=content://media/external/images/media/1000009743
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 20
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[20] RENDERING with data: localId=1000009742, pathUri=content://media/external/images/media/1000009742
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 21
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[21] RENDERING with data: localId=1000009741, pathUri=content://media/external/images/media/1000009741
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 22
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[22] RENDERING with data: localId=1000009740, pathUri=content://media/external/images/media/1000009740
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 23
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[23] RENDERING with data: localId=1000009739, pathUri=content://media/external/images/media/1000009739
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 24
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[24] RENDERING with data: localId=1000009738, pathUri=content://media/external/images/media/1000009738
2025-08-12 21:16:31.097 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 25
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[25] RENDERING with data: localId=1000009736, pathUri=content://media/external/images/media/1000009736
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 26
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[26] RENDERING with data: localId=1000009725, pathUri=content://media/external/images/media/1000009725
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 27
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[27] RENDERING with data: localId=1000009724, pathUri=content://media/external/images/media/1000009724
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 28
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[28] RENDERING with data: localId=1000009723, pathUri=content://media/external/images/media/1000009723
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 29
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[29] RENDERING with data: localId=1000009722, pathUri=content://media/external/images/media/1000009722
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 30
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[30] RENDERING with data: localId=1000009721, pathUri=content://media/external/images/media/1000009721
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 31
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[31] RENDERING with data: localId=1000009720, pathUri=content://media/external/images/media/1000009720
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 33
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[33] RENDERING with data: localId=1000009605, pathUri=content://media/external/images/media/1000009605
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 34
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[34] RENDERING with data: localId=1000009604, pathUri=content://media/external/images/media/1000009604
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 36
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[36] RENDERING with data: localId=1000009544, pathUri=content://media/external/images/media/1000009544
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.098 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 37
2025-08-12 21:16:31.099 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[37] RENDERING with data: localId=1000009538, pathUri=content://media/external/images/media/1000009538
2025-08-12 21:16:31.099 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.099 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 38
2025-08-12 21:16:31.099 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[38] RENDERING with data: localId=1000009532, pathUri=content://media/external/images/media/1000009532
2025-08-12 21:16:31.107 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:31.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:31.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:31.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:31.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:31.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:31.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:31.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:31.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:31.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:31.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:31.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:31.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:31.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:31.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:31.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:31.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:31.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:31.174 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:31.213 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:31.224 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:31.224 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:31.224 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:31.233 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:31.400 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:31.400 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:31.400 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:31.400 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:31.400 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:31.400 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:31.400 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:31.400 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:31.400 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:31.400 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:31.400 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:31.400 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:31.400 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:31.400 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:31.400 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:31.400 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:31.400 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:31.400 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:31.407 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:31.434 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:31.434 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:31.434 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:31.434 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:31.435 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:31.435 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:31.435 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:31.435 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:31.435 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:31.435 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:31.435 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:31.435 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:31.435 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:31.435 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:31.435 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:31.435 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:31.435 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:31.435 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:31.474 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:31.568 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:31.568 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:31.569 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:31.578 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:31.940 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:31.940 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:31.940 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:31.940 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:31.940 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:31.940 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:31.940 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:31.940 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:31.940 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:31.941 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:31.941 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:31.941 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:31.941 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:31.941 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:31.941 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:31.941 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:31.941 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:31.941 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:31.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 1
2025-08-12 21:16:31.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[1] RENDERING with data: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:31.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 2
2025-08-12 21:16:31.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[2] RENDERING with data: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:31.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 3
2025-08-12 21:16:31.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[3] RENDERING with data: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:31.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 4
2025-08-12 21:16:31.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[4] RENDERING with data: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:31.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 5
2025-08-12 21:16:31.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[5] RENDERING with data: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:31.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 6
2025-08-12 21:16:31.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[6] RENDERING with data: localId=1000009756, pathUri=content://media/external/images/media/1000009756
2025-08-12 21:16:31.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 7
2025-08-12 21:16:31.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[7] RENDERING with data: localId=1000009755, pathUri=content://media/external/images/media/1000009755
2025-08-12 21:16:31.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 8
2025-08-12 21:16:31.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[8] RENDERING with data: localId=1000009754, pathUri=content://media/external/images/media/1000009754
2025-08-12 21:16:31.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 9
2025-08-12 21:16:31.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[9] RENDERING with data: localId=1000009753, pathUri=content://media/external/images/media/1000009753
2025-08-12 21:16:31.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 10
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[10] RENDERING with data: localId=1000009752, pathUri=content://media/external/images/media/1000009752
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 11
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[11] RENDERING with data: localId=1000009751, pathUri=content://media/external/images/media/1000009751
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 12
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[12] RENDERING with data: localId=1000009750, pathUri=content://media/external/images/media/1000009750
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 13
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[13] RENDERING with data: localId=1000009749, pathUri=content://media/external/images/media/1000009749
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 14
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[14] RENDERING with data: localId=1000009748, pathUri=content://media/external/images/media/1000009748
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 15
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[15] RENDERING with data: localId=1000009747, pathUri=content://media/external/images/media/1000009747
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 16
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[16] RENDERING with data: localId=1000009746, pathUri=content://media/external/images/media/1000009746
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 17
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[17] RENDERING with data: localId=1000009745, pathUri=content://media/external/images/media/1000009745
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 18
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[18] RENDERING with data: localId=1000009744, pathUri=content://media/external/images/media/1000009744
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 19
2025-08-12 21:16:31.947 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[19] RENDERING with data: localId=1000009743, pathUri=content://media/external/images/media/1000009743
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 20
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[20] RENDERING with data: localId=1000009742, pathUri=content://media/external/images/media/1000009742
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 21
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[21] RENDERING with data: localId=1000009741, pathUri=content://media/external/images/media/1000009741
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 22
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[22] RENDERING with data: localId=1000009740, pathUri=content://media/external/images/media/1000009740
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 23
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[23] RENDERING with data: localId=1000009739, pathUri=content://media/external/images/media/1000009739
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 24
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[24] RENDERING with data: localId=1000009738, pathUri=content://media/external/images/media/1000009738
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 25
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[25] RENDERING with data: localId=1000009736, pathUri=content://media/external/images/media/1000009736
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 26
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[26] RENDERING with data: localId=1000009725, pathUri=content://media/external/images/media/1000009725
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 27
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[27] RENDERING with data: localId=1000009724, pathUri=content://media/external/images/media/1000009724
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 28
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[28] RENDERING with data: localId=1000009723, pathUri=content://media/external/images/media/1000009723
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 29
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[29] RENDERING with data: localId=1000009722, pathUri=content://media/external/images/media/1000009722
2025-08-12 21:16:31.948 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.949 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 30
2025-08-12 21:16:31.949 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[30] RENDERING with data: localId=1000009721, pathUri=content://media/external/images/media/1000009721
2025-08-12 21:16:31.949 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.949 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 31
2025-08-12 21:16:31.949 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[31] RENDERING with data: localId=1000009720, pathUri=content://media/external/images/media/1000009720
2025-08-12 21:16:31.949 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.949 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 33
2025-08-12 21:16:31.949 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[33] RENDERING with data: localId=1000009605, pathUri=content://media/external/images/media/1000009605
2025-08-12 21:16:31.949 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.949 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 34
2025-08-12 21:16:31.949 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[34] RENDERING with data: localId=1000009604, pathUri=content://media/external/images/media/1000009604
2025-08-12 21:16:31.949 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.949 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 36
2025-08-12 21:16:31.949 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[36] RENDERING with data: localId=1000009544, pathUri=content://media/external/images/media/1000009544
2025-08-12 21:16:31.949 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.949 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 37
2025-08-12 21:16:31.949 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[37] RENDERING with data: localId=1000009538, pathUri=content://media/external/images/media/1000009538
2025-08-12 21:16:31.949 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:31.949 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 38
2025-08-12 21:16:31.949 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[38] RENDERING with data: localId=1000009532, pathUri=content://media/external/images/media/1000009532
2025-08-12 21:16:31.956 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:32.024 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:32.024 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:32.024 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:32.024 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:32.024 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:32.024 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:32.024 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:32.024 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:32.024 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:32.024 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:32.024 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:32.024 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:32.024 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:32.024 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:32.024 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:32.024 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:32.024 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:32.024 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:32.084 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:32.095 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:32.095 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:32.096 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:32.105 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:32.282 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:32.282 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:32.282 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:32.282 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:32.282 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:32.282 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:32.282 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:32.282 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:32.282 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:32.282 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:32.282 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:32.282 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:32.283 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:32.283 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:32.283 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:32.283 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:32.283 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:32.283 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:32.289 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:32.317 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:32.317 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:32.317 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:32.317 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:32.317 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:32.317 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:32.317 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:32.317 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:32.317 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:32.317 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:32.317 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:32.317 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:32.317 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:32.317 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:32.318 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:32.318 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:32.318 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:32.318 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:32.357 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:32.448 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:32.448 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:32.448 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:32.456 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:32.817 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:32.817 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:32.817 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:32.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:32.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:32.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:32.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:32.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:32.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:32.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:32.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:32.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:32.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:32.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:32.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:32.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:32.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:32.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:32.822 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.822 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 1
2025-08-12 21:16:32.822 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[1] RENDERING with data: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:32.822 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.822 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 2
2025-08-12 21:16:32.822 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[2] RENDERING with data: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:32.822 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.822 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 3
2025-08-12 21:16:32.822 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[3] RENDERING with data: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:32.822 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.822 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 4
2025-08-12 21:16:32.822 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[4] RENDERING with data: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:32.822 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.822 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 5
2025-08-12 21:16:32.822 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[5] RENDERING with data: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:32.822 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.822 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 6
2025-08-12 21:16:32.822 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[6] RENDERING with data: localId=1000009756, pathUri=content://media/external/images/media/1000009756
2025-08-12 21:16:32.822 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.822 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 7
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[7] RENDERING with data: localId=1000009755, pathUri=content://media/external/images/media/1000009755
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 8
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[8] RENDERING with data: localId=1000009754, pathUri=content://media/external/images/media/1000009754
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 9
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[9] RENDERING with data: localId=1000009753, pathUri=content://media/external/images/media/1000009753
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 10
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[10] RENDERING with data: localId=1000009752, pathUri=content://media/external/images/media/1000009752
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 11
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[11] RENDERING with data: localId=1000009751, pathUri=content://media/external/images/media/1000009751
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 12
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[12] RENDERING with data: localId=1000009750, pathUri=content://media/external/images/media/1000009750
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 13
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[13] RENDERING with data: localId=1000009749, pathUri=content://media/external/images/media/1000009749
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 14
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[14] RENDERING with data: localId=1000009748, pathUri=content://media/external/images/media/1000009748
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 15
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[15] RENDERING with data: localId=1000009747, pathUri=content://media/external/images/media/1000009747
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 16
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[16] RENDERING with data: localId=1000009746, pathUri=content://media/external/images/media/1000009746
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 17
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[17] RENDERING with data: localId=1000009745, pathUri=content://media/external/images/media/1000009745
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 18
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[18] RENDERING with data: localId=1000009744, pathUri=content://media/external/images/media/1000009744
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 19
2025-08-12 21:16:32.823 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[19] RENDERING with data: localId=1000009743, pathUri=content://media/external/images/media/1000009743
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 20
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[20] RENDERING with data: localId=1000009742, pathUri=content://media/external/images/media/1000009742
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 21
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[21] RENDERING with data: localId=1000009741, pathUri=content://media/external/images/media/1000009741
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 22
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[22] RENDERING with data: localId=1000009740, pathUri=content://media/external/images/media/1000009740
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 23
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[23] RENDERING with data: localId=1000009739, pathUri=content://media/external/images/media/1000009739
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 24
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[24] RENDERING with data: localId=1000009738, pathUri=content://media/external/images/media/1000009738
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 25
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[25] RENDERING with data: localId=1000009736, pathUri=content://media/external/images/media/1000009736
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 26
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[26] RENDERING with data: localId=1000009725, pathUri=content://media/external/images/media/1000009725
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 27
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[27] RENDERING with data: localId=1000009724, pathUri=content://media/external/images/media/1000009724
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 28
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[28] RENDERING with data: localId=1000009723, pathUri=content://media/external/images/media/1000009723
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 29
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[29] RENDERING with data: localId=1000009722, pathUri=content://media/external/images/media/1000009722
2025-08-12 21:16:32.824 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.825 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 30
2025-08-12 21:16:32.825 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[30] RENDERING with data: localId=1000009721, pathUri=content://media/external/images/media/1000009721
2025-08-12 21:16:32.825 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.825 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 31
2025-08-12 21:16:32.825 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[31] RENDERING with data: localId=1000009720, pathUri=content://media/external/images/media/1000009720
2025-08-12 21:16:32.825 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.825 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 33
2025-08-12 21:16:32.825 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[33] RENDERING with data: localId=1000009605, pathUri=content://media/external/images/media/1000009605
2025-08-12 21:16:32.825 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.825 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 34
2025-08-12 21:16:32.825 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[34] RENDERING with data: localId=1000009604, pathUri=content://media/external/images/media/1000009604
2025-08-12 21:16:32.825 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.825 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 36
2025-08-12 21:16:32.825 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[36] RENDERING with data: localId=1000009544, pathUri=content://media/external/images/media/1000009544
2025-08-12 21:16:32.825 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.825 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 37
2025-08-12 21:16:32.825 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[37] RENDERING with data: localId=1000009538, pathUri=content://media/external/images/media/1000009538
2025-08-12 21:16:32.825 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:32.825 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 38
2025-08-12 21:16:32.825 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[38] RENDERING with data: localId=1000009532, pathUri=content://media/external/images/media/1000009532
2025-08-12 21:16:32.832 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:32.899 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:32.899 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:32.899 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:32.899 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:32.899 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:32.899 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:32.899 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:32.899 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:32.899 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:32.899 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:32.899 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:32.899 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:32.899 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:32.899 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:32.899 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:32.899 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:32.899 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:32.899 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:32.938 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:32.949 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:32.949 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:32.949 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:32.958 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:33.126 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:33.126 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:33.126 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:33.126 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:33.126 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:33.126 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:33.126 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:33.126 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:33.126 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:33.126 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:33.126 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:33.126 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:33.126 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:33.126 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:33.126 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:33.126 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:33.126 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:33.126 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:33.133 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:33.160 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:33.160 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:33.160 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:33.160 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:33.160 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:33.160 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:33.160 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:33.160 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:33.160 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:33.160 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:33.160 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:33.160 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:33.160 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:33.160 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:33.161 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:33.161 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:33.161 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:33.161 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:33.202 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:33.290 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:33.290 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:33.291 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:33.298 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:33.649 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:33.649 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:33.649 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:33.649 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:33.649 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:33.649 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:33.649 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:33.649 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:33.649 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:33.649 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:33.649 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:33.649 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:33.649 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:33.649 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:33.649 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:33.649 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:33.649 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:33.649 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:33.652 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.652 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 1
2025-08-12 21:16:33.652 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[1] RENDERING with data: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:33.652 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.652 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 2
2025-08-12 21:16:33.652 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[2] RENDERING with data: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:33.652 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.652 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 3
2025-08-12 21:16:33.652 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[3] RENDERING with data: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:33.652 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.652 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 4
2025-08-12 21:16:33.652 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[4] RENDERING with data: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:33.652 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.652 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 5
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[5] RENDERING with data: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 6
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[6] RENDERING with data: localId=1000009756, pathUri=content://media/external/images/media/1000009756
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 7
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[7] RENDERING with data: localId=1000009755, pathUri=content://media/external/images/media/1000009755
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 8
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[8] RENDERING with data: localId=1000009754, pathUri=content://media/external/images/media/1000009754
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 9
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[9] RENDERING with data: localId=1000009753, pathUri=content://media/external/images/media/1000009753
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 10
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[10] RENDERING with data: localId=1000009752, pathUri=content://media/external/images/media/1000009752
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 11
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[11] RENDERING with data: localId=1000009751, pathUri=content://media/external/images/media/1000009751
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 12
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[12] RENDERING with data: localId=1000009750, pathUri=content://media/external/images/media/1000009750
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 13
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[13] RENDERING with data: localId=1000009749, pathUri=content://media/external/images/media/1000009749
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 14
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[14] RENDERING with data: localId=1000009748, pathUri=content://media/external/images/media/1000009748
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 15
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[15] RENDERING with data: localId=1000009747, pathUri=content://media/external/images/media/1000009747
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.653 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 16
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[16] RENDERING with data: localId=1000009746, pathUri=content://media/external/images/media/1000009746
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 17
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[17] RENDERING with data: localId=1000009745, pathUri=content://media/external/images/media/1000009745
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 18
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[18] RENDERING with data: localId=1000009744, pathUri=content://media/external/images/media/1000009744
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 19
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[19] RENDERING with data: localId=1000009743, pathUri=content://media/external/images/media/1000009743
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 20
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[20] RENDERING with data: localId=1000009742, pathUri=content://media/external/images/media/1000009742
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 21
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[21] RENDERING with data: localId=1000009741, pathUri=content://media/external/images/media/1000009741
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 22
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[22] RENDERING with data: localId=1000009740, pathUri=content://media/external/images/media/1000009740
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 23
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[23] RENDERING with data: localId=1000009739, pathUri=content://media/external/images/media/1000009739
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 24
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[24] RENDERING with data: localId=1000009738, pathUri=content://media/external/images/media/1000009738
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 25
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[25] RENDERING with data: localId=1000009736, pathUri=content://media/external/images/media/1000009736
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 26
2025-08-12 21:16:33.654 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[26] RENDERING with data: localId=1000009725, pathUri=content://media/external/images/media/1000009725
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 27
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[27] RENDERING with data: localId=1000009724, pathUri=content://media/external/images/media/1000009724
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 28
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[28] RENDERING with data: localId=1000009723, pathUri=content://media/external/images/media/1000009723
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 29
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[29] RENDERING with data: localId=1000009722, pathUri=content://media/external/images/media/1000009722
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 30
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[30] RENDERING with data: localId=1000009721, pathUri=content://media/external/images/media/1000009721
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 31
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[31] RENDERING with data: localId=1000009720, pathUri=content://media/external/images/media/1000009720
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 33
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[33] RENDERING with data: localId=1000009605, pathUri=content://media/external/images/media/1000009605
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 34
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[34] RENDERING with data: localId=1000009604, pathUri=content://media/external/images/media/1000009604
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 36
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[36] RENDERING with data: localId=1000009544, pathUri=content://media/external/images/media/1000009544
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 37
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[37] RENDERING with data: localId=1000009538, pathUri=content://media/external/images/media/1000009538
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:33.655 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 38
2025-08-12 21:16:33.656 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[38] RENDERING with data: localId=1000009532, pathUri=content://media/external/images/media/1000009532
2025-08-12 21:16:33.662 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:33.723 23853-23853 JobService              com.akslabs.cloudgallery             W  onNetworkChanged() not implemented in androidx.work.impl.background.systemjob.SystemJobService. Must override in a subclass.
2025-08-12 21:16:33.727 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:33.727 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:33.727 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:33.727 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:33.727 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:33.727 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:33.727 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:33.727 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:33.727 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:33.727 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:33.727 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:33.727 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:33.728 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:33.728 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:33.728 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:33.728 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:33.728 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:33.728 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:33.766 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:33.776 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:33.776 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:33.776 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:33.785 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:33.940 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:33.940 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:33.940 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:33.940 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:33.940 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:33.940 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:33.940 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:33.940 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:33.940 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:33.940 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:33.940 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:33.940 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:33.940 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:33.940 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:33.940 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:33.940 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:33.940 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:33.940 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:33.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:33.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:33.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:33.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:33.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:33.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:33.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:33.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:33.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:33.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:33.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:33.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:33.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:33.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:33.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:33.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:33.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:33.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:33.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:34.010 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:34.094 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:34.095 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:34.095 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:34.102 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:34.421 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:34.421 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:34.421 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:34.421 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:34.422 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:34.422 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:34.422 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:34.422 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:34.422 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:34.422 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:34.422 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:34.422 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:34.422 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:34.422 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:34.422 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:34.422 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:34.422 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:34.422 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:34.425 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.425 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 1
2025-08-12 21:16:34.425 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[1] RENDERING with data: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:34.425 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.425 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 2
2025-08-12 21:16:34.425 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[2] RENDERING with data: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:34.425 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.425 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 3
2025-08-12 21:16:34.425 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[3] RENDERING with data: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:34.425 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.425 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 4
2025-08-12 21:16:34.425 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[4] RENDERING with data: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:34.425 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.425 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 5
2025-08-12 21:16:34.425 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[5] RENDERING with data: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:34.425 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.425 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 6
2025-08-12 21:16:34.425 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[6] RENDERING with data: localId=1000009756, pathUri=content://media/external/images/media/1000009756
2025-08-12 21:16:34.425 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.425 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 7
2025-08-12 21:16:34.425 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[7] RENDERING with data: localId=1000009755, pathUri=content://media/external/images/media/1000009755
2025-08-12 21:16:34.425 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.425 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 8
2025-08-12 21:16:34.425 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[8] RENDERING with data: localId=1000009754, pathUri=content://media/external/images/media/1000009754
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 9
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[9] RENDERING with data: localId=1000009753, pathUri=content://media/external/images/media/1000009753
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 10
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[10] RENDERING with data: localId=1000009752, pathUri=content://media/external/images/media/1000009752
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 11
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[11] RENDERING with data: localId=1000009751, pathUri=content://media/external/images/media/1000009751
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 12
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[12] RENDERING with data: localId=1000009750, pathUri=content://media/external/images/media/1000009750
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 13
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[13] RENDERING with data: localId=1000009749, pathUri=content://media/external/images/media/1000009749
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 14
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[14] RENDERING with data: localId=1000009748, pathUri=content://media/external/images/media/1000009748
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 15
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[15] RENDERING with data: localId=1000009747, pathUri=content://media/external/images/media/1000009747
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 16
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[16] RENDERING with data: localId=1000009746, pathUri=content://media/external/images/media/1000009746
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 17
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[17] RENDERING with data: localId=1000009745, pathUri=content://media/external/images/media/1000009745
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 18
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[18] RENDERING with data: localId=1000009744, pathUri=content://media/external/images/media/1000009744
2025-08-12 21:16:34.426 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 19
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[19] RENDERING with data: localId=1000009743, pathUri=content://media/external/images/media/1000009743
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 20
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[20] RENDERING with data: localId=1000009742, pathUri=content://media/external/images/media/1000009742
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 21
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[21] RENDERING with data: localId=1000009741, pathUri=content://media/external/images/media/1000009741
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 22
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[22] RENDERING with data: localId=1000009740, pathUri=content://media/external/images/media/1000009740
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 23
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[23] RENDERING with data: localId=1000009739, pathUri=content://media/external/images/media/1000009739
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 24
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[24] RENDERING with data: localId=1000009738, pathUri=content://media/external/images/media/1000009738
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 25
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[25] RENDERING with data: localId=1000009736, pathUri=content://media/external/images/media/1000009736
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 26
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[26] RENDERING with data: localId=1000009725, pathUri=content://media/external/images/media/1000009725
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 27
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[27] RENDERING with data: localId=1000009724, pathUri=content://media/external/images/media/1000009724
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 28
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[28] RENDERING with data: localId=1000009723, pathUri=content://media/external/images/media/1000009723
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 29
2025-08-12 21:16:34.427 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[29] RENDERING with data: localId=1000009722, pathUri=content://media/external/images/media/1000009722
2025-08-12 21:16:34.428 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.428 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 30
2025-08-12 21:16:34.428 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[30] RENDERING with data: localId=1000009721, pathUri=content://media/external/images/media/1000009721
2025-08-12 21:16:34.428 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.428 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 31
2025-08-12 21:16:34.428 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[31] RENDERING with data: localId=1000009720, pathUri=content://media/external/images/media/1000009720
2025-08-12 21:16:34.428 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.428 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 33
2025-08-12 21:16:34.428 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[33] RENDERING with data: localId=1000009605, pathUri=content://media/external/images/media/1000009605
2025-08-12 21:16:34.428 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.428 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 34
2025-08-12 21:16:34.428 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[34] RENDERING with data: localId=1000009604, pathUri=content://media/external/images/media/1000009604
2025-08-12 21:16:34.428 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.428 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 36
2025-08-12 21:16:34.428 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[36] RENDERING with data: localId=1000009544, pathUri=content://media/external/images/media/1000009544
2025-08-12 21:16:34.428 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.428 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 37
2025-08-12 21:16:34.428 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[37] RENDERING with data: localId=1000009538, pathUri=content://media/external/images/media/1000009538
2025-08-12 21:16:34.428 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:34.428 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 38
2025-08-12 21:16:34.428 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[38] RENDERING with data: localId=1000009532, pathUri=content://media/external/images/media/1000009532
2025-08-12 21:16:34.435 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:34.497 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:34.497 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:34.498 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:34.498 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:34.498 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:34.498 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:34.498 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:34.498 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:34.498 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:34.498 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:34.498 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:34.498 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:34.498 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:34.498 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:34.498 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:34.498 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:34.498 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:34.498 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:34.543 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:34.553 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:34.553 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:34.553 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:34.562 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:34.713 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:34.713 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:34.713 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:34.713 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:34.713 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:34.713 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:34.713 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:34.713 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:34.713 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:34.713 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:34.713 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:34.713 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:34.713 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:34.713 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:34.713 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:34.713 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:34.713 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:34.713 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:34.720 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:34.743 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:34.743 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:34.743 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:34.743 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:34.743 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:34.743 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:34.743 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:34.743 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:34.743 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:34.743 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:34.743 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:34.743 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:34.744 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:34.744 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:34.744 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:34.744 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:34.744 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:34.744 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:34.782 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:34.863 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:34.863 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:34.864 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:34.871 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:35.196 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:35.196 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:35.196 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:35.197 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:35.197 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:35.197 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:35.197 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:35.197 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:35.197 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:35.197 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:35.197 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:35.197 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:35.197 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:35.197 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:35.197 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:35.197 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:35.197 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:35.197 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:35.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 1
2025-08-12 21:16:35.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[1] RENDERING with data: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:35.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 2
2025-08-12 21:16:35.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[2] RENDERING with data: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:35.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 3
2025-08-12 21:16:35.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[3] RENDERING with data: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:35.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 4
2025-08-12 21:16:35.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[4] RENDERING with data: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:35.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 5
2025-08-12 21:16:35.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[5] RENDERING with data: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:35.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 6
2025-08-12 21:16:35.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[6] RENDERING with data: localId=1000009756, pathUri=content://media/external/images/media/1000009756
2025-08-12 21:16:35.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 7
2025-08-12 21:16:35.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[7] RENDERING with data: localId=1000009755, pathUri=content://media/external/images/media/1000009755
2025-08-12 21:16:35.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 8
2025-08-12 21:16:35.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[8] RENDERING with data: localId=1000009754, pathUri=content://media/external/images/media/1000009754
2025-08-12 21:16:35.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 9
2025-08-12 21:16:35.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[9] RENDERING with data: localId=1000009753, pathUri=content://media/external/images/media/1000009753
2025-08-12 21:16:35.200 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 10
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[10] RENDERING with data: localId=1000009752, pathUri=content://media/external/images/media/1000009752
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 11
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[11] RENDERING with data: localId=1000009751, pathUri=content://media/external/images/media/1000009751
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 12
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[12] RENDERING with data: localId=1000009750, pathUri=content://media/external/images/media/1000009750
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 13
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[13] RENDERING with data: localId=1000009749, pathUri=content://media/external/images/media/1000009749
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 14
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[14] RENDERING with data: localId=1000009748, pathUri=content://media/external/images/media/1000009748
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 15
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[15] RENDERING with data: localId=1000009747, pathUri=content://media/external/images/media/1000009747
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 16
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[16] RENDERING with data: localId=1000009746, pathUri=content://media/external/images/media/1000009746
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 17
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[17] RENDERING with data: localId=1000009745, pathUri=content://media/external/images/media/1000009745
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 18
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[18] RENDERING with data: localId=1000009744, pathUri=content://media/external/images/media/1000009744
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 19
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[19] RENDERING with data: localId=1000009743, pathUri=content://media/external/images/media/1000009743
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 20
2025-08-12 21:16:35.201 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[20] RENDERING with data: localId=1000009742, pathUri=content://media/external/images/media/1000009742
2025-08-12 21:16:35.202 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.202 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 21
2025-08-12 21:16:35.202 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[21] RENDERING with data: localId=1000009741, pathUri=content://media/external/images/media/1000009741
2025-08-12 21:16:35.202 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.202 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 22
2025-08-12 21:16:35.202 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[22] RENDERING with data: localId=1000009740, pathUri=content://media/external/images/media/1000009740
2025-08-12 21:16:35.202 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.202 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 23
2025-08-12 21:16:35.202 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[23] RENDERING with data: localId=1000009739, pathUri=content://media/external/images/media/1000009739
2025-08-12 21:16:35.202 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.202 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 24
2025-08-12 21:16:35.202 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[24] RENDERING with data: localId=1000009738, pathUri=content://media/external/images/media/1000009738
2025-08-12 21:16:35.202 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.202 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 25
2025-08-12 21:16:35.202 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[25] RENDERING with data: localId=1000009736, pathUri=content://media/external/images/media/1000009736
2025-08-12 21:16:35.202 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.202 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 26
2025-08-12 21:16:35.202 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[26] RENDERING with data: localId=1000009725, pathUri=content://media/external/images/media/1000009725
2025-08-12 21:16:35.202 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.202 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 27
2025-08-12 21:16:35.202 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[27] RENDERING with data: localId=1000009724, pathUri=content://media/external/images/media/1000009724
2025-08-12 21:16:35.202 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.202 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 28
2025-08-12 21:16:35.202 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[28] RENDERING with data: localId=1000009723, pathUri=content://media/external/images/media/1000009723
2025-08-12 21:16:35.202 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.202 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 29
2025-08-12 21:16:35.203 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[29] RENDERING with data: localId=1000009722, pathUri=content://media/external/images/media/1000009722
2025-08-12 21:16:35.203 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.203 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 30
2025-08-12 21:16:35.203 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[30] RENDERING with data: localId=1000009721, pathUri=content://media/external/images/media/1000009721
2025-08-12 21:16:35.203 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.203 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 31
2025-08-12 21:16:35.203 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[31] RENDERING with data: localId=1000009720, pathUri=content://media/external/images/media/1000009720
2025-08-12 21:16:35.203 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.203 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 33
2025-08-12 21:16:35.203 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[33] RENDERING with data: localId=1000009605, pathUri=content://media/external/images/media/1000009605
2025-08-12 21:16:35.203 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.203 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 34
2025-08-12 21:16:35.203 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[34] RENDERING with data: localId=1000009604, pathUri=content://media/external/images/media/1000009604
2025-08-12 21:16:35.203 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.203 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 36
2025-08-12 21:16:35.203 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[36] RENDERING with data: localId=1000009544, pathUri=content://media/external/images/media/1000009544
2025-08-12 21:16:35.204 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.204 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 37
2025-08-12 21:16:35.204 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[37] RENDERING with data: localId=1000009538, pathUri=content://media/external/images/media/1000009538
2025-08-12 21:16:35.204 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.204 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 38
2025-08-12 21:16:35.204 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[38] RENDERING with data: localId=1000009532, pathUri=content://media/external/images/media/1000009532
2025-08-12 21:16:35.213 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:35.271 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:35.271 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:35.271 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:35.271 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:35.271 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:35.271 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:35.271 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:35.271 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:35.271 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:35.271 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:35.271 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:35.271 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:35.271 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:35.271 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:35.271 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:35.271 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:35.271 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:35.271 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:35.311 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:35.320 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:35.320 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:35.321 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:35.329 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:35.494 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:35.494 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:35.494 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:35.494 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:35.494 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:35.494 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:35.494 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:35.494 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:35.494 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:35.494 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:35.494 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:35.494 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:35.494 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:35.494 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:35.494 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:35.494 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:35.494 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:35.494 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:35.501 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:35.525 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:35.526 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:35.526 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:35.526 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:35.526 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:35.526 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:35.526 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:35.526 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:35.526 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:35.526 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:35.526 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:35.526 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:35.526 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:35.526 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:35.526 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:35.526 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:35.526 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:35.526 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:35.565 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:35.645 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:35.645 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:35.646 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:35.653 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:35.973 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:35.973 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:35.973 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:35.973 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:35.973 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:35.973 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:35.973 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:35.973 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:35.974 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:35.974 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:35.974 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:35.974 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:35.974 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:35.974 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:35.974 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:35.974 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:35.974 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:35.974 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:35.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 1
2025-08-12 21:16:35.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[1] RENDERING with data: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 2
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[2] RENDERING with data: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 3
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[3] RENDERING with data: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 4
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[4] RENDERING with data: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 5
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[5] RENDERING with data: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 6
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[6] RENDERING with data: localId=1000009756, pathUri=content://media/external/images/media/1000009756
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 7
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[7] RENDERING with data: localId=1000009755, pathUri=content://media/external/images/media/1000009755
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 8
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[8] RENDERING with data: localId=1000009754, pathUri=content://media/external/images/media/1000009754
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 9
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[9] RENDERING with data: localId=1000009753, pathUri=content://media/external/images/media/1000009753
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 10
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[10] RENDERING with data: localId=1000009752, pathUri=content://media/external/images/media/1000009752
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 11
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[11] RENDERING with data: localId=1000009751, pathUri=content://media/external/images/media/1000009751
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 12
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[12] RENDERING with data: localId=1000009750, pathUri=content://media/external/images/media/1000009750
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 13
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[13] RENDERING with data: localId=1000009749, pathUri=content://media/external/images/media/1000009749
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 14
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[14] RENDERING with data: localId=1000009748, pathUri=content://media/external/images/media/1000009748
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 15
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[15] RENDERING with data: localId=1000009747, pathUri=content://media/external/images/media/1000009747
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 16
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[16] RENDERING with data: localId=1000009746, pathUri=content://media/external/images/media/1000009746
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 17
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[17] RENDERING with data: localId=1000009745, pathUri=content://media/external/images/media/1000009745
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 18
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[18] RENDERING with data: localId=1000009744, pathUri=content://media/external/images/media/1000009744
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 19
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[19] RENDERING with data: localId=1000009743, pathUri=content://media/external/images/media/1000009743
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 20
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[20] RENDERING with data: localId=1000009742, pathUri=content://media/external/images/media/1000009742
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 21
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[21] RENDERING with data: localId=1000009741, pathUri=content://media/external/images/media/1000009741
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 22
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[22] RENDERING with data: localId=1000009740, pathUri=content://media/external/images/media/1000009740
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 23
2025-08-12 21:16:35.978 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[23] RENDERING with data: localId=1000009739, pathUri=content://media/external/images/media/1000009739
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 24
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[24] RENDERING with data: localId=1000009738, pathUri=content://media/external/images/media/1000009738
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 25
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[25] RENDERING with data: localId=1000009736, pathUri=content://media/external/images/media/1000009736
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 26
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[26] RENDERING with data: localId=1000009725, pathUri=content://media/external/images/media/1000009725
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 27
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[27] RENDERING with data: localId=1000009724, pathUri=content://media/external/images/media/1000009724
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 28
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[28] RENDERING with data: localId=1000009723, pathUri=content://media/external/images/media/1000009723
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 29
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[29] RENDERING with data: localId=1000009722, pathUri=content://media/external/images/media/1000009722
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 30
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[30] RENDERING with data: localId=1000009721, pathUri=content://media/external/images/media/1000009721
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 31
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[31] RENDERING with data: localId=1000009720, pathUri=content://media/external/images/media/1000009720
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 33
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[33] RENDERING with data: localId=1000009605, pathUri=content://media/external/images/media/1000009605
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 34
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[34] RENDERING with data: localId=1000009604, pathUri=content://media/external/images/media/1000009604
2025-08-12 21:16:35.979 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.980 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 36
2025-08-12 21:16:35.980 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[36] RENDERING with data: localId=1000009544, pathUri=content://media/external/images/media/1000009544
2025-08-12 21:16:35.980 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.980 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 37
2025-08-12 21:16:35.980 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[37] RENDERING with data: localId=1000009538, pathUri=content://media/external/images/media/1000009538
2025-08-12 21:16:35.980 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:35.980 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 38
2025-08-12 21:16:35.980 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[38] RENDERING with data: localId=1000009532, pathUri=content://media/external/images/media/1000009532
2025-08-12 21:16:35.987 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:36.043 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:36.043 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:36.043 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:36.043 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:36.043 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:36.043 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:36.043 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:36.043 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:36.043 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:36.043 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:36.043 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:36.043 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:36.043 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:36.044 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:36.044 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:36.044 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:36.044 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:36.044 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:36.082 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:36.091 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:36.091 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:36.092 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:36.100 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:36.269 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:36.269 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:36.269 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:36.269 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:36.269 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:36.269 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:36.269 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:36.269 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:36.269 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:36.269 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:36.269 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:36.269 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:36.269 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:36.269 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:36.269 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:36.269 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:36.269 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:36.269 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:36.276 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:36.299 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:36.299 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:36.299 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:36.299 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:36.299 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:36.299 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:36.299 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:36.299 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:36.299 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:36.299 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:36.299 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:36.299 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:36.299 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:36.300 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:36.300 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:36.300 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:36.300 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:36.300 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:36.338 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:36.419 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:36.419 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:36.419 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:36.427 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:36.744 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:36.744 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:36.744 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:36.744 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:36.745 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:36.745 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:36.745 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:36.745 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:36.745 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:36.745 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:36.745 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:36.745 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:36.745 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:36.745 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:36.745 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:36.745 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:36.745 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:36.745 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:36.748 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.748 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 1
2025-08-12 21:16:36.748 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[1] RENDERING with data: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:36.748 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.748 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 2
2025-08-12 21:16:36.748 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[2] RENDERING with data: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:36.748 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.748 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 3
2025-08-12 21:16:36.748 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[3] RENDERING with data: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:36.748 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.748 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 4
2025-08-12 21:16:36.748 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[4] RENDERING with data: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:36.748 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.748 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 5
2025-08-12 21:16:36.748 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[5] RENDERING with data: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:36.748 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.748 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 6
2025-08-12 21:16:36.748 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[6] RENDERING with data: localId=1000009756, pathUri=content://media/external/images/media/1000009756
2025-08-12 21:16:36.748 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.748 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 7
2025-08-12 21:16:36.748 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[7] RENDERING with data: localId=1000009755, pathUri=content://media/external/images/media/1000009755
2025-08-12 21:16:36.748 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.748 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 8
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[8] RENDERING with data: localId=1000009754, pathUri=content://media/external/images/media/1000009754
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 9
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[9] RENDERING with data: localId=1000009753, pathUri=content://media/external/images/media/1000009753
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 10
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[10] RENDERING with data: localId=1000009752, pathUri=content://media/external/images/media/1000009752
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 11
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[11] RENDERING with data: localId=1000009751, pathUri=content://media/external/images/media/1000009751
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 12
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[12] RENDERING with data: localId=1000009750, pathUri=content://media/external/images/media/1000009750
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 13
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[13] RENDERING with data: localId=1000009749, pathUri=content://media/external/images/media/1000009749
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 14
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[14] RENDERING with data: localId=1000009748, pathUri=content://media/external/images/media/1000009748
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 15
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[15] RENDERING with data: localId=1000009747, pathUri=content://media/external/images/media/1000009747
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 16
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[16] RENDERING with data: localId=1000009746, pathUri=content://media/external/images/media/1000009746
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 17
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[17] RENDERING with data: localId=1000009745, pathUri=content://media/external/images/media/1000009745
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 18
2025-08-12 21:16:36.749 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[18] RENDERING with data: localId=1000009744, pathUri=content://media/external/images/media/1000009744
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 19
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[19] RENDERING with data: localId=1000009743, pathUri=content://media/external/images/media/1000009743
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 20
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[20] RENDERING with data: localId=1000009742, pathUri=content://media/external/images/media/1000009742
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 21
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[21] RENDERING with data: localId=1000009741, pathUri=content://media/external/images/media/1000009741
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 22
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[22] RENDERING with data: localId=1000009740, pathUri=content://media/external/images/media/1000009740
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 23
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[23] RENDERING with data: localId=1000009739, pathUri=content://media/external/images/media/1000009739
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 24
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[24] RENDERING with data: localId=1000009738, pathUri=content://media/external/images/media/1000009738
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 25
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[25] RENDERING with data: localId=1000009736, pathUri=content://media/external/images/media/1000009736
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 26
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[26] RENDERING with data: localId=1000009725, pathUri=content://media/external/images/media/1000009725
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 27
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[27] RENDERING with data: localId=1000009724, pathUri=content://media/external/images/media/1000009724
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 28
2025-08-12 21:16:36.750 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[28] RENDERING with data: localId=1000009723, pathUri=content://media/external/images/media/1000009723
2025-08-12 21:16:36.751 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.751 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 29
2025-08-12 21:16:36.751 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[29] RENDERING with data: localId=1000009722, pathUri=content://media/external/images/media/1000009722
2025-08-12 21:16:36.751 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.751 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 30
2025-08-12 21:16:36.751 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[30] RENDERING with data: localId=1000009721, pathUri=content://media/external/images/media/1000009721
2025-08-12 21:16:36.751 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.751 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 31
2025-08-12 21:16:36.751 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[31] RENDERING with data: localId=1000009720, pathUri=content://media/external/images/media/1000009720
2025-08-12 21:16:36.751 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.751 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 33
2025-08-12 21:16:36.751 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[33] RENDERING with data: localId=1000009605, pathUri=content://media/external/images/media/1000009605
2025-08-12 21:16:36.751 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.751 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 34
2025-08-12 21:16:36.751 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[34] RENDERING with data: localId=1000009604, pathUri=content://media/external/images/media/1000009604
2025-08-12 21:16:36.751 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.751 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 36
2025-08-12 21:16:36.751 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[36] RENDERING with data: localId=1000009544, pathUri=content://media/external/images/media/1000009544
2025-08-12 21:16:36.751 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.751 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 37
2025-08-12 21:16:36.751 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[37] RENDERING with data: localId=1000009538, pathUri=content://media/external/images/media/1000009538
2025-08-12 21:16:36.751 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:36.751 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 38
2025-08-12 21:16:36.751 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[38] RENDERING with data: localId=1000009532, pathUri=content://media/external/images/media/1000009532
2025-08-12 21:16:36.758 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:36.814 23853-23853 JobService              com.akslabs.cloudgallery             W  onNetworkChanged() not implemented in androidx.work.impl.background.systemjob.SystemJobService. Must override in a subclass.
2025-08-12 21:16:36.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:36.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:36.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:36.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:36.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:36.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:36.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:36.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:36.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:36.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:36.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:36.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:36.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:36.818 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:36.819 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:36.819 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:36.819 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:36.819 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:36.858 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:36.868 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:36.868 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:36.868 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:36.877 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:37.023 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:37.023 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:37.023 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:37.023 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:37.023 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:37.023 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:37.023 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:37.023 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:37.024 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:37.024 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:37.024 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:37.024 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:37.024 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:37.024 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:37.024 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:37.024 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:37.024 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:37.024 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:37.030 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:37.053 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:37.053 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:37.053 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:37.053 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:37.053 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:37.053 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:37.053 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:37.053 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:37.053 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:37.053 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:37.053 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:37.053 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:37.053 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:37.053 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:37.054 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:37.054 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:37.054 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:37.054 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:37.092 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:37.169 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:37.169 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:37.169 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:37.176 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:37.484 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:37.484 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:37.484 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:37.484 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:37.484 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:37.484 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:37.484 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:37.484 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:37.484 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:37.484 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:37.484 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:37.485 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:37.485 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:37.485 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:37.485 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:37.485 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:37.485 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:37.485 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:37.487 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.487 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 1
2025-08-12 21:16:37.487 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[1] RENDERING with data: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 2
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[2] RENDERING with data: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 3
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[3] RENDERING with data: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 4
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[4] RENDERING with data: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 5
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[5] RENDERING with data: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 6
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[6] RENDERING with data: localId=1000009756, pathUri=content://media/external/images/media/1000009756
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 7
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[7] RENDERING with data: localId=1000009755, pathUri=content://media/external/images/media/1000009755
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 8
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[8] RENDERING with data: localId=1000009754, pathUri=content://media/external/images/media/1000009754
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 9
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[9] RENDERING with data: localId=1000009753, pathUri=content://media/external/images/media/1000009753
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 10
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[10] RENDERING with data: localId=1000009752, pathUri=content://media/external/images/media/1000009752
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 11
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[11] RENDERING with data: localId=1000009751, pathUri=content://media/external/images/media/1000009751
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 12
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[12] RENDERING with data: localId=1000009750, pathUri=content://media/external/images/media/1000009750
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 13
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[13] RENDERING with data: localId=1000009749, pathUri=content://media/external/images/media/1000009749
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 14
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[14] RENDERING with data: localId=1000009748, pathUri=content://media/external/images/media/1000009748
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 15
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[15] RENDERING with data: localId=1000009747, pathUri=content://media/external/images/media/1000009747
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 16
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[16] RENDERING with data: localId=1000009746, pathUri=content://media/external/images/media/1000009746
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 17
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[17] RENDERING with data: localId=1000009745, pathUri=content://media/external/images/media/1000009745
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 18
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[18] RENDERING with data: localId=1000009744, pathUri=content://media/external/images/media/1000009744
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 19
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[19] RENDERING with data: localId=1000009743, pathUri=content://media/external/images/media/1000009743
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 20
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[20] RENDERING with data: localId=1000009742, pathUri=content://media/external/images/media/1000009742
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 21
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[21] RENDERING with data: localId=1000009741, pathUri=content://media/external/images/media/1000009741
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 22
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[22] RENDERING with data: localId=1000009740, pathUri=content://media/external/images/media/1000009740
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 23
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[23] RENDERING with data: localId=1000009739, pathUri=content://media/external/images/media/1000009739
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 24
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[24] RENDERING with data: localId=1000009738, pathUri=content://media/external/images/media/1000009738
2025-08-12 21:16:37.489 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 25
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[25] RENDERING with data: localId=1000009736, pathUri=content://media/external/images/media/1000009736
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 26
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[26] RENDERING with data: localId=1000009725, pathUri=content://media/external/images/media/1000009725
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 27
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[27] RENDERING with data: localId=1000009724, pathUri=content://media/external/images/media/1000009724
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 28
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[28] RENDERING with data: localId=1000009723, pathUri=content://media/external/images/media/1000009723
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 29
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[29] RENDERING with data: localId=1000009722, pathUri=content://media/external/images/media/1000009722
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 30
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[30] RENDERING with data: localId=1000009721, pathUri=content://media/external/images/media/1000009721
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 31
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[31] RENDERING with data: localId=1000009720, pathUri=content://media/external/images/media/1000009720
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 33
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[33] RENDERING with data: localId=1000009605, pathUri=content://media/external/images/media/1000009605
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 34
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[34] RENDERING with data: localId=1000009604, pathUri=content://media/external/images/media/1000009604
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 36
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[36] RENDERING with data: localId=1000009544, pathUri=content://media/external/images/media/1000009544
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 37
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[37] RENDERING with data: localId=1000009538, pathUri=content://media/external/images/media/1000009538
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:37.490 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 38
2025-08-12 21:16:37.491 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[38] RENDERING with data: localId=1000009532, pathUri=content://media/external/images/media/1000009532
2025-08-12 21:16:37.497 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:37.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:37.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:37.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:37.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:37.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:37.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:37.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:37.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:37.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:37.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:37.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:37.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:37.557 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:37.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:37.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:37.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:37.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:37.558 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:37.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:37.610 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:37.610 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:37.611 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:37.619 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:37.759 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:37.759 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:37.759 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:37.759 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:37.759 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:37.759 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:37.759 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:37.759 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:37.759 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:37.759 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:37.759 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:37.759 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:37.759 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:37.759 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:37.760 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:37.760 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:37.760 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:37.760 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:37.766 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:37.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:37.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:37.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:37.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:37.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:37.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:37.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:37.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:37.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:37.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:37.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:37.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:37.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:37.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:37.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:37.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:37.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:37.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:37.827 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:37.901 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:37.901 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:37.902 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:37.909 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:38.204 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:38.204 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:38.204 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:38.204 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:38.204 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:38.204 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:38.204 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:38.204 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:38.204 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:38.204 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:38.204 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:38.205 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:38.205 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:38.205 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:38.205 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:38.205 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:38.205 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:38.205 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:38.207 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.207 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 1
2025-08-12 21:16:38.207 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[1] RENDERING with data: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 2
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[2] RENDERING with data: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 3
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[3] RENDERING with data: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 4
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[4] RENDERING with data: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 5
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[5] RENDERING with data: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 6
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[6] RENDERING with data: localId=1000009756, pathUri=content://media/external/images/media/1000009756
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 7
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[7] RENDERING with data: localId=1000009755, pathUri=content://media/external/images/media/1000009755
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 8
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[8] RENDERING with data: localId=1000009754, pathUri=content://media/external/images/media/1000009754
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 9
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[9] RENDERING with data: localId=1000009753, pathUri=content://media/external/images/media/1000009753
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 10
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[10] RENDERING with data: localId=1000009752, pathUri=content://media/external/images/media/1000009752
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 11
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[11] RENDERING with data: localId=1000009751, pathUri=content://media/external/images/media/1000009751
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 12
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[12] RENDERING with data: localId=1000009750, pathUri=content://media/external/images/media/1000009750
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.208 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 13
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[13] RENDERING with data: localId=1000009749, pathUri=content://media/external/images/media/1000009749
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 14
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[14] RENDERING with data: localId=1000009748, pathUri=content://media/external/images/media/1000009748
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 15
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[15] RENDERING with data: localId=1000009747, pathUri=content://media/external/images/media/1000009747
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 16
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[16] RENDERING with data: localId=1000009746, pathUri=content://media/external/images/media/1000009746
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 17
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[17] RENDERING with data: localId=1000009745, pathUri=content://media/external/images/media/1000009745
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 18
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[18] RENDERING with data: localId=1000009744, pathUri=content://media/external/images/media/1000009744
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 19
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[19] RENDERING with data: localId=1000009743, pathUri=content://media/external/images/media/1000009743
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 20
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[20] RENDERING with data: localId=1000009742, pathUri=content://media/external/images/media/1000009742
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 21
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[21] RENDERING with data: localId=1000009741, pathUri=content://media/external/images/media/1000009741
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 22
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[22] RENDERING with data: localId=1000009740, pathUri=content://media/external/images/media/1000009740
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 23
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[23] RENDERING with data: localId=1000009739, pathUri=content://media/external/images/media/1000009739
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 24
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[24] RENDERING with data: localId=1000009738, pathUri=content://media/external/images/media/1000009738
2025-08-12 21:16:38.209 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 25
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[25] RENDERING with data: localId=1000009736, pathUri=content://media/external/images/media/1000009736
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 26
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[26] RENDERING with data: localId=1000009725, pathUri=content://media/external/images/media/1000009725
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 27
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[27] RENDERING with data: localId=1000009724, pathUri=content://media/external/images/media/1000009724
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 28
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[28] RENDERING with data: localId=1000009723, pathUri=content://media/external/images/media/1000009723
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 29
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[29] RENDERING with data: localId=1000009722, pathUri=content://media/external/images/media/1000009722
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 30
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[30] RENDERING with data: localId=1000009721, pathUri=content://media/external/images/media/1000009721
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 31
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[31] RENDERING with data: localId=1000009720, pathUri=content://media/external/images/media/1000009720
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 33
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[33] RENDERING with data: localId=1000009605, pathUri=content://media/external/images/media/1000009605
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 34
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[34] RENDERING with data: localId=1000009604, pathUri=content://media/external/images/media/1000009604
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 36
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[36] RENDERING with data: localId=1000009544, pathUri=content://media/external/images/media/1000009544
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 37
2025-08-12 21:16:38.210 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[37] RENDERING with data: localId=1000009538, pathUri=content://media/external/images/media/1000009538
2025-08-12 21:16:38.211 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.211 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 38
2025-08-12 21:16:38.211 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[38] RENDERING with data: localId=1000009532, pathUri=content://media/external/images/media/1000009532
2025-08-12 21:16:38.217 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:38.272 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:38.272 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:38.272 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:38.272 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:38.272 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:38.272 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:38.272 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:38.272 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:38.272 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:38.272 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:38.272 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:38.272 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:38.272 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:38.272 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:38.272 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:38.272 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:38.272 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:38.272 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:38.310 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:38.320 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:38.320 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:38.320 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:38.328 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:38.481 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:38.481 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:38.481 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:38.481 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:38.481 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:38.481 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:38.481 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:38.481 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:38.481 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:38.481 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:38.481 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:38.481 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:38.481 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:38.481 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:38.481 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:38.481 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:38.481 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:38.481 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:38.488 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:38.509 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:38.510 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:38.510 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:38.510 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:38.510 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:38.510 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:38.510 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:38.510 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:38.510 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:38.510 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:38.510 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:38.510 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:38.510 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:38.510 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:38.510 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:38.510 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:38.510 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:38.510 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:38.553 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:38.628 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:38.628 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:38.628 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:38.635 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:38.932 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:38.932 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:38.932 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:38.932 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:38.932 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:38.932 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:38.932 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:38.932 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:38.932 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:38.932 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:38.932 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:38.932 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:38.932 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:38.932 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:38.932 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:38.932 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:38.932 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:38.932 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:38.935 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.935 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 1
2025-08-12 21:16:38.935 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[1] RENDERING with data: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:38.935 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.935 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 2
2025-08-12 21:16:38.935 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[2] RENDERING with data: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:38.935 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.935 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 3
2025-08-12 21:16:38.935 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[3] RENDERING with data: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:38.935 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.935 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 4
2025-08-12 21:16:38.935 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[4] RENDERING with data: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 5
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[5] RENDERING with data: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 6
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[6] RENDERING with data: localId=1000009756, pathUri=content://media/external/images/media/1000009756
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 7
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[7] RENDERING with data: localId=1000009755, pathUri=content://media/external/images/media/1000009755
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 8
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[8] RENDERING with data: localId=1000009754, pathUri=content://media/external/images/media/1000009754
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 9
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[9] RENDERING with data: localId=1000009753, pathUri=content://media/external/images/media/1000009753
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 10
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[10] RENDERING with data: localId=1000009752, pathUri=content://media/external/images/media/1000009752
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 11
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[11] RENDERING with data: localId=1000009751, pathUri=content://media/external/images/media/1000009751
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 12
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[12] RENDERING with data: localId=1000009750, pathUri=content://media/external/images/media/1000009750
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 13
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[13] RENDERING with data: localId=1000009749, pathUri=content://media/external/images/media/1000009749
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 14
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[14] RENDERING with data: localId=1000009748, pathUri=content://media/external/images/media/1000009748
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 15
2025-08-12 21:16:38.936 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[15] RENDERING with data: localId=1000009747, pathUri=content://media/external/images/media/1000009747
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 16
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[16] RENDERING with data: localId=1000009746, pathUri=content://media/external/images/media/1000009746
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 17
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[17] RENDERING with data: localId=1000009745, pathUri=content://media/external/images/media/1000009745
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 18
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[18] RENDERING with data: localId=1000009744, pathUri=content://media/external/images/media/1000009744
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 19
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[19] RENDERING with data: localId=1000009743, pathUri=content://media/external/images/media/1000009743
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 20
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[20] RENDERING with data: localId=1000009742, pathUri=content://media/external/images/media/1000009742
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 21
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[21] RENDERING with data: localId=1000009741, pathUri=content://media/external/images/media/1000009741
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 22
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[22] RENDERING with data: localId=1000009740, pathUri=content://media/external/images/media/1000009740
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 23
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[23] RENDERING with data: localId=1000009739, pathUri=content://media/external/images/media/1000009739
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 24
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[24] RENDERING with data: localId=1000009738, pathUri=content://media/external/images/media/1000009738
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 25
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[25] RENDERING with data: localId=1000009736, pathUri=content://media/external/images/media/1000009736
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 26
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[26] RENDERING with data: localId=1000009725, pathUri=content://media/external/images/media/1000009725
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 27
2025-08-12 21:16:38.937 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[27] RENDERING with data: localId=1000009724, pathUri=content://media/external/images/media/1000009724
2025-08-12 21:16:38.938 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.938 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 28
2025-08-12 21:16:38.938 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[28] RENDERING with data: localId=1000009723, pathUri=content://media/external/images/media/1000009723
2025-08-12 21:16:38.938 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.938 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 29
2025-08-12 21:16:38.938 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[29] RENDERING with data: localId=1000009722, pathUri=content://media/external/images/media/1000009722
2025-08-12 21:16:38.938 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.938 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 30
2025-08-12 21:16:38.938 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[30] RENDERING with data: localId=1000009721, pathUri=content://media/external/images/media/1000009721
2025-08-12 21:16:38.938 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.938 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 31
2025-08-12 21:16:38.938 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[31] RENDERING with data: localId=1000009720, pathUri=content://media/external/images/media/1000009720
2025-08-12 21:16:38.938 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.938 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 33
2025-08-12 21:16:38.938 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[33] RENDERING with data: localId=1000009605, pathUri=content://media/external/images/media/1000009605
2025-08-12 21:16:38.938 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.938 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 34
2025-08-12 21:16:38.938 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[34] RENDERING with data: localId=1000009604, pathUri=content://media/external/images/media/1000009604
2025-08-12 21:16:38.938 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.938 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 36
2025-08-12 21:16:38.938 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[36] RENDERING with data: localId=1000009544, pathUri=content://media/external/images/media/1000009544
2025-08-12 21:16:38.938 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.938 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 37
2025-08-12 21:16:38.938 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[37] RENDERING with data: localId=1000009538, pathUri=content://media/external/images/media/1000009538
2025-08-12 21:16:38.938 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:38.938 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 38
2025-08-12 21:16:38.938 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[38] RENDERING with data: localId=1000009532, pathUri=content://media/external/images/media/1000009532
2025-08-12 21:16:38.945 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:38.994 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:38.994 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:38.994 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:38.994 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:38.994 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:38.994 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:38.994 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:38.994 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:38.994 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:38.994 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:38.994 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:38.994 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:38.994 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:38.994 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:38.994 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:38.994 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:38.994 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:38.994 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:39.032 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:39.041 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:39.041 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:39.041 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:39.049 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:39.169 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:39.169 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:39.170 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:39.170 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:39.170 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:39.170 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:39.170 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:39.170 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:39.170 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:39.170 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:39.170 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:39.170 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:39.170 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:39.170 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:39.170 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:39.170 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:39.170 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:39.170 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:39.176 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:39.197 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:39.197 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:39.197 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:39.197 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:39.197 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:39.197 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:39.197 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:39.197 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:39.197 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:39.198 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:39.198 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:39.198 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:39.198 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:39.198 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:39.198 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:39.198 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:39.198 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:39.198 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:39.236 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:39.308 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:39.308 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:39.308 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:39.316 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:39.596 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:39.596 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:39.596 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:39.596 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:39.596 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:39.596 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:39.596 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:39.596 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:39.596 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:39.596 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:39.596 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:39.596 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:39.596 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:39.596 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:39.596 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:39.597 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:39.597 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:39.597 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:39.599 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.599 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 1
2025-08-12 21:16:39.599 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[1] RENDERING with data: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:39.599 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.599 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 2
2025-08-12 21:16:39.599 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[2] RENDERING with data: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:39.599 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.599 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 3
2025-08-12 21:16:39.599 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[3] RENDERING with data: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 4
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[4] RENDERING with data: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 5
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[5] RENDERING with data: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 6
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[6] RENDERING with data: localId=1000009756, pathUri=content://media/external/images/media/1000009756
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 7
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[7] RENDERING with data: localId=1000009755, pathUri=content://media/external/images/media/1000009755
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 8
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[8] RENDERING with data: localId=1000009754, pathUri=content://media/external/images/media/1000009754
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 9
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[9] RENDERING with data: localId=1000009753, pathUri=content://media/external/images/media/1000009753
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 10
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[10] RENDERING with data: localId=1000009752, pathUri=content://media/external/images/media/1000009752
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 11
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[11] RENDERING with data: localId=1000009751, pathUri=content://media/external/images/media/1000009751
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 12
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[12] RENDERING with data: localId=1000009750, pathUri=content://media/external/images/media/1000009750
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 13
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[13] RENDERING with data: localId=1000009749, pathUri=content://media/external/images/media/1000009749
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 14
2025-08-12 21:16:39.600 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[14] RENDERING with data: localId=1000009748, pathUri=content://media/external/images/media/1000009748
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 15
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[15] RENDERING with data: localId=1000009747, pathUri=content://media/external/images/media/1000009747
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 16
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[16] RENDERING with data: localId=1000009746, pathUri=content://media/external/images/media/1000009746
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 17
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[17] RENDERING with data: localId=1000009745, pathUri=content://media/external/images/media/1000009745
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 18
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[18] RENDERING with data: localId=1000009744, pathUri=content://media/external/images/media/1000009744
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 19
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[19] RENDERING with data: localId=1000009743, pathUri=content://media/external/images/media/1000009743
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 20
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[20] RENDERING with data: localId=1000009742, pathUri=content://media/external/images/media/1000009742
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 21
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[21] RENDERING with data: localId=1000009741, pathUri=content://media/external/images/media/1000009741
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 22
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[22] RENDERING with data: localId=1000009740, pathUri=content://media/external/images/media/1000009740
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 23
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[23] RENDERING with data: localId=1000009739, pathUri=content://media/external/images/media/1000009739
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 24
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[24] RENDERING with data: localId=1000009738, pathUri=content://media/external/images/media/1000009738
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 25
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[25] RENDERING with data: localId=1000009736, pathUri=content://media/external/images/media/1000009736
2025-08-12 21:16:39.601 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 26
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[26] RENDERING with data: localId=1000009725, pathUri=content://media/external/images/media/1000009725
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 27
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[27] RENDERING with data: localId=1000009724, pathUri=content://media/external/images/media/1000009724
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 28
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[28] RENDERING with data: localId=1000009723, pathUri=content://media/external/images/media/1000009723
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 29
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[29] RENDERING with data: localId=1000009722, pathUri=content://media/external/images/media/1000009722
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 30
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[30] RENDERING with data: localId=1000009721, pathUri=content://media/external/images/media/1000009721
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 31
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[31] RENDERING with data: localId=1000009720, pathUri=content://media/external/images/media/1000009720
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 33
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[33] RENDERING with data: localId=1000009605, pathUri=content://media/external/images/media/1000009605
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 34
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[34] RENDERING with data: localId=1000009604, pathUri=content://media/external/images/media/1000009604
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 36
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[36] RENDERING with data: localId=1000009544, pathUri=content://media/external/images/media/1000009544
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 37
2025-08-12 21:16:39.602 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[37] RENDERING with data: localId=1000009538, pathUri=content://media/external/images/media/1000009538
2025-08-12 21:16:39.603 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:39.603 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 38
2025-08-12 21:16:39.603 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[38] RENDERING with data: localId=1000009532, pathUri=content://media/external/images/media/1000009532
2025-08-12 21:16:39.609 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:39.669 23853-23853 JobService              com.akslabs.cloudgallery             W  onNetworkChanged() not implemented in androidx.work.impl.background.systemjob.SystemJobService. Must override in a subclass.
2025-08-12 21:16:39.670 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:39.670 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:39.670 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:39.670 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:39.670 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:39.670 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:39.670 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:39.670 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:39.670 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:39.670 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:39.670 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:39.670 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:39.670 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:39.670 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:39.670 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:39.670 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:39.670 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:39.670 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:39.714 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:39.723 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:39.723 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:39.723 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:39.731 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:39.860 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:39.860 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:39.860 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:39.860 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:39.860 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:39.860 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:39.861 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:39.861 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:39.861 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:39.861 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:39.861 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:39.861 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:39.861 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:39.861 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:39.861 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:39.861 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:39.861 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:39.861 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:39.867 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:39.888 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:39.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:39.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:39.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:39.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:39.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:39.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:39.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:39.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:39.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:39.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:39.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:39.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:39.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:39.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:39.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:39.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:39.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:39.927 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:39.999 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:39.999 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:40.000 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:40.007 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:40.289 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:40.289 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:40.289 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:40.289 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:40.289 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:40.289 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:40.289 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:40.289 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:40.289 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:40.289 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:40.289 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:40.289 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:40.289 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:40.289 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:40.289 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:40.289 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:40.289 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:40.289 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:40.292 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.292 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 1
2025-08-12 21:16:40.292 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[1] RENDERING with data: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:40.292 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.292 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 2
2025-08-12 21:16:40.292 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[2] RENDERING with data: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:40.292 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.292 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 3
2025-08-12 21:16:40.292 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[3] RENDERING with data: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:40.292 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.292 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 4
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[4] RENDERING with data: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 5
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[5] RENDERING with data: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 6
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[6] RENDERING with data: localId=1000009756, pathUri=content://media/external/images/media/1000009756
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 7
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[7] RENDERING with data: localId=1000009755, pathUri=content://media/external/images/media/1000009755
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 8
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[8] RENDERING with data: localId=1000009754, pathUri=content://media/external/images/media/1000009754
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 9
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[9] RENDERING with data: localId=1000009753, pathUri=content://media/external/images/media/1000009753
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 10
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[10] RENDERING with data: localId=1000009752, pathUri=content://media/external/images/media/1000009752
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 11
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[11] RENDERING with data: localId=1000009751, pathUri=content://media/external/images/media/1000009751
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 12
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[12] RENDERING with data: localId=1000009750, pathUri=content://media/external/images/media/1000009750
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 13
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[13] RENDERING with data: localId=1000009749, pathUri=content://media/external/images/media/1000009749
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 14
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[14] RENDERING with data: localId=1000009748, pathUri=content://media/external/images/media/1000009748
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 15
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[15] RENDERING with data: localId=1000009747, pathUri=content://media/external/images/media/1000009747
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.293 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 16
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[16] RENDERING with data: localId=1000009746, pathUri=content://media/external/images/media/1000009746
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 17
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[17] RENDERING with data: localId=1000009745, pathUri=content://media/external/images/media/1000009745
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 18
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[18] RENDERING with data: localId=1000009744, pathUri=content://media/external/images/media/1000009744
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 19
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[19] RENDERING with data: localId=1000009743, pathUri=content://media/external/images/media/1000009743
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 20
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[20] RENDERING with data: localId=1000009742, pathUri=content://media/external/images/media/1000009742
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 21
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[21] RENDERING with data: localId=1000009741, pathUri=content://media/external/images/media/1000009741
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 22
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[22] RENDERING with data: localId=1000009740, pathUri=content://media/external/images/media/1000009740
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 23
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[23] RENDERING with data: localId=1000009739, pathUri=content://media/external/images/media/1000009739
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 24
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[24] RENDERING with data: localId=1000009738, pathUri=content://media/external/images/media/1000009738
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 25
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[25] RENDERING with data: localId=1000009736, pathUri=content://media/external/images/media/1000009736
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 26
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[26] RENDERING with data: localId=1000009725, pathUri=content://media/external/images/media/1000009725
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 27
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[27] RENDERING with data: localId=1000009724, pathUri=content://media/external/images/media/1000009724
2025-08-12 21:16:40.294 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.295 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 28
2025-08-12 21:16:40.295 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[28] RENDERING with data: localId=1000009723, pathUri=content://media/external/images/media/1000009723
2025-08-12 21:16:40.295 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.295 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 29
2025-08-12 21:16:40.295 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[29] RENDERING with data: localId=1000009722, pathUri=content://media/external/images/media/1000009722
2025-08-12 21:16:40.295 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.295 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 30
2025-08-12 21:16:40.295 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[30] RENDERING with data: localId=1000009721, pathUri=content://media/external/images/media/1000009721
2025-08-12 21:16:40.295 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.295 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 31
2025-08-12 21:16:40.295 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[31] RENDERING with data: localId=1000009720, pathUri=content://media/external/images/media/1000009720
2025-08-12 21:16:40.295 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.295 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 33
2025-08-12 21:16:40.295 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[33] RENDERING with data: localId=1000009605, pathUri=content://media/external/images/media/1000009605
2025-08-12 21:16:40.295 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.295 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 34
2025-08-12 21:16:40.295 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[34] RENDERING with data: localId=1000009604, pathUri=content://media/external/images/media/1000009604
2025-08-12 21:16:40.295 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.295 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 36
2025-08-12 21:16:40.295 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[36] RENDERING with data: localId=1000009544, pathUri=content://media/external/images/media/1000009544
2025-08-12 21:16:40.295 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.295 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 37
2025-08-12 21:16:40.295 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[37] RENDERING with data: localId=1000009538, pathUri=content://media/external/images/media/1000009538
2025-08-12 21:16:40.295 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.295 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 38
2025-08-12 21:16:40.295 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[38] RENDERING with data: localId=1000009532, pathUri=content://media/external/images/media/1000009532
2025-08-12 21:16:40.302 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:40.353 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:40.353 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:40.353 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:40.353 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:40.353 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:40.353 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:40.353 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:40.353 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:40.353 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:40.353 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:40.353 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:40.353 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:40.353 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:40.353 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:40.353 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:40.354 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:40.354 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:40.354 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:40.392 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:40.401 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:40.401 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:40.402 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:40.409 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:40.545 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:40.545 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:40.545 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:40.545 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:40.545 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:40.545 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:40.545 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:40.545 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:40.545 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:40.545 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:40.545 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:40.545 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:40.545 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:40.545 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:40.545 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:40.545 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:40.545 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:40.545 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:40.551 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:40.572 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:40.573 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:40.573 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:40.573 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:40.573 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:40.573 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:40.573 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:40.573 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:40.573 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:40.573 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:40.573 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:40.573 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:40.573 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:40.573 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:40.573 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:40.573 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:40.573 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:40.573 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:40.611 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:40.683 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:40.683 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:40.683 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:40.690 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:40.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:40.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:40.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:40.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:40.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:40.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:40.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:40.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:40.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:40.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:40.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:40.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:40.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:40.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:40.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:40.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:40.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:40.971 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:40.974 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.974 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 1
2025-08-12 21:16:40.974 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[1] RENDERING with data: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:40.974 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.974 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 2
2025-08-12 21:16:40.974 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[2] RENDERING with data: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:40.974 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.974 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 3
2025-08-12 21:16:40.974 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[3] RENDERING with data: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:40.974 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.974 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 4
2025-08-12 21:16:40.974 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[4] RENDERING with data: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 5
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[5] RENDERING with data: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 6
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[6] RENDERING with data: localId=1000009756, pathUri=content://media/external/images/media/1000009756
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 7
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[7] RENDERING with data: localId=1000009755, pathUri=content://media/external/images/media/1000009755
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 8
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[8] RENDERING with data: localId=1000009754, pathUri=content://media/external/images/media/1000009754
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 9
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[9] RENDERING with data: localId=1000009753, pathUri=content://media/external/images/media/1000009753
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 10
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[10] RENDERING with data: localId=1000009752, pathUri=content://media/external/images/media/1000009752
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 11
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[11] RENDERING with data: localId=1000009751, pathUri=content://media/external/images/media/1000009751
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 12
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[12] RENDERING with data: localId=1000009750, pathUri=content://media/external/images/media/1000009750
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 13
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[13] RENDERING with data: localId=1000009749, pathUri=content://media/external/images/media/1000009749
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 14
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[14] RENDERING with data: localId=1000009748, pathUri=content://media/external/images/media/1000009748
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 15
2025-08-12 21:16:40.975 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[15] RENDERING with data: localId=1000009747, pathUri=content://media/external/images/media/1000009747
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 16
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[16] RENDERING with data: localId=1000009746, pathUri=content://media/external/images/media/1000009746
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 17
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[17] RENDERING with data: localId=1000009745, pathUri=content://media/external/images/media/1000009745
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 18
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[18] RENDERING with data: localId=1000009744, pathUri=content://media/external/images/media/1000009744
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 19
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[19] RENDERING with data: localId=1000009743, pathUri=content://media/external/images/media/1000009743
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 20
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[20] RENDERING with data: localId=1000009742, pathUri=content://media/external/images/media/1000009742
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 21
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[21] RENDERING with data: localId=1000009741, pathUri=content://media/external/images/media/1000009741
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 22
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[22] RENDERING with data: localId=1000009740, pathUri=content://media/external/images/media/1000009740
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 23
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[23] RENDERING with data: localId=1000009739, pathUri=content://media/external/images/media/1000009739
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 24
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[24] RENDERING with data: localId=1000009738, pathUri=content://media/external/images/media/1000009738
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 25
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[25] RENDERING with data: localId=1000009736, pathUri=content://media/external/images/media/1000009736
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.976 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 26
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[26] RENDERING with data: localId=1000009725, pathUri=content://media/external/images/media/1000009725
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 27
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[27] RENDERING with data: localId=1000009724, pathUri=content://media/external/images/media/1000009724
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 28
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[28] RENDERING with data: localId=1000009723, pathUri=content://media/external/images/media/1000009723
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 29
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[29] RENDERING with data: localId=1000009722, pathUri=content://media/external/images/media/1000009722
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 30
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[30] RENDERING with data: localId=1000009721, pathUri=content://media/external/images/media/1000009721
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 31
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[31] RENDERING with data: localId=1000009720, pathUri=content://media/external/images/media/1000009720
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 33
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[33] RENDERING with data: localId=1000009605, pathUri=content://media/external/images/media/1000009605
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 34
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[34] RENDERING with data: localId=1000009604, pathUri=content://media/external/images/media/1000009604
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 36
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[36] RENDERING with data: localId=1000009544, pathUri=content://media/external/images/media/1000009544
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 37
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[37] RENDERING with data: localId=1000009538, pathUri=content://media/external/images/media/1000009538
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 38
2025-08-12 21:16:40.977 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[38] RENDERING with data: localId=1000009532, pathUri=content://media/external/images/media/1000009532
2025-08-12 21:16:40.984 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:41.038 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:41.038 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:41.038 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:41.038 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:41.038 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:41.038 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:41.038 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:41.038 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:41.039 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:41.039 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:41.039 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:41.039 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:41.039 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:41.039 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:41.039 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:41.039 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:41.039 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:41.039 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:41.076 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:41.085 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:41.085 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:41.085 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:41.093 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:41.217 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:41.217 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:41.217 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:41.217 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:41.217 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:41.217 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:41.217 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:41.217 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:41.217 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:41.217 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:41.217 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:41.217 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:41.217 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:41.217 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:41.217 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:41.217 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:41.217 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:41.217 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:41.224 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:41.243 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:41.244 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:41.244 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:41.244 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:41.244 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:41.244 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:41.244 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:41.244 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:41.244 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:41.244 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:41.244 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:41.244 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:41.244 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:41.244 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:41.244 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:41.244 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:41.244 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:41.244 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:41.282 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:41.354 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:41.354 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:41.354 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:41.361 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:41.630 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:41.630 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:41.630 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:41.630 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:41.630 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:41.630 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:41.630 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:41.630 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:41.630 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:41.630 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:41.630 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:41.630 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:41.630 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:41.630 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:41.630 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:41.630 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:41.630 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:41.630 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:41.633 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.633 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 1
2025-08-12 21:16:41.633 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[1] RENDERING with data: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:41.633 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.633 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 2
2025-08-12 21:16:41.633 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[2] RENDERING with data: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:41.633 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.633 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 3
2025-08-12 21:16:41.633 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[3] RENDERING with data: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:41.633 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 4
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[4] RENDERING with data: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 5
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[5] RENDERING with data: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 6
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[6] RENDERING with data: localId=1000009756, pathUri=content://media/external/images/media/1000009756
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 7
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[7] RENDERING with data: localId=1000009755, pathUri=content://media/external/images/media/1000009755
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 8
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[8] RENDERING with data: localId=1000009754, pathUri=content://media/external/images/media/1000009754
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 9
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[9] RENDERING with data: localId=1000009753, pathUri=content://media/external/images/media/1000009753
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 10
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[10] RENDERING with data: localId=1000009752, pathUri=content://media/external/images/media/1000009752
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 11
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[11] RENDERING with data: localId=1000009751, pathUri=content://media/external/images/media/1000009751
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 12
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[12] RENDERING with data: localId=1000009750, pathUri=content://media/external/images/media/1000009750
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 13
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[13] RENDERING with data: localId=1000009749, pathUri=content://media/external/images/media/1000009749
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.634 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 14
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[14] RENDERING with data: localId=1000009748, pathUri=content://media/external/images/media/1000009748
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 15
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[15] RENDERING with data: localId=1000009747, pathUri=content://media/external/images/media/1000009747
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 16
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[16] RENDERING with data: localId=1000009746, pathUri=content://media/external/images/media/1000009746
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 17
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[17] RENDERING with data: localId=1000009745, pathUri=content://media/external/images/media/1000009745
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 18
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[18] RENDERING with data: localId=1000009744, pathUri=content://media/external/images/media/1000009744
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 19
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[19] RENDERING with data: localId=1000009743, pathUri=content://media/external/images/media/1000009743
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 20
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[20] RENDERING with data: localId=1000009742, pathUri=content://media/external/images/media/1000009742
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 21
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[21] RENDERING with data: localId=1000009741, pathUri=content://media/external/images/media/1000009741
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 22
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[22] RENDERING with data: localId=1000009740, pathUri=content://media/external/images/media/1000009740
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 23
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[23] RENDERING with data: localId=1000009739, pathUri=content://media/external/images/media/1000009739
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 24
2025-08-12 21:16:41.635 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[24] RENDERING with data: localId=1000009738, pathUri=content://media/external/images/media/1000009738
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 25
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[25] RENDERING with data: localId=1000009736, pathUri=content://media/external/images/media/1000009736
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 26
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[26] RENDERING with data: localId=1000009725, pathUri=content://media/external/images/media/1000009725
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 27
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[27] RENDERING with data: localId=1000009724, pathUri=content://media/external/images/media/1000009724
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 28
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[28] RENDERING with data: localId=1000009723, pathUri=content://media/external/images/media/1000009723
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 29
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[29] RENDERING with data: localId=1000009722, pathUri=content://media/external/images/media/1000009722
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 30
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[30] RENDERING with data: localId=1000009721, pathUri=content://media/external/images/media/1000009721
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 31
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[31] RENDERING with data: localId=1000009720, pathUri=content://media/external/images/media/1000009720
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 33
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[33] RENDERING with data: localId=1000009605, pathUri=content://media/external/images/media/1000009605
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 34
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[34] RENDERING with data: localId=1000009604, pathUri=content://media/external/images/media/1000009604
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 36
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[36] RENDERING with data: localId=1000009544, pathUri=content://media/external/images/media/1000009544
2025-08-12 21:16:41.636 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.637 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 37
2025-08-12 21:16:41.637 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[37] RENDERING with data: localId=1000009538, pathUri=content://media/external/images/media/1000009538
2025-08-12 21:16:41.637 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:41.637 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 38
2025-08-12 21:16:41.637 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[38] RENDERING with data: localId=1000009532, pathUri=content://media/external/images/media/1000009532
2025-08-12 21:16:41.644 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:41.688 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:41.688 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:41.688 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:41.688 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:41.688 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:41.688 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:41.688 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:41.688 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:41.688 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:41.688 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:41.688 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:41.688 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:41.688 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:41.688 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:41.688 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:41.688 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:41.688 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:41.688 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:41.727 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:41.736 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:41.736 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:41.736 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:41.743 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:41.870 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:41.870 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:41.870 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:41.870 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:41.870 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:41.870 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:41.870 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:41.870 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:41.870 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:41.870 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:41.870 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:41.870 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:41.870 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:41.870 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:41.870 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:41.870 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:41.870 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:41.870 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:41.876 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:41.895 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:41.895 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:41.895 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:41.895 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:41.895 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:41.895 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:41.895 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:41.895 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:41.895 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:41.895 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:41.895 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:41.895 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:41.895 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:41.895 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:41.895 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:41.895 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:41.895 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:41.895 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:41.932 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:42.003 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:42.003 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:42.003 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:42.009 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:42.261 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:42.261 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:42.261 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:42.261 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:42.261 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:42.261 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:42.261 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:42.261 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:42.261 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:42.261 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:42.261 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:42.261 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:42.261 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:42.261 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:42.262 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:42.262 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:42.262 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:42.262 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:42.264 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.264 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 1
2025-08-12 21:16:42.264 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[1] RENDERING with data: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:42.264 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.264 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 2
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[2] RENDERING with data: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 3
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[3] RENDERING with data: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 4
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[4] RENDERING with data: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 5
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[5] RENDERING with data: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 6
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[6] RENDERING with data: localId=1000009756, pathUri=content://media/external/images/media/1000009756
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 7
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[7] RENDERING with data: localId=1000009755, pathUri=content://media/external/images/media/1000009755
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 8
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[8] RENDERING with data: localId=1000009754, pathUri=content://media/external/images/media/1000009754
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 9
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[9] RENDERING with data: localId=1000009753, pathUri=content://media/external/images/media/1000009753
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 10
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[10] RENDERING with data: localId=1000009752, pathUri=content://media/external/images/media/1000009752
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 11
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[11] RENDERING with data: localId=1000009751, pathUri=content://media/external/images/media/1000009751
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 12
2025-08-12 21:16:42.265 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[12] RENDERING with data: localId=1000009750, pathUri=content://media/external/images/media/1000009750
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 13
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[13] RENDERING with data: localId=1000009749, pathUri=content://media/external/images/media/1000009749
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 14
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[14] RENDERING with data: localId=1000009748, pathUri=content://media/external/images/media/1000009748
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 15
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[15] RENDERING with data: localId=1000009747, pathUri=content://media/external/images/media/1000009747
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 16
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[16] RENDERING with data: localId=1000009746, pathUri=content://media/external/images/media/1000009746
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 17
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[17] RENDERING with data: localId=1000009745, pathUri=content://media/external/images/media/1000009745
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 18
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[18] RENDERING with data: localId=1000009744, pathUri=content://media/external/images/media/1000009744
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 19
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[19] RENDERING with data: localId=1000009743, pathUri=content://media/external/images/media/1000009743
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 20
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[20] RENDERING with data: localId=1000009742, pathUri=content://media/external/images/media/1000009742
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 21
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[21] RENDERING with data: localId=1000009741, pathUri=content://media/external/images/media/1000009741
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 22
2025-08-12 21:16:42.266 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[22] RENDERING with data: localId=1000009740, pathUri=content://media/external/images/media/1000009740
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 23
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[23] RENDERING with data: localId=1000009739, pathUri=content://media/external/images/media/1000009739
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 24
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[24] RENDERING with data: localId=1000009738, pathUri=content://media/external/images/media/1000009738
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 25
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[25] RENDERING with data: localId=1000009736, pathUri=content://media/external/images/media/1000009736
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 26
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[26] RENDERING with data: localId=1000009725, pathUri=content://media/external/images/media/1000009725
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 27
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[27] RENDERING with data: localId=1000009724, pathUri=content://media/external/images/media/1000009724
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 28
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[28] RENDERING with data: localId=1000009723, pathUri=content://media/external/images/media/1000009723
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 29
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[29] RENDERING with data: localId=1000009722, pathUri=content://media/external/images/media/1000009722
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 30
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[30] RENDERING with data: localId=1000009721, pathUri=content://media/external/images/media/1000009721
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 31
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[31] RENDERING with data: localId=1000009720, pathUri=content://media/external/images/media/1000009720
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 33
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[33] RENDERING with data: localId=1000009605, pathUri=content://media/external/images/media/1000009605
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 34
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[34] RENDERING with data: localId=1000009604, pathUri=content://media/external/images/media/1000009604
2025-08-12 21:16:42.267 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.268 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 36
2025-08-12 21:16:42.268 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[36] RENDERING with data: localId=1000009544, pathUri=content://media/external/images/media/1000009544
2025-08-12 21:16:42.268 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.268 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 37
2025-08-12 21:16:42.268 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[37] RENDERING with data: localId=1000009538, pathUri=content://media/external/images/media/1000009538
2025-08-12 21:16:42.268 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.268 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 38
2025-08-12 21:16:42.268 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[38] RENDERING with data: localId=1000009532, pathUri=content://media/external/images/media/1000009532
2025-08-12 21:16:42.274 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:42.318 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:42.318 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:42.318 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:42.318 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:42.318 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:42.319 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:42.319 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:42.319 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:42.319 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:42.319 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:42.319 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:42.319 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:42.319 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:42.319 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:42.319 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:42.319 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:42.319 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:42.319 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:42.356 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:42.364 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:42.364 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:42.364 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:42.371 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:42.474 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:42.474 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:42.474 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:42.474 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:42.474 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:42.474 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:42.474 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:42.474 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:42.474 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:42.474 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:42.474 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:42.474 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:42.474 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:42.474 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:42.474 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:42.474 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:42.474 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:42.474 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:42.480 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:42.499 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:42.499 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:42.499 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:42.499 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:42.499 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:42.499 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:42.499 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:42.499 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:42.499 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:42.499 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:42.499 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:42.499 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:42.499 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:42.499 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:42.499 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:42.499 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:42.499 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:42.499 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:42.537 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:42.608 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:42.608 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:42.608 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:42.614 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:42.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:42.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:42.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:42.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:42.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:42.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:42.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:42.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:42.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:42.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:42.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:42.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:42.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:42.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:42.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:42.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:42.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:42.885 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:42.888 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.888 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 1
2025-08-12 21:16:42.888 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[1] RENDERING with data: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:42.888 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.888 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 2
2025-08-12 21:16:42.888 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[2] RENDERING with data: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:42.888 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.888 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 3
2025-08-12 21:16:42.888 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[3] RENDERING with data: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:42.888 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.888 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 4
2025-08-12 21:16:42.888 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[4] RENDERING with data: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:42.888 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.888 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 5
2025-08-12 21:16:42.888 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[5] RENDERING with data: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:42.888 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.888 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 6
2025-08-12 21:16:42.888 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[6] RENDERING with data: localId=1000009756, pathUri=content://media/external/images/media/1000009756
2025-08-12 21:16:42.888 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.888 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 7
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[7] RENDERING with data: localId=1000009755, pathUri=content://media/external/images/media/1000009755
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 8
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[8] RENDERING with data: localId=1000009754, pathUri=content://media/external/images/media/1000009754
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 9
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[9] RENDERING with data: localId=1000009753, pathUri=content://media/external/images/media/1000009753
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 10
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[10] RENDERING with data: localId=1000009752, pathUri=content://media/external/images/media/1000009752
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 11
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[11] RENDERING with data: localId=1000009751, pathUri=content://media/external/images/media/1000009751
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 12
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[12] RENDERING with data: localId=1000009750, pathUri=content://media/external/images/media/1000009750
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 13
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[13] RENDERING with data: localId=1000009749, pathUri=content://media/external/images/media/1000009749
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 14
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[14] RENDERING with data: localId=1000009748, pathUri=content://media/external/images/media/1000009748
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 15
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[15] RENDERING with data: localId=1000009747, pathUri=content://media/external/images/media/1000009747
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 16
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[16] RENDERING with data: localId=1000009746, pathUri=content://media/external/images/media/1000009746
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 17
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[17] RENDERING with data: localId=1000009745, pathUri=content://media/external/images/media/1000009745
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 18
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[18] RENDERING with data: localId=1000009744, pathUri=content://media/external/images/media/1000009744
2025-08-12 21:16:42.889 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 19
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[19] RENDERING with data: localId=1000009743, pathUri=content://media/external/images/media/1000009743
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 20
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[20] RENDERING with data: localId=1000009742, pathUri=content://media/external/images/media/1000009742
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 21
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[21] RENDERING with data: localId=1000009741, pathUri=content://media/external/images/media/1000009741
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 22
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[22] RENDERING with data: localId=1000009740, pathUri=content://media/external/images/media/1000009740
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 23
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[23] RENDERING with data: localId=1000009739, pathUri=content://media/external/images/media/1000009739
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 24
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[24] RENDERING with data: localId=1000009738, pathUri=content://media/external/images/media/1000009738
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 25
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[25] RENDERING with data: localId=1000009736, pathUri=content://media/external/images/media/1000009736
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 26
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[26] RENDERING with data: localId=1000009725, pathUri=content://media/external/images/media/1000009725
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 27
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[27] RENDERING with data: localId=1000009724, pathUri=content://media/external/images/media/1000009724
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 28
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[28] RENDERING with data: localId=1000009723, pathUri=content://media/external/images/media/1000009723
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.890 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 29
2025-08-12 21:16:42.891 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[29] RENDERING with data: localId=1000009722, pathUri=content://media/external/images/media/1000009722
2025-08-12 21:16:42.891 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.891 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 30
2025-08-12 21:16:42.891 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[30] RENDERING with data: localId=1000009721, pathUri=content://media/external/images/media/1000009721
2025-08-12 21:16:42.891 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.891 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 31
2025-08-12 21:16:42.891 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[31] RENDERING with data: localId=1000009720, pathUri=content://media/external/images/media/1000009720
2025-08-12 21:16:42.891 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.891 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 33
2025-08-12 21:16:42.891 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[33] RENDERING with data: localId=1000009605, pathUri=content://media/external/images/media/1000009605
2025-08-12 21:16:42.891 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.891 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 34
2025-08-12 21:16:42.891 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[34] RENDERING with data: localId=1000009604, pathUri=content://media/external/images/media/1000009604
2025-08-12 21:16:42.891 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.891 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 36
2025-08-12 21:16:42.891 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[36] RENDERING with data: localId=1000009544, pathUri=content://media/external/images/media/1000009544
2025-08-12 21:16:42.891 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.891 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 37
2025-08-12 21:16:42.891 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[37] RENDERING with data: localId=1000009538, pathUri=content://media/external/images/media/1000009538
2025-08-12 21:16:42.891 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:42.891 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 38
2025-08-12 21:16:42.891 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[38] RENDERING with data: localId=1000009532, pathUri=content://media/external/images/media/1000009532
2025-08-12 21:16:42.898 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:42.941 23853-23853 JobService              com.akslabs.cloudgallery             W  onNetworkChanged() not implemented in androidx.work.impl.background.systemjob.SystemJobService. Must override in a subclass.
2025-08-12 21:16:42.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:42.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:42.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:42.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:42.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:42.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:42.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:42.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:42.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:42.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:42.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:42.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:42.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:42.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:42.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:42.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:42.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:42.946 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:42.984 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:42.992 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:42.992 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:42.993 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:43.000 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:43.111 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:43.111 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:43.112 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:43.112 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:43.112 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:43.112 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:43.112 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:43.112 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:43.112 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:43.112 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:43.112 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:43.112 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:43.112 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:43.112 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:43.112 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:43.112 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:43.112 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:43.112 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:43.118 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:43.137 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:43.137 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:43.137 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:43.137 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:43.137 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:43.137 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:43.137 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:43.137 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:43.137 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:43.137 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:43.137 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:43.137 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:43.137 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:43.137 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:43.137 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:43.137 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:43.137 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:43.137 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:43.176 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:43.248 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:43.248 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:43.248 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:43.255 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:43.511 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:43.511 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:43.511 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:43.511 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:43.511 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:43.511 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:43.511 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:43.511 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:43.511 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:43.511 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:43.511 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:43.511 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:43.511 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:43.511 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:43.511 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:43.511 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:43.511 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:43.511 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:43.514 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.514 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 1
2025-08-12 21:16:43.514 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[1] RENDERING with data: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:43.514 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.514 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 2
2025-08-12 21:16:43.514 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[2] RENDERING with data: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:43.514 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.514 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 3
2025-08-12 21:16:43.514 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[3] RENDERING with data: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:43.514 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.514 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 4
2025-08-12 21:16:43.514 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[4] RENDERING with data: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 5
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[5] RENDERING with data: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 6
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[6] RENDERING with data: localId=1000009756, pathUri=content://media/external/images/media/1000009756
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 7
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[7] RENDERING with data: localId=1000009755, pathUri=content://media/external/images/media/1000009755
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 8
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[8] RENDERING with data: localId=1000009754, pathUri=content://media/external/images/media/1000009754
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 9
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[9] RENDERING with data: localId=1000009753, pathUri=content://media/external/images/media/1000009753
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 10
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[10] RENDERING with data: localId=1000009752, pathUri=content://media/external/images/media/1000009752
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 11
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[11] RENDERING with data: localId=1000009751, pathUri=content://media/external/images/media/1000009751
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 12
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[12] RENDERING with data: localId=1000009750, pathUri=content://media/external/images/media/1000009750
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 13
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[13] RENDERING with data: localId=1000009749, pathUri=content://media/external/images/media/1000009749
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 14
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[14] RENDERING with data: localId=1000009748, pathUri=content://media/external/images/media/1000009748
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 15
2025-08-12 21:16:43.515 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[15] RENDERING with data: localId=1000009747, pathUri=content://media/external/images/media/1000009747
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 16
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[16] RENDERING with data: localId=1000009746, pathUri=content://media/external/images/media/1000009746
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 17
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[17] RENDERING with data: localId=1000009745, pathUri=content://media/external/images/media/1000009745
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 18
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[18] RENDERING with data: localId=1000009744, pathUri=content://media/external/images/media/1000009744
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 19
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[19] RENDERING with data: localId=1000009743, pathUri=content://media/external/images/media/1000009743
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 20
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[20] RENDERING with data: localId=1000009742, pathUri=content://media/external/images/media/1000009742
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 21
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[21] RENDERING with data: localId=1000009741, pathUri=content://media/external/images/media/1000009741
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 22
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[22] RENDERING with data: localId=1000009740, pathUri=content://media/external/images/media/1000009740
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 23
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[23] RENDERING with data: localId=1000009739, pathUri=content://media/external/images/media/1000009739
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 24
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[24] RENDERING with data: localId=1000009738, pathUri=content://media/external/images/media/1000009738
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 25
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[25] RENDERING with data: localId=1000009736, pathUri=content://media/external/images/media/1000009736
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 26
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[26] RENDERING with data: localId=1000009725, pathUri=content://media/external/images/media/1000009725
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 27
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[27] RENDERING with data: localId=1000009724, pathUri=content://media/external/images/media/1000009724
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.516 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 28
2025-08-12 21:16:43.517 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[28] RENDERING with data: localId=1000009723, pathUri=content://media/external/images/media/1000009723
2025-08-12 21:16:43.517 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.517 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 29
2025-08-12 21:16:43.517 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[29] RENDERING with data: localId=1000009722, pathUri=content://media/external/images/media/1000009722
2025-08-12 21:16:43.517 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.517 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 30
2025-08-12 21:16:43.517 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[30] RENDERING with data: localId=1000009721, pathUri=content://media/external/images/media/1000009721
2025-08-12 21:16:43.517 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.517 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 31
2025-08-12 21:16:43.517 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[31] RENDERING with data: localId=1000009720, pathUri=content://media/external/images/media/1000009720
2025-08-12 21:16:43.517 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.517 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 33
2025-08-12 21:16:43.517 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[33] RENDERING with data: localId=1000009605, pathUri=content://media/external/images/media/1000009605
2025-08-12 21:16:43.517 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.517 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 34
2025-08-12 21:16:43.517 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[34] RENDERING with data: localId=1000009604, pathUri=content://media/external/images/media/1000009604
2025-08-12 21:16:43.517 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.517 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 36
2025-08-12 21:16:43.517 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[36] RENDERING with data: localId=1000009544, pathUri=content://media/external/images/media/1000009544
2025-08-12 21:16:43.517 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.517 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 37
2025-08-12 21:16:43.517 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[37] RENDERING with data: localId=1000009538, pathUri=content://media/external/images/media/1000009538
2025-08-12 21:16:43.517 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:43.517 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 38
2025-08-12 21:16:43.517 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[38] RENDERING with data: localId=1000009532, pathUri=content://media/external/images/media/1000009532
2025-08-12 21:16:43.523 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:43.575 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:43.575 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:43.575 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:43.575 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:43.575 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:43.575 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:43.575 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:43.575 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:43.575 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:43.575 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:43.575 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:43.575 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:43.575 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:43.575 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:43.575 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:43.575 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:43.575 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:43.575 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:43.613 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:43.622 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:43.622 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:43.622 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:43.629 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:43.751 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:43.751 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:43.752 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:43.752 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:43.752 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:43.752 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:43.752 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:43.752 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:43.752 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:43.752 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:43.752 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:43.752 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:43.752 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:43.752 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:43.752 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:43.752 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:43.752 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:43.752 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:43.758 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:43.777 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:43.777 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:43.777 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:43.777 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:43.777 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:43.777 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:43.777 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:43.777 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:43.777 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:43.777 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:43.777 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:43.777 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:43.777 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:43.777 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:43.777 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:43.777 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:43.777 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:43.777 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:43.816 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:43.886 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:43.886 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:43.886 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:43.892 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:44.153 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:44.153 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:44.153 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:44.153 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:44.153 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:44.153 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:44.153 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:44.153 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:44.153 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:44.153 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:44.153 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:44.153 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:44.153 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:44.153 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:44.153 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:44.153 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:44.153 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:44.153 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:44.156 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.156 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 1
2025-08-12 21:16:44.156 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[1] RENDERING with data: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:44.156 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.156 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 2
2025-08-12 21:16:44.156 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[2] RENDERING with data: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:44.156 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.156 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 3
2025-08-12 21:16:44.156 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[3] RENDERING with data: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:44.156 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.156 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 4
2025-08-12 21:16:44.156 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[4] RENDERING with data: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:44.156 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.156 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 5
2025-08-12 21:16:44.156 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[5] RENDERING with data: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:44.156 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.156 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 6
2025-08-12 21:16:44.156 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[6] RENDERING with data: localId=1000009756, pathUri=content://media/external/images/media/1000009756
2025-08-12 21:16:44.156 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.156 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 7
2025-08-12 21:16:44.156 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[7] RENDERING with data: localId=1000009755, pathUri=content://media/external/images/media/1000009755
2025-08-12 21:16:44.156 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.156 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 8
2025-08-12 21:16:44.156 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[8] RENDERING with data: localId=1000009754, pathUri=content://media/external/images/media/1000009754
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 9
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[9] RENDERING with data: localId=1000009753, pathUri=content://media/external/images/media/1000009753
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 10
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[10] RENDERING with data: localId=1000009752, pathUri=content://media/external/images/media/1000009752
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 11
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[11] RENDERING with data: localId=1000009751, pathUri=content://media/external/images/media/1000009751
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 12
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[12] RENDERING with data: localId=1000009750, pathUri=content://media/external/images/media/1000009750
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 13
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[13] RENDERING with data: localId=1000009749, pathUri=content://media/external/images/media/1000009749
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 14
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[14] RENDERING with data: localId=1000009748, pathUri=content://media/external/images/media/1000009748
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 15
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[15] RENDERING with data: localId=1000009747, pathUri=content://media/external/images/media/1000009747
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 16
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[16] RENDERING with data: localId=1000009746, pathUri=content://media/external/images/media/1000009746
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 17
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[17] RENDERING with data: localId=1000009745, pathUri=content://media/external/images/media/1000009745
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 18
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[18] RENDERING with data: localId=1000009744, pathUri=content://media/external/images/media/1000009744
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 19
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[19] RENDERING with data: localId=1000009743, pathUri=content://media/external/images/media/1000009743
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 20
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[20] RENDERING with data: localId=1000009742, pathUri=content://media/external/images/media/1000009742
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 21
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[21] RENDERING with data: localId=1000009741, pathUri=content://media/external/images/media/1000009741
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.157 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 22
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[22] RENDERING with data: localId=1000009740, pathUri=content://media/external/images/media/1000009740
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 23
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[23] RENDERING with data: localId=1000009739, pathUri=content://media/external/images/media/1000009739
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 24
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[24] RENDERING with data: localId=1000009738, pathUri=content://media/external/images/media/1000009738
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 25
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[25] RENDERING with data: localId=1000009736, pathUri=content://media/external/images/media/1000009736
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 26
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[26] RENDERING with data: localId=1000009725, pathUri=content://media/external/images/media/1000009725
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 27
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[27] RENDERING with data: localId=1000009724, pathUri=content://media/external/images/media/1000009724
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 28
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[28] RENDERING with data: localId=1000009723, pathUri=content://media/external/images/media/1000009723
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 29
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[29] RENDERING with data: localId=1000009722, pathUri=content://media/external/images/media/1000009722
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 30
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[30] RENDERING with data: localId=1000009721, pathUri=content://media/external/images/media/1000009721
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 31
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[31] RENDERING with data: localId=1000009720, pathUri=content://media/external/images/media/1000009720
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 33
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[33] RENDERING with data: localId=1000009605, pathUri=content://media/external/images/media/1000009605
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 34
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[34] RENDERING with data: localId=1000009604, pathUri=content://media/external/images/media/1000009604
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 36
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[36] RENDERING with data: localId=1000009544, pathUri=content://media/external/images/media/1000009544
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 37
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[37] RENDERING with data: localId=1000009538, pathUri=content://media/external/images/media/1000009538
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 38
2025-08-12 21:16:44.158 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[38] RENDERING with data: localId=1000009532, pathUri=content://media/external/images/media/1000009532
2025-08-12 21:16:44.166 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:44.212 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:44.212 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:44.213 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:44.213 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:44.213 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:44.213 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:44.213 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:44.213 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:44.213 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:44.213 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:44.213 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:44.213 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:44.213 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:44.213 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:44.213 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:44.213 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:44.213 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:44.213 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:44.251 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:44.259 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:44.259 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:44.259 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:44.266 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:44.379 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:44.379 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:44.379 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:44.379 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:44.379 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:44.379 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:44.379 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:44.379 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:44.379 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:44.379 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:44.379 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:44.379 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:44.379 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:44.379 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:44.380 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:44.380 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:44.380 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:44.380 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:44.386 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:44.406 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:44.406 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:44.406 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:44.406 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:44.406 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:44.406 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:44.406 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:44.406 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:44.406 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:44.406 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:44.406 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:44.406 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:44.406 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:44.406 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:44.406 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:44.406 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:44.406 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:44.406 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:44.449 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:44.519 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:44.519 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:44.519 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:44.525 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:44.783 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:44.783 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:44.783 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:44.783 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:44.783 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:44.783 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-12 21:16:44.783 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:44.783 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:44.783 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:44.783 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:44.783 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:44.784 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:44.784 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:44.784 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:44.784 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:44.784 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:44.784 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:44.784 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:44.786 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.786 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 1
2025-08-12 21:16:44.786 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[1] RENDERING with data: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:44.786 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.786 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 2
2025-08-12 21:16:44.786 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[2] RENDERING with data: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:44.786 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.786 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 3
2025-08-12 21:16:44.786 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[3] RENDERING with data: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:44.786 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.786 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 4
2025-08-12 21:16:44.786 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[4] RENDERING with data: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 5
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[5] RENDERING with data: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 6
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[6] RENDERING with data: localId=1000009756, pathUri=content://media/external/images/media/1000009756
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 7
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[7] RENDERING with data: localId=1000009755, pathUri=content://media/external/images/media/1000009755
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 8
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[8] RENDERING with data: localId=1000009754, pathUri=content://media/external/images/media/1000009754
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 9
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[9] RENDERING with data: localId=1000009753, pathUri=content://media/external/images/media/1000009753
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 10
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[10] RENDERING with data: localId=1000009752, pathUri=content://media/external/images/media/1000009752
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 11
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[11] RENDERING with data: localId=1000009751, pathUri=content://media/external/images/media/1000009751
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 12
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[12] RENDERING with data: localId=1000009750, pathUri=content://media/external/images/media/1000009750
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 13
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[13] RENDERING with data: localId=1000009749, pathUri=content://media/external/images/media/1000009749
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 14
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[14] RENDERING with data: localId=1000009748, pathUri=content://media/external/images/media/1000009748
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 15
2025-08-12 21:16:44.787 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[15] RENDERING with data: localId=1000009747, pathUri=content://media/external/images/media/1000009747
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 16
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[16] RENDERING with data: localId=1000009746, pathUri=content://media/external/images/media/1000009746
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 17
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[17] RENDERING with data: localId=1000009745, pathUri=content://media/external/images/media/1000009745
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 18
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[18] RENDERING with data: localId=1000009744, pathUri=content://media/external/images/media/1000009744
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 19
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[19] RENDERING with data: localId=1000009743, pathUri=content://media/external/images/media/1000009743
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 20
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[20] RENDERING with data: localId=1000009742, pathUri=content://media/external/images/media/1000009742
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 21
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[21] RENDERING with data: localId=1000009741, pathUri=content://media/external/images/media/1000009741
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 22
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[22] RENDERING with data: localId=1000009740, pathUri=content://media/external/images/media/1000009740
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 23
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[23] RENDERING with data: localId=1000009739, pathUri=content://media/external/images/media/1000009739
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 24
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[24] RENDERING with data: localId=1000009738, pathUri=content://media/external/images/media/1000009738
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 25
2025-08-12 21:16:44.788 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[25] RENDERING with data: localId=1000009736, pathUri=content://media/external/images/media/1000009736
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 26
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[26] RENDERING with data: localId=1000009725, pathUri=content://media/external/images/media/1000009725
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 27
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[27] RENDERING with data: localId=1000009724, pathUri=content://media/external/images/media/1000009724
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 28
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[28] RENDERING with data: localId=1000009723, pathUri=content://media/external/images/media/1000009723
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 29
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[29] RENDERING with data: localId=1000009722, pathUri=content://media/external/images/media/1000009722
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 30
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[30] RENDERING with data: localId=1000009721, pathUri=content://media/external/images/media/1000009721
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 31
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[31] RENDERING with data: localId=1000009720, pathUri=content://media/external/images/media/1000009720
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 33
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[33] RENDERING with data: localId=1000009605, pathUri=content://media/external/images/media/1000009605
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 34
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[34] RENDERING with data: localId=1000009604, pathUri=content://media/external/images/media/1000009604
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 36
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[36] RENDERING with data: localId=1000009544, pathUri=content://media/external/images/media/1000009544
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 37
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[37] RENDERING with data: localId=1000009538, pathUri=content://media/external/images/media/1000009538
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO ITEM RENDER ===
2025-08-12 21:16:44.789 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Index: 38
2025-08-12 21:16:44.790 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Item[38] RENDERING with data: localId=1000009532, pathUri=content://media/external/images/media/1000009532
2025-08-12 21:16:44.797 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:44.839 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:44.839 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:44.839 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:44.839 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:44.839 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:44.839 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:44.839 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:44.839 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:44.839 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[0] LOADED: localId=1000009768, pathUri=content://media/external/images/media/1000009768
2025-08-12 21:16:44.839 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[1] LOADED: localId=1000009760, pathUri=content://media/external/images/media/1000009760
2025-08-12 21:16:44.839 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[2] LOADED: localId=1000009759, pathUri=content://media/external/images/media/1000009759
2025-08-12 21:16:44.839 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[3] LOADED: localId=1000009758, pathUri=content://media/external/images/media/1000009758
2025-08-12 21:16:44.839 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Photo[4] LOADED: localId=1000009757, pathUri=content://media/external/images/media/1000009757
2025-08-12 21:16:44.839 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:44.839 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000009768
2025-08-12 21:16:44.839 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000009760
2025-08-12 21:16:44.839 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000009759
2025-08-12 21:16:44.839 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:44.877 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:44.885 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:44.885 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:44.885 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-12 21:16:44.891 23853-23853 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-12 21:16:44.991 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:44.991 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:44.991 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:44.991 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:44.991 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:44.991 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:44.991 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-12 21:16:44.991 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:44.991 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:44.991 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:44.991 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:44.991 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:44.991 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:44.991 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:44.991 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:44.991 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:44.991 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:44.991 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:44.997 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:45.016 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:45.016 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 943
2025-08-12 21:16:45.016 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 943
2025-08-12 21:16:45.016 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-12 21:16:45.016 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:45.016 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-12 21:16:45.016 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-12 21:16:45.016 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Checking first 5 local photos with peek():
2025-08-12 21:16:45.016 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[0] NULL: not loaded yet or loading
2025-08-12 21:16:45.016 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[1] NULL: not loaded yet or loading
2025-08-12 21:16:45.016 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[2] NULL: not loaded yet or loading
2025-08-12 21:16:45.016 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[3] NULL: not loaded yet or loading
2025-08-12 21:16:45.016 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             W  Photo[4] NULL: not loaded yet or loading
2025-08-12 21:16:45.016 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             I  Snapshot list size: 96
2025-08-12 21:16:45.016 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[0]: localId=1000005856
2025-08-12 21:16:45.016 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[1]: localId=1000005855
2025-08-12 21:16:45.016 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  Snapshot[2]: localId=1000005854
2025-08-12 21:16:45.016 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-12 21:16:45.055 23853-23853 LocalPhotoGrid          com.akslabs.cloudgallery             E  🎯 === LOCAL PHOTO GRID COMPOSING ===
2025-08-12 21:16:45.128 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-12 21:16:45.129 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 160, JumpThreshold: 160
2025-08-12 21:16:45.129 23853-23853 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
