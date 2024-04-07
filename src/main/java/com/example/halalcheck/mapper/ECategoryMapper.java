package com.example.halalcheck.mapper;

import com.example.halalcheck.dto.response.ECategoryResponseDto;
import com.example.halalcheck.entity.ECategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ECategoryMapper extends Mappable<ECategory, ECategoryResponseDto>{
}
