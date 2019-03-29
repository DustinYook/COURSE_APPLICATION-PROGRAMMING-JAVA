package class04;

public class Card 
{
	/** class variables */
	// four types of card suit
	public static final int DIAMOND = 0;
	public static final int CLUB = 1;
	public static final int HEART = 2;
	public static final int SPADE = 3;
	
	// String arrays for printing purposes
	public static final String[] SUIT_STRING = {"Diamonds", "Clubs", "Hearts", "Spades"}; // 4
	public static final String[] RANK_STRING = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}; // 13

	/** instance variables */
	int rank;
	int suit;
	
	public Card(int rank, int suit)
	{
		setRank(rank);
		setSuit(suit);
	}
	
	public void setRank(int rank) 
	{
		this.rank = rank;
	}

	public void setSuit(int suit) 
	{
		this.suit = suit;
	}


	public int getRank()
	{
		return this.rank;
	}
	
	public int getSuit()
	{
		return this.suit;
	}
	
	// to print out object
	public String toString()
	{
		return RANK_STRING[rank] + " of " + SUIT_STRING[suit];
	}
}
