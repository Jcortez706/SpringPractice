package com.example.springtest.LocationCodeService;

import jakarta.persistence.*;

@Entity
@Table(name = "location_code")
public class LocationCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_location_code")
    private int locationCodeID = 0;

    @Column(name = "location_code", nullable = false)
    private String locationCode;

    @Column(name = "city", nullable = false)
    private String city;

    public LocationCode() {}

    public LocationCode(String locationCode, String city) {
        this.locationCode = locationCode;
        this.city = city;
    }

    @Override
    public String toString() {
        return locationCodeID + "," + locationCode;
    }

    public int getLocationCodeID() {
        return locationCodeID;
    }

    public void setLocationCodeID(int locationCodeID) {
        this.locationCodeID = locationCodeID;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
