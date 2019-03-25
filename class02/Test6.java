package class02;

import java.util.Random;
import java.util.Scanner;

public class Test6 
{
	public static void main(String[] args) 
	{
		Random randomNumbers = new Random(); 
		Scanner input = new Scanner(System.in);
		
		int digit1 = 1 + randomNumbers.nextInt(9);
		int digit2 = 1 + randomNumbers.nextInt(9);
		
		int answer = digit1 * digit2; // here we'll store answer
		
		System.out.format("How much is %d times %d?\n", digit1, digit2);
		
		int guess;
		do
		{
			System.out.print("Enter your answer (-1 to exit) : ");
			guess = input.nextInt();
			
			if(guess != -1)
			{
				if(guess == answer)
				{
					System.out.println("Nice work!");
					break;
				}
				else
					System.out.println("No. Keep trying\n");
			}
			else
				break;
			
		} while(guess != -1);
	}
}
