package monopoly;

import java.awt.Color;

public class Board {
	
	private Property[] boardProperties;
	private CardPile chance;
	private CardPile communityChest;
	int numHousesLeft;
	int numHotelsLeft;
	
	public Board() {
		// TODO:
		// Instantiate every single board property and then put it in the array
		
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
