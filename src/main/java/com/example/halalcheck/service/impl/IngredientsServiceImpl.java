package com.example.halalcheck.service.impl;

import com.example.halalcheck.dto.response.IngredientsResponseDto;
import com.example.halalcheck.entity.Additives;
import com.example.halalcheck.entity.Ingredients;
import com.example.halalcheck.enums.Status;
import com.example.halalcheck.mapper.IngredientsMapper;
import com.example.halalcheck.repository.IngredientsRepository;
import com.example.halalcheck.service.IngredientsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class IngredientsServiceImpl implements IngredientsService {

    private final IngredientsRepository ingredientsRepository;
    private final IngredientsMapper ingredientsMapper;

    @Override
    public List<IngredientsResponseDto> getAll() {
        List<Ingredients> ingredientsList = ingredientsRepository.findAll();
        return ingredientsMapper.toDtoList(ingredientsList);
    }

    @Override
    public IngredientsResponseDto getById(Long id) {
        Ingredients ingredient = ingredientsRepository.findById(id)
                .orElseThrow(() ->new EntityNotFoundException("Ingredients not fount with id: " + id));
        return ingredientsMapper.toDto(ingredient);
    }

    @Override
    public List<IngredientsResponseDto> getByStatus(Status status) {
        List<Ingredients> ingredientsList = ingredientsRepository.findByStatus(status);
        return ingredientsMapper.toDtoList(ingredientsList);
    }
}
