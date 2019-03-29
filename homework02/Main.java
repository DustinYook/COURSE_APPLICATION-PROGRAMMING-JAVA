/** 
 * 12131819 YOOK DONGHYUN
 * Java Application Programming-002 (Prof. Tamer) // Assignment02
 * Main.java : simple calculator for 40-digit-number (for calculator operation)
 * Reporting Date : 2019-03-28
 */

package homework02;

import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		/** get the first user input */
		HugeInteger h1 = new HugeInteger();
		String input1 = ""; // user input #1
		do
		{
			System.out.print("Enter the first number  : ");
			input1 = scanner.nextLine(); // get input from user
			if(input1.length() > 40)
				System.out.println("Error! The number should be less than 40-digit!\n");
		}while(input1.length() > 40); // input validity checking
		h1.parse(input1);

		/** get the second user input */
		HugeInteger h2 = new HugeInteger();
		String input2 = ""; // user input #1
		do
		{
			System.out.print("Enter the second number  : ");
			input2 = scanner.nextLine(); // get input from user
			if(input2.length() > 40)
				System.out.println("Error! The number should be less than 40-digit!\n");
		}while(input2.length() > 40); // input validity checking
		h2.parse(input2);
		
		scanner.close(); // to prevent memory leakage

		// test case #1 : 1234567897894561321384025145611604545430
		// test case #2 : 9234567897894561321384025145611604545430
	
		// 1) addition
		System.out.println("*** Addition ***");
		System.out.println(h1.add(h2));
		
		// 2) subtraction
		System.out.println("*** Subtraction ***");
		System.out.println(h1.subtract(h2));
		
		// 3) equality
		System.out.println("*** Equality of first and second ***");
		System.out.format("%b\n", h1.isEqualTo(h2));
		
		// 4) inequality
		System.out.println("*** Inequality of first and second ***");
		System.out.format("%b\n", h1.isNotEqualTo(h2));
		
		// 5) is greater than
		System.out.println("*** First is greater than second ***");
		System.out.format("%b\n", h1.isGreaterThan(h2));
		
		// 6) is less than
		System.out.println("*** First is less than second ***");
		System.out.format("%b\n", h1.isLessThan(h2));
		
		// 7) is greater than or equal to
		System.out.println("*** First is greater than or equal to second ***");
		System.out.format("%b\n", h1.isGreaterThanOrEqualTo(h2));
		
		// 8) is less than or equal to
		System.out.println("*** First is less than or equal to second ***");
		System.out.format("%b\n", h1.isLessThanOrEqualTo(h2));
		
		// 9-1) is zero
		System.out.println("*** First is zero ***");
		System.out.format("%b\n", h1.isZero());
		
		// 9-2) is zero
		System.out.println("*** Second is zero ***");
		System.out.format("%b\n", h2.isZero());
	}
}