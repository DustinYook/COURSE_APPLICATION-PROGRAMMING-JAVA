package class06;

public class Cat implements ISpeak // interface를 implement
{

	@Override
	public void speak() 
	{
		System.out.println("Meow");
	}
}