package com.coviam.blabla.product.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.coviam.blabla.product.dto.ProductDetails;
import com.coviam.blabla.product.dto.ProductListing;
import com.coviam.blabla.product.entity.Product;
import com.coviam.blabla.product.entity.ProductMerchant;
import com.coviam.blabla.product.entity.ProductSpecification;
import com.coviam.blabla.product.entity.Specification;
import com.coviam.blabla.product.service.ProductServiceInterface;

@Controller
public class ProductController {

	@Autowired
	ProductServiceInterface ps;

	@RequestMapping(value = "/")
	public String returnAllProducts() {
//		List<Product> p = ps.getAllProducts();
		return ("index.html");
	}

	@RequestMapping("/test")
	@ResponseBody
	public ModelAndView testMethod() {
		return new ModelAndView("/index.html", "p", "Krishna");
	}
	@RequestMapping("/hello")
	@ResponseBody
	public String someMethod() {
		return ("Hello");
	}

	@RequestMapping("/category/{query}")
	@ResponseBody
	public ProductListing getProductByCategory(@PathVariable("query") String query) {

		List<Product> productList = ps.findProduct(query);
		List<Product> productCodes = ps.getProductCodes(query);
		List<List<ProductMerchant>> pmList = new ArrayList<List<ProductMerchant>>();
		for (Product pCode : productCodes) {
			pmList.add(ps.getMerchantDetails(pCode.getProductCode()));
		}
		ProductListing productListing = new ProductListing(productList, pmList);
		return productListing;

	}

	@RequestMapping("/product/{pCode}/{mId}")
	@ResponseBody
	public ProductDetails getOrderedProducts(@PathVariable("pCode") int pCode, @PathVariable("mId") int mId) {

		List<ProductMerchant> productMerchantList = ps.getProductDetails(pCode, mId);
		List<Product> productList = ps.getProduct(pCode);
		List<ProductSpecification> prodSpec = ps.getProductSpecificationsByProduct(pCode);
		List<Integer> id = new ArrayList<Integer>();
		for (ProductSpecification productSpec : prodSpec) {
			id.add(productSpec.getProdSpecId().getSpec_id());
		}
		List<Specification> specList = ps.getSpecsById(id);
		ProductDetails productDetails = new ProductDetails(productList, prodSpec, productMerchantList, specList);
		return productDetails;

	}

	@RequestMapping("/product/{pCode}")
	@ResponseBody
	public ProductDetails getProductList(@PathVariable("pCode") int pCode) {

		List<ProductMerchant> productMerchantList = ps.getMerchantDetails(pCode);
		List<Product> productList = ps.getProduct(pCode);
		List<ProductSpecification> prodSpec = ps.getProductSpecificationsByProduct(pCode);
		List<Integer> id = new ArrayList<Integer>();
		for (ProductSpecification productSpec : prodSpec) {
			id.add(productSpec.getProdSpecId().getSpec_id());
		}
		List<Specification> specList = ps.getSpecsById(id);
		ProductDetails productDetails = new ProductDetails(productList, prodSpec, productMerchantList, specList);
		return productDetails;

	}

}