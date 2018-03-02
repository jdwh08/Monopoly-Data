// Jonathan Wang
package monopoly;

public class GetOutOfJailCard extends Card {
	public GetOutOfJailCard() {
		setCardType();
	}
	
	// Gets the type of the card as a string.
	@Override
	public void setCardType() {
		cardType = "GetOutOfJailCard";
	}
}