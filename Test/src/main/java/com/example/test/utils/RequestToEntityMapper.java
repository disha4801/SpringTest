package com.example.test.utils;

import org.springframework.stereotype.Component;

import com.example.test.dto.Product;
import com.example.test.payload.request.ProductRequest;


@Component

public class RequestToEntityMapper {

	public Product getProductEntityObject(ProductRequest productRequest) {

		Product product = new Product();
	    //product.setId(productRequest.getId());
		product.setName(productRequest.getName());
		product.setDescription(productRequest.getDescription());
		product.setPrice(productRequest.getPrice());
		product.setExpiry(productRequest.getExpiry());
		product.setCategory(productRequest.getCategory());
		return product;

	}
}
