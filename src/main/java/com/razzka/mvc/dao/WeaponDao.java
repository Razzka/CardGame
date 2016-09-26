package com.razzka.mvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.razzka.mvc.model.Weapon;

@Repository("weaponDao")
public class WeaponDao extends AbstractDao<Integer, Weapon> {
	@SuppressWarnings("unchecked")
	public List<Weapon> findAllWeapons() {
		Criteria criteria = createEntityCriteria();
		return (List<Weapon>) criteria.list();
	}
}
