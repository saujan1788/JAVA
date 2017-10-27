/**
 * student name:saujanya bohara
 * student number:2892141
 */
import java.util.*;
import java.util.function.*;
 public class Assignment08_2017 {
	public static void main(String[] args){


		

		LinkedList<Integer> a = new LinkedList<>();

		for(int j = 0; j < 10; j++){
		int x = (int)(Math.random()*10); a.add(x);
		}




		MyHashList<Point> lst = new MyHashList<Point>(100000);

		for(int j = 0; j < 100000; j++){
			int x = (int)(Math.random()*100000);
			int y = (int)(Math.random()*100000); 
			lst.add(new Point(x,y));
		}



		System.out.println("Percentage of buckets used: "+lst.percentUsed());
		System.out.println("Largest bucket size = "+lst.largestBucket()); 
		System.out.println("Smallest bucket size = "+lst.smallestBucket());

		int lSizes[] = lst.listSizes();

		System.out.println("Frequency list"); 

		for(int j = 0; j < lSizes.length; j++){
        	if(lSizes[j] > 0)
			System.out.printf("Buckets with %d elements = %d\n",j,lSizes[j]); }
			
		System.out.println("Empty buckets = "+lst.empty()); 

		


		
/*==============================================================================*/

		MyHashList<Integer> data = new MyHashList<>(1);

		data.add(10);  data.add(13); data.add(26);	data.add(50);	data.add(55);	data.add(23);

		System.out.println("Integer Data : "+data);

		data.remove(a);
		System.out.println("Removing Elements : "+a);

		System.out.println("GetList  : "+data.getList(1));

		System.out.println("Get : "+data.get(x -> x %2 !=0));

  }
}
//=======================================================
// class Point
class Point{
	private int x,y;
	Point(int a, int b){x = a; y = b;}
	public int x(){return x;}
	public int y(){return y;}
	public String toString(){return "("+x+","+y+")";}
	public boolean equals(Object ob){
		if(!(ob instanceof Point)) return false;
		if(ob == null) return false;
		if (getClass() != ob.getClass()) return false;
		Point p = (Point)ob;
		if(this.x == p.x() && this.y == p.y()) return true;
		else {return false;}
	}
	public  int hashCode() {return x*y;}

}


//End class Point
//=======================================================
//HashTable class
class MyHashList<E> implements Iterable<E>{

	private ArrayList<LinkedList<E>> table;
	private int maxSize = Integer.MAX_VALUE;
	private int size = 0;
	public MyHashList(int n){

	 // n = the number of lists to create - 
	 // it does not limit the number of elements in the table 
	if(n > 1000) //divide n by 10
	table = new ArrayList<>(n/10); else
	table = new ArrayList<>(100); maxSize = n;

	 //table = new ArrayList<>();
   	for(int j = 0; j < n; j++)
   	  table.add(new LinkedList<>());
  	}

  	public MyHashList() {
	table = new ArrayList<>(1000); }


  	private int hashC(E x){
		int k = x.hashCode();
		//an alternative is to mask the minus using
		//int k = x.hashCode() & 0x7fffffff;
		int h = Math.abs(k % table.size());
		return(h);
	}
	
	public void add(E x){
		int index = hashC(x);
		table.get(index).addFirst(x);
	}
	public boolean contains(E x){
		int index = hashC(x);
		return(table.get(index).contains(x));
	}
	public boolean remove(E x){
		int index = hashC(x);
		return table.get(index).remove(x);
	}
	
	public int size(){
		int count = 0;
		for(int j = 0; j < table.size();j++) count += table.get(j).size();
		return count;
	}
	public Iterator<E> iterator(){
	  ArrayList<E> items = new ArrayList<E>();
	  int ind = 0;
	  while(ind < table.size()){
			Iterator<E> it = table.get(ind).iterator();
			while(it.hasNext()) items.add(it.next());
			ind++;
	   }
	   return items.iterator();
	}
	public String toString(){return table.toString();} 


	
	//==================================================================
	//Methods that provide information about the state of the hashtable
	public double percentUsed(){
		int count = 0;
		for(int j = 0; j < table.size(); j++){
			if(table.get(j).size() > 0)
			  count++;
		}
		double p = count *100.0 / table.size();
		return p;
	}
	public int largestBucket(){
		int max = 0;
		for(int j = 0; j < table.size(); j++){
		  int k = table.get(j).size();
			if( k > max) max = k;
		}
		return max;
	}
	public int smallestBucket(){
		int min = table.get(0).size();
		for(int j = 1; j < table.size(); j++){
		  int k = table.get(j).size();
			if(k < min) min = k;
		}
		return min;
	}
	public int[] listSizes(){
		int n = this.largestBucket();
		int d[] = new int[n+1];
		for(int j = 0; j < d.length; j++) d[j] = 0;
		for(int j = 0; j < table.size(); j++){
			int m = table.get(j).size();
			d[m] = d[m] + 1;
		}
		return d;
	}
	public int empty(){
		int count = 0;
		for(int j = 0; j < table.size(); j++)
			if(table.get(j).size() == 0) count++;
		return count;
	}

	public LinkedList<E> getList(E x) {
        if(x == null) return null;

        LinkedList<E> ls = new LinkedList<>();
        int ind = hashC(x);
        ls.addAll(table.get(ind));
        return ls;
    
    }
		

	public void remove(List<E> ls){
		int index;
		for(E x : ls)  {index = hashC(x); if(table.get(index).contains(x)) table.get(index).remove(x);}	
	}

	public List<E> get(Predicate<E> pr){
        List<E> ls = new ArrayList<>();
        for(LinkedList<E> is:table)
            for(E x :ls)
                if(pr.test(x)) ls.add(x);
        return ls;
		}	
	


	
	
		
	//==================================================================
}
