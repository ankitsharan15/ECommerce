package com.coviam.blabla.merchant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coviam.blabla.merchant.dao.MerchantRepository;
import com.coviam.blabla.merchant.dao.ScoreRepository;
import com.coviam.blabla.merchant.dto.MerchantNameandRating;
import com.coviam.blabla.merchant.dto.RatingList;
import com.coviam.blabla.merchant.entity.Merchant;
import com.coviam.blabla.merchant.entity.Score;
import com.coviam.blabla.merchant.entity.ScoreId;

@Service
public class MerchantService implements MerchantServiceInterface {

	@Autowired
	private MerchantRepository merchantrepository;
	@Autowired
	private ScoreRepository scorerepository;

	@Override
	public Iterable<Merchant> getMerchantDetails() {
		return merchantrepository.findAll();
	}
	
	@Override
	public MerchantNameandRating getMerchantRating(int merchantId){
		Merchant merchant=merchantrepository.findOne(merchantId);
		MerchantNameandRating idandrating=new MerchantNameandRating(merchant);
		return idandrating;
	}
 
	@Override
	public List<Double> getScores(List<ScoreId> scoreId) {
		Iterable<Score> scores = scorerepository.findAll(scoreId);
		List<Double> scoreList = new ArrayList<Double>();
		for (Score iterator : scores) {
			Double score = iterator.getCalcScore();
			scoreList.add(score);
		}
		return scoreList;
	}

	@Override
	public void updateMerchantRating(RatingList ratinglist) {
		List<MerchantNameandRating> idratinglist = ratinglist.getIdandRating();
		for (MerchantNameandRating idandrating : idratinglist) {
			int merchantId = idandrating.getMerchantId();
			double newRating = idandrating.getMerchantRating();
			Merchant merchant = merchantrepository.findOne(merchantId);
			double currentRating = merchant.getMerchantRating();
			int counter = merchant.getRatingCounter();
			currentRating = ((currentRating * counter) + newRating) / (counter + 1);
			merchant.setRatingCounter(counter + 1);
			merchant.setMerchantRating(currentRating);
			merchantrepository.save(merchant);
		}
	}
}
