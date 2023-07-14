package com.example.springdatabasicdemo;

import com.example.springdatabasicdemo.models.Car;
import com.example.springdatabasicdemo.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    @Autowired
    private CarService carService;

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void printAllCarsBySeats(Integer seats){
        carService
                .findAllBySeats(seats)
                .forEach(System.out::println);
    }
    private void printCarById(Integer id){
        System.out.println(carService.findById(id));
    }

    private void seedData() throws IOException {
        //Добавление в БД записей
        Car car1 = new Car("gas", "AMC", BigDecimal.valueOf(100.22),"sedan", 2);
        Car car2 = new Car("diesel", "BMW", BigDecimal.valueOf(200.22),"suv", 5);
        Car car3 = new Car("gas", "GAZ", BigDecimal.valueOf(200.22),"pickup", 5);
        Car car4 = new Car("diesel", "BMW", BigDecimal.valueOf(200.22),"suv", 5);
        carService.saveCar(car1);
        carService.saveCar(car2);
        carService.saveCar(car3);
        carService.saveCar(car4);
        printAllCarsBySeats(7);
        printCarById(1);
        carService.changeTypeToTruck(3,4444.4);
        ArrayList list=new ArrayList(2);
        list.add(1);
        list.add(2);
        carService.removeCarsById(list);
    }
}
