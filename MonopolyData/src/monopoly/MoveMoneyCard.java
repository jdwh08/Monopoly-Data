// Jonathan Wang
package monopoly;

// Move to nearest XX and pay XX times the normal rent
public class MoveMoneyCard extends Card {
	String propType;
	int rentMultiplier;
	
	public MoveMoneyCard(String iPropType, int iRentMultiplier, int iCardId) {
		propType = iPropType;
		rentMultiplier = iRentMultiplier;
		setCardType();
	}
	
	public int getRentMultiplier() {
		return rentMultiplier;
	}
	
	public String getPropType() {
		return propType;
	}

	@Override
	public void setCardType() {
		cardType = "MoveMoneyCard";
	}
}