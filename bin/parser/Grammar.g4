grammar Grammar;
import Lexicon;

@parser::header{
	import ast.*;
}

start returns[Program ast]
	:lg+=global*
	{$ast=new Program($lg);}
;

global returns[Global ast]
	:'struct' name=IDENT '{' lsd+=structField* '}'';'
	{$ast = new Struct($name,$lsd);}
	
	|varDef 
	{$ast =$varDef.ast;}

	|func
	{$ast =$func.ast;}
;

func returns[Global ast]
	:name=IDENT	'(' lp=defineFuncParams ')' ':' type '{' lvd+=varDef* ls+=statement* '}'	
	{$ast=new Func($name,$lp.ast,$type.ast,$lvd, $ls);}
	
	|name=IDENT	'(' lp=defineFuncParams ')'  '{' lvd+=varDef* ls+=statement* '}'	
	{$ast=new Func($name,$lp.ast,null,$lvd, $ls);}
;



defineFuncParams returns[List<VarDef> ast=new ArrayList<>()]
	:defineFuncParamsList 
	{$ast=$defineFuncParamsList.ast;}
	| /* Sin elementos  */
;

defineFuncParamsList returns[List<VarDef> ast = new ArrayList<>()]
	: IDENT ':' type ',' defineFuncParamsList
	{$ast.add(new VarDef($IDENT,$type.ast));
	$ast.addAll($defineFuncParamsList.ast);}
	
	
	| IDENT ':' type
	{$ast.add(new VarDef($IDENT,$type.ast));}
; 


passFuncParams returns[List<Expression> ast=new ArrayList<>()]
	:passFuncParamsList 
	{$ast=$passFuncParamsList.ast;}
	| /* Sin elementos  */
;

passFuncParamsList returns[List<Expression> ast = new ArrayList<>()]
	: expression ',' passFuncParams
	{$ast.add($expression.ast);
	$ast.addAll($passFuncParams.ast);}
	 
	| expression
	{$ast.add($expression.ast);}
; 
structField returns[StructField ast]
	:name=IDENT ':' type ';' 
	{$ast = new StructField($name,$type.ast);}
;


varDef returns[VarDef ast]
	:'var' name=IDENT ':'  type 	';'
	{$ast = new VarDef($name,$type.ast);}
;



statement returns[Statement ast]
	:assigned=expression '=' value=expression';'	
	{$ast=new Assignment($assigned.ast,$value.ast);}
	
	|'return' returned=expression';'
	{$ast=new Return($returned.ast);}
	
	|'return'';'
	{$ast=new Return(null);}
	
	|print=('print'|'println'|'printsp') printed=expression';'
	{$ast=new Print($print,$printed.ast);}	
	
	|print=('print'|'println'|'printsp')';'
	{$ast=new Print($print,null);}	
							
	|IDENT '(' parameters=passFuncParams ')'';' 
	{$ast=new FuncCall($IDENT,$parameters.ast);}

	|'read' into=expression';' 
	{$ast=new Read($into.ast);}
	
	|'if''('condition=expression')''{'ifBody+=statement*'}' ('else''{'elseBody+=statement*'}')?
	{$ast=new If($condition.ast,$ifBody,$elseBody);}
	
	|'while' '('condition=expression')' '{' body+=statement* '}'	
	{$ast=new While($condition.ast,$body);}
;

expression returns[Expression ast]
	:'('inside=expression ')'	
	{$ast=$inside.ast;}
	
	|array=expression '[' index=expression ']' 
	{$ast=new ExpressionArrayAccess($array.ast,$index.ast);}

	|e=expression '.' IDENT
	{$ast=new ExpressionPointAccess($e.ast,$IDENT);}
	
	|IDENT '(' parameters=passFuncParams ')'
	{$ast=new ExpressionFuncAccess($IDENT,$parameters.ast);}

	|'!' bool=expression
	{$ast=new Negate($bool.ast);}
	
	|'<' to=type '>' from=expression
	{$ast=new Parse($to.ast,$from.ast);}
	
	|left=expression op=('*'|'/'|'%') right=expression
	{$ast=new ArithmeticExpression($left.ast,$op,$right.ast);}
	 										
	|left=expression op=('+'|'-') right=expression
	{$ast=new ArithmeticExpression($left.ast,$op,$right.ast);}
										
	|left=expression op=('=='|'<='|'>='|'<'|'>'|'!=') right=expression
	{$ast=new BooleanExpression($left.ast,$op,$right.ast);}
						
	|left=expression op='&&' right=expression
	{$ast=new BooleanOfBooleansExpr($left.ast,$op,$right.ast);}
	
	|left=expression op='||' right=expression
	{$ast=new BooleanOfBooleansExpr($left.ast,$op,$right.ast);}
	
	|name=IDENT
	{$ast=new Variable($name);}
	
	|value=FLOAT
	{$ast=new FloatConstant($value);}
	
	|value=CHAR
	{$ast=new CharConstant($value);}
	
	|value=INT
	{$ast=new IntConstant($value);}
;


type returns[Type ast]
	:'int'
	{$ast= new IntType();}
	
	|'float'
	{$ast= new FloatType();}
	
	|'char'
	{$ast= new CharType();}
	
	|name=IDENT
	{$ast= new StructType($name);}
	
	|'[' size=INT ']' type
	{$ast= new ArrayType(new IntConstant($size),$type.ast);}
;



