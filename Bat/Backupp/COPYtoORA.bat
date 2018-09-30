echo on
title stoOra
FOR /F "tokens=1,2 delims==" %%G IN (C:\temp\ConverterConfig.properties) DO (set %%G=%%H) 
echo "\\%LocalHost%\%SharedLoc%\%CompileLogFile%" >> C:\temp\log.txt
del "\\%LocalHost%\%SharedLoc%\%CompileLogFile%"
msdev "%ServerWorkspaceLoc%\dbScripts.dsp" /MAKE "dbScripts - Win32 Debug" /REBUILD
copy "%ServerWorkspaceLoc%\%sFileInWorkspace%.ora" "\\%LocalHost%\%SharedLoc%\%ORAFile%" /Y
copy "%ServerWorkspaceLoc%\dbScripts.plg" "\\%LocalHost%\%SharedLoc%\%CompileLogFile%" /Y
echo file copied >> \\%LocalHost%\%SharedLoc%\%CompileLogFile%


