// Jonathan Wang
package monopoly;

import players.Player;

// Represents properties that can be owned. 
// Note that this is mainly used as a parent class for Utility, ColorProperty, and Railroad to take advantage of inheritance.
// Secondary use is as a reliable cast for these subclasses when all that is needed is fields like the owner or rent.
public class OwnableProperty extends Property {
	// The cost of buying the property.
	private int cost;
	// The amount of money given for mortgaging the property.
	private int mortgageCost;
	// The owner of the property
	Player owner;
	// Boolean representing if the property is mortgaged.
	boolean isMortgaged;
	
	/* Constructs a OwnableProperty
	 * Precondition: an OwnableProperty needs to be instantiated.
	 * @param: the cost of buying the property, the owner, a boolean representing if the property is mortgaged.
	 * Postcondition: the OwnableProperty is constructed.
	 */
	public OwnableProperty(int cCost, Player cOwner, boolean cIsMortgaged) {		
		cost = cCost;
		mortgageCost = cCost / 2;
		owner = cOwner;
		isMortgaged = cIsMortgaged;
	}
	
	// Gets the rent for landing on the property.
	// Meant to be overridden by subclasses.
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
	// Gets whether the property is mortgaged.
	public boolean getIsMortgaged() {
		return isMortgaged;
	}
	// Switches whether the property is mortgaged.
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
