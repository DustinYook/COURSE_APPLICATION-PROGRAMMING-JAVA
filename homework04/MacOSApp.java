/** 
 * 12131819 YOOK DONGHYUN
 * Java Application Programming-002 (Prof. Tamer) // Assignment04
 * MaxOSApp.java : define MacOSApp object and getter & setter methods for each field
 * Reporting Date : 2019-04-16
 */

package homework04;

public class MacOSApp extends DesktopApp // Child class of DesktopApp
{
	/** Member Fields */
	public String deviceType;
	
	/** Member Methods */
	/* Constructor */
	public MacOSApp(String name, String resolution, String deviceType) 
	{
		super(name, resolution);
		this.setPlatform("MacOS");
		this.setDeviceType(deviceType);
	}

	/* Getter & Setter Methods for each field */
	public String getDeviceType() { return this.deviceType; }
	public void setDeviceType(String deviceType) { this.deviceType = deviceType; }
	
	/* Override or redefine parent class' method */
	@Override
	public void showAppInfo() 
	{
		super.showAppInfo(); // using parent's method
		
		// below are the additional process for child class
		String result = String.format("Device Type: %s\n", this.getDeviceType());
		System.out.println(result);
	}
}