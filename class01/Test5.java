package class01;

import java.util.Scanner;

public class Test5 
{
	public static void main(String[] args) 
	{
		// digitSep1();
		digitSep2();
	}
	
	public static void digitSep1()
	{
		Scanner sc = new Scanner(System.in);
		
		// My Solution
		String str = "";
		while(str.length() != 5)
		{
			System.out.print("Enter a 5-digit number : ");
			str = sc.nextLine();
			
			if(str.length() != 5)
				System.out.println("Number must be 5 digits");
		}
		
		System.out.format("Digits in %s are ", str);
		
		for(int i = 0; i < str.length(); i++)
			System.out.format("%c ", str.charAt(i));
		System.out.println("\n");
	}
	
	public static void digitSep2()
	{
		Scanner sc = new Scanner(System.in);
		
		// TA's Solution
		int num = 0;
				
		System.out.print("Enter a 5-digit number : ");
		num = sc.nextInt();
				
		while((num/10000) < 1 || (num/10000) > 9)
		{
			System.out.println("Number must be 5 digits");
			System.out.print("Enter a 5-digit number : ");
			num = sc.nextInt();
		}
				
		int a, b, c, d, e;
		int temp = num;
		a = num / 10000;
		num %= 10000;
		b = num / 1000;
		num %= 1000;
		c = num / 100;
		num %= 100;
		d = num / 10;
		num %= 10;
		e = num;
		
		System.out.printf("Digits in %d are %d %d %d %d %d", temp, a, b, c, d, e);
	}
}