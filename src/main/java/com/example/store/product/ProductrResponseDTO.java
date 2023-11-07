package com.example.store.product;

public record ProductrResponseDTO(Long id, String title, String image, Integer price) {
    public ProductrResponseDTO(Product product) {
    this(product.getId(), product.getTitle(), product.getImage(), product.getPrice());
    }
}
