package com.training.dal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.training.domain.Product;

@Repository("secondaryDAO")
public class ProductDAOInMemImpl implements ProductDAO {
	
	Map<Integer,Product> db = new HashMap<>();
	int idSequence = 0;
	
	public ProductDAOInMemImpl() {
		System.out.println("----->>>> ProductDAOInMemImpl constructor");
	}
	
	@Override
	public Product save(Product toBeSaved) {
		int id = ++idSequence;
		toBeSaved.setId(id);
		db.put(id, toBeSaved);
		return toBeSaved;
	}
	
	@Override
	public Product findById(int id) {
		return db.get(id);
	}
	
	@Override
	public List<Product> findAll() {
		return new ArrayList<>(db.values());
	}
	
	@Override
	public void deleteById(int id) {
		db.remove(id);
		
	}
	

	
}
