#!/usr/bin/env pwsh
<#
.SYNOPSIS
    Script de ejecución rápida para EspañolJava Compiler
    
.DESCRIPTION
    Compila y ejecuta el compilador EspañolJava en modo consola interactivo
    
.PARAMETER Clean
    Limpia los archivos compilados antes de compilar
    
.PARAMETER NoCompile
    Ejecuta sin compilar (supone que ya está compilado)
    
.PARAMETER Test
    Ejecuta prueba de lexer solo
    
.EXAMPLE
    .\compilador.ps1                    # Compilar y ejecutar modo interactivo
    .\compilador.ps1 -Clean             # Limpiar y compilar
    .\compilador.ps1 -NoCompile         # Solo ejecutar (sin compilar)
    .\compilador.ps1 -Test              # Prueba lexer
#>

param(
    [switch]$Clean,
    [switch]$NoCompile,
    [switch]$Test
)

$ErrorActionPreference = "Stop"

# Configuración
$ProjectRoot = Split-Path -Parent $MyInvocation.MyCommandPath
$BuildDir = Join-Path $ProjectRoot "build"
$AntlrJar = "C:\Users\alexp\Downloads\antlr-4.13.2-complete.jar"
$JavaExe = "C:\Program Files\Java\jdk-11.0.31\bin\java.exe"

# Colores para output
$colors = @{
    Success = "Green"
    Error   = "Red"
    Info    = "Cyan"
    Warn    = "Yellow"
}

function Write-Log {
    param([string]$Message, [string]$Type = "Info")
    Write-Host $Message -ForegroundColor $colors[$Type]
}

# Verificar prerequisitos
function Test-Prerequisites {
    Write-Log "🔍 Verificando prerequisitos..." "Info"
    
    if (-not (Test-Path $AntlrJar)) {
        Write-Log "❌ Error: No se encuentra ANTLR JAR en: $AntlrJar" "Error"
        exit 1
    }
    
    if (-not (Test-Path $JavaExe)) {
        Write-Log "❌ Error: No se encuentra Java en: $JavaExe" "Error"
        exit 1
    }
    
    Write-Log "✓ Prerequisitos OK" "Success"
}

# Limpiar build
function Invoke-Clean {
    Write-Log "🗑️  Limpiando directorio build..." "Info"
    if (Test-Path $BuildDir) {
        Remove-Item $BuildDir -Recurse -Force
        Write-Log "✓ Limpieza completada" "Success"
    }
}

# Compilar
function Invoke-Compile {
    Write-Log "🔨 Compilando proyecto..." "Info"
    
    Push-Location $ProjectRoot
    try {
        cmd /c "bin\compilar.bat" | ForEach-Object { 
            if ($_ -match "error|Error|ERROR") {
                Write-Host $_ -ForegroundColor Red
            } else {
                Write-Host $_
            }
        }
        
        if ($LASTEXITCODE -ne 0) {
            Write-Log "❌ Compilación fallida" "Error"
            exit 1
        }
        Write-Log "✓ Compilación exitosa" "Success"
    }
    finally {
        Pop-Location
    }
}

# Ejecutar modo interactivo
function Invoke-Interactive {
    Write-Log "🎯 Iniciando modo consola interactivo..." "Info"
    Write-Log "════════════════════════════════════════════════════════" "Info"
    
    Push-Location $ProjectRoot
    try {
        & $JavaExe -cp "build\classes;$AntlrJar" com.compilador.ej.Main
    }
    catch {
        Write-Log "❌ Error: $_" "Error"
        exit 1
    }
    finally {
        Pop-Location
    }
}

# Ejecutar prueba lexer
function Invoke-Test {
    Write-Log "🧪 Ejecutando prueba de lexer..." "Info"
    
    Push-Location $ProjectRoot
    try {
        & $JavaExe -cp "build\classes;$AntlrJar" `
            com.compilador.ej.lexer.LexerMain `
            resources\examples\caso1_basico.ej
    }
    catch {
        Write-Log "❌ Error: $_" "Error"
        exit 1
    }
    finally {
        Pop-Location
    }
}

# Main
function Main {
    Write-Host ""
    Write-Host "╔════════════════════════════════════════════════════════╗" -ForegroundColor Cyan
    Write-Host "║       🎯 COMPILADOR ESPAÑOLJAVA - SCRIPT RÁPIDO        ║" -ForegroundColor Cyan
    Write-Host "╚════════════════════════════════════════════════════════╝" -ForegroundColor Cyan
    Write-Host ""
    
    Test-Prerequisites
    
    if ($Clean) {
        Invoke-Clean
    }
    
    if (-not $NoCompile) {
        Invoke-Compile
    }
    
    if ($Test) {
        Invoke-Test
    } else {
        Invoke-Interactive
    }
}

# Ejecutar
Main
