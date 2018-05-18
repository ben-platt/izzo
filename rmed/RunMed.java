//Izzo(Hasif Ahmed, Ben Platt, Sophia Xia)
// APCS2 pd1
// Lab03
// 2018-05-15
/* algorith
first: add streaming numbers to the heaps: min and max
- if the heaps are empty || newVal is greater than max heap root -> add to max heap
- else: add to min heap
second: balance the heaps by controlling the difference in size between the heaps
third: return median
- if equal in size, root of each heap average is median
-one one stored valye, root of max
-if min heap has bigger size, return its root
- else return root of max heap
*/
import java.util.NoSuchElementException;
public class RunMed{
  //instance vars
  private ALHeapMax bigVals;
  private ALHeapMin lilVals;

  //default constructor
  public RunMed(){
    bigVals = new ALHeapMax();
    lilVals = new ALHeapMin();
  }


  /*****************************************************
  * double getMedian()
  * Returns running median
  *****************************************************/
  public double getMedian(){
    if(bigVals.size() == 0 && lilVals.size() == 0 ){ //heaps are empty or value is less -> bigvals
      throw new NoSuchElementException();
    }
    else if(lilVals.isEmpty()){  //if one side is empty
      return bigVals.peekMax();
    }

    if(bigVals.size() == lilVals.size()){ // same size arrays means average the roots
      return ((bigVals.peekMax() + lilVals.peekMin()) / 2.0);
    }
    else if (lilVals.size() > bigVals.size()){  //if lilvals bigger size, return min
      return lilVals.peekMin();
    }
    else{
      return bigVals.peekMax(); //if bigvals bigger size, return max
    }

  }

  /*******************************************************
  * void add(int newVal)
  * Adds to the heaps
  ********************************************************/
  public void add(Integer newVal){
    if(bigVals.size() == 0 && lilVals.size() == 0 ){
      bigVals.add(newVal); //adding to the upper half
    }
    else if (newVal <= getMedian()){
	    bigVals.add(newVal); // upper half
	}
	else if (newVal  > getMedian()){
	    lilVals.add(newVal); //lpwer half
	}

	if (bigVals.size() - lilVals.size() > 1){ //if difference is 2 or greater
	    lilVals.add( bigVals.removeMax() ); //move one to another
	}
	else if (lilVals.size() - bigVals.size() > 1){ //if difference is 2 or greater
	    bigVals.add( lilVals.removeMin() ); //move one to another
	}
    }
  public static void main( String[] args) {
  }
}
