// Aaron Li
// APCS1 pd8
// HW46 -- Al<B> Sorted!
// 2017-12-04

// Imports class ArrayList
import java.util.ArrayList;

public class ALTester { // Class ALTester

  // Takes an ArrayList input AND an integer num input
  // Populates input ArrayList with integer num designated elements
  public static void populate(ArrayList<Comparable> input, int num) {
    for (int i = 0; i < num; i++) {
      input.add((int) (Math.random() * 10));
    }
  }

  // Takes ArrayList input
  // Returns a boolean: false if array is not ordered, true if it is
  public static boolean sorted(ArrayList<Comparable> input) {
    // Iterate starting at index 1 to avoid going out of bounds
    for (int i = 1; i < input.size(); i++) {
      // Compares previous element with element at current index:
      // Follows sorting with ascending order, so if element at
      // previous index is smaller than element at current index,
      // return false, otherwise true
      if (((input.get(i - 1).compareTo(input.get(i))) > 0)) {
        return false;
      }
    } return true;
  }

  // Main method for testing
  public static void main(String[] args) {
    // Initialize three ArrayLists
    ArrayList<Comparable> moo = new ArrayList<Comparable>();
    ArrayList<Comparable> foo = new ArrayList<Comparable>();
    ArrayList<Comparable> too = new ArrayList<Comparable>();

    // Print initialized ArrayLists
    System.out.println(moo);
    System.out.println(too);
    System.out.println(foo);

    // Adds ascending elements to foo to test sorted() method
    foo.add(0);
    foo.add(1);
    foo.add(3);
    // Print modified ArrayList foo
    System.out.println(foo);

    // Adds descending elements to too to confirm functionability of sorted()
    too.add(3);
    too.add(1);
    too.add(0);
    // Print modified ArrayList too
    System.out.println(too);

    // Randomly populates moo with 23 elements
    // Note: populate takes 2 inputs: ArrayList, and an integer
    populate(moo, 23);
    // Print populated ArrayList moo
    System.out.println(moo);

    // Print sorted() method tests:
    // Should return: false, true, false
    System.out.println(sorted(moo));
    System.out.println(sorted(foo));
    System.out.println(sorted(too));
  } // end of main method

} // end of class ALTester
