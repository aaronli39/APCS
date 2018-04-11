// Aaron Li
// APCS2 pd8
// HW31 -- Stack: What is it Good For?
// 2018-04-10

/*****************************************************
* skeleton for class LatKtS
* Driver class for Latkes.
* Uses a stack to reverse a text string, check for sets of matching parens.
*****************************************************/


public class LatKtS
{

     /**********************************************************
     * precondition:  input string has length > 0
     * postcondition: returns reversed string s
     *                flip("desserts") -> "stressed"
     **********************************************************/
     public static String flip( String s )
     {
          String ret = ""; // String value to return

          Latkes temp = new Latkes(s.length()); // instantiate a stack
          // add all characters to the stack
          for (int i = 0; i < s.length(); i++) temp.push(s.substring(i, i + 1));
          // pop the whole stack so that the reverse string order is returned
          for (int i = 0; i < s.length(); i++) ret += temp.pop();

          return ret;
     }//end flip()


     /**********************************************************
     * precondition:  s contains only the characters {,},(,),[,]
     * postcondition: allMatched( "({}[()])" )    -> true
     *                allMatched( "([)]" )        -> false
     *                allMatched( "" )            -> true
     **********************************************************/
     public static boolean allMatched( String s )
     {
          boolean ret = false; // boolean value to return

          String open = "({["; // these are opening parens
          String closed = ")}]"; // these are closing parens
          Latkes temp = new Latkes(s.length()); // instantiate a stack

          // iterate through String s
          for (int i = 0; i < s.length(); i++) {
               // if first character in string is a closing parens, return false
               if (temp.isComp() && open.indexOf(s.substring(i, i + 1)) < 0) return false;
               // if last character in the string is an opening parens, return false
               if (i == s.length() - 1 && open.indexOf(s.substring(i, i + 1)) >= 0) return false;

               // otherwise: if current character is an opening parens, push it to stack
               if (open.indexOf(s.substring(i, i + 1)) >= 0) {
                    temp.push(s.substring(i, i + 1));
               }
               // else: if current character is a closing parens, check if it is the appropriate
               // closing parens by popping the last seen open parens
               else {
                    int ind = open.indexOf(temp.pop());
                    if (closed.substring(ind, ind + 1).equals(s.substring(i, i + 1))) ret = true;
                    else { // at this point the current character does not close any previous parens
                         return false;
                    }
               }
          }

          return ret; // if code reaches here it should be all matching parens
     }//end allMatched()


     //main method to test
     public static void main( String[] args )
     {
          System.out.println(flip("stressed"));
          System.out.println(allMatched( "({}[()])" )); //true
          System.out.println(allMatched( "([)]" ) ); //false
          System.out.println(allMatched( "(){([])}" ) ); //true
          System.out.println(allMatched( "](){([])}" ) ); //false
          System.out.println(allMatched( "(){([])}(" ) ); //false
          System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
          System.out.println(allMatched( "()]" ) ); //false
          System.out.println(allMatched( "()[" ) ); //false
          System.out.println(allMatched( "()[]" ) ); //true
     }

}//end class LatKtS
