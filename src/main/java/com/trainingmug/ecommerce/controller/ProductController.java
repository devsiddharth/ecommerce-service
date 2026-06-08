package com.trainingmug.ecommerce.controller;

import com.trainingmug.ecommerce.model.Product;
import com.trainingmug.ecommerce.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // GET all available / unavailable products
    // /api/products/available?status=true
    @GetMapping("/available")
    public List<Product> getAvailableProducts(@RequestParam boolean status) {
        return productService.getAvailableProducts(status);
    }

    // /api/products/category/Electronics
    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }

    // /api/products/price/greater-than/5000
    @GetMapping("/price/greater-than/{price}")
    public List<Product> getAllGreaterThanPrice(@PathVariable int price) {
        return productService.getAllGreaterThanPrice(price);
    }

    // /api/products/names
    @GetMapping("/names")
    public List<String> getAllProductsName() {
        return productService.getAllProductsName();
    }

    // /api/products/count/available?status=true
    @GetMapping("/count/available")
    public long countAvailableProducts(@RequestParam boolean status) {
        return productService.countAvailableProducts(status);
    }

    // /api/products/company/Samsung
    @GetMapping("/company/{company}")
    public ResponseEntity<Product> getCompanyProduct(@PathVariable String company) {
        Optional<Product> product = productService.getCompanyProduct(company);
        return product.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // /api/products/all-available
    @GetMapping("/all-available")
    public boolean areAllProductsAvailable() {
        return productService.areAllProductsAvailable();
    }

    // /api/products/first
    @GetMapping("/first")
    public ResponseEntity<Product> getFirstProduct() {
        Optional<Product> product = productService.getFirstProduct();
        return product.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // /api/products/categories
    @GetMapping("/categories")
    public List<String> getAllCategories() {
        return productService.getAllCategories();
    }

    // /api/products/top-expensive/50000
    @GetMapping("/top-expensive/{price}")
    public List<Product> getTopExpensiveProducts(@PathVariable int price) {
        return productService.getTopExpensiveProducts(price);
    }

    // /api/products/sort/price/asc
    @GetMapping("/sort/price/asc")
    public List<Product> getProductsOrderByPriceAsc() {
        return productService.getProductsOrderByPriceAsc();
    }

    // /api/products/sort/name/desc
    @GetMapping("/sort/name/desc")
    public List<Product> getProductsByNameInDesc() {
        return productService.getProductsByNameInDesc();
    }

    // /api/products/price/sum
    @GetMapping("/price/sum")
    public double getSumOfAllProductPrices() {
        return productService.getSumOfAllProductPrices();
    }

    // /api/products/1/discount-price
    @GetMapping("/{id}/discount-price")
    public double getTotalPriceAfterDiscount(@PathVariable int id) {
        return productService.getTotalPriceAfterDiscount(id);
    }

    // /api/products/manufactured-after/2020
    @GetMapping("/manufactured-after/{year}")
    public List<Product> getAllProductsByManufacturedYear(@PathVariable int year) {
        return productService.getAllProductsByManufacturedYear(year);
    }

    // /api/products/available/price-greater-than/5000
    @GetMapping("/available/price-greater-than/{price}")
    public List<Product> getAllProductsAvailableByPrice(@PathVariable int price) {
        return productService.getAllProductsAvailableByPrice(price);
    }

    // /api/products/count-by-category
    @GetMapping("/count-by-category")
    public Map<String, Long> getProductCountByCategory() {
        return productService.getProductCountByCategory();
    }

    // /api/products/group-by-category
    @GetMapping("/group-by-category")
    public Map<String, List<Product>> getAllProductsGroupByCategory() {
        return productService.getAllProductsGroupByCategory();
    }

    // /api/products/group-by-company
    @GetMapping("/group-by-company")
    public Map<String, List<Product>> getAllProductsGroupByCompany() {
        return productService.getAllProductsGroupByCompany();
    }

    // /api/products/group-by-availability
    @GetMapping("/group-by-availability")
    public Map<Boolean, List<Product>> getProductsByAvailability() {
        return productService.getProductsByAvailability();
    }

    // /api/products/expensive
    @GetMapping("/expensive")
    public Product getExpensiveProduct() {
        return productService.getExpensiveProduct();
    }

    // /api/products/cheap
    @GetMapping("/cheap")
    public Product getCheapProduct() {
        return productService.getCheapProduct();
    }

    // /api/products/map-by-id
    @GetMapping("/map-by-id")
    public Map<Integer, Product> getProductsWithId() {
        return productService.getProductsWithId();
    }

    // /api/products/average-price-by-category
    @GetMapping("/average-price-by-category")
    public Map<String, Double> getAveragePriceByCategory() {
        return productService.getAveragePriceByCategory();
    }

    // /api/products/top-expensive-by-category
    @GetMapping("/top-expensive-by-category")
    public Map<String, List<Product>> getTopExpProductByCategory() {
        return productService.getTopExpProductByCategory();
    }

    //CRUD endpoint Apis

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return "Product deleted successfully";
    }
}