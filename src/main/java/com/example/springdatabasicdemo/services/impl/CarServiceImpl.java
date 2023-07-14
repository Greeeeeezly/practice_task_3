package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.models.Car;
import com.example.springdatabasicdemo.models.Truck;
import com.example.springdatabasicdemo.repositories.CarRepository;
import com.example.springdatabasicdemo.repositories.TruckRepository;
import com.example.springdatabasicdemo.services.CarService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService<Integer> {
    private final CarRepository carRepository;
    private final TruckRepository truckRepository;

    public CarServiceImpl(CarRepository carRepository, TruckRepository truckRepository) {
        this.carRepository = carRepository;
        this.truckRepository = truckRepository;
    }

    @Override
    public void saveCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public List<Car> findAllBySeats(Integer seats) {
        return carRepository.findAllBySeats(seats);
    }

    @Override
    public Car findById(Integer id) {
        return carRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }

    @Override
    public void changeTypeToTruck(Integer id, Double load_capacity) {
        Car car = carRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
        Truck truck = new Truck(car.getFuel_type(),car.getModel(),car.getPrice(),car.getType(),load_capacity);
        carRepository.deleteById(id);
        truckRepository.save(truck);
    }

    @Override
    public void removeCarsById(List<Integer> idList) {
        for (Integer id: idList) {
            carRepository.deleteById(id);
        }
    }
}
