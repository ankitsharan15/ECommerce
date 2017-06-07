package com.coviam.blabla.service;

import java.util.List;

import com.coviam.blabla.entity.Product;
import com.coviam.blabla.entity.ProductMerchant;
import com.coviam.blabla.entity.ProductSpecification;
import com.coviam.blabla.entity.Specification;

public interface ProductServiceInterface {

	public List<Product> getAllProducts();
	public List<Product> findProduct(String query);
	public Product getProduct(int productCode);
	public List<ProductMerchant> getProductDetails(int productCode, int merchantId);
	public List<ProductMerchant> getMerchantDetails(int productCode);
	public List<ProductSpecification> getProductSpecificationsByProduct(int productCode);
	public List<Specification> getSpecsById(List<Integer> id);
}