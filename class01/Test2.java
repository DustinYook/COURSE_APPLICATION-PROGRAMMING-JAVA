package class01;

import java.util.Scanner; 

public class Test2 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in); // create Scanner object

		System.out.print("Please input the first operand : ");
		int operand1 = sc.nextInt();

		System.out.print("Please input the second operand : ");
		int operand2 = sc.nextInt();

		int result = operand1 + operand2;
		System.out.format("%d + %d = %d\n", operand1, operand2, result);
		
		String str = sc.nextLine();
		System.out.format("your input is \"%s\"\n", str);
	}
}

//스캐너 객체 사용하는 방법
//import java.util.Scanner; // Scanner 라이브러리 import
//Scanner sc = new Scanner(System.in); // Scanner 객체 생성
//변수 = sc.nextInt()/nextFloat()/nextLine();

//indentation control하는 단축키 : ctrl + shift + f