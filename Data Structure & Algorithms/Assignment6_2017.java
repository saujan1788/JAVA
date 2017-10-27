/**
 * Student name:Saujanya Bohara
 * Student number:2892141
 */
import java.util.*;
public class Assignment6_2017{
  public static void main(String[] args) {

  	Mystack<Integer> s = new Mystack<Integer>(20);
  	s.push(5);
  	System.out.println(s);
   
}
}

class Mystack<E> implements Stack<E>{
   	private List<E> stack;
   	private int maxsize;
   	public Mystack(int n){  //Stack upper bound = n
   		stack = new ArrayList<>();
   		maxsize = n;
   	}

public boolean push(E x){
	if(stack.size()!= maxsize) {
		stack.add(x);
		return true;
	}
	else return false;
}

 }




interface Stack<E>{
	public boolean push(E x);
	/*public boolean pop();
	public E top();
	public boolean empty();
	public boolean full();
    public Iterator<E> iterator(); */
}

interface Queue<T>{
	/* public boolean join(T x);
	public T top();
	public boolean leave();
	public boolean full();
	public boolean empty();
	public String toString();
	public boolean contains(T x); 
	public Iterator<E> iterator(); */
} 
