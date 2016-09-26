package com.razzka.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.razzka.mvc.dao.PlayerDao;
import com.razzka.mvc.model.Player;

@Service("playerService")
@Transactional
public class PlayerService {
	@Autowired
	private PlayerDao dao;
	
	public List<Player> findAllPlayers() {
		return dao.findAllPlayers();
	}
	public Player findById(int id) {
		return dao.findById(id);
	}
}
