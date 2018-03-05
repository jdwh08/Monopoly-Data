// Jonathan Wang
package players;

import java.awt.Color;
import java.util.ArrayList;

import monopoly.Board;

public class SemiRandomPlayer extends Player {
	
	/* Constructs a SemiRandomPlayer.
	 * @param: the amount of money the player has, whether the player is in jail.
	 */
	public SemiRandomPlayer(int cMoney, boolean cInJail) {
		super(cMoney, cInJail);
	}

	// ArrayList representing the potential actions the player can do based on the property it is on. 
	// These are in the order specified in GetPossibleActions. 
	// True means the action is legal, and false means illegal.
	ArrayList<Boolean> possibleActions = new ArrayList<Boolean>();
	
	// ArrayList representing the potential anytimes the player can do. These are actions that can be done anytime (ex. houses, mortgaging)
	// These are in the order specified in GetPossibleAnytimes. 
	// True means the action is legal, and false means illegal.
	ArrayList<Boolean> possibleAnytimes = new ArrayList<Boolean>();
	
	// ArrayList representing the value the anytime is associated with.
		// When buying houses on a property, anytimeVals includes the id for the color of the property.
		// When mortgaging, anytimeVals includes the id of the property to mortgage.
	ArrayList<Integer> anytimeVals = new ArrayList<Integer>();
	
	// An array representing the possible colors of properties. The id for colors comes from the index here.
	Color[] propColors = { Color.MAGENTA, Color.CYAN, Color.PINK, Color.ORANGE, Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE };

	// Method to get what the player could potentially do.
	@Override
	void getPossibleActions() {
		// Action 0: pay tax
		possibleActions.add(Board.canPayTax(this));
		// Action 1: buy property
		possibleActions.add(Board.canBuyProperty(this, Board.getPlayerLocs().get(this)));
		// Action 2: draw card
		possibleActions.add(Board.canDrawCard(this));
		// Action 3: pay $50 to exit jail
		possibleActions.add(Board.canPayOutJail(this));
		// Action 4: use a get out of jail free card to exit jail
		possibleActions.add(Board.canUseOutJail(this));
		// Action 5: roll dice to try and get out of jail
		possibleActions.add(Board.canRollOutJail(this));
	}
	
	// Method to choose what the player will do for "anytimes".
	// Mortgaging & DeMortgaging, buying & selling houses which do not depend on player position
	void getPossibleAnytimes() {
		ArrayList<Integer> getProps = Board.ownedProperties(this);
		if (getProps.size() > 0) {
			// Anytime 0: transfer property
			int randInt = getProps.get((int) (Math.random() * getProps.size()));
			possibleAnytimes.add(Board.canTransferProperty(this, randInt));
			anytimeVals.add(randInt);
			// Anytime 1: buy house
			randInt = (int) (Math.random() * 8);
			possibleAnytimes.add(Board.canBuyHouse(this, propColors[randInt]));
			anytimeVals.add(randInt);
			// Anytime 2: sell house
			randInt = (int) (Math.random() * 8);
			possibleAnytimes.add(Board.canSellHouse(this, propColors[randInt]));
			anytimeVals.add(randInt);
			// Anytime 3: mortgage property
			randInt = getProps.get((int) (Math.random() * getProps.size()));
			possibleAnytimes.add(Board.canMortgage(this, randInt));
			anytimeVals.add(randInt);
			// Anytime 4: demortgage property
			randInt = getProps.get((int) (Math.random() * getProps.size()));
			possibleAnytimes.add(Board.canDeMortgage(this, randInt));
			anytimeVals.add(randInt);
			//possibleAnytimes.put(Board.canMakeTradeRequest(this));
			// Anytime 5: Nothing / Stop doing anytimes.
			possibleAnytimes.add(true);
		}
	}
	
	// Method to choose what the player will do.
	// It chooses randomly between available actions identified in getPossibleActions.
	@Override
	public int getAction() {		
		possibleActions.clear();
		getPossibleActions();

		ArrayList<Integer> actionOptions = new ArrayList<Integer>(); // possibleActions which can also be done
		for (int i = 0; i < possibleActions.size(); i++) {
			if (possibleActions.get(i)) {
				actionOptions.add(i);
			}
		}
		
		// If you can buy the property, you also can choose not to buy.
		if (actionOptions.contains(1)) {
			actionOptions.add(-1);
		}
		
		if (actionOptions.size() > 0) {
			// Choose a random action
			int randInt = (int)(Math.random() * actionOptions.size());
			
			return actionOptions.get(randInt);
		}
		return -1;
	}
	
	// Method to choose what the player will do for "anytimes". These are actions that can be performed anytime. Ex. Buying houses
	// @return: arrayList with first value being the anytime and second value being the integer for that anytime
	public ArrayList getAnytime() {
		possibleAnytimes.clear();
		anytimeVals.clear();
		
		getPossibleAnytimes();
		
		ArrayList<Integer> anytimeOptions = new ArrayList<Integer>(); // possibleActions which can also be done
		// 1 because I'm skipping player trades
		for (int i = 1; i < possibleAnytimes.size(); i++) {
			if (possibleAnytimes.get(i)) {
				anytimeOptions.add(i);
			}
		}
		
		if (anytimeOptions.size() > 0) {
			int randInt = (int)(Math.random() * anytimeOptions.size());
			if (anytimeOptions.get(randInt) == 5) {
				return new ArrayList();
			}
			// Do a possible anytime
			else if (possibleAnytimes.get(anytimeOptions.get(randInt))) {
				// If statements hear w/ Math.random() alter probability of doing actions
				
				// 1% chance to sell houses
				if (anytimeOptions.get(randInt) == 2 && Math.random() > 0.01) {
					return new ArrayList();
				}
				// 0.75% chance to mortgage property
				if (anytimeOptions.get(randInt) == 3 && Math.random() > 0.0075) {
					return new ArrayList();
				}
				ArrayList<Integer> answer = new ArrayList<Integer>();
				answer.add(anytimeOptions.get(randInt));
				answer.add(anytimeVals.get(anytimeOptions.get(randInt)));
				return answer;
			}
		}
		return new ArrayList();
	}
	
	// Returns a String representing the player's Hash Code.
	// This is used for player identification.
	public String toString() {
		return "" + this.hashCode();
	}
}