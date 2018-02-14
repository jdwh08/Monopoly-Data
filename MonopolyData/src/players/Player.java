package players;

import java.util.ArrayList;

import monopoly.Property;

public abstract class Player {
	private int money;
	private boolean inJail;
	ArrayList<Property> ownedProperty;
	
	abstract void getPossibleActions();
	abstract void getAction();
	
	public int getMoney() {
		return money;
	}
	
	public void addMoney(int addedMoney) {
		this.money = addedMoney;
	}
	
	public boolean isInJail() {
		return inJail;
	}
}