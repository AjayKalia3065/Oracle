@echo OFF
title stoOra
set propFile=%1
FOR /F "tokens=1,2 delims==" %%G IN (%propFile%) DO (set %%G=%%H) 
echo "Checking if Host %ORAHost% is reachable.." > %LogFileLoc%\logs.txt
ping -n 1 %ORAHost% | find "Reply" > NUL
if not errorlevel 1 (echo "%ORAHost% is reachable" >> %LogFileLoc%\logs.txt ) else ( echo "%ORAHost% is not reachable" >> %LogFileLoc%\logs.txt && exit )
echo "File copying %ClientMonitorFile% %SharedWorkspaceLoc% %sFileInWorkspace%.s" >> %LogFileLoc%\logs.txt
copy %ClientMonitorFile% "\\%ORAHost%\%SharedWorkspaceLoc%\%sFileInWorkspace%.s" /Y
if %errorlevel% == 0 (
type nul > "\\%ORAHost%\%SharedWorkspaceLoc%\%CompileMonitorFile%"
echo "%ClientMonitorFile% copied to %ORAHost%\%SharedWorkspaceLoc%" >> %LogFileLoc%\logs.txt
) else (
echo "%ClientMonitorFile% coping failed. Check if "\\%ORAHost%\%SharedWorkspaceLoc%" folder is directly accessible or not from local computer" >> %LogFileLoc%\logs.txt && EXIT
 )
Compile.bat
exit


