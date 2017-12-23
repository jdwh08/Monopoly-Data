package monopoly;

public class Railroad extends OwnableProperty {

	public Railroad(int cCost, int cMortgageCost, Player cOwner, boolean cIsMortgaged) {
		super(cCost, cMortgageCost, cOwner, cIsMortgaged);
	}
	
	@Override
	public int getRent() {
		// TODO:
		// Find a way to check how many railroads a player has
		
		return 50;
	}
}
