// Team Typo: Aaron Li, Jason Kim
// APCS2 pd8
// HW07 -- A Man, A Plan, A Canal: Panama!
// 2018-02-13

public class Resrever { // class Resrever

     // O(n/2) or O(n) runtime of reversing.
     // input: string to reverse
     // output: reversed string
     public static String linRev(String inp) {
          // convert input to array of characters
          char[] out = inp.toCharArray();
          // iterate till the midpoint of the array, swaps
          // first element with last element, second with second
          // to last, etc...
          for (int i = 0; i < (out.length - 1) / 2; i++) {
               char temp = out[i]; // stores char at current index
               out[i] = out[(out.length - 1) - i]; // char at index becomes complementary char
               out[(out.length - 1) - i] = temp; // complement becomes char at index
          } return String.valueOf(out);
     }

     // O(logn) runtime of reversing
     // input: string to reverse
     // output: reversed string
     public static String logRev(String inp) {
          // base case: length 1 strings are returned
          if (inp.length() == 1) {
               return inp;
          } int half = inp.length() / 2; // midpoint split index
          String left = inp.substring(0, half); // first split half
          String right = inp.substring(half); // second split half
          // returns the concatenated strings from the right to left(reversed) order
          return (logRev(right) + logRev(left));
     }

     // main method
     public static void main(String[] args) {
          System.out.println("\nTesting main method:\n\n");
          System.out.println("apcs2:  " + linRev("apcs2"));
          System.out.println("helloguys!:  " + linRev("helloguys!"));
          System.out.println("level:  " + linRev("level"));
          System.out.println("besthomeworkever:  " + logRev("besthomeworkever"));
          System.out.println("haha:  " + logRev("haha"));
          System.out.println("backwards:  " + logRev("backwards"));
     } // end of main method
} // end of class Resrever
