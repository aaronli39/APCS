// Aaron Li
// APCS1 pd8
// HW49 -- Halving the Halves
// 2017-12-07

/********************************
* class OrderedArrayList
* wrapper class for ArrayList.
* Imposes the restriction that stored items
* must remain sorted in ascending order
********************************/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class OrderedArrayList
{
  // instance of class ArrayList, holding objects of type Comparable
  // (ie, instances of a class that implements interface Comparable)
  private ArrayList<Comparable> _data;


  // default constructor initializes instance variable _data
  public OrderedArrayList()
  {
    _data = new ArrayList<Comparable>();
  }


  public String toString()
  {
    return _data.toString();
  }


  public Comparable remove( int index )
  {
    return _data.remove(index);
  }


  public int size()
  {
    return _data.size();
  }


  public Comparable get( int index )
  {
    return _data.get(index);
  }


  /***
  * add takes as input any comparable object
  * (i.e., any object of a class implementing interface Comparable)
  * inserts newVal at the appropriate index
  * maintains ascending order of elements
  * uses a linear search to find appropriate index
  ***/
  public void add( Comparable newVal )
  {
    for( int p = 0; p < _data.size(); p++ ) {
      if ( newVal.compareTo( _data.get(p) ) < 0 ) {
        //newVal < oal[p]
        _data.add( p, newVal );
        return; //Q:why not break?
      }
    }
    _data.add( newVal ); //newVal > every item in oal, so add to end
  }

  public void addBin(Comparable newVal) {
    int low = 0; // Lower bound
    int high = _data.size() - 1; // Upper bound
    int index = (_data.size() / 2) + 1; // Index for midpoint
    Comparable middle = _data.get(index); // Midpoint Comparable

    // While loop to keep running until lower and upper
    // bounds are <= 1, in which case we can determine the index
    // where we insert the newVal
    while ((high - low) > 1) {
      // After every iteration set midpoint to midpoint index
      middle = _data.get(index);

      // If midpoint and newVal are equal, simply insert at midpoint
      if (middle.equals(newVal)) {
        _data.add(index, newVal);
        return;
      }
      // If newVal is less than midpoint, take away upper half of the range
      if (newVal.compareTo(middle) < 0) {
        high = index;
        index = ((low + high) / 2); // New midpoint
      }
      // If newVal is greater than midpoint, take away lower half of range
      else if (newVal.compareTo(middle) > 0) {
        low = index;
        index = (low + high) / 2;
      }
    }

    // Following code determines to insert from the lower bound
    // or insert from the upper bound. If newVal is the largest Comparable,
    // simply add it to the very end. If it is the smallest, insert it
    // from the lowest bound
    if (newVal.compareTo(_data.get(low)) < 0 && newVal.compareTo(_data.get(high)) < 0) {
      _data.add(low, newVal);
    } else if (newVal.compareTo(_data.get(low)) > 0 && newVal.compareTo(_data.get(high)) > 0) {
      _data.add(newVal);
    } else {
      _data.add(high, newVal);
    }
  }


  // main method solely for testing purposes
  public static void main( String[] args )
  {
    OrderedArrayList Franz = new OrderedArrayList();

    // testing linear search
    for( int i = 0; i < 15; i++ )
    Franz.add( (int)( 50 * Math.random() ) );
    System.out.println( Franz );

    //check for sorted-ness
    //if msg does not appear, list was sorted

    // Try inserting 29 binarily
    Franz.addBin(29);
    System.out.println(Franz);

    // Try inserting 0 binarily
    Franz.addBin(0);
    System.out.println(Franz);

    // Try inserting 50 binarily
    Franz.addBin(50);
    System.out.println(Franz);

  }//end main()

}//end class OrderedArrayList
