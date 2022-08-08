/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	booleanOfBooleansExpr:expression -> left:expression  comparison:String  right:expression

public class BooleanOfBooleansExpr extends AbstractExpression {

	public BooleanOfBooleansExpr(Expression left, String comparison, Expression right) {
		this.left = left;
		this.comparison = comparison;
		this.right = right;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(left, right);
	}

	public BooleanOfBooleansExpr(Object left, Object comparison, Object right) {
		this.left = (Expression) getAST(left);
		this.comparison = (comparison instanceof Token) ? ((Token)comparison).getText() : (String) comparison;
		this.right = (Expression) getAST(right);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(left, comparison, right);
	}

	public Expression getLeft() {
		return left;
	}
	public void setLeft(Expression left) {
		this.left = left;
	}

	public String getComparison() {
		return comparison;
	}
	public void setComparison(String comparison) {
		this.comparison = comparison;
	}

	public Expression getRight() {
		return right;
	}
	public void setRight(Expression right) {
		this.right = right;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression left;
	private String comparison;
	private Expression right;

	public String toString() {
       return "{left:" + getLeft() + ", comparison:" + getComparison() + ", right:" + getRight() + "}";
   }
}
