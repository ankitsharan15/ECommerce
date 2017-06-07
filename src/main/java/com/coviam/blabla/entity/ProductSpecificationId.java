package com.coviam.blabla.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable

public class ProductSpecificationId implements Serializable{

	@Column(name = "product_code")
	int productCode;
	
	@Column(name = "spec_id")
	int spec_id;

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public int getSpec_id() {
		return spec_id;
	}

	public void setSpec_id(int spec_id) {
		this.spec_id = spec_id;
	}

	@Override
	public String toString() {
		return "ProductSpecificationId [productCode=" + productCode + ", spec_id=" + spec_id + "]";
	}

	public ProductSpecificationId(int productCode, int spec_id) {
		super();
		this.productCode = productCode;
		this.spec_id = spec_id;
	}
	
	public ProductSpecificationId(){
		
	}
}
