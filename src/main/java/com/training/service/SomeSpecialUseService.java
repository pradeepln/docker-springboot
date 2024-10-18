package com.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.training.dal.ProductDAO;
import com.training.dal.ProductDAOInMemImpl;

@Service
public class SomeSpecialUseService {

	ProductDAO dao;
	
	@Qualifier("secondaryDAO")
	@Autowired
	public void setDao(ProductDAO dao) {
		System.out.println("What's getting injected into SomeSpecialUseService? --> "+dao.getClass().getName());
		this.dao = dao;
	}
	
}
