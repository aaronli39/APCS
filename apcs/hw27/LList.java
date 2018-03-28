// Aaron Li
// APCS2 pd08
// HW27 -- Make Itr Work
// 2018-03-27


/*****************************************************
* class LList
* Implements a linked list of DLLNode<T>s, each containing String data
* new in v2: add-at-index, remove
*****************************************************/
import java.util.*;

public class LList<T> implements List<T> //your List interface must be in same dir
{

     class MyIterator<T> implements Iterator {
          DLLNode<T> _current;
          boolean _canRemove;

          // constructor
          public MyIterator () {
               _current = new DLLNode(null, null, _head);
               _canRemove = false;
          }

          // returns whether or not there is another element
          public boolean hasNext() {
               if (_current.getNext() == null) return false;
               return true;
          }

          // returns next element's cargo
          public T next() {
               if (! (hasNext())) {
                    throw new NoSuchElementException();
               } _current = _current.getNext;
               _canRemove = true;
               return _current.getCargo();
          }

          // removes element of iteration
          public void remove() {
               if (! (_canRemove)) throw new IllegalStateException();
               _current.getPrev.setNext(_current.getNext());
               _current.getNext.setPrev(_current.getPrev());
               _current = new DLLNode(null, null, _current.getNext());
               _canRemove = false;
               super._size--;
          }

     }
     //instance vars
     private DLLNode<T> _head;
     private DLLNode<T> _tail;
     private int _size;

     // constructor -- initializes instance vars
     public LList( )
     {
          _head = null; //at birth, a list has no elements
          _tail = null; //at birth, a list has no elements
          _size = 0;
     }

     public Iterator<T> iterator() {
          return (Iterator<T>) (new MyIterator<T>());
     }

     //--------------v  List interface methods  v--------------

     public boolean add( Object newVal )
     {
          //DLLNode<T> tmp = new DLLNode<T>( newVal, null, _head );

          DLLNode<T> tmp;

          if (_size == 0) {
               tmp = new DLLNode(newVal, null, null);
               _head = tmp;
               _tail = tmp;
          }
          else {
               tmp = new DLLNode(newVal, null, _head);
               _head.setPrev(tmp);
               _head = tmp;
          }

          _size++;
          return true;
     }


     public T get( int index )
     {
          if ( index < 0 || index >= size() )
          throw new IndexOutOfBoundsException();

          T retVal;
          DLLNode<T> tmp = _head; //create alias to head

          //walk to desired DLLNode<T>
          for( int i=0; i < index; i++ )
          tmp = tmp.getNext();

          //check target DLLNode<T>'s cargo hold
          retVal = tmp.getCargo();
          return retVal;
     }


     public T set( int index, T newVal )
     {
          if ( index < 0 || index >= size() )
          throw new IndexOutOfBoundsException();

          T retStr;

          //head and tail cases
          if (index == 0) {
               retStr = _head.getCargo();
               _head.setCargo(newVal);
          }
          else if (index == size() - 1) {
               retStr = _tail.getCargo();
               _tail.setCargo(newVal);
          }
          else { //we gotta walk it
               DLLNode<T> tmp;
               if (index < size()/2) {
                    tmp = _head;
                    for (int i = 0; i < index; i++) {
                         tmp = tmp.getNext();
                    }
                    retStr = tmp.getCargo();
                    tmp.setCargo(newVal);
               }
               else {
                    tmp = _tail;
                    for (int i = size(); i > index + 1; i--) {
                         tmp = tmp.getPrev();
                    }
                    retStr = tmp.getCargo();
                    tmp.setCargo(newVal);
               }
          }

          return retStr;
     }


     //return number of DLLNode<T>s in list
     public int size() { return _size; }


     //insert a DLLNode<T> containing newVal at position index
     public void add( int index, Object newVal ) {

          if ( index < 0 || index >= size() )
          throw new IndexOutOfBoundsException();

          DLLNode<T> tmp;
          DLLNode<T> newNode;

          if (index == 0) {
               add(newVal);
               return;
          }
          else if (index >= _size/2) {
               tmp = _head;
               for (int i = 0; i < index; i++) {
                    tmp = tmp.getNext();
               }
          }
          else {  //index < _size/2
               tmp = _tail;
               for (int i = index; i > 1; i--) {
                    tmp = tmp.getPrev();
               }
          }
          newNode = new DLLNode(newVal, tmp.getPrev(), tmp);
          tmp.getPrev().setNext(newNode);
          tmp.setPrev(newNode);

          _size++;

     }


     //remove DLLNode<T> at pos index, return its cargo
     public T remove( int index ) {

          if ( index < 0 || index >= size() )
          throw new IndexOutOfBoundsException();

          T retStr;

          if (_size == 1) {
               retStr = _head.getCargo();
               _head = null;
               _tail = null;
          }

          else if (index == 0) {
               retStr = _head.getCargo();
               _head = _head.getNext();
               _head.setPrev(null); //kill the pointer
          }
          else if (index == size() - 1) {
               retStr = _tail.getCargo();
               _tail = _tail.getPrev();
               _tail.setNext(null); //kill the pointer
          }
          else { //this means we gotta walk our temp
               DLLNode<T> tmp;
               if (index < size()/2) { //index in first half of LList
                    tmp = _head;
                    for (int i = 0; i < index - 1; i++) {
                         tmp = tmp.getNext();
                    }
                    retStr = tmp.getNext().getCargo(); //save deleted cargo
                    tmp.setNext(tmp.getNext().getNext()); //kill 1 pointer
                    tmp.getNext().setPrev(tmp); //deal with the next's prev (kill other pointer)
               }
               else { //index is in second half of LList
                    tmp = _tail;
                    for (int i = size() - 1; i > index + 1; i--) {
                         tmp = tmp.getPrev();
                    }
                    retStr = tmp.getPrev().getCargo(); //save deleted cargo
                    tmp.setPrev(tmp.getPrev().getPrev()); //kill 1 pointer
                    tmp.getPrev().setNext(tmp); //deal with prev's next (kill other pointer)
               }
          }
          _size--;
          return retStr;
     }

     //--------------^  List interface methods  ^--------------


     // override inherited toString
     public String toString()
     {
          String retStr = "HEAD->";
          DLLNode tmp = _head; //init tr
          while( tmp != null ) {
               retStr += tmp.getCargo() + "->";
               tmp = tmp.getNext();
          }
          retStr += "NULL";
          return retStr;
     }


     //main method for testing
     public static void main( String[] args )
     {

          LList james = new LList();

          System.out.println( james );
          System.out.println( "size: " + james.size() + "\n");

          james.add("beat");
          System.out.println( james );
          System.out.println( "size: " + james.size() + "\n");

          james.add("a");
          System.out.println( james );
          System.out.println( "size: " + james.size() + "\n");

          james.add("need");
          System.out.println( james );
          System.out.println( "size: " + james.size() + "\n");

          james.add("I");
          System.out.println( james );
          System.out.println( "size: " + james.size() + "\n");

          System.out.println( "2nd item is: " + james.get(1) );

          james.add(0,"whut");
          System.out.println( "\n...after add(0,whut): " );
          System.out.println( james );

          james.add(4,"phat");
          System.out.println( "\n...after add(4,phat): " );
          System.out.println( james );

          System.out.println( "\n...after remove last: "
          + james.remove( james._size-1) );
          System.out.println( james );

          System.out.println( "\n...after remove(0): " + james.remove(0) );
          System.out.println( james );

          System.out.println( "\n...after remove(0): " + james.remove(0) );
          System.out.println( james );

          System.out.println( "\n...after remove(0): " + james.remove(0) );
          System.out.println( james );

          System.out.println("\n...after adding 2 useless vals");
          james.add("vals");
          james.add("useless");
          System.out.println(james);

          System.out.println("\n...after setting " + james.set(0, "cool") + " to cool");
          System.out.println(james);

          System.out.println("\n...after setting " + james.set(1, "beans") + " to beans");
          System.out.println(james);

          System.out.println("\n...after setting " + james.set(2, "my") + " to my");
          System.out.println(james);

          System.out.println("\n...after setting " + james.set(3, "man") + " to man");
          System.out.println(james);
     }

}//end class LList
