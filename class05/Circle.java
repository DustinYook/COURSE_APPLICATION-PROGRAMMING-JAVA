package class05;

public class Circle extends TwoDimensionalShape
{
	public Circle(String name, double radius) 
	{
		super(name, radius, radius);
	}

	@Override
	public String getClassName() 
	{
		return "Circle";
	}
	
	public double getRadius()
	{
		return super.getDimension1();
	}
	
	public void setRadius(double radius)
	{
		super.setDimension1(radius);
		super.setDimension2(radius);
	}

	@Override
	public double getArea() 
	{
		return Math.PI * Math.pow(this.getRadius(), 2);
	}

	@Override
	public String toString() 
	{
		return String.format("%s is a [%s], and is a [%s]\n", super.getName(), getClassName(), super.getClassName());
	}
}