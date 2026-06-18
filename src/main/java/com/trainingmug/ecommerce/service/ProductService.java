package com.trainingmug.ecommerce.service;



import com.trainingmug.ecommerce.entity.Product;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductService {

//    //Get all available products based on availability.
//    List<Product> getAvailableProducts(boolean isAvailable);
//
//    //Get all products belonging to a given category.
//    List<Product> getProductsByCategory(String category);
//
//    //Get all products with price greater than a given value.
//    List<Product> getAllGreaterThanPrice(int maxRetailPrice);
//
//    //Get names of all products.
//    List<String> getAllProductsName();
//
//    //Count how many products are available.
//    long countAvailableProducts(boolean isAvailable);
//
//    //Check if there is any product from a given company.
//    Optional<Product> getCompanyProduct(String company);
//
//    //Check if all products are available.
//    boolean areAllProductsAvailable();
//
//    //Get the first product safely (avoids NullPointerException).
//    Optional<Product>  getFirstProduct();
//
//    //Get all unique categories.
//    List<String> getAllCategories();
//
//    //Get top N most expensive products.
//    List<Product> getTopExpensiveProducts(int highestPrice);
//
//    //Sort products by price in ascending order.
//    List<Product> getProductsOrderByPriceAsc();
//
//    //Sort products by name in descending order.
//    List<Product> getProductsByNameInDesc();
//
//    //Get total inventory value (sum of all product prices).
//    double getSumOfAllProductPrices();
//
//    //Get total price after applying discounts.
//    double getTotalPriceAfterDiscount(int id);
//
//    //Get all products manufactured after a given year.
//    List<Product> getAllProductsByManufacturedYear(int manufacturedYear);
//
//    //Get all products that are:
//    //
//    //- available
//    //- and price greater than a given value
//    List<Product> getAllProductsAvailableByPrice(int maxRetailPrice);
//
//    //Count number of products in each category.
//    Map<String, Long> getProductCountByCategory();
//
//    //Group all products by category.
//    Map<String, List<Product>> getAllProductsGroupByCategory();
//
//    //Group all products by company.
//    Map<String, List<Product>> getAllProductsGroupByCompany();
//
//    //Partition products into:
//    //
//    //- available
//    //- unavailable
//    Map<Boolean, List<Product>> getProductsByAvailability();
//
//    //Find the most expensive product.
//    Product getExpensiveProduct();
//
//    //Find the cheap product.
//    Product getCheapProduct();
//
//    //Create a Map of product ID to Product.
//    Map<Integer, Product> getProductsWithId();
//
//    //Find the average price of products per category.
//    Map<String, Double> getAveragePriceByCategory();
//
//    //Get top 3 most expensive products in each category.
//    Map<String, List<Product>> getTopExpProductByCategory();

    //CRUD Methods

    Product createProduct(Product product);

    List<Product> getAllProducts();

    Optional<Product> getProductById(int id);

    Product updateProduct(int id, Product product);

    void deleteProduct(int id);

}
