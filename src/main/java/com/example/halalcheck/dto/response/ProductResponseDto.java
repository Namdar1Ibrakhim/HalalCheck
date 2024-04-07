package com.example.halalcheck.dto.response;

import com.example.halalcheck.entity.*;
import com.example.halalcheck.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class ProductResponseDto {

    private Long id;

    private String name;

    private String barcode;

    private String storage;

    private String company;

    private Country originCountry;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Category category;

    private SubCategory subCategory;

    private String imageUrl;

    private List<Additives> additives;

    private List<Ingredients> ingredients;


}
