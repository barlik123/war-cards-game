import java.util.ArrayList;
import javafx.application.Application; 
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage; 

public class WarGame extends Application {

	private int roundsLimiter = 100; //limits the number of rounds of play to avoid infinitely looped game.
	final private int WARCARDSNUM = 2; //number of Cards to be drawn after tied round before the next 'combat' round.
	
	public void start(Stage stage) {
		DeckOfCards myDeckOfCards = new DeckOfCards();

		myDeckOfCards.shuffle(); // Shuffles the cards for random deck

		// Divides the cards between the players 
		Card[][] playersPiles = myDeckOfCards.splitPiles(); 
		PlayerPile player1 = new PlayerPile(playersPiles[0]); //player1's cards pile
		PlayerPile player2 = new PlayerPile(playersPiles[1]); //player2's cards pile

		ArrayList<Card> playersdraws = new ArrayList<Card>(); //players pile of played/displayed cards
		int roundCount = 0;
		int player1Size;
		int player2Size;
		String roundResults = "";
		Card card1;
		Card card2;
		
		// main game loop
		while ((player1.getSize() > 0 && player2.getSize() > 0) && (roundCount < roundsLimiter)) {
			player1Size = player1.getSize();
			player2Size = player2.getSize();

			// draws the cards from each player's top of the pile
			card1 = player1.removeCardFromTop();
			card2 = player2.removeCardFromTop();

			//adds round's cards to the central pile to determine who won them
			playersdraws.add(card1); 
			playersdraws.add(card2);

			if (card1.getCardVal() > card2.getCardVal()) {
				// In case where player1's card's value is larger he gets the draws pile.
				player1.addCardToBottom(playersdraws);
				playersdraws.clear();
				roundResults = "Player 1 won cards";
				displayInfo(player1Size, card1.toString(), player2Size, card2.toString(), roundResults);
			}
			else if (card1.getCardVal() < card2.getCardVal()) {
				// In case where player2's card's value is larger he gets the draws pile.
				player2.addCardToBottom(playersdraws);
				playersdraws.clear();
				roundResults = "Player 2 won cards";
				displayInfo(player1Size, card1.toString(), player2Size, card2.toString(), roundResults);
			}
			else if (card1.getCardVal() == card2.getCardVal()) {
				// In case of tied cards values, each player adds two cards to the draw pile
				// and moving on for another round 'third round'.
				// if one player doesn't have enough cards the game is finished
				if ((player1.getSize() > WARCARDSNUM) || (player2.getSize() > WARCARDSNUM)) {
					for(int i=0; i<2; i++) {
						player1Size = player1.getSize();
						player2Size = player2.getSize();
						card1 = player1.removeCardFromTop();
						card2 = player2.removeCardFromTop();
						playersdraws.add(card1);
						playersdraws.add(card2);
						roundResults = "War Phase"; //display for the war phase where the cards do not determine anything
						displayInfo(player1Size, card1.toString(), player2Size, card2.toString(), roundResults);
					}
				}
				else {
					break; // ends the game if player does not have enough cards
				}
			}
			roundCount++;
		}

		// displays the winning status in the end of the game based on the players' sizes of cards piles
		if (player1.getSize() == player2.getSize()) { 
			displayGameEnd("The game ended in a tie!");
		}
		else if (player1.getSize() > player2.getSize()) { 
			displayGameEnd("Player 1 won the game!");
		}
		else if (player1.getSize() < player2.getSize()) {
			displayGameEnd("Player 2 won the game!");
		}
	}
	// Method to display a game results with given game results string
	private void displayGameEnd(String gameResults) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("War Game status");
		alert.setHeaderText(gameResults);
		alert.showAndWait(); // Wait until the user closes the dialog
	}

	// Method to display a round status with given data about each player and round
	private void displayInfo(int player1PileSize, String player1Card, int player2PileSize, String player2Card, String roundResults) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("War Game status");
		alert.setHeaderText(roundResults);
		String round = "Player1: " + player1PileSize + "\n" + player1Card +
				"\nPlayer2: " + player2PileSize + "\n" + player2Card;
		alert.setContentText(round);
		alert.showAndWait(); // Wait until the user closes the dialog
	}

	public static void main(String[] args) {
		launch(args); // Launch the JavaFX application
	}
}

