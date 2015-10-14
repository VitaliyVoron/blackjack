package model;

public class Player {

	private int number;
	private int money;

	public Player(int number, int money) {
		this.number = number;
		this.money = money;
	}

	public int getNumber() {
		return number;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
}
