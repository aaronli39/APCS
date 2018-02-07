// Aaron Li
// APCS2 pd8
// HW05 -- Step 1: Split, Step 2: Sort, Step 3: Sorted!
// 2018-02-06

/*======================================
class MergeSort
Implements mergesort on array of ints.

Summary of Algorithm:

     There is an algorithm for sorting two arrays, called merge(). To summarize
the sorting algorithm, the input array is approximately divided in half to form
two arrays, which also divide in half to form two other arrays, until an array
reaches a length of 1. When an array is length 1, it is recursively returned, and
merged with its complement(the other half), using merge(), which will sort the
two halves, and return a sorted array. This process repeats until only one array
remains.

======================================*/

public class MergeSort
{
     /******************************************************
     * int[] merge(int[],int[])
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and
     * output array sorted in ascending order.
     ******************************************************/
     private static int[] merge( int[] a, int[] b )
     {
          // Length of returned array should be the same length as
          // the sum of the lengths of the two inputted arrays
          int[] out = new int[ (a.length + b.length) ];
          int a1 = 0; // current index of array a
          int b1 = 0; // current index of array b

          // While loop iterates until the sum of the indices is equal
          // to sum of the input arrays' indices
          while ((a1 + b1) < a.length + b.length) {
               // if the value at array a index a1 is <= value at array b index
               // b1, then array out is modified to store the value at array a
               // index a1
               if (a1 >= a.length) { // if array a is larger, return elements of array b
                    out[a1 + b1] = b[b1];
                    b1 += 1;
               } else if (b1 >= b.length){ // if array b is larger, return elements of array a
                    out[a1 + b1] = a[a1];
                    a1 += 1;
               } else if (a[a1] < b[b1]) {
                    out[a1 + b1] = a[a1];
                    a1 += 1;
               } else if (b[b1] < a[a1]) { // viceversa for if value at index b1 is < value at a1
                    out[a1 + b1] = b[b1];
                    b1 += 1;
               }
          } return out;
     }//end merge()


     /******************************************************
     * int[] sort(int[])
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
     public static int[] sort( int[] arr )
     {
          // BASE CASE: if array length is 1, it is already sorted
          if (arr.length == 1) {
               return arr;
          } int mid = arr.length / 2; // midpoint for splitting arrays

          // these two arrays have lengths that add up to original array
          int[] a = new int[mid];
          int[] b = new int[arr.length - mid];

          // populates the two halves of the original array with
          // their corresponding values
          for (int i = 0; i < mid; i++ ) {
               a[i] = arr[i];
          } for (int x = 0; x < b.length; x++) {
               b[x] = arr[x + mid];
          }
          // recursively call this method to keep merging halves of the original
          // array, until the array is length 1, where it is returned and merged
          // with its complementary array
          return (merge(sort(a), sort(b)));

     }//end sort()



     //-------------------HELPERS-------------------------
     //tester function for exploring how arrays are passed
     //usage: print array, mess(array), print array. Whaddayasee?
     public static void mess( int[] a ) {
          for( int i = 0 ; i<a.length; i++ )
          a[i] = 0;
     }

     //helper method for displaying an array
     public static void printArray( int[] a ) {
          System.out.print("[");
          for( int i : a )
          System.out.print( i + ",");
          System.out.println("]");
     }
     //---------------------------------------------------


     //main method for testing
     public static void main( String [] args ) {


          int[] arr0 = {0};
          int[] arr1 = {1};
          int[] arr2 = {1,2};
          int[] arr3 = {3,4};
          int[] arr4 = {1,2,3,4};
          int[] arr5 = {4,3,2,1};
          int[] arr6 = {9,42,17,63,0,512,23};
          int[] arr7 = {9,42,17,63,0,9,512,23,9};

          System.out.println("\nTesting mess-with-array method...");
          printArray( arr3 );
          mess(arr3);
          printArray( arr3 );

          System.out.println("\nMerging arr1 and arr0: ");
          printArray( merge(arr1,arr0) );

          System.out.println("\nMerging arr4 and arr6: ");
          printArray( merge(arr4,arr6) );

          System.out.println("\nSorting arr4-7...");
          printArray( sort( arr4 ) );
          printArray( sort( arr5 ) );
          printArray( sort( arr6 ) );
          printArray( sort( arr7 ) );

     }//end main()

}//end class MergeSort
