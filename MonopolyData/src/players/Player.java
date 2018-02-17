package players;

import java.util.ArrayList;

import monopoly.Property;

public abstract class Player {
	private int money;
	private boolean inJail;
	private int turnsInJail;
	// ArrayList<Property> ownedProperty;
	
	public Player(int cMoney, boolean cInJail) {
		money = cMoney;
		inJail = cInJail;
		turnsInJail = 0;
	}
	
	abstract void getPossibleActions();

	public abstract int getAction();

	public int getMoney() {
		return money;
	}

	public void addMoney(int addedMoney) {
		this.money += addedMoney;
	}
	
	public boolean isInJail() {
		return inJail;
	}
	
	public void switchJailStatus() {
		inJail = !inJail;
	}
	
	public int getTurnsInJail() {
		return turnsInJail;
	}
	
	public void addTurnInJail() {
		turnsInJail++;
	}
	
	public void resetTurnInJail() {
		turnsInJail = 0;
	}
}
