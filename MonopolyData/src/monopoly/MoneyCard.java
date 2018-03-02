// Jonathan Wang
package monopoly;

public class MoneyCard extends Card {
	private int money;
	
	public MoneyCard(int iMoney, int iCardId) {
		setMoney(iMoney);
		setCardType();
	}

	// Gets the monetary value of the card.
	public int getMoney() {
		return money;
	}

	// Changes the monetary value of the card by the int specified in @param.
	public void setMoney(int money) {
		this.money = money;
	}
	
	// Sets the Card Type to a string.
	@Override
	public void setCardType() {
		cardType = "MoneyCard";
	}
}
