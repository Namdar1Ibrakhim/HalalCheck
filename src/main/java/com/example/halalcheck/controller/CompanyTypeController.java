package com.example.halalcheck.controller;


import com.example.halalcheck.dto.response.CompanyResponseDto;
import com.example.halalcheck.dto.response.CompanyTypeResponseDto;
import com.example.halalcheck.enums.Status;
import com.example.halalcheck.service.CompanyTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companyType")
public class CompanyTypeController {

    private final CompanyTypeService companyTypeService;

    @GetMapping("/getAll")
    public ResponseEntity<List<CompanyTypeResponseDto>> getAll(){
        return ResponseEntity.ok(companyTypeService.getAll());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<CompanyTypeResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(companyTypeService.getById(id));
    }

    @GetMapping("/getCompaniesByCompanyType/{id}")
    public ResponseEntity<List<CompanyResponseDto>> getCompaniesByCompanyType(@PathVariable Long id) {
        return ResponseEntity.ok(companyTypeService.getCompaniesByCompanyType(id));
    }
}
