/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	funcCall:statement -> name:String  parameters:expression*

public class FuncCall extends AbstractStatement {
	private Func definition;
	public Func getDefinition() {
		return definition;
	}

	public void setDefinition(Func definition) {
		this.definition = definition;
	}

	public FuncCall(String name, List<Expression> parameters) {
		this.name = name;
		this.parameters = parameters;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(parameters);
	}

	public FuncCall(Object name, Object parameters) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.parameters = this.<Expression>getAstFromContexts(parameters);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, parameters);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Expression> getParameters() {
		return parameters;
	}
	public void setParameters(List<Expression> parameters) {
		this.parameters = parameters;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;
	private List<Expression> parameters;

	public String toString() {
       return "{name:" + getName() + ", parameters:" + getParameters() + "}";
   }
}
