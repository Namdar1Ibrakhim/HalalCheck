package com.example.halalcheck.repository;

import com.example.halalcheck.entity.Additives;
import com.example.halalcheck.entity.ECategory;
import com.example.halalcheck.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdditivesRepository extends JpaRepository<Additives, Long>{

    List<Additives> findByStatus(Status status);

    @Query("SELECT a FROM Additives a WHERE a.eCategory.id = :ecategoryId")
    List<Additives> findAdditivesByECategory(Long ecategoryId);
}
