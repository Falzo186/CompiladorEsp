/**
 * ⚠️  ESTE ARCHIVO ESTÁ EN CONSTRUCCIÓN - v1.0
 * 
 * Gramática ANTLR4 - Componente PARSER (Analizador Sintáctico)
 * Lenguaje de programación que combina sintaxis Java con palabras clave en español
 * 
 * Este archivo define:
 * - Reglas sintácticas del programa
 * - Estructura de sentencias y expresiones
 * - Precedencia de operadores
 * - Reglas para: clases, métodos, parámetros, retornos, control de flujo
 * 
 * Fases Implementadas:
 * ✅ Fase A: Condicionales (if/else) con pattern emparejada/no-emparejada
 * ✅ Fase B1: Métodos sin parámetros
 * ✅ Fase B2.1: Métodos con parámetros tipados
 * ✅ Fase B2.2: Retorno de valores desde métodos
 * ✅ Fase C1: Declaración de clases
 * ✅ Fase C2.1: Atributos de clases
 * ✅ Fase C2.2: Métodos como miembros de clases
 * 
 * Autor: CompiladorEsp
 * Versión: 1.0
 * Estado: Fase 1-3 completadas | Mejoras en construcción
 */

parser grammar MiLenguajeParser;

// Importar tokens del lexer separado
options { tokenVocab = MiLenguajeLexer; }

// ============================================================================
// REGLAS PARSER (Análisis Sintáctico)
// ============================================================================

programa
    : elemento+ EOF
    ;

elemento
    : sentencia
    | clase
    ;

sentencia
    : sentenciaEmparejada
    | condicionNoEmparejada
    ;

sentenciaEmparejada
    : declaracion
    | impresion
    | metodo
    | condicionEmparejada
    | ciclo
    | paraStmt
    | retorno
    | exprStmt
    | bloque
    ;

// ============================================================================
// REGLAS PARA MÉTODOS Y CLASES (Fases B y C)
// ============================================================================

metodo
    : modificadorAcceso tipoRetorno IDENTIFICADOR PAREN_ABIERTO listaParametros? PAREN_CERRADO bloque
    ;

clase
    : modificadorAcceso CLASE IDENTIFICADOR LLAVE_ABIERTA miembro* LLAVE_CERRADA
    ;

miembro
    : atributo
    | metodo
    ;

atributo
    : tipo IDENTIFICADOR PUNTO_COMA
    ;

listaParametros
    : parametro (COMA parametro)*
    ;

parametro
    : tipo IDENTIFICADOR
    ;

modificadorAcceso
    : PUBLICO
    | PRIVADO
    | PROTEGIDO
    ;

tipoRetorno
    : VACIO
    | tipo
    ;

// ============================================================================
// REGLAS PARA SENTENCIAS (Fases A-B)
// ============================================================================

declaracion
    : tipo IDENTIFICADOR ASIGNACION expr PUNTO_COMA
    ;

tipo
    : ENTERO
    | DECIMAL
    | CADENA
    | BOOLEANO
    ;

impresion
    : IMPRIMIR PAREN_ABIERTO expr PAREN_CERRADO PUNTO_COMA
    ;

condicion
    : condicionEmparejada
    | condicionNoEmparejada
    ;

condicionEmparejada
    : SI PAREN_ABIERTO expr PAREN_CERRADO sentenciaEmparejada SINO sentenciaEmparejada
    ;

condicionNoEmparejada
    : SI PAREN_ABIERTO expr PAREN_CERRADO sentencia
    | SI PAREN_ABIERTO expr PAREN_CERRADO sentenciaEmparejada SINO condicionNoEmparejada
    ;

ciclo
    : MIENTRAS PAREN_ABIERTO expr PAREN_CERRADO bloque
    ;

paraStmt
    : PARA PAREN_ABIERTO (declaracion | expr? PUNTO_COMA) expr? PUNTO_COMA expr? PAREN_CERRADO bloque
    ;

retorno
    : RETORNAR expr PUNTO_COMA
    ;

exprStmt
    : expr PUNTO_COMA
    ;

bloque
    : LLAVE_ABIERTA sentencia* LLAVE_CERRADA
    ;

// ============================================================================
// REGLAS DE EXPRESIONES CON PRECEDENCIA CORRECTA
// ============================================================================

expr
    : equalityExpr
    ;

equalityExpr
    : relationalExpr ((IGUALDAD | DESIGUALDAD) relationalExpr)*
    ;

relationalExpr
    : addExpr ((MENOR | MAYOR | MENOR_IGUAL | MAYOR_IGUAL) addExpr)*
    ;

addExpr
    : mulExpr ((SUMA | RESTA) mulExpr)*
    ;

mulExpr
    : unaryExpr ((MULT | DIV | MOD) unaryExpr)*
    ;

unaryExpr
    : (RESTA | SUMA | NOT_OP | INCREMENTO | DECREMENTO) unaryExpr
    | postfixExpr
    ;

postfixExpr
    : primary (INCREMENTO | DECREMENTO)?
    ;

primary
    : NUMERO_FLOTANTE
    | NUMERO_ENTERO
    | CADENA_LITERAL
    | IDENTIFICADOR
    | funcionMatematica
    | PAREN_ABIERTO expr PAREN_CERRADO
    ;

funcionMatematica
    : POTENCIA PAREN_ABIERTO expr COMA expr PAREN_CERRADO
    | RAIZ PAREN_ABIERTO expr PAREN_CERRADO
    | SENO PAREN_ABIERTO expr PAREN_CERRADO
    | COSENO PAREN_ABIERTO expr PAREN_CERRADO
    ;
