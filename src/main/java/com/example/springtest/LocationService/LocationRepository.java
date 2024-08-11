package com.example.springtest.LocationService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    @Query("SELECT l.locationID FROM Location l")
    List<Integer> findAllLocations();

    @Query("SELECT l FROM Location l WHERE l.city = :city")
    List<Location> findLocationByCity(@Param("city") String city);
}
