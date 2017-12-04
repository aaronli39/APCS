// Aaron Li
// APCS1 pd8
// HW45 -- In America, the Driver Sits on the Left
// 2017-12-02

/***************************
* class SuperArray version 3.0
* Wrapper class for array. Facilitates resizing,
* resizing
* expansion
* read/write capability on elements
* adding an element to end of array
* adding an element at specified index
* removing an element at specified index
*
* ...and now SuperArray complies with the specifications of the
* ListInt interface. (ListInt.java must be in same dir as this file)
***************************/

public class SuperArray implements List
{
  private Object[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    _data = new Object[10];
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
    //shave off trailing comma
    foo = foo.substring( 0, foo.length()-2 );
    foo += "]";
    return foo;
  }


  //double capacity of SuperArray
  private void expand()
  {
    Object[] temp = new Object[ _data.length * 2 ];
    for( int i = 0; i < _data.length; i++ )
    temp[i] = _data[i];
    _data = temp;
  }


  //accessor -- return Object at specified index
  public Object get( int index )
  {
    if (index < 0 || index > _size) {
      throw new java.lang.IndexOutOfBoundsException("Input index is invalid.");
    } else {
      return _data[index];
    }
  }

  //mutator -- set value at index to Object,
  //           return old value at index
  public Object set( int index, Object x )
  {
    if (index < 0 || index > _size) {
      throw new java.lang.IndexOutOfBoundsException("Input index is invalid.");
    } else {
      Object temp = _data[index];
      _data[index] = x;
      return temp;
    }
  }

  //adds an item after the last item
  public boolean add( Object x )
  {
    add( _size, x );
    return true;
  }


  //inserts an item at index
  public void add( int index, Object x )
  {
    if (index < 0 || index > _size) {
      throw new java.lang.IndexOutOfBoundsException("Input index is invalid");
    } else {
      //first expand if necessary
      if ( _size >= _data.length )
      expand();
      for( int i = _size; i > index; i-- ) {
        _data[i] = _data[i-1]; //each slot gets value of left neighbor
      }
      _data[index] = x;
      _size++;
    }
  }

  //removes the item at index
  //shifts elements left to fill in newly-empted slot
  //returns removed value
  public Object remove( int index )
  {
    if (index < 0 || index > _size) {
      throw new java.lang.IndexOutOfBoundsException("Input index is invalid.");
    } else {
      Object retInt = _data[index];
      for( int i = index; i < _size - 1; i++ ) {
        _data[i] = _data[i+1];
      }
      _size--;
      return retInt;
    }
  }


  //return number of meaningful items in _data
  public int size()
  {
    return _size;
  }



  //main method for testing
  //main method uses class Rational to test the functionality of
  //methods with signature (Object x) in their parameters
  public static void main( String[] args )
  {
    List mayfield = new SuperArray();
    Rational springfield = new Rational(5, 10);
    Rational winterfield = new Rational(1, 3);

    System.out.println("Printing empty SuperArray mayfield...");
    System.out.println(mayfield);

    mayfield.add(winterfield);
    mayfield.add(4);
    mayfield.add(springfield);
    mayfield.add(2);
    mayfield.add(1);

    System.out.println("Printing populated SuperArray mayfield...");
    System.out.println(mayfield);

    mayfield.remove(2);
    System.out.println("Printing SuperArray mayfield post-remove...");
    System.out.println(mayfield);
    mayfield.remove(3);
    System.out.println("Printing SuperArray mayfield post-remove...");
    System.out.println(mayfield);

    mayfield.add(3,99);
    System.out.println("Printing SuperArray mayfield post-insert...");
    System.out.println(mayfield);
    mayfield.add(2,88);
    System.out.println("Printing SuperArray mayfield post-insert...");
    System.out.println(mayfield);
    mayfield.add(1,77);
    System.out.println("Printing SuperArray mayfield post-insert...");
    System.out.println(mayfield);

  }//end main()


}//end class


/***
,,########################################,,
.*##############################################*
,*####*:::*########***::::::::**######:::*###########,
.*####:    *#####*.                 :*###,.#######*,####*.
*####:    *#####*                      .###########*  ,####*
.*####:    ,#######,                        ##########*    :####*
*####.    :#########*,                       ,,,,,,,,.      ,####:
####*  ,##############****************:,,               .####*
:####*#####################################**,        *####.
*############################################*,   :####:
.#############################################*,####*
:#####:*****#####################################.
*####:                  .,,,:*****###########,
.*####,                            *######*
.####* :*#######*               ,#####*
*###############*,,,,,,,,::**######,
*##############################:
*####*****##########**#####*
.####*.            :####*
:####*         .#####,
*####:      *####:
.*####,  *####*
:####*####*
*######
*##

-Miranda Chaiken '16

***/
