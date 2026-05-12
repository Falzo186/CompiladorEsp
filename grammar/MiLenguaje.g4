/**
 * Gramática ANTLR4 para EspañolJava
 * Lenguaje de programación que combina sintaxis Java con palabras clave en español
 * Fase 1: Analizador Léxico (Lexer)
 * 
 * Autor: CompiladorEsp
 * Versión: 1.0
 */

grammar MiLenguaje;

// ============================================================================
// PALABRAS RESERVADAS EN ESPAÑOL (Orden importa - más específicas primero)
// ============================================================================

// Palabras clave de control de acceso
PUBLICO      : 'publico';
PRIVADO      : 'privado';
PROTEGIDO    : 'protegido';
ESTATICO     : 'estatico';

// Palabras clave de tipos
ENTERO       : 'entero';
DECIMAL      : 'decimal';
BOOLEANO     : 'booleano';
CADENA       : 'cadena';
VACIO        : 'vacio';

// Palabras clave estructurales
CLASE        : 'clase';
INTERFAZ     : 'interfaz';
EXTIENDE     : 'extiende';
IMPLEMENTA   : 'implementa';

// Palabras clave de control de flujo
SI           : 'si';
SINO         : 'sino';
MIENTRAS     : 'mientras';
PARA         : 'para';
HACER        : 'hacer';
RUPTURA      : 'ruptura';
CONTINUAR    : 'continuar';

// Palabras clave de retorno
RETORNAR     : 'retornar';
NUEVO        : 'nuevo';

// Palabras clave de manejo de excepciones
INTENTAR     : 'intentar';
CAPTURAR     : 'capturar';
FINALMENTE   : 'finalmente';
LANZAR       : 'lanzar';

// Palabras clave de módulos
IMPORTAR     : 'importar';
PAQUETE      : 'paquete';

// Valores booleanos y nulo
VERDADERO    : 'verdadero';
FALSO        : 'falso';
NULO         : 'nulo';

// Funciones matemáticas estilo español
POTENCIA     : 'potencia';
RAIZ         : 'raiz';
SENO         : 'seno';
COSENO       : 'coseno';
LOGARITMO    : 'logaritmo';
ALEATORIO    : 'aleatorio';
ABSOLUTO     : 'absoluto';
MINIMO       : 'minimo';
MAXIMO       : 'maximo';

// Función de entrada/salida
IMPRIMIR     : 'imprimir';
LEER         : 'leer';

// ============================================================================
// OPERADORES (Orden importante: operadores más largos primero)
// ============================================================================

// Operadores de comparación y lógica
IGUALDAD     : '==';
DESIGUALDAD  : '!=';
MENOR_IGUAL  : '<=';
MAYOR_IGUAL  : '>=';
MENOR        : '<';
MAYOR        : '>';
AND_OP       : '&&';
OR_OP        : '||';
NOT_OP       : '!';

// Operadores aritméticos
SUMA         : '+';
RESTA        : '-';
MULT         : '*';
DIV          : '/';
MOD          : '%';
POTENCIA_OP  : '**' | '^';

// Operadores de incremento/decremento
INCREMENTO   : '++';
DECREMENTO   : '--';

// Operadores de asignación
ASIGNACION   : '=';
SUMA_ASIGN   : '+=';
RESTA_ASIGN  : '-=';
MULT_ASIGN   : '*=';
DIV_ASIGN    : '/=';

// Operador ternario
INTERROGACION: '?';
DOS_PUNTOS   : ':';

// ============================================================================
// DELIMITADORES
// ============================================================================

LLAVE_ABIERTA   : '{';
LLAVE_CERRADA   : '}';
PAREN_ABIERTO   : '(';
PAREN_CERRADO   : ')';
CORCHETE_ABIERTO : '[';
CORCHETE_CERRADO : ']';
PUNTO_COMA      : ';';
COMA            : ',';
PUNTO           : '.';
ARROBA          : '@';

// ============================================================================
// LITERALES - NÚMEROS
// ============================================================================

// Número flotante (debe estar antes que entero por precedencia)
NUMERO_FLOTANTE : (DIGITOS '.' DIGITOS) 
                | ('.' DIGITOS) 
                | (DIGITOS '.' )
                | (DIGITOS ([eE] [+-]? DIGITOS));

// Número entero
NUMERO_ENTERO   : DIGITOS;

// Fragmento para reutilizar
fragment DIGITOS : [0-9]+;

// ============================================================================
// LITERALES - CADENAS Y CARACTERES
// ============================================================================

// Cadena (strings)
CADENA_LITERAL  : '"' (~["\\\r\n])* (ESCAPE_SEQUENCE (~["\\\r\n])*)* '"'
                | '\'' (~['\\\r\n])* (ESCAPE_SEQUENCE (~['\\\r\n])*)* '\'';

// Secuencias de escape para cadenas
fragment ESCAPE_SEQUENCE : '\\' ('n' | 't' | 'r' | '\\' | '"' | '\'');

// ============================================================================
// IDENTIFICADORES (después de palabras clave para evitar conflictos)
// ============================================================================

// Identificador: comienza con letra o guion bajo, seguido de letras, dígitos o guiones bajos
IDENTIFICADOR : [a-zA-Z_][a-zA-Z0-9_]*;

// ============================================================================
// COMENTARIOS
// ============================================================================

// Comentario de línea única
COMENTARIO_LINEA : '//' ~[\r\n]* -> skip;

// Comentario de bloque múltiple
COMENTARIO_BLOQUE : '/*' .*? '*/' -> skip;

// ============================================================================
// ESPACIOS EN BLANCO Y CARACTERES A IGNORAR
// ============================================================================

ESPACIO_BLANCO : [ \t]+ -> skip;
SALTO_LINEA    : [\r\n]+ -> skip;

// ============================================================================
// ERRORES LÉXICOS
// ============================================================================

// Token DESCONOCIDO para capturar caracteres que no coinciden con ninguna regla
DESCONOCIDO : . ;

// ============================================================================
// REGLAS PARSER (Mínimas para Fase 1 - Lexer)
// ============================================================================

// --------------------------------------------------------------------------
// REGLAS PARSER (Fase 2: Analizador sintáctico básico)
// --------------------------------------------------------------------------

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

// ------------------------- Expresiones con precedencia ---------------------
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

// Fin de reglas parser
