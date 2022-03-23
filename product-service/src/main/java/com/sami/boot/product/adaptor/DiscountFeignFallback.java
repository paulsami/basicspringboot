package com.sami.boot.product.adaptor;

import org.springframework.stereotype.Component;

import com.sami.boot.product.dto.DiscountRequest;
import com.sami.boot.product.dto.DiscountResponse;

@Component
public class DiscountFeignFallback implements DiscountServiceFeignClient {

	@Override
	public DiscountResponse callDiscount(DiscountRequest request) {
		return new DiscountResponse(request.getMrp(), 0, 0, 0);
	}

}
