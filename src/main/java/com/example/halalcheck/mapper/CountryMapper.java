package com.example.halalcheck.mapper;

import com.example.halalcheck.dto.response.CountryResponseDto;
import com.example.halalcheck.entity.Country;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper extends Mappable<Country, CountryResponseDto>{
}
