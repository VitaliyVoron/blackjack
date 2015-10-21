package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Deck;
import model.Player;
import service.GameService;

@Controller
public class RestController {

	@Autowired
	private GameService gameService;

	@RequestMapping(value = "/")
	public String mainPage(ModelMap model) {
		String message = "Enter your number!";
		model.addAttribute("message", message);
		return "index";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String addPlayer(@ModelAttribute("id") int id, @ModelAttribute("money") int money) {
		Player player = new Player(id, money);
		gameService.startGame(player);
		return "redirect:/table";
	}

	@RequestMapping(value = "/table")
	public String newTable(ModelMap model) {
		Deck deck = gameService.getDeck();
		model.addAttribute("deck", deck.getListDeck());
		model.addAttribute("players", gameService.getListPlayers());
		return "table";
	}

	@RequestMapping(value = "/more")
	public String hit(ModelMap model) {
		gameService.dealCardToPlayer();
		return "redirect:/table";
	}
	
	@RequestMapping(value = "/stay")
	public String stay(ModelMap model) {
		gameService.dealCardToDealer();
		gameService.checkAllSumNumbers();
		return "redirect:/table";
	}

}