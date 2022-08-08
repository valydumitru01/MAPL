/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import ast.*;
import ast.VarDef.Scope;
import visitor.*;

enum CodeFunction {
	ADDRESS, VALUE
}

public class CodeSelection extends DefaultVisitor {
	private Map<String, String> instruccion = new HashMap<String, String>();
	private static int contadorEtiquetaEndIf = 0;
	private static int contadorEtiquetaElse = 0;
	private static int contadorEtiquetaWhile = 0;
	private static int contadorEtiquetaEndWhile = 0;

	public CodeSelection(Writer writer, String sourceFile) {
		this.writer = new PrintWriter(writer);
		this.sourceFile = sourceFile;

		instruccion.put("+", "add");
		instruccion.put("-", "sub");
		instruccion.put("*", "mul");
		instruccion.put("/", "div");
		instruccion.put("%", "mod");

		instruccion.put("||", "or");
		instruccion.put("&&", "and");
		instruccion.put("!", "not");

		instruccion.put("==", "eq");
		instruccion.put("!=", "ne");
		instruccion.put("<", "lt");
		instruccion.put(">", "gt");
		instruccion.put("<=", "le");
		instruccion.put(">=", "ge");

	}

	// # ----------------------------------------------------------
	/*
	 * Poner aquí los visit.
	 *
	 * Si se ha usado VGen, solo hay que copiarlos de la clase
	 * 'visitor/_PlantillaParaVisitors.txt'.
	 */

	// Ejemplo:
	//
	// public Object visit(Program node, Object param) {
	// out("#source \"" + sourceFile + "\"");
	// out("call main");
	// out("halt");
	//
	// super.visit(node, param); // Recorrer los hijos
	// return null;
	// }

	// # ----------------------------------------------------------
	// Métodos auxiliares recomendados (opcionales) -------------

	// class Program { List<Global> global; }
	
	public Object visit(Program node, Object param) {

		// super.visit(node, param);
		out("#source \"" + sourceFile + "\"", false);
		if(node.hasMain())
			out("call main", false);
		out("halt", false);
		if (node.getGlobal() != null)
			for (Global child : node.getGlobal()) {
				child.accept(this, param);
			}

		return null;
	}

	// class Struct { String name; List<StructField> structfield; }
	public Object visit(Struct node, Object param) {
		// super.visit(node, param);

		out("'type " + node.getName() + "{", false);
		if (node.getStructfield() != null)
			for (StructField child : node.getStructfield()) {
				child.accept(this, param);
			}
		out("'}", false);
		return null;
	}

	// class StructField { String name; Type type; }
	public Object visit(StructField node, Object param) {
		// super.visit(node, param);

		out("'\t" + node.getName() + ":" + node.getType().getMAPLName(), false);
		return null;
	}

	// class VarDef { String name; Type type; }
	public Object visit(VarDef node, Object param) {

		// super.visit(node, param);
		if (node.getScope() == Scope.GLOBAL) {

		}
		return null;
	}

	// class Func { String name; List<VarDef> defineFuncParams; Type type;
	// List<VarDef> bodyDefs; List<Statement> bodyStmts; }
	public Object visit(Func node, Object param) {
		line(node, false);
		out(node.getName() + ": ", false);

		// super.visit(node, param);
		out("enter " + node.getBodyDefsMemSize(), true);
		if (node.getDefineFuncParams() != null)
			for (VarDef child : node.getDefineFuncParams())
				child.accept(this, param);

		if (node.getType() != null)
			node.getType().accept(this, param);

		if (node.getBodyDefs() != null)
			for (VarDef child : node.getBodyDefs())
				child.accept(this, param);

		if (node.getBodyStmts() != null)
			for (Statement child : node.getBodyStmts())
				child.accept(this, param);

		if (node.getType() == null) {
			out("", true);
			out("ret 0," + node.getBodyDefsMemSize() + "," + node.getDefineFuncParamsMemSize(), true);
		}
		return null;
	}

	// class Print { String printType; Expression expression; }
	public Object visit(Print node, Object param) {
		line(node, true);
		// super.visit(node, param);

		if (node.getExpression() != null)
			node.getExpression().accept(this, CodeFunction.VALUE);
		
		if (node.getPrintType().equals("println")) {
			out("pushb 10", true);
			out("outb", true);
		}
		if (node.getExpression() != null) {
			out("out" + node.getExpression().getType().getSuffix(), true);
		} 
		if (node.getPrintType().equals("printsp")) {
			out("pushb 32", true);
			out("outb", true);
		} 

		return null;
	}

	// class Assignment { Expression assigned; Expression right; }
	public Object visit(Assignment node, Object param) {
		line(node, true);
		// super.visit(node, param);

		if (node.getAssigned() != null)
			node.getAssigned().accept(this, CodeFunction.ADDRESS);

		if (node.getRight() != null)
			node.getRight().accept(this, CodeFunction.VALUE);
		out("store", node.getAssigned().getType(), true);
		return null;
	}

	// class Return { Expression returned; }
	public Object visit(Return node, Object param) {
		line(node, true);
		// super.visit(node, param);

		if (node.getReturned() != null)
			node.getReturned().accept(this, CodeFunction.VALUE);
		int sizeReturned;
		if(node.getReturnedType()==null) {
			sizeReturned=0;
		}
		else {
			sizeReturned=node.getReturnedType().getMemSize();
		}
		out("ret " + sizeReturned + "," + node.getFuncParent().getBodyDefsMemSize() + ","
				+ node.getFuncParent().getDefineFuncParamsMemSize(), true);
		return null;
	}

	// class FuncCall { String name; List<Expression> parameters; }
	public Object visit(FuncCall node, Object param) {
		line(node, true);
		// super.visit(node, param);

		if (node.getParameters() != null)
			for (Expression child : node.getParameters()) {
				child.accept(this, param);
			}
		out("call " + node.getName(), true);
		if (node.getDefinition().getType() != null) {
			out("pop" + node.getDefinition().getType().getSuffix(), true);
		}
		return null;
	}

	// class Read { Expression writtedInto; }
	public Object visit(Read node, Object param) {
		line(node, true);
		// super.visit(node, param);

		if (node.getWrittedInto() != null)
			node.getWrittedInto().accept(this, CodeFunction.ADDRESS);

		out("in" + node.getWrittedInto().getType().getSuffix(), true);
		return null;
	}

	// class If { Expression enterCondition; List<Statement> ifBody; List<Statement>
	// elseBody; }
	public Object visit(If node, Object param) {
		line(node, true);
		// super.visit(node, param);

		if (node.getEnterCondition() != null)
			node.getEnterCondition().accept(this, CodeFunction.VALUE);
		if (node.getElseBody().size() > 0)
			out("jz else" + contadorEtiquetaElse, true);
		else
			out("jz endif" + contadorEtiquetaEndIf, true);

		int contadorElseActual=contadorEtiquetaElse;
		int contadorEndIfActual=contadorEtiquetaEndIf;
		contadorEtiquetaEndIf++;
		contadorEtiquetaElse++;
		if (node.getIfBody() != null)
			for (Statement child : node.getIfBody())
				child.accept(this, param);
		out("jmp endif" + contadorEndIfActual, true);
		
		if (node.getElseBody().size() > 0) {
			out("else" + contadorElseActual + ":", true);
			for (Statement child : node.getElseBody())
				child.accept(this, param);
		}
		out("endif" + contadorEndIfActual + ":", true);
		
		return null;
	}

	// class While { Expression stopCondition; List<Statement> body; }
	public Object visit(While node, Object param) {
		line(node, true);
		// super.visit(node, param);

		out("while" + contadorEtiquetaWhile + ":", true);
		
		if (node.getStopCondition() != null)
			node.getStopCondition().accept(this, CodeFunction.VALUE);
		out("jz endwhile" + contadorEtiquetaEndWhile, true);
		
		int thisWhileCounter=contadorEtiquetaWhile;
		int thisEndWhileCounter=contadorEtiquetaEndWhile;
		contadorEtiquetaWhile++;
		contadorEtiquetaEndWhile++;
		if (node.getBody() != null)
			for (Statement child : node.getBody())
				child.accept(this, param);
		out("jmp while" + thisWhileCounter, true);
		out("endwhile" + thisEndWhileCounter + ":", true);
		
		return null;
	}

	/**
	 * ADRESS left
	 * PUSHI offset 
	 * ADD<type>
	 * si value:
	 *    	 LOAD
	 */
	// class ExpressionPointAccess { Expression left; String right; }
	public Object visit(ExpressionPointAccess node, Object param) {

		// super.visit(node, param);
		// TODO:Acabar
		if (node.getLeft() != null)
			node.getLeft().accept(this, CodeFunction.ADDRESS);
		
		Struct defStruct=((StructType)(node.getLeft().getType())).getDefinition();
		StructField field=defStruct.getFieldFromName(node.getRight());
		out("pushi "+defStruct.getFieldOffsetFromName(node.getRight()),true);
		out("addi",true);
		if(param==CodeFunction.VALUE) {
			out("load"+field.getType().getSuffix(),true);
		}
		return null;
	}

	// class ExpressionArrayAccess { Expression array; Expression accessPosition; }
	public Object visit(ExpressionArrayAccess node, Object param) {

		// super.visit(node, param);
		if (node.getArray() != null)
			node.getArray().accept(this, CodeFunction.ADDRESS);

		if (node.getAccessPosition() != null)
			node.getAccessPosition().accept(this, CodeFunction.VALUE);

		out("pushi " + node.getType().getMemSize(), true);
		out("muli", true);
		out("addi", true);

		if (param == CodeFunction.VALUE) {
			out("load" + node.getType().getSuffix(), true);
		}
		return null;
	}

	// class ExpressionFuncAccess { String name; List<Expression> parameters; }
	public Object visit(ExpressionFuncAccess node, Object param) {

		// super.visit(node, param);

		if (node.getParameters() != null)
			for (Expression child : node.getParameters())
				child.accept(this, param);
		out("call " + node.getName(), true);
		return null;
	}

	// class Parse { Type to; Expression from; }
	public Object visit(Parse node, Object param) {

		// super.visit(node, param);

		if (node.getTo() != null)
			node.getTo().accept(this, param);

		if (node.getFrom() != null)
			node.getFrom().accept(this, param);
		out(node.getFrom().getType().getSuffix() + "2" + node.getTo().getSuffix(), true);
		return null;
	}

	// class ArithmeticExpression { Expression left; String op; Expression right; }
	public Object visit(ArithmeticExpression node, Object param) {

		// super.visit(node, param);
		assert (param == CodeFunction.VALUE);
		if (node.getLeft() != null)
			node.getLeft().accept(this, CodeFunction.VALUE);

		if (node.getRight() != null)
			node.getRight().accept(this, CodeFunction.VALUE);
		if (node.getOp().equals("%")) {
			out(instruccion.get(node.getOp()), true);
		} else {
			out(instruccion.get(node.getOp()) + node.getType().getSuffix(), true);
		}
		return null;
	}

	// class BooleanExpression { Expression left; String comparison; Expression
	// right; }
	public Object visit(BooleanExpression node, Object param) {

		// super.visit(node, param);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);

		if (node.getRight() != null)
			node.getRight().accept(this, param);

		out(instruccion.get(node.getComparison()) + node.getType().getSuffix(), true);

		return null;
	}

	// class BooleanOfBooleansExpr { Expression left; String comparison; Expression
	// right; }
	public Object visit(BooleanOfBooleansExpr node, Object param) {

		// super.visit(node, param);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);

		if (node.getRight() != null)
			node.getRight().accept(this, param);

		out(instruccion.get(node.getComparison()), true);

		return null;
	}

	// class Negate { Expression negated; }
	public Object visit(Negate node, Object param) {

		// super.visit(node, param);

		if (node.getNegated() != null)
			node.getNegated().accept(this, param);
		out(instruccion.get("!"), true);
		return null;
	}

	// class Variable { String name; }
	public Object visit(Variable node, Object param) {
		if (((CodeFunction) param) == CodeFunction.VALUE) {
			visit(node, CodeFunction.ADDRESS);
			out("load"+node.getType().getSuffix(), true);
		} else { // Funcion.DIRECCION
			assert (param == CodeFunction.ADDRESS);
			if (node.getDefinition().getScope() == Scope.GLOBAL)
				out("pusha " + node.getDefinition().getAddress(), true);
			else if (node.getDefinition().getScope() == Scope.LOCAL
					|| node.getDefinition().getScope() == Scope.PARAMETER) {
				out("pusha BP", true);
				out("pushi " + node.getDefinition().getAddress(), true);
				out(instruccion.get("+") + "i", true);
			}
		}
		return null;
	}

	// class IntConstant { String value; }
	public Object visit(IntConstant node, Object param) {
		assert (param == CodeFunction.VALUE);
		out("push " + node.getValue(), true);
		return null;
	}

	// class FloatConstant { String value; }
	public Object visit(FloatConstant node, Object param) {
		assert (param == CodeFunction.VALUE);
		out("pushf " + node.getValue(), true);
		return null;
	}

	// class CharConstant { String value; }
	public Object visit(CharConstant node, Object param) {
		assert (param == CodeFunction.VALUE);
		if(node.getValue().equals("'\\n'")) {
			out("pushb " + (int)'\n', true);
		}else
			out("pushb " + (int)node.getValue().toCharArray()[1], true);
		return null;
	}

	// Imprime una línea en el fichero de salida
	private void out(String instruction, boolean tab) {
		writer.println(tab ? "\t" + instruction : instruction);
	}

	private void out(String instruccion, Type tipo, boolean tab) {
		out(instruccion + tipo.getSuffix(), tab);
	}

	private void line(AST node, boolean tab) {
		out("", true);
		if (node.getEnd() != null) {
			out("'" + node.getClass().getSimpleName(), tab);
			out("#line " + node.getEnd().getLine(), tab);
			
		} else
			System.out.println("#line no generado. Se ha pasado una Position null. Falta información en el AST");

	}

	private PrintWriter writer;
	private String sourceFile;
}
