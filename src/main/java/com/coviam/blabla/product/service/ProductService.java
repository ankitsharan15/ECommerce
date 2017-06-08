package com.coviam.blabla.product.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.coviam.blabla.merchant.dto.IdandRating;
import com.coviam.blabla.product.dao.ProductMerchantRepository;
import com.coviam.blabla.product.dao.ProductRepository;
import com.coviam.blabla.product.dao.ProductSpecificationRepository;
import com.coviam.blabla.product.dao.SpecificationRepository;
import com.coviam.blabla.product.entity.Product;
import com.coviam.blabla.product.entity.ProductMerchant;
import com.coviam.blabla.product.entity.ProductMerchantId;
import com.coviam.blabla.product.entity.ProductSpecification;
import com.coviam.blabla.product.entity.Specification;

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
	
	@Autowired
	RestTemplate restTemplate;
	
	
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
	public List<Product> getProduct(int productCode) {
		// TODO Auto-generated method stub
		return pr.findByProductCode(productCode);
	}
	
	@Override
	public List<ProductMerchant> getProductsDetails(int productCode, int merchantId) {
		// TODO Auto-generated method stub
		ProductMerchantId pmid = new ProductMerchantId(productCode, merchantId);
		List<ProductMerchant> productmerchantlist = pmr.findByProductmerchantid(pmid);
		return productmerchantlist;
	}

	@Override
	public List<ProductMerchant> getMerchantDetails(int productCode) {
		// TODO Auto-generated method stub
		List<ProductMerchant> productmerchantlist = pmr.findByProductmerchantidProductCodeOrderByScoreDesc(productCode);
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

	@Override
	public List<Product> getProductCodes(String category) {
		// TODO Auto-generated method stub
		return pr.findByProductCategory(category);
	}

	@Override
	public void saveProduct() {
		// TODO Auto-generated method stub
		Product p = new Product(4, "Levis Jeans", "Levis Slim fit Jeans", "fashion", "SLim Fit 98% Cotton Jeans", "Levis", "http://ecx.images-amazon.com/images/I/91EOx1YAVJL._UL1500_.jpg", 1200);
		pr.save(p);
		p = new Product(5, "TMH Maths", "Designed And Developed By IIT Professors", "book", "Recommended for JEE Aspirants", "TMH", "http://ecx.images-amazon.com/images/I/61xYqbt6vlL.jpg", 500);
		pr.save(p);
		p = new Product(6, "Nike Air", "Blue, 8.5 Running Shoes", "shoes", "Running Shoes", "Nike", "http://ecx.images-amazon.com/images/I/51biuafgJBL.jpg", 4000);
		pr.save(p);
		p = new Product(7, "Iphone 7", "64GB,Red", "phone", "Latest release by Apple", "Apple", "http://ecx.images-amazon.com/images/I/814lO6nm9vL._SL1500_.jpg", 70000);
		pr.save(p);
		p = new Product(8, "OnePlus 3T", "64GB, 4GB RAM", "phone", "Best Budget phone rated by India Times", "OnePlus", "http://ecx.images-amazon.com/images/I/81%2B4WXlorFL._SL1500_.jpg", 32000);
		pr.save(p);
		p = new Product(3,"HP Tablet 7","64GB, 7-inch","tablet","Powerful performance,Sleek Design","HP","http://ecx.images-amazon.com/images/I/419C%2B6y8xqL.jpg",15000);
		pr.save(p);
	}

	@Override
	public void saveProductMerchant(ProductMerchant pm) {
		// TODO Auto-generated method stub
		pmr.save(pm);
	}

	@Override
	public ProductMerchant getProductDetails(int productCode, int merchantId) {
		// TODO Auto-generated method stub
		ProductMerchantId pmid = new ProductMerchantId(productCode, merchantId);
		return pmr.findOne(pmid);
	}

	@Override
	public Product getAProduct(int productCode) {
		// TODO Auto-generated method stub
		return pr.findOne(productCode);
		}

	@Override
	public IdandRating getMerchant(int merchantId) {
		// TODO Auto-generated method stub
		final String uri = "http://172.16.20.34:8080/getmerchant";
		IdandRating merchant = restTemplate.postForObject(uri, merchantId, IdandRating.class);
		return merchant;
	}

	

}
