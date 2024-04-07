package com.example.halalcheck.controller;

import com.example.halalcheck.dto.response.CompanyResponseDto;
import com.example.halalcheck.dto.response.CountryResponseDto;
import com.example.halalcheck.repository.CountryRepository;
import com.example.halalcheck.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/getAll")
    public ResponseEntity<List<CountryResponseDto>> getAll(){
        return ResponseEntity.ok(countryService.getAll());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<CountryResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(countryService.getById(id));
    }
}
