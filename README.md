# 🚀 CompiladorEsp - EspañolJava Lexer

**Compilador para un lenguaje de programación que combina la sintaxis de Java con palabras clave completamente en español.**

![Status](https://img.shields.io/badge/Phase-Lexer%20Complete-green) ![Java](https://img.shields.io/badge/Java-11-orange) ![ANTLR4](https://img.shields.io/badge/ANTLR4-4.13.0-blue)

---

## 📋 Descripción

**EspañolJava** es un lenguaje educativo que demuestra los conceptos de compiladores usando palabras clave en español. El proyecto actual implementa la **Fase 1: Analizador Léxico (Lexer)**.

### Características Principales

✅ **40+ palabras clave en español**  
✅ **25+ operadores** (aritméticos, lógicos, comparación)  
✅ **Funciones matemáticas** como palabras reservadas  
✅ **Manejo de números enteros y flotantes** con notación científica  
✅ **Cadenas con escape sequences**  
✅ **Comentarios** de línea y bloque  
✅ **Detección de errores léxicos** con línea y columna  

---

## 🏗️ Arquitectura del Proyecto

```
CompiladorEsp/
├── grammar/
│   └── MiLenguaje.g4              Gramática ANTLR4
├── src/
│   ├── main/java/com/compilador/ej/
│   │   └── lexer/
│   │       ├── LexerEJ.java        Clase principal del lexer
│   │       └── LexerMain.java      Entrada del programa
│   └── test/                        Pruebas unitarias
├── resources/
│   └── examples/                    Archivos de ejemplo
│       ├── caso1_basico.ej
│       ├── caso2_matematicas.ej
│       ├── caso3_estres.ej
│       ├── caso4_errores.ej
│       └── caso5_completo.ej
├── docs/                            Documentación
│   ├── README.md
│   ├── LEXER_README.md
│   └── ... (más documentación)
├── build/                           Archivos compilados
├── bin/                             Scripts ejecutables
├── build.xml                        Configuración Ant
├── Makefile                         Configuración Make
└── build.properties                 Propiedades del proyecto
```

---

## 🚀 Inicio Rápido

### Requisitos

- **Java 11+**
- **ANTLR4 4.13.0**

### Instalación

```bash
# Clonar o descargar el proyecto
cd CompiladorEsp

# Compilar
.\bin\compilar.bat

# Ejecutar
java -cp "build/classes:C:\antlr\antlr-4.13.0-complete.jar" \
     com.compilador.ej.lexer.LexerMain resources/examples/caso1_basico.ej
```

---

## 📖 Documentación

Toda la documentación se encuentra en la carpeta `docs/`:

| Documento | Contenido |
|-----------|-----------|
| **[docs/INDICE_COMPLETO.md](docs/INDICE_COMPLETO.md)** | Índice general del proyecto |
| **[docs/PRUEBAS_RAPIDO.md](docs/PRUEBAS_RAPIDO.md)** | Instrucciones rápidas para hacer pruebas |
| **[docs/COMO_HACER_PRUEBAS.md](docs/COMO_HACER_PRUEBAS.md)** | Guía detallada de pruebas |
| **[docs/LEXER_README.md](docs/LEXER_README.md)** | Documentación técnica del lexer |
| **[docs/ESPECIFICACION_TECNICA.md](docs/ESPECIFICACION_TECNICA.md)** | Especificación detallada |
| **[docs/REFERENCIA_RAPIDA.md](docs/REFERENCIA_RAPIDA.md)** | Hoja de referencia del lenguaje |
| **[docs/REPORTE_PRUEBAS.md](docs/REPORTE_PRUEBAS.md)** | Reporte de pruebas ejecutadas |

---

## 🧪 Pruebas

El proyecto incluye **5 casos de prueba** exhaustivos:

### CASO 1: Básico
Programa simple válido con clases, variables y asignaciones.

### CASO 2: Funciones Matemáticas ⭐
Prueba de funciones matemáticas españolas (innovación principal).

### CASO 3: Estrés
Combinaciones complejas para validar robustez.

### CASO 4: Errores
Detección de símbolos inválidos.

### CASO 5: Completo
Demo final con cobertura completa del lenguaje.

**Ejecutar pruebas:**
```powershell
powershell -ExecutionPolicy Bypass -File .\bin\ejecutar_pruebas.ps1
```

---

## 📚 Palabras Clave

### Control de Acceso
`publico` `privado` `protegido` `estatico`

### Tipos de Datos
`entero` `decimal` `booleano` `cadena` `vacio`

### Estructuras
`clase` `interfaz` `extiende` `implementa`

### Control de Flujo
`si` `sino` `mientras` `para` `hacer` `ruptura` `continuar`

### Funciones Matemáticas
`potencia` `raiz` `seno` `coseno` `logaritmo` `aleatorio` `absoluto` `minimo` `maximo`

### Más...
`intentar` `capturar` `finalmente` `lanzar` `retornar` `nuevo` `importar` `paquete` `imprimir` `leer` `verdadero` `falso` `nulo`

---

## 💻 Ejemplo de Uso

**Archivo:** `programa.ej`
```java
publico clase Ejemplo {
    publico vacio principal() {
        entero x = potencia(2, 8);
        si(x > 100) {
            imprimir("Es potencia");
        }
    }
}
```

**Ejecutar:**
```bash
java -cp "build/classes:C:\antlr\antlr-4.13.0-complete.jar" \
     com.compilador.ej.lexer.LexerMain programa.ej
```

**Salida:**
```
[@0] Línea 1, Col 0: 'publico' [Tipo: PUBLICO]
[@1] Línea 1, Col 8: 'clase' [Tipo: CLASE]
[@2] Línea 1, Col 14: 'Ejemplo' [Tipo: IDENTIFICADOR]
...
```

---

## 🎯 Resultados de Validación

| Criterio | Estado |
|----------|--------|
| ✅ Keywords en español | CUMPLIDO |
| ✅ Identificadores | CUMPLIDO |
| ✅ Funciones matemáticas | CUMPLIDO |
| ✅ Operadores | CUMPLIDO |
| ✅ Símbolos inválidos detectados | CUMPLIDO |
| ✅ Comentarios ignorados | CUMPLIDO |

**Resultado:** ✅ **6/6 CRITERIOS - 100% ÉXITO**

---

## 🔄 Fases del Proyecto

### ✅ Fase 1: Analizador Léxico (Completada)
- [x] Lexer completo
- [x] Palabras clave españolas
- [x] Operadores y delimitadores
- [x] Manejo de errores

### 🔄 Fase 2: Parser (Próxima)
- Reglas sintácticas
- Árbol de sintaxis abstracta (AST)

### 📋 Fase 3: Análisis Semántico (Futura)
- Verificación de tipos
- Tabla de símbolos

### 🔨 Fase 4: Generación de Código (Futura)
- Bytecode o código intermedio

---

## 🛠️ Build y Compilación

### Con Ant
```bash
ant build
ant test
ant clean
```

### Con Make
```bash
make build
make test
make clean
```

### Manual
```bash
# Generar código ANTLR4
antlr4 -Dlanguage=Java -visitor -no-listener \
       -o src/main/java/com/compilador/ej/gen \
       grammar/MiLenguaje.g4

# Compilar
javac -d build/classes \
      -cp "C:\antlr\antlr-4.13.0-complete.jar" \
      -encoding UTF-8 \
      src/main/java/com/compilador/ej/lexer/*.java
```

---

## 📊 Estadísticas

| Métrica | Valor |
|---------|-------|
| Palabras clave | 40+ |
| Operadores | 25+ |
| Delimitadores | 10 |
| Funciones matemáticas | 9 |
| Líneas de código ANTLR4 | 250+ |
| Casos de prueba | 5 |
| Tasa de éxito | 100% |

---

## 🔗 Enlaces Útiles

- **[ANTLR4](https://www.antlr.org/)** - The ANTLR Project
- **[Java 11](https://docs.oracle.com/en/java/javase/11/)** - Java SE 11 Documentation
- **[Documentación Técnica](docs/ESPECIFICACION_TECNICA.md)** - Detalles técnicos

---

## 📝 Licencia

Proyecto educativo. Libre para usar, modificar y distribuir.

---

## 👨‍💻 Autor

**Proyecto:** CompiladorEsp  
**Versión:** 1.0.0  
**Fecha:** Abril de 2026

---

## 🎓 Próximos Pasos

1. ✅ **Fase 1 Completada** - Lexer funcional y probado
2. 🔄 **Empezar Fase 2** - Desarrollo del Parser
3. 📚 **Extender documentación** con ejemplos más complejos
4. 🧪 **Agregar más casos de prueba**

---

**Para más información, consulta la documentación en la carpeta `docs/`**
