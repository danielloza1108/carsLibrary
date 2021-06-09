package com.example.carslibrary.repository;

import com.example.carslibrary.entity.Make;
import com.example.carslibrary.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
    Model getAllById(Long makeId);

    @Query(value = "SELECT * FROM model WHERE id_make = :id", nativeQuery = true)
    List<Model> getAllByMakeId(@Param("id") Long id);

    @Query(value = "SELECT * FROM model WHERE name LIKE :name||'_%'", nativeQuery = true)
    List<Model> getByName(String name);

    @Query(value = "SELECT * FROM model WHERE year_from >= :minYear", nativeQuery = true)
    List<Model> getAllFromModelYearMin(@Param("minYear") int minYear);

    @Query(value = "SELECT * FROM model WHERE year_from <= :maxYear", nativeQuery = true)
    List<Model> getAllFromModelYearMax(@Param("maxYear") int maxYear);

    @Query(value = "SELECT * FROM model WHERE year_to >= :minYear", nativeQuery = true)
    List<Model> getAllToModelYearMin(@Param("minYear") int minYear);

    @Query(value = "SELECT * FROM model WHERE year_to <= :maxYear", nativeQuery = true)
    List<Model> getAllToModelYearMax(@Param("maxYear") int maxYear);
}
