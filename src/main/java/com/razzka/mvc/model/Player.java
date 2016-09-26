package com.razzka.mvc.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="player")
public class Player {
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "hero_id")
	private Hero hero;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "heropower_id")
	private Heropower heropower;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "weapon_id")
	private Weapon weapon;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "hp")
	private int hp;

	@Column(name = "attack")
	private int attack;
	
	@Column(name = "armor")
	private int armor;
	
	@Column(name = "effects")
	private String effects;
	
	@Column(name = "mana_total")
	private int manaTotal;
	
	@Column(name = "mana_available")
	private int manaAvailable;
	
	@Column(name = "mana_locked")
	private int manaLocked;
	
	@Column(name = "heropower_cost")
	private int heropowerCost;
	
	@OrderBy("position ASC")
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "player")
	private Set<Minion> minions;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "player")
	private Set<CardInHand> cardsInHand;

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public Heropower getHeropower() {
		return heropower;
	}

	public void setHeropower(Heropower heropower) {
		this.heropower = heropower;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
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

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public String getEffects() {
		return effects;
	}

	public void setEffects(String effects) {
		this.effects = effects;
	}

	public int getManaTotal() {
		return manaTotal;
	}

	public void setManaTotal(int manaTotal) {
		this.manaTotal = manaTotal;
	}

	public int getManaAvailable() {
		return manaAvailable;
	}

	public void setManaAvailable(int manaAvailable) {
		this.manaAvailable = manaAvailable;
	}

	public int getManaLocked() {
		return manaLocked;
	}

	public void setManaLocked(int manaLocked) {
		this.manaLocked = manaLocked;
	}

	public int getHeropowerCost() {
		return heropowerCost;
	}

	public void setHeropowerCost(int heropowerCost) {
		this.heropowerCost = heropowerCost;
	}

	public Set<Minion> getMinions() {
		return minions;
	}

	public void setMinions(Set<Minion> minions) {
		this.minions = minions;
	}

	public Set<CardInHand> getCardsInHand() {
		return cardsInHand;
	}

	public void setCardsInHand(Set<CardInHand> cardsInHand) {
		this.cardsInHand = cardsInHand;
	}
}
