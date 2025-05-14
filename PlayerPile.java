
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

// class for a player's pile of cards
public class PlayerPile {
	private Deque<Card> pile;
	
	public PlayerPile(Card[] cards) {
		pile = new ArrayDeque<>(Arrays.asList(cards));
	}
	
	//Methods that adds cards to the bottom of a pile
	public void addCardToBottom(ArrayList<Card> cards) {
		for (Card card : cards) {
			pile.addLast(card);
		}
	}
	
	// Method to remove a Card from the top of the pile and return it
	public Card removeCardFromTop() {
		if (!pile.isEmpty()) {
			return pile.removeFirst();
		}
		else {
			return null;
		}
	}
	
	//Method to get the size of the pile
	public int getSize() {
		return pile.size();
	}
}
