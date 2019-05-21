/** 
 * 12131819 YOOK DONGHYUN
 * Java Application Programming-002 (Prof. Tamer) // Assignment04
 * LinuxApp.java : define LinuxApp object and getter & setter methods for each field
 * Reporting Date : 2019-04-16
 */

package homework04;

public class LinuxApp extends DesktopApp // Child class of DesktopApp
{
	/** Member Fields */
	public String inventor;
	
	/** Member Methods */
	/* Constructor */
	public LinuxApp(String name, String resolution, String inventor) 
	{
		super(name, resolution);
		this.setPlatform("Linux");
		this.setInventor(inventor);
	}

	/* Getter & Setter Methods for each field */
	public String getInventor() { return this.inventor; }
	public void setInventor(String inventor) { this.inventor = inventor; }
	
	/* Override or redefine parent class' method */
	@Override
	public void showAppInfo() 
	{
		super.showAppInfo(); // using parent's method
		
		// below are the additional process for child class
		String result = String.format("Inventor: %s\n", this.getInventor());
		System.out.println(result);
	}
}