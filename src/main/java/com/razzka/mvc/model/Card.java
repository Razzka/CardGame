package com.razzka.mvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="card")
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@NotNull
	@Column(name = "TYPE", nullable = false)
	private String type;
	
	@NotNull
	@Column(name = "create_date")
	private Date dateCreate;
	
	@Column(name = "TEXT")
	private String text;
	
	@Column(name = "DEFAULT_HP")
	private Integer defaultHp;
	
	@Column(name = "DEFAULT_ATTACK")
	private Integer defaultAttack;
	
	@Column(name = "DEFAULT_COST")
	private Integer defaultCost;
	
	@Column(name = "ICON")
	private Integer icon;
	
	@Column(name = "IMAGE_ID")
	private Integer imageId;
	
	@Column(name = "external_id")
	private String externalId;
	
	@Column(name = "img_path")
	private String imgPath;
	
	@Column(name = "imgc_path")
	private String imgCropPath;
	
	@Column(name = "gimg_path")
	private String imgGoldenPath;
	
	@Column(name = "gimgc_path")
	private String imgGoldenCropPath;
	
	@Column(name = "rarity")
	private String rarity;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "card_set")
	private String set;
	
	public void setType(String type) {
		this.type = type;
	}

	public void setDefaultHp(Integer defaultHp) {
		this.defaultHp = defaultHp;
	}

	public void setDefaultAttack(Integer defaultAttack) {
		this.defaultAttack = defaultAttack;
	}

	public void setDefaultCost(Integer defaultCost) {
		this.defaultCost = defaultCost;
	}

	public void setIcon(Integer icon) {
		this.icon = icon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getDefaultHp() {
		return defaultHp;
	}

	public void setDefaultHp(int defaultHp) {
		this.defaultHp = defaultHp;
	}

	public int getDefaultAttack() {
		return defaultAttack;
	}

	public void setDefaultAttack(int defaultAttack) {
		this.defaultAttack = defaultAttack;
	}

	public int getDefaultCost() {
		return defaultCost;
	}

	public void setDefaultCost(int defaultCost) {
		this.defaultCost = defaultCost;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getImgCropPath() {
		return imgCropPath;
	}

	public void setImgCropPath(String imgCropPath) {
		this.imgCropPath = imgCropPath;
	}

	public String getImgGoldenPath() {
		return imgGoldenPath;
	}

	public void setImgGoldenPath(String imgGoldenPath) {
		this.imgGoldenPath = imgGoldenPath;
	}

	public String getImgGoldenCropPath() {
		return imgGoldenCropPath;
	}

	public void setImgGoldenCropPath(String imgGoldenCropPath) {
		this.imgGoldenCropPath = imgGoldenCropPath;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getSet() {
		return set;
	}

	public void setSet(String set) {
		this.set = set;
	}
}
