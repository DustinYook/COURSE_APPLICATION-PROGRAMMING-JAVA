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