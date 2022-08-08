/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import visitor.*;

//	read:statement -> writtedInto:expression

public class Read extends AbstractStatement {

	public Read(Expression writtedInto) {
		this.writtedInto = writtedInto;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(writtedInto);
	}

	public Read(Object writtedInto) {
		this.writtedInto = (Expression) getAST(writtedInto);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(writtedInto);
	}

	public Expression getWrittedInto() {
		return writtedInto;
	}
	public void setWrittedInto(Expression writtedInto) {
		this.writtedInto = writtedInto;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression writtedInto;

	public String toString() {
       return "{writtedInto:" + getWrittedInto() + "}";
   }
}
