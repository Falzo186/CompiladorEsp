# ⚡ COPIAR Y PEGAR - COMANDOS DIRECTOS

## 🎯 ¿Quieres hacer las pruebas AHORA?

### Opción 1: AUTOMÁTICO (Lo más fácil)

1. **Abre PowerShell**
2. **Copia y pega esto:**

```powershell
cd "c:\Users\alexp\CompiladorEsp"; powershell -ExecutionPolicy Bypass -File .\ejecutar_pruebas.ps1
```

3. **Presiona Enter**

**LISTO.** Verás todos los casos probados automáticamente.

---

## 🛠️ Opción 2: MANUAL (Caso por caso)

### Preparación (una sola vez)

```powershell
$env:PATH = "C:\antlr;$env:PATH"; $env:CLASSPATH = "C:\antlr\antlr-4.13.0-complete.jar;C:\Users\alexp\CompiladorEsp"; cd "c:\Users\alexp\CompiladorEsp"
```

### Ahora prueba cada caso:

**CASO 1:**
```powershell
grun MiLenguaje programa -tokens ejemplos/caso1_basico.ej
```

**CASO 2:**
```powershell
grun MiLenguaje programa -tokens ejemplos/caso2_matematicas.ej
```

**CASO 3:**
```powershell
grun MiLenguaje programa -tokens ejemplos/caso3_estres.ej
```

**CASO 4:**
```powershell
grun MiLenguaje programa -tokens ejemplos/caso4_errores.ej
```

**CASO 5:**
```powershell
grun MiLenguaje programa -tokens ejemplos/caso5_completo.ej
```

---

## ✅ Interpretar Resultados

### ✅ LO QUE VAS A VER (ES CORRECTO)

```
[@0,37:43='publico',<'publico'>,2:0]
[@1,45:49='clase',<'clase'>,2:8]
[@2,51:56='Prueba',<IDENTIFICADOR>,2:14]
[@3,58:58='{',<'{'>,2:21]
```

**MUCHAS LÍNEAS = ÉXITO ✅**

### ❌ LO QUE NO QUEREMOS VER

```
error(...)
Exception
Cannot find
```

---

## 📊 Checklist Mínimo

Después de ejecutar, verifica:

```
CASO 1:
- ☐ Ves "publico", "clase", "entero" en los tokens

CASO 2:
- ☐ Ves "potencia", "raiz", "seno"

CASO 3:
- ☐ Funciona sin errores

CASO 4:
- ☐ Ves "DESCONOCIDO" en el output

CASO 5:
- ☐ Procesa muchos tokens (70+)
```

**Si todos pasan: ✅ LEXER FUNCIONA PERFECTAMENTE**

---

## 🔧 Si Algo Falla

### Error: "comando no reconocido"

Asegúrate de estar en la carpeta correcta:

```powershell
cd "c:\Users\alexp\CompiladorEsp"
dir
```

Deberías ver: `MiLenguaje.g4`, `MiLenguajeLexer.class`, carpeta `ejemplos/`

### Error: "grun no existe"

Ejecuta la preparación:

```powershell
$env:PATH = "C:\antlr;$env:PATH"; $env:CLASSPATH = "C:\antlr\antlr-4.13.0-complete.jar;C:\Users\alexp\CompiladorEsp"; cd "c:\Users\alexp\CompiladorEsp"
```

### Error: "archivo no encontrado"

Verifica que exista:

```powershell
ls ejemplos/caso1_basico.ej
```

Si no existe, revisa que tengas la carpeta correcta.

---

## 💡 Todo en Una Línea

Si quieres el comando MÁS CORTO posible para el CASO 1:

```powershell
$env:PATH="C:\antlr;$env:PATH"; $env:CLASSPATH="C:\antlr\antlr-4.13.0-complete.jar;C:\Users\alexp\CompiladorEsp"; cd c:\Users\alexp\CompiladorEsp; grun MiLenguaje programa -tokens ejemplos/caso1_basico.ej
```

---

## 📚 Documentación

Para más detalles, lee:

- **PRUEBAS_RAPIDO.md** ← EMPIEZA AQUÍ
- **COMO_HACER_PRUEBAS.md** ← Guía completa
- **INDICE_COMPLETO.md** ← Índice de todo

---

## 🎯 Resumen Ejecutivo

**OPCIÓN A (Recomendada):**
```
1. Abre PowerShell
2. Copia: cd "c:\Users\alexp\CompiladorEsp"; powershell -ExecutionPolicy Bypass -File .\ejecutar_pruebas.ps1
3. Presiona Enter
```

**OPCIÓN B (Manual):**
```
1. Abre PowerShell
2. Copia la línea de preparación
3. Copia los comandos grun de arriba (uno por uno)
```

---

**¿LISTO? ⚡ Copia cualquiera de los comandos arriba y presiona Enter.**

*Última actualización: 27 de Abril de 2026*
