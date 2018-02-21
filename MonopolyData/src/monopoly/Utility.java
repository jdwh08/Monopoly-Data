// Jonathan Wang
package monopoly;

import players.Player;

public class Utility extends OwnableProperty {
	
	public Utility(int cCost, Player cOwner, boolean cIsMortgaged) {
		super(cCost, cOwner, cIsMortgaged);
	}
	
	@Override
	public int getRent() {
		if (owner != null) {
			if (Board.numPropOwned(owner, "Utility") == 2) {
				return Board.rollDice() * 10;
			}
			else {
				return Board.rollDice() * 4;
			}
		}
		return 0;
	}
	
	public int getRent(int multiplier) {
		return Board.rollDice() * multiplier;
	}
	
	// "Base" rent without multiple. To be used for the moveMoneyCard for utilities
	public int baseRent() {
		return Board.rollDice();
	}
	
	@Override
	public String getPropType() {
		return "Utility";
	}
}