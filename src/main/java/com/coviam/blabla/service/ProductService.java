package com.coviam.blabla.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coviam.blabla.dao.ProductMerchantRepository;
import com.coviam.blabla.dao.ProductRepository;
import com.coviam.blabla.dao.ProductSpecificationRepository;
import com.coviam.blabla.dao.SpecificationRepository;
import com.coviam.blabla.entity.Product;
import com.coviam.blabla.entity.ProductMerchant;
import com.coviam.blabla.entity.ProductMerchantId;
import com.coviam.blabla.entity.ProductSpecification;
import com.coviam.blabla.entity.Specification;

@Service
public class ProductService implements ProductServiceInterface{

	@Autowired
	ProductRepository pr;
	
	@Autowired
	ProductMerchantRepository pmr;
	
	@Autowired
	ProductSpecificationRepository psr;
	
	@Autowired
	SpecificationRepository sr;
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return (List<Product>) pr.findAll();
	}

	@Override
	public List<Product> findProduct(String query) {
		// TODO Auto-generated method stub
		return pr.findByProductCategory(query);
	}

	@Override
	public Product getProduct(int productCode) {
		// TODO Auto-generated method stub
		return pr.findByProductCode(productCode);
	}
	
	@Override
	public List<ProductMerchant> getProductDetails(int productCode, int merchantId) {
		// TODO Auto-generated method stub
		ProductMerchantId pmid = new ProductMerchantId(productCode, merchantId);
		List<ProductMerchant> productmerchantlist = pmr.findByProductmerchantid(pmid);
		return productmerchantlist;
	}

	@Override
	public List<ProductMerchant> getMerchantDetails(int productCode) {
		// TODO Auto-generated method stub
		List<ProductMerchant> productmerchantlist = pmr.findByProductmerchantidProductCode(productCode);
		return productmerchantlist;
	}

	@Override
	public List<ProductSpecification> getProductSpecificationsByProduct(int productCode) {
		// TODO Auto-generated method stub
		List<ProductSpecification> productSpecifications = psr.findByProdSpecIdProductCode(productCode);
		return productSpecifications;
	}

	@Override
	public List<Specification> getSpecsById(List<Integer> id) {
		// TODO Auto-generated method stub
		return (List<Specification>) sr.findAll(id);
	}

}
