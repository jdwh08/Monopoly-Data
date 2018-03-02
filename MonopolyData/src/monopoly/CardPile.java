// Jonathan Wang
package monopoly;

import java.util.ArrayList;
import java.util.HashMap;

import players.Player;

public class CardPile {
	ArrayList<Card> available; // In the pile
	ArrayList<Card> unavailable; // Out of the pile
	private Card getOutOfJailCopy = new GetOutOfJailCard();
	Player ownsGetOutOfJail;

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

		// Check if need to shuffle
		if (available.size() == 0) {
			available = unavailable;
			unavailable = new ArrayList<Card>();
		}

		int raNum = (int) (Math.random() * available.size()); //Chooses random card
		Card answer = available.get(raNum);
		available.remove(answer); // Removes it from available
		if (ownsGetOutOfJail == null && answer.getCardType() == "GetOutOfJailCard") {
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
