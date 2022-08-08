// Generated from Grammar.g4 by ANTLR 4.4
package parser;

	import ast.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull GrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull GrammarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(@NotNull GrammarParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(@NotNull GrammarParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#passFuncParams}.
	 * @param ctx the parse tree
	 */
	void enterPassFuncParams(@NotNull GrammarParser.PassFuncParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#passFuncParams}.
	 * @param ctx the parse tree
	 */
	void exitPassFuncParams(@NotNull GrammarParser.PassFuncParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#defineFuncParamsList}.
	 * @param ctx the parse tree
	 */
	void enterDefineFuncParamsList(@NotNull GrammarParser.DefineFuncParamsListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#defineFuncParamsList}.
	 * @param ctx the parse tree
	 */
	void exitDefineFuncParamsList(@NotNull GrammarParser.DefineFuncParamsListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(@NotNull GrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(@NotNull GrammarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#passFuncParamsList}.
	 * @param ctx the parse tree
	 */
	void enterPassFuncParamsList(@NotNull GrammarParser.PassFuncParamsListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#passFuncParamsList}.
	 * @param ctx the parse tree
	 */
	void exitPassFuncParamsList(@NotNull GrammarParser.PassFuncParamsListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#structField}.
	 * @param ctx the parse tree
	 */
	void enterStructField(@NotNull GrammarParser.StructFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#structField}.
	 * @param ctx the parse tree
	 */
	void exitStructField(@NotNull GrammarParser.StructFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull GrammarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull GrammarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#defineFuncParams}.
	 * @param ctx the parse tree
	 */
	void enterDefineFuncParams(@NotNull GrammarParser.DefineFuncParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#defineFuncParams}.
	 * @param ctx the parse tree
	 */
	void exitDefineFuncParams(@NotNull GrammarParser.DefineFuncParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(@NotNull GrammarParser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(@NotNull GrammarParser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#global}.
	 * @param ctx the parse tree
	 */
	void enterGlobal(@NotNull GrammarParser.GlobalContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#global}.
	 * @param ctx the parse tree
	 */
	void exitGlobal(@NotNull GrammarParser.GlobalContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull GrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull GrammarParser.TypeContext ctx);
}