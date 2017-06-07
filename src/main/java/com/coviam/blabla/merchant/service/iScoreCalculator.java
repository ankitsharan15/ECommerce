package com.coviam.blabla.service;

import java.util.List;

import com.coviam.blabla.dto.ScoreUpdaterfromOrder;
import com.coviam.blabla.dto.ScoreUpdaterfromProduct;
public interface iScoreCalculator {
	public Iterable<Double> generateScore(List<ScoreUpdaterfromOrder> scoreUpdaterListfromOrder,List<ScoreUpdaterfromProduct> scoreUpdaterListfromProduct);
}
