package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import model.Card;
import model.Deck;
import model.Player;

@Component
public class GameService {

	private List<Player> listPlayers;
	private Deck deck;
	private boolean inProgress;
	private String message;
	private int bet;
	private DAOService dao;

	public GameService() {
		listPlayers = new ArrayList<Player>();
		createDealer();
		inProgress = false;
		dao = new DAOService();
	}

	public List<Player> getListPlayers() {
		return listPlayers;
	}

	public void addPlayer(Player player) {
		listPlayers.add(player);
	}

	public Deck getDeck() {
		return deck;
	}

	public void startGame(int bet) {
		message = "";
		inProgress = true;
		this.bet = bet;
		prepareDeck();
		cleanHands();
		firstDealCards();
	}

	private void cleanHands() {
		for (Player player : listPlayers) {
			player.getCards().clear();
		}
	}

	public void prepareDeck() {
		deck = new Deck();
		deck.fillDeck();
		deck.mixDeck();
	}

	public void firstDealCards() {
		listPlayers.get(0).setCards(deck.dialCard());
		listPlayers.get(1).setCards(deck.dialCard());
		listPlayers.get(1).setCards(deck.dialCard());
	}

	public void createDealer() {
		Player dealer = new Player(1000);
		listPlayers.add(0, dealer);
	}

	public void dealCardToPlayer() {
		listPlayers.get(1).setCards(deck.dialCard());
	}

	public void dealCardToDealer() {
		Player dealer = listPlayers.get(0);
		if (dealer.getSumNumber() < 17) {
			Card card = deck.dialCard();
			listPlayers.get(0).setCards(card);
		}
	}

	public void checkAllSumNumbers() {
		int sumPlayer = listPlayers.get(1).getSumNumber();
		int sumDealer = listPlayers.get(0).getSumNumber();
		if (sumPlayer > sumDealer && sumPlayer <= 21 || sumDealer > 21) {
			message = "You Won!";
		} else {
			message = "You Lose!";
		}
		inProgress = false;
	}

	public boolean isInProgress() {
		return inProgress;
	}

	public void setInProgress(boolean inProgress) {
		this.inProgress = inProgress;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getBet() {
		return bet;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}

	public void checkPlayerSum() {
		if (listPlayers.get(1).getSumNumber() > 21) {
			message = "You lost!";
			inProgress = false;
		}
	}
	
	public void updatePlayerAccount(Player player){
		dao.updatePlayerAccount(player);
	}

}
