package com.example.halalcheck.controller;


import com.example.halalcheck.dto.response.AdditivesResponseDto;
import com.example.halalcheck.dto.response.CountryResponseDto;
import com.example.halalcheck.dto.response.ECategoryResponseDto;
import com.example.halalcheck.entity.Additives;
import com.example.halalcheck.service.ECategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ecategory")
public class ECategoryController {

    private final ECategoryService eCategoryService;

    @GetMapping("/getAll")
    public ResponseEntity<List<ECategoryResponseDto>> getAll(){
        return ResponseEntity.ok(eCategoryService.getAll());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ECategoryResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(eCategoryService.getById(id));
    }

    @GetMapping("/getAdditivesByECategoryId/{id}")
    public ResponseEntity<List<AdditivesResponseDto>> getAdditivesByECategory(@PathVariable Long id){
        return ResponseEntity.ok(eCategoryService.getAdditivesByECategory(id));
    }
}
