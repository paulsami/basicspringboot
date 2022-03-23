package com.sami.boot.product.adaptor;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.sami.boot.product.dto.DiscountRequest;
import com.sami.boot.product.dto.DiscountResponse;

//@FeignClient(url = "localhost:8082/api",name = "discountservcie")
//@FeignClient(name = "DISCOUNT-SERVICE", fallback = DiscountFeignFallback.class)
//@FeignClient(url = "localhost:8082",name = "discountservcie",fallback = DiscountFeignFallback.class)
@FeignClient("DISCOUNT-SERVICE")
public interface DiscountServiceFeignClient {
	@PostMapping(path = "/api/calculate")
	public DiscountResponse callDiscount(DiscountRequest request);
}
