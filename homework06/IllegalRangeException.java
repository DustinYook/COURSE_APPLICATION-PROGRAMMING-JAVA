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