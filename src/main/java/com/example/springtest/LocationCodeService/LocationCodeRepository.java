package com.example.springtest.LocationCodeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface LocationCodeRepository extends JpaRepository<LocationCode, Integer> {
    @Query("SELECT l.locationCodeID FROM LocationCode l")
    List<Integer> findAllLocations();

}
