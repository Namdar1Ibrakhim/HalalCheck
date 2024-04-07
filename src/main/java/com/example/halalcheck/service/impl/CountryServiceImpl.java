package com.example.halalcheck.service.impl;

import com.example.halalcheck.dto.response.CategoryResponseDto;
import com.example.halalcheck.dto.response.CountryResponseDto;
import com.example.halalcheck.entity.Category;
import com.example.halalcheck.entity.Country;
import com.example.halalcheck.mapper.CountryMapper;
import com.example.halalcheck.repository.CountryRepository;
import com.example.halalcheck.service.CountryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    @Override
    public List<CountryResponseDto> getAll() {
        List<Country> categoryList = countryRepository.findAll();
        return countryMapper.toDtoList(categoryList);
    }

    @Override
    public CountryResponseDto getById(Long id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() ->new EntityNotFoundException("Category not fount with id: " + id));
        return countryMapper.toDto(country);
    }
}
