package com.example.springtest;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRepository extends JpaRepository<Data, Integer> {
    @Query("SELECT d.datacol FROM Data d")
    List<Integer> findAllDatacol();

    @Query("DELETE FROM Data d where d.datacol = :datacol")
    @Transactional
    @Modifying
    int deleteData(int datacol);

    @Query("UPDATE Data d SET d.datacol = :newDatacol WHERE d.id = :id")
    @Transactional
    @Modifying
    int updataDatacolByID(int id, int newDatacol);

}
