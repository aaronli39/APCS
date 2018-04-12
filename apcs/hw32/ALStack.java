// Aaron Li
// APCS2 pd8
// HW32 -- Leon Leonwood Stack
// 2018-04-11

import java.util.ArrayList;

public class ALStack<T> implements Stack<T> {

     // instance vars
     private ArrayList<T> _stack;
     private int _size;

     // Default constructor
     public ALStack () {
          _size = 0;
          _stack = new ArrayList<T>();
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
               T ret = _stack.get(_stack.size() - 1); // store object to return at end of ArrayList
               return ret;
          } else {
               return null; // null since no more elements
          }
     }

     // Removes the topmost element of the stack
     // decrements _size by 1
     // @returns: the element removed
     // @returns: null if there are no elements to pop
     public T pop() {
          if (! this.isEmpty()) { // checks if stack is empty
               T ret = _stack.remove(_stack.size() - 1); // store object to return at end of ArrayList
               _size--; // decrement _size
               return ret;
          } else {
               return null; // null since there are no elements
          }
     }

     // Adds an element to the ArrayList
     // increments _size by 1
     // @param inp: input object to push
     public void push(T inp) {
          _size++;
          _stack.add(inp); // appends @param inp to the end of the ArrayList
     }
}
