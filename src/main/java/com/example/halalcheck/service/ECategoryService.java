package com.example.halalcheck.service;

import com.example.halalcheck.dto.response.AdditivesResponseDto;
import com.example.halalcheck.dto.response.ECategoryResponseDto;

import java.util.List;

public interface ECategoryService {

    List<ECategoryResponseDto> getAll();

    ECategoryResponseDto getById(Long id);

    List<AdditivesResponseDto> getAdditivesByECategory(Long id);
}
