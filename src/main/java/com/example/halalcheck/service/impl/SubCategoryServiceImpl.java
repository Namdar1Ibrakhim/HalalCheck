package com.example.halalcheck.service.impl;

import com.example.halalcheck.dto.response.CategoryResponseDto;
import com.example.halalcheck.dto.response.ProductResponseDto;
import com.example.halalcheck.dto.response.SubCategoryResponseDto;
import com.example.halalcheck.entity.Category;
import com.example.halalcheck.entity.Product;
import com.example.halalcheck.entity.SubCategory;
import com.example.halalcheck.mapper.CategoryMapper;
import com.example.halalcheck.mapper.ProductMapper;
import com.example.halalcheck.mapper.SubCategoryMapper;
import com.example.halalcheck.repository.CategoryRepository;
import com.example.halalcheck.repository.ProductRepository;
import com.example.halalcheck.repository.SubCategoryRepository;
import com.example.halalcheck.service.SubCategoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubCategoryServiceImpl implements SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;
    private final SubCategoryMapper subCategoryMapper;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<SubCategoryResponseDto> getAll() {
        List<SubCategory> subCategoryList = subCategoryRepository.findAll();
        return subCategoryMapper.toDtoList(subCategoryList);
    }

    @Override
    public SubCategoryResponseDto getById(Long id) {
        SubCategory subCategory = subCategoryRepository.findById(id)
                .orElseThrow(() ->new EntityNotFoundException("Category not fount with id: " + id));
        return subCategoryMapper.toDto(subCategory);
    }

    @Override
    public List<ProductResponseDto> getProductsBySubCategoryId(Long id) {
        SubCategory subCategory = subCategoryRepository.findById(id)
                .orElseThrow(() ->new EntityNotFoundException("Category not fount with id: " + id));
        List<Product> productList = productRepository.findBySubCategory(subCategory);
        return productMapper.toDtoList(productList);
    }

    @Override
    public CategoryResponseDto getCategoryBySubCategoryId(Long id) {
        SubCategory subCategory = subCategoryRepository.findById(id)
                .orElseThrow(() ->new EntityNotFoundException("Category not fount with id: " + id));

        Category category = categoryRepository.findById(subCategory.getCategory().getId())
                .orElseThrow(() ->new EntityNotFoundException("Category not fount with id: " + id));
        return categoryMapper.toDto(category);

    }
}
