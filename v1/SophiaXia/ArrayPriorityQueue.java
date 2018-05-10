//Sophia Xia
//APCS2 pd1
//hw46 -- Arrr, There Be Priorities Here Matey . . .
//2018-05-09

import java.util.ArrayList;

public class ArrayPriorityQueue{

    //Instance Variables
    private ArrayList<String> queue;

    //Constructor
    public ArrayPriorityQueue(){
	queue = new ArrayList<String>();
    }

    //Methods
    //add: O(1) runtime unless expand(from ArrayList) is invoked
    public void add(String str){
	queue.add(str);
    }

    //isEmpty
    public boolean isEmpty(){
	return queue.size() == 0;
    }

    //peekMin: O(n) runtime
    public String peekMin(){
	String min = queue.get(0);
	for(int i = 0; i < queue.size() -1; i++){
	    if(queue.get(i).compareTo(min) <= 0){
		min = queue.get(i);
	    }
	}
	return min;
    }

    //peekMin: O(n) runime
    public String removeMin(){
	int min = 0;
	for(int i = 0; i < queue.size() -1; i++){
	    if(queue.get(i).compareTo(queue.get(min)) <= 0){
		min = i;
	    }
	}
	String retStr = queue.get(min);
	queue.remove(min);
	return retStr;
    }

    //Main Method
    public static void main(String[] args){

	ArrayPriorityQueue MMessenger = new ArrayPriorityQueue();
	System.out.println(MMessenger.isEmpty());

	MMessenger.add("Jaehee");
	MMessenger.add("Yoosung");
	MMessenger.add("Saeyoung");
	MMessenger.add("Jumin");
	MMessenger.add("Zen");
	MMessenger.add("V");
	MMessenger.add("Rika");
	MMessenger.add("Saeran");
	MMessenger.add("Vanderwood");
	MMessenger.add("MC");
	
	System.out.println(MMessenger.isEmpty());

	System.out.println(MMessenger.peekMin());
	System.out.println(MMessenger.removeMin());
	System.out.println(MMessenger.peekMin());
	System.out.println(MMessenger.removeMin());
	System.out.println(MMessenger.peekMin());
	System.out.println(MMessenger.removeMin());
	System.out.println(MMessenger.peekMin());
	System.out.println(MMessenger.removeMin());
	System.out.println(MMessenger.peekMin());
	System.out.println(MMessenger.removeMin());
	System.out.println(MMessenger.peekMin());
	System.out.println(MMessenger.removeMin());
	System.out.println(MMessenger.peekMin());
	System.out.println(MMessenger.removeMin());
	System.out.println(MMessenger.peekMin());
	System.out.println(MMessenger.removeMin());
	System.out.println(MMessenger.peekMin());
	System.out.println(MMessenger.removeMin());
	System.out.println(MMessenger.peekMin());
	System.out.println(MMessenger.removeMin());

	System.out.println(MMessenger.isEmpty());
	
    }
}
