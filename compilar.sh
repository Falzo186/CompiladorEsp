#!/bin/bash
# Script de compilación para ANTLR4 - EspañolJava Lexer
# Requisitos: ANTLR4 instalado y disponible en PATH

echo "===================================================="
echo "Compilador EspañolJava - Generador de Lexer"
echo "===================================================="
echo ""

# Verificar si ANTLR4 está disponible
if ! command -v antlr4 &> /dev/null; then
    echo "ERROR: ANTLR4 no está instalado o no está en PATH"
    echo "Descárgalo desde: https://www.antlr.org/download/"
    echo ""
    echo "Instrucciones de instalación (macOS/Linux):"
    echo "  1. brew install antlr  (macOS con Homebrew)"
    echo "  2. O descargar manualmente desde https://www.antlr.org/download/"
    echo ""
    exit 1
fi

echo "[1/3] Limpiando archivos generados anteriormente..."
# Eliminar archivos generados
rm -f *Lexer.java *Parser.java *Visitor.java *BaseVisitor.java *.tokens
echo "  ✓ Archivos limpios"

echo ""
echo "[2/3] Generando código ANTLR4 desde MiLenguaje.g4..."
# Generar código desde la gramática
antlr4 -Dlanguage=Java -visitor -no-listener MiLenguaje.g4
if [ $? -eq 0 ]; then
    echo "  ✓ Gramática procesada exitosamente"
else
    echo "  ✗ ERROR en procesamiento de gramática"
    exit 1
fi

echo ""
echo "[3/3] Compilando código Java generado..."
# Compilar archivos Java
javac *.java
if [ $? -eq 0 ]; then
    echo "  ✓ Compilación completada exitosamente"
else
    echo "  ✗ ERROR en compilación de Java"
    exit 1
fi

echo ""
echo "===================================================="
echo "✓ Compilación completada exitosamente"
echo "===================================================="
echo ""
echo "Para probar el lexer, ejecute:"
echo "  grun MiLenguaje -tokens ejemplos/prueba_lexer.ej"
echo ""
