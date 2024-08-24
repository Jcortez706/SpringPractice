package com.example.springtest.WeatherService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {
    @Query("SELECT w.idWeather FROM Weather w")
    List<Integer> findAllWeather();

    @Query("SELECT w FROM Weather w WHERE w.date = :date")
    List<Weather> findWeatherByDate(@Param("date") LocalDate date);
}
