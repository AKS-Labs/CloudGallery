> Task :app:clean
> Task :app:preBuild UP-TO-DATE
> Task :app:preDebugBuild UP-TO-DATE
> Task :app:mergeDebugNativeDebugMetadata NO-SOURCE
> Task :app:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :app:generateDebugBuildConfig
> Task :app:generateDebugResValues
> Task :app:mapDebugSourceSetPaths
> Task :app:checkDebugAarMetadata
> Task :app:generateDebugResources
> Task :app:packageDebugResources
> Task :app:createDebugCompatibleScreenManifests
> Task :app:extractDeepLinksDebug
> Task :app:parseDebugLocalResources
> Task :app:mergeDebugResources
> Task :app:processDebugMainManifest
> Task :app:processDebugManifest
> Task :app:mergeDebugShaders
> Task :app:compileDebugShaders NO-SOURCE
> Task :app:generateDebugAssets UP-TO-DATE
> Task :app:javaPreCompileDebug
> Task :app:mergeDebugAssets
> Task :app:processDebugManifestForPackage
> Task :app:compressDebugAssets
> Task :app:desugarDebugFileDependencies
> Task :app:mergeDebugJniLibFolders
> Task :app:checkDebugDuplicateClasses
> Task :app:mergeDebugNativeLibs
> Task :app:mergeLibDexDebug
> Task :app:validateSigningDebug
> Task :app:writeDebugAppMetadata
> Task :app:writeDebugSigningConfigVersions
> Task :app:stripDebugDebugSymbols
warn: removing resource com.akslabs.cloudgallery:string/Chitralaya without required default value.
warn: removing resource com.akslabs.cloudgallery:string/download_Chitralaya without required default value.
warn: removing resource com.akslabs.cloudgallery:string/whitehole_auto_photos_backup_json without required default value.
warn: removing resource com.akslabs.cloudgallery:string/whitehole_photos_backup_json without required default value.

> Task :app:processDebugResources
> Task :app:mergeExtDexDebug
> Task :app:kaptGenerateStubsDebugKotlin
w: Experimental context receivers are superseded by context parameters.
Replace the '-Xcontext-receivers' compiler argument with '-Xcontext-parameters' and migrate to the new syntax.

See the context parameters proposal for more details: https://kotl.in/context-parameters
This warning will become an error in future releases.

> Task :app:kaptDebugKotlin
> Task :app:compileDebugKotlin
./gradlew : e: file:///C:/Users/ashin/StudioProjects/CloudGallery/a
pp/src/main/java/com/akslabs/chitralaya/ui/main/MainPage.kt:292:64 
@Composable invocations can only happen from the context of a 
@Composable function
At line:1 char:1
+ ./gradlew clean assembleDebug --console=plain 2>&1 | Out-File 
-FilePa ...
+ ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    + CategoryInfo          : NotSpecified: (e: file:///C:/U...osa 
   ble function:String) [], RemoteException
    + FullyQualifiedErrorId : NativeCommandError
 
e: file:///C:/Users/ashin/StudioProjects/CloudGallery/app/src/main/
java/com/akslabs/chitralaya/ui/main/MainPage.kt:299:63 Unresolved 
reference 'insert'.
e: file:///C:/Users/ashin/StudioProjects/CloudGallery/app/src/main/
java/com/akslabs/chitralaya/ui/main/MainPage.kt:317:64 @Composable 
invocations can only happen from the context of a @Composable 
function

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

BUILD FAILED in 2m 45s
32 actionable tasks: 32 executed
