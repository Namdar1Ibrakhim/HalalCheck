package com.example.halalcheck.service.impl;

import com.example.halalcheck.dto.response.CompanyResponseDto;
import com.example.halalcheck.dto.response.CompanyTypeResponseDto;
import com.example.halalcheck.entity.Company;
import com.example.halalcheck.entity.CompanyType;
import com.example.halalcheck.mapper.CompanyMapper;
import com.example.halalcheck.mapper.CompanyTypeMapper;
import com.example.halalcheck.repository.CompanyRepository;
import com.example.halalcheck.repository.CompanyTypeRepository;
import com.example.halalcheck.service.CompanyTypeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompanyTypeServiceImpl implements CompanyTypeService {

    private final CompanyTypeRepository companyTypeRepository;
    private final CompanyTypeMapper companyTypeMapper;
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public List<CompanyTypeResponseDto> getAll() {
        List<CompanyType> companyTypeList = companyTypeRepository.findAll();
        return companyTypeMapper.toDtoList(companyTypeList);
    }

    @Override
    public CompanyTypeResponseDto getById(Long id) {
        CompanyType companyType = companyTypeRepository.findById(id)
                .orElseThrow(() ->new EntityNotFoundException("CompanyType not fount with id: " + id));
        return companyTypeMapper.toDto(companyType);
    }

    @Override
    public List<CompanyResponseDto> getCompaniesByCompanyType(Long id) {
        CompanyType companyType = companyTypeRepository.findById(id)
                .orElseThrow(() ->new EntityNotFoundException("CompanyType not fount with id: " + id));

        List<Company> companyList = companyRepository.findAllByCompanyType(companyType);
        return companyMapper.toDtoList(companyList);
    }
}
