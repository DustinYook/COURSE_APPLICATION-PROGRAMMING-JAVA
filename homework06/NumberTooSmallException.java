/** 
 * 12131819 YOOK DONGHYUN
 * Java Application Programming-002 (Prof. Tamer) // Assignment06
 * NumberTooSmallException.java : This class defines the number too small exception (whether it has negative number)
 * Reporting Date : 2019-05-21
 */

package homework06;

@SuppressWarnings("serial")
public class NumberTooSmallException extends Exception 
{
	public NumberTooSmallException() 
	{
		super("Number should be bigger than 0");
	}
	
	public NumberTooSmallException(String message)
	{
		super(message);
	}
}