package monopoly;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import players.Player;

public class Board {

	private static Property[] boardProperties;
	Color[] propColors = { Color.MAGENTA, Color.CYAN, Color.PINK, Color.ORANGE, Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE };
	private static CardPile chance;
	private static CardPile communityChest;
	static int numHousesLeft;
	static int numHotelsLeft;
	static int numPlayers;
	static HashMap<Player, Integer> playerLocs;
	static ArrayList<TradeRequest> pendingTrades;
	static Player currentPlayer;
	Player otherPlayer;

	public Board(Player iCurrentPlayer, Player iOtherPlayer) {
		initializeProperties();
		initializeCards();

		numHousesLeft = 32;
		numHotelsLeft = 12;
		
		currentPlayer = iCurrentPlayer;
		otherPlayer = iOtherPlayer;
		numPlayers = 2;
		playerLocs = new HashMap<Player, Integer>();
		pendingTrades = new ArrayList<TradeRequest>();
		// TODO: Change back
		playerLocs.put(currentPlayer, 7);
		playerLocs.put(otherPlayer, 12);
	}

	private void initializeProperties() { // OKAY
		boardProperties = new Property[40];

		Property go = new Property();
		boardProperties[0] = go;

		int[] medAvePay = { 2, 10, 30, 90, 160, 250 };
		Property medAve = new ColorProperty(60, null, false, Color.MAGENTA, 0, false, medAvePay);
		boardProperties[1] = medAve;

		Property cc1 = new Property();
		boardProperties[2] = cc1;

		int[] balticAvePay = { 4, 20, 60, 180, 320, 450 };
		Property balticAve = new ColorProperty(60, null, false, Color.MAGENTA, 0, false, balticAvePay);
		boardProperties[3] = balticAve;

		Property incomeTax = new Property();
		boardProperties[4] = incomeTax;

		Railroad readingRR = new Railroad(200, null, false);
		boardProperties[5] = readingRR;

		int[] orientalAvePay = { 6, 30, 90, 270, 400, 550 };
		Property orientalAve = new ColorProperty(100, null, false, Color.CYAN, 0, false, orientalAvePay);
		boardProperties[6] = orientalAve;

		Property chance1 = new Property();
		boardProperties[7] = chance1;

		int[] vermontAvePay = { 6, 30, 90, 270, 400, 550 };
		Property vermontAve = new ColorProperty(100, null, false, Color.CYAN, 0, false, vermontAvePay);
		boardProperties[8] = vermontAve;

		int[] connecticutAvePay = { 8, 40, 100, 300, 450, 600 };
		Property connecticutAve = new ColorProperty(120, null, false, Color.CYAN, 0, false, connecticutAvePay);
		boardProperties[9] = connecticutAve;

		Property jail = new Property();
		boardProperties[10] = jail;

		int[] stCharlesPay = { 10, 50, 150, 450, 625 };
		Property stCharlesPlace = new ColorProperty(140, null, false, Color.PINK, 0, false, stCharlesPay);
		boardProperties[11] = stCharlesPlace;

		Property electricCo = new Utility(150, null, false);
		boardProperties[12] = electricCo;

		int[] stateAvePay = { 10, 50, 150, 450, 625 };
		Property stateAve = new ColorProperty(140, null, false, Color.PINK, 0, false, stateAvePay);
		boardProperties[13] = stateAve;

		int[] virginiaAvePay = { 12, 60, 180, 500, 700, 900 };
		Property virginiaAve = new ColorProperty(160, null, false, Color.PINK, 0, false, virginiaAvePay);
		boardProperties[14] = virginiaAve;

		Property pennsylvaniaRR = new Railroad(200, null, false);
		boardProperties[15] = pennsylvaniaRR;

		int[] stJamesPay = { 14, 70, 200, 550, 750, 950 };
		Property stJamesPlace = new ColorProperty(180, null, false, Color.ORANGE, 0, false, stJamesPay);
		boardProperties[16] = stJamesPlace;

		Property cc2 = new Property();
		boardProperties[17] = cc2;

		int[] tenesseeAvePay = { 14, 70, 200, 550, 750, 950 };
		Property tennesseeAve = new ColorProperty(180, null, false, Color.ORANGE, 0, false, tenesseeAvePay);
		boardProperties[18] = tennesseeAve;

		int[] newYorkAvePay = { 16, 80, 220, 600, 800, 1000 };
		Property newYorkAve = new ColorProperty(200, null, false, Color.ORANGE, 0, false, newYorkAvePay);
		boardProperties[19] = newYorkAve;

		Property freeParking = new Property();
		boardProperties[20] = freeParking;

		int[] kentuckyAvePay = { 18, 90, 250, 700, 875, 1050 };
		Property kentuckyAve = new ColorProperty(220, null, false, Color.RED, 0, false, kentuckyAvePay);
		boardProperties[21] = kentuckyAve;

		Property chance2 = new Property();
		boardProperties[22] = chance2;

		int[] indianaAvePay = { 18, 90, 250, 700, 875, 1050 };
		Property indianaAve = new ColorProperty(220, null, false, Color.RED, 0, false, indianaAvePay);
		boardProperties[23] = indianaAve;

		int[] illinoisAvePay = { 20, 100, 300, 750, 925, 1100 };
		Property illinoisAve = new ColorProperty(240, null, false, Color.RED, 0, false, illinoisAvePay);
		boardProperties[24] = illinoisAve;

		Property bnoRR = new Railroad(200, null, false);
		boardProperties[25] = bnoRR;

		int[] atlanticAvePay = { 22, 110, 330, 800, 975, 1150 };
		Property atlanticAve = new ColorProperty(260, null, false, Color.YELLOW, 0, false, atlanticAvePay);
		boardProperties[26] = atlanticAve;

		int[] ventnorAvePay = { 22, 110, 330, 800, 975, 1150 };
		Property ventorAve = new ColorProperty(260, null, false, Color.YELLOW, 0, false, ventnorAvePay);
		boardProperties[27] = ventorAve;

		Property waterWorks = new Utility(150, null, false);
		boardProperties[28] = waterWorks;

		int[] marvinGardensPay = { 24, 120, 360, 850, 1025, 1200 };
		Property marvinGardens = new ColorProperty(280, null, false, Color.YELLOW, 0, false, marvinGardensPay);
		boardProperties[29] = marvinGardens;

		Property gotoJail = new Property();
		boardProperties[30] = gotoJail;

		int[] pacificAvePay = { 26, 130, 390, 900, 1100, 1275 };
		Property pacificAve = new ColorProperty(300, null, false, Color.GREEN, 0, false, pacificAvePay);
		boardProperties[31] = pacificAve;

		int[] northCarolinaAvePay = { 26, 130, 390, 900, 1100, 1275 };
		Property northCarolinaAve = new ColorProperty(300, null, false, Color.GREEN, 0, false, northCarolinaAvePay);
		boardProperties[32] = northCarolinaAve;

		Property cc3 = new Property();
		boardProperties[33] = cc3;

		int[] pennsylaniaAvePay = { 28, 150, 450, 1000, 1200, 1400 };
		Property pennsylvaniaAve = new ColorProperty(320, null, false, Color.GREEN, 0, false, pennsylaniaAvePay);
		boardProperties[34] = pennsylvaniaAve;

		Property shortLineRR = new Railroad(200, null, false);
		boardProperties[35] = shortLineRR;

		Property chance3 = new Property();
		boardProperties[36] = chance3;

		int[] parkPlacePay = { 35, 175, 500, 1100, 1300, 1500 };
		Property parkPlace = new ColorProperty(350, null, false, Color.BLUE, 0, false, parkPlacePay);
		boardProperties[37] = parkPlace;

		Property luxuryTax = new Property();
		boardProperties[38] = luxuryTax;

		int[] boardwalkPay = { 50, 200, 600, 1400, 1700, 2000 };
		Property boardwalk = new ColorProperty(400, null, false, Color.BLUE, 0, false, boardwalkPay);
		boardProperties[39] = boardwalk;
	}
	
	private void initializeCards() { // OKAY
		// Chance
		ArrayList<Card> iChance = new ArrayList<Card>();
		GetOutOfJailCard outOfJail = new GetOutOfJailCard();
		iChance.add(outOfJail);
		// TODO: Change back
		
		/*
		MoveCard toGo = new MoveCard(1, 1);
		iChance.add(toGo);
		MoveCard toIllinois = new MoveCard(24, 2);
		iChance.add(toIllinois);
		MoveCard toStCharles = new MoveCard(11, 3);
		iChance.add(toStCharles);
		MoveMoneyCard nearestUtility = new MoveMoneyCard("Utility", 10, 4);
		iChance.add(nearestUtility);
		MoveMoneyCard nearestRR = new MoveMoneyCard("Railroad", 2, 5);
		iChance.add(nearestRR);
		MoveMoneyCard nearestRRTwo = new MoveMoneyCard("Railroad", 2, 6);
		iChance.add(nearestRRTwo);
		MoneyCard bankDividend = new MoneyCard(50, 7);
		iChance.add(bankDividend);
		MoveCard backThree = new MoveCard(-3, 8);
		iChance.add(backThree);
		MoveCard goToJail = new MoveCard(10, 9);
		iChance.add(goToJail);
		MoneyPerNumCard generalRepairs = new MoneyPerNumCard(-25, -100, 10);
		iChance.add(generalRepairs);
		MoneyCard poorTax = new MoneyCard(-15, 11);
		iChance.add(poorTax);
		MoveCard toReading = new MoveCard(5, 12);
		iChance.add(toReading);
		MoveCard toBoardwalk = new MoveCard(39, 13);
		iChance.add(toBoardwalk);
		MoneyPerNumCard chairmanOfBoard = new MoneyPerNumCard(-50, 14);
		iChance.add(chairmanOfBoard);
		MoneyCard buildingLoan = new MoneyCard(150, 15);
		iChance.add(buildingLoan);
		*/
		chance = new CardPile(iChance);
		
		// CommunityChest
		ArrayList<Card> iCC = new ArrayList<Card>();
		iCC.add(outOfJail);
		// TODO: Change back
		
		/*iCC.add(toGo);
		MoneyCard bankError = new MoneyCard(200, 2);
		iCC.add(bankError);
		MoneyCard doctorsFees = new MoneyCard(-50, 3);
		iCC.add(doctorsFees);
		MoneyCard saleStock = new MoneyCard(50, 4);
		iCC.add(saleStock);
		MoneyPerNumCard operaNight = new MoneyPerNumCard(50, 14);
		iCC.add(operaNight);
		MoneyCard holidayFund = new MoneyCard(100, 6);
		iCC.add(holidayFund);
		MoneyCard incomeTaxRefund = new MoneyCard(20, 7);
		iCC.add(incomeTaxRefund);
		MoneyCard lifeInsurance = new MoneyCard(100, 8);
		iCC.add(lifeInsurance);
		MoneyCard hospitalFee = new MoneyCard(-100, 9);
		iCC.add(hospitalFee);
		MoneyCard schoolFee = new MoneyCard(-150, 10);
		iCC.add(schoolFee);
		MoneyCard consultancyFee = new MoneyCard(25, 11);
		iCC.add(consultancyFee);
		MoneyPerNumCard streetRepairs = new MoneyPerNumCard(-40, -115, 12);
		iCC.add(streetRepairs);
		MoneyCard secondBeautyPrize = new MoneyCard(10, 13);
		iCC.add(secondBeautyPrize);
		MoneyCard inherit = new MoneyCard(100,14);
		iCC.add(inherit);*/
		communityChest = new CardPile(iCC);
	}
	
	// Gets property by ID
	public Property getProperty(int id) {
		return boardProperties[id];
	}
	
	// Gets property thePlayer is on
	public Property getProperty(Player thePlayer) {
		int index = playerLocs.get(thePlayer);
		return boardProperties[index];
	}

	public static int rollDice() {
		return (int) ((Math.random() * 5 + 1) + (Math.random() * 5 + 1));
	}

	// Moves player and pays rent if necessary. Returns whether rolled a double
	protected boolean move(Player thePlayer) {
		boolean hasDoubles = false;
		int diceOne = (int) ((Math.random() * 5 + 1));
		int diceTwo = (int) ((Math.random() * 5 + 1));
		
		if (diceOne == diceTwo) {
			hasDoubles = true;
		}
		int moveDist = diceOne + diceTwo;
		// TODO: Switch back
		moveDist = 10;
		
		// Wrap around GO
		if (moveDist + playerLocs.get(thePlayer) > 39) {
			playerLocs.put(thePlayer, moveDist + playerLocs.get(thePlayer) - 40);
			thePlayer.addMoney(200);
			payRent(thePlayer);
		}
		// Normal
		else {
			playerLocs.put(thePlayer, moveDist + playerLocs.get(thePlayer));
			// Go to Jail
			if (playerLocs.get(thePlayer) == 30) {
				goToJail(thePlayer);
			}
			else {
				payRent(thePlayer);
			}
		}
		
		return hasDoubles;
	}

	protected void moveTo(Player thePlayer, int propId) {
		// Check if passes GO and thus collect $200
		if (playerLocs.get(thePlayer) > propId) {
			thePlayer.addMoney(200);
		}
		playerLocs.put(thePlayer, propId);
		
		payRent(thePlayer);
		
	}
	
	protected void moveTo(Player thePlayer, int propId, int multiplier) {
		// Check if passes GO and thus collect $200
		if (playerLocs.get(thePlayer) > propId) {
			thePlayer.addMoney(200);
		}
		playerLocs.put(thePlayer, propId);
		
		payRent(thePlayer, multiplier);
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
			OwnableProperty temp = (OwnableProperty) boardProperties[propId];
			temp.setOwner(newOwner);
		}
		else {
			System.out.println("TRANSFER PROPERTY ENOUGH ALREADY");
		}
	}

	// Buys one house on the selected color group.
	// Houses are placed on the property with the least number of houses on that color group.
	protected void buyHouse(Player thePlayer, Color theColor) {
		ArrayList<Integer> ownedColorProps = ownedColorProperties(thePlayer, theColor);
		ArrayList<Integer> possibleToAdd = new ArrayList<Integer>();
		// Does thePlayer own properties in that color
		if (canBuyHouse(thePlayer, theColor)) {
			// Does thePlayer have a monopoly on that color
			for (Integer propId : ownedColorProps) {
				int numHouses = ((ColorProperty) (boardProperties[propId])).getNumHouses();
				// Are there houses left?
				if (numHouses < 4 && numHousesLeft > 0) {
					possibleToAdd.add(propId);
				}
				// Are there hotels left?
				else if (numHouses == 4 && numHotelsLeft > 0) {
					possibleToAdd.add(propId);
				}
			}
			// Properties which can be added onto
			if (possibleToAdd.size() > 0) {
				// Find prop with least amount of houses
				int minHouseId = possibleToAdd.get(0);
				int minHouseNum = ((ColorProperty) (boardProperties[minHouseId])).getNumHouses();
				for (Integer propId : possibleToAdd) {
					if (((ColorProperty) (boardProperties[propId])).getNumHouses() < minHouseNum) {
						minHouseNum = ((ColorProperty) boardProperties[propId]).getNumHouses();
						minHouseId = propId;
					}
				}

				((ColorProperty) boardProperties[minHouseId]).addHouses(1);
				if (((ColorProperty) boardProperties[minHouseId]).getNumHouses() == 5) {
					numHotelsLeft--;
				}
				else {
					numHousesLeft--;
				}
			}
		}
	}

	protected void mortgage(Player thePlayer, int propId) {
		if (canMortgage(thePlayer, propId)) {
			((OwnableProperty) boardProperties[propId]).switchMortgageStatus();
		}
		else {
			System.out.println("MORTGAGED ENOUGH ALREADY");
		}
	}

	protected void deMortgage(Player thePlayer, int propId) {
		if (canDeMortgage(thePlayer, propId)) {
			((OwnableProperty) boardProperties[propId]).switchMortgageStatus();
		}
		else {
			System.out.println("DEMORTGAGED ENOUGH ALREADY");
		}
	}

	protected void drawCard(Player thePlayer) {
		if (canDrawCard(thePlayer)) {
			int playerLocId = playerLocs.get(thePlayer);
			
			Card theCard;
			
			if (playerLocId == 2 || playerLocId == 17 || playerLocId == 33) {
				theCard = communityChest.draw();
			}
			else {
				theCard = chance.draw();
			}
			
			useCard(thePlayer, theCard);
		}
	}
	
	// Does the effects for the cards
	protected void useCard(Player thePlayer, Card theCard) {
		String cardType = theCard.getCardType();
		switch (cardType) {
		case "MoveCard":
			int movement = ((MoveCard) theCard).getMoveId();
			
			if ((movement == 10)) {
				goToJail(thePlayer);
				break;
			}
			else if (movement < 0) {
				moveTo(thePlayer, playerLocs.get(thePlayer) + movement);
			}
			else {
				moveTo(thePlayer, movement);
				break;
			}
		
		case "MoneyCard":
			thePlayer.addMoney(((MoneyCard) theCard).getMoney());
			break;
		
		case "MoneyPerNumCard":
			MoneyPerNumCard temp = (MoneyPerNumCard) theCard;
			if (temp.rateTwo == 0) {
				thePlayer.addMoney(temp.rateOne * (numPlayers - 1));
				break;
			}
			else {
				int numHouses = 0;
				int numHotels = 0;
				
				// Gets the number of houses & hotels owned by the player
				for (int i = 0; i < boardProperties.length; i++) {
					if (boardProperties[i].getPropType() == "ColorProperty") {
						ColorProperty tempColProp = (ColorProperty) boardProperties[i];
						if (tempColProp.getNumHouses() == 5) {
							numHotels++;
						}
						else {
							numHouses += tempColProp.getNumHouses();
						}
					}
				}
				
				thePlayer.addMoney(temp.rateOne * numHouses + temp.rateTwo * numHotels);
				break;
			}
		
		case "MoveMoneyCard":
			MoveMoneyCard tempMMC = (MoveMoneyCard) theCard;
			int nearestProp = playerLocs.get(thePlayer);
			// Find the nearest property
			for (int i = nearestProp; i < boardProperties.length; i++) {
				if (boardProperties[i].getPropType().equals(tempMMC.getPropType())) {
					nearestProp = i;
					break;
				}
			}
			// Find the nearest property, wrap around go
			if (nearestProp == playerLocs.get(thePlayer)) {
				for (int i = 0; i < playerLocs.get(thePlayer); i++) {
					if (boardProperties[i].getPropType().equals(tempMMC.getPropType())) {
						nearestProp = i;
					}
				}
			}
			moveTo(thePlayer, nearestProp);
		}
	}
	
	private void payRent(Player thePlayer) {
		int playerLoc = playerLocs.get(thePlayer);
		if (boardProperties[playerLoc].getPropType() != "Property") {
			OwnableProperty temp = (OwnableProperty) boardProperties[playerLoc];
			if (temp.getOwner() != thePlayer && temp.getOwner() != null) {
				int rent = temp.getRent();
				thePlayer.addMoney(-rent);
				temp.owner.addMoney(rent);
			}
		}
	}
	
	private void payRent(Player thePlayer, int multiplier) {
		int playerLoc = playerLocs.get(thePlayer);
		if (boardProperties[playerLoc].getPropType() != "Property") {
			OwnableProperty temp = (OwnableProperty) boardProperties[playerLoc];
			if (temp.getOwner() != thePlayer && temp.getOwner() != null) {
				int rent = temp.getRent(multiplier);
				thePlayer.addMoney(-rent);
				temp.owner.addMoney(rent);
			}
		}
	}
	
	// Sends the player to jail
	protected void goToJail(Player thePlayer) {
		playerLocs.put(thePlayer, 10);
		thePlayer.switchJailStatus();
	}

	// Get out of jail by using a card
	protected void useOutJail(Player thePlayer) {
		if (canUseOutJail(thePlayer)) {
			if (chance.ownsGetOutOfJail.equals(thePlayer)) {
				thePlayer.switchJailStatus();
				thePlayer.resetTurnInJail();
				chance.ownsGetOutOfJail = null;
			}
		}
	}

	// Get out of jail by paying money
	protected void payOutJail(Player thePlayer) {
		if (canPayOutJail(thePlayer)) {
			thePlayer.addMoney(-50);
			thePlayer.switchJailStatus();
			thePlayer.resetTurnInJail();
		}
	}
	
	protected void rollOutJail(Player thePlayer) {
		if (canRollOutJail(thePlayer)) {
			int diceOne = (int) ((Math.random() * 5 + 1));
			int diceTwo = (int) ((Math.random() * 5 + 1));
			
			if (diceOne == diceTwo) {
				thePlayer.switchJailStatus();
				thePlayer.resetTurnInJail();
			}
			else {
				thePlayer.addTurnInJail();
			}
		}
	}
	
	protected void makeTradeRequest(TradeRequest tr) {
		pendingTrades.add(tr);
	}

	public boolean canMove(Player thePlayer) {
		return !thePlayer.isInJail();
	}

	// Pay luxury or income tax
	public static boolean canPayTax(Player thePlayer) {
		int playerLoc = playerLocs.get(thePlayer);
		// Player on Income         or Luxury tax
		if (playerLoc == 4 || playerLoc == 38) {
			return true;
		}
		return false;
	}

	public static boolean canBuyProperty(Player thePlayer, int propId) {
		if (boardProperties[propId].getPropType() != "Property") {
			OwnableProperty theProp = (OwnableProperty) boardProperties[propId];
			if (theProp.getOwner() == null && thePlayer.getMoney() > theProp.getCost()) {
				return true;
			}
		}
		return false;
	}

	public static boolean canTransferProperty(Player oldOwner, int propId) {
		if (boardProperties[propId].getPropType() != "Property") {
			OwnableProperty theProp = (OwnableProperty) boardProperties[propId];
			if (theProp.getOwner().equals(oldOwner)) {
				return true;
			}
		}
		return false;
	}

	public static boolean canBuyHouse(Player thePlayer, Color theColor) {
		ArrayList<Integer> ownedColorProps = ownedColorProperties(thePlayer, theColor);
		// Does thePlayer own properties in that color
		if (ownedColorProps.size() > 0) {
			// Does thePlayer have a monopoly on that color
			if (hasMonopolyNoMortgage(thePlayer, theColor)) {
				for (Integer propId : ownedColorProps) {
					int numHouses = ((ColorProperty) (boardProperties[propId])).getNumHouses();
					// Are there houses left?
					if (numHouses < 5 && numHousesLeft > 0) {
						return true;
					}
					// Are there hotels left?
					else if (numHouses == 4 && numHotelsLeft > 0) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static boolean canSellHouse(Player thePlayer, int propId) {
		if (boardProperties[propId].getPropType() == "ColorProperty") {
			ColorProperty temp = (ColorProperty) boardProperties[propId];
			if (temp.getOwner().equals(thePlayer) && temp.getNumHouses() > 0) {
				return true;
			}
		}
		return false;
	}

	public static boolean canMortgage(Player thePlayer, int propId) {
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

	public static boolean canDeMortgage(Player thePlayer, int propId) {
		if ((boardProperties[propId].getPropType() != "Property")) {
			OwnableProperty temp = (OwnableProperty) boardProperties[propId];
			if (temp.isMortgaged && temp.getOwner().equals(thePlayer)) {
				return true;
			}
		}
		return false;
	}

	public static boolean canDrawCard(Player thePlayer) {
		int index = playerLocs.get(thePlayer);
		if (index == 2 || index == 7 || index == 17 || index == 22 || index == 33 || index == 36) {
			return true;
		}
		return false;
	}

	public static boolean canUseOutJail(Player thePlayer) {
		if (thePlayer.isInJail()) {
			if (chance.getPlayerOwned() == thePlayer || communityChest.getPlayerOwned() == thePlayer) {
				return true;
			}
		}
		return false;
	}

	public static boolean canPayOutJail(Player thePlayer) {
		if (thePlayer.isInJail()) {
			return true;
		}
		return false;
	}
	
	public static boolean canRollOutJail(Player thePlayer) {
		if (thePlayer.isInJail() && thePlayer.getTurnsInJail() <= 3) {
			return true;
		}
		return false;
	}

	public static boolean canMakeTradeRequest(Player thePlayer) {
		return true;
	}

	public boolean isOwnable(int propId) {
		if (boardProperties[propId].getPropType() == "Property") {
			return false;
		}
		return true;
	}

	public static ArrayList<Integer> ownedProperties(Player thePlayer, Color theColor) {
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
	
	// Returns the index of all properties of theColor owned by thePlayer
	public static ArrayList<Integer> ownedColorProperties(Player thePlayer, Color theColor) {
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

	// Returns boolean for if thePlayer has a monopoly over theColor
	public static boolean hasMonopoly(Player thePlayer, Color theColor) {
		ArrayList<Integer> ownedColorProps = ownedColorProperties(thePlayer, theColor);
		// These colors have only 2 properties
		if (theColor == Color.MAGENTA || theColor == Color.BLUE) {
			if (ownedColorProps.size() == 2) {
				return true;
			}
		}
		// Every other color has 3 properties
		else if (ownedColorProps.size() == 3) {
			return true;
		}
		return false;
	}

	// Returns boolean for if thePlayer has a monopoly over theColor without mortgages
	public static boolean hasMonopolyNoMortgage(Player thePlayer, Color theColor) {
		ArrayList<Integer> ownedColorProps = ownedColorProperties(thePlayer, theColor);
		// Check for mortages
		for (Integer propId : ownedColorProps) {
			if (((ColorProperty) boardProperties[propId]).isMortgaged) {
				return false;
			}
		}
		return (hasMonopoly(thePlayer, theColor));
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
		else if (theColor == Color.YELLOW) {
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
	
	void switchCurrentPlayer() {
		Player temp = currentPlayer;
		currentPlayer = otherPlayer;
		otherPlayer = temp;
	}
	
	// Gets the number of properties of theType owned by thePlayer
	public static int numPropOwned(Player thePlayer, String theType) {
		int answer = 0;
		for (Property prop : boardProperties) {
			if (prop.getPropType() == theType) {
				answer++;
			}
		}
		return answer;
	}
	
	public static Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	public static HashMap<Player, Integer> getPlayerLocs() {
		return playerLocs;
	}
	
	public static ArrayList<TradeRequest> getPendingTrades() {
		return pendingTrades;
	}
}
