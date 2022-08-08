/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package visitor;

import ast.*;

public interface Visitor {
	public Object visit(Program node, Object param);
	public Object visit(Struct node, Object param);
	public Object visit(StructField node, Object param);
	public Object visit(VarDef node, Object param);
	public Object visit(Func node, Object param);
	public Object visit(Print node, Object param);
	public Object visit(Assignment node, Object param);
	public Object visit(Return node, Object param);
	public Object visit(FuncCall node, Object param);
	public Object visit(Read node, Object param);
	public Object visit(If node, Object param);
	public Object visit(While node, Object param);
	public Object visit(ExpressionPointAccess node, Object param);
	public Object visit(ExpressionArrayAccess node, Object param);
	public Object visit(ExpressionFuncAccess node, Object param);
	public Object visit(Parse node, Object param);

	public Object visit(ArithmeticExpression node, Object param);
	public Object visit(BooleanExpression node, Object param);
	public Object visit(BooleanOfBooleansExpr node, Object param);
	public Object visit(Negate node, Object param);
	public Object visit(Variable node, Object param);
	public Object visit(IntConstant node, Object param);
	public Object visit(FloatConstant node, Object param);
	public Object visit(CharConstant node, Object param);
	public Object visit(IntType node, Object param);
	public Object visit(FloatType node, Object param);
	public Object visit(CharType node, Object param);
	public Object visit(StructType node, Object param);
	public Object visit(ArrayType node, Object param);
}
