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

	int balance = 100;

	@RequestMapping(value = "/")
	public String mainPage(ModelMap model) {
		String message = "Welcome Player 1!";
		model.addAttribute("message", message);
		model.addAttribute("balance", balance);
		return "index";
	}

	@RequestMapping(value = "/start", method = RequestMethod.POST)
	public String startGame() {
		gameService.addPlayer(new Player(123, balance));
		return "redirect:/table";
	}

	@RequestMapping(value = "/add_money", method = RequestMethod.POST)
	public String addMoneyButton() {
		return "redirect:/payment";
	}

	@RequestMapping(value = "/payment")
	public String addMoney(ModelMap model) {
		model.addAttribute("balance", balance);
		return "payment";
	}

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String chipsBought(@ModelAttribute("chips") int chips) {
		balance += chips;
		return "redirect:/";
	}

	@RequestMapping(value = "/table")
	public String newTable(ModelMap model) {
		model.addAttribute("user", gameService.getListPlayers().get(1));
		model.addAttribute("bet", gameService.getBet());
		model.addAttribute("message", gameService.getMessage());
		model.addAttribute("players", gameService.getListPlayers());
		model.addAttribute("inProgress", gameService.isInProgress());
		return "table";
	}
	
	@RequestMapping(value = "/table", method = RequestMethod.POST)
	public String start(@ModelAttribute("bet") String bet) {
		if("".equals(bet)){
			gameService.setMessage("Make your bet!");
			return "redirect:/game";
		}
		int playerBet = Integer.parseInt(bet);
		gameService.startGame(playerBet);
		return "redirect:/table";
	}

	@RequestMapping(value = "/hit", method = RequestMethod.POST)
	public String hit() {
		gameService.dealCardToPlayer();
		gameService.checkPlayerSum();
		return "redirect:/table";
	}
	
	@RequestMapping(value = "/stay", method = RequestMethod.POST)
	public String stay() {
		gameService.dealCardToDealer();
		gameService.checkAllSumNumbers();
		return "redirect:/table";
	}

}