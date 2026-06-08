package com.trainingmug.ecommerce.repository;

import com.trainingmug.ecommerce.model.Product;
import org.springframework.stereotype.Repository;
import com.trainingmug.ecommerce.util.CsvReader;

import java.io.IOException;
import java.util.List;

@Repository
public class ProductRepository {
    private final CsvReader csvReader;
    private final List<Product> products;

    public ProductRepository(CsvReader csvReader) throws IOException {
        this.csvReader = csvReader;
        this.products = this.csvReader.getProductsFromCsv();
    }

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