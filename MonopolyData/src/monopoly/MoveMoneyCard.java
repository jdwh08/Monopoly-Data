// Jonathan Wang
package monopoly;

// Represents cards of the format "Move to nearest XX and pay XX times the normal rent"
public class MoveMoneyCard extends Card {
	// A string representing the type of property the player gets sent to. (ex. "Railroad" or "Utility")
	String propType;
	// An int representing the extra XX times the normal rent the player must pay.
	int rentMultiplier;
	
	/* Constructs a MoveMoneyCard.
	 * Precondition: a MoveMoneyCard needs to be instantiated.
	 * @param: A string representing the type of property the player gets sent to, an int representing the extra multiple of rent the player must pay.
	 * Postcondition: a MoveMoneyCard is instantiated.
	 */
	public MoveMoneyCard(String iPropType, int iRentMultiplier) {
		propType = iPropType;
		rentMultiplier = iRentMultiplier;
		setCardType();
	}
	
	// Gets the extra multiple for rent.
	public int getRentMultiplier() {
		return rentMultiplier;
	}
	
	// Gets the type of property the player gets sent to.
	public String getPropType() {
		return propType;
	}

	// Sets the type of card to "MoveMoneyCard".
	@Override
	public void setCardType() {
		cardType = "MoveMoneyCard";
	}
}