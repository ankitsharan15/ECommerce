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
import com.coviam.blabla.order.dto.ItemDetail;
import com.coviam.blabla.order.dto.OrderAndItems;
import com.coviam.blabla.order.dto.ProductQty;
import com.coviam.blabla.order.entity.Order;
import com.coviam.blabla.order.entity.OrderItem;
import com.coviam.blabla.order.service.OrderService;
import com.coviam.blabla.product.dto.CustomMerchant;
import com.coviam.blabla.product.dto.ProductDetails;
import com.coviam.blabla.product.dto.ProductMerchantList;
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
	ProductServiceInterface ps;

	@Autowired
	OrderService orderservice;

	@Autowired
	MerchantServiceInterface msi;
	
	@Autowired
	SearchService searchservice;
	

	@RequestMapping(value = "/")
	public String returnAllProducts() {
		ps.saveProduct();
		return ("index.html");
	}

	@RequestMapping(value = "/updateStock", method = RequestMethod.POST)
	@ResponseBody
	public List<ProductQty> updateStock(@RequestBody ArrayList<ProductQty> productQty) {
		ProductMerchant productMerchant = new ProductMerchant();
		long curStock;
		for (ProductQty p : productQty) {
			productMerchant = ps.getProductDetails((int) p.getProductId(), (int) p.getMerchantId());
			curStock = productMerchant.getStock();
			productMerchant.setStock(curStock - p.getNumOfOrders());
			ps.saveProductMerchant(productMerchant);
		}
		return productQty;
	}

	@RequestMapping(value = "/getproductmerchant", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<OrderAndItems> getProductMerchant(@RequestBody ArrayList<OrderAndItems> productMerchantDto) {

		List<OrderAndItems> productMerchantList = new ArrayList<OrderAndItems>();
		ProductMerchantList pml = new ProductMerchantList();
		List<ItemDetail> itemdetaillist = new ArrayList<ItemDetail>();
		for (OrderAndItems pmd : productMerchantDto) {
			itemdetaillist = pmd.getProductList();
			for (ItemDetail itemdetail : itemdetaillist) {
				itemdetail.setMerchantName(ps.getMerchant(itemdetail.getMerchantId()).getMerchantName());
				itemdetail.setProductName(ps.getAProduct(itemdetail.getProductId()).getProductName());
				itemdetail.setImageUrl(ps.getAProduct(itemdetail.getProductId()).getProductImage());
			}
			productMerchantList.add(pmd);
		}
		return productMerchantList;
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

		List<ProductMerchant> productMerchantList = ps.getProductsDetails(pCode, mId);
		Product productList = ps.getAProduct(pCode);
		List<ProductSpecification> prodSpec = ps.getProductSpecificationsByProduct(pCode);
		List<Integer> id = new ArrayList<Integer>();
		for (ProductSpecification productSpec : prodSpec) {
			id.add(productSpec.getProdSpecId().getSpec_id());
		}
		CustomMerchant customMerchant;
		List<Specification> specList = ps.getSpecsById(id);
		List<CustomMerchant> customMerchantList = new ArrayList<CustomMerchant>();
		for (ProductMerchant productMerchant : productMerchantList) {
			customMerchant = new CustomMerchant(productMerchant,
					ps.getMerchant(productMerchant.getProductmerchantid().getMerchantId()).getMerchantName());
			customMerchantList.add(customMerchant);
		}
		ProductDetails productDetails = new ProductDetails(productList, prodSpec, customMerchantList, specList);
		return productDetails;

	}

	@RequestMapping("/product/{pCode}")
	@ResponseBody
	public ProductDetails getProductList(@PathVariable("pCode") int pCode) {

		List<ProductMerchant> productMerchantList = ps.getMerchantDetails(pCode);
		Product productList = ps.getAProduct(pCode);
		List<ProductSpecification> prodSpec = ps.getProductSpecificationsByProduct(pCode);
		List<Integer> id = new ArrayList<Integer>();
		for (ProductSpecification productSpec : prodSpec) {
			id.add(productSpec.getProdSpecId().getSpec_id());
		}
		CustomMerchant customMerchant;
		List<Specification> specList = ps.getSpecsById(id);
		List<CustomMerchant> customMerchantList = new ArrayList<CustomMerchant>();
		for (ProductMerchant productMerchant : productMerchantList) {
			customMerchant = new CustomMerchant(productMerchant,
					ps.getMerchant(productMerchant.getProductmerchantid().getMerchantId()).getMerchantName());
			customMerchantList.add(customMerchant);
		}
		ProductDetails productDetails = new ProductDetails(productList, prodSpec, customMerchantList, specList);
		return productDetails;

	}

	@RequestMapping("/merchant")
	@ResponseBody
	public List<Merchant> Merchantindex() {
		return (List<Merchant>) msi.getMerchantDetails(null);
	}

	@RequestMapping("/update")
	@ResponseBody
	public void updateRating(RatingList rl) {
		msi.updateMerchantRating(rl);
	}

	@RequestMapping(value = "/orders/checkout", method = RequestMethod.POST)
	@ResponseBody
	public boolean saveOrder(@RequestBody OrderAndItems orderanditems){
		
		Order savedOrder = orderservice.saveOrder(orderanditems);
		long orderId = savedOrder.getOrderId();
		List<OrderItem> savedOrderItems = orderservice.saveOrderItems(orderanditems, orderId);
		//orderservice.updateStockinProductMicroService(savedOrderItems);
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
	


}