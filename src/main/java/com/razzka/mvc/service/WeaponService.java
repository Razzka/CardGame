package com.razzka.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.razzka.mvc.dao.WeaponDao;
import com.razzka.mvc.model.Weapon;

@Service("weaponService")
@Transactional
public class WeaponService {
	@Autowired
	private WeaponDao dao;
	
	public List<Weapon> findAllWeapons() {
		return dao.findAllWeapons();
	}
}
