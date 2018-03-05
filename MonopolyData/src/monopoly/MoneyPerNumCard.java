// Jonathan Wang
package monopoly;

// Cards which give money based on the number of players OR the number of houses and hotels.
public class MoneyPerNumCard extends Card {
	// An int representing either the rate per player or rate per house.
	int rateOne;
	// An int representing the rate per hotel.
	int rateTwo;
	
	/* Constructs cards which give money per player (ex. Opera Night gives $50 per player. Chairman of the Board gives $-50 per player).
	 * Precondition: a MoneyPerNumCard needs to be instantiated.
	 * @param: an int representing the money per player.
	 * Postcondition: the MoneyPerNumCard is instantiated.
	 */
	public MoneyPerNumCard(int iRateOne) {
		rateOne = iRateOne;
		rateTwo = 0;
		setCardType();
	}
	
	/* Constructs cards which give money per house and hotel (ex. General Repairs: $-25 per house and $-100 per hotel).
	 * Precondition: a MoneyPerNumCard needs to be instantiated.
	 * @param: an int representing the money per house, an int representing the money per hotel.
	 * Postcondition: the MoneyPerNumCard is instantiated.
	 */
	public MoneyPerNumCard(int iRateOne, int iRateTwo) {
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
