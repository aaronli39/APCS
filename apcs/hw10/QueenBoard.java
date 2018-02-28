// Aaron Li
// APCS2 pd8
// HW10 -- [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
// 2018-02-27

/***
* class QueenBoard
* Generates solutions for N-Queens problem.
*/

public class QueenBoard
{
     private int[][] _board;

     public QueenBoard( int size )
     {
          _board = new int[size][size];
     }


     /***
     * precondition: board is filled with 0's only.
     * postcondition:
     * If a solution is found, board shows position of N queens,
     * returns true.
     * If no solution, board is filled with 0's,
     * returns false.
     */
     public boolean solve()
     {
          int count = 0;
          for (int i = 0; i < _board.length; i++) {
               if (solveH(i) == true) {
                    for (int x = 0; x < _board.length; x++) {
                         if (_board[x][i] == 0) {
                              addQueen(x, i);
                              _board[x][i] = 1;
                              count++;
                              break;
                         }
                    }
               }
          } System.out.println(count);
          if (count == _board.length) {
               for (int z = 0; z < _board.length; z++) {
                    for (int q = 0; q < _board.length; q++) {
                         if (_board[z][q] == 1) {
                              System.out.println("(" + z + ", " + q + ")");
                              removeQueen(z, q);
                              break;
                         }
                    }
               } return true;
          }
          for (int w = 0; w < _board.length; w++) {
               for (int k = 0; k < _board.length; k++) {
                    if (_board[w][k] == 1) {
                         removeQueen(w, k);
                         break;
                    }
               }
          } return false;
     }


     /**
     *Helper method for solve.
     Returns: true if you can place a queen in specified column
     Returns: false if you cannot place a queen in specified column
     */
     private boolean solveH( int col )
     {
          int count = 0;
          for (int i = 0; i < _board.length; i++) {
               if (_board[i][col] == 1 ) {
                    return false;
               } if (_board[i][col] < 0) {
                    count++;
               }
          }
          if (count == _board.length) {
               return false;
          } return true;
     }

     public void printSolution()
     {
          String output = "\n";
          if (this.solve() == true) {
               for (int i = 0; i < _board.length; i++) {
                    for (int z = 0; z < _board.length; z++) {
                         if (_board[i][z] <= 0) {
                              output += "_ ";
                         } if (_board[i][z] == 1) {
                              output += "Q ";
                         }
                    } output += "\n";
               }
          } System.out.println(output);
     }



     //================= YE OLDE SEPARATOR =================

     /***
     * Places a queen at the specified index
     * precondition: there is no queen at the input indices, return false
     * postcondition: queen is placed at index, possible queen moves are decremented, return true
     */
     private boolean addQueen(int row, int col){
          if(_board[row][col] != 0){
               return false;
          }
          _board[row][col] = 1;
          int offset = 1;
          while(col+offset < _board[row].length){
               _board[row][col+offset]--;
               if(row - offset >= 0){
                    _board[row-offset][col+offset]--;
               }
               if(row + offset < _board.length){
                    _board[row+offset][col+offset]--;
               }
               offset++;
          }
          return true;
     }


     /***
     * Removes queen at the specified index
     * precondition: there is no queen at the specified index, return false
     * postcondition: queen at index removed, all possible moves for the queen are incremented by one
     */
     private boolean removeQueen(int row, int col){
          if ( _board[row][col] != 1 ) {
               return false;
          }
          _board[row][col] = 0;
          int offset = 1;

          while( col+offset < _board[row].length ) {
               _board[row][col+offset]++;
               if( row - offset >= 0 ) {
                    _board[row-offset][col+offset]++;
               }
               if( row + offset < _board.length ) {
                    _board[row+offset][col+offset]++;
               }
               offset++;
          }
          return true;
     }


     /***
     * Prints virtual board
     * precondition: valid Queensboard makes function call
     * postcondition: String representation of Queensboard is returned
     */
     public String toString()
     {
          String ans = "";
          for( int r = 0; r < _board.length; r++ ) {
               for( int c = 0; c < _board[0].length; c++ ) {
                    ans += _board[r][c]+"\t";
               }
               ans += "\n";
          }
          return ans;
     }


     //main method for testing...
     public static void main( String[] args )
     {
          QueenBoard b = new QueenBoard(5);
          System.out.println(b);
          System.out.println(b.solveH(0));
          System.out.println(b.solve());
          System.out.println(b);
          b.printSolution();

          QueenBoard c = new QueenBoard(7);
          System.out.println(c);
          System.out.println(c.solveH(0));
          System.out.println(c.solve());
          System.out.println(c);
     }

}//end class
