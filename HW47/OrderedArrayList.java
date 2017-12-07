// Aaron Li
// APCS1 pd8
// HW47 -- ascending
// 2017-12-05

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

  // toString to print ArrayList
  public String toString()
  {
    return this._data.toString();
  }

  // Removes comparable at index
  public Comparable remove( int index )
  {
    Comparable temp = this.get(index);
    this._data.remove(index);
    return temp;
  }

  // get the size of the ArrayList
  public int size()
  {
    return this._data.size();
  }

  // Get the comparable at the specified index
  public Comparable get( int index )
  {
    return this._data.get(index);
  }

  // Hardcoded sort method
  public ArrayList<Comparable> sort(ArrayList<Comparable> input) {
    Comparable temp = 0;
    for (int x = 0; x < input.size(); x++) {
      for (int i = 1; i < input.size(); i++) {
        if (((input.get(i - 1).compareTo(input.get(i))) > 0)) {
          temp = input.get(i - 1);
          input.set(i - 1, input.get(i));
          input.set(i, temp);
          System.out.println(_data);
        }
      }
    } return _data;
  }

  // New add method adds the value
  // at the end then sorts it
  public void add(Comparable newVal)
  {
    _data.add(newVal);
    _data = sort(_data);
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
    for( int i=0; i<Franz.size()-1; i++ ) {
      System.out.println("at i: " + Franz.get(i) );
      if ( Franz.get(i).compareTo(Franz.get(i+1)) > 0 ) {
        System.out.println( " *** NOT sorted *** " );
        break;
      }
    }

  }//end main()

}//end class OrderedArrayList
