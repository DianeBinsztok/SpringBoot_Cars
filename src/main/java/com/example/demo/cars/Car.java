package com.example.demo.cars;
import com.fasterxml.jackson.databind.annotation.JsonAppend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String model;
    private  String brand;
    private  String color;


    public Car(int id, String model, String brand, String color) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.color = color;
    }

    public Car() {

    }


    public int getId() {
        return id;
    }
    public String getModel() {
        return model;
    }
    public String getBrand() {
        return brand;
    }
    public String getColor() {
        return color;
    }
}
