package com.coviam.blabla.product.dto;

import java.util.List;

import com.coviam.blabla.product.entity.Product;
import com.coviam.blabla.product.entity.ProductSpecification;
import com.coviam.blabla.product.entity.Specification;

public class ProductDetails {

	private Product product;
	private List<CustomMerchant> customMerchant;
	private List<Specification> specList;
	private List<ProductSpecification> specification;

	public ProductDetails(Product product, List<ProductSpecification> specification,
			List<CustomMerchant> customMerchant, List<Specification> specList) {
		super();
		this.product = product;
		this.specification = specification;
		this.customMerchant = customMerchant;
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

	public List<CustomMerchant> getCustomMerchant() {
		return customMerchant;
	}

	public void setCustomMerchant(List<CustomMerchant> customMerchant) {
		this.customMerchant = customMerchant;
	}

	public List<Specification> getSpecList() {
		return specList;
	}

	public void setSpecList(List<Specification> specList) {
		this.specList = specList;
	}

	@Override
	public String toString() {
		return "ProductDetails [product=" + product + ", customMerchant=" + customMerchant + ", specList=" + specList
				+ ", specification=" + specification + "]";
	}

}
