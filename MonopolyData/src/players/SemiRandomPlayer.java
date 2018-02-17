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
	HashMap<Boolean, Integer> possibleAnytimes = new HashMap<Boolean, Integer>();
	Color[] propColors = { Color.MAGENTA, Color.CYAN, Color.PINK, Color.ORANGE, Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE }; //8

	@Override
	void getPossibleActions() {
		possibleActions.add(Board.canPayTax(this));
		possibleActions.add(Board.canBuyProperty(this, Board.getPlayerLocs().get(this)));
		possibleActions.add(Board.canDrawCard(this));
		possibleActions.add(Board.canPayOutJail(this));
		possibleActions.add(Board.canUseOutJail(this));
		possibleActions.add(Board.canRollOutJail(this));
	}

	// Mortgaging & DeMortgaging, buying & selling houses which do not depend on player position
	void getPossibleAnytimes() {
		int randInt = (int) (Math.random() * 40);
		possibleAnytimes.put(Board.canTransferProperty(this, randInt), randInt);
		randInt = (int) (Math.random() * 8);
		possibleAnytimes.put(Board.canBuyHouse(this, propColors[randInt]), randInt);
		randInt = (int) (Math.random() * 40);
		possibleAnytimes.put(Board.canMortgage(this, randInt), randInt);
		randInt = (int) (Math.random() * 40);
		possibleAnytimes.put(Board.canDeMortgage(this, randInt), randInt);
		//possibleAnytimes.put(Board.canMakeTradeRequest(this));
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
		
		while (!hasAction && actionOptions.size() > 0) {
			int randInt = (int)(Math.random() * actionOptions.size());
			// Do nothing
			if (actionOptions.get(randInt) == -1) {
				return actionOptions.get(randInt);
			}
			// Do a possible action
			if (possibleActions.get(actionOptions.get(randInt))) {
				hasAction = true;
				return actionOptions.get(randInt);
			}
		}
		return -1;
	}

}