package com.example.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.domain.Product;
import com.example.test.repository.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping(value = "/create")
	public void create(Product product) {
		productRepository.save(product);
	}
	
	@GetMapping(value = "/readOne")
	public Optional readOne(Long id) {
		return productRepository.findById(id);
	}
	
	@GetMapping(value = "/readAll")
	public List readAll() {
		return productRepository.findAll();
	}
	
	@GetMapping(value = "/update")
	public void update(Product product, Long id) {
		productRepository.update(product, id);
	}
	
	@GetMapping(value = "/delete")
	public void delete(Long id) {
		productRepository.deleteById(id);
	}

}
