package com.coviam.blabla.merchant.service;

import com.coviam.blabla.merchant.entity.Score;
import com.coviam.blabla.merchant.entity.ScoreId;

public interface iScoreCalculator {
	public double generateScore();
	public void updatesFromScore(ScoreId scoreId, Score score);
}
