package class02;

import java.util.Arrays; 
// 우리의 클래스명이 Arrays여서 built-in과 이름 같은 경우 java.util.Arrays.sort();라고 명시하여 built-in 것을 출력가능

public class Test2
{
	public static void main(String[] args) 
	{
		// how to declare array
		int[] array = new int[5]; // dynamic allocation
		int[] array5 = {1,2,3,4,5};
		
		final int SIZE = 5;
		int[] array3 = new int[SIZE];
		
		for(int i : array)
			System.out.print(i + " ");
		System.out.println();
		
		for(int i : array5)
			System.out.print(i + " ");
		System.out.println();
		
		for(int i : array3)
			System.out.print(i + " ");
		System.out.println();
		
		int[] arr = {1, 3, 2, 4, 5};
		
		for(int i : arr)
			System.out.print(i + " ");
		System.out.println();
		
		Arrays.sort(arr);
		
		for(int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}
}