package com.java4h.ilcarro.business.services;

import com.java4h.ilcarro.business.dto.Car;
import com.java4h.ilcarro.business.dto.Image;

public interface CarService {

    Car addCar(Car car);
    Car removeCar(String registrationNumber);
    Car correctCar(String registrationNumber, Car car);
    Car getCar(String registrationNumber);

    boolean addImage(String registrationNumber, Image image);

}


