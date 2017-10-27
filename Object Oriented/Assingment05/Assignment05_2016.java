/**
 *
 * Student Name; Saujanya Bohara
 * Student Number: 2892141
 */

public class Assignment05_2016{
 public static void main(String[] args) {
  //Test Rational class here ========================
  Rational k = new Rational(4,5);
  System.out.println(k);
  Rational k1 = new Rational(20,8);
  System.out.println(k1);

  System.out.println(k.add(k1));
  System.out.println(k.mult(k1)); 
  System.out.println(k.multBy(2)); 
  System.out.println(k.mult(k1));
  System.out.println(k.le(k1));
  System.out.println(k.eq(k1));
  System.out.println(k.gt(k1));
  System.out.println(k.min(k1));
  System.out.println(k.max(k1));




  //=================================================
 }
}

interface Operations{
	public Rational add(Rational q);
	public Rational mult(Rational q);
	public Rational multBy(int k);
	public Rational divBy(Rational q);
	public boolean le(Rational q); //returns true if this less than q
	public boolean eq(Rational q); //returns true if this equals q
	public boolean gt(Rational q); //returns true if this greater than q
	public Rational min(Rational q); //returns min of this and q
	public Rational max(Rational q); //returns max of this and q
} 
class Rational{ // implements Operations{
	private int num,den;
	public Rational(int n, int d){//assume d != 0
        if(n < 0 && d < 0){ n = -n; d = -d;}
        else if(d < 0){ n = -n; d = -d;}
        //ensures that d never negative and n positive e.g. 1/-2 is changed to -1/2
        int g = gcd(Math.abs(n), Math.abs(d));
        num = n/g;den = d/g;
	}
	public Rational(int n){num = n; den = 1;}
	public int num(){return num;}
	public int den(){return den;}
	public Rational add(Rational q)
	{
     int n = 0; int d = 0;
     n = (num * q.den()) + (den * q.num());
     d = (den * q.den());
     return new Rational(n,d);
	}

	public Rational mult(Rational q)
	{
		int n = 0; int d = 0;
		n = (num * q.num());
		d = (den * q.den());
		return new Rational(n,d);
	}

    public Rational multBy(int k)
    {
    	int n = 0; int d = 0;
    	n = num * k;
    	d = den;
    	return new Rational(n,d);
    }

    public Rational divBy(Rational q)
    {
    	int n = 0; int d = 0;
    	n = num * q.den();
    	d = den * q.num();
    	return new Rational(n,d);
    }

    public boolean le(Rational q)
    {
    	int chk = (num * q.den()) - (den  * q.num());
    	if (chk < 0 )
    		return true;
    	else 
    		return false;

    }

    public boolean eq(Rational q)
    {
    	int n =0; int d =0;
    	n = num * q.den();
    	d = den * q.num();
    	if (n == d)
    		return true;
    	else 
    		return false;
    }

    public boolean gt(Rational q)
    {
    	int chk = (num * q.den()) - (den * q.num());
    	if (chk > 0)
    		return true;
    	else
    		return false;
    }

    public Rational min(Rational q)
    {

		int chk = (num * q.den()) - (den * q.num());
		
		if(chk<0)
			return new Rational(num,den);
		
		else if(chk>0)
			return new Rational(q.num(),q.den());
		
		else
			return null;

    }

    public Rational max(Rational q)
	{
		int chk = (num * q.den()) - (den * q.num());
		
		if(chk>0)
			return new Rational(num,den);
		
		else if(chk<0)
			return new Rational(q.num(),q.den());
		
		else
			return null;
	}
	public String toString(){return num+"/"+den;}
	private int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b,a%b);
     }
}