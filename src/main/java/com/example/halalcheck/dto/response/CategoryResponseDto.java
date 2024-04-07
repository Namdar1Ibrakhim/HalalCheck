package com.example.halalcheck.dto.response;

import com.example.halalcheck.entity.Product;
import com.example.halalcheck.entity.SubCategory;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class CategoryResponseDto {

    private Long id;

    private String name;

    private String description;

}
