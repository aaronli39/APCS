// Aaron Li, Jackie Li, Mary Ann
// APCS2 pd8
// HW35 -- 
// 2018-04-16

// import the ArrayList library
import java.util.ArrayList;

public class ALQueue<T> implements Queue<T> { // class ALQueue
     // INSTANCE VARIABLES
     private int _size; // size of ArrayList
     private int _start; // starting index
     ArrayList<T> line; // ArrayList for queue

     // DEFAULT CONSTRUCTOR
     // Sets size and starting index to 0
     // Instantiates new ArrayList
     public ALQueue () {
          _size = 0;
          _start = 0;
          line = new ArrayList<T>();
     }

     // Returns whether or not queue is empty
     // @returns: true if queue is empty, false otherwise
     public boolean isEmpty() {
          return _size == 0;
     }

     // Returns the first element in the queue
     // @returns element
     public T peekFront() {
          if (this.isEmpty()) return null; // if queue is empty return null
          return line.get(_start); // return first element in the queue
     }

     // Adds an element to the queue
     // @param inp: element to enqueue
     public void enqueue(T inp) {
          line.add(inp);
          _size++;
     }

     // Removes the first element from the queue
     // @returns: first element of queue
     public T dequeue() {
          if (this.isEmpty()) return null; // if queue is empty return null
          T ret = this.peekFront(); // store value to return
          _start++;
          _size--;
          return ret;
     }

     // main method
     public static void main(String[] args) {

          // Test 1
          ALQueue<String> test = new ALQueue<String>();
          test.enqueue("Charlie");
          test.enqueue("Brown");
          test.enqueue("Bucket");
          test.enqueue("Chaplin");
          test.enqueue("the fourth");
          test.enqueue("Sheen");

          System.out.println(test.peekFront());
          System.out.println(test.dequeue());
          System.out.println(test.peekFront());
          System.out.println(test.peekFront());
          System.out.println(test.dequeue());
          System.out.println(test.peekFront());
          System.out.println(test.peekFront());
          System.out.println(test.dequeue());
          System.out.println(test.peekFront());

          // Test 2
          ALQueue<String> Michelle = new ALQueue<String>();
          System.out.println("\n\n======= TEST 2 =======\n");
          Michelle.enqueue("Michelle");
          Michelle.enqueue("Sharkeesha");
          Michelle.enqueue("Kell");
          Michelle.enqueue("Crystal");
          Michelle.enqueue("Hailee");
          Michelle.enqueue("Coolbeans");

          System.out.println(Michelle.peekFront()); // Michelle
          System.out.println(Michelle.dequeue()); // Michelle
          System.out.println(Michelle.peekFront()); // Sharkeesha
          System.out.println(Michelle.dequeue()); // Sharkeesha
          System.out.println(Michelle.peekFront()); // Kell
          System.out.println(Michelle.dequeue()); // Kell
          System.out.println(Michelle.peekFront()); // Crystal
          System.out.println(Michelle.dequeue()); // Crystal
     } // end main
} // end class ALQueue
