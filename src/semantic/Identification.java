/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package semantic;

import java.util.HashMap;
import java.util.Map;

import ast.AST;
import ast.Expression;
import ast.ExpressionFuncAccess;
import ast.Func;
import ast.FuncCall;
import ast.Position;
import ast.Statement;
import ast.Struct;
import ast.StructField;
import ast.StructType;
import ast.VarDef;
import ast.Variable;
import main.ErrorManager;
import visitor.DefaultVisitor;

public class Identification extends DefaultVisitor {

    public Identification(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

	//	class Struct { String name;  List<StructField> structfield; }
	public Object visit(Struct node, Object param) {

		// super.visit(node, param);
		Struct definition=structs.get(node.getName());
		predicado(definition==null,"Struct ya definido: " + node.getName(),node);
		structs.put(node.getName(), node);
		if (node.getStructfield() != null)
			for (StructField child : node.getStructfield())
				child.accept(this, param);

		return null;
	}
//	class StructType { String name; }
	public Object visit(StructType node, Object param) {
		Struct definition=structs.get(node.getName());
		predicado(definition!=null,"Struct no definido: " + node.getName(),node);
		node.setDefinition(definition);
		return null;
	}
	//	class ExpressionFuncAccess { String name;  List<Expression> expression; }
	public Object visit(ExpressionFuncAccess node, Object param) {
		Func definition=functions.get(node.getName());
		predicado(definition!=null,"Funcion no definida: " + node.getName(),node);
		node.setDefinition(definition);
		// super.visit(node, param);

		if (node.getParameters() != null)
			for (Expression child : node.getParameters())
				child.accept(this, param);


		return null;
	}
	
	//	class FuncCall { String name;  List<Expression> parameters; }
	public Object visit(FuncCall node, Object param) {
		Func definition=functions.get(node.getName());
		predicado(definition!=null,"Procedimiento no definido: " + node.getName(),node);
		node.setDefinition(definition);
		
		// super.visit(node, param);

		if (node.getParameters() != null)
			for (Expression child : node.getParameters())
				child.accept(this, param);

		return null;
	}
	//	class Func { String name;  List<VarDef> defineFuncParams;  Type type;  List<VarDef> bodyDefs;  List<Statement> bodyStmts; }
	public Object visit(Func node, Object param) {
		
		
		variables.set();
		Func definition=functions.get(node.getName());
		predicado(definition==null,"Funcion ya definida: " + node.getName(),node);
		functions.put(node.getName(), node);
		// super.visit(node, param);
		if (node.getDefineFuncParams() != null)
			for (VarDef child : node.getDefineFuncParams()) 
				child.accept(this, VarDef.Scope.PARAMETER);
			

		if (node.getType() != null)
			node.getType().accept(this, param);

		if (node.getBodyDefs() != null)
			for (VarDef child : node.getBodyDefs())
				child.accept(this, VarDef.Scope.LOCAL);

		if (node.getBodyStmts() != null)
			for (Statement child : node.getBodyStmts())
				child.accept(this, param);

		variables.reset();
		return null;
	}
 // class VarDefinition { Type type; String name; }
    public Object visit(VarDef node, Object param) {
	    node.getType().accept(this, param); // No es necesario realmente
	    VarDef definicion = variables.getFromTop(node.getName());
	    predicado(definicion == null, "Variable ya definida: " + node.getName(), node);
	    variables.put(node.getName(), node);
	    
	    if(param instanceof VarDef.Scope)
	    	node.setScope((VarDef.Scope)param);
	    else {
	    	node.setScope(VarDef.Scope.GLOBAL);
	    }
	    return null;
    }
    
    // class Variable { String name; }
    public Object visit(Variable node, Object param) {
    	VarDef definicion = variables.getFromAny(node.getName());
	    predicado(definicion != null, "Variable no definida: " + node.getName(), node);
	    node.setDefinicion(definicion); // Enlazar referencia con definición
	    return null;
    }
    
    private void error(String msg) {
        error(msg, null);
    }

    private void error(String msg, Position position) {
        errorManager.notify("Identification", msg, position);
    }
    private void predicado(boolean condition, String errorMessage, AST node) {
    	if (!condition)
    	error(errorMessage, node.getStart());
    }

    private ErrorManager errorManager;
    private Map<String,Struct> structs=new HashMap<>();
    private Map<String,Func> functions=new HashMap<>();
    private ContextMap<String, VarDef> variables = new ContextMap<String, VarDef>();
}
