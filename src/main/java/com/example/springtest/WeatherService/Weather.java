package com.example.springtest.WeatherService;

import com.example.springtest.LocationService.Location;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "weather")
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int weatherID = 0;

    @Column(name= "date", nullable = false)
    private LocalDate date;

    @Column(name= "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_location_code")
    private Location locationID;

    public Weather(){}

    public Weather(int weatherID){
        this.setWeatherID(weatherID);
    }

    public void setWeatherID(int locationID) {
        this.weatherID = locationID;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getLocationID() {
        return locationID;
    }

    public void setLocationID(Location locationID) {
        this.locationID = locationID;
    }
}