@ECHO OFF
title Compile
del "\\%LocalHost%\%SharedLoc%\%CompileLogFile%"
echo "Local log files deleted" >> %LogFileLoc%\logs.txt
Wmic /node:%ORAHost% /user:%User% /password:%Password% process call create "cmd.exe /c msdev \"%ServerWorkspaceLoc%/%DSPFile%.dsp\" /MAKE \"%DSPFile% - Win32 Debug\" /REBUILD" >> %LogFileLoc%\logs.txt
if not errorlevel 1 (echo "Wmic executed successfully" >> %LogFileLoc%\logs.txt ) else ( echo "Wmic not executed successfully" >> %LogFileLoc%\logs.txt && exit )
find /c " 0 error" "\\%ORAHost%\%SharedWorkspaceLoc%\dbScripts.plg" > nul
if %errorlevel% == 0 ( 
copy "\\%ORAHost%\%SharedWorkspaceLoc%\%sFileInWorkspace%.ora" "\\%LocalHost%\%SharedLoc%\%ORAFile%" /Y
echo "Compiled ORA file copied" >> %LogFileLoc%\logs.txt
) else (
echo "File compilation failed. Check logs or compile file manually on server" >> %LogFileLoc%\logs.txt
)
( timeout /t 5 || >nul ping -n 3 localhost ) 2> nul 
copy "\\%ORAHost%\%SharedWorkspaceLoc%\%DSPFile%.plg" "\\%LocalHost%\%SharedLoc%\%CompileLogFile%" 
echo "Compilation log file copied" >> %LogFileLoc%\logs.txt
exit