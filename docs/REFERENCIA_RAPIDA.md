# Referencia Rápida - EspañolJava Lexer

## 📌 Comandos Esenciales

```bash
# Compilar gramática ANTLR4
antlr4 -Dlanguage=Java -visitor -no-listener MiLenguaje.g4

# Compilar código Java generado
javac *.java

# Probar lexer con archivo de entrada
grun MiLenguaje -tokens ejemplos/prueba_lexer.ej

# Todo en uno (Windows)
compilar.bat

# Todo en uno (Linux/macOS)
bash compilar.sh
```

---

## 🔤 Palabras Clave en Español

### Control
`publico` `privado` `protegido` `estatico`

### Tipos
`entero` `decimal` `booleano` `cadena` `vacio`

### Estructura
`clase` `interfaz` `extiende` `implementa`

### Control de Flujo
`si` `sino` `mientras` `para` `hacer` `ruptura` `continuar`

### Retorno
`retornar` `nuevo`

### Excepciones
`intentar` `capturar` `finalmente` `lanzar`

### Módulos
`importar` `paquete`

### Valores
`verdadero` `falso` `nulo`

### Matemáticas
`potencia` `raiz` `seno` `coseno` `logaritmo` `aleatorio` `absoluto` `minimo` `maximo`

### I/O
`imprimir` `leer`

---

## 🔧 Operadores

### Aritméticos
| Símbolo | Uso | Ejemplo |
|---------|-----|---------|
| `+` | Suma | `a + b` |
| `-` | Resta | `a - b` |
| `*` | Multiplicación | `a * b` |
| `/` | División | `a / b` |
| `%` | Módulo | `a % b` |
| `**` o `^` | Potencia | `potencia(a, b)` |

### Comparación
| Símbolo | Significado | Ejemplo |
|---------|-------------|---------|
| `==` | Igual | `a == b` |
| `!=` | Diferente | `a != b` |
| `<` | Menor | `a < b` |
| `>` | Mayor | `a > b` |
| `<=` | Menor o igual | `a <= b` |
| `>=` | Mayor o igual | `a >= b` |

### Lógicos
| Símbolo | Significado | Ejemplo |
|---------|-------------|---------|
| `&&` | Y lógico | `a && b` |
| `\|\|` | O lógico | `a \|\| b` |
| `!` | Negación | `!a` |

### Asignación
| Símbolo | Uso | Ejemplo |
|---------|-----|---------|
| `=` | Asignar | `x = 5` |
| `+=` | Sumar y asignar | `x += 5` |
| `-=` | Restar y asignar | `x -= 5` |
| `*=` | Multiplicar y asignar | `x *= 5` |
| `/=` | Dividir y asignar | `x /= 5` |

### Especiales
| Símbolo | Uso | Ejemplo |
|---------|-----|---------|
| `++` | Incremento | `x++` |
| `--` | Decremento | `x--` |
| `?` `:` | Ternario | `x > 0 ? a : b` |

---

## 🎯 Delimitadores

| Símbolo | Nombre | Uso |
|---------|--------|-----|
| `{` `}` | Llaves | Bloques de código |
| `(` `)` | Paréntesis | Funciones, parámetros |
| `[` `]` | Corchetes | Arrays (futuro) |
| `;` | Punto y coma | Fin de sentencia |
| `,` | Coma | Separar elementos |
| `.` | Punto | Acceso a miembros |
| `@` | Arroba | Anotaciones (futuro) |

---

## 📝 Identificadores

**Formato válido:**
```
[a-zA-Z_][a-zA-Z0-9_]*
```

**Válidos:**
- `x` `contador` `variable1`
- `_privado` `MiFuncion` `valor_total`

**Inválidos:**
- `123abc` (comienza con número)
- `@dato` (símbolo especial)
- `mi-variable` (guion no permitido)

---

## 🔢 Números

**Enteros:** `0` `42` `1000` `-5`

**Flotantes:** `3.14` `.5` `5.` `1e5` `1.5e-2` `1E+10`

---

## 📄 Cadenas

**Formato:**
```
"cadena aquí"    // Comillas dobles
'cadena aquí'    // Comillas simples
```

**Escapes válidos:**
```
\n    Nueva línea
\t    Tabulación
\r    Retorno
\\    Barra invertida
\"    Comilla doble
\'    Comilla simple
```

**Ejemplo:**
```
"Hola\nmundo"    // Imprime:
                 // Hola
                 // mundo
```

---

## 💬 Comentarios

**Línea simple:**
```
// Esto es un comentario
```

**Bloque múltiple:**
```
/* Esto es un
   comentario de
   múltiples líneas */
```

---

## 📋 Estructura Básica

```java
paquete ejemplos;

importar java.util.*;

publico clase MiClase {
    
    privado entero variable = 10;
    
    publico vacio metodo() {
        si (variable > 5) {
            imprimir("Mayor a 5");
        }
    }
}
```

---

## 🎓 Ejemplo: Función Fibonacci

```java
publico entero fibonacci(entero n) {
    si (n <= 1) {
        retornar n;
    }
    retornar fibonacci(n - 1) + fibonacci(n - 2);
}
```

---

## 🔍 Errores Comunes

| Error | Causa | Solución |
|-------|-------|----------|
| `Palabra clave no reconocida` | Mayúsculas incorrecto | Usar minúsculas: `Entero` → `entero` |
| `Símbolo desconocido $` | Operador inválido | No existe en EspañolJava |
| `Identificador inicia con número` | `123var` | Iniciar con letra: `var123` |
| `Comilla sin cerrar` | `"texto` | Cerrar comilla: `"texto"` |
| `Operador & incompleto` | `a & b` | Usar `&&` para AND |
| `Comentario sin cerrar` | `/* comentario` | Cerrar: `/* ... */` |

---

## 🚀 Ejemplo Completo

```java
publico clase Calculadora {
    
    publico decimal sumar(decimal a, decimal b) {
        retornar a + b;
    }
    
    publico decimal restar(decimal a, decimal b) {
        retornar a - b;
    }
    
    publico decimal multiplicar(decimal a, decimal b) {
        retornar a * b;
    }
    
    publico decimal dividir(decimal a, decimal b) {
        si (b != 0) {
            retornar a / b;
        } sino {
            imprimir("Error: División por cero");
            retornar 0;
        }
    }
    
    publico decimal potenciacion(decimal base, decimal exponente) {
        retornar potencia(base, exponente);
    }
}
```

---

## 📊 Resumen de Tokens

| Tipo | Cantidad | Ejemplos |
|------|----------|----------|
| Palabras clave | 40+ | `publico`, `clase`, `si` |
| Operadores | 25+ | `+`, `==`, `&&` |
| Delimitadores | 10 | `{`, `}`, `;` |
| Identificadores | Ilimitado | `x`, `contador`, `var1` |
| Números | Ilimitado | `42`, `3.14` |
| Cadenas | Ilimitado | `"texto"` |
| Comentarios | Ignorados | `// texto` |
| Errores | Token DESCONOCIDO | `$`, `#` |

---

## 🔗 Acceso Rápido a Documentación

- **Guía completa:** [LEXER_README.md](LEXER_README.md)
- **Especificación técnica:** [ESPECIFICACION_TECNICA.md](ESPECIFICACION_TECNICA.md)
- **Ejemplos:** [ejemplos/prueba_lexer.ej](ejemplos/prueba_lexer.ej)
- **Errores:** [ejemplos/errores_lexicos.ej](ejemplos/errores_lexicos.ej)
- **Gramática:** [MiLenguaje.g4](MiLenguaje.g4)

---

## ✨ Características Destacadas

✅ Palabras clave completamente en español
✅ Operadores estándar de programación
✅ Manejo de números enteros y flotantes
✅ Cadenas con escape sequences
✅ Comentarios de línea y bloque
✅ Funciones matemáticas españolas
✅ Detección de errores léxicos
✅ Información precisa de línea/columna
✅ Diseño extensible y modular
✅ Código generado automáticamente con ANTLR4

---

**Versión:** 1.0 | **Fase:** Lexer Completa | **Fecha:** Abril de 2026
