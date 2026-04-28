# Analizador Léxico (Lexer) para EspañolJava

## Descripción General

Este lexer ANTLR4 reconoce los elementos básicos del lenguaje EspañolJava, una combinación entre la sintaxis de Java y palabras clave completamente en español.

**Archivo principal:** `MiLenguaje.g4`

---

## Estructura del Lexer

### 1. **Palabras Reservadas** (75+ tokens)

El lexer reconoce palabras clave en español equivalentes a Java:

#### Control de Acceso
- `PUBLICO` → public
- `PRIVADO` → private
- `PROTEGIDO` → protected
- `ESTATICO` → static

#### Tipos de Datos
- `ENTERO` → int
- `DECIMAL` → double
- `BOOLEANO` → boolean
- `CADENA` → String
- `VACIO` → void

#### Estructura
- `CLASE` → class
- `INTERFAZ` → interface
- `EXTIENDE` → extends
- `IMPLEMENTA` → implements

#### Control de Flujo
- `SI` → if
- `SINO` → else
- `MIENTRAS` → while
- `PARA` → for
- `HACER` → do
- `RUPTURA` → break
- `CONTINUAR` → continue

#### Excepciones
- `INTENTAR` → try
- `CAPTURAR` → catch
- `FINALMENTE` → finally
- `LANZAR` → throw

#### Valores
- `VERDADERO` → true
- `FALSO` → false
- `NULO` → null

#### Funciones Matemáticas Españolas
- `POTENCIA(a, b)` - Calcula a^b
- `RAIZ(x)` - Calcula √x
- `SENO(x)` - Función seno
- `COSENO(x)` - Función coseno
- `LOGARITMO(x)` - Logaritmo natural
- `ALEATORIO()` - Número aleatorio
- `ABSOLUTO(x)` - Valor absoluto
- `MINIMO(a, b)` - Mínimo de dos valores
- `MAXIMO(a, b)` - Máximo de dos valores

#### I/O
- `IMPRIMIR` → print
- `LEER` → read

### 2. **Operadores**

#### Comparación
- `==` IGUALDAD
- `!=` DESIGUALDAD
- `<` MENOR
- `>` MAYOR
- `<=` MENOR_IGUAL
- `>=` MAYOR_IGUAL

#### Lógicos
- `&&` AND_OP
- `||` OR_OP
- `!` NOT_OP

#### Aritméticos
- `+` SUMA
- `-` RESTA
- `*` MULT
- `/` DIV
- `%` MOD
- `**` o `^` POTENCIA_OP

#### Incremento/Decremento
- `++` INCREMENTO
- `--` DECREMENTO

#### Asignación
- `=` ASIGNACION
- `+=` SUMA_ASIGN
- `-=` RESTA_ASIGN
- `*=` MULT_ASIGN
- `/=` DIV_ASIGN

#### Ternario
- `?` INTERROGACION
- `:` DOS_PUNTOS

### 3. **Delimitadores**

- `{` `}` - Llaves
- `(` `)` - Paréntesis
- `[` `]` - Corchetes
- `;` - Punto y coma
- `,` - Coma
- `.` - Punto
- `@` - Arroba

### 4. **Identificadores**

Formato válido:
```
[a-zA-Z_][a-zA-Z0-9_]*
```

**Ejemplos válidos:**
- `variable1`
- `contador`
- `miFuncion`
- `_privado`
- `Var2023`

**Ejemplos inválidos:**
- `123abc` (comienza con número)
- `@dato` (carácter especial no válido)
- `mi-variable` (guion no permitido)

### 5. **Números**

#### Enteros
```
NUMERO_ENTERO: [0-9]+
```

Ejemplos: `0`, `42`, `1000`, `999999`

#### Flotantes
```
NUMERO_FLOTANTE: (DIGITOS '.' DIGITOS) | ('.' DIGITOS) | (DIGITOS '.') | (DIGITOS ([eE] [+-]? DIGITOS))
```

Ejemplos: `3.14`, `.5`, `2.`, `1e5`, `1.5e-2`

### 6. **Cadenas (Strings)**

Formato:
```
CADENA_LITERAL: "..." | '...'
```

Soporta:
- Cadenas entre comillas dobles: `"Hola mundo"`
- Cadenas entre comillas simples: `'Hola mundo'`
- Secuencias de escape: `\n`, `\t`, `\r`, `\\`, `\"`, `\'`

Ejemplo:
```
cadena mensaje = "Hola\nmundo";
```

### 7. **Comentarios**

#### Línea Simple
```
// Este es un comentario de una línea
```

#### Bloque Múltiple
```
/* Este es un comentario
   que puede ocupar
   múltiples líneas */
```

Los comentarios son ignorados automáticamente por el lexer (acción `skip`).

### 8. **Espacios en Blanco**

- Espacios y tabulaciones: ignoradas
- Saltos de línea (\n, \r): ignorados

### 9. **Manejo de Errores**

Token `DESCONOCIDO` para capturar caracteres no reconocidos:

```
DESCONOCIDO: .
```

Ejemplos de errores detectados:
- `$` → Error léxico (símbolo desconocido)
- `#` → Error léxico (símbolo desconocido)
- `@` al inicio de línea → Error léxico

---

## Compilación y Uso

### Requisitos
- ANTLR4 (versión 4.9+)
- Java Runtime Environment (JRE)

### Pasos para Compilar

1. **Generar código Java desde la gramática:**
   ```bash
   antlr4 -Dlanguage=Java -visitor -no-listener MiLenguaje.g4
   ```

2. **Compilar el código generado:**
   ```bash
   javac *.java
   ```

3. **Crear un analizador léxico:**
   ```bash
   grun MiLenguaje -tokens <archivo_entrada.ej>
   ```

### Ejemplo de Uso Programático (Java)

```java
import org.antlr.v4.runtime.*;

public class AnalizadorLexico {
    public static void main(String[] args) throws Exception {
        // Leer archivo fuente
        CharStream input = CharStreams.fromFileName("programa.ej");
        
        // Crear lexer
        MiLenguajeLexer lexer = new MiLenguajeLexer(input);
        
        // Obtener todos los tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();
        
        // Mostrar tokens
        for (Token token : tokens.getTokens()) {
            String tokenType = MiLenguajeParser.tokenNames[token.getType()];
            System.out.println(String.format(
                "(%s, %s) en línea %d, columna %d",
                tokenType,
                token.getText(),
                token.getLine(),
                token.getCharPositionInLine()
            ));
        }
    }
}
```

---

## Ejemplo de Entrada y Salida

### Entrada (programa.ej)
```java
publico clase Prueba {
    entero x = 10;
    si(x > 5) {
        imprimir("Hola");
    }
}
```

### Salida Esperada
```
(PUBLICO, publico) en línea 1, columna 0
(CLASE, clase) en línea 1, columna 8
(IDENTIFICADOR, Prueba) en línea 1, columna 14
(LLAVE_ABIERTA, {) en línea 1, columna 20
(ENTERO, entero) en línea 2, columna 4
(IDENTIFICADOR, x) en línea 2, columna 11
(ASIGNACION, =) en línea 2, columna 13
(NUMERO_ENTERO, 10) en línea 2, columna 15
(PUNTO_COMA, ;) en línea 2, columna 17
(SI, si) en línea 3, columna 4
(PAREN_ABIERTO, () en línea 3, columna 6
(IDENTIFICADOR, x) en línea 3, columna 7
(MAYOR, >) en línea 3, columna 9
(NUMERO_ENTERO, 5) en línea 3, columna 11
(PAREN_CERRADO, )) en línea 3, columna 12
(LLAVE_ABIERTA, {) en línea 3, columna 14
(IMPRIMIR, imprimir) en línea 4, columna 8
(PAREN_ABIERTO, () en línea 4, columna 16
(CADENA_LITERAL, "Hola") en línea 4, columna 17
(PAREN_CERRADO, )) en línea 4, columna 23
(PUNTO_COMA, ;) en línea 4, columna 24
(LLAVE_CERRADA, }) en línea 5, columna 4
(LLAVE_CERRADA, }) en línea 6, columna 0
```

---

## Características Principales

✅ **Palabras clave completas en español**
✅ **Operadores estándar de programación**
✅ **Soporte para números enteros y flotantes**
✅ **Manejo de cadenas con escape sequences**
✅ **Comentarios de línea y bloque**
✅ **Identificadores válidos (validación básica)**
✅ **Funciones matemáticas españolas**
✅ **Detección de errores léxicos**
✅ **Información de línea y columna para errores**
✅ **Diseño extensible para futuro parser**

---

## Próximas Fases

### Fase 2: Parser (Próximamente)
- Reglas sintácticas para la estructura del programa
- Validación de construcciones gramaticales
- Generación de Árbol de Sintaxis Abstracta (AST)

### Fase 3: Análisis Semántico
- Verificación de tipos
- Validación de alcance (scope)
- Table de símbolos

### Fase 4: Generación de Código
- Traducción a bytecode de Java o código intermedio
- Optimizaciones

---

## Notas Importantes

1. **Orden de reglas:** Las palabras reservadas se definen antes que los identificadores para evitar conflictos de precedencia.

2. **Fragmentos:** Se utilizan fragmentos (`fragment`) para reutilizar patrones como `DIGITOS`.

3. **Acciones skip:** Los comentarios y espacios en blanco usan `-> skip` para ser ignorados por el parser.

4. **Errores léxicos:** El token `DESCONOCIDO` captura cualquier carácter no reconocido, permitiendo manejo de errores robusto.

5. **Extensibilidad:** La estructura modular permite agregar nuevas palabras clave, operadores o funciones fácilmente.

---

## Archivo de Prueba

Ver `ejemplos/prueba_lexer.ej` para un programa de ejemplo completo en EspañolJava que demuestra el uso de todas las características del lexer.
