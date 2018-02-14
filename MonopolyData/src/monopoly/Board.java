package monopoly;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import players.Player;
import players.SemiRandomPlayer;

public class Board {
	
	private Property[] boardProperties;
	private CardPile chance;
	private CardPile communityChest;
	int numHousesLeft;
	int numHotelsLeft;
	HashMap<Player, Integer> playerLocs;
	// TODO: Current Player Stuff. Current Player is probably in the runner.
	
	public Board() {
		initializeProperties();

		numHousesLeft = 32;
		numHotelsLeft = 12;
		Player srp1 = new SemiRandomPlayer();
		Player srp2 = new SemiRandomPlayer();
		playerLocs = new HashMap<Player, Integer>();
		playerLocs.put(srp1, 0);
		playerLocs.put(srp2, 0);
	}
	
	private void initializeProperties() {
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
	
	public Property getProperty(int id) {
		return boardProperties[id];
	}
	
	public Property getProperty(Player thePlayer) {
		int index = playerLocs.get(thePlayer);
		return boardProperties[index];
	}
	
	public static int rollDice() {
		return (int) ((Math.random() * 5 + 1) + (Math.random() * 5 + 1));
	}
	
	protected void move(Player thePlayer) {
		int moveDist = rollDice();
		
		// Wrap around GO
		if (moveDist + playerLocs.get(thePlayer) > 39) {
			playerLocs.put(thePlayer, moveDist + playerLocs.get(thePlayer) - 40);
		}
		// Normal
		else {
			playerLocs.put(thePlayer, moveDist + playerLocs.get(thePlayer));
		}
	}
	
	protected void moveTo(Player thePlayer, int propId) {
		playerLocs.put(thePlayer, propId);
	}
	
	protected void payTax(Player thePlayer) {
		if (playerLocs.get(thePlayer) == 4) {
			// Pay $200, the 10% option is gone in new US edition
			thePlayer.addMoney(-200);
		}
		else if (playerLocs.get(thePlayer) == 38) {
			// new US edition sets luxury tax at $100 not $75
			thePlayer.addMoney(-100);
		}
		else {
			// Didn't need to pay taxes.
			System.out.println("TAXED ENOUGH ALREADY");
		}
	}
	
	protected void buyProperty(Player thePlayer, int propId) {
		if (canBuyProperty(thePlayer, propId)) {
			OwnableProperty temp = (OwnableProperty) boardProperties[propId];
			temp.setOwner(thePlayer);
			thePlayer.addMoney(-(temp.getCost()));
		}
		else {
			System.out.println("BUY PROPERTY ENOUGH ALREADY");
		}
	}
	
	protected void transferProperty(Player oldOwner, int propId, Player newOwner) {
		if (canTransferProperty(oldOwner, propId)) {
			OwnableProperty temp = (OwnableProperty)boardProperties[propId];
			temp.setOwner(newOwner);
		}
		else {
			System.out.println("TRANSFER PROPERTY ENOUGH ALREADY");
		}
	}
	
	// Buys one house on the selected color group.
	// Houses are placed on the property with the least number of houses on that color group.
	protected void buyHouse(Player thePlayer, Color theColor) {
		ArrayList<Integer> possibleToAdd = new ArrayList<Integer>();
		ArrayList<Integer> ownedColorProps = ownedColorProperties(thePlayer, theColor);
		if (ownedColorProps.size() > 0) {
			for (Integer propId : ownedColorProps) {
				if (((ColorProperty)boardProperties[propId]).getNumHouses() < 6) {
					possibleToAdd.add(propId);
				}
			}
		}
		
		
	}
	
	protected void mortgage(int propId) {
		// TODO:
		// Mortgage Houses
	}
	
	protected void deMortgage(int propId) {
		// TODO:
		// De-Mortgage Houses
	}
	
	protected Card drawCard() {
		// TODO:
		// Draw Card
	}
	
	protected void goToJail() {
		// TODO:
		// Send player to jail
	}
	
	// Get out of jail by using a card
	protected void useOutJail() {
		// TODO:
		// Send player out of jail
		// Transfer card out of player possession
		// Transfer card into used section of deck
	}
	
	// Get out of jail by paying money
	protected void payOutJail() {
		// TODO:
		// Have player pay 50 to get out of jail
	}
	
	public boolean canMove() {
		// TODO:
		// Check if can move (IE in jail)
	}
	
	public boolean canPayTax(Player thePlayer) {
		int playerLoc = playerLocs.get(thePlayer);
		// Player on Income         or Luxury tax
		if (playerLoc == 4 || playerLoc == 38) {
			return true;
		}
		return false;
	}
	
	public boolean canBuyProperty(Player thePlayer, int propId) {
		if (boardProperties[propId].getPropType() != "Property") {
			OwnableProperty theProp = (OwnableProperty) boardProperties[propId];
			if (theProp.getOwner() == null && thePlayer.getMoney() > theProp.getCost()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean canTransferProperty(Player oldOwner, int propId) {
		if (boardProperties[propId].getPropType() != "Property") {
			OwnableProperty theProp = (OwnableProperty) boardProperties[propId];
			if (theProp.getOwner().equals(oldOwner)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean canBuyHouse(Player thePlayer, Color theColor) {
		ArrayList<Integer> ownedColorProps = ownedColorProperties(thePlayer, theColor);
		if (ownedColorProps.size() > 0) {
			for (Integer propId : ownedColorProps) {
				if (((ColorProperty)boardProperties[propId]).getNumHouses() < 6) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean canSellHouse(Player thePlayer, int propId) {
		if (boardProperties[propId].getPropType() == "ColorProperty") {
			ColorProperty temp = (ColorProperty) boardProperties[propId];
			if (temp.getOwner().equals(thePlayer) && temp.getNumHouses() > 0) {
				return true;
			}
		}
		return false;
	}
	
	public boolean canMortgage(Player thePlayer, int propId) {
		if ((boardProperties[propId].getPropType() != "Property")) {
			OwnableProperty temp = (OwnableProperty) boardProperties[propId];
			if (!temp.isMortgaged && temp.getOwner().equals(thePlayer)) {
				if (temp.getPropType() == "ColorProperty") {
					ColorProperty tempColor = (ColorProperty) boardProperties[propId];
					if (tempColor.getNumHouses() == 0) {
						return true;
					}
				}
				else {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean canDeMortgage(Player thePlayer, int propId) {
		if ((boardProperties[propId].getPropType() != "Property")) {
			OwnableProperty temp = (OwnableProperty) boardProperties[propId];
			if (temp.isMortgaged && temp.getOwner().equals(thePlayer)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean canDrawCard(Player thePlayer) {
		int index = playerLocs.get(thePlayer);
		if (index == 2 || index == 7 || index == 17 || index == 22 || index == 33 || index == 36) {
			return true;
		}
		return false;
	}
	
	public boolean canUseOutJail(Player thePlayer) {		
		if (thePlayer.isInJail()) {
			if (chance.getPlayerOwned() == thePlayer || communityChest.getPlayerOwned() == thePlayer) {
				return true;
			}
		}
		return false;
	}
	
	public boolean canPayOutJail(Player thePlayer) {
		if (thePlayer.isInJail()) {
			if (thePlayer.getMoney() >= 50) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isOwnable(int propId) {
		if (boardProperties[propId].getPropType() == "Property") {
			return false;
		}
		return true;
	}
	
	// Returns the index of all properties of theColor owned by thePlayer
	public ArrayList<Integer> ownedColorProperties(Player thePlayer, Color theColor) {
		ArrayList<Integer> ownedColorProps = new ArrayList<Integer>();
		
		for (int i = 0; i < boardProperties.length; i++) {
			if (boardProperties[i].getPropType() == "ColorProperty") {
				ColorProperty colorProp = (ColorProperty) boardProperties[i];
				if (colorProp.owner == thePlayer) {
					ownedColorProps.add(i);
				}
			}
		}
		return ownedColorProps;
	}
	
	// Gets the cost of buying a house based on theColor
	public int houseCost(Color theColor) {
		if (theColor == Color.MAGENTA) {
			return 50;
		}
		else if (theColor == Color.CYAN) {
			return 50;
		}
		else if (theColor == Color.PINK) {
			return 100;
		}
		else if (theColor == Color.ORANGE) {
			return 100;
		}
		else if (theColor == Color.RED) {
			return 150;
		}
		else if (theColor == Color.YELLOW ) {
			return 150;
		}
		else if (theColor == Color.GREEN) {
			return 200;
		}
		else if (theColor == Color.BLUE) {
			return 200;
		}
		System.out.println("HOUSE COST ENOUGH ALREADY");
		return 0;
	}
}
