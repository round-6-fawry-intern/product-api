package com.product.product_services.repository;

import com.product.product_services.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("SELECT p FROM Product p WHERE p.createdAt BETWEEN :startDate AND :endDate")
    List<Product> findProductsCreatedBetween
            (@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    @Query("SELECT p FROM Product p WHERE p.updatedAt BETWEEN :startDate AND :endDate")
    List<Product> findProductsUpdatedBetween
            (@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    List<Product> findByCategory(String category);

    List<Product> findByIdIn(List<Long> ids );
}
