package com.example.halalcheck.mapper;

import com.example.halalcheck.dto.response.CompanyTypeResponseDto;
import com.example.halalcheck.entity.CompanyType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyTypeMapper extends Mappable<CompanyType, CompanyTypeResponseDto>{
}
