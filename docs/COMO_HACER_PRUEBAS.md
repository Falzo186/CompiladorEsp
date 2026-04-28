# 🧪 Guía Completa para Ejecutar Pruebas del Lexer EspañolJava

## ⚡ Requisitos Previos

✅ Java 8+ instalado
✅ Archivos compilados listos (`.class` y `.jar`)
✅ Terminal/PowerShell disponible

---

## 📝 Paso 1: Compilar el Proyecto

Abre PowerShell y ve a la carpeta del proyecto:

```powershell
cd "c:\Users\alexp\CompiladorEsp"
```

Compila el proyecto (esto genera los archivos ANTLR4 y compila):

```powershell
.\bin\compilar.bat
```

**Deberías ver:** `OK - Compilacion completada`

Verifica que se haya creado el directorio de clases:

```powershell
ls build\classes\com\compilador\ej
```

---

## 🔧 Paso 2: Ejecutar una Prueba

Ahora ejecuta una prueba usando el nuevo lexer compilado:

```powershell
$ANTLR4 = 'C:\antlr\antlr-4.13.0-complete.jar'
java -cp "build\classes;$ANTLR4" com.compilador.ej.lexer.LexerMain resources\examples\caso1_basico.ej
```

**IMPORTANTE:** Las pruebas ahora están en `resources/examples/` (nueva estructura clean architecture)

---

## ✅ Paso 3: Probar Cada Caso

### CASO 1: Programa Básico Válido

```powershell
$ANTLR4 = 'C:\antlr\antlr-4.13.0-complete.jar'
java -cp "build\classes;$ANTLR4" com.compilador.ej.lexer.LexerMain resources\examples\caso1_basico.ej
```

**Esperado:** Deberías ver algo como:
```
[@0] Línea 2, Col 0: 'publico' [Tipo: 'publico']
[@1] Línea 2, Col 8: 'clase' [Tipo: 'clase']
...
Total de tokens: 21
OK - Analisis completado sin errores
```

**Si ves esto:** ✅ CASO 1 PASADO

---

### CASO 2: Funciones Matemáticas (IMPORTANTE)

```powershell
$ANTLR4 = 'C:\antlr\antlr-4.13.0-complete.jar'
java -cp "build\classes;$ANTLR4" com.compilador.ej.lexer.LexerMain resources\examples\caso2_matematicas.ej
```

**Busca líneas como estas:**
```
[@X] Línea Y, Col Z: 'potencia' [Tipo: 'potencia']
[@X] Línea Y, Col Z: 'raiz' [Tipo: 'raiz']
[@X] Línea Y, Col Z: 'seno' [Tipo: 'seno']
```

**Si ves `[Tipo: 'potencia']`, `[Tipo: 'raiz']`, etc.:** ✅ CASO 2 PASADO

---

### CASO 3: Programa de Estrés

```powershell
$ANTLR4 = 'C:\antlr\antlr-4.13.0-complete.jar'
java -cp "build\classes;$ANTLR4" com.compilador.ej.lexer.LexerMain resources\examples\caso3_estres.ej
```

**Esperado:** Muchos tokens sin errores (40+)

**Si no hay errores:** ✅ CASO 3 PASADO

---

### CASO 4: Detectar Errores Léxicos

```powershell
$ANTLR4 = 'C:\antlr\antlr-4.13.0-complete.jar'
java -cp "build\classes;$ANTLR4" com.compilador.ej.lexer.LexerMain resources\examples\caso4_errores.ej
```

**Busca estos tokens DESCONOCIDOS:**
```
[@X] Línea 3, Col 6: '$' [Tipo: DESCONOCIDO]
[@X] Línea 4, Col 5: '#' [Tipo: DESCONOCIDO]
```

**Si ves DESCONOCIDO con línea y columna:** ✅ CASO 4 PASADO

---

### CASO 5: Demo Completa

```powershell
$ANTLR4 = 'C:\antlr\antlr-4.13.0-complete.jar'
java -cp "build\classes;$ANTLR4" com.compilador.ej.lexer.LexerMain resources\examples\caso5_completo.ej
```

**Esperado:** 72 tokens correctamente procesados

**Si no hay errores:** ✅ CASO 5 PASADO

---

## 🎯 Script Automatizado para Todos los Casos

Copia y pega esto en PowerShell para ejecutar TODOS los casos de una vez:

```powershell
cd "c:\Users\alexp\CompiladorEsp"
$ANTLR4 = 'C:\antlr\antlr-4.13.0-complete.jar'
$casos = @('caso1_basico', 'caso2_matematicas', 'caso3_estres', 'caso4_errores', 'caso5_completo')

foreach ($caso in $casos) {
    Write-Host "\n================================" -ForegroundColor Cyan
    Write-Host "Prueba: $caso" -ForegroundColor Yellow
    Write-Host "================================"
    java -cp "build\classes;$ANTLR4" com.compilador.ej.lexer.LexerMain "resources\examples\$caso.ej"
}
```

---

## 📊 Interpretar los Resultados

Cada línea de salida tiene este formato:

```
[@N] Línea LINE, Col COL: 'TEXT' [Tipo: TYPE]
```

**Ejemplo:**
```
[@0] Línea 2, Col 0: 'publico' [Tipo: 'publico']
```

| Parte | Significado |
|-------|----------|
| `@0` | Número de token (0, 1, 2, ...) |
| `Línea 2` | Número de línea en el archivo |
| `Col 0` | Número de columna |
| `'publico'` | Texto original |
| `[Tipo: 'publico']` | Tipo de token (la palabra clave) |

---

## ✅ Checklist de Validación

Marca cada uno mientras pruebas:

```
CASO 1: Básico
- ☐ Reconoce "publico"
- ☐ Reconoce "clase"
- ☐ Reconoce "entero"
- ☐ Reconoce números (10, 3.14)
- ☐ Sin errores

CASO 2: Matemáticas ⭐
- ☐ Reconoce "potencia"
- ☐ Reconoce "raiz"
- ☐ Reconoce "seno"
- ☐ Reconoce "coseno"
- ☐ Reconoce "logaritmo"
- ☐ Sin errores

CASO 3: Estrés
- ☐ Procesa sin errores
- ☐ Reconoce "si" y "mientras"
- ☐ Reconoce "++"
- ☐ 40+ tokens

CASO 4: Errores
- ☐ Ve "$" como DESCONOCIDO
- ☐ Ve "#" como DESCONOCIDO
- ☐ Reporta línea y columna correcto

CASO 5: Completo
- ☐ Procesa sin errores
- ☐ Reconoce "paquete"
- ☐ Reconoce "imprimir"
- ☐ 72 tokens
```

---

## 🐛 Troubleshooting

### Error: "NoSuchFileException: ejemplos\caso1_basico.ej"

**Solución:** Los archivos están en `resources/examples/` (nueva estructura):
```powershell
cd "c:\Users\alexp\CompiladorEsp"
ls resources\examples
```

### Error: "cannot find symbol" o "MiLenguajeLexer cannot be resolved"

**Solución:** Compila el proyecto:
```powershell
cd "c:\Users\alexp\CompiladorEsp"
.\bin\compilar.bat
```

### Error: "antlr4: no se reconoce"

**Solución:** Asegúrate que ANTLR4 esté en PATH o usa el script compilar.bat que lo maneja automáticamente

### Error: "build\classes no existe"

**Solución:** Ejecuta la compilación:
```powershell
.\bin\compilar.bat
```

---

## 🚀 Comando Rápido (Copia y Pega)

**Opción 1: Script automatizado**
```powershell
cd "c:\Users\alexp\CompiladorEsp"; .\bin\compilar.bat test
```

**Opción 2: Manual (cualquier caso)**
```powershell
cd "c:\Users\alexp\CompiladorEsp"; $A='C:\antlr\antlr-4.13.0-complete.jar'; java -cp "build\classes;$A" com.compilador.ej.lexer.LexerMain resources\examples\caso1_basico.ej
```

---

## 📁 Estructura de Carpetas

Verifica que tengas esta estructura (clean architecture):

```
c:\Users\alexp\CompiladorEsp\
├── grammar/
│   └── MiLenguaje.g4              ✅ Gramática
├── src/main/java/com/compilador/ej/
│   ├── lexer/
│   │   ├── LexerEJ.java           ✅ Lexer principal
│   │   └── LexerMain.java         ✅ Punto de entrada
│   └── gen/                        (código generado ANTLR4)
├── build/classes/                  ✅ Archivos compilados
├── resources/examples/
│   ├── caso1_basico.ej            ✅ Archivo de prueba
│   ├── caso2_matematicas.ej       ✅ Archivo de prueba
│   ├── caso3_estres.ej            ✅ Archivo de prueba
│   ├── caso4_errores.ej           ✅ Archivo de prueba
│   └── caso5_completo.ej          ✅ Archivo de prueba
├── bin/compilar.bat               ✅ Script de compilación
└── docs/                           ✅ Documentación
```

---

## 💡 Tips Útiles

### Ver solo los errores (tokens DESCONOCIDO)

```powershell
$ANTLR4 = 'C:\antlr\antlr-4.13.0-complete.jar'
java -cp "build\classes;$ANTLR4" com.compilador.ej.lexer.LexerMain resources\examples\caso4_errores.ej | Select-String DESCONOCIDO
```

### Guardar salida en archivo

```powershell
$ANTLR4 = 'C:\antlr\antlr-4.13.0-complete.jar'
java -cp "build\classes;$ANTLR4" com.compilador.ej.lexer.LexerMain resources\examples\caso1_basico.ej > salida.txt
```

---

## 🎓 Próximos Pasos

Una vez que confirmes que todos los casos pasan:

1. ✅ Fase 1: LEXER - **COMPLETADA**
2. 🔄 Fase 2: PARSER - Próxima
3. 📋 Fase 3: Análisis Semántico
4. 🔨 Fase 4: Generación de Código

---

**¿Tienes algún problema? Revisa:**
1. ¿Estás en la carpeta correcta?
2. ¿Está configurado PATH y CLASSPATH?
3. ¿Existen los archivos .class?
4. ¿Existen los archivos .ej en ejemplos/?

---

*Última actualización: 27 de Abril de 2026*
