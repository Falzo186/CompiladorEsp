# 🚀 INSTRUCCIONES RÁPIDAS PARA HACER LAS PRUEBAS

**Tu Lexer está completamente compilado y listo para usar.**

---

## ⚡ OPCIÓN 1: Script Automático (RECOMENDADO)

### Paso 1: Abre PowerShell

Presiona `Windows + X` → Selecciona "Windows PowerShell"

### Paso 2: Ejecuta el script

```powershell
cd "c:\Users\alexp\CompiladorEsp"
powershell -ExecutionPolicy Bypass -File .\ejecutar_pruebas.ps1
```

**Esto ejecutará automáticamente todos los 5 casos y te mostrará los resultados.**

---

## ⚙️ OPCIÓN 2: Ejecutar Cada Caso Manualmente

### Preparación (una sola vez por sesión)

Abre PowerShell y copia esto:

```powershell
$env:PATH = "C:\antlr;$env:PATH"
$env:CLASSPATH = "C:\antlr\antlr-4.13.0-complete.jar;C:\Users\alexp\CompiladorEsp"
cd "c:\Users\alexp\CompiladorEsp"
```

### Ahora ejecuta los casos:

**CASO 1 - Básico:**
```powershell
grun MiLenguaje programa -tokens ejemplos/caso1_basico.ej
```

**CASO 2 - Funciones Matemáticas:**
```powershell
grun MiLenguaje programa -tokens ejemplos/caso2_matematicas.ej
```

**CASO 3 - Estrés:**
```powershell
grun MiLenguaje programa -tokens ejemplos/caso3_estres.ej
```

**CASO 4 - Errores:**
```powershell
grun MiLenguaje programa -tokens ejemplos/caso4_errores.ej
```

**CASO 5 - Completo:**
```powershell
grun MiLenguaje programa -tokens ejemplos/caso5_completo.ej
```

---

## ✅ Qué Significa la Salida

Cada línea se ve así:

```
[@0,37:43='publico',<'publico'>,2:0]
```

✅ **BUENA SEÑAL:** Ves tokens correctamente tokenizados
❌ **MALA SEÑAL:** Ves mensajes de error

Si ves muchas líneas de tokens sin errores = **FUNCIONANDO PERFECTO** ✅

---

## 📊 Resultados Esperados

| Caso | Qué Buscar | Resultado |
|------|-----------|-----------|
| **CASO 1** | Palabras: publico, clase, entero | ✅ Si las ve |
| **CASO 2** | Palabras: potencia, raiz, seno, coseno | ✅ Si todas aparecen |
| **CASO 3** | Muchos tokens sin errores (40+) | ✅ Si procesa sin fallos |
| **CASO 4** | Token "DESCONOCIDO" en línea 3 y 4 | ✅ Si los detecta |
| **CASO 5** | Todos los tokens de un programa | ✅ Si procesa 70+ tokens |

---

## 🎯 Resumen de Archivos para Pruebas

```
c:\Users\alexp\CompiladorEsp\
├── ejecutar_pruebas.ps1          👈 EJECUTA ESTO (script automático)
├── COMO_HACER_PRUEBAS.md         👈 GUÍA DETALLADA
├── REPORTE_PRUEBAS.md            👈 REPORTE COMPLETO
├── MiLenguaje.g4                 (gramática - ya compilada)
├── MiLenguajeLexer.class         (compilado - listo para usar)
├── ejemplos/
│   ├── caso1_basico.ej
│   ├── caso2_matematicas.ej
│   ├── caso3_estres.ej
│   ├── caso4_errores.ej
│   └── caso5_completo.ej
```

---

## 📝 Paso a Paso Simplificado

### 1. Abre PowerShell

### 2. Copia y Pega ESTO:

```powershell
$env:PATH = "C:\antlr;$env:PATH"; $env:CLASSPATH = "C:\antlr\antlr-4.13.0-complete.jar;C:\Users\alexp\CompiladorEsp"; cd "c:\Users\alexp\CompiladorEsp"; grun MiLenguaje programa -tokens ejemplos/caso1_basico.ej
```

### 3. Presiona Enter

**Si ves tokens (montones de líneas con @ y números) = ✅ FUNCIONA**

---

## ❓ Solución Rápida de Problemas

| Problema | Solución |
|----------|----------|
| "grun: no se encontró" | Copia la línea de preparación (arriba) |
| "Archivo no encontrado" | Verifica: `cd "c:\Users\alexp\CompiladorEsp"` |
| Veo muchos errores | Revisa que los archivos .ej existan: `ls ejemplos/` |

---

## 🎓 ¿Qué Significa si TODO Funciona?

✅ El lexer reconoce palabras clave españolas
✅ Reconoce números, operadores, identificadores
✅ Detecta errores léxicos (símbolos inválidos)
✅ **Tu lenguaje EspañolJava está LISTO** 🎉

---

## 🔗 Archivos Útiles

- **REPORTE_PRUEBAS.md** - Reporte detallado de todas las pruebas
- **COMO_HACER_PRUEBAS.md** - Guía completa con más detalles
- **REFERENCIA_RAPIDA.md** - Hoja de referencia del lenguaje

---

**¿Problemas? Lee COMO_HACER_PRUEBAS.md para más detalles.**
