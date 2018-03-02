// Jonathan Wang
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
	
	// Calculates the rent.
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
	
	// Calculates the rent with a multiplier from MoveMoneyCards. Note: this should not happen because MoveMoneyCards direct players to Railroads or Utilities
	@Override
	public int getRent(int multiplier) {
		System.out.println("COLOR PROPERTY MULTIPLIER ERROR");
		return getRent();
	}
	
	// Gets the color of the property.
	public Color getColor() {
		return propColor;
	}
	
	// Gets the number of houses on the property. Hotel == 5 houses.
	public int getNumHouses() {
		return numHouses;
	}
	
	/* Adds the number of houses specified to the property.
	 * Precondition: The board is filled with properties, the players are instantiated, the player is attempting to houses.
	 * @param the number of houses to add.
	 * Postcondition: The property gains the specified number of houses.
	 */
	public void addHouses(int change) {
		numHouses += change;
		if (numHouses == 5) {
			hasHotel = true;
		}
	}
	
	// Returns if the property has a hotel.
	public boolean hasHotel() {
		return hasHotel;
	}
	
	// Returns a string representing the type of property.
	@Override
	public String getPropType() {
		return "ColorProperty";
	}
}
