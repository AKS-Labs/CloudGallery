--------- beginning of crash
--------- beginning of system
--------- beginning of main
2025-08-08 11:37:25.724 32679-32679 bs.cloudgallery         com.akslabs.cloudgallery             I  Late-enabling -Xcheck:jni
2025-08-08 11:37:25.821 32679-32679 bs.cloudgallery         com.akslabs.cloudgallery             I  Using CollectorTypeCC GC.
2025-08-08 11:37:25.913 32679-32679 nativeloader            com.akslabs.cloudgallery             D  Load libframework-connectivity-tiramisu-jni.so using APEX ns com_android_tethering for caller /apex/com.android.tethering/javalib/framework-connectivity-t.jar: ok
2025-08-08 11:37:26.076 32679-32679 re-initialized>         com.akslabs.cloudgallery             W  type=1400 audit(0.0:10863): avc:  granted  { execute } for  path="/data/data/com.akslabs.cloudgallery/code_cache/startup_agents/b13c65d9-agent.so" dev="mmcblk0p61" ino=244238 scontext=u:r:untrusted_app:s0:c31,c259,c512,c768 tcontext=u:object_r:app_data_file:s0:c31,c259,c512,c768 tclass=file app=com.akslabs.cloudgallery
2025-08-08 11:37:26.099 32679-32679 nativeloader            com.akslabs.cloudgallery             D  Load /data/user/0/com.akslabs.cloudgallery/code_cache/startup_agents/b13c65d9-agent.so using system ns (caller=<unknown>): ok
2025-08-08 11:37:26.123 32679-32679 bs.cloudgallery         com.akslabs.cloudgallery             W  DexFile /data/data/com.akslabs.cloudgallery/code_cache/.studio/instruments-462f9421.jar is in boot class path but is not in a known location
2025-08-08 11:37:26.433 32679-32679 bs.cloudgallery         com.akslabs.cloudgallery             W  Redefining intrinsic method java.lang.Thread java.lang.Thread.currentThread(). This may cause the unexpected use of the original definition of java.lang.Thread java.lang.Thread.currentThread()in methods that have already been compiled.
2025-08-08 11:37:26.433 32679-32679 bs.cloudgallery         com.akslabs.cloudgallery             W  Redefining intrinsic method boolean java.lang.Thread.interrupted(). This may cause the unexpected use of the original definition of boolean java.lang.Thread.interrupted()in methods that have already been compiled.
2025-08-08 11:37:26.535 32679-32679 ApplicationLoaders      com.akslabs.cloudgallery             D  Returning zygote-cached class loader: /system_ext/framework/androidx.window.extensions.jar
2025-08-08 11:37:26.536 32679-32679 ApplicationLoaders      com.akslabs.cloudgallery             D  Returning zygote-cached class loader: /system_ext/framework/androidx.window.sidecar.jar
2025-08-08 11:37:26.553 32679-32679 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes12.dm': No such file or directory
2025-08-08 11:37:26.563 32679-32679 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes14.dm': No such file or directory
2025-08-08 11:37:26.569 32679-32679 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes6.dm': No such file or directory
2025-08-08 11:37:26.577 32679-32679 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes9.dm': No such file or directory
2025-08-08 11:37:26.592 32679-32679 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes10.dm': No such file or directory
2025-08-08 11:37:26.606 32679-32679 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/app/~~1gUfwzcQ3RGkaL7n9sbb7g==/com.akslabs.cloudgallery-yD3ylgl4AgCe97uUS9ud8A==/base.dm': No such file or directory
2025-08-08 11:37:26.606 32679-32679 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/app/~~1gUfwzcQ3RGkaL7n9sbb7g==/com.akslabs.cloudgallery-yD3ylgl4AgCe97uUS9ud8A==/base.dm': No such file or directory
2025-08-08 11:37:27.874 32679-32679 nativeloader            com.akslabs.cloudgallery             D  Configuring clns-7 for other apk /data/app/~~1gUfwzcQ3RGkaL7n9sbb7g==/com.akslabs.cloudgallery-yD3ylgl4AgCe97uUS9ud8A==/base.apk. target_sdk_version=34, uses_libraries=, library_path=/data/app/~~1gUfwzcQ3RGkaL7n9sbb7g==/com.akslabs.cloudgallery-yD3ylgl4AgCe97uUS9ud8A==/lib/arm64:/data/app/~~1gUfwzcQ3RGkaL7n9sbb7g==/com.akslabs.cloudgallery-yD3ylgl4AgCe97uUS9ud8A==/base.apk!/lib/arm64-v8a, permitted_path=/data:/mnt/expand:/data/user/0/com.akslabs.cloudgallery
2025-08-08 11:37:27.925 32679-32679 GraphicsEnvironment     com.akslabs.cloudgallery             V  Currently set values for:
2025-08-08 11:37:27.926 32679-32679 GraphicsEnvironment     com.akslabs.cloudgallery             V    angle_gl_driver_selection_pkgs=[com.android.angle, com.linecorp.b612.android, com.campmobile.snow, com.google.android.apps.tachyon]
2025-08-08 11:37:27.926 32679-32679 GraphicsEnvironment     com.akslabs.cloudgallery             V    angle_gl_driver_selection_values=[angle, native, native, native]
2025-08-08 11:37:27.926 32679-32679 GraphicsEnvironment     com.akslabs.cloudgallery             V  com.akslabs.cloudgallery is not listed in per-application setting
2025-08-08 11:37:27.926 32679-32679 GraphicsEnvironment     com.akslabs.cloudgallery             V  Neither updatable production driver nor prerelease driver is supported.
2025-08-08 11:37:28.038 32679-32679 WM-WrkMgrInitializer    com.akslabs.cloudgallery             D  Initializing WorkManager with default configuration.
2025-08-08 11:37:28.175 32679-32679 WM-PackageManagerHelper com.akslabs.cloudgallery             D  Skipping component enablement for androidx.work.impl.background.systemjob.SystemJobService
2025-08-08 11:37:28.175 32679-32679 WM-Schedulers           com.akslabs.cloudgallery             D  Created SystemJobScheduler and enabled SystemJobService
2025-08-08 11:37:28.805 32679-32679 EngineFactory           com.akslabs.cloudgallery             I  Provider GmsCore_OpenSSL not available
2025-08-08 11:37:28.840 32679-32679 ImageLoaderModule       com.akslabs.cloudgallery             I  === INITIALIZING IMAGE LOADERS ===
2025-08-08 11:37:29.095 32679-32679 ImageLoaderModule       com.akslabs.cloudgallery             D  Created OkHttpClient with 30s connect, 60s read/write timeouts
2025-08-08 11:37:29.095 32679-32679 ImageLoaderModule       com.akslabs.cloudgallery             D  Creating remoteImageLoader...
2025-08-08 11:37:29.099 32679-32679 ImageLoaderModule       com.akslabs.cloudgallery             I  remoteImageLoader created successfully
2025-08-08 11:37:29.099 32679-32679 ImageLoaderModule       com.akslabs.cloudgallery             D  Creating thumbnailImageLoader...
2025-08-08 11:37:29.099 32679-32679 ImageLoaderModule       com.akslabs.cloudgallery             I  thumbnailImageLoader created successfully
2025-08-08 11:37:29.100 32679-32679 ImageLoaderModule       com.akslabs.cloudgallery             I  === IMAGE LOADERS INITIALIZATION COMPLETE ===
2025-08-08 11:37:29.100 32679-32679 ImageLoaderModule       com.akslabs.cloudgallery             I  Available loaders:
2025-08-08 11:37:29.100 32679-32679 ImageLoaderModule       com.akslabs.cloudgallery             I  - defaultImageLoader: ✓
2025-08-08 11:37:29.100 32679-32679 ImageLoaderModule       com.akslabs.cloudgallery             I  - remoteImageLoader: ✓
2025-08-08 11:37:29.100 32679-32679 ImageLoaderModule       com.akslabs.cloudgallery             I  - thumbnailImageLoader: ✓
2025-08-08 11:37:29.203 32679-32679 Choreographer           com.akslabs.cloudgallery             I  Skipped 60 frames!  The application may be doing too much work on its main thread.
2025-08-08 11:37:29.374 32679-566   DatabaseDebugHelper     com.akslabs.cloudgallery             I  === DATABASE DEBUG REPORT ===
2025-08-08 11:37:29.413 32679-566   DatabaseDebugHelper     com.akslabs.cloudgallery             I  Database version: 4
2025-08-08 11:37:29.438 32679-32679 DesktopModeFlagsUtil    com.akslabs.cloudgallery             D  Toggle override initialized to: OVERRIDE_UNSET
2025-08-08 11:37:29.440 32679-566   DatabaseDebugHelper     com.akslabs.cloudgallery             I  Record counts:
2025-08-08 11:37:29.440 32679-566   DatabaseDebugHelper     com.akslabs.cloudgallery             I    Total photos: 0
2025-08-08 11:37:29.441 32679-566   DatabaseDebugHelper     com.akslabs.cloudgallery             I    Photos with remoteId: 0
2025-08-08 11:37:29.441 32679-566   DatabaseDebugHelper     com.akslabs.cloudgallery             I    Total remote photos: 0
2025-08-08 11:37:29.441 32679-566   DatabaseDebugHelper     com.akslabs.cloudgallery             I  === END DATABASE DEBUG REPORT ===
2025-08-08 11:37:29.869 32679-32693 bs.cloudgallery         com.akslabs.cloudgallery             I  Compiler allocated 4431KB to compile void android.view.ViewRootImpl.performTraversals()
2025-08-08 11:37:30.118 32679-32679 bs.cloudgallery         com.akslabs.cloudgallery             W  Method boolean androidx.compose.runtime.snapshots.SnapshotStateList.conditionalUpdate(boolean, kotlin.jvm.functions.Function1) failed lock verification and will run slower.
                                                                                                    Common causes for lock verification issues are non-optimized dex code
                                                                                                    and incorrect proguard optimizations.
2025-08-08 11:37:30.119 32679-32679 bs.cloudgallery         com.akslabs.cloudgallery             W  Method boolean androidx.compose.runtime.snapshots.SnapshotStateList.conditionalUpdate$default(androidx.compose.runtime.snapshots.SnapshotStateList, boolean, kotlin.jvm.functions.Function1, int, java.lang.Object) failed lock verification and will run slower.
2025-08-08 11:37:30.119 32679-32679 bs.cloudgallery         com.akslabs.cloudgallery             W  Method java.lang.Object androidx.compose.runtime.snapshots.SnapshotStateList.mutate(kotlin.jvm.functions.Function1) failed lock verification and will run slower.
2025-08-08 11:37:30.119 32679-32679 bs.cloudgallery         com.akslabs.cloudgallery             W  Method void androidx.compose.runtime.snapshots.SnapshotStateList.update(boolean, kotlin.jvm.functions.Function1) failed lock verification and will run slower.
2025-08-08 11:37:30.119 32679-32679 bs.cloudgallery         com.akslabs.cloudgallery             W  Method void androidx.compose.runtime.snapshots.SnapshotStateList.update$default(androidx.compose.runtime.snapshots.SnapshotStateList, boolean, kotlin.jvm.functions.Function1, int, java.lang.Object) failed lock verification and will run slower.
2025-08-08 11:37:30.868 32679-539   AdrenoGLES-0            com.akslabs.cloudgallery             I  QUALCOMM build                   : 95db91f, Ifbc588260a
                                                                                                    Build Date                       : 09/24/20
                                                                                                    OpenGL ES Shader Compiler Version: EV031.32.02.01
                                                                                                    Local Branch                     : mybrancheafe5b6d-fb5b-f1b0-b904-5cb90179c3e0
                                                                                                    Remote Branch                    : quic/gfx-adreno.lnx.1.0.r114-rel
                                                                                                    Remote Branch                    : NONE
                                                                                                    Reconstruct Branch               : NOTHING
2025-08-08 11:37:30.868 32679-539   AdrenoGLES-0            com.akslabs.cloudgallery             I  Build Config                     : S P 10.0.7 AArch64
2025-08-08 11:37:30.868 32679-539   AdrenoGLES-0            com.akslabs.cloudgallery             I  Driver Path                      : /vendor/lib64/egl/libGLESv2_adreno.so
2025-08-08 11:37:30.886 32679-539   AdrenoGLES-0            com.akslabs.cloudgallery             I  PFP: 0x016ee190, ME: 0x00000000
2025-08-08 11:37:30.975 32679-683   Gralloc4                com.akslabs.cloudgallery             I  mapper 4.x is not supported
2025-08-08 11:37:30.976 32679-683   Gralloc3                com.akslabs.cloudgallery             W  mapper 3.x is not supported
2025-08-08 11:37:30.988 32679-683   Gralloc2                com.akslabs.cloudgallery             I  Adding additional valid usage bits: 0x8202000
2025-08-08 11:37:31.035 32679-569   CloudPhotoSyncWorker    com.akslabs.cloudgallery             I  === CLOUD PHOTO SYNC WORKER STARTED ===
2025-08-08 11:37:31.050 32679-32702 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1450ms; Flags=1, FrameTimelineVsyncId=136180891, IntendedVsync=211747512111689, Vsync=211747545448117, InputEventId=0, HandleInputStart=211747556695681, AnimationStart=211747556698024, PerformTraversalsStart=211747556699014, DrawStart=211748890880055, FrameDeadline=211747533445021, FrameInterval=211747556674274, FrameStartTime=16668214, SyncQueued=211748948679222, SyncStart=211748948884430, IssueDrawCommandsStart=211748950321201, SwapBuffers=211748960940680, FrameCompleted=211748962842607, DequeueBufferDuration=16459, QueueBufferDuration=429895, GpuCompleted=211748962842607, SwapBuffersCompleted=211748962166045, DisplayPresentTime=8929200825491172685, CommandSubmissionCompleted=211748960940680, 
2025-08-08 11:37:31.058 32679-576   WM-Processor            com.akslabs.cloudgallery             I  Moving WorkSpec (ef1c927c-bf5e-467f-84db-4c8b3b9f6377) to the foreground
2025-08-08 11:37:31.081 32679-569   CloudPhotoSyncService   com.akslabs.cloudgallery             I  === STARTING FULL CLOUD PHOTO SYNC ===
2025-08-08 11:37:31.085 32679-569   CloudPhotoSyncService   com.akslabs.cloudgallery             W  No group/channel ID configured in preferences
2025-08-08 11:37:31.085 32679-569   CloudPhotoSyncService   com.akslabs.cloudgallery             D  BotApi.chatId is null, trying to get from preferences
2025-08-08 11:37:31.085 32679-569   CloudPhotoSyncService   com.akslabs.cloudgallery             W  No chat ID available. User may need to configure group/channel ID or send /start to bot first
2025-08-08 11:37:31.087 32679-566   CloudPhotoSyncService   com.akslabs.cloudgallery             W  No channel ID configured, skipping sync
2025-08-08 11:37:31.087 32679-566   CloudPhotoSyncService   com.akslabs.cloudgallery             I  To enable historical sync: Configure group/channel ID in app settings
2025-08-08 11:37:31.087 32679-566   CloudPhotoSyncWorker    com.akslabs.cloudgallery             E  Cloud photo sync failed: No Telegram group/channel configured for backup.
2025-08-08 11:37:31.087 32679-566   CloudPhotoSyncWorker    com.akslabs.cloudgallery             I  === CLOUD PHOTO SYNC WORKER FINISHED ===
2025-08-08 11:37:31.090 32679-572   WM-WorkerWrapper        com.akslabs.cloudgallery             I  Worker result FAILURE for Work [ id=ef1c927c-bf5e-467f-84db-4c8b3b9f6377, tags={ com.akslabs.cloudgallery.workers.CloudPhotoSyncWorker } ]
2025-08-08 11:37:31.092 32679-32679 Choreographer           com.akslabs.cloudgallery             I  Skipped 82 frames!  The application may be doing too much work on its main thread.
2025-08-08 11:37:31.136 32679-32679 WM-SystemFgDispatcher   com.akslabs.cloudgallery             I  Started foreground service Intent { act=ACTION_START_FOREGROUND cmp=com.akslabs.cloudgallery/androidx.work.impl.foreground.SystemForegroundService (has extras) }
2025-08-08 11:37:31.215 32679-32679 WM-SystemFgDispatcher   com.akslabs.cloudgallery             I  Stopping foreground service
2025-08-08 11:37:34.324 32679-32679 WindowOnBackDispatcher  com.akslabs.cloudgallery             W  OnBackInvokedCallback is not enabled for the application.
                                                                                                    Set 'android:enableOnBackInvokedCallback="true"' in the application manifest.
2025-08-08 11:37:35.126 32679-32702 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=918ms; Flags=0, FrameTimelineVsyncId=136187609, IntendedVsync=211752128711113, Vsync=211752178710805, InputEventId=220746498, HandleInputStart=211752193206356, AnimationStart=211752193251929, PerformTraversalsStart=211752256853335, DrawStart=211752983360939, FrameDeadline=211752150044445, FrameInterval=211752193194846, FrameStartTime=16666759, SyncQueued=211753038257501, SyncStart=211753038419949, IssueDrawCommandsStart=211753039379116, SwapBuffers=211753044472397, FrameCompleted=211753047236147, DequeueBufferDuration=33959, QueueBufferDuration=353490, GpuCompleted=211753047236147, SwapBuffersCompleted=211753045581304, DisplayPresentTime=-4976307568766831132, CommandSubmissionCompleted=211753044472397, 
2025-08-08 11:37:35.134 32679-32679 Choreographer           com.akslabs.cloudgallery             I  Skipped 49 frames!  The application may be doing too much work on its main thread.
2025-08-08 11:37:35.205 32679-732   ProfileInstaller        com.akslabs.cloudgallery             D  Installing profile for com.akslabs.cloudgallery
2025-08-08 11:37:37.252 32679-32679 InsetsController        com.akslabs.cloudgallery             D  show(ime(), fromIme=false)
2025-08-08 11:37:37.255 32679-32679 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:7e3a4a5a: onRequestShow at ORIGIN_CLIENT reason SHOW_SOFT_INPUT_BY_INSETS_API fromUser false
2025-08-08 11:37:37.259 32679-32679 InputMethodManager      com.akslabs.cloudgallery             D  showSoftInput() view=androidx.compose.ui.platform.AndroidComposeView{d4c0e2a VFED..... .F....ID 0,0-1080,2263 aid=1073741824} flags=0 reason=SHOW_SOFT_INPUT_BY_INSETS_API
2025-08-08 11:37:37.350 32679-32679 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:1e1557c0: onRequestShow at ORIGIN_CLIENT reason SHOW_SOFT_INPUT fromUser false
2025-08-08 11:37:37.350 32679-32679 InputMethodManager      com.akslabs.cloudgallery             D  showSoftInput() view=androidx.compose.ui.platform.AndroidComposeView{d4c0e2a VFED..... .F...... 0,0-1080,2263 aid=1073741824} flags=0 reason=SHOW_SOFT_INPUT
2025-08-08 11:37:37.964 32679-32679 InsetsController        com.akslabs.cloudgallery             D  show(ime(), fromIme=true)
2025-08-08 11:37:38.005 32679-876   InteractionJankMonitor  com.akslabs.cloudgallery             W  Initializing without READ_DEVICE_CONFIG permission. enabled=false, interval=1, missedFrameThreshold=3, frameTimeThreshold=64, package=com.akslabs.cloudgallery
2025-08-08 11:37:38.251 32679-32679 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:1e1557c0: onShown
2025-08-08 11:37:43.908 32679-32679 InsetsController        com.akslabs.cloudgallery             D  show(ime(), fromIme=false)
2025-08-08 11:37:43.911 32679-32679 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:d7922612: onRequestShow at ORIGIN_CLIENT reason SHOW_SOFT_INPUT_BY_INSETS_API fromUser false
2025-08-08 11:37:43.911 32679-32679 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:d7922612: onCancelled at PHASE_CLIENT_APPLY_ANIMATION
2025-08-08 11:37:43.974 32679-32679 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:73ddec18: onRequestShow at ORIGIN_CLIENT reason SHOW_SOFT_INPUT fromUser false
2025-08-08 11:37:43.974 32679-32679 InputMethodManager      com.akslabs.cloudgallery             D  showSoftInput() view=androidx.compose.ui.platform.AndroidComposeView{d4c0e2a VFED..... .F...... 0,0-1080,2263 aid=1073741824} flags=0 reason=SHOW_SOFT_INPUT
2025-08-08 11:37:44.236 32679-32679 InsetsController        com.akslabs.cloudgallery             D  show(ime(), fromIme=true)
2025-08-08 11:37:44.237 32679-32679 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:73ddec18: onCancelled at PHASE_CLIENT_APPLY_ANIMATION
2025-08-08 11:37:49.186 32679-32679 GettingStartedScreen    com.akslabs.cloudgallery             I  Validating chat ID: -1002651869724
2025-08-08 11:37:50.675 32679-32679 GettingStartedScreen    com.akslabs.cloudgallery             W  Raw getChat failed, falling back to BotApi
                                                                                                    com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.akslabs.cloudgallery.api.TelegramRawApi$TelegramResponse` (no Creators, like default constructor, exist): cannot deserialize from Object value (no delegate- or property-based Creator)
                                                                                                     at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); line: 1, column: 2]
                                                                                                    	at com.fasterxml.jackson.databind.DeserializationContext.reportBadDefinition(DeserializationContext.java:1887)
                                                                                                    	at com.fasterxml.jackson.databind.DatabindContext.reportBadDefinition(DatabindContext.java:414)
                                                                                                    	at com.fasterxml.jackson.databind.DeserializationContext.handleMissingInstantiator(DeserializationContext.java:1375)
                                                                                                    	at com.fasterxml.jackson.databind.deser.BeanDeserializerBase.deserializeFromObjectUsingNonDefault(BeanDeserializerBase.java:1508)
                                                                                                    	at com.fasterxml.jackson.databind.deser.BeanDeserializer.deserializeFromObject(BeanDeserializer.java:348)
                                                                                                    	at com.fasterxml.jackson.databind.deser.BeanDeserializer.deserialize(BeanDeserializer.java:185)
                                                                                                    	at com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.readRootValue(DefaultDeserializationContext.java:342)
                                                                                                    	at com.fasterxml.jackson.databind.ObjectReader._bindAndClose(ObjectReader.java:2125)
                                                                                                    	at com.fasterxml.jackson.databind.ObjectReader.readValue(ObjectReader.java:1501)
                                                                                                    	at retrofit2.converter.jackson.JacksonResponseBodyConverter.convert(JacksonResponseBodyConverter.java:33)
                                                                                                    	at retrofit2.converter.jackson.JacksonResponseBodyConverter.convert(JacksonResponseBodyConverter.java:23)
                                                                                                    	at retrofit2.OkHttpCall.parseResponse(OkHttpCall.java:246)
                                                                                                    	at retrofit2.OkHttpCall$1.onResponse(OkHttpCall.java:156)
                                                                                                    	at okhttp3.internal.connection.RealCall$AsyncCall.run(RealCall.kt:519)
                                                                                                    	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
                                                                                                    	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:644)
                                                                                                    	at java.lang.Thread.run(Thread.java:1117)
2025-08-08 11:37:50.677 32679-568   BotApi                  com.akslabs.cloudgallery             I  Attempting to get chat info for: Id(id=-1002651869724)
2025-08-08 11:37:50.944 32679-568   BotApi                  com.akslabs.cloudgallery             I  getChat result - isSuccess: false
2025-08-08 11:37:50.944 32679-568   BotApi                  com.akslabs.cloudgallery             W  getChat failed - result: Unknown(exception=com.google.gson.JsonSyntaxException: java.lang.IllegalStateException: Expected a string but was BEGIN_OBJECT at line 1 column 944 path $.result.pinned_message)
2025-08-08 11:37:56.597 32679-32679 GettingStartedScreen    com.akslabs.cloudgallery             I  Validating chat ID: -1002651869724
2025-08-08 11:37:57.723 32679-32679 GettingStartedScreen    com.akslabs.cloudgallery             W  Raw getChat failed, falling back to BotApi
                                                                                                    com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.akslabs.cloudgallery.api.TelegramRawApi$TelegramResponse` (no Creators, like default constructor, exist): cannot deserialize from Object value (no delegate- or property-based Creator)
                                                                                                     at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); line: 1, column: 2]
                                                                                                    	at com.fasterxml.jackson.databind.DeserializationContext.reportBadDefinition(DeserializationContext.java:1887)
                                                                                                    	at com.fasterxml.jackson.databind.DatabindContext.reportBadDefinition(DatabindContext.java:414)
                                                                                                    	at com.fasterxml.jackson.databind.DeserializationContext.handleMissingInstantiator(DeserializationContext.java:1375)
                                                                                                    	at com.fasterxml.jackson.databind.deser.BeanDeserializerBase.deserializeFromObjectUsingNonDefault(BeanDeserializerBase.java:1508)
                                                                                                    	at com.fasterxml.jackson.databind.deser.BeanDeserializer.deserializeFromObject(BeanDeserializer.java:348)
                                                                                                    	at com.fasterxml.jackson.databind.deser.BeanDeserializer.deserialize(BeanDeserializer.java:185)
                                                                                                    	at com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.readRootValue(DefaultDeserializationContext.java:342)
                                                                                                    	at com.fasterxml.jackson.databind.ObjectReader._bindAndClose(ObjectReader.java:2125)
                                                                                                    	at com.fasterxml.jackson.databind.ObjectReader.readValue(ObjectReader.java:1501)
                                                                                                    	at retrofit2.converter.jackson.JacksonResponseBodyConverter.convert(JacksonResponseBodyConverter.java:33)
                                                                                                    	at retrofit2.converter.jackson.JacksonResponseBodyConverter.convert(JacksonResponseBodyConverter.java:23)
                                                                                                    	at retrofit2.OkHttpCall.parseResponse(OkHttpCall.java:246)
                                                                                                    	at retrofit2.OkHttpCall$1.onResponse(OkHttpCall.java:156)
                                                                                                    	at okhttp3.internal.connection.RealCall$AsyncCall.run(RealCall.kt:519)
                                                                                                    	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
                                                                                                    	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:644)
                                                                                                    	at java.lang.Thread.run(Thread.java:1117)
2025-08-08 11:37:57.724 32679-568   BotApi                  com.akslabs.cloudgallery             I  Attempting to get chat info for: Id(id=-1002651869724)
2025-08-08 11:37:57.946 32679-568   BotApi                  com.akslabs.cloudgallery             I  getChat result - isSuccess: false
2025-08-08 11:37:57.946 32679-568   BotApi                  com.akslabs.cloudgallery             W  getChat failed - result: Unknown(exception=com.google.gson.JsonSyntaxException: java.lang.IllegalStateException: Expected a string but was BEGIN_OBJECT at line 1 column 944 path $.result.pinned_message)
2025-08-08 11:37:59.726 32679-32679 WindowOnBackDispatcher  com.akslabs.cloudgallery             W  sendCancelIfRunning: isInProgress=false callback=ImeCallback=ImeOnBackInvokedCallback@218750357 Callback=android.window.IOnBackInvokedCallback$Stub$Proxy@1509cd0
2025-08-08 11:37:59.727 32679-32679 InsetsController        com.akslabs.cloudgallery             D  hide(ime(), fromIme=true)
2025-08-08 11:37:59.953 32679-32679 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:f526c8fb: onRequestHide at ORIGIN_CLIENT reason HIDE_SOFT_INPUT_ON_ANIMATION_STATE_CHANGED fromUser false
2025-08-08 11:37:59.955 32679-32679 ImeTracker              com.akslabs.cloudgallery             I  helium314.keyboard:1bf6f876: onHidden
2025-08-08 11:38:03.062 32679-32679 InsetsController        com.akslabs.cloudgallery             D  hide(ime(), fromIme=false)
2025-08-08 11:38:03.063 32679-32679 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:8325762: onRequestHide at ORIGIN_CLIENT reason HIDE_SOFT_INPUT_BY_INSETS_API fromUser false
2025-08-08 11:38:03.063 32679-32679 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:8325762: onCancelled at PHASE_CLIENT_APPLY_ANIMATION
2025-08-08 11:38:03.976 32679-32679 WindowOnBackDispatcher  com.akslabs.cloudgallery             W  OnBackInvokedCallback is not enabled for the application.
                                                                                                    Set 'android:enableOnBackInvokedCallback="true"' in the application manifest.
2025-08-08 11:38:05.616 32679-32679 InsetsController        com.akslabs.cloudgallery             D  show(ime(), fromIme=false)
2025-08-08 11:38:05.617 32679-32679 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:dcfbf12c: onRequestShow at ORIGIN_CLIENT reason SHOW_SOFT_INPUT_BY_INSETS_API fromUser false
2025-08-08 11:38:05.617 32679-32679 InputMethodManager      com.akslabs.cloudgallery             D  showSoftInput() view=androidx.compose.ui.platform.AndroidComposeView{d4c0e2a VFED..... .F....ID 0,0-1080,2263 aid=1073741824} flags=0 reason=SHOW_SOFT_INPUT_BY_INSETS_API
2025-08-08 11:38:05.648 32679-32679 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:2f49356e: onRequestShow at ORIGIN_CLIENT reason SHOW_SOFT_INPUT fromUser false
2025-08-08 11:38:05.648 32679-32679 InputMethodManager      com.akslabs.cloudgallery             D  showSoftInput() view=androidx.compose.ui.platform.AndroidComposeView{d4c0e2a VFED..... .F...... 0,0-1080,2263 aid=1073741824} flags=0 reason=SHOW_SOFT_INPUT
2025-08-08 11:38:05.899 32679-32679 InsetsController        com.akslabs.cloudgallery             D  show(ime(), fromIme=true)
2025-08-08 11:38:06.135 32679-32679 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:2f49356e: onShown
2025-08-08 11:38:08.576 32679-32679 WindowOnBackDispatcher  com.akslabs.cloudgallery             W  sendCancelIfRunning: isInProgress=false callback=ImeCallback=ImeOnBackInvokedCallback@218750357 Callback=android.window.IOnBackInvokedCallback$Stub$Proxy@5364e89
2025-08-08 11:38:08.582 32679-32679 InsetsController        com.akslabs.cloudgallery             D  hide(ime(), fromIme=true)
2025-08-08 11:38:08.636 32679-32679 ImeTracker              com.akslabs.cloudgallery             I  com.android.systemui:7b7c6d8a: onCancelled at PHASE_CLIENT_ANIMATION_CANCEL
2025-08-08 11:38:08.638 32679-32679 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:221eddd: onRequestHide at ORIGIN_CLIENT reason HIDE_SOFT_INPUT_ON_ANIMATION_STATE_CHANGED fromUser false
2025-08-08 11:38:08.639 32679-32679 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:221eddd: onFailed at PHASE_CLIENT_VIEW_SERVED
2025-08-08 11:38:09.079 32679-32679 ImeBackDispatcher       com.akslabs.cloudgallery             E  Ime callback not found. Ignoring unregisterReceivedCallback. callbackId: 218750357
2025-08-08 11:38:10.221 32679-32679 InsetsController        com.akslabs.cloudgallery             D  show(ime(), fromIme=false)
2025-08-08 11:38:10.222 32679-32679 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:fce1f8c5: onRequestShow at ORIGIN_CLIENT reason SHOW_SOFT_INPUT_BY_INSETS_API fromUser false
2025-08-08 11:38:10.223 32679-32679 InputMethodManager      com.akslabs.cloudgallery             D  showSoftInput() view=androidx.compose.ui.platform.AndroidComposeView{d4c0e2a VFED..... .F....ID 0,0-1080,2263 aid=1073741824} flags=0 reason=SHOW_SOFT_INPUT_BY_INSETS_API
2025-08-08 11:38:10.238 32679-32679 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:bcf3e8c0: onRequestShow at ORIGIN_CLIENT reason SHOW_SOFT_INPUT fromUser false
2025-08-08 11:38:10.238 32679-32679 InputMethodManager      com.akslabs.cloudgallery             D  showSoftInput() view=androidx.compose.ui.platform.AndroidComposeView{d4c0e2a VFED..... .F...... 0,0-1080,2263 aid=1073741824} flags=0 reason=SHOW_SOFT_INPUT
2025-08-08 11:38:10.321 32679-32679 InsetsController        com.akslabs.cloudgallery             D  show(ime(), fromIme=true)
2025-08-08 11:38:10.554 32679-32679 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:bcf3e8c0: onShown
2025-08-08 11:38:15.122 32679-32679 InsetsController        com.akslabs.cloudgallery             D  show(ime(), fromIme=false)
2025-08-08 11:38:15.123 32679-32679 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:815a6992: onRequestShow at ORIGIN_CLIENT reason SHOW_SOFT_INPUT_BY_INSETS_API fromUser false
2025-08-08 11:38:15.124 32679-32679 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:815a6992: onCancelled at PHASE_CLIENT_APPLY_ANIMATION
2025-08-08 11:38:15.178 32679-32679 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:b5eec6b2: onRequestShow at ORIGIN_CLIENT reason SHOW_SOFT_INPUT fromUser false
2025-08-08 11:38:15.178 32679-32679 InputMethodManager      com.akslabs.cloudgallery             D  showSoftInput() view=androidx.compose.ui.platform.AndroidComposeView{d4c0e2a VFED..... .F...... 0,0-1080,2263 aid=1073741824} flags=0 reason=SHOW_SOFT_INPUT
2025-08-08 11:38:15.389 32679-32679 InsetsController        com.akslabs.cloudgallery             D  show(ime(), fromIme=true)
2025-08-08 11:38:15.389 32679-32679 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:b5eec6b2: onCancelled at PHASE_CLIENT_APPLY_ANIMATION
2025-08-08 11:38:19.240 32679-32679 GettingStartedScreen    com.akslabs.cloudgallery             I  Validating chat ID: -1002651869724
2025-08-08 11:38:20.313 32679-32679 GettingStartedScreen    com.akslabs.cloudgallery             W  Raw getChat failed, falling back to BotApi
                                                                                                    com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.akslabs.cloudgallery.api.TelegramRawApi$TelegramResponse` (no Creators, like default constructor, exist): cannot deserialize from Object value (no delegate- or property-based Creator)
                                                                                                     at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); line: 1, column: 2]
                                                                                                    	at com.fasterxml.jackson.databind.DeserializationContext.reportBadDefinition(DeserializationContext.java:1887)
                                                                                                    	at com.fasterxml.jackson.databind.DatabindContext.reportBadDefinition(DatabindContext.java:414)
                                                                                                    	at com.fasterxml.jackson.databind.DeserializationContext.handleMissingInstantiator(DeserializationContext.java:1375)
                                                                                                    	at com.fasterxml.jackson.databind.deser.BeanDeserializerBase.deserializeFromObjectUsingNonDefault(BeanDeserializerBase.java:1508)
                                                                                                    	at com.fasterxml.jackson.databind.deser.BeanDeserializer.deserializeFromObject(BeanDeserializer.java:348)
                                                                                                    	at com.fasterxml.jackson.databind.deser.BeanDeserializer.deserialize(BeanDeserializer.java:185)
                                                                                                    	at com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.readRootValue(DefaultDeserializationContext.java:342)
                                                                                                    	at com.fasterxml.jackson.databind.ObjectReader._bindAndClose(ObjectReader.java:2125)
                                                                                                    	at com.fasterxml.jackson.databind.ObjectReader.readValue(ObjectReader.java:1501)
                                                                                                    	at retrofit2.converter.jackson.JacksonResponseBodyConverter.convert(JacksonResponseBodyConverter.java:33)
                                                                                                    	at retrofit2.converter.jackson.JacksonResponseBodyConverter.convert(JacksonResponseBodyConverter.java:23)
                                                                                                    	at retrofit2.OkHttpCall.parseResponse(OkHttpCall.java:246)
                                                                                                    	at retrofit2.OkHttpCall$1.onResponse(OkHttpCall.java:156)
                                                                                                    	at okhttp3.internal.connection.RealCall$AsyncCall.run(RealCall.kt:519)
                                                                                                    	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
                                                                                                    	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:644)
                                                                                                    	at java.lang.Thread.run(Thread.java:1117)
2025-08-08 11:38:20.314 32679-929   BotApi                  com.akslabs.cloudgallery             I  Attempting to get chat info for: Id(id=-1002651869724)
2025-08-08 11:38:20.558 32679-929   BotApi                  com.akslabs.cloudgallery             I  getChat result - isSuccess: false
2025-08-08 11:38:20.558 32679-929   BotApi                  com.akslabs.cloudgallery             W  getChat failed - result: Unknown(exception=com.google.gson.JsonSyntaxException: java.lang.IllegalStateException: Expected a string but was BEGIN_OBJECT at line 1 column 944 path $.result.pinned_message)
