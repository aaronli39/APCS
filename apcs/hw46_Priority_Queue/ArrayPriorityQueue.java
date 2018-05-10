// Aaron Li
// APCS2 pd8
// HW46 -- Arr, There Be Priorities Here Matey
// 2018-05-09

// import ArrayList
import java.util.ArrayList;

public class ArrayPriorityQueue { // class ArrayPriorityQueue

     // instance variables
     ArrayList<String> _data;
     int _size;

     // default constructor
     public ArrayPriorityQueue() {
          _data = new ArrayList();
          _size = 0;
     }

     // checks if _data is empty
     // returns: true if empty, false otherwise
     // O(1)
     public boolean isEmpty() {
          return _size == 0;
     }

     // add a String input to _data
     // O(1)
     public void add(String inp) {
          _data.add(inp);
     }

     // checks for the String element of smallest value in _data
     // returns: String element of the smallest value
     // O(n)
     public String peekMin() {
          // start from beginning of ArrayList
          String ret = _data.get(0);
          // for loop to iterate through ArrayList
          for (int i = 1; i < _data.size(); i++) {
               // if the current element is smaller than the stored element, set it
               // as the new stored element
               if (ret.compareToIgnoreCase(_data.get(i)) >= 0) ret = _data.get(i);
          } return ret;
     }

     // removes and returns the smallest String element
     // returns: value removed
     // O(n)
     public String removeMin() {
          String ret = this.peekMin();
          _data.remove(_data.indexOf(this.peekMin()));
          return ret;
     }

     // toString to print _data
     // O(n)
     public String toString() {
          String ret = "";
          for (String i : _data) {
               ret += i + ", ";
          } ret = ret.substring(0, ret.length() - 2);
          ret += "\n";
          return ret;
     }

     // main method
     public static void main(String[] args) {
          ArrayPriorityQueue test = new ArrayPriorityQueue();
          System.out.println("\nAdding elements to the queue...");
          test.add("Munchkins");
          test.add("glazed donuts");
          test.add("cool beans");
          test.add("smoothies");
          test.add("hashbrowns");
          test.add("bacon");

          System.out.println("\nPrinting current queue...");
          System.out.println(test.toString());

          System.out.println("The smallest String element to be removed: " + test.peekMin());
          System.out.println("\nRemoving the smallest element...");
          System.out.println("Element removed: " + test.removeMin());
          System.out.println("\nPrinting current state of ArrayList...");
          System.out.println(test.toString());
          System.out.println("Removing next smallest String element: " + test.peekMin());
          test.removeMin();
          System.out.println(test.toString());

     } // end main method

} // end class
