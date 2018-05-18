//Izzo(Hasif Ahmed, Ben Platt, Sophia Xia)
// APCS2 pd1
// Lab03
// 2018-05-15

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
    if(bigVals.size() == 0 && lilVals.size() == 0 || newVal< bigVals.peekMax()){
      bigVals.add(newVal); //adding to the lower half
    }
    else{
      lilVals.add(newVal); // adding to upper half
    }

    //adjusting the heaps
    while(lilVals.size()-bigVals.size() >= 2){

      if(lilVals.size() - bigVals.size() > 0){
        bigVals.add(lilVals.removeMin());
      }
      else{
        lilVals.add(bigVals.removeMax());
      }
    }
  }
}
