package com.sami.boot.product.dto;

import java.io.Serializable;

import com.sami.boot.product.entity.ProductCategory;

public class DiscountRequest implements Serializable {
	public DiscountRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DiscountRequest(ProductCategory category, double mrp) {
		super();
		this.category = category;
		this.mrp = mrp;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductCategory category;
	private double mrp;

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	@Override
	public String toString() {
		return "DiscountRequest [category=" + category + ", mrp=" + mrp + "]";
	}
}
