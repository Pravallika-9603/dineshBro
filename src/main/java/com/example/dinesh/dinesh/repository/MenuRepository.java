package com.example.dinesh.dinesh.repository;

import com.example.dinesh.dinesh.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<MenuItem, Long> {

    @Query("SELECT m FROM MenuItem m WHERE m.category.categoryname = :categoryName")
    List<MenuItem> findByCategoryName(@Param("categoryName") String categoryName);

}
