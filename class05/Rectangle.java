package class05;

public class Rectangle extends TwoDimensionalShape 
{
	public Rectangle(String name, double width, double height) 
	{
		super(name, width, height);
	}

	@Override
	public String getClassName() 
	{
		return "Rectangle";
	}
	
	public void setWidth(double width)
	{
		super.setDimension1(width);
	}
	
	public double getWidth()
	{
		return super.getDimension1();
	}

	public void setHeight(double height)
	{
		super.setDimension2(height);
	}
	
	public double getHeight()
	{
		return super.getDimension2();
	}
	
	// or this way of using setter is allowed
	public void setSize(double width, double height)
	{
		super.setDimension1(width);
		super.setDimension2(height);
	}
	
	@Override
	public double getArea() 
	{
		return (this.getWidth() * this.getHeight());
	}
	
	@Override
	public String toString() 
	{
		return String.format("%s is a [%s], and is a [%s]\n", super.getName(), getClassName(), super.getClassName());
	}
}