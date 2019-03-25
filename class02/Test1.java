// 프로그램 목적 : java의 연산자 이해
package class02;

public class Test1 
{
	public static void main(String[] args) 
	{
		int a, b;
		a = 10;
		b = (a==1) ? 20 : 30; // ternary condition operator
		System.out.format("a is %d, b is %d\n", a, b);
	}
}