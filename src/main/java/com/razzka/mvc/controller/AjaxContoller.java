package com.razzka.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.razzka.mvc.model.Card;
import com.razzka.mvc.model.Hero;
import com.razzka.mvc.model.Heropower;
import com.razzka.mvc.model.Image;
import com.razzka.mvc.model.Minion;
import com.razzka.mvc.model.Player;
import com.razzka.mvc.model.Puzzle;
import com.razzka.mvc.model.Weapon;
import com.razzka.mvc.service.CardPlusService;
import com.razzka.mvc.service.CardService;
import com.razzka.mvc.service.HeroService;
import com.razzka.mvc.service.HeropowerService;
import com.razzka.mvc.service.ImageService;
import com.razzka.mvc.service.MinionService;
import com.razzka.mvc.service.PlayerService;
import com.razzka.mvc.service.PuzzleService;
import com.razzka.mvc.service.WeaponService;

@Controller
@RequestMapping("/ajax/")
public class AjaxContoller {
	@Autowired
	Gson gson;
	
	@Autowired
	ImageService imageService;
	
	@Autowired
	CardService cardService;
	
	@Autowired
	CardPlusService cardPlusService;
	
	@Autowired
	MinionService minionService;
	
	@Autowired
	PlayerService playerService;
	
	@Autowired
	PuzzleService puzzleService;
	
	@Autowired
	HeropowerService heropowerService;
	
	@Autowired
	HeroService heroService;
	
	@Autowired
	WeaponService weaponService;
    
    @RequestMapping(value = { "/get-image-{id}" }, method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable String id, ModelMap model) {
    	try {
    		Integer intId = Integer.parseInt(id);
    		Image image = imageService.findById(intId);
    		return new ResponseEntity<byte[]>(image.getImage(),
    				ControllerHelper.httpHeaderImage("kartinko", image.getImage().length), HttpStatus.OK);
    	} catch (NumberFormatException e) {
    		model.addAttribute("error", 1);
    	}

    	return null;
    }
    
    @RequestMapping(value = { "/get-card-{id}" }, method = RequestMethod.GET,  produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> getCard(@PathVariable String id, ModelMap model) {
    	try {
    		Integer intId = Integer.parseInt(id);
    		Card card = cardService.findById(intId);
    		String result = gson.toJson(card); 
    		return new ResponseEntity<String>(result, HttpStatus.OK);
    	} catch (NumberFormatException e) {
    		model.addAttribute("error", 1);
    	}

    	return null;
    }
    
    @RequestMapping(value = { "/get-cards" }, method = RequestMethod.GET,  produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> getCards(ModelMap model) {
    	try {
    		List<Card> cards = cardService.findAllCards("Classic");
    		String result = gson.toJson(cards);
    		return new ResponseEntity<String>(result, HttpStatus.OK);
    	} catch (NumberFormatException e) {
    		model.addAttribute("error", 1);
    	}

    	return null;
    }
    
    @RequestMapping(value = { "/get-players" }, method = RequestMethod.GET,  produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> getPlayers(ModelMap model) {
    	try {
    		List<Player> players = playerService.findAllPlayers();
    		String result = gson.toJson(players); 
    		return new ResponseEntity<String>(result, HttpStatus.OK);
    	} catch (NumberFormatException e) {
    		model.addAttribute("error", 1);
    	}

    	return null;
    }
    
    @RequestMapping(value = { "/get-player-{id}" }, method = RequestMethod.GET,  produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> getPlayer(@PathVariable int id, ModelMap model) {
    	try {
    		Player player = playerService.findById(id);
    		String result = gson.toJson(player); 
    		return new ResponseEntity<String>(result, HttpStatus.OK);
    	} catch (NumberFormatException e) {
    		model.addAttribute("error", 1);
    	}

    	return null;
    }
    
    @RequestMapping(value = { "/get-minions" }, method = RequestMethod.GET,  produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> getMinions(ModelMap model) {
    	try {
    		List<Minion> minions = minionService.findAllMinions();
    		String result = gson.toJson(minions); 
    		return new ResponseEntity<String>(result, HttpStatus.OK);
    	} catch (NumberFormatException e) {
    		model.addAttribute("error", 1);
    	}

    	return null;
    }
    
    @RequestMapping(value = { "/get-heropowers" }, method = RequestMethod.GET,  produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> getHeropowers(ModelMap model) {
    	try {
    		List<Heropower> heropowers = heropowerService.findAllHeropowers();
    		String result = gson.toJson(heropowers); 
    		return new ResponseEntity<String>(result, HttpStatus.OK);
    	} catch (NumberFormatException e) {
    		model.addAttribute("error", 1);
    	}

    	return null;
    }
    
    @RequestMapping(value = { "/get-weapons" }, method = RequestMethod.GET,  produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> getWeapons(ModelMap model) {
    	try {
    		List<Weapon> weapons = weaponService.findAllWeapons();
    		String result = gson.toJson(weapons); 
    		return new ResponseEntity<String>(result, HttpStatus.OK);
    	} catch (NumberFormatException e) {
    		model.addAttribute("error", 1);
    	}

    	return null;
    }
    
    @RequestMapping(value = { "/process-cards" }, method = RequestMethod.GET,  produces = { MediaType.APPLICATION_JSON_VALUE })
    public String processCards(ModelMap model) {
    	try {
    		
//    		List<CardPlus> cards = cardPlusService.findNotProcessed();
//    		
//    		for (CardPlus card: cards) {
//    			cardService.transferCard(card);
//    		}
    		
    		return null;
    	} catch (NumberFormatException e) {
    		model.addAttribute("error", 1);
    	}

    	return null;
    }
    
    @RequestMapping(value = { "/process-urls" }, method = RequestMethod.GET,  produces = { MediaType.APPLICATION_JSON_VALUE })
    public String processUrls(ModelMap model) {
    	try {
    		List<Card> cards = cardService.findForLoad();
    		
    		for (Card card: cards) {
    			cardService.loadImage(card);
    		}
    		
    		return null;
    	} catch (NumberFormatException e) {
    		model.addAttribute("error", 1);
    	}

    	return null;
    }
    
    @RequestMapping(value = { "/process-missed" }, method = RequestMethod.GET,  produces = { MediaType.APPLICATION_JSON_VALUE })
    public String processMissed(ModelMap model) {
    	try {
    		List<Card> cards = cardService.findMissed();
    		
    		for (Card card: cards) {
    			cardService.checkAndLoadImage(card);
    		}
    		
    		return null;
    	} catch (NumberFormatException e) {
    		model.addAttribute("error", 1);
    	}

    	return null;
    }
    
    @RequestMapping(value = { "/get-puzzle-{id}" }, method = RequestMethod.GET,  produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> getPuzzle(@PathVariable int id, ModelMap model) {
    	try {
    		Puzzle puzzle = puzzleService.findById(id);
    		String result = gson.toJson(puzzle); 
    		return new ResponseEntity<String>(result, HttpStatus.OK);
    	} catch (NumberFormatException e) {
    		model.addAttribute("error", 1);
    	}

    	return null;
    }
    
    @RequestMapping(value = { "/search-cards" }, method = RequestMethod.GET,  produces = { MediaType.APPLICATION_JSON_VALUE },
    		params = {"name"})
    public ResponseEntity<String> searchCards(ModelMap model, @RequestParam(value = "name") String name) {
    	try {
    		List<Card> cards = cardService.searchCards(name);
    		String result = gson.toJson(cards); 
    		return new ResponseEntity<String>(result, HttpStatus.OK);
    	} catch (NumberFormatException e) {
    		model.addAttribute("error", 1);
    	}

    	return null;
    }
    
    @RequestMapping(value = { "/get-heroes" }, method = RequestMethod.GET,  produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> getHeroes(ModelMap model) {
    	try {
    		List<Hero> heroes = heroService.findAllHeroes();
    		String result = gson.toJson(heroes); 
    		return new ResponseEntity<String>(result, HttpStatus.OK);
    	} catch (NumberFormatException e) {
    		model.addAttribute("error", 1);
    	}

    	return null;
    }
}
