package com.razzka.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.razzka.mvc.dao.CardPlusDao;
import com.razzka.mvc.model.CardPlus;

@Service("cardPlusService")
@Transactional
public class CardPlusService {
	@Autowired
	private CardPlusDao dao;

	public CardPlus findById(int id) {
		return dao.findById(id);
	}

	public void saveCard(CardPlus card) {
		dao.saveCard(card);
	}

	public void deleteCardById(int id) {
		dao.deleteCardById(id);
	}

	public List<CardPlus> findAllCards() {
		return dao.findAllCards();
	}
	
	public List<CardPlus> findNotProcessed() {
		return dao.findNotProcessed();
	}

	public void saveCards(ArrayList<CardPlus> cards) {
		for (CardPlus card : cards) {
			saveCard(card);
		}
	}
}
