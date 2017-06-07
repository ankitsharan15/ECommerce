package com.coviam.blabla.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.coviam.blabla.entity.ProductSpecification;
import com.coviam.blabla.entity.ProductSpecificationId;

public interface ProductSpecificationRepository extends CrudRepository<ProductSpecification	, ProductSpecificationId>{

	public List<ProductSpecification> findByProdSpecIdProductCode(int productCode);
}
