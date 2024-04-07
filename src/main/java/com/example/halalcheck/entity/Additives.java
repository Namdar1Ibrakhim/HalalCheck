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
@Table(name = "additives")
public class Additives {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private ECategory eCategory;

//    @ManyToMany
//    private List<Product> products;
}
