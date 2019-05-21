/** 
 * 12131819 YOOK DONGHYUN
 * Java Application Programming-002 (Prof. Tamer) // Assignment04
 * Application.java : define Application object and getter & setter methods for each field
 * Reporting Date : 2019-04-16
 */

package homework04;

public abstract class Application // Parent class of Web, Mobile, Desktop
{
	/** Member Fields */
	public String name;
	public String platform;
	public String developer;
	public String releaseDate;
	
	/** Member Methods */
	/* Constructor */
	public Application(String name) { this.setName(name); }

	/* Getter & Setter Methods for each field */
	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }
	
	public String getPlatform() { return this.platform; }
	public void setPlatform(String platform) { this.platform = platform; }

	public String getDeveloper() { return this.developer; }
	public void setDeveloper(String developer) { this.developer = developer; }

	public String getReleaseDate() { return this.releaseDate; }
	public void setReleaseDate(int date, int month, int year) 
	{
		String[] months = { null, "January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int[] validDates = { -1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		
		if((year >= 1900 && year <= 2019) && (month >= 1 && month <= 12) && (date >= 1 && date <= validDates[month]))
			this.releaseDate = String.format("%s %d, %d", months[month], date, year);
		else
			System.out.println("Wrong input!");
	}
	
	/* Abstract Method */
	public abstract void showAppInfo();
}