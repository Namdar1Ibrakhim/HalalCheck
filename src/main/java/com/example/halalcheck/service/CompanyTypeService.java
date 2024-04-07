package com.example.halalcheck.service;

import com.example.halalcheck.dto.response.CompanyResponseDto;
import com.example.halalcheck.dto.response.CompanyTypeResponseDto;
import com.example.halalcheck.enums.Status;

import java.util.List;

public interface CompanyTypeService {

    List<CompanyTypeResponseDto> getAll();

    CompanyTypeResponseDto getById(Long id);

    List<CompanyResponseDto> getCompaniesByCompanyType(Long id);
}
