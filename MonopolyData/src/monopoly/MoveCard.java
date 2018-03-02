// Jonathan Wang
package monopoly;

public class MoveCard extends Card {
	private int moveId;
	
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
