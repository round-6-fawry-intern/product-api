package com.product.product_services.service;

import com.product.product_services.model.Product;
import com.product.product_services.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
    public Product updateProduct(Long id, Product productDetails) {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(productDetails.getName());
            product.setDescription(productDetails.getDescription());
            product.setCategory(productDetails.getCategory());
            product.setPrice(productDetails.getPrice());
            product.setQuantity(productDetails.getQuantity());
            product.setImageUrl(productDetails.getImageUrl()); // new

            return productRepository.save(product);
        } else {
            throw new RuntimeException("Product not found with id: " + id);
        }
    }

    public List<Product> findProductsCreatedBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return productRepository.findProductsCreatedBetween(startDate, endDate);
    }

    public List<Product> findProductsUpdatedBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return productRepository.findProductsUpdatedBetween(startDate, endDate);
    }
    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public List<Product> findProductsByIds(List<Long> ids ){
        return productRepository.findByIdIn(ids);
    }
}