// Jonathan Wang
package monopoly;

import players.Player;

public class Utility extends OwnableProperty {
	
	public Utility(int cCost, Player cOwner, boolean cIsMortgaged) {
		super(cCost, cOwner, cIsMortgaged);
	}
	
	// Gets rent from landing on the utility.
	@Override
	public int getRent() {
		if (owner != null) {
			// Owning both utilities gives 10x dice roll.
			if (Board.numPropOwned(owner, "Utility") == 2) {
				return Board.rollDice() * 10;
			}
			// Owning one utility gives 4x dice roll.
			else {
				return Board.rollDice() * 4;
			}
		}
		return 0;
	}
	
	// Gets rent from landing on utility from a MoveMoneyCard. These always have the player pay 10x the roll.
	public int getRent(int multiplier) {
		return Board.rollDice() * multiplier;
	}
	
	// "Base" rent without multiple (IE sum of two dice). To be used for the moveMoneyCard for utilities
	public int baseRent() {
		return Board.rollDice();
	}
	// Gets the property type.
	@Override
	public String getPropType() {
		return "Utility";
	}
}