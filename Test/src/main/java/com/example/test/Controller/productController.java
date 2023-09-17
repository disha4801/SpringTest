package com.example.test.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.dto.Product;
import com.example.test.exception.IdNotFoundException;
import com.example.test.exception.InvalidNameException;
import com.example.test.payload.request.ProductRequest;
import com.example.test.service.ProductService;
import com.example.test.utils.RequestToEntityMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/product")
public class productController {

	@Autowired
	ProductService productService;
	@Autowired
	RequestToEntityMapper mapper;

	@PostMapping("/create")

	public ResponseEntity<?> createProduct(@Valid @RequestBody ProductRequest productRequest) {

		return ResponseEntity.ok(mapper.getProductEntityObject(productRequest));

	}
	
	 @GetMapping("/{productId}")

		public ResponseEntity<?>RetrieveProductById(@PathVariable("productId") String productId) throws IdNotFoundException {
			Optional<Product> optional = productService.RetrieveProductById(productId);
			if(optional.isPresent()) {
				return ResponseEntity.ok(optional.get());
			}
			else {
				throw new IdNotFoundException("ID not found");

			}
		}
	 
		@GetMapping("/products")

		public ResponseEntity<?> RetrieveAllProducts() {

			List<Product> result;

			result = (List<Product>) productService.RetrieveAllProducts();

			return ResponseEntity.ok(result);

		}
		@DeleteMapping("/{productId}")

		public ResponseEntity<?> deleteProductById(@PathVariable("productId") String productId) throws IdNotFoundException{

			if(productService.existsById(productId)) {

				productService.deleteProductById(productId);

				return ResponseEntity.ok("product deleted");
			}else {

				throw new IdNotFoundException("Id not found");

			}

		}
		@PutMapping("/update/{productId}")

		public ResponseEntity<?> updateProduct(@RequestBody ProductRequest productRequest, 
		@PathVariable("productId") String Id) throws InvalidNameException, IdNotFoundException {

			Optional<Product> updatedProduct;
			if(productService.existsById(Id)) {

				Product product = mapper.getProductEntityObject(productRequest);

				product.setId(Id);

				updatedProduct = productService.updateProduct(product,Id);

			}

			else

				throw new IdNotFoundException("Product Id Doesn't exist");

			

			return new ResponseEntity(updatedProduct, HttpStatus.OK);

		}

	}
