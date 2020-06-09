package com.java4h.ilcarro.business.services;
/*
 * Created by "Mark Tsimerman" on 5/26/2020
 */

import com.java4h.ilcarro.business.config.FieldsConfiguration;
import com.java4h.ilcarro.business.dto.Car;
import com.java4h.ilcarro.business.entities.*;
import com.java4h.ilcarro.business.repositories.*;
import com.java4h.ilcarro.business.utilites.ModelMapper;
import com.java4h.ilcarro.common.exceptions.IdNotFoundException;
import com.java4h.ilcarro.common.exceptions.InvalidValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    CarJpaRepository carRepo;

    @Autowired
    ModelJpaRepository modelRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    LocationJpaRepository locationRepo;

    @Autowired
    TransmissionJpaRepository transmissionRepo;

    @Autowired
    UserJpaRepository userRepo;

    @Autowired
    FuelJpaRepository fuelRepo;

    @Autowired
    WheelDriveJpaRepository wheelDriveRepo;

    @Transactional(readOnly = true)
    @Override
    public List<Car> getAllCars() {
        try(Stream<CarEntity> stream = carRepo.findAllBy()){
            return stream.map(carEntity -> modelMapper.convertToDto(carEntity)).collect(Collectors.toList());
        }
//        return carRepo.findAll().stream().map(carEntity -> modelMapper.convertToDto(carEntity)).collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarsByLocationCountry(String country) {
        return locationRepo.findAllByCountry(country).stream()
                .map(locationEntity -> modelMapper.convertToDto(locationEntity.getCar()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarsByLocationCountryCity(String country, String city) {
        return locationRepo.findAllByCountryAndCity(country, city).stream()
                .map(locationEntity -> modelMapper.convertToDto(locationEntity.getCar()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarsByModel(String modelType) {
        ModelEntity model = modelRepo
                .findById(modelType)
                .orElseThrow(() -> new IdNotFoundException("Requested model not found"));

        return carRepo.findAllByModel(model).stream()
                .map(carEntity -> modelMapper.convertToDto(carEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarsByTransmission(String transmissionType) {
        TransmissionEntity transmission = transmissionRepo
                .findById(transmissionType)
                .orElseThrow(() -> new IdNotFoundException("Requested transmission not found"));
        return carRepo.findAllByTransmission(transmission).stream()
                .map(carEntity -> modelMapper.convertToDto(carEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarsByOwner(String email) {
        // TODO: SECURITY check if the current user has access rights or it is a current user
        UserEntity owner = userRepo
                .findById(email)
                .orElseThrow(() -> new IdNotFoundException("Owner not found"));
        return carRepo.findAllByUser(owner).stream()
                .map(carEntity -> modelMapper.convertToDto(carEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarsByFuel(String fuelType) {
        FuelEntity fuel = fuelRepo
                .findById(fuelType)
                .orElseThrow(() -> new IdNotFoundException("Requested fuel type not found"));
        return carRepo.findAllByFuel(fuel).stream()
                .map(carEntity -> modelMapper.convertToDto(carEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarsByWheelDrive(String wheelDriveType) {
        WheelDriveEntity wheelDrive = wheelDriveRepo
                .findById(wheelDriveType)
                .orElseThrow(() -> new IdNotFoundException("Requested wheel drive type not found"));
        return carRepo.findAllByWheelDrive(wheelDrive).stream()
                .map(carEntity -> modelMapper.convertToDto(carEntity))
                .collect(Collectors.toList());
    }

    // TODO: should be deleted, see interface for reason
    @Override
    public List<Car> getCarsByYear(Integer year) {
        if (year > LocalDate.now().getYear() + FieldsConfiguration.MAX_FUTURE_MODEL_YEAR)
            throw new InvalidValueException("Future model year, maximum is " +
                    LocalDate.now().getYear() + FieldsConfiguration.MAX_FUTURE_MODEL_YEAR);

        return carRepo.findAllByYearGreaterThanEqualAndYearIsLessThanEqual(year, year).stream()
                .map(carEntity -> modelMapper.convertToDto(carEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getAllCarsSortedByYear() {
        return carRepo.findAllByOrderByYear().stream()
                .map(carEntity -> modelMapper.convertToDto(carEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getAllCarsSortedByEngine() {
        return carRepo.findAllByOrderByEngine().stream()
                .map(carEntity -> modelMapper.convertToDto(carEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getAllCarsSortedByHorsepower() {
        return carRepo.findAllByOrderByHorsepower().stream()
                .map(carEntity -> modelMapper.convertToDto(carEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getAllCarsSortedByPrice() {
        return carRepo.findAllByOrderByPrice().stream()
                .map(carEntity -> modelMapper.convertToDto(carEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getAllCarsSortedByRating() {
        return carRepo.findAllByOrderByRating().stream()
                .map(carEntity -> modelMapper.convertToDto(carEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getAllCarsInYearRange(Integer from, Integer to) {
        if (from > to) throw new InvalidValueException("Year 'From' is greater than 'To'");
        return carRepo.findAllByYearGreaterThanEqualAndYearIsLessThanEqual(from, to).stream()
                .map(carEntity -> modelMapper.convertToDto(carEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getAllCarsInPriceRange(Double from, Double to) {
        if (from > to) throw new InvalidValueException("Price 'From' is greater than 'To'");
        return carRepo.findAllByPriceGreaterThanEqualAndPriceIsLessThanEqual(from, to).stream()
                .map(carEntity -> modelMapper.convertToDto(carEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getAllCarsInRatingRange(Double from, Double to) {
        if (from > to) throw new InvalidValueException("Rating 'From' is greater than 'To'");
        return carRepo.findAllByRatingGreaterThanEqualAndRatingIsLessThanEqual(from, to).stream()
                .map(carEntity -> modelMapper.convertToDto(carEntity))
                .collect(Collectors.toList());
    }
}
