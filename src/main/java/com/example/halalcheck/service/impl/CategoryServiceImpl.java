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
import com.example.halalcheck.service.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final SubCategoryMapper subCategoryMapper;
    private final SubCategoryRepository subCategoryRepository;

    @Override
    public List<CategoryResponseDto> getAll() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryMapper.toDtoList(categoryList);
    }

    @Override
    public CategoryResponseDto getById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->new EntityNotFoundException("Category not fount with id: " + id));
        return categoryMapper.toDto(category);
    }

    @Override
    public List<ProductResponseDto> getProductsByCategoryId(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->new EntityNotFoundException("Category not fount with id: " + id));
        List<Product> productList = productRepository.findByCategory(category);
        return productMapper.toDtoList(productList);
    }

    @Override
    public List<SubCategoryResponseDto> getSubCategoriesByCategoryId(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->new EntityNotFoundException("Category not fount with id: " + id));

        List<SubCategory> subCategoryList = subCategoryRepository.findByCategory(category);
        return subCategoryMapper.toDtoList(subCategoryList);
    }


}
