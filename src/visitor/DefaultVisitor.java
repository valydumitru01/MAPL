/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package visitor;

import ast.*;
import java.util.*;

/*
DefaultVisitor. Implementación base del visitor para ser derivada por nuevos visitor.
	No modificar esta clase. Para crear nuevos visitor usar el fichero "_PlantillaParaVisitors.txt".
	DefaultVisitor ofrece una implementación por defecto de cada nodo que se limita a visitar los nodos hijos.
*/
public class DefaultVisitor implements Visitor {

	//	class Program { List<Global> global; }
	public Object visit(Program node, Object param) {
		visitChildren(node.getGlobal(), param);
		return null;
	}

	//	class Struct { String name;  List<StructField> structfield; }
	public Object visit(Struct node, Object param) {
		visitChildren(node.getStructfield(), param);
		return null;
	}

	//	class StructField { String name;  Type type; }
	public Object visit(StructField node, Object param) {
		if (node.getType() != null)
			node.getType().accept(this, param);
		return null;
	}

	//	class VarDef { String name;  Type type; }
	public Object visit(VarDef node, Object param) {
		if (node.getType() != null)
			node.getType().accept(this, param);
		return null;
	}

	//	class Func { String name;  List<VarDef> defineFuncParams;  Type type;  List<VarDef> bodyDefs;  List<Statement> bodyStmts; }
	public Object visit(Func node, Object param) {
		visitChildren(node.getDefineFuncParams(), param);
		if (node.getType() != null)
			node.getType().accept(this, param);
		visitChildren(node.getBodyDefs(), param);
		visitChildren(node.getBodyStmts(), param);
		return null;
	}

	//	class Print { String printType;  Expression expression; }
	public Object visit(Print node, Object param) {
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class Assignment { Expression assigned;  Expression right; }
	public Object visit(Assignment node, Object param) {
		if (node.getAssigned() != null)
			node.getAssigned().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class Return { Expression returned; }
	public Object visit(Return node, Object param) {
		if (node.getReturned() != null)
			node.getReturned().accept(this, param);
		return null;
	}

	//	class FuncCall { String name;  List<Expression> parameters; }
	public Object visit(FuncCall node, Object param) {
		visitChildren(node.getParameters(), param);
		return null;
	}

	//	class Read { Expression writtedInto; }
	public Object visit(Read node, Object param) {
		if (node.getWrittedInto() != null)
			node.getWrittedInto().accept(this, param);
		return null;
	}

	//	class If { Expression enterCondition;  List<Statement> ifBody;  List<Statement> elseBody; }
	public Object visit(If node, Object param) {
		if (node.getEnterCondition() != null)
			node.getEnterCondition().accept(this, param);
		visitChildren(node.getIfBody(), param);
		visitChildren(node.getElseBody(), param);
		return null;
	}

	//	class While { Expression stopCondition;  List<Statement> body; }
	public Object visit(While node, Object param) {
		if (node.getStopCondition() != null)
			node.getStopCondition().accept(this, param);
		visitChildren(node.getBody(), param);
		return null;
	}

	//	class ExpressionPointAccess { Expression left;  String right; }
	public Object visit(ExpressionPointAccess node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		return null;
	}

	//	class ExpressionArrayAccess { Expression array;  Expression accessPosition; }
	public Object visit(ExpressionArrayAccess node, Object param) {
		if (node.getArray() != null)
			node.getArray().accept(this, param);
		if (node.getAccessPosition() != null)
			node.getAccessPosition().accept(this, param);
		return null;
	}

	//	class ExpressionFuncAccess { String name;  List<Expression> parameters; }
	public Object visit(ExpressionFuncAccess node, Object param) {
		visitChildren(node.getParameters(), param);
		return null;
	}

	//	class Parse { Type to;  Expression from; }
	public Object visit(Parse node, Object param) {
		if (node.getTo() != null)
			node.getTo().accept(this, param);
		if (node.getFrom() != null)
			node.getFrom().accept(this, param);
		return null;
	}


	//	class ArithmeticExpression { Expression left;  String op;  Expression right; }
	public Object visit(ArithmeticExpression node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class BooleanExpression { Expression left;  String comparison;  Expression right; }
	public Object visit(BooleanExpression node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class BooleanOfBooleansExpr { Expression left;  String comparison;  Expression right; }
	public Object visit(BooleanOfBooleansExpr node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class Negate { Expression negated; }
	public Object visit(Negate node, Object param) {
		if (node.getNegated() != null)
			node.getNegated().accept(this, param);
		return null;
	}

	//	class Variable { String name; }
	public Object visit(Variable node, Object param) {
		return null;
	}

	//	class IntConstant { String value; }
	public Object visit(IntConstant node, Object param) {
		return null;
	}

	//	class FloatConstant { String value; }
	public Object visit(FloatConstant node, Object param) {
		return null;
	}

	//	class CharConstant { String value; }
	public Object visit(CharConstant node, Object param) {
		return null;
	}

	//	class IntType {  }
	public Object visit(IntType node, Object param) {
		return null;
	}

	//	class FloatType {  }
	public Object visit(FloatType node, Object param) {
		return null;
	}

	//	class CharType {  }
	public Object visit(CharType node, Object param) {
		return null;
	}

	//	class StructType { String name; }
	public Object visit(StructType node, Object param) {
		return null;
	}

	//	class ArrayType { IntConstant size;  Type type; }
	public Object visit(ArrayType node, Object param) {
		if (node.getSize() != null)
			node.getSize().accept(this, param);
		if (node.getType() != null)
			node.getType().accept(this, param);
		return null;
	}

    // Método auxiliar -----------------------------
    protected void visitChildren(List<? extends AST> children, Object param) {
        if (children != null)
            for (AST child : children)
                child.accept(this, param);
    }
}
