package com.coviam.blabla.merchant.service;

import java.util.List;

import com.coviam.blabla.merchant.dto.ScoreUpdaterfromOrder;
import com.coviam.blabla.merchant.dto.ScoreUpdaterfromProduct;
public interface iScoreCalculator {
	public Iterable<Double> generateScore(List<ScoreUpdaterfromOrder> scoreUpdaterListfromOrder,List<ScoreUpdaterfromProduct> scoreUpdaterListfromProduct);
}
