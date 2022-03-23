package com.sami.boot.discount.dto;

public class DiscountRequest {
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
