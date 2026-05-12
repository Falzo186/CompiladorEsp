@echo off
setlocal enabledelayedexpansion
set ANTLR4_JAR=C:\Users\alexp\Downloads\antlr-4.13.2-complete.jar
set GRAMMAR=grammar\MiLenguaje.g4
set SRC_MAIN=src\main\java
set BUILD_DIR=build
set CLASSES_DIR=%BUILD_DIR%\classes
set GEN_DIR=%SRC_MAIN%\com\compilador\ej\gen
set EJT_DIR=%SRC_MAIN%\com\compilador\ej
set LEXER_DIR=%EJT_DIR%\lexer
set PARSER_DIR=%EJT_DIR%\parser

if "%1"=="clean" (
    if exist "%BUILD_DIR%" rmdir /s /q "%BUILD_DIR%"
    exit /b 0
)

if "%1"=="test" (
    java -cp "%CLASSES_DIR%;%ANTLR4_JAR%" com.compilador.ej.lexer.LexerMain resources\examples\caso1_basico.ej
    exit /b 0
)

echo Generando codigo ANTLR4...
if not exist "%GEN_DIR%" mkdir "%GEN_DIR%"
java -jar "%ANTLR4_JAR%" -Dlanguage=Java -visitor -no-listener -package com.compilador.ej.gen -Xexact-output-dir -o "%GEN_DIR%" "%GRAMMAR%"
if !ERRORLEVEL! neq 0 exit /b 1

echo Compilando codigo Java...
if not exist "%CLASSES_DIR%" mkdir "%CLASSES_DIR%"
javac -encoding UTF-8 -d "%CLASSES_DIR%" -cp "%ANTLR4_JAR%" "%EJT_DIR%\Main.java" "%LEXER_DIR%\LexerEJ.java" "%LEXER_DIR%\LexerMain.java" "%PARSER_DIR%\ParserTest.java" "%GEN_DIR%\MiLenguajeLexer.java" "%GEN_DIR%\MiLenguajeParser.java" "%GEN_DIR%\MiLenguajeVisitor.java" "%GEN_DIR%\MiLenguajeBaseVisitor.java"
if !ERRORLEVEL! neq 0 (echo Error en compilacion & exit /b 1)

echo.
echo OK - Compilacion completada
echo.
echo Ejecucion disponible:
echo   - Consola interactiva: java -cp "build\classes;%ANTLR4_JAR%" com.compilador.ej.Main
echo   - Lexer test:          compilar.bat test
echo   - Parser test:         java -cp "build\classes;%ANTLR4_JAR%" com.compilador.ej.parser.ParserTest recursos\examples\caso_parser_demo.ej
endlocal
