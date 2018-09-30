@echo OFF
setlocal EnableDelayedExpansion
SET op= %1
SET file = %2
SET propFile=%3
 
FOR /F "tokens=1,2 delims==" %%G IN (%propFile%) DO (set %%G=%%H) 
echo "Properties set" > %LogFileLoc%\logs.txt 
if %op% == delete ( del "\\%ORAHost%\%SharedWorkspaceLoc%\includes\%2"   >> %LogFileLoc%\logs.txt) 
if %op% == add ( copy "%includesFolder%\%2" "\\%ORAHost%\%SharedWorkspaceLoc%\includes" >> %LogFileLoc%\logs.txt )
if %op% == modify (
del "\\%ORAHost%\%SharedWorkspaceLoc%\includes\%2" > %LogFileLoc%\logs.txt
echo "\\%ORAHost%\%SharedWorkspaceLoc%\includes\%2" deleted from destiNation >> %LogFileLoc%\logs.txt  
copy "%includesFolder%\%2" "\\%ORAHost%\%SharedWorkspaceLoc%\includes" >> %LogFileLoc%\logs.txt 
echo "%includesFolder%\%2" copied in destination >> %LogFileLoc%\logs.txt
)
if not errorlevel 1 (echo "\\%ORAHost%\%SharedWorkspaceLoc%\includes\%2 File operation %op% success" >> %LogFileLoc%\logs.txt ) else (echo "\\%ORAHost%\%SharedWorkspaceLoc%\includes\%2 File operation %op% not success"  >> %LogFileLoc%\logs.txt && exit )
type nul > "\\%ORAHost%\%SharedWorkspaceLoc%\%CompileMonitorFile%"
Compile.bat
exit

