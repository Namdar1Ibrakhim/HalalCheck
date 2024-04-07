package com.example.halalcheck.repository;

import com.example.halalcheck.entity.Category;
import com.example.halalcheck.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    List<SubCategory> findByCategory(Category category);
}
