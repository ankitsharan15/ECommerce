package com.coviam.blabla.product.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.coviam.blabla.merchant.dto.IdandScore;
import com.coviam.blabla.merchant.dto.RatingList;
import com.coviam.blabla.merchant.dto.ScoreUpdaterfromProduct;
import com.coviam.blabla.merchant.entity.Merchant;
import com.coviam.blabla.merchant.entity.ScoreId;
import com.coviam.blabla.merchant.service.MerchantServiceInterface;
import com.coviam.blabla.order.dto.ItemDetail;
import com.coviam.blabla.order.dto.OrderAndItems;
import com.coviam.blabla.order.dto.ProductQty;
import com.coviam.blabla.order.entity.Order;
import com.coviam.blabla.order.entity.OrderItem;
import com.coviam.blabla.order.service.OrderService;
import com.coviam.blabla.product.dto.CustomMerchant;
import com.coviam.blabla.product.dto.ProductDetails;
import com.coviam.blabla.search.dto.ProductSearch;
import com.coviam.blabla.service.SearchService;
import com.coviam.blabla.product.entity.Product;
import com.coviam.blabla.product.entity.ProductMerchant;
import com.coviam.blabla.product.entity.ProductSpecification;
import com.coviam.blabla.product.entity.Specification;
import com.coviam.blabla.product.service.ProductServiceInterface;

@Controller
public class ProductController {

	@Autowired
	ProductServiceInterface productService;

	@Autowired
	OrderService orderservice;

	@Autowired
	MerchantServiceInterface merchantService;

	@Autowired
	SearchService searchservice;
	
	@RequestMapping(value = "/")
	public String returnAllProducts() {
		return ("index.html");
	}

	@RequestMapping(value = "/updateStock", method = RequestMethod.POST)
	@ResponseBody
	public List<ProductQty> updateStock(@RequestBody ArrayList<ProductQty> productQty) {
		ProductMerchant productMerchant = new ProductMerchant();
		int curStock;
		for (ProductQty p : productQty) {
			curStock = productMerchant.getStock() - p.getNumOfOrders();
			if (curStock >= 0) {
				productMerchant = productService.getProductDetails((int) p.getProductId(), (int) p.getMerchantId());
				productMerchant.setStock(curStock);
				productService.saveProductMerchant(productMerchant);
			}
		}
		return productQty;
	}

	@RequestMapping(value = "/getUpdatesfromProduct", method = RequestMethod.POST)
	public ScoreUpdaterfromProduct setScoreFromProduct(@RequestBody ScoreId scoreId) {
		ProductMerchant productMerchant = productService.getProductDetails(scoreId.getProductId(),
				scoreId.getMerchantId());
		ScoreUpdaterfromProduct scoreproduct = new ScoreUpdaterfromProduct(
				productMerchant.getProductmerchantid().getMerchantId(), productMerchant.getCapacity(),
				productMerchant.getStock(), productMerchant.getPrice());
		return scoreproduct;
	}

	@RequestMapping(value = "/setscoretoproduct", method = RequestMethod.POST)
	@ResponseBody
	public boolean updateLocalScore(@RequestBody List<IdandScore> idandscore) {

		ProductMerchant productMerchant;
		for (IdandScore idscore : idandscore) {
			productMerchant = productService.getProductDetails(idscore.getScoreid().getProductId(),
					idscore.getScoreid().getMerchantId());
			productMerchant.setScore(idscore.getScore());
			productService.saveProductMerchant(productMerchant);
			productService.updateBestScores(idscore.getScoreid());
		}

		return true;
	}

	@RequestMapping(value = "/getproductmerchant", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<OrderAndItems> getProductMerchant(@RequestBody ArrayList<OrderAndItems> productMerchantDto) {

		List<OrderAndItems> productMerchantList = new ArrayList<OrderAndItems>();
		List<ItemDetail> itemdetaillist = new ArrayList<ItemDetail>();
		for (OrderAndItems pmd : productMerchantDto) {
			itemdetaillist = pmd.getProductList();
			for (ItemDetail itemdetail : itemdetaillist) {
				itemdetail.setMerchantName(productService.getMerchant(itemdetail.getMerchantId()).getMerchantName());
				itemdetail.setProductName(productService.getAProduct(itemdetail.getProductId()).getProductName());
				itemdetail.setImageUrl(productService.getAProduct(itemdetail.getProductId()).getProductImage());
			}
			productMerchantList.add(pmd);
		}
		return productMerchantList;
	}

	@RequestMapping("/category/{query}")
	@ResponseBody
	public List<Product> getProductByCategory(@PathVariable("query") String query) {

		List<Product> productList = productService.findProduct(query);
		return productList;

	}

	@RequestMapping("/product/{pCode}/{mId}")
	@ResponseBody
	public ProductDetails getOrderedProducts(@PathVariable("pCode") int pCode, @PathVariable("mId") int mId) {

		List<ProductMerchant> productMerchantList = productService.getProductsDetails(pCode, mId);
		Product productList = productService.getAProduct(pCode);
		List<ProductSpecification> prodSpec = productService.getProductSpecificationsByProduct(pCode);
		List<Integer> id = new ArrayList<Integer>();
		for (ProductSpecification productSpec : prodSpec) {
			id.add(productSpec.getProdSpecId().getSpec_id());
		}
		CustomMerchant customMerchant;
		List<Specification> specList = productService.getSpecsById(id);
		List<CustomMerchant> customMerchantList = new ArrayList<CustomMerchant>();
		for (ProductMerchant productMerchant : productMerchantList) {
			customMerchant = new CustomMerchant(productMerchant, productService
					.getMerchant(productMerchant.getProductmerchantid().getMerchantId()).getMerchantName());
			customMerchantList.add(customMerchant);
		}
		ProductDetails productDetails = new ProductDetails(productList, prodSpec, customMerchantList, specList);
		return productDetails;

	}

	@RequestMapping("/product/{pCode}")
	@ResponseBody
	public ProductDetails getProductList(@PathVariable("pCode") int pCode) {

		List<ProductMerchant> productMerchantList = productService.getMerchantDetails(pCode);
		Product productList = productService.getAProduct(pCode);
		List<ProductSpecification> prodSpec = productService.getProductSpecificationsByProduct(pCode);
		List<Integer> id = new ArrayList<Integer>();
		for (ProductSpecification productSpec : prodSpec) {
			id.add(productSpec.getProdSpecId().getSpec_id());
		}
		CustomMerchant customMerchant;
		List<Specification> specList = productService.getSpecsById(id);
		List<CustomMerchant> customMerchantList = new ArrayList<CustomMerchant>();
		for (ProductMerchant productMerchant : productMerchantList) {
			customMerchant = new CustomMerchant(productMerchant, productService
					.getMerchant(productMerchant.getProductmerchantid().getMerchantId()).getMerchantName());
			customMerchantList.add(customMerchant);
		}
		ProductDetails productDetails = new ProductDetails(productList, prodSpec, customMerchantList, specList);
		return productDetails;

	}

	@RequestMapping("/merchant")
	@ResponseBody
	public void Merchantindex() {
		//return (List<Merchant>) msi.getMerchantDetails(null);
	}

	@RequestMapping("/update")
	@ResponseBody
	public void updateRating(RatingList rl) {
		merchantService.updateMerchantRating(rl);
	}

	@RequestMapping(value = "/orders/checkout", method = RequestMethod.POST)
	@ResponseBody
	public boolean saveOrder(@RequestBody OrderAndItems orderanditems){

		Order savedOrder = orderservice.saveOrder(orderanditems);
		long orderId = savedOrder.getOrderId();
		List<OrderItem> savedOrderItems = orderservice.saveOrderItems(orderanditems, orderId);
		orderservice.updateStockinProductMicroService(savedOrderItems);
		orderservice.updateProductRatingQuantityinMerchantMicroService(savedOrderItems);
		orderservice.sendOrderConfirmationEmail(orderId, orderanditems);
		return true;
		
		}



	@RequestMapping(value = "/orders/history", method = RequestMethod.POST)
	@ResponseBody
	public List<OrderAndItems> fetchOrderHistory(@RequestBody String email){
		List<OrderAndItems> orderHistory = orderservice.fetchOrderHistory(email);
		if(orderHistory.size() == 0)
			return null;
		return orderHistory;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public List<ProductSearch> searchProduct(@RequestBody String productName){
		List<ProductSearch> productsearchedlist = searchservice.getProductByName(productName);
		return productsearchedlist;
	}
	


	@RequestMapping(value = "/getProductByName/{productName}")
	@ResponseBody
	public List<ProductSearch> getProductByName(@PathVariable("productName") String productName) {
		return productService.getProductListByName(productName);

	}

}