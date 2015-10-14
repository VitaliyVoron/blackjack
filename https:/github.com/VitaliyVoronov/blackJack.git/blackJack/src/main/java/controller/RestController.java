package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Player;
import service.Service;

@Controller
public class RestController {
	
	@Autowired
	private Service service;

	@RequestMapping(value = "/")
	public String mainPage(ModelMap model) {
		String message = "Enter your number!";
		model.addAttribute("message", message);
		return "index";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String addPlayer(@ModelAttribute("id") int id, @ModelAttribute("money") int money) {
		Player player = new Player(id,money);
		service.setPlayers(player);
		return "redirect:/table";
	}
	
	@RequestMapping(value = "/table")
	public String newTable(ModelMap model) {
		model.addAttribute("player", service.getPlayer());
		return "table";
	}
	
	
	
}