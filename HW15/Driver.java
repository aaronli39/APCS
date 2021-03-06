/*

<Xiaojie> <Li>
APCS1 pd<8>
HW<16> -- <Get it While You Can>
<2017>-<10>-<12> 

*/

public class Driver
{
    // variable to store number of matches that have occured
    public static int match;
    
    //variabe to store number of matches that matched
    public static int matches;

    public static void main( String[] args )
    {
        match = 0;
	matches = 0;
	//build Objects from blueprint specified by class Coin
	// ===================TOP==========================
	Coin mine = new Coin();

	//test 1st overloaded constructor
	Coin yours = new Coin( "quarter" );

	//test 2nd overloaded constructor
	Coin wayne = new Coin( "dollar", "heads" );

	//test toString() methods of each Coin
	System.out.println("mine: " + mine);
	System.out.println("yours: " + yours);
	System.out.println("wayne: " + wayne);

	//test flip() method
	System.out.println("\nAfter flipping...");

	// While loop that will keep flipping until a specified number of flips 
	while ((yours.headsCtr <= 66 || wayne.headsCtr <= 150) && (match <= 99 && (matches < 13000 && 13000./2000 != 0.0))) {  
	    yours.flip();
	    wayne.flip();
	    // The equals method must be implemented within the while loop to continuously check for equality after each run and to increase the appropriate counters
	    if (yours.upFace.equals(wayne.upFace)) { 
		System.out.println( "Matchee matchee!" );
		matches += 1;
		match += 1;
	    }
	    else {
		System.out.println( "No match. Firestarter you can not be." );
		match += 1;
	    }
	    
	    yours.flip();
	    wayne.flip();
	    System.out.println("yours: " + yours);
	    System.out.println("wayne: " + wayne);
	}
	// ====================BOTTOM====================== 
	
    }// end main()
}//end class
