/*****************************************************
 * class ALHeap
 * SKELETON
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALHeap
{

    //instance vars
    private ArrayList<Integer> _heap; 

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeap() 
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
	String str = "";
	for(Integer e: _heap){
	    //str = str + e + "\t";
	    System.out.print(e + "\t");
	}
	return str;
    }//O(?)


    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty()
    {
	return _heap.size() == 0;
    }//O(?)


    /*****************************************************
     * Integer peekMin()
     * Returns min value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Integer peekMin()
    {
	return _heap.get(0);
    }//O(?)


    /*****************************************************
     * add(Integer) 
     * Inserts an element in the heap
     * Postcondition: Tree exhibits heap property.
     *****************************************************/
    public void add( Integer addVal )
    {
	_heap.add(addVal);
	//compare to parent and swap until in the right position
	int sInd = _heap.size() -1;
	for(int i = _heap.size() -1; i > 0;){
	    //if int at sInd is smaller than the parent, swap
	    if(_heap.get(sInd) < _heap.get(i)){
		swap(sInd, i);
		//and set sInd to the parent ind
		sInd = i;
	    }
	    else{
		return;
	    }
	    //change i to the next parent according to sInd
	    if(sInd % 2 == 0){
		i = sInd/2 -1;
	    }
	    else{
		i = sInd/2;
	    }
	}
    }//O(?)
    
    
    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public Integer removeMin()
    {
	int min = _heap.get(0);
	//replace the first element with the last element of the heap and remove the last element
	_heap.set(0, _heap.get(minChildPos(0)));
	_heap.remove(minChildPos(0));
	//compare to children and swap until in the correct position
	int sInd = 0;
	for(int i = 0; i < _heap.size() -1;){
	    //if LChild is smaller than RChild or LChild equals RChild
	    if(_heap.get(i) <= _heap.get(i +1)){
		//swap sInd with LChild and set sInd to current pos
		swap(sInd, i);
		sInd = i;
	    }
	    //if RChild is smaller than LChild
	    else if(_heap.get(i) > _heap.get(i +1)){
		//swap sInd with RChild and set sInd to current pos
		swap(sInd, i+1);
		sInd = i +1;
	    }
	    //set i to LChild of sInd(RChild = LChild + 1)
	    i = 2*(i +1) -1;
	}
	return min;
    }//O(?)


    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or 
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    private int minChildPos( int pos )
    {
	int LChild = 2*(pos +1) -1;
	int RChild = 2*(pos +1);
	
	//if only one child
	if(LChild < _heap.size() -1 && RChild > _heap.size() -1){
	    //return child position
	    return LChild;
	}
	//if two children
	if(LChild < _heap.size() -1 && RChild < _heap.size() -1){
	    return minChildPos(RChild);
	}
	return -1;
    }//O(?)
  

    //************ aux helper fxns ***************
    private Integer minOf( Integer a, Integer b )
    {
	if ( a.compareTo(b) < 0 )
	    return a;
	else
	    return b;
    }

    //swap for an ArrayList
    private void swap( int pos1, int pos2 )
    {
	_heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
    }
    //********************************************



    //main method for testing
    public static void main( String[] args )
    {
	  ALHeap pile = new ALHeap();

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

	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class ALHeap
