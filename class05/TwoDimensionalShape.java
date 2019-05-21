package class05;

public class TwoDimensionalShape 
{
	private String name;
	private double dimension1; // x축 성분
	private double dimension2; // y축 성분
	
	public TwoDimensionalShape(String name, double dimension1, double dimension2) 
	{
		this.name = name;
		this.setDimension1(dimension1);
		this.setDimension2(dimension2);
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public double getDimension1() 
	{
		return this.dimension1;
	}

	public void setDimension1(double dimension1) 
	{
		this.dimension1 = dimension1;
	}

	public double getDimension2() 
	{
		return this.dimension2;
	}

	public void setDimension2(double dimension2) 
	{
		this.dimension2 = dimension2;
	}

	public String getClassName()
	{
		return "2D Shape";
	}
	
	public double getArea()
	{
		return 0;
	}
}