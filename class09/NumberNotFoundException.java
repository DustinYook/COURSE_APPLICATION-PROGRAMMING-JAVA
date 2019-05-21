package class09;

@SuppressWarnings("serial")
public class NumberNotFoundException extends Exception 
{
	public NumberNotFoundException()
	{
		super("Number not found in the array!");
	}
	
	// for customized error message
	public NumberNotFoundException(String message)
	{
		super(message);
	}
}