package com.razzka.mvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.razzka.mvc.model.Image;

@Repository("imageDao")
public class ImageDao extends AbstractDao<Integer, Image> {
	@SuppressWarnings("unchecked")
	public List<Image> findAllImages() {
		Criteria criteria = createEntityCriteria();
		return (List<Image>) criteria.list();
	}
	
	public Image findById(int id) {
		return getByKey(id);
	}
}
