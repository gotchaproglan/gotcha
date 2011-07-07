grammar Expr;

// START:members
@header {
import java.util.HashMap;
}

@members {
/** Map variable name to Integer object holding value */
HashMap memory = new HashMap();
}
// END:members

// START:stat
prog:   stat+ ;
                
stat:   // evaluate expr and emit result
        // $expr.value is return attribute 'value' from expr call
        expr NEWLINE {System.out.println($expr.value);}

        // match assignment and stored value
        // $ID.text is text property of token matched for ID reference
    |   ID '=' expr NEWLINE
        {memory.put($ID.text, new Integer($expr.value));}

        // do nothing: empty statement
    |   NEWLINE
    ;
// END:stat

// START:expr
/** return value of multExpr or, if '+'|'-' present, return
 *  the addition or subtraction of results from both multExpr references.
 */
expr returns [int value]
    :   e=multExpr {$value = $e.value;}
        (   '+' e=multExpr {$value += $e.value;}
        |   '-' e=multExpr {$value -= $e.value;}
        )*
    ;
// END:expr

// START:multExpr
/** return the value of an atom or, if '*' present, return
 *  multiplication of results from both atom references.
 *  $value is the return value of this method, $e.value
 *  is the return value of the rule labeled with e.
 */
multExpr returns [int value]
    :   e=atom {$value = $e.value;} ('*' e=atom {$value *= $e.value;})*
    ; 
// END:multExpr

// START:atom
atom returns [int value]
    :   // value of an INT is the int computed from char sequence
        INT {$value = Integer.parseInt($INT.text);}

    |   ID // variable reference
        {
        // look up value of variable
        Integer v = (Integer)memory.get($ID.text);
        // if found, set return value else error
        if ( v!=null ) $value = v.intValue();
        else System.err.println("undefined variable "+$ID.text);
        }

        // value of parenthesized expression is just the expr value
    |   '(' expr ')' {$value = $expr.value;}
    ;
// END:atom

// START:tokens
ID  :   ('a'..'z'|'A'..'Z')+ ;
INT :   '0'..'9'+ ;
NEWLINE:'\r'? '\n' ;
WS  :   (' '|'\t'|'\n'|'\r')+ {skip();} ;
// END:tokens
