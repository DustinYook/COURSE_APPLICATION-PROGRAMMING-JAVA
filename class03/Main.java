package class03;

import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		Rectangle r1 = new Rectangle(3.0, 4.0);
		r1.printRectInfo();
		System.out.println();
		
		Rectangle r2 = new Rectangle();
		Scanner sc = new Scanner(System.in);
		System.out.print("Set height : ");
		r2.setHeight(sc.nextDouble());
		System.out.print("Set width : ");
		r2.setWidth(sc.nextDouble());
		r2.printRectInfo();
		sc.close(); // to prevent memory leakage, use close method!
		
//		String a = "name";
//		if(a.equals("name"))
//			System.out.println("string is same!");
//		
//		if(a == "name") // low reliability, so avoid using it
//			System.out.println("string is same!");
//		else
//			System.out.println("not equal");
	}
}