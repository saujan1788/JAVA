

import java.util.Scanner;

class Assignment003{
	public static void main(String[] args){

		Scanner in = new Scanner(System.in);
		

		System.out.println("Enter the string");
		 String reversed = in.nextLine();


		System.out.println("Enter the nth number to be reversed");
		int n = in.nextInt();
				
			  int count=1;
			  String one="";
		
		for(int i=0 ; i<reversed.length() ; i++)
		{
			one = one+reversed.charAt(i);
			if(reversed.charAt(i)==' ')
				count++;
			
			one = one+reversed.charAt(i);
			
				
			if(count%2==0)
			{
				
				i++;
				String temp="";
				int j=i;
				while(reversed.charAt(j)!=' ' && j<reversed.length())
				{
					temp = temp+reversed.charAt(j);
					j++;
				}
				temp = Reverse(temp);
				
				one = one+reversed.charAt(i);
			}
		}

		System.out.println("Reversed string is:" + one);
	}

private static String Reverse(String s) {
	String reverse = "";
	int length = s.length();
	for (int i = length -1;i >= 0;i--){
		reverse = reverse + s.charAt(i);		
	}
	return reverse;
}



	}
