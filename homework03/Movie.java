/** 
 * 12131819 YOOK DONGHYUN
 * Java Application Programming-002 (Prof. Tamer) // Assignment03
 * Movie.java : define movie object and getter & setter methods for each field
 * Reporting Date : 2019-04-08
 */

package homework03;

import java.lang.NullPointerException;

public class Movie 
{
	/** instance variable */
	private String title;
	private int duration;
	private int year;
	private String[] castOfActors;
	private String genre;
	private String plotSummary;
	
	/** class variable */
	static int start = 60 * 10; // start 10 AM (10 * 60) 
	// class variable is shared through all instances, so that means it can be used for accumulation 
	
	/* constructor */ 
	public Movie(String title, int duration, int year, String[] castOfActors) 
	{
		this.castOfActors = new String[4];
		// using setter method to take advantage of validity checking
		this.setTitle(title);
		this.setDuration(duration);
		this.setYear(year);
		this.setCastOfActors(castOfActors);
	}
	
	/* overloaded constructor */ 
	public Movie(String title, int duration, int year, String[] castOfActors, String genre) 
	{
		this.castOfActors = new String[4];
		// using setter method to take advantage of validity checking
		this.setTitle(title);
		this.setDuration(duration);
		this.setYear(year);
		this.setCastOfActors(castOfActors);
		this.setGenre(genre);
	}
	
	/* overloaded constructor */ 
	public Movie(String title, int duration, int year, String[] castOfActors, String genre, String plotSummary) 
	{
		this.castOfActors = new String[4];
		// using setter method to take advantage of validity checking
		this.setTitle(title);
		this.setDuration(duration);
		this.setYear(year);
		this.setCastOfActors(castOfActors);
		this.setGenre(genre);
		this.setPlotSummary(plotSummary);
	}

	/* getter & setter methods for each field */
	public String getTitle() 
	{
		return this.title;
	}
	
	public void setTitle(String title) 
	{
		if(title.length() > 20) // length of title won't be greater than 20 symbols
		{
			System.out.println("Length is big. Cut to 20 symbols.");
			this.title = title.substring(0, 20);
		}
		else
			this.title = title;
	}
	
	public int getDuration() 
	{
		return this.duration;
	}
	
	public void setDuration(int duration) 
	{
		if(duration >= 60 && duration <= 180) // duration from 1hour to 3hours
			this.duration = duration;
		else
		{
			System.out.println("Invalid duration. Set to 1.5 hrs.");
			this.duration = 90;
		}
	}
	
	public int getYear() 
	{
		return this.year;
	}
	
	public void setYear(int year) 
	{
		if(year >= 2000 && year <= 2020) // year should be from 2000 to 2020
			this.year = year;
		else
		{
			System.out.println("Invalid year. Set to 2019.");
			this.year = 2019;
		}
	}
	
	public String getCastOfActors() 
	{
		String result = "";
		for(int i = 0; i < this.castOfActors.length; i++)
		{
			if(i == this.castOfActors.length - 1)
				result += this.castOfActors[i] + "."; 
			// if it is the last one, put dot(.) instead of comma(,)
			else
				result += this.castOfActors[i] + ", ";
		}
		return result;
	}
	
	public void setCastOfActors(String[] castOfActors) 
	{
		try
		{
			if(castOfActors.length < 5)
				this.castOfActors = castOfActors;
			else
			{
				for(int i = 0; i <= this.castOfActors.length; i++)
				{
					if(i < this.castOfActors.length)
						this.castOfActors[i] = castOfActors[i];
				}
			}
		}
		catch(NullPointerException exception)
		{
			System.out.println(exception);
		}
	}
	
	public String getGenre() 
	{
		return this.genre;
	}

	public void setGenre(String genre) 
	{
		this.genre = genre;
	}

	public String getPlotSummary() 
	{
		return this.plotSummary;
	}

	public void setPlotSummary(String plotSummary) 
	{
		this.plotSummary = plotSummary;
	}

	/* get time with format #1 */
	public String getTime(int timeValue)
	{
		int hour = timeValue / 60;
		int minute = timeValue % 60;
		return (hour < 10 ? "0" + Integer.toString(hour) : Integer.toString(hour)) + ":" 
				+ (minute < 10 ? "0" + Integer.toString(minute) : Integer.toString(minute));
	}
	
	/* get time with format #2 */
	public String getTimeFormat(int timeValue)
	{
		int hour = timeValue / 60;
		int minute = timeValue % 60;
		// if hour or minute is plural form I put 's' behind, or not I set singular form
		return (hour != 1 ? Integer.toString(hour) + "hrs" : Integer.toString(hour) + "hr") + " " +
			   (minute == 0 ? "" : (minute == 1 ? Integer.toString(minute) + "min" : Integer.toString(minute) + "mins"));
	}
	
	/* show additional movie information */
	public String showAddtionalInfo()
	{
		return "*** " + "\"" + this.getTitle() + "\"" + " ***\n" +
				"Duration: " + this.getTimeFormat(this.getDuration()) + "\n" + // I added duration with time format
				"Genre: " + this.getGenre() + "\n" +
				"Plot Summary: " + this.getPlotSummary() + "\n";
	}

	@Override
	public String toString() 
	{
		return "*** " + "\"" + this.getTitle() + "\"" + " ***\n" +
	           "Year: " + this.getYear() + "\n" + 
			   "Main roles: " + this.getCastOfActors() + "\n" +
	           "--- Start time: " + this.getTime(Movie.start) + " ---\n" +
			   "--- End time: " + this.getTime(Movie.start += this.duration) + " ---";
	}
}