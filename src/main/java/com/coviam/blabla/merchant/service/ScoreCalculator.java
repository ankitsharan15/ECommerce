package com.coviam.blabla.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.coviam.blabla.dao.MerchantRepository;
import com.coviam.blabla.dao.ScoreRepository;
import com.coviam.blabla.dto.IdandScore;
import com.coviam.blabla.dto.ScoreUpdaterfromOrder;
import com.coviam.blabla.dto.ScoreUpdaterfromProduct;
import com.coviam.blabla.entity.Merchant;
import com.coviam.blabla.entity.Score;
import com.coviam.blabla.entity.ScoreId;

@Service
public class ScoreCalculator implements iScoreCalculator{
	double weights[]={1,3,2,1,9,2};
	
		@Autowired
		private ScoreRepository scoreRepository;
		@Autowired
		private MerchantRepository merchantRepository;
		@Autowired
		RestTemplate restTemplate;
		
		@Value("${productUri}")
		private String productUri;
		
		@Transactional
		@Override
		public void setUpdatesFromOrder(List<ScoreUpdaterfromOrder> scoreUpdaterListfromOrder){
			for(ScoreUpdaterfromOrder scoreUpdaterOrder : scoreUpdaterListfromOrder){
				int merchantId=scoreUpdaterOrder.getMerchantId();
				int numOfProdSold = scoreUpdaterOrder.getNumOfProd();
				int productId=scoreUpdaterOrder.getProductId();
				double prodRating=scoreUpdaterOrder.getRating();
				ScoreId scoreId = new ScoreId(merchantId,productId);
				Score score = scoreRepository.findOne(scoreId);
				double currRating=score.getCustomerRating();
				int counterCurrRating=score.getCounterCustomerRating();
				prodRating=((currRating*counterCurrRating)+prodRating)/(counterCurrRating+1);
				score.setCustomerRating(prodRating);	
				final String uri=productUri+"/getUpdatesfromProduct";
				ScoreUpdaterfromProduct scoreUpdaterProduct = restTemplate.postForObject(uri, scoreId, ScoreUpdaterfromProduct.class);
						int currentStock=scoreUpdaterProduct.getCurrentStock();
						int numOfProdOfMerchant=scoreUpdaterProduct.getNumOfProdOfMerchant();
						int difference = score.getCurrentStock() - currentStock;
						score.setCurrentStock(currentStock);
						int updatedProdSold=difference+(score.getNumProdSold());
						score.setNumProdSold(updatedProdSold);
						score.setNumOfProd(numOfProdOfMerchant);
						scoreRepository.save(score);
				}
			List<IdandScore> calcIdScoreList=new ArrayList<IdandScore>();
			for(ScoreUpdaterfromOrder scoreUpdater : scoreUpdaterListfromOrder){
				int merchantId=scoreUpdater.getMerchantId();
				int productId=scoreUpdater.getProductId();
				ScoreId scoreId = new ScoreId(merchantId,productId);
				Score score= scoreRepository.findOne(scoreId);
				int numProd=score.getNumOfProd();
				int numProdSold=score.getNumProdSold();
				int stock=score.getCurrentStock();
				Merchant merchant=merchantRepository.findOne(merchantId);
				double merchantRating=merchant.getMerchantRating();
				double priceRating=score.getPriceRating();
				double calcScore;
				double prodRating=score.getCustomerRating();
				calcScore = ((weights[0]*numProd)/10)+((weights[1]*numProdSold)/10)+((weights[2]*stock)/100)+(weights[3]*merchantRating)+((weights[4]*priceRating)/100)+(weights[5]*prodRating);
				IdandScore idandscore=new IdandScore();
				idandscore.setScoreid(scoreId);
				idandscore.setScore(calcScore);		
				calcIdScoreList.add(idandscore);
				score.setCalcScore(calcScore);
				scoreRepository.save(score);
				}
			final String uri=productUri+"/setscoretoproduct";
			Boolean bool= restTemplate.postForObject(uri, calcIdScoreList, Boolean.class);
			System.out.println(bool);
		}
		@Override
		public Iterable<Score> getScoreDetails() {
			return scoreRepository.findAll();
		}
		
		
//		public List<ScoreUpdaterfromOrder> testCase(){
//		System.out.println("Reached 0");
//		ScoreUpdaterfromOrder obj=new ScoreUpdaterfromOrder();
//		List<ScoreUpdaterfromOrder> scoreUpdaterListfromOrder=new ArrayList<ScoreUpdaterfromOrder>();
//		obj.setProductId(1);
//		obj.setMerchantId(1);
//		obj.setNumOfProd(23);
//		obj.setRating(3.4);
//		scoreUpdaterListfromOrder.add(obj);
//		System.out.println("Reached 1");
//		for(ScoreUpdaterfromOrder scoreUpdater : scoreUpdaterListfromOrder){
//			int merchantId=scoreUpdater.getMerchantId();
//			int numOfProdSold=scoreUpdater.getNumOfProd();
//			int productId=scoreUpdater.getProductId();
//			double prodRating=scoreUpdater.getRating();
//			ScoreId scoreId = new ScoreId(merchantId,productId);
//			scoreId.setMerchantId(merchantId);
//			scoreId.setProductId(productId);
//			Score score = scoreRepository.findOne(scoreId);
//			score.setNumOfProd(numOfProdSold+score.getNumProdSold());
//			double currRating=score.getCustomerRating();
//			int counterCurrRating=score.getCounterCustomerRating();
//			prodRating=((currRating*counterCurrRating)+prodRating)/(counterCurrRating+1);
//			score.setCustomerRating(prodRating);	
//			final String uri="http://172.16.20.36:8080/getUpdatesfromProduct";
//			ScoreUpdaterfromProduct scoreUpdaterProduct = restTemplate.postForObject(uri, scoreId, ScoreUpdaterfromProduct.class);
//					int currentStock=scoreUpdaterProduct.getCurrentStock();
//					int numOfProdOfMerchant=scoreUpdaterProduct.getNumOfProdOfMerchant();
//					score.setCurrentStock(currentStock);
//					score.setNumOfProd(numOfProdOfMerchant);
//			scoreRepository.save(score);
//			}
//		List<IdandScore> calcIdScoreList=new ArrayList<IdandScore>();
//		for(ScoreUpdaterfromOrder scoreUpdater : scoreUpdaterListfromOrder){
//			int merchantId=scoreUpdater.getMerchantId();
//			int productId=scoreUpdater.getProductId();
//			ScoreId scoreId = new ScoreId(merchantId,productId);
//			Score score= scoreRepository.findOne(scoreId);
//			int numProd=score.getNumOfProd();
//			int numProdSold=score.getNumProdSold();
//			int stock=score.getCurrentStock();
//			Merchant merchant=merchantRepository.findOne(merchantId);
//			double merchantRating=merchant.getMerchantRating();
//			double priceRating=score.getPriceRating();
//			double calcScore;
//			double prodRating=score.getCustomerRating();
//			calcScore = ((weights[0]*numProd)/10)+((weights[1]*numProdSold)/10)+((weights[2]*stock)/100)+(weights[3]*merchantRating)+((weights[4]*priceRating)/100)+(weights[5]*prodRating);
//			IdandScore idandscore=new IdandScore();
//			idandscore.setScoreid(scoreId);
//			idandscore.setScore(calcScore);		
//			calcIdScoreList.add(idandscore);
//			score.setCalcScore(calcScore);
//			scoreRepository.save(score);
//			}
//		final String uri="http://172.16.20.36:8080/setscoretoproduct";
//		Boolean bool= restTemplate.postForObject(uri, calcIdScoreList, Boolean.class);
//		System.out.println(bool);
//		return scoreUpdaterListfromOrder;
//		}
		
}