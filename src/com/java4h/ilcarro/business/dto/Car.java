package com.java4h.ilcarro.business.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.validation.constraints.*;
import java.util.Map;

import static com.java4h.ilcarro.business.config.FieldsConfiguration.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Car {
    @JsonProperty("id")
    @NotBlank(message = "Registration number is required")
    @Size(
            min = CAR_ID_MIN_LENGTH,
            max = CAR_ID_MAX_LENGTH,
            message = CAR_ID_ERROR_MSG
    )
    private String registrationNumber;

    @NotNull(message = "Location is required")
    private Location location;

    @NotNull(message = "Model is required")
    private Model model;

    @NotBlank(message = "Transmission type is required")
    private String transmission;

    @NotBlank(message = "Fuel type is required")
    private String fuel;

    @JsonProperty("wd")
    @NotBlank(message = "Wheel drive type is required")
    private String wheelDrive;

    @NotNull(message = "Year is required")
    @Min(value = CAR_YEAR_VALID_MIN, message = "Incorrect year, minimum is " + CAR_YEAR_VALID_MIN)
    @Max(value = CAR_YEAR_VALID_MAX, message = "Incorrect year")
    private Integer year;

    @NotNull(message = "Engine volume is required")
    @Positive(message = "Engine volume can't be negative")
    private Double engine;

    @NotNull(message = "Engine horsepower is required")
    @Positive(message = "Engine power can't be negative")
    private Integer horsepower;

    @Positive(message = "Incorrect input")
    private Integer doors;

    @Positive(message = "Incorrect input")
    private Integer seats;

    @NotNull(message = "Fuel consumption is required")
    @Positive(message = "Incorrect input")
    private Double fuelConsumption;

    private String features;

    // Will be ignored on input DTO
    private Map<Integer, String> images;

    @NotNull(message = "Price is required")
    @Positive(message = "Incorrect input")
    private Double price;

    // Will be ignored on input DTO and set to 0 on creation
    private Double rating;
}
