package com.example.halalcheck.mapper;

import com.example.halalcheck.dto.response.CategoryResponseDto;
import com.example.halalcheck.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends Mappable<Category, CategoryResponseDto>{
}
