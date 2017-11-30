// TEAM Auto-Indent
// Aaron Li, Johnny Wong
// APCS1 pd8
// HW42 -- Array of Grade 316
// 2017-11-29

/***************************
* class SuperArray version 2.0
* (SKELETON)
* Wrapper class for array. Facilitates resizing,
* resizing
* expansion
* read/write capability on elements
* adding an element to end of array
* adding an element at specified index
* removing an element at specified index
***************************/

public class SuperArray implements ListInt
{

  private int[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    _data = new int[10];
    _size = 0;
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
    String foo = "[";
    for( int i = 0; i < _size; i++ ) {
      foo += _data[i] + ", ";
    }
    if ( foo.length() > 1 )
    //shave off trailing comma and whitespace
    foo = foo.substring( 0, foo.length() - 2 );
    foo += "]";
    return foo;
  }


  //double capacity of SuperArray
  private void expand()
  {
    int[] temp = new int[ _data.length * 2 ];
    for( int i = 0; i < _data.length; i++ )
    temp[i] = _data[i];
    _data = temp;
  }


  //accessor -- return value at specified index
  public int get( int index )
  {
    return _data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal )
  {
    int temp = _data[index];
    _data[index] = newVal;
    return temp;
  }


  //adds an item after the last item
  public void add( int newVal )
  {
    // If # of meaningful items is less than the
    // length of the array:
    if (_size < _data.length) {
      // size is 1: set index 1 to value
      if (_size == 1) {
        set(1, newVal);
        // size is 0: set index 0 to value
      } else if (_size == 0) {
        set(0, newVal);
        // size > 1 but < length of array:
        // set index size to value
      } else {
        set(_size, newVal);
      }
      // if size is bigger than length of array:
      // expand the array, then set index _size
      // to value
    } else if (_size > _data.length) {
      this.expand();
      set(_size, newVal);
    }
    // regardless of which conditional was invoked,
    // size will always increase by 1 b/c one value
    // had been added
    _size += 1;
  }


  //inserts an item at index
  public void add( int index, int newVal )
  {
    // to store next value in array
    int next = 0;
    // store the value that was replaced by newVal
    int temp = _data[index];
    // sets index index to newVal
    _data[index] = newVal;

    // ensures that there is enough room for index
    while (index > _data.length - 1) {
      this.expand();
    }

    // iterate through array to set each index value to
    // preceding value
    for (int i = index + 1; i < _data.length - 1; i++ ) {
      next = _data[i];
      _data[i] = temp;
      temp = next;
    } _size += 1;
  }



  //removes the item at index
  //shifts elements left to fill in newly-empted slot
  public void remove( int index )
  {
    // size decreases by 1 b/c a value was removed
    _size -= 1;

    // iterate through array to set each index value
    // to the succeeding value
    for (int i = index; i < _data.length - 1; i++ ) {
      set(i, get(i + 1));
    } _data[_data.length - 1] = 0;
  }


  //return number of meaningful items in _data
  public int size()
  {
    return _size;
  }



  //main method for testing
  public static void main( String[] args )
  {
    SuperArray curtis = new SuperArray();
    System.out.println( "Printing empty SuperArray curtis..." );
    System.out.println( curtis );

    for( int i = 0; i < curtis._data.length; i++ ) {
      curtis.add( i, i * 2 );
      // changed curtis.set to .add b/c can't distinguish meaningful zeroes
    }

    System.out.println("\nPrinting populated SuperArray curtis...");
    System.out.println(curtis);

    // length should increase while printed array should not change
    for( int i = 0; i < 3; i++ ) {
      curtis.expand();
      System.out.println("\nPrinting expanded SuperArray curtis...");
      System.out.println(curtis);
      System.out.println("\nnew length of underlying array: "
      + curtis._data.length );
    }

    SuperArray mayfield = new SuperArray();
    System.out.println("\nPrinting empty SuperArray mayfield...");
    System.out.println(mayfield);

    // output array should be [5,4,3,2,1]
    mayfield.add(5);
    mayfield.add(4);
    mayfield.add(3);
    mayfield.add(2);
    mayfield.add(1);

    System.out.println("\nPrinting populated SuperArray mayfield...");
    System.out.println(mayfield);

    // removes third index
    mayfield.remove(3);
    System.out.println("\nPrinting SuperArray mayfield post-remove...");
    System.out.println(mayfield);
    // removes third index
    mayfield.remove(3);
    System.out.println("\nPrinting SuperArray mayfield post-remove...");
    System.out.println(mayfield);

    // adds 99 to third index, since size > array length,
    // it will expand then add 99 to the third index
    mayfield.add(3,99);
    System.out.println("\nPrinting SuperArray mayfield post-insert...");
    System.out.println(mayfield);
    // inserts 88 into the second index
    mayfield.add(2,88);
    System.out.println("\nPrinting SuperArray mayfield post-insert...");
    System.out.println(mayfield);
    // inserts 77 into the first index
    mayfield.add(1,77);
    System.out.println("\nPrinting SuperArray mayfield post-insert...");
    System.out.println(mayfield);

  }//end main()


}//end class
