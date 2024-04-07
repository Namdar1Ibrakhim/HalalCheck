package com.example.halalcheck.service.impl;

import com.example.halalcheck.dto.response.ProductResponseDto;
import com.example.halalcheck.entity.Product;
import com.example.halalcheck.mapper.ProductMapper;
import com.example.halalcheck.repository.ProductRepository;
import com.example.halalcheck.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponseDto getById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not fount with id: " + id));
        return productMapper.toDto(product);
    }

    @Override
    public List<ProductResponseDto> getAll() {
        List<Product> companyList = productRepository.findAll();
        return productMapper.toDtoList(companyList);
    }


    public List<ProductResponseDto> filterProducts(
            String name,
            String barcode,
            Long originCountryId,
            String storage,
            String company,
            String imageUrl,
            Long categoryId,
            Long subCategoryId
    ) {
        List<Product> productList = productRepository.findFilteredProducts(name, barcode, originCountryId, storage, company, imageUrl, categoryId, subCategoryId);
        return productMapper.toDtoList(productList);
    }

}