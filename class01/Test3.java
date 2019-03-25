package class01;

import java.util.Scanner;

public class Test3
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Input your name : ");
		String name = sc.nextLine();
		
		System.out.format("Hello %s.", name);
	}
}