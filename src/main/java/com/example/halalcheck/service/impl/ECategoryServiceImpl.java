package com.example.halalcheck.service.impl;

import com.example.halalcheck.dto.response.AdditivesResponseDto;
import com.example.halalcheck.dto.response.ECategoryResponseDto;
import com.example.halalcheck.entity.Additives;
import com.example.halalcheck.entity.ECategory;
import com.example.halalcheck.mapper.AdditivesMapper;
import com.example.halalcheck.mapper.ECategoryMapper;
import com.example.halalcheck.repository.AdditivesRepository;
import com.example.halalcheck.repository.ECategoryRepository;
import com.example.halalcheck.service.ECategoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ECategoryServiceImpl implements ECategoryService {

    private final ECategoryRepository eCategoryRepository;
    private final ECategoryMapper eCategoryMapper;
    private final AdditivesMapper additivesMapper;
    private AdditivesRepository additivesRepository;

    @Override
    public List<ECategoryResponseDto> getAll() {
        List<ECategory> ecategoryList = eCategoryRepository.findAll();
        return eCategoryMapper.toDtoList(ecategoryList);
    }

    @Override
    public ECategoryResponseDto getById(Long id) {
        ECategory ecategory = eCategoryRepository.findById(id)
                .orElseThrow(() ->new EntityNotFoundException("Category not fount with id: " + id));
        return eCategoryMapper.toDto(ecategory);
    }

    @Override
    public List<AdditivesResponseDto> getAdditivesByECategory(Long id) {
        ECategory ecategory = eCategoryRepository.findById(id)
                .orElseThrow(() ->new EntityNotFoundException("Category not fount with id: " + id));

        List<Additives> additivesList = additivesRepository.findAdditivesByECategory(ecategory.getId());
        return additivesMapper.toDtoList(additivesList);

    }
}
