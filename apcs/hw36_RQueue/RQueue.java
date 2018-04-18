// Aaron Li
// APCS2 pd8
// HW36 -- Now Let's Consider You Lot at Fake Terry's
// 2018-04-17

/*****************************************************
* class RQueue
* A linked-list-based, randomized queue
* (a collection with FIIDKO property)
*
*       -------------------------------
*   end |  --->   Q U E U E   --->    | front
*       -------------------------------
*
*  linkages point opposite direction for O(1) en/dequeuing
*            N <- N <- ... <- N <- N
*      _end -^                     ^- _front
*
******************************************************/

public class RQueue<T> implements Queue<T>
{
     //instance variables
     private LLNode<T> _front, _end;
     private int _size;


     // default constructor creates an empty queue
     public RQueue()
     {
          _size = 0;
          _front = null;
          _end = null;
     }//end default constructor

     // Adds a new node with cargo of input value to the queue
     // @param enQVal: value to be queued
     // O(1)
     public void enqueue( T enQVal )
     {
          if (_size == 0) {
               _front = new LLNode<T>(enQVal, null);
               _end = _front;
               System.out.println(_end.getValue());
          } else {
               // New node points to the current end with value of input
               LLNode<T> temp = new LLNode<T>( enQVal, _end);
               _end = temp;
               System.out.println(_end.getValue());
          } _size++;
     }//end enqueue()


     // remove and return thing at front of queue
     // assume _queue ! empty
     // O(n)
     public T dequeue()
     {
          T retVal = null; // initialize retVal to return
          LLNode<T> temp = _end; // placeholder
          // if size is < 1, then everything is just null
          if (_size < 1) {
               _front = null;
               _end = null;
               return null;
          } else if (_size == 1) { // if size == 1, just return the end value
               retVal = _end.getValue();
               _front = null;
               _size--;
               return retVal;
          } for (int i = 0; i < _size; i++) { // iterate through until you find the front
               if ( temp.getNext() == _front ){
                    // if the next pointer isn't null, retVal is value of _front
                    if (temp.getNext().getValue() != null) {
                         retVal = temp.getNext().getValue();
                    } temp.setNext(temp.getNext().getNext());
                    this.sample(); // set new _front
                    break;
               } else {
                    temp = temp.getNext();
               }

          }
          return retVal;
     }//end dequeue()

     // Peeks at the front of the queue
     // @returns: value of type T of the value at the front of the queue
     public T peekFront()
     {
          return _front.getValue();
     }


     /******************************************
     * void sample() -- a means of "shuffling" the queue
     * Algo:
     *    1) Generate a random integer number between 0 and the size of the queue
     *    2) Iterate to that number starting from the end as the placeholder
     *    3) Set that node to as the new front
     ******************************************/
     // O(n)
     public void sample ()
     {
          _size -= 1;
          // random nth node in the queue
          int rando = (int) (Math.random() * (_size));
          // iterate through the queue, starting from the end, to achieve
          // the randomly selected queue, set it as the new front
          LLNode<T> temp = _end;
          if (rando == 0) rando += 1;
          for (int i = 0; i < _size - rando; i++) {
               if ( i == (_size - rando) - 1) {
                    if (temp.getNext() == null) {
                         _front = null;
                         break;
                    } else {
                         this._front = temp.getNext();
                         break;
                    }
               } else {
                    temp = temp.getNext();
               }
          }
     }//end sample()


     // Checks if queue is empty
     // @returns: a boolean true if queue is empty, else false
     // O(1)
     public boolean isEmpty()
     {
          return _size == 0;
     }


     // print each node, separated by spaces
     // O(n)
     public String toString()
     {
          String retVal = ""; // string to return
          LLNode<T> temp = _end; // indexer

          if (_size < 1) return null; // return just null if size is less than 1

          // iterate through starting at the end
          // because the front isn't gauranteed to be the "front"
          for (int i = 0; i < _size; i++){
               retVal += temp.getValue() + " ";
               temp = temp.getNext();
          }
          return retVal;
     }//end toString()



     //main method for testing
     public static void main( String[] args )
     {

          RQueue<String> PirateQueue = new RQueue<String>();

          System.out.println("\nnow enqueuing...");
          PirateQueue.enqueue("Dread");
          PirateQueue.enqueue("Pirate");
          PirateQueue.enqueue("Robert");
          PirateQueue.enqueue("Blackbeard");
          PirateQueue.enqueue("Peter");
          PirateQueue.enqueue("Stuyvesant");

          System.out.println("\nnow testing toString()...");
          System.out.println( PirateQueue.toString() ); //for testing toString()...

          System.out.println("\nnow dequeuing...");
          System.out.println( PirateQueue.dequeue() );
          System.out.println( PirateQueue.dequeue() );
          System.out.println( PirateQueue.dequeue() );
          System.out.println( PirateQueue.dequeue() );
          System.out.println( PirateQueue.dequeue() );
          System.out.println( PirateQueue.dequeue() );

          System.out.println("\nnow dequeuing fr empty queue...");
          System.out.println( PirateQueue.dequeue() );

     }//end main

}//end class RQueue
