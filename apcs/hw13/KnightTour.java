// Aaron Li
// APCS2 pd8
// HW13 -- We On Award Tour
// 2018-03-04

/*======================================
class KnightTour
Animates a Knight's Tour of a square chess board.

Mean execution times for boards of size n*n:
n=5   50s    over 5 executions
n=6   456s   over 5 executions
n=7   ?s     over 5 executions
n=8   ?s     over 5 executions
======================================*/

/***
* USAGE:
* $ javac KnightTour.java
* $ java KnightTour
* $ java KnightTour [N]
*
* (default N value: 8)
*
* POSIX TIP: to measure execution time, use time program:
* $ time java KnightTour 5
***/


import java.io.*;
import java.util.*;


class TourFinder
{
     //instance vars
     private int[][] board;
     private int sideLength; //board has dimensions n x n
     private boolean solved = false;

     //constructor
     public TourFinder( int n ) {

          sideLength = n;

          //init 2D array to represent square board with moat
          board = new int[n+4][n+4];

          //SETUP BOARD --  0 on each cell to represent unvisited
          //               -1 on each border/buffer cell around edges
          //---------------------------------------------------------
          for( int i=0; i < n+4; i++ )
          for( int j=0; j < n+4; j++ )
          board[i][j] = -1; //lay down initial blanket of -1's

          for( int i=2; i < n+2; i++ )
          for( int j=2; j < n+2; j++ )
          board[i][j] = 0; //lay down 0's for actual board
          //---------------------------------------------------------

     }//end constructor


     public String toString()
     {
          //send ANSI code "ESC[0;0H" to place cursor in upper left
          String retStr = "[0;0H";
          //emacs shortcut: C-q, then press ESC
          //emacs shortcut: M-x quoted-insert, then press ESC

          int i, j;
          for( i=0; i < sideLength+4; i++ ) {
               for( j=0; j < sideLength+4; j++ )
               retStr = retStr + String.format( "%3d", board[j][i] );
               //"%3d" allots 3 spaces for each number
               retStr = retStr + "\n";
          }
          return retStr;
     }


     //helper method to keep try/catch clutter out of main flow
     private void delay( int n )
     {
          try {
               Thread.sleep(n);
          } catch( InterruptedException e ) {
               System.exit(0);
          }
     }

     // helper method to verify validity of a spot on the board
     public boolean valid(int x, int y) {
          return board[x][y] == 0;
     }

     /*********************************************
     * void findTour(int x,int y,int moves) -- use depth-first w/ backtracking algo
     * to find valid knight's tour
     * @param x      starting x-coord
     * @param y      starting y-coord
     * @param moves  number of moves made so far
     *********************************************/
     public void findTour( int x, int y, int moves )
     {
          delay(50); //slow it down enough to be followable
          if (solved) System.exit(0);

          //primary base case: tour completed
          if (moves == (sideLength * sideLength)) {
               solved = true;
          }
          //other base case: stepped off board or onto visited cell
          if ( board[x][y] != 0 ) {
               return;
          }
          //otherwise, mark current location
          //and recursively generate tour possibilities from current pos
          else {
               board[x][y] = moves;
               System.out.println(this);
               delay(10); //uncomment to slow down enough to view

               /*======================================
               Recursively try to solve (find tour) from
               each of knight's available moves.
               . e . d .
               f . . . c
               . . @ . .
               g . . . b
               . h . a .
               ======================================*/
               // right and down
               findTour(x + 1, y + 2, moves + 1);
               // left and down
               findTour(x - 1, y + 2, moves + 1);
               // down and right
               findTour(x + 2, y + 1, moves + 1);
               // up and left
               findTour(x - 2, y - 1, moves + 1);
               // right and up
               findTour(x + 1, y - 2, moves + 1);
               // left and up
               findTour(x - 1, y - 2, moves + 1);
               // up and right
               findTour(x + 2, y - 1, moves + 1);
               // down and left
               findTour(x - 2, y + 1, moves + 1);

               //If made it this far, path did not lead to tour, so back up.
               board[x][y] = 0;
               System.out.println(this);
          }
     }//end findTour()

}//end class TourFinder


public class KnightTour
{
     public static void main( String[] args ) {

          int n = 5;

          try {
               n = Integer.parseInt( args[0] );
          }catch( Exception e ) {
               System.out.println( "Invalid input. Using board size "
               + n + "..." );
          }

          TourFinder tf = new TourFinder( n );

          //clear screen using ANSI control code
          System.out.println( "[2J" );

          //display board
          System.out.println( tf );

          //for random starting location, use lines below:
          int startX = 2 + (int)( n * Math.random() );
          int startY = 2 + (int)( n * Math.random() );

          long sum = 0;
          for (int i = 0; i < 5; i++) {
               long start = System.nanoTime();
               tf.findTour(2, 2, 0 );   // 1 or 0 ?
               long end = System.nanoTime();
               sum += (end - start);
          } System.out.println(sum / 5000000000. + "");

          TourFinder tf1 = new TourFinder(n + 1);


          //clear screen using ANSI control code
          System.out.println( "[2J" );

          //display board
          System.out.println( tf );

          //for random starting location, use lines below:
          startX = 2 + (int)( n * Math.random() );
          startY = 2 + (int)( n * Math.random() );

          sum = 0;
          for (int i = 0; i < 5; i++) {
               long start = System.nanoTime();
               tf1.findTour(2, 2, 0 );   // 1 or 0 ?
               long end = System.nanoTime();
               sum += (end - start);
          } System.out.println(sum / 5000000000. + "");

          //for fixed starting location, use line below:
          // tf.findTour( 2, 2, 0 );

     }//end main()

}//end class KnightTour
