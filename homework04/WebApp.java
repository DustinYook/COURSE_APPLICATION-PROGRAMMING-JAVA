/** 
 * 12131819 YOOK DONGHYUN
 * Java Application Programming-002 (Prof. Tamer) // Assignment04
 * WebApp.java : define WebApp object and getter & setter methods for each field
 * Reporting Date : 2019-04-16
 */

package homework04;

public class WebApp extends Application // Child class of Application
{
	/** Member Fields */
	public String URL; 
	public String hostingProvider;
	
	/** Member Methods */
	/* Constructor */
	public WebApp(String name, String URL, String hostingProvider) 
	{
		super(name);
		this.setPlatform("Web");
		this.setURL(URL);
		this.setHostingProvider(hostingProvider);
	}

	/* Getter & Setter Method for each field */
	public String getURL() { return this.URL; }
	public void setURL(String URL) { this.URL = URL; }

	public String getHostingProvider() { return this.hostingProvider; }
	public void setHostingProvider(String hostingProvider) { this.hostingProvider = hostingProvider; }

	/* Implements Parent class' abstract method */
	@Override
	public void	showAppInfo() 
	{
		String result = String.format("*** %s ***\n", this.getName()) +
		String.format("Release Date: %s\n", this.getReleaseDate()) +
		String.format("URL: %s\n", this.getURL()) +
		String.format("Platform: %s\n", this.getPlatform());
		
		System.out.println(result);
	}
}