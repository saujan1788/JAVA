/**
 * Assignment 2_2016
 *
 * Student Name:Saujanya Bohara
 * Student Number:2892141
 */
import java.util.*;
public class Assignment2_2016 {
	public static void main(String[] args) {
    //Question 1 test here that shows why encapsulation is broken
    class Author{
	private String a;
	public Author(String n)
	{a = n;}
	public String get(){return a;}
	public void edit(String na)
	{a = na;}
	public String toString(){return a;}
}
class Report{
	private String title;
	private Author author;
	public Report(String t, Author a)
	{
		title = t; 
		author = new Author(a.get());
	}
	public Author author()
	{
		return new Author(author.get());
	}
	
	public void editAuthor(String s)
	{
		author.edit(s);
	}
	
	public String toString()
	{
		return title + " by "+ author.toString();
	}
}
    
    
    //============================================================
    //Question 2 testing here ====================================
    ************************************************************************
    public class test{

	public static void main(String[] args)
	{
		email eml1 = new email("lordsaujan@gmail.com", "student@dublin.ie");
		employee emp1 = new employee("Saujan", "Bohara", eml1);



		System.out.println(eml1);
		System.out.println(emp1);
		
		
		eml1.edithome("saujan1788@gmail.com");
		eml1.editwork("student@griffith.ie");
		
		System.out.println("\n"+eml1);
		System.out.println(emp1);
		
		
		System.out.println("\n");
		
		emp1.editEmphome("saujan_bohara@gmail.com");
		emp1.editEmpwork("computing_student@griffith.ie");
		
		
		System.out.println("\n"+eml1);
		System.out.println(emp1);
		
	}
}

    
    
//Classes for Question 1======================================

class Author{
	private String a;
	public Author(String n){a = n;}
	public String get(){return a;}
	public String edit(String na){a = na;}
	public String toString(){return a;}
}
class Report{
	private String title;
	private Author author;
	public Report(String t, Author a){title = t; author = a;}
	public Author author(){return author;}
}
//classes for Question 2==================================================
************************************************************************************
class email{
	
	private String home;
	private String work;
	
	public email(String hm, String wk)
	{
		home = hm;
		work = wk;
	}	
	
	public String gethome(){return home;}
	public String getwork(){return work;}
	
	public String edithome(String nhm)
	{
		home = nhm;
		return home;
	}
	
	public String editwork(String nwk)
	{
		work = nwk;
		return work;
	}
	
	public String toString()
	{
		String out = "Home Email ID : "+home+"\n\nWork Email ID : "+work;
		return out;
	}
}




*******************************************************************************************
class employee{
	
	private String fstname;
	private String surname;
	private email Email;
	
	public employee(String fst, String sur, email eml)
	{
		fstname = fst;
		surname = sur;
		Email = new email(eml.gethome(), eml.getwork());
	}	
	
	public void editEmphome(String a){ Email.edithome(a); }
	public void editEmpwork(String b){ Email.editwork(b); }
	
	public String toString()
	{
		String out = "\n\nName = "+fstname+" "+surname+"\n\n"+Email.toString();
		return out;
	}
}
