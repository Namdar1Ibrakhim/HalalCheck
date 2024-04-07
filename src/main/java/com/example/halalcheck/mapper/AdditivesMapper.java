package com.example.halalcheck.mapper;

import com.example.halalcheck.dto.request.AdditivesRequestDto;
import com.example.halalcheck.dto.response.AdditivesResponseDto;
import com.example.halalcheck.entity.Additives;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdditivesMapper extends Mappable<Additives, AdditivesResponseDto>{

}