package com.coviam.blabla.product.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.coviam.blabla.product.entity.Product;


public interface ProductRepository extends CrudRepository<Product, Integer>{

	public List<Product> findByProductCategory(String category);
	public List<Product> findByProductCode(int productCode);
}