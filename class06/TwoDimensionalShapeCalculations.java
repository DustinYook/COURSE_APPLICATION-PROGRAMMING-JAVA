package class06;

public interface TwoDimensionalShapeCalculations 
{
	// Common behavior between all 2D shapes
	public abstract double getPerimeter();
	public abstract double getArea(); // interface 내의 method는 디폴트로 abstract method
	public abstract String toString();
}