/** 
 * 12131819 YOOK DONGHYUN
 * Java Application Programming-002 (Prof. Tamer) // Assignment04
 * WindowsApp.java : define WindowsApp object and getter & setter methods for each field
 * Reporting Date : 2019-04-16
 */

package homework04;

public class WindowsApp extends DesktopApp // Child class of DesktopApp
{
	/** Member Fields */
	// None
	
	/** Member Methods */
	/* Constructor */
	public WindowsApp(String name, String resolution) 
	{
		super(name, resolution);
		this.setPlatform("Windows");
	}
	
	/* Override or redefine parent class' method */
	@Override
	public void showAppInfo() 
	{
		super.showAppInfo(); // using parent's method
		System.out.println();
	}
}