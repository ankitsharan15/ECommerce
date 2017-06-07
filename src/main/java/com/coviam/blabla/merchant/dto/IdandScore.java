package com.coviam.blabla.merchant.dto;

import com.coviam.blabla.merchant.entity.ScoreId;
import com.coviam.blabla.merchant.entity.Score;
public class IdandScore {
	private ScoreId scoreid;
	private double Score;
public IdandScore(Score score) {
		super();
		this.scoreid = score.getScoreId();
		Score = score.getCalcScore();
	}
	public ScoreId getScoreid() {
		return scoreid;
	}
	public void setScoreid(ScoreId scoreid) {
		this.scoreid = scoreid;
	}
	public double getScore() {
		return Score;
	}
	public void setScore(double score) {
		Score = score;
	}
}