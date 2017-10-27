class TD{
	private String name;
	private String constituency;
	public TD(String n, String c){
		name = n; constituency = c;
	}
	public String name(){return name;}
	public String constituency(){return constituency;}
} 

class Minister extends TD {
	private String department;
	public Minister(String n, String c, String dept){
		super(n,c);
		department = dept;
	}

	public String department(){return department;}

}



