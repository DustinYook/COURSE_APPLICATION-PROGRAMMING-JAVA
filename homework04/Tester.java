/** 
 * 12131819 YOOK DONGHYUN
 * Java Application Programming-002 (Prof. Tamer) // Assignment04
 * Tester.java : generate object and test whether it works or not.
 * Reporting Date : 2019-04-16
 */

package homework04;

public class Tester // User Class which reads & writes the application classes 
{
	public static void releaseDateInitializer(Application[] apps)
	{
		int[][] releaseDates = {
									{23, 07, 2005}, {4, 01, 2016}, {19, 03, 2019}, 
									{29, 8, 2003}, {24, 2, 2019}, {12, 3, 2018}
							   };
		
		for(Application app : apps) // Using polymorphism to initialize release dates
			for(int i = 0; i < releaseDates.length; i++)
				app.setReleaseDate(releaseDates[i][0], releaseDates[i][1], releaseDates[i][2]);
	}
	
	public static void printOutInfo(Application[] apps)
	{
		for(Application app : apps)
			app.showAppInfo();
	}
	
	public static void main(String[] args) 
	{
		// Using polymorphism to implement easier way to initialize and print out
		Application[] apps = { 
								new WebApp("Reddit", "www.reddit.com", "bluehost"),
								new iOSApp("Clash Royale", 12.04, "iTunes Store"),
								new AndroidApp("KakaoTalk", 9.0, 5),
								new WindowsApp("Skype", "1920x1080"),
								new LinuxApp("Git", "1680x1050", "Linus Torvalds"),
								new MacOSApp("Amphetamine", "1600x900", "Mac Book Pro")
							 };
		
		releaseDateInitializer(apps);
		printOutInfo(apps);
	}
}