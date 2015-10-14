package service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import model.Player;

@Component
public class Service {
	
	List<Player> players = new ArrayList<Player>();

	public Player getPlayer() {
		return players.get(players.size()-1);
	}

	public void setPlayers(Player player) {
		players.add(player);
	}
	
	
	

}
