package com.razzka.mvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.razzka.mvc.model.Player;

@Repository("playerDao")
public class PlayerDao extends AbstractDao<Integer, Player> {
	@SuppressWarnings("unchecked")
	public List<Player> findAllPlayers() {
		Criteria criteria = createEntityCriteria();
		return (List<Player>) criteria.list();
	}
	
	public Player findById(int id) {
		return getByKey(id);
	}
}
