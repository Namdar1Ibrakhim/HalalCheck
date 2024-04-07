package com.example.halalcheck.entity;


import com.example.halalcheck.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.Image;
import java.util.Date;


@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String enterpriceName;

    private String brandName;

    private String typeOfBusiness;

    private Date dateOfReceipt;

    private Date deadlineDate;

    private String region;

    private String controller;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private CompanyType companyType;

    private String imageUrl;

    private String certificateUrl;

    private String address;

    private String certifiedBy;

    private String lng;

    private String lat;




}
