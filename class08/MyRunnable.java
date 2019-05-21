package class08;

public class MyRunnable implements Runnable
{
	@Override
	public void run() 
	{
		System.out.println("MyRunnable running");
	}
	
	public static void main(String[] args) 
	{
		Thread myThread = new Thread(new MyRunnable());
		myThread.start();
	}
}