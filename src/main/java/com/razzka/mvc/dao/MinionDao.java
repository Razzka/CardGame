package com.razzka.mvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.razzka.mvc.model.Minion;

@Repository("minionDao")
public class MinionDao extends AbstractDao<Integer, Minion> {
	@SuppressWarnings("unchecked")
	public List<Minion> findAllMinions() {
		Criteria criteria = createEntityCriteria();
		return (List<Minion>) criteria.list();
	}
}
