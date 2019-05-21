package class06;

public class MainShape 
{
	public static void main(String[] args) 
	{
		TwoDimensionalShape[] arr = {new Circle(5), new Rectangle(3,4), new Square(2)}; // initialize list
		// TwoDimensionalShape[] arr = new TwoDimensionalShape[5]; // just reserve memory space (didn't create object)
		// arr[0] = new Circle(5); // Polymorphism
		
		for(int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
		// for(TwoDimensionalShape i : arr) // Same as above
		//    System.out.println(arr[i]);
		
		((Circle)arr[0]).speak();
		((Rectangle)arr[1]).speak();
		((Square)arr[2]).speak();
		// 주의) Rectangle r = (Rectangle)arr[1];
	}
}