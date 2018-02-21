// Jonathan Wang
package monopoly;

public abstract class Card {
	private int cardId; // GET OUT OF JAIL FREE CARD HAS ID 0
	String cardType;
	
	public Card(int iCardId) {
		cardId = iCardId;
	}
	
	public int getCardId() {
		return cardId;
	}
	
	public abstract void setCardType();
	
	public String getCardType() {
		return cardType;
	}
}
