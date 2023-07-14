package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.models.Car;

import java.util.List;

public interface CarService<ID> {
    void saveCar(Car car);
    List<Car> findAllBySeats(Integer seats);
    Car findById(ID id);
    void changeTypeToTruck(ID id, Double load_capaity);
    void removeCarsById(List<ID> idList);
}
