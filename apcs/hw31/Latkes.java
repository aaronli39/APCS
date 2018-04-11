// Aaron Li
// APCS2 pd8
// HW30 -- Stacks on Stacks on Stacks on Stacks...
// 2018-04-09

/*****************************************************
* skeleton for class Latkes
* Implements a stack of Strings using an encapsulated array
*****************************************************/

public class Latkes
{
     private String [] _stack; // array of data
     private int _stackSize; // length of _stack - 1


     //constructor
     public Latkes( int size )
     {
          _stackSize = -1; // _stackSize = -1 so that I can use _stackSize as indicies
          _stack = new String[size]; // allow _stack to hold @param size amount of elements
     }

     //means of insertion
     public void push( String s )
     {
          // if _stack has at least one empty slot, then append input
          if (this.isEmpty()) {
               _stackSize += 1;
               _stack[_stackSize] = s;
          } else { // if _stack is full, make and replace _stack with a larger array, then append input
               String[] newOne = new String[_stack.length + 1];
               for (int i = 0; i < _stack.length; i++) newOne[i] = _stack[i];
               _stack = newOne;
               _stackSize += 1;
               _stack[_stackSize] = s;
          }
     }

     //means of removal
     public String pop()
     {
          // String to return
          String removed;
          // if there is at least one element left, simply decrement _stackSize and return element at last index
          if (_stackSize >= 0) {
               removed = _stack[_stackSize];
               _stackSize -= 1;
               return removed;
          } else {
               return null; // if _stack is already empty, return null
          }
     }

     //chk for emptiness
     public boolean isEmpty()
     {
          return (_stackSize < _stack.length - 1); // if _stackSize is < _stack, then there is space
     }

     // checks for complete emptiness
     public boolean isComp() {
          return (_stackSize == -1);
     }
     //chk for fullness
     public boolean isFull()
     {
          return (_stackSize == _stack.length - 1); // if _stackSize == _stack length, then it is full
     }


     //main method for testing
     public static void main( String[] args )
     {
          Latkes tastyStack = new Latkes(10);

          tastyStack.push("aoo");
          tastyStack.push("boo");
          tastyStack.push("coo");
          tastyStack.push("doo");
          tastyStack.push("eoo");
          tastyStack.push("foo");
          tastyStack.push("goo");
          tastyStack.push("hoo");
          tastyStack.push("ioo");
          tastyStack.push("joo");
          tastyStack.push("coocoo");
          tastyStack.push("cachoo");

          //cachoo
          System.out.println( tastyStack.pop() );
          //coocoo
          System.out.println( tastyStack.pop() );
          //joo
          System.out.println( tastyStack.pop() );
          //ioo
          System.out.println( tastyStack.pop() );
          //hoo
          System.out.println( tastyStack.pop() );
          //goo
          System.out.println( tastyStack.pop() );
          //foo
          System.out.println( tastyStack.pop() );
          //eoo
          System.out.println( tastyStack.pop() );
          //doo
          System.out.println( tastyStack.pop() );
          //coo
          System.out.println( tastyStack.pop() );
          //boo
          System.out.println( tastyStack.pop() );
          //aoo
          System.out.println( tastyStack.pop() );

          //stack empty by now; SOP(null)
          System.out.println( tastyStack.pop() );

     }//end main()

}//end class Latkes
