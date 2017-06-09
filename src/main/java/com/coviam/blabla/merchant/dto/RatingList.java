package com.coviam.blabla.merchant.dto;

import java.util.List;

public class RatingList {
	
	List<MerchantNameandRating> idratinglist;

	public RatingList() {
	}

//	public RatingList(List<MerchantNameandRating> idandRating) {
//		super();
//		idratinglist = idandRating;
//	}
	
	public List<MerchantNameandRating> getIdandRating() {
		return idratinglist;
	}

	public void setIdandRating(List<MerchantNameandRating> idandRating) {
		this.idratinglist = idandRating;
	}

	
}
