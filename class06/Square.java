package class06;

public class Square extends Rectangle implements ShapeType
{
	public Square(double dim) 
	{
		super(dim, dim);
	}
	
	@Override
	public String toString() 
	{
		return "This object is " + String.format("[%s]", "Square") + "\n" +
				"Perimeter is " + String.format("%.3f", this.getPerimeter()) + "\n" + 
				"Area is " + String.format("%.3f", this.getArea()) + "\n";
	}

	@Override
	public void speak() 
	{
		System.out.println("Square speaks!");
	}
}