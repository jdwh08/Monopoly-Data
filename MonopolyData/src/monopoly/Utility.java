package monopoly;

import players.Player;

public class Utility extends OwnableProperty {
	
	public Utility(int cCost, Player cOwner, boolean cIsMortgaged) {
		super(cCost, cOwner, cIsMortgaged);
	}
	
	@Override
	public int getRent() {
		// TODO:
		// Check if player owns both utilities
		
		return Board.rollDice() * 4;
	}
	
	@Override
	public String getPropType() {
		return "Utility";
	}
}