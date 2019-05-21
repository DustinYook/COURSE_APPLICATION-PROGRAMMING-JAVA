package class06;

public abstract class Animal 
{
	String name;

	public Animal(String name) 
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public abstract void speak();
}