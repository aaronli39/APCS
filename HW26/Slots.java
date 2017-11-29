/*****************************************************
 * class Slots
 * simulates a slot machine in your very own terminal
 * Xiaojie "Aaron" Li
 * APCS1 pd8
 * HW26 -- Spin Class
 * 2017-11-07
 *****************************************************/

public class Slots
{

    private static final String[] FRUITS = {
	"lime", "lime", "lime", 
	"lemon", "lemon", "lemon", 
	"cherry", "cherry", "cherry", 
	"orange", "orange", "orange", 
	"grapefruit", "grapefruit", "grapefruit", 
	"tangerine", "tangerine", "tangerine", 
	"ugli", "ugli", "ugli",
	"peach", "peach", "peach"
    };
  
    private String[] _fruits; //to be init'd by each instance


    /*=====================================
      Slots() -- default constructor
      pre:  constant array FRUITS exists, has been initialized
      post: mutable array _fruits contains same elements as FRUITS
      =====================================*/
    public Slots()
    {
	//allocate memory for _fruits based on size of FRUITS:
	_fruits = new String [FRUITS.length];

	int i = 0;
	
	//copy elements of FRUITS into _fruits:
	for (String element: FRUITS) {
	    _fruits[i] = element;
	    i++;
	}
    }

    
    /*=====================================
      String toString() -- overrides inherited toString()
      pre:  
      post: returns String of elements in slots 0 thru 2, separated by tabs
      =====================================*/
    public String toString()
    {
	return (_fruits[0] + "\t" + _fruits[1] + "\t" + _fruits[2]);
    }
	    

    /*=====================================
      void swap(int,int) -- array swap util fxn
      pre:  _fruits array exists
      post: elements at indices i, j are swapped
      =====================================*/
    private void swap(int i, int j) 
    {
	String orig = _fruits[i];
	_fruits[i] = _fruits[j];
	_fruits[j] = _fruits[i]; 
    }


    /*=====================================
      void spinOnce() -- simulate a pull of the slot machine lever
      pre:  _fruits array exists
      post: randomized order of elements in _fruits array
      =====================================*/
    public void spinOnce()
    {
	for (int i = 0; i < _fruits.length; i++) {
	    int a = (int) (Math.random() * _fruits.length);
	    int b = (int) (Math.random() * _fruits.length);
	    swap(a, b);
	}
    }


    /*=====================================
      boolean jackpot() -- checks for a winning combo
      pre:  _fruits is existing array
      post: returns true if first 3 slots represent winning combo,
      false otherwise
      =====================================*/
    public boolean jackpot()
    {
	return (_fruits[0].equals(_fruits[1])) && (_fruits[0].equals(_fruits[2]));
    }


    /*=====================================
      boolean miniWin() -- checks for a winning combo
      pre:  _fruits is existing array
      post: returns true if first 3 slots represent winning combo,
      or if first 3 slots mutually distinct, 
      false otherwise
      =====================================*/
    public boolean miniWin()
    {
	return (jackpot() || ! (_fruits[0].equals(_fruits[1]) && _fruits[0].equals(_fruits[2])));
    }


    //main() method for testing
    public static void main( String[] args )
    {
	Slots machine01 = new Slots();
	Slots machine02 = new Slots();
	
	//test to verify slot machines function indepently
	System.out.println();
	System.out.println( "Machine01 initial state:\t" + machine01 );
	System.out.println( "Machine02 initial state:\t" + machine02 );
	
	System.out.println( "\nSpinning machine01...\n" );
	
	machine01.spinOnce();
	
	System.out.println();
	System.out.println( "Machine01 state:\t" + machine01 );
	System.out.println( "Machine02 state:\t" + machine02 );
	System.out.println();
		
	//test gamble-until-you-win mechanism
	
	System.out.println( "Preparing to spin until a mini win! . . ." );
	System.out.println( "------------------------------------" );
	
	//if you haven't won, spin again until you win!
	while( machine01.miniWin() == false ) {
	    System.out.println( "Your spin..." + "\t" + machine01 );
	    System.out.println( "LOSE\n" );
	    machine01.spinOnce();
	}
	
	System.out.println( "====================================" );
	System.out.println( "Your spin..." + "\t" + machine01 );
	System.out.println( "WIN\n" );
	
	System.out.println( "Preparing to spin until...jackpot! . . ." );
	System.out.println( "------------------------------------" );
	
	//if you haven't won, spin again until you win!
	while( machine01.jackpot() == false ) {
	    System.out.println( "Your spin..." + "\t" + machine01 );
	    System.out.println( "LOSE\n" );
	    machine01.spinOnce();
	}
	
	System.out.println( "====================================" );
	System.out.println( "Your spin..." + "\t" + machine01 );
	System.out.println( "JACKPOT!\n" );
    }//end main
    
}//end class Slots
