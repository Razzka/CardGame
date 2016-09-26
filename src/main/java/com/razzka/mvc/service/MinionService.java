package com.razzka.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.razzka.mvc.dao.MinionDao;
import com.razzka.mvc.model.Minion;

@Service("minionService")
@Transactional
public class MinionService {
	@Autowired
	private MinionDao dao;
	
	public List<Minion> findAllMinions() {
		return dao.findAllMinions();
	}
}
