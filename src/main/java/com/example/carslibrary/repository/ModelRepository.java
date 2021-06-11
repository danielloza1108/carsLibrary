package com.example.carslibrary.repository;

import com.example.carslibrary.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {

    Model getAllById(Long makeId);

    @Query(value = "SELECT * FROM model WHERE name LIKE :name||'_%'", nativeQuery = true)
    List<Model> getByName(String name);

    List<Model> getAllByYearToLessThanEqual(int maxYear);

    List<Model> getAllByYearToGreaterThanEqual(int minYear);

    List<Model> getAllByMakeId(Long id);

    List<Model> getAllByYearFromGreaterThanEqual(int minYear);

    List<Model> getAllByYearFromLessThanEqual(int maxYear);

    List<Model> getAllByMakeIdAndYearFromGreaterThanEqualAndYearFromLessThanEqualOrYearToGreaterThanEqualAndYearToLessThanEqualAndMakeId(Long id,int yearFromMin, int yearFromMax, int yearToMin, int yearToMax, Long id2);

}
