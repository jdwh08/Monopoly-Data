// Jonathan Wang
package players;

import java.util.ArrayList;
// Players
public abstract class Player {
	// The amount of money the player has.
	private int money;
	// Boolean representing whether the player is in jail
	private boolean inJail;
	// int representing how long the player has been in jail.
	private int turnsInJail;
	
	/* Constructs a player.
	 * @param: the amount of money the player has, whether the player is in jail.
	 */
	public Player(int cMoney, boolean cInJail) {
		money = cMoney;
		inJail = cInJail;
		turnsInJail = 0;
	}
	
	// Method to get what the player could potentially do.
	abstract void getPossibleActions();

	// Method to choose what the player will do.
	public abstract int getAction();

	// Method to choose what the player will do for "anytimes". These are actions that can be performed anytime. Ex. Buying houses
	public abstract ArrayList<Integer> getAnytime();

	// Gets the money.
	public int getMoney() {
		return money;
	}

	// Adds the money specified in @param to the player's money.
	public void addMoney(int addedMoney) {
		this.money += addedMoney;
	}
	
	// Gets if the player is in jail.
	public boolean isInJail() {
		return inJail;
	}
	
	// Switches if the player is in jail.
	public void switchJailStatus() {
		inJail = !inJail;
	}
	
	// Gets the number of turns the player has been in jail.
	public int getTurnsInJail() {
		return turnsInJail;
	}
	
	// Adds 1 to the number of turns the player has been in jail.
	public void addTurnInJail() {
		turnsInJail++;
	}
	
	// Resets the number of turns in jail the player has to 0.
	// Precondition: the player has been released from jail.
	public void resetTurnInJail() {
		turnsInJail = 0;
	}
}
