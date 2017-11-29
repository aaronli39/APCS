/* 
   Aaron Li
   APCS1 pd8
   HW36 -- Be More Rational
   2017-11-20
*/ 

public class Rational { // class Rational
    private int _num; // stores numerator
    private int _denom; // stores denominator

    // Default constructor
    // Numerator is 0, denominator is 1 for default
    public Rational() {
	_num = 0;
	_denom = 1;
    }
    
    // Public constructor takes 2 input parameters: numerator and denominator.
    public Rational(int up, int down) { 
	this();
	if (_denom != 0) { // if _denom != 0, set instance vars to input values
	    _denom = down;
	    _num = up;
	} else { // otherwise, set numerator and denominator to inputs
	    System.out.println("You have entered an invalid denominator");
	}
    }

    // Returns greatest common denominator
    public static int gcd(int a, int b) {
	int c = 0;
	if (a % b == 0) {
	    return b;
	} if (b % a == 0) {
	    return a;
	} while (a > 0 && b > 0) {
	    if (a == 0) {
		return b;
	    } if (b == 0) {
		return a;
	    } if (a >= b) {
		c = a;
		a = b;
		b = c - b;
	    } if (b >= a) {
		a = a;
		b = b - a;
	    } 
	} if (a > b) {
	    return a;
	} else {
	    return b;
	}
    }

    // toString method to stringify the numerator/denominator
    public String toString() {
	return (_num + " / " + _denom);
    }

    // returns an accurate value of the approximation of the number by using doubles
    public double floatValue() {
	return ((double) _num / _denom);
    }

    // Multiplies and modifies caller's numerator and denominator. Input is
    // unaffected.
    public void multiply(Rational inp) {
	this._num *= inp._num;
	this._denom *= inp._denom;
    }

    // Divides and modifies caller's instance variables. Input is unaffected.
    public void divide(Rational inp) {
	if (inp._denom != 0) {
	    _num /= inp._num;
	    _denom /= inp._denom;
	} else {
	    System.out.println("Divide by 0 error");
	}
    }

    // Takes one rational object and adds it to caller
    public void add(Rational inp) {
	this.reduce(); // reduce both caller and input 
	inp.reduce();

	int origdenom = this._denom; // stores original caller denominator to multiply
	
	this._num *= inp._denom; // multiply to have common denominator
	this._denom *= inp._denom;
	
	inp._num *= origdenom;
	inp._denom *= origdenom;
	
	this._num += inp._num; // adds caller numerator by input numerator
	this.reduce(); // reduces final answer
    }

    // Takes one rational object and subtracts it from caller
    public void subtract(Rational inp) {
	this.reduce(); // reduce both caller and input first
	inp.reduce();

	int origdenom = this._denom; // stores original denominator to later multiply with
	
	this._num *= inp._denom; // multiplies numerator and denominator by denominator of ipnut
	this._denom *= inp._denom;
	
	inp._num *= origdenom; // multiplies numerator and denominator by denominator of caller
	inp._denom *= origdenom;
	
	this._num -= inp._num; // subtracts numerators
	this.reduce(); // reduces final answer
    }

    // Reduces calling rational object to simplest form
    public void reduce() {
	int common = gcd(_num, _denom); // common factor to reduce by
	_num /= common;
	_denom /= common;
    }

    // Compares two Rational objects.
    // Returns 0 if inputs are equal
    // Returns positive int if calling number is larger than input
    // Returns negative integer if calling number is smaller than input
    public int compareTo(Rational inp) {
	double caller = this.floatValue();
	double input = inp.floatValue();
	if (caller == input) {
	    return 0;
	} else if (caller >= input) {
	    return 1;
	} else {
	    return -1;
	}
    }
    
    // Main method for testing
    public static void main(String[] args) {
	Rational r = new Rational(2, 3); // new instance r
	Rational s = new Rational(1, 2); // new instance s
	Rational t = new Rational(1, 2); // new instance t
	Rational u = new Rational(4, 6); // new instance u
	System.out.println(gcd(2, 7)); // outputs gcd of 2 and 7: should be 1
        
	r.multiply(s); // mulitplies r by s
	System.out.println(r.toString()); // numerator and denominator of r should change
	System.out.println(s.toString()); // numerator and denominator of s should not change
	
	Rational x = new Rational(1, 0); // test what happens when invalid denominator is inputted. Should return 0/1
	System.out.println(x.toString());

	
	t.add(u); // add t and u
	System.out.println(t.toString()); // should output 7/6
	
	t.subtract(u); // subtract t by u
	System.out.println(t.toString()); // should output 1/2
	    

	System.out.println(r.floatValue()); // tests float value. should output 0.333~
	System.out.println(r.compareTo(s)); // compares r and s, should return -1
	System.out.println(s.compareTo(t)); // compares s and t, should return 0
	
    }
} // end class Rational
