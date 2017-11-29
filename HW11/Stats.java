/* 
<TEAM BORON>
<Aaron> <Li>
APCS1 pd<8>
HW<19> -- <GCD 3 Ways>
<2017>-<10>-<18>
*/

public class Stats {
    // Instance variables to store and/or modify ints
    public static int num1;
    public static int num2;
    
    // Calculate the mean of integers
    public static int mean(int a, int b) {
	return (a + b) / 2;
    }

    // Calculate the mean of floating point numbers
    public static double mean(double a, double b) {
	return (a + b) / 2;
    }

    // Calculate the max number of two integers
    public static int max(int a, int b) {
	if (a > b) {
	    return a;
	}
	return b;
    }

    // Calculate the min number of two integers
    public static int min(int a, int b) {
	if ((a - b) < 0) {
	    return a;
	}
	return b;
    }
    
    // Calculate the max number of three integers
    public static int max(int a, int b, int c) {
	if (a > b && a > c) {
	    return a;
	}
	return max(b, c);
    }
    
    // Calculate the max number of two floating point numbers
    public static double max(double a, double b) {
	if (a > b) {
	    return a;
	}
        return b;
    }

    // Calculate the max number of three floating point numbers
    public static double max(double a, double b, double c) {
	if (a > b && a > c) {
	    return a;
	} else {
	    return max(b, c); 
	}
    } 

    // Calculate the geometric mean of two integers
    public static int geoMean(int a, int b) {
	return (int) Math.sqrt(a * b);
    }

    // Calculate the geometric mean of three integers
    public static int geoMean(int a, int b, int c) {
	return (int) Math.pow((a * b * c), (1.0/3));
    }
    
    // Calculate the geometric mean of two floating point numbers
    public static double geoMean(double a, double b) {
	return Math.sqrt(a * b);
    }

    // Calculate the geometric mean of three floating point numbers
    public static double geoMean(double a, double b, double c) {
	return Math.pow((a * b * c), (1.0 / 3.0));
    }

    // Brute force approach for GCD
    public static int gcd(int a, int b) {
	num1 = 0; // This will store the GCD thus far
	int counter = 1; // This is the counter that will increase until half of max(a, b) + 1 is reached
	if (a == 0 || b == 0 || a == b) { // If any input is zero, or if the inputs are equal, the min will be outputted
	    return min(a, b);
	} while (counter <= (max(a, b) / 2) + 1) { // Brute force iteration loop
	    if (a % counter == 0 && b % counter == 0) { // If both a and b divide counter, then num1 will store that GCD, and loop continues
		num1 = counter;
		counter += 1;
	    } else {
		counter += 1; // If either a or b doesn't divide counter without remainder, then counter will increment by one and loop continues
	    }
	} return num1;
    }

    /* 
       -------------------------------------------------------------------------------------------------------------------------
       Euclid's Algorithm for finding the GCD first tests to see if either input int a or input int b divides into the other, 
       and if it does, then the int that divides into the other is the GCD. After that, the input int a and input int b is 
       modified such that either the new int a or int b will become the old minimum of old a and old b. Then, the other new 
       int a or int b will become the difference between the old a and old b. This process is repeated until either new int a 
       or new int b becomes zero. At this point, the non-zero new int a or new int b is the GCD between the two integers.
       -------------------------------------------------------------------------------------------------------------------------
    */
    
    // Euclid's Algorithm for GCD (iterative)
    public static int gcdEW(int a, int b) {
	num1 = a; // Using variables to store int a and int b so they can be modified
	num2 = b;
	if (num1 % num2 == 0) { 
	    return num2; // If two numbers are equal or if one completely divides into the other, it already is the GCD 
	} if (num2 % num1 == 0) {
	    return num1;
	} while (num1 > 0 && num2 > 0) { // When either num1 or num2 reaches zero, the loop is over
	    if (num1 == 0) {
		return num2; // If one number is zero, then the other is the GCD
	    } if (num2 == 0) {
	        return num1;
	    }
	    num1 = min(num1, num2); // After each loop, num1 and num2 will be the minimum value between num1, num2 and the difference between num1 and num2
	    num2 = (max(num1, num2) - min(num1, num2));
	} return max(num1, num2);
    }		
    
    // Euclid's Algorithm for GCD (recursive)
    public static int gcdER(int a, int b) {
	num1 = a;
	num2 = b;
	if (num1 % num2 == 0) { // If num2 divides into num1 perfectly, num2 is the GCD
	    return num2;
	} if (num2 % num1 == 0) { // If num1 divides into num2 perfectly, num1 is the GCD
	    return num1;
	} if (min(num1, num2) == 0) { // This is the base case. If either num1 or num2 is zero, then recursion loop exits
	    return min(num1, num2);
	} else {
	    num1 = min(num1, num2);
	    num2 = (max(num1, num2) - min(num1, num2));
	    gcdER(num1, num2);
	} return max(num1, num2);
    }
	
    // Main method runs a test case of each method

    /*

      ------------------------------------------------------------------------------
       THE INT METHODS FOR geoMean WILL MAY PRODUCE NUMBERS DIFFERENT FROM THE
       PREDICTED VALUE DUE TO PRECISION LOSS DURING ROUNDING. FOR THE MOST ACCURATE 
       RESULTS FOR geoMean, USE FLOATING POINT NUMBERS.
      ------------------------------------------------------------------------------

     */
    
    public static void main(String[] args) {

	// Should produce 3 as answer 
	System.out.println(Stats.mean(1,5));

	// Should produce 8.4 as answer
	System.out.println(Stats.mean(6.3,10.5));

	// Should produce 6 as the answer
	System.out.println(Stats.max(5,6));

	// Should produce 6.9 as the answer
	System.out.println(Stats.max(6.9, 6.8));

	// Should produce 10 as the answer
	System.out.println(Stats.max(6, 10, 7));

	// Should produce 11.9 as the answer
	System.out.println(Stats.max(6.9, 10.5, 11.9));

	// Should produce 6 as the answer
	System.out.println(Stats.geoMean(4, 9));

	// Should produce ~7.98 as the answer
	System.out.println(Stats.geoMean(9.8, 6.5));

	// Should produce ~4 as the answer 
	System.out.println(Stats.geoMean(2.0, 4.0, 8.0));

	// Should produce 4 as answer, but 3 is outputted. This is due to loss of precision
	System.out.println(Stats.geoMean(2, 4, 8));

	// Should produce 20 as the GCD
	System.out.println(Stats.gcdEW(80, 20));

	// Should produce 25 as the GCD
	System.out.println(Stats.gcdER(25, 100));

	// Should produce 4 as the GCD
	System.out.println(Stats.gcd(80, 244));
    }
}
