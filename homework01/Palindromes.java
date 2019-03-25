package homework01;

import java.util.Scanner;
import java.util.Stack;

public class Palindromes 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			// user input
			System.out.print("Enter the 5 digit number : ");
			int number = sc.nextInt(); 
			
			// save the digit the number has
			int digit = (int)(Math.log10(number) + 1); 
			
			if(digit == 5)
			{
				int temp = number;
				
				// save the front part of the number
				Stack<Integer> front = new Stack<Integer>(); 
				
				// parsing the numbers by digits and save it in stack
				for(int i = 4; i >= 0; i--)
				{
					int div = (int) Math.pow(10, i);
					int num = (int)(temp/div);
					front.push(new Integer(num));
					temp = temp - (num * div); 
				}
				
				// move the digit numbers from front to back
				Stack<Integer> back = new Stack<Integer>();
				for(int i = 0; i < 3; i++)
					back.push(new Integer(front.pop()));
				
				// remove center at the back part
				back.pop(); 
				
				// checking whether the number is palindrome or not
				boolean flag = false; // if flag is false, it means the number is palindrome
				for(int i = 0; i < 2; i++)
				{
					int f_num = front.pop();
					int b_num = back.pop();

					if(f_num == b_num)
						flag = false;
					else
						flag = true;
				}
				
				if(flag)
					System.out.format("The number %d is NOT a palindrome!", number);
				else
					System.out.format("The number %d is a palindrome!", number);
				
				break;
			}
			else
				System.out.print("It's not 5 digit number! ");
		}
	}
}