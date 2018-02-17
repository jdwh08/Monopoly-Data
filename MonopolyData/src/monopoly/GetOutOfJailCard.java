package monopoly;

public class GetOutOfJailCard extends Card {
	public GetOutOfJailCard() {
		super(0);
		setCardType();
	}
	
	@Override
	public void setCardType() {
		cardType = "GetOutOfJailCard";
	}
}