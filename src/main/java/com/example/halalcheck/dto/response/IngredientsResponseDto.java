package com.example.halalcheck.dto.response;

import com.example.halalcheck.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class IngredientsResponseDto {

    private Long id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;
}
