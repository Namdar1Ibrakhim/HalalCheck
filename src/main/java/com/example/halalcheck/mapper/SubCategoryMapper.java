package com.example.halalcheck.mapper;

import com.example.halalcheck.dto.response.SubCategoryResponseDto;
import com.example.halalcheck.entity.SubCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubCategoryMapper extends Mappable<SubCategory, SubCategoryResponseDto>{
}
