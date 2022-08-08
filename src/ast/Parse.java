/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import visitor.*;

//	parse:expression -> to:type  from:expression

public class Parse extends AbstractExpression {

	public Parse(Type to, Expression from) {
		this.to = to;
		this.from = from;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(to, from);
	}

	public Parse(Object to, Object from) {
		this.to = (Type) getAST(to);
		this.from = (Expression) getAST(from);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(to, from);
	}

	public Type getTo() {
		return to;
	}
	public void setTo(Type to) {
		this.to = to;
	}

	public Expression getFrom() {
		return from;
	}
	public void setFrom(Expression from) {
		this.from = from;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Type to;
	private Expression from;

	public String toString() {
       return "{to:" + getTo() + ", from:" + getFrom() + "}";
   }
}
