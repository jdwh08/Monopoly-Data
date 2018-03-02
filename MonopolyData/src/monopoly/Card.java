// Jonathan Wang
package monopoly;

public abstract class Card {
	String cardType;

	// Sets the type for the card
	public abstract void setCardType();
	
	// Gets the cardType.
	public String getCardType() {
		return cardType;
	}
}
