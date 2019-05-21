package class05;

public class Triangle extends TwoDimensionalShape
{
	public Triangle(String name, double width, double height) 
	{
		super(name, width, height);
	}
	
	@Override
	public String getClassName() 
	{
		return "Triangle";
	}
	
	public double getWidth()
	{
		return super.getDimension1();
	}
	
	public void setWidth(double width) 
	{
		super.setDimension1(width);
	}
	
	public double getHeight()
	{
		return super.getDimension2();
	}
	
	public void setHeight(double height) 
	{
		super.setDimension2(height);
	}
	
	public double getAnotherSide()
	{
		return Math.sqrt(Math.pow(this.getWidth(), 2) + Math.pow(this.getHeight(), 2));
	}
	
	@Override
	public double getArea()
	{
		return (1/2 * this.getWidth() * this.getHeight());
	}
	
	@Override
	public String toString() 
	{
		return String.format("%s is a [%s], and is a [%s]\n", super.getName(), getClassName(), super.getClassName());
	}
}