// Jonathan Wang
package monopoly;

public class MoneyCard extends Card {
	private int money;
	
	public MoneyCard(int iMoney, int iCardId) {
		setMoney(iMoney);
		setCardType();
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	@Override
	public void setCardType() {
		cardType = "MoneyCard";
	}
}
