/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import java.util.*;
import visitor.*;

//	while:statement -> stopCondition:expression  body:statement*

public class While extends AbstractStatement {

	public While(Expression stopCondition, List<Statement> body) {
		this.stopCondition = stopCondition;
		this.body = body;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(stopCondition, body);
	}

	public While(Object stopCondition, Object body) {
		this.stopCondition = (Expression) getAST(stopCondition);
		this.body = this.<Statement>getAstFromContexts(body);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(stopCondition, body);
	}

	public Expression getStopCondition() {
		return stopCondition;
	}
	public void setStopCondition(Expression stopCondition) {
		this.stopCondition = stopCondition;
	}

	public List<Statement> getBody() {
		return body;
	}
	public void setBody(List<Statement> body) {
		this.body = body;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression stopCondition;
	private List<Statement> body;

	public String toString() {
       return "{stopCondition:" + getStopCondition() + ", body:" + getBody() + "}";
   }
}
