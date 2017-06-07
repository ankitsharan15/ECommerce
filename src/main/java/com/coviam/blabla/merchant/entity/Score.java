package com.coviam.blabla.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="score")
public class Score implements Serializable{
	@EmbeddedId ScoreId scoreId;
	@Column(name="numOfProd")
	int numOfProd;
	@Column(name="numProdSold")
	int numProdSold;
	@Column(name="currentStock")
	int currentStock;
	@Column(name="merchantRating")
	double merchantRating;
	@Column(name="counterMerchantRating")
	int counterMerchantRating;
	@Column(name="priceRating")
	double priceRating;
	@Column(name="customerRating")
	double customerRating;
	@Column(name="counterCustomerRating")
	int counterCustomerRating;
	@Column(name="calc_score")
	double calcScore;
	public ScoreId getScoreId() {
		return scoreId;
	}
	public void setScoreId(ScoreId scoreId) {
		this.scoreId = scoreId;
	}
	public int getNumOfProd() {
		return numOfProd;
	}
	public void setNumOfProd(int numOfProd) {
		this.numOfProd = numOfProd;
	}
	public int getNumProdSold() {
		return numProdSold;
	}
	public void setNumProdSold(int numProdSold) {
		this.numProdSold = numProdSold;
	}
	public int getCurrentStock() {
		return currentStock;
	}
	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}
	public double getMerchantRating() {
		return merchantRating;
	}
	public void setMerchantRating(double merchantRating) {
		this.merchantRating = merchantRating;
	}
	public int getCounterMerchantRating() {
		return counterMerchantRating;
	}
	public void setCounterMerchantRating(int counterMerchantRating) {
		this.counterMerchantRating = counterMerchantRating;
	}
	public double getPriceRating() {
		return priceRating;
	}
	public void setPriceRating(double priceRating) {
		this.priceRating = priceRating;
	}
	public double getCustomerRating() {
		return customerRating;
	}
	public void setCustomerRating(double customerRating) {
		this.customerRating = customerRating;
	}
	public int getCounterCustomerRating() {
		return counterCustomerRating;
	}
	public void setCounterCustomerRating(int counterCustomerRating) {
		this.counterCustomerRating = counterCustomerRating;
	}
	public double getCalcScore() {
		return calcScore;
	}
	public void setCalcScore(double calcScore) {
		this.calcScore = calcScore;
	}
	@Override
	public String toString() {
		return "Score [scoreId=" + scoreId + ", numOfProd=" + numOfProd + ", numProdSold=" + numProdSold
				+ ", currentStock=" + currentStock + ", merchantRating=" + merchantRating + ", counterMerchantRating="
				+ counterMerchantRating + ", priceRating=" + priceRating + ", customerRating=" + customerRating
				+ ", counterCustomerRating=" + counterCustomerRating + ", calcScore=" + calcScore + "]";
	}
	
	
}
