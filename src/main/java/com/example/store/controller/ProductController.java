package com.example.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

//    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveProduct(@RequestBody ProductRequestDTO data) {
        Product productData = new Product(data);
        repository.save(productData);
        return;
    }
    
//    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<Product> getAll() {
        return repository.findAll();
    }
    
//    @CrossOrigin(origins = "*", allowedHeaders = "*")
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
