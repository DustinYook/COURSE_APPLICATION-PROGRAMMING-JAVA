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