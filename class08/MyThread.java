package class08;

public class MyThread extends Thread
{
	// override the run method
	@Override
	public void run()
	{
		System.out.println("MyThread running");
	}
	
	public static void main(String[] args) 
	{
		MyThread my = new MyThread(); // MyThread("1"); -> We need to define constructor
		my.start();
	}
}