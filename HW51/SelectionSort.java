// Aaron Li
// APCS1 pd8
// HW51 -- Selection
// 2017-12-11

/***************************************
* class SelectionSort -- implements SelectionSort algorithm
***************************************/

import java.util.ArrayList;

public class SelectionSort
{
  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond: lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi ) {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
      //     offset + rand int on interval [lo,hi]
      retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
      size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al ) {
    int randomIndex;
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of SelectionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void selectionSortV( ArrayList<Comparable> data )
  {
    // Iterate through each element in input
    for (int i = 0; i < data.size(); i++) {
      int index = i; // This holds the index of the minimum value
      // This foor loop finds the index of the next smallest Comparable
      for (int z = i + 1; z < data.size(); z++) {
        // If the current index is smallest than the index
        // of the smallest value, set var index to z
        if (data.get(z).compareTo(data.get(index)) < 0 ) {
          index = z;
        }
      }
      // Uses temp to store value at index, then swap the two indices
      Comparable temp = data.get(index);
      data.set(index, data.get(i));
      data.set(i, temp);
    }
  }//end selectionSortV

  // ArrayList-returning selectionSort
  // postcondition: order of input ArrayList's elements unchanged
  // Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input )
  {
    // Make new ArrayList foo to store a copy of input
    ArrayList<Comparable> foo = new ArrayList<Comparable>();
    // Use foreach loop to copy each element in put into foo
    for (Comparable i: input) {
      foo.add(i);
    }
    // Sort foo, which is a copy of all values in input
    selectionSortV(foo);
    // Return foo
    return foo;
  }//end selectionSort

  public static void main( String [] args )
  {
    /*
    ArrayList glen = new ArrayList<Integer>();
    glen.add(7);
    glen.add(1);
    glen.add(5);
    glen.add(12);
    glen.add(3);
    System.out.println( "ArrayList glen before sorting:\n" + glen );
    selectionSortV(glen);
    System.out.println( "ArrayList glen after sorting:\n" + glen );

    ArrayList coco = populate( 10, 1, 1000 );
    System.out.println( "ArrayList coco before sorting:\n" + coco );
    selectionSortV(coco);
    System.out.println( "ArrayList coco after sorting:\n" + coco );
    */

    ArrayList glen = new ArrayList<Integer>();
    glen.add(7);
    glen.add(1);
    glen.add(5);
    glen.add(12);
    glen.add(3);
    System.out.println( "ArrayList glen before sorting:\n" + glen );
    ArrayList glenSorted = selectionSort( glen );
    System.out.println( "sorted version of ArrayList glen:\n"
    + glenSorted );
    System.out.println( "ArrayList glen after sorting:\n" + glen );

    ArrayList coco = populate( 10, 1, 1000 );
    System.out.println( "ArrayList coco before sorting:\n" + coco );
    ArrayList cocoSorted = selectionSort( coco );
    System.out.println( "sorted version of ArrayList coco:\n"
    + cocoSorted );
    System.out.println( "ArrayList coco after sorting:\n" + coco );
    System.out.println( coco );

  }//end main

}//end class SelectionSort
