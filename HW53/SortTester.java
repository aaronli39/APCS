// Aaron Li, Collin Hosking, Samuel Ramos -- TEAM GUACAMOLE
// APCS1 pd8
// HW53 -- Solid Comparative Analysis
// 2017-12-13

import java.util.ArrayList;

public class SortTester {

  public static void main(String[] args) {
    /*
    Testing bubbleSortV:

    Best Case: input is already in ascending order
    Worst Case: input is in descending order

    The nature of bubbleSortV checks two adjacent elements,
    and determines if it needs swapping. If it doesn't require
    swapping, it will simply skip the conditional and go to the next
    pair of elements. Thus, if an input ArrayList is already in
    sorted ascending order, it will not have to swap anything,
    which is the best case scenario. If it is in descending order,
    every pair will have to be swapped, which is the worst case scenario.
    */

    /*
    Testing selectionSortV:

    There is no best or worst case.

    The nature of selectionSortV selects a minimum value and puts it to the
    correct position. The for loop utilized to find the minimum value will
    be run regardless of the circumstances, which is why it doesn't matter if
    it is ascneding or descending: it will iterate the whole input to search
    for the minimum regardless.
    */

    /*
    Testing insertionSortV:

    Best and worst case are the same as bubbleSortV.

    The nature of insertionSortV creates both a sorted and unsorted zone
    in the input. There is swapping involved in insertionSortV, just like
    bubbleSortV, which is why there is a best and worst case. If an input
    is already pre-sorted and does not require swapping, it will be better
    than if it is in descending order, and every element must be swapped.
    */

    // Instantiate new ArrayLists to test
    ArrayList<Comparable> BestBubble = new ArrayList<Comparable>();
    ArrayList<Comparable> WorstBubble = new ArrayList<Comparable>();
    ArrayList<Comparable> BestSelection = new ArrayList<Comparable>();
    ArrayList<Comparable> WorstSelection = new ArrayList<Comparable>();
    ArrayList<Comparable> BestInsertion = new ArrayList<Comparable>();
    ArrayList<Comparable> WorstInsertion = new ArrayList<Comparable>();

    // Best and worst case bubbleSortV testing...
    for (int i = 0; i < 10; i++) {
      BestBubble.add(i * 2);
    } System.out.println("BestBubble in pre-sorted ascending order...\n" + BestBubble + "\n");

    for (int x = 10; x > 0; x--) {
      WorstBubble.add(x);
    }
    System.out.println("WorstBubble in descending order...\n" + WorstBubble + "\n");

    // Best and worst case selectionSortV testing...
    for (int i = 0; i < 10; i++) {
      BestSelection.add(i * 2);
    } System.out.println("BestSelection in pre-sorted ascending order...\n" + BestSelection + "\n");

    for (int x = 10; x > 0; x--) {
      WorstSelection.add(x);
    }
    System.out.println("WorstSelection in descending order...\n" + WorstSelection + "\n");

    // Best and worst case insertionSortV testing...
    for (int i = 0; i < 10; i++) {
      BestInsertion.add(i * 2);
    } System.out.println("BestInsertion in pre-sorted ascending order...\n" + BestInsertion + "\n");

    for (int x = 10; x > 0; x--) {
      WorstInsertion.add(x);
    }
    System.out.println("WorstInsertion in descending order...\n" + WorstInsertion + "\n");

    // Sort every single instantiation of ArrayList
    MySorts.bubbleSortV(BestBubble);
    MySorts.bubbleSortV(WorstBubble);

    MySorts.selectionSortV(BestSelection);
    MySorts.selectionSortV(WorstSelection);

    MySorts.insertionSortV(BestInsertion);
    MySorts.insertionSortV(WorstInsertion);

    // Prints all the instantiations of ArrayList
    System.out.println("Sorted BestBubble...\n" + BestBubble + "\n");
    System.out.println("Sorted WorstBubble...\n" + WorstBubble + "\n");

    System.out.println("Sorted BestSelection...\n" + BestSelection + "\n");
    System.out.println("Sorted WorstSelection...\n" + WorstSelection + "\n");

    System.out.println("Sorted BestInsertion...\n" + BestInsertion + "\n");
    System.out.println("Sorted WorstInsertion...\n" + WorstInsertion + "\n");
  }
}
