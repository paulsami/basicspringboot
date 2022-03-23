package com.bootcamp.discount.dto;

public class DiscountResponse {

	private double mrp;
	private double drp;
	private double fixedCategoryDiscount;
	private double onSpotDiscount;

	public DiscountResponse(double mrp, double drp, double fixedCategoryDiscount, double onSpotDiscount) {
		super();
		this.mrp = mrp;
		this.drp = drp;
		this.fixedCategoryDiscount = fixedCategoryDiscount;
		this.onSpotDiscount = onSpotDiscount;
	}

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	public double getDrp() {
		return drp;
	}

	public void setDrp(double drp) {
		this.drp = drp;
	}

	public double getFixedCategoryDiscount() {
		return fixedCategoryDiscount;
	}

	public void setFixedCategoryDiscount(double fixedCategoryDiscount) {
		this.fixedCategoryDiscount = fixedCategoryDiscount;
	}

	public double getOnSpotDiscount() {
		return onSpotDiscount;
	}

	public void setOnSpotDiscount(double onSpotDiscount) {
		this.onSpotDiscount = onSpotDiscount;
	}

	@Override
	public String toString() {
		return "DiscountResponse [mrp=" + mrp + ", drp=" + drp + ", fixedCategoryDiscount=" + fixedCategoryDiscount
				+ ", onSpotDiscount=" + onSpotDiscount + "]";
	}
}
