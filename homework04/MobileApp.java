/** 
 * 12131819 YOOK DONGHYUN
 * Java Application Programming-002 (Prof. Tamer) // Assignment04
 * MobileApp.java : define MobileApp object and getter & setter methods for each field
 * Reporting Date : 2019-04-16
 */

package homework04;

public class MobileApp extends Application // Child class of Application
{
	/** Member Fields */
	public double OSVersion;

	/** Member Methods */
	/* Constructor */
	public MobileApp(String name, double OSVersion) 
	{
		super(name);
		this.setOSVersion(OSVersion);
	}

	/* Getter & Setter methods for each field */
	public double getOSVersion() { return this.OSVersion; }
	public void setOSVersion(double OSVersion) { this.OSVersion = OSVersion; }

	/* Implements Parent class' abstract method */
	@Override
	public void showAppInfo() 
	{
		String result = String.format("*** %s ***\n", this.getName()) +
				String.format("Release Date: %s\n", this.getReleaseDate()) +
				String.format("Platform: %s v%.2f\n", this.getPlatform(), this.getOSVersion());
		System.out.print(result);
	}
}