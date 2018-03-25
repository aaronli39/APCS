// Team Wampanoag -- Aaron Li, Collin Hosking
// APCS2 pd8
// HW23 -- Give and Take
// 2018-03-22

public class LList implements List {

     // instance vars
     private LLNode first;
     private int size;

     // default constructor
     // first node is set to null, and size is 0
     public LList() {
          first = null;
          size = 0;
     }

     // takes index input, returns the cargo of the node at that index
     public String get(int i) {
          if ( i < 0 || i >= size() ) {
               throw new IndexOutOfBoundsException();
          }

          LLNode desired = first;
          for(int x = 0; x < i; x++) {
               desired = desired.getNext();
          }
          return desired.getCargo();
     }

     // sets cargo of node at index to input cargo
     // returns the cargo at index
     public String set(int i, String inp) {
          if ( i < 0 || i >= size() ) {
               throw new IndexOutOfBoundsException();
          }

          LLNode desired = first;
          for (int x = 0; x < i; x++) {
               desired = desired.getNext();
          } String orig = desired.getCargo();

          desired.setCargo(inp);
          return orig;
     }

     // returns size of linked list
     public int size() {
          return size;
     }

     // adds a node with cargo of input String, and returns true
     public boolean add(String inp) {
          LLNode temp = new LLNode(inp, first);
          first = temp;
          size++;
          return true;
     }

     // adds a node with cargo of input String at specified index
     public boolean add(int i, String inp) {
          if (i < 0 || i > size()) throw new IndexOutOfBoundsException();
          LLNode temp = first; // alias
          // new LLNode with cargo of input string, pointer to null
          LLNode newOne = new LLNode(inp, null);
          // if the specified index is 0, then we just need to invoke the
          // regular add method
          if (i == 0) {
               add(inp);
               return true;
          }
          // walk up to the node preceding the specified node, point the new node
          // to the node after the specified index, and then set the preceding to
          // point to the new node
          for (int x = 0; x < i - 1; x++) {
               temp = temp.getNext();
          } newOne.setNext(temp.getNext());
          temp.setNext(newOne);
          size++; // don't forget to increment size!
          return true;
     }

     // removes a LLNode at the specified index
     public String remove(int x) {
          if (x < 0 || x > size()) throw new IndexOutOfBoundsException();
          LLNode temp = first; // alias
          String out = ""; // output String
          // if the specified index is 0, then we just need set first node to
          // the one after it
          if (x == 0) {
               out = first.getCargo();
               first = first.getNext();
               size--;
               return out;
          }
          // walk up to the node preceding the specified index, set its pointer to
          // the node after the specified index
          for (int i = 0; i < x - 1; i++) {
               temp = temp.getNext();
          } out = temp.getNext().getCargo();
          temp.setNext(temp.getNext().getNext());
          size--; // don't forget to decrement size!
          return out;
     }

     // overwrite default toString method
     public String toString() {
          return first.toString();
     }

     // main method
     public static void main(String[] args) {
          // create new test
          LList test = new LList();

          // add the first node
          test.add("Thing 1");
          System.out.println(test);

          // add the second node
          test.add("Thing 2");
          System.out.println(test);

          // we don't like the second node, so change its cargo to something else
          test.set(1, "Thang Dos");
          System.out.println(test);

          // anotha one
          test.add("Thing 3");
          System.out.println(test);

          // and anotha
          test.add("thang 5");
          System.out.println(test);

          // tests functionality of get, which returns cargo of second node
          System.out.println(test.get(1));

          // tests functionality of add at indice
          System.out.println(test.add(2, "inserted at index 2"));
          System.out.println(test);
          // tests functionality of add at index
          System.out.println(test.add(4, "inserted at index 4"));
          System.out.println(test);

          // tests functionality of remove
          System.out.println(test.remove(4));
          System.out.println(test);
          System.out.println("------> removed node at index 4 <-------");
     }
}
