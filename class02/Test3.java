package class02;

import java.util.Random;

public class Test3 
{
	public static void main(String[] args) 
	{
		Random randomGenerator = new Random();
		
		final int MIN = 1;
		final int MAX = 6;
		int rNumber;
		// rNumber = randomGenerator.nextInt(10); // 시드 주는 방법
		rNumber = MIN + randomGenerator.nextInt((MAX-MIN) + 1); // 최솟값과 최댓값의 범위를 지정하는 트릭
		// srand()와 동일함 
		System.out.format("Random number is %d\n", rNumber);
	}
}