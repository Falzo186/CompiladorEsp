package com.compilador.ej.parser;

import com.compilador.ej.gen.MiLenguajeLexer;
import com.compilador.ej.gen.MiLenguajeParser;
import com.compilador.ej.lexer.LexerEJ;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

/**
 * Prueba de parser para EspañolJava.
 */
public class ParserTest {

    private static final String USO =
            "Uso: java -cp \"build/classes;C:\\Users\\alexp\\Downloads\\antlr-4.13.2-complete.jar\" "
                    + "com.compilador.ej.parser.ParserTest <archivo.ej>";

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(USO);
            return;
        }

        Path rutaArchivo = Paths.get(args[0]);
        if (!Files.exists(rutaArchivo)) {
            System.err.println("ERROR: No existe el archivo: " + rutaArchivo);
            return;
        }

        try {
            new ParserTest().analizarArchivo(rutaArchivo);
        } catch (IOException e) {
            System.err.println("ERROR: No se pudo leer el archivo: " + e.getMessage());
        }
    }

    private void analizarArchivo(Path rutaArchivo) throws IOException {
        String codigo = Files.readString(rutaArchivo, StandardCharsets.UTF_8);

        System.out.println("========================================");
        System.out.println("     PRUEBA DE PARSER ESPAÑOLJAVA      ");
        System.out.println("========================================");
        System.out.println("Archivo: " + rutaArchivo);
        System.out.println();

        LexerEJ lexerEJ = new LexerEJ();
        lexerEJ.analizarCodigo(codigo);

        System.out.println("--- TOKENS (LexerEJ) ---");
        lexerEJ.imprimirReporteTokens();
        System.out.println();
        lexerEJ.imprimirReporteErrores();
        System.out.println();

        CharStream input = CharStreams.fromString(codigo);
        MiLenguajeLexer lexer = new MiLenguajeLexer(input);
        lexer.removeErrorListeners();
        lexer.addErrorListener(new ParserErrorListener());

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        tokenStream.fill();

        System.out.println("--- LISTA DE TOKENS ---");
        for (Token token : tokenStream.getTokens()) {
            System.out.printf("[@%d] Línea %d, Col %d: '%s' [Tipo: %s]%n",
                    token.getTokenIndex(),
                    token.getLine(),
                    token.getCharPositionInLine(),
                    token.getText(),
                    MiLenguajeParser.VOCABULARY.getDisplayName(token.getType()));
        }
        System.out.println();

        MiLenguajeParser parser = new MiLenguajeParser(tokenStream);
        parser.removeErrorListeners();
        parser.addErrorListener(new ParserErrorListener());

        System.out.println("--- PARSE TREE ---");
        System.out.println(parser.programa().toStringTree(parser));
    }

    private static class ParserErrorListener extends BaseErrorListener {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                int line, int charPositionInLine, String msg,
                                RecognitionException e) {
            String mensajeEspanol = traducirMensajeError(msg);
            System.err.printf("ERROR sintáctico en línea %d, columna %d: %s%n",
                    line,
                    charPositionInLine,
                    mensajeEspanol);
        }

        /**
         * Traduce mensajes de error de ANTLR al español
         */
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
    }

}
