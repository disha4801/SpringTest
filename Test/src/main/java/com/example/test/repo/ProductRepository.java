package com.example.test.repo;

import java.util.Optional;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.test.dto.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {

	public Optional<Product>findByName(String Name);



}
