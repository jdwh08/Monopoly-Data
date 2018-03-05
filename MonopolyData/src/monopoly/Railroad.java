// Jonathan Wang
package monopoly;

import players.Player;

// Railroads.
public class Railroad extends OwnableProperty {

	/* Constructs a railroad.
	 * @param: the cost of buying the railroad, the owner of the railroad, whether the railroad is mortgaged.
	 */
	public Railroad(int cCost, Player cOwner, boolean cIsMortgaged) {
		super(cCost, cOwner, cIsMortgaged);
	}
	
	// Returns an int representing the cost of rent.
	@Override
	public int getRent() {
		if (owner != null) {
			int numOwned = Board.numPropOwned(owner, "Railroad");
			// Note that railroads pay is determined by the number of railroads the owner has.
			switch (numOwned) {
			case 1:
				return 50;
			case 2:
				return 100;
			case 3:
				return 150;
			case 4: 
				return 200;
			}
		}
		return 0;
	}
	
	// Returns a string representing the type of property 
	@Override
	public String getPropType() {
		return "Railroad";
	}
}
