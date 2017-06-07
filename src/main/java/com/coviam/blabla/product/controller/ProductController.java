package com.coviam.blabla.product.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coviam.blabla.merchant.dto.RatingList;
import com.coviam.blabla.merchant.entity.Merchant;
import com.coviam.blabla.merchant.service.MerchantServiceInterface;
import com.coviam.blabla.merchant.service.iScoreCalculator;
import com.coviam.blabla.order.dto.OrderAndItems;
import com.coviam.blabla.order.entity.Order;
import com.coviam.blabla.order.service.OrderService;
import com.coviam.blabla.product.dto.ProductDetails;
import com.coviam.blabla.product.entity.Product;
import com.coviam.blabla.product.entity.ProductMerchant;
import com.coviam.blabla.product.entity.ProductSpecification;
import com.coviam.blabla.product.entity.Specification;
import com.coviam.blabla.product.service.ProductServiceInterface;

@Controller
public class ProductController {

	@Autowired
	ProductServiceInterface ps;

	@Autowired
	OrderService orderservice;
	
	MerchantServiceInterface msi;
	@Autowired
	iScoreCalculator isc;


	@RequestMapping(value = "/")
	public String returnAllProducts() {
		
		return ("index.html");
	}

	@RequestMapping("/category/{query}")
	@ResponseBody
	public List<Product> getProductByCategory(@PathVariable("query") String query) {

		List<Product> productList = ps.findProduct(query);
		return productList;

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

	@RequestMapping("/merchant")
	public List<Merchant> Merchantindex() {
		return (List<Merchant>) msi.getMerchantDetails(null);
	}

	@RequestMapping("/update")
	public void updateRating(RatingList rl) {
		msi.updateMerchantRating(rl);
	}

	@RequestMapping(value = "/orders/checkout", method = RequestMethod.POST)
	@ResponseBody
	public boolean saveOrder(@RequestBody OrderAndItems orderanditems) {

		Order savedOrder = orderservice.saveOrder(orderanditems);
		long orderId = savedOrder.getOrderId();
		orderservice.saveOrderItems(orderanditems, orderId);
		return true;
	}

	@RequestMapping(value = "/orders/history", method = RequestMethod.POST)
	@ResponseBody
	public List<OrderAndItems> fetchOrderHistory(@RequestBody String email) {
		List<OrderAndItems> orderHistory = orderservice.fetchOrderHistory(email);
		if (orderHistory.size() == 0)
			return null;
		return orderHistory;
	}

}