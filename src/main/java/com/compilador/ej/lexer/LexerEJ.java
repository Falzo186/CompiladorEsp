package com.compilador.ej.lexer;

import org.antlr.v4.runtime.*;
import com.compilador.ej.gen.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Analizador Léxico para EspañolJava
 * 
 * Responsabilidades:
 * - Leer archivos de entrada
 * - Tokenizar código EspañolJava
 * - Reportar errores léxicos
 * 
 * @author CompiladorEsp
 * @version 1.0
 */
public class LexerEJ {
    
    private final MiLenguajeLexer lexer;
    private final List<TokenInfo> tokens;
    private final List<String> errores;
    
    public LexerEJ() {
        this.lexer = null;
        this.tokens = new ArrayList<>();
        this.errores = new ArrayList<>();
    }
    
    /**
     * Analiza un archivo EspañolJava y extrae los tokens
     * 
     * @param rutaArchivo Ruta al archivo .ej
     * @throws IOException Si el archivo no existe o no puede leerse
     */
    public void analizarArchivo(String rutaArchivo) throws IOException {
        Path ruta = Paths.get(rutaArchivo);
        String codigo = Files.readString(ruta, StandardCharsets.UTF_8);
        analizarCodigo(codigo);
    }
    
    /**
     * Analiza código EspañolJava directo
     * 
     * @param codigo Código fuente a analizar
     */
    public void analizarCodigo(String codigo) {
        tokens.clear();
        errores.clear();
        
        CharStream input = CharStreams.fromString(codigo);
        MiLenguajeLexer lexer = new MiLenguajeLexer(input);
        
        // Configurar manejador de errores personalizado
        lexer.removeErrorListeners();
        lexer.addErrorListener(new ErrorListener());
        
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        tokenStream.fill();
        
        // Extraer información de tokens
        for (Token token : tokenStream.getTokens()) {
            tokens.add(new TokenInfo(
                token.getType(),
                token.getText(),
                token.getLine(),
                token.getCharPositionInLine()
            ));
        }
    }
    
    /**
     * Obtiene todos los tokens extraídos
     */
    public List<TokenInfo> obtenerTokens() {
        return new ArrayList<>(tokens);
    }
    
    /**
     * Obtiene todos los errores detectados
     */
    public List<String> obtenerErrores() {
        return new ArrayList<>(errores);
    }
    
    /**
     * Verifica si hay errores léxicos
     */
    public boolean tieneErrores() {
        return !errores.isEmpty();
    }
    
    /**
     * Imprime un reporte de los tokens
     */
    public void imprimirReporteTokens() {
        System.out.println("========================================");
        System.out.println("       REPORTE DE TOKENS (LEXER)       ");
        System.out.println("========================================\n");
        
        for (int i = 0; i < tokens.size(); i++) {
            TokenInfo token = tokens.get(i);
            System.out.printf("[@%d] Línea %d, Col %d: '%s' [Tipo: %s]%n",
                i,
                token.getLinea(),
                token.getColumna(),
                token.getTexto(),
                getNombreToken(token.getTipo())
            );
        }
        
        System.out.println("\nTotal de tokens: " + tokens.size());
    }
    
    /**
     * Imprime un reporte de los errores
     */
    public void imprimirReporteErrores() {
        if (errores.isEmpty()) {
            System.out.println("OK - Sin errores lexicos");
            return;
        }
        
        System.out.println("========================================");
        System.out.println("        ERRORES LEXICOS DETECTADOS      ");
        System.out.println("========================================\n");
        
        for (String error : errores) {
            System.out.println("ERROR: " + error);
        }
    }
    
    /**
     * Obtiene el nombre descriptivo de un tipo de token
     */
    private String getNombreToken(int tipo) {
        if (tipo == Token.EOF) return "EOF";
        try {
            return MiLenguajeParser.VOCABULARY.getDisplayName(tipo);
        } catch (Exception e) {
            return "DESCONOCIDO(" + tipo + ")";
        }
    }
    
    /**
     * Clase interna para almacenar información de un token
     */
    public static class TokenInfo {
        private final int tipo;
        private final String texto;
        private final int linea;
        private final int columna;
        
        public TokenInfo(int tipo, String texto, int linea, int columna) {
            this.tipo = tipo;
            this.texto = texto;
            this.linea = linea;
            this.columna = columna;
        }
        
        public int getTipo() { return tipo; }
        public String getTexto() { return texto; }
        public int getLinea() { return linea; }
        public int getColumna() { return columna; }
    }
    
    /**
     * Manejador de errores personalizado para ANTLR4
     */
    private class ErrorListener extends BaseErrorListener {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                              int line, int charPositionInLine, String msg, RecognitionException e) {
            String error = String.format("Línea %d, Columna %d: %s", line, charPositionInLine, msg);
            errores.add(error);
        }
    }
}
