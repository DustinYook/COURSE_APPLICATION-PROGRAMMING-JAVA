package class01;

import java.util.Scanner;

public class Test4 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the first integer : ");
		int num1 = sc.nextInt();
		
		System.out.print("Enter the second integer : ");
		int num2 = sc.nextInt();
		
		System.out.print("Enter the third integer : ");
		int num3 = sc.nextInt();
		
		System.out.format("For the numbers %d, %d and %d\n", num1, num2, num3);
		
		func1(num1, num2, num3);
		func2(num1, num2, num3);
		
		int sum = num1 + num2 + num3;
		System.out.println("Sum is " + sum);
		
		int product = num1 * num2 * num3;
		System.out.println("Product is " + product);
		
		double average = sum / 3;
		System.out.format("Average is %.3f", average);
	}
	
	public static void func1(int num1, int num2, int num3)
	{
		int max = num1;
		if(max < num2)
			max = num2;
		if(max < num3)
			max = num3;
		
		int min = num1;
		if(min > num2)
			min = num2;
		if(min > num3)
			min = num3;
		
		System.out.println("Largest is " + max);
		System.out.println("Smallest is " + min);
	}
	
	public static void func2(int num1, int num2, int num3)
	{
		int[] arr = {num1, num2, num3};
		for(int i = 0; i < 3; i++)
		{
			for(int j = i + 1; j < 3; j++)
			{
				if(arr[i] > arr[j])
				{
					int temp = arr[i];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		System.out.println("Largest is " + arr[2]);
		System.out.println("Smallest is " + arr[0]);
	}
}