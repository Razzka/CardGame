package com.razzka.mvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.razzka.mvc.model.Puzzle;

@Repository("puzzleDao")
public class PuzzleDao extends AbstractDao<Integer, Puzzle> {
	public Puzzle findById(int id) {
		return getByKey(id);
	}

	public void persistPuzzle(Puzzle puzzle) {
		persist(puzzle);
	}
	
	public void savePuzzle(Puzzle puzzle) {
		save(puzzle);
	}
	
	public void updatePuzzle(Puzzle puzzle) {
		update(puzzle);
	}

	public void deletePuzzleById(int id) {
		Query query = getSession().createSQLQuery("delete from Puzzle where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Puzzle> findAllPuzzles() {
		Criteria criteria = createEntityCriteria();
		return (List<Puzzle>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Puzzle> findForLoad() {
		Criteria criteria = createEntityCriteria();
		criteria.setMaxResults(1000);
		return (List<Puzzle>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Puzzle> findMissed() {
		Criteria criteria = createEntityCriteria();
		return (List<Puzzle>) criteria.list();
	}
}
