--------- beginning of crash
--------- beginning of system
--------- beginning of main
2025-12-09 18:16:12.654 29019-29041 WM-GreedyScheduler      com.akslabs.cloudgallery             D  Constraints met: Scheduling work ID WorkGenerationalId(workSpecId=98896a65-cd04-45f5-80d8-785180cac635, generation=0)
2025-12-09 18:16:12.668 29019-29040 WM-Processor            com.akslabs.cloudgallery             D  Work WorkGenerationalId(workSpecId=98896a65-cd04-45f5-80d8-785180cac635, generation=0) is already enqueued for processing
2025-12-09 18:16:24.665 29019-29019 bs.cloudgallery         com.akslabs.cloudgallery             W  Accessing hidden method Landroid/window/BackEvent;->getFrameTimeMillis()J (blocked, linking, denied)
2025-12-09 18:16:24.669 29019-29019 bs.cloudgallery         com.akslabs.cloudgallery             W  Accessing hidden method Landroid/window/BackEvent;->getFrameTimeMillis()J (blocked, linking, denied)
2025-12-09 18:16:24.669 29019-29019 bs.cloudgallery         com.akslabs.cloudgallery             W  Accessing hidden method Landroid/window/BackEvent;-><init>(FFFIJ)V (blocked, linking, denied)
2025-12-09 18:16:24.771 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-12-09 18:16:24.771 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 1266
2025-12-09 18:16:24.771 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos (Paging) itemCount: 180
2025-12-09 18:16:24.771 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  AllPhotos (Custom) size: 0
2025-12-09 18:16:24.771 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-12-09 18:16:24.771 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-12-09 18:16:24.771 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-12-09 18:16:24.771 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-12-09 18:16:24.790 29019-29045 LocalPhotoGrid          com.akslabs.cloudgallery             D  fetchAllLocalPhotos: Cursor count: 1266
2025-12-09 18:16:24.836 29019-29045 LocalPhotoGrid          com.akslabs.cloudgallery             D  fetchAllLocalPhotos: Fetched 1266 photos
2025-12-09 18:16:25.590 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-12-09 18:16:25.590 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 1266
2025-12-09 18:16:25.590 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos (Paging) itemCount: 180
2025-12-09 18:16:25.590 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  AllPhotos (Custom) size: 1266
2025-12-09 18:16:25.590 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-12-09 18:16:25.590 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-12-09 18:16:25.590 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-12-09 18:16:25.590 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-12-09 18:16:25.626 29019-29032 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=812ms; Flags=0, FrameTimelineVsyncId=8409035, IntendedVsync=14548906380725, Vsync=14548956380147, InputEventId=0, HandleInputStart=14548957261636, AnimationStart=14548957263927, PerformTraversalsStart=14549176483198, DrawStart=14549176577938, FrameDeadline=14548923047391, FrameInterval=14548957253823, FrameStartTime=16666474, SyncQueued=14549688328198, SyncStart=14549688454083, IssueDrawCommandsStart=14549688848823, SwapBuffers=14549702180750, FrameCompleted=14549719158771, DequeueBufferDuration=18802, QueueBufferDuration=504271, GpuCompleted=14549719158771, SwapBuffersCompleted=14549703336427, DisplayPresentTime=14530405376018, CommandSubmissionCompleted=14549702180750, 
2025-12-09 18:16:25.653 29019-29019 Choreographer           com.akslabs.cloudgallery             I  Skipped 33 frames!  The application may be doing too much work on its main thread.
2025-12-09 18:16:25.655 29019-29019 MainPage                com.akslabs.cloudgallery             D  Selection Debug: selected=0, total=1266, route=device
2025-12-09 18:16:25.881 29019-29019 WindowOnBackDispatcher  com.akslabs.cloudgallery             W  sendCancelIfRunning: isInProgress=false callback=androidx.navigationevent.OnBackInvokedInput$createOnBackAnimationCallback$1@167daf2
2025-12-09 18:16:26.061 29019-29033 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=964ms; Flags=0, FrameTimelineVsyncId=8409181, IntendedVsync=14549189721594, Vsync=14549739738138, InputEventId=0, HandleInputStart=14549756376948, AnimationStart=14549756380177, PerformTraversalsStart=14549994091896, DrawStart=14550134980593, FrameDeadline=14549739704617, FrameInterval=14549755674031, FrameStartTime=16667168, SyncQueued=14550144510333, SyncStart=14550144783406, IssueDrawCommandsStart=14550145182729, SwapBuffers=14550145987260, FrameCompleted=14550154702312, DequeueBufferDuration=16875, QueueBufferDuration=331719, GpuCompleted=14550154702312, SwapBuffersCompleted=14550146605802, DisplayPresentTime=14530422047736, CommandSubmissionCompleted=14550145987260, 
2025-12-09 18:16:26.062 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-12-09 18:16:26.062 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 1266
2025-12-09 18:16:26.062 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos (Paging) itemCount: 180
2025-12-09 18:16:26.062 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  AllPhotos (Custom) size: 0
2025-12-09 18:16:26.062 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-12-09 18:16:26.062 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-12-09 18:16:26.062 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-12-09 18:16:26.062 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-12-09 18:16:26.089 29019-29045 LocalPhotoGrid          com.akslabs.cloudgallery             D  fetchAllLocalPhotos: Cursor count: 1266
2025-12-09 18:16:26.120 29019-29045 LocalPhotoGrid          com.akslabs.cloudgallery             D  fetchAllLocalPhotos: Fetched 1266 photos
2025-12-09 18:16:26.769 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-12-09 18:16:26.769 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 1266
2025-12-09 18:16:26.769 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos (Paging) itemCount: 180
2025-12-09 18:16:26.769 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  AllPhotos (Custom) size: 1266
2025-12-09 18:16:26.770 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-12-09 18:16:26.770 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-12-09 18:16:26.770 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-12-09 18:16:26.770 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-12-09 18:16:26.774 29019-29019 Choreographer           com.akslabs.cloudgallery             I  Skipped 37 frames!  The application may be doing too much work on its main thread.
2025-12-09 18:16:29.404 29019-29045 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:29.404 29019-29067 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:29.414 29019-29044 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:29.567 29019-29044 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:29.581 29019-29067 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:29.593 29019-29044 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:29.606 29019-29045 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:30.069 29019-29066 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:30.121 29019-29066 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:30.156 29019-29066 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:30.187 29019-29066 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:30.875 29019-29019 LocalPhotoGrid          com.akslabs.cloudgallery             D  Opening photo viewer: originalIndex=42, mappedIndex=42, totalLoaded=1266
2025-12-09 18:16:30.982 29019-29019 InsetsController        com.akslabs.cloudgallery             D  Setting requestedVisibleTypes to -528 (was -9)
2025-12-09 18:16:31.041 29019-29066 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:31.420 29019-29019 InteractionJankMonitor  com.akslabs.cloudgallery             W  Initializing without READ_DEVICE_CONFIG permission. enabled=false, interval=1, missedFrameThreshold=3, frameTimeThreshold=64, package=com.akslabs.cloudgallery
2025-12-09 18:16:31.497 29019-29019 InsetsController        com.akslabs.cloudgallery             D  hide(ime(), fromIme=false)
2025-12-09 18:16:31.497 29019-29019 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:9a2beeec: onCancelled at PHASE_CLIENT_ALREADY_HIDDEN
2025-12-09 18:16:32.977 29019-29019 WindowOnBackDispatcher  com.akslabs.cloudgallery             W  sendCancelIfRunning: isInProgress=false callback=androidx.navigationevent.OnBackInvokedInput$createOnBackAnimationCallback$1@3cf7054
2025-12-09 18:16:32.999 29019-29019 InsetsController        com.akslabs.cloudgallery             D  Setting requestedVisibleTypes to -9 (was -528)
2025-12-09 18:16:33.063 29019-29019 InsetsController        com.akslabs.cloudgallery             D  hide(ime(), fromIme=false)
2025-12-09 18:16:33.063 29019-29019 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:9ed9c24f: onCancelled at PHASE_CLIENT_ALREADY_HIDDEN
2025-12-09 18:16:43.655 29019-29019 JobService              com.akslabs.cloudgallery             W  onNetworkChanged() not implemented in androidx.work.impl.background.systemjob.SystemJobService. Must override in a subclass.
2025-12-09 18:16:45.464 29019-29019 InsetsController        com.akslabs.cloudgallery             D  hide(ime(), fromIme=false)
2025-12-09 18:16:45.464 29019-29019 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:2568f36b: onCancelled at PHASE_CLIENT_ALREADY_HIDDEN
2025-12-09 18:16:48.804 29019-29019 LocalViewModel          com.akslabs.cloudgallery             E  ❌ Error collecting from localPhotosFlow
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@768c94c
2025-12-09 18:16:48.814 29019-29019 LocalViewModel          com.akslabs.cloudgallery             E  ❌ Error collecting from localPhotosCount
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@768c94c
2025-12-09 18:16:48.824 29019-29019 RemoteViewModel         com.akslabs.cloudgallery             E  ❌ Error collecting from allCloudPhotosFlow
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@1065eaa
2025-12-09 18:16:48.834 29019-29019 RemoteViewModel         com.akslabs.cloudgallery             E  ❌ Error collecting from totalCloudPhotosCount
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@1065eaa
2025-12-09 18:16:48.881 29019-29019 WindowOnBackDispatcher  com.akslabs.cloudgallery             W  sendCancelIfRunning: isInProgress=false callback=android.app.Activity$$ExternalSyntheticLambda0@b759dd3
2025-12-09 18:16:48.889 29019-29019 ViewRootImpl            com.akslabs.cloudgallery             D  Skipping stats log for color mode
2025-12-09 18:16:49.071 29727-29727 bs.cloudgallery         com.akslabs.cloudgallery             I  Late-enabling -Xcheck:jni
2025-12-09 18:16:49.115 29727-29727 bs.cloudgallery         com.akslabs.cloudgallery             I  Using CollectorTypeCC GC.
2025-12-09 18:16:49.146 29727-29727 nativeloader            com.akslabs.cloudgallery             D  Load libframework-connectivity-tiramisu-jni.so using APEX ns com_android_tethering for caller /apex/com.android.tethering/javalib/framework-connectivity-t.jar: ok
2025-12-09 18:16:49.180 29727-29727 re-initialized>         com.akslabs.cloudgallery             W  type=1400 audit(0.0:1180): avc:  granted  { execute } for  path="/data/data/com.akslabs.cloudgallery/code_cache/startup_agents/1f04feac-agent.so" dev="mmcblk0p61" ino=2031722 scontext=u:r:untrusted_app:s0:c19,c259,c512,c768 tcontext=u:object_r:app_data_file:s0:c19,c259,c512,c768 tclass=file app=com.akslabs.cloudgallery
2025-12-09 18:16:49.201 29727-29727 nativeloader            com.akslabs.cloudgallery             D  Load /data/user/0/com.akslabs.cloudgallery/code_cache/startup_agents/1f04feac-agent.so using system ns (caller=<unknown>): ok
2025-12-09 18:16:49.222 29727-29727 bs.cloudgallery         com.akslabs.cloudgallery             W  DexFile /data/data/com.akslabs.cloudgallery/code_cache/.studio/instruments-843f6601.jar is in boot class path but is not in a known location
2025-12-09 18:16:49.387 29727-29727 bs.cloudgallery         com.akslabs.cloudgallery             W  Redefining intrinsic method java.lang.Thread java.lang.Thread.currentThread(). This may cause the unexpected use of the original definition of java.lang.Thread java.lang.Thread.currentThread()in methods that have already been compiled.
2025-12-09 18:16:49.387 29727-29727 bs.cloudgallery         com.akslabs.cloudgallery             W  Redefining intrinsic method boolean java.lang.Thread.interrupted(). This may cause the unexpected use of the original definition of boolean java.lang.Thread.interrupted()in methods that have already been compiled.
2025-12-09 18:16:49.470 29727-29727 ApplicationLoaders      com.akslabs.cloudgallery             D  Returning zygote-cached class loader: /system_ext/framework/androidx.window.extensions.jar
2025-12-09 18:16:49.471 29727-29727 ApplicationLoaders      com.akslabs.cloudgallery             D  Returning zygote-cached class loader: /system_ext/framework/androidx.window.sidecar.jar
2025-12-09 18:16:49.483 29727-29727 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes9.dm': No such file or directory
2025-12-09 18:16:49.493 29727-29727 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes6.dm': No such file or directory
2025-12-09 18:16:49.501 29727-29727 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes4.dm': No such file or directory
2025-12-09 18:16:49.506 29727-29727 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes7.dm': No such file or directory
2025-12-09 18:16:49.510 29727-29727 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/app/~~filE95L3nl1ruaMLkN4mFQ==/com.akslabs.cloudgallery-rxMr6hVX3OngZympqGUPAA==/base.dm': No such file or directory
2025-12-09 18:16:49.510 29727-29727 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/app/~~filE95L3nl1ruaMLkN4mFQ==/com.akslabs.cloudgallery-rxMr6hVX3OngZympqGUPAA==/base.dm': No such file or directory
2025-12-09 18:16:50.351 29727-29727 nativeloader            com.akslabs.cloudgallery             D  Configuring clns-7 for other apk /data/app/~~filE95L3nl1ruaMLkN4mFQ==/com.akslabs.cloudgallery-rxMr6hVX3OngZympqGUPAA==/base.apk. target_sdk_version=36, uses_libraries=, library_path=/data/app/~~filE95L3nl1ruaMLkN4mFQ==/com.akslabs.cloudgallery-rxMr6hVX3OngZympqGUPAA==/lib/arm64:/data/app/~~filE95L3nl1ruaMLkN4mFQ==/com.akslabs.cloudgallery-rxMr6hVX3OngZympqGUPAA==/base.apk!/lib/arm64-v8a, permitted_path=/data:/mnt/expand:/data/user/0/com.akslabs.cloudgallery
2025-12-09 18:16:50.370 29727-29727 bs.cloudgallery         com.akslabs.cloudgallery             I  AssetManager2(0x75886dd318) locale list changing from [] to [en-IN]
2025-12-09 18:16:50.374 29727-29727 bs.cloudgallery         com.akslabs.cloudgallery             I  AssetManager2(0x75886d9ad8) locale list changing from [] to [en-IN]
2025-12-09 18:16:50.386 29727-29727 GraphicsEnvironment     com.akslabs.cloudgallery             V  Currently set values for:
2025-12-09 18:16:50.386 29727-29727 GraphicsEnvironment     com.akslabs.cloudgallery             V    angle_gl_driver_selection_pkgs=[com.android.angle, com.linecorp.b612.android, com.campmobile.snow, com.google.android.apps.tachyon]
2025-12-09 18:16:50.386 29727-29727 GraphicsEnvironment     com.akslabs.cloudgallery             V    angle_gl_driver_selection_values=[angle, native, native, native]
2025-12-09 18:16:50.386 29727-29727 GraphicsEnvironment     com.akslabs.cloudgallery             V  com.akslabs.cloudgallery is not listed in per-application setting
2025-12-09 18:16:50.386 29727-29727 GraphicsEnvironment     com.akslabs.cloudgallery             V  Neither updatable production driver nor prerelease driver is supported.
2025-12-09 18:16:50.602 29727-29727 WM-WrkMgrInitializer    com.akslabs.cloudgallery             D  Initializing WorkManager with default configuration.
2025-12-09 18:16:50.788 29727-29727 WM-PackageManagerHelper com.akslabs.cloudgallery             D  Skipping component enablement for androidx.work.impl.background.systemjob.SystemJobService
2025-12-09 18:16:50.788 29727-29727 WM-Schedulers           com.akslabs.cloudgallery             D  Created SystemJobScheduler and enabled SystemJobService
2025-12-09 18:16:50.800 29727-29747 WM-ForceStopRunnable    com.akslabs.cloudgallery             D  The default process name was not specified.
2025-12-09 18:16:50.803 29727-29747 WM-ForceStopRunnable    com.akslabs.cloudgallery             D  Performing cleanup operations.
2025-12-09 18:16:50.868 29727-29727 KeyProviderManager      com.akslabs.cloudgallery             W  Incomplete keybox provided by overlays
2025-12-09 18:16:51.026 29727-29747 WM-ForceStopRunnable    com.akslabs.cloudgallery             D  Application was force-stopped, rescheduling.
2025-12-09 18:16:51.142 29727-29747 WM-SystemJobScheduler   com.akslabs.cloudgallery             D  Scheduling work ID 4f3991a5-5f1a-4e22-9b4a-c355d5017631Job ID 17
2025-12-09 18:16:51.164 29727-29747 WM-SystemJobScheduler   com.akslabs.cloudgallery             D  Scheduling work ID 277b37ab-6c13-407a-995f-8aeb0515f4a8Job ID 144
2025-12-09 18:16:51.196 29727-29747 WM-SystemJobScheduler   com.akslabs.cloudgallery             D  Scheduling work ID 730ec25f-a563-426c-97a9-463c9d31939bJob ID 179
2025-12-09 18:16:51.204 29727-29727 KeyProviderManager      com.akslabs.cloudgallery             W  Incomplete keybox provided by overlays
2025-12-09 18:16:51.217 29727-29747 WM-SystemJobScheduler   com.akslabs.cloudgallery             D  Scheduling work ID 97a67553-0882-4c53-b133-e2627e6d8e73Job ID 173
2025-12-09 18:16:51.238 29727-29747 WM-SystemJobScheduler   com.akslabs.cloudgallery             D  Scheduling work ID 98896a65-cd04-45f5-80d8-785180cac635Job ID 177
2025-12-09 18:16:51.262 29727-29747 WM-SystemJobScheduler   com.akslabs.cloudgallery             D  Scheduling work ID 62067714-b94b-48bc-818b-647f7fde3ab6Job ID 178
2025-12-09 18:16:51.266 29727-29747 WM-GreedyScheduler      com.akslabs.cloudgallery             D  Starting tracking for 98896a65-cd04-45f5-80d8-785180cac635
2025-12-09 18:16:51.343 29727-29752 WM-ConstraintTracker    com.akslabs.cloudgallery             D  NetworkStateTracker24: initial state = NetworkState(isConnected=true, isValidated=true, isMetered=true, isNotRoaming=true)
2025-12-09 18:16:51.344 29727-29752 WM-NetworkStateTracker  com.akslabs.cloudgallery             D  Registering network callback
2025-12-09 18:16:51.355 29727-29753 WM-NetworkStateTracker  com.akslabs.cloudgallery             D  Network capabilities changed: [ Transports: CELLULAR Capabilities: SUPL&INTERNET&NOT_RESTRICTED&TRUSTED&NOT_VPN&VALIDATED&NOT_ROAMING&FOREGROUND&NOT_CONGESTED&NOT_SUSPENDED&NOT_VCN_MANAGED&NOT_BANDWIDTH_CONSTRAINED LinkUpBandwidth>=4794Kbps LinkDnBandwidth>=4794Kbps Specifier: <TelephonyNetworkSpecifier [mSubId = 1]> SubscriptionIds: {1} UnderlyingNetworks: Null]
2025-12-09 18:16:51.356 29727-29752 WM-PackageManagerHelper com.akslabs.cloudgallery             D  Skipping component enablement for androidx.work.impl.background.systemalarm.RescheduleReceiver
2025-12-09 18:16:51.357 29727-29752 WM-GreedyScheduler      com.akslabs.cloudgallery             D  Constraints met: Scheduling work ID WorkGenerationalId(workSpecId=98896a65-cd04-45f5-80d8-785180cac635, generation=0)
2025-12-09 18:16:51.395 29727-29752 WM-Processor            com.akslabs.cloudgallery             D  Processor: processing WorkGenerationalId(workSpecId=98896a65-cd04-45f5-80d8-785180cac635, generation=0)
2025-12-09 18:16:51.411 29727-29727 KeyProviderManager      com.akslabs.cloudgallery             W  Incomplete keybox provided by overlays
2025-12-09 18:16:51.424 29727-29752 WM-WorkerFactory        com.akslabs.cloudgallery             E  Could not instantiate com.akslabs.cloudgallery.workers.PeriodicPhotoBackupWorker (Fix with AI)
                                                                                                    java.lang.reflect.InvocationTargetException
                                                                                                    	at java.lang.reflect.Constructor.newInstance0(Native Method)
                                                                                                    	at java.lang.reflect.Constructor.newInstance(Constructor.java:343)
                                                                                                    	at androidx.work.WorkerFactory.createWorkerWithDefaultFallback$fallbackToReflection(WorkerFactory.kt:88)
                                                                                                    	at androidx.work.WorkerFactory.createWorkerWithDefaultFallback(WorkerFactory.kt:96)
                                                                                                    	at androidx.work.impl.WorkerWrapper.runWorker(WorkerWrapper.kt:234)
                                                                                                    	at androidx.work.impl.WorkerWrapper.access$runWorker(WorkerWrapper.kt:67)
                                                                                                    	at androidx.work.impl.WorkerWrapper$launch$1$resolution$1.invokeSuspend(WorkerWrapper.kt:98)
                                                                                                    	at androidx.work.impl.WorkerWrapper$launch$1$resolution$1.invoke(Unknown Source:8)
                                                                                                    	at androidx.work.impl.WorkerWrapper$launch$1$resolution$1.invoke(Unknown Source:4)
                                                                                                    	at kotlinx.coroutines.intrinsics.UndispatchedKt.startUndispatchedOrReturn(Undispatched.kt:42)
                                                                                                    	at kotlinx.coroutines.BuildersKt__Builders_commonKt.withContext(Builders.common.kt:164)
                                                                                                    	at kotlinx.coroutines.BuildersKt.withContext(Unknown Source:1)
                                                                                                    	at androidx.work.impl.WorkerWrapper$launch$1.invokeSuspend(WorkerWrapper.kt:98)
                                                                                                    	at androidx.work.impl.WorkerWrapper$launch$1.invoke(Unknown Source:8)
                                                                                                    	at androidx.work.impl.WorkerWrapper$launch$1.invoke(Unknown Source:4)
                                                                                                    	at androidx.work.ListenableFutureKt$launchFuture$1$2.invokeSuspend(ListenableFuture.kt:42)
                                                                                                    	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:34)
                                                                                                    	at kotlinx.coroutines.DispatchedTask.run(DispatchedTask.kt:101)
                                                                                                    	at androidx.work.impl.utils.SerialExecutorImpl$Task.run(SerialExecutorImpl.java:96)
                                                                                                    	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1156)
                                                                                                    	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:651)
                                                                                                    	at java.lang.Thread.run(Thread.java:1119)
                                                                                                    Caused by: kotlin.UninitializedPropertyAccessException: lateinit property encryptedPreferences has not been initialized
                                                                                                    	at com.akslabs.cloudgallery.data.localdb.Preferences.getEncryptedLong(Preferences.kt:123)
                                                                                                    	at com.akslabs.cloudgallery.workers.PeriodicPhotoBackupWorker.<init>(PeriodicPhotoBackupWorker.kt:33)
                                                                                                    	at java.lang.reflect.Constructor.newInstance0(Native Method) 
                                                                                                    	at java.lang.reflect.Constructor.newInstance(Constructor.java:343) 
                                                                                                    	at androidx.work.WorkerFactory.createWorkerWithDefaultFallback$fallbackToReflection(WorkerFactory.kt:88) 
                                                                                                    	at androidx.work.WorkerFactory.createWorkerWithDefaultFallback(WorkerFactory.kt:96) 
                                                                                                    	at androidx.work.impl.WorkerWrapper.runWorker(WorkerWrapper.kt:234) 
                                                                                                    	at androidx.work.impl.WorkerWrapper.access$runWorker(WorkerWrapper.kt:67) 
                                                                                                    	at androidx.work.impl.WorkerWrapper$launch$1$resolution$1.invokeSuspend(WorkerWrapper.kt:98) 
                                                                                                    	at androidx.work.impl.WorkerWrapper$launch$1$resolution$1.invoke(Unknown Source:8) 
                                                                                                    	at androidx.work.impl.WorkerWrapper$launch$1$resolution$1.invoke(Unknown Source:4) 
                                                                                                    	at kotlinx.coroutines.intrinsics.UndispatchedKt.startUndispatchedOrReturn(Undispatched.kt:42) 
                                                                                                    	at kotlinx.coroutines.BuildersKt__Builders_commonKt.withContext(Builders.common.kt:164) 
                                                                                                    	at kotlinx.coroutines.BuildersKt.withContext(Unknown Source:1) 
                                                                                                    	at androidx.work.impl.WorkerWrapper$launch$1.invokeSuspend(WorkerWrapper.kt:98) 
                                                                                                    	at androidx.work.impl.WorkerWrapper$launch$1.invoke(Unknown Source:8) 
                                                                                                    	at androidx.work.impl.WorkerWrapper$launch$1.invoke(Unknown Source:4) 
                                                                                                    	at androidx.work.ListenableFutureKt$launchFuture$1$2.invokeSuspend(ListenableFuture.kt:42) 
                                                                                                    	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:34) 
                                                                                                    	at kotlinx.coroutines.DispatchedTask.run(DispatchedTask.kt:101) 
                                                                                                    	at androidx.work.impl.utils.SerialExecutorImpl$Task.run(SerialExecutorImpl.java:96) 
                                                                                                    	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1156) 
                                                                                                    	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:651) 
                                                                                                    	at java.lang.Thread.run(Thread.java:1119) 
2025-12-09 18:16:51.425 29727-29752 WM-WorkerWrapper        com.akslabs.cloudgallery             E  Could not create Worker com.akslabs.cloudgallery.workers.PeriodicPhotoBackupWorker
2025-12-09 18:16:51.495 29727-29727 ImageLoaderModule       com.akslabs.cloudgallery             I  === INITIALIZING IMAGE LOADERS ===
2025-12-09 18:16:51.587 29727-29727 ImageLoaderModule       com.akslabs.cloudgallery             D  Created OkHttpClient with 30s connect, 60s read/write timeouts
2025-12-09 18:16:51.587 29727-29727 ImageLoaderModule       com.akslabs.cloudgallery             D  Creating remoteImageLoader...
2025-12-09 18:16:51.591 29727-29727 ImageLoaderModule       com.akslabs.cloudgallery             I  remoteImageLoader created successfully
2025-12-09 18:16:51.591 29727-29727 ImageLoaderModule       com.akslabs.cloudgallery             D  Creating thumbnailImageLoader...
2025-12-09 18:16:51.592 29727-29727 ImageLoaderModule       com.akslabs.cloudgallery             I  thumbnailImageLoader created successfully
2025-12-09 18:16:51.592 29727-29727 ImageLoaderModule       com.akslabs.cloudgallery             I  === IMAGE LOADERS INITIALIZATION COMPLETE ===
2025-12-09 18:16:51.593 29727-29727 ImageLoaderModule       com.akslabs.cloudgallery             I  Available loaders:
2025-12-09 18:16:51.593 29727-29727 ImageLoaderModule       com.akslabs.cloudgallery             I  - defaultImageLoader: ✓
2025-12-09 18:16:51.593 29727-29727 ImageLoaderModule       com.akslabs.cloudgallery             I  - remoteImageLoader: ✓
2025-12-09 18:16:51.593 29727-29727 ImageLoaderModule       com.akslabs.cloudgallery             I  - thumbnailImageLoader: ✓
2025-12-09 18:16:51.761 29727-29727 bs.cloudgallery         com.akslabs.cloudgallery             I  AssetManager2(0x75886dc698) locale list changing from [] to [en-IN]
2025-12-09 18:16:51.844 29727-29727 DesktopModeFlagsUtil    com.akslabs.cloudgallery             D  Toggle override initialized to: OVERRIDE_UNSET
2025-12-09 18:16:51.870 29727-29760 DatabaseDebugHelper     com.akslabs.cloudgallery             I  === DATABASE DEBUG REPORT ===
2025-12-09 18:16:51.921 29727-29760 DatabaseDebugHelper     com.akslabs.cloudgallery             I  Database version: 6
2025-12-09 18:16:51.956 29727-29750 WM-SystemJobScheduler   com.akslabs.cloudgallery             D  Scheduling work ID b7e10afd-b522-4346-a2fb-8712546afabcJob ID 180
2025-12-09 18:16:51.963 29727-29750 WM-GreedyScheduler      com.akslabs.cloudgallery             D  Starting tracking for b7e10afd-b522-4346-a2fb-8712546afabc
2025-12-09 18:16:51.965 29727-29727 Choreographer           com.akslabs.cloudgallery             I  Skipped 66 frames!  The application may be doing too much work on its main thread.
2025-12-09 18:16:51.976 29727-29750 WM-ConstraintTracker    com.akslabs.cloudgallery             D  BatteryNotLowTracker: initial state = true
2025-12-09 18:16:51.977 29727-29750 WM-BrdcstRcvrCnstrntTrc com.akslabs.cloudgallery             D  BatteryNotLowTracker: registering receiver
2025-12-09 18:16:51.981 29727-29752 WM-GreedyScheduler      com.akslabs.cloudgallery             D  Constraints met: Scheduling work ID WorkGenerationalId(workSpecId=b7e10afd-b522-4346-a2fb-8712546afabc, generation=0)
2025-12-09 18:16:51.994 29727-29751 WM-Processor            com.akslabs.cloudgallery             D  Processor: processing WorkGenerationalId(workSpecId=b7e10afd-b522-4346-a2fb-8712546afabc, generation=0)
2025-12-09 18:16:52.068 29727-29761 DatabaseDebugHelper     com.akslabs.cloudgallery             I  Record counts:
2025-12-09 18:16:52.068 29727-29761 DatabaseDebugHelper     com.akslabs.cloudgallery             I    Total photos: 1266
2025-12-09 18:16:52.068 29727-29761 DatabaseDebugHelper     com.akslabs.cloudgallery             I    Photos with remoteId: 62
2025-12-09 18:16:52.068 29727-29761 DatabaseDebugHelper     com.akslabs.cloudgallery             I    Total remote photos: 151
2025-12-09 18:16:52.068 29727-29761 DatabaseDebugHelper     com.akslabs.cloudgallery             I  Sample uploaded photos:
2025-12-09 18:16:52.068 29727-29761 DatabaseDebugHelper     com.akslabs.cloudgallery             I    Photo: localId=1000002432, remoteId=BQACAgUAAyEGAASeEFIcAAISC2k14xFD1aQ_Fnl9hggmvmcq2a34AAKuGwACqNuxVafkNxG2MxWzNgQ, type=png
2025-12-09 18:16:52.068 29727-29761 DatabaseDebugHelper     com.akslabs.cloudgallery             I    Photo: localId=1000002433, remoteId=BQACAgUAAyEGAASeEFIcAAISDGk14xXMwt_3XsP4fRjQyVHiLq3sAAKvGwACqNuxVTPzZGq0rGx-NgQ, type=png
2025-12-09 18:16:52.068 29727-29761 DatabaseDebugHelper     com.akslabs.cloudgallery             I    Photo: localId=1000002434, remoteId=BQACAgUAAyEGAASeEFIcAAISBGkyxSVkniQ8XerGNt1HFZXf7sr3AALXGgACZFmZVc4PqtaaLbzxNgQ, type=png
2025-12-09 18:16:52.068 29727-29761 DatabaseDebugHelper     com.akslabs.cloudgallery             I  Sample remote photos:
2025-12-09 18:16:52.068 29727-29761 DatabaseDebugHelper     com.akslabs.cloudgallery             I    RemotePhoto: remoteId=BQACAgUAAyEGAASeEFIcAAISCGk1rD3z-H4CUUILEZ_2xM8lh_egAAJIGwACqNuxVa6TYf3cfoMYNgQ, type=jpg, fileName=-17623686672599265309087664342293844020.jpg
2025-12-09 18:16:52.068 29727-29761 DatabaseDebugHelper     com.akslabs.cloudgallery             I    RemotePhoto: remoteId=BQACAgUAAyEGAASeEFIcAAIBj2iPQ6-FPeZUfk6cNN5tKBSh0GxEAAKBFwAC8eiAVLhoqNzg0uGRNgQ, type=jpg, fileName=3907716578206654586264069117857707451.jpg
2025-12-09 18:16:52.069 29727-29761 DatabaseDebugHelper     com.akslabs.cloudgallery             I    RemotePhoto: remoteId=BQACAgUAAyEGAASeEFIcAAIBimiPJut7WOsbRP51Z3CuUpPCb-ajAALaFgAC8eiAVBVfvc0NGF-6NgQ, type=jpg, fileName=57243397926246794571503127365130511322.jpg
2025-12-09 18:16:52.069 29727-29761 DatabaseDebugHelper     com.akslabs.cloudgallery             W  DATA INCONSISTENCY: Uploaded photos count (62) != Remote photos count (151)
2025-12-09 18:16:52.069 29727-29761 DatabaseDebugHelper     com.akslabs.cloudgallery             I  === END DATABASE DEBUG REPORT ===
2025-12-09 18:16:52.306 29727-29727 bs.cloudgallery         com.akslabs.cloudgallery             W  Accessing hidden method Landroid/os/SystemProperties;->addChangeCallback(Ljava/lang/Runnable;)V (unsupported, reflection, allowed)
2025-12-09 18:16:52.526 29727-29747 bs.cloudgallery         com.akslabs.cloudgallery             W  Accessing hidden method Landroid/database/sqlite/SQLiteDatabase;->getThreadSession()Landroid/database/sqlite/SQLiteSession; (unsupported, reflection, allowed)
2025-12-09 18:16:52.526 29727-29747 bs.cloudgallery         com.akslabs.cloudgallery             W  Accessing hidden method Landroid/database/sqlite/SQLiteSession;->beginTransaction(ILandroid/database/sqlite/SQLiteTransactionListener;ILandroid/os/CancellationSignal;)V (unsupported, reflection, allowed)
2025-12-09 18:16:52.554 29727-29727 MainPage                com.akslabs.cloudgallery             D  Selection Debug: selected=0, total=0, route=null
2025-12-09 18:16:52.833 29727-29727 LocalViewModel          com.akslabs.cloudgallery             E  🚀 === LOCAL VIEW MODEL INITIALIZED ===
2025-12-09 18:16:52.833 29727-29727 LocalViewModel          com.akslabs.cloudgallery             I  === LOCAL PHOTOS DATABASE DEBUG ===
2025-12-09 18:16:52.834 29727-29727 LocalViewModel          com.akslabs.cloudgallery             I  Local total count flow created: null
2025-12-09 18:16:52.834 29727-29727 LocalViewModel          com.akslabs.cloudgallery             I  === END LOCAL PHOTOS DATABASE DEBUG ===
2025-12-09 18:16:52.844 29727-29727 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-12-09 18:16:52.844 29727-29727 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 60, PrefetchDistance: 64, JumpThreshold: 160
2025-12-09 18:16:52.863 29727-29727 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-12-09 18:16:52.865 29727-29727 LocalViewModel          com.akslabs.cloudgallery             E  📊 Local photos count updated: 0
2025-12-09 18:16:52.875 29727-29727 RemoteViewModel         com.akslabs.cloudgallery             D  === CREATING NEW PAGING SOURCE ===
2025-12-09 18:16:52.875 29727-29727 RemoteViewModel         com.akslabs.cloudgallery             D  PageSize: 24, PrefetchDistance: 72, JumpThreshold: 120
2025-12-09 18:16:52.877 29727-29727 RemoteViewModel         com.akslabs.cloudgallery             D  PagingSource created: null
2025-12-09 18:16:52.881 29727-29727 RemoteViewModel         com.akslabs.cloudgallery             E  📄 New PagingData received in ViewModel
2025-12-09 18:16:52.882 29727-29727 RemoteViewModel         com.akslabs.cloudgallery             E  📊 Total count updated: 0
2025-12-09 18:16:53.157 29727-29756 AdrenoGLES-0            com.akslabs.cloudgallery             I  QUALCOMM build                   : 95db91f, Ifbc588260a
                                                                                                    Build Date                       : 09/24/20
                                                                                                    OpenGL ES Shader Compiler Version: EV031.32.02.01
                                                                                                    Local Branch                     : mybrancheafe5b6d-fb5b-f1b0-b904-5cb90179c3e0
                                                                                                    Remote Branch                    : quic/gfx-adreno.lnx.1.0.r114-rel
                                                                                                    Remote Branch                    : NONE
                                                                                                    Reconstruct Branch               : NOTHING
2025-12-09 18:16:53.157 29727-29756 AdrenoGLES-0            com.akslabs.cloudgallery             I  Build Config                     : S P 10.0.7 AArch64
2025-12-09 18:16:53.157 29727-29756 AdrenoGLES-0            com.akslabs.cloudgallery             I  Driver Path                      : /vendor/lib64/egl/libGLESv2_adreno.so
2025-12-09 18:16:53.192 29727-29756 AdrenoGLES-0            com.akslabs.cloudgallery             I  PFP: 0x016ee190, ME: 0x00000000
2025-12-09 18:16:53.293 29727-29773 Gralloc4                com.akslabs.cloudgallery             I  mapper 4.x is not supported
2025-12-09 18:16:53.294 29727-29773 Gralloc3                com.akslabs.cloudgallery             W  mapper 3.x is not supported
2025-12-09 18:16:53.301 29727-29773 Gralloc2                com.akslabs.cloudgallery             I  Adding additional valid usage bits: 0x8202000
2025-12-09 18:16:53.344 29727-29727 WM-Processor            com.akslabs.cloudgallery             D  Processor 98896a65-cd04-45f5-80d8-785180cac635 executed; reschedule = false
2025-12-09 18:16:53.344 29727-29727 WM-GreedyScheduler      com.akslabs.cloudgallery             D  Stopping tracking for WorkGenerationalId(workSpecId=98896a65-cd04-45f5-80d8-785180cac635, generation=0)
2025-12-09 18:16:53.354 29727-29752 WM-GreedyScheduler      com.akslabs.cloudgallery             D  Cancelling work ID 98896a65-cd04-45f5-80d8-785180cac635
2025-12-09 18:16:53.358 29727-29727 WM-WorkerWrapper        com.akslabs.cloudgallery             D  Starting work for com.akslabs.cloudgallery.workers.CloudPhotoSyncWorker
2025-12-09 18:16:53.362 29727-29761 CloudPhotoSyncWorker    com.akslabs.cloudgallery             I  === CLOUD PHOTO SYNC WORKER STARTED ===
2025-12-09 18:16:53.370 29727-29738 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=2495ms; Flags=1, FrameTimelineVsyncId=8433174, IntendedVsync=14574956375829, Vsync=14576056333941, InputEventId=0, HandleInputStart=14576068729959, AnimationStart=14576068752302, PerformTraversalsStart=14576069114281, DrawStart=14577388854125, FrameDeadline=14574973042495, FrameInterval=14576067951052, FrameStartTime=16666032, SyncQueued=14577423238135, SyncStart=14577423350010, IssueDrawCommandsStart=14577423938760, SwapBuffers=14577440890896, FrameCompleted=14577451676573, DequeueBufferDuration=15469, QueueBufferDuration=629896, GpuCompleted=14577451676573, SwapBuffersCompleted=14577442897250, DisplayPresentTime=8929200823284531200, CommandSubmissionCompleted=14577440890896, 
2025-12-09 18:16:53.416 29727-29752 WM-Processor            com.akslabs.cloudgallery             I  Moving WorkSpec (b7e10afd-b522-4346-a2fb-8712546afabc) to the foreground
2025-12-09 18:16:53.438 29727-29761 CloudPhotoSyncService   com.akslabs.cloudgallery             I  === STARTING FULL CLOUD PHOTO SYNC ===
2025-12-09 18:16:53.445 29727-29761 CloudPhotoSyncService   com.akslabs.cloudgallery             D  Found configured group/channel ID: -1002651869724
2025-12-09 18:16:53.446 29727-29759 CloudPhotoSyncService   com.akslabs.cloudgallery             I  Syncing with channel ID: -1002651869724
2025-12-09 18:16:53.446 29727-29759 CloudPhotoSyncService   com.akslabs.cloudgallery             W  ⚠️  TELEGRAM BOT API LIMITATION:
2025-12-09 18:16:53.446 29727-29759 CloudPhotoSyncService   com.akslabs.cloudgallery             W  Bot API can only access messages from the last 24 hours
2025-12-09 18:16:53.446 29727-29759 CloudPhotoSyncService   com.akslabs.cloudgallery             W  Historical images older than 24 hours cannot be retrieved via Bot API
2025-12-09 18:16:53.446 29727-29759 CloudPhotoSyncService   com.akslabs.cloudgallery             W  This is a Telegram platform limitation, not an app bug
2025-12-09 18:16:53.446 29727-29759 CloudPhotoSyncService   com.akslabs.cloudgallery             E  Exception during full sync (Fix with AI)
                                                                                                    java.lang.ClassCastException: java.lang.Long cannot be cast to java.lang.String
                                                                                                    	at android.app.SharedPreferencesImpl.getString(SharedPreferencesImpl.java:310)
                                                                                                    	at com.akslabs.cloudgallery.data.localdb.Preferences.getString(Preferences.kt:79)
                                                                                                    	at com.akslabs.cloudgallery.services.CloudPhotoSyncService.shouldPerformSync(CloudPhotoSyncService.kt:168)
                                                                                                    	at com.akslabs.cloudgallery.services.CloudPhotoSyncService.access$shouldPerformSync(CloudPhotoSyncService.kt:18)
                                                                                                    	at com.akslabs.cloudgallery.services.CloudPhotoSyncService$performFullSync$1.invokeSuspend(CloudPhotoSyncService.kt:54)
                                                                                                    	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:34)
                                                                                                    	at kotlinx.coroutines.DispatchedTask.run(DispatchedTask.kt:101)
                                                                                                    	at kotlinx.coroutines.scheduling.CoroutineScheduler.runSafely(CoroutineScheduler.kt:589)
                                                                                                    	at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.executeTask(CoroutineScheduler.kt:832)
                                                                                                    	at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.runWorker(CoroutineScheduler.kt:720)
                                                                                                    	at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.run(CoroutineScheduler.kt:707)
2025-12-09 18:16:53.447 29727-29759 CloudPhotoSyncWorker    com.akslabs.cloudgallery             E  Cloud photo sync failed: Sync failed: java.lang.Long cannot be cast to java.lang.String
2025-12-09 18:16:53.447 29727-29759 CloudPhotoSyncWorker    com.akslabs.cloudgallery             I  === CLOUD PHOTO SYNC WORKER FINISHED ===
2025-12-09 18:16:53.449 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-12-09 18:16:53.449 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 0
2025-12-09 18:16:53.449 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos (Paging) itemCount: 0
2025-12-09 18:16:53.449 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  AllPhotos (Custom) size: 0
2025-12-09 18:16:53.450 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-12-09 18:16:53.450 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-12-09 18:16:53.450 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-12-09 18:16:53.450 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-12-09 18:16:53.456 29727-29752 WM-Processor            com.akslabs.cloudgallery             D  Processor cancelling 97a67553-0882-4c53-b133-e2627e6d8e73
2025-12-09 18:16:53.456 29727-29752 WM-Processor            com.akslabs.cloudgallery             D  WorkerWrapper could not be found for 97a67553-0882-4c53-b133-e2627e6d8e73
2025-12-09 18:16:53.464 29727-29727 MainViewModel           com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-12-09 18:16:53.464 29727-29752 WM-GreedyScheduler      com.akslabs.cloudgallery             D  Cancelling work ID 97a67553-0882-4c53-b133-e2627e6d8e73
2025-12-09 18:16:53.480 29727-29761 LocalPhotoGrid          com.akslabs.cloudgallery             D  fetchAllLocalPhotos: Cursor count: 1266
2025-12-09 18:16:53.486 29727-29727 MainViewModel           com.akslabs.cloudgallery             D  === CREATING NEW REMOTE PAGING SOURCE ===
2025-12-09 18:16:53.515 29727-29727 MainViewModel           com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-12-09 18:16:53.532 29727-29752 WM-SystemJobScheduler   com.akslabs.cloudgallery             D  Scheduling work ID 8f47031c-97ce-45f6-9132-407cc4458c94Job ID 181
2025-12-09 18:16:53.537 29727-29752 WM-GreedyScheduler      com.akslabs.cloudgallery             D  Starting work for 8f47031c-97ce-45f6-9132-407cc4458c94
2025-12-09 18:16:53.540 29727-29727 Choreographer           com.akslabs.cloudgallery             I  Skipped 90 frames!  The application may be doing too much work on its main thread.
2025-12-09 18:16:53.553 29727-29751 WM-Processor            com.akslabs.cloudgallery             D  Processor: processing WorkGenerationalId(workSpecId=8f47031c-97ce-45f6-9132-407cc4458c94, generation=0)
2025-12-09 18:16:53.556 29727-29761 LocalPhotoGrid          com.akslabs.cloudgallery             D  fetchAllLocalPhotos: Fetched 1266 photos
2025-12-09 18:16:53.561 29727-29727 MainPage                com.akslabs.cloudgallery             D  Selection Debug: selected=0, total=0, route=device
2025-12-09 18:16:53.612 29727-29727 MainViewModel           com.akslabs.cloudgallery             D  Upload state: false
2025-12-09 18:16:53.613 29727-29727 RemoteViewModel         com.akslabs.cloudgallery             E  📊 Total count updated: 151
2025-12-09 18:16:53.614 29727-29727 MainViewModel           com.akslabs.cloudgallery             D  Upload state: false
2025-12-09 18:16:53.617 29727-29727 WM-SystemJobService     com.akslabs.cloudgallery             D  onStartJob for WorkGenerationalId(workSpecId=b7e10afd-b522-4346-a2fb-8712546afabc, generation=0)
2025-12-09 18:16:53.622 29727-29727 WM-SystemFgDispatcher   com.akslabs.cloudgallery             I  Started foreground service Intent { act=ACTION_START_FOREGROUND cmp=com.akslabs.cloudgallery/androidx.work.impl.foreground.SystemForegroundService (has extras) }
2025-12-09 18:16:53.623 29727-29727 WM-SystemFgDispatcher   com.akslabs.cloudgallery             D  Notifying with (id:2001, workSpecId: b7e10afd-b522-4346-a2fb-8712546afabc, notificationType :1)
2025-12-09 18:16:53.626 29727-29737 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1576ms; Flags=0, FrameTimelineVsyncId=8433715, IntendedVsync=14576139701467, Vsync=14577639687727, InputEventId=0, HandleInputStart=14577643465687, AnimationStart=14577643468395, PerformTraversalsStart=14577698744698, DrawStart=14577698908968, FrameDeadline=14577472947295, FrameInterval=14577643114229, FrameStartTime=16666514, SyncQueued=14577711557145, SyncStart=14577711851260, IssueDrawCommandsStart=14577711948760, SwapBuffers=14577713487198, FrameCompleted=14577716024906, DequeueBufferDuration=14740, QueueBufferDuration=314479, GpuCompleted=14577716024906, SwapBuffersCompleted=14577714641573, DisplayPresentTime=72904454214516736, CommandSubmissionCompleted=14577713487198, 
2025-12-09 18:16:53.631 29727-29751 WM-Processor            com.akslabs.cloudgallery             D  Work WorkGenerationalId(workSpecId=b7e10afd-b522-4346-a2fb-8712546afabc, generation=0) is already enqueued for processing
2025-12-09 18:16:53.632 29727-29727 WM-SystemFgDispatcher   com.akslabs.cloudgallery             D  Notifying with (id:2001, workSpecId: b7e10afd-b522-4346-a2fb-8712546afabc, notificationType :1)
2025-12-09 18:16:53.660 29727-29752 WM-WorkerWrapper        com.akslabs.cloudgallery             I  Worker result FAILURE for Work [ id=b7e10afd-b522-4346-a2fb-8712546afabc, tags={ com.akslabs.cloudgallery.workers.CloudPhotoSyncWorker } ]
2025-12-09 18:16:53.661 29727-29727 WM-SystemJobService     com.akslabs.cloudgallery             D  onStartJob for WorkGenerationalId(workSpecId=8f47031c-97ce-45f6-9132-407cc4458c94, generation=0)
2025-12-09 18:16:53.693 29727-29750 WM-Processor            com.akslabs.cloudgallery             D  Work WorkGenerationalId(workSpecId=8f47031c-97ce-45f6-9132-407cc4458c94, generation=0) is already enqueued for processing
2025-12-09 18:16:53.728 29727-29727 MainPage                com.akslabs.cloudgallery             D  Selection Debug: selected=0, total=1266, route=device
2025-12-09 18:16:54.146 29727-29727 WM-WorkerWrapper        com.akslabs.cloudgallery             D  Starting work for com.akslabs.cloudgallery.workers.SyncDbMediaStoreWorker
2025-12-09 18:16:54.147 29727-29727 LocalViewModel          com.akslabs.cloudgallery             E  📊 Local photos count updated: 1266
2025-12-09 18:16:54.151 29727-29727 InsetsController        com.akslabs.cloudgallery             D  hide(ime(), fromIme=false)
2025-12-09 18:16:54.151 29727-29727 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:f1a6a8ea: onCancelled at PHASE_CLIENT_ALREADY_HIDDEN
2025-12-09 18:16:54.154 29727-29727 WM-Processor            com.akslabs.cloudgallery             D  Processor b7e10afd-b522-4346-a2fb-8712546afabc executed; reschedule = false
2025-12-09 18:16:54.155 29727-29727 WM-GreedyScheduler      com.akslabs.cloudgallery             D  Stopping tracking for WorkGenerationalId(workSpecId=b7e10afd-b522-4346-a2fb-8712546afabc, generation=0)
2025-12-09 18:16:54.156 29727-29727 WM-SystemJobService     com.akslabs.cloudgallery             D  b7e10afd-b522-4346-a2fb-8712546afabc executed on JobScheduler
2025-12-09 18:16:54.158 29727-29727 WM-SystemFgDispatcher   com.akslabs.cloudgallery             D  Removing Notification (id: 2001, workSpecId: WorkGenerationalId(workSpecId=b7e10afd-b522-4346-a2fb-8712546afabc, generation=0), notificationType: 1
2025-12-09 18:16:54.167 29727-29747 WM-GreedyScheduler      com.akslabs.cloudgallery             D  Cancelling work ID b7e10afd-b522-4346-a2fb-8712546afabc
2025-12-09 18:16:54.187 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-12-09 18:16:54.187 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 1266
2025-12-09 18:16:54.187 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos (Paging) itemCount: 0
2025-12-09 18:16:54.187 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  AllPhotos (Custom) size: 1266
2025-12-09 18:16:54.187 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-12-09 18:16:54.187 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-12-09 18:16:54.188 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-12-09 18:16:54.188 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-12-09 18:16:54.195 29727-29747 WM-BrdcstRcvrCnstrntTrc com.akslabs.cloudgallery             D  BatteryNotLowTracker: unregistering receiver
2025-12-09 18:16:54.200 29727-29747 WM-NetworkStateTracker  com.akslabs.cloudgallery             D  Unregistering network callback
2025-12-09 18:16:54.460 29727-29760 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:54.468 29727-29759 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:54.485 29727-29761 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:54.495 29727-29778 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:54.511 29727-29777 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:54.565 29727-29759 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:54.601 29727-29778 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:54.615 29727-29777 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:54.644 29727-29759 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:54.647 29727-29761 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:54.676 29727-29784 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:54.723 29727-29777 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:54.779 29727-29784 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:54.784 29727-29761 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:54.850 29727-29777 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:54.882 29727-29761 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:54.918 29727-29784 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:54.934 29727-29759 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:54.955 29727-29777 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:54.967 29727-29760 ContentValues           com.akslabs.cloudgallery             D  doWork: []
2025-12-09 18:16:54.967 29727-29760 Sync MediaStore         com.akslabs.cloudgallery             D  doWork: Success
2025-12-09 18:16:54.975 29727-29785 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:54.975 29727-29761 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:54.995 29727-29778 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:55.017 29727-29784 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:55.027 29727-29760 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:55.038 29727-29785 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:55.040 29727-29759 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:55.044 29727-29778 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:55.070 29727-29759 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:55.092 29727-29778 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:55.129 29727-29759 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:55.137 29727-29778 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:55.153 29727-29785 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:55.191 29727-29785 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:55.205 29727-29778 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:55.209 29727-29759 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:55.230 29727-29778 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:16:55.382 29727-29727 WM-SystemFgDispatcher   com.akslabs.cloudgallery             I  Stopping foreground service
2025-12-09 18:16:55.383 29727-29727 WM-SystemFgService      com.akslabs.cloudgallery             D  Shutting down.
2025-12-09 18:16:55.393 29727-29727 WM-SystemJobService     com.akslabs.cloudgallery             D  onStopJob for WorkGenerationalId(workSpecId=b7e10afd-b522-4346-a2fb-8712546afabc, generation=0)
2025-12-09 18:16:55.399 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-12-09 18:16:55.399 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 1266
2025-12-09 18:16:55.399 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos (Paging) itemCount: 180
2025-12-09 18:16:55.399 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  AllPhotos (Custom) size: 1266
2025-12-09 18:16:55.399 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-12-09 18:16:55.399 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-12-09 18:16:55.399 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-12-09 18:16:55.399 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-12-09 18:16:55.411 29727-29783 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1676ms; Flags=0, FrameTimelineVsyncId=8434714, IntendedVsync=14577823047483, Vsync=14578306377404, InputEventId=0, HandleInputStart=14578308996260, AnimationStart=14578309001312, PerformTraversalsStart=14578392803812, DrawStart=14578392909541, FrameDeadline=14578273049734, FrameInterval=14578307928812, FrameStartTime=16666549, SyncQueued=14579483207301, SyncStart=14579483287145, IssueDrawCommandsStart=14579483571780, SwapBuffers=14579486632509, FrameCompleted=14579499165843, DequeueBufferDuration=16719, QueueBufferDuration=304167, GpuCompleted=14579499165843, SwapBuffersCompleted=14579487252822, DisplayPresentTime=0, CommandSubmissionCompleted=14579486632509, 
2025-12-09 18:16:55.438 29727-29727 Choreographer           com.akslabs.cloudgallery             I  Skipped 73 frames!  The application may be doing too much work on its main thread.
2025-12-09 18:16:55.606 29727-29752 WM-WorkerWrapper        com.akslabs.cloudgallery             I  Worker result SUCCESS for Work [ id=8f47031c-97ce-45f6-9132-407cc4458c94, tags={ com.akslabs.cloudgallery.workers.SyncDbMediaStoreWorker } ]
2025-12-09 18:16:55.610 29727-29783 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1373ms; Flags=0, FrameTimelineVsyncId=8435278, IntendedVsync=14578320365173, Vsync=14579536954922, InputEventId=0, HandleInputStart=14579541194020, AnimationStart=14579541197405, PerformTraversalsStart=14579665506468, DrawStart=14579665616051, FrameDeadline=14579527702264, FrameInterval=14579540739228, FrameStartTime=16665613, SyncQueued=14579681695791, SyncStart=14579681850791, IssueDrawCommandsStart=14579682366572, SwapBuffers=14579686946468, FrameCompleted=14579693593916, DequeueBufferDuration=27187, QueueBufferDuration=189688, GpuCompleted=14579693593916, SwapBuffersCompleted=14579688030218, DisplayPresentTime=0, CommandSubmissionCompleted=14579686946468, 
2025-12-09 18:16:55.684 29727-29751 WM-SystemJobScheduler   com.akslabs.cloudgallery             D  Scheduling work ID ea118e1f-2971-4a30-9b60-885ecc98621bJob ID 182
2025-12-09 18:16:55.972 29727-29727 WM-Processor            com.akslabs.cloudgallery             D  Processor 8f47031c-97ce-45f6-9132-407cc4458c94 executed; reschedule = false
2025-12-09 18:16:55.972 29727-29727 WM-SystemJobService     com.akslabs.cloudgallery             D  8f47031c-97ce-45f6-9132-407cc4458c94 executed on JobScheduler
2025-12-09 18:16:55.978 29727-29752 WM-GreedyScheduler      com.akslabs.cloudgallery             D  Cancelling work ID 8f47031c-97ce-45f6-9132-407cc4458c94
2025-12-09 18:16:56.036 29727-29727 WM-SystemJobService     com.akslabs.cloudgallery             D  onStopJob for WorkGenerationalId(workSpecId=8f47031c-97ce-45f6-9132-407cc4458c94, generation=0)
2025-12-09 18:16:57.141 29727-29789 ProfileInstaller        com.akslabs.cloudgallery             D  Installing profile for com.akslabs.cloudgallery
2025-12-09 18:16:59.293 29727-29732 bs.cloudgallery         com.akslabs.cloudgallery             I  Background concurrent copying GC freed 19MB AllocSpace bytes, 91(2012KB) LOS objects, 49% free, 9420KB/18MB, paused 99us,37us total 137.465ms
2025-12-09 18:17:01.636 29727-29727 MainPage                com.akslabs.cloudgallery             D  Selection Debug: selected=0, total=151, route=cloud
2025-12-09 18:17:01.761 29727-29727 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-12-09 18:17:01.762 29727-29727 RemotePhotoGrid         com.akslabs.cloudgallery             D  🔍 Starting remote date grouping for 0 photos
2025-12-09 18:17:01.762 29727-29727 RemotePhotoGrid         com.akslabs.cloudgallery             D  ✅ Remote date grouping complete: 0 processed, 0 skipped
2025-12-09 18:17:01.825 29727-29727 MainViewModel           com.akslabs.cloudgallery             D  === CREATING NEW REMOTE PAGING SOURCE ===
2025-12-09 18:17:01.875 29727-29727 MainViewModel           com.akslabs.cloudgallery             D  Upload state: false
2025-12-09 18:17:01.891 29727-29727 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-12-09 18:17:01.894 29727-29727 RemotePhotoGrid         com.akslabs.cloudgallery             D  🔍 Starting remote date grouping for 151 photos
2025-12-09 18:17:01.906 29727-29727 RemotePhotoGrid         com.akslabs.cloudgallery             D  ✅ Remote date grouping complete: 72 processed, 79 skipped
2025-12-09 18:17:01.961 29727-29778 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAIST2k4GgABzhVHbvYw6JrWxjhdnw_WAgACsh4AArquwVU9SJYJG-BfAjYE, size: Size(width=150, height=150)
2025-12-09 18:17:01.962 29727-29778 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:01.963 29727-29778 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAIST2k4GgABzhVHbvYw6JrWxjhdnw_WAgACsh4AArquwVU9SJYJG-BfAjYE
2025-12-09 18:17:01.963 29727-29778 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: png
2025-12-09 18:17:01.963 29727-29778 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 66735963071645025771664547049808185553.png
2025-12-09 18:17:01.963 29727-29778 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 323262
2025-12-09 18:17:01.963 29727-29778 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:01.963 29727-29778 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAIST2k4GgABzhVHbvYw6JrWxjhdnw_WAgACsh4AArquwVU9SJYJG-BfAjYE
2025-12-09 18:17:01.975 29727-29759 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISTmk4Gf8E51zifVTODE_UnPBDHjRtAAKxHgACuq7BVdJ68OMyI6oHNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:01.976 29727-29759 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:01.976 29727-29759 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISTmk4Gf8E51zifVTODE_UnPBDHjRtAAKxHgACuq7BVdJ68OMyI6oHNgQ
2025-12-09 18:17:01.976 29727-29759 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: png
2025-12-09 18:17:01.976 29727-29759 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -104305915468168366117007500943592734.png
2025-12-09 18:17:01.976 29727-29759 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 323262
2025-12-09 18:17:01.976 29727-29759 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:01.976 29727-29759 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISTmk4Gf8E51zifVTODE_UnPBDHjRtAAKxHgACuq7BVdJ68OMyI6oHNgQ
2025-12-09 18:17:01.993 29727-29785 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISTGk4GdXslJRTpKe8QSkC4iykxx8eAAKvHgACuq7BVWQ3-y4YHXE1NgQ, size: Size(width=150, height=150)
2025-12-09 18:17:01.994 29727-29785 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:01.994 29727-29785 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISTGk4GdXslJRTpKe8QSkC4iykxx8eAAKvHgACuq7BVWQ3-y4YHXE1NgQ
2025-12-09 18:17:01.994 29727-29785 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:01.994 29727-29785 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 38979236254974748124199778375570666128.jpg
2025-12-09 18:17:01.994 29727-29785 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 3999309
2025-12-09 18:17:01.994 29727-29785 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:01.994 29727-29785 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISTGk4GdXslJRTpKe8QSkC4iykxx8eAAKvHgACuq7BVWQ3-y4YHXE1NgQ
2025-12-09 18:17:02.013 29727-29760 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISS2k4Ga78clugfaps2KryxG7YxsUSAAKtHgACuq7BVVY1R_Xe2rIvNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.013 29727-29760 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.013 29727-29760 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISS2k4Ga78clugfaps2KryxG7YxsUSAAKtHgACuq7BVVY1R_Xe2rIvNgQ
2025-12-09 18:17:02.013 29727-29760 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.013 29727-29760 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -17926321980551407548818181834234654642.jpg
2025-12-09 18:17:02.013 29727-29760 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 14247
2025-12-09 18:17:02.013 29727-29760 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.013 29727-29760 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISS2k4Ga78clugfaps2KryxG7YxsUSAAKtHgACuq7BVVY1R_Xe2rIvNgQ
2025-12-09 18:17:02.034 29727-29784 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISSmk4B4rGhJymvN6Xb1uIUIGFgamNAAJ_HgACuq7BVZVYLE43JItrNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.034 29727-29784 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.034 29727-29784 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISSmk4B4rGhJymvN6Xb1uIUIGFgamNAAJ_HgACuq7BVZVYLE43JItrNgQ
2025-12-09 18:17:02.034 29727-29784 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.034 29727-29784 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -66741660213027176921227142352250071395.jpg
2025-12-09 18:17:02.034 29727-29784 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 220586
2025-12-09 18:17:02.034 29727-29784 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.034 29727-29784 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISSmk4B4rGhJymvN6Xb1uIUIGFgamNAAJ_HgACuq7BVZVYLE43JItrNgQ
2025-12-09 18:17:02.052 29727-29761 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISSWk4B4iX-wTt1M0YseJ_kmNkheSBAAJ-HgACuq7BVUyMUI29HoBqNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.052 29727-29761 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.052 29727-29761 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISSWk4B4iX-wTt1M0YseJ_kmNkheSBAAJ-HgACuq7BVUyMUI29HoBqNgQ
2025-12-09 18:17:02.052 29727-29761 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.052 29727-29761 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -54319976482011598045019523617316420869.jpg
2025-12-09 18:17:02.052 29727-29761 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 68215
2025-12-09 18:17:02.052 29727-29761 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.052 29727-29761 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISSWk4B4iX-wTt1M0YseJ_kmNkheSBAAJ-HgACuq7BVUyMUI29HoBqNgQ
2025-12-09 18:17:02.070 29727-29777 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISSGk4B4bPPpRsy_NvWU9Hl9xa5styAAJ9HgACuq7BVVokZd-PmQnRNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.070 29727-29777 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.070 29727-29777 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISSGk4B4bPPpRsy_NvWU9Hl9xa5styAAJ9HgACuq7BVVokZd-PmQnRNgQ
2025-12-09 18:17:02.070 29727-29777 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.070 29727-29777 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 86470853926802444855643458901249774122.jpg
2025-12-09 18:17:02.070 29727-29777 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 57201
2025-12-09 18:17:02.070 29727-29777 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.070 29727-29777 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISSGk4B4bPPpRsy_NvWU9Hl9xa5styAAJ9HgACuq7BVVokZd-PmQnRNgQ
2025-12-09 18:17:02.087 29727-29786 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISR2k4B4V8a39vO1UFZ9DmCDD5fjZ3AAJ8HgACuq7BVbDCFMxXjybzNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.087 29727-29786 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.087 29727-29786 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISR2k4B4V8a39vO1UFZ9DmCDD5fjZ3AAJ8HgACuq7BVbDCFMxXjybzNgQ
2025-12-09 18:17:02.087 29727-29786 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.087 29727-29786 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -69534218746957185694710811843165719754.jpg
2025-12-09 18:17:02.087 29727-29786 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 896795
2025-12-09 18:17:02.087 29727-29786 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.087 29727-29786 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISR2k4B4V8a39vO1UFZ9DmCDD5fjZ3AAJ8HgACuq7BVbDCFMxXjybzNgQ
2025-12-09 18:17:02.104 29727-29816 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISRmk4B391Ur-B3oZxr9XwrOW8xXzfAAJ7HgACuq7BVclL-RoX8onmNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.104 29727-29816 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.104 29727-29816 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISRmk4B391Ur-B3oZxr9XwrOW8xXzfAAJ7HgACuq7BVclL-RoX8onmNgQ
2025-12-09 18:17:02.104 29727-29816 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.104 29727-29816 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -17055938619259491057460878480784570804.jpg
2025-12-09 18:17:02.104 29727-29816 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 143583
2025-12-09 18:17:02.104 29727-29816 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.104 29727-29816 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISRmk4B391Ur-B3oZxr9XwrOW8xXzfAAJ7HgACuq7BVclL-RoX8onmNgQ
2025-12-09 18:17:02.122 29727-29817 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISRWk4B3miFvKpu-es5enCj5ssqw7OAAJ6HgACuq7BVQeqqlnlpBYINgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.122 29727-29817 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.122 29727-29817 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISRWk4B3miFvKpu-es5enCj5ssqw7OAAJ6HgACuq7BVQeqqlnlpBYINgQ
2025-12-09 18:17:02.122 29727-29817 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.122 29727-29817 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -1222669993748915715235778988322223971.jpg
2025-12-09 18:17:02.122 29727-29817 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 62475
2025-12-09 18:17:02.122 29727-29817 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.122 29727-29817 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISRWk4B3miFvKpu-es5enCj5ssqw7OAAJ6HgACuq7BVQeqqlnlpBYINgQ
2025-12-09 18:17:02.140 29727-29822 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISRGk4B3aa_h0SnshF7qcz9ZCialt_AAJ5HgACuq7BVYXKdSxZXG5FNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.140 29727-29822 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.140 29727-29822 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISRGk4B3aa_h0SnshF7qcz9ZCialt_AAJ5HgACuq7BVYXKdSxZXG5FNgQ
2025-12-09 18:17:02.140 29727-29822 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.140 29727-29822 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 37828961356114911538642936572326811486.jpg
2025-12-09 18:17:02.140 29727-29822 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 58810
2025-12-09 18:17:02.140 29727-29822 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.140 29727-29822 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISRGk4B3aa_h0SnshF7qcz9ZCialt_AAJ5HgACuq7BVYXKdSxZXG5FNgQ
2025-12-09 18:17:02.158 29727-29823 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISQ2k4B3VoC89TJrEoGmZikzyoV_JyAAJ4HgACuq7BVT0tvpqS6Ba1NgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.158 29727-29823 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.158 29727-29823 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISQ2k4B3VoC89TJrEoGmZikzyoV_JyAAJ4HgACuq7BVT0tvpqS6Ba1NgQ
2025-12-09 18:17:02.158 29727-29823 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.158 29727-29823 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 12262704049492011391340038311159537702.jpg
2025-12-09 18:17:02.158 29727-29823 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 800731
2025-12-09 18:17:02.158 29727-29823 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.158 29727-29823 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISQ2k4B3VoC89TJrEoGmZikzyoV_JyAAJ4HgACuq7BVT0tvpqS6Ba1NgQ
2025-12-09 18:17:02.175 29727-29829 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISQmk4B24MI_3z9opyGWFD0epAz81zAAJ3HgACuq7BVQYpGqGPAtIINgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.175 29727-29829 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.175 29727-29829 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISQmk4B24MI_3z9opyGWFD0epAz81zAAJ3HgACuq7BVQYpGqGPAtIINgQ
2025-12-09 18:17:02.175 29727-29829 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.175 29727-29829 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 51462118640104019605488804954357862468.jpg
2025-12-09 18:17:02.175 29727-29829 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 157889
2025-12-09 18:17:02.176 29727-29829 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.176 29727-29829 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISQmk4B24MI_3z9opyGWFD0epAz81zAAJ3HgACuq7BVQYpGqGPAtIINgQ
2025-12-09 18:17:02.195 29727-29828 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISQWk4B2zek7kPqws5z0BlpsKckl3HAAJ2HgACuq7BVcfl7OfJPWIRNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.195 29727-29828 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.195 29727-29828 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISQWk4B2zek7kPqws5z0BlpsKckl3HAAJ2HgACuq7BVcfl7OfJPWIRNgQ
2025-12-09 18:17:02.195 29727-29828 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.196 29727-29828 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -59512562396899058593370662859273237887.jpg
2025-12-09 18:17:02.196 29727-29828 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 231285
2025-12-09 18:17:02.196 29727-29828 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.196 29727-29828 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISQWk4B2zek7kPqws5z0BlpsKckl3HAAJ2HgACuq7BVcfl7OfJPWIRNgQ
2025-12-09 18:17:02.210 29727-29834 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISQGk4B2pr_W-Ttl3r22EX9fD2zxd7AAJ1HgACuq7BVTg417sGtRy8NgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.210 29727-29834 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.210 29727-29834 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISQGk4B2pr_W-Ttl3r22EX9fD2zxd7AAJ1HgACuq7BVTg417sGtRy8NgQ
2025-12-09 18:17:02.210 29727-29834 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.210 29727-29834 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -13248265543009987853277768459449078062.jpg
2025-12-09 18:17:02.210 29727-29834 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 255729
2025-12-09 18:17:02.210 29727-29834 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.210 29727-29834 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISQGk4B2pr_W-Ttl3r22EX9fD2zxd7AAJ1HgACuq7BVTg417sGtRy8NgQ
2025-12-09 18:17:02.229 29727-29835 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISPmk4B2MYbJcwBoUfVshq9rm45HG8AAJzHgACuq7BVQzouyPn7OveNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.229 29727-29835 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.229 29727-29835 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISPmk4B2MYbJcwBoUfVshq9rm45HG8AAJzHgACuq7BVQzouyPn7OveNgQ
2025-12-09 18:17:02.229 29727-29835 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.229 29727-29835 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 51967083241366325308584991732410992015.jpg
2025-12-09 18:17:02.229 29727-29835 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 81527
2025-12-09 18:17:02.229 29727-29835 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.230 29727-29835 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISPmk4B2MYbJcwBoUfVshq9rm45HG8AAJzHgACuq7BVQzouyPn7OveNgQ
2025-12-09 18:17:02.245 29727-29840 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISPWk4B1RnCvMauFhsqq0c0YYhDa3NAAJyHgACuq7BVXm_qGks68M6NgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.245 29727-29840 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.245 29727-29840 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISPWk4B1RnCvMauFhsqq0c0YYhDa3NAAJyHgACuq7BVXm_qGks68M6NgQ
2025-12-09 18:17:02.245 29727-29840 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.245 29727-29840 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -23568622413020440613875168272293172598.jpg
2025-12-09 18:17:02.245 29727-29840 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 985106
2025-12-09 18:17:02.245 29727-29840 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.245 29727-29840 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISPWk4B1RnCvMauFhsqq0c0YYhDa3NAAJyHgACuq7BVXm_qGks68M6NgQ
2025-12-09 18:17:02.262 29727-29841 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISPGk4B0uuVdnOiiFZ34wmn6KdYvIuAAJxHgACuq7BVY7iKQvVwLbgNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.262 29727-29841 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.262 29727-29841 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISPGk4B0uuVdnOiiFZ34wmn6KdYvIuAAJxHgACuq7BVY7iKQvVwLbgNgQ
2025-12-09 18:17:02.262 29727-29841 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.262 29727-29841 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 25780282115958746212537160405355317426.jpg
2025-12-09 18:17:02.262 29727-29841 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 510678
2025-12-09 18:17:02.262 29727-29841 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.262 29727-29841 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISPGk4B0uuVdnOiiFZ34wmn6KdYvIuAAJxHgACuq7BVY7iKQvVwLbgNgQ
2025-12-09 18:17:02.279 29727-29846 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISO2k4B0alhh5UI16vqeWw-3RJF8GLAAJwHgACuq7BVSZEHu7upw4qNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.279 29727-29846 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.279 29727-29846 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISO2k4B0alhh5UI16vqeWw-3RJF8GLAAJwHgACuq7BVSZEHu7upw4qNgQ
2025-12-09 18:17:02.279 29727-29846 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.279 29727-29846 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 22104452995747380878688689768219556062.jpg
2025-12-09 18:17:02.279 29727-29846 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 127105
2025-12-09 18:17:02.279 29727-29846 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.279 29727-29846 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISO2k4B0alhh5UI16vqeWw-3RJF8GLAAJwHgACuq7BVSZEHu7upw4qNgQ
2025-12-09 18:17:02.296 29727-29847 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISOmk4B0Sf7GKFRC5XxHWmzPlN5w_jAAJvHgACuq7BVR5S6HpSH4wvNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.296 29727-29847 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.296 29727-29847 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISOmk4B0Sf7GKFRC5XxHWmzPlN5w_jAAJvHgACuq7BVR5S6HpSH4wvNgQ
2025-12-09 18:17:02.296 29727-29847 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.296 29727-29847 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 25745530396689829244627214592059360758.jpg
2025-12-09 18:17:02.296 29727-29847 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 165906
2025-12-09 18:17:02.296 29727-29847 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.296 29727-29847 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISOmk4B0Sf7GKFRC5XxHWmzPlN5w_jAAJvHgACuq7BVR5S6HpSH4wvNgQ
2025-12-09 18:17:02.314 29727-29852 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISOWk4B0GYPuH0Objuf17D6VFjEUbfAAJuHgACuq7BVaUGm3N60DcgNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.314 29727-29852 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.314 29727-29852 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISOWk4B0GYPuH0Objuf17D6VFjEUbfAAJuHgACuq7BVaUGm3N60DcgNgQ
2025-12-09 18:17:02.314 29727-29852 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.314 29727-29852 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -56083793053672605433986674938167061735.jpg
2025-12-09 18:17:02.314 29727-29852 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 918113
2025-12-09 18:17:02.314 29727-29852 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.314 29727-29852 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISOWk4B0GYPuH0Objuf17D6VFjEUbfAAJuHgACuq7BVaUGm3N60DcgNgQ
2025-12-09 18:17:02.330 29727-29853 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISOGk4BzDKNPcFhKPsxKF4tgIicgc1AAJsHgACuq7BVRnzsT5aEYogNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.330 29727-29853 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.330 29727-29853 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISOGk4BzDKNPcFhKPsxKF4tgIicgc1AAJsHgACuq7BVRnzsT5aEYogNgQ
2025-12-09 18:17:02.330 29727-29853 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.330 29727-29853 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -5185972839701388666385740418985090319.jpg
2025-12-09 18:17:02.330 29727-29853 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 1004825
2025-12-09 18:17:02.330 29727-29853 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.330 29727-29853 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISOGk4BzDKNPcFhKPsxKF4tgIicgc1AAJsHgACuq7BVRnzsT5aEYogNgQ
2025-12-09 18:17:02.347 29727-29859 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISNWk4Bo6nvvr8VtbNrbtZXoi3dkx7AAJkHgACuq7BVbKGBDXIu2a3NgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.347 29727-29859 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.347 29727-29859 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISNWk4Bo6nvvr8VtbNrbtZXoi3dkx7AAJkHgACuq7BVbKGBDXIu2a3NgQ
2025-12-09 18:17:02.347 29727-29859 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.347 29727-29859 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 27694350883056160642153418728408660386.jpg
2025-12-09 18:17:02.347 29727-29859 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 893565
2025-12-09 18:17:02.347 29727-29859 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.347 29727-29859 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISNWk4Bo6nvvr8VtbNrbtZXoi3dkx7AAJkHgACuq7BVbKGBDXIu2a3NgQ
2025-12-09 18:17:02.364 29727-29858 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISNGk4Bojcv5nsU9yEG9_sJeaw_Cx2AAJjHgACuq7BVbqIpjKzEomzNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.364 29727-29858 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.364 29727-29858 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISNGk4Bojcv5nsU9yEG9_sJeaw_Cx2AAJjHgACuq7BVbqIpjKzEomzNgQ
2025-12-09 18:17:02.364 29727-29858 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.364 29727-29858 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 81381010950402908224394496091790158107.jpg
2025-12-09 18:17:02.364 29727-29858 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 3587684
2025-12-09 18:17:02.364 29727-29858 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.364 29727-29858 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISNGk4Bojcv5nsU9yEG9_sJeaw_Cx2AAJjHgACuq7BVbqIpjKzEomzNgQ
2025-12-09 18:17:02.380 29727-29865 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISM2k4BnFZf3ytXlxjCwm2RgV1K-0XAAJhHgACuq7BVSJg5CNFxVGFNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.380 29727-29865 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.380 29727-29865 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISM2k4BnFZf3ytXlxjCwm2RgV1K-0XAAJhHgACuq7BVSJg5CNFxVGFNgQ
2025-12-09 18:17:02.380 29727-29865 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.380 29727-29865 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 4056351053215901511610220552113032983.jpg
2025-12-09 18:17:02.380 29727-29865 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 4601524
2025-12-09 18:17:02.380 29727-29865 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.380 29727-29865 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISM2k4BnFZf3ytXlxjCwm2RgV1K-0XAAJhHgACuq7BVSJg5CNFxVGFNgQ
2025-12-09 18:17:02.397 29727-29866 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISMWk16U4ZeP9m_7azrMp7iYo1loKjAALUGwACqNuxVZShnQfKn9iMNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.397 29727-29866 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.397 29727-29866 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISMWk16U4ZeP9m_7azrMp7iYo1loKjAALUGwACqNuxVZShnQfKn9iMNgQ
2025-12-09 18:17:02.397 29727-29866 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.397 29727-29866 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 40033026795977047353494464962836767993.jpg
2025-12-09 18:17:02.397 29727-29866 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 1111027
2025-12-09 18:17:02.397 29727-29866 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.397 29727-29866 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISMWk16U4ZeP9m_7azrMp7iYo1loKjAALUGwACqNuxVZShnQfKn9iMNgQ
2025-12-09 18:17:02.414 29727-29871 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISMGk16UfyZZwQ9l6r3QLlkErMgpuXAALTGwACqNuxVbhAMBpwnNEkNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.414 29727-29871 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.414 29727-29871 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISMGk16UfyZZwQ9l6r3QLlkErMgpuXAALTGwACqNuxVbhAMBpwnNEkNgQ
2025-12-09 18:17:02.414 29727-29871 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.414 29727-29871 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 27281772998313705473558970462900670988.jpg
2025-12-09 18:17:02.414 29727-29871 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 2866084
2025-12-09 18:17:02.414 29727-29871 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.414 29727-29871 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISMGk16UfyZZwQ9l6r3QLlkErMgpuXAALTGwACqNuxVbhAMBpwnNEkNgQ
2025-12-09 18:17:02.431 29727-29872 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISL2k16TqJsJ6yUp5V0L5tPfLbioKzAALSGwACqNuxVW6CjPvRrW-8NgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.431 29727-29872 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.431 29727-29872 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISL2k16TqJsJ6yUp5V0L5tPfLbioKzAALSGwACqNuxVW6CjPvRrW-8NgQ
2025-12-09 18:17:02.431 29727-29872 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.431 29727-29872 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -7041779385842348514169979258179592994.jpg
2025-12-09 18:17:02.431 29727-29872 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 971514
2025-12-09 18:17:02.431 29727-29872 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.431 29727-29872 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISL2k16TqJsJ6yUp5V0L5tPfLbioKzAALSGwACqNuxVW6CjPvRrW-8NgQ
2025-12-09 18:17:02.449 29727-29877 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISLmk16TdkMITDN8h31O9KSt2Hemu0AALRGwACqNuxVc4md7uFTSVhNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.449 29727-29877 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.449 29727-29877 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISLmk16TdkMITDN8h31O9KSt2Hemu0AALRGwACqNuxVc4md7uFTSVhNgQ
2025-12-09 18:17:02.449 29727-29877 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.449 29727-29877 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -62762332556329169284773297197242722626.jpg
2025-12-09 18:17:02.449 29727-29877 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 988813
2025-12-09 18:17:02.449 29727-29877 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.449 29727-29877 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISLmk16TdkMITDN8h31O9KSt2Hemu0AALRGwACqNuxVc4md7uFTSVhNgQ
2025-12-09 18:17:02.466 29727-29878 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISLWk148EaGtqTbixQx6wMcvkThNIGAALQGwACqNuxVXUmH6zxfN3sNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.466 29727-29878 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.466 29727-29878 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISLWk148EaGtqTbixQx6wMcvkThNIGAALQGwACqNuxVXUmH6zxfN3sNgQ
2025-12-09 18:17:02.466 29727-29878 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.466 29727-29878 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 8904595978302154468855741790612207816.jpg
2025-12-09 18:17:02.466 29727-29878 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 237369
2025-12-09 18:17:02.466 29727-29878 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.466 29727-29878 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISLWk148EaGtqTbixQx6wMcvkThNIGAALQGwACqNuxVXUmH6zxfN3sNgQ
2025-12-09 18:17:02.482 29727-29883 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISLGk1478i3AFrgylNw4TagZPXkfuuAALPGwACqNuxVXSLLvdYdZ5kNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.483 29727-29883 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.483 29727-29883 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISLGk1478i3AFrgylNw4TagZPXkfuuAALPGwACqNuxVXSLLvdYdZ5kNgQ
2025-12-09 18:17:02.483 29727-29883 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.483 29727-29883 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -60519898706824239866378637257905595395.jpg
2025-12-09 18:17:02.483 29727-29883 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 47228
2025-12-09 18:17:02.483 29727-29883 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.483 29727-29883 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISLGk1478i3AFrgylNw4TagZPXkfuuAALPGwACqNuxVXSLLvdYdZ5kNgQ
2025-12-09 18:17:02.502 29727-29884 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISK2k14756K6IZ4D9_-JVi2391vEMQAALOGwACqNuxVZHliSK8D7meNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.502 29727-29884 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.502 29727-29884 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISK2k14756K6IZ4D9_-JVi2391vEMQAALOGwACqNuxVZHliSK8D7meNgQ
2025-12-09 18:17:02.502 29727-29884 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.502 29727-29884 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -25116319639357521405459770412701707147.jpg
2025-12-09 18:17:02.502 29727-29884 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 392190
2025-12-09 18:17:02.502 29727-29884 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.502 29727-29884 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISK2k14756K6IZ4D9_-JVi2391vEMQAALOGwACqNuxVZHliSK8D7meNgQ
2025-12-09 18:17:02.518 29727-29891 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISKmk1471_ESpcLE2nhxTCUrP6GVp1AALNGwACqNuxVd32fi62NDe-NgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.518 29727-29891 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.518 29727-29891 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISKmk1471_ESpcLE2nhxTCUrP6GVp1AALNGwACqNuxVd32fi62NDe-NgQ
2025-12-09 18:17:02.518 29727-29891 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.518 29727-29891 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 68614204407723687062691905464766641694.jpg
2025-12-09 18:17:02.518 29727-29891 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 1586084
2025-12-09 18:17:02.518 29727-29891 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.518 29727-29891 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISKmk1471_ESpcLE2nhxTCUrP6GVp1AALNGwACqNuxVd32fi62NDe-NgQ
2025-12-09 18:17:02.535 29727-29890 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISKWk147tv8XtvQGIAAa5pSSybvqP76AACzBsAAqjbsVX9ZDPofL9vcjYE, size: Size(width=150, height=150)
2025-12-09 18:17:02.535 29727-29890 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.535 29727-29890 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISKWk147tv8XtvQGIAAa5pSSybvqP76AACzBsAAqjbsVX9ZDPofL9vcjYE
2025-12-09 18:17:02.535 29727-29890 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.535 29727-29890 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -28266777001234782612531490892913463122.jpg
2025-12-09 18:17:02.535 29727-29890 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 541913
2025-12-09 18:17:02.535 29727-29890 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.535 29727-29890 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISKWk147tv8XtvQGIAAa5pSSybvqP76AACzBsAAqjbsVX9ZDPofL9vcjYE
2025-12-09 18:17:02.551 29727-29896 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISKGk147rLWgkfhO6nA_d8PshiFY0wAALLGwACqNuxVebx48O4BqUuNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.551 29727-29896 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.551 29727-29896 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISKGk147rLWgkfhO6nA_d8PshiFY0wAALLGwACqNuxVebx48O4BqUuNgQ
2025-12-09 18:17:02.551 29727-29896 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.551 29727-29896 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -11111680713350000044506901480385368006.jpg
2025-12-09 18:17:02.551 29727-29896 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 13022
2025-12-09 18:17:02.551 29727-29896 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.551 29727-29896 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISKGk147rLWgkfhO6nA_d8PshiFY0wAALLGwACqNuxVebx48O4BqUuNgQ
2025-12-09 18:17:02.568 29727-29897 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISJ2k147liO5zloI9Tn0r_s9bKHkBJAALKGwACqNuxVXkBp4xxXfQpNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:02.568 29727-29897 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:02.568 29727-29897 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISJ2k147liO5zloI9Tn0r_s9bKHkBJAALKGwACqNuxVXkBp4xxXfQpNgQ
2025-12-09 18:17:02.568 29727-29897 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:02.568 29727-29897 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -77696314321773935756531522480030051042.jpg
2025-12-09 18:17:02.568 29727-29897 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 221900
2025-12-09 18:17:02.568 29727-29897 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:02.568 29727-29897 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISJ2k147liO5zloI9Tn0r_s9bKHkBJAALKGwACqNuxVXkBp4xxXfQpNgQ
2025-12-09 18:17:02.773 29727-29727 Choreographer           com.akslabs.cloudgallery             I  Skipped 53 frames!  The application may be doing too much work on its main thread.
2025-12-09 18:17:03.521 29727-29732 bs.cloudgallery         com.akslabs.cloudgallery             I  Background young concurrent copying GC freed 4676KB AllocSpace bytes, 0(0B) LOS objects, 0% free, 18MB/18MB, paused 1.081ms,529us total 292.786ms
2025-12-09 18:17:03.756 29727-29783 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=957ms; Flags=0, FrameTimelineVsyncId=8442292, IntendedVsync=14586889716201, Vsync=14586906382989, InputEventId=0, HandleInputStart=14586919268652, AnimationStart=14586919271621, PerformTraversalsStart=14587706160267, DrawStart=14587706276465, FrameDeadline=14587739722209, FrameInterval=14586919258392, FrameStartTime=16666982, SyncQueued=14587840295006, SyncStart=14587840411465, IssueDrawCommandsStart=14587841290319, SwapBuffers=14587842661256, FrameCompleted=14587847753079, DequeueBufferDuration=17500, QueueBufferDuration=258802, GpuCompleted=14587847753079, SwapBuffersCompleted=14587843625631, DisplayPresentTime=14585855379174, CommandSubmissionCompleted=14587842661256, 
2025-12-09 18:17:03.774 29727-29727 Choreographer           com.akslabs.cloudgallery             I  Skipped 57 frames!  The application may be doing too much work on its main thread.
2025-12-09 18:17:03.793 29727-29732 bs.cloudgallery         com.akslabs.cloudgallery             I  Background concurrent copying GC freed 8386KB AllocSpace bytes, 0(0B) LOS objects, 49% free, 14MB/29MB, paused 269us,158us total 270.567ms
2025-12-09 18:17:03.960 29727-29783 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1134ms; Flags=0, FrameTimelineVsyncId=8442326, IntendedVsync=14586923046826, Vsync=14587873041601, InputEventId=0, HandleInputStart=14587877195839, AnimationStart=14587877199381, PerformTraversalsStart=14588002303548, DrawStart=14588002388808, FrameDeadline=14587873067629, FrameInterval=14587876728860, FrameStartTime=16666982, SyncQueued=14588050229589, SyncStart=14588050488339, IssueDrawCommandsStart=14588050832819, SwapBuffers=14588051839537, FrameCompleted=14588057331777, DequeueBufferDuration=17604, QueueBufferDuration=275625, GpuCompleted=14588057331777, SwapBuffersCompleted=14588052550162, DisplayPresentTime=14585872043288, CommandSubmissionCompleted=14588051839537, 
2025-12-09 18:17:09.282 29727-29727 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-12-09 18:17:09.490 29727-29727 InsetsController        com.akslabs.cloudgallery             D  Setting requestedVisibleTypes to -528 (was -9)
2025-12-09 18:17:09.503 29727-29902 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISQGk4B2pr_W-Ttl3r22EX9fD2zxd7AAJ1HgACuq7BVTg417sGtRy8NgQ, size: Size(width=1080, height=2264)
2025-12-09 18:17:09.503 29727-29902 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:09.503 29727-29902 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISQGk4B2pr_W-Ttl3r22EX9fD2zxd7AAJ1HgACuq7BVTg417sGtRy8NgQ
2025-12-09 18:17:09.503 29727-29902 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:09.503 29727-29902 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 
2025-12-09 18:17:09.503 29727-29902 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: null
2025-12-09 18:17:09.504 29727-29902 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=1080, height=2264)
2025-12-09 18:17:09.504 29727-29902 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISQGk4B2pr_W-Ttl3r22EX9fD2zxd7AAJ1HgACuq7BVTg417sGtRy8NgQ
2025-12-09 18:17:09.505 29727-29753 NetworkObserver         com.akslabs.cloudgallery             I  ONLINE
2025-12-09 18:17:09.890 29727-29727 Choreographer           com.akslabs.cloudgallery             I  Skipped 30 frames!  The application may be doing too much work on its main thread.
2025-12-09 18:17:09.933 29727-29727 InteractionJankMonitor  com.akslabs.cloudgallery             W  Initializing without READ_DEVICE_CONFIG permission. enabled=false, interval=1, missedFrameThreshold=3, frameTimeThreshold=64, package=com.akslabs.cloudgallery
2025-12-09 18:17:10.024 29727-29727 InsetsController        com.akslabs.cloudgallery             D  hide(ime(), fromIme=false)
2025-12-09 18:17:10.024 29727-29727 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:10bf605c: onCancelled at PHASE_CLIENT_ALREADY_HIDDEN
2025-12-09 18:17:12.046 29727-29871 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 ✅ SUCCESS: Downloaded 2866084 bytes in 9632ms for remoteId: BQACAgUAAyEGAASeEFIcAAISMGk16UfyZZwQ9l6r3QLlkErMgpuXAALTGwACqNuxVbhAMBpwnNEkNgQ
2025-12-09 18:17:12.046 29727-29871 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Detected MIME type: image/jpeg
2025-12-09 18:17:12.049 29727-29871 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Created SourceResult for remoteId: BQACAgUAAyEGAASeEFIcAAISMGk16UfyZZwQ9l6r3QLlkErMgpuXAALTGwACqNuxVbhAMBpwnNEkNgQ
2025-12-09 18:17:12.049 29727-29871 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER SUCCESS ===
2025-12-09 18:17:12.135 29727-29871 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:17:12.396 29727-29727 bs.cloudgallery         com.akslabs.cloudgallery             W  Accessing hidden method Landroid/window/BackEvent;->getFrameTimeMillis()J (blocked, linking, denied)
2025-12-09 18:17:12.397 29727-29727 bs.cloudgallery         com.akslabs.cloudgallery             W  Accessing hidden method Landroid/window/BackEvent;->getFrameTimeMillis()J (blocked, linking, denied)
2025-12-09 18:17:12.397 29727-29727 bs.cloudgallery         com.akslabs.cloudgallery             W  Accessing hidden method Landroid/window/BackEvent;-><init>(FFFIJ)V (blocked, linking, denied)
2025-12-09 18:17:12.545 29727-29727 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-12-09 18:17:12.554 29727-29727 WindowOnBackDispatcher  com.akslabs.cloudgallery             W  sendCancelIfRunning: isInProgress=false callback=androidx.navigationevent.OnBackInvokedInput$createOnBackAnimationCallback$1@39c890
2025-12-09 18:17:12.577 29727-29727 InsetsController        com.akslabs.cloudgallery             D  Setting requestedVisibleTypes to -9 (was -528)
2025-12-09 18:17:12.645 29727-29727 InsetsController        com.akslabs.cloudgallery             D  hide(ime(), fromIme=false)
2025-12-09 18:17:12.645 29727-29727 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:623ac55d: onCancelled at PHASE_CLIENT_ALREADY_HIDDEN
2025-12-09 18:17:12.681 29727-29897 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 ✅ SUCCESS: Downloaded 221900 bytes in 10113ms for remoteId: BQACAgUAAyEGAASeEFIcAAISJ2k147liO5zloI9Tn0r_s9bKHkBJAALKGwACqNuxVXkBp4xxXfQpNgQ
2025-12-09 18:17:12.681 29727-29897 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Detected MIME type: image/jpeg
2025-12-09 18:17:12.683 29727-29897 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Created SourceResult for remoteId: BQACAgUAAyEGAASeEFIcAAISJ2k147liO5zloI9Tn0r_s9bKHkBJAALKGwACqNuxVXkBp4xxXfQpNgQ
2025-12-09 18:17:12.683 29727-29897 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER SUCCESS ===
2025-12-09 18:17:12.728 29727-29897 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:17:12.839 29727-29883 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 ✅ SUCCESS: Downloaded 47228 bytes in 10356ms for remoteId: BQACAgUAAyEGAASeEFIcAAISLGk1478i3AFrgylNw4TagZPXkfuuAALPGwACqNuxVXSLLvdYdZ5kNgQ
2025-12-09 18:17:12.840 29727-29883 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Detected MIME type: image/jpeg
2025-12-09 18:17:12.840 29727-29883 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Created SourceResult for remoteId: BQACAgUAAyEGAASeEFIcAAISLGk1478i3AFrgylNw4TagZPXkfuuAALPGwACqNuxVXSLLvdYdZ5kNgQ
2025-12-09 18:17:12.840 29727-29883 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER SUCCESS ===
2025-12-09 18:17:12.853 29727-29883 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:17:15.180 29727-29877 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 ✅ SUCCESS: Downloaded 988813 bytes in 12731ms for remoteId: BQACAgUAAyEGAASeEFIcAAISLmk16TdkMITDN8h31O9KSt2Hemu0AALRGwACqNuxVc4md7uFTSVhNgQ
2025-12-09 18:17:15.180 29727-29877 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Detected MIME type: image/jpeg
2025-12-09 18:17:15.182 29727-29877 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Created SourceResult for remoteId: BQACAgUAAyEGAASeEFIcAAISLmk16TdkMITDN8h31O9KSt2Hemu0AALRGwACqNuxVc4md7uFTSVhNgQ
2025-12-09 18:17:15.182 29727-29877 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER SUCCESS ===
2025-12-09 18:17:15.212 29727-29896 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 ✅ SUCCESS: Downloaded 13022 bytes in 12661ms for remoteId: BQACAgUAAyEGAASeEFIcAAISKGk147rLWgkfhO6nA_d8PshiFY0wAALLGwACqNuxVebx48O4BqUuNgQ
2025-12-09 18:17:15.212 29727-29896 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Detected MIME type: image/jpeg
2025-12-09 18:17:15.212 29727-29896 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Created SourceResult for remoteId: BQACAgUAAyEGAASeEFIcAAISKGk147rLWgkfhO6nA_d8PshiFY0wAALLGwACqNuxVebx48O4BqUuNgQ
2025-12-09 18:17:15.212 29727-29896 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER SUCCESS ===
2025-12-09 18:17:15.246 29727-29896 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:17:15.304 29727-29877 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:17:16.339 29727-29727 MainPage                com.akslabs.cloudgallery             D  Selection Debug: selected=0, total=1266, route=device
2025-12-09 18:17:16.370 29727-29727 WindowOnBackDispatcher  com.akslabs.cloudgallery             W  sendCancelIfRunning: isInProgress=false callback=androidx.navigationevent.OnBackInvokedInput$createOnBackAnimationCallback$1@c419f64
2025-12-09 18:17:16.373 29727-29890 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 ✅ SUCCESS: Downloaded 541913 bytes in 13838ms for remoteId: BQACAgUAAyEGAASeEFIcAAISKWk147tv8XtvQGIAAa5pSSybvqP76AACzBsAAqjbsVX9ZDPofL9vcjYE
2025-12-09 18:17:16.373 29727-29890 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Detected MIME type: image/jpeg
2025-12-09 18:17:16.375 29727-29890 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Created SourceResult for remoteId: BQACAgUAAyEGAASeEFIcAAISKWk147tv8XtvQGIAAa5pSSybvqP76AACzBsAAqjbsVX9ZDPofL9vcjYE
2025-12-09 18:17:16.375 29727-29890 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER SUCCESS ===
2025-12-09 18:17:16.470 29727-29890 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2025-12-09 18:17:16.529 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-12-09 18:17:16.529 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 1266
2025-12-09 18:17:16.529 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos (Paging) itemCount: 180
2025-12-09 18:17:16.529 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  AllPhotos (Custom) size: 0
2025-12-09 18:17:16.529 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-12-09 18:17:16.529 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-12-09 18:17:16.529 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-12-09 18:17:16.529 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-12-09 18:17:16.546 29727-29877 LocalPhotoGrid          com.akslabs.cloudgallery             D  fetchAllLocalPhotos: Cursor count: 1266
2025-12-09 18:17:16.598 29727-29877 LocalPhotoGrid          com.akslabs.cloudgallery             D  fetchAllLocalPhotos: Fetched 1266 photos
2025-12-09 18:17:17.504 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-12-09 18:17:17.504 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 1266
2025-12-09 18:17:17.504 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos (Paging) itemCount: 180
2025-12-09 18:17:17.504 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  AllPhotos (Custom) size: 1266
2025-12-09 18:17:17.504 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-12-09 18:17:17.504 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-12-09 18:17:17.504 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-12-09 18:17:17.504 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-12-09 18:17:17.512 29727-29727 Choreographer           com.akslabs.cloudgallery             I  Skipped 51 frames!  The application may be doing too much work on its main thread.
2025-12-09 18:17:19.492 29727-29891 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISKmk1471_ESpcLE2nhxTCUrP6GVp1AALNGwACqNuxVd32fi62NDe-NgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@db0b877
2025-12-09 18:17:19.492 29727-29891 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:19.797 29727-29727 bs.cloudgallery         com.akslabs.cloudgallery             W  Accessing hidden method Landroid/view/ViewTreeObserver;->dispatchOnScrollChanged()V (unsupported, reflection, allowed)
2025-12-09 18:17:20.105 29727-29884 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISK2k14756K6IZ4D9_-JVi2391vEMQAALOGwACqNuxVZHliSK8D7meNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@673c6b9
2025-12-09 18:17:20.105 29727-29884 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:21.734 29727-29872 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISL2k16TqJsJ6yUp5V0L5tPfLbioKzAALSGwACqNuxVW6CjPvRrW-8NgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@51be8f3
2025-12-09 18:17:21.734 29727-29872 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:22.188 29727-29878 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISLWk148EaGtqTbixQx6wMcvkThNIGAALQGwACqNuxVXUmH6zxfN3sNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@636d029
2025-12-09 18:17:22.189 29727-29878 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:24.148 29727-29866 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISMWk16U4ZeP9m_7azrMp7iYo1loKjAALUGwACqNuxVZShnQfKn9iMNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@582214f
2025-12-09 18:17:24.148 29727-29866 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:24.201 29727-29760 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISS2k4Ga78clugfaps2KryxG7YxsUSAAKtHgACuq7BVVY1R_Xe2rIvNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@4345e5
2025-12-09 18:17:24.201 29727-29760 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:26.601 29727-29727 MainPage                com.akslabs.cloudgallery             D  Selection Debug: selected=0, total=151, route=cloud
2025-12-09 18:17:26.670 29727-29727 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-12-09 18:17:26.673 29727-29727 RemotePhotoGrid         com.akslabs.cloudgallery             D  🔍 Starting remote date grouping for 151 photos
2025-12-09 18:17:26.684 29727-29727 RemotePhotoGrid         com.akslabs.cloudgallery             D  ✅ Remote date grouping complete: 72 processed, 79 skipped
2025-12-09 18:17:26.723 29727-29760 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAIST2k4GgABzhVHbvYw6JrWxjhdnw_WAgACsh4AArquwVU9SJYJG-BfAjYE, size: Size(width=150, height=150)
2025-12-09 18:17:26.723 29727-29760 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:26.723 29727-29760 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAIST2k4GgABzhVHbvYw6JrWxjhdnw_WAgACsh4AArquwVU9SJYJG-BfAjYE
2025-12-09 18:17:26.723 29727-29760 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: png
2025-12-09 18:17:26.723 29727-29760 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 66735963071645025771664547049808185553.png
2025-12-09 18:17:26.723 29727-29760 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 323262
2025-12-09 18:17:26.723 29727-29760 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:26.723 29727-29760 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAIST2k4GgABzhVHbvYw6JrWxjhdnw_WAgACsh4AArquwVU9SJYJG-BfAjYE
2025-12-09 18:17:26.733 29727-29866 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISTmk4Gf8E51zifVTODE_UnPBDHjRtAAKxHgACuq7BVdJ68OMyI6oHNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:26.733 29727-29866 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:26.733 29727-29866 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISTmk4Gf8E51zifVTODE_UnPBDHjRtAAKxHgACuq7BVdJ68OMyI6oHNgQ
2025-12-09 18:17:26.733 29727-29866 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: png
2025-12-09 18:17:26.733 29727-29866 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -104305915468168366117007500943592734.png
2025-12-09 18:17:26.733 29727-29866 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 323262
2025-12-09 18:17:26.733 29727-29866 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:26.734 29727-29866 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISTmk4Gf8E51zifVTODE_UnPBDHjRtAAKxHgACuq7BVdJ68OMyI6oHNgQ
2025-12-09 18:17:26.745 29727-29878 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISTGk4GdXslJRTpKe8QSkC4iykxx8eAAKvHgACuq7BVWQ3-y4YHXE1NgQ, size: Size(width=150, height=150)
2025-12-09 18:17:26.745 29727-29878 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:26.745 29727-29878 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISTGk4GdXslJRTpKe8QSkC4iykxx8eAAKvHgACuq7BVWQ3-y4YHXE1NgQ
2025-12-09 18:17:26.745 29727-29878 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:26.745 29727-29878 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 38979236254974748124199778375570666128.jpg
2025-12-09 18:17:26.745 29727-29878 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 3999309
2025-12-09 18:17:26.745 29727-29878 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:26.745 29727-29878 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISTGk4GdXslJRTpKe8QSkC4iykxx8eAAKvHgACuq7BVWQ3-y4YHXE1NgQ
2025-12-09 18:17:26.755 29727-29872 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISS2k4Ga78clugfaps2KryxG7YxsUSAAKtHgACuq7BVVY1R_Xe2rIvNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:26.755 29727-29872 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:26.755 29727-29872 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISS2k4Ga78clugfaps2KryxG7YxsUSAAKtHgACuq7BVVY1R_Xe2rIvNgQ
2025-12-09 18:17:26.755 29727-29872 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:26.755 29727-29872 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -17926321980551407548818181834234654642.jpg
2025-12-09 18:17:26.755 29727-29872 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 14247
2025-12-09 18:17:26.756 29727-29872 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:26.756 29727-29872 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISS2k4Ga78clugfaps2KryxG7YxsUSAAKtHgACuq7BVVY1R_Xe2rIvNgQ
2025-12-09 18:17:26.766 29727-29884 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISSmk4B4rGhJymvN6Xb1uIUIGFgamNAAJ_HgACuq7BVZVYLE43JItrNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:26.767 29727-29884 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:26.767 29727-29884 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISSmk4B4rGhJymvN6Xb1uIUIGFgamNAAJ_HgACuq7BVZVYLE43JItrNgQ
2025-12-09 18:17:26.767 29727-29884 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:26.767 29727-29884 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -66741660213027176921227142352250071395.jpg
2025-12-09 18:17:26.767 29727-29884 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 220586
2025-12-09 18:17:26.767 29727-29884 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:26.767 29727-29884 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISSmk4B4rGhJymvN6Xb1uIUIGFgamNAAJ_HgACuq7BVZVYLE43JItrNgQ
2025-12-09 18:17:26.778 29727-29891 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISSWk4B4iX-wTt1M0YseJ_kmNkheSBAAJ-HgACuq7BVUyMUI29HoBqNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:26.778 29727-29891 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:26.778 29727-29891 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISSWk4B4iX-wTt1M0YseJ_kmNkheSBAAJ-HgACuq7BVUyMUI29HoBqNgQ
2025-12-09 18:17:26.778 29727-29891 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:26.778 29727-29891 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -54319976482011598045019523617316420869.jpg
2025-12-09 18:17:26.778 29727-29891 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 68215
2025-12-09 18:17:26.778 29727-29891 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:26.778 29727-29891 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISSWk4B4iX-wTt1M0YseJ_kmNkheSBAAJ-HgACuq7BVUyMUI29HoBqNgQ
2025-12-09 18:17:26.788 29727-29877 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISSGk4B4bPPpRsy_NvWU9Hl9xa5styAAJ9HgACuq7BVVokZd-PmQnRNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:26.788 29727-29877 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:26.788 29727-29877 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISSGk4B4bPPpRsy_NvWU9Hl9xa5styAAJ9HgACuq7BVVokZd-PmQnRNgQ
2025-12-09 18:17:26.788 29727-29877 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:26.788 29727-29877 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 86470853926802444855643458901249774122.jpg
2025-12-09 18:17:26.788 29727-29877 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 57201
2025-12-09 18:17:26.788 29727-29877 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:26.788 29727-29877 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISSGk4B4bPPpRsy_NvWU9Hl9xa5styAAJ9HgACuq7BVVokZd-PmQnRNgQ
2025-12-09 18:17:26.799 29727-29890 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISR2k4B4V8a39vO1UFZ9DmCDD5fjZ3AAJ8HgACuq7BVbDCFMxXjybzNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:26.800 29727-29890 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:26.800 29727-29890 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISR2k4B4V8a39vO1UFZ9DmCDD5fjZ3AAJ8HgACuq7BVbDCFMxXjybzNgQ
2025-12-09 18:17:26.800 29727-29890 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:26.800 29727-29890 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -69534218746957185694710811843165719754.jpg
2025-12-09 18:17:26.800 29727-29890 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 896795
2025-12-09 18:17:26.800 29727-29890 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:26.800 29727-29890 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISR2k4B4V8a39vO1UFZ9DmCDD5fjZ3AAJ8HgACuq7BVbDCFMxXjybzNgQ
2025-12-09 18:17:26.811 29727-29896 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISRmk4B391Ur-B3oZxr9XwrOW8xXzfAAJ7HgACuq7BVclL-RoX8onmNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:26.811 29727-29896 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:26.811 29727-29896 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISRmk4B391Ur-B3oZxr9XwrOW8xXzfAAJ7HgACuq7BVclL-RoX8onmNgQ
2025-12-09 18:17:26.811 29727-29896 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:26.811 29727-29896 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -17055938619259491057460878480784570804.jpg
2025-12-09 18:17:26.811 29727-29896 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 143583
2025-12-09 18:17:26.811 29727-29896 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:26.811 29727-29896 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISRmk4B391Ur-B3oZxr9XwrOW8xXzfAAJ7HgACuq7BVclL-RoX8onmNgQ
2025-12-09 18:17:26.819 29727-29859 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISNWk4Bo6nvvr8VtbNrbtZXoi3dkx7AAJkHgACuq7BVbKGBDXIu2a3NgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@63a4a7c
2025-12-09 18:17:26.819 29727-29859 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:26.822 29727-29859 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISRWk4B3miFvKpu-es5enCj5ssqw7OAAJ6HgACuq7BVQeqqlnlpBYINgQ, size: Size(width=150, height=150)
2025-12-09 18:17:26.822 29727-29859 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:26.822 29727-29859 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISRWk4B3miFvKpu-es5enCj5ssqw7OAAJ6HgACuq7BVQeqqlnlpBYINgQ
2025-12-09 18:17:26.822 29727-29859 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:26.822 29727-29859 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -1222669993748915715235778988322223971.jpg
2025-12-09 18:17:26.822 29727-29859 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 62475
2025-12-09 18:17:26.823 29727-29859 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:26.823 29727-29859 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISRWk4B3miFvKpu-es5enCj5ssqw7OAAJ6HgACuq7BVQeqqlnlpBYINgQ
2025-12-09 18:17:26.833 29727-29883 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISRGk4B3aa_h0SnshF7qcz9ZCialt_AAJ5HgACuq7BVYXKdSxZXG5FNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:26.833 29727-29883 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:26.833 29727-29883 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISRGk4B3aa_h0SnshF7qcz9ZCialt_AAJ5HgACuq7BVYXKdSxZXG5FNgQ
2025-12-09 18:17:26.833 29727-29883 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:26.833 29727-29883 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 37828961356114911538642936572326811486.jpg
2025-12-09 18:17:26.833 29727-29883 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 58810
2025-12-09 18:17:26.833 29727-29883 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:26.833 29727-29883 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISRGk4B3aa_h0SnshF7qcz9ZCialt_AAJ5HgACuq7BVYXKdSxZXG5FNgQ
2025-12-09 18:17:26.845 29727-29897 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISQ2k4B3VoC89TJrEoGmZikzyoV_JyAAJ4HgACuq7BVT0tvpqS6Ba1NgQ, size: Size(width=150, height=150)
2025-12-09 18:17:26.845 29727-29897 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:26.845 29727-29897 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISQ2k4B3VoC89TJrEoGmZikzyoV_JyAAJ4HgACuq7BVT0tvpqS6Ba1NgQ
2025-12-09 18:17:26.845 29727-29897 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:26.845 29727-29897 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 12262704049492011391340038311159537702.jpg
2025-12-09 18:17:26.845 29727-29897 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 800731
2025-12-09 18:17:26.845 29727-29897 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:26.845 29727-29897 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISQ2k4B3VoC89TJrEoGmZikzyoV_JyAAJ4HgACuq7BVT0tvpqS6Ba1NgQ
2025-12-09 18:17:26.856 29727-29871 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISQmk4B24MI_3z9opyGWFD0epAz81zAAJ3HgACuq7BVQYpGqGPAtIINgQ, size: Size(width=150, height=150)
2025-12-09 18:17:26.857 29727-29871 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:26.857 29727-29871 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISQmk4B24MI_3z9opyGWFD0epAz81zAAJ3HgACuq7BVQYpGqGPAtIINgQ
2025-12-09 18:17:26.857 29727-29871 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:26.857 29727-29871 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 51462118640104019605488804954357862468.jpg
2025-12-09 18:17:26.857 29727-29871 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 157889
2025-12-09 18:17:26.857 29727-29871 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:26.857 29727-29871 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISQmk4B24MI_3z9opyGWFD0epAz81zAAJ3HgACuq7BVQYpGqGPAtIINgQ
2025-12-09 18:17:26.867 29727-29903 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISQWk4B2zek7kPqws5z0BlpsKckl3HAAJ2HgACuq7BVcfl7OfJPWIRNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:26.868 29727-29903 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:26.868 29727-29903 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISQWk4B2zek7kPqws5z0BlpsKckl3HAAJ2HgACuq7BVcfl7OfJPWIRNgQ
2025-12-09 18:17:26.868 29727-29903 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:26.868 29727-29903 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -59512562396899058593370662859273237887.jpg
2025-12-09 18:17:26.868 29727-29903 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 231285
2025-12-09 18:17:26.868 29727-29903 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:26.868 29727-29903 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISQWk4B2zek7kPqws5z0BlpsKckl3HAAJ2HgACuq7BVcfl7OfJPWIRNgQ
2025-12-09 18:17:26.878 29727-30017 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISQGk4B2pr_W-Ttl3r22EX9fD2zxd7AAJ1HgACuq7BVTg417sGtRy8NgQ, size: Size(width=150, height=150)
2025-12-09 18:17:26.879 29727-30017 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:26.879 29727-30017 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISQGk4B2pr_W-Ttl3r22EX9fD2zxd7AAJ1HgACuq7BVTg417sGtRy8NgQ
2025-12-09 18:17:26.879 29727-30017 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:26.879 29727-30017 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -13248265543009987853277768459449078062.jpg
2025-12-09 18:17:26.879 29727-30017 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 255729
2025-12-09 18:17:26.879 29727-30017 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:26.879 29727-30017 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISQGk4B2pr_W-Ttl3r22EX9fD2zxd7AAJ1HgACuq7BVTg417sGtRy8NgQ
2025-12-09 18:17:26.890 29727-30016 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISPmk4B2MYbJcwBoUfVshq9rm45HG8AAJzHgACuq7BVQzouyPn7OveNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:26.890 29727-30016 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:26.890 29727-30016 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISPmk4B2MYbJcwBoUfVshq9rm45HG8AAJzHgACuq7BVQzouyPn7OveNgQ
2025-12-09 18:17:26.890 29727-30016 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:26.890 29727-30016 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 51967083241366325308584991732410992015.jpg
2025-12-09 18:17:26.890 29727-30016 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 81527
2025-12-09 18:17:26.890 29727-30016 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:26.890 29727-30016 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISPmk4B2MYbJcwBoUfVshq9rm45HG8AAJzHgACuq7BVQzouyPn7OveNgQ
2025-12-09 18:17:26.901 29727-30018 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISPWk4B1RnCvMauFhsqq0c0YYhDa3NAAJyHgACuq7BVXm_qGks68M6NgQ, size: Size(width=150, height=150)
2025-12-09 18:17:26.901 29727-30018 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:26.902 29727-30018 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISPWk4B1RnCvMauFhsqq0c0YYhDa3NAAJyHgACuq7BVXm_qGks68M6NgQ
2025-12-09 18:17:26.902 29727-30018 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:26.902 29727-30018 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -23568622413020440613875168272293172598.jpg
2025-12-09 18:17:26.902 29727-30018 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 985106
2025-12-09 18:17:26.902 29727-30018 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:26.902 29727-30018 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISPWk4B1RnCvMauFhsqq0c0YYhDa3NAAJyHgACuq7BVXm_qGks68M6NgQ
2025-12-09 18:17:26.905 29727-29761 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISSWk4B4iX-wTt1M0YseJ_kmNkheSBAAJ-HgACuq7BVUyMUI29HoBqNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@5c09d95
2025-12-09 18:17:26.905 29727-29761 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:26.912 29727-29761 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISPGk4B0uuVdnOiiFZ34wmn6KdYvIuAAJxHgACuq7BVY7iKQvVwLbgNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:26.912 29727-29761 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:26.913 29727-29761 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISPGk4B0uuVdnOiiFZ34wmn6KdYvIuAAJxHgACuq7BVY7iKQvVwLbgNgQ
2025-12-09 18:17:26.913 29727-29761 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:26.913 29727-29761 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 25780282115958746212537160405355317426.jpg
2025-12-09 18:17:26.913 29727-29761 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 510678
2025-12-09 18:17:26.913 29727-29761 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:26.913 29727-29761 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISPGk4B0uuVdnOiiFZ34wmn6KdYvIuAAJxHgACuq7BVY7iKQvVwLbgNgQ
2025-12-09 18:17:26.923 29727-30019 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISO2k4B0alhh5UI16vqeWw-3RJF8GLAAJwHgACuq7BVSZEHu7upw4qNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:26.924 29727-30019 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:26.924 29727-30019 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISO2k4B0alhh5UI16vqeWw-3RJF8GLAAJwHgACuq7BVSZEHu7upw4qNgQ
2025-12-09 18:17:26.924 29727-30019 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:26.924 29727-30019 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 22104452995747380878688689768219556062.jpg
2025-12-09 18:17:26.924 29727-30019 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 127105
2025-12-09 18:17:26.924 29727-30019 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:26.924 29727-30019 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISO2k4B0alhh5UI16vqeWw-3RJF8GLAAJwHgACuq7BVSZEHu7upw4qNgQ
2025-12-09 18:17:26.934 29727-30020 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISOmk4B0Sf7GKFRC5XxHWmzPlN5w_jAAJvHgACuq7BVR5S6HpSH4wvNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:26.934 29727-30020 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:26.934 29727-30020 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISOmk4B0Sf7GKFRC5XxHWmzPlN5w_jAAJvHgACuq7BVR5S6HpSH4wvNgQ
2025-12-09 18:17:26.934 29727-30020 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:26.934 29727-30020 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 25745530396689829244627214592059360758.jpg
2025-12-09 18:17:26.934 29727-30020 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 165906
2025-12-09 18:17:26.934 29727-30020 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:26.935 29727-30020 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISOmk4B0Sf7GKFRC5XxHWmzPlN5w_jAAJvHgACuq7BVR5S6HpSH4wvNgQ
2025-12-09 18:17:26.946 29727-30021 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISOWk4B0GYPuH0Objuf17D6VFjEUbfAAJuHgACuq7BVaUGm3N60DcgNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:26.946 29727-30021 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:26.946 29727-30021 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISOWk4B0GYPuH0Objuf17D6VFjEUbfAAJuHgACuq7BVaUGm3N60DcgNgQ
2025-12-09 18:17:26.946 29727-30021 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:26.946 29727-30021 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -56083793053672605433986674938167061735.jpg
2025-12-09 18:17:26.946 29727-30021 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 918113
2025-12-09 18:17:26.946 29727-30021 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:26.946 29727-30021 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISOWk4B0GYPuH0Objuf17D6VFjEUbfAAJuHgACuq7BVaUGm3N60DcgNgQ
2025-12-09 18:17:26.958 29727-30022 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISOGk4BzDKNPcFhKPsxKF4tgIicgc1AAJsHgACuq7BVRnzsT5aEYogNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:26.958 29727-30022 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:26.958 29727-30022 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISOGk4BzDKNPcFhKPsxKF4tgIicgc1AAJsHgACuq7BVRnzsT5aEYogNgQ
2025-12-09 18:17:26.958 29727-30022 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:26.958 29727-30022 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -5185972839701388666385740418985090319.jpg
2025-12-09 18:17:26.958 29727-30022 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 1004825
2025-12-09 18:17:26.958 29727-30022 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:26.958 29727-30022 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISOGk4BzDKNPcFhKPsxKF4tgIicgc1AAJsHgACuq7BVRnzsT5aEYogNgQ
2025-12-09 18:17:26.969 29727-30023 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISNWk4Bo6nvvr8VtbNrbtZXoi3dkx7AAJkHgACuq7BVbKGBDXIu2a3NgQ, size: Size(width=150, height=150)
2025-12-09 18:17:26.969 29727-30023 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:26.969 29727-30023 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISNWk4Bo6nvvr8VtbNrbtZXoi3dkx7AAJkHgACuq7BVbKGBDXIu2a3NgQ
2025-12-09 18:17:26.969 29727-30023 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:26.969 29727-30023 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 27694350883056160642153418728408660386.jpg
2025-12-09 18:17:26.969 29727-30023 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 893565
2025-12-09 18:17:26.969 29727-30023 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:26.969 29727-30023 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISNWk4Bo6nvvr8VtbNrbtZXoi3dkx7AAJkHgACuq7BVbKGBDXIu2a3NgQ
2025-12-09 18:17:26.981 29727-30024 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISNGk4Bojcv5nsU9yEG9_sJeaw_Cx2AAJjHgACuq7BVbqIpjKzEomzNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:26.981 29727-30024 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:26.981 29727-30024 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISNGk4Bojcv5nsU9yEG9_sJeaw_Cx2AAJjHgACuq7BVbqIpjKzEomzNgQ
2025-12-09 18:17:26.981 29727-30024 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:26.981 29727-30024 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 81381010950402908224394496091790158107.jpg
2025-12-09 18:17:26.981 29727-30024 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 3587684
2025-12-09 18:17:26.981 29727-30024 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:26.981 29727-30024 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISNGk4Bojcv5nsU9yEG9_sJeaw_Cx2AAJjHgACuq7BVbqIpjKzEomzNgQ
2025-12-09 18:17:26.993 29727-30025 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISM2k4BnFZf3ytXlxjCwm2RgV1K-0XAAJhHgACuq7BVSJg5CNFxVGFNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:26.993 29727-30025 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:26.993 29727-30025 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISM2k4BnFZf3ytXlxjCwm2RgV1K-0XAAJhHgACuq7BVSJg5CNFxVGFNgQ
2025-12-09 18:17:26.993 29727-30025 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:26.993 29727-30025 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 4056351053215901511610220552113032983.jpg
2025-12-09 18:17:26.993 29727-30025 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 4601524
2025-12-09 18:17:26.994 29727-30025 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:26.994 29727-30025 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISM2k4BnFZf3ytXlxjCwm2RgV1K-0XAAJhHgACuq7BVSJg5CNFxVGFNgQ
2025-12-09 18:17:27.003 29727-30029 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISMWk16U4ZeP9m_7azrMp7iYo1loKjAALUGwACqNuxVZShnQfKn9iMNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:27.003 29727-30029 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:27.003 29727-30029 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISMWk16U4ZeP9m_7azrMp7iYo1loKjAALUGwACqNuxVZShnQfKn9iMNgQ
2025-12-09 18:17:27.003 29727-30029 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:27.003 29727-30029 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 40033026795977047353494464962836767993.jpg
2025-12-09 18:17:27.004 29727-30029 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 1111027
2025-12-09 18:17:27.004 29727-30029 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:27.004 29727-30029 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISMWk16U4ZeP9m_7azrMp7iYo1loKjAALUGwACqNuxVZShnQfKn9iMNgQ
2025-12-09 18:17:27.028 29727-30030 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISL2k16TqJsJ6yUp5V0L5tPfLbioKzAALSGwACqNuxVW6CjPvRrW-8NgQ, size: Size(width=150, height=150)
2025-12-09 18:17:27.028 29727-30030 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:27.028 29727-30030 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISL2k16TqJsJ6yUp5V0L5tPfLbioKzAALSGwACqNuxVW6CjPvRrW-8NgQ
2025-12-09 18:17:27.028 29727-30030 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:27.028 29727-30030 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -7041779385842348514169979258179592994.jpg
2025-12-09 18:17:27.028 29727-30030 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 971514
2025-12-09 18:17:27.028 29727-30030 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:27.028 29727-30030 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISL2k16TqJsJ6yUp5V0L5tPfLbioKzAALSGwACqNuxVW6CjPvRrW-8NgQ
2025-12-09 18:17:27.030 29727-29817 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISRWk4B3miFvKpu-es5enCj5ssqw7OAAJ6HgACuq7BVQeqqlnlpBYINgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@fb97a41
2025-12-09 18:17:27.030 29727-29817 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:27.046 29727-29817 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISLWk148EaGtqTbixQx6wMcvkThNIGAALQGwACqNuxVXUmH6zxfN3sNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:27.046 29727-29817 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:27.046 29727-29817 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISLWk148EaGtqTbixQx6wMcvkThNIGAALQGwACqNuxVXUmH6zxfN3sNgQ
2025-12-09 18:17:27.046 29727-29817 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:27.046 29727-29817 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 8904595978302154468855741790612207816.jpg
2025-12-09 18:17:27.046 29727-29817 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 237369
2025-12-09 18:17:27.046 29727-29817 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:27.046 29727-29817 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISLWk148EaGtqTbixQx6wMcvkThNIGAALQGwACqNuxVXUmH6zxfN3sNgQ
2025-12-09 18:17:27.068 29727-30032 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISK2k14756K6IZ4D9_-JVi2391vEMQAALOGwACqNuxVZHliSK8D7meNgQ, size: Size(width=150, height=150)
2025-12-09 18:17:27.068 29727-30032 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:27.068 29727-30032 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISK2k14756K6IZ4D9_-JVi2391vEMQAALOGwACqNuxVZHliSK8D7meNgQ
2025-12-09 18:17:27.068 29727-30032 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:27.068 29727-30032 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: -25116319639357521405459770412701707147.jpg
2025-12-09 18:17:27.068 29727-30032 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 392190
2025-12-09 18:17:27.068 29727-30032 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:27.068 29727-30032 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISK2k14756K6IZ4D9_-JVi2391vEMQAALOGwACqNuxVZHliSK8D7meNgQ
2025-12-09 18:17:27.079 29727-30031 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISKmk1471_ESpcLE2nhxTCUrP6GVp1AALNGwACqNuxVd32fi62NDe-NgQ, size: Size(width=150, height=150)
2025-12-09 18:17:27.079 29727-30031 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-12-09 18:17:27.079 29727-30031 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAISKmk1471_ESpcLE2nhxTCUrP6GVp1AALNGwACqNuxVd32fi62NDe-NgQ
2025-12-09 18:17:27.079 29727-30031 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: jpg
2025-12-09 18:17:27.079 29727-30031 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 68614204407723687062691905464766641694.jpg
2025-12-09 18:17:27.079 29727-30031 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 1586084
2025-12-09 18:17:27.079 29727-30031 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-12-09 18:17:27.079 29727-30031 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAISKmk1471_ESpcLE2nhxTCUrP6GVp1AALNGwACqNuxVd32fi62NDe-NgQ
2025-12-09 18:17:27.198 29727-29727 Choreographer           com.akslabs.cloudgallery             I  Skipped 31 frames!  The application may be doing too much work on its main thread.
2025-12-09 18:17:27.300 29727-29846 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISO2k4B0alhh5UI16vqeWw-3RJF8GLAAJwHgACuq7BVSZEHu7upw4qNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@9abb888
2025-12-09 18:17:27.300 29727-29846 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:27.679 29727-29847 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISOmk4B0Sf7GKFRC5XxHWmzPlN5w_jAAJvHgACuq7BVR5S6HpSH4wvNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@13868ff
2025-12-09 18:17:27.679 29727-29847 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:27.747 29727-29822 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISRGk4B3aa_h0SnshF7qcz9ZCialt_AAJ5HgACuq7BVYXKdSxZXG5FNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@2868d15
2025-12-09 18:17:27.747 29727-29822 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:28.051 29727-29816 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISRmk4B391Ur-B3oZxr9XwrOW8xXzfAAJ7HgACuq7BVclL-RoX8onmNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@f34961b
2025-12-09 18:17:28.051 29727-29816 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:28.197 29727-29835 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISPmk4B2MYbJcwBoUfVshq9rm45HG8AAJzHgACuq7BVQzouyPn7OveNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@5cfe591
2025-12-09 18:17:28.197 29727-29835 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:28.775 29727-29778 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAIST2k4GgABzhVHbvYw6JrWxjhdnw_WAgACsh4AArquwVU9SJYJG-BfAjYE
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@bfb55db
2025-12-09 18:17:28.775 29727-29778 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:28.796 29727-29732 bs.cloudgallery         com.akslabs.cloudgallery             I  Background concurrent copying GC freed 14MB AllocSpace bytes, 148(4384KB) LOS objects, 49% free, 10MB/21MB, paused 99us,128us total 102.863ms
2025-12-09 18:17:29.263 29727-29834 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISQGk4B2pr_W-Ttl3r22EX9fD2zxd7AAJ1HgACuq7BVTg417sGtRy8NgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@a2e0b51
2025-12-09 18:17:29.263 29727-29834 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:29.430 29727-29727 MainPage                com.akslabs.cloudgallery             D  Selection Debug: selected=0, total=1266, route=device
2025-12-09 18:17:29.448 29727-29727 WindowOnBackDispatcher  com.akslabs.cloudgallery             W  sendCancelIfRunning: isInProgress=false callback=androidx.navigationevent.OnBackInvokedInput$createOnBackAnimationCallback$1@c419f64
2025-12-09 18:17:29.557 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-12-09 18:17:29.557 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 1266
2025-12-09 18:17:29.557 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos (Paging) itemCount: 180
2025-12-09 18:17:29.557 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  AllPhotos (Custom) size: 0
2025-12-09 18:17:29.557 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-12-09 18:17:29.557 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-12-09 18:17:29.557 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-12-09 18:17:29.557 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-12-09 18:17:29.578 29727-29834 LocalPhotoGrid          com.akslabs.cloudgallery             D  fetchAllLocalPhotos: Cursor count: 1266
2025-12-09 18:17:29.608 29727-29834 LocalPhotoGrid          com.akslabs.cloudgallery             D  fetchAllLocalPhotos: Fetched 1266 photos
2025-12-09 18:17:30.330 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-12-09 18:17:30.330 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 1266
2025-12-09 18:17:30.330 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos (Paging) itemCount: 180
2025-12-09 18:17:30.330 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  AllPhotos (Custom) size: 1266
2025-12-09 18:17:30.330 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-12-09 18:17:30.330 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-12-09 18:17:30.330 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-12-09 18:17:30.330 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-12-09 18:17:30.336 29727-29727 Choreographer           com.akslabs.cloudgallery             I  Skipped 40 frames!  The application may be doing too much work on its main thread.
2025-12-09 18:17:31.468 29727-29852 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISOWk4B0GYPuH0Objuf17D6VFjEUbfAAJuHgACuq7BVaUGm3N60DcgNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@dd58691
2025-12-09 18:17:31.471 29727-29852 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:33.410 29727-29840 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISPWk4B1RnCvMauFhsqq0c0YYhDa3NAAJyHgACuq7BVXm_qGks68M6NgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@d2581f7
2025-12-09 18:17:33.410 29727-29840 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:35.118 29727-29786 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISR2k4B4V8a39vO1UFZ9DmCDD5fjZ3AAJ8HgACuq7BVbDCFMxXjybzNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@4bafacd
2025-12-09 18:17:35.119 29727-29786 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:35.429 29727-29829 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISQmk4B24MI_3z9opyGWFD0epAz81zAAJ3HgACuq7BVQYpGqGPAtIINgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@f264693
2025-12-09 18:17:35.429 29727-29829 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:35.585 29727-29777 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISSGk4B4bPPpRsy_NvWU9Hl9xa5styAAJ9HgACuq7BVVokZd-PmQnRNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@976c9
2025-12-09 18:17:35.585 29727-29777 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:36.009 29727-29784 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISSmk4B4rGhJymvN6Xb1uIUIGFgamNAAJ_HgACuq7BVZVYLE43JItrNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@664b8ef
2025-12-09 18:17:36.009 29727-29784 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:36.566 29727-29902 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISQGk4B2pr_W-Ttl3r22EX9fD2zxd7AAJ1HgACuq7BVTg417sGtRy8NgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@fa9b685
2025-12-09 18:17:36.566 29727-29902 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:36.567 29727-29727 RealImageLoader         com.akslabs.cloudgallery             I  🏗  Cancelled - RemotePhoto(remoteId=BQACAgUAAyEGAASeEFIcAAISQGk4B2pr_W-Ttl3r22EX9fD2zxd7AAJ1HgACuq7BVTg417sGtRy8NgQ, photoType=jpg, fileName=, fileSize=null, uploadedAt=1765284429444, thumbnailCached=false, messageId=null)
2025-12-09 18:17:36.985 29727-29828 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISQWk4B2zek7kPqws5z0BlpsKckl3HAAJ2HgACuq7BVcfl7OfJPWIRNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@26df50b
2025-12-09 18:17:36.985 29727-29828 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:37.495 29727-29727 InsetsController        com.akslabs.cloudgallery             D  hide(ime(), fromIme=false)
2025-12-09 18:17:37.495 29727-29727 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:fcb5350c: onCancelled at PHASE_CLIENT_ALREADY_HIDDEN
2025-12-09 18:17:37.572 29727-29759 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISTmk4Gf8E51zifVTODE_UnPBDHjRtAAKxHgACuq7BVdJ68OMyI6oHNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@f543601
2025-12-09 18:17:37.572 29727-29759 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:38.969 29727-29823 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISQ2k4B3VoC89TJrEoGmZikzyoV_JyAAJ4HgACuq7BVT0tvpqS6Ba1NgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@484d6e7
2025-12-09 18:17:38.969 29727-29823 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:39.840 29727-29841 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISPGk4B0uuVdnOiiFZ34wmn6KdYvIuAAJxHgACuq7BVY7iKQvVwLbgNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@3cd313d
2025-12-09 18:17:39.840 29727-29841 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:41.498 29727-29853 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISOGk4BzDKNPcFhKPsxKF4tgIicgc1AAJsHgACuq7BVRnzsT5aEYogNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@53dfa83
2025-12-09 18:17:41.499 29727-29853 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:43.123 29727-29732 bs.cloudgallery         com.akslabs.cloudgallery             I  Background concurrent copying GC freed 7631KB AllocSpace bytes, 7(3280KB) LOS objects, 49% free, 10MB/21MB, paused 178us,99us total 118.524ms
2025-12-09 18:17:48.809 29727-29727 VRI[MainActivity]       com.akslabs.cloudgallery             D  visibilityChanged oldVisibility=true newVisibility=false
2025-12-09 18:17:49.168 29727-29785 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISTGk4GdXslJRTpKe8QSkC4iykxx8eAAKvHgACuq7BVWQ3-y4YHXE1NgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@99b47d7
2025-12-09 18:17:49.168 29727-29785 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.072 29727-29865 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISM2k4BnFZf3ytXlxjCwm2RgV1K-0XAAJhHgACuq7BVSJg5CNFxVGFNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@1d1e3ad
2025-12-09 18:17:54.072 29727-29865 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.074 29727-29760 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAIST2k4GgABzhVHbvYw6JrWxjhdnw_WAgACsh4AArquwVU9SJYJG-BfAjYE
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@1560da9
2025-12-09 18:17:54.074 29727-29866 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISTmk4Gf8E51zifVTODE_UnPBDHjRtAAKxHgACuq7BVdJ68OMyI6oHNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@3837f2e
2025-12-09 18:17:54.074 29727-29858 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISNGk4Bojcv5nsU9yEG9_sJeaw_Cx2AAJjHgACuq7BVbqIpjKzEomzNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@b515acf
2025-12-09 18:17:54.074 29727-29760 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.074 29727-29866 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.074 29727-29858 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.076 29727-29878 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISTGk4GdXslJRTpKe8QSkC4iykxx8eAAKvHgACuq7BVWQ3-y4YHXE1NgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@dd8db65
2025-12-09 18:17:54.077 29727-29878 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.078 29727-29872 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISS2k4Ga78clugfaps2KryxG7YxsUSAAKtHgACuq7BVVY1R_Xe2rIvNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@5b2d4eb
2025-12-09 18:17:54.078 29727-29872 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.079 29727-29891 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISSWk4B4iX-wTt1M0YseJ_kmNkheSBAAJ-HgACuq7BVUyMUI29HoBqNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@667d4c7
2025-12-09 18:17:54.079 29727-29891 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.079 29727-29884 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISSmk4B4rGhJymvN6Xb1uIUIGFgamNAAJ_HgACuq7BVZVYLE43JItrNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@100c8e1
2025-12-09 18:17:54.079 29727-29884 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.080 29727-29877 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISSGk4B4bPPpRsy_NvWU9Hl9xa5styAAJ9HgACuq7BVVokZd-PmQnRNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@e60121d
2025-12-09 18:17:54.080 29727-29877 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.081 29727-29896 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISRmk4B391Ur-B3oZxr9XwrOW8xXzfAAJ7HgACuq7BVclL-RoX8onmNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@482f663
2025-12-09 18:17:54.081 29727-29896 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.081 29727-29890 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISR2k4B4V8a39vO1UFZ9DmCDD5fjZ3AAJ8HgACuq7BVbDCFMxXjybzNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@670b319
2025-12-09 18:17:54.081 29727-29890 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.083 29727-30019 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISO2k4B0alhh5UI16vqeWw-3RJF8GLAAJwHgACuq7BVSZEHu7upw4qNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@d5067d5
2025-12-09 18:17:54.083 29727-30019 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.084 29727-30016 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISPmk4B2MYbJcwBoUfVshq9rm45HG8AAJzHgACuq7BVQzouyPn7OveNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@13cac51
2025-12-09 18:17:54.084 29727-30016 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.084 29727-29871 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISQmk4B24MI_3z9opyGWFD0epAz81zAAJ3HgACuq7BVQYpGqGPAtIINgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@2a97db7
2025-12-09 18:17:54.084 29727-29871 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.084 29727-30017 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISQGk4B2pr_W-Ttl3r22EX9fD2zxd7AAJ1HgACuq7BVTg417sGtRy8NgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@ccebc8d
2025-12-09 18:17:54.084 29727-30017 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.085 29727-29883 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISRGk4B3aa_h0SnshF7qcz9ZCialt_AAJ5HgACuq7BVYXKdSxZXG5FNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@d4e3e53
2025-12-09 18:17:54.085 29727-29883 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.085 29727-30021 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISOWk4B0GYPuH0Objuf17D6VFjEUbfAAJuHgACuq7BVaUGm3N60DcgNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@f79489
2025-12-09 18:17:54.085 29727-30021 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.086 29727-29859 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISRWk4B3miFvKpu-es5enCj5ssqw7OAAJ6HgACuq7BVQeqqlnlpBYINgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@9746caf
2025-12-09 18:17:54.086 29727-29859 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.087 29727-29903 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISQWk4B2zek7kPqws5z0BlpsKckl3HAAJ2HgACuq7BVcfl7OfJPWIRNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@2bbf045
2025-12-09 18:17:54.087 29727-29903 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.087 29727-30031 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISKmk1471_ESpcLE2nhxTCUrP6GVp1AALNGwACqNuxVd32fi62NDe-NgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@72524cb
2025-12-09 18:17:54.087 29727-30031 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.088 29727-29897 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISQ2k4B3VoC89TJrEoGmZikzyoV_JyAAJ4HgACuq7BVT0tvpqS6Ba1NgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@8b04bc1
2025-12-09 18:17:54.088 29727-29897 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.089 29727-30032 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISK2k14756K6IZ4D9_-JVi2391vEMQAALOGwACqNuxVZHliSK8D7meNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@3df42a7
2025-12-09 18:17:54.089 29727-30032 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.090 29727-30020 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISOmk4B0Sf7GKFRC5XxHWmzPlN5w_jAAJvHgACuq7BVR5S6HpSH4wvNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@434e2fd
2025-12-09 18:17:54.090 29727-30020 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.090 29727-29761 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISPGk4B0uuVdnOiiFZ34wmn6KdYvIuAAJxHgACuq7BVY7iKQvVwLbgNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@716cedb
2025-12-09 18:17:54.090 29727-29761 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.091 29727-29817 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISLWk148EaGtqTbixQx6wMcvkThNIGAALQGwACqNuxVXUmH6zxfN3sNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@c336243
2025-12-09 18:17:54.091 29727-29817 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.092 29727-30018 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISPWk4B1RnCvMauFhsqq0c0YYhDa3NAAJyHgACuq7BVXm_qGks68M6NgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@e9d4bea
2025-12-09 18:17:54.092 29727-30018 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.093 29727-30030 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISL2k16TqJsJ6yUp5V0L5tPfLbioKzAALSGwACqNuxVW6CjPvRrW-8NgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@271b1f9
2025-12-09 18:17:54.093 29727-30030 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.093 29727-30029 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISMWk16U4ZeP9m_7azrMp7iYo1loKjAALUGwACqNuxVZShnQfKn9iMNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@b1fdf9f
2025-12-09 18:17:54.093 29727-30029 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.093 29727-30025 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISM2k4BnFZf3ytXlxjCwm2RgV1K-0XAAJhHgACuq7BVSJg5CNFxVGFNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@11274b5
2025-12-09 18:17:54.093 29727-30025 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.095 29727-30023 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISNWk4Bo6nvvr8VtbNrbtZXoi3dkx7AAJkHgACuq7BVbKGBDXIu2a3NgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@32cd6bb
2025-12-09 18:17:54.095 29727-30023 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.095 29727-30022 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISOGk4BzDKNPcFhKPsxKF4tgIicgc1AAJsHgACuq7BVRnzsT5aEYogNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@2c2a731
2025-12-09 18:17:54.095 29727-30022 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:17:54.096 29727-30024 NetworkFetcher          com.akslabs.cloudgallery             E  🌐 ❌ EXCEPTION in NetworkFetcher for remoteId: BQACAgUAAyEGAASeEFIcAAISNGk4Bojcv5nsU9yEG9_sJeaw_Cx2AAJjHgACuq7BVbqIpjKzEomzNgQ
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@d482397
2025-12-09 18:17:54.096 29727-30024 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER EXCEPTION ===
2025-12-09 18:19:21.695 29727-29727 ViewRootImpl            com.akslabs.cloudgallery             D  Skipping stats log for color mode
2025-12-09 18:19:21.965 29727-29727 InsetsController        com.akslabs.cloudgallery             D  hide(ime(), fromIme=false)
2025-12-09 18:19:21.965 29727-29727 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:81d45f8: onCancelled at PHASE_CLIENT_ALREADY_HIDDEN
2025-12-09 18:19:23.699 29727-29727 MainPage                com.akslabs.cloudgallery             D  Selection Debug: selected=0, total=151, route=settings
2025-12-09 18:19:24.324 29727-29727 Choreographer           com.akslabs.cloudgallery             I  Skipped 37 frames!  The application may be doing too much work on its main thread.
2025-12-09 18:19:24.370 29727-30024 BackupHelper            com.akslabs.cloudgallery             D  Backup status - Has backup: true, Data unchanged: false
2025-12-09 18:19:24.371 29727-30024 BackupHelper            com.akslabs.cloudgallery             D  Current: 1266 photos, 151 remote | Last backup: 1262 photos, 40 remote
2025-12-09 18:19:25.290 29727-29752 WM-Processor            com.akslabs.cloudgallery             D  Processor cancelling 62067714-b94b-48bc-818b-647f7fde3ab6
2025-12-09 18:19:25.290 29727-29752 WM-Processor            com.akslabs.cloudgallery             D  WorkerWrapper could not be found for 62067714-b94b-48bc-818b-647f7fde3ab6
2025-12-09 18:19:25.297 29727-29752 WM-GreedyScheduler      com.akslabs.cloudgallery             D  Cancelling work ID 62067714-b94b-48bc-818b-647f7fde3ab6
2025-12-09 18:19:27.749 29727-29750 WM-SystemJobScheduler   com.akslabs.cloudgallery             D  Scheduling work ID 40f68570-b4d6-4102-a241-50d5898c4b54Job ID 183
2025-12-09 18:19:27.763 29727-29750 WM-GreedyScheduler      com.akslabs.cloudgallery             D  Starting tracking for 40f68570-b4d6-4102-a241-50d5898c4b54
2025-12-09 18:19:27.806 29727-29752 WM-SystemJobScheduler   com.akslabs.cloudgallery             D  Scheduling work ID 69931b14-bc56-44bd-a292-8ac6e2344132Job ID 184
2025-12-09 18:19:27.827 29727-29752 WM-GreedyScheduler      com.akslabs.cloudgallery             D  Starting tracking for 40f68570-b4d6-4102-a241-50d5898c4b54
2025-12-09 18:19:27.829 29727-29727 WM-SystemJobService     com.akslabs.cloudgallery             D  onStartJob for WorkGenerationalId(workSpecId=40f68570-b4d6-4102-a241-50d5898c4b54, generation=0)
2025-12-09 18:19:27.838 29727-29751 WM-Processor            com.akslabs.cloudgallery             D  Processor: processing WorkGenerationalId(workSpecId=40f68570-b4d6-4102-a241-50d5898c4b54, generation=0)
2025-12-09 18:19:27.867 29727-29751 WM-ConstraintTracker    com.akslabs.cloudgallery             D  NetworkStateTracker24: initial state = NetworkState(isConnected=true, isValidated=true, isMetered=true, isNotRoaming=true)
2025-12-09 18:19:27.867 29727-29751 WM-NetworkStateTracker  com.akslabs.cloudgallery             D  Registering network callback
2025-12-09 18:19:27.874 29727-29753 WM-NetworkStateTracker  com.akslabs.cloudgallery             D  Network capabilities changed: [ Transports: CELLULAR Capabilities: SUPL&INTERNET&NOT_RESTRICTED&TRUSTED&NOT_VPN&VALIDATED&NOT_ROAMING&FOREGROUND&NOT_CONGESTED&NOT_SUSPENDED&NOT_VCN_MANAGED&NOT_BANDWIDTH_CONSTRAINED LinkUpBandwidth>=4420Kbps LinkDnBandwidth>=4420Kbps Specifier: <TelephonyNetworkSpecifier [mSubId = 1]> SubscriptionIds: {1} UnderlyingNetworks: Null]
2025-12-09 18:19:27.881 29727-29750 WM-GreedyScheduler      com.akslabs.cloudgallery             D  Constraints met: Scheduling work ID WorkGenerationalId(workSpecId=40f68570-b4d6-4102-a241-50d5898c4b54, generation=0)
2025-12-09 18:19:27.896 29727-29750 WM-Processor            com.akslabs.cloudgallery             D  Work WorkGenerationalId(workSpecId=40f68570-b4d6-4102-a241-50d5898c4b54, generation=0) is already enqueued for processing
2025-12-09 18:19:27.911 29727-29727 WM-WorkerWrapper        com.akslabs.cloudgallery             D  Starting work for com.akslabs.cloudgallery.workers.PeriodicPhotoBackupWorker
2025-12-09 18:19:34.631 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-12-09 18:19:34.631 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 1266
2025-12-09 18:19:34.631 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos (Paging) itemCount: 180
2025-12-09 18:19:34.631 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  AllPhotos (Custom) size: 0
2025-12-09 18:19:34.631 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-12-09 18:19:34.631 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-12-09 18:19:34.631 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-12-09 18:19:34.631 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-12-09 18:19:34.656 29727-30022 LocalPhotoGrid          com.akslabs.cloudgallery             D  fetchAllLocalPhotos: Cursor count: 1266
2025-12-09 18:19:34.680 29727-30022 LocalPhotoGrid          com.akslabs.cloudgallery             D  fetchAllLocalPhotos: Fetched 1266 photos
2025-12-09 18:19:34.684 29727-29727 MainPage                com.akslabs.cloudgallery             D  Selection Debug: selected=0, total=1266, route=device
2025-12-09 18:19:34.755 29727-29727 WindowOnBackDispatcher  com.akslabs.cloudgallery             W  sendCancelIfRunning: isInProgress=false callback=androidx.navigationevent.OnBackInvokedInput$createOnBackAnimationCallback$1@c419f64
2025-12-09 18:19:34.880 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-12-09 18:19:34.880 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 1266
2025-12-09 18:19:34.880 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos (Paging) itemCount: 180
2025-12-09 18:19:34.880 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  AllPhotos (Custom) size: 0
2025-12-09 18:19:34.880 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-12-09 18:19:34.880 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-12-09 18:19:34.880 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-12-09 18:19:34.880 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-12-09 18:19:34.896 29727-30022 LocalPhotoGrid          com.akslabs.cloudgallery             D  fetchAllLocalPhotos: Cursor count: 1266
2025-12-09 18:19:34.923 29727-30022 LocalPhotoGrid          com.akslabs.cloudgallery             D  fetchAllLocalPhotos: Fetched 1266 photos
2025-12-09 18:19:35.033 29727-29732 bs.cloudgallery         com.akslabs.cloudgallery             I  Background concurrent copying GC freed 8897KB AllocSpace bytes, 2(72KB) LOS objects, 49% free, 15MB/30MB, paused 110us,45us total 107.754ms
2025-12-09 18:19:35.551 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-12-09 18:19:35.551 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 1266
2025-12-09 18:19:35.551 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos (Paging) itemCount: 180
2025-12-09 18:19:35.551 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  AllPhotos (Custom) size: 1266
2025-12-09 18:19:35.552 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-12-09 18:19:35.552 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-12-09 18:19:35.552 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-12-09 18:19:35.552 29727-29727 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-12-09 18:19:35.557 29727-29727 Choreographer           com.akslabs.cloudgallery             I  Skipped 36 frames!  The application may be doing too much work on its main thread.
2025-12-09 18:19:46.179 29727-29727 InsetsController        com.akslabs.cloudgallery             D  hide(ime(), fromIme=false)
2025-12-09 18:19:46.179 29727-29727 ImeTracker              com.akslabs.cloudgallery             I  com.akslabs.cloudgallery:6b65cd3e: onCancelled at PHASE_CLIENT_ALREADY_HIDDEN
2025-12-09 18:19:50.921 29727-30024 ContentValues           com.akslabs.cloudgallery             D  sendFile: Success! Metadata included in caption.
2025-12-09 18:19:50.927 29727-29727 RemoteViewModel         com.akslabs.cloudgallery             E  📊 Total count updated: 152
2025-12-09 18:19:50.928 29727-29727 MainViewModel           com.akslabs.cloudgallery             D  === CREATING NEW REMOTE PAGING SOURCE ===
2025-12-09 18:19:50.949 29727-29727 MainViewModel           com.akslabs.cloudgallery             D  === CREATING NEW REMOTE PAGING SOURCE ===
2025-12-09 18:19:50.973 29727-29727 MainPage                com.akslabs.cloudgallery             D  Selection Debug: selected=0, total=1266, route=device
2025-12-09 18:19:52.990 29727-29727 JobService              com.akslabs.cloudgallery             W  onNetworkChanged() not implemented in androidx.work.impl.background.systemjob.SystemJobService. Must override in a subclass.
2025-12-09 18:19:55.570 29727-30022 ContentValues           com.akslabs.cloudgallery             D  sendFile: Success! Metadata included in caption.
2025-12-09 18:19:55.574 29727-29727 MainViewModel           com.akslabs.cloudgallery             D  === CREATING NEW REMOTE PAGING SOURCE ===
2025-12-09 18:19:55.595 29727-29727 RemoteViewModel         com.akslabs.cloudgallery             E  📊 Total count updated: 153
2025-12-09 18:19:55.600 29727-29727 MainPage                com.akslabs.cloudgallery             D  Selection Debug: selected=0, total=1266, route=device
2025-12-09 18:19:57.200 29727-30022 ContentValues           com.akslabs.cloudgallery             D  sendFile: Success! Metadata included in caption.
2025-12-09 18:19:57.202 29727-29727 MainViewModel           com.akslabs.cloudgallery             D  === CREATING NEW REMOTE PAGING SOURCE ===
2025-12-09 18:19:57.213 29727-29727 RemoteViewModel         com.akslabs.cloudgallery             E  📊 Total count updated: 154
2025-12-09 18:19:57.219 29727-29727 MainPage                com.akslabs.cloudgallery             D  Selection Debug: selected=0, total=1266, route=device
2025-12-09 18:20:01.375 29727-30024 ContentValues           com.akslabs.cloudgallery             D  sendFile: Success! Metadata included in caption.
2025-12-09 18:20:01.381 29727-29727 MainViewModel           com.akslabs.cloudgallery             D  === CREATING NEW REMOTE PAGING SOURCE ===
2025-12-09 18:20:01.399 29727-29727 RemoteViewModel         com.akslabs.cloudgallery             E  📊 Total count updated: 155
2025-12-09 18:20:01.402 29727-29727 MainPage                com.akslabs.cloudgallery             D  Selection Debug: selected=0, total=1266, route=device
2025-12-09 18:20:02.638 29727-29727 JobService              com.akslabs.cloudgallery             W  onNetworkChanged() not implemented in androidx.work.impl.background.systemjob.SystemJobService. Must override in a subclass.
2025-12-09 18:20:02.662 29727-29753 WM-NetworkStateTracker  com.akslabs.cloudgallery             D  Network capabilities changed: [ Transports: CELLULAR Capabilities: SUPL&INTERNET&NOT_RESTRICTED&TRUSTED&NOT_VPN&VALIDATED&NOT_ROAMING&FOREGROUND&NOT_CONGESTED&NOT_SUSPENDED&NOT_VCN_MANAGED&NOT_BANDWIDTH_CONSTRAINED LinkUpBandwidth>=7581Kbps LinkDnBandwidth>=7581Kbps Specifier: <TelephonyNetworkSpecifier [mSubId = 1]> SubscriptionIds: {1} UnderlyingNetworks: Null]
2025-12-09 18:20:05.992 29727-30022 ContentValues           com.akslabs.cloudgallery             D  sendFile: Success! Metadata included in caption.
2025-12-09 18:20:05.995 29727-29727 MainViewModel           com.akslabs.cloudgallery             D  === CREATING NEW REMOTE PAGING SOURCE ===
2025-12-09 18:20:06.024 29727-29727 RemoteViewModel         com.akslabs.cloudgallery             E  📊 Total count updated: 156
2025-12-09 18:20:06.037 29727-29727 MainPage                com.akslabs.cloudgallery             D  Selection Debug: selected=0, total=1266, route=device
2025-12-09 18:20:07.667 29727-30022 ContentValues           com.akslabs.cloudgallery             D  sendFile: Success! Metadata included in caption.
2025-12-09 18:20:07.675 29727-29727 MainPage                com.akslabs.cloudgallery             D  Selection Debug: selected=0, total=1266, route=device
2025-12-09 18:20:07.685 29727-29727 MainViewModel           com.akslabs.cloudgallery             D  === CREATING NEW REMOTE PAGING SOURCE ===
2025-12-09 18:20:07.703 29727-29727 RemoteViewModel         com.akslabs.cloudgallery             E  📊 Total count updated: 157
2025-12-09 18:20:09.086 29727-30022 ContentValues           com.akslabs.cloudgallery             D  sendFile: Success! Metadata included in caption.
2025-12-09 18:20:09.088 29727-29727 MainViewModel           com.akslabs.cloudgallery             D  === CREATING NEW REMOTE PAGING SOURCE ===
2025-12-09 18:20:09.100 29727-29727 RemoteViewModel         com.akslabs.cloudgallery             E  📊 Total count updated: 158
2025-12-09 18:20:09.105 29727-29727 MainPage                com.akslabs.cloudgallery             D  Selection Debug: selected=0, total=1266, route=device
