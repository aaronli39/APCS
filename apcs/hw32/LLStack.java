// Aaron Li
// APCS2 pd8
// HW32 -- Leon Leonwood Stack
// 2018-04-11

import java.util.LinkedList;

public class LLStack<T> implements Stack<T> {

     // instance vars
     private LinkedList<T> _stack; // the actual stack
     private int _size; // size of stack elements

     // Default constructor
     public LLStack (){
          _size = 0;
          _stack = new LinkedList<T>();
     }

     // Checks if the stack is is empty
     // @returns: true if empty, false if not
     public boolean isEmpty() {
          return _size == 0;
     }

     // Checks the top element of the stack
     // @returns: the top element of the stack
     // @returns: null if the stack is empty
     public T peek() {
          if (! this.isEmpty()) { // checks if stack is empty
               T ret = _stack.getFirst(); // stores the object are the front of the LinkedList
               return ret;
          } else {
               return null; // null if there are no more elements to peek
          }
     }

     // Removes the topmost element of the stack
     // decrements _size by 1
     // @returns: the element removed
     // @returns: null if there are no elements to pop
     public T pop() {
          if (! this.isEmpty()) { // checks if stack is empty
               T ret = _stack.removeFirst(); // store object to return, from the head of the LinkedList
               _size -= 1; // decrement _size by 1
               return ret;
          } else {
               return null; // null if stack is empty and no more elements to pop
          }
     }

     // Adds an element to the LinkedList
     // increments _size by 1
     // @param inp: input object to push
     public void push(T inp) {
          _size += 1; // increment _size by 1
          _stack.addFirst(inp); // append @param inp to front of LinkedList
     }
}
