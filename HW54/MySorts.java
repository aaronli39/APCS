// Aaron Li, Collin Hosking, Samuel Ramos -- TEAM GUACAMOLE
// APCS1 pd8
// HW54 -- One File to Bring Them All...
// 2017-12-13

import java.util.ArrayList;

public class MySorts {

  public static void bubbleSortV( ArrayList<Comparable> data )
  {
    //make n-1 passes across collection
    for( int passCtr = 1; passCtr < data.size(); passCtr++ ) {

      //iterate from first to next-to-last element
      for( int i = 0; i < data.size()-1; i++ ) {
        //if element at i > element at i+1, swap
        if ( data.get(i).compareTo(data.get(i+1) ) > 0 )
        data.set( i, data.set(i+1,data.get(i)) );
        //System.out.println(data); //diag: show current state of list
      }
    }
  }

  public static void selectionSortV( ArrayList<Comparable> data )
  {
    //note: this version places greatest value at rightmost end,

    //maxPos will point to position of SELECTION (greatest value)
    int maxPos;

    for( int pass = data.size()-1; pass > 0; pass-- ) {
	    maxPos = 0;
	    for( int i = 1; i <= pass; i++ ) {
        if ( data.get(i).compareTo( data.get(maxPos) ) > 0 )
          maxPos = i;
	    }
	    data.set( maxPos, ( data.set( pass, data.get(maxPos) ) ) );
    }
  }//end selectionSortV

  public static void insertionSortV( ArrayList<Comparable> data )
  {
    for( int partition = 1; partition < data.size(); partition++ ) {
	    //partition marks first item in unsorted region

	    //traverse sorted region from right to left
	    for( int i = partition; i > 0; i-- ) {

        // "walk" the current item to where it belongs
        // by swapping adjacent items
        if ( data.get(i).compareTo( data.get(i-1) ) < 0 ) {
          data.set( i, data.set( i-1, data.get(i) ) );
        }
        else
        break;
	    }
    }
  }//end insertionSortV

}
