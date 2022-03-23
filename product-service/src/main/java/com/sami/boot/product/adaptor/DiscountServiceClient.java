package com.sami.boot.product.adaptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sami.boot.product.config.DiscountServiceconfig;
import com.sami.boot.product.dto.DiscountRequest;
import com.sami.boot.product.dto.DiscountResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class DiscountServiceClient {
	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;
	@Autowired
	private DiscountServiceconfig serviceconfig;

	@HystrixCommand(fallbackMethod = "discountfallback")
	public DiscountResponse callDiscount(DiscountRequest request) {
		HttpEntity<DiscountRequest> entity = new HttpEntity<DiscountRequest>(request);

		return restTemplate.postForEntity(serviceconfig.getUrl(), entity, DiscountResponse.class).getBody();
	}

	public DiscountResponse discountfallback(DiscountRequest request)
	{
		return new DiscountResponse(request.getMrp(),0 , 0, 0);
	}
}
