/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

public abstract class AbstractStatement extends AbstractAST implements Statement {
	protected Func funcParent;
	public Func getFuncParent() {
		return funcParent;
	}
	public void setFuncParent(Func funcParent) {
		this.funcParent=funcParent;
	}
}
