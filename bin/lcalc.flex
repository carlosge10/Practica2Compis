
   
import java_cup.runtime.*;
      
%%
%class Lexer

%line
%column
%cup
   

%{   
    
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    
    private Symbol symbol(int type, Object value) {	  
    	if (type == sym.ID)
    		Variables.initializeVariable((String)value);
    	return new Symbol(type, yyline, yycolumn, value);
    }
    
%}
   
LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]

dec_int_lit = 0 | [0-9][0-9]*[.0-9]*
dec_int_id = [A-Za-z_][A-Za-z_0-9]*

PI = PI
NORM = norm
MAG = magnitude
DOT = dot
LN = ln
SIN = sin
COS = cos
TAN = tan
SQRT = sqrt

%%  
   /* YYINITIAL is the state */
   
<YYINITIAL> {
   
    ";"                { return symbol(sym.SEMI); }
    "+"                { System.out.print(" + "); return symbol(sym.PLUS); }
    "-"                { System.out.print(" - "); return symbol(sym.MINUS); }
    "*"                { System.out.print(" * "); return symbol(sym.TIMES); }
    "/"                { System.out.print(" / "); return symbol(sym.DIVIDE); }
    "("                { System.out.print(" ( "); return symbol(sym.LPAREN); }
    ")"                { System.out.print(" ) "); return symbol(sym.RPAREN); }
    "="                { System.out.print(" = "); return symbol(sym.EQ); }
    "^"                { System.out.print(" ^ "); return symbol(sym.POW); }
    ">"                { System.out.print(" > "); return symbol(sym.RV); }
    "<"                { System.out.print(" < "); return symbol(sym.LV); }
    ","                { System.out.print(" , "); return symbol(sym.COMA); }
    "Double"           { System.out.print(" Double "); return symbol(sym.DOUBLE); }
    "Vec2D"            { System.out.print(" Vec2D "); return symbol(sym.VEC); }
   
	{PI}			  { System.out.print(yytext());
                         return symbol(sym.PI, Math.PI); }
	{NORM}		  { System.out.print(yytext());
                         return symbol(sym.NORM); }
	{MAG}		  { System.out.print(yytext());
                         return symbol(sym.MAG); }
	{DOT}		  { System.out.print(yytext());
                         return symbol(sym.DOT); }
	{LN}		  { System.out.print(yytext());
                         return symbol(sym.LN); }
	{SIN}		  { System.out.print(yytext());
                         return symbol(sym.SIN); }
	{COS}		  { System.out.print(yytext());
                         return symbol(sym.COS); }
	{TAN}		  { System.out.print(yytext());
                         return symbol(sym.TAN); }
	{SQRT}		  { System.out.print(yytext());
                         return symbol(sym.SQRT); }

    {dec_int_lit}      { System.out.print(yytext());
                         return symbol(sym.NUMBER, new Double(yytext())); }
    {dec_int_id}       { System.out.print(yytext());
                         return symbol(sym.ID, yytext());}
   
    {WhiteSpace}       { /* do nothing */ }   
}

[^]                    { throw new Error("Illegal character <"+yytext()+">"); }

