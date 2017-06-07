package com.coviam.blabla.dto;

import java.util.List;

import com.coviam.blabla.entity.Product;
import com.coviam.blabla.entity.ProductMerchant;
import com.coviam.blabla.entity.ProductSpecification;
import com.coviam.blabla.entity.Specification;

public class ProductDetails {

	private Product product;
	private List<ProductSpecification> specification;
	private List<ProductMerchant> productMerchant;
	private List<Specification> specList;

	public ProductDetails(Product product, List<ProductSpecification> specification,
			List<ProductMerchant> productMerchant, List<Specification> specList) {
		super();
		this.product = product;
		this.specification = specification;
		this.productMerchant = productMerchant;
		this.specList = specList;
	}

	public ProductDetails() {

	}

	public List<ProductSpecification> getSpecification() {
		return specification;
	}

	public void setSpecification(List<ProductSpecification> specification) {
		this.specification = specification;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<ProductMerchant> getProductMerchant() {
		return productMerchant;
	}

	public void setProductMerchant(List<ProductMerchant> productMerchant) {
		this.productMerchant = productMerchant;
	}

	public List<Specification> getSpecList() {
		return specList;
	}

	public void setSpecList(List<Specification> specList) {
		this.specList = specList;
	}

	@Override
	public String toString() {
		return "ProductDetails [product=" + product + ", specification=" + specification + ", productMerchant="
				+ productMerchant + ", specList=" + specList + "]";
	}

	

}
