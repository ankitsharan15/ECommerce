package com.coviam.blabla.merchant.service;

import java.util.List;

import com.coviam.blabla.merchant.dto.MerchantNameandRating;
import com.coviam.blabla.merchant.dto.RatingList;
import com.coviam.blabla.merchant.entity.Merchant;
import com.coviam.blabla.merchant.entity.ScoreId;

public interface MerchantServiceInterface {
	Iterable<Merchant> getMerchantDetails();
	List<Double> getScores(List<ScoreId> scoreId);
	MerchantNameandRating getMerchantRating(int merchantId);
	void updateMerchantRating(RatingList ratinglist);
	}