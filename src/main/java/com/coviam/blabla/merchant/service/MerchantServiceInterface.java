package com.coviam.blabla.service;

import java.util.List;
import com.coviam.blabla.dto.RatingList;
import com.coviam.blabla.entity.Merchant;
import com.coviam.blabla.entity.Score;
import com.coviam.blabla.entity.ScoreId;

public interface MerchantServiceInterface {
	void updateMerchantRating(RatingList ratinglist);
	Iterable<Merchant> getMerchantDetails(List<Long> merchantId);
	Iterable<Score> getScores(List<ScoreId> scoreId);
	}