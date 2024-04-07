package com.example.halalcheck.controller;

import com.example.halalcheck.dto.response.CategoryResponseDto;
import com.example.halalcheck.dto.response.ProductResponseDto;
import com.example.halalcheck.dto.response.SubCategoryResponseDto;
import com.example.halalcheck.entity.Product;
import com.example.halalcheck.service.CategoryService;
import com.example.halalcheck.service.SubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subCategory")
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    @GetMapping("/getAll")
    public ResponseEntity<List<SubCategoryResponseDto>> getAll(){
        return ResponseEntity.ok(subCategoryService.getAll());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<SubCategoryResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(subCategoryService.getById(id));
    }

    @GetMapping("/getProductsByCategoryId/{id}")
    public ResponseEntity<List<ProductResponseDto>> getProductsByCategoryId(@PathVariable Long id){
        return ResponseEntity.ok(subCategoryService.getProductsBySubCategoryId(id));
    }

    @GetMapping("getCategoryBySubCategoryId/{id}")
    public ResponseEntity<CategoryResponseDto> getCategoryBySubCategoryId(@PathVariable Long id) {
        return ResponseEntity.ok(subCategoryService.getCategoryBySubCategoryId(id));
    }
}
