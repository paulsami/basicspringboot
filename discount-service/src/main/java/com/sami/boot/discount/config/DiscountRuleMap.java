package com.sami.boot.discount.config;

import java.util.HashMap;
import java.util.Map;

import com.sami.boot.discount.dto.ProductCategory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "discountdata")
@Component
public class DiscountRuleMap {
	private Map<ProductCategory, Double> discountMap = new HashMap<ProductCategory, Double>();

	public Map<ProductCategory, Double> getDiscountMap() {
		return discountMap;
	}

	public void setDiscountMap(Map<ProductCategory, Double> discountMap) {
		this.discountMap = discountMap;
	}

}
