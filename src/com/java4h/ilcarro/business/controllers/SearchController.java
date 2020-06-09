package com.java4h.ilcarro.business.controllers;
/*
 * Created by "Mark Tsimerman" on 5/26/2020
 */

import com.java4h.ilcarro.business.dto.Car;
import com.java4h.ilcarro.business.services.SearchService;
import com.java4h.ilcarro.common.exceptions.InvalidValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

import static com.java4h.ilcarro.business.config.FieldsConfiguration.*;

@RestController
@CrossOrigin
//@RequestMapping("/search")
@RequestMapping("/business")
@Validated
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping("/all")
    public List<Car> getAllCars(){
        return searchService.getAllCars();
    }

    @GetMapping("/model")
    public List<Car> getCarsByModel(@RequestParam(name = "name") String name){
        return searchService.getCarsByModel(name);
    }

    @GetMapping("/transmission")
    public List<Car> getCarsByTransmission(@RequestParam String type){
        return searchService.getCarsByTransmission(type);
    }

    @GetMapping("/owner")
    public List<Car> getCarsByOwner(@RequestParam String email){
        return searchService.getCarsByOwner(email);
    }

    @GetMapping("/fuel")
    public List<Car> getCarsByFuel(@RequestParam String type){
        return searchService.getCarsByFuel(type);
    }

    @GetMapping("/wd")
    public List<Car> getCarsByWheelDrive(@RequestParam String type){
        return searchService.getCarsByWheelDrive(type);
    }

    @GetMapping("/year")
    public List<Car> getCarsByYear(@RequestParam
            @Min(value = CAR_YEAR_VALID_MIN, message = "Incorrect year, minimum is " + CAR_YEAR_VALID_MIN)
            @Max(value = CAR_YEAR_VALID_MAX, message = "Incorrect year")
                                               Integer year){
        return searchService.getCarsByYear(year);
    }

    @GetMapping("location/{country}")
    public List<Car> getCarsByLocationCountryCity(
            @PathVariable String country,
            @RequestParam(required = false, name = "city") String city){
        if (city == null){
            return searchService.getCarsByLocationCountry(country);
        }
        return searchService.getCarsByLocationCountryCity(country, city);
    }

    @GetMapping("/filter")
    public List<Car> getFiltered(
            @Valid @NotBlank @RequestParam String by,
            @Valid @NotNull @Positive @RequestParam Double from,
            @Valid @NotNull @Positive @RequestParam Double to){
        if (from > to) throw new InvalidValueException("Parameter 'From' is greater than 'To'");
        switch (by){
            case "year": return searchService.getAllCarsInYearRange((int)Math.abs(from), (int)Math.abs(to));
            case "price": return searchService.getAllCarsInPriceRange(from, to);
            case "rating": return searchService.getAllCarsInRatingRange(from, to);
            default: return new ArrayList<>();
        }
    }

    @GetMapping("/sorted")
    public List<Car> getCarsSorted(@Valid @NotBlank @RequestParam String by){
        switch (by){
            case "year": return searchService.getAllCarsSortedByYear();
            case "engine": return searchService.getAllCarsSortedByEngine();
            case "horsepower": return searchService.getAllCarsSortedByHorsepower();
            case "rating": return searchService.getAllCarsSortedByRating();
            default: return searchService.getAllCarsSortedByPrice();
        }
    }

}
