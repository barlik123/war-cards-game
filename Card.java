public class Card 
{
	private String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six", 
			"Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };

	private String face; // face of card ("Ace", "Deuce", ...)
	private String suit; // suit of card ("Hearts", "Diamonds", ...)
	private int cardVal; // card's numbered value (based on the faces)

	// two-argument constructor initializes card's face and suit
	public Card( String cardFace, String cardSuit )
	{
		face = cardFace; // initialize face of card
		suit = cardSuit; // initialize suit of card
		cardVal = findValue(faces,cardFace);
	} 
	
	//helper functions that calculates the face 'value' of the card
	private static int findValue(String[] faces, String face) {
		for (int val = 0; val < faces.length; val++) {
			if (faces[val].equals(face)) {
				return val;
			}
		}
		return -1;
	}

	// return String representation of Card
	public String toString() 
	{ 
		return face + " of " + suit;
	} 
	
	// returns the card's value
	public int getCardVal() {
		return cardVal;
	}
} 