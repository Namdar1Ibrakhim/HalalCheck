package com.example.halalcheck.dto.response;

import com.example.halalcheck.entity.CompanyType;
import com.example.halalcheck.enums.Status;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.Date;

@Data
public class CompanyResponseDto {

    private Long id;

    private String enterpriceName;

    private String brandName;

    private String typeOfBusiness;

    private Date dateOfReceipt;

    private Date deadlineDate;

    private String region;

    private String controller;

    private Status status;

    private CompanyType companyType;

    private String imageUrl;

    private String certificateUrl;

    private String certifiedBy;

    private String lng;

    private String lat;


}
