package com.microservice.CarList.service;

import com.microservice.CarList.dao.CarDao;
import com.microservice.CarList.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private CarDao carDao;

    public CarServiceImpl(CarDao carDao){
        this.carDao = carDao;
    }
    @Override
    public Car getCarById(Integer id) {
       return this.carDao.getCarById(id);
    }

    @Override
    public void addCar(Car car) {
        this.carDao.addCar(car);
    }

    @Override
    public List<Car> getAllCars() {
        return this.carDao.getAllCars();
    }

    @Override
    public void updateCar(Car car, int id) {
        this.carDao.updateCar(car, id);
    }

    @Override
    public void deleteCar(Integer id) {
        this.carDao.deleteCar(id);
    }
}
