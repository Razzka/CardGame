package com.razzka.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.razzka.mvc.dao.CardInHandDao;
import com.razzka.mvc.model.CardInHand;

@Service("cardInHandService")
@Transactional
public class CardInHandService {
	@Autowired
	private CardInHandDao dao;
	
	public List<CardInHand> findAllCardsInHand() {
		return dao.findAllCardsInHand();
	}
}
