/** 
 * 12131819 YOOK DONGHYUN
 * Java Application Programming-002 (Prof. Tamer) // Assignment06
 * IllegalRangeException.java : This class defines the illegal range exception
 * Reporting Date : 2019-05-21
 */

package homework06;

@SuppressWarnings("serial")
public class IllegalRangeException extends Exception 
{
	public IllegalRangeException()
	{
		super("First input should be less than second input!");
	}
	
	public IllegalRangeException(String message)
	{
		super(message);
	}
}