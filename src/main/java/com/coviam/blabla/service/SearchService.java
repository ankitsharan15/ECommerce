package com.coviam.blabla.service;

import java.util.List;
import com.coviam.blabla.search.dto.ProductSearch;


public interface SearchService {

	public List<ProductSearch> getProductByName(String productName);
}
