/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package semantic;

import java.util.Iterator;

import ast.*;
import ast.VarDef.Scope;
import main.*;
import visitor.*;

public class TypeChecking extends DefaultVisitor {

    public TypeChecking(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    // # ----------------------------------------------------------
    /*
    * Poner aquí los visit.
    *
    * Si se ha usado VGen, solo hay que copiarlos de la clase 'visitor/_PlantillaParaVisitors.txt'.
    */

    // public Object visit(Program prog, Object param) {
    //      ...
    // }

    // ...
    // ...
    // ...

   
	public Object visit(Program node, Object param) {

		// super.visit(node, param);
		if (node.getGlobal() != null)
			for (Global child : node.getGlobal()) {
				 if(child instanceof Func) {
						if(((Func)child).getName().equals("main")) {
							node.setHasMain(true);
						}
					}
				child.accept(this, param);
			}

		return null;
	}
	//	class VarDef { String name;  Type type; }
	public Object visit(VarDef node, Object param) {
		
		node.getType().accept(this, param);

		// super.visit(node, param);
		if(param==Scope.PARAMETER)
			predicado(esTipoSimple(node.getType()),
					"Parametro "+node.getName()+": El tipo de los parámetros debe ser tipo simple\n\t"
							+ "[Tipo esperado->Simple]"
							+ "[Tipo de expresión->"+node.getType(),node.getStart());
		return null;
	}


	//	class Func { String name;  List<VarDef> defineFuncParams;  Type type;  List<VarDef> bodyDefs;  List<Statement> bodyStmts; }
	public Object visit(Func node, Object param) {

		// super.visit(node, param);

		if (node.getDefineFuncParams() != null)
			for (VarDef child : node.getDefineFuncParams())
				child.accept(this, param);
		if (node.getType() != null)
			node.getType().accept(this, param);

		if (node.getBodyDefs() != null)
			for (VarDef child : node.getBodyDefs())
				child.accept(this, param);
		
		boolean thereIsAReturn=false;
		if (node.getBodyStmts() != null)
			for (Statement child : node.getBodyStmts()) {
				child.setFuncParent(node);
				child.accept(this, param);
				if(child instanceof Return)
					thereIsAReturn=true;
				
			}
		if(node.getType()!=null)
			predicado(thereIsAReturn,
					"Func: Debe haber un return no condicional \n \t");
		return null;
	}
	
	//	class Print { String printType;  Expression expression; }
	public Object visit(Print node, Object param) {

		// super.visit(node, param);
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		if(node.getExpression()!=null && node.getExpression().getType()!=null)
			predicado(esTipoSimple(node.getExpression().getType()),
			"Print: Tipo de la expresión del print no es un tipo simple \n \t"
			+ "[Tipo esperado->Simple] "
			+ "[Tipo actual->"+node.getExpression().getType()+"]",node.getStart());

		return null;
	}
	
	//	class Assignment { Expression assigned;  Expression right; }
	public Object visit(Assignment node, Object param) {

		// super.visit(node, param);
		
		if (node.getAssigned() != null)
			node.getAssigned().accept(this, param);

		if (node.getRight() != null)
			node.getRight().accept(this, param);
		
		if(node.getAssigned().getType()!=null && node.getRight()!=null)
			predicado(node.getAssigned().getType().toString().equals(node.getRight().getType().toString()),
					"Asignacion: Tipo de la izquierda diferente del tipo de la derecha de la asignacion\n\t"
					+ "[Tipo izquierda->"+node.getAssigned().getType()+"]"
					+ "[Tipo derecha->"+node.getRight().getType()+"]",node.getStart());
		
		predicado(node.getAssigned().getModifiable()==true,
				"Asignacion: La expresion asignada no es modificable",node.getStart());
		
		predicado(esTipoSimple(node.getRight().getType()),
				"Asignacion: El valor a asignar no es tipo simple\n\t"
				+ "[Tipo esperado->Simple]"
				+ "[Tipo de funcion->"+node.getRight().getType()+"]",node.getStart());
		return null;
	}
	
	//	class Return { Expression returned; }
	public Object visit(Return node, Object param) {
		
		// super.visit(node, param);

		if (node.getReturned() != null){
			
			node.getReturned().accept(this, param);
			if(node.getReturned()!=null)
				node.setReturnedType(node.getReturned().getType());
		}
		if(node.getReturnedType()==null || node.getFuncParent().getType()==null) {
			predicado(node.getFuncParent().getType()==null && node.getReturnedType()==null,
			"Return: Tipo de expresion del retorno diferente al tipo de la función\n\t"
			+ "[Tipo de retorno->"+node.getReturnedType()+"]"
			+ "[Tipo de función->"+node.getFuncParent().getType()+"]",node.getStart());
			
		}
		else
			predicado(node.getFuncParent().getType().toString().equals(node.getReturnedType().toString()),
				"Return: Tipo de expresion del retorno diferente al tipo de la función\n\t"
				+ "[Tipo de retorno->"+node.getReturnedType()+"]"
				+ "[Tipo de funcion->"+node.getFuncParent().getType()+"]",node.getStart());
		
		return null;
	}

	//	class FuncCall { String name;  List<Expression> parameters; }
	public Object visit(FuncCall node, Object param) {

		// super.visit(node, param);
		predicado(node.getDefinition().getDefineFuncParams().size()==node.getParameters().size(),
				"Procedimiento: Numero de parametros distinto a los de la funcion definida\n\t"
				+ "[Numero esperado->"+node.getDefinition().getDefineFuncParams().size()+"]"
				+ "[Numero actual->"+node.getParameters().size()+"]",node.getStart());
		if (node.getParameters() != null)
			for (Expression child : node.getParameters())
				child.accept(this, param);
		
		if(node.getDefinition().getDefineFuncParams().size()==node.getParameters().size()) {
		for (int j = 0; j < node.getParameters().size(); j++) {
			predicado(node.getParameters().get(j).getType().toString().equals(node.getDefinition().getDefineFuncParams().get(j).getType().toString()),
					"Procedimiento: Parametro de función " +j+" no coinciden en tipo con la funcion definida\n\t"
					+ "[Tipo parametro esperado->"+node.getDefinition().getDefineFuncParams().get(j).getType()+"]"
					+ "[Tipo parametro actual->"+node.getParameters().get(j).getType()+"]",node.getStart());
		}
		}
		return null;
	}

	//	class Read { Expression writtedInto; }
	public Object visit(Read node, Object param) {

		// super.visit(node, param);
		if (node.getWrittedInto() != null)
			node.getWrittedInto().accept(this, param);

		predicado(node.getWrittedInto().getModifiable()==true,
				"Read: No se puede escribir en una expresión no modificable",node.getStart());
		predicado(esTipoSimple(node.getWrittedInto().getType()),
				"Read: El tipo de la expresión en donde se escribe no es simple \n \t"
				+ "[Tipo esperado->Simple] "
				+ "[Tipo actual->"+node.getWrittedInto().getType(),node.getStart());
		
		return null;
	}

	
	
	//	class If { Expression enterCondition;  List<Statement> ifBody;  List<Statement> elseBody; }
	public Object visit(If node, Object param) {

		// super.visit(node, param);

		if (node.getEnterCondition() != null)
			node.getEnterCondition().accept(this, param);

		if (node.getIfBody() != null)
			for (Statement child : node.getIfBody()) {
				child.setFuncParent(node.getFuncParent());
				child.accept(this, param);
			}

		if (node.getElseBody() != null)
			for (Statement child : node.getElseBody()) {
				child.setFuncParent(node.getFuncParent());
				child.accept(this, param);
			}
		
		predicado(node.getEnterCondition().getType() instanceof IntType,
				"If: Tipo de condicion distinto de int \n \t"
				+ "[Tipo esperado->Int] "
				+ "[Tipo actual->"+node.getEnterCondition().getType(),node.getStart());
		
		return null;
	}

	//	class While { Expression stopCondition;  List<Statement> body; }
	public Object visit(While node, Object param) {

		// super.visit(node, param);

		if (node.getStopCondition() != null)
			node.getStopCondition().accept(this, param);
		
		predicado(node.getStopCondition().getType() instanceof IntType,
				"While: Tipo de condicion distinto de int \n\t"
				+ "[Tipo esperado->Int] "
				+ "[Tipo actual->"+node.getStopCondition().getType()+"]",node.getStart());
		
		if (node.getBody() != null)
			for (Statement child : node.getBody()) {
				child.setFuncParent(node.getFuncParent());
				child.accept(this, param);
			}
		

		for(Statement statement:node.getBody()){
			statement.setFuncParent(node.getFuncParent());
		}
		
		return null;
	}
	
	
//	class ExpressionPointAccess { Expression left;  String right; }
	public Object visit(ExpressionPointAccess node, Object param) {


		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		node.setModifiable(true);

		if(!(node.getLeft().getType() instanceof StructType)) {
			predicado(false, "Expresion struct: El tipo al que se intenta acceder mediante operador \".\" no es Struct \n \t "
					+ "[Tipo esperado->Struct] "
					+ "[Tipo actual->"+node.getLeft().getType()+"]",node.getStart());
		}else
			for (StructField field : ((StructType)node.getLeft().getType()).getDefinition().getStructfield()) {
				if(field.getName().equals(node.getRight()))
					node.setType(field.getType());
			}	
		
		
		
		return null;
	}

	//	class ExpressionArrayAccess { Expression array;  Expression accessPosition; }
	public Object visit(ExpressionArrayAccess node, Object param) {

		// super.visit(node, param);

		if (node.getArray() != null)
			node.getArray().accept(this, param);

		if (node.getAccessPosition() != null)
			node.getAccessPosition().accept(this, param);
		
		node.setModifiable(true);
		predicado(node.getArray().getType() instanceof ArrayType,
				"Expresion array: Tipo distinto de array\n\t"
				+ "[Tipo esperado->Array]"
				+ "[Tipo actual->"+node.getArray().getType()+"]",node.getStart());
		if(node.getArray().getType() instanceof ArrayType)
			node.setType(((ArrayType)node.getArray().getType()).getType());
		else return null;
		
		predicado(node.getAccessPosition().getType() instanceof IntType,
				"Expresion array: Tipo de expresión en un acceso a array distinto de int\n\t"
				+ "[Tipo esperado->Int]"
				+ "[Tipo actual->"+node.getAccessPosition().getType()+"]",node.getStart());
		
		return null;
	}
	
	//	class ExpressionFuncAccess { String name;  List<Expression> parameters; }
	public Object visit(ExpressionFuncAccess node, Object param) {
		predicado(node.getDefinition().getDefineFuncParams().size()==node.getParameters().size(),
				"Expresion funcion: Numero de parametros distinto a los de la funcion definida\n\t"
				+ "[Numero esperado->"+node.getDefinition().getDefineFuncParams().size()+"]"
				+ "[Numero actual->"+node.getParameters().size()+"]",node.getStart());
		// super.visit(node, param);
		if (node.getParameters() != null)
			for (Expression child : node.getParameters()) 
				child.accept(this, param);
		
		node.setType(node.getDefinition().getType());
		node.setModifiable(false);
		
		if(node.getDefinition().getDefineFuncParams().size()==node.getParameters().size())
			for (int j = 0; j < node.getParameters().size(); j++) {
				predicado(node.getParameters().get(j).getType().toString().equals(node.getDefinition().getDefineFuncParams().get(j).getType().toString()),
						"Expresion funcion: Parametro de procedimiento " +j+" no coinciden en tipo con la funcion definida\n\t"
								+ "[Tipo paramentro esperado->"+node.getDefinition().getDefineFuncParams().get(j).getType()+"]"
								+ "[Tipo parametros actual->"+node.getParameters().get(j).getType()+"]",node.getStart());
				
			}
		predicado(node.getDefinition().getType()!=null,
				"Expresion funcion: Tipo de la funcion definida es null",node.getStart());
		return null;
	}

	//	class Parse { Type to;  Expression from; }
	public Object visit(Parse node, Object param) {

		// super.visit(node, param);

		if (node.getTo() != null)
			node.getTo().accept(this, param);

		if (node.getFrom() != null)
			node.getFrom().accept(this, param);
		
		node.setType(node.getTo());
		node.setModifiable(false);
		predicado(node.getTo().getClass()!=node.getFrom().getClass(),
				"Parse: Tipo origen y tipo destino son iguales",node.getStart());
		predicado(esTipoSimple(node.getTo()),
				"Parse: Tipo origen no es tipo simple\n \t"
				+ "[Tipo esperado->Simple] "
				+ "[Tipo actual->"+node.getTo()+"]",node.getStart());
		predicado(esTipoSimple(node.getTo()),
				"Parse: Tipo destino no es tipo simple\n \t"
				+ "[Tipo esperado->Simple] "
				+ "[Tipo actual->"+node.getTo()+"]",node.getStart());
		return null;
	}

	//	class ArithmeticExpression { Expression left;  String op;  Expression right; }
	public Object visit(ArithmeticExpression node, Object param) {

		// super.visit(node, param);
		
		node.setModifiable(false);
		
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);

		if (node.getRight() != null)
			node.getRight().accept(this, param);
		
		node.setType(node.getLeft().getType());
		node.setModifiable(false);
		
		predicado(node.getRight().getType().getClass()==node.getLeft().getType().getClass(),
				"Expresion aritmetica: Las expresiones no son de mismo tipo",node.getStart());
		predicado(esNumero(node.getLeft().getType()),
				"Expresion aritmetica: Tipo de las expresiones no es numero \n \t"
				+ "[Tipo esperado->Numero] "
				+ "[Tipo actual->"+node.getLeft().getType(),node.getStart());
		
		return null;
	}
	
	
	//	class BooleanExpression { Expression left;  String comparison;  Expression right; }
	public Object visit(BooleanExpression node, Object param) {

		// super.visit(node, param);
		
		
		
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);

		if (node.getRight() != null)
			node.getRight().accept(this, param);
		
		node.setType(new IntType());
		node.setModifiable(false);
		
		predicado(node.getRight().getType().getClass()==node.getLeft().getType().getClass(),
				"Expresion booleana: Las expresiones no son de mismo tipo",node.getStart());
		predicado(esTipoSimple(node.getLeft().getType()),
				"Expresion booleana: Tipo de las expresiones no es simple \n \t"
				+ "[Tipo esperado->Simple] "
				+ "[Tipo actual->"+node.getLeft().getType(),node.getStart());
		
		return null;
	}

	//	class BooleanOfBooleansExpr { Expression left;  String comparison;  Expression right; }
	public Object visit(BooleanOfBooleansExpr node, Object param) {

		// super.visit(node, param);
		
		
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);

		if (node.getRight() != null)
			node.getRight().accept(this, param);
		
		node.setType(new IntType());
		node.setModifiable(false);
		
		predicado(node.getRight().getType().getClass()==node.getLeft().getType().getClass(),
				"Expresion booleana de booleanos: Las expresiones no son de mismo tipo",node.getStart());
		predicado(node.getLeft().getType() instanceof IntType,
				"Expresion booleana de booleanos: Tipo de la expresion no es int \n \t"
				+ "[Tipo esperado->Int] "
				+ "[Tipo actual->"+node.getLeft().getType(),node.getStart());
		
		return null;
	}

	//	class Negate { Expression negated; }
	public Object visit(Negate node, Object param) {

		// super.visit(node, param);
		
		
		if (node.getNegated() != null)
			node.getNegated().accept(this, param);

		node.setType(new IntType());
		node.setModifiable(false);
		
		predicado(node.getNegated().getType() instanceof IntType,
				"Negacion: Tipo de la expresión no es int \n \t"
				+ "[Tipo esperado->Int] "
				+ "[Tipo actual->"+node.getNegated().getType(),node.getStart());
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	//	class Variable { String name; }
	public Object visit(Variable node, Object param) {
		
		node.setType(node.getDefinition().getType());
		node.setModifiable(true);
		
		return null;
	}
	
	//	class IntConstant { String value; }
	public Object visit(IntConstant node, Object param) {
		
		node.setType(new IntType());
		node.setModifiable(false);
		
		return null;
	}
	
	
	//	class FloatConstant { String value; }
	public Object visit(FloatConstant node, Object param) {
		
		node.setType(new FloatType());
		node.setModifiable(false);
		
		return null;
	}

	//	class CharConstant { String value; }
	public Object visit(CharConstant node, Object param) {
		
		node.setType(new CharType());
		node.setModifiable(false);
		
		return null;
	}
	
	
	
	//	class ArrayType { IntConstant size;  Type type; }
	public Object visit(ArrayType node, Object param) {

		// super.visit(node, param);
		
		if (node.getSize() != null)
			node.getSize().accept(this, param);

		if (node.getType() != null)
			node.getType().accept(this, param);
		
		predicado(Integer.parseInt(node.getSize().getValue())>0,
				"Tipo array: El tamaño del array es menor que 0 [Valor actual->"+node.getSize().getValue());
		return null;
	}

	
    // # ----------------------------------------------------------
    // Métodos auxiliares recomendados (opcionales) -------------
	
    /**
     * predicado. Método auxiliar para implementar los predicados. Borrar si no se quiere usar.
     *
     * Ejemplos de uso (suponiendo que existe un método "esPrimitivo(expr)"):
     *
     *      1. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo primitivo", expr.getStart());
     *      2. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo primitivo", expr); // Se asume getStart()
     *      3. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo primitivo");
     *
     * NOTA: El método getStart() (ejemplo 1) indica la linea/columna del fichero fuente donde estaba el nodo
     * (y así poder dar información más detallada de la posición del error). Si se usa VGen, dicho método
     * habrá sido generado en todos los nodos del AST.
     * No es obligatorio llamar a getStart() (ejemplo 2), ya que si se pasa el nodo, se usará por defecto dicha
     * posición.
     * Si no se quiere imprimir la posición del fichero, se puede omitir el tercer argumento (ejemplo 3).
     *
     * @param condition     Debe cumplirse para que no se produzca un error
     * @param errorMessage  Se imprime si no se cumple la condición
     * @param posicionError Fila y columna del fichero donde se ha producido el error.
     */

	

    
    
    private void predicado(boolean condition, String errorMessage, Position position) {
        if (!condition) {
        	System.out.println();
            errorManager.notify("Type Checking", errorMessage, position);
        }
    }

    private void predicado(boolean condition, String errorMessage) {
        predicado(condition, errorMessage, (Position) null);
    }
    
    private boolean esTipoSimple(Type type) {
    	return type instanceof FloatType || type instanceof IntType || type instanceof CharType;
    }
    private boolean esNumero(Type type) {
    	return type instanceof FloatType || type instanceof IntType;
    }

    private ErrorManager errorManager;
}
