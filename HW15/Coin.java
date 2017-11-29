/*

<Xiaojie> <Li>
APCS1 pd<8>
HW<16> -- <Get it While You Can>
<2017>-<10>-<12>

*/

public class Coin {
    // These are the instance variables
    
    public int value;
    
    public String upFace;
    
    public String name;
    
    public int flipCtr;
    
    public int headsCtr;
   
    public int tailsCtr;
    
    public double bias; 
    // 1.0 = always heads 0.0 = always tails 

    public Coin() {
	upFace = "heads";
	flipCtr = 0;
	headsCtr = 0;
	tailsCtr = 0;
	bias = 0.5;
    }
    
    public Coin(String denom) {
	// Take string input to indicate denomination
	name = denom;
	upFace = "heads";
	flipCtr = 0;
	headsCtr = 0;
	tailsCtr = 0;
	bias = 0.5;	
    }
    
    public Coin(String denom, String face) {
	// String denomination and string face to indicate current face
	this.name = denom;
	this.upFace = face;
	bias = 0.5;
    }

    public void flip() {
	// Simulate a coin flip
	// probability of heads or tails determined by bias
	double num = Math.random();
	if (num <= bias) {
	    upFace = "heads";
	    headsCtr += 1;
	} else if (num > bias) {
	    upFace = "tails";
	    tailsCtr += 1;
	}
	flipCtr += 1;
    }

    public String toString() {
	// return coin denom and current face
	String output = "";
	output += " " + name + " -- " + upFace;
	return output;
    }

    public boolean equals(Coin input) {
	// compare with another coin, true if same face false otherwise
	return upFace.equals(input.upFace);
    }

    public void assignValue() {
	// assigns coin monetary value due to name
	if (name == "penny") {
	    value = 1;
	} else if (name == "nickel") {
	    value = 5;
	} else if (name == "dime") {
	    value = 10;
	} else if (name == "quarter") {
	    value = 25;
	} else if (name == "dollar") {
	    value = 100;
	}
	System.out.println(value);
    }

}
