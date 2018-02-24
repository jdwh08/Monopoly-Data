// Jonathan Wang
package players;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import monopoly.Board;

public class SemiRandomPlayer extends Player {
	
	public SemiRandomPlayer(int cMoney, boolean cInJail) {
		super(cMoney, cInJail);
	}

	ArrayList<Boolean> possibleActions = new ArrayList<Boolean>();
	ArrayList<Boolean> possibleAnytimes = new ArrayList<Boolean>();
	ArrayList<Integer> anytimeVals = new ArrayList<Integer>();
	Color[] propColors = { Color.MAGENTA, Color.CYAN, Color.PINK, Color.ORANGE, Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE }; //8

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

	@Override
	public int getAction() {
		possibleActions.clear();
		getPossibleActions();
		boolean hasAction = false;
		// TODO: Remove actions that have been false
		// TODO: Check if there are no actions possible
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
			// Do nothing
			if (actionOptions.get(randInt) == -1) {
				return actionOptions.get(randInt);
			}
			// Do a possible action
			if (possibleActions.get(actionOptions.get(randInt))) {
				return actionOptions.get(randInt);
			}
		}
		return -1;
	}
	
	// Returns arraylist with value 1 being the anytime and value 2 being the integer for that anytime
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
	
	public String toString() {
		return "" + this.hashCode();
	}
}