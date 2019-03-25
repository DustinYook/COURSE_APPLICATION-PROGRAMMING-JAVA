package class02;

import java.util.Random;
import java.util.Scanner;

public class Test7 
{
	Random randomNumbers = new Random();
	
	int answer;
	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		// static으로 메소드 정의하든가 또는 인스턴스 생성해서 접근하는 두가지 방법 존재
		Test7 t = new Test7();
		
		t.createQuestion();
		
		System.out.print("Enter your answer (-1 to exit) : ");
		int guess = input.nextInt();
		
		while(guess != -1)
		{
			if(guess == t.answer)
			{
				System.out.println("Nice work!");
				break;
			}
			else
				System.out.println("No. Keep trying\n");
		}
	}
	
	public void createQuestion() 
	{
		int digit1 = 1 + randomNumbers.nextInt(9);
		int digit2 = 1 + randomNumbers.nextInt(9);
		
		answer = digit1 * digit2; // here we'll store answer
		
		System.out.format("How much is %d times %d?\n", digit1, digit2);
	}
}