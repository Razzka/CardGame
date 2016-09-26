package com.razzka.mvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.razzka.mvc.model.CardInHand;

@Repository("cardInHandDao")
public class CardInHandDao extends AbstractDao<Integer, CardInHand> {
	@SuppressWarnings("unchecked")
	public List<CardInHand> findAllCardsInHand() {
		Criteria criteria = createEntityCriteria();
		return (List<CardInHand>) criteria.list();
	}
}
