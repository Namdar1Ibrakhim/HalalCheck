package com.example.halalcheck.repository;

import com.example.halalcheck.entity.Company;
import com.example.halalcheck.entity.CompanyType;
import com.example.halalcheck.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findByStatus(Status status);

    List<Company> findAllByCompanyType(CompanyType companyType);
}
