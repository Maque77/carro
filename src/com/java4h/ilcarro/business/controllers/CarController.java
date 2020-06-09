package com.java4h.ilcarro.business.controllers;
/*
 * Created by "Mark Tsimerman" on 5/21/2020
 */

import com.java4h.ilcarro.business.dto.Car;
import com.java4h.ilcarro.business.services.CarService;
import com.java4h.ilcarro.business.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.HashSet;

import static com.java4h.ilcarro.business.config.FieldsConfiguration.*;

@RestController
@CrossOrigin
@RequestMapping("/business")
@Validated
public class CarController {

    @Autowired
    CarService carService;

    @Autowired
    ImageService imageService;

    @PostMapping("/addCar")
    public Car addCar(@RequestBody @Valid Car car){
        return carService.addCar(car);
    }

    @GetMapping("/car/{registrationNumber}")
    public Car getCar(@PathVariable("registrationNumber") @Size(
            min = CAR_ID_MIN_LENGTH,
            max = CAR_ID_MAX_LENGTH,
            message = CAR_ID_ERROR_MSG) String registrationNumber){
        return carService.getCar(registrationNumber);
    }

    @DeleteMapping("/car/{registrationNumber}")
    public Car removeCar(@PathVariable("registrationNumber") @Size(
            min = CAR_ID_MIN_LENGTH,
            max = CAR_ID_MAX_LENGTH,
            message = CAR_ID_ERROR_MSG) String registrationNumber){
        return carService.removeCar(registrationNumber);
    }

    @PutMapping("/car/{registrationNumber}")
    public Car correctCar(
            @PathVariable("registrationNumber") @Size(
                    min = CAR_ID_MIN_LENGTH,
                    max = CAR_ID_MAX_LENGTH,
                    message = CAR_ID_ERROR_MSG) String registrationNumber,
            @RequestBody @Valid Car car){
        return carService.correctCar(registrationNumber, car);
    }

    // -----------------------------------------------------------------------
    // IMAGES SECTION

    @PostMapping("/images")
    public boolean addImages(@RequestParam String carId){
        imageService.addPicturesToCar(carId, new HashSet<>());
        return true;
    }

    @DeleteMapping("/images")
    public boolean deleteImage(@RequestParam int id){
        imageService.deletePictureById(id);
        return true;
    }
}
