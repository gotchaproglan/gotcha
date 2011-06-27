// $ANTLR 3.1.1 Expr.g 2011-06-26 01:57:35

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ExprParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NEWLINE", "ID", "INT", "WS", "'='", "'+'", "'-'", "'*'", "'('", "')'"
    };
    public static final int WS=7;
    public static final int NEWLINE=4;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__13=13;
    public static final int T__10=10;
    public static final int INT=6;
    public static final int ID=5;
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__8=8;

    // delegates
    // delegators


        public ExprParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ExprParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return ExprParser.tokenNames; }
    public String getGrammarFileName() { return "Expr.g"; }



    // $ANTLR start "prog"
    // Expr.g:3:1: prog : ( stat )+ ;
    public final void prog() throws RecognitionException {
        try {
            // Expr.g:3:6: ( ( stat )+ )
            // Expr.g:3:8: ( stat )+
            {
            // Expr.g:3:8: ( stat )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=NEWLINE && LA1_0<=INT)||LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Expr.g:3:8: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_prog10);
            	    stat();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "prog"


    // $ANTLR start "stat"
    // Expr.g:5:1: stat : ( expr NEWLINE | ID '=' expr NEWLINE | NEWLINE );
    public final void stat() throws RecognitionException {
        try {
            // Expr.g:5:6: ( expr NEWLINE | ID '=' expr NEWLINE | NEWLINE )
            int alt2=3;
            switch ( input.LA(1) ) {
            case INT:
            case 12:
                {
                alt2=1;
                }
                break;
            case ID:
                {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==8) ) {
                    alt2=2;
                }
                else if ( (LA2_2==NEWLINE||(LA2_2>=9 && LA2_2<=11)) ) {
                    alt2=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;
                }
                }
                break;
            case NEWLINE:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // Expr.g:5:8: expr NEWLINE
                    {
                    pushFollow(FOLLOW_expr_in_stat19);
                    expr();

                    state._fsp--;

                    match(input,NEWLINE,FOLLOW_NEWLINE_in_stat21); 

                    }
                    break;
                case 2 :
                    // Expr.g:6:4: ID '=' expr NEWLINE
                    {
                    match(input,ID,FOLLOW_ID_in_stat26); 
                    match(input,8,FOLLOW_8_in_stat28); 
                    pushFollow(FOLLOW_expr_in_stat30);
                    expr();

                    state._fsp--;

                    match(input,NEWLINE,FOLLOW_NEWLINE_in_stat32); 

                    }
                    break;
                case 3 :
                    // Expr.g:7:5: NEWLINE
                    {
                    match(input,NEWLINE,FOLLOW_NEWLINE_in_stat38); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "stat"


    // $ANTLR start "expr"
    // Expr.g:10:1: expr : multExpr ( ( '+' | '-' ) multExpr )* ;
    public final void expr() throws RecognitionException {
        try {
            // Expr.g:10:6: ( multExpr ( ( '+' | '-' ) multExpr )* )
            // Expr.g:10:8: multExpr ( ( '+' | '-' ) multExpr )*
            {
            pushFollow(FOLLOW_multExpr_in_expr48);
            multExpr();

            state._fsp--;

            // Expr.g:10:17: ( ( '+' | '-' ) multExpr )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=9 && LA3_0<=10)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Expr.g:10:18: ( '+' | '-' ) multExpr
            	    {
            	    if ( (input.LA(1)>=9 && input.LA(1)<=10) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_multExpr_in_expr57);
            	    multExpr();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "expr"


    // $ANTLR start "multExpr"
    // Expr.g:13:1: multExpr : atom ( '*' atom )* ;
    public final void multExpr() throws RecognitionException {
        try {
            // Expr.g:13:10: ( atom ( '*' atom )* )
            // Expr.g:13:12: atom ( '*' atom )*
            {
            pushFollow(FOLLOW_atom_in_multExpr69);
            atom();

            state._fsp--;

            // Expr.g:13:17: ( '*' atom )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==11) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Expr.g:13:18: '*' atom
            	    {
            	    match(input,11,FOLLOW_11_in_multExpr72); 
            	    pushFollow(FOLLOW_atom_in_multExpr74);
            	    atom();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "multExpr"


    // $ANTLR start "atom"
    // Expr.g:16:1: atom : ( INT | ID | '(' expr ')' );
    public final void atom() throws RecognitionException {
        try {
            // Expr.g:16:6: ( INT | ID | '(' expr ')' )
            int alt5=3;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt5=1;
                }
                break;
            case ID:
                {
                alt5=2;
                }
                break;
            case 12:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // Expr.g:16:8: INT
                    {
                    match(input,INT,FOLLOW_INT_in_atom86); 

                    }
                    break;
                case 2 :
                    // Expr.g:17:4: ID
                    {
                    match(input,ID,FOLLOW_ID_in_atom91); 

                    }
                    break;
                case 3 :
                    // Expr.g:18:4: '(' expr ')'
                    {
                    match(input,12,FOLLOW_12_in_atom96); 
                    pushFollow(FOLLOW_expr_in_atom98);
                    expr();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_atom100); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "atom"

    // Delegated rules


 

    public static final BitSet FOLLOW_stat_in_prog10 = new BitSet(new long[]{0x0000000000001072L});
    public static final BitSet FOLLOW_expr_in_stat19 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_NEWLINE_in_stat21 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_stat26 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_stat28 = new BitSet(new long[]{0x0000000000001060L});
    public static final BitSet FOLLOW_expr_in_stat30 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_NEWLINE_in_stat32 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWLINE_in_stat38 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multExpr_in_expr48 = new BitSet(new long[]{0x0000000000000602L});
    public static final BitSet FOLLOW_set_in_expr51 = new BitSet(new long[]{0x0000000000001060L});
    public static final BitSet FOLLOW_multExpr_in_expr57 = new BitSet(new long[]{0x0000000000000602L});
    public static final BitSet FOLLOW_atom_in_multExpr69 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_11_in_multExpr72 = new BitSet(new long[]{0x0000000000001060L});
    public static final BitSet FOLLOW_atom_in_multExpr74 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_INT_in_atom86 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_atom96 = new BitSet(new long[]{0x0000000000001060L});
    public static final BitSet FOLLOW_expr_in_atom98 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_atom100 = new BitSet(new long[]{0x0000000000000002L});

}