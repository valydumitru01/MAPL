package main;

import ast.ArithmeticExpression;
import ast.ArrayType;
import ast.Assignment;
import ast.BooleanExpression;
import ast.BooleanOfBooleansExpr;
import ast.CharConstant;
import ast.CharType;
import ast.Expression;
import ast.ExpressionArrayAccess;
import ast.ExpressionFuncAccess;
import ast.ExpressionPointAccess;
import ast.FloatConstant;
import ast.FloatType;
import ast.Func;
import ast.FuncCall;
import ast.Global;
import ast.If;
import ast.IntConstant;
import ast.IntType;
import ast.Negate;
import ast.Parse;
import ast.Print;
import ast.Program;
import ast.Read;
import ast.Return;
import ast.Statement;
import ast.Struct;
import ast.StructField;
import ast.StructType;
import ast.VarDef;
import ast.Variable;
import ast.While;
import visitor.Visitor;

public class MiNuevoVisitor implements Visitor{

	//	class Program { List<Global> global; }
	public Object visit(Program node, Object param) {

		// super.visit(node, param);

		if (node.getGlobal() != null)
			for (Global child : node.getGlobal()) {
				child.accept(this, param);
				System.out.println();
			}
		

		return null;
	}
	//	class Struct { String name;  List<StructField> structfield; }
	public Object visit(Struct node, Object param) {
		System.out.println("struct "+node.getName()+"{");
		// super.visit(node, param);
		
		if (node.getStructfield() != null)
			for (StructField child : node.getStructfield()) {
				child.accept(this, param);
				System.out.print(";\n");
			}
		System.out.print("}");
		return null;
	}

	//	class StructField { String name;  Type type; }
	public Object visit(StructField node, Object param) {
		
		// super.visit(node, param);
		System.out.print("\t"+node.getName()+":");
		if (node.getType() != null)
			node.getType().accept(this, param);

		return null;
	}

	//	class VarDef { String name;  Type type; }
	public Object visit(VarDef node, Object param) {
		// super.visit(node, param);
		System.out.print("var "+node.getName()+":");
		if (node.getType() != null)
			node.getType().accept(this, param);
		return null;
	}

	//	class Func { String name;  List<VarDef> defineFuncParams;  Type type;  List<VarDef> bodyDefs;  List<Statement> bodyStmts; }
	public Object visit(Func node, Object param) {
		
		// super.visit(node, param);
		System.out.print(node.getName()+"(" );
		if (node.getDefineFuncParams() != null) {
			int i=0;
			for (VarDef child : node.getDefineFuncParams()) {
				//child.accept(this, param);
				
				System.out.print(child.getName()+":");
				child.getType().accept(this, param);
				if(i<node.getDefineFuncParams().size()-1)
					System.out.print(",");
				i++;
			}
		}
		System.out.print(")");
		if (node.getType() != null) {
			System.out.print(":");
			node.getType().accept(this, param);
		}
		System.out.println("{");
		if (node.getBodyDefs() != null)
			for (VarDef child : node.getBodyDefs()) {
				System.out.print("\t");
				child.accept(this, param);
				System.out.print(";\n");
			}

		if (node.getBodyStmts() != null)
			for (Statement child : node.getBodyStmts()){
				System.out.print("\t");
				child.accept(this, param);
				System.out.print(";\n");
			}
		System.out.println();
		System.out.print("}");
		System.out.println();
		return null;
	}

	//	class Print { String printType;  Expression expression; }
	public Object visit(Print node, Object param) {

		// super.visit(node, param);
		System.out.print(node.getPrintType()+" ");
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);

		return null;
	}

	//	class Assignment { Expression assigned;  Expression right; }
	public Object visit(Assignment node, Object param) {

		// super.visit(node, param);
		
		if (node.getAssigned() != null)
			node.getAssigned().accept(this, param);
		System.out.print(" = ");
		if (node.getRight() != null)
			node.getRight().accept(this, param);

		return null;
	}

	//	class Return { Expression returned; }
	public Object visit(Return node, Object param) {

		// super.visit(node, param);
		System.out.print("return ");
		if (node.getReturned() != null)
			node.getReturned().accept(this, param);

		return null;
	}

	//	class FuncCall { String name;  List<Expression> parameters; }
	public Object visit(FuncCall node, Object param) {
		int i=0;
		// super.visit(node, param);
		System.out.print(node.getName()+"(");
		if (node.getParameters() != null) {
			for (Expression child : node.getParameters()) {
				child.accept(this, param);
				if(i<node.getParameters().size()-1)
					System.out.print(",");
			}
			i++;
		}
		System.out.print(")");
		
		return null;
	}

	//	class Read { Expression writtedInto; }
	public Object visit(Read node, Object param) {

		// super.visit(node, param);
		System.out.print("read ");
		if (node.getWrittedInto() != null)
			node.getWrittedInto().accept(this, param);

		return null;
	}

	//	class If { Expression enterCondition;  List<Statement> ifBody;  List<Statement> elseBody; }
	public Object visit(If node, Object param) {

		// super.visit(node, param);
		System.out.print("if(");
		if (node.getEnterCondition() != null)
			node.getEnterCondition().accept(this, param);
		System.out.print("){");
		System.out.println();
		if (node.getIfBody() != null)
			for (Statement child : node.getIfBody()) {
				if(child!=null) {
				System.out.print("\t");
				child.accept(this, param);
				System.out.print(";\n");
				}
				
			}
		System.out.print("}");
		if (node.getElseBody() != null) {
			System.out.print("else{");
			System.out.println();
			for (Statement child : node.getElseBody()) {
				System.out.print("\t");
				child.accept(this, param);
				System.out.print(";\n");
			}
			System.out.print("}");
		}
		return null;
	}

	//	class While { Expression stopCondition;  List<Statement> body; }
	public Object visit(While node, Object param) {

		// super.visit(node, param);
		System.out.print("while(");
		if (node.getStopCondition() != null)
			node.getStopCondition().accept(this, param);
		System.out.print("){");
		System.out.println();
		if (node.getBody() != null)
			for (Statement child : node.getBody()) {
				System.out.print("\t");
				if(child!=null)
					child.accept(this, param);
				System.out.print(";\n");
			}
		System.out.println();
		System.out.print("}");
		return null;
	}

	//	class ExpressionPointAccess { Expression left;  String right; }
	public Object visit(ExpressionPointAccess node, Object param) {

		// super.visit(node, param);
		
		if (node.getLeft() != null) {
			
			node.getLeft().accept(this, param);
			System.out.print(".");
			System.out.print(node.getRight()); 
		}
		
		return null;
	}

	//	class ExpressionArrayAccess { Expression array;  Expression accessPosition; }
	public Object visit(ExpressionArrayAccess node, Object param) {

		// super.visit(node, param);

		if (node.getArray() != null) {
			node.getArray().accept(this, param);
			
		}
		
		if (node.getAccessPosition() != null) {
			System.out.print("[");
			node.getAccessPosition().accept(this, param);
			System.out.print("]");
		}

		return null;
	}

	//	class ExpressionFuncAccess { String name;  List<Expression> expression; }
	public Object visit(ExpressionFuncAccess node, Object param) {

		// super.visit(node, param);
		System.out.print(node.getName()+"(");
		if (node.getParameters() != null)
			for (Expression child : node.getParameters())
				child.accept(this, param);
		System.out.print(")");
		return null;
	}

	//	class Parse { Type to;  Expression from; }
	public Object visit(Parse node, Object param) {

		// super.visit(node, param);
		
		if (node.getTo() != null) {
			System.out.print("<");
			node.getTo().accept(this, param);
			System.out.print(">");
		}
		
		
		if (node.getFrom() != null) {
			node.getFrom().accept(this, param);
		}
		
		return null;
	}

	//	class ArithmeticExpression { Expression left;  String op;  Expression right; }
	public Object visit(ArithmeticExpression node, Object param) {

		// super.visit(node, param);
		
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		System.out.print(node.getOp());
		if (node.getRight() != null)
			node.getRight().accept(this, param);

		return null;
	}

	//	class BooleanExpression { Expression left;  String comparison;  Expression right; }
	public Object visit(BooleanExpression node, Object param) {

		// super.visit(node, param);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		System.out.print(node.getComparison());
		if (node.getRight() != null)
			node.getRight().accept(this, param);

		return null;
	}

	//	class Negate { Expression negated; }
	public Object visit(Negate node, Object param) {

		// super.visit(node, param);
		System.out.print("!");
		if (node.getNegated() != null)
			node.getNegated().accept(this, param);

		return null;
	}

	//	class Variable { String name; }
	public Object visit(Variable node, Object param) {
		System.out.print(node.getName());
		return null;
	}

	//	class IntConstant { String value; }
	public Object visit(IntConstant node, Object param) {
		System.out.print(node.getValue());
		return null;
	}

	//	class FloatConstant { String value; }
	public Object visit(FloatConstant node, Object param) {
		System.out.print(node.getValue());
		return null;
	}

	//	class CharConstant { String value; }
	public Object visit(CharConstant node, Object param) {
		System.out.print(node.getValue());
		return null;
	}

	//	class IntType {  }
	public Object visit(IntType node, Object param) {
		System.out.print("int");
		return null;
	}

	//	class FloatType {  }
	public Object visit(FloatType node, Object param) {
		System.out.print("float");
		return null;
	}

	//	class CharType {  }
	public Object visit(CharType node, Object param) {
		System.out.print("char");
		return null;
	}

	//	class StructType { String name; }
	public Object visit(StructType node, Object param) {
		System.out.print(node.getName());
		return null;
	}

	//	class ArrayType { IntConstant size;  Type type; }
	public Object visit(ArrayType node, Object param) {

		// super.visit(node, param);
		System.out.print("[");
		if (node.getSize() != null)
			node.getSize().accept(this, param);
		System.out.print("]");
		if (node.getType() != null)
			node.getType().accept(this, param);

		return null;
	}


	//	class BooleanExpression { Expression left;  String comparison;  Expression right; }
	public Object visit(BooleanOfBooleansExpr node, Object param) {

		// super.visit(node, param);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		System.out.print(node.getComparison());
		if (node.getRight() != null)
			node.getRight().accept(this, param);

		return null;
	}


}
