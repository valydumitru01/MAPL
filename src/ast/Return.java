/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import visitor.*;

//	return:statement -> returned:expression

public class Return extends AbstractStatement {
	public Return(Expression returned) {
		this.returned = returned;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(returned);
	}

	public Return(Object returned) {
		this.returned = (Expression) getAST(returned);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(returned);
	}

	public Expression getReturned() {
		return returned;
	}
	public Type getReturnedType() {
		return returnedType;
	}
	public void setReturnedType(Type returnedType) {
		this.returnedType=returnedType;
	}
	public void setReturned(Expression returned) {
		
		this.returned = returned;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression returned;
	private Type returnedType;
	public String toString() {
       return "{returned:" + getReturned() + "}";
   }
}
