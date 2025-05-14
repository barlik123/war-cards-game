# war-cards-game
## What is this game?
The "War" cards game is a two players game that involves a *card deck*.
*card deck*: 
  - size: 52 cards
  - appearance:
      * Each card have a face of 13 option -
          "Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"
      * And suit of 4 options -
          "Hearts", "Diamonds", "Clubs", "Spades"
      * Cards cannot be of the same (face,suit) permutation, hence there are 13*4= 52 cards.
   
  ## how does it work?
  To start, the card deck is shuffled and divided equally between the two players (26 cards each).
  Then both players draw a card from the top of their pile and the cards are compared based on their faces.
  for example Eight (Clubs) > Deuce (Hearts) because Eight is greater than Deuce aka 2.
  Then the player with the larger face collects both drawn piles.
  If both cards have the same face a "war" state is executed where both players draw 2 cards and then draw a 3rd card and compare it as explained previously.

  The game is displayed with pop-ups of the current draws and who won the round, or with the war state if entered. 

  When a player have no more cards left in his pile, the other player wins the game and the game is finished.
