package com.coviam.blabla.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.coviam.blabla.search.dto.ProductSearch;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${productUri}")
    String productUri;
	
	@Override
	public List<ProductSearch> getProductByName(String productName) {
		
		final String uri = productUri+"getProductByName/{productName}";
		ProductSearch[] result = restTemplate.getForObject(uri, ProductSearch[].class, productName);
		List<ProductSearch> resultList = Arrays.asList(result);
		return resultList;
		
	}

}
