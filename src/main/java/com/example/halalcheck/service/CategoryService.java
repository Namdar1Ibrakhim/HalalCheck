package com.example.halalcheck.service;

import com.example.halalcheck.dto.response.CategoryResponseDto;
import com.example.halalcheck.dto.response.ProductResponseDto;
import com.example.halalcheck.dto.response.SubCategoryResponseDto;

import java.util.List;

public interface CategoryService {

    List<CategoryResponseDto> getAll();

    CategoryResponseDto getById(Long id);

    List<ProductResponseDto> getProductsByCategoryId(Long categoryId);

    List<SubCategoryResponseDto> getSubCategoriesByCategoryId(Long categoryId);
}
