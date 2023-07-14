package com.example.springdatabasicdemo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "cars")
public class Car extends Vehicle{
    @Column(precision = 11)
    private Integer seats;

    public Car(String fuel_type, String model, BigDecimal price, String type, Integer seats) {
        super(fuel_type, model, price, type);
        this.seats = seats;
    }

    protected Car() {
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }
}
