package com.example.halalcheck.service;

import com.example.halalcheck.dto.response.IngredientsResponseDto;
import com.example.halalcheck.enums.Status;

import java.util.List;

public interface IngredientsService {

    List<IngredientsResponseDto> getAll();

    IngredientsResponseDto getById(Long id);

    List<IngredientsResponseDto> getByStatus(Status status);
}
