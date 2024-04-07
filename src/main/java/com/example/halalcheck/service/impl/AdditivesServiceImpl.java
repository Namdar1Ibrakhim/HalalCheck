package com.example.halalcheck.service.impl;

import com.example.halalcheck.dto.response.AdditivesResponseDto;
import com.example.halalcheck.entity.Additives;
import com.example.halalcheck.mapper.AdditivesMapper;
import com.example.halalcheck.repository.AdditivesRepository;
import com.example.halalcheck.service.AdditivesService;
import com.example.halalcheck.enums.Status;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class AdditivesServiceImpl implements AdditivesService {

    private final AdditivesRepository additivesRepository;
    private final AdditivesMapper additivesMapper;

    @Override
    public List<AdditivesResponseDto> getAll() {
        List<Additives> additivesList = additivesRepository.findAll();
        return additivesMapper.toDtoList(additivesList);
    }

    @Override
    public AdditivesResponseDto getById(Long id) {
        Additives additive = additivesRepository.findById(id)
                .orElseThrow(() ->new EntityNotFoundException("Additives not fount with id: " + id));
        return additivesMapper.toDto(additive);
    }

    @Override
    public List<AdditivesResponseDto> getByStatus(Status status) {
        List<Additives> additivesList = additivesRepository.findByStatus(status);
        return additivesMapper.toDtoList(additivesList);
    }

}
