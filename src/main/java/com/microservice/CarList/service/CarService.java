package com.microservice.CarList.service;

import com.microservice.CarList.model.Car;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CarService {
    Optional<Car> getCarById(Integer id);
    void addCar(Car car);
    List<Car> getAllCars();
    void updateCar(Car car, int id);
    void deleteCar(Integer id);
}


