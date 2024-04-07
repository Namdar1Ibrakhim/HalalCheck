package com.example.halalcheck.repository;

import com.example.halalcheck.entity.CompanyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyTypeRepository extends JpaRepository<CompanyType, Long> {
}
