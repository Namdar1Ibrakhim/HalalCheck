package com.example.halalcheck.entity;

import com.example.halalcheck.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String barcode;

    @ManyToMany
    private List<Additives> additives;

    @ManyToMany
    private List<Ingredients> ingredients;

    private String storage;

    private String company;

    @ManyToOne
    @JoinColumn(name = "origin_country_id")
    private Country originCountry;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String imageUrl;

    private Boolean certified;

    @OneToOne
    private Certificate certificate;

    @ManyToOne
    private Category category;

    @ManyToOne
    private SubCategory subCategory;

}
