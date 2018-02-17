package monopoly;

import java.awt.Color;

import players.Player;

public class ColorProperty extends OwnableProperty {
	private Color propColor;
	private int numHouses;
	private boolean hasHotel;
	private int[] payTable;
	
	public ColorProperty(int cCost, Player cOwner, boolean cIsMortgaged, Color cPropColor, int cNumHouses, boolean cHasHotel, int[] cPayTable) {
		super(cCost, cOwner, cIsMortgaged);
		propColor = cPropColor;
		numHouses = cNumHouses;
		hasHotel = cHasHotel;
		payTable = cPayTable;
	}
	
	@Override
	public int getRent() {
		if (owner != null) {
			if (Board.hasMonopoly(owner, propColor) && numHouses == 0) {
				return 2 * payTable[numHouses];
			}
			return payTable[numHouses];
		}
		return 0;
	}
	
	@Override
	public int getRent(int multiplier) {
		System.out.println("COLOR PROPERTY MULTIPLIER ERROR");
		return getRent();
	}
	
	public Color getColor() {
		return propColor;
	}
	
	public int getNumHouses() {
		return numHouses;
	}
	
	public void addHouses(int change) {
		numHouses += change;
		if (numHouses == 5) {
			hasHotel = true;
		}
	}
	
	public boolean hasHotel() {
		return hasHotel;
	}
	
	@Override
	public String getPropType() {
		return "ColorProperty";
	}
}
