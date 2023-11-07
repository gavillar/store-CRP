package com.example.store.controller;

import com.example.store.product.Product;
import com.example.store.product.ProductRepository;
import com.example.store.product.ProductRequestDTO;
import com.example.store.product.ProductrResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveProduct(@RequestBody ProductRequestDTO data) {
        Product productData = new Product(data);
        repository.save(productData);
        return;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<ProductrResponseDTO> getAll() {
        List<ProductrResponseDTO> productList = repository.findAll().stream().map(ProductrResponseDTO::new).toList();
        return productList;
    }
}
