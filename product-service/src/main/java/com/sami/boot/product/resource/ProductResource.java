package com.sami.boot.product.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sami.boot.product.dto.ProductPrice;
import com.sami.boot.product.entity.Product;
import com.sami.boot.product.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductResource {

	@Value("${product.name:IPhone}")
	private String productName;
	@Autowired
	private ProductService service;

	@RefreshScope
	@GetMapping
	private ResponseEntity<List<Product>> getProducts() {
		return new ResponseEntity<List<Product>>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	private ResponseEntity<Product> getProduct(@PathVariable("id") int id) {
		return new ResponseEntity<Product>(service.findById(id), HttpStatus.OK);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Product> create(@RequestBody Product product) {
		return new ResponseEntity<Product>(service.create(product), HttpStatus.CREATED);
	}

	@GetMapping("/{id}/price")
	private ResponseEntity<ProductPrice> getProductPrice(@PathVariable("id") int id) {
		return new ResponseEntity<ProductPrice>(service.getPrice(id), HttpStatus.OK);
	}
}
