package class04;

import java.util.Random;import javax.security.auth.callback.TextOutputCallback;

public class DeckOfCards 
{
	public static final int TOTAL_CARDS = 52;
	public Card[] deck; // array of card objects to store 52 cards
	
	public Random randNum;
	public int currentCard; // current card position
	
	public DeckOfCards()
	{
		deck = new Card[TOTAL_CARDS]; // generate array for card object
		randNum = new Random();
		
		int i = 0; // control card index
		
		for(int suit = Card.DIAMOND; suit <= Card.SPADE; suit++) // decide suit type
			for(int rank = 0; rank < 13; rank++) // decide rank type
				deck[i++] = new Card(rank, suit);
		
		currentCard = 0;
	}
	
	public void shuffle()
	{
		for(int i = 0; i < deck.length; i++)
		{
			int j = randNum.nextInt(TOTAL_CARDS);
			
			// swap operation
			Card temp = deck[i];
			deck[i] = deck[j];
			deck[j] = temp;
		}
	}
	
	public Card deal() // give one card to user
	{
		if(currentCard >= TOTAL_CARDS)
		{
			System.out.println("No card left");
			return null;
		}
		
		return (deck[currentCard++]);
	}
	
	public static void main(String[] args) 
	{
		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle();
		
		for(int i = 0; i < DeckOfCards.TOTAL_CARDS; i++)
		{
			System.out.format("%-19s", myDeckOfCards.deal());
			
			if((i + 1) % 4 == 0)
				System.out.println();
		}
	}
}