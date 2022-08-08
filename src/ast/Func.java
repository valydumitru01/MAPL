/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	func:global -> name:String  defineFuncParams:varDef*  type:type  bodyDefs:varDef*  bodyStmts:statement*

public class Func extends AbstractGlobal {

	private List<VarDef> bodyDefs;

	private List<Statement> bodyStmts;

	private List<VarDef> defineFuncParams;
	private String name;
	private Type type;
	public Func(Object name, Object defineFuncParams, Object type, Object bodyDefs, Object bodyStmts) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.defineFuncParams = this.<VarDef>getAstFromContexts(defineFuncParams);
		this.type = (Type) getAST(type);
		this.bodyDefs = this.<VarDef>getAstFromContexts(bodyDefs);
		this.bodyStmts = this.<Statement>getAstFromContexts(bodyStmts);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, defineFuncParams, type, bodyDefs, bodyStmts);
	}

	public Func(String name, List<VarDef> defineFuncParams, Type type, List<VarDef> bodyDefs, List<Statement> bodyStmts) {
		this.name = name;
		this.defineFuncParams = defineFuncParams;
		this.type = type;
		this.bodyDefs = bodyDefs;
		this.bodyStmts = bodyStmts;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(defineFuncParams, type, bodyDefs, bodyStmts);
	}
	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	public List<VarDef> getBodyDefs() {
		return bodyDefs;
	}
	public List<Statement> getBodyStmts() {
		return bodyStmts;
	}
	public int getBodyDefsMemSize() {
		return getMemSizeOfListVarDefs(bodyDefs);
	}

	public List<VarDef> getDefineFuncParams() {
		return defineFuncParams;
	}
	public int getDefineFuncParamsMemSize() {
		return getMemSizeOfListVarDefs(defineFuncParams);
	}
	private int getMemSizeOfListVarDefs(List<VarDef> list) {
		int sum=0;
		for(VarDef def:list) {
			sum+=def.getType().getMemSize();
		}
		return sum;
	}
	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}

	public void setBodyDefs(List<VarDef> bodyDefs) {
		this.bodyDefs = bodyDefs;
	}
	public void setBodyStmts(List<Statement> bodyStmts) {
		this.bodyStmts = bodyStmts;
	}
	public void setDefineFuncParams(List<VarDef> defineFuncParams) {
		this.defineFuncParams = defineFuncParams;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setType(Type type) {
		this.type = type;
	}

	public String toString() {
       return "{name:" + getName() + ", defineFuncParams:" + getDefineFuncParams() + ", type:" + getType() + ", bodyDefs:" + getBodyDefs() + ", bodyStmts:" + getBodyStmts() + "}";
   }

}
