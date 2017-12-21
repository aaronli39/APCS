// Aaron Li
// APCS1 pd8
// HW57 -- How Deep Does the Rabbit Hole Go?
// 2017-12-19

/***
* class Matrix -- models a square matrix
*
* BACKGROUND:
* A matrix is a rectangular array.
* Its dimensions are numRows x numColumns.
* Each element is indexed as (row,column):
*  eg,
*   for 2 x 3 matrix M:
*        -       -
*   M =  | a b c |
*        | d e f |
*        -       -
*   ... d is at position (2,1) or M[2,1]
*
* TASK:
* Implement methods below, categorize runtime of each.
* Test in main method.
***/


public class Matrix
{
  //constant for default matrix size
  private final static int DEFAULT_SIZE = 2;

  private Object[][] matrix;

  //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
  public Matrix( )
  {
    matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
  }


  //constructor intializes an a*a matrix
  public Matrix( int a )
  {
    matrix = new Object[a][a];
  }


  //return size of this matrix, where size is 1 dimension
  private int size()
  {
    // Since matrix is a square, # of rows == # of columns
    return matrix.length;
  }


  //return the item at the specified row & column
  private Object get( int r, int c )
  {
    // Inputs start at index 1, but the actual index is one less than that
    return matrix[r - 1][c - 1];
  }


  //return true if this matrix is empty, false otherwise
  private boolean isEmpty(int r, int c)
  {
    return (get(r, c) == null);
  }


  //overwrite item at specified row and column with newVal
  //return old value
  private Object set( int r, int c, Object newVal )
  {
    // Var to store old value
    Object old = this.matrix[r - 1][c - 1];
    // Sets element at row r and column c to newVal
    matrix[r - 1][c - 1] = newVal;
    // Return original value
    return old;
  }


  //return String representation of this matrix
  // (make it look like a matrix)
  public String toString()
  {
    // String var to store outputting string
    String out = "\n   ";

    // For loop: ONLY WORKS WITH SINGLE DIGIT OBJECTS
    // Prints column numbers on top of the whole matrix
    for (int i = 0; i < size(); i++) {
      out += (i + 1) + " ";
    } out += "\n";

    // For loop: creates the columns
    for (int x = 0; x < size(); x++) {
      out += "   ";
      // Embedded for loop: adds underline to create a cell for each element
      for (int z = 0; z < size(); z++) {
        out += "_ ";
      } out += "\n" + (x + 1) + " ";
      // Embedded for loop: adds bars to create cell for each element
      for (int bars = 0; bars < size(); bars++) {
        out += "|" + matrix[x][bars];
      } out += "|\n";
    } out += "   ";
    // For loop: adds final underlines to complete all cells
    for (int a = 0; a < size(); a++) {
      out += "_ ";
    } return out; // Return String out
  }



  //override inherited equals method
  //criteria for equality: matrices have identical dimensions,
  // and identical values in each slot
  public boolean equals( Object rightSide )
  {
    // Store out output boolean var
    boolean out = false;

    // Conditional: check if calling matrix has same dimensions as input matrix
    if (size() == (((Matrix) rightSide).size())) {
      // For loop: iterate throw each row
      for (int i = 0; i < size(); i++) {
        // For loop: iterate through each element in each row
        for (int x = 0; x < size(); x++) {
          // Conditional: check if element are row x and column y are equal
          // for both calling matrix and rightSide matrix
          if (matrix[i][x] == ((Matrix) rightSide).matrix[i][x]) {
            out = true;
          } else { // If not identical values: exit method, return false
            return false;
          }
        }
      }
    } else { // If not identical dimensions: exit method, return false
      return false;
    } return out; // Return out, should be true if code reaches here
  }


  //swap two columns of this matrix
  //(1,1) is top left corner of matrix
  //row values increase going down
  //column value increase L-to-R
  public void swapColumns( int c1, int c2  )
  {
    // Set inputs to one less the index because
    // user indices start at 1
    c1 -= 1;
    c2 -= 1;
    // For loop: swaps c1 and c2 of each row
    for (int i = 0; i < size(); i++) {
      Object temp = matrix[i][c1];
      matrix[i][c1] = matrix[i][c2];
      matrix[i][c2] = temp;
    }
  }


  //swap two rows of this matrix
  //(1,1) is top left corner of matrix
  //row values increase going down
  //column value increase L-to-R
  public void swapRows( int r1, int r2  )
  {
    // Set inputs to one less the index because
    // user indices start at 1
    r1 -= 1;
    r2 -= 1;
    // For loop: swaps r1 and r2 of each column
    for (int i = 0; i < size(); i++) {
      Object temp = matrix[r1][i];
      matrix[r1][i] = matrix[r2][i];
      matrix[r2][i] = temp;
    }
  }


  //main method for testing
  public static void main( String[] args )
  {
    // Create new instance Matrix called moo for testing
    Matrix moo = new Matrix(4);
    System.out.println("Initialized new 4x4 Matrix moo... ");
    System.out.println("\nPrinting empty Matrix moo..." + moo);

    // Testing isEmpty method
    System.out.println("\nIs Matrix moo empty: " + moo.isEmpty(1, 3) + "\n");

    // Populate moo to test other methods
    System.out.println("\nPopulating moo... ");
    for (int i = 1; i < moo.size() + 1; i++) {
      for (int x = 1; x < moo.size() + 1; x++) {
        int num = (int) (Math.random() * 10);
        moo.set(i, x, num);
      }
    } System.out.println("Printing moo...");
    System.out.println(moo);

    // Testing swapRows method
    System.out.println("\nNow swapping rows 2 and 3...");
    System.out.println("Printing moo with rows 2 and 3 swapped...");
    moo.swapRows(2, 3);
    System.out.println(moo);

    // Testig swapColumns method
    System.out.println("\nNow swapping columns 1 and 4...");
    System.out.println("Printing moo with columns 1 and 4 swapped...");
    moo.swapColumns(1, 4);
    System.out.println(moo);


  } // end main method

}//end class Matrix
