package com.coviam.blabla.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coviam.blabla.dto.RatingList;
import com.coviam.blabla.entity.Merchant;
import com.coviam.blabla.service.MerchantServiceInterface;

@RestController
public class MerchantController {
	
	@Autowired
	MerchantServiceInterface msi;

	@RequestMapping("/")
	public String index(){
        return "Greetings from BlaBla";
	}
	
    	@RequestMapping("/merchant")
    	public List<Merchant> Merchantindex(){
            return (List<Merchant>) msi.getMerchantDetails(null);
	}
    	
    	@RequestMapping("/update")
    	public void updateRating(RatingList rl)
    	{
    			msi.updateMerchantRating(rl);
    	}

}
