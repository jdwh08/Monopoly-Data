// Jonathan Wang
package monopoly;

// A get out of jail free card.
public class GetOutOfJailCard extends Card {
	
	// Constructs a get out of jail free card.
	public GetOutOfJailCard() {
		setCardType();
	}
	
	// Gets the type of the card as a string.
	@Override
	public void setCardType() {
		cardType = "GetOutOfJailCard";
	}
}