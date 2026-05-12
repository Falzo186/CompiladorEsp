# Modo Consola Interactivo - EspañolJava

## 🎯 Descripción

Se ha creado un **modo consola interactivo** que permite realizar análisis léxico, sintáctico y visualizar parse trees sin necesidad de ejecutar comandos largos en la terminal.

**Archivo principal:** `src/main/java/com/compilador/ej/Main.java`

## 📋 Características

✅ Menú principal interactivo  
✅ 8 casos de prueba predefinidos  
✅ Análisis léxico en tiempo real  
✅ Análisis sintáctico (parser) completo  
✅ Visualización de parse tree (árbol sintáctico)  
✅ Carga automática desde `resources/examples/`  
✅ Errores en español con formato mejorado  
✅ Sin análisis semántico (según requisitos)

## 🚀 Ejecución Rápida

### Opción 1: Compilar y ejecutar (recomendado)

```bash
# Compilar todo (ANTLR + Java + Main.java)
cd c:\programas\CompiladorEsp
bin\compilar.bat

# Ejecutar modo interactivo
java -cp "build\classes;C:\Users\alexp\Downloads\antlr-4.13.2-complete.jar" com.compilador.ej.Main
```

### Opción 2: Usar PowerShell en Windows

```powershell
cd c:\programas\CompiladorEsp
cmd /c bin\compilar.bat
java -cp "build\classes;C:\Users\alexp\Downloads\antlr-4.13.2-complete.jar" com.compilador.ej.Main
```

### Opción 3: Script bash (Linux/Mac)

```bash
cd /c/programas/CompiladorEsp
./bin/compilar.sh
java -cp "build/classes:$ANTLR4_JAR" com.compilador.ej.Main
```

## 📖 Menú Interactivo

Una vez ejecutado, verás:

```
============================================================
    🎯 COMPILADOR ESPAÑOLJAVA - MODO CONSOLA INTERACTIVO
============================================================

📋 MENÚ PRINCIPAL:
   1. Ejecutar análisis léxico
   2. Ejecutar parser
   3. Mostrar parse tree
   4. Ejecutar casos predefinidos
   5. Salir

▶ Selecciona opción:
```

### Opción 1: Ejecutar Análisis Léxico

- Selecciona opción **1**
- Ingresa la ruta del archivo (ej: `resources/examples/caso1_basico.ej`)
- Verás:
  - Número de tokens encontrados
  - Detalles de cada token
  - Errores léxicos (si los hay)

**Ejemplo:**
```
--- ANÁLISIS LÉXICO ---
▶ Ingresa ruta del archivo: resources/examples/caso1_basico.ej

✓ TOKENS ENCONTRADOS:
   [@0] Línea 1, Col 0: 'entero' [Tipo: ENTERO]
   [@1] Línea 1, Col 7: 'x' [Tipo: IDENTIFICADOR]
   [@2] Línea 1, Col 8: '=' [Tipo: ASIGNACION]
   ...
✓ No hay errores léxicos
```

### Opción 2: Ejecutar Parser

- Selecciona opción **2**
- Ingresa la ruta del archivo
- Verás:
  - Análisis sintáctico completo
  - Errores sintácticos con traducción al español
  - Estado del parsing (exitoso o con errores)

**Ejemplo:**
```
--- ANÁLISIS SINTÁCTICO (PARSER) ---
▶ Ingresa ruta del archivo: resources/examples/caso_completo_con_errores.ej

✓ ERRORES SINTÁCTICOS:
   ERROR sintáctico en línea 5, columna 0: falta ';' en 'publico'
   ERROR sintáctico en línea 5, columna 39: falta ')' en '{'
```

### Opción 3: Mostrar Parse Tree

- Selecciona opción **3**
- Ingresa la ruta del archivo
- Verás:
  - Árbol sintáctico completo en formato textual
  - Jerarquía de reglas gramaticales

**Ejemplo:**
```
--- PARSE TREE (Árbol sintáctico) ---
🌳 ÁRBOL SINTÁCTICO (Parse Tree):
------------------------------------------------------------
(programa (elemento (sentencia (sentenciaEmparejada 
  (declaracion entero x = (expr (equalityExpr (relationalExpr 
  (addExpr (mulExpr (unaryExpr (postfixExpr (primary 5))))))))) ;))) EOF)
------------------------------------------------------------
✓ Árbol generado exitosamente
```

### Opción 4: Casos Predefinidos

- Selecciona opción **4**
- Verás la lista de casos disponibles:

```
--- CASOS PREDEFINIDOS ---
   1. Análisis Léxico (prueba_lexer.ej)
   2. Caso Básico (caso1_basico.ej)
   3. If/Else (caso_if_else.ej)
   4. Métodos (caso_metodo_parametros.ej)
   5. Clases (caso_clase_metodo.ej)
   6. Completo (sin errores) (caso_completo_sin_errores.ej)
   7. Completo (con errores) (caso_completo_con_errores.ej)
   8. Volver al menú principal

▶ Selecciona caso:
```

Cada caso ejecuta automáticamente:
- Análisis léxico
- Análisis sintáctico
- Reporte completo de errores (si los hay)

### Opción 5: Salir

- Selecciona opción **5**
- Sale del programa

## 📊 Casos Predefinidos Disponibles

| # | Nombre | Archivo | Descripción |
|---|--------|---------|-------------|
| 1 | Análisis Léxico | `prueba_lexer.ej` | Prueba exhaustiva de tokens |
| 2 | Caso Básico | `caso1_basico.ej` | Declaraciones simples |
| 3 | If/Else | `caso_if_else.ej` | Condicionales (Fase A) |
| 4 | Métodos | `caso_metodo_parametros.ej` | Métodos con parámetros (Fase B) |
| 5 | Clases | `caso_clase_metodo.ej` | Clases con miembros (Fase C) |
| 6 | Completo (sin errores) | `caso_completo_sin_errores.ej` | Programa válido completo |
| 7 | Completo (con errores) | `caso_completo_con_errores.ej` | Programa con errores para debug |

## 🛠️ Compilación

El script `compilar.bat` ahora incluye Main.java:

```batch
@echo Compilando codigo Java...
javac -encoding UTF-8 -d "build\classes" -cp "%ANTLR4_JAR%" ^
  src\main\java\com\compilador\ej\Main.java ^
  src\main\java\com\compilador\ej\lexer\*.java ^
  src\main\java\com\compilador\ej\parser\*.java ^
  src\main\java\com\compilador\ej\gen\*.java
```

## 📁 Estructura de Archivos Actualizados

```
src/main/java/com/compilador/ej/
├── Main.java              ← NUEVO: Consola interactiva
├── lexer/
│   ├── LexerEJ.java       ← Análisis léxico
│   └── LexerMain.java
├── parser/
│   └── ParserTest.java    ← Análisis sintáctico
└── gen/
    ├── MiLenguajeLexer.java
    ├── MiLenguajeParser.java
    ├── MiLenguajeVisitor.java
    └── MiLenguajeBaseVisitor.java

bin/
├── compilar.bat           ← ACTUALIZADO: Incluye Main.java
└── compilar.sh

grammar/
└── MiLenguaje.g4          ← Gramática ANTLR (lexer + parser)

resources/examples/
├── caso1_basico.ej
├── caso_if_else.ej
├── caso_metodo_parametros.ej
├── caso_clase_metodo.ej
├── caso_completo_sin_errores.ej
├── caso_completo_con_errores.ej
└── ... (7 más)
```

## 🔧 Requisitos

- **Java 11+** (JDK 11.0.31 o superior)
- **ANTLR 4.13.2** (`antlr-4.13.2-complete.jar`)
- Ruta configurada en `compilar.bat`:
  ```
  set ANTLR4_JAR=C:\Users\alexp\Downloads\antlr-4.13.2-complete.jar
  ```

## ✨ Características de la Consola

### Traducción de Errores al Español

Todos los mensajes de error se traducen automáticamente:

| ANTLR | Español |
|-------|---------|
| `missing ';'` | `falta ';'` |
| `at 'token'` | `en 'token'` |
| `expected` | `se esperaba` |
| `Unexpected input` | `Entrada inesperada` |
| `no viable alternative` | `sin alternativa viable` |
| `extraneous input` | `entrada extraña` |

### Formato Mejorado

Los tokens y errores se muestran con formato:
- ✓ Éxito (marca verde)
- ❌ Error (marca roja)
- 📍 Sección (punto azul)
- 🌳 Parse tree (árbol)
- 📋 Menú (list)

## 🎓 Ejemplo de Uso Completo

```bash
# 1. Compilar
cd c:\programas\CompiladorEsp
bin\compilar.bat

# 2. Ejecutar
java -cp "build\classes;C:\Users\alexp\Downloads\antlr-4.13.2-complete.jar" com.compilador.ej.Main

# 3. En el menú, seleccionar opción 4 (casos predefinidos)
# 4. Seleccionar caso 1 (Análisis Léxico)
# 5. Ver resultados completos
# 6. Seleccionar opción 5 para salir
```

## 📝 Notas

- **Sin análisis semántico:** Como se requiere, no hay análisis de tipos, scope o validación de símbolos
- **Solo sintaxis:** Se valida estructura gramatical, no significado semántico
- **Código reutilizable:** Main.java usa LexerEJ y ParserTest existentes
- **Mantenimiento fácil:** Agregar nuevos casos es simple (agregar archivo a `resources/examples/`)

## 🐛 Troubleshooting

### "ANTLR not found"
Actualiza `compilar.bat` con la ruta correcta del JAR:
```batch
set ANTLR4_JAR=C:\ruta\a\antlr-4.13.2-complete.jar
```

### "No encoding specified"
Asegúrate de usar `-encoding UTF-8` en javac:
```batch
javac -encoding UTF-8 ...
```

### Caracteres raros en salida
Usa una terminal que soporte UTF-8 o ajusta encoding del sistema:
```powershell
$OutputEncoding = [System.Text.Encoding]::UTF8
```

## 📚 Documentación Relacionada

- [COMO_HACER_PRUEBAS.md](docs/COMO_HACER_PRUEBAS.md) - Guía completa de pruebas
- [ESPECIFICACION_TECNICA.md](docs/ESPECIFICACION_TECNICA.md) - Detalles técnicos
- [grammar/MiLenguaje.g4](grammar/MiLenguaje.g4) - Definición de la gramática
