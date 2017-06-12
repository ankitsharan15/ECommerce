package com.coviam.blabla.merchant.service;

import java.util.List;

import com.coviam.blabla.merchant.dto.ScoreUpdaterfromOrder;
import com.coviam.blabla.merchant.entity.Score;
public interface iScoreCalculator {
	public Iterable<Score> getScoreDetails();
	public void setUpdatesFromOrder(List<ScoreUpdaterfromOrder> scoreUpdaterListfromOrder);
	//List<IdandScore> generateScore(List<ScoreUpdaterfromOrder> scoreUpdaterListfromOrder);
	//public List<ScoreUpdaterfromOrder> testCase();
	//void setUpdatesFromProduct(ScoreId scoreId, Score score);
}
