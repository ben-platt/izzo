//Izzo(Hasif Ahmed, Ben Platt, Sophia Xia)
// APCS2 pd1
// Lab03
// 2018-05-15
import java.util.ArrayList;
import java.lang.Integer;

public class ALHeapMax
{

  //instance vars
  private ArrayList<Integer> _heap;

  /*****************************************************
   * default constructor  ---  inits empty heap
   *****************************************************/
  public ALHeapMax()
  {
      _heap = new ArrayList<Integer>();
  }

  /*****************************************************
   * toString()  ---  overrides inherited method
   * Returns either
   * a) a level-order traversal of the tree (simple version)
   * b) ASCII representation of the tree (more complicated, more fun)
   *****************************************************/
  public String toString()
  {
      if (isEmpty())
	  return null;
      String ret= "" + _heap.get(0);
      for( int i = 1; i < _heap.size(); i++ ) {
	  ret += " - " + _heap.get(i);
      }
      return ret;
  }//O(n)


  /*****************************************************
   * boolean isEmpty()
   * Returns true if no meaningful elements in heap, false otherwise
   *****************************************************/
  public boolean isEmpty()
  {
      int i = 0;
      while ( i < _heap.size() ) {
	  if ( _heap.get(i) != null ) {
	      return false;
	  }
      }
      return true;
  }//O(n)


  /*****************************************************
   * Integer peekMax()
   * Returns max value in heap
   * Postcondition: Heap remains unchanged.
   *****************************************************/
  public Integer peekMax()
  {
      if(_heap.size() <= 0){
        return null;
      }
      else{
        return _heap.get(0);
      }
  }//O(1)


    // KAYLI CHANGE THIS LATER
  /*****************************************************
   * add(Integer)
   * Inserts an element in the heap
   * Postcondition: Tree exhibits heap property.
     First, add new value to ArrayList. Then keep swapping that value with its parent if it is larger than that parent.
   *****************************************************/
   public void add( Integer addVal )
   {


     _heap.add( addVal ); //add at end

     int Pos = _heap.size() - 1; //position of added value
     int parent; //position of parent

     while( Pos > 0 ) { //swap to root

       parent= (Pos-1) / 2;

       if ( addVal.compareTo(_heap.get(parent)) > 0 ) {//parent is greater
         swap( Pos, parent ); //swap values at the positions
         Pos = parent; //pos is now parents position
       }
       else {
       break; //leave loop
     }
     }

   }//O(log n)


    // KAYLI CHANGE THIS LATER
  /*****************************************************
   * removeMax()  ---  means of removing an element from heap
   * Removes and returns greatest element in heap.
   * Postcondition: Tree maintains heap property.
   First, store first element as temp variable. Next, remove last element and set the first element as the last element's value.
   Keep swapping the newly set element with its largest child until it has no children left.
   *****************************************************/
  public Integer removeMax()
  {
      if (isEmpty())
	  return null;
      else if (_heap.size() == 1)
	  return _heap.remove(0);
      Integer max = peekMax();
      Integer last = _heap.remove(_heap.size() - 1);
      _heap.set(0, last);
      maxHeapify(0);
      return max;
  }//O(log n)


  /*****************************************************
   * minChildPos(int)  ---  helper fxn for removeMin()
   * Returns index of least child, or
   * -1 if no children, or if input pos is not in ArrayList
   * Postcondition: Tree unchanged
   *****************************************************/
  private int maxChildPos( int pos )
  {
      if ( ( 2*pos+1 > _heap.size() - 1 ||  (2*pos+2) > _heap.size() - 1 ) || pos > _heap.size() - 1 || pos < 0 ) {
	  return -1;
      }
      else if ( _heap.get(2*pos+1) < _heap.get(2*pos+2) ) {
	  return 2*pos+2;
      }
      else {
	  return 2*pos+1;
      }
  }//O(1)

    private void maxHeapify(int pos){
	int maxChild = maxChildPos(pos);
	if (maxChild != -1){
	    swap(pos, maxChild);
	    maxHeapify(maxChild);
	}
    }
  //************ aux helper fxns ***************
  private Integer maxOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) > 0 )
	    return a;
    else
	    return b;
  }

  //swap for an ArrayList
  private void swap( int pos1, int pos2 )
  {
    _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );
  }

  public int size(){
    return _heap.size();
  }
  //********************************************



  //main method for testing
  public static void main( String[] args )
  {
      ALHeapMax pile = new ALHeapMax();

      pile.add(2);
      System.out.println(pile);
      pile.add(4);
      System.out.println(pile);
      pile.add(6);
      System.out.println(pile);
      pile.add(8);
      System.out.println(pile);
      pile.add(10);
      System.out.println(pile);
      pile.add(1);
      System.out.println(pile);
      pile.add(3);
      System.out.println(pile);
      pile.add(5);
      System.out.println(pile);
      pile.add(7);
      System.out.println(pile);
      pile.add(9);
      System.out.println(pile);

      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
  }//end main()

}//end class ALHeap
