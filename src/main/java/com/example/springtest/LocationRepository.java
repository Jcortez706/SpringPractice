package com.example.springtest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    @Query("SELECT l.locationID FROM location l")
    List<Integer> findAllLocations();

    @Query("SELECT l FROM location l WHERE l.city = :city")
    List<Location> findLocationByCity(@Param("city") String city);

//    @Query("DELETE FROM Data d where d.datacol = :datacol")
//    @Transactional
//    @Modifying
//    int deleteData(int datacol);
//
//    @Query("UPDATE Data d SET d.datacol = :newDatacol WHERE d.id = :id")
//    @Transactional
//    @Modifying
//    int updataDatacolByID(int id, int newDatacol);

}
