--------- beginning of crash
2025-08-13 16:01:55.584  8122-8122  AndroidRuntime          pid-8122                             E  FATAL EXCEPTION: main
                                                                                                    Process: com.akslabs.cloudgallery, PID: 8122
                                                                                                    java.lang.IllegalArgumentException: Maximum size must be at least pageSize + 2*prefetchDist, pageSize=20, prefetchDist=20, maxSize=40
                                                                                                    	at androidx.paging.PagingConfig.<init>(PagingConfig.kt:147)
                                                                                                    	at androidx.paging.PagingConfig.<init>(PagingConfig.kt:29)
                                                                                                    	at com.akslabs.cloudgallery.ui.main.screens.local.LocalViewModel$localPhotosFlow$2.invoke(LocalViewModel.kt:26)
                                                                                                    	at com.akslabs.cloudgallery.ui.main.screens.local.LocalViewModel$localPhotosFlow$2.invoke(LocalViewModel.kt:24)
                                                                                                    	at kotlin.SynchronizedLazyImpl.getValue(LazyJVM.kt:74)
                                                                                                    	at com.akslabs.cloudgallery.ui.main.screens.local.LocalViewModel.getLocalPhotosFlow(LocalViewModel.kt:24)
                                                                                                    	at com.akslabs.cloudgallery.ui.main.nav.ComposableSingletons$AppNavHostKt$lambda-1$1.invoke(AppNavHost.kt:36)
                                                                                                    	at com.akslabs.cloudgallery.ui.main.nav.ComposableSingletons$AppNavHostKt$lambda-1$1.invoke(AppNavHost.kt:34)
                                                                                                    	at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:139)
                                                                                                    	at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:35)
                                                                                                    	at androidx.navigation.compose.NavHostKt$NavHost$32$1.invoke(NavHost.kt:671)
                                                                                                    	at androidx.navigation.compose.NavHostKt$NavHost$32$1.invoke(NavHost.kt:670)
                                                                                                    	at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:109)
                                                                                                    	at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:35)
                                                                                                    	at androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider(CompositionLocal.kt:401)
                                                                                                    	at androidx.compose.runtime.saveable.SaveableStateHolderImpl.SaveableStateProvider(SaveableStateHolder.kt:85)
                                                                                                    	at androidx.navigation.compose.NavBackStackEntryProviderKt.SaveableStateProvider(NavBackStackEntryProvider.kt:65)
                                                                                                    	at androidx.navigation.compose.NavBackStackEntryProviderKt.access$SaveableStateProvider(NavBackStackEntryProvider.kt:1)
                                                                                                    	at androidx.navigation.compose.NavBackStackEntryProviderKt$LocalOwnersProvider$1.invoke(NavBackStackEntryProvider.kt:52)
                                                                                                    	at androidx.navigation.compose.NavBackStackEntryProviderKt$LocalOwnersProvider$1.invoke(NavBackStackEntryProvider.kt:51)
                                                                                                    	at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:109)
                                                                                                    	at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:35)
                                                                                                    	at androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider(CompositionLocal.kt:380)
                                                                                                    	at androidx.navigation.compose.NavBackStackEntryProviderKt.LocalOwnersProvider(NavBackStackEntryProvider.kt:47)
                                                                                                    	at androidx.navigation.compose.NavHostKt$NavHost$32.invoke(NavHost.kt:670)
                                                                                                    	at androidx.navigation.compose.NavHostKt$NavHost$32.invoke(NavHost.kt:651)
                                                                                                    	at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:139)
                                                                                                    	at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:35)
                                                                                                    	at androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$5.invoke(AnimatedContent.kt:803)
                                                                                                    	at androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$5.invoke(AnimatedContent.kt:792)
                                                                                                    	at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:118)
                                                                                                    	at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:35)
                                                                                                    	at androidx.compose.animation.AnimatedVisibilityKt.AnimatedEnterExitImpl(AnimatedVisibility.kt:771)
                                                                                                    	at androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1.invoke(AnimatedContent.kt:774)
                                                                                                    	at androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1.invoke(AnimatedContent.kt:757)
                                                                                                    	at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:109)
                                                                                                    	at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:35)
                                                                                                    	at androidx.compose.animation.AnimatedContentKt.AnimatedContent(AnimatedContent.kt:816)
                                                                                                    	at androidx.navigation.compose.NavHostKt.NavHost(NavHost.kt:623)
                                                                                                    	at androidx.navigation.compose.NavHostKt.NavHost(NavHost.kt:211)
2025-08-13 16:01:55.585  8122-8122  AndroidRuntime          pid-8122                             E  	at com.akslabs.cloudgallery.ui.main.nav.AppNavHostKt.AppNavHost(AppNavHost.kt:27)
                                                                                                    	at com.akslabs.cloudgallery.ui.main.MainPageKt$MainPage$4$3$1.invoke(MainPage.kt:251)
                                                                                                    	at com.akslabs.cloudgallery.ui.main.MainPageKt$MainPage$4$3$1.invoke(MainPage.kt:250)
                                                                                                    	at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:109)
                                                                                                    	at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:35)
                                                                                                    	at androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider(CompositionLocal.kt:401)
                                                                                                    	at com.akslabs.cloudgallery.ui.main.MainPageKt$MainPage$4$3.invoke(MainPage.kt:250)
                                                                                                    	at com.akslabs.cloudgallery.ui.main.MainPageKt$MainPage$4$3.invoke(MainPage.kt:249)
                                                                                                    	at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:118)
                                                                                                    	at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:35)
                                                                                                    	at androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1$bodyContentPlaceables$1.invoke(Scaffold.kt:261)
                                                                                                    	at androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1$bodyContentPlaceables$1.invoke(Scaffold.kt:238)
                                                                                                    	at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:109)
                                                                                                    	at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:35)
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState$subcompose$3$1$1.invoke(SubcomposeLayout.kt:1017)
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState$subcompose$3$1$1.invoke(SubcomposeLayout.kt:493)
                                                                                                    	at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:109)
                                                                                                    	at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:35)
                                                                                                    	at androidx.compose.runtime.ActualJvm_jvmKt.invokeComposable(ActualJvm.jvm.kt:97)
                                                                                                    	at androidx.compose.runtime.ComposerImpl.doCompose(Composer.kt:3595)
                                                                                                    	at androidx.compose.runtime.ComposerImpl.composeContent$runtime_release(Composer.kt:3522)
                                                                                                    	at androidx.compose.runtime.CompositionImpl.composeContent(Composition.kt:743)
                                                                                                    	at androidx.compose.runtime.Recomposer.composeInitial$runtime_release(Recomposer.kt:1122)
                                                                                                    	at androidx.compose.runtime.ComposerImpl$CompositionContextImpl.composeInitial$runtime_release(Composer.kt:3876)
                                                                                                    	at androidx.compose.runtime.CompositionImpl.composeInitial(Composition.kt:649)
                                                                                                    	at androidx.compose.runtime.CompositionImpl.setContent(Composition.kt:635)
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState.subcomposeInto(SubcomposeLayout.kt:516)
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState.subcompose(SubcomposeLayout.kt:488)
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState.subcompose(SubcomposeLayout.kt:479)
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState.subcompose(SubcomposeLayout.kt:463)
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState$Scope.subcompose(SubcomposeLayout.kt:895)
                                                                                                    	at androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1.invoke-0kLqBqw(Scaffold.kt:238)
                                                                                                    	at androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1.invoke(Scaffold.kt:140)
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1.measure-3p2s80s(SubcomposeLayout.kt:725)
                                                                                                    	at androidx.compose.ui.node.InnerNodeCoordinator.measure-BRTryo0(InnerNodeCoordinator.kt:135)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate$performMeasureBlock$1.invoke(LayoutNodeLayoutDelegate.kt:316)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate$performMeasureBlock$1.invoke(LayoutNodeLayoutDelegate.kt:315)
                                                                                                    	at androidx.compose.runtime.snapshots.Snapshot$Companion.observe(Snapshot.kt:503)
                                                                                                    	at androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap.observe(SnapshotStateObserver.kt:502)
                                                                                                    	at androidx.compose.runtime.snapshots.SnapshotStateObserver.observeReads(SnapshotStateObserver.kt:258)
                                                                                                    	at androidx.compose.ui.node.OwnerSnapshotObserver.observeReads$ui_release(OwnerSnapshotObserver.kt:133)
2025-08-13 16:03:13.279  8123-8123  AndroidRuntime          pid-8123                             E  FATAL EXCEPTION: main
                                                                                                    Process: com.akslabs.cloudgallery, PID: 8123
                                                                                                    java.lang.IllegalArgumentException: Key "header_Wed 19 - February 2025" was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item.
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState.subcompose(SubcomposeLayout.kt:453)
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState$Scope.subcompose(SubcomposeLayout.kt:895)
                                                                                                    	at androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScopeImpl.measure-0kLqBqw(LazyLayoutMeasureScope.kt:125)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider.getAndMeasure-m8Kt_7k(LazyGridMeasuredItemProvider.kt:62)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider.getAndMeasure(LazyGridMeasuredLineProvider.kt:72)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridMeasureKt.measureLazyGrid-OZKpZRA(LazyGridMeasure.kt:202)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.invoke-0kLqBqw(LazyGrid.kt:341)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.invoke(LazyGrid.kt:172)
                                                                                                    	at androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$2$1.invoke-0kLqBqw(LazyLayout.kt:119)
                                                                                                    	at androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$2$1.invoke(LazyLayout.kt:112)
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1.measure-3p2s80s(SubcomposeLayout.kt:725)
                                                                                                    	at androidx.compose.ui.node.InnerNodeCoordinator.measure-BRTryo0(InnerNodeCoordinator.kt:135)
                                                                                                    	at androidx.compose.ui.graphics.SimpleGraphicsLayerModifier.measure-3p2s80s(GraphicsLayerModifier.kt:646)
                                                                                                    	at androidx.compose.ui.node.LayoutModifierNodeCoordinator.measure-BRTryo0(LayoutModifierNodeCoordinator.kt:188)
                                                                                                    	at androidx.compose.foundation.layout.FillNode.measure-3p2s80s(Size.kt:699)
                                                                                                    	at androidx.compose.ui.node.LayoutModifierNodeCoordinator.measure-BRTryo0(LayoutModifierNodeCoordinator.kt:188)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate$performMeasureBlock$1.invoke(LayoutNodeLayoutDelegate.kt:316)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate$performMeasureBlock$1.invoke(LayoutNodeLayoutDelegate.kt:315)
                                                                                                    	at androidx.compose.runtime.snapshots.Snapshot$Companion.observe(Snapshot.kt:2441)
                                                                                                    	at androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap.observe(SnapshotStateObserver.kt:502)
                                                                                                    	at androidx.compose.runtime.snapshots.SnapshotStateObserver.observeReads(SnapshotStateObserver.kt:258)
                                                                                                    	at androidx.compose.ui.node.OwnerSnapshotObserver.observeReads$ui_release(OwnerSnapshotObserver.kt:133)
                                                                                                    	at androidx.compose.ui.node.OwnerSnapshotObserver.observeMeasureSnapshotReads$ui_release(OwnerSnapshotObserver.kt:113)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate.performMeasure-BRTryo0(LayoutNodeLayoutDelegate.kt:1782)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate.access$performMeasure-BRTryo0(LayoutNodeLayoutDelegate.kt:40)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate.remeasure-BRTryo0(LayoutNodeLayoutDelegate.kt:696)
                                                                                                    	at androidx.compose.ui.node.LayoutNode.remeasure-_Sx5XlM$ui_release(LayoutNode.kt:1222)
                                                                                                    	at androidx.compose.ui.node.MeasureAndLayoutDelegate.doRemeasure-sdFAvZA(MeasureAndLayoutDelegate.kt:367)
                                                                                                    	at androidx.compose.ui.node.MeasureAndLayoutDelegate.measureAndLayout-0kLqBqw(MeasureAndLayoutDelegate.kt:463)
                                                                                                    	at androidx.compose.ui.platform.AndroidComposeView.measureAndLayout-0kLqBqw(AndroidComposeView.android.kt:1280)
                                                                                                    	at androidx.compose.ui.node.LayoutNode.forceRemeasure(LayoutNode.kt:1296)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridState.onScroll$foundation_release(LazyGridState.kt:421)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridState$scrollableState$1.invoke(LazyGridState.kt:211)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridState$scrollableState$1.invoke(LazyGridState.kt:211)
2025-08-13 16:43:16.282 14243-14243 AndroidRuntime          pid-14243                            E  FATAL EXCEPTION: main
                                                                                                    Process: com.akslabs.cloudgallery, PID: 14243
                                                                                                    java.lang.IllegalArgumentException: Key "1000009736" was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item.
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState.subcompose(SubcomposeLayout.kt:453)
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState$Scope.subcompose(SubcomposeLayout.kt:895)
                                                                                                    	at androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScopeImpl.measure-0kLqBqw(LazyLayoutMeasureScope.kt:125)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider.getAndMeasure-m8Kt_7k(LazyGridMeasuredItemProvider.kt:62)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider.getAndMeasure(LazyGridMeasuredLineProvider.kt:72)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridMeasureKt.measureLazyGrid-OZKpZRA(LazyGridMeasure.kt:202)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.invoke-0kLqBqw(LazyGrid.kt:341)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.invoke(LazyGrid.kt:172)
                                                                                                    	at androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$2$1.invoke-0kLqBqw(LazyLayout.kt:119)
                                                                                                    	at androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$2$1.invoke(LazyLayout.kt:112)
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1.measure-3p2s80s(SubcomposeLayout.kt:725)
                                                                                                    	at androidx.compose.ui.node.InnerNodeCoordinator.measure-BRTryo0(InnerNodeCoordinator.kt:135)
                                                                                                    	at androidx.compose.ui.graphics.SimpleGraphicsLayerModifier.measure-3p2s80s(GraphicsLayerModifier.kt:646)
                                                                                                    	at androidx.compose.ui.node.LayoutModifierNodeCoordinator.measure-BRTryo0(LayoutModifierNodeCoordinator.kt:188)
                                                                                                    	at androidx.compose.foundation.layout.FillNode.measure-3p2s80s(Size.kt:699)
                                                                                                    	at androidx.compose.ui.node.LayoutModifierNodeCoordinator.measure-BRTryo0(LayoutModifierNodeCoordinator.kt:188)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate$performMeasureBlock$1.invoke(LayoutNodeLayoutDelegate.kt:316)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate$performMeasureBlock$1.invoke(LayoutNodeLayoutDelegate.kt:315)
                                                                                                    	at androidx.compose.runtime.snapshots.Snapshot$Companion.observe(Snapshot.kt:2441)
                                                                                                    	at androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap.observe(SnapshotStateObserver.kt:502)
                                                                                                    	at androidx.compose.runtime.snapshots.SnapshotStateObserver.observeReads(SnapshotStateObserver.kt:258)
                                                                                                    	at androidx.compose.ui.node.OwnerSnapshotObserver.observeReads$ui_release(OwnerSnapshotObserver.kt:133)
                                                                                                    	at androidx.compose.ui.node.OwnerSnapshotObserver.observeMeasureSnapshotReads$ui_release(OwnerSnapshotObserver.kt:113)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate.performMeasure-BRTryo0(LayoutNodeLayoutDelegate.kt:1782)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate.access$performMeasure-BRTryo0(LayoutNodeLayoutDelegate.kt:40)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate.remeasure-BRTryo0(LayoutNodeLayoutDelegate.kt:696)
                                                                                                    	at androidx.compose.ui.node.LayoutNode.remeasure-_Sx5XlM$ui_release(LayoutNode.kt:1222)
                                                                                                    	at androidx.compose.ui.node.MeasureAndLayoutDelegate.doRemeasure-sdFAvZA(MeasureAndLayoutDelegate.kt:367)
                                                                                                    	at androidx.compose.ui.node.MeasureAndLayoutDelegate.measureAndLayout-0kLqBqw(MeasureAndLayoutDelegate.kt:463)
                                                                                                    	at androidx.compose.ui.platform.AndroidComposeView.measureAndLayout-0kLqBqw(AndroidComposeView.android.kt:1280)
                                                                                                    	at androidx.compose.ui.node.LayoutNode.forceRemeasure(LayoutNode.kt:1296)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridState.onScroll$foundation_release(LazyGridState.kt:421)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridState$scrollableState$1.invoke(LazyGridState.kt:211)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridState$scrollableState$1.invoke(LazyGridState.kt:211)
                                                                                                    	at androidx.compose.foundation.gestures.DefaultScrollableState$scrollScope$1.scrollBy(ScrollableState.kt:184)
2025-08-13 16:44:23.649 14244-14244 AndroidRuntime          pid-14244                            E  FATAL EXCEPTION: main
                                                                                                    Process: com.akslabs.cloudgallery, PID: 14244
                                                                                                    java.lang.IllegalArgumentException: Key "1000009736" was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item.
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState.subcompose(SubcomposeLayout.kt:453)
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState$Scope.subcompose(SubcomposeLayout.kt:895)
                                                                                                    	at androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScopeImpl.measure-0kLqBqw(LazyLayoutMeasureScope.kt:125)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider.getAndMeasure-m8Kt_7k(LazyGridMeasuredItemProvider.kt:62)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider.getAndMeasure(LazyGridMeasuredLineProvider.kt:72)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridMeasureKt.measureLazyGrid-OZKpZRA(LazyGridMeasure.kt:202)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.invoke-0kLqBqw(LazyGrid.kt:341)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.invoke(LazyGrid.kt:172)
                                                                                                    	at androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$2$1.invoke-0kLqBqw(LazyLayout.kt:119)
                                                                                                    	at androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$2$1.invoke(LazyLayout.kt:112)
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1.measure-3p2s80s(SubcomposeLayout.kt:725)
                                                                                                    	at androidx.compose.ui.node.InnerNodeCoordinator.measure-BRTryo0(InnerNodeCoordinator.kt:135)
                                                                                                    	at androidx.compose.ui.graphics.SimpleGraphicsLayerModifier.measure-3p2s80s(GraphicsLayerModifier.kt:646)
                                                                                                    	at androidx.compose.ui.node.LayoutModifierNodeCoordinator.measure-BRTryo0(LayoutModifierNodeCoordinator.kt:188)
                                                                                                    	at androidx.compose.foundation.layout.FillNode.measure-3p2s80s(Size.kt:699)
                                                                                                    	at androidx.compose.ui.node.LayoutModifierNodeCoordinator.measure-BRTryo0(LayoutModifierNodeCoordinator.kt:188)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate$performMeasureBlock$1.invoke(LayoutNodeLayoutDelegate.kt:316)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate$performMeasureBlock$1.invoke(LayoutNodeLayoutDelegate.kt:315)
                                                                                                    	at androidx.compose.runtime.snapshots.Snapshot$Companion.observe(Snapshot.kt:2441)
                                                                                                    	at androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap.observe(SnapshotStateObserver.kt:502)
                                                                                                    	at androidx.compose.runtime.snapshots.SnapshotStateObserver.observeReads(SnapshotStateObserver.kt:258)
                                                                                                    	at androidx.compose.ui.node.OwnerSnapshotObserver.observeReads$ui_release(OwnerSnapshotObserver.kt:133)
                                                                                                    	at androidx.compose.ui.node.OwnerSnapshotObserver.observeMeasureSnapshotReads$ui_release(OwnerSnapshotObserver.kt:113)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate.performMeasure-BRTryo0(LayoutNodeLayoutDelegate.kt:1782)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate.access$performMeasure-BRTryo0(LayoutNodeLayoutDelegate.kt:40)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate.remeasure-BRTryo0(LayoutNodeLayoutDelegate.kt:696)
                                                                                                    	at androidx.compose.ui.node.LayoutNode.remeasure-_Sx5XlM$ui_release(LayoutNode.kt:1222)
                                                                                                    	at androidx.compose.ui.node.MeasureAndLayoutDelegate.doRemeasure-sdFAvZA(MeasureAndLayoutDelegate.kt:367)
                                                                                                    	at androidx.compose.ui.node.MeasureAndLayoutDelegate.measureAndLayout-0kLqBqw(MeasureAndLayoutDelegate.kt:463)
                                                                                                    	at androidx.compose.ui.platform.AndroidComposeView.measureAndLayout-0kLqBqw(AndroidComposeView.android.kt:1280)
                                                                                                    	at androidx.compose.ui.node.LayoutNode.forceRemeasure(LayoutNode.kt:1296)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridState.onScroll$foundation_release(LazyGridState.kt:421)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridState$scrollableState$1.invoke(LazyGridState.kt:211)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridState$scrollableState$1.invoke(LazyGridState.kt:211)
                                                                                                    	at androidx.compose.foundation.gestures.DefaultScrollableState$scrollScope$1.scrollBy(ScrollableState.kt:184)
2025-08-13 16:44:38.972 18355-18355 AndroidRuntime          pid-18355                            E  FATAL EXCEPTION: main
                                                                                                    Process: com.akslabs.cloudgallery, PID: 18355
                                                                                                    java.lang.IllegalArgumentException: Key "1000009736" was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item.
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState.subcompose(SubcomposeLayout.kt:453)
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState$Scope.subcompose(SubcomposeLayout.kt:895)
                                                                                                    	at androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScopeImpl.measure-0kLqBqw(LazyLayoutMeasureScope.kt:125)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider.getAndMeasure-m8Kt_7k(LazyGridMeasuredItemProvider.kt:62)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider.getAndMeasure(LazyGridMeasuredLineProvider.kt:72)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridMeasureKt.measureLazyGrid-OZKpZRA(LazyGridMeasure.kt:202)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.invoke-0kLqBqw(LazyGrid.kt:341)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.invoke(LazyGrid.kt:172)
                                                                                                    	at androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$2$1.invoke-0kLqBqw(LazyLayout.kt:119)
                                                                                                    	at androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$2$1.invoke(LazyLayout.kt:112)
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1.measure-3p2s80s(SubcomposeLayout.kt:725)
                                                                                                    	at androidx.compose.ui.node.InnerNodeCoordinator.measure-BRTryo0(InnerNodeCoordinator.kt:135)
                                                                                                    	at androidx.compose.ui.graphics.SimpleGraphicsLayerModifier.measure-3p2s80s(GraphicsLayerModifier.kt:646)
                                                                                                    	at androidx.compose.ui.node.LayoutModifierNodeCoordinator.measure-BRTryo0(LayoutModifierNodeCoordinator.kt:188)
                                                                                                    	at androidx.compose.foundation.layout.FillNode.measure-3p2s80s(Size.kt:699)
                                                                                                    	at androidx.compose.ui.node.LayoutModifierNodeCoordinator.measure-BRTryo0(LayoutModifierNodeCoordinator.kt:188)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate$performMeasureBlock$1.invoke(LayoutNodeLayoutDelegate.kt:316)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate$performMeasureBlock$1.invoke(LayoutNodeLayoutDelegate.kt:315)
                                                                                                    	at androidx.compose.runtime.snapshots.Snapshot$Companion.observe(Snapshot.kt:2441)
                                                                                                    	at androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap.observe(SnapshotStateObserver.kt:502)
                                                                                                    	at androidx.compose.runtime.snapshots.SnapshotStateObserver.observeReads(SnapshotStateObserver.kt:258)
                                                                                                    	at androidx.compose.ui.node.OwnerSnapshotObserver.observeReads$ui_release(OwnerSnapshotObserver.kt:133)
                                                                                                    	at androidx.compose.ui.node.OwnerSnapshotObserver.observeMeasureSnapshotReads$ui_release(OwnerSnapshotObserver.kt:113)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate.performMeasure-BRTryo0(LayoutNodeLayoutDelegate.kt:1782)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate.access$performMeasure-BRTryo0(LayoutNodeLayoutDelegate.kt:40)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate.remeasure-BRTryo0(LayoutNodeLayoutDelegate.kt:696)
                                                                                                    	at androidx.compose.ui.node.LayoutNode.remeasure-_Sx5XlM$ui_release(LayoutNode.kt:1222)
                                                                                                    	at androidx.compose.ui.node.LayoutNode.remeasure-_Sx5XlM$ui_release$default(LayoutNode.kt:1213)
                                                                                                    	at androidx.compose.ui.node.MeasureAndLayoutDelegate.doRemeasure-sdFAvZA(MeasureAndLayoutDelegate.kt:369)
                                                                                                    	at androidx.compose.ui.node.MeasureAndLayoutDelegate.remeasureAndRelayoutIfNeeded(MeasureAndLayoutDelegate.kt:566)
                                                                                                    	at androidx.compose.ui.node.MeasureAndLayoutDelegate.remeasureAndRelayoutIfNeeded$default(MeasureAndLayoutDelegate.kt:534)
                                                                                                    	at androidx.compose.ui.node.MeasureAndLayoutDelegate.measureAndLayout(MeasureAndLayoutDelegate.kt:390)
                                                                                                    	at androidx.compose.ui.platform.AndroidComposeView.measureAndLayout(AndroidComposeView.android.kt:1268)
                                                                                                    	at androidx.compose.ui.node.Owner.measureAndLayout$default(Owner.kt:248)
                                                                                                    	at androidx.compose.ui.platform.AndroidComposeView.dispatchDraw(AndroidComposeView.android.kt:1556)
--------- beginning of system
2025-08-13 16:58:12.363 18360-18360 AndroidRuntime          com.akslabs.cloudgallery             E  FATAL EXCEPTION: main
                                                                                                    Process: com.akslabs.cloudgallery, PID: 18360
                                                                                                    java.lang.IllegalArgumentException: Key "1000009736" was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item.
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState.subcompose(SubcomposeLayout.kt:453)
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState$Scope.subcompose(SubcomposeLayout.kt:895)
                                                                                                    	at androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScopeImpl.measure-0kLqBqw(LazyLayoutMeasureScope.kt:125)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider.getAndMeasure-m8Kt_7k(LazyGridMeasuredItemProvider.kt:62)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider.getAndMeasure(LazyGridMeasuredLineProvider.kt:72)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridMeasureKt.measureLazyGrid-OZKpZRA(LazyGridMeasure.kt:202)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.invoke-0kLqBqw(LazyGrid.kt:341)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.invoke(LazyGrid.kt:172)
                                                                                                    	at androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$2$1.invoke-0kLqBqw(LazyLayout.kt:119)
                                                                                                    	at androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$2$1.invoke(LazyLayout.kt:112)
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1.measure-3p2s80s(SubcomposeLayout.kt:725)
                                                                                                    	at androidx.compose.ui.node.InnerNodeCoordinator.measure-BRTryo0(InnerNodeCoordinator.kt:135)
                                                                                                    	at androidx.compose.ui.graphics.SimpleGraphicsLayerModifier.measure-3p2s80s(GraphicsLayerModifier.kt:646)
                                                                                                    	at androidx.compose.ui.node.LayoutModifierNodeCoordinator.measure-BRTryo0(LayoutModifierNodeCoordinator.kt:188)
                                                                                                    	at androidx.compose.foundation.layout.FillNode.measure-3p2s80s(Size.kt:699)
                                                                                                    	at androidx.compose.ui.node.LayoutModifierNodeCoordinator.measure-BRTryo0(LayoutModifierNodeCoordinator.kt:188)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate$performMeasureBlock$1.invoke(LayoutNodeLayoutDelegate.kt:316)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate$performMeasureBlock$1.invoke(LayoutNodeLayoutDelegate.kt:315)
                                                                                                    	at androidx.compose.runtime.snapshots.Snapshot$Companion.observe(Snapshot.kt:2441)
                                                                                                    	at androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap.observe(SnapshotStateObserver.kt:502)
                                                                                                    	at androidx.compose.runtime.snapshots.SnapshotStateObserver.observeReads(SnapshotStateObserver.kt:258)
                                                                                                    	at androidx.compose.ui.node.OwnerSnapshotObserver.observeReads$ui_release(OwnerSnapshotObserver.kt:133)
                                                                                                    	at androidx.compose.ui.node.OwnerSnapshotObserver.observeMeasureSnapshotReads$ui_release(OwnerSnapshotObserver.kt:113)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate.performMeasure-BRTryo0(LayoutNodeLayoutDelegate.kt:1782)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate.access$performMeasure-BRTryo0(LayoutNodeLayoutDelegate.kt:40)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate.remeasure-BRTryo0(LayoutNodeLayoutDelegate.kt:696)
                                                                                                    	at androidx.compose.ui.node.LayoutNode.remeasure-_Sx5XlM$ui_release(LayoutNode.kt:1222)
                                                                                                    	at androidx.compose.ui.node.LayoutNode.remeasure-_Sx5XlM$ui_release$default(LayoutNode.kt:1213)
                                                                                                    	at androidx.compose.ui.node.MeasureAndLayoutDelegate.doRemeasure-sdFAvZA(MeasureAndLayoutDelegate.kt:369)
                                                                                                    	at androidx.compose.ui.node.MeasureAndLayoutDelegate.remeasureAndRelayoutIfNeeded(MeasureAndLayoutDelegate.kt:566)
                                                                                                    	at androidx.compose.ui.node.MeasureAndLayoutDelegate.remeasureAndRelayoutIfNeeded$default(MeasureAndLayoutDelegate.kt:534)
                                                                                                    	at androidx.compose.ui.node.MeasureAndLayoutDelegate.measureAndLayout(MeasureAndLayoutDelegate.kt:390)
                                                                                                    	at androidx.compose.ui.platform.AndroidComposeView.measureAndLayout(AndroidComposeView.android.kt:1268)
                                                                                                    	at androidx.compose.ui.node.Owner.measureAndLayout$default(Owner.kt:248)
                                                                                                    	at androidx.compose.ui.platform.AndroidComposeView.dispatchDraw(AndroidComposeView.android.kt:1556)
2025-08-13 16:58:12.364 18360-18360 AndroidRuntime          com.akslabs.cloudgallery             E  	at android.view.View.draw(View.java:24880)
                                                                                                    	at android.view.View.updateDisplayListIfDirty(View.java:23727)
                                                                                                    	at android.view.ViewGroup.recreateChildDisplayList(ViewGroup.java:4540)
                                                                                                    	at android.view.ViewGroup.dispatchGetDisplayList(ViewGroup.java:4513)
                                                                                                    	at android.view.View.updateDisplayListIfDirty(View.java:23681)
                                                                                                    	at android.view.ViewGroup.recreateChildDisplayList(ViewGroup.java:4540)
                                                                                                    	at android.view.ViewGroup.dispatchGetDisplayList(ViewGroup.java:4513)
                                                                                                    	at android.view.View.updateDisplayListIfDirty(View.java:23681)
                                                                                                    	at android.view.ViewGroup.recreateChildDisplayList(ViewGroup.java:4540)
                                                                                                    	at android.view.ViewGroup.dispatchGetDisplayList(ViewGroup.java:4513)
                                                                                                    	at android.view.View.updateDisplayListIfDirty(View.java:23681)
                                                                                                    	at android.view.ViewGroup.recreateChildDisplayList(ViewGroup.java:4540)
                                                                                                    	at android.view.ViewGroup.dispatchGetDisplayList(ViewGroup.java:4513)
                                                                                                    	at android.view.View.updateDisplayListIfDirty(View.java:23681)
                                                                                                    	at android.view.ThreadedRenderer.updateViewTreeDisplayList(ThreadedRenderer.java:706)
                                                                                                    	at android.view.ThreadedRenderer.updateRootDisplayList(ThreadedRenderer.java:712)
                                                                                                    	at android.view.ThreadedRenderer.draw(ThreadedRenderer.java:810)
                                                                                                    	at android.view.ViewRootImpl.draw(ViewRootImpl.java:5748)
                                                                                                    	at android.view.ViewRootImpl.performDraw(ViewRootImpl.java:5400)
                                                                                                    	at android.view.ViewRootImpl.performTraversals(ViewRootImpl.java:4399)
                                                                                                    	at android.view.ViewRootImpl.doTraversal(ViewRootImpl.java:2997)
                                                                                                    	at android.view.ViewRootImpl$TraversalRunnable.run(ViewRootImpl.java:10455)
                                                                                                    	at android.view.Choreographer$CallbackRecord.run(Choreographer.java:1415)
                                                                                                    	at android.view.Choreographer$CallbackRecord.run(Choreographer.java:1424)
                                                                                                    	at android.view.Choreographer.doCallbacks(Choreographer.java:1024)
                                                                                                    	at android.view.Choreographer.doFrame(Choreographer.java:953)
                                                                                                    	at android.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:1398)
                                                                                                    	at android.os.Handler.handleCallback(Handler.java:991)
                                                                                                    	at android.os.Handler.dispatchMessage(Handler.java:102)
                                                                                                    	at android.os.Looper.loopOnce(Looper.java:232)
                                                                                                    	at android.os.Looper.loop(Looper.java:317)
                                                                                                    	at android.app.ActivityThread.main(ActivityThread.java:8782)
                                                                                                    	at java.lang.reflect.Method.invoke(Native Method)
                                                                                                    	at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:595)
                                                                                                    	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:871)
2025-08-13 17:00:07.297 23516-23516 AndroidRuntime          com.akslabs.cloudgallery             E  FATAL EXCEPTION: main
                                                                                                    Process: com.akslabs.cloudgallery, PID: 23516
                                                                                                    java.lang.IllegalArgumentException: Key "1000008747" was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item.
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState.subcompose(SubcomposeLayout.kt:453)
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState$Scope.subcompose(SubcomposeLayout.kt:895)
                                                                                                    	at androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScopeImpl.measure-0kLqBqw(LazyLayoutMeasureScope.kt:125)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider.getAndMeasure-m8Kt_7k(LazyGridMeasuredItemProvider.kt:62)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider.getAndMeasure(LazyGridMeasuredLineProvider.kt:72)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridMeasureKt.measureLazyGrid-OZKpZRA(LazyGridMeasure.kt:155)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.invoke-0kLqBqw(LazyGrid.kt:341)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.invoke(LazyGrid.kt:172)
                                                                                                    	at androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$2$1.invoke-0kLqBqw(LazyLayout.kt:119)
                                                                                                    	at androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$2$1.invoke(LazyLayout.kt:112)
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1.measure-3p2s80s(SubcomposeLayout.kt:725)
                                                                                                    	at androidx.compose.ui.node.InnerNodeCoordinator.measure-BRTryo0(InnerNodeCoordinator.kt:135)
                                                                                                    	at androidx.compose.ui.graphics.SimpleGraphicsLayerModifier.measure-3p2s80s(GraphicsLayerModifier.kt:646)
                                                                                                    	at androidx.compose.ui.node.LayoutModifierNodeCoordinator.measure-BRTryo0(LayoutModifierNodeCoordinator.kt:188)
                                                                                                    	at androidx.compose.foundation.layout.FillNode.measure-3p2s80s(Size.kt:699)
                                                                                                    	at androidx.compose.ui.node.LayoutModifierNodeCoordinator.measure-BRTryo0(LayoutModifierNodeCoordinator.kt:188)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate$performMeasureBlock$1.invoke(LayoutNodeLayoutDelegate.kt:316)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate$performMeasureBlock$1.invoke(LayoutNodeLayoutDelegate.kt:315)
                                                                                                    	at androidx.compose.runtime.snapshots.Snapshot$Companion.observe(Snapshot.kt:2441)
                                                                                                    	at androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap.observe(SnapshotStateObserver.kt:502)
                                                                                                    	at androidx.compose.runtime.snapshots.SnapshotStateObserver.observeReads(SnapshotStateObserver.kt:258)
                                                                                                    	at androidx.compose.ui.node.OwnerSnapshotObserver.observeReads$ui_release(OwnerSnapshotObserver.kt:133)
                                                                                                    	at androidx.compose.ui.node.OwnerSnapshotObserver.observeMeasureSnapshotReads$ui_release(OwnerSnapshotObserver.kt:113)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate.performMeasure-BRTryo0(LayoutNodeLayoutDelegate.kt:1782)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate.access$performMeasure-BRTryo0(LayoutNodeLayoutDelegate.kt:40)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate.remeasure-BRTryo0(LayoutNodeLayoutDelegate.kt:696)
                                                                                                    	at androidx.compose.ui.node.LayoutNode.remeasure-_Sx5XlM$ui_release(LayoutNode.kt:1222)
                                                                                                    	at androidx.compose.ui.node.MeasureAndLayoutDelegate.doRemeasure-sdFAvZA(MeasureAndLayoutDelegate.kt:367)
                                                                                                    	at androidx.compose.ui.node.MeasureAndLayoutDelegate.measureAndLayout-0kLqBqw(MeasureAndLayoutDelegate.kt:463)
                                                                                                    	at androidx.compose.ui.platform.AndroidComposeView.measureAndLayout-0kLqBqw(AndroidComposeView.android.kt:1280)
                                                                                                    	at androidx.compose.ui.node.LayoutNode.forceRemeasure(LayoutNode.kt:1296)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridState.onScroll$foundation_release(LazyGridState.kt:421)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridState$scrollableState$1.invoke(LazyGridState.kt:211)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridState$scrollableState$1.invoke(LazyGridState.kt:211)
                                                                                                    	at androidx.compose.foundation.gestures.DefaultScrollableState$scrollScope$1.scrollBy(ScrollableState.kt:184)
2025-08-13 17:00:07.300 23516-23516 AndroidRuntime          com.akslabs.cloudgallery             E  	at androidx.compose.foundation.gestures.ScrollingLogic.performScroll-3eAAhYA(Scrollable.kt:717)
                                                                                                    	at androidx.compose.foundation.gestures.ScrollingLogic.access$performScroll-3eAAhYA(Scrollable.kt:642)
                                                                                                    	at androidx.compose.foundation.gestures.ScrollingLogic$performScrollForOverscroll$1.invoke-MK-Hz9U(Scrollable.kt:702)
                                                                                                    	at androidx.compose.foundation.gestures.ScrollingLogic$performScrollForOverscroll$1.invoke(Scrollable.kt:700)
                                                                                                    	at androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.applyToScroll-Rhakbz0(AndroidOverscroll.android.kt:494)
                                                                                                    	at androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1.scrollByWithOverscroll-OzD1aCk(Scrollable.kt:691)
                                                                                                    	at androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2$reverseScope$1.scrollBy(Scrollable.kt:773)
                                                                                                    	at androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2$1.invoke(Scrollable.kt:895)
                                                                                                    	at androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2$1.invoke(Scrollable.kt:893)
                                                                                                    	at androidx.compose.animation.core.SuspendAnimationKt.doAnimationFrame(SuspendAnimation.kt:361)
                                                                                                    	at androidx.compose.animation.core.SuspendAnimationKt.doAnimationFrameWithScale(SuspendAnimation.kt:339)
                                                                                                    	at androidx.compose.animation.core.SuspendAnimationKt.access$doAnimationFrameWithScale(SuspendAnimation.kt:1)
                                                                                                    	at androidx.compose.animation.core.SuspendAnimationKt$animate$9.invoke(SuspendAnimation.kt:279)
                                                                                                    	at androidx.compose.animation.core.SuspendAnimationKt$animate$9.invoke(SuspendAnimation.kt:278)
                                                                                                    	at androidx.compose.animation.core.SuspendAnimationKt$callWithFrameNanos$2.invoke(SuspendAnimation.kt:304)
                                                                                                    	at androidx.compose.animation.core.SuspendAnimationKt$callWithFrameNanos$2.invoke(SuspendAnimation.kt:303)
                                                                                                    	at androidx.compose.runtime.BroadcastFrameClock$FrameAwaiter.resume(BroadcastFrameClock.kt:42)
                                                                                                    	at androidx.compose.runtime.BroadcastFrameClock.sendFrame(BroadcastFrameClock.kt:76)
                                                                                                    	at androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2$1.invoke(Recomposer.kt:592)
                                                                                                    	at androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2$1.invoke(Recomposer.kt:585)
                                                                                                    	at androidx.compose.ui.platform.AndroidUiFrameClock$withFrameNanos$2$callback$1.doFrame(AndroidUiFrameClock.android.kt:41)
                                                                                                    	at androidx.compose.ui.platform.AndroidUiDispatcher.performFrameDispatch(AndroidUiDispatcher.android.kt:109)
                                                                                                    	at androidx.compose.ui.platform.AndroidUiDispatcher.access$performFrameDispatch(AndroidUiDispatcher.android.kt:41)
                                                                                                    	at androidx.compose.ui.platform.AndroidUiDispatcher$dispatchCallback$1.doFrame(AndroidUiDispatcher.android.kt:69)
                                                                                                    	at android.view.Choreographer$CallbackRecord.run(Choreographer.java:1413)
                                                                                                    	at android.view.Choreographer$CallbackRecord.run(Choreographer.java:1424)
                                                                                                    	at android.view.Choreographer.doCallbacks(Choreographer.java:1024)
                                                                                                    	at android.view.Choreographer.doFrame(Choreographer.java:949)
                                                                                                    	at android.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:1398)
                                                                                                    	at android.os.Handler.handleCallback(Handler.java:991)
                                                                                                    	at android.os.Handler.dispatchMessage(Handler.java:102)
                                                                                                    	at android.os.Looper.loopOnce(Looper.java:232)
                                                                                                    	at android.os.Looper.loop(Looper.java:317)
                                                                                                    	at android.app.ActivityThread.main(ActivityThread.java:8782)
                                                                                                    	at java.lang.reflect.Method.invoke(Native Method)
                                                                                                    	at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:595)
                                                                                                    	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:871)
                                                                                                    	Suppressed: kotlinx.coroutines.internal.DiagnosticCoroutineContextException: [androidx.compose.ui.platform.MotionDurationScaleImpl@24fca64, androidx.compose.runtime.BroadcastFrameClock@8fbd4cd, StandaloneCoroutine{Cancelling}@19e4182, AndroidUiDispatcher@4e3b093]
--------- beginning of main
2025-08-13 17:19:07.354 26450-26450 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:19:07.458 26450-26450 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:19:22.822  1835-2239  ConnectivityService     system_server                        E  RemoteException caught trying to send a callback msg for NetworkRequest [ TRACK_DEFAULT id=1530, [ Capabilities: INTERNET&NOT_RESTRICTED&TRUSTED&NOT_VCN_MANAGED&NOT_BANDWIDTH_CONSTRAINED Uid: 10813 RequestorUid: 10813 RequestorPkg: com.akslabs.cloudgallery UnderlyingNetworks: Null] ]
2025-08-13 17:19:22.823  1835-2239  ConnectivityService     system_server                        E  RemoteException caught trying to send a callback msg for NetworkRequest [ LISTEN id=1532, [ Capabilities: INTERNET&NOT_RESTRICTED&TRUSTED&NOT_VPN&FOREGROUND&NOT_VCN_MANAGED&NOT_BANDWIDTH_CONSTRAINED Forbidden: LOCAL_NETWORK Uid: 10813 RequestorUid: 10813 RequestorPkg: com.akslabs.cloudgallery UnderlyingNetworks: Null] ]
2025-08-13 17:19:31.165 28642-28642 bs.cloudgallery         com.akslabs.cloudgallery             I  Late-enabling -Xcheck:jni
2025-08-13 17:19:31.195 28642-28642 bs.cloudgallery         com.akslabs.cloudgallery             I  Using CollectorTypeCC GC.
2025-08-13 17:19:31.208 28642-28642 nativeloader            com.akslabs.cloudgallery             D  Load libframework-connectivity-tiramisu-jni.so using APEX ns com_android_tethering for caller /apex/com.android.tethering/javalib/framework-connectivity-t.jar: ok
2025-08-13 17:19:31.283 28642-28642 re-initialized>         com.akslabs.cloudgallery             W  type=1400 audit(0.0:2388): avc:  granted  { execute } for  path="/data/data/com.akslabs.cloudgallery/code_cache/startup_agents/b13c65d9-agent.so" dev="mmcblk0p61" ino=298676 scontext=u:r:untrusted_app:s0:c45,c259,c512,c768 tcontext=u:object_r:app_data_file:s0:c45,c259,c512,c768 tclass=file app=com.akslabs.cloudgallery
2025-08-13 17:19:31.315 28642-28642 nativeloader            com.akslabs.cloudgallery             D  Load /data/user/0/com.akslabs.cloudgallery/code_cache/startup_agents/b13c65d9-agent.so using system ns (caller=<unknown>): ok
2025-08-13 17:19:31.348 28642-28642 bs.cloudgallery         com.akslabs.cloudgallery             W  DexFile /data/data/com.akslabs.cloudgallery/code_cache/.studio/instruments-462f9421.jar is in boot class path but is not in a known location
2025-08-13 17:19:31.438 28642-28642 bs.cloudgallery         com.akslabs.cloudgallery             W  Redefining intrinsic method java.lang.Thread java.lang.Thread.currentThread(). This may cause the unexpected use of the original definition of java.lang.Thread java.lang.Thread.currentThread()in methods that have already been compiled.
2025-08-13 17:19:31.438 28642-28642 bs.cloudgallery         com.akslabs.cloudgallery             W  Redefining intrinsic method boolean java.lang.Thread.interrupted(). This may cause the unexpected use of the original definition of boolean java.lang.Thread.interrupted()in methods that have already been compiled.
2025-08-13 17:19:31.475 28642-28642 ApplicationLoaders      com.akslabs.cloudgallery             D  Returning zygote-cached class loader: /system_ext/framework/androidx.window.extensions.jar
2025-08-13 17:19:31.476 28642-28642 ApplicationLoaders      com.akslabs.cloudgallery             D  Returning zygote-cached class loader: /system_ext/framework/androidx.window.sidecar.jar
2025-08-13 17:19:31.482 28642-28642 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes12.dm': No such file or directory
2025-08-13 17:19:31.484 28642-28642 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes14.dm': No such file or directory
2025-08-13 17:19:31.487 28642-28642 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes6.dm': No such file or directory
2025-08-13 17:19:31.490 28642-28642 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes4.dm': No such file or directory
2025-08-13 17:19:31.491 28642-28642 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes8.dm': No such file or directory
2025-08-13 17:19:31.492 28642-28642 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/app/~~H39HcsrPQN-FSXDcIRydeg==/com.akslabs.cloudgallery-RcHZ3qQgx4Iubj1z1Y82Gg==/base.dm': No such file or directory
2025-08-13 17:19:31.492 28642-28642 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/app/~~H39HcsrPQN-FSXDcIRydeg==/com.akslabs.cloudgallery-RcHZ3qQgx4Iubj1z1Y82Gg==/base.dm': No such file or directory
2025-08-13 17:19:32.139 28642-28642 nativeloader            com.akslabs.cloudgallery             D  Configuring clns-7 for other apk /data/app/~~H39HcsrPQN-FSXDcIRydeg==/com.akslabs.cloudgallery-RcHZ3qQgx4Iubj1z1Y82Gg==/base.apk. target_sdk_version=34, uses_libraries=, library_path=/data/app/~~H39HcsrPQN-FSXDcIRydeg==/com.akslabs.cloudgallery-RcHZ3qQgx4Iubj1z1Y82Gg==/lib/arm64:/data/app/~~H39HcsrPQN-FSXDcIRydeg==/com.akslabs.cloudgallery-RcHZ3qQgx4Iubj1z1Y82Gg==/base.apk!/lib/arm64-v8a, permitted_path=/data:/mnt/expand:/data/user/0/com.akslabs.cloudgallery
2025-08-13 17:19:32.161 28642-28642 GraphicsEnvironment     com.akslabs.cloudgallery             V  Currently set values for:
2025-08-13 17:19:32.161 28642-28642 GraphicsEnvironment     com.akslabs.cloudgallery             V    angle_gl_driver_selection_pkgs=[com.android.angle, com.linecorp.b612.android, com.campmobile.snow, com.google.android.apps.tachyon]
2025-08-13 17:19:32.161 28642-28642 GraphicsEnvironment     com.akslabs.cloudgallery             V    angle_gl_driver_selection_values=[angle, native, native, native]
2025-08-13 17:19:32.161 28642-28642 GraphicsEnvironment     com.akslabs.cloudgallery             V  com.akslabs.cloudgallery is not listed in per-application setting
2025-08-13 17:19:32.161 28642-28642 GraphicsEnvironment     com.akslabs.cloudgallery             V  Neither updatable production driver nor prerelease driver is supported.
2025-08-13 17:19:32.182 28642-28642 WM-WrkMgrInitializer    com.akslabs.cloudgallery             D  Initializing WorkManager with default configuration.
2025-08-13 17:19:32.255 28642-28642 WM-PackageManagerHelper com.akslabs.cloudgallery             D  Skipping component enablement for androidx.work.impl.background.systemjob.SystemJobService
2025-08-13 17:19:32.255 28642-28642 WM-Schedulers           com.akslabs.cloudgallery             D  Created SystemJobScheduler and enabled SystemJobService
2025-08-13 17:19:32.575 28642-28642 EngineFactory           com.akslabs.cloudgallery             I  Provider GmsCore_OpenSSL not available
2025-08-13 17:19:32.594 28642-28642 ImageLoaderModule       com.akslabs.cloudgallery             I  === INITIALIZING IMAGE LOADERS ===
2025-08-13 17:19:32.740 28642-28642 ImageLoaderModule       com.akslabs.cloudgallery             D  Created OkHttpClient with 30s connect, 60s read/write timeouts
2025-08-13 17:19:32.740 28642-28642 ImageLoaderModule       com.akslabs.cloudgallery             D  Creating remoteImageLoader...
2025-08-13 17:19:32.744 28642-28642 ImageLoaderModule       com.akslabs.cloudgallery             I  remoteImageLoader created successfully
2025-08-13 17:19:32.744 28642-28642 ImageLoaderModule       com.akslabs.cloudgallery             D  Creating thumbnailImageLoader...
2025-08-13 17:19:32.744 28642-28642 ImageLoaderModule       com.akslabs.cloudgallery             I  thumbnailImageLoader created successfully
2025-08-13 17:19:32.744 28642-28642 ImageLoaderModule       com.akslabs.cloudgallery             I  === IMAGE LOADERS INITIALIZATION COMPLETE ===
2025-08-13 17:19:32.744 28642-28642 ImageLoaderModule       com.akslabs.cloudgallery             I  Available loaders:
2025-08-13 17:19:32.744 28642-28642 ImageLoaderModule       com.akslabs.cloudgallery             I  - defaultImageLoader: ✓
2025-08-13 17:19:32.744 28642-28642 ImageLoaderModule       com.akslabs.cloudgallery             I  - remoteImageLoader: ✓
2025-08-13 17:19:32.744 28642-28642 ImageLoaderModule       com.akslabs.cloudgallery             I  - thumbnailImageLoader: ✓
2025-08-13 17:19:32.834 28642-28642 Choreographer           com.akslabs.cloudgallery             I  Skipped 31 frames!  The application may be doing too much work on its main thread.
2025-08-13 17:19:32.946 28642-31067 DatabaseDebugHelper     com.akslabs.cloudgallery             I  === DATABASE DEBUG REPORT ===
2025-08-13 17:19:32.962 28642-28642 MainActivity            com.akslabs.cloudgallery             W  Invalid sync timestamp format, resetting to 0
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
2025-08-13 17:19:32.967 28642-31067 DatabaseDebugHelper     com.akslabs.cloudgallery             I  Database version: 4
2025-08-13 17:19:33.001 28642-28642 DesktopModeFlagsUtil    com.akslabs.cloudgallery             D  Toggle override initialized to: OVERRIDE_UNSET
2025-08-13 17:19:33.014 28642-31067 DatabaseDebugHelper     com.akslabs.cloudgallery             I  Record counts:
2025-08-13 17:19:33.014 28642-31067 DatabaseDebugHelper     com.akslabs.cloudgallery             I    Total photos: 951
2025-08-13 17:19:33.014 28642-31067 DatabaseDebugHelper     com.akslabs.cloudgallery             I    Photos with remoteId: 3
2025-08-13 17:19:33.014 28642-31067 DatabaseDebugHelper     com.akslabs.cloudgallery             I    Total remote photos: 3
2025-08-13 17:19:33.014 28642-31067 DatabaseDebugHelper     com.akslabs.cloudgallery             I  Sample uploaded photos:
2025-08-13 17:19:33.014 28642-31067 DatabaseDebugHelper     com.akslabs.cloudgallery             I    Photo: localId=1000009071, remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ, type=png
2025-08-13 17:19:33.014 28642-31067 DatabaseDebugHelper     com.akslabs.cloudgallery             I    Photo: localId=1000006476, remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ, type=png
2025-08-13 17:19:33.014 28642-31067 DatabaseDebugHelper     com.akslabs.cloudgallery             I    Photo: localId=1000006091, remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE, type=png
2025-08-13 17:19:33.014 28642-31067 DatabaseDebugHelper     com.akslabs.cloudgallery             I  Sample remote photos:
2025-08-13 17:19:33.015 28642-31067 DatabaseDebugHelper     com.akslabs.cloudgallery             I    RemotePhoto: remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE, type=png, fileName=42717895550690360893227045473287536868.png
2025-08-13 17:19:33.015 28642-31067 DatabaseDebugHelper     com.akslabs.cloudgallery             I    RemotePhoto: remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ, type=png, fileName=694000534657088556765825092497223751.png
2025-08-13 17:19:33.015 28642-31067 DatabaseDebugHelper     com.akslabs.cloudgallery             I    RemotePhoto: remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ, type=png, fileName=42554030560734015792823288097017760953.png
2025-08-13 17:19:33.015 28642-31067 DatabaseDebugHelper     com.akslabs.cloudgallery             I  === END DATABASE DEBUG REPORT ===
2025-08-13 17:19:33.407 28642-31049 bs.cloudgallery         com.akslabs.cloudgallery             I  Compiler allocated 4431KB to compile void android.view.ViewRootImpl.performTraversals()
2025-08-13 17:19:33.555 28642-28642 bs.cloudgallery         com.akslabs.cloudgallery             W  Method boolean androidx.compose.runtime.snapshots.SnapshotStateList.conditionalUpdate(boolean, kotlin.jvm.functions.Function1) failed lock verification and will run slower.
                                                                                                    Common causes for lock verification issues are non-optimized dex code
                                                                                                    and incorrect proguard optimizations.
2025-08-13 17:19:33.555 28642-28642 bs.cloudgallery         com.akslabs.cloudgallery             W  Method boolean androidx.compose.runtime.snapshots.SnapshotStateList.conditionalUpdate$default(androidx.compose.runtime.snapshots.SnapshotStateList, boolean, kotlin.jvm.functions.Function1, int, java.lang.Object) failed lock verification and will run slower.
2025-08-13 17:19:33.555 28642-28642 bs.cloudgallery         com.akslabs.cloudgallery             W  Method java.lang.Object androidx.compose.runtime.snapshots.SnapshotStateList.mutate(kotlin.jvm.functions.Function1) failed lock verification and will run slower.
2025-08-13 17:19:33.556 28642-28642 bs.cloudgallery         com.akslabs.cloudgallery             W  Method void androidx.compose.runtime.snapshots.SnapshotStateList.update(boolean, kotlin.jvm.functions.Function1) failed lock verification and will run slower.
2025-08-13 17:19:33.556 28642-28642 bs.cloudgallery         com.akslabs.cloudgallery             W  Method void androidx.compose.runtime.snapshots.SnapshotStateList.update$default(androidx.compose.runtime.snapshots.SnapshotStateList, boolean, kotlin.jvm.functions.Function1, int, java.lang.Object) failed lock verification and will run slower.
2025-08-13 17:19:34.069 28642-28642 LocalViewModel          com.akslabs.cloudgallery             E  🚀 === LOCAL VIEW MODEL INITIALIZED ===
2025-08-13 17:19:34.070 28642-28642 LocalViewModel          com.akslabs.cloudgallery             I  === LOCAL PHOTOS DATABASE DEBUG ===
2025-08-13 17:19:34.090 28642-28642 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-13 17:19:34.090 28642-28642 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 64, JumpThreshold: 160
2025-08-13 17:19:34.105 28642-28642 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-13 17:19:34.107 28642-28642 LocalViewModel          com.akslabs.cloudgallery             E  📊 Local photos count updated: 0
2025-08-13 17:19:34.123 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:19:34.206 28642-31064 AdrenoGLES-0            com.akslabs.cloudgallery             I  QUALCOMM build                   : 95db91f, Ifbc588260a
                                                                                                    Build Date                       : 09/24/20
                                                                                                    OpenGL ES Shader Compiler Version: EV031.32.02.01
                                                                                                    Local Branch                     : mybrancheafe5b6d-fb5b-f1b0-b904-5cb90179c3e0
                                                                                                    Remote Branch                    : quic/gfx-adreno.lnx.1.0.r114-rel
                                                                                                    Remote Branch                    : NONE
                                                                                                    Reconstruct Branch               : NOTHING
2025-08-13 17:19:34.206 28642-31064 AdrenoGLES-0            com.akslabs.cloudgallery             I  Build Config                     : S P 10.0.7 AArch64
2025-08-13 17:19:34.206 28642-31064 AdrenoGLES-0            com.akslabs.cloudgallery             I  Driver Path                      : /vendor/lib64/egl/libGLESv2_adreno.so
2025-08-13 17:19:34.221 28642-31064 AdrenoGLES-0            com.akslabs.cloudgallery             I  PFP: 0x016ee190, ME: 0x00000000
2025-08-13 17:19:34.290 28642-31084 Gralloc4                com.akslabs.cloudgallery             I  mapper 4.x is not supported
2025-08-13 17:19:34.291 28642-31084 Gralloc3                com.akslabs.cloudgallery             W  mapper 3.x is not supported
2025-08-13 17:19:34.299 28642-31084 Gralloc2                com.akslabs.cloudgallery             I  Adding additional valid usage bits: 0x8202000
2025-08-13 17:19:34.338 28642-31067 CloudPhotoSyncWorker    com.akslabs.cloudgallery             I  === CLOUD PHOTO SYNC WORKER STARTED ===
2025-08-13 17:19:34.353 28642-31063 WM-Processor            com.akslabs.cloudgallery             I  Moving WorkSpec (566a812a-4c7b-4141-9c7c-0215bffc13bf) to the foreground
2025-08-13 17:19:34.359 28642-31056 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1216ms; Flags=1, FrameTimelineVsyncId=9084553, IntendedVsync=15580145285030, Vsync=15580145285030, InputEventId=0, HandleInputStart=15580146406347, AnimationStart=15580146408742, PerformTraversalsStart=15580146409888, DrawStart=15581308846450, FrameDeadline=15580166618362, FrameInterval=15580146398482, FrameStartTime=16666640, SyncQueued=15581344986398, SyncStart=15581345164471, IssueDrawCommandsStart=15581346109732, SwapBuffers=15581355392752, FrameCompleted=15581362360252, DequeueBufferDuration=17448, QueueBufferDuration=357552, GpuCompleted=15581362360252, SwapBuffersCompleted=15581356144211, DisplayPresentTime=35192962023424, CommandSubmissionCompleted=15581355392752, 
2025-08-13 17:19:34.373 28642-31067 CloudPhotoSyncService   com.akslabs.cloudgallery             I  === STARTING FULL CLOUD PHOTO SYNC ===
2025-08-13 17:19:34.381 28642-31067 CloudPhotoSyncService   com.akslabs.cloudgallery             D  Found configured group/channel ID: -1002651869724
2025-08-13 17:19:34.382 28642-31068 CloudPhotoSyncService   com.akslabs.cloudgallery             I  Syncing with channel ID: -1002651869724
2025-08-13 17:19:34.382 28642-31068 CloudPhotoSyncService   com.akslabs.cloudgallery             W  ⚠️  TELEGRAM BOT API LIMITATION:
2025-08-13 17:19:34.382 28642-31068 CloudPhotoSyncService   com.akslabs.cloudgallery             W  Bot API can only access messages from the last 24 hours
2025-08-13 17:19:34.382 28642-31068 CloudPhotoSyncService   com.akslabs.cloudgallery             W  Historical images older than 24 hours cannot be retrieved via Bot API
2025-08-13 17:19:34.382 28642-31068 CloudPhotoSyncService   com.akslabs.cloudgallery             W  This is a Telegram platform limitation, not an app bug
2025-08-13 17:19:34.382 28642-31068 CloudPhotoSyncService   com.akslabs.cloudgallery             D  Last sync: 0, Current: 1755085774382, Should sync: true
2025-08-13 17:19:34.388 28642-31069 CloudPhotoSyncService   com.akslabs.cloudgallery             I  Current database has 3 RemotePhoto records
2025-08-13 17:19:34.388 28642-31069 CloudPhotoSyncService   com.akslabs.cloudgallery             I  Performing incremental sync
2025-08-13 17:19:34.392 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:19:34.392 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 0
2025-08-13 17:19:34.392 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 0
2025-08-13 17:19:34.392 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-13 17:19:34.392 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:19:34.392 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-13 17:19:34.392 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:19:34.392 28642-31069 Historical...eDiscovery com.akslabs.cloudgallery             I  === STARTING HISTORICAL IMAGE DISCOVERY ===
2025-08-13 17:19:34.392 28642-31069 Historical...eDiscovery com.akslabs.cloudgallery             I  Channel ID: -1002651869724
2025-08-13 17:19:34.394 28642-31069 Historical...eDiscovery com.akslabs.cloudgallery             I  Config: ScanConfig(channelId=-1002651869724, batchSize=100, maxFiles=1000, includePhotos=true, includeDocuments=true, includeVideos=true)
2025-08-13 17:19:34.397 28642-28642 LocalViewModel          com.akslabs.cloudgallery             E  ❌ Error collecting from localPhotosFlow
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@965fafa
2025-08-13 17:19:34.402 28642-31067 Historical...eDiscovery com.akslabs.cloudgallery             I  Found 3 existing RemotePhoto records
2025-08-13 17:19:34.402 28642-31067 Historical...eDiscovery com.akslabs.cloudgallery             D  Processing batch 1 (offset: null)
2025-08-13 17:19:34.409 28642-28642 LocalViewModel          com.akslabs.cloudgallery             E  ❌ Error collecting from localPhotosCount
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@965fafa
2025-08-13 17:19:34.424 28642-31067 BotApi                  com.akslabs.cloudgallery             D  === SCANNING CHANNEL FOR MEDIA ===
2025-08-13 17:19:34.424 28642-31067 BotApi                  com.akslabs.cloudgallery             D  Channel ID: -1002651869724, Limit: 100, Offset: null
2025-08-13 17:19:34.436 28642-28642 Choreographer           com.akslabs.cloudgallery             I  Skipped 75 frames!  The application may be doing too much work on its main thread.
2025-08-13 17:19:34.547 28642-28642 LocalViewModel          com.akslabs.cloudgallery             E  ❌ Error debugging local database state
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@965fafa
2025-08-13 17:19:34.556 28642-28642 WM-SystemFgDispatcher   com.akslabs.cloudgallery             I  Started foreground service Intent { act=ACTION_START_FOREGROUND cmp=com.akslabs.cloudgallery/androidx.work.impl.foreground.SystemForegroundService (has extras) }
2025-08-13 17:19:34.565 28642-31057 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1375ms; Flags=0, FrameTimelineVsyncId=9084597, IntendedVsync=15580197948637, Vsync=15581447944537, InputEventId=0, HandleInputStart=15581458505721, AnimationStart=15581458508221, PerformTraversalsStart=15581548542804, DrawStart=15581550301190, FrameDeadline=15581395283056, FrameInterval=15581458067752, FrameStartTime=16666612, SyncQueued=15581565806867, SyncStart=15581566122961, IssueDrawCommandsStart=15581566365617, SwapBuffers=15581571147856, FrameCompleted=15581573824419, DequeueBufferDuration=48854, QueueBufferDuration=531823, GpuCompleted=15581573824419, SwapBuffersCompleted=15581572616294, DisplayPresentTime=72904454214516736, CommandSubmissionCompleted=15581571147856, 
2025-08-13 17:19:34.661 28642-28642 LocalViewModel          com.akslabs.cloudgallery             E  🚀 === LOCAL VIEW MODEL INITIALIZED ===
2025-08-13 17:19:34.661 28642-28642 LocalViewModel          com.akslabs.cloudgallery             I  === LOCAL PHOTOS DATABASE DEBUG ===
2025-08-13 17:19:34.669 28642-28642 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-13 17:19:34.669 28642-28642 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 64, JumpThreshold: 160
2025-08-13 17:19:34.674 28642-28642 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-13 17:19:34.675 28642-28642 LocalViewModel          com.akslabs.cloudgallery             E  📊 Local photos count updated: 0
2025-08-13 17:19:34.680 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:19:34.775 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:19:34.775 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 0
2025-08-13 17:19:34.775 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 0
2025-08-13 17:19:34.775 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-13 17:19:34.775 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:19:34.775 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-13 17:19:34.775 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:19:34.829 28642-28642 LocalViewModel          com.akslabs.cloudgallery             E  📊 Local photos count updated: 951
2025-08-13 17:19:34.830 28642-28642 LocalViewModel          com.akslabs.cloudgallery             I  Total Photo records in database: 951
2025-08-13 17:19:34.830 28642-28642 LocalViewModel          com.akslabs.cloudgallery             I  ✅ Photo records found:
2025-08-13 17:19:34.831 28642-28642 LocalViewModel          com.akslabs.cloudgallery             D  Photo[0]: localId=1000009866, pathUri=content://media/external/images/media/1000009866, remoteId=null, photoType=png
2025-08-13 17:19:34.831 28642-28642 LocalViewModel          com.akslabs.cloudgallery             D  Photo[1]: localId=1000009865, pathUri=content://media/external/images/media/1000009865, remoteId=null, photoType=png
2025-08-13 17:19:34.831 28642-28642 LocalViewModel          com.akslabs.cloudgallery             D  Photo[2]: localId=1000009864, pathUri=content://media/external/images/media/1000009864, remoteId=null, photoType=png
2025-08-13 17:19:34.831 28642-28642 LocalViewModel          com.akslabs.cloudgallery             D  Photo[3]: localId=1000009863, pathUri=content://media/external/images/media/1000009863, remoteId=null, photoType=png
2025-08-13 17:19:34.831 28642-28642 LocalViewModel          com.akslabs.cloudgallery             D  Photo[4]: localId=1000009850, pathUri=content://media/external/images/media/1000009850, remoteId=null, photoType=png
2025-08-13 17:19:34.831 28642-28642 LocalViewModel          com.akslabs.cloudgallery             D  Photo[5]: localId=1000009844, pathUri=content://media/external/images/media/1000009844, remoteId=null, photoType=png
2025-08-13 17:19:34.831 28642-28642 LocalViewModel          com.akslabs.cloudgallery             D  Photo[6]: localId=1000009843, pathUri=content://media/external/images/media/1000009843, remoteId=null, photoType=png
2025-08-13 17:19:34.831 28642-28642 LocalViewModel          com.akslabs.cloudgallery             D  Photo[7]: localId=1000009842, pathUri=content://media/external/images/media/1000009842, remoteId=null, photoType=png
2025-08-13 17:19:34.831 28642-28642 LocalViewModel          com.akslabs.cloudgallery             D  Photo[8]: localId=1000009841, pathUri=content://media/external/images/media/1000009841, remoteId=null, photoType=png
2025-08-13 17:19:34.831 28642-28642 LocalViewModel          com.akslabs.cloudgallery             D  Photo[9]: localId=1000009768, pathUri=content://media/external/images/media/1000009768, remoteId=null, photoType=png
2025-08-13 17:19:34.831 28642-28642 LocalViewModel          com.akslabs.cloudgallery             D  ... and 941 more records
2025-08-13 17:19:34.831 28642-28642 LocalViewModel          com.akslabs.cloudgallery             I  Testing Local PagingSource directly...
2025-08-13 17:19:34.834 28642-28642 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-13 17:19:34.834 28642-28642 LocalViewModel          com.akslabs.cloudgallery             I  Local total count flow created: SafeFlow
2025-08-13 17:19:34.834 28642-28642 LocalViewModel          com.akslabs.cloudgallery             I  === END LOCAL PHOTOS DATABASE DEBUG ===
2025-08-13 17:19:34.848 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:19:34.869 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:19:34.869 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:19:34.869 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 0
2025-08-13 17:19:34.869 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-13 17:19:34.869 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:19:34.870 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-13 17:19:34.870 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:19:34.936 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:19:35.536 28642-31097 ContentValues           com.akslabs.cloudgallery             D  doWork: []
2025-08-13 17:19:35.536 28642-31097 Sync MediaStore         com.akslabs.cloudgallery             D  doWork: Success
2025-08-13 17:19:35.541 28642-31063 WM-WorkerWrapper        com.akslabs.cloudgallery             I  Worker result SUCCESS for Work [ id=e36ec5b1-da79-4693-a58a-d3e39dc20514, tags={ com.akslabs.cloudgallery.workers.SyncDbMediaStoreWorker } ]
2025-08-13 17:19:37.136 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:19:37.136 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:19:37.136 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 96
2025-08-13 17:19:37.136 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:19:37.136 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:19:37.136 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:19:37.136 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:19:37.148 28642-31057 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=2265ms; Flags=0, FrameTimelineVsyncId=9085732, IntendedVsync=15581897977134, Vsync=15581947979379, InputEventId=0, HandleInputStart=15581952211815, AnimationStart=15581952214419, PerformTraversalsStart=15582008144263, DrawStart=15582008253377, FrameDeadline=15581964658805, FrameInterval=15581952200825, FrameStartTime=16667415, SyncQueued=15584155832178, SyncStart=15584155916033, IssueDrawCommandsStart=15584156306970, SwapBuffers=15584158609105, FrameCompleted=15584163852387, DequeueBufferDuration=16198, QueueBufferDuration=285729, GpuCompleted=15584163852387, SwapBuffersCompleted=15584159746033, DisplayPresentTime=72904454231491835, CommandSubmissionCompleted=15584158609105, 
2025-08-13 17:19:37.237 28642-28642 Choreographer           com.akslabs.cloudgallery             I  Skipped 137 frames!  The application may be doing too much work on its main thread.
2025-08-13 17:19:37.265 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:19:37.582 28642-31057 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=2625ms; Flags=0, FrameTimelineVsyncId=9085784, IntendedVsync=15581964639584, Vsync=15584248066534, InputEventId=0, HandleInputStart=15584260705460, AnimationStart=15584260708949, PerformTraversalsStart=15584537055459, DrawStart=15584538310616, FrameDeadline=15584181412240, FrameInterval=15584259312335, FrameStartTime=16667350, SyncQueued=15584576714939, SyncStart=15584577077334, IssueDrawCommandsStart=15584577411918, SwapBuffers=15584579852491, FrameCompleted=15584590956449, DequeueBufferDuration=27864, QueueBufferDuration=393958, GpuCompleted=15584590956449, SwapBuffersCompleted=15584580822595, DisplayPresentTime=72057628414509173, CommandSubmissionCompleted=15584579852491, 
2025-08-13 17:19:37.768 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:19:37.768 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:19:37.768 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 96
2025-08-13 17:19:37.768 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:19:37.768 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: Loading(endOfPaginationReached=false)
2025-08-13 17:19:37.769 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:19:37.769 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:19:37.848 28642-28642 Choreographer           com.akslabs.cloudgallery             I  Skipped 36 frames!  The application may be doing too much work on its main thread.
2025-08-13 17:19:37.895 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:19:38.682 28642-31057 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1436ms; Flags=0, FrameTimelineVsyncId=9086786, IntendedVsync=15584261950418, Vsync=15584861948990, InputEventId=0, HandleInputStart=15584870651241, AnimationStart=15584870656084, PerformTraversalsStart=15585491911813, DrawStart=15585492017595, FrameDeadline=15584619414216, FrameInterval=15584870064418, FrameStartTime=16666627, SyncQueued=15585692310511, SyncStart=15585692389313, IssueDrawCommandsStart=15585692933792, SwapBuffers=15585694130147, FrameCompleted=15585698710147, DequeueBufferDuration=18437, QueueBufferDuration=327864, GpuCompleted=15585698237855, SwapBuffersCompleted=15585698710147, DisplayPresentTime=0, CommandSubmissionCompleted=15585694130147, 
2025-08-13 17:19:38.768 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:19:38.768 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:19:38.768 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 128
2025-08-13 17:19:38.768 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:19:38.768 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: Loading(endOfPaginationReached=false)
2025-08-13 17:19:38.769 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:19:38.769 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:19:38.825 28642-31125 ProfileInstaller        com.akslabs.cloudgallery             D  Installing profile for com.akslabs.cloudgallery
2025-08-13 17:19:38.846 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:19:39.234 28642-28642 WindowOnBackDispatcher  com.akslabs.cloudgallery             W  OnBackInvokedCallback is not enabled for the application.
                                                                                                    Set 'android:enableOnBackInvokedCallback="true"' in the application manifest.
2025-08-13 17:19:39.394 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:19:39.395 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:19:39.395 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 160
2025-08-13 17:19:39.395 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:19:39.395 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:19:39.395 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:19:39.395 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:19:40.389 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:19:40.393 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  🔍 Starting date grouping for 160 photos
2025-08-13 17:19:40.454 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  📊 Processed 100 photos so far...
2025-08-13 17:19:40.466 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  ✅ Date grouping complete: 160 processed, 0 skipped
2025-08-13 17:19:40.466 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  📅 Created 13 date groups
2025-08-13 17:19:40.471 28642-28642 LocalPhotoGrid          com.akslabs.cloudgallery             D  Layout cache in 81ms; normal=160, grouped=173
2025-08-13 17:19:41.316 28642-31050 bs.cloudgallery         com.akslabs.cloudgallery             I  Background concurrent copying GC freed 17MB AllocSpace bytes, 180(3940KB) LOS objects, 49% free, 9680KB/18MB, paused 75us,85us total 114.420ms
2025-08-13 17:19:41.352 28642-28642 AndroidRuntime          com.akslabs.cloudgallery             D  Shutting down VM
2025-08-13 17:19:41.362 28642-28642 AndroidRuntime          com.akslabs.cloudgallery             E  FATAL EXCEPTION: main
                                                                                                    Process: com.akslabs.cloudgallery, PID: 28642
                                                                                                    java.lang.IllegalArgumentException: Key "1000009736" was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item.
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState.subcompose(SubcomposeLayout.kt:453)
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState$Scope.subcompose(SubcomposeLayout.kt:895)
                                                                                                    	at androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScopeImpl.measure-0kLqBqw(LazyLayoutMeasureScope.kt:125)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider.getAndMeasure-m8Kt_7k(LazyGridMeasuredItemProvider.kt:62)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider.getAndMeasure(LazyGridMeasuredLineProvider.kt:72)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridMeasureKt.measureLazyGrid-OZKpZRA(LazyGridMeasure.kt:202)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.invoke-0kLqBqw(LazyGrid.kt:341)
                                                                                                    	at androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.invoke(LazyGrid.kt:172)
                                                                                                    	at androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$2$1.invoke-0kLqBqw(LazyLayout.kt:119)
                                                                                                    	at androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$2$1.invoke(LazyLayout.kt:112)
                                                                                                    	at androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1.measure-3p2s80s(SubcomposeLayout.kt:725)
                                                                                                    	at androidx.compose.ui.node.InnerNodeCoordinator.measure-BRTryo0(InnerNodeCoordinator.kt:135)
                                                                                                    	at androidx.compose.ui.graphics.SimpleGraphicsLayerModifier.measure-3p2s80s(GraphicsLayerModifier.kt:646)
                                                                                                    	at androidx.compose.ui.node.LayoutModifierNodeCoordinator.measure-BRTryo0(LayoutModifierNodeCoordinator.kt:188)
                                                                                                    	at androidx.compose.foundation.layout.FillNode.measure-3p2s80s(Size.kt:699)
                                                                                                    	at androidx.compose.ui.node.LayoutModifierNodeCoordinator.measure-BRTryo0(LayoutModifierNodeCoordinator.kt:188)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate$performMeasureBlock$1.invoke(LayoutNodeLayoutDelegate.kt:316)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate$performMeasureBlock$1.invoke(LayoutNodeLayoutDelegate.kt:315)
                                                                                                    	at androidx.compose.runtime.snapshots.Snapshot$Companion.observe(Snapshot.kt:2441)
                                                                                                    	at androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap.observe(SnapshotStateObserver.kt:502)
                                                                                                    	at androidx.compose.runtime.snapshots.SnapshotStateObserver.observeReads(SnapshotStateObserver.kt:258)
                                                                                                    	at androidx.compose.ui.node.OwnerSnapshotObserver.observeReads$ui_release(OwnerSnapshotObserver.kt:133)
                                                                                                    	at androidx.compose.ui.node.OwnerSnapshotObserver.observeMeasureSnapshotReads$ui_release(OwnerSnapshotObserver.kt:113)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate.performMeasure-BRTryo0(LayoutNodeLayoutDelegate.kt:1782)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate.access$performMeasure-BRTryo0(LayoutNodeLayoutDelegate.kt:40)
                                                                                                    	at androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate.remeasure-BRTryo0(LayoutNodeLayoutDelegate.kt:696)
                                                                                                    	at androidx.compose.ui.node.LayoutNode.remeasure-_Sx5XlM$ui_release(LayoutNode.kt:1222)
                                                                                                    	at androidx.compose.ui.node.LayoutNode.remeasure-_Sx5XlM$ui_release$default(LayoutNode.kt:1213)
                                                                                                    	at androidx.compose.ui.node.MeasureAndLayoutDelegate.doRemeasure-sdFAvZA(MeasureAndLayoutDelegate.kt:369)
                                                                                                    	at androidx.compose.ui.node.MeasureAndLayoutDelegate.remeasureAndRelayoutIfNeeded(MeasureAndLayoutDelegate.kt:566)
                                                                                                    	at androidx.compose.ui.node.MeasureAndLayoutDelegate.remeasureAndRelayoutIfNeeded$default(MeasureAndLayoutDelegate.kt:534)
                                                                                                    	at androidx.compose.ui.node.MeasureAndLayoutDelegate.measureAndLayout(MeasureAndLayoutDelegate.kt:390)
                                                                                                    	at androidx.compose.ui.platform.AndroidComposeView.measureAndLayout(AndroidComposeView.android.kt:1268)
                                                                                                    	at androidx.compose.ui.node.Owner.measureAndLayout$default(Owner.kt:248)
                                                                                                    	at androidx.compose.ui.platform.AndroidComposeView.dispatchDraw(AndroidComposeView.android.kt:1556)
2025-08-13 17:19:41.363 28642-28642 AndroidRuntime          com.akslabs.cloudgallery             E  	at android.view.View.draw(View.java:24880)
                                                                                                    	at android.view.View.updateDisplayListIfDirty(View.java:23727)
                                                                                                    	at android.view.ViewGroup.recreateChildDisplayList(ViewGroup.java:4540)
                                                                                                    	at android.view.ViewGroup.dispatchGetDisplayList(ViewGroup.java:4513)
                                                                                                    	at android.view.View.updateDisplayListIfDirty(View.java:23681)
                                                                                                    	at android.view.ViewGroup.recreateChildDisplayList(ViewGroup.java:4540)
                                                                                                    	at android.view.ViewGroup.dispatchGetDisplayList(ViewGroup.java:4513)
                                                                                                    	at android.view.View.updateDisplayListIfDirty(View.java:23681)
                                                                                                    	at android.view.ViewGroup.recreateChildDisplayList(ViewGroup.java:4540)
                                                                                                    	at android.view.ViewGroup.dispatchGetDisplayList(ViewGroup.java:4513)
                                                                                                    	at android.view.View.updateDisplayListIfDirty(View.java:23681)
                                                                                                    	at android.view.ViewGroup.recreateChildDisplayList(ViewGroup.java:4540)
                                                                                                    	at android.view.ViewGroup.dispatchGetDisplayList(ViewGroup.java:4513)
                                                                                                    	at android.view.View.updateDisplayListIfDirty(View.java:23681)
                                                                                                    	at android.view.ThreadedRenderer.updateViewTreeDisplayList(ThreadedRenderer.java:706)
                                                                                                    	at android.view.ThreadedRenderer.updateRootDisplayList(ThreadedRenderer.java:712)
                                                                                                    	at android.view.ThreadedRenderer.draw(ThreadedRenderer.java:810)
                                                                                                    	at android.view.ViewRootImpl.draw(ViewRootImpl.java:5748)
                                                                                                    	at android.view.ViewRootImpl.performDraw(ViewRootImpl.java:5400)
                                                                                                    	at android.view.ViewRootImpl.performTraversals(ViewRootImpl.java:4399)
                                                                                                    	at android.view.ViewRootImpl.doTraversal(ViewRootImpl.java:2997)
                                                                                                    	at android.view.ViewRootImpl$TraversalRunnable.run(ViewRootImpl.java:10455)
                                                                                                    	at android.view.Choreographer$CallbackRecord.run(Choreographer.java:1415)
                                                                                                    	at android.view.Choreographer$CallbackRecord.run(Choreographer.java:1424)
                                                                                                    	at android.view.Choreographer.doCallbacks(Choreographer.java:1024)
                                                                                                    	at android.view.Choreographer.doFrame(Choreographer.java:953)
                                                                                                    	at android.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:1398)
                                                                                                    	at android.os.Handler.handleCallback(Handler.java:991)
                                                                                                    	at android.os.Handler.dispatchMessage(Handler.java:102)
                                                                                                    	at android.os.Looper.loopOnce(Looper.java:232)
                                                                                                    	at android.os.Looper.loop(Looper.java:317)
                                                                                                    	at android.app.ActivityThread.main(ActivityThread.java:8782)
                                                                                                    	at java.lang.reflect.Method.invoke(Native Method)
                                                                                                    	at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:595)
                                                                                                    	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:871)
2025-08-13 17:19:41.386 28642-28642 Process                 com.akslabs.cloudgallery             I  Sending signal. PID: 28642 SIG: 9
2025-08-13 17:19:55.312 28644-28644 bs.cloudgallery         com.akslabs.cloudgallery             I  Late-enabling -Xcheck:jni
2025-08-13 17:19:55.351 28644-28644 bs.cloudgallery         com.akslabs.cloudgallery             I  Using CollectorTypeCC GC.
2025-08-13 17:19:55.367 28644-28644 nativeloader            com.akslabs.cloudgallery             D  Load libframework-connectivity-tiramisu-jni.so using APEX ns com_android_tethering for caller /apex/com.android.tethering/javalib/framework-connectivity-t.jar: ok
2025-08-13 17:19:55.443 28644-28644 re-initialized>         com.akslabs.cloudgallery             W  type=1400 audit(0.0:2389): avc:  granted  { execute } for  path="/data/data/com.akslabs.cloudgallery/code_cache/startup_agents/b13c65d9-agent.so" dev="mmcblk0p61" ino=298676 scontext=u:r:untrusted_app:s0:c45,c259,c512,c768 tcontext=u:object_r:app_data_file:s0:c45,c259,c512,c768 tclass=file app=com.akslabs.cloudgallery
2025-08-13 17:19:55.469 28644-28644 nativeloader            com.akslabs.cloudgallery             D  Load /data/user/0/com.akslabs.cloudgallery/code_cache/startup_agents/b13c65d9-agent.so using system ns (caller=<unknown>): ok
2025-08-13 17:19:55.485 28644-28644 bs.cloudgallery         com.akslabs.cloudgallery             W  DexFile /data/data/com.akslabs.cloudgallery/code_cache/.studio/instruments-462f9421.jar is in boot class path but is not in a known location
2025-08-13 17:19:55.625 28644-28644 bs.cloudgallery         com.akslabs.cloudgallery             W  Redefining intrinsic method java.lang.Thread java.lang.Thread.currentThread(). This may cause the unexpected use of the original definition of java.lang.Thread java.lang.Thread.currentThread()in methods that have already been compiled.
2025-08-13 17:19:55.625 28644-28644 bs.cloudgallery         com.akslabs.cloudgallery             W  Redefining intrinsic method boolean java.lang.Thread.interrupted(). This may cause the unexpected use of the original definition of boolean java.lang.Thread.interrupted()in methods that have already been compiled.
2025-08-13 17:19:55.687 28644-28644 ApplicationLoaders      com.akslabs.cloudgallery             D  Returning zygote-cached class loader: /system_ext/framework/androidx.window.extensions.jar
2025-08-13 17:19:55.687 28644-28644 ApplicationLoaders      com.akslabs.cloudgallery             D  Returning zygote-cached class loader: /system_ext/framework/androidx.window.sidecar.jar
2025-08-13 17:19:55.693 28644-28644 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes12.dm': No such file or directory
2025-08-13 17:19:55.700 28644-28644 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes14.dm': No such file or directory
2025-08-13 17:19:55.705 28644-28644 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes6.dm': No such file or directory
2025-08-13 17:19:55.717 28644-28644 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes4.dm': No such file or directory
2025-08-13 17:19:55.723 28644-28644 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes8.dm': No such file or directory
2025-08-13 17:19:55.726 28644-28644 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/app/~~H39HcsrPQN-FSXDcIRydeg==/com.akslabs.cloudgallery-RcHZ3qQgx4Iubj1z1Y82Gg==/base.dm': No such file or directory
2025-08-13 17:19:55.726 28644-28644 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/app/~~H39HcsrPQN-FSXDcIRydeg==/com.akslabs.cloudgallery-RcHZ3qQgx4Iubj1z1Y82Gg==/base.dm': No such file or directory
2025-08-13 17:19:56.511 28644-28644 nativeloader            com.akslabs.cloudgallery             D  Configuring clns-7 for other apk /data/app/~~H39HcsrPQN-FSXDcIRydeg==/com.akslabs.cloudgallery-RcHZ3qQgx4Iubj1z1Y82Gg==/base.apk. target_sdk_version=34, uses_libraries=, library_path=/data/app/~~H39HcsrPQN-FSXDcIRydeg==/com.akslabs.cloudgallery-RcHZ3qQgx4Iubj1z1Y82Gg==/lib/arm64:/data/app/~~H39HcsrPQN-FSXDcIRydeg==/com.akslabs.cloudgallery-RcHZ3qQgx4Iubj1z1Y82Gg==/base.apk!/lib/arm64-v8a, permitted_path=/data:/mnt/expand:/data/user/0/com.akslabs.cloudgallery
2025-08-13 17:19:56.528 28644-28644 GraphicsEnvironment     com.akslabs.cloudgallery             V  Currently set values for:
2025-08-13 17:19:56.528 28644-28644 GraphicsEnvironment     com.akslabs.cloudgallery             V    angle_gl_driver_selection_pkgs=[com.android.angle, com.linecorp.b612.android, com.campmobile.snow, com.google.android.apps.tachyon]
2025-08-13 17:19:56.528 28644-28644 GraphicsEnvironment     com.akslabs.cloudgallery             V    angle_gl_driver_selection_values=[angle, native, native, native]
2025-08-13 17:19:56.528 28644-28644 GraphicsEnvironment     com.akslabs.cloudgallery             V  com.akslabs.cloudgallery is not listed in per-application setting
2025-08-13 17:19:56.528 28644-28644 GraphicsEnvironment     com.akslabs.cloudgallery             V  Neither updatable production driver nor prerelease driver is supported.
2025-08-13 17:19:56.551 28644-28644 WM-WrkMgrInitializer    com.akslabs.cloudgallery             D  Initializing WorkManager with default configuration.
2025-08-13 17:19:56.626 28644-28644 WM-PackageManagerHelper com.akslabs.cloudgallery             D  Skipping component enablement for androidx.work.impl.background.systemjob.SystemJobService
2025-08-13 17:19:56.626 28644-28644 WM-Schedulers           com.akslabs.cloudgallery             D  Created SystemJobScheduler and enabled SystemJobService
2025-08-13 17:19:56.945 28644-28644 EngineFactory           com.akslabs.cloudgallery             I  Provider GmsCore_OpenSSL not available
2025-08-13 17:19:56.960 28644-28644 ImageLoaderModule       com.akslabs.cloudgallery             I  === INITIALIZING IMAGE LOADERS ===
2025-08-13 17:19:57.108 28644-28644 ImageLoaderModule       com.akslabs.cloudgallery             D  Created OkHttpClient with 30s connect, 60s read/write timeouts
2025-08-13 17:19:57.108 28644-28644 ImageLoaderModule       com.akslabs.cloudgallery             D  Creating remoteImageLoader...
2025-08-13 17:19:57.112 28644-28644 ImageLoaderModule       com.akslabs.cloudgallery             I  remoteImageLoader created successfully
2025-08-13 17:19:57.112 28644-28644 ImageLoaderModule       com.akslabs.cloudgallery             D  Creating thumbnailImageLoader...
2025-08-13 17:19:57.112 28644-28644 ImageLoaderModule       com.akslabs.cloudgallery             I  thumbnailImageLoader created successfully
2025-08-13 17:19:57.112 28644-28644 ImageLoaderModule       com.akslabs.cloudgallery             I  === IMAGE LOADERS INITIALIZATION COMPLETE ===
2025-08-13 17:19:57.112 28644-28644 ImageLoaderModule       com.akslabs.cloudgallery             I  Available loaders:
2025-08-13 17:19:57.112 28644-28644 ImageLoaderModule       com.akslabs.cloudgallery             I  - defaultImageLoader: ✓
2025-08-13 17:19:57.112 28644-28644 ImageLoaderModule       com.akslabs.cloudgallery             I  - remoteImageLoader: ✓
2025-08-13 17:19:57.112 28644-28644 ImageLoaderModule       com.akslabs.cloudgallery             I  - thumbnailImageLoader: ✓
2025-08-13 17:19:57.215 28644-28644 Choreographer           com.akslabs.cloudgallery             I  Skipped 32 frames!  The application may be doing too much work on its main thread.
2025-08-13 17:19:57.334 28644-31303 DatabaseDebugHelper     com.akslabs.cloudgallery             I  === DATABASE DEBUG REPORT ===
2025-08-13 17:19:57.356 28644-31303 DatabaseDebugHelper     com.akslabs.cloudgallery             I  Database version: 4
2025-08-13 17:19:57.374 28644-28644 DesktopModeFlagsUtil    com.akslabs.cloudgallery             D  Toggle override initialized to: OVERRIDE_UNSET
2025-08-13 17:19:57.410 28644-31303 DatabaseDebugHelper     com.akslabs.cloudgallery             I  Record counts:
2025-08-13 17:19:57.410 28644-31303 DatabaseDebugHelper     com.akslabs.cloudgallery             I    Total photos: 951
2025-08-13 17:19:57.410 28644-31303 DatabaseDebugHelper     com.akslabs.cloudgallery             I    Photos with remoteId: 3
2025-08-13 17:19:57.410 28644-31303 DatabaseDebugHelper     com.akslabs.cloudgallery             I    Total remote photos: 3
2025-08-13 17:19:57.410 28644-31303 DatabaseDebugHelper     com.akslabs.cloudgallery             I  Sample uploaded photos:
2025-08-13 17:19:57.410 28644-31303 DatabaseDebugHelper     com.akslabs.cloudgallery             I    Photo: localId=1000009071, remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ, type=png
2025-08-13 17:19:57.410 28644-31303 DatabaseDebugHelper     com.akslabs.cloudgallery             I    Photo: localId=1000006476, remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ, type=png
2025-08-13 17:19:57.410 28644-31303 DatabaseDebugHelper     com.akslabs.cloudgallery             I    Photo: localId=1000006091, remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE, type=png
2025-08-13 17:19:57.410 28644-31303 DatabaseDebugHelper     com.akslabs.cloudgallery             I  Sample remote photos:
2025-08-13 17:19:57.411 28644-31303 DatabaseDebugHelper     com.akslabs.cloudgallery             I    RemotePhoto: remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE, type=png, fileName=42717895550690360893227045473287536868.png
2025-08-13 17:19:57.411 28644-31303 DatabaseDebugHelper     com.akslabs.cloudgallery             I    RemotePhoto: remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ, type=png, fileName=694000534657088556765825092497223751.png
2025-08-13 17:19:57.411 28644-31303 DatabaseDebugHelper     com.akslabs.cloudgallery             I    RemotePhoto: remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ, type=png, fileName=42554030560734015792823288097017760953.png
2025-08-13 17:19:57.411 28644-31303 DatabaseDebugHelper     com.akslabs.cloudgallery             I  === END DATABASE DEBUG REPORT ===
2025-08-13 17:19:57.481 28644-28644 WM-SystemFgDispatcher   com.akslabs.cloudgallery             I  Started foreground service Intent { act=ACTION_START_FOREGROUND cmp=com.akslabs.cloudgallery/androidx.work.impl.foreground.SystemForegroundService (has extras) }
2025-08-13 17:19:57.791 28644-31286 bs.cloudgallery         com.akslabs.cloudgallery             I  Compiler allocated 4431KB to compile void android.view.ViewRootImpl.performTraversals()
2025-08-13 17:19:57.982 28644-28644 bs.cloudgallery         com.akslabs.cloudgallery             W  Method boolean androidx.compose.runtime.snapshots.SnapshotStateList.conditionalUpdate(boolean, kotlin.jvm.functions.Function1) failed lock verification and will run slower.
                                                                                                    Common causes for lock verification issues are non-optimized dex code
                                                                                                    and incorrect proguard optimizations.
2025-08-13 17:19:57.982 28644-28644 bs.cloudgallery         com.akslabs.cloudgallery             W  Method boolean androidx.compose.runtime.snapshots.SnapshotStateList.conditionalUpdate$default(androidx.compose.runtime.snapshots.SnapshotStateList, boolean, kotlin.jvm.functions.Function1, int, java.lang.Object) failed lock verification and will run slower.
2025-08-13 17:19:57.982 28644-28644 bs.cloudgallery         com.akslabs.cloudgallery             W  Method java.lang.Object androidx.compose.runtime.snapshots.SnapshotStateList.mutate(kotlin.jvm.functions.Function1) failed lock verification and will run slower.
2025-08-13 17:19:57.983 28644-28644 bs.cloudgallery         com.akslabs.cloudgallery             W  Method void androidx.compose.runtime.snapshots.SnapshotStateList.update(boolean, kotlin.jvm.functions.Function1) failed lock verification and will run slower.
2025-08-13 17:19:57.983 28644-28644 bs.cloudgallery         com.akslabs.cloudgallery             W  Method void androidx.compose.runtime.snapshots.SnapshotStateList.update$default(androidx.compose.runtime.snapshots.SnapshotStateList, boolean, kotlin.jvm.functions.Function1, int, java.lang.Object) failed lock verification and will run slower.
2025-08-13 17:19:58.536 28644-28644 LocalViewModel          com.akslabs.cloudgallery             E  🚀 === LOCAL VIEW MODEL INITIALIZED ===
2025-08-13 17:19:58.537 28644-28644 LocalViewModel          com.akslabs.cloudgallery             I  === LOCAL PHOTOS DATABASE DEBUG ===
2025-08-13 17:19:58.555 28644-28644 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-13 17:19:58.555 28644-28644 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 64, JumpThreshold: 160
2025-08-13 17:19:58.570 28644-28644 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-13 17:19:58.572 28644-28644 LocalViewModel          com.akslabs.cloudgallery             E  📊 Local photos count updated: 0
2025-08-13 17:19:58.588 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:19:58.603 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  🔍 Starting date grouping for 0 photos
2025-08-13 17:19:58.603 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  ✅ Date grouping complete: 0 processed, 0 skipped
2025-08-13 17:19:58.604 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  📅 Created 0 date groups
2025-08-13 17:19:58.604 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  Layout cache in 2ms; normal=0, grouped=0
2025-08-13 17:19:58.676 28644-31300 AdrenoGLES-0            com.akslabs.cloudgallery             I  QUALCOMM build                   : 95db91f, Ifbc588260a
                                                                                                    Build Date                       : 09/24/20
                                                                                                    OpenGL ES Shader Compiler Version: EV031.32.02.01
                                                                                                    Local Branch                     : mybrancheafe5b6d-fb5b-f1b0-b904-5cb90179c3e0
                                                                                                    Remote Branch                    : quic/gfx-adreno.lnx.1.0.r114-rel
                                                                                                    Remote Branch                    : NONE
                                                                                                    Reconstruct Branch               : NOTHING
2025-08-13 17:19:58.676 28644-31300 AdrenoGLES-0            com.akslabs.cloudgallery             I  Build Config                     : S P 10.0.7 AArch64
2025-08-13 17:19:58.676 28644-31300 AdrenoGLES-0            com.akslabs.cloudgallery             I  Driver Path                      : /vendor/lib64/egl/libGLESv2_adreno.so
2025-08-13 17:19:58.713 28644-31300 AdrenoGLES-0            com.akslabs.cloudgallery             I  PFP: 0x016ee190, ME: 0x00000000
2025-08-13 17:19:58.790 28644-31315 Gralloc4                com.akslabs.cloudgallery             I  mapper 4.x is not supported
2025-08-13 17:19:58.791 28644-31315 Gralloc3                com.akslabs.cloudgallery             W  mapper 3.x is not supported
2025-08-13 17:19:58.800 28644-31315 Gralloc2                com.akslabs.cloudgallery             I  Adding additional valid usage bits: 0x8202000
2025-08-13 17:19:58.859 28644-31294 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1369ms; Flags=1, FrameTimelineVsyncId=9096692, IntendedVsync=15604495361064, Vsync=15604495361064, InputEventId=0, HandleInputStart=15604506314098, AnimationStart=15604506316233, PerformTraversalsStart=15604506317379, DrawStart=15605808217014, FrameDeadline=15604516694396, FrameInterval=15604506305035, FrameStartTime=16667365, SyncQueued=15605848886701, SyncStart=15605849008837, IssueDrawCommandsStart=15605850053993, SwapBuffers=15605862040816, FrameCompleted=15605864850920, DequeueBufferDuration=23854, QueueBufferDuration=393959, GpuCompleted=15605864850920, SwapBuffersCompleted=15605863097691, DisplayPresentTime=35192962023424, CommandSubmissionCompleted=15605862040816, 
2025-08-13 17:19:58.909 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:19:58.909 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 0
2025-08-13 17:19:58.910 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 0
2025-08-13 17:19:58.910 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-13 17:19:58.910 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:19:58.910 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-13 17:19:58.910 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:19:58.915 28644-28644 LocalViewModel          com.akslabs.cloudgallery             E  ❌ Error collecting from localPhotosFlow
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@82ed91c
2025-08-13 17:19:58.926 28644-28644 LocalViewModel          com.akslabs.cloudgallery             E  ❌ Error collecting from localPhotosCount
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@82ed91c
2025-08-13 17:19:58.950 28644-28644 Choreographer           com.akslabs.cloudgallery             I  Skipped 83 frames!  The application may be doing too much work on its main thread.
2025-08-13 17:19:59.045 28644-28644 LocalViewModel          com.akslabs.cloudgallery             E  ❌ Error debugging local database state
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@82ed91c
2025-08-13 17:19:59.051 28644-31303 CloudPhotoSyncWorker    com.akslabs.cloudgallery             I  === CLOUD PHOTO SYNC WORKER STARTED ===
2025-08-13 17:19:59.065 28644-31292 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1487ms; Flags=0, FrameTimelineVsyncId=9096718, IntendedVsync=15604581328345, Vsync=15605964691586, InputEventId=0, HandleInputStart=15605972429878, AnimationStart=15605972432535, PerformTraversalsStart=15606049312743, DrawStart=15606050984983, FrameDeadline=15605895419025, FrameInterval=15605971759201, FrameStartTime=16667027, SyncQueued=15606064712378, SyncStart=15606064984149, IssueDrawCommandsStart=15606065079410, SwapBuffers=15606066414983, FrameCompleted=15606068764774, DequeueBufferDuration=15208, QueueBufferDuration=263334, GpuCompleted=15606068764774, SwapBuffersCompleted=15606067256233, DisplayPresentTime=72904454214516736, CommandSubmissionCompleted=15606066414983, 
2025-08-13 17:19:59.066 28644-31296 WM-Processor            com.akslabs.cloudgallery             I  Moving WorkSpec (72d63aea-1525-4d40-a833-508b8461a0bf) to the foreground
2025-08-13 17:19:59.082 28644-31303 CloudPhotoSyncService   com.akslabs.cloudgallery             I  === STARTING FULL CLOUD PHOTO SYNC ===
2025-08-13 17:19:59.089 28644-31303 CloudPhotoSyncService   com.akslabs.cloudgallery             D  Found configured group/channel ID: -1002651869724
2025-08-13 17:19:59.092 28644-31304 CloudPhotoSyncService   com.akslabs.cloudgallery             I  Syncing with channel ID: -1002651869724
2025-08-13 17:19:59.092 28644-31304 CloudPhotoSyncService   com.akslabs.cloudgallery             W  ⚠️  TELEGRAM BOT API LIMITATION:
2025-08-13 17:19:59.092 28644-31304 CloudPhotoSyncService   com.akslabs.cloudgallery             W  Bot API can only access messages from the last 24 hours
2025-08-13 17:19:59.092 28644-31304 CloudPhotoSyncService   com.akslabs.cloudgallery             W  Historical images older than 24 hours cannot be retrieved via Bot API
2025-08-13 17:19:59.092 28644-31304 CloudPhotoSyncService   com.akslabs.cloudgallery             W  This is a Telegram platform limitation, not an app bug
2025-08-13 17:19:59.092 28644-31304 CloudPhotoSyncService   com.akslabs.cloudgallery             D  Last sync: 0, Current: 1755085799092, Should sync: true
2025-08-13 17:19:59.097 28644-31304 CloudPhotoSyncService   com.akslabs.cloudgallery             I  Current database has 3 RemotePhoto records
2025-08-13 17:19:59.097 28644-31304 CloudPhotoSyncService   com.akslabs.cloudgallery             I  Performing incremental sync
2025-08-13 17:19:59.102 28644-31304 Historical...eDiscovery com.akslabs.cloudgallery             I  === STARTING HISTORICAL IMAGE DISCOVERY ===
2025-08-13 17:19:59.102 28644-31304 Historical...eDiscovery com.akslabs.cloudgallery             I  Channel ID: -1002651869724
2025-08-13 17:19:59.102 28644-31304 Historical...eDiscovery com.akslabs.cloudgallery             I  Config: ScanConfig(channelId=-1002651869724, batchSize=100, maxFiles=1000, includePhotos=true, includeDocuments=true, includeVideos=true)
2025-08-13 17:19:59.108 28644-31305 Historical...eDiscovery com.akslabs.cloudgallery             I  Found 3 existing RemotePhoto records
2025-08-13 17:19:59.108 28644-31305 Historical...eDiscovery com.akslabs.cloudgallery             D  Processing batch 1 (offset: null)
2025-08-13 17:19:59.126 28644-31305 BotApi                  com.akslabs.cloudgallery             D  === SCANNING CHANNEL FOR MEDIA ===
2025-08-13 17:19:59.126 28644-31305 BotApi                  com.akslabs.cloudgallery             D  Channel ID: -1002651869724, Limit: 100, Offset: null
2025-08-13 17:19:59.159 28644-28644 LocalViewModel          com.akslabs.cloudgallery             E  🚀 === LOCAL VIEW MODEL INITIALIZED ===
2025-08-13 17:19:59.160 28644-28644 LocalViewModel          com.akslabs.cloudgallery             I  === LOCAL PHOTOS DATABASE DEBUG ===
2025-08-13 17:19:59.167 28644-28644 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-13 17:19:59.167 28644-28644 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 64, JumpThreshold: 160
2025-08-13 17:19:59.171 28644-28644 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-13 17:19:59.173 28644-28644 LocalViewModel          com.akslabs.cloudgallery             E  📊 Local photos count updated: 0
2025-08-13 17:19:59.178 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:19:59.183 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  🔍 Starting date grouping for 0 photos
2025-08-13 17:19:59.183 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  ✅ Date grouping complete: 0 processed, 0 skipped
2025-08-13 17:19:59.183 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  📅 Created 0 date groups
2025-08-13 17:19:59.183 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  Layout cache in 0ms; normal=0, grouped=0
2025-08-13 17:19:59.287 28644-28644 WM-SystemFgDispatcher   com.akslabs.cloudgallery             I  Started foreground service Intent { act=ACTION_START_FOREGROUND cmp=com.akslabs.cloudgallery/androidx.work.impl.foreground.SystemForegroundService (has extras) }
2025-08-13 17:19:59.324 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:19:59.324 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 0
2025-08-13 17:19:59.324 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 0
2025-08-13 17:19:59.324 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-13 17:19:59.325 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:19:59.325 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-13 17:19:59.325 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:19:59.429 28644-28644 LocalViewModel          com.akslabs.cloudgallery             E  📊 Local photos count updated: 951
2025-08-13 17:19:59.430 28644-28644 LocalViewModel          com.akslabs.cloudgallery             I  Total Photo records in database: 951
2025-08-13 17:19:59.430 28644-28644 LocalViewModel          com.akslabs.cloudgallery             I  ✅ Photo records found:
2025-08-13 17:19:59.430 28644-28644 LocalViewModel          com.akslabs.cloudgallery             D  Photo[0]: localId=1000009866, pathUri=content://media/external/images/media/1000009866, remoteId=null, photoType=png
2025-08-13 17:19:59.430 28644-28644 LocalViewModel          com.akslabs.cloudgallery             D  Photo[1]: localId=1000009865, pathUri=content://media/external/images/media/1000009865, remoteId=null, photoType=png
2025-08-13 17:19:59.430 28644-28644 LocalViewModel          com.akslabs.cloudgallery             D  Photo[2]: localId=1000009864, pathUri=content://media/external/images/media/1000009864, remoteId=null, photoType=png
2025-08-13 17:19:59.430 28644-28644 LocalViewModel          com.akslabs.cloudgallery             D  Photo[3]: localId=1000009863, pathUri=content://media/external/images/media/1000009863, remoteId=null, photoType=png
2025-08-13 17:19:59.431 28644-28644 LocalViewModel          com.akslabs.cloudgallery             D  Photo[4]: localId=1000009850, pathUri=content://media/external/images/media/1000009850, remoteId=null, photoType=png
2025-08-13 17:19:59.431 28644-28644 LocalViewModel          com.akslabs.cloudgallery             D  Photo[5]: localId=1000009844, pathUri=content://media/external/images/media/1000009844, remoteId=null, photoType=png
2025-08-13 17:19:59.431 28644-28644 LocalViewModel          com.akslabs.cloudgallery             D  Photo[6]: localId=1000009843, pathUri=content://media/external/images/media/1000009843, remoteId=null, photoType=png
2025-08-13 17:19:59.431 28644-28644 LocalViewModel          com.akslabs.cloudgallery             D  Photo[7]: localId=1000009842, pathUri=content://media/external/images/media/1000009842, remoteId=null, photoType=png
2025-08-13 17:19:59.431 28644-28644 LocalViewModel          com.akslabs.cloudgallery             D  Photo[8]: localId=1000009841, pathUri=content://media/external/images/media/1000009841, remoteId=null, photoType=png
2025-08-13 17:19:59.431 28644-28644 LocalViewModel          com.akslabs.cloudgallery             D  Photo[9]: localId=1000009768, pathUri=content://media/external/images/media/1000009768, remoteId=null, photoType=png
2025-08-13 17:19:59.431 28644-28644 LocalViewModel          com.akslabs.cloudgallery             D  ... and 941 more records
2025-08-13 17:19:59.431 28644-28644 LocalViewModel          com.akslabs.cloudgallery             I  Testing Local PagingSource directly...
2025-08-13 17:19:59.434 28644-28644 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-13 17:19:59.434 28644-28644 LocalViewModel          com.akslabs.cloudgallery             I  Local total count flow created: SafeFlow
2025-08-13 17:19:59.434 28644-28644 LocalViewModel          com.akslabs.cloudgallery             I  === END LOCAL PHOTOS DATABASE DEBUG ===
2025-08-13 17:19:59.472 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:19:59.476 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  🔍 Starting date grouping for 0 photos
2025-08-13 17:19:59.476 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  ✅ Date grouping complete: 0 processed, 0 skipped
2025-08-13 17:19:59.476 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  📅 Created 0 date groups
2025-08-13 17:19:59.476 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  Layout cache in 0ms; normal=0, grouped=0
2025-08-13 17:19:59.524 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:19:59.524 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:19:59.524 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 0
2025-08-13 17:19:59.524 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-13 17:19:59.524 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:19:59.525 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-13 17:19:59.525 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:19:59.535 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:19:59.542 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  🔍 Starting date grouping for 96 photos
2025-08-13 17:19:59.681 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  ✅ Date grouping complete: 96 processed, 0 skipped
2025-08-13 17:19:59.681 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  📅 Created 13 date groups
2025-08-13 17:19:59.685 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  Layout cache in 148ms; normal=96, grouped=109
2025-08-13 17:19:59.905 28644-31303 ContentValues           com.akslabs.cloudgallery             D  doWork: []
2025-08-13 17:19:59.905 28644-31303 Sync MediaStore         com.akslabs.cloudgallery             D  doWork: Success
2025-08-13 17:19:59.910 28644-31296 WM-WorkerWrapper        com.akslabs.cloudgallery             I  Worker result SUCCESS for Work [ id=5a5ba63d-6964-4576-9340-647e9976054e, tags={ com.akslabs.cloudgallery.workers.SyncDbMediaStoreWorker } ]
2025-08-13 17:20:00.951 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:20:00.951 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:20:00.951 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 96
2025-08-13 17:20:00.951 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:20:00.951 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:20:00.951 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:20:00.951 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:20:00.966 28644-31293 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1502ms; Flags=0, FrameTimelineVsyncId=9097852, IntendedVsync=15606481300025, Vsync=15606547962869, InputEventId=0, HandleInputStart=15606550432066, AnimationStart=15606550434618, PerformTraversalsStart=15606780889670, DrawStart=15606781006284, FrameDeadline=15606564656940, FrameInterval=15606550421180, FrameStartTime=16665711, SyncQueued=15607970881648, SyncStart=15607971149305, IssueDrawCommandsStart=15607971425711, SwapBuffers=15607974355659, FrameCompleted=15607983677117, DequeueBufferDuration=17032, QueueBufferDuration=237188, GpuCompleted=15607983677117, SwapBuffersCompleted=15607974895398, DisplayPresentTime=0, CommandSubmissionCompleted=15607974355659, 
2025-08-13 17:20:00.999 28644-28644 Choreographer           com.akslabs.cloudgallery             I  Skipped 87 frames!  The application may be doing too much work on its main thread.
2025-08-13 17:20:01.132 28644-31292 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1569ms; Flags=0, FrameTimelineVsyncId=9097896, IntendedVsync=15606564629460, Vsync=15608014657416, InputEventId=0, HandleInputStart=15608021758680, AnimationStart=15608021761076, PerformTraversalsStart=15608116323107, DrawStart=15608117583107, FrameDeadline=15608014546392, FrameInterval=15608021298315, FrameStartTime=16666988, SyncQueued=15608127406128, SyncStart=15608127657534, IssueDrawCommandsStart=15608127843211, SwapBuffers=15608129190294, FrameCompleted=15608134263003, DequeueBufferDuration=16875, QueueBufferDuration=260729, GpuCompleted=15608134263003, SwapBuffersCompleted=15608129916544, DisplayPresentTime=72904454231491835, CommandSubmissionCompleted=15608129190294, 
2025-08-13 17:20:01.255 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:20:01.850 28644-31293 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=837ms; Flags=0, FrameTimelineVsyncId=9098535, IntendedVsync=15608028586795, Vsync=15608245244899, InputEventId=0, HandleInputStart=15608262961596, AnimationStart=15608262966128, PerformTraversalsStart=15608701740971, DrawStart=15608701842481, FrameDeadline=15608169326652, FrameInterval=15608261815034, FrameStartTime=16666008, SyncQueued=15608856940346, SyncStart=15608857197117, IssueDrawCommandsStart=15608857524877, SwapBuffers=15608858617013, FrameCompleted=15608866328211, DequeueBufferDuration=16823, QueueBufferDuration=217708, GpuCompleted=15608866328211, SwapBuffersCompleted=15608859135554, DisplayPresentTime=72057628414509173, CommandSubmissionCompleted=15608858617013, 
2025-08-13 17:20:01.891 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:20:02.466 28644-31356 ProfileInstaller        com.akslabs.cloudgallery             D  Installing profile for com.akslabs.cloudgallery
2025-08-13 17:20:04.727 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:20:05.003 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:20:05.465 28644-31287 bs.cloudgallery         com.akslabs.cloudgallery             I  Background concurrent copying GC freed 14MB AllocSpace bytes, 112(2452KB) LOS objects, 49% free, 8502KB/16MB, paused 164us,70us total 105.781ms
2025-08-13 17:20:05.699 28644-31294 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=874ms; Flags=0, FrameTimelineVsyncId=9100287, IntendedVsync=15611828724742, Vsync=15612095396982, InputEventId=589020507, HandleInputStart=15612103202011, AnimationStart=15612211549928, PerformTraversalsStart=15612668412584, DrawStart=15612668578053, FrameDeadline=15612133366825, FrameInterval=15612102890709, FrameStartTime=16667015, SyncQueued=15612691814928, SyncStart=15612691883574, IssueDrawCommandsStart=15612692264407, SwapBuffers=15612694351647, FrameCompleted=15612702911438, DequeueBufferDuration=16979, QueueBufferDuration=334479, GpuCompleted=15612702911438, SwapBuffersCompleted=15612695007115, DisplayPresentTime=72904454231491208, CommandSubmissionCompleted=15612694351647, 
2025-08-13 17:20:05.738 28644-28644 Choreographer           com.akslabs.cloudgallery             I  Skipped 32 frames!  The application may be doing too much work on its main thread.
2025-08-13 17:20:06.148 28644-31294 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=948ms; Flags=0, FrameTimelineVsyncId=9100619, IntendedVsync=15612212002236, Vsync=15612745336956, InputEventId=469479757, HandleInputStart=15612760598626, AnimationStart=15612760638782, PerformTraversalsStart=15613135449771, DrawStart=15613135554824, FrameDeadline=15612733409869, FrameInterval=15612759667949, FrameStartTime=16666710, SyncQueued=15613154187949, SyncStart=15613154504615, IssueDrawCommandsStart=15613154869615, SwapBuffers=15613156692219, FrameCompleted=15613160449980, DequeueBufferDuration=17708, QueueBufferDuration=316875, GpuCompleted=15613160449980, SwapBuffersCompleted=15613157442376, DisplayPresentTime=72057628414509199, CommandSubmissionCompleted=15613156692219, 
2025-08-13 17:20:06.615 28644-31292 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=835ms; Flags=0, FrameTimelineVsyncId=9100916, IntendedVsync=15612795316735, Vsync=15613178648535, InputEventId=292976874, HandleInputStart=15613185714251, AnimationStart=15613232663001, PerformTraversalsStart=15613596424719, DrawStart=15613596508105, FrameDeadline=15613183338038, FrameInterval=15613184566751, FrameStartTime=16666600, SyncQueued=15613621242480, SyncStart=15613621495032, IssueDrawCommandsStart=15613621840657, SwapBuffers=15613623368053, FrameCompleted=15613631101282, DequeueBufferDuration=16614, QueueBufferDuration=335521, GpuCompleted=15613631101282, SwapBuffersCompleted=15613623960553, DisplayPresentTime=0, CommandSubmissionCompleted=15613623368053, 
2025-08-13 17:20:07.199 28644-31370 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=963ms; Flags=0, FrameTimelineVsyncId=9101222, IntendedVsync=15613245307506, Vsync=15613728636644, InputEventId=872154793, HandleInputStart=15613729988886, AnimationStart=15613730075813, PerformTraversalsStart=15614158013729, DrawStart=15614158111594, FrameDeadline=15613666646667, FrameInterval=15613729652427, FrameStartTime=16666522, SyncQueued=15614198047219, SyncStart=15614198147896, IssueDrawCommandsStart=15614198521334, SwapBuffers=15614200737167, FrameCompleted=15614208911750, DequeueBufferDuration=16510, QueueBufferDuration=253750, GpuCompleted=15614208911750, SwapBuffersCompleted=15614201261386, DisplayPresentTime=0, CommandSubmissionCompleted=15614200737167, 
2025-08-13 17:20:20.602 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:20:20.608 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  Opening photo viewer: originalIndex=74, mappedIndex=74, totalLoaded=96
2025-08-13 17:20:20.757 28644-28644 WindowOnBackDispatcher  com.akslabs.cloudgallery             W  OnBackInvokedCallback is not enabled for the application.
                                                                                                    Set 'android:enableOnBackInvokedCallback="true"' in the application manifest.
2025-08-13 17:20:21.113 28644-28644 Choreographer           com.akslabs.cloudgallery             I  Skipped 31 frames!  The application may be doing too much work on its main thread.
2025-08-13 17:20:22.911 28644-28644 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:20:23.018 28644-28644 WindowOnBackDispatcher  com.akslabs.cloudgallery             W  sendCancelIfRunning: isInProgress=false callback=android.view.ViewRootImpl$$ExternalSyntheticLambda11@1103d42
2025-08-13 17:20:32.158 28644-31305 BotApi                  com.akslabs.cloudgallery             I  Received 0 updates from Telegram
2025-08-13 17:20:32.159 28644-31305 BotApi                  com.akslabs.cloudgallery             I  Scan complete: Found 0 media files
2025-08-13 17:20:32.160 28644-31344 Historical...eDiscovery com.akslabs.cloudgallery             D  Batch 1: Found 0 media files
2025-08-13 17:20:32.160 28644-31344 Historical...eDiscovery com.akslabs.cloudgallery             I  Batch 1: Processing 0 new files
2025-08-13 17:20:32.166 28644-31344 Historical...eDiscovery com.akslabs.cloudgallery             I  No more messages to scan
2025-08-13 17:20:32.166 28644-31344 Historical...eDiscovery com.akslabs.cloudgallery             I  No new images found to sync
2025-08-13 17:20:32.166 28644-31344 Historical...eDiscovery com.akslabs.cloudgallery             I  === HISTORICAL IMAGE DISCOVERY COMPLETE ===
2025-08-13 17:20:32.166 28644-31344 Historical...eDiscovery com.akslabs.cloudgallery             I  Total batches processed: 1
2025-08-13 17:20:32.166 28644-31344 Historical...eDiscovery com.akslabs.cloudgallery             I  Total new files discovered: 0
2025-08-13 17:20:32.172 28644-31344 CloudPhotoSyncService   com.akslabs.cloudgallery             D  Updated last sync timestamp to: 1755085832166
2025-08-13 17:20:32.172 28644-31344 CloudPhotoSyncService   com.akslabs.cloudgallery             I  === FULL CLOUD PHOTO SYNC COMPLETE ===
2025-08-13 17:20:32.172 28644-31344 CloudPhotoSyncWorker    com.akslabs.cloudgallery             I  Cloud photo sync completed successfully: 0 new files
2025-08-13 17:20:32.172 28644-31344 CloudPhotoSyncWorker    com.akslabs.cloudgallery             I  === CLOUD PHOTO SYNC WORKER FINISHED ===
2025-08-13 17:20:32.174 28644-31307 WM-WorkerWrapper        com.akslabs.cloudgallery             I  Worker result SUCCESS for Work [ id=72d63aea-1525-4d40-a833-508b8461a0bf, tags={ com.akslabs.cloudgallery.workers.CloudPhotoSyncWorker } ]
2025-08-13 17:20:32.186 28644-28644 WM-SystemFgDispatcher   com.akslabs.cloudgallery             I  Stopping foreground service
2025-08-13 17:22:19.443 28644-28644 VRI[MainActivity]       com.akslabs.cloudgallery             D  visibilityChanged oldVisibility=true newVisibility=false
---------------------------- PROCESS STARTED (28645) for package com.akslabs.cloudgallery ----------------------------
2025-08-13 17:25:23.254 28645-28645 ApplicationLoaders      com.akslabs.cloudgallery             D  Returning zygote-cached class loader: /system_ext/framework/androidx.window.extensions.jar
2025-08-13 17:25:23.254 28645-28645 ApplicationLoaders      com.akslabs.cloudgallery             D  Returning zygote-cached class loader: /system_ext/framework/androidx.window.sidecar.jar
2025-08-13 17:25:23.270 28645-28645 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes12.dm': No such file or directory
2025-08-13 17:25:23.272 28645-28645 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes14.dm': No such file or directory
2025-08-13 17:25:23.281 28645-28645 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes6.dm': No such file or directory
2025-08-13 17:25:23.289 28645-28645 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes4.dm': No such file or directory
2025-08-13 17:25:23.294 28645-28645 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes8.dm': No such file or directory
2025-08-13 17:25:23.300 28645-28645 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/app/~~H39HcsrPQN-FSXDcIRydeg==/com.akslabs.cloudgallery-RcHZ3qQgx4Iubj1z1Y82Gg==/base.dm': No such file or directory
2025-08-13 17:25:23.300 28645-28645 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/app/~~H39HcsrPQN-FSXDcIRydeg==/com.akslabs.cloudgallery-RcHZ3qQgx4Iubj1z1Y82Gg==/base.dm': No such file or directory
2025-08-13 17:25:24.010 28645-28645 nativeloader            com.akslabs.cloudgallery             D  Configuring clns-7 for other apk /data/app/~~H39HcsrPQN-FSXDcIRydeg==/com.akslabs.cloudgallery-RcHZ3qQgx4Iubj1z1Y82Gg==/base.apk. target_sdk_version=34, uses_libraries=, library_path=/data/app/~~H39HcsrPQN-FSXDcIRydeg==/com.akslabs.cloudgallery-RcHZ3qQgx4Iubj1z1Y82Gg==/lib/arm64:/data/app/~~H39HcsrPQN-FSXDcIRydeg==/com.akslabs.cloudgallery-RcHZ3qQgx4Iubj1z1Y82Gg==/base.apk!/lib/arm64-v8a, permitted_path=/data:/mnt/expand:/data/user/0/com.akslabs.cloudgallery
2025-08-13 17:25:24.048 28645-28645 GraphicsEnvironment     com.akslabs.cloudgallery             V  Currently set values for:
2025-08-13 17:25:24.048 28645-28645 GraphicsEnvironment     com.akslabs.cloudgallery             V    angle_gl_driver_selection_pkgs=[com.android.angle, com.linecorp.b612.android, com.campmobile.snow, com.google.android.apps.tachyon]
2025-08-13 17:25:24.048 28645-28645 GraphicsEnvironment     com.akslabs.cloudgallery             V    angle_gl_driver_selection_values=[angle, native, native, native]
2025-08-13 17:25:24.048 28645-28645 GraphicsEnvironment     com.akslabs.cloudgallery             V  com.akslabs.cloudgallery is not listed in per-application setting
2025-08-13 17:25:24.048 28645-28645 GraphicsEnvironment     com.akslabs.cloudgallery             V  Neither updatable production driver nor prerelease driver is supported.
2025-08-13 17:25:24.073 28645-28645 WM-WrkMgrInitializer    com.akslabs.cloudgallery             D  Initializing WorkManager with default configuration.
2025-08-13 17:25:24.152 28645-28645 WM-PackageManagerHelper com.akslabs.cloudgallery             D  Skipping component enablement for androidx.work.impl.background.systemjob.SystemJobService
2025-08-13 17:25:24.152 28645-28645 WM-Schedulers           com.akslabs.cloudgallery             D  Created SystemJobScheduler and enabled SystemJobService
2025-08-13 17:25:24.513 28645-28645 EngineFactory           com.akslabs.cloudgallery             I  Provider GmsCore_OpenSSL not available
2025-08-13 17:25:24.533 28645-28645 ImageLoaderModule       com.akslabs.cloudgallery             I  === INITIALIZING IMAGE LOADERS ===
2025-08-13 17:25:24.675 28645-28645 ImageLoaderModule       com.akslabs.cloudgallery             D  Created OkHttpClient with 30s connect, 60s read/write timeouts
2025-08-13 17:25:24.675 28645-28645 ImageLoaderModule       com.akslabs.cloudgallery             D  Creating remoteImageLoader...
2025-08-13 17:25:24.679 28645-28645 ImageLoaderModule       com.akslabs.cloudgallery             I  remoteImageLoader created successfully
2025-08-13 17:25:24.679 28645-28645 ImageLoaderModule       com.akslabs.cloudgallery             D  Creating thumbnailImageLoader...
2025-08-13 17:25:24.680 28645-28645 ImageLoaderModule       com.akslabs.cloudgallery             I  thumbnailImageLoader created successfully
2025-08-13 17:25:24.680 28645-28645 ImageLoaderModule       com.akslabs.cloudgallery             I  === IMAGE LOADERS INITIALIZATION COMPLETE ===
2025-08-13 17:25:24.680 28645-28645 ImageLoaderModule       com.akslabs.cloudgallery             I  Available loaders:
2025-08-13 17:25:24.680 28645-28645 ImageLoaderModule       com.akslabs.cloudgallery             I  - defaultImageLoader: ✓
2025-08-13 17:25:24.680 28645-28645 ImageLoaderModule       com.akslabs.cloudgallery             I  - remoteImageLoader: ✓
2025-08-13 17:25:24.680 28645-28645 ImageLoaderModule       com.akslabs.cloudgallery             I  - thumbnailImageLoader: ✓
2025-08-13 17:25:24.782 28645-28645 Choreographer           com.akslabs.cloudgallery             I  Skipped 34 frames!  The application may be doing too much work on its main thread.
2025-08-13 17:25:24.907 28645-32109 DatabaseDebugHelper     com.akslabs.cloudgallery             I  === DATABASE DEBUG REPORT ===
2025-08-13 17:25:24.927 28645-28645 MainActivity            com.akslabs.cloudgallery             W  Invalid sync timestamp format, resetting to 0
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
2025-08-13 17:25:24.931 28645-32109 DatabaseDebugHelper     com.akslabs.cloudgallery             I  Database version: 4
2025-08-13 17:25:24.955 28645-28645 DesktopModeFlagsUtil    com.akslabs.cloudgallery             D  Toggle override initialized to: OVERRIDE_UNSET
2025-08-13 17:25:24.970 28645-32110 DatabaseDebugHelper     com.akslabs.cloudgallery             I  Record counts:
2025-08-13 17:25:24.971 28645-32110 DatabaseDebugHelper     com.akslabs.cloudgallery             I    Total photos: 951
2025-08-13 17:25:24.971 28645-32110 DatabaseDebugHelper     com.akslabs.cloudgallery             I    Photos with remoteId: 3
2025-08-13 17:25:24.971 28645-32110 DatabaseDebugHelper     com.akslabs.cloudgallery             I    Total remote photos: 3
2025-08-13 17:25:24.971 28645-32110 DatabaseDebugHelper     com.akslabs.cloudgallery             I  Sample uploaded photos:
2025-08-13 17:25:24.971 28645-32110 DatabaseDebugHelper     com.akslabs.cloudgallery             I    Photo: localId=1000009071, remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ, type=png
2025-08-13 17:25:24.971 28645-32110 DatabaseDebugHelper     com.akslabs.cloudgallery             I    Photo: localId=1000006476, remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ, type=png
2025-08-13 17:25:24.971 28645-32110 DatabaseDebugHelper     com.akslabs.cloudgallery             I    Photo: localId=1000006091, remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE, type=png
2025-08-13 17:25:24.971 28645-32110 DatabaseDebugHelper     com.akslabs.cloudgallery             I  Sample remote photos:
2025-08-13 17:25:24.971 28645-32110 DatabaseDebugHelper     com.akslabs.cloudgallery             I    RemotePhoto: remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE, type=png, fileName=42717895550690360893227045473287536868.png
2025-08-13 17:25:24.971 28645-32110 DatabaseDebugHelper     com.akslabs.cloudgallery             I    RemotePhoto: remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ, type=png, fileName=694000534657088556765825092497223751.png
2025-08-13 17:25:24.971 28645-32110 DatabaseDebugHelper     com.akslabs.cloudgallery             I    RemotePhoto: remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ, type=png, fileName=42554030560734015792823288097017760953.png
2025-08-13 17:25:24.971 28645-32110 DatabaseDebugHelper     com.akslabs.cloudgallery             I  === END DATABASE DEBUG REPORT ===
2025-08-13 17:25:25.359 28645-32090 bs.cloudgallery         com.akslabs.cloudgallery             I  Compiler allocated 4431KB to compile void android.view.ViewRootImpl.performTraversals()
2025-08-13 17:25:25.505 28645-28645 bs.cloudgallery         com.akslabs.cloudgallery             W  Method boolean androidx.compose.runtime.snapshots.SnapshotStateList.conditionalUpdate(boolean, kotlin.jvm.functions.Function1) failed lock verification and will run slower.
                                                                                                    Common causes for lock verification issues are non-optimized dex code
                                                                                                    and incorrect proguard optimizations.
2025-08-13 17:25:25.505 28645-28645 bs.cloudgallery         com.akslabs.cloudgallery             W  Method boolean androidx.compose.runtime.snapshots.SnapshotStateList.conditionalUpdate$default(androidx.compose.runtime.snapshots.SnapshotStateList, boolean, kotlin.jvm.functions.Function1, int, java.lang.Object) failed lock verification and will run slower.
2025-08-13 17:25:25.505 28645-28645 bs.cloudgallery         com.akslabs.cloudgallery             W  Method java.lang.Object androidx.compose.runtime.snapshots.SnapshotStateList.mutate(kotlin.jvm.functions.Function1) failed lock verification and will run slower.
2025-08-13 17:25:25.505 28645-28645 bs.cloudgallery         com.akslabs.cloudgallery             W  Method void androidx.compose.runtime.snapshots.SnapshotStateList.update(boolean, kotlin.jvm.functions.Function1) failed lock verification and will run slower.
2025-08-13 17:25:25.505 28645-28645 bs.cloudgallery         com.akslabs.cloudgallery             W  Method void androidx.compose.runtime.snapshots.SnapshotStateList.update$default(androidx.compose.runtime.snapshots.SnapshotStateList, boolean, kotlin.jvm.functions.Function1, int, java.lang.Object) failed lock verification and will run slower.
2025-08-13 17:25:26.070 28645-28645 LocalViewModel          com.akslabs.cloudgallery             E  🚀 === LOCAL VIEW MODEL INITIALIZED ===
2025-08-13 17:25:26.071 28645-28645 LocalViewModel          com.akslabs.cloudgallery             I  === LOCAL PHOTOS DATABASE DEBUG ===
2025-08-13 17:25:26.089 28645-28645 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-13 17:25:26.089 28645-28645 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 64, JumpThreshold: 160
2025-08-13 17:25:26.105 28645-28645 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-13 17:25:26.106 28645-28645 LocalViewModel          com.akslabs.cloudgallery             E  📊 Local photos count updated: 0
2025-08-13 17:25:26.123 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:25:26.200 28645-32106 AdrenoGLES-0            com.akslabs.cloudgallery             I  QUALCOMM build                   : 95db91f, Ifbc588260a
                                                                                                    Build Date                       : 09/24/20
                                                                                                    OpenGL ES Shader Compiler Version: EV031.32.02.01
                                                                                                    Local Branch                     : mybrancheafe5b6d-fb5b-f1b0-b904-5cb90179c3e0
                                                                                                    Remote Branch                    : quic/gfx-adreno.lnx.1.0.r114-rel
                                                                                                    Remote Branch                    : NONE
                                                                                                    Reconstruct Branch               : NOTHING
2025-08-13 17:25:26.200 28645-32106 AdrenoGLES-0            com.akslabs.cloudgallery             I  Build Config                     : S P 10.0.7 AArch64
2025-08-13 17:25:26.200 28645-32106 AdrenoGLES-0            com.akslabs.cloudgallery             I  Driver Path                      : /vendor/lib64/egl/libGLESv2_adreno.so
2025-08-13 17:25:26.256 28645-32106 AdrenoGLES-0            com.akslabs.cloudgallery             I  PFP: 0x016ee190, ME: 0x00000000
2025-08-13 17:25:26.322 28645-32122 Gralloc4                com.akslabs.cloudgallery             I  mapper 4.x is not supported
2025-08-13 17:25:26.323 28645-32122 Gralloc3                com.akslabs.cloudgallery             W  mapper 3.x is not supported
2025-08-13 17:25:26.330 28645-32122 Gralloc2                com.akslabs.cloudgallery             I  Adding additional valid usage bits: 0x8202000
2025-08-13 17:25:26.375 28645-32110 CloudPhotoSyncWorker    com.akslabs.cloudgallery             I  === CLOUD PHOTO SYNC WORKER STARTED ===
2025-08-13 17:25:26.396 28645-32112 WM-Processor            com.akslabs.cloudgallery             I  Moving WorkSpec (38e93e4b-3685-46e9-8f01-28d1d5fa50f8) to the foreground
2025-08-13 17:25:26.409 28645-32097 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1306ms; Flags=1, FrameTimelineVsyncId=9317575, IntendedVsync=15932095315411, Vsync=15932095315411, InputEventId=0, HandleInputStart=15932096309181, AnimationStart=15932096313244, PerformTraversalsStart=15932096315379, DrawStart=15933338827462, FrameDeadline=15932116648743, FrameInterval=15932096297619, FrameStartTime=16666728, SyncQueued=15933378717566, SyncStart=15933379443399, IssueDrawCommandsStart=15933380731837, SwapBuffers=15933393553764, FrameCompleted=15933402913295, DequeueBufferDuration=15833, QueueBufferDuration=376666, GpuCompleted=15933402913295, SwapBuffersCompleted=15933394389233, DisplayPresentTime=35192962096355, CommandSubmissionCompleted=15933393553764, 
2025-08-13 17:25:26.419 28645-32110 CloudPhotoSyncService   com.akslabs.cloudgallery             I  === STARTING FULL CLOUD PHOTO SYNC ===
2025-08-13 17:25:26.424 28645-32110 CloudPhotoSyncService   com.akslabs.cloudgallery             D  Found configured group/channel ID: -1002651869724
2025-08-13 17:25:26.425 28645-32110 CloudPhotoSyncService   com.akslabs.cloudgallery             I  Syncing with channel ID: -1002651869724
2025-08-13 17:25:26.425 28645-32110 CloudPhotoSyncService   com.akslabs.cloudgallery             W  ⚠️  TELEGRAM BOT API LIMITATION:
2025-08-13 17:25:26.425 28645-32110 CloudPhotoSyncService   com.akslabs.cloudgallery             W  Bot API can only access messages from the last 24 hours
2025-08-13 17:25:26.425 28645-32110 CloudPhotoSyncService   com.akslabs.cloudgallery             W  Historical images older than 24 hours cannot be retrieved via Bot API
2025-08-13 17:25:26.425 28645-32110 CloudPhotoSyncService   com.akslabs.cloudgallery             W  This is a Telegram platform limitation, not an app bug
2025-08-13 17:25:26.425 28645-32110 CloudPhotoSyncService   com.akslabs.cloudgallery             D  Last sync: 0, Current: 1755086126425, Should sync: true
2025-08-13 17:25:26.427 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:26.428 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 0
2025-08-13 17:25:26.428 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 0
2025-08-13 17:25:26.428 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-13 17:25:26.428 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:26.428 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:26.428 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:26.431 28645-32109 CloudPhotoSyncService   com.akslabs.cloudgallery             I  Current database has 3 RemotePhoto records
2025-08-13 17:25:26.431 28645-32109 CloudPhotoSyncService   com.akslabs.cloudgallery             I  Performing incremental sync
2025-08-13 17:25:26.433 28645-28645 LocalViewModel          com.akslabs.cloudgallery             E  ❌ Error collecting from localPhotosFlow
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@9c12925
2025-08-13 17:25:26.436 28645-32109 Historical...eDiscovery com.akslabs.cloudgallery             I  === STARTING HISTORICAL IMAGE DISCOVERY ===
2025-08-13 17:25:26.436 28645-32109 Historical...eDiscovery com.akslabs.cloudgallery             I  Channel ID: -1002651869724
2025-08-13 17:25:26.436 28645-32109 Historical...eDiscovery com.akslabs.cloudgallery             I  Config: ScanConfig(channelId=-1002651869724, batchSize=100, maxFiles=1000, includePhotos=true, includeDocuments=true, includeVideos=true)
2025-08-13 17:25:26.441 28645-32111 Historical...eDiscovery com.akslabs.cloudgallery             I  Found 3 existing RemotePhoto records
2025-08-13 17:25:26.441 28645-32111 Historical...eDiscovery com.akslabs.cloudgallery             D  Processing batch 1 (offset: null)
2025-08-13 17:25:26.445 28645-28645 LocalViewModel          com.akslabs.cloudgallery             E  ❌ Error collecting from localPhotosCount
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@9c12925
2025-08-13 17:25:26.470 28645-32111 BotApi                  com.akslabs.cloudgallery             D  === SCANNING CHANNEL FOR MEDIA ===
2025-08-13 17:25:26.470 28645-32111 BotApi                  com.akslabs.cloudgallery             D  Channel ID: -1002651869724, Limit: 100, Offset: null
2025-08-13 17:25:26.476 28645-28645 Choreographer           com.akslabs.cloudgallery             I  Skipped 81 frames!  The application may be doing too much work on its main thread.
2025-08-13 17:25:26.607 28645-28645 LocalViewModel          com.akslabs.cloudgallery             E  ❌ Error debugging local database state
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@9c12925
2025-08-13 17:25:26.614 28645-32095 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1481ms; Flags=0, FrameTimelineVsyncId=9317618, IntendedVsync=15932147974539, Vsync=15933497956341, InputEventId=0, HandleInputStart=15933499329337, AnimationStart=15933499332097, PerformTraversalsStart=15933603371003, DrawStart=15933604996003, FrameDeadline=15933428653589, FrameInterval=15933498013660, FrameStartTime=16666442, SyncQueued=15933625962566, SyncStart=15933626230378, IssueDrawCommandsStart=15933626324024, SwapBuffers=15933627628347, FrameCompleted=15933629953764, DequeueBufferDuration=16094, QueueBufferDuration=310833, GpuCompleted=15933629953764, SwapBuffersCompleted=15933628514805, DisplayPresentTime=35192962111539, CommandSubmissionCompleted=15933627628347, 
2025-08-13 17:25:26.617 28645-28645 WM-SystemFgDispatcher   com.akslabs.cloudgallery             I  Started foreground service Intent { act=ACTION_START_FOREGROUND cmp=com.akslabs.cloudgallery/androidx.work.impl.foreground.SystemForegroundService (has extras) }
2025-08-13 17:25:26.722 28645-28645 LocalViewModel          com.akslabs.cloudgallery             E  🚀 === LOCAL VIEW MODEL INITIALIZED ===
2025-08-13 17:25:26.722 28645-28645 LocalViewModel          com.akslabs.cloudgallery             I  === LOCAL PHOTOS DATABASE DEBUG ===
2025-08-13 17:25:26.730 28645-28645 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-13 17:25:26.730 28645-28645 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 64, JumpThreshold: 160
2025-08-13 17:25:26.734 28645-28645 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-13 17:25:26.735 28645-28645 LocalViewModel          com.akslabs.cloudgallery             E  📊 Local photos count updated: 0
2025-08-13 17:25:26.741 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:25:26.839 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:26.840 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 0
2025-08-13 17:25:26.840 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 0
2025-08-13 17:25:26.840 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-13 17:25:26.840 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:26.840 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:26.840 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:26.913 28645-28645 LocalViewModel          com.akslabs.cloudgallery             E  📊 Local photos count updated: 951
2025-08-13 17:25:26.914 28645-28645 LocalViewModel          com.akslabs.cloudgallery             I  Total Photo records in database: 951
2025-08-13 17:25:26.914 28645-28645 LocalViewModel          com.akslabs.cloudgallery             I  ✅ Photo records found:
2025-08-13 17:25:26.914 28645-28645 LocalViewModel          com.akslabs.cloudgallery             D  Photo[0]: localId=1000009866, pathUri=content://media/external/images/media/1000009866, remoteId=null, photoType=png
2025-08-13 17:25:26.914 28645-28645 LocalViewModel          com.akslabs.cloudgallery             D  Photo[1]: localId=1000009865, pathUri=content://media/external/images/media/1000009865, remoteId=null, photoType=png
2025-08-13 17:25:26.914 28645-28645 LocalViewModel          com.akslabs.cloudgallery             D  Photo[2]: localId=1000009864, pathUri=content://media/external/images/media/1000009864, remoteId=null, photoType=png
2025-08-13 17:25:26.914 28645-28645 LocalViewModel          com.akslabs.cloudgallery             D  Photo[3]: localId=1000009863, pathUri=content://media/external/images/media/1000009863, remoteId=null, photoType=png
2025-08-13 17:25:26.914 28645-28645 LocalViewModel          com.akslabs.cloudgallery             D  Photo[4]: localId=1000009850, pathUri=content://media/external/images/media/1000009850, remoteId=null, photoType=png
2025-08-13 17:25:26.914 28645-28645 LocalViewModel          com.akslabs.cloudgallery             D  Photo[5]: localId=1000009844, pathUri=content://media/external/images/media/1000009844, remoteId=null, photoType=png
2025-08-13 17:25:26.914 28645-28645 LocalViewModel          com.akslabs.cloudgallery             D  Photo[6]: localId=1000009843, pathUri=content://media/external/images/media/1000009843, remoteId=null, photoType=png
2025-08-13 17:25:26.914 28645-28645 LocalViewModel          com.akslabs.cloudgallery             D  Photo[7]: localId=1000009842, pathUri=content://media/external/images/media/1000009842, remoteId=null, photoType=png
2025-08-13 17:25:26.914 28645-28645 LocalViewModel          com.akslabs.cloudgallery             D  Photo[8]: localId=1000009841, pathUri=content://media/external/images/media/1000009841, remoteId=null, photoType=png
2025-08-13 17:25:26.914 28645-28645 LocalViewModel          com.akslabs.cloudgallery             D  Photo[9]: localId=1000009768, pathUri=content://media/external/images/media/1000009768, remoteId=null, photoType=png
2025-08-13 17:25:26.914 28645-28645 LocalViewModel          com.akslabs.cloudgallery             D  ... and 941 more records
2025-08-13 17:25:26.914 28645-28645 LocalViewModel          com.akslabs.cloudgallery             I  Testing Local PagingSource directly...
2025-08-13 17:25:26.916 28645-28645 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-13 17:25:26.916 28645-28645 LocalViewModel          com.akslabs.cloudgallery             I  Local total count flow created: SafeFlow
2025-08-13 17:25:26.916 28645-28645 LocalViewModel          com.akslabs.cloudgallery             I  === END LOCAL PHOTOS DATABASE DEBUG ===
2025-08-13 17:25:26.929 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:25:26.950 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:26.950 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:25:26.950 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 0
2025-08-13 17:25:26.951 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-13 17:25:26.951 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:26.951 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:26.951 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:27.133 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:25:27.404 28645-32110 ContentValues           com.akslabs.cloudgallery             D  doWork: []
2025-08-13 17:25:27.404 28645-32110 Sync MediaStore         com.akslabs.cloudgallery             D  doWork: Success
2025-08-13 17:25:27.407 28645-32113 WM-WorkerWrapper        com.akslabs.cloudgallery             I  Worker result SUCCESS for Work [ id=a6414df8-48ee-4bcd-b847-2520ac5cbafe, tags={ com.akslabs.cloudgallery.workers.SyncDbMediaStoreWorker } ]
2025-08-13 17:25:28.798 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:28.799 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:25:28.799 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 96
2025-08-13 17:25:28.799 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:28.799 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:28.799 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:25:28.799 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:28.815 28645-32197 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1762ms; Flags=0, FrameTimelineVsyncId=9318859, IntendedVsync=15934064647522, Vsync=15934131312802, InputEventId=0, HandleInputStart=15934140875222, AnimationStart=15934140879337, PerformTraversalsStart=15934205526836, DrawStart=15934205643555, FrameDeadline=15934114651403, FrameInterval=15934140858191, FrameStartTime=16666320, SyncQueued=15935814507513, SyncStart=15935814600534, IssueDrawCommandsStart=15935814905013, SwapBuffers=15935818203398, FrameCompleted=15935827048346, DequeueBufferDuration=19584, QueueBufferDuration=250677, GpuCompleted=15935827048346, SwapBuffersCompleted=15935818861263, DisplayPresentTime=35192962117794, CommandSubmissionCompleted=15935818203398, 
2025-08-13 17:25:28.833 28645-28645 Choreographer           com.akslabs.cloudgallery             I  Skipped 102 frames!  The application may be doing too much work on its main thread.
2025-08-13 17:25:28.859 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:25:29.148 28645-32095 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=2018ms; Flags=0, FrameTimelineVsyncId=9318904, IntendedVsync=15934147976683, Vsync=15935847917353, InputEventId=0, HandleInputStart=15935855343450, AnimationStart=15935855346315, PerformTraversalsStart=15936129234284, DrawStart=15936130635482, FrameDeadline=15935847944108, FrameInterval=15935854604805, FrameStartTime=16666085, SyncQueued=15936160743346, SyncStart=15936161012409, IssueDrawCommandsStart=15936161204700, SwapBuffers=15936162599336, FrameCompleted=15936166907721, DequeueBufferDuration=17864, QueueBufferDuration=261979, GpuCompleted=15936166907721, SwapBuffersCompleted=15936163424179, DisplayPresentTime=35192962108723, CommandSubmissionCompleted=15936162599336, 
2025-08-13 17:25:29.232 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:29.232 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:25:29.232 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 96
2025-08-13 17:25:29.232 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:29.232 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: Loading(endOfPaginationReached=false)
2025-08-13 17:25:29.232 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:25:29.232 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:29.371 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:25:30.045 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:30.045 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:25:30.045 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 128
2025-08-13 17:25:30.045 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:30.045 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:30.045 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:25:30.045 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:30.048 28645-32095 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1190ms; Flags=0, FrameTimelineVsyncId=9319668, IntendedVsync=15935861970655, Vsync=15936345301127, InputEventId=0, HandleInputStart=15936362616732, AnimationStart=15936362619492, PerformTraversalsStart=15936877711783, DrawStart=15936877821940, FrameDeadline=15936202572385, FrameInterval=15936361486002, FrameStartTime=16666568, SyncQueued=15937047658919, SyncStart=15937047978137, IssueDrawCommandsStart=15937048308346, SwapBuffers=15937049453137, FrameCompleted=15937053013815, DequeueBufferDuration=17969, QueueBufferDuration=244323, GpuCompleted=15937053013815, SwapBuffersCompleted=15937050596783, DisplayPresentTime=0, CommandSubmissionCompleted=15937049453137, 
2025-08-13 17:25:30.072 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:25:30.591 28645-32224 ProfileInstaller        com.akslabs.cloudgallery             D  Installing profile for com.akslabs.cloudgallery
2025-08-13 17:25:34.070 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:25:34.070 28645-32091 bs.cloudgallery         com.akslabs.cloudgallery             I  Background concurrent copying GC freed 18MB AllocSpace bytes, 110(2476KB) LOS objects, 49% free, 8224KB/16MB, paused 70us,83us total 129.720ms
2025-08-13 17:25:34.339 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:25:37.496 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:25:37.776 28645-28645 Choreographer           com.akslabs.cloudgallery             I  Skipped 37 frames!  The application may be doing too much work on its main thread.
2025-08-13 17:25:37.800 28645-32242 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=888ms; Flags=0, FrameTimelineVsyncId=9323689, IntendedVsync=15943911986474, Vsync=15944111986730, InputEventId=661307194, HandleInputStart=15944126679281, AnimationStart=15944173880791, PerformTraversalsStart=15944713902978, DrawStart=15944713999332, FrameDeadline=15944169331576, FrameInterval=15944126136208, FrameStartTime=16666688, SyncQueued=15944792843864, SyncStart=15944792942770, IssueDrawCommandsStart=15944793300687, SwapBuffers=15944794855895, FrameCompleted=15944800719853, DequeueBufferDuration=16771, QueueBufferDuration=264687, GpuCompleted=15944800719853, SwapBuffersCompleted=15944795562718, DisplayPresentTime=35192962078907, CommandSubmissionCompleted=15944794855895, 
2025-08-13 17:25:37.848 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:37.848 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:25:37.848 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 128
2025-08-13 17:25:37.848 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:37.848 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: Loading(endOfPaginationReached=false)
2025-08-13 17:25:37.848 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:25:37.848 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:38.084 28645-32242 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=915ms; Flags=0, FrameTimelineVsyncId=9323890, IntendedVsync=15944178650784, Vsync=15944795316242, InputEventId=38798300, HandleInputStart=15944799105530, AnimationStart=15944869858447, PerformTraversalsStart=15945067471728, DrawStart=15945067551259, FrameDeadline=15944833320958, FrameInterval=15944798465062, FrameStartTime=16666634, SyncQueued=15945085478239, SyncStart=15945085610062, IssueDrawCommandsStart=15945086285791, SwapBuffers=15945089776416, FrameCompleted=15945094020791, DequeueBufferDuration=27135, QueueBufferDuration=251875, GpuCompleted=15945094020791, SwapBuffersCompleted=15945090893187, DisplayPresentTime=0, CommandSubmissionCompleted=15945089776416, 
2025-08-13 17:25:38.195 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:25:38.447 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:38.448 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:25:38.448 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 160
2025-08-13 17:25:38.448 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:38.448 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:38.448 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:25:38.448 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:40.013 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:25:40.233 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:40.233 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:25:40.233 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 160
2025-08-13 17:25:40.233 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:40.233 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: Loading(endOfPaginationReached=false)
2025-08-13 17:25:40.233 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:25:40.233 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:40.437 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:25:40.587 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:40.587 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:25:40.587 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 192
2025-08-13 17:25:40.587 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:40.587 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:40.587 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:25:40.587 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:43.117 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:25:43.268 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:43.268 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:25:43.268 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 192
2025-08-13 17:25:43.269 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:43.269 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: Loading(endOfPaginationReached=false)
2025-08-13 17:25:43.269 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:25:43.269 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:43.903 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:25:44.128 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:44.128 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:25:44.128 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 224
2025-08-13 17:25:44.128 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:44.128 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:44.128 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:25:44.128 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:44.131 28645-28645 Choreographer           com.akslabs.cloudgallery             I  Skipped 30 frames!  The application may be doing too much work on its main thread.
2025-08-13 17:25:44.148 28645-32242 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=826ms; Flags=0, FrameTimelineVsyncId=9328432, IntendedVsync=15950328621051, Vsync=15950545265609, InputEventId=0, HandleInputStart=15950553375632, AnimationStart=15950553378809, PerformTraversalsStart=15951099066205, DrawStart=15951099159590, FrameDeadline=15950583344632, FrameInterval=15950552434591, FrameStartTime=16664966, SyncQueued=15951148031778, SyncStart=15951148296674, IssueDrawCommandsStart=15951148677768, SwapBuffers=15951150629174, FrameCompleted=15951155272611, DequeueBufferDuration=17188, QueueBufferDuration=287656, GpuCompleted=15951155272611, SwapBuffersCompleted=15951151375163, DisplayPresentTime=0, CommandSubmissionCompleted=15951150629174, 
2025-08-13 17:25:44.556 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:25:44.883 28645-32242 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1240ms; Flags=0, FrameTimelineVsyncId=9328581, IntendedVsync=15950645339156, Vsync=15951145323116, InputEventId=0, HandleInputStart=15951153426882, AnimationStart=15951153429903, PerformTraversalsStart=15951803889642, DrawStart=15951803977924, FrameDeadline=15951183202683, FrameInterval=15951152798549, FrameStartTime=16666132, SyncQueued=15951874962871, SyncStart=15951875222038, IssueDrawCommandsStart=15951875596934, SwapBuffers=15951877386778, FrameCompleted=15951885825840, DequeueBufferDuration=17552, QueueBufferDuration=284948, GpuCompleted=15951885825840, SwapBuffersCompleted=15951877940632, DisplayPresentTime=35197257032699, CommandSubmissionCompleted=15951877386778, 
2025-08-13 17:25:44.927 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:44.927 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:25:44.927 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 224
2025-08-13 17:25:44.927 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:44.927 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: Loading(endOfPaginationReached=false)
2025-08-13 17:25:44.927 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:25:44.927 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:45.424 28645-28645 Choreographer           com.akslabs.cloudgallery             I  Skipped 77 frames!  The application may be doing too much work on its main thread.
2025-08-13 17:25:45.430 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:25:45.650 28645-32242 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1503ms; Flags=0, FrameTimelineVsyncId=9328817, IntendedVsync=15951161948609, Vsync=15952445195420, InputEventId=673327794, HandleInputStart=15952446163913, AnimationStart=15952446239642, PerformTraversalsStart=15952591424017, DrawStart=15952591507142, FrameDeadline=15951916632388, FrameInterval=15952445560423, FrameStartTime=16665543, SyncQueued=15952655447038, SyncStart=15952655760579, IssueDrawCommandsStart=15952656078184, SwapBuffers=15952657432923, FrameCompleted=15952666063965, DequeueBufferDuration=17396, QueueBufferDuration=366459, GpuCompleted=15952666063965, SwapBuffersCompleted=15952658070632, DisplayPresentTime=35192962110907, CommandSubmissionCompleted=15952657432923, 
2025-08-13 17:25:45.657 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:45.657 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:25:45.657 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 256
2025-08-13 17:25:45.657 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:45.657 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: Loading(endOfPaginationReached=false)
2025-08-13 17:25:45.657 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:25:45.657 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:45.948 28645-28645 Choreographer           com.akslabs.cloudgallery             I  Skipped 30 frames!  The application may be doing too much work on its main thread.
2025-08-13 17:25:46.067 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:25:46.300 28645-32197 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=846ms; Flags=0, FrameTimelineVsyncId=9329638, IntendedVsync=15952461993393, Vsync=15952961987913, InputEventId=1064568125, HandleInputStart=15952971088965, AnimationStart=15952989019746, PerformTraversalsStart=15953270419590, DrawStart=15953270509798, FrameDeadline=15952699846354, FrameInterval=15952970369902, FrameStartTime=16666484, SyncQueued=15953300217506, SyncStart=15953300466308, IssueDrawCommandsStart=15953300791465, SwapBuffers=15953301826100, FrameCompleted=15953309097819, DequeueBufferDuration=17344, QueueBufferDuration=268855, GpuCompleted=15953309097819, SwapBuffersCompleted=15953302385631, DisplayPresentTime=0, CommandSubmissionCompleted=15953301826100, 
2025-08-13 17:25:46.307 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:46.307 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:25:46.307 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 288
2025-08-13 17:25:46.307 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:46.307 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:46.307 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:25:46.308 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:47.737 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:25:47.905 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:47.905 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:25:47.905 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 288
2025-08-13 17:25:47.905 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:47.905 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: Loading(endOfPaginationReached=false)
2025-08-13 17:25:47.905 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:25:47.905 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:48.100 28645-32240 HWUI                    com.akslabs.cloudgallery             D  --- Failed to create image decoder with message 'unimplemented'
2025-08-13 17:25:48.100 28645-32240 HWUI                    com.akslabs.cloudgallery             D  --- Failed to create image decoder with message 'unimplemented'
2025-08-13 17:25:48.163 28645-32091 bs.cloudgallery         com.akslabs.cloudgallery             I  Background concurrent copying GC freed 9770KB AllocSpace bytes, 55(1100KB) LOS objects, 49% free, 10157KB/19MB, paused 250us,44us total 113.557ms
2025-08-13 17:25:48.237 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:25:48.427 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:48.427 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:25:48.427 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 320
2025-08-13 17:25:48.427 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:48.427 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:48.427 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:25:48.427 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:54.253 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:25:54.410 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:54.411 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:25:54.411 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 320
2025-08-13 17:25:54.411 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:54.411 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: Loading(endOfPaginationReached=false)
2025-08-13 17:25:54.411 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:25:54.411 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:54.600 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:25:54.798 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:54.799 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:25:54.799 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 352
2025-08-13 17:25:54.799 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:54.799 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:25:54.799 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:25:54.799 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:25:56.098 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:25:56.109 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  Opening photo viewer: originalIndex=248, mappedIndex=248, totalLoaded=352
2025-08-13 17:25:56.309 28645-28645 WindowOnBackDispatcher  com.akslabs.cloudgallery             W  OnBackInvokedCallback is not enabled for the application.
                                                                                                    Set 'android:enableOnBackInvokedCallback="true"' in the application manifest.
2025-08-13 17:25:57.893 28645-32112 WM-Processor            com.akslabs.cloudgallery             I  Moving WorkSpec (e60ec733-1822-4e84-98a3-7454d1c2d259) to the foreground
2025-08-13 17:25:57.897 28645-28645 WM-SystemFgDispatcher   com.akslabs.cloudgallery             I  Started foreground service Intent { act=ACTION_START_FOREGROUND cmp=com.akslabs.cloudgallery/androidx.work.impl.foreground.SystemForegroundService (has extras) }
2025-08-13 17:25:58.134  1835-1835  NotifAttentionHelper    system_server                        E  Muting recently noisy 0|com.akslabs.cloudgallery|1|null|10813
2025-08-13 17:25:58.839 28645-32111 BotApi                  com.akslabs.cloudgallery             I  Received 0 updates from Telegram
2025-08-13 17:25:58.839 28645-32111 BotApi                  com.akslabs.cloudgallery             I  Scan complete: Found 0 media files
2025-08-13 17:25:58.840 28645-32241 Historical...eDiscovery com.akslabs.cloudgallery             D  Batch 1: Found 0 media files
2025-08-13 17:25:58.840 28645-32241 Historical...eDiscovery com.akslabs.cloudgallery             I  Batch 1: Processing 0 new files
2025-08-13 17:25:58.846 28645-32241 Historical...eDiscovery com.akslabs.cloudgallery             I  No more messages to scan
2025-08-13 17:25:58.846 28645-32241 Historical...eDiscovery com.akslabs.cloudgallery             I  No new images found to sync
2025-08-13 17:25:58.846 28645-32241 Historical...eDiscovery com.akslabs.cloudgallery             I  === HISTORICAL IMAGE DISCOVERY COMPLETE ===
2025-08-13 17:25:58.847 28645-32241 Historical...eDiscovery com.akslabs.cloudgallery             I  Total batches processed: 1
2025-08-13 17:25:58.847 28645-32241 Historical...eDiscovery com.akslabs.cloudgallery             I  Total new files discovered: 0
2025-08-13 17:25:58.848 28645-32241 CloudPhotoSyncService   com.akslabs.cloudgallery             D  Updated last sync timestamp to: 1755086158847
2025-08-13 17:25:58.848 28645-32241 CloudPhotoSyncService   com.akslabs.cloudgallery             I  === FULL CLOUD PHOTO SYNC COMPLETE ===
2025-08-13 17:25:58.848 28645-32241 CloudPhotoSyncWorker    com.akslabs.cloudgallery             I  Cloud photo sync completed successfully: 0 new files
2025-08-13 17:25:58.848 28645-32241 CloudPhotoSyncWorker    com.akslabs.cloudgallery             I  === CLOUD PHOTO SYNC WORKER FINISHED ===
2025-08-13 17:25:58.854 28645-32113 WM-WorkerWrapper        com.akslabs.cloudgallery             I  Worker result SUCCESS for Work [ id=38e93e4b-3685-46e9-8f01-28d1d5fa50f8, tags={ com.akslabs.cloudgallery.workers.CloudPhotoSyncWorker } ]
2025-08-13 17:25:59.086  1835-1835  NotifAttentionHelper    system_server                        E  Muting recently noisy 0|com.akslabs.cloudgallery|1|null|10813
2025-08-13 17:26:38.157 28645-28645 JobService              com.akslabs.cloudgallery             W  onNetworkChanged() not implemented in androidx.work.impl.background.systemjob.SystemJobService. Must override in a subclass.
2025-08-13 17:26:39.118 28645-32240 ContentValues           com.akslabs.cloudgallery             D  sendFile: Failed!
2025-08-13 17:26:39.119 28645-32240 ContentValues           com.akslabs.cloudgallery             D  56851300455617874268131129071423892370.png
2025-08-13 17:26:39.166 28645-32102 WM-Processor            com.akslabs.cloudgallery             I  Moving WorkSpec (e60ec733-1822-4e84-98a3-7454d1c2d259) to the foreground
2025-08-13 17:26:39.176 28645-32112 WM-WorkerWrapper        com.akslabs.cloudgallery             I  Worker result SUCCESS for Work [ id=e60ec733-1822-4e84-98a3-7454d1c2d259, tags={ com.akslabs.cloudgallery.workers.InstantPhotoUploadWorker } ]
2025-08-13 17:26:39.197 28645-28645 WM-SystemFgDispatcher   com.akslabs.cloudgallery             I  Stopping foreground service
2025-08-13 17:26:46.060 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:26:46.219 28645-28645 WindowOnBackDispatcher  com.akslabs.cloudgallery             W  sendCancelIfRunning: isInProgress=false callback=android.view.ViewRootImpl$$ExternalSyntheticLambda11@dfa10a4
2025-08-13 17:26:47.623 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:26:47.818 28645-28645 WindowOnBackDispatcher  com.akslabs.cloudgallery             W  OnBackInvokedCallback is not enabled for the application.
                                                                                                    Set 'android:enableOnBackInvokedCallback="true"' in the application manifest.
2025-08-13 17:26:47.832 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:26:47.838 28645-28645 RemoteViewModel         com.akslabs.cloudgallery             E  🚀 === REMOTE VIEW MODEL INITIALIZED ===
2025-08-13 17:26:47.839 28645-28645 RemoteViewModel         com.akslabs.cloudgallery             I  === COMPREHENSIVE DATABASE DEBUG ===
2025-08-13 17:26:47.849 28645-28645 RemoteViewModel         com.akslabs.cloudgallery             D  === CREATING NEW PAGING SOURCE ===
2025-08-13 17:26:47.849 28645-28645 RemoteViewModel         com.akslabs.cloudgallery             D  PageSize: 24, PrefetchDistance: 72, JumpThreshold: 120
2025-08-13 17:26:47.850 28645-28645 RemoteViewModel         com.akslabs.cloudgallery             D  PagingSource created: null
2025-08-13 17:26:47.852 28645-28645 RemoteViewModel         com.akslabs.cloudgallery             E  📄 New PagingData received in ViewModel
2025-08-13 17:26:47.864 28645-28645 RemoteViewModel         com.akslabs.cloudgallery             E  📊 Total count updated: 0
2025-08-13 17:26:47.871 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:26:47.874 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  🚀 Creating remote layout cache for 0 photos
2025-08-13 17:26:47.874 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  🔍 Starting remote date grouping for 0 photos
2025-08-13 17:26:47.874 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  ✅ Remote date grouping complete: 0 processed, 0 skipped
2025-08-13 17:26:47.874 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  📅 Created 0 remote date groups
2025-08-13 17:26:47.874 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  ⚡ Remote layout cache created in 1ms
2025-08-13 17:26:47.874 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  📊 Normal grid: 0 items, Date grouped: 0 items
2025-08-13 17:26:47.874 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  ⚡ Switching to Date Grouped remote layout
2025-08-13 17:26:48.042 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === REMOTE PHOTO GRID DEBUG ===
2025-08-13 17:26:48.042 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Total count from ViewModel: 0
2025-08-13 17:26:48.042 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  CloudPhotos itemCount: 0
2025-08-13 17:26:48.042 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-13 17:26:48.042 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:26:48.042 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-13 17:26:48.042 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-13 17:26:48.042 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             W  CloudPhotos itemCount is 0!
2025-08-13 17:26:48.042 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === END REMOTE PHOTO GRID DEBUG ===
2025-08-13 17:26:48.072 28645-28645 RemoteViewModel         com.akslabs.cloudgallery             I  Total RemotePhoto records in database: 3
2025-08-13 17:26:48.072 28645-28645 RemoteViewModel         com.akslabs.cloudgallery             I  ✅ RemotePhoto records found:
2025-08-13 17:26:48.072 28645-28645 RemoteViewModel         com.akslabs.cloudgallery             D  RemotePhoto[0]: id=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE, type=png, fileName=42717895550690360893227045473287536868.png, size=2798186, uploadedAt=1755062249950, thumbnailCached=false
2025-08-13 17:26:48.072 28645-28645 RemoteViewModel         com.akslabs.cloudgallery             D  RemotePhoto[1]: id=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ, type=png, fileName=694000534657088556765825092497223751.png, size=257191, uploadedAt=1755062134620, thumbnailCached=false
2025-08-13 17:26:48.073 28645-28645 RemoteViewModel         com.akslabs.cloudgallery             D  RemotePhoto[2]: id=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ, type=png, fileName=42554030560734015792823288097017760953.png, size=1061745, uploadedAt=1755062087415, thumbnailCached=false
2025-08-13 17:26:48.073 28645-28645 RemoteViewModel         com.akslabs.cloudgallery             I  Testing PagingSource directly...
2025-08-13 17:26:48.073 28645-28645 RemoteViewModel         com.akslabs.cloudgallery             D  PagingSource created: null
2025-08-13 17:26:48.073 28645-28645 RemoteViewModel         com.akslabs.cloudgallery             I  Total count flow created: SafeFlow
2025-08-13 17:26:48.073 28645-28645 RemoteViewModel         com.akslabs.cloudgallery             I  === END COMPREHENSIVE DATABASE DEBUG ===
2025-08-13 17:26:48.073 28645-28645 RemoteViewModel         com.akslabs.cloudgallery             E  📊 Total count updated: 3
2025-08-13 17:26:48.079 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:26:48.099 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === REMOTE PHOTO GRID DEBUG ===
2025-08-13 17:26:48.099 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Total count from ViewModel: 3
2025-08-13 17:26:48.099 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  CloudPhotos itemCount: 0
2025-08-13 17:26:48.099 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-13 17:26:48.099 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:26:48.099 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-13 17:26:48.099 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-13 17:26:48.099 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             W  CloudPhotos itemCount is 0!
2025-08-13 17:26:48.099 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === END REMOTE PHOTO GRID DEBUG ===
2025-08-13 17:26:48.103 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:26:48.104 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  🚀 Creating remote layout cache for 3 photos
2025-08-13 17:26:48.104 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  🔍 Starting remote date grouping for 3 photos
2025-08-13 17:26:48.105 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  ✅ Remote date grouping complete: 3 processed, 0 skipped
2025-08-13 17:26:48.105 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  📅 Created 1 remote date groups
2025-08-13 17:26:48.106 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  ⚡ Remote layout cache created in 2ms
2025-08-13 17:26:48.106 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  📊 Normal grid: 3 items, Date grouped: 4 items
2025-08-13 17:26:48.106 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  ⚡ Switching to Date Grouped remote layout
2025-08-13 17:26:48.127 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:26:48.127 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:26:48.127 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:26:48.144 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Item[0] Creating ImageRequest for remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE
2025-08-13 17:26:48.144 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Item[0] ImageRequest created, starting SubcomposeAsyncImage
2025-08-13 17:26:48.148 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[0] Image loading STARTED for remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE
2025-08-13 17:26:48.155 28645-32241 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE, size: Size(width=150, height=150)
2025-08-13 17:26:48.158 28645-32241 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-08-13 17:26:48.158 28645-32241 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE
2025-08-13 17:26:48.158 28645-32241 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: png
2025-08-13 17:26:48.158 28645-32241 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 42717895550690360893227045473287536868.png
2025-08-13 17:26:48.158 28645-32241 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 2798186
2025-08-13 17:26:48.159 28645-32241 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-08-13 17:26:48.159 28645-32241 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE
2025-08-13 17:26:48.160 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Item[1] Creating ImageRequest for remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ
2025-08-13 17:26:48.160 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Item[1] ImageRequest created, starting SubcomposeAsyncImage
2025-08-13 17:26:48.163 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[1] Image loading STARTED for remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ
2025-08-13 17:26:48.164 28645-32111 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ, size: Size(width=150, height=150)
2025-08-13 17:26:48.164 28645-32111 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-08-13 17:26:48.164 28645-32111 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ
2025-08-13 17:26:48.164 28645-32111 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: png
2025-08-13 17:26:48.164 28645-32111 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 694000534657088556765825092497223751.png
2025-08-13 17:26:48.164 28645-32111 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 257191
2025-08-13 17:26:48.164 28645-32111 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-08-13 17:26:48.164 28645-32111 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ
2025-08-13 17:26:48.174 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Item[2] Creating ImageRequest for remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ
2025-08-13 17:26:48.174 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Item[2] ImageRequest created, starting SubcomposeAsyncImage
2025-08-13 17:26:48.177 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[2] Image loading STARTED for remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ
2025-08-13 17:26:48.178 28645-32240 NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ, size: Size(width=150, height=150)
2025-08-13 17:26:48.178 28645-32240 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-08-13 17:26:48.178 28645-32240 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ
2025-08-13 17:26:48.178 28645-32240 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: png
2025-08-13 17:26:48.178 28645-32240 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 42554030560734015792823288097017760953.png
2025-08-13 17:26:48.178 28645-32240 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 1061745
2025-08-13 17:26:48.178 28645-32240 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-08-13 17:26:48.178 28645-32240 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ
2025-08-13 17:26:48.198 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === REMOTE PHOTO GRID DEBUG ===
2025-08-13 17:26:48.198 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Total count from ViewModel: 3
2025-08-13 17:26:48.198 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  CloudPhotos itemCount: 3
2025-08-13 17:26:48.198 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:26:48.198 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=true)
2025-08-13 17:26:48.198 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:26:48.198 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-13 17:26:48.199 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Checking first 5 cloud photos with peek():
2025-08-13 17:26:48.199 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Photo[0] LOADED: remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE, type=png, fileName=42717895550690360893227045473287536868.png
2025-08-13 17:26:48.199 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Photo[1] LOADED: remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ, type=png, fileName=694000534657088556765825092497223751.png
2025-08-13 17:26:48.199 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Photo[2] LOADED: remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ, type=png, fileName=42554030560734015792823288097017760953.png
2025-08-13 17:26:48.199 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Snapshot list size: 3
2025-08-13 17:26:48.199 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Snapshot[0]: remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE
2025-08-13 17:26:48.199 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Snapshot[1]: remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ
2025-08-13 17:26:48.199 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Snapshot[2]: remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ
2025-08-13 17:26:48.199 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === END REMOTE PHOTO GRID DEBUG ===
2025-08-13 17:26:48.201 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === CLOUD PHOTO ITEM RENDER ===
2025-08-13 17:26:48.201 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Index: 0
2025-08-13 17:26:48.201 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[0] RENDERING with data: remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE, type=png, fileName=42717895550690360893227045473287536868.png
2025-08-13 17:26:48.202 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === CLOUD PHOTO ITEM RENDER ===
2025-08-13 17:26:48.202 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Index: 1
2025-08-13 17:26:48.202 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[1] RENDERING with data: remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ, type=png, fileName=694000534657088556765825092497223751.png
2025-08-13 17:26:48.202 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === CLOUD PHOTO ITEM RENDER ===
2025-08-13 17:26:48.202 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Index: 2
2025-08-13 17:26:48.202 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[2] RENDERING with data: remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ, type=png, fileName=42554030560734015792823288097017760953.png
2025-08-13 17:26:48.554 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:26:48.559 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:26:48.559 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:26:48.559 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:26:48.641 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:26:48.643 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:26:48.643 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:26:48.643 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:26:48.850 28645-32091 bs.cloudgallery         com.akslabs.cloudgallery             W  Cleared Reference was only reachable from finalizer (only reported once)
2025-08-13 17:26:50.632 28645-32111 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 ✅ SUCCESS: Downloaded 257191 bytes in 2468ms for remoteId: BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ
2025-08-13 17:26:50.633 28645-32111 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Detected MIME type: image/png
2025-08-13 17:26:50.633 28645-32111 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Created SourceResult for remoteId: BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ
2025-08-13 17:26:50.633 28645-32111 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER SUCCESS ===
2025-08-13 17:26:50.673 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[1] Image loading SUCCESS for remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ, dataSource=NETWORK
2025-08-13 17:26:52.557 28645-32240 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 ✅ SUCCESS: Downloaded 1061745 bytes in 4379ms for remoteId: BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ
2025-08-13 17:26:52.557 28645-32240 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Detected MIME type: image/png
2025-08-13 17:26:52.560 28645-32240 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Created SourceResult for remoteId: BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ
2025-08-13 17:26:52.560 28645-32240 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER SUCCESS ===
2025-08-13 17:26:52.623 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[2] Image loading SUCCESS for remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ, dataSource=NETWORK
2025-08-13 17:26:58.015 28645-32241 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 ✅ SUCCESS: Downloaded 2798186 bytes in 9856ms for remoteId: BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE
2025-08-13 17:26:58.015 28645-32241 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Detected MIME type: image/png
2025-08-13 17:26:58.020 28645-32241 NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Created SourceResult for remoteId: BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE
2025-08-13 17:26:58.020 28645-32241 NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER SUCCESS ===
2025-08-13 17:26:58.129 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[0] Image loading SUCCESS for remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE, dataSource=NETWORK
2025-08-13 17:27:01.074 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:01.077 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:01.077 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:01.077 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:27:01.099 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:01.101 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:01.101 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:01.101 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:27:01.121 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:01.123 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:01.123 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:01.123 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:27:05.699 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:05.701 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:05.701 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:05.701 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:27:05.739 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:05.745 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:27:05.749 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:05.749 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:05.749 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:27:06.860 28645-28645 Choreographer           com.akslabs.cloudgallery             I  Skipped 68 frames!  The application may be doing too much work on its main thread.
2025-08-13 17:27:06.869 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:27:06.869 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:27:06.869 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 352
2025-08-13 17:27:06.869 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:27:06.870 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:27:06.870 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:27:06.870 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:27:06.883 28645-32096 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1173ms; Flags=0, FrameTimelineVsyncId=9372254, IntendedVsync=16032714657226, Vsync=16032731323926, InputEventId=0, HandleInputStart=16032744688361, AnimationStart=16032744689611, PerformTraversalsStart=16032779834716, DrawStart=16032779941955, FrameDeadline=16032764655664, FrameInterval=16032744680966, FrameStartTime=16666823, SyncQueued=16033880546798, SyncStart=16033880761226, IssueDrawCommandsStart=16033881160288, SwapBuffers=16033882072632, FrameCompleted=16033888223101, DequeueBufferDuration=18855, QueueBufferDuration=245730, GpuCompleted=16033888223101, SwapBuffersCompleted=16033882630861, DisplayPresentTime=16023996986594, CommandSubmissionCompleted=16033882072632, 
2025-08-13 17:27:06.998 28645-32096 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1252ms; Flags=0, FrameTimelineVsyncId=9372273, IntendedVsync=16032747990626, Vsync=16033881326226, InputEventId=0, HandleInputStart=16033882573830, AnimationStart=16033882579663, PerformTraversalsStart=16033967988465, DrawStart=16033968140705, FrameDeadline=16033914668202, FrameInterval=16033881692580, FrameStartTime=16666823, SyncQueued=16033987350080, SyncStart=16033987421590, IssueDrawCommandsStart=16033987725080, SwapBuffers=16033989581330, FrameCompleted=16034000777684, DequeueBufferDuration=17813, QueueBufferDuration=331615, GpuCompleted=16034000777684, SwapBuffersCompleted=16033990334976, DisplayPresentTime=16024013651906, CommandSubmissionCompleted=16033989581330, 
2025-08-13 17:27:07.280 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:27:07.752 28645-32097 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=850ms; Flags=0, FrameTimelineVsyncId=9372894, IntendedVsync=16033911997780, Vsync=16034278668260, InputEventId=0, HandleInputStart=16034296570132, AnimationStart=16034296573100, PerformTraversalsStart=16034603180913, DrawStart=16034603278100, FrameDeadline=16034035994142, FrameInterval=16034295081017, FrameStartTime=16666840, SyncQueued=16034752738673, SyncStart=16034752830027, IssueDrawCommandsStart=16034753433361, SwapBuffers=16034754640340, FrameCompleted=16034762387006, DequeueBufferDuration=17709, QueueBufferDuration=278334, GpuCompleted=16034762387006, SwapBuffersCompleted=16034755193048, DisplayPresentTime=16024030323417, CommandSubmissionCompleted=16034754640340, 
2025-08-13 17:27:07.762 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:27:07.963 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:27:07.963 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:27:07.963 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 352
2025-08-13 17:27:07.963 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:27:07.963 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: Loading(endOfPaginationReached=false)
2025-08-13 17:27:07.963 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:27:07.963 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:27:08.104 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:27:08.313 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:27:08.313 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:27:08.313 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 384
2025-08-13 17:27:08.313 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:27:08.313 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: Loading(endOfPaginationReached=false)
2025-08-13 17:27:08.313 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:27:08.313 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:27:08.465 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:27:08.671 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:27:08.671 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:27:08.671 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 416
2025-08-13 17:27:08.671 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:27:08.671 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:27:08.671 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:27:08.671 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:27:09.532 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:27:09.737 28645-28645 WindowOnBackDispatcher  com.akslabs.cloudgallery             W  OnBackInvokedCallback is not enabled for the application.
                                                                                                    Set 'android:enableOnBackInvokedCallback="true"' in the application manifest.
2025-08-13 17:27:09.751 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:27:09.755 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:09.756 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  🚀 Creating remote layout cache for 3 photos
2025-08-13 17:27:09.756 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  🔍 Starting remote date grouping for 3 photos
2025-08-13 17:27:09.757 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  ✅ Remote date grouping complete: 3 processed, 0 skipped
2025-08-13 17:27:09.757 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  📅 Created 1 remote date groups
2025-08-13 17:27:09.758 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  ⚡ Remote layout cache created in 2ms
2025-08-13 17:27:09.758 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  📊 Normal grid: 3 items, Date grouped: 4 items
2025-08-13 17:27:09.758 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  ⚡ Switching to Date Grouped remote layout
2025-08-13 17:27:09.943 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:09.943 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:09.943 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:27:09.964 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Item[0] Creating ImageRequest for remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE
2025-08-13 17:27:09.964 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Item[0] ImageRequest created, starting SubcomposeAsyncImage
2025-08-13 17:27:09.967 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[0] Image loading STARTED for remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE
2025-08-13 17:27:09.968 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[0] Image loading SUCCESS for remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE, dataSource=MEMORY_CACHE
2025-08-13 17:27:09.979 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Item[1] Creating ImageRequest for remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ
2025-08-13 17:27:09.980 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Item[1] ImageRequest created, starting SubcomposeAsyncImage
2025-08-13 17:27:09.982 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[1] Image loading STARTED for remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ
2025-08-13 17:27:09.982 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[1] Image loading SUCCESS for remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ, dataSource=MEMORY_CACHE
2025-08-13 17:27:09.994 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Item[2] Creating ImageRequest for remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ
2025-08-13 17:27:09.994 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Item[2] ImageRequest created, starting SubcomposeAsyncImage
2025-08-13 17:27:09.997 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[2] Image loading STARTED for remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ
2025-08-13 17:27:09.997 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[2] Image loading SUCCESS for remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ, dataSource=MEMORY_CACHE
2025-08-13 17:27:10.034 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === REMOTE PHOTO GRID DEBUG ===
2025-08-13 17:27:10.034 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Total count from ViewModel: 3
2025-08-13 17:27:10.034 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  CloudPhotos itemCount: 3
2025-08-13 17:27:10.034 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:27:10.034 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=true)
2025-08-13 17:27:10.034 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:27:10.034 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-13 17:27:10.034 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Checking first 5 cloud photos with peek():
2025-08-13 17:27:10.034 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Photo[0] LOADED: remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE, type=png, fileName=42717895550690360893227045473287536868.png
2025-08-13 17:27:10.034 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Photo[1] LOADED: remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ, type=png, fileName=694000534657088556765825092497223751.png
2025-08-13 17:27:10.034 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Photo[2] LOADED: remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ, type=png, fileName=42554030560734015792823288097017760953.png
2025-08-13 17:27:10.034 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Snapshot list size: 3
2025-08-13 17:27:10.034 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Snapshot[0]: remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE
2025-08-13 17:27:10.035 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Snapshot[1]: remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ
2025-08-13 17:27:10.035 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Snapshot[2]: remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ
2025-08-13 17:27:10.035 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === END REMOTE PHOTO GRID DEBUG ===
2025-08-13 17:27:10.036 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === CLOUD PHOTO ITEM RENDER ===
2025-08-13 17:27:10.036 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Index: 0
2025-08-13 17:27:10.036 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[0] RENDERING with data: remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE, type=png, fileName=42717895550690360893227045473287536868.png
2025-08-13 17:27:10.036 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === CLOUD PHOTO ITEM RENDER ===
2025-08-13 17:27:10.036 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Index: 1
2025-08-13 17:27:10.037 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[1] RENDERING with data: remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ, type=png, fileName=694000534657088556765825092497223751.png
2025-08-13 17:27:10.037 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === CLOUD PHOTO ITEM RENDER ===
2025-08-13 17:27:10.037 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Index: 2
2025-08-13 17:27:10.037 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[2] RENDERING with data: remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ, type=png, fileName=42554030560734015792823288097017760953.png
2025-08-13 17:27:10.474 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:10.480 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:10.481 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:10.481 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:27:10.625 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:10.626 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:10.626 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:10.626 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:27:12.873 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:12.875 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:12.875 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:12.875 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:27:12.895 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:12.897 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:12.897 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:12.897 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:27:12.917 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:12.919 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:12.919 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:12.919 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:27:12.941 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:12.943 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:12.943 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:12.943 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:27:12.968 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:12.970 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:12.970 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:12.970 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:27:12.987 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:12.988 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:12.989 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:12.989 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:27:13.011 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:13.012 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:13.013 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:13.013 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:27:13.030 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:13.032 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:13.032 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:13.032 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:27:13.051 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:13.053 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:13.053 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:13.053 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:27:13.080 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:13.082 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:13.082 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:13.082 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:27:13.099 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:13.101 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:13.101 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:13.101 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:27:13.116 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:13.118 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:13.118 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:13.118 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:27:13.135 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:13.136 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:13.136 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:13.136 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:27:13.167 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:13.171 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:13.171 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:13.171 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:27:13.215 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:13.219 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:13.220 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:13.220 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:27:13.241 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:13.243 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:13.243 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:13.243 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:27:13.762 28645-28645 VRI[MainActivity]       com.akslabs.cloudgallery             D  visibilityChanged oldVisibility=true newVisibility=false
2025-08-13 17:27:45.476 28645-28645 WindowOnBackDispatcher  com.akslabs.cloudgallery             W  OnBackInvokedCallback is not enabled for the application.
                                                                                                    Set 'android:enableOnBackInvokedCallback="true"' in the application manifest.
2025-08-13 17:27:49.033 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:49.035 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:49.035 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:49.035 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:27:49.078 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:49.085 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:27:49.092 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:49.092 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:49.092 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:27:50.089 28645-32091 bs.cloudgallery         com.akslabs.cloudgallery             I  Background young concurrent copying GC freed 6003KB AllocSpace bytes, 22(440KB) LOS objects, 30% free, 11MB/17MB, paused 249us,232us total 158.667ms
2025-08-13 17:27:50.142 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:27:50.143 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:27:50.143 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 416
2025-08-13 17:27:50.143 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:27:50.143 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:27:50.143 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:27:50.143 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:27:50.149 28645-32096 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1078ms; Flags=0, FrameTimelineVsyncId=9402815, IntendedVsync=16076078666009, Vsync=16076078666009, InputEventId=0, HandleInputStart=16076094375376, AnimationStart=16076094377824, PerformTraversalsStart=16076123961001, DrawStart=16076124060845, FrameDeadline=16076169350941, FrameInterval=16076094366574, FrameStartTime=16666003, SyncQueued=16077150669751, SyncStart=16077150759751, IssueDrawCommandsStart=16077152150740, SwapBuffers=16077153841678, FrameCompleted=16077156970428, DequeueBufferDuration=29323, QueueBufferDuration=361615, GpuCompleted=16077156970428, SwapBuffersCompleted=16077154928188, DisplayPresentTime=16028330317842, CommandSubmissionCompleted=16077153841678, 
2025-08-13 17:27:50.163 28645-28645 Choreographer           com.akslabs.cloudgallery             I  Skipped 65 frames!  The application may be doing too much work on its main thread.
2025-08-13 17:27:50.298 28645-32096 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1206ms; Flags=0, FrameTimelineVsyncId=9402829, IntendedVsync=16076095332926, Vsync=16077178682531, InputEventId=0, HandleInputStart=16077186505428, AnimationStart=16077186510532, PerformTraversalsStart=16077253188605, DrawStart=16077253329959, FrameDeadline=16077183289536, FrameInterval=16077185484438, FrameStartTime=16666003, SyncQueued=16077290613761, SyncStart=16077290746261, IssueDrawCommandsStart=16077291155219, SwapBuffers=16077295902563, FrameCompleted=16077302160376, DequeueBufferDuration=18958, QueueBufferDuration=265938, GpuCompleted=16077302160376, SwapBuffersCompleted=16077296930480, DisplayPresentTime=16028346986228, CommandSubmissionCompleted=16077295902563, 
2025-08-13 17:27:50.321 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:27:51.128 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:27:51.573 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:27:51.573 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:27:51.574 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 448
2025-08-13 17:27:51.574 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:27:51.574 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: Loading(endOfPaginationReached=false)
2025-08-13 17:27:51.574 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:27:51.574 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:27:51.599 28645-32197 HWUI                    com.akslabs.cloudgallery             I  Davey! duration=774ms; Flags=0, FrameTimelineVsyncId=9403707, IntendedVsync=16077828651697, Vsync=16077978651376, InputEventId=0, HandleInputStart=16077984779646, AnimationStart=16077984782407, PerformTraversalsStart=16078406816781, DrawStart=16078406931052, FrameDeadline=16077849985029, FrameInterval=16077984432667, FrameStartTime=16666631, SyncQueued=16078593007615, SyncStart=16078593364906, IssueDrawCommandsStart=16078593918917, SwapBuffers=16078595534698, FrameCompleted=16078603774958, DequeueBufferDuration=17395, QueueBufferDuration=253073, GpuCompleted=16078603774958, SwapBuffersCompleted=16078596063448, DisplayPresentTime=16032663667164, CommandSubmissionCompleted=16078595534698, 
2025-08-13 17:27:51.746 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:27:51.969 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:27:51.969 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:27:51.969 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 480
2025-08-13 17:27:51.969 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:27:51.969 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:27:51.969 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:27:51.969 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:27:52.980 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:27:53.186 28645-28645 WindowOnBackDispatcher  com.akslabs.cloudgallery             W  OnBackInvokedCallback is not enabled for the application.
                                                                                                    Set 'android:enableOnBackInvokedCallback="true"' in the application manifest.
2025-08-13 17:27:53.199 28645-28645 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:27:53.204 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:53.205 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  🚀 Creating remote layout cache for 3 photos
2025-08-13 17:27:53.205 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  🔍 Starting remote date grouping for 3 photos
2025-08-13 17:27:53.206 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  ✅ Remote date grouping complete: 3 processed, 0 skipped
2025-08-13 17:27:53.206 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  📅 Created 1 remote date groups
2025-08-13 17:27:53.206 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  ⚡ Remote layout cache created in 1ms
2025-08-13 17:27:53.206 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  📊 Normal grid: 3 items, Date grouped: 4 items
2025-08-13 17:27:53.206 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  ⚡ Switching to Date Grouped remote layout
2025-08-13 17:27:53.399 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:53.399 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:53.399 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:27:53.415 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Item[0] Creating ImageRequest for remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE
2025-08-13 17:27:53.415 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Item[0] ImageRequest created, starting SubcomposeAsyncImage
2025-08-13 17:27:53.417 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[0] Image loading STARTED for remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE
2025-08-13 17:27:53.418 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[0] Image loading SUCCESS for remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE, dataSource=MEMORY_CACHE
2025-08-13 17:27:53.427 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Item[1] Creating ImageRequest for remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ
2025-08-13 17:27:53.427 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Item[1] ImageRequest created, starting SubcomposeAsyncImage
2025-08-13 17:27:53.430 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[1] Image loading STARTED for remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ
2025-08-13 17:27:53.430 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[1] Image loading SUCCESS for remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ, dataSource=MEMORY_CACHE
2025-08-13 17:27:53.439 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Item[2] Creating ImageRequest for remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ
2025-08-13 17:27:53.439 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Item[2] ImageRequest created, starting SubcomposeAsyncImage
2025-08-13 17:27:53.442 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[2] Image loading STARTED for remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ
2025-08-13 17:27:53.442 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[2] Image loading SUCCESS for remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ, dataSource=MEMORY_CACHE
2025-08-13 17:27:53.471 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === REMOTE PHOTO GRID DEBUG ===
2025-08-13 17:27:53.471 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Total count from ViewModel: 3
2025-08-13 17:27:53.471 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  CloudPhotos itemCount: 3
2025-08-13 17:27:53.471 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:27:53.471 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=true)
2025-08-13 17:27:53.471 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:27:53.471 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-13 17:27:53.471 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Checking first 5 cloud photos with peek():
2025-08-13 17:27:53.471 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Photo[0] LOADED: remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE, type=png, fileName=42717895550690360893227045473287536868.png
2025-08-13 17:27:53.471 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Photo[1] LOADED: remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ, type=png, fileName=694000534657088556765825092497223751.png
2025-08-13 17:27:53.471 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Photo[2] LOADED: remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ, type=png, fileName=42554030560734015792823288097017760953.png
2025-08-13 17:27:53.471 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Snapshot list size: 3
2025-08-13 17:27:53.471 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Snapshot[0]: remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE
2025-08-13 17:27:53.471 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Snapshot[1]: remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ
2025-08-13 17:27:53.471 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Snapshot[2]: remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ
2025-08-13 17:27:53.471 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === END REMOTE PHOTO GRID DEBUG ===
2025-08-13 17:27:53.473 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === CLOUD PHOTO ITEM RENDER ===
2025-08-13 17:27:53.473 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Index: 0
2025-08-13 17:27:53.473 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[0] RENDERING with data: remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE, type=png, fileName=42717895550690360893227045473287536868.png
2025-08-13 17:27:53.473 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === CLOUD PHOTO ITEM RENDER ===
2025-08-13 17:27:53.473 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Index: 1
2025-08-13 17:27:53.473 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[1] RENDERING with data: remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ, type=png, fileName=694000534657088556765825092497223751.png
2025-08-13 17:27:53.474 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === CLOUD PHOTO ITEM RENDER ===
2025-08-13 17:27:53.474 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Index: 2
2025-08-13 17:27:53.474 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[2] RENDERING with data: remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ, type=png, fileName=42554030560734015792823288097017760953.png
2025-08-13 17:27:53.928 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:53.932 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:53.932 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:53.932 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:27:54.008 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:27:54.010 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:27:54.010 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:27:54.010 28645-28645 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
---------------------------- PROCESS ENDED (28645) for package com.akslabs.cloudgallery ----------------------------
---------------------------- PROCESS STARTED (30864) for package com.akslabs.cloudgallery ----------------------------
2025-08-13 17:27:58.600 30864-30864 ApplicationLoaders      com.akslabs.cloudgallery             D  Returning zygote-cached class loader: /system_ext/framework/androidx.window.extensions.jar
2025-08-13 17:27:58.600 30864-30864 ApplicationLoaders      com.akslabs.cloudgallery             D  Returning zygote-cached class loader: /system_ext/framework/androidx.window.sidecar.jar
2025-08-13 17:27:58.620 30864-30864 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes12.dm': No such file or directory
2025-08-13 17:27:58.623 30864-30864 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes14.dm': No such file or directory
2025-08-13 17:27:58.625 30864-30864 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes6.dm': No such file or directory
2025-08-13 17:27:58.629 30864-30864 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes4.dm': No such file or directory
2025-08-13 17:27:58.631 30864-30864 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/data/com.akslabs.cloudgallery/code_cache/.overlay/base.apk/classes8.dm': No such file or directory
2025-08-13 17:27:58.635 30864-30864 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/app/~~H39HcsrPQN-FSXDcIRydeg==/com.akslabs.cloudgallery-RcHZ3qQgx4Iubj1z1Y82Gg==/base.dm': No such file or directory
2025-08-13 17:27:58.635 30864-30864 ziparchive              com.akslabs.cloudgallery             W  Unable to open '/data/app/~~H39HcsrPQN-FSXDcIRydeg==/com.akslabs.cloudgallery-RcHZ3qQgx4Iubj1z1Y82Gg==/base.dm': No such file or directory
2025-08-13 17:27:59.322 30864-30864 nativeloader            com.akslabs.cloudgallery             D  Configuring clns-7 for other apk /data/app/~~H39HcsrPQN-FSXDcIRydeg==/com.akslabs.cloudgallery-RcHZ3qQgx4Iubj1z1Y82Gg==/base.apk. target_sdk_version=34, uses_libraries=, library_path=/data/app/~~H39HcsrPQN-FSXDcIRydeg==/com.akslabs.cloudgallery-RcHZ3qQgx4Iubj1z1Y82Gg==/lib/arm64:/data/app/~~H39HcsrPQN-FSXDcIRydeg==/com.akslabs.cloudgallery-RcHZ3qQgx4Iubj1z1Y82Gg==/base.apk!/lib/arm64-v8a, permitted_path=/data:/mnt/expand:/data/user/0/com.akslabs.cloudgallery
2025-08-13 17:27:59.437 30864-30864 GraphicsEnvironment     com.akslabs.cloudgallery             V  Currently set values for:
2025-08-13 17:27:59.437 30864-30864 GraphicsEnvironment     com.akslabs.cloudgallery             V    angle_gl_driver_selection_pkgs=[com.android.angle, com.linecorp.b612.android, com.campmobile.snow, com.google.android.apps.tachyon]
2025-08-13 17:27:59.437 30864-30864 GraphicsEnvironment     com.akslabs.cloudgallery             V    angle_gl_driver_selection_values=[angle, native, native, native]
2025-08-13 17:27:59.437 30864-30864 GraphicsEnvironment     com.akslabs.cloudgallery             V  com.akslabs.cloudgallery is not listed in per-application setting
2025-08-13 17:27:59.437 30864-30864 GraphicsEnvironment     com.akslabs.cloudgallery             V  Neither updatable production driver nor prerelease driver is supported.
2025-08-13 17:27:59.464 30864-30864 WM-WrkMgrInitializer    com.akslabs.cloudgallery             D  Initializing WorkManager with default configuration.
2025-08-13 17:27:59.540 30864-30864 WM-PackageManagerHelper com.akslabs.cloudgallery             D  Skipping component enablement for androidx.work.impl.background.systemjob.SystemJobService
2025-08-13 17:27:59.540 30864-30864 WM-Schedulers           com.akslabs.cloudgallery             D  Created SystemJobScheduler and enabled SystemJobService
2025-08-13 17:27:59.847 30864-30864 EngineFactory           com.akslabs.cloudgallery             I  Provider GmsCore_OpenSSL not available
2025-08-13 17:27:59.864 30864-30864 ImageLoaderModule       com.akslabs.cloudgallery             I  === INITIALIZING IMAGE LOADERS ===
2025-08-13 17:28:00.011 30864-30864 ImageLoaderModule       com.akslabs.cloudgallery             D  Created OkHttpClient with 30s connect, 60s read/write timeouts
2025-08-13 17:28:00.011 30864-30864 ImageLoaderModule       com.akslabs.cloudgallery             D  Creating remoteImageLoader...
2025-08-13 17:28:00.014 30864-30864 ImageLoaderModule       com.akslabs.cloudgallery             I  remoteImageLoader created successfully
2025-08-13 17:28:00.014 30864-30864 ImageLoaderModule       com.akslabs.cloudgallery             D  Creating thumbnailImageLoader...
2025-08-13 17:28:00.014 30864-30864 ImageLoaderModule       com.akslabs.cloudgallery             I  thumbnailImageLoader created successfully
2025-08-13 17:28:00.014 30864-30864 ImageLoaderModule       com.akslabs.cloudgallery             I  === IMAGE LOADERS INITIALIZATION COMPLETE ===
2025-08-13 17:28:00.014 30864-30864 ImageLoaderModule       com.akslabs.cloudgallery             I  Available loaders:
2025-08-13 17:28:00.015 30864-30864 ImageLoaderModule       com.akslabs.cloudgallery             I  - defaultImageLoader: ✓
2025-08-13 17:28:00.015 30864-30864 ImageLoaderModule       com.akslabs.cloudgallery             I  - remoteImageLoader: ✓
2025-08-13 17:28:00.015 30864-30864 ImageLoaderModule       com.akslabs.cloudgallery             I  - thumbnailImageLoader: ✓
2025-08-13 17:28:00.133 30864-30864 Choreographer           com.akslabs.cloudgallery             I  Skipped 32 frames!  The application may be doing too much work on its main thread.
2025-08-13 17:28:00.231 30864-1811  DatabaseDebugHelper     com.akslabs.cloudgallery             I  === DATABASE DEBUG REPORT ===
2025-08-13 17:28:00.260 30864-1811  DatabaseDebugHelper     com.akslabs.cloudgallery             I  Database version: 4
2025-08-13 17:28:00.263 30864-30864 MainActivity            com.akslabs.cloudgallery             W  Invalid sync timestamp format, resetting to 0
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
2025-08-13 17:28:00.297 30864-1811  DatabaseDebugHelper     com.akslabs.cloudgallery             I  Record counts:
2025-08-13 17:28:00.297 30864-1811  DatabaseDebugHelper     com.akslabs.cloudgallery             I    Total photos: 951
2025-08-13 17:28:00.297 30864-1811  DatabaseDebugHelper     com.akslabs.cloudgallery             I    Photos with remoteId: 3
2025-08-13 17:28:00.297 30864-1811  DatabaseDebugHelper     com.akslabs.cloudgallery             I    Total remote photos: 3
2025-08-13 17:28:00.297 30864-1811  DatabaseDebugHelper     com.akslabs.cloudgallery             I  Sample uploaded photos:
2025-08-13 17:28:00.297 30864-1811  DatabaseDebugHelper     com.akslabs.cloudgallery             I    Photo: localId=1000009071, remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ, type=png
2025-08-13 17:28:00.297 30864-1811  DatabaseDebugHelper     com.akslabs.cloudgallery             I    Photo: localId=1000006476, remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ, type=png
2025-08-13 17:28:00.297 30864-1811  DatabaseDebugHelper     com.akslabs.cloudgallery             I    Photo: localId=1000006091, remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE, type=png
2025-08-13 17:28:00.297 30864-1811  DatabaseDebugHelper     com.akslabs.cloudgallery             I  Sample remote photos:
2025-08-13 17:28:00.297 30864-1811  DatabaseDebugHelper     com.akslabs.cloudgallery             I    RemotePhoto: remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE, type=png, fileName=42717895550690360893227045473287536868.png
2025-08-13 17:28:00.297 30864-1811  DatabaseDebugHelper     com.akslabs.cloudgallery             I    RemotePhoto: remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ, type=png, fileName=694000534657088556765825092497223751.png
2025-08-13 17:28:00.297 30864-1811  DatabaseDebugHelper     com.akslabs.cloudgallery             I    RemotePhoto: remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ, type=png, fileName=42554030560734015792823288097017760953.png
2025-08-13 17:28:00.297 30864-1811  DatabaseDebugHelper     com.akslabs.cloudgallery             I  === END DATABASE DEBUG REPORT ===
2025-08-13 17:28:00.302 30864-30864 DesktopModeFlagsUtil    com.akslabs.cloudgallery             D  Toggle override initialized to: OVERRIDE_UNSET
2025-08-13 17:28:00.681 30864-1777  bs.cloudgallery         com.akslabs.cloudgallery             I  Compiler allocated 4431KB to compile void android.view.ViewRootImpl.performTraversals()
2025-08-13 17:28:00.876 30864-30864 bs.cloudgallery         com.akslabs.cloudgallery             W  Method boolean androidx.compose.runtime.snapshots.SnapshotStateList.conditionalUpdate(boolean, kotlin.jvm.functions.Function1) failed lock verification and will run slower.
                                                                                                    Common causes for lock verification issues are non-optimized dex code
                                                                                                    and incorrect proguard optimizations.
2025-08-13 17:28:00.876 30864-30864 bs.cloudgallery         com.akslabs.cloudgallery             W  Method boolean androidx.compose.runtime.snapshots.SnapshotStateList.conditionalUpdate$default(androidx.compose.runtime.snapshots.SnapshotStateList, boolean, kotlin.jvm.functions.Function1, int, java.lang.Object) failed lock verification and will run slower.
2025-08-13 17:28:00.876 30864-30864 bs.cloudgallery         com.akslabs.cloudgallery             W  Method java.lang.Object androidx.compose.runtime.snapshots.SnapshotStateList.mutate(kotlin.jvm.functions.Function1) failed lock verification and will run slower.
2025-08-13 17:28:00.877 30864-30864 bs.cloudgallery         com.akslabs.cloudgallery             W  Method void androidx.compose.runtime.snapshots.SnapshotStateList.update(boolean, kotlin.jvm.functions.Function1) failed lock verification and will run slower.
2025-08-13 17:28:00.877 30864-30864 bs.cloudgallery         com.akslabs.cloudgallery             W  Method void androidx.compose.runtime.snapshots.SnapshotStateList.update$default(androidx.compose.runtime.snapshots.SnapshotStateList, boolean, kotlin.jvm.functions.Function1, int, java.lang.Object) failed lock verification and will run slower.
2025-08-13 17:28:01.462 30864-30864 LocalViewModel          com.akslabs.cloudgallery             E  🚀 === LOCAL VIEW MODEL INITIALIZED ===
2025-08-13 17:28:01.463 30864-30864 LocalViewModel          com.akslabs.cloudgallery             I  === LOCAL PHOTOS DATABASE DEBUG ===
2025-08-13 17:28:01.484 30864-30864 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-13 17:28:01.484 30864-30864 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 64, JumpThreshold: 160
2025-08-13 17:28:01.499 30864-30864 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-13 17:28:01.501 30864-30864 LocalViewModel          com.akslabs.cloudgallery             E  📊 Local photos count updated: 0
2025-08-13 17:28:01.517 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:28:01.607 30864-1808  AdrenoGLES-0            com.akslabs.cloudgallery             I  QUALCOMM build                   : 95db91f, Ifbc588260a
                                                                                                    Build Date                       : 09/24/20
                                                                                                    OpenGL ES Shader Compiler Version: EV031.32.02.01
                                                                                                    Local Branch                     : mybrancheafe5b6d-fb5b-f1b0-b904-5cb90179c3e0
                                                                                                    Remote Branch                    : quic/gfx-adreno.lnx.1.0.r114-rel
                                                                                                    Remote Branch                    : NONE
                                                                                                    Reconstruct Branch               : NOTHING
2025-08-13 17:28:01.607 30864-1808  AdrenoGLES-0            com.akslabs.cloudgallery             I  Build Config                     : S P 10.0.7 AArch64
2025-08-13 17:28:01.607 30864-1808  AdrenoGLES-0            com.akslabs.cloudgallery             I  Driver Path                      : /vendor/lib64/egl/libGLESv2_adreno.so
2025-08-13 17:28:01.622 30864-1808  AdrenoGLES-0            com.akslabs.cloudgallery             I  PFP: 0x016ee190, ME: 0x00000000
2025-08-13 17:28:01.683 30864-1841  Gralloc4                com.akslabs.cloudgallery             I  mapper 4.x is not supported
2025-08-13 17:28:01.687 30864-1841  Gralloc3                com.akslabs.cloudgallery             W  mapper 3.x is not supported
2025-08-13 17:28:01.693 30864-1841  Gralloc2                com.akslabs.cloudgallery             I  Adding additional valid usage bits: 0x8202000
2025-08-13 17:28:01.716 30864-1811  CloudPhotoSyncWorker    com.akslabs.cloudgallery             I  === CLOUD PHOTO SYNC WORKER STARTED ===
2025-08-13 17:28:01.736 30864-1817  WM-Processor            com.akslabs.cloudgallery             I  Moving WorkSpec (4d4032ee-7155-4f75-9931-e485a65f70b3) to the foreground
2025-08-13 17:28:01.742 30864-1839  HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1307ms; Flags=1, FrameTimelineVsyncId=9409417, IntendedVsync=16087428653176, Vsync=16087428653176, InputEventId=0, HandleInputStart=16087429475684, AnimationStart=16087429477976, PerformTraversalsStart=16087429479070, DrawStart=16088674055267, FrameDeadline=16087449986508, FrameInterval=16087429468653, FrameStartTime=16666647, SyncQueued=16088702986621, SyncStart=16088703330059, IssueDrawCommandsStart=16088704508600, SwapBuffers=16088733568184, FrameCompleted=16088736186621, DequeueBufferDuration=12160937, QueueBufferDuration=425990, GpuCompleted=16088736186621, SwapBuffersCompleted=16088735007403, DisplayPresentTime=8929200825491172685, CommandSubmissionCompleted=16088733568184, 
2025-08-13 17:28:01.757 30864-1811  CloudPhotoSyncService   com.akslabs.cloudgallery             I  === STARTING FULL CLOUD PHOTO SYNC ===
2025-08-13 17:28:01.762 30864-1815  CloudPhotoSyncService   com.akslabs.cloudgallery             D  Found configured group/channel ID: -1002651869724
2025-08-13 17:28:01.763 30864-1811  CloudPhotoSyncService   com.akslabs.cloudgallery             I  Syncing with channel ID: -1002651869724
2025-08-13 17:28:01.763 30864-1811  CloudPhotoSyncService   com.akslabs.cloudgallery             W  ⚠️  TELEGRAM BOT API LIMITATION:
2025-08-13 17:28:01.763 30864-1811  CloudPhotoSyncService   com.akslabs.cloudgallery             W  Bot API can only access messages from the last 24 hours
2025-08-13 17:28:01.763 30864-1811  CloudPhotoSyncService   com.akslabs.cloudgallery             W  Historical images older than 24 hours cannot be retrieved via Bot API
2025-08-13 17:28:01.763 30864-1811  CloudPhotoSyncService   com.akslabs.cloudgallery             W  This is a Telegram platform limitation, not an app bug
2025-08-13 17:28:01.764 30864-1811  CloudPhotoSyncService   com.akslabs.cloudgallery             D  Last sync: 0, Current: 1755086281764, Should sync: true
2025-08-13 17:28:01.770 30864-1815  CloudPhotoSyncService   com.akslabs.cloudgallery             I  Current database has 3 RemotePhoto records
2025-08-13 17:28:01.770 30864-1815  CloudPhotoSyncService   com.akslabs.cloudgallery             I  Performing incremental sync
2025-08-13 17:28:01.775 30864-1815  Historical...eDiscovery com.akslabs.cloudgallery             I  === STARTING HISTORICAL IMAGE DISCOVERY ===
2025-08-13 17:28:01.775 30864-1815  Historical...eDiscovery com.akslabs.cloudgallery             I  Channel ID: -1002651869724
2025-08-13 17:28:01.775 30864-1815  Historical...eDiscovery com.akslabs.cloudgallery             I  Config: ScanConfig(channelId=-1002651869724, batchSize=100, maxFiles=1000, includePhotos=true, includeDocuments=true, includeVideos=true)
2025-08-13 17:28:01.780 30864-1812  Historical...eDiscovery com.akslabs.cloudgallery             I  Found 3 existing RemotePhoto records
2025-08-13 17:28:01.781 30864-1812  Historical...eDiscovery com.akslabs.cloudgallery             D  Processing batch 1 (offset: null)
2025-08-13 17:28:01.792 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:28:01.792 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 0
2025-08-13 17:28:01.792 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 0
2025-08-13 17:28:01.792 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-13 17:28:01.792 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:28:01.792 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-13 17:28:01.792 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:28:01.800 30864-30864 LocalViewModel          com.akslabs.cloudgallery             E  ❌ Error collecting from localPhotosFlow
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@b88ccc6
2025-08-13 17:28:01.811 30864-30864 LocalViewModel          com.akslabs.cloudgallery             E  ❌ Error collecting from localPhotosCount
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@b88ccc6
2025-08-13 17:28:01.813 30864-1815  BotApi                  com.akslabs.cloudgallery             D  === SCANNING CHANNEL FOR MEDIA ===
2025-08-13 17:28:01.813 30864-1815  BotApi                  com.akslabs.cloudgallery             D  Channel ID: -1002651869724, Limit: 100, Offset: null
2025-08-13 17:28:01.839 30864-30864 Choreographer           com.akslabs.cloudgallery             I  Skipped 82 frames!  The application may be doing too much work on its main thread.
2025-08-13 17:28:01.949 30864-30864 LocalViewModel          com.akslabs.cloudgallery             E  ❌ Error debugging local database state
                                                                                                    kotlinx.coroutines.JobCancellationException: Job was cancelled; job=SupervisorJobImpl{Cancelling}@b88ccc6
2025-08-13 17:28:01.959 30864-30864 WM-SystemFgDispatcher   com.akslabs.cloudgallery             I  Started foreground service Intent { act=ACTION_START_FOREGROUND cmp=com.akslabs.cloudgallery/androidx.work.impl.foreground.SystemForegroundService (has extras) }
2025-08-13 17:28:01.964 30864-1785  HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1491ms; Flags=0, FrameTimelineVsyncId=9409461, IntendedVsync=16087481315857, Vsync=16088847977631, InputEventId=0, HandleInputStart=16088861712611, AnimationStart=16088861717559, PerformTraversalsStart=16088952961361, DrawStart=16088954569017, FrameDeadline=16088761984955, FrameInterval=16088861091257, FrameStartTime=16666607, SyncQueued=16088968275371, SyncStart=16088968751777, IssueDrawCommandsStart=16088968856986, SwapBuffers=16088970352507, FrameCompleted=16088972804277, DequeueBufferDuration=15625, QueueBufferDuration=302761, GpuCompleted=16088972804277, SwapBuffersCompleted=16088971337090, DisplayPresentTime=8169775882781153257, CommandSubmissionCompleted=16088970352507, 
2025-08-13 17:28:02.057 30864-30864 LocalViewModel          com.akslabs.cloudgallery             E  🚀 === LOCAL VIEW MODEL INITIALIZED ===
2025-08-13 17:28:02.058 30864-30864 LocalViewModel          com.akslabs.cloudgallery             I  === LOCAL PHOTOS DATABASE DEBUG ===
2025-08-13 17:28:02.065 30864-30864 LocalViewModel          com.akslabs.cloudgallery             D  === CREATING NEW LOCAL PAGING SOURCE ===
2025-08-13 17:28:02.065 30864-30864 LocalViewModel          com.akslabs.cloudgallery             D  PageSize: 32, PrefetchDistance: 64, JumpThreshold: 160
2025-08-13 17:28:02.069 30864-30864 LocalViewModel          com.akslabs.cloudgallery             E  📄 New PagingData received in LocalViewModel
2025-08-13 17:28:02.071 30864-30864 LocalViewModel          com.akslabs.cloudgallery             E  📊 Local photos count updated: 0
2025-08-13 17:28:02.076 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:28:02.165 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:28:02.165 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 0
2025-08-13 17:28:02.165 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 0
2025-08-13 17:28:02.165 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-13 17:28:02.165 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:28:02.165 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-13 17:28:02.165 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:28:02.221 30864-30864 LocalViewModel          com.akslabs.cloudgallery             E  📊 Local photos count updated: 951
2025-08-13 17:28:02.222 30864-30864 LocalViewModel          com.akslabs.cloudgallery             I  Total Photo records in database: 951
2025-08-13 17:28:02.222 30864-30864 LocalViewModel          com.akslabs.cloudgallery             I  ✅ Photo records found:
2025-08-13 17:28:02.222 30864-30864 LocalViewModel          com.akslabs.cloudgallery             D  Photo[0]: localId=1000009866, pathUri=content://media/external/images/media/1000009866, remoteId=null, photoType=png
2025-08-13 17:28:02.222 30864-30864 LocalViewModel          com.akslabs.cloudgallery             D  Photo[1]: localId=1000009865, pathUri=content://media/external/images/media/1000009865, remoteId=null, photoType=png
2025-08-13 17:28:02.222 30864-30864 LocalViewModel          com.akslabs.cloudgallery             D  Photo[2]: localId=1000009864, pathUri=content://media/external/images/media/1000009864, remoteId=null, photoType=png
2025-08-13 17:28:02.222 30864-30864 LocalViewModel          com.akslabs.cloudgallery             D  Photo[3]: localId=1000009863, pathUri=content://media/external/images/media/1000009863, remoteId=null, photoType=png
2025-08-13 17:28:02.222 30864-30864 LocalViewModel          com.akslabs.cloudgallery             D  Photo[4]: localId=1000009850, pathUri=content://media/external/images/media/1000009850, remoteId=null, photoType=png
2025-08-13 17:28:02.222 30864-30864 LocalViewModel          com.akslabs.cloudgallery             D  Photo[5]: localId=1000009844, pathUri=content://media/external/images/media/1000009844, remoteId=null, photoType=png
2025-08-13 17:28:02.222 30864-30864 LocalViewModel          com.akslabs.cloudgallery             D  Photo[6]: localId=1000009843, pathUri=content://media/external/images/media/1000009843, remoteId=null, photoType=png
2025-08-13 17:28:02.223 30864-30864 LocalViewModel          com.akslabs.cloudgallery             D  Photo[7]: localId=1000009842, pathUri=content://media/external/images/media/1000009842, remoteId=null, photoType=png
2025-08-13 17:28:02.223 30864-30864 LocalViewModel          com.akslabs.cloudgallery             D  Photo[8]: localId=1000009841, pathUri=content://media/external/images/media/1000009841, remoteId=null, photoType=png
2025-08-13 17:28:02.223 30864-30864 LocalViewModel          com.akslabs.cloudgallery             D  Photo[9]: localId=1000009768, pathUri=content://media/external/images/media/1000009768, remoteId=null, photoType=png
2025-08-13 17:28:02.223 30864-30864 LocalViewModel          com.akslabs.cloudgallery             D  ... and 941 more records
2025-08-13 17:28:02.223 30864-30864 LocalViewModel          com.akslabs.cloudgallery             I  Testing Local PagingSource directly...
2025-08-13 17:28:02.226 30864-30864 LocalViewModel          com.akslabs.cloudgallery             D  Local PagingSource created: null
2025-08-13 17:28:02.227 30864-30864 LocalViewModel          com.akslabs.cloudgallery             I  Local total count flow created: SafeFlow
2025-08-13 17:28:02.227 30864-30864 LocalViewModel          com.akslabs.cloudgallery             I  === END LOCAL PHOTOS DATABASE DEBUG ===
2025-08-13 17:28:02.254 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:28:02.298 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:28:02.298 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:28:02.298 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 0
2025-08-13 17:28:02.298 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-13 17:28:02.298 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:28:02.298 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-13 17:28:02.298 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:28:02.309 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:28:02.767 30864-1812  ContentValues           com.akslabs.cloudgallery             D  doWork: []
2025-08-13 17:28:02.767 30864-1812  Sync MediaStore         com.akslabs.cloudgallery             D  doWork: Success
2025-08-13 17:28:02.772 30864-1802  WM-WorkerWrapper        com.akslabs.cloudgallery             I  Worker result SUCCESS for Work [ id=7f34805a-b7b9-432d-92a0-2ea1e8fcc8c2, tags={ com.akslabs.cloudgallery.workers.SyncDbMediaStoreWorker } ]
2025-08-13 17:28:04.000 30864-1906  HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1743ms; Flags=0, FrameTimelineVsyncId=9410576, IntendedVsync=16089264658752, Vsync=16089314658822, InputEventId=0, HandleInputStart=16089324751777, AnimationStart=16089324754434, PerformTraversalsStart=16089405102819, DrawStart=16089405261100, FrameDeadline=16089331319863, FrameInterval=16089324740579, FrameStartTime=16666690, SyncQueued=16090995683912, SyncStart=16090995961412, IssueDrawCommandsStart=16090996234745, SwapBuffers=16090999181620, FrameCompleted=16091008812870, DequeueBufferDuration=17396, QueueBufferDuration=229531, GpuCompleted=16091008812870, SwapBuffersCompleted=16090999728652, DisplayPresentTime=3397062778697545190, CommandSubmissionCompleted=16090999181620, 
2025-08-13 17:28:04.011 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:28:04.011 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:28:04.011 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 96
2025-08-13 17:28:04.011 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:28:04.011 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:28:04.011 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:28:04.011 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:28:04.075 30864-30864 Choreographer           com.akslabs.cloudgallery             I  Skipped 105 frames!  The application may be doing too much work on its main thread.
2025-08-13 17:28:04.120 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:28:04.399 30864-1906  HWUI                    com.akslabs.cloudgallery             I  Davey! duration=2072ms; Flags=0, FrameTimelineVsyncId=9410643, IntendedVsync=16089331325606, Vsync=16091081325956, InputEventId=728661785, HandleInputStart=16091097755318, AnimationStart=16091097758131, PerformTraversalsStart=16091354764485, DrawStart=16091356041933, FrameDeadline=16091031327868, FrameInterval=16091097252037, FrameStartTime=16666670, SyncQueued=16091392992818, SyncStart=16091393103027, IssueDrawCommandsStart=16091393320527, SwapBuffers=16091395041933, FrameCompleted=16091404335318, DequeueBufferDuration=16719, QueueBufferDuration=278386, GpuCompleted=16091404335318, SwapBuffersCompleted=16091395600683, DisplayPresentTime=-50593791446094547, CommandSubmissionCompleted=16091395041933, 
2025-08-13 17:28:04.454 30864-30864 WindowOnBackDispatcher  com.akslabs.cloudgallery             W  OnBackInvokedCallback is not enabled for the application.
                                                                                                    Set 'android:enableOnBackInvokedCallback="true"' in the application manifest.
2025-08-13 17:28:04.457 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:28:04.457 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:28:04.457 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 96
2025-08-13 17:28:04.457 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:28:04.457 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: Loading(endOfPaginationReached=false)
2025-08-13 17:28:04.457 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:28:04.457 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:28:04.625 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:28:04.635 30864-30864 RemoteViewModel         com.akslabs.cloudgallery             E  🚀 === REMOTE VIEW MODEL INITIALIZED ===
2025-08-13 17:28:04.636 30864-30864 RemoteViewModel         com.akslabs.cloudgallery             I  === COMPREHENSIVE DATABASE DEBUG ===
2025-08-13 17:28:04.642 30864-30864 RemoteViewModel         com.akslabs.cloudgallery             D  === CREATING NEW PAGING SOURCE ===
2025-08-13 17:28:04.642 30864-30864 RemoteViewModel         com.akslabs.cloudgallery             D  PageSize: 24, PrefetchDistance: 72, JumpThreshold: 120
2025-08-13 17:28:04.642 30864-30864 RemoteViewModel         com.akslabs.cloudgallery             D  PagingSource created: null
2025-08-13 17:28:04.645 30864-30864 RemoteViewModel         com.akslabs.cloudgallery             E  📄 New PagingData received in ViewModel
2025-08-13 17:28:04.647 30864-30864 RemoteViewModel         com.akslabs.cloudgallery             E  📊 Total count updated: 0
2025-08-13 17:28:04.653 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:28:04.655 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  🚀 Creating remote layout cache for 0 photos
2025-08-13 17:28:04.655 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  🔍 Starting remote date grouping for 0 photos
2025-08-13 17:28:04.655 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  ✅ Remote date grouping complete: 0 processed, 0 skipped
2025-08-13 17:28:04.655 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  📅 Created 0 remote date groups
2025-08-13 17:28:04.656 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  ⚡ Remote layout cache created in 0ms
2025-08-13 17:28:04.656 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  📊 Normal grid: 0 items, Date grouped: 0 items
2025-08-13 17:28:04.656 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  ⚡ Switching to Date Grouped remote layout
2025-08-13 17:28:05.316 30864-1906  HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1218ms; Flags=0, FrameTimelineVsyncId=9411443, IntendedVsync=16091114648043, Vsync=16091597979124, InputEventId=0, HandleInputStart=16091608269381, AnimationStart=16091608272141, PerformTraversalsStart=16092146921412, DrawStart=16092147029797, FrameDeadline=16091447992690, FrameInterval=16091606916412, FrameStartTime=16666676, SyncQueued=16092322812922, SyncStart=16092323102870, IssueDrawCommandsStart=16092323450839, SwapBuffers=16092324535162, FrameCompleted=16092332999172, DequeueBufferDuration=16563, QueueBufferDuration=514479, GpuCompleted=16092332218964, SwapBuffersCompleted=16092332999172, DisplayPresentTime=-3661734457817742985, CommandSubmissionCompleted=16092324535162, 
2025-08-13 17:28:05.332 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:28:05.332 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:28:05.332 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 128
2025-08-13 17:28:05.332 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:28:05.332 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:28:05.332 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:28:05.332 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:28:05.335 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  === REMOTE PHOTO GRID DEBUG ===
2025-08-13 17:28:05.335 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  Total count from ViewModel: 0
2025-08-13 17:28:05.335 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  CloudPhotos itemCount: 0
2025-08-13 17:28:05.335 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-13 17:28:05.335 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:28:05.335 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-13 17:28:05.335 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-13 17:28:05.335 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             W  CloudPhotos itemCount is 0!
2025-08-13 17:28:05.335 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  === END REMOTE PHOTO GRID DEBUG ===
2025-08-13 17:28:05.353 30864-30864 Choreographer           com.akslabs.cloudgallery             I  Skipped 45 frames!  The application may be doing too much work on its main thread.
2025-08-13 17:28:05.476 30864-30864 RemoteViewModel         com.akslabs.cloudgallery             I  Total RemotePhoto records in database: 3
2025-08-13 17:28:05.476 30864-30864 RemoteViewModel         com.akslabs.cloudgallery             I  ✅ RemotePhoto records found:
2025-08-13 17:28:05.476 30864-30864 RemoteViewModel         com.akslabs.cloudgallery             D  RemotePhoto[0]: id=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE, type=png, fileName=42717895550690360893227045473287536868.png, size=2798186, uploadedAt=1755062249950, thumbnailCached=false
2025-08-13 17:28:05.476 30864-30864 RemoteViewModel         com.akslabs.cloudgallery             D  RemotePhoto[1]: id=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ, type=png, fileName=694000534657088556765825092497223751.png, size=257191, uploadedAt=1755062134620, thumbnailCached=false
2025-08-13 17:28:05.476 30864-30864 RemoteViewModel         com.akslabs.cloudgallery             D  RemotePhoto[2]: id=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ, type=png, fileName=42554030560734015792823288097017760953.png, size=1061745, uploadedAt=1755062087415, thumbnailCached=false
2025-08-13 17:28:05.476 30864-30864 RemoteViewModel         com.akslabs.cloudgallery             I  Testing PagingSource directly...
2025-08-13 17:28:05.477 30864-30864 RemoteViewModel         com.akslabs.cloudgallery             D  PagingSource created: null
2025-08-13 17:28:05.477 30864-30864 RemoteViewModel         com.akslabs.cloudgallery             I  Total count flow created: SafeFlow
2025-08-13 17:28:05.477 30864-30864 RemoteViewModel         com.akslabs.cloudgallery             I  === END COMPREHENSIVE DATABASE DEBUG ===
2025-08-13 17:28:05.477 30864-30864 RemoteViewModel         com.akslabs.cloudgallery             E  📊 Total count updated: 3
2025-08-13 17:28:05.499 30864-1906  HWUI                    com.akslabs.cloudgallery             I  Davey! duration=893ms; Flags=0, FrameTimelineVsyncId=9411682, IntendedVsync=16091611992025, Vsync=16092361993660, InputEventId=0, HandleInputStart=16092375834016, AnimationStart=16092375836620, PerformTraversalsStart=16092452506047, DrawStart=16092452608651, FrameDeadline=16092369312876, FrameInterval=16092375182037, FrameStartTime=16666703, SyncQueued=16092497227401, SyncStart=16092497499953, IssueDrawCommandsStart=16092497802505, SwapBuffers=16092498957818, FrameCompleted=16092505554901, DequeueBufferDuration=16928, QueueBufferDuration=302240, GpuCompleted=16092505554901, SwapBuffersCompleted=16092499556776, DisplayPresentTime=-6621054377111562680, CommandSubmissionCompleted=16092498957818, 
2025-08-13 17:28:05.503 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:28:05.706 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  === REMOTE PHOTO GRID DEBUG ===
2025-08-13 17:28:05.706 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  Total count from ViewModel: 3
2025-08-13 17:28:05.706 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  CloudPhotos itemCount: 0
2025-08-13 17:28:05.706 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  LoadState.refresh: Loading(endOfPaginationReached=false)
2025-08-13 17:28:05.706 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:28:05.706 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=false)
2025-08-13 17:28:05.706 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             I  REFRESH is currently LOADING
2025-08-13 17:28:05.706 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             W  CloudPhotos itemCount is 0!
2025-08-13 17:28:05.706 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  === END REMOTE PHOTO GRID DEBUG ===
2025-08-13 17:28:05.723 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:28:05.724 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  🚀 Creating remote layout cache for 3 photos
2025-08-13 17:28:05.724 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  🔍 Starting remote date grouping for 3 photos
2025-08-13 17:28:05.725 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  ✅ Remote date grouping complete: 3 processed, 0 skipped
2025-08-13 17:28:05.725 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  📅 Created 1 remote date groups
2025-08-13 17:28:05.726 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  ⚡ Remote layout cache created in 2ms
2025-08-13 17:28:05.726 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  📊 Normal grid: 3 items, Date grouped: 4 items
2025-08-13 17:28:05.726 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  ⚡ Switching to Date Grouped remote layout
2025-08-13 17:28:05.745 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:28:05.745 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:28:05.745 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:28:05.769 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  Item[0] Creating ImageRequest for remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE
2025-08-13 17:28:05.770 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  Item[0] ImageRequest created, starting SubcomposeAsyncImage
2025-08-13 17:28:05.774 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[0] Image loading STARTED for remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE
2025-08-13 17:28:05.780 30864-1878  NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE, size: Size(width=150, height=150)
2025-08-13 17:28:05.781 30864-1878  NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-08-13 17:28:05.781 30864-1878  NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE
2025-08-13 17:28:05.781 30864-1878  NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: png
2025-08-13 17:28:05.781 30864-1878  NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 42717895550690360893227045473287536868.png
2025-08-13 17:28:05.781 30864-1878  NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 2798186
2025-08-13 17:28:05.781 30864-1878  NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-08-13 17:28:05.781 30864-1878  NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE
2025-08-13 17:28:05.796 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  Item[1] Creating ImageRequest for remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ
2025-08-13 17:28:05.796 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  Item[1] ImageRequest created, starting SubcomposeAsyncImage
2025-08-13 17:28:05.800 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[1] Image loading STARTED for remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ
2025-08-13 17:28:05.801 30864-1877  NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ, size: Size(width=150, height=150)
2025-08-13 17:28:05.801 30864-1877  NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-08-13 17:28:05.801 30864-1877  NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ
2025-08-13 17:28:05.801 30864-1877  NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: png
2025-08-13 17:28:05.801 30864-1877  NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 694000534657088556765825092497223751.png
2025-08-13 17:28:05.801 30864-1877  NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 257191
2025-08-13 17:28:05.801 30864-1877  NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-08-13 17:28:05.801 30864-1877  NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ
2025-08-13 17:28:05.821 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  Item[2] Creating ImageRequest for remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ
2025-08-13 17:28:05.821 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  Item[2] ImageRequest created, starting SubcomposeAsyncImage
2025-08-13 17:28:05.825 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[2] Image loading STARTED for remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ
2025-08-13 17:28:05.826 30864-1875  NetworkFetcher          com.akslabs.cloudgallery             D  🏭 NetworkFetcher.Factory creating fetcher for remoteId: BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ, size: Size(width=150, height=150)
2025-08-13 17:28:05.826 30864-1875  NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER START ===
2025-08-13 17:28:05.826 30864-1875  NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Fetching image for remoteId: BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ
2025-08-13 17:28:05.826 30864-1875  NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo type: png
2025-08-13 17:28:05.826 30864-1875  NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileName: 42554030560734015792823288097017760953.png
2025-08-13 17:28:05.826 30864-1875  NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Photo fileSize: 1061745
2025-08-13 17:28:05.826 30864-1875  NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Request size: Size(width=150, height=150)
2025-08-13 17:28:05.826 30864-1875  NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Calling BotApi.getFile for remoteId: BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ
2025-08-13 17:28:05.860 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  === REMOTE PHOTO GRID DEBUG ===
2025-08-13 17:28:05.860 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  Total count from ViewModel: 3
2025-08-13 17:28:05.860 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  CloudPhotos itemCount: 3
2025-08-13 17:28:05.860 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:28:05.860 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=true)
2025-08-13 17:28:05.860 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:28:05.860 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             I  REFRESH completed successfully
2025-08-13 17:28:05.860 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             I  Checking first 5 cloud photos with peek():
2025-08-13 17:28:05.860 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  Photo[0] LOADED: remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE, type=png, fileName=42717895550690360893227045473287536868.png
2025-08-13 17:28:05.860 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  Photo[1] LOADED: remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ, type=png, fileName=694000534657088556765825092497223751.png
2025-08-13 17:28:05.860 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  Photo[2] LOADED: remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ, type=png, fileName=42554030560734015792823288097017760953.png
2025-08-13 17:28:05.860 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             I  Snapshot list size: 3
2025-08-13 17:28:05.861 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  Snapshot[0]: remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE
2025-08-13 17:28:05.861 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  Snapshot[1]: remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ
2025-08-13 17:28:05.861 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  Snapshot[2]: remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ
2025-08-13 17:28:05.861 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  === END REMOTE PHOTO GRID DEBUG ===
2025-08-13 17:28:05.864 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  === CLOUD PHOTO ITEM RENDER ===
2025-08-13 17:28:05.864 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  Index: 0
2025-08-13 17:28:05.864 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[0] RENDERING with data: remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE, type=png, fileName=42717895550690360893227045473287536868.png
2025-08-13 17:28:05.865 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  === CLOUD PHOTO ITEM RENDER ===
2025-08-13 17:28:05.865 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  Index: 1
2025-08-13 17:28:05.865 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[1] RENDERING with data: remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ, type=png, fileName=694000534657088556765825092497223751.png
2025-08-13 17:28:05.866 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  === CLOUD PHOTO ITEM RENDER ===
2025-08-13 17:28:05.866 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  Index: 2
2025-08-13 17:28:05.866 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[2] RENDERING with data: remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ, type=png, fileName=42554030560734015792823288097017760953.png
2025-08-13 17:28:05.994 30864-1911  ProfileInstaller        com.akslabs.cloudgallery             D  Installing profile for com.akslabs.cloudgallery
2025-08-13 17:28:08.321 30864-1779  bs.cloudgallery         com.akslabs.cloudgallery             I  Background concurrent copying GC freed 20MB AllocSpace bytes, 110(2476KB) LOS objects, 49% free, 8461KB/16MB, paused 131us,86us total 105.072ms
2025-08-13 17:28:10.547 30864-1878  NetworkFetcher          com.akslabs.cloudgallery             I  🌐 ✅ SUCCESS: Downloaded 2798186 bytes in 4766ms for remoteId: BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE
2025-08-13 17:28:10.547 30864-1878  NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Detected MIME type: image/png
2025-08-13 17:28:10.555 30864-1878  NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Created SourceResult for remoteId: BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE
2025-08-13 17:28:10.555 30864-1878  NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER SUCCESS ===
2025-08-13 17:28:10.653 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[0] Image loading SUCCESS for remoteId=BQACAgUAAyEGAASeEFIcAAIIxWicH-pfCpVe6p8dpwABw5mTf9TS-wAC7BYAAu0w4FQDDzOSkNDPZzYE, dataSource=NETWORK
2025-08-13 17:28:10.773 30864-1877  NetworkFetcher          com.akslabs.cloudgallery             I  🌐 ✅ SUCCESS: Downloaded 257191 bytes in 4971ms for remoteId: BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ
2025-08-13 17:28:10.773 30864-1877  NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Detected MIME type: image/png
2025-08-13 17:28:10.774 30864-1877  NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Created SourceResult for remoteId: BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ
2025-08-13 17:28:10.774 30864-1877  NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER SUCCESS ===
2025-08-13 17:28:10.816 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[1] Image loading SUCCESS for remoteId=BQACAgUAAyEGAASeEFIcAAIIxGicH3a3maSfIpEvi6hlMr5ZIZFuAALrFgAC7TDgVJkHP9_WFFxzNgQ, dataSource=NETWORK
2025-08-13 17:28:12.069 30864-1875  NetworkFetcher          com.akslabs.cloudgallery             I  🌐 ✅ SUCCESS: Downloaded 1061745 bytes in 6243ms for remoteId: BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ
2025-08-13 17:28:12.070 30864-1875  NetworkFetcher          com.akslabs.cloudgallery             D  🌐 Detected MIME type: image/png
2025-08-13 17:28:12.073 30864-1875  NetworkFetcher          com.akslabs.cloudgallery             I  🌐 Created SourceResult for remoteId: BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ
2025-08-13 17:28:12.073 30864-1875  NetworkFetcher          com.akslabs.cloudgallery             D  🌐 === NETWORK FETCHER SUCCESS ===
2025-08-13 17:28:12.132 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             I  Item[2] Image loading SUCCESS for remoteId=BQACAgUAAyEGAASeEFIcAAIIw2icH0dtSLbvL2_f5NkJfIflVxbEAALqFgAC7TDgVGFo9RNZQqV7NgQ, dataSource=NETWORK
2025-08-13 17:28:17.834 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:28:17.837 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:28:17.837 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:28:17.837 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:28:17.885 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             E  🎯 === REMOTE PHOTO GRID COMPOSING ===
2025-08-13 17:28:17.891 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:28:17.898 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  === OPTIMIZED REMOTE LAZY GRID ITEMS BLOCK ===
2025-08-13 17:28:17.898 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  Layout mode: Date Grouped
2025-08-13 17:28:17.898 30864-30864 RemotePhotoGrid         com.akslabs.cloudgallery             D  Rendering 4 items (Total photos in cache: 3)
2025-08-13 17:28:19.143 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:28:19.143 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:28:19.143 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 128
2025-08-13 17:28:19.143 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:28:19.143 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:28:19.144 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:28:19.144 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:28:19.150 30864-1839  HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1283ms; Flags=0, FrameTimelineVsyncId=9419944, IntendedVsync=16104881334813, Vsync=16104898001487, InputEventId=0, HandleInputStart=16104898453959, AnimationStart=16104898456511, PerformTraversalsStart=16104934844323, DrawStart=16104934935521, FrameDeadline=16104947998433, FrameInterval=16104898443542, FrameStartTime=16666210, SyncQueued=16106159964010, SyncStart=16106160275313, IssueDrawCommandsStart=16106160785260, SwapBuffers=16106161670208, FrameCompleted=16106164844167, DequeueBufferDuration=18177, QueueBufferDuration=315833, GpuCompleted=16106164844167, SwapBuffersCompleted=16106162416250, DisplayPresentTime=16097696987816, CommandSubmissionCompleted=16106161670208, 
2025-08-13 17:28:19.151 30864-30864 Choreographer           com.akslabs.cloudgallery             I  Skipped 75 frames!  The application may be doing too much work on its main thread.
2025-08-13 17:28:19.249 30864-1839  HWUI                    com.akslabs.cloudgallery             I  Davey! duration=1353ms; Flags=0, FrameTimelineVsyncId=9419973, IntendedVsync=16104911998215, Vsync=16106161997115, InputEventId=0, HandleInputStart=16106173769323, AnimationStart=16106173772917, PerformTraversalsStart=16106210681875, DrawStart=16106210768333, FrameDeadline=16106202632989, FrameInterval=16106173154167, FrameStartTime=16666210, SyncQueued=16106246004010, SyncStart=16106246083542, IssueDrawCommandsStart=16106246413542, SwapBuffers=16106251258750, FrameCompleted=16106265170156, DequeueBufferDuration=17500, QueueBufferDuration=268021, GpuCompleted=16106265170156, SwapBuffersCompleted=16106251788333, DisplayPresentTime=16097713655993, CommandSubmissionCompleted=16106251258750, 
2025-08-13 17:28:19.317 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:28:19.846 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:28:19.988 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:28:19.988 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:28:19.988 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 128
2025-08-13 17:28:19.988 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:28:19.988 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: Loading(endOfPaginationReached=false)
2025-08-13 17:28:19.988 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:28:19.988 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:28:20.068 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  🎯 LocalPhotoGrid composing
2025-08-13 17:28:20.239 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  === LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:28:20.239 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  Total count from ViewModel: 951
2025-08-13 17:28:20.239 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LocalPhotos itemCount: 160
2025-08-13 17:28:20.239 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.refresh: NotLoading(endOfPaginationReached=false)
2025-08-13 17:28:20.239 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.append: NotLoading(endOfPaginationReached=false)
2025-08-13 17:28:20.239 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  LoadState.prepend: NotLoading(endOfPaginationReached=true)
2025-08-13 17:28:20.239 30864-30864 LocalPhotoGrid          com.akslabs.cloudgallery             D  === END LOCAL PHOTO GRID DEBUG ===
2025-08-13 17:28:36.003 30864-1815  BotApi                  com.akslabs.cloudgallery             I  Received 0 updates from Telegram
2025-08-13 17:28:36.003 30864-1815  BotApi                  com.akslabs.cloudgallery             I  Scan complete: Found 0 media files
2025-08-13 17:28:36.004 30864-1815  Historical...eDiscovery com.akslabs.cloudgallery             D  Batch 1: Found 0 media files
2025-08-13 17:28:36.004 30864-1815  Historical...eDiscovery com.akslabs.cloudgallery             I  Batch 1: Processing 0 new files
2025-08-13 17:28:36.012 30864-1815  Historical...eDiscovery com.akslabs.cloudgallery             I  No more messages to scan
2025-08-13 17:28:36.012 30864-1815  Historical...eDiscovery com.akslabs.cloudgallery             I  No new images found to sync
2025-08-13 17:28:36.012 30864-1815  Historical...eDiscovery com.akslabs.cloudgallery             I  === HISTORICAL IMAGE DISCOVERY COMPLETE ===
2025-08-13 17:28:36.012 30864-1815  Historical...eDiscovery com.akslabs.cloudgallery             I  Total batches processed: 1
2025-08-13 17:28:36.012 30864-1815  Historical...eDiscovery com.akslabs.cloudgallery             I  Total new files discovered: 0
2025-08-13 17:28:36.013 30864-1815  CloudPhotoSyncService   com.akslabs.cloudgallery             D  Updated last sync timestamp to: 1755086316012
2025-08-13 17:28:36.013 30864-1815  CloudPhotoSyncService   com.akslabs.cloudgallery             I  === FULL CLOUD PHOTO SYNC COMPLETE ===
2025-08-13 17:28:36.013 30864-1815  CloudPhotoSyncWorker    com.akslabs.cloudgallery             I  Cloud photo sync completed successfully: 0 new files
2025-08-13 17:28:36.013 30864-1815  CloudPhotoSyncWorker    com.akslabs.cloudgallery             I  === CLOUD PHOTO SYNC WORKER FINISHED ===
2025-08-13 17:28:36.018 30864-1817  WM-WorkerWrapper        com.akslabs.cloudgallery             I  Worker result SUCCESS for Work [ id=4d4032ee-7155-4f75-9931-e485a65f70b3, tags={ com.akslabs.cloudgallery.workers.CloudPhotoSyncWorker } ]
2025-08-13 17:28:36.029 30864-30864 WM-SystemFgDispatcher   com.akslabs.cloudgallery             I  Stopping foreground service
