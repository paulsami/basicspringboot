package com.sami.boot.product.dto;

import com.sami.boot.product.entity.Product;

public class ProductPrice {

	private Product product;
	private DiscountResponse discount;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public DiscountResponse getDiscount() {
		return discount;
	}

	public void setDiscount(DiscountResponse discount) {
		this.discount = discount;
	}
}
