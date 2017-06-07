package com.coviam.blabla.product.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.coviam.blabla.product.entity.ProductMerchant;
import com.coviam.blabla.product.entity.ProductMerchantId;

public interface ProductMerchantRepository extends CrudRepository<ProductMerchant, ProductMerchantId> {

	public List<ProductMerchant> findByProductmerchantid(ProductMerchantId pmid);
	
	public List<ProductMerchant> findByProductmerchantidProductCode(int pCode);
}