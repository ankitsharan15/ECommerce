package com.coviam.blabla.product.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import com.coviam.blabla.merchant.dto.IdandRating;
import com.coviam.blabla.merchant.entity.ScoreId;
import com.coviam.blabla.product.dao.ProductMerchantRepository;
import com.coviam.blabla.product.dao.ProductRepository;
import com.coviam.blabla.product.dao.ProductSpecificationRepository;
import com.coviam.blabla.product.dao.SpecificationRepository;
import com.coviam.blabla.search.dto.ProductSearch;
import com.coviam.blabla.product.entity.Product;
import com.coviam.blabla.product.entity.ProductMerchant;
import com.coviam.blabla.product.entity.ProductMerchantId;
import com.coviam.blabla.product.entity.ProductSpecification;
import com.coviam.blabla.product.entity.Specification;

@Service
public class ProductService implements ProductServiceInterface {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductMerchantRepository productMerchantRepository;

	@Autowired
	ProductSpecificationRepository productSpecificationRepository;

	@Autowired
	SpecificationRepository specificationRepository;

	@Autowired
	RestTemplate restTemplate;

	@Value("${merchantUri}")
    String merchantUri;
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public List<Product> findProduct(String query) {
		// TODO Auto-generated method stub
		return productRepository.findByProductCategory(query);
	}

	@Override
	public List<Product> getProduct(int productCode) {
		// TODO Auto-generated method stub
		return productRepository.findByProductCode(productCode);
	}

	@Override
	public List<ProductMerchant> getProductsDetails(int productCode, int merchantId) {
		// TODO Auto-generated method stub
		ProductMerchantId pmid = new ProductMerchantId(productCode, merchantId);
		List<ProductMerchant> productmerchantlist = productMerchantRepository.findByProductmerchantid(pmid);
		return productmerchantlist;
	}

	@Override
	public List<ProductMerchant> getMerchantDetails(int productCode) {
		// TODO Auto-generated method stub
		List<ProductMerchant> productmerchantlist = productMerchantRepository
				.findByProductmerchantidProductCodeOrderByScoreDesc(productCode);
		return productmerchantlist;
	}

	@Override
	public List<ProductSpecification> getProductSpecificationsByProduct(int productCode) {
		// TODO Auto-generated method stub
		List<ProductSpecification> productSpecifications = productSpecificationRepository
				.findByProdSpecIdProductCode(productCode);
		return productSpecifications;
	}

	@Override
	public List<Specification> getSpecsById(List<Integer> id) {
		// TODO Auto-generated method stub
		return (List<Specification>) specificationRepository.findAll(id);
	}

	@Override
	public List<Product> getProductCodes(String category) {
		// TODO Auto-generated method stub
		return productRepository.findByProductCategory(category);
	}

	@Override
	@Transactional
	public void saveProductMerchant(ProductMerchant pm) {
		System.out.println("" + pm.toString());
		// TODO Auto-generated method stub
		productMerchantRepository.save(pm);
	}

	@Override
	public ProductMerchant getProductDetails(int productCode, int merchantId) {
		// TODO Auto-generated method stub
		ProductMerchantId pmid = new ProductMerchantId(productCode, merchantId);
		return productMerchantRepository.findOne(pmid);
	}

	@Override
	public Product getAProduct(int productCode) {
		// TODO Auto-generated method stub
		return productRepository.findOne(productCode);
	}

	@Override
	public IdandRating getMerchant(int merchantId) {
		// TODO Auto-generated method stub
		final String uri = merchantUri+"getmerchant";
		IdandRating merchant = restTemplate.postForObject(uri, merchantId, IdandRating.class);
		return merchant;
	}

	@Override
	public List<ProductSearch> getProductListByName(String productName) {
		// TODO Auto-generated method stub
		List<Product> productList = productRepository.findByProductNameContainingIgnoreCase(productName);
		List<ProductSearch> productSearchList = new ArrayList<ProductSearch>();
		ProductSearch productSearch;
		for (Product product : productList) {
			productSearch = new ProductSearch(product.getProductCode(), product.getProductName(),
					product.getProductImage(), product.getBestPrice());
			productSearchList.add(productSearch);
		}
		return productSearchList;
	}

	@Override
	@Transactional
	public void updateBestScores(ScoreId scoreId) {
		// TODO Auto-generated method stub
		List<ProductMerchant> productMerchantList = productMerchantRepository
				.findByProductmerchantidProductCodeOrderByScoreDesc(scoreId.getProductId());
		Product product = productRepository.findOne(scoreId.getProductId());
		product.setBestPrice(productMerchantList.get(0).getPrice());
		productRepository.save(product);
	}

}
