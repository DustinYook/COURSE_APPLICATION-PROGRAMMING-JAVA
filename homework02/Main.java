package homework02;

import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		HugeInteger h1 = new HugeInteger();
		HugeInteger h2 = new HugeInteger();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the first number : ");
		h1.parse(sc.nextLine());
		System.out.print("Enter the second number : ");
		h2.parse(sc.nextLine());
		System.out.println(h1.toString());
		System.out.println(h2.toString());
		h1.add(h2);
		System.out.println(h1.toString());
	}
}