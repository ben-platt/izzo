/*Izzo(bPlatt, hAhmed, sXia)

APCS2 pd1

HW46 -- Arrr, There Be Priorities Here Matey

2018-05-09
*/
import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue{
    //ArrayList
    private ArrayList<String> bigBoy = new ArrayList<String>();
    
    public boolean isEmpty() {
	return bigBoy.size() == 0;
    }
    
    public void add(String xxxTentacion) {
	bigBoy.add(xxxTentacion);
    }
    
    public String removeMin() {
      int index = 0;
      int place = 0;
      String smol = bigBoy.get(0);
      for(String bean : bigBoy) {
	  if(bean.compareTo(smol) < 0) {
	      smol = bean;
	      index = place;
	  }
	  place++;
	}
      return bigBoy.remove(index);
    }
    
    public String peekMin() {
	String smol = bigBoy.get(0);
	for(String bean : bigBoy) {
	    if(bean.compareTo(smol) < 0) {
		smol = bean;
	    }
	}
	return smol;
    }
    
    //tests methods
    public static void main(String[] args){
	PriorityQueue test = new ArrayPriorityQueue();
	//testing isEmpty
	System.out.println("Is empty? " + test.isEmpty()); //true
	//testing add
	test.add("foo");
	test.add("goo");
	test.add("boo");
	test.add("hoo");
	test.add("doo");
	//testing isEmpty
	System.out.println("Is empty? " + test.isEmpty()); //false
	System.out.println(test.peekMin()); //boo
	System.out.println(test.removeMin());
	System.out.println(test.peekMin()); //doo
	System.out.println(test.removeMin());
    }
}
	    
