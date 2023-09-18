package com.example.test.service;

import java.util.Optional;



import com.example.test.dto.Product;
import com.example.test.exception.IdNotFoundException;
import com.example.test.exception.InvalidNameException;

public interface ProductService {
	public Product createProduct(Product product)throws IdNotFoundException;
	public Optional<Product> updateProduct(Product product,String Id) throws InvalidNameException;
    public Optional<Product> RetrieveProductById(String productId);
    public Iterable<Product> RetrieveAllProducts();
    public boolean deleteProductById(String producttId)throws IdNotFoundException;
	public boolean existsById(String productId);
	
}
