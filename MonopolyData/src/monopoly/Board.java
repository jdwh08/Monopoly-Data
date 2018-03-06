// Jonathan Wang
package monopoly;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import players.Player;

// Represents the monopoly board, and additional information associated with it (properties, cards, locations)
public class Board {
	// An array of the properties found on the monopoly board.
	private static Property[] boardProperties;
	// A collection of the cards found in Chance.
	private static CardPile chance;
	// A collection of the cards found in Community Chest.
	private static CardPile communityChest;
	// An int representing the number of houses that are available to buy.
	static int numHousesLeft;
	// An int representing the number of hotels that are available to buy.
	static int numHotelsLeft;
	// An int representing the number of players.
	static int numPlayers;
	// Relates a player to an int representing location. The int is based on the index in boardProperties, so a player on Go would have a position of 0.
	static HashMap<Player, Integer> playerLocs;
	// The player that is currently taking its turn.
	static Player currentPlayer;
	// The player that is not taking its turn.
	Player otherPlayer;

	/* Constructs a Board with two players. Defines properties, cards, houses, hotels, and player locations.
	 * Precondition: iCurrentPlayer and iOtherPlayer are not null
	 * Postcondition: The board is set up with houses, hotels, players, locations, properties, and cards.
	 */
	public Board(Player iCurrentPlayer, Player iOtherPlayer) {
		numHousesLeft = 32;
		numHotelsLeft = 12;
		
		currentPlayer = iCurrentPlayer;
		otherPlayer = iOtherPlayer;
		numPlayers = 2;
		playerLocs = new HashMap<Player, Integer>();
		playerLocs.put(currentPlayer, 0);
		playerLocs.put(otherPlayer, 0);
		
		initializeProperties();
		initializeCards();
	}
	
	/* Instantiates the properties in the board.
	 * Precondition: Runner is started, Board is to be instantiated.
	 * Postcondition: boardProperties is filled with the properties.
	 */
	private void initializeProperties() {
		
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
	
	/* Instantiates the cards in communityChest and chance.
	 * Precondition: Runner is started, Properties have been instantiated
	 * Postcondition: communityChest and chance are filled with the cards.
	 */
	private void initializeCards() {
		// Chance
		ArrayList<Card> iChance = new ArrayList<Card>();
		GetOutOfJailCard outOfJail = new GetOutOfJailCard();
		iChance.add(outOfJail);
		MoveCard toGo = new MoveCard(1, 1);
		iChance.add(toGo);
		MoveCard toIllinois = new MoveCard(24, 2);
		iChance.add(toIllinois);
		MoveCard toStCharles = new MoveCard(11, 3);
		iChance.add(toStCharles);
		MoveMoneyCard nearestUtility = new MoveMoneyCard("Utility", 10);
		iChance.add(nearestUtility);
		MoveMoneyCard nearestRR = new MoveMoneyCard("Railroad", 2);
		iChance.add(nearestRR);
		MoveMoneyCard nearestRRTwo = new MoveMoneyCard("Railroad", 2);
		iChance.add(nearestRRTwo);
		MoneyCard bankDividend = new MoneyCard(50);
		iChance.add(bankDividend);
		MoveCard backThree = new MoveCard(-3, 8);
		iChance.add(backThree);
		MoveCard goToJail = new MoveCard(10, 9);
		iChance.add(goToJail);
		MoneyPerNumCard generalRepairs = new MoneyPerNumCard(-25, -100);
		iChance.add(generalRepairs);
		MoneyCard poorTax = new MoneyCard(-15);
		iChance.add(poorTax);
		MoveCard toReading = new MoveCard(5, 12);
		iChance.add(toReading);
		MoveCard toBoardwalk = new MoveCard(39, 13);
		iChance.add(toBoardwalk);
		MoneyPerNumCard chairmanOfBoard = new MoneyPerNumCard(-50, 14);
		iChance.add(chairmanOfBoard);
		MoneyCard buildingLoan = new MoneyCard(150);
		iChance.add(buildingLoan);
		chance = new CardPile(iChance);
		
		// CommunityChest
		ArrayList<Card> iCC = new ArrayList<Card>();
		iCC.add(outOfJail);
		iCC.add(toGo);
		MoneyCard bankError = new MoneyCard(200);
		iCC.add(bankError);
		MoneyCard doctorsFees = new MoneyCard(-50);
		iCC.add(doctorsFees);
		MoneyCard saleStock = new MoneyCard(50);
		iCC.add(saleStock);
		MoneyPerNumCard operaNight = new MoneyPerNumCard(50, 14);
		iCC.add(operaNight);
		MoneyCard holidayFund = new MoneyCard(100);
		iCC.add(holidayFund);
		MoneyCard incomeTaxRefund = new MoneyCard(20);
		iCC.add(incomeTaxRefund);
		MoneyCard lifeInsurance = new MoneyCard(100);
		iCC.add(lifeInsurance);
		MoneyCard hospitalFee = new MoneyCard(-100);
		iCC.add(hospitalFee);
		MoneyCard schoolFee = new MoneyCard(-150);
		iCC.add(schoolFee);
		MoneyCard consultancyFee = new MoneyCard(25);
		iCC.add(consultancyFee);
		MoneyPerNumCard streetRepairs = new MoneyPerNumCard(-40, -115);
		iCC.add(streetRepairs);
		MoneyCard secondBeautyPrize = new MoneyCard(10);
		iCC.add(secondBeautyPrize);
		MoneyCard inherit = new MoneyCard(100);
		iCC.add(inherit);
		communityChest = new CardPile(iCC);
	}
	
	/* Returns the Property specified by the id.
	 * Precondition: The board is filled with properties.
	 * @param id of the property to be found
	 * @return the Property specified by the id.
	 */
	public Property getProperty(int id) {
		return boardProperties[id];
	}
	
	/* Returns the Property thePlayer is on.
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param the Player to look up
	 * @return the Property the player is on.
	 */
	public Property getProperty(Player thePlayer) {
		int index = playerLocs.get(thePlayer);
		return boardProperties[index];
	}

	/* Returns sum of rolling two dice.
	 * @return the integer for the sum of the two dice.
	 */
	public static int rollDice() {
		return (int) ((Math.random() * 5 + 1) + (Math.random() * 5 + 1));
	}

	/* Moves the player
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param the Player to move
	 * @return whether the two dice have the same number (whether the player has rolled doubles)
	 * Postcondition: The player is moved by the sum of the dice.
	 */
	protected boolean move(Player thePlayer) {
		boolean hasDoubles = false;
		int diceOne = (int) ((Math.random() * 5 + 1));
		int diceTwo = (int) ((Math.random() * 5 + 1));
		
		if (diceOne == diceTwo) {
			hasDoubles = true;
		}
		int moveDist = diceOne + diceTwo;
		
		// Wrap around GO
		if (moveDist + playerLocs.get(thePlayer) > 39) {
			playerLocs.put(thePlayer, (moveDist + playerLocs.get(thePlayer)) - 40);
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
	
	/* Moves the player to the location specified by the propID (the index of boardProperties)
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param the Player to move, the index of the boardProperties to move the player to
	 * Postcondition: The player is moved to the location specified.
	 */
	protected void moveTo(Player thePlayer, int propId) {
		// Check if passes GO and thus collect $200
		if (playerLocs.get(thePlayer) > propId) {
			thePlayer.addMoney(200);
		}
		playerLocs.put(thePlayer, propId);
		
		payRent(thePlayer);
	}
	
	/* Moves the player to the location specified by the propId and then have the player pay the rent times the multiplier
	 * Precondition: The board is filled with properties, the players are instantiated, the player drew a MoveMoneyCard
	 * @param the Player to move, the property to move to, the multiplier for the rent
	 * Postcondition: The player is moved by the sum of the dice and has money reduced by the rent times the multiplier
	 */
	protected void moveTo(Player thePlayer, int propId, int multiplier) {
		// Check if passes GO and thus collect $200
		if (playerLocs.get(thePlayer) > propId) {
			thePlayer.addMoney(200);
		}
		playerLocs.put(thePlayer, propId);
		
		payRent(thePlayer, multiplier);
	}

	/* Makes the player pay Income or Property Tax
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param the Player to pay tax with
	 * Postcondition: The player has their money decreased by the amount for the tax if they are on a tax square.
	 */
	protected void payTax(Player thePlayer) {
		if (playerLocs.get(thePlayer) == 4) {
			// income tax is $200 now
			thePlayer.addMoney(-200);
		}
		else if (playerLocs.get(thePlayer) == 38) {
			// new US edition sets luxury tax at $100 not $75
			thePlayer.addMoney(-100);
		}
	}

	/* Makes thePlayer pay for the property.
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param the Player wanting to buy the property
	 * Postcondition: The player owns the property and has their money reduced by the property cost if they can buy the property.
	 */
	protected void buyProperty(Player thePlayer) {
		int propId = playerLocs.get(thePlayer);
		if (canBuyProperty(thePlayer, propId)) {
			OwnableProperty temp = (OwnableProperty) boardProperties[propId];
			temp.setOwner(thePlayer);
			thePlayer.addMoney(-(temp.getCost()));
		}
	}

	/* Transfers ownership of the property.
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param the current owner of the property, the index of the property, the new owner of the property.
	 * Postcondition: The property specified changes ownership to the new owner specified if it can be transfered over.
	 */
	protected void transferProperty(Player oldOwner, int propId, Player newOwner) {
		if (canTransferProperty(oldOwner, propId)) {
			OwnableProperty temp = (OwnableProperty) boardProperties[propId];
			temp.setOwner(newOwner);
		}
	}

	/* Buys a house on one of the properties of the color specified.
	 * Precondition: The board is filled with properties, the players are instantiated, theColor is not null.
	 * @param the Player wanting to buy a house, the color of the property group they want to build a house on.
	 * Postcondition: If legal, the property with the least number of houses on it with that color gets an additional house. The player pays the house cost.
	 */
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

				// Add houses / hotel.
				((ColorProperty) boardProperties[minHouseId]).addHouses(1);
				thePlayer.addMoney(-houseCost(((ColorProperty) boardProperties[minHouseId]).getColor()));
				if (((ColorProperty) boardProperties[minHouseId]).getNumHouses() == 5) {
					// Added a hotel.
					numHotelsLeft--;
				}
				else {
					// Added a house.
					numHousesLeft--;
				}
			}
		}
	}
	
	/* Sells a house from that color group.
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param the Player who wants to sell houses, the color of the property they want to sell houses from.
	 * Postcondition: If legal, property with most number of houses with theColor specified loses one house. The player gains half the house cost.
	 */
	protected void sellHouse(Player thePlayer, Color theColor) {
		ArrayList<Integer> ownedColors = ownedColorProperties(thePlayer, theColor);
		ArrayList<Integer> possibleToRemove = new ArrayList<Integer>();
		
		// Does thePlayer own properties in that color with houses
		if (canSellHouse(thePlayer, theColor)) {
			for (Integer propId : ownedColors) {
				if (((ColorProperty) boardProperties[propId]).getNumHouses() > 0) {
					possibleToRemove.add(propId);
				}
			}
			
			// Properties which are owned by thePlayer and have houses
			if (possibleToRemove.size() > 0) {
				// Find prop with most amount of houses
				int maxHouseId = possibleToRemove.get(0);
				int maxHouseNum = ((ColorProperty) (boardProperties[maxHouseId])).getNumHouses();
				for (Integer propId : possibleToRemove) {
					if (((ColorProperty) (boardProperties[propId])).getNumHouses() > maxHouseNum) {
						maxHouseNum = ((ColorProperty) boardProperties[propId]).getNumHouses();
						maxHouseId = propId;
					}
				}

				((ColorProperty) boardProperties[maxHouseId]).addHouses(-1);
				thePlayer.addMoney(houseCost(((ColorProperty) boardProperties[maxHouseId]).getColor()) / 2);
				if (((ColorProperty) boardProperties[maxHouseId]).getNumHouses() == 5) {
					numHotelsLeft++;
				}
				else {
					numHousesLeft++;
				}
			}
		}
	}
	
	/* Mortgages a property
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param the Player who wants to mortgage, the index of the property thePlayer wants to mortgage.
	 * Postcondition: If legal, property specified becomes mortgaged.
	 */
	protected void mortgage(Player thePlayer, int propId) {
		if (canMortgage(thePlayer, propId)) {
			((OwnableProperty) boardProperties[propId]).switchMortgageStatus();
			thePlayer.addMoney(((OwnableProperty) boardProperties[propId]).getMortgageCost());
		}
	}
	
	/* Removes mortgage from a property.
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param the Player who wants to de-mortgage, the index of the property thePlayer wants to de-mortgage.
	 * Postcondition: If legal, property specified no longer is mortgaged. thePlayer pays back the mortgaged and 10% of the mortgage as interest.
	 */
	protected void deMortgage(Player thePlayer, int propId) {
		if (canDeMortgage(thePlayer, propId)) {
			((OwnableProperty) boardProperties[propId]).switchMortgageStatus();
			thePlayer.addMoney((int) (- 1.10 * ((OwnableProperty) boardProperties[propId]).getMortgageCost()));
		}
	}
	
	/* Draws a card from chance or communityChest.
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param the Player who is trying to draw a card
	 * Postcondition: If legal, card is drawn (removed from available cards in the cardPile).
	 * 		If card was a GetOutOfJail card, thePlayer becomes the owner.
	 * 		Otherwise, the card takes effect and is then moved to unavailable in the cardPile.
	 */
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
	
	/* Uses a card / makes it take effect.
	 * Precondition: The board is filled with properties, the players are instantiated, a player drew a card
	 * @param the Player who drew the card, the Card drawn.
	 * Postcondition: The card's action takes effect.
	 * 		If MoveCard, player moves to the location specified. If not going to jail, player might gain $200 by passing Go (index 0).
	 * 		If MoneyCard, player's money changes by the amount specified.
	 * 		If MoneyPerNumCard, player's money changes by the amount specified times the number of things (ex. number of houses, number of players).
	 * 		If MoveMoneyCard, player moves to nearest property of that type. If needs to pay rent, pays rent times the multiple.
	 */
	protected void useCard(Player thePlayer, Card theCard) {
		String cardType = theCard.getCardType();
		switch (cardType) {
		case "MoveCard":
			int movement = ((MoveCard) theCard).getMoveId();
			
			// Checks for the "Go to Jail" card.
			if ((movement == 10)) {
				goToJail(thePlayer);
				break;
			}
			// Checks for the "Move back three spaces" card.
			else if (movement < 0) {
				moveTo(thePlayer, playerLocs.get(thePlayer) + movement);
				break;
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
				// Cards with money based on number of players. Ex. Chairman of the Board - pay each player $50.
				thePlayer.addMoney(temp.rateOne * (numPlayers - 1));
				break;
			}
			else {
				// Cards with money based on number of houses and hotels. Ex. Street repairs - pay $40 per house and $115 per hotel.
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
				// Pay for house & hotel repairs.
				thePlayer.addMoney(temp.rateOne * numHouses + temp.rateTwo * numHotels);
				break;
			}
		
		case "MoveMoneyCard":
			MoveMoneyCard tempMMC = (MoveMoneyCard) theCard;
			int nearestProp = playerLocs.get(thePlayer);
			// Find the nearest property of the type specified.
			for (int i = nearestProp; i < boardProperties.length; i++) {
				if (boardProperties[i].getPropType().equals(tempMMC.getPropType())) {
					nearestProp = i;
					break;
				}
			}
			// Find the nearest property, wrap around go to the player's location. Activates if cannot find a property yet of that type yet.
			if (nearestProp == playerLocs.get(thePlayer)) {
				for (int i = 0; i < playerLocs.get(thePlayer); i++) {
					if (boardProperties[i].getPropType().equals(tempMMC.getPropType())) {
						nearestProp = i;
					}
				}
			}
			moveTo(thePlayer, nearestProp, tempMMC.getRentMultiplier());
		}
	}
	
	/* Pays rent.
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param the Player who might need to pay rent.
	 * Postcondition: If legal, thePlayer gives rent amount to the owner of the property.
	 */
	private void payRent(Player thePlayer) {
		int playerLoc = playerLocs.get(thePlayer);
		if (boardProperties[playerLoc].getPropType() != "Property") {
			OwnableProperty temp = (OwnableProperty) boardProperties[playerLoc];
			if (temp.getOwner() != thePlayer && temp.getOwner() != null) {
				// Property which is not owned by thePlayer.
				int rent = temp.getRent();
				thePlayer.addMoney(-rent);
				temp.getOwner().addMoney(rent);
			}
		}
	}
	
	/* Pays rent multiplied by the multiplier.
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param the Player who might need to pay rent, the multiplier.
	 * Postcondition: If legal, thePlayer gives rent amount to the owner of the property times the multiplier.
	 * 		If utility, rent is sum of two dice times 10.
	 */
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
	
	/* Sends player directly to jail.
	 * Precondition: The board is filled with properties, the players are instantiated. Player either rolls 3 doubles, landed on GoToJail, or drew GoToJail.
	 * @param the Player going to Jail.
	 * Postcondition: Sends the player to jail and switches the player's isInJail to true.
	 */
	protected void goToJail(Player thePlayer) {
		playerLocs.put(thePlayer, 10);
		thePlayer.switchJailStatus();
	}

	/* Get out of jail by using the GetOutOfJailCard.
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param the Player who wants to use the card to get out of jail.
	 * Postcondition: If legal, thePlayer exits jail. thePlayer's turns in jail becomes 0. thePlayer no longer owns one of the GetOutOfJailFree cards.
	 */
	protected void useOutJail(Player thePlayer) {
		if (canUseOutJail(thePlayer)) {
			if (chance.ownsGetOutOfJail != null && chance.ownsGetOutOfJail.equals(thePlayer)) {
				thePlayer.switchJailStatus();
				thePlayer.resetTurnInJail();
				chance.ownsGetOutOfJail = null;
			}
			else if (communityChest.ownsGetOutOfJail != null && communityChest.ownsGetOutOfJail.equals(thePlayer)) {
				thePlayer.switchJailStatus();
				thePlayer.resetTurnInJail();
				communityChest.ownsGetOutOfJail = null;
			}
		}
	}

	/* Get out of jail by paying $50.
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param the Player who wants to get out of jail.
	 * Postcondition: If legal, thePlayer exits jail. thePlayer's money decreases by 50.
	 */
	protected void payOutJail(Player thePlayer) {
		if (canPayOutJail(thePlayer)) {
			thePlayer.addMoney(-50);
			thePlayer.switchJailStatus();
			thePlayer.resetTurnInJail();
		}
	}
	
	/* Get out of jail by rolling for doubles.
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param the Player who wants to get out of jail.
	 * Postcondition: If legal, thePlayer rolls two dice.
	 * 		If rolls doubles, then the player's isInJail gets set to false. thePlayer's number of turns in jail is set to 0.
	 * 		If not doubles, thePlayer's turnInJail increments by 1.
	 */
	protected void rollOutJail(Player thePlayer) {
		if (canRollOutJail(thePlayer)) {
			int diceOne = (int) ((Math.random() * 5 + 1));
			int diceTwo = (int) ((Math.random() * 5 + 1));
			
			if (diceOne == diceTwo) {
				thePlayer.switchJailStatus();
				thePlayer.resetTurnInJail();
				moveTo(thePlayer, playerLocs.get(thePlayer) + diceOne + diceTwo);
			}
			else {
				thePlayer.addTurnInJail();
			}
		}
	}


	/* Checks if player can move.
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param thePlayer to check.
	 * @return boolean representing if the player can move (ie not in jail)
	 */
	public boolean canMove(Player thePlayer) {
		return !thePlayer.isInJail();
	}
	

	/* Checks if player can pay tax.
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param thePlayer to check.
	 * @return boolean representing if the player can pay tax (ie on the Income Tax or Luxury Tax squares)
	 */
	public static boolean canPayTax(Player thePlayer) {
		int playerLoc = playerLocs.get(thePlayer);
		// Player on Income         or Luxury tax
		if (playerLoc == 4 || playerLoc == 38) {
			return true;
		}
		return false;
	}

	/* Checks if player can buy the property specified.
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param thePlayer to check, the index of the property planned.
	 * @return boolean representing if the player can buy the property (no owner, has enough money)
	 */
	public static boolean canBuyProperty(Player thePlayer, int propId) {
		if (boardProperties[propId].getPropType() != "Property") {
			OwnableProperty theProp = (OwnableProperty) boardProperties[propId];
			if (theProp.getOwner() == null && thePlayer.getMoney() > theProp.getCost()) {
				return true;
			}
		}
		return false;
	}

	/* Checks if player can transfer the property specified.
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param thePlayer to check, the index of the property to transfer.
	 * @return boolean representing if the player can transfer the property specified (ie owned by thePlayer specified)
	 */
	public static boolean canTransferProperty(Player oldOwner, int propId) {
		if (boardProperties[propId].getPropType() != "Property") {
			OwnableProperty theProp = (OwnableProperty) boardProperties[propId];
			if (theProp.getOwner() != null && theProp.getOwner().equals(oldOwner)) {
				return true;
			}
		}
		return false;
	}

	/* Checks if player can buy a house on properties of that color.
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param thePlayer to check, color of property to build a house on.
	 * @return boolean representing if the player can buy a house (ie owns all properties of that color without mortgages, houses / hotels left, has enough money to buy a house)
	 */
	public static boolean canBuyHouse(Player thePlayer, Color theColor) {
		ArrayList<Integer> ownedColorProps = ownedColorProperties(thePlayer, theColor);
		// Does thePlayer own properties in that color
		if (ownedColorProps.size() > 0 && thePlayer.getMoney() > houseCost(theColor)) {
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

	/* Checks if player can sell a house.
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param thePlayer to check, theColor to sell a house from
	 * @return boolean representing if the player can sell the house (ie owns a house on a property of that color)
	 */
	public static boolean canSellHouse(Player thePlayer, Color theColor) {
		ArrayList<Integer> ownedColors = ownedColorProperties(thePlayer, theColor);
		
		for (int i = 0; i < ownedColors.size(); i++) {
			if (boardProperties[i].getPropType() == "ColorProperty") {
				ColorProperty temp = (ColorProperty) boardProperties[i];
				if (temp.getOwner() != null && temp.getOwner().equals(thePlayer) && temp.getNumHouses() > 0) {
					return true;
				}
			}
		}
		return false;
	}

	/* Checks if player can mortgage a property.
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param thePlayer to check, the index of the property to mortgage.
	 * @return boolean representing if the player can move (ie owns the property, is a ColorProperty, has no houses / hotels)
	 */
	public static boolean canMortgage(Player thePlayer, int propId) {
		if ((boardProperties[propId].getPropType() != "Property")) {
			OwnableProperty temp = (OwnableProperty) boardProperties[propId];
			if (!temp.isMortgaged && temp.getOwner() != null && temp.getOwner().equals(thePlayer)) {
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

	/* Checks if player can remove the mortgage from a property.
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param thePlayer to check, the property to remove the mortgage from.
	 * @return boolean representing if the player can de-mortgage the property (ie owns the property and is mortgaged)
	 */
	public static boolean canDeMortgage(Player thePlayer, int propId) {
		if ((boardProperties[propId].getPropType() != "Property")) {
			OwnableProperty temp = (OwnableProperty) boardProperties[propId];
			if (temp.getIsMortgaged() && temp.getOwner().equals(thePlayer)) {
				return true;
			}
		}
		return false;
	}

	/* Checks if player can draw a card.
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param thePlayer to check.
	 * @return boolean representing if the player can draw a card (ie is on a Chance or Community Chest square)
	 */
	public static boolean canDrawCard(Player thePlayer) {
		int index = playerLocs.get(thePlayer);
		if (index == 2 || index == 7 || index == 17 || index == 22 || index == 33 || index == 36) {
			return true;
		}
		return false;
	}

	/* Checks if player can use a GetOutOfJailCard to get out of jail.
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param thePlayer to check.
	 * @return boolean representing if the player can use the card (ie in jail, owns a GetOutOfJailCard)
	 */
	public static boolean canUseOutJail(Player thePlayer) {
		if (thePlayer.isInJail()) {
			if ((chance.getPlayerOwned() != null && chance.getPlayerOwned().equals(thePlayer)) || (communityChest.getPlayerOwned() != null && communityChest.getPlayerOwned().equals(thePlayer))) {
				return true;
			}
		}
		return false;
	}

	/* Checks if player can pay money to get out of jail.
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param thePlayer to check.
	 * @return boolean representing if the player can pay (ie in jail)
	 */
	public static boolean canPayOutJail(Player thePlayer) {
		if (thePlayer.isInJail()) {
			return true;
		}
		return false;
	}
	
	/* Checks if player can roll dice to get out of jail.
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param thePlayer to check.
	 * @return boolean representing if the player can roll dice to get out of jail (ie in jail & thrown dice less than 3 times)
	 */
	public static boolean canRollOutJail(Player thePlayer) {
		if (thePlayer.isInJail() && thePlayer.getTurnsInJail() < 3) {
			return true;
		}
		return false;
	}

	/* Checks if property can be owned
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param the index of the property to check
	 * @return boolean representing if the property can be owned (ie subclass of Property)
	 */
	public boolean isOwnable(int propId) {
		if (boardProperties[propId].getPropType() == "Property") {
			return false;
		}
		return true;
	}
	
	/* Returns the id of all properties owned by thePlayer
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param thePlayer to check.
	 * @return ArrayList<Integer> representing all the indexes of the properties owned by thePlayer.
	 */
	public static ArrayList<Integer> ownedProperties(Player thePlayer) {
		ArrayList<Integer> ownedColorProps = new ArrayList<Integer>();

		for (int i = 0; i < boardProperties.length; i++) {
			if (boardProperties[i].getPropType() != "Property") {
				OwnableProperty ownableProp = (OwnableProperty) boardProperties[i];
				if (ownableProp.getOwner() == thePlayer) {
					ownedColorProps.add(i);
				}
			}
		}
		return ownedColorProps;
	}
	
	/* Returns the id of all properties of theColor owned by thePlayer
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param thePlayer to check.
	 * @return ArrayList<Integer> representing all the indexes of the properties of theColor owned by thePlayer.
	 */
	public static ArrayList<Integer> ownedColorProperties(Player thePlayer, Color theColor) {
		ArrayList<Integer> ownedColorProps = new ArrayList<Integer>();

		for (int i = 0; i < boardProperties.length; i++) {
			if (boardProperties[i].getPropType() == "ColorProperty") {
				ColorProperty colorProp = (ColorProperty) boardProperties[i];
				if (colorProp.getOwner() == thePlayer && colorProp.getColor() == theColor) {
					ownedColorProps.add(i);
				}
			}
		}
		return ownedColorProps;
	}

	/* Returns boolean for if thePlayer has a monopoly over theColor
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param thePlayer to check, theColor of the property to check.
	 * @return boolean representing whether thePlayer owns all properties of theColor.
	 */
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

	/* Returns boolean for if thePlayer has a monopoly over theColor without mortgages
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param thePlayer to check, theColor of the properties to check.
	 * @return boolean representing whether thePlayer owns all properties of theColor and none of the properties are mortgaged.
	 */
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

	/* Gets the cost of buying a house based on theColor
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param theColor of the property which is having a house built on it.
	 * @return int representing the cost of buying one house on that color.
	 */
	public static int houseCost(Color theColor) {
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
		return 0;
	}
	
	/* Gets the number of properties of theType owned by thePlayer
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @param thePlayer to check, the type of the property written out as a string (ex. "Utility").
	 * @return int representing the number of properties of theType owned by thePlayer.
	 */
	public static int numPropOwned(Player thePlayer, String theType) {
		int answer = 0;
		for (Property prop : boardProperties) {
			if (prop.getPropType() == theType) {
				answer++;
			}
		}
		return answer;
	}
	
	// Gets the player currently doing stuff.
	public static Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	// Gets a HashMap relating the players to the index of the boardProperty they are on.
	public static HashMap<Player, Integer> getPlayerLocs() {
		return playerLocs;
	}
	
	/* Determines if all properties on the board are owned.
	 * Precondition: The board is filled with properties, the players are instantiated.
	 * @return boolean representing whether all properties that can be owned are owned.
	 */
	public boolean isAllPropertiesOwned() {
		int numOwned = 0;
		for (Property prop : boardProperties) {
			if (prop.getPropType() != "Property") {
				OwnableProperty temp = (OwnableProperty) prop;
				if (temp.getOwner() != null) {
					numOwned++;
				}
			}
		}
		if (numOwned == 28) {
			return true;
		}
		return false;
	}
	
	/* Switches which player is currently making moves.
	 * Precondition: The board is filled with properties, the players are instantiated, the currentPlayer is finished making their moves.
	 * Postcondition: the currentPlayer switches with the otherPlayer.
	 */
	void switchCurrentPlayer() {
		Player temp = currentPlayer;
		currentPlayer = otherPlayer;
		otherPlayer = temp;
	}
}
