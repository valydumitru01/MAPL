/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import visitor.*;

//	arrayType:type -> size:intConstant  type:type

public class ArrayType extends AbstractType {

	public ArrayType(IntConstant size, Type type) {
		this.size = size;
		this.type = type;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(size, type);
	}

	public ArrayType(Object size, Object type) {
		this.size = (IntConstant) getAST(size);
		this.type = (Type) getAST(type);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(size, type);
	}
	
	public int getMemSize() {
		return Integer.parseInt(size.getValue())*this.getType().getMemSize();
	}
	public IntConstant getSize() {
		return size;
	}
	public void setSize(IntConstant size) {
		this.size = size;
	}

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private IntConstant size;
	private Type type;

	public String toString() {
       return "{size:" + getSize() + ", type:" + getType() + "}";
   }

	@Override
	public String getMAPLName() {
		return "array";
	}

	@Override
	public char getSuffix() {
		// TODO Auto-generated method stub
		return 0;
	}
}
