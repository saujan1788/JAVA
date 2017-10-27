class labwork8{
public static void main(String[] args) {
	StItem dt[] = {
     new StItem("aaa","AAA","111"),
     new StItem("bbb","BBB","222"),
     new StItem("ccc","DDD","333"),
     new StItem("ddd","CCC","444"),
     new StItem("eee","EEE","555"),
     new StItem("fff","FFF","666"),


	};

	Arrays.sort(dt);
	for (StItem st: dt)
		System.out.println(st);
}


}





final class StItem implements Comparable<StItem>{
	private String code;
	private String name;
	private int quantity;
	StItem(String c, String n,int q){
		code = c; name = n;quantity = q;
	}
	public String code(){return code;}
	public String name(){return name;}
	public int quantity(){return quantity;}
	public boolean delQty(int x){
		if(x <= quantity){
			quantity = quantity - x;
			return true;
		}
		else return false;

    public boolean equals(Object ob){
    	if(!ob instanceof Stitem) return false;
    	StItem st = (StItem)ob;
    	return code.equals(st.code);
    }
	public String toString(){
		return name + " " + code + " " + quantity;
	}
	public int compareTo(StItem s){
		if (s == null) return -1;
		if (this.equals(s))return 0;
		else return (name.compareTo(s.name()));
	}
	public int hashCode(){}	
	}
}
