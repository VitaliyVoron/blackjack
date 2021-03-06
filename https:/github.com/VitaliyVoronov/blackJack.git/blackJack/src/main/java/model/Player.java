package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private int number;
	private int accountNumber;
	private List<Card> cards;
	private int sumNumber;
	private String status;
	private int money;
	boolean firstT = true;

	public Player(int number) {
		this.number = number;
		cards = new ArrayList<Card>();
	}
	
	public Player(int number, int money) {
		this.number = number;
		this.money = money;
		cards = new ArrayList<Card>();
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public int getNumber() {
		return number;
	}

	public void setNunmber(int number) {
		this.number = number;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(Card card) {
		cards.add(card);
	}

	public int getSumNumber() {
		sumNumber = 0;
		for (Card card : cards) {
			sumNumber += card.getNumber();
		}
		if(sumNumber > 21 ){
			for (Card card : cards) {
				if(card.getNumber() == 11 && firstT == true){
					sumNumber -= 10;
					firstT = false;
				}
			}
		}
		return sumNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	
}
