// Jonathan Wang
package monopoly;

import java.awt.Color;

import players.Player;

// ColorProperties are squares that have a color associated with them, and can have houses.
public class ColorProperty extends OwnableProperty {
	// Represents the color associated with the property. Ex. Pacific Avenue is Green.
	private Color propColor;
	// The number of houses on the property, from 0 - 5. Note 5 houses represents having a hotel.
	private int numHouses;
	// Boolean represents whether the property has a hotel. Slightly easier to check booleans.
	private boolean hasHotel;
	// An array representing the cost of rent based on the number of houses on the property.
	private int[] payTable;
	
	/* Constructs a colorProperty
	 * Precondition: A square on the board is a colorProperty, and needs to be instantiated.
	 * @param: the cost of buying the property, the owner, whether it is mortgaged, the color, the number of houses, whether it has a hotel, 
	 * 		and an array representing the cost of rent based on the number of houses.
	 * Postcondition: The ColorProperty is instantiated.
	 */
	public ColorProperty(int cCost, Player cOwner, boolean cIsMortgaged, Color cPropColor, int cNumHouses, boolean cHasHotel, int[] cPayTable) {
		super(cCost, cOwner, cIsMortgaged);
		propColor = cPropColor;
		numHouses = cNumHouses;
		hasHotel = cHasHotel;
		payTable = cPayTable;
	}
	
	/* Gets the rent for the property.
	 * Precondition: the property is instantiated, a player needs to know the rent for this property.
	 * @return: an int representing the cost of rent.
	 */
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
	
	/* Calculates the rent with a multiplier from MoveMoneyCards. The multiplier should increase the rental cost.
	 * Precondition: Never, since MoveMoneyCards direct players to Railroads or Utilities.
	 * 		Note: this is in here as an override for the parent's class, and as backup.
	 * @param: an int representing the multiplier for the rent.
	 * @return: an int representing the cost of rent.
	 */
	
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
