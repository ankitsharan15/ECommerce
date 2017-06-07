package com.coviam.blabla.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_specs")
public class ProductSpecification implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@EmbeddedId
	private ProductSpecificationId prodSpecId;
	
	@Column(name = "spec_value")
	String specValue;

	public ProductSpecificationId getProdSpecId() {
		return prodSpecId;
	}

	public void setProdSpecId(ProductSpecificationId prodSpecId) {
		this.prodSpecId = prodSpecId;
	}

	public String getSpecValue() {
		return specValue;
	}

	public void setSpecValue(String specValue) {
		this.specValue = specValue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ProductSpecification [prodSpecId=" + prodSpecId + ", specValue=" + specValue + "]";
	}
	
	
	
}
