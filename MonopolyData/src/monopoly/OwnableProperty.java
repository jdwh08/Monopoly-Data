// Jonathan Wang
package monopoly;

import players.Player;

public class OwnableProperty extends Property {
	private int cost;
	private int mortgageCost; // Amount of money given to player for mortgaging
	Player owner;
	boolean isMortgaged;
	
	public OwnableProperty(int cCost, Player cOwner, boolean cIsMortgaged) {		
		cost = cCost;
		mortgageCost = cCost / 2;
		owner = cOwner;
		isMortgaged = cIsMortgaged;
	}
	
	// Abstract-ish method, meant to be overridden. Gets the rent from landing on the property.
	public int getRent() {
		return 0;
	}
	
	// Gets rent with a multiplier attached. Used for moveMoneyCards.
	public int getRent(int multiplier) {
		return 0 * multiplier;
	}
	
	// Gets cost of buying property
	public int getCost() {
		return cost;
	}
	
	// Gets mortgage value
	public int getMortgageCost() {
		return mortgageCost;
	}
	
	public boolean getIsMortgaged() {
		return isMortgaged;
	}
	
	public void switchMortgageStatus() {
		isMortgaged = !isMortgaged;
	}
	
	// Gets property owner
	public Player getOwner() {
		return owner;
	}
	
	// Sets owner of property to Player specified in @param
	public void setOwner(Player newOwner) {
		owner = newOwner;
	}
	
	// Gets the type of the property as a string.
	@Override
	public String getPropType() {
		return "OwnableProperty";
	}
}
