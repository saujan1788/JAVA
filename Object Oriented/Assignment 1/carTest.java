class car {
	private String make;
	private String registrationNo;
	private double price;
	private double distTravelled;

	public car(String m, String rN, double p, double dis){
		make = m;
		registrationNo = rN;
		price = p;
		distTravelled = dis;
	}

public double update(double p){
	price = p;
	return p;
}
	public void display(){
		System.out.println("Make :" + make);
		System.out.println("RegistrationNo :" + registrationNo);
		System.out.println("Price :" + price);
		System.out.println("Dist_travelled :" +distTravelled);

	}
}

class carTest{

	public static void main(String[] args) {
		car c1 = new car("Ferrari","12DA",2000,10.00);
		c1.display();
		System.out.println(c1.update(3000.00));
		
	}
}