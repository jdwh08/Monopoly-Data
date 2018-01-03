package monopoly;

import java.awt.Color;

public class Board {
	
	private Property[] boardProperties;
	private CardPile chance;
	private CardPile communityChest;
	int numHousesLeft;
	int numHotelsLeft;
	
	public Board() {
		initializeProperties();

		numHousesLeft = 32;
		numHotelsLeft = 12;
	}
	
	public void initializeProperties() {
		boardProperties = new Property[40];
		
		Property go = new Property();
		boardProperties[0] = go;
		
		int[] medAvePay = {2,10,30,90,160,250};
		Property medAve = new ColorProperty(60, null, false, Color.MAGENTA, 0, false, medAvePay);
		boardProperties[1] = medAve;
		
		Property cc1 = new Property();
		boardProperties[2] = cc1;
		
		int[] balticAvePay = {4,20,60,180,320,450};
		Property balticAve = new ColorProperty(60, null, false, Color.MAGENTA, 0, false, balticAvePay);
		boardProperties[3] = balticAve;
		
		Property incomeTax = new Property();
		boardProperties[4] = incomeTax;
		
		Railroad readingRR = new Railroad(200, null, false);
		boardProperties[5] = readingRR;
		
		int[] orientalAvePay = {6,30,90,270,400,550};
		Property orientalAve = new ColorProperty(100, null, false, Color.CYAN, 0, false, orientalAvePay);
		boardProperties[6] = orientalAve;
		
		Property chance1 = new Property();
		boardProperties[7] = chance1;
		
		int[] vermontAvePay = {6,30,90,270,400,550};
		Property vermontAve = new ColorProperty(100, null, false, Color.CYAN, 0, false, vermontAvePay);
		boardProperties[8] = vermontAve;
		
		int[] connecticutAvePay = {8,40,100,300,450,600};
		Property connecticutAve = new ColorProperty(120, null, false, Color.CYAN, 0, false, connecticutAvePay);
		boardProperties[9] = connecticutAve;
		
		Property jail = new Property();
		boardProperties[10] = jail;
		
		int[] stCharlesPay = {10,50,150,450,625};
		Property stCharlesPlace = new ColorProperty(140, null,false, Color.PINK, 0, false, stCharlesPay);
		boardProperties[11] = stCharlesPlace;
		
		Property electricCo = new Utility(150, null, false);
		boardProperties[12] = electricCo;
		
		int[] stateAvePay = {10,50,150,450,625};
		Property stateAve = new ColorProperty(140,null,false, Color.PINK, 0, false, stateAvePay);
		boardProperties[13] = stateAve;
		
		int[] virginiaAvePay = {12,60,180,500,700,900};
		Property virginiaAve = new ColorProperty(160,null,false,Color.PINK,0,false, virginiaAvePay);
		boardProperties[14] = virginiaAve;
		
		Property pennsylvaniaRR = new Railroad(200, null, false);
		boardProperties[15] = pennsylvaniaRR;
		
		int[] stJamesPay = {14,70,200,550,750,950};
		Property stJamesPlace = new ColorProperty(180,null,false,Color.ORANGE,0,false, stJamesPay);
		boardProperties[16] = stJamesPlace;
		
		Property cc2 = new Property();
		boardProperties[17] = cc2;
		
		int[] tenesseeAvePay = {14,70,200,550,750,950};
		Property tennesseeAve = new ColorProperty(180,null,false,Color.ORANGE,0,false, tenesseeAvePay);
		boardProperties[18] = tennesseeAve;
		
		int[] newYorkAvePay = {16,80,220,600,800,1000};
		Property newYorkAve = new ColorProperty(200,null,false,Color.ORANGE,0,false,newYorkAvePay);
		boardProperties[19] = newYorkAve;
		
		Property freeParking = new Property();
		boardProperties[20] = freeParking;
		
		int[] kentuckyAvePay = {18,90,250,700,875,1050};
		Property kentuckyAve = new ColorProperty(220,null,false,Color.RED,0,false,kentuckyAvePay);
		boardProperties[21] = kentuckyAve;
		
		Property chance2 = new Property();
		boardProperties[22] = chance2;
		
		int[] indianaAvePay = {18,90,250,700,875,1050};
		Property indianaAve = new ColorProperty(220,null,false,Color.RED,0,false,indianaAvePay);
		boardProperties[23] = indianaAve;
		
		int[] illinoisAvePay = {20,100,300,750,925,1100};
		Property illinoisAve = new ColorProperty(240,null,false,Color.RED,0,false,illinoisAvePay);
		boardProperties[24] = illinoisAve;
		
		Property bnoRR = new Railroad(200, null, false);
		boardProperties[25] = bnoRR;
		
		int[] atlanticAvePay = {22,110,330,800,975,1150};
		Property atlanticAve = new ColorProperty(260,null,false,Color.YELLOW,0,false,atlanticAvePay);
		boardProperties[26] = atlanticAve;
		
		int[] ventnorAvePay = {22,110,330,800,975,1150};
		Property ventorAve = new ColorProperty(260,null,false,Color.YELLOW,0,false,ventnorAvePay);
		boardProperties[27] = ventorAve;
		
		Property waterWorks = new Utility(150, null, false);
		boardProperties[28] = waterWorks;
		
		int[] marvinGardensPay = {24,120,360,850,1025,1200};
		Property marvinGardens = new ColorProperty(280,null,false,Color.YELLOW,0,false,marvinGardensPay);
		boardProperties[29] = marvinGardens;
		
		Property gotoJail = new Property();
		boardProperties[30] = gotoJail;
		
		int[] pacificAvePay = {26,130,390,900,1100,1275};
		Property pacificAve = new ColorProperty(300,null,false,Color.GREEN,0,false,pacificAvePay);
		boardProperties[31] = pacificAve;
		
		int[] northCarolinaAvePay = {26,130,390,900,1100,1275};
		Property northCarolinaAve = new ColorProperty(300,null,false,Color.GREEN,0,false,northCarolinaAvePay);
		boardProperties[32] = northCarolinaAve;
		
		Property cc3 = new Property();
		boardProperties[33] = cc3;
		
		int[] pennsylaniaAvePay = {28,150,450,1000,1200,1400};
		Property pennsylvaniaAve = new ColorProperty(320,null,false,Color.GREEN,0,false,pennsylaniaAvePay);
		boardProperties[34] = pennsylvaniaAve;
		
		Property shortLineRR = new Railroad(200, null, false);
		boardProperties[35] = shortLineRR;
		
		Property chance3 = new Property();
		boardProperties[36] = chance3;
		
		int[] parkPlacePay = {35,175,500,1100,1300,1500};
		Property parkPlace = new ColorProperty(350,null,false,Color.BLUE,0,false,parkPlacePay);
		boardProperties[37] = parkPlace;
		
		Property luxuryTax = new Property();
		boardProperties[38] = luxuryTax;
		
		int[] boardwalkPay = {50,200,600,1400,1700,2000};
		Property boardwalk = new ColorProperty(400,null,false,Color.BLUE,0,false,boardwalkPay);
		boardProperties[39] = boardwalk;
	}
	
	// TODO: 
	// Create a method for getProperty() which gets the property based on where the player is.
	
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
