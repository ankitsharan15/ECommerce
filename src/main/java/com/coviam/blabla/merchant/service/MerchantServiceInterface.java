package com.coviam.blabla.service;

import java.util.List;
import com.coviam.blabla.dto.RatingList;
import com.coviam.blabla.entity.Merchant;
import com.coviam.blabla.entity.ScoreId;

public interface MerchantServiceInterface {
	void updateMerchantRating(RatingList ratinglist);
	Iterable<Merchant> getMerchantDetails(List<Long> merchantId);
	List<Double> getScores(List<ScoreId> scoreId);
	}