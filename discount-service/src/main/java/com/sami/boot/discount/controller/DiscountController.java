package com.sami.boot.discount.controller;

import java.util.Map;

import com.sami.boot.discount.config.DiscountRuleMap;
import com.sami.boot.discount.dto.DiscountRequest;
import com.sami.boot.discount.dto.DiscountResponse;
import com.sami.boot.discount.dto.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/discount")
@Slf4j
public class DiscountController {
	@Autowired
	private DiscountRuleMap ruleMap;

	@GetMapping
	public Map<ProductCategory, Double> getDiscount() {
		
		return ruleMap.getDiscountMap();
	}

	@PostMapping(path = "/calculate", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public DiscountResponse caclulate(@RequestBody DiscountRequest request) {

		double fixedCategoryDiscount = ruleMap.getDiscountMap().get(request.getCategory());
		double onSpotDiscount = Math.floor(Math.random() * 10);
		double discountper = fixedCategoryDiscount + onSpotDiscount;
		double drp = Math.ceil(request.getMrp() - ((discountper / 100) * request.getMrp()));
		DiscountResponse response = new DiscountResponse(request.getMrp(), drp, fixedCategoryDiscount, onSpotDiscount);
		return response;
	}
}
