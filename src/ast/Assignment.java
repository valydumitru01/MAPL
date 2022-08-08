/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import visitor.*;

//	assignment:statement -> assigned:expression  right:expression

public class Assignment extends AbstractStatement {

	public Assignment(Expression assigned, Expression right) {
		this.assigned = assigned;
		this.right = right;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(assigned, right);
	}

	public Assignment(Object assigned, Object right) {
		this.assigned = (Expression) getAST(assigned);
		this.right = (Expression) getAST(right);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(assigned, right);
	}

	public Expression getAssigned() {
		return assigned;
	}
	public void setAssigned(Expression assigned) {
		this.assigned = assigned;
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

	private Expression assigned;
	private Expression right;

	public String toString() {
       return "{assigned:" + getAssigned() + ", right:" + getRight() + "}";
   }
}
