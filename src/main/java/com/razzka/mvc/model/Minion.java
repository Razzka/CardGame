package com.razzka.mvc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.razzka.custom.annotations.Exclude;

@Entity
@Table(name="minion")
public class Minion {
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "card_id")
	private Card card;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "hp")
	private int hp;

	@Column(name = "attack")
	private int attack;
	
	@Column(name = "position")
	private int position;
	
	@Column(name = "side")
	private int side;
	
	@Column(name = "effects")
	private String effects;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "player_id")
	@Exclude
	private Player player;
	
	// Дополнительные иконки + к тем, которые идут от Card (типа если Друид баффнул Душой Леса, то добавляется DT, которого обычно нет).
	@Column(name = "icon")
	private String icon;
	
	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	public String getEffects() {
		return effects;
	}

	public void setEffects(String effects) {
		this.effects = effects;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
}
