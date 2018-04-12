/*****************************************************
* class Stckr
* driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
*****************************************************/

public class Stckr
{
     public static void main( String[] args )
     {
          // Stack<String> cakes = new ALStack<String>();
          Stack<String> cakes = new LLStack<String>();

          // add a bunch of elements to the stack for testing
          cakes.push("foofoo");
          cakes.push("booboo");
          cakes.push("yooyoo");
          cakes.push("zooooo");
          cakes.push("bananas");
          cakes.push("hellllo");
          cakes.push("poooopooo");
          cakes.push("apcsiscool");
          cakes.push("testtt");

          System.out.println(cakes.pop()); // testtt
          System.out.println(cakes.pop()); // apcsiscool
          System.out.println(cakes.pop()); // poooopooo
          System.out.println(cakes.pop()); // hellllo
          System.out.println(cakes.pop()); // bananas
          System.out.println(cakes.pop()); // zooooo
          System.out.println(cakes.pop()); // yooyoo
          System.out.println(cakes.pop()); // booboo
          System.out.println(cakes.pop()); // foofoo
          // stack should be empty by now
          System.out.println(cakes.pop()); // null

     }//end main

}//end class
