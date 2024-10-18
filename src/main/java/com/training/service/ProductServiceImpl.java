package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.dal.ProductDAO;
import com.training.dal.ProductDAOInMemImpl;
import com.training.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	static final int MIN_VALUE = 10_000;
	private ProductDAO dao; // = new ProductDAOInMemImpl();
	
	public ProductServiceImpl() {
		System.out.println("----->>>> ProductServiceImpl constructor");
	}
	
	@Autowired
	public void setDao(ProductDAO dao) {
		System.out.println("----->>>> Injecting dao into service");
		this.dao = dao;
	}
	
	@Override
	public int addProduct(Product toBeAdded) {
		if(toBeAdded.getPrice() * toBeAdded.getQoh() >= MIN_VALUE) {
			Product added = dao.save(toBeAdded);
			return added.getId();
		}else {
			throw new IllegalArgumentException("Product Value (price * qoh) must be GTEQ 10k");
		}
	}
	
	@Override
	public void removeExisting(int id) {
		Product existing = dao.findById(id);
		
		if(existing.getPrice() * existing.getQoh() < 100000) {
			dao.deleteById(id);
		}else {
			throw new IllegalStateException("Product worth more than 100k, can't just be deleted!");
		}
	}

	@Override
	public Product findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Product> findAll() {
		return dao.findAll();
	}

	
	
}
