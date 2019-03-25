package class02;

import java.util.Scanner;
import java.util.Random;

public class Test4 
{
	public static void main(String[] args) 
	{
		Random rand = new Random();
		Scanner s = new Scanner(System.in);
		
		final int MIN = 0; // 하한
		final int MAX = 10; // 상한
		
		int input; // 사용자 입력값
		
		while(true)
		{
			int rNum1 = rand.nextInt((MAX - MIN) + 1) + MIN;
			int rNum2 = rand.nextInt((MAX - MIN) + 1) + MIN;
			
			int ans = rNum1 * rNum2;
			
			System.out.format("How much is %d times %d?\n", rNum1, rNum2);
			System.out.print("Enter your answer (-1 to exit) : ");
			input = s.nextInt();
			
			if(input != -1)
			{
				if(ans == input)
					System.out.println("Nice work!");
				else
					System.out.println("No. Keep trying.");
			}
			else
				break;
			
			System.out.println();
		}
		System.out.println("\nYou exit game successfully!");
	}
}