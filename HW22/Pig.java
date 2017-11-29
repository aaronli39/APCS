/* Team Aconbay
Aaron Li + Colin Hosking + George Liang 
APCS1 pd08
HW24 -- Imetay Otay Ineshay 
2017-10-29
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
===================================================================
TO DO LIST (ALL COMPLETED)
-------------------------------------------------------------------
$ add the functionality of detecting and working around punctuation  
$ add a method that can translate a whole english sentence into pig latin
$ add method to properly process "qu"
$ add method to properly process letter y

===================================================================
PIG LATIN GENERAL RULES 
-------------------------------------------------------------------
$ If a word starts with a vowel, then add "way" to the end of the word
$ If a word starts with a consonant, then add all subsequent consonants until the first vowel to the end of the word, and add "ay" to the end of the word

===================================================================
PIG LATIN EXTRA RULES
-------------------------------------------------------------------
$ If a word starts with "y" and has other vowels, treat leading y as a consonant
$ If a word has no vowels, but letter y is present, treat it as a vowel
$ If a word has a leading "qu", treat it as one unit
$ If a word has capitalization, the first letter of the translated word must be capitalized
$ If a word has ending hyphens, treat is as normal ending punctuation, if a word has hyphens in it, treat the separated string as two words
$ If a word has multiple leading consonants, they must all be appended to the end of the word

 ***/

/* ====================== Methods Expansion Summary ========================
   All succeeding code requires proper grammar input to ensure flawlessness,
   inputs with incorrect grammar may/will produce errors. The engToPig 
   translator can handle sentences, ending punctuation, hyphens, apostrophes,
   capitalized letters, and correctly process the letter "y." The string "qu"
   is also properly coded to work. 
   ========================================================================= */

import java.util.Scanner;

public class Pig {
    //Q: How does these initializations make your life easier?
    private static final String VOWELS = "aeiouAEIOU";
    private static final String ENDPUNC = ".,;:!?";
    private static final String LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-";
    
    //A: It allows us to use string VOWELS to check if another string has the included vowels "aeiou." It allows us to use string LETTERS to check if another string is a letter by checking for its index in LETTERS. It also allows us to check if end punctuation is present by checking for its index in ENDPUNC.
    
    /*=====================================
      boolean hasA(String,String) -- checks for a letter in a String
      pre:  w != null, letter.length() == 1
      post: hasA("cat", "a") -> true
      hasA("cat", "p")       -> false
      =====================================*/
    public static boolean hasA( String w, String letter ) {
        return (w.indexOf(letter) != -1); // checks if letter is in string w, otherwise it will false
    }//end hasA()
   

    /*=====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1
      =====================================*/
    public static boolean isAVowel( String letter ) {
	return (VOWELS.indexOf(letter) != -1); // if letter is in VOWELS, will return true, otherwise will return false
    }

    /*=====================================
      boolean isALetter(String) -- tells whether a character is a letter
      precondition: letter.length() == 1
      ======================================*/
    public static boolean isALetter(String letter) {
	return (LETTERS.indexOf(letter) != -1); // if letter is in LETTERS, will true true, otherwise will return false
    }
    
    /*=====================================
      int countVowels(String) -- counts vowels in a String
      pre:  w != null
      post: countVowels("meatball") -> 3
      =====================================*/
    public static int countVowels( String w ) {
	int count = 0; // initialize vowel counter
	for (int len = 0; len < w.length(); len++) { // for loop that iterates through each character, and adds one to count if the iterated character is a vowel
	    if (isAVowel(w.substring(len, len + 1))) {
		count += 1;
	    } 
	} return count; // return count
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
	} return "";
    }


     /* =====================================
	pre: w != null and w.length() > 0
	post: beginsWithVowel("apple")  --> true
	beginsWithVowel("strong") --> false
	===================================== */ 
    public static boolean beginsWithVowel(String w) {
	return (VOWELS.indexOf(w.substring(0,1)) != -1);
    }


    public static boolean isEndPunc(String letter){
    	return (ENDPUNC.indexOf(letter) != -1); // if letter is in endPunc, will return true, otherwise will return false
    }
	
    /* =====================================
       pre: w != null and w.length() > 0
       post: engToPig("apple")  --> appleway
       engToPig("java") --> avajay
       ===================================== */
    public static String engToPig(String w) {

	char firstLet = w.charAt(0); //converts 1st letter to char for caps testing
	boolean capital = (Character.isUpperCase(firstLet)); //tests for caps
	String product = ""; // final output
	String lastChar = w.substring(w.length() - 1, w.length()); //last letter
	final boolean punc = isEndPunc(w.substring(w.length() - 1)); //checks for end punc
	String end = ""; //stores ending punctuation

	// If a word has hyphens: this code block deals with it
        if (hasA(w, "-")) { 
	    if (w.indexOf("-") == (w.length() - 1)) { // if word has a hyphen, and the hyphen is the last character, chop it off, apply pig latin rules, then append at the end
		return engToPig(w.substring(0, w.length() - 1)) + w.substring(w.length() - 1); 
	    } return engToPig(w.substring(0,w.indexOf("-"))) + "-" + engToPig(w.substring(w.indexOf("-")+1)); //else: breaks up into two words and feeds them into engtopig
	}
	
	// If a word has end punctuation, this code stores all ending punctuation, and then cuts it off so the main string can be processed 
       	if (punc) { // if there is punctuation
	    int len = 1; // initialize int len to be able to backtrack through string
	    while (! isALetter(w.toLowerCase().substring(w.length() - len, (w.length()- len) + 1))) { // while loop that keeps running until the substring is a letter
		end = w.substring(w.length() - len, (w.length() - len) + 1) + end; // loop appends every end punctuation until it reaches a letter
		len += 1; // increment len so the next letter from the end can be processed
	    } w = w.substring(0, w.length() - len + 1); // after storing all end punctuation, input string w is set to string w without end punctuation
	}
	
	// Actual code for translating a single word from english to pig latin based on general rules 
	if (beginsWithVowel(w)) { // if the first letter of the word is a vowel, then check for end punctuation
	    if (! hasA(lastChar, ENDPUNC)){ // if first letter of a word is a vowel and doesn't have end punctuation, return it plus "way"
		product = (w + "way");
	    } else if (hasA(lastChar,ENDPUNC)){ // if first letter of a word is a vowel and has punctuation, return it plus "way" plus end punctuation
		product = w.substring(0,w.indexOf(lastChar) + 1) + "way" + lastChar; 
	    }
	} else if (countVowels(w) == 0 && (! hasA(w.toLowerCase(), "y"))) { // if word has no vowels nor a letter y, return the input
	    product = w + "ay";
	} else if (countVowels(w) == 0 && (w.substring(0, 1).toLowerCase().equals("y"))) { // if word has no vowels and the first letter is y, treat it as a vowel
	    product = w + "way";
	} else if (countVowels(w) == 0 && (! (w.substring(0, 1).toLowerCase().equals("y"))) && hasA(w.toLowerCase(), "y")) { // if word has no vowels, and y is present but not the first letter, treat it as a vowel
	    product = w.substring(w.toLowerCase().indexOf("y")) + w.substring(0, w.toLowerCase().indexOf("y")) + "ay";
	} else if (countVowels(w) != 0 && (w.substring(0, 1).toLowerCase().equals("y"))) { // if other vowels are present, but y is the first letter, treat it as a consonant
	    product = w.substring(w.toLowerCase().indexOf("y") + 1) + w.substring(0, w.toLowerCase().indexOf("y") + 1) + "ay";
	} else if (countVowels(w) != 0 && hasA(w.toLowerCase(), "y")) { // if other vowels are present and y is present, but not leading, treat y as a vowel
	    product = w.substring(w.toLowerCase().indexOf("y")) + w.substring(0, w.toLowerCase().indexOf("y")) + "ay";
	} else if (w.toLowerCase().substring(0, 1).equals("q") && w.toLowerCase().substring(1, 2).equals("u")) { // if "qu" is the first two letters, treat it as a unit 
	    product = w.substring(w.toLowerCase().indexOf("u") + 1) + w.substring(0, w.toLowerCase().indexOf("u") + 1) + "ay";
	} else if(countVowels(w) > 0) { // if word is not a special case(has letter y or qu) take care of it with normal consonant rules
	    product = (w.substring(w.indexOf(firstVowel(w))) + w.substring(0, (w.indexOf(firstVowel(w)))) + "ay" );
	}

	// after the main string is modified, the following code applies capitalization and punctuation
	if (capital) { // if word was capitalized...
	    product = product.substring(0,1).toUpperCase() + product.substring(1).toLowerCase(); //change the first letter of product to uppercase
	} if (punc) { // if word had punctuation, append all punctuation to the end 
	    product += end;
	} return product;
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

	System.out.println("========== engToPig testing ==========");

	System.out.println(engToPig("java")); //expected: avajay
	System.out.println(engToPig("strong")); //expected: ongstray
	System.out.println(engToPig("apple")); //expected: appleway
	System.out.println(engToPig("coding")); //expected: odingcay

       	System.out.println(engToPig("Coding")); //expected: Odingcay
       	System.out.println(engToPig("Uppercase")); //expected: Uppercaseway
       	System.out.println(engToPig("Dog")); //expected: Ogday
	System.out.println(engToPig("That")); //expected: Atthay
	
	System.out.println(engToPig("Dog-Tail")); //expected: Ogday-Ailtay
        System.out.println(engToPig("meat-balls")); //expected: eatmay-allsbay
	System.out.println(engToPig("hello-")); //expected: ellohay-
	
    	System.out.println(engToPig("Dog's")); //expected: Og'sday
	System.out.println(engToPig("can't")); //expected: an'tcay

	System.out.println(engToPig("done.")); //expected: oneday. 
	System.out.println(engToPig("That?")); //expected: Atthay?
	System.out.println(engToPig("gym")); //expected: ymgay
	System.out.println(engToPig("fly"));//expected: yflay
	System.out.println(engToPig("mystery"));//ecpected: ysterymay
	System.out.println(engToPig("Fly"));//expected: yflay
	System.out.println(engToPig("Ywwht"));//expected: Ywwhtway
	System.out.println(engToPig("ywwht!!"));//expected: ywwhtway!!
	System.out.println(engToPig("Yes!"));//expected: Ywwhtway
	System.out.println(engToPig("quiet")); //expected: ietquay
	System.out.println(engToPig("Quiet")); //expected: Ietquay
	System.out.println(engToPig("quiet!?")); //expected: ietquay!?
	System.out.println(engToPig("qie")); //expected: ieqay 
	System.out.println(engToPig("xD")); //expected: xDay
        
	System.out.println("========== End of Prewritten tests =========");
	System.out.println("========== Start of Command Line Input: input a word to translate, or press C-c to exit ==========");
	
	Scanner sc = new Scanner(System.in); // The scanner accepts input from the command line and prints the translation of each token from the input. 

	while(sc.hasNext()){ // while there is another input, print the translated input
	    System.out.println(engToPig(sc.next()) + "\n");
	}
    }//end main()
}//end class Pig
