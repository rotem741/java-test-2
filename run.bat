@echo off
javac ordersystem\*.java
if %errorlevel% neq 0 (
    echo Compilation failed.
    pause
    exit /b %errorlevel%
)
java ordersystem.Main
pause