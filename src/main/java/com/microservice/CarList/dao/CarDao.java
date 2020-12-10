package com.microservice.CarList.dao;

import com.microservice.CarList.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarDao extends JpaRepository<Car, Integer> {
    Car getCarById(Integer id);
    void addCar(Car car);
    List<Car> getAllCars();
    void updateCar(Car car, int id);
    void deleteCar(Integer id);
}
