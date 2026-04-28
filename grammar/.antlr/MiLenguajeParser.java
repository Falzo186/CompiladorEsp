// Generated from c:/Users/alexp/CompiladorEsp/grammar/MiLenguaje.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MiLenguajeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PUBLICO=1, PRIVADO=2, PROTEGIDO=3, ESTATICO=4, ENTERO=5, DECIMAL=6, BOOLEANO=7, 
		CADENA=8, VACIO=9, CLASE=10, INTERFAZ=11, EXTIENDE=12, IMPLEMENTA=13, 
		SI=14, SINO=15, MIENTRAS=16, PARA=17, HACER=18, RUPTURA=19, CONTINUAR=20, 
		RETORNAR=21, NUEVO=22, INTENTAR=23, CAPTURAR=24, FINALMENTE=25, LANZAR=26, 
		IMPORTAR=27, PAQUETE=28, VERDADERO=29, FALSO=30, NULO=31, POTENCIA=32, 
		RAIZ=33, SENO=34, COSENO=35, LOGARITMO=36, ALEATORIO=37, ABSOLUTO=38, 
		MINIMO=39, MAXIMO=40, IMPRIMIR=41, LEER=42, IGUALDAD=43, DESIGUALDAD=44, 
		MENOR_IGUAL=45, MAYOR_IGUAL=46, MENOR=47, MAYOR=48, AND_OP=49, OR_OP=50, 
		NOT_OP=51, SUMA=52, RESTA=53, MULT=54, DIV=55, MOD=56, POTENCIA_OP=57, 
		INCREMENTO=58, DECREMENTO=59, ASIGNACION=60, SUMA_ASIGN=61, RESTA_ASIGN=62, 
		MULT_ASIGN=63, DIV_ASIGN=64, INTERROGACION=65, DOS_PUNTOS=66, LLAVE_ABIERTA=67, 
		LLAVE_CERRADA=68, PAREN_ABIERTO=69, PAREN_CERRADO=70, CORCHETE_ABIERTO=71, 
		CORCHETE_CERRADO=72, PUNTO_COMA=73, COMA=74, PUNTO=75, ARROBA=76, NUMERO_FLOTANTE=77, 
		NUMERO_ENTERO=78, CADENA_LITERAL=79, IDENTIFICADOR=80, COMENTARIO_LINEA=81, 
		COMENTARIO_BLOQUE=82, ESPACIO_BLANCO=83, SALTO_LINEA=84, DESCONOCIDO=85;
	public static final int
		RULE_programa = 0;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'publico'", "'privado'", "'protegido'", "'estatico'", "'entero'", 
			"'decimal'", "'booleano'", "'cadena'", "'vacio'", "'clase'", "'interfaz'", 
			"'extiende'", "'implementa'", "'si'", "'sino'", "'mientras'", "'para'", 
			"'hacer'", "'ruptura'", "'continuar'", "'retornar'", "'nuevo'", "'intentar'", 
			"'capturar'", "'finalmente'", "'lanzar'", "'importar'", "'paquete'", 
			"'verdadero'", "'falso'", "'nulo'", "'potencia'", "'raiz'", "'seno'", 
			"'coseno'", "'logaritmo'", "'aleatorio'", "'absoluto'", "'minimo'", "'maximo'", 
			"'imprimir'", "'leer'", "'=='", "'!='", "'<='", "'>='", "'<'", "'>'", 
			"'&&'", "'||'", "'!'", "'+'", "'-'", "'*'", "'/'", "'%'", null, "'++'", 
			"'--'", "'='", "'+='", "'-='", "'*='", "'/='", "'?'", "':'", "'{'", "'}'", 
			"'('", "')'", "'['", "']'", "';'", "','", "'.'", "'@'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PUBLICO", "PRIVADO", "PROTEGIDO", "ESTATICO", "ENTERO", "DECIMAL", 
			"BOOLEANO", "CADENA", "VACIO", "CLASE", "INTERFAZ", "EXTIENDE", "IMPLEMENTA", 
			"SI", "SINO", "MIENTRAS", "PARA", "HACER", "RUPTURA", "CONTINUAR", "RETORNAR", 
			"NUEVO", "INTENTAR", "CAPTURAR", "FINALMENTE", "LANZAR", "IMPORTAR", 
			"PAQUETE", "VERDADERO", "FALSO", "NULO", "POTENCIA", "RAIZ", "SENO", 
			"COSENO", "LOGARITMO", "ALEATORIO", "ABSOLUTO", "MINIMO", "MAXIMO", "IMPRIMIR", 
			"LEER", "IGUALDAD", "DESIGUALDAD", "MENOR_IGUAL", "MAYOR_IGUAL", "MENOR", 
			"MAYOR", "AND_OP", "OR_OP", "NOT_OP", "SUMA", "RESTA", "MULT", "DIV", 
			"MOD", "POTENCIA_OP", "INCREMENTO", "DECREMENTO", "ASIGNACION", "SUMA_ASIGN", 
			"RESTA_ASIGN", "MULT_ASIGN", "DIV_ASIGN", "INTERROGACION", "DOS_PUNTOS", 
			"LLAVE_ABIERTA", "LLAVE_CERRADA", "PAREN_ABIERTO", "PAREN_CERRADO", "CORCHETE_ABIERTO", 
			"CORCHETE_CERRADO", "PUNTO_COMA", "COMA", "PUNTO", "ARROBA", "NUMERO_FLOTANTE", 
			"NUMERO_ENTERO", "CADENA_LITERAL", "IDENTIFICADOR", "COMENTARIO_LINEA", 
			"COMENTARIO_BLOQUE", "ESPACIO_BLANCO", "SALTO_LINEA", "DESCONOCIDO"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MiLenguaje.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiLenguajeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001U\u0005\u0002\u0000\u0007\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0000\u0000\u0001\u0000\u0000\u0000\u0003\u0000\u0002\u0001\u0000"+
		"\u0000\u0000\u0002\u0003\u0001\u0000\u0000\u0000\u0003\u0001\u0001\u0000"+
		"\u0000\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}