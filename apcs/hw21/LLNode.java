// Aaron Li
// APCS2 pd8
// HW21c -- Rockin' Through the Night
// 2018-03-19


/*****************************************************
* class LLNode
* Implements a node, for use in lists and other container classes.
* Stores its data as a String
*****************************************************/

public class LLNode
{
     //instance vars
     private String car; // stores cargo
     private LLNode cdr; // next node

     // constructor(s)
     public LLNode(String carg) { // constructor 1: no next node
          car = carg;
     }
     public LLNode(String carg, LLNode next) { // constructor 2: with next node
          this.car = carg;
          this.cdr = next;
     }

     //--------------v  ACCESSORS  v--------------
     // returns the cargo
     public String getCargo()
     {
          return car;
     }

     // returns the next node
     public LLNode getNext()
     {
          return cdr;
     }
     //--------------^  ACCESSORS  ^--------------

     //--------------v  MUTATORS  v--------------
     // set the cargo to input, returns original cargo
     public String setCargo(String inp)
     {
          String orig = car;
          car = inp;
          return orig;
     }

     // sets cdr to input, returns original cdr
     public LLNode setNext(LLNode inp)
     {
          LLNode orig = cdr;
          cdr = inp;
          return orig;
     }

     //--------------^  MUTATORS  ^--------------
     // override inherited toString
     public String toString()
     {
          return car + " -> " + cdr; // use "->" to denote the next node
     }

     //main method for testing
     public static void main( String[] args )
     {
          //PROTIP: try creating a few nodes: traversible, connected...
          //note anything notable as you develop and test...
          LLNode test1 = new LLNode("Testing");
          System.out.println(test1);
          LLNode test2 = new LLNode("testing another link");
          test1.setNext(test2);
          System.out.println(test1);
          LLNode test3 = new LLNode("continuing the link");
          test2.setNext(test3);
          System.out.println(test1);
     }//end main

}//end class LLNode
