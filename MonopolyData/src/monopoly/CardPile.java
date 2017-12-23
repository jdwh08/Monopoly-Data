package monopoly;

import java.util.ArrayList;

public class CardPile {
	ArrayList<Card> available; // In the pile
	ArrayList<Card> unavailable; // Out of the pile
	ArrayList<Card> playerOwned; // Owned by players (Get Out of Jail Cards)
	
	
	public CardPile(ArrayList<Card> cAvailable, ArrayList<Card> cUnavailable) {
		available = cAvailable;
		unavailable = cUnavailable;
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
		unavailable.add(answer); // Adds it to unavailable
		
		return answer;
	}
}
