package com.microservice.CarList.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * define the model of Car table in database
 */
@Entity
public class Car {

    @Id
    @GeneratedValue
    @JsonIgnore
    private int id;
    @JsonIgnore
    private String brand;
    @JsonIgnore
    private String color;

    /**
     * Car constructor without parameter
     */
    public Car(){
    }

    /**
     * Car constructor
     * @param brand String
     * @param color String
     */
    public Car(String brand, String color){
        this.brand = brand;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
