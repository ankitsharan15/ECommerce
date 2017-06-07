package com.coviam.blabla.product.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.coviam.blabla.product.entity.ProductSpecification;
import com.coviam.blabla.product.entity.ProductSpecificationId;

public interface ProductSpecificationRepository extends CrudRepository<ProductSpecification	, ProductSpecificationId>{

	public List<ProductSpecification> findByProdSpecIdProductCode(int productCode);
}
