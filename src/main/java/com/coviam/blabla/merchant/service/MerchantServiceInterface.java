package com.coviam.blabla.merchant.service;

import java.util.List;
import com.coviam.blabla.merchant.dto.RatingList;
import com.coviam.blabla.merchant.entity.Merchant;
import com.coviam.blabla.merchant.entity.Score;
import com.coviam.blabla.merchant.entity.ScoreId;


public interface MerchantServiceInterface {
	void updateMerchantRating(RatingList ratinglist);
	Iterable<Merchant> getMerchantDetails(List<Long> merchantId);
	List<Double> getScores(List<ScoreId> scoreId);
	}