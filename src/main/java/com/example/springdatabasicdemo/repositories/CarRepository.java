package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findAllBySeats(Integer seats);
}
