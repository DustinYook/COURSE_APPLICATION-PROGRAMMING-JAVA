package class04;

public class Point 
{
	int x;
	int y;
	
	public Point(int initX, int initY)
	{
		this.x = initX;
		this.y = initY;
	}
	
	public static double distanceFromOrigin()
	{
		int x = 3;
		int y = 4;
		Point p = new Point(x, y);
		double dist = Math.sqrt(p.x * x + p.y * y);
		return dist;
	}
	
	public void translate(int dx, int dy)
	{
		this.x += dx;
		this.y += dy;
	}
}