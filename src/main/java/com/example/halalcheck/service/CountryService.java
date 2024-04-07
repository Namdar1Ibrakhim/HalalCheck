package com.example.halalcheck.service;

import com.example.halalcheck.dto.response.CountryResponseDto;

import java.util.List;

public interface CountryService {

    List<CountryResponseDto> getAll();

    CountryResponseDto getById(Long id);
}
