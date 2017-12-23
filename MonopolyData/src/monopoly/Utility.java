package monopoly;

public class Utility extends OwnableProperty {
	
	public Utility(int cPropId, int cCost, int cMortgageCost, Player cOwner, boolean cIsMortgaged) {
		super(cPropId, cCost, cMortgageCost, cOwner, cIsMortgaged);
	}
	
	@Override
	public int getRent() {
		// TODO:
		// Check if player owns both utilities
		
		return Board.rollDice() * 4;
	}
}
