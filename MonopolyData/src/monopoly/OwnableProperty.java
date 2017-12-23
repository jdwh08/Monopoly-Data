package monopoly;

public class OwnableProperty extends Property {
	private int cost;
	private int mortgageCost;
	Player owner;
	boolean isMortgaged;
	
	public OwnableProperty(int cCost, int cMortgageCost, Player cOwner, boolean cIsMortgaged) {		
		cost = cCost;
		mortgageCost = cMortgageCost;
		owner = cOwner;
		isMortgaged = cIsMortgaged;
	}
	
	// Abstract-ish method, meant to be overridden
	public int getRent() {
		return 0;
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
	
	public Player getOwner() {
		return owner;
	}
	
	public void changeOwner(Player newOwner) {
		owner = newOwner;
	}
}
