// Jonathan Wang
package monopoly;

import java.util.ArrayList;

import players.Player;

// Represents a collection of Cards, ie. Chance or Community Chest.
public class CardPile {
	// ArrayList of the cards that are in the pile & can be drawn.
	ArrayList<Card> available;
	// An arrayList of the cards that have been drawn already, and are not held by players.
	ArrayList<Card> unavailable;
	// A copy of the getOutOfJail card, so only 1 instantiation is needed.
	private Card getOutOfJailCopy = new GetOutOfJailCard();
	// The player that owns the getOutOfJail card. Can be null indicating no one owns.
	Player ownsGetOutOfJail;

	/* Constructs a new CardPile.
	 * Precondition: a CardPile needs to be instantiated.
	 * @param: an ArrayList of cards that are available in the card pile.
	 * Postcondition: the cardPile is instantiated with the available cards.
	 */
	public CardPile(ArrayList<Card> cAvailable) {
		available = cAvailable;
		unavailable = new ArrayList<Card>();
		ownsGetOutOfJail = null;
	}

	/* Draws a card from the available cards.
	 * Precondition: The board is filled with properties, the players are instantiated, a player is on a Chance or CommunityChest property.
	 * @return the card drawn.
	 * Postcondition: 
	 * 		If there are no more cards left, the unavailable cards get placed into the available cards.
	 * 		If the card drawn is a getOutOfJailCard, the owner gets set to thePlayer.
	 * 		Otherwise, the card gets sent to the unavailable section.
	 */
	public Card draw() {
		// Check if need to shuffle the deck
		if (available.size() == 0) {
			// Shuffles by adding the unavailable cards back into the available deck.
			// Note that since cards are drawn randomly, there is no need to randomize here.
			available = unavailable;
			unavailable = new ArrayList<Card>();
		}

		// Chooses random card
		int raNum = (int) (Math.random() * available.size());
		Card answer = available.get(raNum);
		available.remove(answer); // Removes it from available
		if (ownsGetOutOfJail == null && answer.getCardType() == "GetOutOfJailCard") {
			// Gives ownership of the GetOutOfJail card to the player that drew it.
			ownsGetOutOfJail = Board.getCurrentPlayer();
		}
		else {
			unavailable.add(answer); // Adds it to unavailable
		}
		return answer;
	}
	
	/* Uses the get out of jail card
	 * Precondition: The board is filled with properties, the players are instantiated, the player used a getOutOfJailCard to get out of jail.
	 * Postcondition: The card's owner gets reset, the card gets added to unavailable cards.
	 */
	public void useJailCard() {
		unavailable.add(getOutOfJailCopy);
		ownsGetOutOfJail = null;
	}

	// Gets the player that owns the getOutOfJail card.
	public Player getPlayerOwned() {
		return ownsGetOutOfJail;
	}
}
