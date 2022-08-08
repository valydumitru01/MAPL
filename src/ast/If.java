/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import java.util.*;
import visitor.*;

//	if:statement -> enterCondition:expression  ifBody:statement*  elseBody:statement*

public class If extends AbstractStatement {

	public If(Expression enterCondition, List<Statement> ifBody, List<Statement> elseBody) {
		this.enterCondition = enterCondition;
		this.ifBody = ifBody;
		this.elseBody = elseBody;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(enterCondition, ifBody, elseBody);
	}

	public If(Object enterCondition, Object ifBody, Object elseBody) {
		this.enterCondition = (Expression) getAST(enterCondition);
		this.ifBody = this.<Statement>getAstFromContexts(ifBody);
		this.elseBody = this.<Statement>getAstFromContexts(elseBody);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(enterCondition, ifBody, elseBody);
	}

	public Expression getEnterCondition() {
		return enterCondition;
	}
	public void setEnterCondition(Expression enterCondition) {
		this.enterCondition = enterCondition;
	}

	public List<Statement> getIfBody() {
		return ifBody;
	}
	public void setIfBody(List<Statement> ifBody) {
		this.ifBody = ifBody;
	}

	public List<Statement> getElseBody() {
		return elseBody;
	}
	public void setElseBody(List<Statement> elseBody) {
		this.elseBody = elseBody;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression enterCondition;
	private List<Statement> ifBody;
	private List<Statement> elseBody;

	public String toString() {
       return "{enterCondition:" + getEnterCondition() + ", ifBody:" + getIfBody() + ", elseBody:" + getElseBody() + "}";
   }
}
