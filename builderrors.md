        W  Image decoding logging dropped!
2026-02-10 16:12:47.467 30627-30749 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2026-02-10 16:12:47.482 30627-30813 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2026-02-10 16:12:47.543 30627-30826 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2026-02-10 16:12:47.556 30627-30779 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2026-02-10 16:12:47.573  1865-31399 ActivityManager         system_server                        E  ANR in com.akslabs.cloudgallery (com.akslabs.cloudgallery/.ui.MainActivity)
                                                                                                    PID: 30627
                                                                                                    Reason: Input dispatching timed out (a400799 com.akslabs.cloudgallery/com.akslabs.cloudgallery.ui.MainActivity is not responding. Waited 5002ms for MotionEvent).
                                                                                                    Parent: com.akslabs.cloudgallery/.ui.MainActivity
                                                                                                    ErrorId: ac301461-8cdd-4399-b9e2-345dc9fc6629
                                                                                                    Frozen: false
                                                                                                    CPU usage from 13ms to 464ms later (2026-02-10 16:12:41.193 to 2026-02-10 16:12:41.645):
                                                                                                      251% 30627/com.akslabs.cloudgallery: 202% user + 48% kernel / faults: 3966 minor 242 major
                                                                                                        94% 30627/bs.cloudgallery: 83% user + 10% kernel
                                                                                                        76% 30792/DefaultDispatch: 76% user + 0% kernel
                                                                                                        69% 30641/Signal Catcher: 41% user + 27% kernel
                                                                                                        3.4% 30644/Jit thread pool: 3.4% user + 0% kernel
                                                                                                        3.4% 30895/binder:30627_7: 0% user + 3.4% kernel
                                                                                                      150% 1865/system_server: 73% user + 76% kernel / faults: 14833 minor 30 major
                                                                                                        96% 1888/HeapTaskDaemon: 56% user + 39% kernel
                                                                                                        45% 31400/AnrAuxiliaryTas: 11% user + 33% kernel
                                                                                                        2.8% 1865/system_server: 2.8% user + 0% kernel
                                                                                                        2.8% 1928/ActivityManager: 0% user + 2.8% kernel
                                                                                                        2.8% 1955/bgres-controlle: 2.8% user + 0% kernel
                                                                                                        2.8% 2487/HwBinder:1865_5: 2.8% user + 0% kernel
                                                                                                        2.8% 4718/binder:1865_13: 0% user + 2.8% kernel
                                                                                                        2.8% 7715/binder:1865_1B: 2.8% user + 0% kernel
                                                                                                      87% 134/kswapd0: 0% user + 87% kernel
                                                                                                      56% 31389/logcat: 14% user + 42% kernel
                                                                                                      23% 1078/surfaceflinger: 18% user + 5.3% kernel
                                                                                                        7.9% 1078/surfaceflinger: 5.3% user + 2.6% kernel
                                                                                                        5.3% 1161/RenderEngine: 5.3% user + 0% kernel
                                                                                                        2.6% 1198/TimerDispatch: 2.6% user + 0% kernel
                                                                                                        2.6% 1200/app: 2.6% user + 0% kernel
                                                                                                        2.6% 2937/binder:1078_5: 0% user + 2.6% kernel
                                                                                                      23% 3384/app.revanced.android.youtube: 23% user + 0% kernel / faults: 109 minor 2 major
                                                                                                        5.8% 3592/ExoPlayer:Playb: 5.8% user + 0% kernel
                                                                                                        2.9% 3384/android.youtube: 2.9% user + 0% kernel
                                                                                                        2.9% 3565/Lite Thread #1: 2.9% user + 0% kernel
                                                                                                        2.9% 3593/ComponentLayout: 2.9% user + 0% kernel
                                                                                                        2.9% 7085/CodecLooper: 2.9% user + 0% kernel
                                                                                                      16% 1449/adbd: 5.6% user + 11% kernel / faults: 19 minor
                                                                                                        14% 1449/adbd: 5.6% user + 8.4% kernel
                                                                                                       +0% 31401/UsbFfs-monitor: 0% user + 0% kernel
                                                                                                      12% 618/logd: 5% user + 7.5% kernel / faults: 116 minor
                                                                                                        10% 31393/logd.reader.per: 5% user + 5% kernel
                                                                                                      13% 27125/kworker/u16:8: 0% user + 13% kernel
                                                                                                      7.4% 407/mmc-cmdqd/0: 0% user + 7.4% kernel
                                                                                                      9.6% 21655/kworker/u16:3: 0% user + 9.6% kernel
                                                                                                      9.6% 21689/kworker/u16:12: 0% user + 9.6% kernel
                                                                                                      5.2% 1028/android.hardware.graphics.composer@2.3-service: 2.6% user + 2.6% kernel
                                                                                                        5.2% 1100/HwBinder:1028_1: 2.6% user + 2.6% kernel
                                                                                                      5.4% 1302/media.codec: 2.7% user + 2.7% kernel / faults: 1 minor
                                                                                                        2.7% 4720/HwBinder:1302_7: 2.7% user + 0% kernel
                                                                                                        2.7% 7087/VideoDecMsgThre: 2.7% user + 0% kernel
                                                                                                      5.9% 4168/com.android.providers.media.module: 2.9% user + 2.9% kernel / faults: 1202 minor
                                                                                                        5.9% 14361/binder:4168_D: 2.9% user + 2.9% kernel
                                                                                                      6.8% 30445/kworker/u16:5: 0% user + 6.8% kernel
                                                                                                      2.2% 1/init: 0% user + 2.2% kernel / faults: 2 minor 3 major
                                                                                                        2.2% 1/init: 0% user + 2.2% kernel
                                                                                                      2.3% 61/rcuop/6: 0% user + 2.3% kernel
                                                                                                      2.3% 69/rcuop/7: 0% user + 2.3% kernel
                                                                                                      2.3% 242/crtc_commit:100: 0% user + 2.3% kernel
                                                                                                      2.5% 527/ueventd: 2.5% user + 0% kernel
                                                                                                      2.6% 1015/android.hardware.audio.service: 0% user + 2.6% kernel
                                                                                                      2.6% 1029/android.hardware.health@2.1-service: 0% user + 2.6% kernel
                                                                                                      2.8% 2357/com.android.systemui: 2.8% user + 0% kernel / faults: 13 minor
                                                                                                        2.8% 2357/ndroid.systemui: 0% user + 2.8% kernel
                                                                                                        2.8% 2894/pool-14-thread-: 0% user + 2.8% kernel
                                                                                                    83% TOTAL: 43% user + 34% kernel + 3.6% iowait + 1.3% irq + 1.3% softirq
2026-02-10 16:12:47.594 30627-30813 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2026-02-10 16:12:47.594 30627-30812 HWUI                    com.akslabs.cloudgallery             W  Image decoding logging dropped!
2026-02-10 16:12:47.597 30627-30705 HWUI                    com.akslabs.cloudgallery   