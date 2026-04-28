@echo off
REM Script de compilación para ANTLR4 - EspañolJava Lexer
REM Requisitos: ANTLR4 instalado y disponible en PATH

echo ====================================================
echo Compilador EspañolJava - Generador de Lexer
echo ====================================================

REM Verificar si ANTLR4 está disponible
where antlr4 >nul 2>nul
if %errorlevel% neq 0 (
    echo ERROR: ANTLR4 no está instalado o no está en PATH
    echo Descárgalo desde: https://www.antlr.org/download/antlr-4.13.0-complete.jar
    echo.
    echo Instrucciones de instalación:
    echo 1. Descargar: https://www.antlr.org/download/
    echo 2. Guardar en: C:\antlr
    echo 3. Agregar a PATH o ejecutar directamente
    pause
    exit /b 1
)

echo.
echo [1/3] Limpiando archivos generados anteriormente...
REM Eliminar archivos generados
for %%f in (*Lexer.java *Parser.java *Visitor.java *BaseVisitor.java *.tokens) do (
    if exist "%%f" (
        del "%%f"
        echo   - Eliminado: %%f
    )
)

echo.
echo [2/3] Generando código ANTLR4 desde MiLenguaje.g4...
REM Generar código desde la gramática
antlr4 -Dlanguage=Java -visitor -no-listener MiLenguaje.g4
if %errorlevel% equ 0 (
    echo   ✓ Gramática procesada exitosamente
) else (
    echo   ✗ ERROR en procesamiento de gramática
    pause
    exit /b 1
)

echo.
echo [3/3] Compilando código Java generado...
REM Compilar archivos Java
javac *.java
if %errorlevel% equ 0 (
    echo   ✓ Compilación completada exitosamente
) else (
    echo   ✗ ERROR en compilación de Java
    pause
    exit /b 1
)

echo.
echo ====================================================
echo ✓ Compilación completada exitosamente
echo ====================================================
echo.
echo Para probar el lexer, ejecute:
echo   grun MiLenguaje -tokens ejemplos/prueba_lexer.ej
echo.
pause
