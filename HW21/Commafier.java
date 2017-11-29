/*
<Aaron> <Li>
APCS1 pd<8>
HW<21> -- <Karmacomma>
<2017>-<10>-<23>
*/

public class Commafier { // class
    public static String commafyF(int x) { // method for commafying using iteration
	String input = Integer.toString(x); // converts int to string to iterate
	String output = ""; // this will be the output
	if (input.length() <= 3) { // if any integer(or string now) is 3 digits or less, just return it
	    return input;
	} else {
	    if ((input.length() % 3) == 0) { // if the input is evenly divisible by 3,(e.g 9 digit numbers or 6 digit numbers) it will have a diff method than if it wasn't evenly divisible
		output = input.substring(0, 3); // the output is set to the first 3 digits of the number (this is so there won't be extra commas at the end)
		input = input.substring(3); // the new input becomes the previous input minus the beginning 3 digits
		for (int jump = ((input.length() / 3)); jump > 0; jump--) { // for loop to add a comma and 3 number digits a set number of times determined by its divisibility
		    output += "," + input.substring(0, 3);
		    input = input.substring(3);
		}
	    } else { // this is if the input is not evenly divisible by 3(e.g 5 digit numbers or 8 digit numbers)
		output = input.substring(0, (input.length() % 3)); // the first 1 or 2 digits have to be separated from the rest, which is separatable by 3s
		input = input.substring(input.length() % 3); // the new input is the previous input minus the beginning extra digits
		for (int hop = (input.length() / 3); hop > 0; hop--) { // for loop to add comma and 3 number digits to the beginning extra digits a set number of times
		    output += "," + input.substring(0, 3);
		    input = input.substring(3);
		}
	    }
	}
	return output; // returns result
    }

    public static String commafyR(int x) { // method for commafying using recursion
	String first = Integer.toString(x); // must convert int to string
	if (first.length() <= 3) { // base case: if input becomes or is 3 digits or lower, return it
	    return first;
	} else if ((first.length() % 3) == 0) { // if input is evenly divisble by 3, return first 3 digits, a comma and recall the method using a new input without the first 3 digits
	    return (first.substring(0, 3) + "," + commafyR(Integer.parseInt(first.substring(3))));
	} else { // if input isn't evenly divisble at first by 3, return first 1 or 2 extra digits plus a comma and recall the method with new input without first few digits
	    return (first.substring(0, first.length() % 3) + "," + commafyR(Integer.parseInt(first.substring(first.length() % 3))));
	}
    }

    public static void main(String[] args) {
	/* THESE ARE TEST CASES FOR ITERATING COMMAFYING

	System.out.println(commafyF(1)); // should return 1
	System.out.println(commafyF(10)); // should return 10
	System.out.println(commafyF(101)); // should return 101
	System.out.println(commafyF(1000)); // should return 1,000
	System.out.println(commafyF(12345)); // should return 12,345
 
	*/
	
	/* THESE ARE TEST CASES FOR RECURSIVELY COMMAFYING 

	System.out.println(commafyR(1)); // should return 1
	System.out.println(commafyR(10)); // should return 10
	System.out.println(commafyR(101)); // should return 101
	System.out.println(commafyR(1000)); // should return 1,000, but is missing the ending zeroes
	System.out.println(commafyR(12345)); // should return 12,345
	
	*/
	
	for (String s: args) {
	    System.out.println(commafyR(Integer.parseInt(s)));
	}
    }
}
