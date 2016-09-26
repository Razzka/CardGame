package com.razzka.mvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.razzka.mvc.model.Hero;

@Repository("heroDao")
public class HeroDao extends AbstractDao<Integer, Hero> {
	@SuppressWarnings("unchecked")
	public List<Hero> findAllHeroes() {
		Criteria criteria = createEntityCriteria();
		return (List<Hero>) criteria.list();
	}
}
