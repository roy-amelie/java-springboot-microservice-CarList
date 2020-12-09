package com.microservice.CarList.service;

import com.microservice.CarList.model.Car;

import java.util.List;

public interface CarService {
    Car getCarById(Integer id);
    void addCar(Car car);
    List<Car> getAllCars();
    void updateCar(Car car, int id);
    void deleteCar(Integer id);
}


