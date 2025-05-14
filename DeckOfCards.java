import java.util.Arrays;
import java.util.Random;



// class for the entire deck of cards
public class DeckOfCards
{
	private Card[] deck; // array of Card objects
	private static final int NUMBER_OF_CARDS = 52; // constant # of Cards
	
	private String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six", 
			"Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
	
	private String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
	
	// random number generator
	private static final Random randomNumbers = new Random();

	// constructor fills deck of Cards
	public DeckOfCards()
	{
		deck = new Card[ NUMBER_OF_CARDS ]; // create array of Card objects

		// populate deck with Card objects
		for ( int count = 0; count < deck.length; count++ ) 
			deck[ count ] = 
			new Card( faces[ count % 13 ], suits[ count / 13 ] );
	} 

	// shuffle deck of Cards with one-pass algorithm
	public void shuffle()
	{
		// for each Card, pick another random Card (0-51) and swap them
		for ( int first = 0; first < deck.length; first++ ) 
		{
			// select a random number between 0 and 51 
			int second =  randomNumbers.nextInt( NUMBER_OF_CARDS );

			// swap current Card with randomly selected Card
			Card temp = deck[ first ];        
			deck[ first ] = deck[ second ];   
			deck[ second ] = temp;            
		} 
	} 

	// Split the deck into two piles
	public Card[][] splitPiles() {
		// Create two arrays for the two piles
		Card[] pile1 = Arrays.copyOfRange(deck, 0, deck.length / 2);
		Card[] pile2 = Arrays.copyOfRange(deck, deck.length / 2, deck.length);

		// Returns the piles as a 2D array
		return new Card[][] {pile1, pile2};
	}
} 
