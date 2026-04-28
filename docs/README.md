# 🎯 EspañolJava: Compilador de Lenguaje Personalizado

**Proyecto:** Desarrollo de un compilador para un lenguaje de programación que combina la sintaxis Java con palabras clave completamente en español.

**Fase Actual:** ✅ Fase 1 - Analizador Léxico (Lexer) - COMPLETADA

---

## 📋 Descripción General

EspañolJava es un lenguaje de programación educativo diseñado para:
- Aprender conceptos de compiladores en español
- Combinar familiaridad con Java con palabras clave naturales del español
- Demostrar las fases de compilación: Lexer → Parser → Análisis Semántico → Generación de Código

---

## 📁 Estructura del Proyecto

```
CompiladorEsp/
├── MiLenguaje.g4                    # Gramática ANTLR4 (Lexer)
├── ejemplos/
│   └── prueba_lexer.ej              # Programa de prueba en EspañolJava
├── src/                             # Código fuente (generado/a generar)
├── LEXER_README.md                  # Guía del lexer
├── ESPECIFICACION_TECNICA.md        # Especificación técnica detallada
├── README.md                        # Este archivo
├── compilar.bat                     # Script compilación (Windows)
└── compilar.sh                      # Script compilación (Linux/macOS)
```

---

## 🚀 Inicio Rápido

### Requisitos Previos

- **Java 8+** (JRE y JDK)
- **ANTLR4 4.9+**
- **Bash o PowerShell** (según el SO)

### Instalación de ANTLR4

#### Windows
```powershell
# Descargar ANTLR4
# https://www.antlr.org/download/antlr-4.13.0-complete.jar

# Guardar en C:\antlr\ y agregar a PATH
```

#### macOS (con Homebrew)
```bash
brew install antlr
```

#### Linux
```bash
# Descargar manualmente o usar:
# apt-get install antlr4 (Debian/Ubuntu)
# yum install antlr4 (RedHat/CentOS)
```

### Compilación

**Windows:**
```bash
compilar.bat
```

**Linux/macOS:**
```bash
bash compilar.sh
```

### Prueba del Lexer

```bash
grun MiLenguaje -tokens ejemplos/prueba_lexer.ej
```

---

## 📚 Documentación

### Archivos Principales

1. **[MiLenguaje.g4](MiLenguaje.g4)**
   - Definición completa de la gramática ANTLR4
   - 75+ palabras clave en español
   - Operadores, delimitadores, números, cadenas
   - Comentarios y manejo de errores

2. **[LEXER_README.md](LEXER_README.md)**
   - Guía completa del lexer
   - Explicación de todos los tokens
   - Ejemplos de uso
   - Instrucciones de compilación

3. **[ESPECIFICACION_TECNICA.md](ESPECIFICACION_TECNICA.md)**
   - Especificación detallada
   - Tabla de tokens
   - Precedencia y conflictos
   - Ejemplos de tokenización

4. **[ejemplos/prueba_lexer.ej](ejemplos/prueba_lexer.ej)**
   - Programa de ejemplo en EspañolJava
   - Demuestra todas las características del lexer
   - Incluye comentarios explicativos

---

## 🎓 Características del Lexer

### ✅ Palabras Clave en Español

**Control de Acceso:** publico, privado, protegido, estatico

**Tipos:** entero, decimal, booleano, cadena, vacio

**Estructuras:** clase, interfaz, extiende, implementa

**Control de Flujo:** si, sino, mientras, para, hacer, ruptura, continuar

**Excepciones:** intentar, capturar, finalmente, lanzar

**Valores:** verdadero, falso, nulo

**Funciones Matemáticas:** potencia, raiz, seno, coseno, logaritmo, aleatorio, absoluto, minimo, maximo

**I/O:** imprimir, leer

**Módulos:** importar, paquete

### ✅ Operadores

- **Aritméticos:** `+`, `-`, `*`, `/`, `%`, `**`, `^`
- **Comparación:** `==`, `!=`, `<`, `>`, `<=`, `>=`
- **Lógicos:** `&&`, `||`, `!`
- **Asignación:** `=`, `+=`, `-=`, `*=`, `/=`
- **Incremento/Decremento:** `++`, `--`
- **Ternario:** `?`, `:`

### ✅ Delimitadores

Llaves `{}`, Paréntesis `()`, Corchetes `[]`, Punto y coma `;`, Coma `,`, Punto `.`, Arroba `@`

### ✅ Literales

- **Números:** `42`, `3.14`, `.5`, `1e5`, `1.5e-2`
- **Cadenas:** `"Hola"`, `'Mundo'` (con escape sequences)
- **Comentarios:** `// línea` y `/* bloque */`

### ✅ Identificadores

Válidos: `variable1`, `contador`, `_privado`, `MiFuncion`

Inválidos: `123abc` (comienza con número), `@dato` (carácter especial)

### ✅ Manejo de Errores

- Token `DESCONOCIDO` para capturar caracteres inválidos
- Información de línea y columna para reportes de error
- Detección de símbolos no reconocidos: `$`, `#`, etc.

---

## 📝 Ejemplo de Uso

### Entrada (programa.ej)
```java
publico clase Prueba {
    entero x = 10;
    si(x > 5) {
        imprimir("Hola mundo");
    }
}
```

### Salida del Lexer
```
PUBLICO         'publico'
CLASE           'clase'
IDENTIFICADOR   'Prueba'
LLAVE_ABIERTA   '{'
ENTERO          'entero'
IDENTIFICADOR   'x'
ASIGNACION      '='
NUMERO_ENTERO   '10'
PUNTO_COMA      ';'
SI              'si'
PAREN_ABIERTO   '('
IDENTIFICADOR   'x'
MAYOR           '>'
NUMERO_ENTERO   '5'
PAREN_CERRADO   ')'
LLAVE_ABIERTA   '{'
IMPRIMIR        'imprimir'
PAREN_ABIERTO   '('
CADENA_LITERAL  '"Hola mundo"'
PAREN_CERRADO   ')'
PUNTO_COMA      ';'
LLAVE_CERRADA   '}'
LLAVE_CERRADA   '}'
```

---

## 🔧 Compilación Manual

Si los scripts no funcionan:

```bash
# 1. Generar código desde la gramática
antlr4 -Dlanguage=Java -visitor -no-listener MiLenguaje.g4

# 2. Compilar el código generado
javac *.java

# 3. Probar el lexer
grun MiLenguaje -tokens ejemplos/prueba_lexer.ej
```

---

## 📊 Fases del Proyecto

### Fase 1: ✅ Analizador Léxico (Completada)
- [x] Palabras clave en español
- [x] Operadores y delimitadores
- [x] Números y cadenas
- [x] Comentarios
- [x] Identificadores
- [x] Manejo de errores
- [x] Funciones matemáticas españolas

### Fase 2: 🔄 Parser (Próxima)
- [ ] Reglas sintácticas
- [ ] Estructura de programas
- [ ] Generación de AST (Árbol de Sintaxis Abstracta)
- [ ] Validación de construcciones gramaticales

### Fase 3: 📋 Análisis Semántico (Futura)
- [ ] Tabla de símbolos
- [ ] Verificación de tipos
- [ ] Validación de alcance (scope)
- [ ] Chequeo de redefiniciones

### Fase 4: 🔨 Generación de Código (Futura)
- [ ] Traducción a bytecode Java
- [ ] O generación de código intermedio
- [ ] Optimizaciones
- [ ] Ejecución o compilación final

---

## 💡 Conceptos Clave

### ¿Qué es un Lexer?
El lexer (analizador léxico) es la primera fase de un compilador. Lee caracteres individuales y los agrupa en tokens significativos para el lenguaje (palabras clave, números, operadores, etc.).

### ¿Por qué ANTLR4?
ANTLR4 es una herramienta poderosa que:
- Genera automáticamente código de análisis
- Soporta múltiples lenguajes de salida (Java, Python, C#, etc.)
- Tiene excelente manejo de errores
- Es estándar en la industria

### ¿Por qué español?
- Facilita la enseñanza de compiladores en español
- Demuestra que los conceptos son independientes del idioma
- Permite familiaridad con conceptos de programación en idioma natural

---

## 🐛 Resolución de Problemas

### Error: "antlr4 no es reconocido"
- Verificar que ANTLR4 esté en PATH
- O usar la ruta completa: `C:\antlr\antlr4.cmd` o `/usr/local/bin/antlr4`

### Error: "javac no es reconocido"
- Verificar que Java JDK esté instalado (no solo JRE)
- Agregar `JAVA_HOME` a las variables de entorno

### Error: "grun no es reconocido"
- ANTLR4 debe estar en PATH
- O ejecutar: `java -cp antlr-4.13.0-complete.jar:. org.antlr.v4.gui.TestRig`

### El lexer no reconoce palabras clave
- Verificar que las palabras están en minúsculas exactas
- Revisar que no hay espacios adicionales
- Compilar nuevamente: `antlr4 ... && javac *.java`

---

## 📖 Recursos Adicionales

- **[ANTLR4 Official Documentation](https://antlr.org/)**
- **[ANTLR4 The Definitive Reference](https://pragprog.com/titles/tpantlr2/the-definitive-antlr-4-reference/)** (Libro)
- **[GitHub ANTLR4](https://github.com/antlr/antlr4)**

---

## 📝 Notas de Desarrollo

### Decisiones de Diseño

1. **Minúsculas para palabras clave:** Facilita lectura y reduce errores tipográficos comunes.

2. **Funciones matemáticas como palabras clave:** Permite parsing más eficiente y validación sintáctica.

3. **Token DESCONOCIDO:** Permite recuperación de errores elegante sin detener el análisis.

4. **Orden de precedencia:** Las palabras clave se definen antes que identificadores para evitar conflictos.

5. **Fragmentos ANTLR:** Se usan para reutilizar patrones comunes (como DIGITOS).

### Extensibilidad

El diseño es modular y permite fácilmente:
- Agregar nuevas palabras clave
- Incluir operadores adicionales
- Soportar nuevos tipos de literales
- Mejorar el manejo de errores

---

## 👨‍💻 Autor

**Proyecto:** CompiladorEsp  
**Fase 1:** Analizador Léxico (Lexer)  
**Versión:** 1.0  
**Fecha:** Abril de 2026

---

## 📄 Licencia

Este proyecto es educativo. Siéntase libre de usar, modificar y distribuir.

---

## ⚙️ Próximos Pasos

1. ✅ Completar y validar el lexer
2. 🔄 Desarrollar el parser (Fase 2)
3. 📋 Implementar análisis semántico (Fase 3)
4. 🔨 Generar código ejecutable (Fase 4)

---

**¡Gracias por usar EspañolJava! 🚀**
