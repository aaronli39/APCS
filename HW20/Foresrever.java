/* 

<Aaron> <Li>
APCS 1 pd<8>
HW<20> -- <For the Love of Strings>
<2017>--<10>--<19>

*/

public class Foresrever {
    // Creates string representation of a fence with a non-negative int input. Employs for loop
    public static String fenceF(int posts) {
	String fence = "|"; // Fence will be built left to right so the first post must be pre-set
	for (int counter = 2; counter <= posts; counter++) { // Counter starts at 2 because there is already one post pre-set in String fence
	    fence += "--|"; // Add on to previous post each time
	}
	return fence;
    }

    // Returns a reversed string input with for loop
    public static String reverseF(String s) {
	String reverse = ""; // Store output string
	for (int counter = s.length() - 1; reverse.length() < s.length(); counter--) { // Loop will add last letter of string s to string reverse until they are same length 
	    reverse += s.substring(counter, counter + 1); // Adding last character to reverse
	}
	return reverse; // Return reverse
    }

    // Returns a reversed string input with recursion loop
    public static String reverseR(String s) {
	int len = s.length() - 1; // Shortcut 
	if (len + 1 == 0) { // When length of string s is 0, it means all characters are added already, so return empty string
	    return "";
	} return s.substring(len) + reverseR(s.substring(0, len)); // The last character will keep being added while the length of string s gets shorter each loop
    }
    
    // Main method for testing methods
    public static void main(String[] args) {
	// Should return 10 post fence
	System.out.println(fenceF(10));

	// Should return "stressed" 
	System.out.println(reverseF("desserts"));

	// Should return "stressed" 
	System.out.println(reverseR("desserts"));
    }
}
	    
