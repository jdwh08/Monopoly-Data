package monopoly;

import players.Player;

public class OwnableProperty extends Property {
	private int cost;
	private int mortgageCost;
	Player owner;
	boolean isMortgaged;
	
	public OwnableProperty(int cCost, Player cOwner, boolean cIsMortgaged) {		
		cost = cCost;
		mortgageCost = cCost / 2;
		owner = cOwner;
		isMortgaged = cIsMortgaged;
	}
	
	// Abstract-ish method, meant to be overridden
	public int getRent() {
		return 0;
	}
	
	public int getRent(int multiplier) {
		return 0 * multiplier;
	}
	
	public int getCost() {
		return cost;
	}
	
	public int getMortgageCost() {
		return mortgageCost;
	}
	
	public boolean getIsMortgaged() {
		return isMortgaged;
	}
	
	public void switchMortgageStatus() {
		isMortgaged = !isMortgaged;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public void setOwner(Player newOwner) {
		owner = newOwner;
	}
	
	@Override
	public String getPropType() {
		return "OwnableProperty";
	}
}
