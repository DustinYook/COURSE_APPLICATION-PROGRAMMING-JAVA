/** 
 * 12131819 YOOK DONGHYUN
 * Java Application Programming-002 (Prof. Tamer) // Assignment04
 * AndroidApp.java : define AndroidApp object and getter & setter methods for each field
 * Reporting Date : 2019-04-16
 */

package homework04;

public class AndroidApp extends MobileApp // Child class of MobileApp
{
	/** Member Fields */
	public int rating;
	
	/** Member Methods */
	/* Constructor */
	public AndroidApp(String name, double OSVersion, int rating) 
	{
		super(name, OSVersion);
		this.setPlatform("Android");
		this.setRating(rating);
	}

	/* Getter & Setter Methods for each field */
	public int getRating() { return this.rating; }
	public void setRating(int rating) { this.rating = rating; }
	
	/* Override or redefine parent class' method */
	@Override
	public void showAppInfo() 
	{
		super.showAppInfo(); // using parent's method
		
		// below are the additional process for child class
		String result = String.format("Rating : %d Star(s)\n", this.getRating());
		System.out.println(result);
	}
}