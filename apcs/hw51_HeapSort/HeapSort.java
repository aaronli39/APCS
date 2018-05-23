// Aaron Li
// APCS2 pd8
// HW51 -- Heaping Piles of Sordidness
// 2018-05-20

import java.util.ArrayList;

public class HeapSort { // class HeapSort

     // Sorts an array by heapifying
     // @param inp: ArrayList to sort
     // Precondition: input ArrayList is != null and of type Integer
     // Postcondition: input ArrayList is sorted
     // O(logn)
     public static void sort(ArrayList<Integer> inp) {
          int temp = inp.size(); // "counter" to decrement, this is the sorted region
          // while loop to heapify the ArrayList
          while (temp > 1) {
               heapify(inp, temp);
               swap(0, temp - 1, inp);
               temp -= 1;
          }
     }

     // Heapifies an ArrayList till partition
     // @param temp: keep heapifying until index reached
     // @param inp: input ArrayList to heapify
     // Precondition: input is != null and of type Integer
     // Postcondition: input is heapified
     // O(logn)
     public static void heapify(ArrayList<Integer> inp, int temp) {
          int part = 1; // partition to heapify
          while (part < temp) {
               int child = part;
               int parent = (child - 1) / 2;
               while (child > 0 && inp.get(child).compareTo(inp.get(parent)) > 0) {
                    swap(child, parent, inp);
                    child = parent;
                    parent = (child - 1) / 2;
               } part += 1;
          }
     }

     // Sets target index with ArrayList input
     public static void swap(int temp, int target, ArrayList<Integer> inp) {
          inp.set(target, inp.set(temp, inp.get(target)));
     }

     // main method
     public static void main(String[] args) {
          // Test case
          ArrayList<Integer> test = new ArrayList<Integer>();

          // Populate
          for (int i = 0; i < 30; i++) {
               test.add((int) (Math.random() * 10));
          } System.out.println("currently, test case is: " + test);
          sort(test);
          System.out.println("\nNow, test case is: " + test);
     } // end main method
} // end class HeapSort
