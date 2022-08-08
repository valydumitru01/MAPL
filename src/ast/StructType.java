/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	structType:type -> name:String

public class StructType extends AbstractType {

	private Struct definition;
	public StructType(String name) {
		this.name = name;
	}

	public StructType(Object name) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;

	public String toString() {
       return "{name:" + getName() + "}";
   }

	public Struct getDefinition() {
		return definition;
	}

	public void setDefinition(Struct definition) {
		this.definition = definition;
	}

	@Override
	public int getMemSize() {
		int size=0;
		for(StructField structField:getDefinition().getStructfield())
			size+=structField.getType().getMemSize();
		return size;
	}

	@Override
	public String getMAPLName() {
		// TODO Auto-generated method stub
		return "struct";
	}

	@Override
	public char getSuffix() {
		// TODO Auto-generated method stub
		return 0;
	}
}
