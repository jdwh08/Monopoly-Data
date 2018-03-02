// Jonathan Wang
package monopoly;

public class MoneyPerNumCard extends Card {
	int rateOne;
	int rateTwo;
	
	// Cards Which Give Money Per Player (ex. Opera Night)
	public MoneyPerNumCard(int iRateOne, int iCardId) {
		rateOne = iRateOne;
		rateTwo = 0;
		setCardType();
	}
	
	// Cards which give money per number of houses and hotels (ex. Street Repairs)
	public MoneyPerNumCard(int iRateOne, int iRateTwo, int iCardId) {
		rateOne = iRateOne;
		rateTwo = iRateTwo;
		setCardType();
	}
	
	// Sets the card type
	@Override
	public void setCardType() {
		cardType = "MoneyPerNumCard";
	}
}
