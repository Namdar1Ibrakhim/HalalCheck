package com.example.halalcheck.repository;

import com.example.halalcheck.entity.Ingredients;
import com.example.halalcheck.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredients, Long> {

    List<Ingredients> findByStatus(Status status);

}
