package class02;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Test8 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Random randomNumbers = new Random();
		
		System.out.print("Enter number of dices : ");
		int dNum = sc.nextInt();
		
		System.out.print("Enter number of rolls : ");
		int rNum = sc.nextInt();
		
		int MIN = 1 * dNum; // 시작 번호
		int MAX = 6 * dNum; // 끝 번호
		System.out.println(MIN + " " + MAX);
		
		int[] freq = new int[MAX]; 
		Arrays.fill(freq, 0);
		
		System.out.format("%5s%12s%12s\n", "Sum", "Frequency", "Percentage");
		for(int i = 0; i < rNum; i++)
		{
			int rand = randomNumbers.nextInt((MAX - MIN) + 1) + MIN;
			System.out.print(rand + " "); // 확인용
			freq[rand - dNum]++;
		}
		System.out.println();
		
		for(int i = 0; i < freq.length; i++)
		{
			System.out.format("%5d%12d%12.2f\n", i, freq[i], (double)(freq[i])/(double)(rNum) * 100);
//			for(int j = 0; j < freq[i]; i++)
//				System.out.print("*");
//			System.out.println();
		}
	}
}