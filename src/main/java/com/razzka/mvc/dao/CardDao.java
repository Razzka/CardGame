package com.razzka.mvc.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.razzka.mvc.model.Card;

@Repository("cardDao")
public class CardDao extends AbstractDao<Integer, Card> {

	public Card findById(int id) {
		return getByKey(id);
	}

	public void persistCard(Card card) {
		persist(card);
	}
	
	public void saveCard(Card card) {
		save(card);
	}
	
	public void updateCard(Card card) {
		update(card);
	}

	public void deleteCardById(int id) {
		Query query = getSession().createSQLQuery("delete from Card where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Card> findAllCards(String setName) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("set", setName));
		return (List<Card>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Card> searchCards(String name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.ilike("name", "%" + name + "%", MatchMode.ANYWHERE));
		criteria.add(Restrictions.eq("set", "Classic"));
		
		criteria.add(Restrictions.in("type", new String[] {"Minion", "Spell", "Weapon"}));
		criteria.setMaxResults(12);
		return (List<Card>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Card> findForLoad() {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.isNull("imgPath"));
		criteria.add(Restrictions.isNotNull("imageUrl"));
		criteria.setMaxResults(1000);
		return (List<Card>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Card> findMissed() {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.isNotNull("imageUrl"));
		return (List<Card>) criteria.list();
	}
	
}
