package com.coviam.blabla.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.coviam.blabla.entity.ProductMerchant;
import com.coviam.blabla.entity.ProductMerchantId;

public interface ProductMerchantRepository extends CrudRepository<ProductMerchant, ProductMerchantId> {

	public List<ProductMerchant> findByProductmerchantid(ProductMerchantId pmid);
	
	public List<ProductMerchant> findByProductmerchantidProductCode(int pCode);
}