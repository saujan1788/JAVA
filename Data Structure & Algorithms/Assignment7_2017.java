import java.util.*;
import java.util.function.*;
public class Assignment7_2017{
  public static void main(String args[]){
    /*Question 1 ==========================================================
    Using the class NewNumbers listed below write a code sequence that tests
    the methods: 
      forAll(Predicate<Integer> pr),
      List<Integer> getSubList(Predicate<Integer> pr)
      List<Integer> mapList(Function<Integer,Integer> f)
      Sample tests might be: all the values are positiAssive, all negative,
      retrieve a list of the even numbers, a list of negative numbers,
      use mapList to return the square of all the numbers, etc
      You should write at least three tests for each method
    ======================================================================*/
    // This code sets up a List
    NewNumbers lst = new NewNumbers();
    lst.add(Arrays.asList(1,2,3,4,6,-1,-5,7,8,12,4,-5,1,4,-2));
    lst.print(x->System.out.print(x+" "));




    Consumer<Integer> pNeg = x->{
    	if (x <0)System.out.print(x + " ");
    	
    };

    lst.print(pNeg);
    lst.print(x->{if(x<0) System.out.print(x + " ");});

    // COUNT METHOD
     System.out.println();
     System.out.println("Count Negative:"  			+ lst.count(x-> x <0));
     System.out.println("Count Poisitive:" 			+ lst.count(x-> x >0));
     System.out.println("Count Even:"      			+ lst.count(x-> x%2 == 0));
     System.out.println("Count Odd:"       			+ lst.count(x-> x%2 != 0));
     System.out.println("Count Range 0 to 8:"    	+ lst.count(x-> x > 0 && x < 8));

     
    // CONTAINS
     System.out.println();
     System.out.println("Contains no >10:"   		+lst.contains(x-> x>10));
     System.out.println("Contains negative no:"     +lst.contains(x-> x<0));
     System.out.println("Range 12 to 16:"    		+lst.contains(x-> (x<12 && x>16)));
     

     // MAPLIST
     System.out.println();
     System.out.println("List 1:" + lst.mapList(x-> x+10));
     System.out.println("List 2:" + lst.mapList(x-> x-5));
     System.out.println("List 3:" + lst.mapList(x-> x/2));

     //FORALL
     System.out.println();
     System.out.println("Check if all elements >-6:"       + lst.forAll(x-> x >-6));
     System.out.println("Check if all elements <15:"      + lst.forAll(x-> x <15));
     System.out.println("Chexk if all elements Even:"           + lst.forAll(x-> x%2 == 0));

     // GETSUBLIST
     System.out.println();
         System.out.println("SubList (x > 5) :"+lst.getSubList(x -> x < 0));



     //SUM
     System.out.println();
        System.out.println("sumEven: " + lst.sum(x-> x%2==0));
     
    
    /*Question 2 ============================================================
    Using the generic class MyList<E> listed below write a code sequence that 
    tests all of its the methods. You are given a Book class that you can use 
    to perform your tests. Note that creating a MyList<Integer> instance is not
    an acceptable data type for your tests.
    ================================================================== */
    MyList<Book> bls = new MyList<>();
    bls.add(Arrays.asList(
    	  new Book("Ulysses","Joyce"),
    	  new Book("Dubliners","Joyce"),
    	  new Book("Murphy","Beckett")
    ));

    //CONTAINS
    System.out.println();
    System.out.println(bls.contains(b->b.title().equals("Ulysses")));
    System.out.println(bls.contains(b->b.title().equals("Dubliners")));
    System.out.println(bls.contains(b->b.equals(new Book("Ulysses","Joyce"))));

    //FILTERLIST
    System.out.println();
    System.out.println(bls.filterList(b->b.title().equals("Ulysses")));
    System.out.println(bls.filterList(b->b.title().equals("Murphy")));
    System.out.println(bls.filterList(b->b.author().equals("Joyce")));


    //REMOVE
     System.out.println();





    //PRINT
    
  }
}
class NewNumbers{
	private List<Integer> data = new ArrayList<>();
	void add(int x){data.add(x);}
	void add(List<Integer> lst){data.addAll(lst);}
	boolean contains(Predicate<Integer> pr){
		for(Integer x : data)
		 if(pr.test(x)) return true;
		return false;
	}
	boolean forAll(Predicate<Integer> pr){
		for(Integer x : data)
		  if(!pr.test(x)) return false;
		return true;
	}
	List<Integer> getSubList(Predicate<Integer> pr){
		List<Integer> tmp = new ArrayList<>();
		for(Integer x : data)
		 if(pr.test(x)) tmp.add(x);
		return tmp;
	}
	List<Integer> mapList(Function<Integer,Integer> f){
	 List<Integer> tmp = new ArrayList<>();
	 for(Integer x : data) tmp.add(f.apply(x));
	 return tmp;
	}
	int count(Predicate<Integer> pr){
		int count = 0;
		for(Integer x : data) if(pr.test(x)) count++;
	  return count;
	}
	int sum(Predicate<Integer> pr){
		int s = 0;
		for(Integer x : data) if(pr.test(x)) s += x;
		return s;
	}
	void print(Consumer<Integer> cn){
		data.forEach(cn);
		System.out.println();
	}
}

class MyList<E> implements Iterable<E>{
 private List<E> data = new LinkedList<>();
 public void add(E x){data.add(x);}
 public void add(List<E> ls){
   for(E x : ls) data.add(x);
 }
 public boolean contains(Predicate<E> pr){
    for(E x : data) if(pr.test(x)) return true;
    return false;
 }
 public List<E> filterList(Predicate<E> pr){
  List<E> tmp = new LinkedList<>();
  for(E x : data) if(pr.test(x)) tmp.add(x);
  return tmp; 
 }
 public void remove(Predicate<E> pr){
  data.removeIf(pr);
 }
 public void print(Consumer<E> cn){
   data.forEach(cn);
	 System.out.println();
 }
 public Iterator<E> iterator(){return data.iterator();}
}
class Book{
 private String title;
 private String author;
 public Book(String t, String a){title = t; author = a;}
 public String title(){return title;}
 public String author(){return author;}
 public boolean equals(Object ob){
  if(!(ob instanceof Book)) return false;
  Book b = (Book)ob;
  return title.equals(b.title) && author.equals(b.author);
 }
 public int hashCode(){return 31*title.hashCode()*author.hashCode();}
 public String toString(){return title+" "+author;}
}