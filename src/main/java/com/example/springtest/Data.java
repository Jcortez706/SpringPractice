package com.example.springtest;

import jakarta.persistence.*;

@Entity
@Table(name = "data")
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int iddata = 0;

    @Column(name= "datacol", nullable = false)
    private int datacol;

    public Data(){}
    public Data(int datacol){
        this.setDatacol(datacol);
    }


    @Override
    public String toString() {
        return "Data{iddata=" + iddata + ", datacol=" + datacol + "}";
    }


    public int getIddata() {
        return iddata;
    }

    public void setIddata(int iddata) {
        this.iddata = iddata;
    }

    public int getDatacol() {
        return datacol;
    }

    public void setDatacol(int datacol) {
        this.datacol = datacol;
    }
}
