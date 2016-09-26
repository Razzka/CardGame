package com.razzka.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.razzka.mvc.dao.HeroDao;
import com.razzka.mvc.model.Hero;

@Service("heroService")
@Transactional
public class HeroService {
	@Autowired
	private HeroDao dao;
	
	public List<Hero> findAllHeroes() {
		return dao.findAllHeroes();
	}
}
