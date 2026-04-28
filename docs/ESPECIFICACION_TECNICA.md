# Especificación Técnica del Lexer - EspañolJava

## 1. Introducción

El lexer (analizador léxico) es la primera fase de un compilador. Su responsabilidad es transformar una secuencia de caracteres en una secuencia de tokens significativos para el lenguaje.

**Archivo:** `MiLenguaje.g4`  
**Versión:** 1.0  
**Basado en:** ANTLR4 (Another Tool for Language Recognition)

---

## 2. Definición de Tokens

### 2.1 Tokens Reservados

El lexer define **75+ tokens** para palabras clave del lenguaje EspañolJava, agrupadas por categoría:

| Categoría | Tokens | Cantidad |
|-----------|--------|----------|
| Control de Acceso | PUBLICO, PRIVADO, PROTEGIDO, ESTATICO | 4 |
| Tipos de Datos | ENTERO, DECIMAL, BOOLEANO, CADENA, VACIO | 5 |
| Estructuras | CLASE, INTERFAZ, EXTIENDE, IMPLEMENTA | 4 |
| Control de Flujo | SI, SINO, MIENTRAS, PARA, HACER, RUPTURA, CONTINUAR | 7 |
| Excepciones | INTENTAR, CAPTURAR, FINALMENTE, LANZAR | 4 |
| Valores | VERDADERO, FALSO, NULO | 3 |
| Funciones Matemáticas | POTENCIA, RAIZ, SENO, COSENO, LOGARITMO, ALEATORIO, ABSOLUTO, MINIMO, MAXIMO | 9 |
| I/O | IMPRIMIR, LEER | 2 |
| Módulos | IMPORTAR, PAQUETE | 2 |
| **Total** | | **40+** |

### 2.2 Tokens de Operadores

| Tipo | Operadores | Token |
|------|-----------|-------|
| Comparación | ==, !=, <, >, <=, >= | 6 tokens |
| Lógicos | &&, \|\|, ! | 3 tokens |
| Aritméticos | +, -, *, /, %, **, ^ | 7 tokens |
| Incremento/Decremento | ++, -- | 2 tokens |
| Asignación | =, +=, -=, *=, /= | 5 tokens |
| Ternario | ?, : | 2 tokens |
| **Total Operadores** | | **25 tokens** |

### 2.3 Tokens de Delimitadores

| Símbolo | Token | Uso |
|---------|-------|-----|
| { } | LLAVE_ABIERTA, LLAVE_CERRADA | Bloques de código |
| ( ) | PAREN_ABIERTO, PAREN_CERRADO | Llamadas de función |
| [ ] | CORCHETE_ABIERTO, CORCHETE_CERRADO | Índices de arrays |
| ; | PUNTO_COMA | Fin de sentencia |
| , | COMA | Separador de parámetros |
| . | PUNTO | Acceso a miembros |
| @ | ARROBA | Anotaciones |

### 2.4 Tokens de Literales

#### Números
- **NUMERO_ENTERO:** Secuencia de dígitos (0-9)+
  - Ejemplos: `0`, `42`, `1000`
- **NUMERO_FLOTANTE:** Número con punto decimal o notación científica
  - Ejemplos: `3.14`, `.5`, `2.`, `1e5`, `1.5e-2`

#### Cadenas
- **CADENA_LITERAL:** Texto entre comillas (dobles o simples)
  - Formato: `"..."` o `'...'`
  - Escape sequences: `\n`, `\t`, `\r`, `\\`, `\"`, `\'`
  - Ejemplo: `"Hola\nmundo"`

#### Identificadores
- **IDENTIFICADOR:** [a-zA-Z_][a-zA-Z0-9_]*
  - Válidos: `variable1`, `_privado`, `MiFuncion`
  - Inválidos: `123abc` (comienza con número), `@dato` (carácter especial)

### 2.5 Tokens Especiales

- **COMENTARIO_LINEA:** `// ...` → Ignorado (skip)
- **COMENTARIO_BLOQUE:** `/* ... */` → Ignorado (skip)
- **ESPACIO_BLANCO:** [ \t]+ → Ignorado (skip)
- **SALTO_LINEA:** [\r\n]+ → Ignorado (skip)
- **DESCONOCIDO:** `.` → Error léxico (captura caracteres no reconocidos)

---

## 3. Precedencia y Conflictos

### 3.1 Orden de Definición

ANTLR4 utiliza la **primera coincidencia** cuando hay ambigüedad. Por eso el orden es crítico:

1. **Palabras reservadas** (más específicas, primero)
2. **Operadores** (ordenados por longitud: más largos primero, ej: `==` antes de `=`)
3. **Delimitadores**
4. **Números flotantes** (antes que enteros)
5. **Números enteros**
6. **Identificadores** (menos específicos, último)

### 3.2 Ejemplo de Resolución de Conflictos

Entrada: `contador++`

1. Lexer intenta `IDENTIFICADOR` primero
2. Reconoce `contador` como IDENTIFICADOR
3. Lee `++` y lo reconoce como INCREMENTO
4. Resultado: `(IDENTIFICADOR, contador)` `(INCREMENTO, ++)`

---

## 4. Manejo de Errores

### 4.1 Token DESCONOCIDO

Captura caracteres no reconocidos en la entrada:

```
DESCONOCIDO : .
```

Ejemplos:
- `$` → Token DESCONOCIDO
- `#` → Token DESCONOCIDO
- `@` (inicio de línea) → Token DESCONOCIDO

### 4.2 Información de Error

Cada token incluye:
- **Tipo:** Nombre del token
- **Texto:** Valor exacto del token
- **Línea:** Número de línea (1-basado)
- **Columna:** Posición en la línea (0-basado)

Ejemplo de informe de error:
```
Error léxico en línea 5, columna 10: símbolo desconocido '$'
```

---

## 5. Estructura ANTLR4

### 5.1 Cabecera de Gramática

```antlr
grammar MiLenguaje;
```

Define el nombre de la gramática (debe coincidir con el nombre del archivo).

### 5.2 Reglas de Tokens

Las reglas en **mayúsculas** definen tokens:

```antlr
PUBLICO : 'publico';
ASIGNACION : '=';
NUMERO_ENTERO : DIGITOS;
```

### 5.3 Reglas de Fragmentos

Los fragmentos se usan para reutilizar patrones sin generar tokens:

```antlr
fragment DIGITOS : [0-9]+;
```

### 5.4 Acciones de Tokens

```antlr
COMENTARIO_LINEA : '//' ~[\r\n]* -> skip;
```

- `-> skip` ignora el token en el parser
- Sin acción → el token se incluye en la secuencia

---

## 6. Tabla de Especificaciones

| Aspecto | Especificación |
|---------|---|
| **Sensibilidad a mayúsculas** | Sí (palabras clave deben ser exactas en minúsculas) |
| **Espacios en blanco** | Ignorados |
| **Comentarios** | Ignorados (// y /* */) |
| **Alcance de línea** | 1-basado (primera línea = 1) |
| **Alcance de columna** | 0-basado (primer carácter = 0) |
| **Longitud máxima de identificador** | Sin límite (ANTLR4 maneja) |
| **Longitud máxima de cadena** | Sin límite |
| **Longitud máxima de número** | Sin límite (manejado por Java BigInteger) |

---

## 7. Ejemplos de Tokenización

### 7.1 Ejemplo 1: Declaración Simple

**Entrada:**
```
entero x = 10;
```

**Salida:**
```
ENTERO       'entero'
IDENTIFICADOR 'x'
ASIGNACION   '='
NUMERO_ENTERO '10'
PUNTO_COMA   ';'
```

### 7.2 Ejemplo 2: Estructura de Control

**Entrada:**
```
si (x > 5) { x++; }
```

**Salida:**
```
SI                'si'
PAREN_ABIERTO    '('
IDENTIFICADOR    'x'
MAYOR            '>'
NUMERO_ENTERO    '5'
PAREN_CERRADO    ')'
LLAVE_ABIERTA    '{'
IDENTIFICADOR    'x'
INCREMENTO       '++'
PUNTO_COMA       ';'
LLAVE_CERRADA    '}'
```

### 7.3 Ejemplo 3: Función Matemática

**Entrada:**
```
decimal resultado = potencia(2, 8);
```

**Salida:**
```
DECIMAL          'decimal'
IDENTIFICADOR    'resultado'
ASIGNACION       '='
POTENCIA         'potencia'
PAREN_ABIERTO    '('
NUMERO_ENTERO    '2'
COMA             ','
NUMERO_ENTERO    '8'
PAREN_CERRADO    ')'
PUNTO_COMA       ';'
```

---

## 8. Características Implementadas

### 8.1 ✅ Completadas

- [x] Palabras reservadas en español (40+)
- [x] Operadores aritméticos, lógicos y de comparación
- [x] Delimitadores (llaves, paréntesis, corchetes)
- [x] Números enteros y flotantes
- [x] Cadenas con escape sequences
- [x] Comentarios de línea y bloque
- [x] Identificadores válidos
- [x] Funciones matemáticas españolas
- [x] Detección de errores léxicos
- [x] Información de línea y columna

### 8.2 🔄 Futuras Mejoras

- [ ] Soporte para caracteres Unicode completo
- [ ] Validación de cadenas incompletas
- [ ] Recuperación de errores mejorada
- [ ] Tokens para estructuras adicionales (enums, records)
- [ ] Palabras clave contextuales
- [ ] Soporte para literales booleanos adicionales

---

## 9. Generación de Código

### 9.1 Comando ANTLR4

```bash
antlr4 -Dlanguage=Java -visitor -no-listener MiLenguaje.g4
```

**Opciones:**
- `-Dlanguage=Java` → Genera código Java
- `-visitor` → Genera patrón Visitor (útil para análisis)
- `-no-listener` → No genera patrón Listener

### 9.2 Archivos Generados

| Archivo | Propósito |
|---------|-----------|
| MiLenguajeLexer.java | Clase del lexer |
| MiLenguajeParser.java | Clase del parser (en fase 2) |
| MiLenguajeVisitor.java | Interfaz Visitor |
| MiLenguajeBaseVisitor.java | Clase base Visitor |
| MiLenguaje.tokens | Información de tokens |

---

## 10. Validación

Para validar que el lexer funciona correctamente:

```bash
# Compilar
antlr4 -Dlanguage=Java -visitor -no-listener MiLenguaje.g4
javac *.java

# Probar
grun MiLenguaje -tokens ejemplos/prueba_lexer.ej
```

---

## 11. Referencias

- [ANTLR4 Documentation](https://antlr.org/)
- [ANTLR4 Lexer Reference](https://antlr.org/documentation/how-to-create-a-lexer)
- [Java Regular Expressions](https://docs.oracle.com/javase/tutorial/i18n/reintro/charactersintro.html)

---

## 12. Notas de Implementación

1. **Fragmentos:** Utilizan `fragment` para definir patrones reutilizables sin generar tokens.

2. **Negación de caracteres:** `~[...]` significa "cualquier carácter excepto los especificados".

3. **Rangos:** `[a-z]` incluye todos los caracteres del rango.

4. **Repetición:**
   - `+` una o más veces
   - `*` cero o más veces
   - `?` cero o una vez

5. **Alternancia:** `(opción1 | opción2)` para múltiples opciones.

---

**Autor:** CompiladorEsp  
**Fecha de Creación:** Abril de 2026  
**Estado:** Completo - Fase 1 (Lexer)
