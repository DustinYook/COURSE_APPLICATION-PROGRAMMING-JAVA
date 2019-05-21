package class05;

public class Main 
{
	public static void main(String[] args) 
	{
		Circle c = new Circle("Clock", 10);
		System.out.print(c.toString());
		System.out.println("Radius is " + c.getRadius());
		System.out.println("Area is " + c.getArea());
		System.out.println();
		
		Rectangle r = new Rectangle("Board", 10, 20);
		System.out.print(r.toString());
		System.out.println("Width is " + r.getWidth());
		System.out.println("Height is " + r.getHeight());
		System.out.println("Area is " + r.getArea());
		System.out.println();
		
		Square s = new Square("Tile", 10);
		System.out.print(s.toString());
		System.out.println("Side is " + s.getSide());
		System.out.println("Area is " + s.getArea());
		System.out.println();
		
		System.out.print("Is Square a TwoDimensionalShape? : ");
		System.out.format("%b\n", s instanceof TwoDimensionalShape);
		System.out.print("Is Square a Rectangle? : ");
		System.out.format("%b\n", s instanceof Rectangle);
		System.out.print("Is Square a Square? : ");
		System.out.format("%b\n", s instanceof Square);
		System.out.println();
		
		Triangle t = new Triangle("Mountain", 3.0, 4.0);
		System.out.print(t.toString());
		System.out.println("Width is " + t.getWidth());
		System.out.println("Height is " + t.getHeight());
		System.out.println("Another side is " + t.getAnotherSide());
		System.out.println("Area is " + t.getArea());
		System.out.println();
	}
}