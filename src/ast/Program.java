/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import java.util.*;
import visitor.*;

//	program -> global:global*

public class Program extends AbstractAST  {

	public Program(List<Global> global) {
		this.global = global;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(global);
	}

	public Program(Object global) {
		this.global = this.<Global>getAstFromContexts(global);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(global);
	}

	public List<Global> getGlobal() {
		return global;
	}
	public void setGlobal(List<Global> global) {
		this.global = global;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private List<Global> global;
	private boolean hasMain;
	public String toString() {
       return "{global:" + getGlobal() + "}";
   }

	public boolean hasMain() {
		return hasMain;
	}

	public void setHasMain(boolean hasMain) {
		this.hasMain = hasMain;
	}
}
