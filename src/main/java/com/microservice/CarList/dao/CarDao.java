package com.microservice.CarList.dao;

import com.microservice.CarList.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarDao extends JpaRepository<Car, Integer> {
}
