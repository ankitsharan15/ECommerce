package com.coviam.blabla.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "specification")
public class Specification implements Serializable{

	@Id
	@Column(name = "spec_id")
	int specId;
	
	@Column(name = "spec_name")
	String specName;

	public int getSpecId() {
		return specId;
	}

	public void setSpecId(int specId) {
		this.specId = specId;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	@Override
	public String toString() {
		return "Specification [specId=" + specId + ", specName=" + specName + "]";
	}
	
	
	
}
