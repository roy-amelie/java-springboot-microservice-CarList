package com.microservice.CarList.service;

import com.microservice.CarList.dao.CarDao;
import com.microservice.CarList.model.Car;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class CarServiceImpl implements CarService {
    private final CarDao carDao;


    public CarServiceImpl(CarDao carDao){
        this.carDao = carDao;
    }
    @Override
    public Optional<Car> getCarById(Integer id) {
       return this.carDao.findById(id);
    }

    @Override
    public void addCar(Car car) {
        this.carDao.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return  carDao.findAll();
    }

    @Override
    public void updateCar(Car car, int id) {
        this.carDao.save(car);
    }

    @Override
    public void deleteCar(Integer id) {
        this.carDao.deleteById(id);
    }
}
