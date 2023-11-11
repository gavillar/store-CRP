package com.example.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.store.product.Product;
import com.example.store.product.ProductRepository;
import com.example.store.product.ProductRequestDTO;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @PostMapping
    public ResponseEntity<Product> post(@RequestBody ProductRequestDTO product) {
        Product productData = new Product(product);
        repository.save(productData);
        return new ResponseEntity<Product>(HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
    	return new ResponseEntity<List<Product>>(repository.findAll(), HttpStatus.OK);
    }

	@PutMapping
	@Transactional
	public ResponseEntity<Product> put(@RequestBody Product product) {
		if(repository.findById(product.getId()).isPresent()) {
			repository.deleteById(product.getId());
			repository.save(product);
			return new ResponseEntity<Product>(HttpStatus.OK);
		}
		return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
	}
    
	@DeleteMapping
	@Transactional
	public ResponseEntity<Product> delete(@RequestBody Product product) {
		if(repository.findById(product.getId()).isPresent()) {
			repository.deleteById(product.getId());
			return new ResponseEntity<Product>(HttpStatus.OK);
		}
		return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
	}
}
