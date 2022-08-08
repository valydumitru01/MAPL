/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import visitor.*;

//	expressionArrayAccess:expression -> array:expression  accessPosition:expression

public class ExpressionArrayAccess extends AbstractExpression {

	public ExpressionArrayAccess(Expression array, Expression accessPosition) {
		this.array = array;
		this.accessPosition = accessPosition;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(array, accessPosition);
	}

	public ExpressionArrayAccess(Object array, Object accessPosition) {
		this.array = (Expression) getAST(array);
		this.accessPosition = (Expression) getAST(accessPosition);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(array, accessPosition);
	}

	public Expression getArray() {
		return array;
	}
	public void setArray(Expression array) {
		this.array = array;
	}

	public Expression getAccessPosition() {
		return accessPosition;
	}
	public void setAccessPosition(Expression accessPosition) {
		this.accessPosition = accessPosition;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression array;
	private Expression accessPosition;

	public String toString() {
       return "{array:" + getArray() + ", accessPosition:" + getAccessPosition() + "}";
   }
}
