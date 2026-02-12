   W  Image decoding logging dropped!
2026-02-12 19:11:28.777  1782-22221 ActivityManager         system_server                        E  ANR in com.akslabs.cloudgallery (com.akslabs.cloudgallery/.ui.MainActivity)
                                                                                                    PID: 16913
                                                                                                    Reason: Input dispatching timed out (bce0951 com.akslabs.cloudgallery/com.akslabs.cloudgallery.ui.MainActivity is not responding. Waited 5002ms for MotionEvent).
                                                                                                    Parent: com.akslabs.cloudgallery/.ui.MainActivity
                                                                                                    ErrorId: 900cb092-bccd-4f97-8d98-7d7ae4daddc1
                                                                                                    Frozen: false
                                                                                                    CPU usage from 41ms to 479ms later (2026-02-12 19:11:23.465 to 2026-02-12 19:11:23.903):
                                                                                                      296% 16913/com.akslabs.cloudgallery: 252% user + 43% kernel / faults: 7280 minor 413 major
                                                                                                        97% 16913/bs.cloudgallery: 97% user + 0% kernel
                                                                                                        80% 20471/Signal Catcher: 40% user + 40% kernel
                                                                                                        53% 21796/DefaultDispatch: 53% user + 0% kernel
                                                                                                        37% 21747/DefaultDispatch: 33% user + 3.3% kernel
                                                                                                        23% 21790/DefaultDispatch: 23% user + 0% kernel
                                                                                                        3.3% 20498/RenderThread: 0% user + 3.3% kernel
                                                                                                      52% 134/kswapd0: 0% user + 52% kernel
                                                                                                      52% 1782/system_server: 17% user + 35% kernel / faults: 705 minor
                                                                                                        41% 22224/AnrAuxiliaryTas: 11% user + 29% kernel
                                                                                                        11% 1806/binder:1782_2: 8.8% user + 2.9% kernel
                                                                                                      21% 4225/com.android.providers.media.module: 12% user + 9.2% kernel / faults: 163 minor
                                                                                                        21% 12676/binder:4225_A: 12% user + 9.2% kernel
                                                                                                      7.5% 407/mmc-cmdqd/0: 0% user + 7.5% kernel
                                                                                                      2.2% 7/rcu_preempt: 0% user + 2.2% kernel
                                                                                                      2.2% 8/rcu_sched: 0% user + 2.2% kernel
                                                                                                      2.3% 25/migration/2: 0% user + 2.3% kernel
                                                                                                      2.5% 618/lmkd: 0% user + 2.5% kernel
                                                                                                        2.5% 618/lmkd: 0% user + 2.5% kernel
                                                                                                      2.7% 1071/surfaceflinger: 0% user + 2.7% kernel
                                                                                                        2.7% 1188/TimerDispatch: 0% user + 2.7% kernel
                                                                                                        2.7% 1190/app: 2.7% user + 0% kernel
                                                                                                      2.9% 2280/com.android.systemui: 2.9% user + 0% kernel / faults: 9 minor
                                                                                                        2.9% 2280/ndroid.systemui: 2.9% user + 0% kernel
                                                                                                        2.9% 2395/SystemUIBg-2: 2.9% user + 0% kernel
                                                                                                      3.2% 6967/cds_ol_rx_threa: 0% user + 3.2% kernel
                                                                                                      3.2% 7070/kworker/u16:9: 0% user + 3.2% kernel
                                                                                                      3.3% 17143/kworker/u17:0: 0% user + 3.3% kernel
                                                                                                      3.6% 25793/com.instagram.android: 0% user + 3.6% kernel / faults: 2 minor
                                                                                                        3.6% 25793/stagram.android: 0% user + 3.6% kernel
                                                                                                    59% TOTAL: 31% user + 20% kernel + 4.7% iowait + 1.1% irq + 0.8% softirq
2026-02-12 19:11:40.977 16913-20475 bs.cloudgallery         com.akslabs.cloudgallery             I  Background concurrent copying GC freed 8833KB AllocSpace bytes, 4(80KB) LOS objects, 49% free, 29MB/58MB, paused 166us,122us total 219.285ms
2026-02-12 19:11:41.325 16913-21754 HWUI                    com.akslabs.cloudgallery           