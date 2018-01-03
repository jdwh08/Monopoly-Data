package monopoly;

public class Railroad extends OwnableProperty {

	public Railroad(int cCost, Player cOwner, boolean cIsMortgaged) {
		super(cCost, cOwner, cIsMortgaged);
	}
	
	@Override
	public int getRent() {
		// TODO:
		// Find a way to check how many railroads a player has
		
		return 50;
	}
}
