package com.razzka.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.razzka.mvc.dao.ImageDao;
import com.razzka.mvc.model.Image;

@Service("imageService")
@Transactional
public class ImageService {
	@Autowired
	private ImageDao dao;
	
	public Image findById(int id) {
		return dao.findById(id);
	}
	
	public List<Image> findAllImages() {
		return dao.findAllImages();
	}
}
