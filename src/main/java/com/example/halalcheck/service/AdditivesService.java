package com.example.halalcheck.service;

import com.example.halalcheck.dto.response.AdditivesResponseDto;
import com.example.halalcheck.enums.Status;

import java.util.List;

public interface AdditivesService {

    List<AdditivesResponseDto> getAll();

    AdditivesResponseDto getById(Long id);

    List<AdditivesResponseDto> getByStatus(Status status);


}
