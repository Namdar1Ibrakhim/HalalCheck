package com.example.halalcheck.service;

import com.example.halalcheck.dto.response.CategoryResponseDto;
import com.example.halalcheck.dto.response.CompanyResponseDto;
import com.example.halalcheck.dto.response.ProductResponseDto;
import com.example.halalcheck.dto.response.SubCategoryResponseDto;
import com.example.halalcheck.entity.Product;
import com.example.halalcheck.enums.Status;
import io.minio.errors.*;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface CompanyService {

    List<CompanyResponseDto> getAll();

    CompanyResponseDto getById(Long id);

    List<CompanyResponseDto> getByStatus(Status status);

}
