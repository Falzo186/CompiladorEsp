#!/bin/bash
# =========================================================
# CompiladorEsp - Script de Compilación para Linux/Mac
# =========================================================
# Este script compila el proyecto desde la estructura limpia
# Uso: ./compilar.sh [clean|build|test|all]
# =========================================================

set -e

# Configuración
PROYECTO="CompiladorEsp"
VERSION="1.0.0"
ANTLR4_JAR="/usr/local/lib/antlr-4.13.0-complete.jar"
GRAMMAR="grammar/MiLenguaje.g4"
SRC_MAIN="src/main/java"
BUILD_DIR="build"
CLASSES_DIR="$BUILD_DIR/classes"
GEN_DIR="$SRC_MAIN/com/compilador/ej/gen"

# Colores para salida
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

echo ""
echo "╔═══════════════════════════════════════════════════════╗"
echo "║  $PROYECTO v$VERSION - Compilación Linux/Mac        ║"
echo "╚═══════════════════════════════════════════════════════╝"
echo ""

# Verificar ANTLR4
if [ ! -f "$ANTLR4_JAR" ]; then
    echo -e "${RED}❌ Error: ANTLR4 no encontrado en $ANTLR4_JAR${NC}"
    echo "Descarga desde: https://www.antlr.org/download/"
    exit 1
fi

# Función: Limpiar
clean() {
    echo -e "${BLUE}📁 Limpiando directorio de build...${NC}"
    if [ -d "$BUILD_DIR" ]; then
        rm -rf "$BUILD_DIR"
        echo -e "${GREEN}✓ Directorio limpio${NC}"
    else
        echo -e "${YELLOW}ℹ️  Nada que limpiar${NC}"
    fi
}

# Función: Generar
generate() {
    echo ""
    echo -e "${BLUE}🔄 Generando código ANTLR4...${NC}"
    mkdir -p "$GEN_DIR"
    
    if [ ! -f "$GRAMMAR" ]; then
        echo -e "${RED}❌ Error: Gramática no encontrada: $GRAMMAR${NC}"
        exit 1
    fi
    
    antlr4 -Dlanguage=Java -visitor -no-listener -o "$GEN_DIR" "$GRAMMAR"
    if [ $? -ne 0 ]; then
        echo -e "${RED}❌ Error en generación ANTLR4${NC}"
        exit 1
    fi
    echo -e "${GREEN}✓ Código generado en $GEN_DIR${NC}"
}

# Función: Compilar
compile() {
    echo ""
    echo -e "${BLUE}🔨 Compilando código Java...${NC}"
    mkdir -p "$CLASSES_DIR"
    
    javac -d "$CLASSES_DIR" \
          -cp "$ANTLR4_JAR:$GEN_DIR" \
          -encoding UTF-8 \
          -source 11 -target 11 \
          "$SRC_MAIN"/com/compilador/ej/lexer/*.java \
          "$GEN_DIR"/*.java
    
    if [ $? -ne 0 ]; then
        echo -e "${RED}❌ Error en compilación Java${NC}"
        exit 1
    fi
    echo -e "${GREEN}✓ Compilación completada en $CLASSES_DIR${NC}"
}

# Función: Probar
test_project() {
    echo ""
    echo -e "${BLUE}🧪 Ejecutando pruebas...${NC}"
    
    if [ ! -d "$CLASSES_DIR" ]; then
        echo -e "${RED}❌ Error: Clases no compiladas. Ejecuta './compilar.sh build' primero${NC}"
        exit 1
    fi
    
    ARCHIVO_PRUEBA="resources/examples/caso1_basico.ej"
    if [ ! -f "$ARCHIVO_PRUEBA" ]; then
        echo -e "${RED}❌ Error: Archivo de prueba no encontrado${NC}"
        exit 1
    fi
    
    echo ""
    echo "Archivo de prueba: $ARCHIVO_PRUEBA"
    echo ""
    
    java -cp "$CLASSES_DIR:$ANTLR4_JAR" \
         com.compilador.ej.lexer.LexerMain "$ARCHIVO_PRUEBA"
    
    if [ $? -ne 0 ]; then
        echo -e "${RED}❌ Las pruebas fallaron${NC}"
        exit 1
    fi
    echo ""
    echo -e "${GREEN}✅ Pruebas exitosas${NC}"
}

# Procesar argumentos
ACCION="${1:-build}"

case "$ACCION" in
    clean)
        clean
        ;;
    generate)
        generate
        ;;
    compile)
        generate
        compile
        ;;
    build)
        generate
        compile
        ;;
    test)
        test_project
        ;;
    all)
        clean
        generate
        compile
        test_project
        ;;
    *)
        echo "Uso: $0 [clean|generate|compile|build|test|all]"
        exit 1
        ;;
esac

echo ""
echo -e "${GREEN}✅ Operación completada exitosamente${NC}"
echo ""
