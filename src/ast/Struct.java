/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	struct:global -> name:String  structfield:structField*

public class Struct extends AbstractGlobal {

	public Struct(String name, List<StructField> structfield) {
		this.name = name;
		this.structfield = structfield;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(structfield);
	}

	public Struct(Object name, Object structfield) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.structfield = this.<StructField>getAstFromContexts(structfield);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, structfield);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<StructField> getStructfield() {
		return structfield;
	}
	public void setStructfield(List<StructField> structfield) {
		this.structfield = structfield;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}
	public StructField getFieldFromName(String name) {
		for(StructField field:structfield) {
			if(field.getName().equals(name)) {
				return field;
		
			}
		}
		return null;
	}
	public int getFieldOffsetFromName(String name) {
		int acc=0;
		for(StructField field:structfield) {
			if(field.getName().equals(name)) {
				return acc;
		
			}
			acc+=field.getType().getMemSize();
		}
		return -1;
	}
	private String name;
	private List<StructField> structfield;

	public String toString() {
       return "{name:" + getName() + ", structfield:" + getStructfield() + "}";
   }
}
