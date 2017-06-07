package com.coviam.blabla.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.coviam.blabla.entity.Product;


public interface ProductRepository extends CrudRepository<Product, String>{

	public List<Product> findByProductCategory(String category);
	public Product findByProductCode(int productCode);
}