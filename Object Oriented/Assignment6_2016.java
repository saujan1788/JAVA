public class Assignment6_2016{
	public static void main(String args[]){
	  
	}
}
//Q1  =============================================
//Add classes for Q1 here =========================

abstract class Shape{

	private String name;
	public Shape(String n){name = n;}
	public abstract double area();
	public abstract double perimeter();
	public void put(){
		System.out.printf("%s with area %6.2f and perimeter %6.2f\n",
				          name, area(), perimeter());
	}
}

class Square extends Shape{
	
	private double length, width;
	public Square(String n,double l, double w)
	{super(n); length = l; width = w;}
	public double length(){return length;}
	public double width(){return width;}
	public double area(){return length*width;}
	public double perimeter(){return 4*length;}
	public double diagonal(){return length*Math.sqrt(2);}
	
}

class Circle extends Shape{
	
	private double radius;
	public Circle(String n,double r)
	{super(n); radius = r;}
	public double radius(){return radius;}
	public double area(){return Math.PI* Math.pow(radius,2);}
	public double perimeter(){return 2*Math.PI*radius;}
	
		
}

public static void main(String[] args){
	
	
	Square sqr1 = new Square("Sqr1",5,5);
	
	Circle cir1 = new Circle("Cir1",2.5);
	
	cir1.display();
	
	double c = cir1.perimeter();
	System.out.println(c);
	
	
	sqr1.display();
	
	double s = sqr1.diagonal();
	System.out.println(s);
	
	
		
	}
	
	
}

//Q2 ===============================================
//edit this class here =============================
final class Car{
	private  String reg;
	private  String make;
	private  int kilometers;
	private double price;
	public Car(String r, String m, int k, double p){
	 reg = r; make = m; kilometers = k; price = p; 
	}
	public String reg(){return reg;}
	public String make(){return make;}
	public int kilomters(){return kilometers;}
	public double price(){return price;}
	public void setPrice(double p){price = p;}
	public void setKil(int k){kilometers = k;}
	
	public void display(){
		System.out.println("Make :" + make);
		System.out.println("Registration :" + reg);
		System.out.println("Price :" + price);
		System.out.println("Kilometres :" +kilometers);

	}
	
}

class carTest{
public static void main(String[] args){
Car c1 = new Car("12DA","Bugati",100,99999);
c1.display();
System.out.println("Upadted")
c1.setPrice(10000.00);
c1.setKil(101);
c1.display();
 }
}

//Q3 ==================================================
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
public class RationalTest{
 Rational r1 = new Rational(1,2);
 Rational r2 = new Rational(3,4);
 Rational r3 = new Rational(-1,2);
 Rational r4 = new Rational(1,4);
 Rational dt[];
 public RationalTest(){
   dt = new Rational[4];
   dt[0] = r1; dt[1] = r2; dt[2] = r3; dt[3] = r4;
 }
 
 @Test
 public void testAdd1(){
    assertEquals(r1.add(r3),new Rational(0));
 }
 
 @Test
 public void testSubt(){
 assertEquals(r2.sub(r4),new Rational(1,2)); 
 }
 
@ Test
public void  testMult(){
 assertEquals(r1.mult(r4),new Rational(1,8));
}

@Test
public void testDiv(){
assertEquals(r1.div(r2),new Rational(2,3));
}

@Test
public void test_addx(){
assertEquals(r1.add(1),new Rational(3,2));
}

@Test
public void test_subx(){
assertEquals(r1.sub(1),new Rational(-1,2));
}

@Test
public void test_multx(){
assertEquals(r1.mult(1),new Rational(1,2));
}

@Test
public void test_divx(){
assertEquals(r1.div(1),new Rational(1,2));
}

@Test
 public void testdt(){
	Rational r = new Rational(0);
	for(int i = 0; i<dt.length; i++){r = r.add(dt[i]);}
	assertEquals(r,new Rational(1));
}
 
@Test
public void productdt(){
	Rational q = new Rational(1,1);
	for(int i = 0; i<dt.length; i++){q = q.mult(dt[i]);}
	assertEquals(q,new Rational(-3,64));
}	
}
//Given below is the class Rational. ========================
// Do not edit this code ====================================
 
class Rational{
	private final int num, den;
	Rational(int n, int d){
		assert d != 0;
		if(n == 0){num = 0; den = 1;}
		else{
		  int g = gcd(Math.abs(n), Math.abs(d)); 
		  if(n < 0 && d < 0){num = -n/g; den = -d/g;}
		  else if(d < 0) { num = -n/g; den = -d/g;} 
		  else {num = n/g; den = d/g;}
		}
	}
	Rational(int n){num = n; den = 1;}
	public int num(){return num;}
	public int den(){return den;}
	public String toString(){
		 if(num == 0) return num+"";
		 else if(den == 1) return num+"";
		 else return num+"/"+den;
	}
	public Rational add(Rational k ){
		assert k != null;
		return new Rational(num*k.den+k.num*den, den*k.den);
	}
	public Rational sub(Rational k){
		assert k != null;
		return new Rational(num*k.den - k.num*den, den*k.den);
	}
	public Rational mult(Rational k){
		assert k != null;
		return new Rational(num*k.num,den*k.den);
	}
	public Rational div(Rational k){
		assert k != null;
		return new Rational(num*k.den, den*k.num);
	}
	public Rational add(int x){return new Rational(num+den*x,den);}
	public Rational sub(int x){return new Rational(num-den*x,den);}
	public Rational mult(int x){return new Rational(x*num,den);}
	public Rational div(int x){return new Rational(num,den*x);}
  public boolean equals(Object ob){
  	if(!(ob instanceof Rational)) return false;
  	Rational p = (Rational)ob;
  	return num == p.num && den == p.den;
  }
	//Private methods ===========================================
	private int gcd(int a, int b){ 
	  //implements Euclid's algorithm to find greatest common divisor
		if(a == b) return a;
		while(a != b) if(a > b) a = a - b; else b = b - a; return a;  
		// recursive version of Euclid
		//if(b==0) return a; else return gcd(b,a % b); 
	}
	
}
