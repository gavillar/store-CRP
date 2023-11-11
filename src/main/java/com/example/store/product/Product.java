package com.example.store.product;

import com.example.store.utils.JsonUtils;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "product")
@Entity(name = "product")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String image;
    private Integer price;

    public Product(ProductRequestDTO data) {
        this.image = data.image();
        this.title = data.title();
        this.price = data.price();

    }
    
	public static Product instanciateBy(final Object value) {
		return JsonUtils.toJson(value, Product.class);
	}
}
