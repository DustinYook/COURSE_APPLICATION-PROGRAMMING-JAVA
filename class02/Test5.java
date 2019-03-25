package class02;

import java.util.Random;
import java.util.Scanner;

public class Test5 
{
	public static void main(String[] args) 
	{
		Random randomNumbers = new Random(); 
		int answer; // here we'll store answer
		
		Scanner input = new Scanner(System.in);
		
		int digit1 = 1 + randomNumbers.nextInt(9);
		int digit2 = 1 + randomNumbers.nextInt(9);
		
		answer = digit1 * digit2;
		System.out.format("How much is %d times %d?\n", digit1, digit2);
		
		System.out.print("Enter your answer (-1 to exit) : ");
		int guess = input.nextInt();
		
		while(guess != -1)
		{
			if(guess == answer)
			{
				System.out.println("Nice work!");
				break;
			}
			else
			{
				System.out.println("No. Keep trying\n");
				
				System.out.print("Enter your answer (-1 to exit) : ");
				guess = input.nextInt();
			}
		}
	}
}