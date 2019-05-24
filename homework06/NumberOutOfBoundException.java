/** 
 * 12131819 YOOK DONGHYUN
 * Java Application Programming-002 (Prof. Tamer) // Assignment06
 * NumberOutOfBoundException.java : This class defines the number out of bound exception
 * Reporting Date : 2019-05-21
 */

package homework06;

@SuppressWarnings("serial")
public class NumberOutOfBoundException extends Exception 
{
	public NumberOutOfBoundException() 
	{
		super("Number has more than 8 digits!");
	}
	
	public NumberOutOfBoundException(String message) 
	{
		super(message);
	}
}