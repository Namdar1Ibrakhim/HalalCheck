package com.example.halalcheck.controller;


import com.example.halalcheck.dto.response.AdditivesResponseDto;
import com.example.halalcheck.dto.response.ProductResponseDto;
import com.example.halalcheck.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/getById/{id}")
    public ResponseEntity<ProductResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getById(id));
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<ProductResponseDto>> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/products")
    public List<ProductResponseDto> filterProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String barcode,
            @RequestParam(required = false) Long originCountryId,
            @RequestParam(required = false) String storage,
            @RequestParam(required = false) String company,
            @RequestParam(required = false) String imageUrl,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) Long subCategoryId
    ) {
        return productService.filterProducts(name, barcode, originCountryId, storage, company, imageUrl, categoryId, subCategoryId);
    }


}
