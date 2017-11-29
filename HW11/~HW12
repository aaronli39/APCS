/* 
<Aaron> <Li>
APCS1 pd<8>
HW<12> -- <sTatiscally sPeaking>
<2000>-<10>-<05>
*/

public class Stats {
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
	return (int) Math.pow((a * b * c), (1.0/3.0));
    }
    
    // Calculate the geometric mean of two floating point numbers
    public static double geoMean(double a, double b) {
	return Math.sqrt(a * b);
    }

    // Calculate the geometric mean of three floating point numbers
    public static double geoMean(double a, double b, double c) {
	return Math.pow((a * b * c), (1.0 / 3.0));
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

	// Shoud produce 6.9 as the answer
	System.out.println(Stats.max(6.9,6.8));

	// Should produce 10 as the answer
	System.out.println(Stats.max(6,10,7));

	// Should produce 11.9 as the answer
	System.out.println(Stats.max(6.9,10.5,11.9));

	// Should produce 6 as the answer
	System.out.println(Stats.geoMean(4,9));

	// Should produce ~7.98 as the answer
	System.out.println(Stats.geoMean(9.8,6.5));

	// Should produce ~4 as the answer 
	System.out.println(Stats.geoMean(2.0, 4.0, 8.0));

	// Should produce 4 as answer, but 3 is outputted. This is due to loss of precision
	System.out.println(Stats.geoMean(2, 4, 8));
    }
}
