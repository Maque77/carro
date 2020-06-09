package com.java4h.ilcarro.business.services;

import com.java4h.ilcarro.business.dto.*;
import com.java4h.ilcarro.business.entities.*;
import com.java4h.ilcarro.common.exceptions.DataNotFoundException;
import com.java4h.ilcarro.common.exceptions.IdNotFoundException;
import com.java4h.ilcarro.common.exceptions.IncorrectLogicException;
import com.java4h.ilcarro.common.exceptions.InvalidValueException;
import com.java4h.ilcarro.business.repositories.*;
import com.java4h.ilcarro.business.utilites.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarJpaRepository carJpaRepository;

    @Autowired
    ImageService imageService;

    @Autowired
    UserJpaRepository userJpaRepository;

    @Autowired
    ModelMapper modelMapper;

    @Transactional
    @Override
    public Car addCar(Car carDto) {
        if(carJpaRepository.existsById(carDto.getRegistrationNumber()))
            throw new InvalidValueException(
                    "Car with number " + carDto.getRegistrationNumber() + " already exists");

        // TODO: HERE IS USER SERVICE STUB
        UserEntity currentUser = userJpaRepository
                .findById("john@mail.com")
                .orElseThrow(() -> new IdNotFoundException("Owner is not found"));

        CarEntity carEntity = modelMapper.convertToEntity(carDto, currentUser);
        carJpaRepository.save(carEntity);

        // TODO: HERE IS IMAGE SERVICE STUB START, SEE CONTINUE IN "IMAGE SERVICE"
        Car car = imageService.addPicturesToCar(carDto.getRegistrationNumber(), new HashSet<>());
        return car;
    }

    @Override
    @Transactional
    public Car removeCar(String registrationNumber) {
        CarEntity target = carJpaRepository
                .findById(registrationNumber)
                .orElseThrow(() -> new IdNotFoundException("Car with registration number " + registrationNumber + " not found"));

        // TODO: SECURITY check if the current user has access rights or it is a current owner

        carJpaRepository.delete(target);
        imageService.deletePicturesByCar(target);

        return modelMapper.convertToDto(target);
    }

    @Override
    public Car correctCar(String registrationNumber, Car carDto) {
        CarEntity target = carJpaRepository
                .findById(registrationNumber)
                .orElseThrow(() -> new IdNotFoundException("Car with registration number " + registrationNumber + " not found"));
        if (!target.getRegistrationNumber().equals(carDto.getRegistrationNumber()))
            throw new IncorrectLogicException("Registration number mismatch");

        // TODO: SECURITY check if the current user has access rights or it is a current owner
        // HERE IS USER SERVICE STUB
        UserEntity currentUser = userJpaRepository
                .findById("john@mail.com")
                .orElseThrow(() -> new IdNotFoundException("Owner is not found"));
        if (!target.getUser().equals(currentUser))
            throw new IncorrectLogicException("Current user doesn't have permission for this operation");


        CarEntity changedCar = modelMapper.convertToEntity(carDto, currentUser);
        LocationEntity changedLocation = modelMapper.convertToEntity(carDto.getLocation());
        changedLocation.setLocationId(target.getLocation().getLocationId());
        changedCar.setLocation(changedLocation);

        carJpaRepository.save(changedCar);
        return modelMapper.convertToDto(changedCar);
    }

    @Override
    public Car getCar(String registrationNumber){
        return modelMapper.convertToDto(carJpaRepository
                .findById(registrationNumber)
                .orElseThrow(() -> new IdNotFoundException("Car with registration number " + registrationNumber + " not found"))
        );
    }

    @Override
    public boolean addImage(String registrationNumber, Image image) {
        // TODO: method stub
        return false;
    }

}

