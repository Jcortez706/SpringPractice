package com.example.springtest.LocationCodeService;

import jakarta.persistence.*;

@Entity
@Table(name = "location_code")
public class LocationCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_location_code")
    private int locationCodeID = 0;

    @Column(name= "location_code", nullable = false)
    private String locationCode;

    public LocationCode(){}
    public LocationCode(int locationCodeID){
        this.setLocationCodeID(locationCodeID);
    }
    @Override
    public String toString(){
        return locationCodeID+","+locationCode;
    }
    public Integer getLocationCodeID(){
        return locationCodeID;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCodeID(int locationCodeID) {
        this.locationCodeID = locationCodeID;
    }

}
