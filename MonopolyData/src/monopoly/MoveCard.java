// Jonathan Wang
package monopoly;

public class MoveCard extends Card {
	private int moveId;
	
	public MoveCard(int ipropId, int iCardId) {
		super(iCardId);
		setMoveId(ipropId);
		setCardType();
	}

	public int getMoveId() {
		return moveId;
	}

	public void setMoveId(int moveId) {
		this.moveId = moveId;
	}
	
	@Override
	public void setCardType() {
		cardType = "MoveCard";
	}
}
