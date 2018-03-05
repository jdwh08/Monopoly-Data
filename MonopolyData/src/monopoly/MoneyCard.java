// Jonathan Wang
package monopoly;

// Cards which only give / take money from the player.
public class MoneyCard extends Card {
	// int representing the amount of money given (positive) or taken away (negative) from the player.
	private int money;
	
	/* Constructs a moneyCard.
	 * Precondition: the cards need to be instantiated.
	 * @param an int representing the amount of money to give/take from the player.
	 * Postcondition: the MoneyCard is constructed.
	 */
	public MoneyCard(int iMoney) {
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
