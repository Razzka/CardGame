package com.razzka.mvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.razzka.mvc.model.Heropower;

@Repository("heropowerDao")
public class HeropowerDao extends AbstractDao<Integer, Heropower> {
	public Heropower findById(int id) {
		return getByKey(id);
	}

	public void saveHeropower(Heropower heropower) {
		persist(heropower);
	}

	public void deleteHeropowerById(int id) {
		Query query = getSession().createSQLQuery("delete from Heropower where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Heropower> findAllHeropowers() {
		Criteria criteria = createEntityCriteria();
		return (List<Heropower>) criteria.list();
	}
}
