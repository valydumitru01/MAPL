/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

public abstract class AbstractExpression extends AbstractAST implements Expression {
	
	protected Type type;
	protected boolean modificable;
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public boolean getModifiable() {
		return this.modificable;
	}
	public void setModifiable(boolean modifiable) {
		this.modificable=modifiable;
	}
}
