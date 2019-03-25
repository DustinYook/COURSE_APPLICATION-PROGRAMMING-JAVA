package class01; // C++의 namespace와 유사한 역할을 수행

public class Test1 // class명과 폴더명을 일치시켜야 함
{
	public static void main(String[] args) 
	{
		System.out.print("No break line"); // without break line
		System.out.print("break line\n");
		System.out.println("break line"); // with break line

		System.out.printf("the number is %d\n", 100); // formatted string
		System.out.println("the number is " + 100); // formatted string

		long n = 461012;
		System.out.format("%+,8d%n", n); // '+'와 ','에 초점

		double pi = Math.PI;
		System.out.format("%-10.3f%n", pi);
	}
}