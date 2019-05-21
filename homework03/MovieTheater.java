/** 
 * 12131819 YOOK DONGHYUN
 * Java Application Programming-002 (Prof. Tamer) // Assignment03
 * MovieTheater.java : define movie theater object and getter & setter methods for each field
 * Reporting Date : 2019-04-08
 */

package homework03;

import java.util.Random;
import java.lang.NullPointerException;

public class MovieTheater 
{
	public Movie[] movies;
	Random rand;
	final int MAX = 3;
	final int MIN = 0;
	
	public MovieTheater(Movie[] mv)
	{
		rand = new Random();
		movies = new Movie[4]; // create Movie array
		
		try
		{
			for(int i = 0; i < movies.length; i++)
				movies[i] = mv[i]; // allocate elements to Movie array
		}
		catch(NullPointerException exception)
		{
			System.out.println(exception);
		}
	}
	
	public void makeSchedule()
	{
		int[] randomNumbers = new int[4];
		
		for(int i = 0; i < randomNumbers.length; i++)
			randomNumbers[i] = -1; // initialize with impossible value for random
		
		boolean flag = false;
		for(int i = 0; i < 4; i++) 
		{
			do 
			{
				flag = false;
				randomNumbers[i] = rand.nextInt((MAX - MIN) + 1) + MIN;
	            
				// check whether it generates the same number or not
				for(int j = 0; j < i; j++)
				{
					if(randomNumbers[i] == randomNumbers[j])
						flag = true; // if it has the same number, set flag true
				}
			} while (flag == true); 
		}
		
		for(int i : randomNumbers)
		{
			System.out.println(movies[i] + "\n"); // print out movie information
			Movie.start += 30; // consider 30 minutes break between movies (except for first one)
		}
	}
}