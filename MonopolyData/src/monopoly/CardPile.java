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

	// Draws a card from the pile. Shuffles if necessary.
	public Card draw() {

		// Check if need to shuffle
		if (available.size() == 0) {
			available = unavailable;
			unavailable = new ArrayList<Card>();
		}

		int raNum = (int) (Math.random() * available.size()); //Chooses random card
		Card answer = available.get(raNum);
		available.remove(answer); // Removes it from available
		if (ownsGetOutOfJail == null && answer.getCardId() == 0) {
			ownsGetOutOfJail = Board.getCurrentPlayer();
		}
		else {
			unavailable.add(answer); // Adds it to unavailable
		}
		return answer;
	}
	
	public void useJailCard() {
		unavailable.add(getOutOfJailCopy);
		ownsGetOutOfJail = null;
	}

	public Player getPlayerOwned() {
		return ownsGetOutOfJail;
	}
}
