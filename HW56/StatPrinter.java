// Aaron Li
// APCS1 pd8
// HW56 -- His Toe Grammar
// 2017-12-18

/*====================================================================
  An AP-style question, for practice:
  Write the StatPrinter class below. The StatPrinter Object receives an
  ArrayList of nonnegative integers, then builds a frequency ArrayList in which
  the index values are the data and the entry at the index is the frequency.
  For example, if the received data is    2,3,2,5,1,3    then the frequency
  list would be [0,1,2,2,0,1]. This is read as 0 zeroes, 1 one, 2 twos,
  2 threes, 0 fours, 1 five. The size of the frequency list is the equal to
  the maximum value of the data.

  A capability of the class is to calculate local modes from the frequency
  list. A local mode is a value that is greater than the value at index-1
  and greater than the value at index+1. A local mode is never at the end
  points of the list. For example, if the frequency list is [1,2,1,4,2,3,5]
  then the local modes are 2 and 4.

  This class is also capable of printing a histogram of the frequencies, using
  '*'s to indicate a frequency amount. To print a histogram, the user specifies
  the longest sequence of '*'s used and then all other values are printed in
  proportion to this value. For example, if longest bar is 10 and the frequency
  list is [1,2,1,4,2,3,5] then the histogram printed looks like this:

  0 : **
  1 : ****
  2 : **
  3 : ********
  4 : ****
  5 : ******
  6 : **********

  For each method, state run time efficiency using Big O notation.

  Tips for Awesome:
  * Keys to Success are so named for a reason.
  * Look over all fxns, think a bit, decide which to tackle first.
  ( Simplest?  Prerequisites? . . . )
  * Develop 1 fxn at a time, test it, then move to next.
  * For coding today, what extra code do you need to get past compiler?
  ====================================================================*/

import java.util.ArrayList;


public class StatPrinter {

    // instance variable for frequencies of each integer in input ArrayList
    private ArrayList <Integer> _frequency;


    //*************** QUESTION 02 **************************
    //precond:  data.size() > 0, each entry b/t 0,100 inclusive
    //postcond: _frequency.size() set to max(data) + 1
    //          _frequency.get(i) returns frequency of i in data
    //eg, for data [2,3,2,5,2,3]
    //  _frequency would be [0,0,3,2,0,1]
    public StatPrinter( ArrayList <Integer> data )
    {
      // initialize frequency
      _frequency = new ArrayList<Integer>();
      // counter to count occurences of each index
      int counter = 0;
      // for loop iterates max + 1 times
      for (int i = 0; i < max(data) + 1; i++) {
        counter = 0; // reset counter
        for (Integer num : data) { // use for each loop to gaurantee each element is iterated
          if (i == num) { // if equal, add 1 to counter
            counter ++;
          }
        } _frequency.add(counter);
      }
    }


    //*************** QUESTION 01 **************************
    //precond:  data.size() > 0
    //postcond: returns largest integer in data
    public Integer max( ArrayList <Integer> data )
    {
      // store return value
      int x = 0;
      // for loop to iterate through data
      for (int i = 0; i < data.size() - 1; i++) {
        if (data.get(i) > x) { // if value at index is larger than x, replace x
          x = data.get(i);
        }
      } return x;
    }


    //*************** QUESTION 03 **************************
    //postcond: returns true if i > 0 and i < _frequency.size() - 1
    //          and _frequency.get( i - 1 ) < _frequency.get( i )
    //          and _frequency.get( i + 1 ) < _frequency.get( i )
    //          Otherwise, returns false
    //eg, for _frequency [1,2,1,5,5,8,2,4]
    //    2 and 8 are local modes, so
    //    isLocalMode(0) -> false
    //    isLocalMode(1) -> true
    //    isLocalMode(5) -> true
    public boolean isLocalMode( int i )
    {
      // first conditional checks if input is out of bounds
      if (i > 0 && i < _frequency.size() - 1) {
        // second conditional checks if value at index +- 1 is smaller than current
        if (_frequency.get(i - 1) < _frequency.get(i) && _frequency.get(i + 1) < _frequency.get(i)) {
          return true;
        } else {
          return false;
        }
      } return false;
    }



    //*************** QUESTION 04 **************************
    //postcond: returns list of modes in _frequency
    public ArrayList<Integer> getLocalModes()
    {
      // ArrayList out to store output
      ArrayList<Integer> out = new ArrayList<Integer>();
      // for loop to check for modes
      for (int i = 0; i < _frequency.size(); i++) {
        if (isLocalMode(i) == true) {
          out.add(i);
        }
      } return out;
    }


    //*************** QUESTION 05 **************************
    //precond:  longestBar > 0
    public void printHistogram( int longestBar )
    {
      // this is the ratio of input to max
      int ratio = longestBar / max(_frequency);
      // output string to SOP
      String out = "";
      // for loop to iterate each index
      for (int i = 0; i < _frequency.size(); i++) {
        out += "\n" + i + " : ";
        // addes proportional number of astericks
        for (int x = 0; x < (_frequency.get(i) * ratio); x++) {
          out += "*";
        } System.out.println(out);
        out = ""; // reset string
      }
    }

}//end class StatPrinter
