package class06;

public abstract class TwoDimensionalShape implements TwoDimensionalShapeCalculations
{
	/** Common properties between all 2D shapes */
	private double dim1;
	private double dim2;
	
	/** Overloaded Constructor */
	public TwoDimensionalShape(double dim1, double dim2) 
	{
		this.dim1 = dim1;
		this.dim2 = dim2;
	}

	/** Getter & Setter methods for each field */
	public double getDim1() 
	{
		return this.dim1;
	}

	public void setDim1(double dim1) 
	{
		this.dim1 = dim1;
	}

	public double getDim2() 
	{
		return this.dim2;
	}

	public void setDim2(double dim2) 
	{
		this.dim2 = dim2;
	}
}