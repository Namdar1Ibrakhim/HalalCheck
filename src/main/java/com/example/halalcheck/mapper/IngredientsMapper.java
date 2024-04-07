package com.example.halalcheck.mapper;

import com.example.halalcheck.dto.response.IngredientsResponseDto;
import com.example.halalcheck.entity.Ingredients;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IngredientsMapper extends Mappable<Ingredients, IngredientsResponseDto>{
}
