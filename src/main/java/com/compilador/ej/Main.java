package com.compilador.ej;

import com.compilador.ej.gen.MiLenguajeLexer;
import com.compilador.ej.gen.MiLenguajeParser;
import com.compilador.ej.lexer.LexerEJ;
import org.antlr.v4.runtime.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Modo consola interactivo para EspañolJava
 * 
 * Proporciona un menú interactivo para:
 * - Ejecutar análisis léxico
 * - Ejecutar parser
 * - Mostrar parse tree
 * - Probar casos predefinidos
 * 
 * @author CompiladorEsp
 * @version 1.0
 */
public class Main {
    
    private static final String RUTA_EJEMPLOS = "resources/examples/";
    private static final String EXTENSION = ".ej";
    private Scanner scanner;
    
    // Casos de prueba predefinidos
    private static final String[][] CASOS = {
        {"Análisis Léxico", "prueba_lexer.ej"},
        {"Caso Básico", "caso1_basico.ej"},
        {"If/Else", "caso_if_else.ej"},
        {"Métodos", "caso_metodo_parametros.ej"},
        {"Clases", "caso_clase_metodo.ej"},
        {"Completo (sin errores)", "caso_completo_sin_errores.ej"},
        {"Completo (con errores)", "caso_completo_con_errores.ej"},
    };
    
    public static void main(String[] args) {
        new Main().ejecutar();
    }
    
    public Main() {
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Inicia el menú interactivo principal
     */
    private void ejecutar() {
        mostrarBienvenida();
        
        boolean activo = true;
        while (activo) {
            mostrarMenuPrincipal();
            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1:
                    ejecutarAnalisisLexico();
                    break;
                case 2:
                    ejecutarParser();
                    break;
                case 3:
                    ejecutarParseTree();
                    break;
                case 4:
                    ejecutarCasosPredefinidos();
                    break;
                case 5:
                    activo = false;
                    System.out.println("\n✓ ¡Hasta luego!\n");
                    break;
                default:
                    System.out.println("❌ Opción inválida\n");
            }
        }
        
        scanner.close();
    }
    
    /**
     * Muestra el banner de bienvenida
     */
    private void mostrarBienvenida() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("    🎯 COMPILADOR ESPAÑOLJAVA - MODO CONSOLA INTERACTIVO");
        System.out.println("=".repeat(60) + "\n");
    }
    
    /**
     * Muestra el menú principal
     */
    private void mostrarMenuPrincipal() {
        System.out.println("\n📋 MENÚ PRINCIPAL:");
        System.out.println("   1. Ejecutar análisis léxico");
        System.out.println("   2. Ejecutar parser");
        System.out.println("   3. Mostrar parse tree");
        System.out.println("   4. Ejecutar casos predefinidos");
        System.out.println("   5. Salir");
        System.out.print("\n▶ Selecciona opción: ");
    }
    
    /**
     * Ejecuta análisis léxico en un archivo
     */
    private void ejecutarAnalisisLexico() {
        System.out.println("\n--- ANÁLISIS LÉXICO ---");
        Path archivo = seleccionarArchivo();
        
        if (archivo == null) return;
        
        try {
            System.out.println();
            LexerEJ lexerEJ = new LexerEJ();
            lexerEJ.analizarArchivo(archivo.toString());
            
            System.out.println("✓ TOKENS ENCONTRADOS:");
            lexerEJ.imprimirReporteTokens();
            
            if (lexerEJ.tieneErrores()) {
                System.out.println("\n⚠️  ERRORES LÉXICOS:");
                lexerEJ.imprimirReporteErrores();
            } else {
                System.out.println("\n✓ No hay errores léxicos");
            }
        } catch (IOException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }
    }
    
    /**
     * Ejecuta parser en un archivo
     */
    private void ejecutarParser() {
        System.out.println("\n--- ANÁLISIS SINTÁCTICO (PARSER) ---");
        Path archivo = seleccionarArchivo();
        
        if (archivo == null) return;
        
        try {
            String codigo = Files.readString(archivo, StandardCharsets.UTF_8);
            analizarConParser(codigo, archivo.toString());
        } catch (IOException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }
    }
    
    /**
     * Ejecuta parser y muestra parse tree
     */
    private void ejecutarParseTree() {
        System.out.println("\n--- PARSE TREE (Árbol sintáctico) ---");
        Path archivo = seleccionarArchivo();
        
        if (archivo == null) return;
        
        try {
            String codigo = Files.readString(archivo, StandardCharsets.UTF_8);
            mostrarParseTree(codigo, archivo.toString());
        } catch (IOException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }
    }
    
    /**
     * Menú de casos de prueba predefinidos
     */
    private void ejecutarCasosPredefinidos() {
        System.out.println("\n--- CASOS PREDEFINIDOS ---");
        
        for (int i = 0; i < CASOS.length; i++) {
            System.out.printf("   %d. %s (%s)%n", i + 1, CASOS[i][0], CASOS[i][1]);
        }
        System.out.printf("   %d. Volver al menú principal%n", CASOS.length + 1);
        System.out.print("\n▶ Selecciona caso: ");
        
        int opcion = leerOpcion();
        
        if (opcion < 1 || opcion > CASOS.length + 1) {
            System.out.println("❌ Opción inválida");
            return;
        }
        
        if (opcion == CASOS.length + 1) {
            return;
        }
        
        ejecutarCaso(CASOS[opcion - 1][1]);
    }
    
    /**
     * Ejecuta un caso de prueba específico
     */
    private void ejecutarCaso(String nombreArchivo) {
        Path archivo = Paths.get(RUTA_EJEMPLOS, nombreArchivo);
        
        if (!Files.exists(archivo)) {
            System.err.println("❌ Archivo no encontrado: " + archivo);
            return;
        }
        
        try {
            String codigo = Files.readString(archivo, StandardCharsets.UTF_8);
            
            System.out.println("\n" + "=".repeat(60));
            System.out.println("📄 " + nombreArchivo);
            System.out.println("=".repeat(60));
            
            // Análisis léxico
            System.out.println("\n📍 ANÁLISIS LÉXICO:");
            LexerEJ lexerEJ = new LexerEJ();
            lexerEJ.analizarCodigo(codigo);
            
            if (lexerEJ.tieneErrores()) {
                System.out.println("⚠️  ERRORES LÉXICOS:");
                lexerEJ.imprimirReporteErrores();
            } else {
                System.out.println("✓ Sin errores léxicos (" + 
                    lexerEJ.obtenerTokens().size() + " tokens)");
            }
            
            // Análisis sintáctico
            System.out.println("\n📍 ANÁLISIS SINTÁCTICO:");
            analizarConParser(codigo, archivo.toString());
            
        } catch (IOException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }
    }
    
    /**
     * Realiza análisis con parser y reporta resultados
     */
    private void analizarConParser(String codigo, String rutaArchivo) {
        CharStream input = CharStreams.fromString(codigo);
        MiLenguajeLexer lexer = new MiLenguajeLexer(input);
        lexer.removeErrorListeners();
        
        ParserErrorListener errorListener = new ParserErrorListener();
        lexer.addErrorListener(errorListener);
        
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        MiLenguajeParser parser = new MiLenguajeParser(tokenStream);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
        
        // Intentar parsear
        try {
            parser.programa();
            
            if (errorListener.tieneErrores()) {
                System.out.println("⚠️  ERRORES SINTÁCTICOS:");
                for (String error : errorListener.obtenerErrores()) {
                    System.out.println("   " + error);
                }
            } else {
                System.out.println("✓ Parse exitoso - Sin errores sintácticos");
            }
        } catch (Exception e) {
            System.out.println("❌ Error en parsing: " + e.getMessage());
        }
    }
    
    /**
     * Muestra el parse tree de un código
     */
    private void mostrarParseTree(String codigo, String rutaArchivo) {
        CharStream input = CharStreams.fromString(codigo);
        MiLenguajeLexer lexer = new MiLenguajeLexer(input);
        lexer.removeErrorListeners();
        
        ParserErrorListener errorListener = new ParserErrorListener();
        lexer.addErrorListener(errorListener);
        
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        MiLenguajeParser parser = new MiLenguajeParser(tokenStream);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
        
        try {
            MiLenguajeParser.ProgramaContext arbol = parser.programa();
            
            System.out.println("\n🌳 ÁRBOL SINTÁCTICO (Parse Tree):");
            System.out.println("-".repeat(60));
            String arbolTexto = arbol.toStringTree(parser);
            
            // Limitar la salida si es muy larga
            if (arbolTexto.length() > 3000) {
                System.out.println(arbolTexto.substring(0, 3000));
                System.out.println("\n... (salida truncada - árbol muy grande)");
            } else {
                System.out.println(arbolTexto);
            }
            System.out.println("-".repeat(60));
            
            if (!errorListener.tieneErrores()) {
                System.out.println("\n✓ Árbol generado exitosamente");
            }
            
        } catch (Exception e) {
            System.err.println("❌ Error: " + e.getMessage());
        }
    }
    
    /**
     * Permite al usuario seleccionar un archivo
     */
    private Path seleccionarArchivo() {
        System.out.print("\n▶ Ingresa ruta del archivo (relativa o absoluta): ");
        String rutaStr = scanner.nextLine().trim();
        
        if (rutaStr.isEmpty()) {
            System.out.println("❌ Ruta vacía");
            return null;
        }
        
        Path ruta = Paths.get(rutaStr);
        
        if (!Files.exists(ruta)) {
            System.err.println("❌ Archivo no encontrado: " + ruta);
            return null;
        }
        
        return ruta;
    }
    
    /**
     * Lee un número desde la consola
     */
    private int leerOpcion() {
        try {
            String linea = scanner.nextLine().trim();
            return Integer.parseInt(linea);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    /**
     * Listener personalizado para errores de parser
     */
    private static class ParserErrorListener extends BaseErrorListener {
        private List<String> errores = new ArrayList<>();
        
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                               int line, int charPositionInLine, String msg,
                               RecognitionException e) {
            String errorMsg = String.format("ERROR sintáctico en línea %d, columna %d: %s",
                    line, charPositionInLine, traducirMensajeError(msg));
            errores.add(errorMsg);
        }
        
        private String traducirMensajeError(String msg) {
            String traducido = msg;
            
            // Traducir "missing" → "falta"
            traducido = traducido.replace("missing ", "falta ");
            
            // Traducir "at" → "en"
            traducido = traducido.replace(" at ", " en ");
            
            // Traducir "expected" → "se esperaba"
            traducido = traducido.replace("expected", "se esperaba");
            
            // Traducir "Unexpected input" → "Entrada inesperada"
            traducido = traducido.replace("Unexpected input", "Entrada inesperada");
            
            // Traducir "no viable alternative" → "sin alternativa viable"
            traducido = traducido.replace("no viable alternative", "sin alternativa viable");
            
            // Traducir "extraneous input" → "entrada extraña"
            traducido = traducido.replace("extraneous input", "entrada extraña");
            
            return traducido;
        }
        
        public boolean tieneErrores() {
            return !errores.isEmpty();
        }
        
        public List<String> obtenerErrores() {
            return new ArrayList<>(errores);
        }
    }
}
