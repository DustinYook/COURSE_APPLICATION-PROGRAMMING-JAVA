package class06;

public class Circle extends TwoDimensionalShape implements ShapeType
{
	public Circle(double radius) // extends하는 경우 super생성자 필요!
	{
		super(radius, radius);
	}

	@Override
	public double getPerimeter() 
	{
		return 2 * Math.PI * super.getDim1();
	}

	@Override
	public double getArea() 
	{
		return Math.PI * Math.pow(super.getDim1(), 2);
	}

	@Override
	public String toString() 
	{
		return "This object is " + String.format("[%s]", "Circle") + "\n" +
				"Perimeter is " + String.format("%.3f", this.getPerimeter()) + "\n" +
				"Area is " + String.format("%.3f", this.getArea()) + "\n";
				
	}

	@Override
	public void speak() 
	{
		System.out.println("Circle speaks!");
	}
}