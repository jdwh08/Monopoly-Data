package monopoly;

public class MoneyPerNumCard extends Card {
	int rateOne;
	int rateTwo;
	
	// Per Player
	public MoneyPerNumCard(int iRateOne, int iCardId) {
		super(iCardId);
		rateOne = iRateOne;
		rateTwo = 0;
		setCardType();
	}
	
	// Per House & Hotel
	public MoneyPerNumCard(int iRateOne, int iRateTwo, int iCardId) {
		super(iCardId);
		rateOne = iRateOne;
		rateTwo = iRateTwo;
		setCardType();
	}
	
	@Override
	public void setCardType() {
		cardType = "MoneyPerNumCard";
	}
}
