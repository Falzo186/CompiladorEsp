@echo off
setlocal enabledelayedexpansion
set ANTLR4_JAR=C:\antlr\antlr-4.13.0-complete.jar
set GRAMMAR=grammar\MiLenguaje.g4
set SRC_MAIN=src\main\java
set BUILD_DIR=build
set CLASSES_DIR=%BUILD_DIR%\classes
set GEN_DIR=%SRC_MAIN%\com\compilador\ej\gen
set LEXER_DIR=%SRC_MAIN%\com\compilador\ej\lexer
set PARSER_DIR=%SRC_MAIN%\com\compilador\ej\parser

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
antlr4 -Dlanguage=Java -visitor -no-listener -package com.compilador.ej.gen -Xexact-output-dir -o "%GEN_DIR%" "%GRAMMAR%"
if !ERRORLEVEL! neq 0 exit /b 1

echo Compilando codigo Java...
if not exist "%CLASSES_DIR%" mkdir "%CLASSES_DIR%"
javac -encoding UTF-8 -d "%CLASSES_DIR%" -cp "%ANTLR4_JAR%" "%LEXER_DIR%\LexerEJ.java" "%LEXER_DIR%\LexerMain.java" "%PARSER_DIR%\ParserTest.java" "%GEN_DIR%\MiLenguajeLexer.java" "%GEN_DIR%\MiLenguajeParser.java" "%GEN_DIR%\MiLenguajeVisitor.java" "%GEN_DIR%\MiLenguajeBaseVisitor.java"
if !ERRORLEVEL! neq 0 (echo Error en compilacion & exit /b 1)

echo.
echo OK - Compilacion completada
echo Prueba: compilar.bat test
echo Prueba parser: java -cp "build\classes;%ANTLR4_JAR%" com.compilador.ej.parser.ParserTest resources\examples\caso_parser_demo.ej
endlocal
