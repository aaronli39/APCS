/*****************************************************
* class T
* Implements a doubly-linked node,
* for use in lists and other collection classes.
* Stores data of type String
*****************************************************/

public class DLLNode<T>
{
     private Object _cargo;    //cargo may only be of type String
     private T _nextNode, _prevNode; //pointers to next, prev Ts

     public DLLNode(Object carg, T prev, T next) {
          this._cargo = carg;
          this._nextNode = next;
          this._prevNode = prev;
     }

     //--------------v  ACCESSORS  v--------------

     public T getCargo() {
          return _cargo;
     }

     public T getNext() {
          return _nextNode;
     }

     public T getPrev() {
          return _prevNode;
     }

     //--------------^  ACCESSORS  ^--------------

     //--------------v  MUTATORS  v--------------
     public T setCargo(Object inp) {
          String orig = _cargo;
          _cargo = inp;
          return orig;
     }

     public T setNext(T inp) {
          T orig = _nextNode;
          this._nextNode = inp;
          return orig;
     }

     public T setPrev(T inp) {
          T orig = _prevNode;
          _prevNode = inp;
          return orig;
     }
     //--------------^  MUTATORS  ^--------------

     public String toString() {
          return _cargo + " <-> " + _nextNode;
     }

     public static void main(String[] args) {
          //PROTIP: try creating a few nodes: traversible, connected...
          //note anything notable as you develop and test...
          DLLNode test1 = new DLLNode("Testing", null, null);
          System.out.println(test1);
          DLLNode test2 = new DLLNode("testing another link", test1, null);
          test1.setNext(test2);
          test2.setPrev(test1);
          System.out.println(test1);
          DLLNode test3 = new DLLNode("continuing the link", test2, null);
          test2.setNext(test3);
          test3.setPrev(test2);
          System.out.println(test1);
     }
}//end class T
