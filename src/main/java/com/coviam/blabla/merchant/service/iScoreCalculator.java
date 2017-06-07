package com.coviam.blabla.service;

import com.coviam.blabla.entity.Score;
import com.coviam.blabla.entity.ScoreId;

public interface iScoreCalculator {
	public double generateScore();
	public void updatesFromScore(ScoreId scoreId, Score score);
}
