package com.example.halalcheck.controller;

import com.example.halalcheck.dto.response.CompanyResponseDto;
import com.example.halalcheck.enums.Status;
import com.example.halalcheck.service.CompanyService;
import io.minio.errors.*;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/getAll")
    public ResponseEntity<List<CompanyResponseDto>> getAll(){
        return ResponseEntity.ok(companyService.getAll());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<CompanyResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(companyService.getById(id));
    }

    @GetMapping("/getByStatus")
    public ResponseEntity<List<CompanyResponseDto>> getByStatus(@RequestParam Status status){
        return ResponseEntity.ok(companyService.getByStatus(status));
    }
}
