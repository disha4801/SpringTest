package com.example.test.payload.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class ProductRequest {
//	@NotBlank(message = "product id should not be blank")
//	public String id;
	@Column(unique=true)
	public String name;
	@NotBlank(message = "Description should be Given")
	private String description;
	@Min(value = 0,message = "price should be non negative")
	public float price;
	@NotBlank(message = "ExpiryDate should not be given")
	public String expiry;
	@NotBlank(message = "Category should written")
	public String category;

}
