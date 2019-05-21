package class09;

@SuppressWarnings("serial")
public class DuplicateValueException extends Exception 
{
	public DuplicateValueException()
	{
		super("Integer cannot be duplicate!");
	}
	
	// for customized error message
	public DuplicateValueException(String message)
	{
		super(message);
	}
}