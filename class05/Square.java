package class05;

public class Square extends Rectangle 
{
	public Square(String name, double side) 
	{
		super(name, side, side);
	}
	
	public void setSide(double side)
	{
		super.setWidth(side);
		super.setHeight(side);
	}
	
	public double getSide()
	{
		return super.getWidth();
	}

	@Override
	public String getClassName() 
	{
		return "Square";
	}
	
	@Override
	public String toString() 
	{
		return String.format("%s is a [%s], and is a [%s]\n", super.getName(), getClassName(), super.getClassName());
	}
}