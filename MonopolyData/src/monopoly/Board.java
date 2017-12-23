package monopoly;

import java.awt.Color;

public class Board {
	
	private Property[] boardProperties;
	private CardPile chance;
	private CardPile communityChest;
	int numHousesLeft;
	int numHotelsLeft;
	
	public Board() {
		boardProperties = new Property[40];
		
		Property go = new Property();
		boardProperties[0] = go;
		
		int[] medAvePay = {2,10,30,90,160,250};
		Property medAve = new ColorProperty(60, 30, null, false, Color.MAGENTA, 0, false, medAvePay);
		boardProperties[1] = medAve;
		
		Property cc1 = new Property();
		boardProperties[2] = cc1;
		
		int[] balticAvePay = {4,20,60,180,320,450};
		Property balticAve = new ColorProperty(60, 30, null, false, Color.MAGENTA, 0, false, balticAvePay);
		boardProperties[3] = balticAve;
		
		Property incomeTax = new Property();
		boardProperties[4] = incomeTax;
		
		Railroad readingRR = new Railroad(200, 100, null, false);
		boardProperties[5] = readingRR;
		
		int[] orientalAvePay = {6,30,90,270,400,550};
		Property orientalAve = new ColorProperty(100, 50, null, false, Color.CYAN, 0, false, orientalAvePay);
		boardProperties[6] = orientalAve;
		
		Property chance1 = new Property();
		boardProperties[7] = chance1;
		
		int[] vermontAvePay = {6,30,90,270,400,550};
		Property vermontAve = new ColorProperty(100, 50, null, false, Color.CYAN, 0, false, vermontAvePay);
		boardProperties[8] = vermontAve;
		
		int[] connecticutAvePay = {8,40,100,300,450,600};
		Property connecticutAve = new ColorProperty(120, 60, null, false, Color.CYAN, 0, false, connecticutAvePay);
		boardProperties[9] = connecticutAve;
		
		Property jail = new Property();
		boardProperties[10] = jail;
		
		// TODO:
		// Add the rest of the properties
		
		numHousesLeft = 32;
		numHotelsLeft = 12;
	}
	
	public Property getProperty(int id) {
		return boardProperties[id];
	}
	
	public static int rollDice() {
		return (int) ((Math.random() * 5 + 1) + (Math.random() * 5 + 1));
	}
	
	public void move() {
		// TODO:
		// Make the player move
	}
	
	public void moveTo(int propId) {
		// TODO:
		// Make the player move
	}
	
	public void payTax() {
		// TODO:
		// Make the player pay stuff based on the property they land on
	}
	
	public void buyProperty(int propId) {
		// TODO:
		// Buy Properties
	}
	
	public void transferProperty(int propId) {
		// TODO:
		// Transfer Properties
	}
	
	// Buys one house on the selected color group.
	// Houses are placed on the property with the least number of houses on that color group.
	public void buyHouse(Color propColor) {
		// TODO:
		// Buy House
	}
	
	public void mortgage(int propId) {
		// TODO:
		// Mortgage Houses
	}
	
	public void deMortgage(int propId) {
		// TODO:
		// De-Mortgage Houses
	}
	
	public Card drawCard() {
		// TODO:
		// Draw Card
	}
	
	public void goToJail() {
		// TODO:
		// Send player to jail
	}
	
	// Get out of jail by using a card
	public void useOutJail() {
		// TODO:
		// Send player out of jail
		// Transfer card out of player possession
		// Transfer card into used section of deck
	}
	
	// Get out of jail by paying money
	public void payOutJail() {
		// TODO:
		// Have player pay 50 to get out of jail
	}
	
	public boolean canMove() {
		// TODO:
		// Check if can move (IE in jail)
	}
	
	public boolean canPayTax() {
		// TODO:
		// Check if on a tax property
	}
	
	public boolean canBuyProperty(int propId) {
		// TODO:
		// Check if property is Ownable, and if it isn't owned.
	}
	
	public boolean canTransferProperty(int propId, Player newOwner) {
		// TODO:
		// Check if property is transferable (IE, is owned by the player)
	}
	
	public boolean canBuyHouse(Color propColor) {
		// TODO:
		// Check if player can buy a house (IE, if has enough money && there are still houses && the Color Group still can has space)
	}
	
	public boolean canSellHouse(Color propColor) {
		// TODO:
		// Check if player can sell a house (IE, if that Color Group has a house on a property owned by the player)
	}
	
	public boolean canMortgage(int propId) {
		// TODO:
		// Check if player can mortgage a property (IE, is owned && has no houses/hotels on it)
	}
	
	public boolean canDeMortgage(int propId) {
		// TODO:
		// Check if a player can De-Mortgage a property (IE, is owned && is mortgaged && can afford to pay (+10% interest))
	}
	
	public boolean canDrawCard() {
		// TODO:
		// Check if player can draw a card (IE, is on a Chance or Community Chest property)
	}
	
	public boolean canUseOutJail() {
		// TODO:
		// Check if player can use a card to get out of jail (IE, has a Get Out of Jail Free Card && is in jail)
	}
	
	public boolean canPayOutJail() {
		// TODO:
		// Check if player can pay money to get out of jail (IE, can afford $50 && is in jail)
	}
}
