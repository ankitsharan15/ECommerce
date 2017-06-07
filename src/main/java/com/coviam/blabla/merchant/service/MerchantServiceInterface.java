package com.coviam.blabla.merchant.service;

import java.util.List;
<<<<<<< HEAD
import com.coviam.blabla.merchant.dto.RatingList;
import com.coviam.blabla.merchant.entity.Merchant;
import com.coviam.blabla.merchant.entity.Score;
import com.coviam.blabla.merchant.entity.ScoreId;

=======
import com.coviam.blabla.dto.RatingList;
import com.coviam.blabla.entity.Merchant;
import com.coviam.blabla.entity.Score;
import com.coviam.blabla.entity.ScoreId;
>>>>>>> parent of 5690f46... Add files via upload

public interface MerchantServiceInterface {
	void updateMerchantRating(RatingList ratinglist);
	Iterable<Merchant> getMerchantDetails(List<Long> merchantId);
	Iterable<Score> getScores(List<ScoreId> scoreId);
	}