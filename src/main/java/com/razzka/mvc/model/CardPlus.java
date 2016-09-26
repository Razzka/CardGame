package com.razzka.mvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="card_plus")
public class CardPlus {
	@Column(name = "img")
	private String img;
	
	@Column(name = "cost")
	private Integer cost;
	
	@Column(name = "collectible")
	private boolean collectible;
	
	@Column(name = "artist")
	private String artist;
	
	@Column(name = "health")
	private Integer health;
	
	// private String mechanics;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "locale")
	private String locale;
	
	@Column(name = "flavor")
	private String flavor;
	
	@Column(name = "card_set")
	private String cardSet;
	
	@Column(name = "attack")
	private Integer attack;
	
	@Id
	@Column(name = "card_id", nullable = false)
	private String cardId;
	
	@Column(name = "faction")
	private String faction;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "img_gold")
	private String imgGold;
	
	@Column(name = "text")
	private String text;
	
	@Column(name = "rarity")
	private String rarity;
	
	@Column(name = "processed")
	private Integer processed;

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public boolean isCollectible() {
		return collectible;
	}

	public void setCollectible(boolean collectible) {
		this.collectible = collectible;
	}

	public String getAtrist() {
		return artist;
	}

	public void setAtrist(String artist) {
		this.artist = artist;
	}

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public String getCardSet() {
		return cardSet;
	}

	public void setCardSet(String cardSet) {
		this.cardSet = cardSet;
	}

	public Integer getAttack() {
		return attack;
	}

	public void setAttack(Integer attack) {
		this.attack = attack;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getFaction() {
		return faction;
	}

	public void setFaction(String faction) {
		this.faction = faction;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgGold() {
		return imgGold;
	}

	public void setImgGold(String imgGold) {
		this.imgGold = imgGold;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Integer getProcessed() {
		return processed;
	}

	public void setProcessed(Integer processed) {
		this.processed = processed;
	}
}
