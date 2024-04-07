package com.example.halalcheck.service;

import com.example.halalcheck.dto.response.ProductResponseDto;

import java.util.List;

public interface ProductService {

    ProductResponseDto getById(Long id);

    List<ProductResponseDto> getAll();

    List<ProductResponseDto> filterProducts(String name, String barcode, Long originCountryId, String storage, String company, String imageUrl, Long categoryId, Long subCategoryId);
}
