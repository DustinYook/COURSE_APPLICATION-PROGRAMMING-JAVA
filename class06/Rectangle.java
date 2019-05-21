package class06;

//if some class extends abstract class, it should implement abstract method or to be set as abstract class
public class Rectangle extends TwoDimensionalShape implements ShapeType
{
	public Rectangle(double width, double height) 
	{
		super(width, height);
	}

	@Override // implements abstract method
	public double getPerimeter() 
	{
		return 2 * (super.getDim1() + super.getDim2());
	}

	@Override // implements abstract method
	public double getArea() 
	{
		return (super.getDim1() * super.getDim2());
	}
	
	@Override // overrides original method to do specific jobs
	public String toString() 
	{
		return "This object is " + String.format("[%s]", "Rectangle") + "\n" +
				"Perimeter is " + String.format("%.3f", this.getPerimeter()) + "\n" +
				"Area is " + String.format("%.3f", this.getArea()) + "\n";
	}

	@Override
	public void speak() 
	{
		System.out.println("Rectangle speaks!");
	}
}