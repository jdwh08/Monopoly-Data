// Jonathan Wang
package monopoly;

// Represents a single card from Chance or Community Chest.
public abstract class Card {
	// String represents the type of card. Ex. "MoveCard". This makes it easier to differentiate between the card types than finding the class name.
	String cardType;

	// Sets the type for the card
	public abstract void setCardType();
	
	// Gets the cardType.
	public String getCardType() {
		return cardType;
	}
}
