package com.compilador.ej.lexer;

import java.io.IOException;
import java.util.List;

/**
 * Clase principal para ejecutar el lexer de EspañolJava
 * 
 * Uso:
 *   java com.compilador.ej.lexer.LexerMain archivo.ej
 *   java com.compilador.ej.lexer.LexerMain --help
 * 
 * @author CompiladorEsp
 * @version 1.0
 */
public class LexerMain {
    
    public static void main(String[] args) {
        if (args.length == 0) {
            mostrarAyuda();
            System.exit(1);
        }
        
        String rutaArchivo = args[0];
        boolean verbose = args.length > 1 && args[1].equals("-v");
        
        if (rutaArchivo.equals("--help") || rutaArchivo.equals("-h")) {
            mostrarAyuda();
            System.exit(0);
        }
        
        try {
            ejecutarLexer(rutaArchivo, verbose);
        } catch (IOException e) {
            System.err.println("❌ Error al leer archivo: " + e.getMessage());
            System.exit(1);
        }
    }
    
    private static void ejecutarLexer(String rutaArchivo, boolean verbose) throws IOException {
        LexerEJ lexer = new LexerEJ();
        
        System.out.println("Analizando: " + rutaArchivo);
        System.out.println();
        
        lexer.analizarArchivo(rutaArchivo);
        
        // Mostrar tokens
        lexer.imprimirReporteTokens();
        System.out.println();
        
        // Mostrar errores
        if (lexer.tieneErrores()) {
            lexer.imprimirReporteErrores();
            System.exit(1);
        } else {
            System.out.println("OK - Analisis completado sin errores");
        }
    }
    
    private static void mostrarAyuda() {
        System.out.println("===================================================");
        System.out.println("   Lexer EspañolJava - Fase 1 (Analizador)    ");
        System.out.println("===================================================");
        System.out.println();
        System.out.println("Uso:");
        System.out.println("  java -cp . com.compilador.ej.lexer.LexerMain <archivo.ej> [opciones]");
        System.out.println();
        System.out.println("Opciones:");
        System.out.println("  -v          Modo verbose (más detalles)");
        System.out.println("  --help, -h  Mostrar esta ayuda");
        System.out.println();
        System.out.println("Ejemplo:");
        System.out.println("  java -cp . com.compilador.ej.lexer.LexerMain programa.ej");
        System.out.println("  java -cp . com.compilador.ej.lexer.LexerMain programa.ej -v");
    }
}
