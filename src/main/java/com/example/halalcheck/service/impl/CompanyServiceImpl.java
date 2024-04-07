package com.example.halalcheck.service.impl;

import com.example.halalcheck.dto.response.CompanyResponseDto;
import com.example.halalcheck.entity.Company;
import com.example.halalcheck.entity.Product;
import com.example.halalcheck.enums.Status;
import com.example.halalcheck.mapper.CompanyMapper;
import com.example.halalcheck.repository.CompanyRepository;
import com.example.halalcheck.service.CompanyService;
import com.example.halalcheck.service.ImageService;
import io.minio.errors.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public List<CompanyResponseDto> getAll() {
        List<Company> companyList = companyRepository.findAll();
        return companyMapper.toDtoList(companyList);
    }

    @Override
    public CompanyResponseDto getById(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() ->new EntityNotFoundException("Company not fount with id: " + id));
        return companyMapper.toDto(company);
    }

    @Override
    public List<CompanyResponseDto> getByStatus(Status status) {
        List<Company> companyList = companyRepository.findByStatus(status);
        return companyMapper.toDtoList(companyList);
    }

}
