// Aaron Li
// APCS2 pd8
// HW21c -- Rockin' Through the Night
// 2018-03-19

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
          LLNode desired = first;
          for(int x = 0; x < i; x++) {
               desired = desired.getNext();
          }
          return desired.getCargo();
     }

     // sets cargo of node at index to input cargo
     // returns the cargo at index
     public String set(int i, String inp) {
          LLNode desired = first;
          for (int x = 0; x < i; x++) {
               desired = desired.getNext();
          } desired.setCargo(inp);
          return desired.getCargo();
     }

     // returns size of linked list
     public int size() {
          return size;
     }

     // adds a node with cargo of input String, and returns true
     public boolean add(String inp) {
          if (first == null) {
               first = new LLNode(inp);
          } else {
               LLNode desired = new LLNode(inp);
               .setNext(desired);
          }
          size += 1;
          return true;
     }

     // refers to the toString of LLNode
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
     }
}
