package com.example.springtest.WeatherService;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "weather")
public class Weather {
    @Id
    @Column(name="id_weather")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idWeather = 0;

    @Column(name= "date", nullable = false)
    private LocalDate date;

    @Column(name= "description", nullable = false)
    private String description;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column (name = "country")
    private String country;

    public Weather(){}

    public Weather(int weatherID){
        this.setWeatherID(weatherID);
    }

    public void setWeatherID(int locationID) {
        this.idWeather = locationID;
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



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}