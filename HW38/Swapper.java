/* 
   Aaron Li
   APCS1 pd8
   HW40 -- Make it Better
   2017-11-25
*/

/**=======================================================================
   Operation of Aaron's Swapper Class: 
   
   1) An array is created in the main method, it has a random [2, 10) 
   number of rows, and either three or four columns(also random)
   2) The array is populated with random characters from a final string, 
   with help from a populate() method. 
   3) The populated array is printed to the user using a toString() method
   4) Swap() method is engaged, in which the UI will instruct the user 
   how to swap two string cells of the array
   
   ======================================================================**/

/*****====================================================================
      IMPROVEMENTS:
      1) Added row numbers
      2) Added column numbers
      3) Prettified UI and presented user with array after modifications
      ===============================================================*****/


import cs1.Keyboard; // import cs1 package for keyboard input methods

public class Swapper { // start class Swapper

    // Final string that stores all possible characters in the 3/4 character long strings
    private static final String [] STR = {
	"A", "B", "C", "D", "E", "F", "G",
	"H", "I", "J", "K", "L", "M", "N",
	"O", "P", "Q", "R", "S", "T", "U",
	"V", "W", "X", "Y", "Z", "a", "b",
	"c", "d", "e", "f", "g", "h", "i",
	"j", "k", "l", "m", "n", "o", "p",
	"q", "r", "s", "t", "u", "v", "w",
	"x", "y", "z","0", "1", "2", "3",
	"4", "5", "6", "7", "8", "9" };

    // Allows arrays to be printed in pretty well spaced string form
    // this is for arrays with length 3 subarrays
    public static String toString(String[][] a) { // takes array input
        
	String out = "[\n        0    1    2     \n";
	    
	
	for (int i = 0; i < a.length; i++) { // iterate through each subarray
	    out += "   " + i + "  [ ";
	    for (int x = 0; x < a[1].length; x++) { // iterate through each cell
		out += a[i][x] + ", ";
	    } out = out.substring(0, out.length() - 2); // removes extra comma and white space
	    out += "] \n";
	} out += "] \n";
	return out; 
    }

    // Allows arrays to be printed in pretty well spaced string form
    // this is for arrays with length 4 subarrays
    public static String toString1(String[][] a) { // takes array input
        
	String out = "[\n        0     1     2     3     \n";
	    
	
	for (int i = 0; i < a.length; i++) { // iterate through each subarray
	    out += "   " + i + "  [ ";
	    for (int x = 0; x < a[1].length; x++) { // iterate through each cell
		out += a[i][x] + ", ";
	    } out = out.substring(0, out.length() - 2); // removes extra comma and white space
	    out += "] \n";
	} out += "] \n";
	return out; 
    }
    

    // Void method that populates every cell in each array 
    public static void populate(String[][] input) { // takes array input
	for (int i = 0; i < input.length; i++) { // iterate through each subarray
	    for (int cell = 0; cell < input[i].length; cell++) { // iterate through each cell
		String str = ""; // store cell's string 
		int counter = 0; // counter to iterate
		while (counter < input[i].length) { // iterate through number of characters
		    str += STR[(int) (Math.random() * 62)]; // random chooses one character from STR
		    counter++;
		} input[i][cell] = str;
	    }
	}
    }

    // Randomly chooses either 3 or 4 character length strings
    public static int choose() {
	double rand = Math.random();
	if (rand < 0.5) {
	    return 3;
	} else {
	    return 4;
	}
    }

    // Void method swap that takes input array and allows the user to swap cells
    public static void swap(String[][] input) {
	String out = "\n===================== WELCOME TO THE ULTIMATE SWAPPER ===================== \n\n\n"; // greeting
	out += "Please indicate the location of the string you want to swap in the format: \n"; // instructions
	out += "   Index of Array \n";
	out += "   Index of Cell \n";
	out += "   (without spaces) \n\n";
	out += "Range of indexes for array number: 0 - " + (input.length - 1) + "\n"; // for user reference
	out += "Range of indexes for cell number: 0 - " + (input[1].length - 1) + "\n\n"; // for user reference
	out += "Please indicate the location of the array cell you wish to change: \n";
	System.out.println(out);

	//---------- uses cs1 package to read each line of user input ----------
	Keyboard wow = new Keyboard();
	out += wow.readInt();
	out += wow.readInt();
	int oRow = Integer.parseInt(out.substring(out.length() - 2, out.length() - 1));
	int oCol = Integer.parseInt(out.substring(out.length() - 1, out.length()));
	out += "\nGood! Now please enter the location of the array cell you wish to swap with in the same format: \n";
	System.out.println(out);
        
	out += wow.readInt();
	out += wow.readInt();
	int nRow = Integer.parseInt(out.substring(out.length() - 2, out.length() - 1));
	int nCol = Integer.parseInt(out.substring(out.length() - 1, out.length()));
	//----------------------------------------------------------------------

	// Swaps the selected cell with the new cell
	String orig = input[oRow][oCol];
	String newo = input[nRow][nCol];

	input[oRow][oCol] = newo;
	input[nRow][nCol] = orig;

	System.out.println("You have swapped successfully! \n"); 

    } 

    // Main method to test 
    public static void main(String[] args) {
	// create new array with row count [2,10) and either 3 or 4 length subarrays
	String[][] user = new String[(int) ((Math.random() * 8 + 2))][choose()];

	// populate the new array with random string values
	populate(user);

	System.out.println("\n===================================");
	System.out.println("Your 2D array is: \n");
	if (user[1].length == 3) {
	    System.out.println(toString(user)); // prints the array
	} if (user[1].length == 4) {
	    System.out.println(toString1(user));
	}
	System.out.println("===================================\n");
	
	swap(user); // user input based swapping

	System.out.println(toString(user));
    }
} // end class Swapper

   
