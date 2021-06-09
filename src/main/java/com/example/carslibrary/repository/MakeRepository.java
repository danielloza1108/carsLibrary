package com.example.carslibrary.repository;

import com.example.carslibrary.entity.Make;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MakeRepository extends JpaRepository<Make, Long> {
    Make getAllById(Long id);

    @Query(value = "SELECT * FROM make", nativeQuery = true)
    List<Make> getAll();
}
