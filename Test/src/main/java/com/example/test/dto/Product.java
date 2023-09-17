package com.example.test.dto;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import com.example.test.utils.CustomProductIdGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_seq")
	
	@GenericGenerator(name = "product_seq", strategy = "com.example.test.utils.CustomProductIdGenerator",
	parameters =  {@Parameter(name=CustomProductIdGenerator.INCREMENT_PARAM,value="50"),
			@Parameter(name=CustomProductIdGenerator.NUMBER_FORMAT_PARAMETER,value="%05d"),
			@Parameter(name=CustomProductIdGenerator.VALUE_PREFIX_PARAMETER,value="pro_")}
				)
	@NotBlank(message = "product id should not be blank")
	public String id;
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
