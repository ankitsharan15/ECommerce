package com.coviam.blabla.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coviam.blabla.dao.MerchantRepository;
import com.coviam.blabla.dao.ScoreRepository;
import com.coviam.blabla.dto.ScoreUpdaterfromOrder;
import com.coviam.blabla.dto.ScoreUpdaterfromProduct;
import com.coviam.blabla.entity.Merchant;
import com.coviam.blabla.entity.Score;
import com.coviam.blabla.entity.ScoreId;

@Service
public class ScoreCalculator implements iScoreCalculator{
	double weights[]={0.1,0.3,0.2,1.0,0.009,2.0};
	
		@Autowired
		private ScoreRepository scoreRepository;
		@Autowired
		private MerchantRepository merchantRepository;
		
		List<ScoreUpdaterfromOrder> scoreUpdaterListfromOrder;
		List<ScoreUpdaterfromProduct> scoreUpdaterListfromProduct;

		private double calcScore;
		
		public double generateScore(){
			for(ScoreUpdaterfromOrder scoreUpdater : scoreUpdaterListfromOrder){
				long merchantId=scoreUpdater.getMerchantId();
				int numOfProdSold=scoreUpdater.getNumOfProd();
				long productId=scoreUpdater.getProductId();
				double prodRating=scoreUpdater.getRating();
				ScoreId scoreId = new ScoreId();
				scoreId.setMerchantId(merchantId);
				scoreId.setProductId(productId);
				Score score= scoreRepository.findOne(scoreId);
				score.setNumOfProd(numOfProdSold+score.getNumProdSold());
				double currRating=score.getCustomerRating();
				int counterCurrRating=score.getCounterCustomerRating();
				prodRating=((currRating*counterCurrRating)+prodRating)/(counterCurrRating+1);
				score.setCustomerRating(prodRating);	
				ScoreCalculator scoreCalculator=new ScoreCalculator();
				scoreCalculator.updatesFromScore(scoreId,score);
				int numProd=score.getNumOfProd();
				int numProdSold=score.getNumProdSold();
				int stock=score.getCurrentStock();
				Merchant merchant=merchantRepository.findOne(merchantId);
				double merchantRating=merchant.getMerchantRating();
				double priceRating=score.getPriceRating();
				calcScore = (weights[0]*numProd)+(weights[1]*numProdSold)+(weights[2]*stock)+(weights[3]*merchantRating)+(weights[4]*priceRating)+(weights[5]*prodRating);
			}
				return calcScore;
			}
		
		public void updatesFromScore(ScoreId scoreId, Score score){
			//send ScoreID to product and fetch the list from there
				for(ScoreUpdaterfromProduct scoreUpdater: scoreUpdaterListfromProduct){
					int currentStock=scoreUpdater.getCurrentStock();
					int numOfProdOfMerchant=scoreUpdater.getNumOfProdOfMerchant();
					score.setCurrentStock(currentStock);
					score.setNumOfProd(numOfProdOfMerchant);
					scoreRepository.save(score);
				}
		}		
}