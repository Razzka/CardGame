package com.razzka.mvc.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.razzka.helpers.ImageHelper;
import com.razzka.mvc.model.Card;
import com.razzka.mvc.model.CardInHand;
import com.razzka.mvc.model.Hero;
import com.razzka.mvc.model.Heropower;
import com.razzka.mvc.model.Minion;
import com.razzka.mvc.model.Player;
import com.razzka.mvc.model.Weapon;
import com.razzka.mvc.service.CardInHandService;
import com.razzka.mvc.service.CardPlusService;
import com.razzka.mvc.service.CardService;
import com.razzka.mvc.service.HeroService;
import com.razzka.mvc.service.HeropowerService;
import com.razzka.mvc.service.ImageService;
import com.razzka.mvc.service.MinionService;
import com.razzka.mvc.service.PlayerService;
import com.razzka.mvc.service.WeaponService;

@Controller
@RequestMapping("/")
public class AppController {
	
	@Autowired
	CardService cardService;
	
	@Autowired
	CardPlusService cardPlusService;
	
	@Autowired
	HeropowerService heropowerService;
	
	@Autowired
	HeroService heroService;
	
	@Autowired
	WeaponService weaponService;
	
	@Autowired
	MinionService minionService;
	
	@Autowired
	CardInHandService cardInHandService;
	
	@Autowired
	PlayerService playerService;
	
	@Autowired
	ImageService imageService;
	
	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = { "/cards" }, method = RequestMethod.GET)
	public String listCards(ModelMap model) {
		List<Card> cards = cardService.findAllCards("Classic");
		model.addAttribute("cards", cards);
		
		return "allcards";
	}
	
	@RequestMapping(value = { "/heropowers" }, method = RequestMethod.GET)
	public String listHeropowers(ModelMap model) {
		List<Heropower> hps = heropowerService.findAllHeropowers();
		model.addAttribute("heropowers", hps);
		return "allheropowers";
	}
	
	@RequestMapping(value = { "/heroes" }, method = RequestMethod.GET)
	public String listHeroes(ModelMap model) {
		List<Hero> heroes = heroService.findAllHeroes();
		model.addAttribute("heroes", heroes);
		return "allheroes";
	}
	
	@RequestMapping(value = { "/weapons" }, method = RequestMethod.GET)
	public String listWeapons(ModelMap model) {
		List<Weapon> weapons = weaponService.findAllWeapons();
		model.addAttribute("weapons", weapons);
		return "allcards";
	}
	
	@RequestMapping(value = { "/minions" }, method = RequestMethod.GET)
	public String listMinions(ModelMap model) {
		List<Minion> minions = minionService.findAllMinions();
		model.addAttribute("minions", minions);
		return "allminions";
	}
	
	@RequestMapping(value = { "/cardsinhand" }, method = RequestMethod.GET)
	public String listCardsInHand(ModelMap model) {
		List<CardInHand> cards = cardInHandService.findAllCardsInHand();
		model.addAttribute("cardsInHand", cards);
		return "allcards";
	}
	
	@RequestMapping(value = { "/players" }, method = RequestMethod.GET)
	public String listPlayers(ModelMap model) {
		List<Player> players = playerService.findAllPlayers();
		model.addAttribute("players", players);
		return "allcards";
	}
	
	@RequestMapping(value = { "/field" }, method = RequestMethod.GET)
	public String field(ModelMap model) {
		return "field";
	}
	
	@Autowired
	Gson gson;
	
	@RequestMapping(value = { "/cardLoad/{set}" }, method = RequestMethod.GET)
	public String cardLoad(@PathVariable String set, ModelMap model) {
		try {
			
			final File folder = new File("C:\\Users\\Aleksandr\\git\\hearthpuzzle\\SpringHibernateExample\\webapp\\static\\images\\cards");
			for (final File fileEntry : folder.listFiles()) {
				if (fileEntry.getName().endsWith(".png") && fileEntry.getName().indexOf('c') == -1) {
			        final BufferedImage sourceImage = ImageIO.read(fileEntry);

			        String fileName = "E:\\Eclipse\\cards\\" + fileEntry.getName();
			        fileName = fileName.replace(".png", "c.png");
			        File outputfile = new File(fileName);

			        // BufferedImage bi = ImageHelper.cutMinion(sourceImage);
			        BufferedImage bi = ImageHelper.cutWeapon(sourceImage);
			        
			        ImageIO.write(bi, "png", outputfile);
				}
		    }
			
//			URL url = new URL("http://wow.zamimg.com/images/hearthstone/cards/enus/original/CS2_231.png");
//	        
//	        final BufferedImage sourceImage = ImageIO.read(url);
//
//	        File outputfile = new File("E:\\Eclipse\\saved1.png");
//
//	        BufferedImage bi = ImageHelper.cutMinion(sourceImage);
//	        
//	        ImageIO.write(bi, "png", outputfile);	
		} catch (IOException e) {
			
		}
		
		return null;
		
//		try {
//			HttpResponse<JsonNode> response = Unirest.get("https://omgvamp-hearthstone-v1.p.mashape.com/cards/sets/" + set)
//					.header("X-Mashape-Key", "1Y0GFuf9ncmshpZeefrcr0GMGfC5p1PcgqIjsns0KDWwId3jm4")
//					.asJson();
//			
//				Type listType = new TypeToken<ArrayList<CardPlus>>(){}.getType();
//				ArrayList<CardPlus> cards = gson.fromJson(response.getBody().toString(), listType);
//				
//				cardPlusService.saveCards(cards);
//		} catch (UnirestException e) {
//			try {
//				File f = new File("E:\\Eclipse\\cards_" + set + ".txt");
//				FileWriter fw = new FileWriter(f);
//				fw.write((new Date()).toString() + ": " + e.getLocalizedMessage());
//				fw.flush();
//				fw.close();	
//			} catch (IOException ioe) {
//				
//			}
//		}
//		
//		return null;
	}
}