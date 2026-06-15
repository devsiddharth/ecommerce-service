package com.trainingmug.ecommerce.service.impl;

import com.trainingmug.ecommerce.entity.Product;
import com.trainingmug.ecommerce.repository.ProductRepository;
import com.trainingmug.ecommerce.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

//    @Override
//    public List<Product> getAvailableProducts(boolean isAvailable) {
//        return  productRepository
//                .findAll()
//                .stream()
//                .filter(p -> p.isAvailable() == isAvailable)
//                .toList();
//    }
//
//    @Override
//    public List<Product> getProductsByCategory(String category) {
//        return productRepository
//                .findAll().stream()
//                .filter(p -> p.getCategory().equals(category))
//                .toList();
//    }
//
//    @Override
//    public List<Product> getAllGreaterThanPrice(int maxRetailPrice) {
//        return productRepository
//                .findAll()
//                .stream()
//                .filter(p ->p.getMaxRetailPrice() > maxRetailPrice)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<String> getAllProductsName() {
//        return productRepository
//                .findAll()
//                .stream()
//                .map(Product::getName)
//                .distinct()
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public long countAvailableProducts(boolean isAvailable) {
//        return productRepository
//                .findAll()
//                .stream()
//                .filter(p ->p.isAvailable() == isAvailable)
//                .count();
//    }
//
//    @Override
//    public Optional<Product> getCompanyProduct(String company) {
//        return productRepository
//                .findAll()
//                .stream()
//                .filter(p->p.getCompany().equals(company))
//                .findFirst();
//    }
//
//    @Override
//    public boolean areAllProductsAvailable() {
//        return productRepository
//                .findAll()
//                .stream()
//                .allMatch(Product::isAvailable);
//    }
//
//    @Override
//    public Optional<Product> getFirstProduct() {
//        return productRepository
//                .findAll()
//                .stream()
//                .findFirst();
//    }
//
//    @Override
//    public List<String> getAllCategories() {
//        return productRepository
//                .findAll()
//                .stream()
//                .map(Product::getCategory)
//                .distinct()
//                .toList();
//    }
//
//    @Override
//    public List<Product> getTopExpensiveProducts(int highestPrice) {
//        return productRepository
//                .findAll()
//                .stream()
//                .filter(p->p.getMaxRetailPrice()>highestPrice)
//                .toList();
//    }
//
//    @Override
//    public List<Product> getProductsOrderByPriceAsc() {
//        return productRepository
//                .findAll()
//                .stream()
//                .sorted((Comparator.comparingInt(Product::getMaxRetailPrice)))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Product> getProductsByNameInDesc() {
//        return productRepository
//                .findAll()
//                .stream()
//                .sorted(Comparator.comparing(Product::getName).reversed())
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public double getSumOfAllProductPrices(){
//        return productRepository
//                .findAll()
//                .stream()
//                .mapToInt(Product::getMaxRetailPrice)
//                .sum();
//    }
//
//    @Override
//    public double getTotalPriceAfterDiscount(int id) {
//        return productRepository
//                .findAll()
//                .stream()
//                .filter(p->p.getId() == id)
//                .findFirst()
//                .map(p->p.getMaxRetailPrice()-(p.getMaxRetailPrice()*p.getDiscountPercentage()/100.0))
//                .orElse(0.0);
//    }
//
//    @Override
//    public List<Product> getAllProductsByManufacturedYear(int manufacturedYear) {
//        return productRepository
//                .findAll()
//                .stream()
//                .filter(p->p.getManufacturedYear() > manufacturedYear)
//                .toList();
//    }
//
//    @Override
//    public List<Product> getAllProductsAvailableByPrice(int maxRetailPrice) {
//        return productRepository
//                .findAll()
//                .stream()
//                .filter(p->p.isAvailable() && p.getMaxRetailPrice() > maxRetailPrice)
//                .toList();
//    }
//
//    @Override
//    public Map<String, Long> getProductCountByCategory() {
//        return productRepository
//                .findAll()
//                .stream()
//                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
//    }
//
//    @Override
//    public Map<String, List<Product>> getAllProductsGroupByCategory() {
//        return productRepository
//                .findAll()
//                .stream()
//                .collect(Collectors.groupingBy(Product::getCategory));
//    }
//
//    @Override
//    public Map<String, List<Product>> getAllProductsGroupByCompany() {
//        return productRepository
//                .findAll()
//                .stream()
//                .collect(Collectors.groupingBy(Product::getCompany));
//    }
//
//    @Override
//    public Map<Boolean, List<Product>> getProductsByAvailability() {
//        return productRepository
//                .findAll()
//                .stream()
//                .collect(Collectors.partitioningBy(Product::isAvailable));
//    }
//
//    @Override
//    public Product getExpensiveProduct() {
//        return productRepository
//                .findAll()
//                .stream()
//                .max(Comparator.comparingInt(Product::getMaxRetailPrice))
//                .orElse(null);
//    }
//
//    @Override
//    public Product getCheapProduct() {
//        return productRepository
//                .findAll()
//                .stream()
//                .min(Comparator.comparingInt(Product::getMaxRetailPrice))
//                .orElse(null);
//    }
//
//    @Override
//    public Map<Integer, Product> getProductsWithId() {
//        return productRepository
//                .findAll()
//                .stream()
//                .collect(Collectors.toMap(Product::getId, product -> product));
//    }
//
//    @Override
//    public Map<String, Double> getAveragePriceByCategory() {
//        return productRepository
//                .findAll()
//                .stream()
//                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getMaxRetailPrice)));
//    }
//
//    @Override
//    public Map<String, List<Product>> getTopExpProductByCategory() {
//        return productRepository
//                .findAll()
//                .stream()
//                .collect(
//                        Collectors.groupingBy(
//                                Product::getCategory,
//                                Collectors.collectingAndThen(
//                                        Collectors.toList(),
//                                        products -> products.stream()
//                                                .sorted(
//                                                        Comparator.comparingInt(Product::getMaxRetailPrice)
//                                                                .reversed()
//                                                )
//                                                .limit(3)
//                                                .toList()
//                                )
//                        )
//                );
//    }

    //CRUD implementations

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        Product product = productRepository.findById(id);

        if (product == null) {
            throw new RuntimeException("Product not found with id: " + id);
        }

        return product;
    }

    @Override
    public Product updateProduct(int id, Product product) {
        Product existingProduct = productRepository.findById(id);

        if (existingProduct == null) {
            throw new RuntimeException("Product not found with id: " + id);
        }

        existingProduct.setName(product.getName());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setCompany(product.getCompany());
        existingProduct.setMaxRetailPrice(product.getMaxRetailPrice());
        existingProduct.setDiscountPercentage(product.getDiscountPercentage());
        existingProduct.setManufacturedYear(product.getManufacturedYear());
        existingProduct.setAvailable(product.isAvailable());

        return existingProduct;
    }

    @Override
    public void deleteProduct(int id) {
        Product existingProduct = productRepository.findById(id);

        if (existingProduct == null) {
            throw new RuntimeException("Product not found with id: " + id);
        }

        productRepository.deleteById(id);
    }
}
