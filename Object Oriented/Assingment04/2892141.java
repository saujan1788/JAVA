/**
 *
 * Student name: Saujanya  Bohara
 * Student number: 2892141
 */

public class Assignment4_2016 {
  public static void main(String[] args) {
        // Code for test here
  	Student s1 = new Student("Saujan", "1234", "Male", "2892141", "Programming");
  	System.out.println(s1);
  	Lecturer l1 = new Lecturer("Tony", "5678", "Male", 89000, "OO Programming");
  	System.out.println(l1);





  	Student dt[] = {
  		new Student("Winry", "1111", "Female", "1231231", "Alchemy"),
  		new Student("Edward", "2222", "Male", "3333333", "Automail")
  	};
  	Students s2 = new Students(10);
  	for(Student st : dt) s2.add(st);
  	System.out.println("All Students:-");	
  	System.out.println(s2);	
	System.out.println();


	System.out.println("Automail Students:- ");	
  	Student data[] = s2.getSubject("Automail");
  	for(Student st : data) System.out.println(st);

  	System.out.println("Female Students:-");
  	data = s2.getGender('F');
  	for(Student st : data) System.out.println(st);


  	System.out.println("Searching students based on Student number:");
  	boolean b = s2.search("3333333");
  	for(Student st : data) System.out.println(b);	
  		
  }
}
//----------------------------------------Q1 class-----------------------------------------
class Person{
	private String name;
	private String number;
	private String gender;
	Person(String n, String g, String num){
		name = n; gender = g; number = num;
	}
	public String name(){return name;}
	public String number(){return number;}
	public String gender(){return gender;}
	public String toString(){
		return "Name:- " + name + "Phone Number:- " + number + "Gender:- " + gender;
	}
}

class Student extends Person{
	private String studentNum;
	private String subject;
	public Student(String n, String g, String num, String sNum, String subs){
		super(n,num,g);
		studentNum = sNum; 
		subject = subs;
	}
	public String student_num(){return studentNum;}
	public String subject(){return subject;}
	public String toString(){
		return super.toString() + "Student number:- " + studentNum + "Subject:- " + subject;
	}
}

class Lecturer extends Person{
	private int staffNum;
	private String department;
	public Lecturer(String n, String g, String num, int stfN, String d){
		super(n,num,g);
		staffNum = stfN; department = d;
	}
	public String department(){return department;}
	public int staffNum(){return staffNum;}
	public String toString(){
		return super.toString() + "Staff number:- " + staffNum + "Department:- " + department;
	}
}

//----------------------------------------Q2 class-----------------------------------------
class Students{
	private Student[] data;
	private int size;
	public Students(int n){

		data = new Student[n];
		size = 0;
	}
	
	public boolean add(Student st){
		if(size < data.length){
			data[size] = st;
			size++;
			return true;
		}
		else return false;

	}
	public boolean search(String sNum){
		for(int i = 0; i < size; i++){
			if(data[i].student_num().equals(sNum)){
				return true;
			}
		}
		return false;
	}
	
	public Student[] getGender(char g){
		if(size == 0) return null;
		Student dt[] = new Student[size];
		int i = 0;
		for(int j = 0; j < size; j++){
			if(data[j].gender().charAt(0) == g){
				dt[i] = data[j];
				i++;
			}

		}
		return dt;
	}
	public Student[] getSubject(String sub){
		if(size == 0) return null;
		Student dt[] = new Student[size];
		int i = 0;
		for(int j = 0; j < size; j++){
			if(data[j].subject().equals(sub)){
				dt[i] = data[j];
				i++;
			}
		}
		return dt;
	}
	
	
	public int size(){return size;}
	public String toString(){
		if(size == 0) return "[]";
		String s = "[";
		for(int j = 0; j < size - 1; j++)
			s = s + data[j] + ",";
		return s+data[size-1]+"]";
	}
}
