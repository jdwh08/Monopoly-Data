package monopoly;

import java.awt.Color;

public class ColorProperty extends OwnableProperty {
	private Color propColor;
	private int numHouses;
	private boolean hasHotel;
	private int[] payTable;
	
	public ColorProperty(int cCost, Player cOwner, boolean cIsMortgaged, Color cPropColor, int cNumHouses, boolean cHasHotel, int[] cPayTable) {
		super(cCost, cOwner, cIsMortgaged);
		
		numHouses = cNumHouses;
		hasHotel = cHasHotel;
		payTable = cPayTable;
	}
	
	@Override
	public int getRent() {
		if (hasHotel) {
			return payTable[5];
		}
		else {
			// TODO:
			// Something here about monopolies (unimproved lots color checker)
			
			return payTable[numHouses];
		}
	}
	
	public Color getColor() {
		return propColor;
	}
	
	public int getNumHouses() {
		return numHouses;
	}
	
	public void addHouses(int change) {
		numHouses += change;
	}
	
	public boolean hasHotel() {
		return hasHotel;
	}
}
