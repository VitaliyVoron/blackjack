package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private	List<Card> listDeck = new ArrayList<Card>(52);

	public List<Card> getListDeck() {
		return listDeck;
	}

	public void setListDeck(List<Card> listDeck) {
		this.listDeck = listDeck;
	}
	
	public void fillDeck(){
		String[] title = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J",
				"Q", "K", "A" };
		String[] suit = { "Peak", "Heart", "Tambourine", "Cross" };
		for (int i = 0; i < title.length; i++) {
			int number = i + 2;
			if (i + 2 > 10 && i + 2 < 14) {
				number = 10;
			} else if (i + 2 == 14) {
				number = 11;
			}
			for (int f = 0; f < suit.length; f++) {
				Card card = new Card();
				card.setTitle(title[i]);
				card.setSuit(suit[f]);
				card.setNumber(number);
				listDeck.add(card);
			}
		}
	}
	
	public void mixDeck(){
		Collections.shuffle(listDeck);
	}
	
	public Card dialCard(){
		int deckSize = listDeck.size();
		Card card = listDeck.get(deckSize - 1);
		listDeck.remove(deckSize - 1);
		return card;
	}

}
