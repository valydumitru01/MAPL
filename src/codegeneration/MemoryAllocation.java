/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration;

import ast.*;
import visitor.*;

/**
 * Clase encargada de asignar direcciones a las variables.
 */
public class MemoryAllocation extends DefaultVisitor {

    // class Programa { List<DefVariable> definiciones; List<Sentencia> sentencias; }
    public Object visit(Program node, Object param) {

        int currentAddress = 0;

        for (Global child : node.getGlobal()) {
        	child.accept(this, param);
        	if(child instanceof VarDef) {
	            ((VarDef)child).setAddress(currentAddress);
	            System.out.println("Variable global \""+((VarDef)child).getName()+"\" está en la posicion de memoria "+currentAddress);
	            currentAddress += ((VarDef)child).getType().getMemSize();
        	}
        	
        }
        return null;
    }
    
    //	class Func { String name;  List<VarDef> defineFuncParams;  Type type;  List<VarDef> bodyDefs;  List<Statement> bodyStmts; }
	public Object visit(Func node, Object param) {

		// super.visit(node, param);
		
		
		
		if (node.getDefineFuncParams() != null) {
			
			for (VarDef child : node.getDefineFuncParams()) {
				child.accept(this, param);
			}
			int currentAddress=4;
			for (int i = node.getDefineFuncParams().size()-1; i >= 0; i--) {
				node.getDefineFuncParams().get(i).setAddress(currentAddress);
				System.out.println("Parametro \""+node.getDefineFuncParams().get(i).getName()+"\" está en la posicion de memoria BP+"+currentAddress);
				currentAddress+=node.getDefineFuncParams().get(i).getType().getMemSize();
			}
		}

		if (node.getType() != null)
			node.getType().accept(this, param);

		if (node.getBodyDefs() != null) {
			int currentAddress=0;
			for (VarDef child : node.getBodyDefs()) {
				
				child.accept(this, param);
				
				currentAddress-=child.getType().getMemSize();
				child.setAddress(currentAddress);
				System.out.println("Variable local \""+child.getName()+"\" está en la posicion de memoria BP"+currentAddress);
				
			}
		}

		if (node.getBodyStmts() != null)
			for (Statement child : node.getBodyStmts())
				child.accept(this, param);

		return null;
	}

}
