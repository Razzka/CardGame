package com.razzka.mvc.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.razzka.helpers.ImageHelper;
import com.razzka.mvc.dao.CardDao;
import com.razzka.mvc.dao.CardPlusDao;
import com.razzka.mvc.model.Card;
import com.razzka.mvc.model.CardPlus;

@Service("cardService")
@Transactional
public class CardService {
	@Autowired
	private CardDao dao;
	
	@Autowired
	private CardPlusDao cpDao;

	public Card findById(int id) {
		return dao.findById(id);
	}

	public void saveCard(Card card) {
		dao.saveCard(card);
	}

	public void updateCard(Card card) {
		Card entity = dao.findById(card.getId());
		if(entity!=null){
			entity.setName(card.getName());
			entity.setDefaultAttack(card.getDefaultAttack());
			entity.setDefaultCost(card.getDefaultCost());
			entity.setDefaultHp(card.getDefaultHp());
			entity.setIcon(card.getIcon());
			entity.setText(card.getText());
			entity.setType(card.getType());
			dao.update(entity);
		}		
	}

	public void deleteCardById(int id) {
		dao.deleteCardById(id);
	}

	public List<Card> findAllCards(String setName) {
		return dao.findAllCards(setName);
	}
	
	public List<Card> searchCards(String name) {
		return dao.searchCards(name);
	}
	
	public void loadImage(Card c) {
		Integer id = c.getId();
		String prefix = "E:\\Eclipse\\images\\";
		String imgPath = prefix + id.toString();
		// String golden = "g";
		String cropped = "c";
		String pngExt = ".png";
		// String gifExt = ".gif";
		
		if (c.getImageUrl() != null) {
			if ("Hero Power".equals(c.getType())) {
				try {
					String s1 = imgPath + cropped + pngExt;
					URL url = new URL(c.getImageUrl());
			        final BufferedImage sourceImage = ImageIO.read(url);
			        File outputfile = new File(s1);
			        BufferedImage bi = ImageHelper.cutHeroPower(sourceImage);
			        ImageIO.write(bi, "png", outputfile);
			        
			        c.setImgCropPath(s1);
					
	//				String s = imgPath + golden + cropped + gifExt;
	//				ImageHelper.cutGifHeropower(c.getImgGold(), s);
	//				card.setImgGoldenCropPath(s);
				} catch (Exception e) {
					
				}
			}
			
			if ("Weapon".equals(c.getType())) {
				try {
					String s1 = imgPath + cropped + pngExt;
					URL url = new URL(c.getImageUrl());
			        final BufferedImage sourceImage = ImageIO.read(url);
			        File outputfile = new File(s1);
			        BufferedImage bi = ImageHelper.cutWeapon(sourceImage);
			        ImageIO.write(bi, "png", outputfile);
			        
			        c.setImgCropPath(s1);
					
	//				String s = imgPath + golden + cropped + gifExt;
	//				ImageHelper.cutGifWeapon(c.getImgGold(), s);
	//				card.setImgGoldenCropPath(s);
				} catch (Exception e) {
					
				}
			}
			
			
			try {
				ImageHelper.saveImage(c.getImageUrl(), imgPath + pngExt);
				c.setImgPath(imgPath + pngExt);
				
	//			ImageHelper.saveImage(c.getImgGold(), imgPath + golden + gifExt);
	//			card.setImgGoldenPath(imgPath + golden + gifExt);
			} catch (Exception e) {
				
			}
		}
		
		dao.updateCard(c);
	}
	
	public List<Card> findForLoad() {
		return dao.findForLoad();
	}
	
	public List<Card> findMissed() {
		return dao.findMissed();
	}
	
	public void transferCard(CardPlus c) {
		Card card = new Card();
		card.setDefaultAttack(c.getAttack());
		card.setDefaultCost(c.getCost());
		card.setDefaultHp(c.getHealth());
		card.setExternalId(c.getCardId());
		card.setName(c.getName());
		card.setText(c.getText());
		card.setType(c.getType());
		card.setRarity(c.getRarity());
		card.setDateCreate(new Date());
		saveCard(card);
		
		Integer id = card.getId();
		String prefix = "E:\\Eclipse\\images\\";
		String imgPath = prefix + id.toString();
		// String golden = "g";
		String cropped = "c";
		String pngExt = ".png";
		// String gifExt = ".gif";
		
		if (c.getImg() != null) {
			if ("Hero Power".equals(card.getType())) {
				try {
					String s1 = imgPath + cropped + pngExt;
					URL url = new URL(c.getImg());
			        final BufferedImage sourceImage = ImageIO.read(url);
			        File outputfile = new File(s1);
			        BufferedImage bi = ImageHelper.cutHeroPower(sourceImage);
			        ImageIO.write(bi, "png", outputfile);
			        
			        card.setImgCropPath(s1);
					
	//				String s = imgPath + golden + cropped + gifExt;
	//				ImageHelper.cutGifHeropower(c.getImgGold(), s);
	//				card.setImgGoldenCropPath(s);
				} catch (Exception e) {
					
				}
			}
			
			if ("Weapon".equals(card.getType())) {
				try {
					String s1 = imgPath + cropped + pngExt;
					URL url = new URL(c.getImg());
			        final BufferedImage sourceImage = ImageIO.read(url);
			        File outputfile = new File(s1);
			        BufferedImage bi = ImageHelper.cutWeapon(sourceImage);
			        ImageIO.write(bi, "png", outputfile);
			        
			        card.setImgCropPath(s1);
					
	//				String s = imgPath + golden + cropped + gifExt;
	//				ImageHelper.cutGifWeapon(c.getImgGold(), s);
	//				card.setImgGoldenCropPath(s);
				} catch (Exception e) {
					
				}
			}
			
			
			try {
				ImageHelper.saveImage(c.getImg(), imgPath + pngExt);
				card.setImgPath(imgPath + pngExt);
				
	//			ImageHelper.saveImage(c.getImgGold(), imgPath + golden + gifExt);
	//			card.setImgGoldenPath(imgPath + golden + gifExt);
			} catch (Exception e) {
				
			}
		}
		
		saveCard(card);
		c.setProcessed(1);
		cpDao.updateCard(c);
	}
	
	public void checkAndLoadImage(Card c) {
		if (c.getImgPath() != null) {
			File f = new File(c.getImgPath());
			if (f.exists() && !f.isDirectory()) { 
			    // all right!
			} else {
				loadImage(c);
			}
		}
	}
}
