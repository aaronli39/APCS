// Aaron Li
// APCS1 pd8
// HW48 -- Keep Guessing
// 2017-12-06

/*==================================================
  class GuessNumber -- fun fun fun!

  eg, sample interaction with end user:
  Guess a # fr 1-100: 50
  Too high
  Guess a # fr 1-49: 25
  Too low
  Guess a # fr 26-49: 38
  Correct! It took 3 guesses
  ==================================================*/

import cs1.Keyboard;

public class GuessNumber
{
    //instance vars
    private int _lo, _hi, _guessCtr, _target;


    /*==================================================
      constructor -- initializes a guess-a-number game
      pre:
      post: _lo is lower bound, _hi is upper bound,
      _guessCtr is 1, _target is random int on range [_lo,_hi]
      ==================================================*/
    public GuessNumber( int a, int b )
    {
	_guessCtr = 1; // Guess counter is initialized to 1
	_lo = a; // Lower bound set to input a
	_hi = b; // Upper bound set to input b
	// A random int between lower and upper bounds
	_target = (int) ((Math.random() * _hi) + _lo);
    }

    /*==================================================
      void playRec() -- Prompts a user to guess until guess is correct.
      Uses recursion.
      pre:
      post:
      ==================================================*/
    public void playRec()
    {
	// Makes new instance of Keyboard
	Keyboard key = new Keyboard();
	// Add one to the counter b/c there is going to be a guess
	_guessCtr += 1;
	// Print user dialogue
	System.out.print("========================================\nGuess a number from " + _lo + "-" + _hi + ": ");

	// int input is set to the user input for code usage
	int input = key.readInt();
	// Safety user dialogue to prompt the user to try another input if theirs
	// is out of bounds
	if (input > _hi || input < _lo) {
	    System.out.println("\nYou have entered an unreasonable number. Try something closer...\n");
	    System.out.println("Guess a number from " + _lo + "-" + _hi + ": ");
	    playRec();
	}
	// If user makes a valid input, then check if the input is > secret int
	// If it is, set _hi to one smaller than the input to guess
	else if (input > _target ) {
	    _hi = input - 1;
	    System.out.println("\nToo high, try again...\n");
	    playRec();
	}
	// If user makes an input less than the secret int, change
	// _lo to one larger for user to guess
	else if (input < _target) {
	    _lo = input + 1;
	    System.out.println("\nToo low, try again...\n");
	    playRec();
	}
	// When the user finally gets the right number, output success message
	else if (input == _target) {
	    System.out.println("\nCorrect! It took you " + _guessCtr + " guesses.");
	}
    }


    /*==================================================
      void playIter() -- Prompts a user to guess until guess is correct.
      Uses iteration.
      pre:
      post:
      ==================================================*/
    public void playIter()
    {
	// Instance of Keyboard
	Keyboard key = new Keyboard();
	// Prompts the first user dialogue
	System.out.print("\nGuess a number from " + _lo + "-" + _hi + ": ");
	// int input stores user inputs
	int input = 0;
	// While loop to iterate
	while (input != _target) {
	    // Set input to the current user input
	    input = key.readInt();
	    // Safety check: if input is out of bounds, tell user to input something
	    // closer to bounds
	    if (input > _hi || input < _lo) {
		System.out.println("\nYou have entered an unreasonable number. Try something closer...\n");
		playIter();
	    }
	    // If input is larger than secret int, lower the upper range
	    else if (input > _target) {
		_hi = input - 1;
		System.out.println("Too high, try again...\n\n");
		System.out.print("Guess a number from " + _lo + "-" + _hi + ": ");
		_guessCtr += 1;
	    }
	    // If input is smaller than secret int, increment the lower range
	    else if (input < _target) {
		_lo = input + 1;
		System.out.println("Too low, try again...\n\n");
		System.out.print("Guess a number from " + _lo + "-" + _hi + ": ");
		_guessCtr += 1;
	    }
	}
	// If user makes successful guess, output success dialogue
	System.out.println("Correct! It took you " + _guessCtr + " guesses.");
    }


<<<<<<< HEAD
  //wrapper for playRec/playIter to simplify calling
  public void play()
  {
    playIter();
  }
=======

    //wrapper for playRec/playIter to simplify calling
    public void play()
    {
	playIter();
    }
>>>>>>> 51649e049c40674c391c00d602bc199cd915cc30


    //main method to run it all
    public static void main( String[] args )
    {

	//instantiate a new game
	GuessNumber g = new GuessNumber(1,100);

	System.out.println("========== WELCOME TO NUMBER GUESSER ==========\n\n");
	//start the game
	g.play();

    }//end main

}//end class
