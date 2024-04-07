package com.example.halalcheck.mapper;

import com.example.halalcheck.dto.response.CompanyResponseDto;
import com.example.halalcheck.entity.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper extends Mappable<Company, CompanyResponseDto>{
}
