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
    List<Weather> findWeatherByDate(@Param("date") String date);

    @Query("SELECT lc.locationCode FROM Weather w JOIN LocationCode lc ON w.city = lc.city")
    List<String> findLocationCodesByCity();

    @Query("Select w FROM Weather w WHERE w.date = :date AND w.city = :city")
    List<Weather> findWeatherByDateAndCity(@Param("date") String date, @Param("city") String city);
}
