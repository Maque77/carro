package com.java4h.ilcarro.business.services;
/*
 * Created by "Mark Tsimerman" on 5/26/2020
 */

import com.java4h.ilcarro.business.dto.Car;

import java.util.List;

public interface SearchService {

    //get
    List<Car> getAllCars();
    List<Car> getCarsByLocationCountry(String country);
    List<Car> getCarsByLocationCountryCity(String country, String city);
    List<Car> getCarsByModel(String modelType);
    List<Car> getCarsByTransmission(String transmissionType);
    List<Car> getCarsByOwner(String email);
    List<Car> getCarsByFuel(String fuelType);
    List<Car> getCarsByWheelDrive(String wheelDriveType);
    /** @deprecated This method is replaced by
     * getAllCarsInYearRange(year, year)
     */
    @Deprecated
    List<Car> getCarsByYear(Integer year);      // Should be changed to YearRange(from=year, to=year)

    //range
    List<Car> getAllCarsInYearRange(Integer from, Integer to);
    List<Car> getAllCarsInPriceRange(Double from, Double to);
    List<Car> getAllCarsInRatingRange(Double from, Double to);

    //sorted
    List<Car> getAllCarsSortedByYear();
    List<Car> getAllCarsSortedByEngine();
    List<Car> getAllCarsSortedByHorsepower();
    List<Car> getAllCarsSortedByPrice();
    List<Car> getAllCarsSortedByRating();


}
