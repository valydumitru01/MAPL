/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	print:statement -> printType:String  expression:expression

public class Print extends AbstractStatement {

	public Print(String printType, Expression expression) {
		this.printType = printType;
		this.expression = expression;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expression);
	}

	public Print(Object printType, Object expression) {
		this.printType = (printType instanceof Token) ? ((Token)printType).getText() : (String) printType;
		this.expression = (Expression) getAST(expression);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(printType, expression);
	}

	public String getPrintType() {
		return printType;
	}
	public void setPrintType(String printType) {
		this.printType = printType;
	}

	public Expression getExpression() {
		return expression;
	}
	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String printType;
	private Expression expression;
	public String toString() {
       return "{printType:" + getPrintType() + ", expression:" + getExpression() + "}";
   }
}
