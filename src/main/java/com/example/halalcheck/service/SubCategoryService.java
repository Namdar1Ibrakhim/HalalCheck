package com.example.halalcheck.service;

import com.example.halalcheck.dto.response.CategoryResponseDto;
import com.example.halalcheck.dto.response.ProductResponseDto;
import com.example.halalcheck.dto.response.SubCategoryResponseDto;

import java.util.List;

public interface SubCategoryService {

    List<SubCategoryResponseDto> getAll();

    SubCategoryResponseDto getById(Long id);

    List<ProductResponseDto> getProductsBySubCategoryId(Long id);

    CategoryResponseDto getCategoryBySubCategoryId(Long id);
}
