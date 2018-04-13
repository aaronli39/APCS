// Aaron Li
// APCS2 pd8
// HW33 -- What a Racket
// 2018-04-12

/*****************************************************
* class Scheme
* Simulates a rudimentary Scheme interpreter
*
* ALGORITHM for EVALUATING A SCHEME EXPRESSION:
*   1. Flip the String expression while maintaining integer values and whitespaces
*   2. Split the reversed SCHEME expression by whitespaces
*   3. Change the operands to their appropriate integer markers
    4. Instantiate a new LLStack
    5. Iterating through the elements in the reversed String array:
          A. if current element IS NOT an opening parens, push it to stack
          B. if current element IS an opening parens:
               a. store and pop the operand to be performed
               b. feed the current stack and operation to unload(). Store the result
               c. now, keep popping the stack until you have popped a closing parens
               d. move on to the next element in the reversed String array, repeat 5A and 5B
     6. Wallah!!!
*
* STACK OF CHOICE: LLStack by APCS2 Library
* b/c:
     LLStack is simpler to implement since LinkedLists simply need to change cdrs in order
     to change their order, which makes popping easier to visualize and logical.
******************************************************/

public class Scheme
{
     /******************************************************
     * precond:  Assumes expr is a valid Scheme (prefix) expression,
     *           with whitespace separating all operators, parens, and
     *           integer operands.
     * postcond: Returns the simplified value of the expression, as a String
     * eg,
     *           evaluate( "( + 4 3 )" ) -> 7
     *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
     ******************************************************/
     public static String evaluate( String expr ) {
          expr = flip(expr); // flip the string, maintaining white spaces
          // string array to hold split elements
          String[] arr = expr.split("\\s");

          // convert operands to appropriate numbers, knowing
          // that operands are always the element prior to the opening parens
          for (int i = 0; i < arr.length; i++) {
               if (arr[i].equals("+")) arr[i] = "1";
               else if (arr[i].equals("-")) arr[i] = "2";
               else if (arr[i].equals("*")) arr[i] = "3";
          }

          // instantiate new stack, which serves as the stack used to
          // serve into unload()
          LLStack<String> test = new LLStack<String>();
          // iterate through the length of the array: by the end of this
          // the whole Scheme expression should have been fed and evaluated
          for (int i = 0; i < arr.length; i++) {
               // add elements from split string array to the stack as long as
               // it's not an opening parens
               if (! arr[i].equals("(")) test.push(arr[i]);
               else if (arr[i].equals("(")) { // if it is an opening parens

                    // stores the int corresponding to the operation to be performed,
                    // then pop the operation placeholder
                    int op = Integer.parseInt(test.pop());
                    // feed and store the result of the operations on a parens
                    String res = unload(op, test);

                    // remove the enclosed parens that was just unloaded
                    // while loop pops elements until right before the closing parens
                    while (! test.peek().equals(")")) {
                         test.pop();
                    } test.pop(); // pop the closing parens

                    test.push(res); // push the result of the operations of the enclosed parens
               }
          } return test.pop(); // return



     }//end evaluate()


     /******************************************************
     * precond:  Assumes top of input stack is a number.
     * postcond: Performs op on nums until closing paren is seen thru peek().
     *           Returns the result of operating on sequence of operands.
     *           Ops: + is 1, - is 2, * is 3
     ******************************************************/
     public static String unload( int op, LLStack<String> numbers )
     {
          int result = 0; // int result to store the result of operations

          // if operation is addition, just add the sums
          if (op == 1) {
               result = 0;
               while (! numbers.peek().equals(")")) { // keep operating till closing parens
                    result += Integer.parseInt(numbers.pop());
               }
          }
          // if operation is subtraction, just store the difference
          else if (op == 2) {
               result = Integer.parseInt(numbers.pop());
               while (! numbers.peek().equals(")")) { // keep operating till closing parens
                    result -= Integer.parseInt(numbers.pop());
               }
          }
          // if operation is multiplication, just store the products
          else if (op == 3) {
               result = 1;
               while (! numbers.peek().equals(")")) { // keep operating till closing parens
                    result *= Integer.parseInt(numbers.pop());
               }
          }

          return Integer.toString(result); // return
     }//end unload()

     /**********************************************************
     * precondition:  input string has length > 0
     * postcondition: returns reversed string s
     *                flip("desserts") -> "stressed"
     **********************************************************/
     public static String flip( String s )
     {
          String ret = ""; // return string

          // split by whitespace so that even two digit integers are preserved
          String[] storage = s.split("\\s");
          // instantiate new stack to push() and pop()
          LLStack<String> temp = new LLStack<String>();

          // push each element in the split string array into the stack, making
          // sure to revert the one whitespace separation
          for (int i = 0; i < storage.length; i++) {
               temp.push(storage[i] + " ");
          }
          // pop the items from the stack and add them to
          // return string so that the order is reversed
          for (int i = 0; i < storage.length; i++) ret += temp.pop();

          return ret; // return
     }//end flip()

     /*
     //optional check-to-see-if-its-a-number helper fxn:
     public static boolean isNumber( String s ) {
     try {
     Integer.parseInt(s);
     return true;
}
catch( NumberFormatException e ) {
return false;
}
}
*/


//main method for testing
public static void main( String[] args )
{

     String zoo1 = "( + 4 3 )";
     System.out.println(zoo1);
     System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
     //...7

     String zoo2 = "( + 4 ( * 2 5 ) 3 )";
     System.out.println(zoo2);
     System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
     //...17

     String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
     System.out.println(zoo3);
     System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
     //...29

     String zoo4 = "( - 1 2 3 )";
     System.out.println(zoo4);
     System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
     //...-4

}//main

}//end class Scheme
