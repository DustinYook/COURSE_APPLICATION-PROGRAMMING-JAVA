/**
 * 12131819 YOOK DONGHYUN
 * Description : Rectangle class
 */
package class03;

public class Rectangle 
{
	/** member variables */
	private double height;
	private double width;
	
	/** Default constructor */
	Rectangle() // the mission for the constructor is to initialize variables in your class
	{
		// using default value to prevent errors
		this.height = 0.0;
		this.width = 0.0;
	}
	
	/** Overloaded constructor */
	Rectangle(double rectHeight, double rectWidth)
	{
		setHeight(rectHeight);
		setWidth(rectWidth);
		// Warning! if you just assign value without using setter method, no validity-checking is provided.
	}
	
	/** Setter method for height member variable */
	public void setHeight(double rectHeight)
	{
		if(rectHeight > 0.0 && rectHeight < 20.0)
			this.height = rectHeight;
		else
			System.out.println("the value should be between 0 and 20!");
	}
	
	/** Setter method for height width variable */
	public void setWidth(double rectWidth)
	{
		if(rectWidth > 0.0 && rectWidth < 20.0)
			this.width = rectWidth;
		else
			System.out.println("the value should be between 0 and 20!");
	}
	
	/** calculator method to get perimeter of rectangle */
	public double calcPerimeter()
	{
		return 2 * (this.height + this.width);
	}
	
	/** calculator method to get area of rectangle */
	public double calcArea()
	{
		return (this.height * this.width);
	}
	
	/** rectangle-draw method */
	public void drawRectangle()
	{
		for(int i = 0 ; i < this.height; i++)
		{
			for(int j = 0; j < this.width; j++)
				System.out.print("* ");
			System.out.println();
		}
	}
	
	/** calculator method to get diagonal length of rectangle */
	public double calcDiagonal()
	{
		return (Math.sqrt(Math.pow(this.height, 2) + Math.pow(this.width, 2)));
	}
	
	/** printer method to show information about rectangle */
	public void printRectInfo()
	{
		System.out.println("Height : " + this.height);
		System.out.println("Width : " + this.width);
		System.out.println("Perimeter : " + calcPerimeter());
		System.out.println("Area : " + calcArea());
		System.out.format("Diagonal length is %.2f\n", calcDiagonal());
		System.out.println("Drawing:");
		drawRectangle();
	}
}