package com.coviam.blabla.product.service;

import java.util.List;

import com.coviam.blabla.merchant.dto.IdandRating;
import com.coviam.blabla.merchant.dto.IdandScore;
import com.coviam.blabla.merchant.entity.ScoreId;
import com.coviam.blabla.product.dto.ProductSearch;
import com.coviam.blabla.product.entity.Product;
import com.coviam.blabla.product.entity.ProductMerchant;
import com.coviam.blabla.product.entity.ProductSpecification;
import com.coviam.blabla.product.entity.Specification;

public interface ProductServiceInterface {

	public List<Product> getAllProducts();
	public List<Product> findProduct(String query);
	public List<Product> getProduct(int productCode);
	public List<ProductMerchant> getProductsDetails(int productCode, int merchantId);
	public List<ProductMerchant> getMerchantDetails(int productCode);
	public List<ProductSpecification> getProductSpecificationsByProduct(int productCode);
	public List<Specification> getSpecsById(List<Integer> id);
	public List<Product> getProductCodes(String category);
	public void saveProductMerchant(ProductMerchant productMerchant);
	public ProductMerchant getProductDetails(int productCode, int merchantId);
	public Product getAProduct(int productCode);
	public IdandRating getMerchant(int merchantId);
	public List<ProductSearch> getProductListByName(String productName);
	public void updateBestScores(ScoreId scoreId);
}