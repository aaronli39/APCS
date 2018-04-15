// Aaron Li
// APCS2 pd8
// HW34 -- The English Do Not Wait In Line
// 2018-04-14

/******************************************************************************
* Class Nodequeue
* Simulates the queue data structure type by use of singly-linked nodes

*************************************************************************/


public class NodeQueue<T> implements Queue<T> { // class Nodequeue
     // INSTANCE VARIABLES
     LLNode<T> _topQueue; // "head" of the queue, or the first element
     LLNode<T> _lastQueue; // "tail" of the queue, or the last element
     int _queueSize; // size of the queue

     // DEFAULT CONSTRUCTOR
     public NodeQueue () {
          _topQueue = new LLNode<T>(null, null);
          _lastQueue = _topQueue;
          _queueSize = 0;
     }

     // @returns: true if queue is empty, false otherwise
     // O(1)
     public boolean isEmpty() {
          return (_queueSize == 0);
     }

     // @returns: value of the element at the top of queue
     // O(1)
     public T peekFront() {
          if (this.isEmpty()) return null;
          return _topQueue.getValue();
     }

     // Adds an element to the queue
     // @param inp: value to queue
     // O(1)
     public void enqueue(T inp) {
          // if queue is empty, simple make new node with head pointing
          // to null and tail pointing to head
          if (this.isEmpty()) {
               _topQueue = new LLNode(inp, null);
               _lastQueue = _topQueue;
          } else {
               // if there is >= one node, simply
               // make a new node, point it to current tail,
               // and set tail to new node
               LLNode<T> temp = new LLNode(inp, _lastQueue);
               _lastQueue = temp;

          } _queueSize++; // increment queue size
     }

     // Removes the head of the queue
     // @returns: value of the head
     // O(n)
     public T dequeue() {
          T ret = _topQueue.getValue(); // value to return
          // if there is only one node left, decrement queue size
          // and return the current node's value
          if (_lastQueue == _topQueue) {
               _queueSize--;
               return ret;
          }
          // if there is more than one node, remove the top queue,
          // decrement size, and return the value removed
          else {
               LLNode<T> temp = _lastQueue;
               while (temp.getNext() != _topQueue) {
                    temp = temp.getNext();
               } _topQueue = temp;
               _queueSize--;
               return ret;
          }
     }

     // main method
     public static void main(String[] args) {
          Queue<String> test = new NodeQueue<String>(); // instantiate new NodeQueue

          // tests
          test.enqueue("First element");
          System.out.println("This is the head: \"" + test.peekFront() + "\""); // "First element"
          System.out.println("Enqueued \"2nd ele\" ");
          test.enqueue("2nd ele");
          System.out.println("Enqueued \"3rd ele\" ");
          test.enqueue("3rd ele");
          System.out.println("After all that enqueuing, This is the head still: \"" + test.peekFront() + "\""); // "First element"
          System.out.println("DeQueued: \"" + test.dequeue() + "\". This is new head: \"" + test.peekFront() + "\""); // "2nd ele"
          System.out.println("DeQueued: \"" + test.dequeue() + "\". This is new head: \"" + test.peekFront() + "\""); // "3rd ele"
          System.out.println("DeQueued: \"" + test.dequeue() + "\". This is new head: " + test.peekFront()); // null
     } // end main method

} // end class Nodequeue
