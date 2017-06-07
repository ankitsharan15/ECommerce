package com.coviam.blabla.dto;

import java.util.List;

public class RatingList {
	
	List<IdandRating> idratinglist;

	public RatingList(List<IdandRating> idandRating) {
		super();
		idratinglist = idandRating;
	}
	
	public List<IdandRating> getIdandRating() {
		return idratinglist;
	}

	public void setIdandRating(List<IdandRating> idandRating) {
		this.idratinglist = idandRating;
	}

	
}
