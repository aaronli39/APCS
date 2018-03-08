// Aaron Li
// APCS2 pd8
// HW16 -- About Face
// 2018-03-07

public class Mysterion {

     // helper method to swap two indicies
     public static void swap(int a, int b, int[] arr) {
          int temp = arr[a];
          arr[a] = arr[b];
          arr[b] = temp;
     }

     /*
     The function of this method is still unclear to me. While inspecting the code,
     I thought that this would be a sort method that sorts things to the left and right
     of int c, but my test cases have proved it wrong. The results of my tests did not
     seem to fit any theory that I had.
     */
     public static int mystery(int a, int b, int c, int[] arr) {
          int v = arr[c];

          swap(c, b, arr);
          int s = a;
          for (int i = 0; i < (b - 1) - a; i++) {
               if (arr[i] < v) {
                    swap(s, i, arr);
                    s += 1;
               }
          } swap(b, s, arr);
          System.out.println(toString(arr));
          return s;
     }

     // toString method to display specified array
     public static String toString(int[] arr) {
          String out = "[";
          for (int i = 0; i < arr.length; i++) {
               out += arr[i] + ", ";
          } out = out.substring(0, out.length() - 2);
          out += "]";
          return out;
     }

     // main method
     public static void main(String[] args) {
          // Test calls
          int[] arr = {5, 6, 9, 1, 7};
          System.out.println(mystery(0, 2, 4, arr));
          System.out.println(mystery(4, 2, 0, arr));

          int[] arr1 = {1, 3, 5, 7, 9};
          System.out.println(mystery(0, 2, 4, arr1));
          System.out.println(mystery(4, 2, 0, arr1));
     } // end of main method
}
