package com.coviam.blabla.service;

import java.util.List;

import com.coviam.blabla.dto.MerchantNameandRating;
import com.coviam.blabla.dto.RatingList;
import com.coviam.blabla.entity.Merchant;
import com.coviam.blabla.entity.ScoreId;

public interface MerchantServiceInterface {
	Iterable<Merchant> getMerchantDetails();
	List<Double> getScores(List<ScoreId> scoreId);
	MerchantNameandRating getMerchantRating(int merchantId);
	void updateMerchantRating(RatingList ratinglist);
	}