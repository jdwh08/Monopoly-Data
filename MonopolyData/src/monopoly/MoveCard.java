// Jonathan Wang
package monopoly;

// Cards that move the player.
public class MoveCard extends Card {
	// An int representing the id to move the player to, OR -3 representing "Move back three spaces"
		// Note that id's are based on the index of properties in boardProperties in Board.
	private int moveId;
	
	/* Constructs a MoveCard.
	 * Precondition: a MoveCard needs to be instantiated.
	 * @param: the int representing the id to move the player to OR -3 representing "Move back three spaces"
	 * Postcondition: the Card is instantiated.
	 */
	public MoveCard(int ipropId, int iCardId) {
		setMoveId(ipropId);
		setCardType();
	}

	// Gets the location the player gets sent to.
	public int getMoveId() {
		return moveId;
	}

	// Changes the location the player gets sent to. New location is specified as paramenter.
	public void setMoveId(int moveId) {
		this.moveId = moveId;
	}
	
	// Sets the type of card as a string.
	@Override
	public void setCardType() {
		cardType = "MoveCard";
	}
}
