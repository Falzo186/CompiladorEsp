# Makefile para CompiladorEsp
# Proyecto: Compilador EspañolJava
# Versión: 1.0

.PHONY: clean build test help compile generate

# Variables
ANTLR4=antlr4
JAVAC=javac
JAVA=java
CLASSPATH=-cp "C:\antlr\antlr-4.13.0-complete.jar:build/classes"

# Directorios
SRC_MAIN=src/main/java
GRAMMAR_DIR=grammar
BUILD_DIR=build
CLASSES_DIR=$(BUILD_DIR)/classes

help:
	@echo "CompiladorEsp - Compilador EspañolJava"
	@echo "========================================"
	@echo "Targets disponibles:"
	@echo "  make build     - Compila el proyecto"
	@echo "  make test      - Ejecuta las pruebas"
	@echo "  make generate  - Genera código ANTLR4"
	@echo "  make clean     - Limpia archivos compilados"
	@echo "  make help      - Muestra esta ayuda"

generate:
	@echo "Generando código ANTLR4..."
	$(ANTLR4) -Dlanguage=Java -visitor -no-listener -package com.compilador.ej.gen -Xexact-output-dir \
		-o $(SRC_MAIN)/com/compilador/ej/gen \
		$(GRAMMAR_DIR)/MiLenguaje.g4
	@echo "✓ Código generado"

compile: generate
	@echo "Compilando..."
	$(JAVAC) -d $(CLASSES_DIR) \
		-cp "C:\antlr\antlr-4.13.0-complete.jar" \
		-encoding UTF-8 \
		$(SRC_MAIN)/com/compilador/ej/lexer/*.java \
		$(SRC_MAIN)/com/compilador/ej/gen/*.java
	@echo "✓ Compilación completada"

build: compile
	@echo "Build completado"

test: build
	@echo "Ejecutando pruebas..."
	$(JAVA) -cp "$(CLASSES_DIR):C:\antlr\antlr-4.13.0-complete.jar" \
		com.compilador.ej.lexer.LexerMain resources/examples/caso1_basico.ej

clean:
	@echo "Limpiando..."
	rm -rf $(BUILD_DIR)
	@echo "✓ Archivos limpios"

.DEFAULT_GOAL := help
