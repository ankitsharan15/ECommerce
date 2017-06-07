package com.coviam.blabla.dto;

import java.util.List;

public class ScoreUpdaterList {

	List<ScoreUpdaterfromOrder> scoreUpdaterListfromOrder;

	public ScoreUpdaterList(List<ScoreUpdaterfromOrder> scoreUpdaterListfromOrder) {
		super();
		this.scoreUpdaterListfromOrder = scoreUpdaterListfromOrder;
	}

	public List<ScoreUpdaterfromOrder> getScoreUpdaterList() {
		return scoreUpdaterListfromOrder;
	}

	public void setScoreUpdaterList(List<ScoreUpdaterfromOrder> scoreUpdaterList) {
		this.scoreUpdaterListfromOrder = scoreUpdaterList;
	}
	
	
}
