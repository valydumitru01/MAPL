/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import visitor.*;

//	negate:expression -> negated:expression

public class Negate extends AbstractExpression {

	public Negate(Expression negated) {
		this.negated = negated;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(negated);
	}

	public Negate(Object negated) {
		this.negated = (Expression) getAST(negated);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(negated);
	}

	public Expression getNegated() {
		return negated;
	}
	public void setNegated(Expression negated) {
		this.negated = negated;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression negated;

	public String toString() {
       return "{negated:" + getNegated() + "}";
   }
}
