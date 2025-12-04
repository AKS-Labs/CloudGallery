2025-12-03 23:35:45.101 30408-30408 Preferences             pid-30408                            E  Error getting long for key last_cloud_photo_sync_timestamp (Fix with AI)
                                                                                                    java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Long
                                                                                                    	at android.app.SharedPreferencesImpl.getLong(SharedPreferencesImpl.java:337)
                                                                                                    	at com.akslabs.cloudgallery.data.localdb.Preferences.getLong(Preferences.kt:83)
                                                                                                    	at com.akslabs.cloudgallery.ui.MainActivity$initializeCloudPhotoSync$1.invokeSuspend(MainActivity.kt:173)
                                                                                                    	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:34)
                                                                                                    	at kotlinx.coroutines.internal.DispatchedContinuationKt.resumeCancellableWith(DispatchedContinuation.kt:359)
                                                                                                    	at kotlinx.coroutines.intrinsics.CancellableKt.startCoroutineCancellable(Cancellable.kt:26)
                                                                                                    	at kotlinx.coroutines.CoroutineStart.invoke(CoroutineStart.kt:358)
                                                                                                    	at kotlinx.coroutines.AbstractCoroutine.start(AbstractCoroutine.kt:124)
                                                                                                    	at kotlinx.coroutines.BuildersKt__Builders_commonKt.launch(Builders.common.kt:52)
                                                                                                    	at kotlinx.coroutines.BuildersKt.launch(Unknown Source:1)
                                                                                                    	at kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(Builders.common.kt:43)
                                                                                                    	at kotlinx.coroutines.BuildersKt.launch$default(Unknown Source:1)
                                                                                                    	at com.akslabs.cloudgallery.ui.MainActivity.initializeCloudPhotoSync(MainActivity.kt:162)
                                                                                                    	at com.akslabs.cloudgallery.ui.MainActivity.onCreate(MainActivity.kt:61)
                                                                                                    	at android.app.Activity.performCreate(Activity.java:9155)
                                                                                                    	at android.app.Activity.performCreate(Activity.java:9133)
                                                                                                    	at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1528)
                                                                                                    	at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:4262)
                                                                                                    	at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:4467)
                                                                                                    	at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:222)
                                                                                                    	at android.app.servertransaction.TransactionExecutor.executeNonLifecycleItem(TransactionExecutor.java:133)
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
2025-12-03 23:36:48.382 30534-30534 bs.cloudgallery         com.akslabs.cloudgallery             I  Late-enabling -Xcheck:jni
2025-12-03 23:36:48.415 30534-30534 bs.cloudgallery         com.akslabs.cloudgallery             I  Using CollectorTypeCC GC.
2025-12-03 23:36:48.467 30534-30534 bs.cloudgallery         com.akslabs.cloudgallery             W  Thread Pool max thread count is 0. Cannot cache binder as linkToDeath cannot be implemented. serviceName: activity
2025-12-03 23:36:48.480 30534-30534 nativeloader            com.akslabs.cloudgallery             D  Load libframework-connectivity-tiramisu-jni.so using APEX ns com_android_tethering for caller /apex/com.android.tethering/javalib/framework-connectivity-t.jar: ok
2025-12-03 23:36:48.515 30534-30534 nativeloader            com.akslabs.cloudgallery             D  Load /data/user/0/com.akslabs.cloudgallery/code_cache/startup_agents/43ec9884-agent.so using system ns (caller=<unknown>): ok
2025-12-03 23:36:48.525 30534-30534 bs.cloudgallery         com.akslabs.cloudgallery             W  hiddenapi: DexFile /data/data/com.akslabs.cloudgallery/code_cache/.studio/instruments-aba82530.jar is in boot class path but is not in a known location
2025-12-03 23:36:48.725 30534-30534 bs.cloudgallery         com.akslabs.cloudgallery             W  Redefining intrinsic method java.lang.Thread java.lang.Thread.currentThread(). This may cause the unexpected use of the original definition of java.lang.Thread java.lang.Thread.currentThread()in methods that have already been compiled.
2025-12-03 23:36:48.725 30534-30534 bs.cloudgallery         com.akslabs.cloudgallery             W  Redefining intrinsic method boolean java.lang.Thread.interrupted(). This may cause the unexpected use of the original definition of boolean java.lang.Thread.interrupted()in methods that have already been compiled.
2025-12-03 23:36:48.760 30534-30534 ApplicationLoaders      com.akslabs.cloudgallery             D  Returning zygote-cached class loader: /system_ext/framework/androidx.window.extensions.jar
2025-12-03 23:36:48.760 30534-30534 ApplicationLoaders      com.akslabs.cloudgallery             D  Returning zygote-cached class loader: /system_ext/framework/androidx.window.sidecar.jar
2025-12-03 23:36:48.805 30534-30534 bs.cloudgallery         com.akslabs.cloudgallery             W  ClassLoaderContext classpath size mismatch. expected=0, found=7 (PCL[]{PCL[/system_ext/framework/androidx.window.extensions.jar*2326151982]#PCL[/system_ext/framework/androidx.window.sidecar.jar*1750604274]} | PCL[/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes12.dex*4060145770:/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes14.dex*2549995372:/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes5.dex*2794375807:/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes9.dex*1390503394:/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes13.dex*2892799424:/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes8.dex*1363965770:/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes6.dex*2512512217]{PCL[/system_ext/framework/androidx.window.extensions.jar*2326151982]#PCL[/system_ext/framework/androidx.window.sidecar.jar*1750604274]})
2025-12-03 23:36:48.818 30534-30534 nativeloader            com.akslabs.cloudgallery             D  Configuring clns-9 for other apk /data/app/~~P-ngOPSEWhFOtj_Nfa7ofg==/com.akslabs.cloudgallery-0L1MtGisrBbiBPvVuXAfXA==/base.apk. target_sdk_version=36, uses_libraries=, library_path=/data/app/~~P-ngOPSEWhFOtj_Nfa7ofg==/com.akslabs.cloudgallery-0L1MtGisrBbiBPvVuXAfXA==/lib/arm64:/data/app/~~P-ngOPSEWhFOtj_Nfa7ofg==/com.akslabs.cloudgallery-0L1MtGisrBbiBPvVuXAfXA==/base.apk!/lib/arm64-v8a, permitted_path=/data:/mnt/expand:/data/user/0/com.akslabs.cloudgallery
2025-12-03 23:36:48.856 30534-30534 bs.cloudgallery         com.akslabs.cloudgallery             I  AssetManager2(0x79c40d3b28) locale list changing from [] to [en-IN]
2025-12-03 23:36:48.859 30534-30534 bs.cloudgallery         com.akslabs.cloudgallery             I  AssetManager2(0x79c40d4428) locale list changing from [] to [en-IN]
2025-12-03 23:36:48.868 30534-30534 GraphicsEnvironment     com.akslabs.cloudgallery             V  Currently set values for:
2025-12-03 23:36:48.868 30534-30534 GraphicsEnvironment     com.akslabs.cloudgallery             V    angle_gl_driver_selection_pkgs=[com.android.angle, com.linecorp.b612.android, com.campmobile.snow, com.google.android.apps.tachyon]
2025-12-03 23:36:48.868 30534-30534 GraphicsEnvironment     com.akslabs.cloudgallery             V    angle_gl_driver_selection_values=[angle, native, native, native]
2025-12-03 23:36:48.868 30534-30534 GraphicsEnvironment     com.akslabs.cloudgallery             V  com.akslabs.cloudgallery is not listed in per-application setting
2025-12-03 23:36:48.869 30534-30534 GraphicsEnvironment     com.akslabs.cloudgallery             V  ANGLE allowlist from config: 
2025-12-03 23:36:48.869 30534-30534 GraphicsEnvironment     com.akslabs.cloudgallery             V  com.akslabs.cloudgallery is not listed in ANGLE allowlist or settings, returning default
2025-12-03 23:36:48.869 30534-30534 GraphicsEnvironment     com.akslabs.cloudgallery             V  Neither updatable production driver nor prerelease driver is supported.
2025-12-03 23:36:48.895 30534-30534 WM-WrkMgrInitializer    com.akslabs.cloudgallery             D  Initializing WorkManager with default configuration.
2025-12-03 23:36:48.934 30534-30534 WM-PackageManagerHelper com.akslabs.cloudgallery             D  Skipping component enablement for androidx.work.impl.background.systemjob.SystemJobService
2025-12-03 23:36:48.934 30534-30534 WM-Schedulers           com.akslabs.cloudgallery             D  Created SystemJobScheduler and enabled SystemJobService
2025-12-03 23:36:48.938 30534-749   WM-ForceStopRunnable    com.akslabs.cloudgallery             D  The default process name was not specified.
2025-12-03 23:36:48.940 30534-749   WM-ForceStopRunnable    com.akslabs.cloudgallery             D  Performing cleanup operations.
2025-12-03 23:36:48.960 30534-749   ashmem                  com.akslabs.cloudgallery             E  Pinning is deprecated since Android Q. Please use trim or other methods.
2025-12-03 23:36:49.006 30534-749   WM-SystemJobScheduler   com.akslabs.cloudgallery             D  Reconciling jobs
2025-12-03 23:36:49.054 30534-749   WM-ForceStopRunnable    com.akslabs.cloudgallery             D  Application was force-stopped, rescheduling.
2025-12-03 23:36:49.124 30534-749   WM-SystemJobScheduler   com.akslabs.cloudgallery             D  Scheduling work ID 1a8fae58-26f0-4b55-834c-6e166557d4dcJob ID 3
2025-12-03 23:36:49.140 30534-749   WM-SystemJobScheduler   com.akslabs.cloudgallery             D  Scheduling work ID 75ea98e4-6161-493c-bf46-c4aafb57a965Job ID 118
2025-12-03 23:36:49.160 30534-749   WM-SystemJobScheduler   com.akslabs.cloudgallery             D  Scheduling work ID 6a9a935d-05ed-4d4d-8990-f55a5b452addJob ID 142
2025-12-03 23:36:49.172 30534-749   WM-SystemJobScheduler   com.akslabs.cloudgallery             D  Scheduling work ID 26d4d7d1-68de-4ee2-a3ab-d47c67858a96Job ID 141
2025-12-03 23:36:49.213 30534-753   WM-PackageManagerHelper com.akslabs.cloudgallery             D  Skipping component enablement for androidx.work.impl.background.systemalarm.RescheduleReceiver
2025-12-03 23:36:49.222 30534-30534 ImageLoaderModule       com.akslabs.cloudgallery             I  === INITIALIZING IMAGE LOADERS ===
2025-12-03 23:36:49.235 30534-30534 ImageLoaderModule       com.akslabs.cloudgallery             D  Created OkHttpClient with 30s connect, 60s read/write timeouts
2025-12-03 23:36:49.235 30534-30534 ImageLoaderModule       com.akslabs.cloudgallery             D  Creating remoteImageLoader...
2025-12-03 23:36:49.237 30534-30534 ImageLoaderModule       com.akslabs.cloudgallery             I  remoteImageLoader created successfully
2025-12-03 23:36:49.237 30534-30534 ImageLoaderModule       com.akslabs.cloudgallery             D  Creating thumbnailImageLoader...
2025-12-03 23:36:49.237 30534-30534 ImageLoaderModule       com.akslabs.cloudgallery             I  thumbnailImageLoader created successfully
2025-12-03 23:36:49.237 30534-30534 ImageLoaderModule       com.akslabs.cloudgallery             I  === IMAGE LOADERS INITIALIZATION COMPLETE ===
2025-12-03 23:36:49.237 30534-30534 ImageLoaderModule       com.akslabs.cloudgallery             I  Available loaders:
2025-12-03 23:36:49.238 30534-30534 ImageLoaderModule       com.akslabs.cloudgallery             I  - defaultImageLoader: ✓
2025-12-03 23:36:49.238 30534-30534 ImageLoaderModule       com.akslabs.cloudgallery             I  - remoteImageLoader: ✓
2025-12-03 23:36:49.238 30534-30534 ImageLoaderModule       com.akslabs.cloudgallery             I  - thumbnailImageLoader: ✓
2025-12-03 23:36:49.282 30534-30534 WM-RescheduleReceiver   com.akslabs.cloudgallery             D  Received intent Intent { act=android.intent.action.BOOT_COMPLETED flg=0x9000030 pkg=com.akslabs.cloudgallery cmp=com.akslabs.cloudgallery/androidx.work.impl.background.systemalarm.RescheduleReceiver (has extras) }
2025-12-03 23:36:49.289 30534-755   DisplayManager          com.akslabs.cloudgallery             I  Choreographer implicitly registered for the refresh rate.
2025-12-03 23:36:49.291 30534-30534 bs.cloudgallery         com.akslabs.cloudgallery             I  AssetManager2(0x79c40d3e28) locale list changing from [] to [en-IN]
2025-12-03 23:36:49.291 30534-755   AdrenoGLES-0            com.akslabs.cloudgallery             I  QUALCOMM build                   : 95db91f, Ifbc588260a
                                                                                                    Build Date                       : 09/24/20
                                                                                                    OpenGL ES Shader Compiler Version: EV031.32.02.01
                                                                                                    Local Branch                     : mybrancheafe5b6d-fb5b-f1b0-b904-5cb90179c3e0
                                                                                                    Remote Branch                    : quic/gfx-adreno.lnx.1.0.r114-rel
                                                                                                    Remote Branch                    : NONE
                                                                                                    Reconstruct Branch               : NOTHING
2025-12-03 23:36:49.291 30534-755   AdrenoGLES-0            com.akslabs.cloudgallery             I  Build Config                     : S P 10.0.7 AArch64
2025-12-03 23:36:49.291 30534-755   AdrenoGLES-0            com.akslabs.cloudgallery             I  Driver Path                      : /vendor/lib64/egl/libGLESv2_adreno.so
2025-12-03 23:36:49.295 30534-755   AdrenoGLES-0            com.akslabs.cloudgallery             I  PFP: 0x016ee190, ME: 0x00000000
2025-12-03 23:36:49.335 30534-30534 CompatChangeReporter    com.akslabs.cloudgallery             D  Compat change id reported: 377864165; UID 10756; state: ENABLED
2025-12-03 23:36:49.337 30534-30534 DesktopModeFlags        com.akslabs.cloudgallery             D  Toggle override initialized to: OVERRIDE_UNSET
2025-12-03 23:36:49.356 30534-757   DatabaseDebugHelper     com.akslabs.cloudgallery             I  === DATABASE DEBUG REPORT ===
2025-12-03 23:36:49.369 30534-30534 Preferences             com.akslabs.cloudgallery             E  Error getting long for key last_cloud_photo_sync_timestamp (Fix with AI)
                                                                                                    java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Long
                                                                                                    	at android.app.SharedPreferencesImpl.getLong(SharedPreferencesImpl.java:337)
                                                                                                    	at com.akslabs.cloudgallery.data.localdb.Preferences.getLong(Preferences.kt:83)
                                                                                                    	at com.akslabs.cloudgallery.ui.MainActivity$initializeCloudPhotoSync$1.invokeSuspend(MainActivity.kt:173)
                                                                                                    	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:34)
                                                                                                    	at kotlinx.coroutines.internal.DispatchedContinuationKt.resumeCancellableWith(DispatchedContinuation.kt:359)
                                                                                                    	at kotlinx.coroutines.intrinsics.CancellableKt.startCoroutineCancellable(Cancellable.kt:26)
                                                                                                    	at kotlinx.coroutines.CoroutineStart.invoke(CoroutineStart.kt:358)
                                                                                                    	at kotlinx.coroutines.AbstractCoroutine.start(AbstractCoroutine.kt:124)
                                                                                                    	at kotlinx.coroutines.BuildersKt__Builders_commonKt.launch(Builders.common.kt:52)
                                                                                                    	at kotlinx.coroutines.BuildersKt.launch(Unknown Source:1)
                                                                                                    	at kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(Builders.common.kt:43)
                                                                                                    	at kotlinx.coroutines.BuildersKt.launch$default(Unknown Source:1)
                                                                                                    	at com.akslabs.cloudgallery.ui.MainActivity.initializeCloudPhotoSync(MainActivity.kt:162)
                                                                                                    	at com.akslabs.cloudgallery.ui.MainActivity.onCreate(MainActivity.kt:61)
                                                                                                    	at android.app.Activity.performCreate(Activity.java:9155)
                                                                                                    	at android.app.Activity.performCreate(Activity.java:9133)
                                                                                                    	at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1528)
                                                                                                    	at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:4262)
                                                                                                    	at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:4467)
                                                                                                    	at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:222)
                                                                                                    	at android.app.servertransaction.TransactionExecutor.executeNonLifecycleItem(TransactionExecutor.java:133)
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
2025-12-03 23:36:49.382 30534-757   DatabaseDebugHelper     com.akslabs.cloudgallery             I  Database version: 6
2025-12-03 23:36:49.423 30534-765   Gralloc4                com.akslabs.cloudgallery             I  mapper 4.x is not supported
2025-12-03 23:36:49.426 30534-765   Gralloc3                com.akslabs.cloudgallery             W  mapper 3.x is not supported
2025-12-03 23:36:49.450 30534-757   DatabaseDebugHelper     com.akslabs.cloudgallery             I  Record counts:
2025-12-03 23:36:49.450 30534-757   DatabaseDebugHelper     com.akslabs.cloudgallery             I    Total photos: 1239
2025-12-03 23:36:49.450 30534-757   DatabaseDebugHelper     com.akslabs.cloudgallery             I    Photos with remoteId: 84
2025-12-03 23:36:49.450 30534-757   DatabaseDebugHelper     com.akslabs.cloudgallery             I    Total remote photos: 85
2025-12-03 23:36:49.450 30534-757   DatabaseDebugHelper     com.akslabs.cloudgallery             I  Sample uploaded photos:
2025-12-03 23:36:49.450 30534-757   DatabaseDebugHelper     com.akslabs.cloudgallery             I    Photo: localId=27, remoteId=BQACAgUAAyEGAASeEFIcAAIN52juPY3YqJBEBLYWiLtKZmIsWA6ZAAJCGQAC0yVxV3LrOK57q7kaNgQ, type=png
2025-12-03 23:36:49.451 30534-757   DatabaseDebugHelper     com.akslabs.cloudgallery             I    Photo: localId=1642, remoteId=BQACAgUAAyEGAASeEFIcAAIN6WjuPZTA9ia2blr9PfHlp0io3YeoAAJEGQAC0yVxV7LNTrLXWC_VNgQ, type=jpg
2025-12-03 23:36:49.451 30534-757   DatabaseDebugHelper     com.akslabs.cloudgallery             I    Photo: localId=1643, remoteId=BQACAgUAAyEGAASeEFIcAAIN6mjuPZZI8zj0N9zRxCDV8e3UV82QAAJFGQAC0yVxV61DSAVNposaNgQ, type=jpg
2025-12-03 23:36:49.451 30534-757   DatabaseDebugHelper     com.akslabs.cloudgallery             I  Sample remote photos:
2025-12-03 23:36:49.451 30534-757   DatabaseDebugHelper     com.akslabs.cloudgallery             I    RemotePhoto: remoteId=BQACAgUAAyEGAASeEFIcAAIR6mksfDIGokEGLucKneHot8urDJKpAAJzHgAClElpVR9tkmoj0N90NgQ, type=jpg, fileName=-2465991538733278748596574115619019544.jpg
2025-12-03 23:36:49.451 30534-757   DatabaseDebugHelper     com.akslabs.cloudgallery             I    RemotePhoto: remoteId=BQACAgUAAyEGAASeEFIcAAIOm2j_U4BBaVRy0HirOss1TkMJ8fRiAAJNHAAC24MBVNF5clta0gP5NgQ, type=png, fileName=8975460329306876439755484173380517754.png
2025-12-03 23:36:49.451 30534-757   DatabaseDebugHelper     com.akslabs.cloudgallery             I    RemotePhoto: remoteId=BQACAgUAAyEGAASeEFIcAAIOPGjuQH7N06jTsWbMVBNLMUoJu8XkAAKbGQAC0yVxVzfbWHb8-1ecNgQ, type=png, fileName=-51530756309401880956373678045048482464.png
2025-12-03 23:36:49.451 30534-757   DatabaseDebugHelper     com.akslabs.cloudgallery             W  DATA INCONSISTENCY: Uploaded photos count (84) != Remote photos count (85)
2025-12-03 23:36:49.451 30534-757   DatabaseDebugHelper     com.akslabs.cloudgallery             I  === END DATABASE DEBUG REPORT ===
2025-12-03 23:36:49.454 30534-749   JobInfo                 com.akslabs.cloudgallery             W  Requested important-while-foreground flag for job143 is ignored and takes no effect
2025-12-03 23:36:49.454 30534-749   WM-SystemJobScheduler   com.akslabs.cloudgallery             D  Scheduling work ID 082a8e56-26c1-4542-9694-86a1ca61e2f2Job ID 143
2025-12-03 23:36:49.457 30534-749   WM-GreedyScheduler      com.akslabs.cloudgallery             D  Starting tracking for 082a8e56-26c1-4542-9694-86a1ca61e2f2
2025-12-03 23:36:49.475 30534-749   WM-ConstraintTracker    com.akslabs.cloudgallery             D  BatteryNotLowTracker: initial state = true
2025-12-03 23:36:49.476 30534-749   WM-BrdcstRcvrCnstrntTrc com.akslabs.cloudgallery             D  BatteryNotLowTracker: registering receiver
2025-12-03 23:36:49.483 30534-749   WM-ConstraintTracker    com.akslabs.cloudgallery             D  NetworkStateTracker24: initial state = NetworkState(isConnected=true, isValidated=true, isMetered=true, isNotRoaming=true)
2025-12-03 23:36:49.483 30534-749   WM-NetworkStateTracker  com.akslabs.cloudgallery             D  Registering network callback
2025-12-03 23:36:49.489 30534-752   WM-GreedyScheduler      com.akslabs.cloudgallery             D  Constraints met: Scheduling work ID WorkGenerationalId(workSpecId=082a8e56-26c1-4542-9694-86a1ca61e2f2, generation=0)
2025-12-03 23:36:49.492 30534-767   WM-NetworkStateTracker  com.akslabs.cloudgallery             D  Network capabilities changed: [ Transports: CELLULAR Capabilities: SUPL&INTERNET&NOT_RESTRICTED&TRUSTED&NOT_VPN&VALIDATED&NOT_ROAMING&FOREGROUND&NOT_CONGESTED&NOT_SUSPENDED&NOT_VCN_MANAGED&NOT_BANDWIDTH_CONSTRAINED LinkUpBandwidth>=1623Kbps LinkDnBandwidth>=3932Kbps Specifier: <TelephonyNetworkSpecifier [mSubId = 2]> SubscriptionIds: {2} UnderlyingNetworks: Null]
2025-12-03 23:36:49.502 30534-752   WM-Processor            com.akslabs.cloudgallery             D  Processor: processing WorkGenerationalId(workSpecId=082a8e56-26c1-4542-9694-86a1ca61e2f2, generation=0)
2025-12-03 23:36:49.557 30534-30534 bs.cloudgallery         com.akslabs.cloudgallery             I  hiddenapi: Accessing hidden method Landroid/os/SystemProperties;->addChangeCallback(Ljava/lang/Runnable;)V (runtime_flags=0, domain=platform, api=unsupported) from Landroidx/compose/ui/platform/AndroidComposeView$Companion; (domain=app) using reflection: allowed
2025-12-03 23:36:49.843 30534-30534 LocalViewModel          com.akslabs.cloudgallery             E  🚀 === LOCAL VIEW MODEL INITIALIZED ===
2025-12-03 23:36:49.843 30534-30534 LocalViewModel          com.akslabs.cloudgallery             I  === LOCAL PHOTOS DATABASE DEBUG ===
2025-12-03 23:36:49.844 30534-30534 LocalViewModel          com.akslabs.cloudgallery             I  Local total count flow created: null
2025-12-03 23:36:49.844 30534-30534 LocalViewModel          com.akslabs.cloudgallery             I  === END LOCAL PHOTOS DATABASE DEBUG ===
2025-12-03 23:36:49.852 30534-30534 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-12-03 23:36:49.852 30534-30534 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 60, PrefetchDistance: 64, JumpThreshold: 160
2025-12-03 23:36:49.860 30534-30534 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-12-03 23:36:49.862 30534-30534 LocalViewModel          com.akslabs.cloudgallery             E  📊 Local photos count updated: 0
2025-12-03 23:36:49.873 30534-30534 RemoteViewModel         com.akslabs.cloudgallery             D  === CREATING NEW PAGING SOURCE ===
2025-12-03 23:36:49.873 30534-30534 RemoteViewModel         com.akslabs.cloudgallery             D  PageSize: 24, PrefetchDistance: 72, JumpThreshold: 120
2025-12-03 23:36:49.875 30534-30534 RemoteViewModel         com.akslabs.cloudgallery             D  PagingSource created: null
2025-12-03 23:36:49.879 30534-30534 RemoteViewModel         com.akslabs.cloudgallery             E  📄 New PagingData received in ViewModel
2025-12-03 23:36:49.880 30534-30534 RemoteViewModel         com.akslabs.cloudgallery             E  📊 Total count updated: 0
2025-12-03 23:36:50.076 30534-771   Gralloc2                com.akslabs.cloudgallery             I  Adding additional valid usage bits: 0x8202000
2025-12-03 23:36:50.321 30534-754   WM-Processor            com.akslabs.cloudgallery             D  Processor cancelling 26d4d7d1-68de-4ee2-a3ab-d47c67858a96
2025-12-03 23:36:50.322 30534-754   WM-Processor            com.akslabs.cloudgallery             D  WorkerWrapper could not be found for 26d4d7d1-68de-4ee2-a3ab-d47c67858a96
2025-12-03 23:36:50.331 30534-754   WM-GreedyScheduler      com.akslabs.cloudgallery             D  Cancelling work ID 26d4d7d1-68de-4ee2-a3ab-d47c67858a96
2025-12-03 23:36:50.338 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-12-03 23:36:50.338 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 0
2025-12-03 23:36:50.338 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos (Paging) itemCount: 0
2025-12-03 23:36:50.339 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  AllPhotos (Custom) size: 0
2025-12-03 23:36:50.339 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-12-03 23:36:50.339 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-12-03 23:36:50.339 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-12-03 23:36:50.339 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-12-03 23:36:50.350 30534-30534 MainViewModel           com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-12-03 23:36:50.359 30534-757   LocalPhotoGrid          com.akslabs.cloudgallery             D  fetchAllLocalPhotos: Cursor count: 1239
2025-12-03 23:36:50.367 30534-30534 MainViewModel           com.akslabs.cloudgallery             D  === CREATING NEW REMOTE PAGING SOURCE ===
2025-12-03 23:36:50.378 30534-768   bs.cloudgallery         com.akslabs.cloudgallery             I  hiddenapi: Accessing hidden method Landroid/database/sqlite/SQLiteDatabase;->getThreadSession()Landroid/database/sqlite/SQLiteSession; (runtime_flags=0, domain=platform, api=unsupported) from Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase; (domain=app) using reflection: allowed
2025-12-03 23:36:50.378 30534-768   bs.cloudgallery         com.akslabs.cloudgallery             I  hiddenapi: Accessing hidden method Landroid/database/sqlite/SQLiteSession;->beginTransaction(ILandroid/database/sqlite/SQLiteTransactionListener;ILandroid/os/CancellationSignal;)V (runtime_flags=0, domain=platform, api=unsupported) from Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase; (domain=app) using reflection: allowed
2025-12-03 23:36:50.404 30534-30534 MainViewModel           com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-12-03 23:36:50.409 30534-754   WM-SystemJobScheduler   com.akslabs.cloudgallery             D  Scheduling work ID cf00f9e3-ea8c-4d8b-afe7-06c8b2e3fa6eJob ID 144
2025-12-03 23:36:50.417 30534-754   WM-GreedyScheduler      com.akslabs.cloudgallery             D  Starting work for cf00f9e3-ea8c-4d8b-afe7-06c8b2e3fa6e
2025-12-03 23:36:50.428 30534-754   WM-Processor            com.akslabs.cloudgallery             D  Processor: processing WorkGenerationalId(workSpecId=cf00f9e3-ea8c-4d8b-afe7-06c8b2e3fa6e, generation=0)
2025-12-03 23:36:50.452 30534-757   LocalPhotoGrid          com.akslabs.cloudgallery             D  fetchAllLocalPhotos: Fetched 1239 photos
2025-12-03 23:36:50.460 30534-30534 Choreographer           com.akslabs.cloudgallery             I  Skipped 58 frames!  The application may be doing too much work on its main thread.
2025-12-03 23:36:50.838 30534-30534 WM-WorkerWrapper        com.akslabs.cloudgallery             D  Starting work for com.akslabs.cloudgallery.workers.CloudPhotoSyncWorker
2025-12-03 23:36:50.840 30534-757   CloudPhotoSyncWorker    com.akslabs.cloudgallery             I  === CLOUD PHOTO SYNC WORKER STARTED ===
2025-12-03 23:36:50.848 30534-754   WM-Processor            com.akslabs.cloudgallery             I  Moving WorkSpec (082a8e56-26c1-4542-9694-86a1ca61e2f2) to the foreground
2025-12-03 23:36:50.861 30534-757   CloudPhotoSyncService   com.akslabs.cloudgallery             I  === STARTING FULL CLOUD PHOTO SYNC ===
2025-12-03 23:36:50.865 30534-759   CloudPhotoSyncService   com.akslabs.cloudgallery             D  Found configured group/channel ID: -1002651869724
2025-12-03 23:36:50.866 30534-757   CloudPhotoSyncService   com.akslabs.cloudgallery             I  Syncing with channel ID: -1002651869724
2025-12-03 23:36:50.866 30534-757   CloudPhotoSyncService   com.akslabs.cloudgallery             W  ⚠️  TELEGRAM BOT API LIMITATION:
2025-12-03 23:36:50.866 30534-757   CloudPhotoSyncService   com.akslabs.cloudgallery             W  Bot API can only access messages from the last 24 hours
2025-12-03 23:36:50.866 30534-757   CloudPhotoSyncService   com.akslabs.cloudgallery             W  Historical images older than 24 hours cannot be retrieved via Bot API
2025-12-03 23:36:50.866 30534-757   CloudPhotoSyncService   com.akslabs.cloudgallery             W  This is a Telegram platform limitation, not an app bug
2025-12-03 23:36:50.866 30534-757   CloudPhotoSyncService   com.akslabs.cloudgallery             D  Last sync: 0, Current: 1764785210866, Should sync: true
2025-12-03 23:36:50.875 30534-759   CloudPhotoSyncService   com.akslabs.cloudgallery             I  Current database has 85 RemotePhoto records
2025-12-03 23:36:50.876 30534-759   CloudPhotoSyncService   com.akslabs.cloudgallery             I  Performing incremental sync
2025-12-03 23:36:50.876 30534-759   Historical...eDiscovery com.akslabs.cloudgallery             I  === STARTING HISTORICAL IMAGE DISCOVERY ===
2025-12-03 23:36:50.877 30534-759   Historical...eDiscovery com.akslabs.cloudgallery             I  Channel ID: -1002651869724
2025-12-03 23:36:50.877 30534-759   Historical...eDiscovery com.akslabs.cloudgallery             I  Config: ScanConfig(channelId=-1002651869724, batchSize=100, maxFiles=1000, includePhotos=true, includeDocuments=true, includeVideos=true)
2025-12-03 23:36:50.889 30534-760   Historical...eDiscovery com.akslabs.cloudgallery             I  Found 85 existing RemotePhoto records
2025-12-03 23:36:50.889 30534-760   Historical...eDiscovery com.akslabs.cloudgallery             D  Processing batch 1 (offset: null)
2025-12-03 23:36:50.891 30534-752   WM-WorkProgressUpdater  com.akslabs.cloudgallery             D  Updating progress for 082a8e56-26c1-4542-9694-86a1ca61e2f2 (Data {batch : 1, found : 0})
2025-12-03 23:36:50.904 30534-30534 WM-WorkerWrapper        com.akslabs.cloudgallery             D  Starting work for com.akslabs.cloudgallery.workers.SyncDbMediaStoreWorker
2025-12-03 23:36:50.906 30534-760   BotApi                  com.akslabs.cloudgallery             D  === SCANNING CHANNEL FOR MEDIA ===
2025-12-03 23:36:50.906 30534-760   BotApi                  com.akslabs.cloudgallery             D  Channel ID: -1002651869724, Limit: 100, Offset: null
2025-12-03 23:36:50.956 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-12-03 23:36:50.956 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 0
2025-12-03 23:36:50.956 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos (Paging) itemCount: 0
2025-12-03 23:36:50.956 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  AllPhotos (Custom) size: 1239
2025-12-03 23:36:50.956 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-12-03 23:36:50.956 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-12-03 23:36:50.957 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-12-03 23:36:50.957 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-12-03 23:36:50.995 30534-30534 Choreographer           com.akslabs.cloudgallery             I  Skipped 31 frames!  The application may be doing too much work on its main thread.
2025-12-03 23:36:51.083 30534-30534 WM-SystemFgDispatcher   com.akslabs.cloudgallery             I  Started foreground service Intent { act=ACTION_START_FOREGROUND xflg=0x4 cmp=com.akslabs.cloudgallery/androidx.work.impl.foreground.SystemForegroundService (has extras) }
2025-12-03 23:36:51.084 30534-30534 WM-SystemFgDispatcher   com.akslabs.cloudgallery             D  Notifying with (id:2001, workSpecId: 082a8e56-26c1-4542-9694-86a1ca61e2f2, notificationType :1)
2025-12-03 23:36:51.091 30534-30534 WM-SystemFgDispatcher   com.akslabs.cloudgallery             D  Notifying with (id:2001, workSpecId: 082a8e56-26c1-4542-9694-86a1ca61e2f2, notificationType :1)
2025-12-03 23:36:51.104 30534-30534 LocalViewModel          com.akslabs.cloudgallery             E  📊 Local photos count updated: 1239
2025-12-03 23:36:51.104 30534-30534 RemoteViewModel         com.akslabs.cloudgallery             E  📊 Total count updated: 85
2025-12-03 23:36:51.108 30534-30534 WM-SystemJobService     com.akslabs.cloudgallery             D  onStartJob for WorkGenerationalId(workSpecId=cf00f9e3-ea8c-4d8b-afe7-06c8b2e3fa6e, generation=0)
2025-12-03 23:36:51.110 30534-30534 InsetsController        com.akslabs.cloudgallery             D  hide(ime(), fromIme=false)
2025-12-03 23:36:51.110 30534-30534 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:3a991d9: onCancelled at PHASE_CLIENT_ALREADY_HIDDEN
2025-12-03 23:36:51.121 30534-749   WM-Processor            com.akslabs.cloudgallery             D  Work WorkGenerationalId(workSpecId=cf00f9e3-ea8c-4d8b-afe7-06c8b2e3fa6e, generation=0) is already enqueued for processing
2025-12-03 23:36:51.185 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-12-03 23:36:51.185 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 1239
2025-12-03 23:36:51.185 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos (Paging) itemCount: 0
2025-12-03 23:36:51.185 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  AllPhotos (Custom) size: 1239
2025-12-03 23:36:51.185 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-12-03 23:36:51.185 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-12-03 23:36:51.185 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-12-03 23:36:51.185 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-12-03 23:36:51.965 30534-788   ContentValues           com.akslabs.cloudgallery             D  doWork: []
2025-12-03 23:36:51.965 30534-788   Sync MediaStore         com.akslabs.cloudgallery             D  doWork: Success
2025-12-03 23:36:52.695 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-12-03 23:36:52.695 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 1239
2025-12-03 23:36:52.695 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos (Paging) itemCount: 180
2025-12-03 23:36:52.695 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  AllPhotos (Custom) size: 1239
2025-12-03 23:36:52.695 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-12-03 23:36:52.695 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-12-03 23:36:52.695 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-12-03 23:36:52.695 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-12-03 23:36:52.726 30534-30534 Choreographer           com.akslabs.cloudgallery             I  Skipped 90 frames!  The application may be doing too much work on its main thread.
2025-12-03 23:36:52.780 30534-754   WM-WorkerWrapper        com.akslabs.cloudgallery             I  Worker result SUCCESS for Work [ id=cf00f9e3-ea8c-4d8b-afe7-06c8b2e3fa6e, tags={ com.akslabs.cloudgallery.workers.SyncDbMediaStoreWorker } ]
2025-12-03 23:36:52.885 30534-752   WM-SystemJobScheduler   com.akslabs.cloudgallery             D  Scheduling work ID ffd3c406-9519-474c-99c3-d1e3f0f76e26Job ID 145
2025-12-03 23:36:53.146 30534-30534 WM-Processor            com.akslabs.cloudgallery             D  Processor cf00f9e3-ea8c-4d8b-afe7-06c8b2e3fa6e executed; reschedule = false
2025-12-03 23:36:53.147 30534-30534 WM-SystemJobService     com.akslabs.cloudgallery             D  cf00f9e3-ea8c-4d8b-afe7-06c8b2e3fa6e executed on JobScheduler
2025-12-03 23:36:53.153 30534-749   WM-GreedyScheduler      com.akslabs.cloudgallery             D  Cancelling work ID cf00f9e3-ea8c-4d8b-afe7-06c8b2e3fa6e
2025-12-03 23:36:53.328 30534-30534 WM-SystemJobService     com.akslabs.cloudgallery             D  onStopJob for WorkGenerationalId(workSpecId=cf00f9e3-ea8c-4d8b-afe7-06c8b2e3fa6e, generation=0)
2025-12-03 23:36:54.454 30534-795   ProfileInstaller        com.akslabs.cloudgallery             D  Installing profile for com.akslabs.cloudgallery
2025-12-03 23:36:58.565 30534-722   bs.cloudgallery         com.akslabs.cloudgallery             I  Background concurrent copying GC freed 19MB AllocSpace bytes, 93(2116KB) LOS objects, 66% free, 8570KB/25MB, paused 83us,48us total 114.789ms
2025-12-03 23:36:59.852 30534-30534 Choreographer           com.akslabs.cloudgallery             I  Skipped 34 frames!  The application may be doing too much work on its main thread.
2025-12-03 23:37:04.987 30534-767   WM-NetworkStateTracker  com.akslabs.cloudgallery             D  Network capabilities changed: [ Transports: CELLULAR Capabilities: SUPL&INTERNET&NOT_RESTRICTED&TRUSTED&NOT_VPN&VALIDATED&NOT_ROAMING&FOREGROUND&NOT_CONGESTED&NOT_SUSPENDED&NOT_VCN_MANAGED&NOT_BANDWIDTH_CONSTRAINED LinkUpBandwidth>=1194Kbps LinkDnBandwidth>=4468Kbps Specifier: <TelephonyNetworkSpecifier [mSubId = 2]> SubscriptionIds: {2} UnderlyingNetworks: Null]
2025-12-03 23:37:15.817 30534-30534 bs.cloudgallery         com.akslabs.cloudgallery             I  hiddenapi: Accessing hidden method Landroid/view/ViewTreeObserver;->dispatchOnScrollChanged()V (runtime_flags=0, domain=platform, api=unsupported) from Landroidx/compose/ui/platform/AndroidComposeView$Companion; (domain=app) using reflection: allowed
2025-12-03 23:37:22.398 30534-760   BotApi                  com.akslabs.cloudgallery             I  Received 0 updates from Telegram
2025-12-03 23:37:22.398 30534-760   BotApi                  com.akslabs.cloudgallery             I  Scan complete: Found 0 media files
2025-12-03 23:37:22.399 30534-760   Historical...eDiscovery com.akslabs.cloudgallery             D  Batch 1: Found 0 media files
2025-12-03 23:37:22.399 30534-760   Historical...eDiscovery com.akslabs.cloudgallery             I  Batch 1: Processing 0 new files
2025-12-03 23:37:22.400 30534-753   WM-WorkProgressUpdater  com.akslabs.cloudgallery             D  Updating progress for 082a8e56-26c1-4542-9694-86a1ca61e2f2 (Data {batch : 1, found : 0})
2025-12-03 23:37:22.435 30534-787   Historical...eDiscovery com.akslabs.cloudgallery             I  No more messages to scan
2025-12-03 23:37:22.436 30534-787   Historical...eDiscovery com.akslabs.cloudgallery             I  No new images found to sync
2025-12-03 23:37:22.436 30534-787   Historical...eDiscovery com.akslabs.cloudgallery             I  === HISTORICAL IMAGE DISCOVERY COMPLETE ===
2025-12-03 23:37:22.436 30534-787   Historical...eDiscovery com.akslabs.cloudgallery             I  Total batches processed: 1
2025-12-03 23:37:22.436 30534-787   Historical...eDiscovery com.akslabs.cloudgallery             I  Total new files discovered: 0
2025-12-03 23:37:22.437 30534-787   CloudPhotoSyncService   com.akslabs.cloudgallery             D  Updated last sync timestamp to: 1764785242436
2025-12-03 23:37:22.437 30534-787   CloudPhotoSyncService   com.akslabs.cloudgallery             I  === FULL CLOUD PHOTO SYNC COMPLETE ===
2025-12-03 23:37:22.437 30534-787   CloudPhotoSyncWorker    com.akslabs.cloudgallery             I  Cloud photo sync completed successfully: 0 new files
2025-12-03 23:37:22.437 30534-787   CloudPhotoSyncWorker    com.akslabs.cloudgallery             I  === CLOUD PHOTO SYNC WORKER FINISHED ===
2025-12-03 23:37:22.458 30534-754   WM-WorkerWrapper        com.akslabs.cloudgallery             I  Worker result SUCCESS for Work [ id=082a8e56-26c1-4542-9694-86a1ca61e2f2, tags={ com.akslabs.cloudgallery.workers.CloudPhotoSyncWorker } ]
2025-12-03 23:37:22.506 30534-30534 WM-Processor            com.akslabs.cloudgallery             D  Processor 082a8e56-26c1-4542-9694-86a1ca61e2f2 executed; reschedule = false
2025-12-03 23:37:22.507 30534-30534 WM-GreedyScheduler      com.akslabs.cloudgallery             D  Stopping tracking for WorkGenerationalId(workSpecId=082a8e56-26c1-4542-9694-86a1ca61e2f2, generation=0)
2025-12-03 23:37:22.508 30534-30534 WM-SystemFgDispatcher   com.akslabs.cloudgallery             D  Removing Notification (id: 2001, workSpecId: WorkGenerationalId(workSpecId=082a8e56-26c1-4542-9694-86a1ca61e2f2, generation=0), notificationType: 1
2025-12-03 23:37:22.520 30534-752   WM-GreedyScheduler      com.akslabs.cloudgallery             D  Cancelling work ID 082a8e56-26c1-4542-9694-86a1ca61e2f2
2025-12-03 23:37:22.561 30534-749   WM-BrdcstRcvrCnstrntTrc com.akslabs.cloudgallery             D  BatteryNotLowTracker: unregistering receiver
2025-12-03 23:37:22.563 30534-749   WM-NetworkStateTracker  com.akslabs.cloudgallery             D  Unregistering network callback
2025-12-03 23:37:22.592 30534-30534 WM-SystemFgDispatcher   com.akslabs.cloudgallery             I  Stopping foreground service
2025-12-03 23:37:22.592 30534-30534 WM-SystemFgService      com.akslabs.cloudgallery             D  Shutting down.
2025-12-03 23:37:23.161 30534-722   bs.cloudgallery         com.akslabs.cloudgallery             I  Background concurrent copying GC freed 13MB AllocSpace bytes, 108(2224KB) LOS objects, 66% free, 9921KB/29MB, paused 209us,86us total 177.054ms
2025-12-03 23:37:31.051 30534-790   HWUI                    com.akslabs.cloudgallery             D  --- Failed to create image decoder with message 'unimplemented'
2025-12-03 23:37:31.052 30534-790   HWUI                    com.akslabs.cloudgallery             D  --- Failed to create image decoder with message 'unimplemented'
2025-12-03 23:37:35.986 30534-722   bs.cloudgallery         com.akslabs.cloudgallery             I  Background concurrent copying GC freed 12MB AllocSpace bytes, 216(4320KB) LOS objects, 66% free, 11MB/33MB, paused 156us,89us total 221.155ms
2025-12-03 23:37:36.636 30534-30534 Choreographer           com.akslabs.cloudgallery             I  Skipped 56 frames!  The application may be doing too much work on its main thread.
2025-12-03 23:37:37.510 30534-760   HWUI                    com.akslabs.cloudgallery             D  --- Failed to create image decoder with message 'unimplemented'
2025-12-03 23:37:37.511 30534-760   HWUI                    com.akslabs.cloudgallery             D  --- Failed to create image decoder with message 'unimplemented'
2025-12-03 23:37:39.179 30534-790   HWUI                    com.akslabs.cloudgallery             D  --- Failed to create image decoder with message 'unimplemented'
2025-12-03 23:37:39.179 30534-790   HWUI                    com.akslabs.cloudgallery             D  --- Failed to create image decoder with message 'unimplemented'
2025-12-03 23:37:39.483 30534-722   bs.cloudgallery         com.akslabs.cloudgallery             I  Background young concurrent copying GC freed 11MB AllocSpace bytes, 313(6260KB) LOS objects, 53% free, 15MB/33MB, paused 436us,142us total 123.514ms
2025-12-03 23:37:41.021 30534-942   skia                    com.akslabs.cloudgallery             D  Tiff header had invalid endian marker 0x45,0x78,0x69,0x66.
2025-12-03 23:37:41.023 30534-942   skia                    com.akslabs.cloudgallery             D  Tiff header had invalid endian marker 0x45,0x78,0x69,0x66.
2025-12-03 23:37:41.349 30534-30534 Choreographer           com.akslabs.cloudgallery             I  Skipped 36 frames!  The application may be doing too much work on its main thread.
2025-12-03 23:37:41.855 30534-1111  HWUI                    com.akslabs.cloudgallery             D  --- Failed to create image decoder with message 'unimplemented'
2025-12-03 23:37:41.855 30534-1111  HWUI                    com.akslabs.cloudgallery             D  --- Failed to create image decoder with message 'unimplemented'
2025-12-03 23:37:41.907 30534-722   bs.cloudgallery         com.akslabs.cloudgallery             I  Background concurrent copying GC freed 14MB AllocSpace bytes, 311(6220KB) LOS objects, 66% free, 14MB/44MB, paused 112us,571us total 239.013ms
2025-12-03 23:37:41.972 30534-1111  skia                    com.akslabs.cloudgallery             D  Tiff header had invalid endian marker 0x45,0x78,0x69,0x66.
2025-12-03 23:37:41.975 30534-1111  skia                    com.akslabs.cloudgallery             D  Tiff header had invalid endian marker 0x45,0x78,0x69,0x66.
2025-12-03 23:37:42.365 30534-30534 Choreographer           com.akslabs.cloudgallery             I  Skipped 60 frames!  The application may be doing too much work on its main thread.
2025-12-03 23:37:42.444 30534-1107  skia                    com.akslabs.cloudgallery             D  Tiff header had invalid endian marker 0x45,0x78,0x69,0x66.
2025-12-03 23:37:42.445 30534-1107  skia                    com.akslabs.cloudgallery             D  Tiff header had invalid endian marker 0x45,0x78,0x69,0x66.
2025-12-03 23:37:43.224 30534-30534 Choreographer           com.akslabs.cloudgallery             I  Skipped 50 frames!  The application may be doing too much work on its main thread.
2025-12-03 23:37:50.270 30534-1107  skia                    com.akslabs.cloudgallery             D  Tiff header had invalid endian marker 0x45,0x78,0x69,0x66.
2025-12-03 23:37:50.271 30534-1107  skia                    com.akslabs.cloudgallery             D  Tiff header had invalid endian marker 0x45,0x78,0x69,0x66.
2025-12-03 23:37:51.606 30534-722   bs.cloudgallery         com.akslabs.cloudgallery             I  NativeAlloc concurrent copying GC freed 11MB AllocSpace bytes, 103(2052KB) LOS objects, 66% free, 11MB/35MB, paused 100us,242us total 263.996ms
2025-12-03 23:37:51.764 30534-30534 Choreographer           com.akslabs.cloudgallery             I  Skipped 34 frames!  The application may be doing too much work on its main thread.
2025-12-03 23:38:05.636 30534-30534 WindowOnBackDispatcher  com.akslabs.cloudgallery             W  sendCancelIfRunning: isInProgress=false callback=androidx.navigationevent.OnBackInvokedInput$createOnBackAnimationCallback$1@c8ec84b
2025-12-03 23:38:12.929 30534-30534 LocalPhotoGrid          com.akslabs.cloudgallery             D  Opening photo viewer: originalIndex=1221, mappedIndex=1221, totalLoaded=1239
2025-12-03 23:38:13.048 30534-30534 InsetsController        com.akslabs.cloudgallery             D  Setting requestedVisibleTypes to -528 (was -9)
2025-12-03 23:38:13.399 30534-30534 InteractionJankMonitor  com.akslabs.cloudgallery             W  Initializing without READ_DEVICE_CONFIG permission. enabled=false, interval=1, missedFrameThreshold=3, frameTimeThreshold=64, package=com.akslabs.cloudgallery
2025-12-03 23:38:13.431 30534-722   bs.cloudgallery         com.akslabs.cloudgallery             I  NativeAlloc concurrent copying GC freed 23MB AllocSpace bytes, 93(1860KB) LOS objects, 66% free, 10MB/30MB, paused 160us,88us total 104.272ms
2025-12-03 23:38:13.453 30534-30534 InsetsController        com.akslabs.cloudgallery             D  hide(ime(), fromIme=false)
2025-12-03 23:38:13.453 30534-30534 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:f43b4ace: onCancelled at PHASE_CLIENT_ALREADY_HIDDEN
2025-12-03 23:38:14.733 30534-30534 WindowOnBackDispatcher  com.akslabs.cloudgallery             W  sendCancelIfRunning: isInProgress=false callback=androidx.navigationevent.OnBackInvokedInput$createOnBackAnimationCallback$1@23a22fe
2025-12-03 23:38:14.741 30534-30534 InsetsController        com.akslabs.cloudgallery             D  Setting requestedVisibleTypes to -9 (was -528)
2025-12-03 23:38:14.806 30534-30534 InsetsController        com.akslabs.cloudgallery             D  hide(ime(), fromIme=false)
2025-12-03 23:38:14.806 30534-30534 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:b5515f20: onCancelled at PHASE_CLIENT_ALREADY_HIDDEN
2025-12-03 23:38:34.067 30534-1107  HWUI                    com.akslabs.cloudgallery             D  --- Failed to create image decoder with message 'unimplemented'
2025-12-03 23:38:34.067 30534-1107  HWUI                    com.akslabs.cloudgallery             D  --- Failed to create image decoder with message 'unimplemented'
