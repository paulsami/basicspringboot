package com.sami.boot.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sami.boot.product.adaptor.DiscountServiceClient;
import com.sami.boot.product.adaptor.DiscountServiceFeignClient;
import com.sami.boot.product.dto.DiscountRequest;
import com.sami.boot.product.dto.DiscountResponse;
import com.sami.boot.product.dto.ProductPrice;
import com.sami.boot.product.entity.Product;
import com.sami.boot.product.repo.ProductRepo;

@Service
public class ProductService {
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private DiscountServiceClient client;
	@Autowired
	DiscountServiceFeignClient feignClient;

	public List<Product> findAll() {
		List<Product> products = new ArrayList<Product>();
		productRepo.findAll().forEach(product -> products.add(product));
		return products;
	}

	public Product findById(Integer id) {
		return productRepo.findById(id).get();
	}

	public Product create(Product product) {
		return productRepo.save(product);
	}

	public ProductPrice getPrice(Integer id) {

		Product product = productRepo.findById(id).get();
		DiscountRequest discountRequest = new DiscountRequest();
		discountRequest.setCategory(product.getCategory());
		discountRequest.setMrp(product.getMrp());
		DiscountResponse discountResponse = client.callDiscount(discountRequest);

		ProductPrice productPrice = new ProductPrice();
		productPrice.setDiscount(discountResponse);
		productPrice.setProduct(product);

		return productPrice;
	}
}
