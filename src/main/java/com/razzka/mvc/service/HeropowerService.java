package com.razzka.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.razzka.mvc.dao.HeropowerDao;
import com.razzka.mvc.model.Heropower;

@Service("heropowerService")
@Transactional
public class HeropowerService {
	@Autowired
	private HeropowerDao dao;

	public Heropower findById(int id) {
		return dao.findById(id);
	}

	public void saveHeropower(Heropower heropower) {
		dao.saveHeropower(heropower);
	}

	public void updateHeropower(Heropower heropower) {
		Heropower entity = dao.findById(heropower.getId());
		if(entity!=null){
			entity.setText(heropower.getText());
		}		
	}

	public void deleteHeropowerById(int id) {
		dao.deleteHeropowerById(id);
	}

	public List<Heropower> findAllHeropowers() {
		return dao.findAllHeropowers();
	}
}
