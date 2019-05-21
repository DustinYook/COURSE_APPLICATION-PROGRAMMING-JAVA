/** 
 * 12131819 YOOK DONGHYUN
 * Java Application Programming-002 (Prof. Tamer) // Assignment03
 * Main.java : this is the place where the program can be run
 * Reporting Date : 2019-04-08
 */

package homework03;

import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		/** Setting casts for each movie */
		String[] avengersCast = {"Robert Downey Jr", "Chris Hemsworth", "Scarlett Johanson", "Mark Ruffalo"};
		String[] shazamCast = {"Zachary Levi", "Mark Strong", "Asher Angel", "Jack Dylan Grazer"};
		String[] hellboyCast = {"David Harbour", "Milla Jovovichi", "Ian McShane", "Sasha Lane"};
		String[] breakthroughCast = {"Sam Trammell", "Denni", "Haysbert", "Isaac Kragten"};
		
		/** Setting plot summary for each movie */
		String avengersPlot = "When Thor's evil brother, Loki (Tom Hiddleston), gains access to the unlimited power of the energy cube called the Tesseract, Nick Fury (Samuel L. Jackson), director of S.H.I.E.L.D., initiates a superhero recruitment effort to defeat the unprecedented threat to Earth. Joining Fury's \"dream team\" are Iron Man (Robert Downey Jr.), Captain America (Chris Evans), the Hulk (Mark Ruffalo), Thor (Chris Hemsworth), the Black Widow (Scarlett Johansson) and Hawkeye (Jeremy Renner).";
		String shazamPlot = "We all have a superhero inside of us -- it just takes a bit of magic to bring it out. In 14-year-old Billy Batson's case, all he needs to do is shout out one word to transform into the adult superhero Shazam. Still a kid at heart, Shazam revels in the new version of himself by doing what any other teen would do -- have fun while testing out his newfound powers. But he'll need to master them quickly before the evil Dr. Thaddeus Sivana can get his hands on Shazam's magical abilities.";
		String hellboyPlot = "At the end of World War II, the Nazis attempt to open a portal to a paranormal dimension in order to defeat the Allies, but are only able to summon a baby demon who is rescued by Allied forces and dubbed \"Hellboy\" (Ron Perlman). Sixty years later, Hellboy serves as an agent in the Bureau of Paranormal Research and Defense, where he, aided by Abe Sapien (Doug Jones), a merman with psychic powers, and Liz Sherman (Selma Blair), a woman with pyrokinesis, protects America against dark forces.";
		String breakthroughPlot = "BREAKTHROUGH is based on the inspirational true story of one mother’s unfaltering love in the face of impossible odds. When Joyce Smith’s adopted son John falls through an icy Missouri lake, all hope seems lost. But as John lies lifeless, Joyce refuses to give up. Her steadfast belief inspires those around her to continue to pray for John’s recovery, even in the face of every case history and scientific prediction. From producer DeVon Franklin (Miracles from Heaven) and adapted for the screen by Grant Nieporte (Seven Pounds) from Joyce Smith’s own book, BREAKTHROUGH is an enthralling reminder that faith and love can create a mountain of hope, and sometimes even a miracle.";
		
		/** Setting information for each movie */
		Movie avengers = new Movie("Avengers: Endgame", 180, 2019, avengersCast, "Hero", avengersPlot);
		Movie shazam = new Movie("Shazam!", 140, 2019, shazamCast, "Action", shazamPlot);
		Movie hellboy = new Movie("Hellboy", 180, 2019, hellboyCast, "SF", hellboyPlot);
		Movie breakthrough = new Movie("Breakthrough", 120, 2019, breakthroughCast, "Drama", breakthroughPlot);
		
		Movie[] movies = {avengers, shazam, hellboy, breakthrough};
		MovieTheater CGV = new MovieTheater(movies);
		
		User me = new User("12345", "1234asd"); // user account
		String inputId; // input ID
		String inputPw; // input password
		
		Scanner sc = new Scanner(System.in);
		
		/** Login Process */
		while(true)
		{
			System.out.print("Enter user ID: ");
			inputId = sc.nextLine();
			
			System.out.print("Enter user password: ");
			inputPw = sc.nextLine();
			System.out.println();
			
			if(me.login(inputId, inputPw) == true)
				break;
			else
				System.out.println("You entered wrong information, try again!\n");
		}
		
		/** Select Menu Process */
		while(true)
		{
			System.out.print("Choose menu you want to do (1: Check movie schedule, 2: Check additional information of movie, 3: Log out) => ");
			
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1: // Check movie schedule
				CGV.makeSchedule();
				break;
			case 2: // Check additional information of movie
				for(Movie m : CGV.movies)
					System.out.println(m.showAddtionalInfo());
				break;
			case 3: // Log out
				System.out.println("You successfully logged out!");
				break;
			}
			
			if(choice == 3) // if input is 3, then break the loop
				break;
		}
		
		sc.close(); // close scanner to prevent it from memory leakage
	}
}