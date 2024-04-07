package com.example.halalcheck.repository;


import com.example.halalcheck.dto.response.ProductResponseDto;
import com.example.halalcheck.entity.Category;
import com.example.halalcheck.entity.Product;
import com.example.halalcheck.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(Category category);

    Product findByBarcode(String barcode);

    List<Product> findBySubCategory(SubCategory subCategory);

    @Query("SELECT p FROM Product p " +
            "WHERE (:name IS NULL OR p.name = :name) " +
            "AND (:barcode IS NULL OR p.barcode = :barcode) " +
            "AND (:originCountryId IS NULL OR p.originCountry.id = :originCountryId) " +
            "AND (:storage IS NULL OR p.storage = :storage) " +
            "AND (:company IS NULL OR p.company = :company) " +
            "AND (:imageUrl IS NULL OR p.imageUrl = :imageUrl) " +
            "AND (:categoryId IS NULL OR p.category.id = :categoryId) " +
            "AND (:subCategoryId IS NULL OR p.subCategory.id = :subCategoryId)")
    List<Product> findFilteredProducts(
            String name,
            String barcode,
            Long originCountryId,
            String storage,
            String company,
            String imageUrl,
            Long categoryId,
            Long subCategoryId
    );
}
