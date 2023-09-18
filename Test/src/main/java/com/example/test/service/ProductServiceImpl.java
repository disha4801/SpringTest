package com.example.test.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.test.dto.Product;
import com.example.test.exception.IdNotFoundException;
import com.example.test.exception.InvalidNameException;
import com.example.test.repo.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
	@Override
	public Product createProduct(Product product)throws IdNotFoundException {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	
	@Override
	public Optional<Product> RetrieveProductById(String productId) {
		// TODO Auto-generated method stub
		return productRepository.findById(productId);
	}

	@Override
	public Iterable<Product> RetrieveAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public boolean deleteProductById(String productId)throws IdNotFoundException {
		// TODO Auto-generated method stub
		if (productRepository.existsById(productId)) {
			productRepository.deleteById(productId);
			if (productRepository.existsById(productId)) {
				return false;
			}
			return true;
		} else {
			throw new IdNotFoundException("AccountId not found");
		}
	}

	@Override
	public boolean existsById(String productId) {
		if (productRepository.existsById(productId)) return true;
		else return false;
	}

	@Override

	public Optional<Product> updateProduct(Product product, String Id) throws InvalidNameException {

		Optional<Product> product2 = productRepository.findByName(product.getName());

		// same product being update

		if (product2.isPresent() && product2.get().getId().equals(Id)) {

			productRepository.save(product);

			return Optional.of(product);

		} else if (product2.isPresent()) {

			throw new InvalidNameException("Product Name should be unique");

		} else {

			productRepository.save(product);

			return Optional.of(product);

		}

	}


}
