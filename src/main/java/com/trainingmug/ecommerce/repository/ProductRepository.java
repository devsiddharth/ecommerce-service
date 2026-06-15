package com.trainingmug.ecommerce.repository;

import com.trainingmug.ecommerce.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private final List<Product> products = new ArrayList<>();

    public List<Product> findAll(){
        return products;
    }

    public Product save(Product product) {
        products.add(product);
        return product;
    }

    public Product findById(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void deleteById(int id) {
        products.removeIf(product -> product.getId() == id);
    }
}