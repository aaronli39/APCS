/* 
    Aaron Li
    APCS1 pd8
    HW36 -- Be Rational
    2017-11-19
*/ 

public class Rational { // class Rational
    private int num; // stores numerator
    private int denom; // stores denominator

    // Public constructor takes 2 input parameters: numerator and denominator.
    // Numerator is set to 0 and denominator is set to 1 if invalid denominator
    // is inputted. 
    public Rational(int up, int down) { 
	if (down == 0) { // if denominator is 0, num = 0, denom = 1
	    denom = 1;
	    num = 0;
	    System.out.println("You have entered an invalid denominator. Your number has been set to 0/1."); // error message
	} else { // otherwise, set numerator and denominator to inputs
	    num = up;
	    denom = down;
	}
    }

    // toString method to stringify the numerator/denominator
    public String toString() {
	return ("Your number is: " + num + "/" + denom + "");
    }

    // returns an accurate value of the approximation of the number by using doubles
    public double floatValue() {
	return (num / denom);
    }

    // Multiplies and modifies caller's numerator and denominator. Input is
    // unaffected.
    public void multiply(Rational inp) {
	num *= inp.num;
	denom *= inp.denom;
    }

    // Divides and modifies caller's instance variables. Input is unaffected.
    public void divide(Rational inp) {
	num /= inp.num;
	denom /= inp.denom;
    }

    // Main method for testing
    public static void main(String[] args) {
	Rational r = new Rational(2, 3); // new instance r
	Rational s = new Rational(1, 2); // new instance s
	r.multiply(s); // mulitplies r by s
	System.out.println(r.num); // numerator and denominator of r should change
	System.out.println(s.num); // numerator and denominator of s should not change
	Rational x = new Rational(1, 0); // test what happens when invalid denominator is inputted. Should return 0/1
	
    }
} // end class Rational
