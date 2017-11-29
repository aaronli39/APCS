/* Team Aconbay
Aaron Li + Colin Hosking + George Liang 
APCS1 pd08
HW23 -- Etterbay Odingcay Oughthray Ollaborationcay 
2017-10-26
*/

/***
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 ***/

public class Pig {
    //Q: How does this initialization make your life easier?
    private static final String VOWELS = "aeiouAEIOU";
    //A: It allows us to use string VOWELS to check if another string has the included vowels "aeiou."
    
    /*=====================================
      boolean hasA(String,String) -- checks for a letter in a String
      pre:  w != null, letter.length() == 1
      post: hasA("cat", "a") -> true
      hasA("cat", "p")       -> false
      =====================================*/
    public static boolean hasA( String w, String letter ) {
	w = w.toLowerCase();
	letter = letter.toLowerCase();
	return (w.indexOf(letter) != -1); // checks if letter is in string w, otherwise it will return -1
    }//end hasA()
   

    /*=====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1
      =====================================*/
    public static boolean isAVowel( String letter ) {
	letter = letter.toLowerCase();
	return (VOWELS.indexOf(letter) != -1); // if letter is in VOWELS, will return true, otherwise will return -1 which is false
    }
    
    
    /*=====================================
      int countVowels(String) -- counts vowels in a String
      pre:  w != null
      post: countVowels("meatball") -> 3
      =====================================*/
    public static int countVowels( String w ) {
	int count = 0; // initialize vowel counter
	w = w.toLowerCase(); // set w to lowercase 
	for (int len = 0; len < w.length(); len++) { // for loop that iterates through each character, and adds one to count if the iterated character is a vowel
	    if (isAVowel(w.substring(len, len + 1))) {
		count += 1;
	    } 
	}
	return count; // return count
    }
    
    
    /*=====================================
      boolean hasAVowel(String) -- tells whether a String has a vowel
      pre:  w != null
      post: hasAVowel("cat") -> true
      hasAVowel("zzz")       -> false
      =====================================*/
    public static boolean hasAVowel( String w ) {
	return (countVowels(w) != 0); // if the count of vowels in w is not zero, that means there are vowels
    }
    
    
    /*=====================================
      String allVowels(String) -- returns vowels in a String
      pre:  w != null
      post: allVowels("meatball") -> "eaa"
      =====================================*/
    public static String allVowels( String w ) {
	String out = ""; // this is the output string
	if (hasAVowel(w)) { // if w has at least one vowel, then initiate for loop, else return a message saying no vowels
	    for (int count = 0; count < w.length(); count++) {
		if (isAVowel(w.substring(count, count + 1))) { // iterate each string character and tests if it's a vowel
		    out += w.substring(count, count + 1); // if it is a vowel, add it to out
		} 
	    }
	} else {
	    return " ";
	} return out; // return result
    }

    /*=====================================
      pre: w != null
      post: firstVowel("") --> ""
      firstVowel("zzz") --> ""
      firstVowel("meatball") --> "e"
      =====================================*/
    public static String firstVowel(String w) {
	if (hasAVowel(w)) {
	    return (allVowels(w).substring(0,1));
	} 
	return "";
	
    }

     /* =====================================
	pre: w != null and w.length() > 0
	post: beginsWithVowel("apple")  --> true
	beginsWithVowel("strong") --> false
     ===================================== */ 
    public static boolean beginsWithVowel(String w) {
	return (VOWELS.indexOf(w.substring(0,1)) != -1);
    }

    /* =====================================
    pre: w != null and w.length() > 0
    post: beginsWithVowel("apple")  --> true
    beginsWithVowel("strong") --> false
     ===================================== */ 
    public static String engToPig(String w) {
	return "";
    }

    // MAIN METHOD TESTS EACH METHOD
    public static void main( String[] args ) {
	System.out.println("========== hasA testing ==========");

	System.out.println(hasA("cat", "a")); //expected: true
	System.out.println(hasA("cat", "p")); //expected: false
	System.out.println(hasA("abcde", "")); //expected: true
      
	System.out.println("========== isAVowel testing ==========");

	System.out.println(isAVowel("e")); //expected: true
	System.out.println(isAVowel("f")); //expected: false
     
	System.out.println("========== countVowels testing ==========");

	System.out.println(countVowels("meatball")); //expected: 3
	System.out.println(countVowels("aeiou")); //expected: 5
	System.out.println(countVowels("xxxxx")); //expected: 0
	System.out.println(countVowels("")); //expected: 0
	
	System.out.println("========== hasAVowel testing ==========");
	
	System.out.println(hasAVowel("cat")); //expected: true
	System.out.println(hasAVowel("zzz")); //expected: false
	System.out.println(hasAVowel("")); //expected: false
	
	System.out.println("========== allVowels testing ==========");
	
	System.out.println(allVowels("meatball")); //expected: "eaa"
	System.out.println(allVowels("zzz")); //expected: ""
	System.out.println(allVowels("")); //expected: ""

      	System.out.println("========== firstVowel testing ==========");

	System.out.println(firstVowel("meatball")); //expected: "e"
	System.out.println(firstVowel("zzz")); //expected: ""
	System.out.println(firstVowel("")); //expected: ""

	System.out.println("========== beginsWithVowel testing ==========");

     	System.out.println(beginsWithVowel("strong")); //expected false
	System.out.println(beginsWithVowel("apple")); //expected true


	
    }//end main()
}//end class Pig
