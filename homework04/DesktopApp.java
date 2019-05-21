/** 
 * 12131819 YOOK DONGHYUN
 * Java Application Programming-002 (Prof. Tamer) // Assignment04
 * DesktopApp.java : define DesktopApp object and getter & setter methods for each field
 * Reporting Date : 2019-04-16
 */

package homework04;

public class DesktopApp extends Application // Child class of Application
{
	/** Member Fields */
	public String resolution;
	
	/** Member Methods */
	/* Constructor */
	public DesktopApp(String name, String resolution) 
	{
		super(name);
		this.setResolution(resolution);
	}

	/* Getter & Setter Methods for each field */
	public String getResolution() { return this.resolution; }
	public void setResolution(String resolution) { this.resolution = resolution; }

	/* Implements Parent class' abstract method */
	@Override
	public void showAppInfo() 
	{
		String result = String.format("*** %s ***\n", this.getName()) +
				String.format("Release Date: %s\n", this.getReleaseDate()) +
				String.format("Platform: %s, ", this.getPlatform()) +
				String.format("Resolution: %s\n", this.getResolution());
		System.out.print(result);
	}
}