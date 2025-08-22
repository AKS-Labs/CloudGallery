@echo off
echo Setting up Java environment for Android build...

REM Common Java installation paths
set "JAVA_CANDIDATES=C:\Program Files\Java\jdk* C:\Program Files\Android\Android Studio\jre C:\Program Files\Android\Android Studio\jbr"

for %%i in (%JAVA_CANDIDATES%) do (
    if exist "%%i\bin\java.exe" (
        set "JAVA_HOME=%%i"
        echo Found Java at: %%i
        goto :found
    )
)

echo Java not found in common locations.
echo Please install Java or Android Studio first.
goto :end

:found
set "PATH=%JAVA_HOME%\bin;%PATH%"
echo JAVA_HOME set to: %JAVA_HOME%
echo.
echo Now you can run: gradlew assembleRelease
echo.

:end
pause