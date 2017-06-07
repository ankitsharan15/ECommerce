package com.coviam.blabla.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.coviam.blabla.dto.ProductAndMerchant;
import com.coviam.blabla.dto.ProductDetails;
import com.coviam.blabla.entity.Product;
import com.coviam.blabla.entity.ProductMerchant;
import com.coviam.blabla.entity.ProductSpecification;
import com.coviam.blabla.entity.Specification;
import com.coviam.blabla.service.ProductServiceInterface;

@Controller
public class ProductController {

	@Autowired
	ProductServiceInterface ps;

//	@RequestMapping(value = "/")
//	public ModelAndView returnAllProducts() {
//		List<Product> p = ps.getAllProducts();
//		return new ModelAndView("index.html","p",p);	
//		}
///
	@RequestMapping("/")
	public String testMethod(){
		return "index.html";
	}
	
	@RequestMapping("/category/{query}")
	public @ResponseBody List<Product> getProductByCategory(@PathVariable("query") String query) {
		List<Product> productList = ps.findProduct(query);
		return productList;

	}

	@RequestMapping("/product/{pCode}/{mId}")
	public ProductDetails getOrderedProducts(@PathVariable("pCode") int pCode, @PathVariable("mId") int mId) {

		List<ProductMerchant> productMerchantList = ps.getProductDetails(pCode, mId);
		Product productList = ps.getProduct(pCode);
		List<ProductSpecification> prodSpec = ps.getProductSpecificationsByProduct(pCode);
		List<Integer> id = new ArrayList<Integer>();
		for(ProductSpecification productSpec : prodSpec){
			id.add(productSpec.getProdSpecId().getSpec_id());
		}
		List<Specification> specList = ps.getSpecsById(id);
		ProductDetails productDetails = new ProductDetails(productList, prodSpec, productMerchantList,specList);
		return productDetails;

	}

	@RequestMapping("/product/{pCode}")
	public ProductDetails getProductList(@PathVariable("pCode") int pCode) {

		List<ProductMerchant> productMerchantList = ps.getMerchantDetails(pCode);
		Product productList = ps.getProduct(pCode);
		List<ProductSpecification> prodSpec = ps.getProductSpecificationsByProduct(pCode);
		List<Integer> id  = new ArrayList<Integer>();
		for(ProductSpecification productSpec : prodSpec){
			id.add(productSpec.getProdSpecId().getSpec_id());
		}		List<Specification> specList = ps.getSpecsById(id);
		ProductDetails productDetails = new ProductDetails(productList, prodSpec, productMerchantList,specList);
		return productDetails;

	}

}