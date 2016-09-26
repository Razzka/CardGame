package com.razzka.mvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.razzka.mvc.model.CardPlus;

@Repository("cardPlusDao")
public class CardPlusDao extends AbstractDao<Integer, CardPlus> {
	public CardPlus findById(int id) {
		return getByKey(id);
	}

	public void saveCard(CardPlus card) {
		persist(card);
	}
	
	public void updateCard(CardPlus card) {
		update(card);
	}

	public void deleteCardById(int id) {
		Query query = getSession().createSQLQuery("delete from card_plus where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<CardPlus> findAllCards() {
		Criteria criteria = createEntityCriteria();
		return (List<CardPlus>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<CardPlus> findNotProcessed() {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("processed", 0));
		//criteria.add(Restrictions.eq("type", "Hero Power"));
		criteria.setMaxResults(1000);
		return (List<CardPlus>) criteria.list();
	}
}
