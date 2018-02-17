package monopoly;

import players.Player;

public class Railroad extends OwnableProperty {

	public Railroad(int cCost, Player cOwner, boolean cIsMortgaged) {
		super(cCost, cOwner, cIsMortgaged);
	}
	
	@Override
	public int getRent() {
		if (owner != null) {
			int numOwned = Board.numPropOwned(owner, "Railroad");
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
			System.out.println("RAILROAD RENT FAIL");
		}
		return 0;
	}
	
	@Override
	public String getPropType() {
		return "Railroad";
	}
}
