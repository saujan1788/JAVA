/* Assignment10_2016

Student name: Saujanya Bohara
Student number: 2892141

*/
import java.util.*;
public class Assignment10_2016{
	public static void main(String args[]){
	  //Create instance of Friends class and test methods here.
		Friends f = new Friends();
		f.add(new Person("Aaaa", "1111"));
		System.out.println(f);


		Set<Person> st = new HashSet<>();
		st.addAll(Arrays.asList(
					new Person("Bbbb", "2222"),
					new Person("Cccc", "3333"),
					new Person("Dddd", "4444"),
					new Person("Eeee", "5555"),
					new Person("Ffff", "6666")
			));
		f.add(st);

		System.out.println(f);
		System.out.println("Search friend Aaaa 1111:");
		System.out.println(f.search(new Person("Aaaa", "1111")));
		System.out.println("Size of Set:\n" + f.size());

		Set<Person> t = f.getFirstname("Aaaa");
		System.out.println("Friends with First Name Aaaa:\n" + t); 

		Set<Person> t1 = f.getSurname("3333");
		System.out.println("Friends with Surname 3333:\n" + t1); 

		System.out.println("Frequency : "+f.getFreq("Eeee"));

		System.out.println("Deleting Ffff from Set:");
		f.del(new Person("Ffff", "6666"));
		System.out.println(f);

		System.out.println("Sorted Set:\n" + f.sort());



	  
	}
}

class Friends{
	private Set<Person> dt = new HashSet<>();
	public void add(Person p){
		dt.add(p);
	}
	public void add(Set<Person> t){
		dt.addAll(t);
	}
	public boolean search(Person p){
		for(Person p1 : dt){
			if(p1.equals(p))
				return true;
		}
		
		return false;
	}
	public int size(){
		return dt.size();
	}
	public Set<Person> getFirstname(String f){
		Set<Person> t = new HashSet<>();
		for(Person p : dt)
			if(f.equals(p.fName()))
				t.add(p);

			return t;
		
	}
	public Set<Person> getSurname(String s){
		Set<Person> t1 = new HashSet<>();
		for(Person p : dt)
			if(s.equals(p.sName()))
				t1.add(p);

			return t1;
		
	}
	public int getFreq(String f){
		int count = 0;
		for(Person p : dt)
			if(p.fName().equals(f))
				count++;
			return count;
	}
	public void del(Person p){
		dt.remove(p);		
	}

	public Set<Person> sort(){
		Set<Person> treeSet = new TreeSet<>(dt);
		treeSet.addAll(dt); 
		return treeSet; 


	}

	public String toString(){
		return dt.toString();
	}
}

final class Person implements Comparable<Person>{
	private final String sName;
  private final String fName;
	Person(String fn, String sn){fName = fn; sName = sn;}
	public String sName(){return sName;}
  public String fName(){return fName;}
	public String toString(){return fName+" "+sName;}
	public boolean equals(Object ob){
		if(!(ob instanceof Person)) return false;
		Person p = (Person)ob;
		return sName.equals(p.sName) && fName.equals(p.fName);
	}
	public int compareTo(Person p){
		if(p == null) return -1;
    if(this.equals(p)) return 0;
		return sName.compareTo(p.sName);
	}
	public int hashCode(){
    return 41 * sName.hashCode() * fName.hashCode();
  }
}