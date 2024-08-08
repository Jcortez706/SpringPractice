package com.example.springtest;

import jakarta.persistence.*;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int locationID = 0;

    @Column(name= "city", nullable = false)
    private String city;
    @Column(name= "state", nullable = true)
    private String state;
    @Column(name= "country", nullable = false)
    private String country;
    @Column(name= "location_code", nullable = false)
    private String location_code;

    public Location(){}
    public Location(int locationID){
        this.setLocationID(locationID);
    }
    @Override
    public String toString(){
        return locationID+","+city+","+state+","+country+","+location_code;
    }



    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    //GETTER & SETTERS
    public int getLocationID() {
        return locationID;
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

    public String getLocation_code() {
        return location_code;
    }

    public void setLocation_code(String location_code) {
        this.location_code = location_code;
    }
}
