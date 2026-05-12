// Generated from c:/programas/CompiladorEsp/grammar/MiLenguaje.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiLenguajeParser}.
 */
public interface MiLenguajeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(MiLenguajeParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(MiLenguajeParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#elemento}.
	 * @param ctx the parse tree
	 */
	void enterElemento(MiLenguajeParser.ElementoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#elemento}.
	 * @param ctx the parse tree
	 */
	void exitElemento(MiLenguajeParser.ElementoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSentencia(MiLenguajeParser.SentenciaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSentencia(MiLenguajeParser.SentenciaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#sentenciaEmparejada}.
	 * @param ctx the parse tree
	 */
	void enterSentenciaEmparejada(MiLenguajeParser.SentenciaEmparejadaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#sentenciaEmparejada}.
	 * @param ctx the parse tree
	 */
	void exitSentenciaEmparejada(MiLenguajeParser.SentenciaEmparejadaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#metodo}.
	 * @param ctx the parse tree
	 */
	void enterMetodo(MiLenguajeParser.MetodoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#metodo}.
	 * @param ctx the parse tree
	 */
	void exitMetodo(MiLenguajeParser.MetodoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#clase}.
	 * @param ctx the parse tree
	 */
	void enterClase(MiLenguajeParser.ClaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#clase}.
	 * @param ctx the parse tree
	 */
	void exitClase(MiLenguajeParser.ClaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#miembro}.
	 * @param ctx the parse tree
	 */
	void enterMiembro(MiLenguajeParser.MiembroContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#miembro}.
	 * @param ctx the parse tree
	 */
	void exitMiembro(MiLenguajeParser.MiembroContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#atributo}.
	 * @param ctx the parse tree
	 */
	void enterAtributo(MiLenguajeParser.AtributoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#atributo}.
	 * @param ctx the parse tree
	 */
	void exitAtributo(MiLenguajeParser.AtributoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#listaParametros}.
	 * @param ctx the parse tree
	 */
	void enterListaParametros(MiLenguajeParser.ListaParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#listaParametros}.
	 * @param ctx the parse tree
	 */
	void exitListaParametros(MiLenguajeParser.ListaParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(MiLenguajeParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(MiLenguajeParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#modificadorAcceso}.
	 * @param ctx the parse tree
	 */
	void enterModificadorAcceso(MiLenguajeParser.ModificadorAccesoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#modificadorAcceso}.
	 * @param ctx the parse tree
	 */
	void exitModificadorAcceso(MiLenguajeParser.ModificadorAccesoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#tipoRetorno}.
	 * @param ctx the parse tree
	 */
	void enterTipoRetorno(MiLenguajeParser.TipoRetornoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#tipoRetorno}.
	 * @param ctx the parse tree
	 */
	void exitTipoRetorno(MiLenguajeParser.TipoRetornoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion(MiLenguajeParser.DeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion(MiLenguajeParser.DeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(MiLenguajeParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(MiLenguajeParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#impresion}.
	 * @param ctx the parse tree
	 */
	void enterImpresion(MiLenguajeParser.ImpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#impresion}.
	 * @param ctx the parse tree
	 */
	void exitImpresion(MiLenguajeParser.ImpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#condicion}.
	 * @param ctx the parse tree
	 */
	void enterCondicion(MiLenguajeParser.CondicionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#condicion}.
	 * @param ctx the parse tree
	 */
	void exitCondicion(MiLenguajeParser.CondicionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#condicionEmparejada}.
	 * @param ctx the parse tree
	 */
	void enterCondicionEmparejada(MiLenguajeParser.CondicionEmparejadaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#condicionEmparejada}.
	 * @param ctx the parse tree
	 */
	void exitCondicionEmparejada(MiLenguajeParser.CondicionEmparejadaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#condicionNoEmparejada}.
	 * @param ctx the parse tree
	 */
	void enterCondicionNoEmparejada(MiLenguajeParser.CondicionNoEmparejadaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#condicionNoEmparejada}.
	 * @param ctx the parse tree
	 */
	void exitCondicionNoEmparejada(MiLenguajeParser.CondicionNoEmparejadaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#ciclo}.
	 * @param ctx the parse tree
	 */
	void enterCiclo(MiLenguajeParser.CicloContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#ciclo}.
	 * @param ctx the parse tree
	 */
	void exitCiclo(MiLenguajeParser.CicloContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#paraStmt}.
	 * @param ctx the parse tree
	 */
	void enterParaStmt(MiLenguajeParser.ParaStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#paraStmt}.
	 * @param ctx the parse tree
	 */
	void exitParaStmt(MiLenguajeParser.ParaStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#retorno}.
	 * @param ctx the parse tree
	 */
	void enterRetorno(MiLenguajeParser.RetornoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#retorno}.
	 * @param ctx the parse tree
	 */
	void exitRetorno(MiLenguajeParser.RetornoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(MiLenguajeParser.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(MiLenguajeParser.ExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#bloque}.
	 * @param ctx the parse tree
	 */
	void enterBloque(MiLenguajeParser.BloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#bloque}.
	 * @param ctx the parse tree
	 */
	void exitBloque(MiLenguajeParser.BloqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MiLenguajeParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MiLenguajeParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpr(MiLenguajeParser.EqualityExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpr(MiLenguajeParser.EqualityExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(MiLenguajeParser.RelationalExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(MiLenguajeParser.RelationalExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(MiLenguajeParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(MiLenguajeParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#mulExpr}.
	 * @param ctx the parse tree
	 */
	void enterMulExpr(MiLenguajeParser.MulExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#mulExpr}.
	 * @param ctx the parse tree
	 */
	void exitMulExpr(MiLenguajeParser.MulExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(MiLenguajeParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(MiLenguajeParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#postfixExpr}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpr(MiLenguajeParser.PostfixExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#postfixExpr}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpr(MiLenguajeParser.PostfixExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(MiLenguajeParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(MiLenguajeParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#funcionMatematica}.
	 * @param ctx the parse tree
	 */
	void enterFuncionMatematica(MiLenguajeParser.FuncionMatematicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#funcionMatematica}.
	 * @param ctx the parse tree
	 */
	void exitFuncionMatematica(MiLenguajeParser.FuncionMatematicaContext ctx);
}