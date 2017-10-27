/*
Student Name: Saujanya Bohara
Student Number: 2892141
*/

import java.util.*;
public class Assignment3_2016{
	public static void main(String args[]){
	
	IntManager in = new IntManager(100);
	System.out.println(in);

	for(int j = 0; j < 20; j++){
		int x = (int)(Math.random()*20);
		in.add(x);

	}
	System.out.println(in);
	
	System.out.println("Found method: " + in.found(7));	

	System.out.println("Sum: " + in.sum());
	System.out.println("Sum odd: " + in.sumOdd());
	System.out.println("frequency: " + in.freq(2));
	System.out.println("Max: " + in.max());
	in.sort();
		/*Q2  ==============================================
		  This code is a sample test for Q2.*/
		 	TicketManager tm = new TicketManager();
     	System.out.println(tm);
     	Ticket t1 = new Ticket((int)(Math.random()*5),(int)(Math.random()*5));
     	tm.buy(t1);
     	System.out.println(tm);
     	Ticket t2 = new Ticket((int)(Math.random()*5),(int)(Math.random()*5));
     	tm.buy(t2);
     	System.out.println(tm);
     	for(int j = 0; j < 200; j++)
     		tm.buy(new Ticket((int)(Math.random()*5),(int)(Math.random()*5)));
     	System.out.println(tm.sold());
     	Ticket draw = new Ticket((int)(Math.random()*5),(int)(Math.random()*5));
     	System.out.println(tm.freqWinner(draw));

		
	}
}
//Q1 class ===============================================
class IntManager{
	private Integer dt[];
	private int size;
	IntManager(int k){dt = new Integer[k]; size = 0;}
	public void add(Integer x){
		if(size < dt.length){
			dt[size] = x; size++;
		}
	}

	public boolean found(Integer x){
		//return true if x in dt; false otherwise
		for(int i = 0; i < size; i++){
			if(dt[i].equals(x)){
				return true;
			}
		}
		return false;
	}
	public Integer sum(){
		int sum = 0;
		//calulate sum of the values
		for(int i = 0; i < size; i++){
			sum = sum + dt[i];
		}
		return sum;
	}
	public Integer sumOdd(){
		int sum_odd = 0;
		//calculate sum of odd values
		for(int i = 0; i < size; i++){
			if(dt[i] % 2 != 0){
				sum_odd = sum_odd + dt[i];

			}
		}
		return sum_odd;
	}
	public Integer freq(Integer x){
		//count frequency of occurrence of x in dt
		int f = 0;
		for(int i = 0; i < size; i++){
			if(dt[i].equals(x)){
				f++;
			}
		}
		return f;
	}
	
	public Integer max(){
	  //return largest value in dt; null if size == 0
		int a = dt[0];
		if(size == 0) return null;
		for(int i = 0; i < size; i++){
			if(dt[i] > a){
				a = dt[i];
			}
		}
		return a;

	}

	public void sort(){
		Arrays.sort(dt,0,size); //0 is the starting index, and size is the last index because on its there are no values in it
		for(int i = 0; i < size; i++){
			System.out.print(dt[i] + " ");
		}
		System.out.println();
		
	}
	public String toString(){
		if(size == 0) return "[]";
		String s = "[";
		for(int j = 0; j < size - 1; j++)
			s = s + dt[j] + ",";
		return s+dt[size-1]+"]";
	}
}

//Q2 classes ================================================

class Ticket{
	private int a,b;
	Ticket(int a1, int b1){a = a1; b = b1;}
	public int a(){return a;}
	public int b(){return b;}
	public String toString(){
	return "["+a+","+b+"]";
	}
}

//////////////////////////////////

class TicketManager{

	private Ticket[] tickets;
	private int tSold = 0;
	private int maxTickets = 500;

	TicketManager()
	{
		tickets = new Ticket[maxTickets];
	}

	public boolean buy(Ticket t)
	{		
		if(tSold == maxTickets)
		{
			return true;
		}
		
		else
		{
			tickets[tSold] = t;
			tSold++;
			
			return false;
		}
	}

	public int freqWinner(Ticket t)
	{
		int w = 0;
		for(int j=0 ; j<tSold ; j++)
		{
			if(t.equals(tickets[j]))
				w++;	
			else;
		}
			

		return w;
	}
	
	public boolean search(Ticket t)
	{
		boolean x = false;
		for(int j=0 ; j<tSold ; j++)
		{			
			if(tickets[j].equals(t))
			{
				j = tSold;
				x = true;
			}
		}
				
		return x;
	}
	public int tSold()
	    {
		return tSold;
	    }
	
	public boolean alltSold()
	{
		if(tSold == maxTickets)
			return true;
		else
			return false;
	}

	public String toString(){
		if(tSold == 0) return "[]";
		String a = "[";
		for(int j = 0; j < tSold - 1; j++)
			a = a + tickets[j] + ",";
		return a+tickets[tSold-1]+"]";
	}
}
