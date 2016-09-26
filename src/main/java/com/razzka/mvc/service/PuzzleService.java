package com.razzka.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.razzka.mvc.dao.PuzzleDao;
import com.razzka.mvc.model.Puzzle;

@Service("puzzleService")
@Transactional
public class PuzzleService {
	@Autowired
	private PuzzleDao dao;
	
	public Puzzle findById(int id) {
		return dao.findById(id);
	}

	public void savePuzzle(Puzzle puzzle) {
		dao.savePuzzle(puzzle);
	}

	public void updatePuzzle(Puzzle puzzle) {
		Puzzle entity = dao.findById(puzzle.getId());
		if(entity!=null){
			entity.setName(puzzle.getName());
			entity.setEnemyHero(puzzle.getEnemyHero());
			entity.setDateCreate(puzzle.getDateCreate());
			entity.setPlayerHero(puzzle.getPlayerHero());
			dao.update(entity);
		}
	}

	public void deletePuzzleById(int id) {
		dao.deletePuzzleById(id);
	}

	public List<Puzzle> findAllPuzzles() {
		return dao.findAllPuzzles();
	}
}
