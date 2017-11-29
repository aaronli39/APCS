/* 
   Aaron Li
   APCS1 pd8
   HW25 -- All Hallow's Eve
   2017-11-01
*/

public class Loopier { // new class Loopier
    
    public static void populate(int[] nums) { // takes an input array and changes each index to a random integer between 0 inclusive and 10 exclusive
	for (int i = 0; i < nums.length; i ++) { // for loop to iterate
	    nums[i] = (int) (Math.random() * 10); // uses Math function to generate random int between 0 and 10
	} 
    }

    public static String stringify(int[] nums) { // takes input array and returns a stringified version of the array input
	String out = "["; // the beginning of the output will have brackets
	for (int i = 0; i < nums.length; i++) { // for loop to iterate
	    out += nums[i] + ", "; // each number should have a comma to separate them
	}
	return out + "]"; 
    }

    public static int linSearch(int[] a, int target) { // takes input array and a target and returns the index of the first occurence
	int index = 0;
	for (int i = 0; i < a.length; i++) { // for loop to iterate each index
	    if (a[i] == target) { // if a index i is equal to target, return index, else, keep going
		index += i;
		return i;
	    }
	} return -1; // if none of the indexes trigger a return, then return -1 because target not found
    }

    public static int linSearchR(int[] a, int target) { // takes input array and a target and returns index of the first occurence recursively
	if (linSearch(a, target) == -1) { // use iterative linSearch to check if the target is present
	    return -1; 
	} else if(a[0] != target) { // this is the loop: if the first index is not the target, make a shortened array without index 0 and add 1 to keep track of indexes
	    int[] b = new int[a.length - 1];
	    for (int i = 1; i < a.length - 1; i++) {
		b[i - 1] = a[i];
	    } return linSearchR(b, target) + 1;
	} return 0; // if the index is equal to the target, return 0, and add all the preceeding 1s to find the index
    }

    public static int freq(int[] a, int target) { // takes input array and target number and returns the frequency that the number occurs
	int counter = 0; // initialize counter variable to count occurences
	for (int i = 0; i < a.length; i++) { // for loop to iterate
	    if (a[i] == target) { // if sub index is equal to target, add one to counter, keep going until each element has been checked
		counter += 1;
	    }
	} return counter; // return count
    }

    public static int freqRec(int[] a, int target) { // takes input array and target number and return frequency that the number occurs
	if (a.length == 0) { // base case: if array a has no more indexes, return 0 to add
	    return 0;
	} else if(a[0] == target) { // if the first index of array a is the target, create new array b such that all indexes except the first is preserved. Recall method.
	    int[] b = new int[a.length - 1];
	    for (int i = 1; i < a.length - 1; i++) {
		b[i - 1] = a[i];
	    } return freqRec(b, target) + 1; // when recalling add 1 for frequency count
	} else { // if the first index is not equal to the target, make a new shortened array b without the first index
	    int[] b = new int[a.length - 1];
	    for (int i = 1; i < a.length - 1; i++) {
		b[i - 1] = a[i];
	    } return freqRec(b, target);
	}
    }

    // main method to test
    public static void main(String[] args) {
	int[] arr = {1,5,9,4}; // makes a new array with intialized values
	populate(arr); // randomizes each index in the array
      
	System.out.println(arr[3]); // number will vary based on populate

	// All following values are dependent on the populate method 
	System.out.println("========== Stringified Array ==========");
	System.out.println(stringify(arr));

	System.out.println("========== Iterative Linear Search ==========");
	System.out.println(linSearch(arr, -10));
	System.out.println(linSearch(arr, 3));
	
	System.out.println("========== Recursive Linear Search ==========");
	System.out.println(linSearchR(arr, -10));
	System.out.println(linSearchR(arr, 3));

	System.out.println("========== Iterative Frequency ==========");
	System.out.println(freq(arr, -10));
	System.out.println(freq(arr, 3));

	System.out.println("========== Recursive Frequency ==========");
	System.out.println(freqRec(arr, -10));
	System.out.println(freqRec(arr, 3));
    }
} // end of class   
