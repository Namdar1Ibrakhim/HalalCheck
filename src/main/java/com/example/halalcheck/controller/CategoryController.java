package com.example.halalcheck.controller;

import com.example.halalcheck.dto.response.AdditivesResponseDto;
import com.example.halalcheck.dto.response.CategoryResponseDto;
import com.example.halalcheck.dto.response.ProductResponseDto;
import com.example.halalcheck.dto.response.SubCategoryResponseDto;
import com.example.halalcheck.entity.SubCategory;
import com.example.halalcheck.enums.Status;
import com.example.halalcheck.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryResponseDto>> getAll(){
        return ResponseEntity.ok(categoryService.getAll());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<CategoryResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.getById(id));
    }

    @GetMapping("/getProductsByCategoryId/{id}")
    public ResponseEntity<List<ProductResponseDto>> getProductsByCategoryId(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.getProductsByCategoryId(id));
    }

    @GetMapping("getSubCategoriesByCategoryId/{id}")
    public ResponseEntity<List<SubCategoryResponseDto>> getSubCategoriesByCategoryId(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getSubCategoriesByCategoryId(id));
    }

}
