/** 
 * 12131819 YOOK DONGHYUN
 * Java Application Programming-002 (Prof. Tamer) // Assignment04
 * iOSApp.java : define iOSApp object and getter & setter methods for each field
 * Reporting Date : 2019-04-16
 */

package homework04;

public class iOSApp extends MobileApp // Child class of MobileApp
{
	/** Member Fields */
	public String distributor;
	
	/** Member Methods */
	/* Constructor */
	public iOSApp(String name, double OSVersion, String distributor) 
	{
		super(name, OSVersion);
		this.setPlatform("iOS");
		this.setDistributor(distributor);
	}

	/* Getter & Setter Methods for each field */
	public String getDistributor() { return this.distributor; }
	public void setDistributor(String distributor) { this.distributor = distributor; }

	/* Override or redefine parent class' method */
	@Override
	public void showAppInfo() 
	{
		super.showAppInfo(); // using parent's method
		
		// below are the additional process for child class
		String result = String.format("Available in %s\n", this.getDistributor());
		System.out.println(result);
	}
}