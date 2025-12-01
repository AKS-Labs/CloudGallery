> Task :app:preBuild UP-TO-DATE
> Task :app:preDebugBuild UP-TO-DATE
> Task :app:mergeDebugNativeDebugMetadata NO-SOURCE
> Task :app:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :app:generateDebugBuildConfig UP-TO-DATE
> Task :app:checkDebugAarMetadata UP-TO-DATE
> Task :app:generateDebugResValues UP-TO-DATE
> Task :app:mapDebugSourceSetPaths UP-TO-DATE
> Task :app:generateDebugResources UP-TO-DATE
> Task :app:mergeDebugResources UP-TO-DATE
> Task :app:packageDebugResources UP-TO-DATE
> Task :app:parseDebugLocalResources UP-TO-DATE
> Task :app:createDebugCompatibleScreenManifests UP-TO-DATE
> Task :app:extractDeepLinksDebug UP-TO-DATE
> Task :app:processDebugMainManifest UP-TO-DATE
> Task :app:processDebugManifest UP-TO-DATE
> Task :app:processDebugManifestForPackage UP-TO-DATE
> Task :app:processDebugResources UP-TO-DATE
> Task :app:kaptGenerateStubsDebugKotlin UP-TO-DATE
> Task :app:kaptDebugKotlin UP-TO-DATE
> Task :app:javaPreCompileDebug UP-TO-DATE
> Task :app:mergeDebugShaders UP-TO-DATE
> Task :app:compileDebugShaders NO-SOURCE
> Task :app:generateDebugAssets UP-TO-DATE
> Task :app:mergeDebugAssets UP-TO-DATE
> Task :app:compressDebugAssets UP-TO-DATE
> Task :app:checkDebugDuplicateClasses UP-TO-DATE
> Task :app:desugarDebugFileDependencies UP-TO-DATE
> Task :app:mergeExtDexDebug UP-TO-DATE
> Task :app:mergeLibDexDebug UP-TO-DATE
> Task :app:mergeDebugJniLibFolders UP-TO-DATE
> Task :app:mergeDebugNativeLibs UP-TO-DATE
> Task :app:stripDebugDebugSymbols UP-TO-DATE
> Task :app:validateSigningDebug UP-TO-DATE
> Task :app:writeDebugAppMetadata UP-TO-DATE
> Task :app:writeDebugSigningConfigVersions UP-TO-DATE
> Task :app:compileDebugKotlin
./gradlew : e: file:///C:/Users/ashin/StudioProjects/CloudGallery/a
pp/src/main/java/com/akslabs/chitralaya/ui/main/MainPage.kt:298:63 
Unresolved reference 'insert'.
At line:1 char:1
+ ./gradlew assembleDebug 2>&1 | Out-File -FilePath builderrors.md 
-Enc ...
+ ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    + CategoryInfo          : NotSpecified: (e: file:///C:/U...ren 
   ce 'insert'.:String) [], RemoteException
    + FullyQualifiedErrorId : NativeCommandError
 
e: file:///C:/Users/ashin/StudioProjects/CloudGallery/app/src/main/
java/com/akslabs/chitralaya/ui/main/MainPage.kt:310:49 Function 
invocation 'context(...)' expected.
e: file:///C:/Users/ashin/StudioProjects/CloudGallery/app/src/main/
java/com/akslabs/chitralaya/ui/main/MainPage.kt:322:49 Function 
invocation 'context(...)' expected.
e: file:///C:/Users/ashin/StudioProjects/CloudGallery/app/src/main/
java/com/akslabs/chitralaya/ui/main/MainPage.kt:722:10 Syntax 
error: Unexpected tokens (use ';' to separate expressions on the 
same line).
e: file:///C:/Users/ashin/StudioProjects/CloudGallery/app/src/main/
java/com/akslabs/chitralaya/ui/main/MainPage.kt:723:9 Unresolved 
reference 'navigationIcon'.
e: file:///C:/Users/ashin/StudioProjects/CloudGallery/app/src/main/
java/com/akslabs/chitralaya/ui/main/MainPage.kt:723:28 Syntax 
error: Unexpected tokens (use ';' to separate expressions on the 
same line).
e: file:///C:/Users/ashin/StudioProjects/CloudGallery/app/src/main/
java/com/akslabs/chitralaya/ui/main/MainPage.kt:724:9 Unresolved 
reference 'colors'.
e: file:///C:/Users/ashin/StudioProjects/CloudGallery/app/src/main/
java/com/akslabs/chitralaya/ui/main/MainPage.kt:724:36 @Composable 
invocations can only happen from the context of a @Composable 
function
e: file:///C:/Users/ashin/StudioProjects/CloudGallery/app/src/main/
java/com/akslabs/chitralaya/ui/main/MainPage.kt:725:44 @Composable 
invocations can only happen from the context of a @Composable 
function
e: file:///C:/Users/ashin/StudioProjects/CloudGallery/app/src/main/
java/com/akslabs/chitralaya/ui/main/MainPage.kt:727:5 Syntax 
error: Expecting an element.
e: file:///C:/Users/ashin/StudioProjects/CloudGallery/app/src/main/
java/com/akslabs/chitralaya/ui/main/MainPage.kt:728:2 Syntax 
error: Expecting '}'.

> Task :app:compileDebugKotlin FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':app:compileDebugKotlin'.
> A failure occurred while executing org.jetbrains.kotlin.compilerR
unner.GradleCompilerRunnerWithWorkers$GradleKotlinCompilerWorkActio
n
   > Compilation error. See log for more details

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.
> Get more help at https://help.gradle.org.

BUILD FAILED in 57s
31 actionable tasks: 1 executed, 30 up-to-date
