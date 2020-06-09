package com.java4h.ilcarro.business.repositories;

import com.java4h.ilcarro.business.entities.*;
import com.java4h.ilcarro.common.CustomizedJpaRepository;


import java.util.List;
import java.util.stream.Stream;

public interface CarJpaRepository extends CustomizedJpaRepository<CarEntity, String> {
	
	default String type() {
		return "CarEntity";
	}
	
	
    Stream<CarEntity> findAllBy();

    // GET BY
    List<CarEntity> findAllByModel(ModelEntity model);
    List<CarEntity> findAllByTransmission(TransmissionEntity transmission);
    List<CarEntity> findAllByUser(UserEntity user);
    List<CarEntity> findAllByFuel(FuelEntity fuel);
    List<CarEntity> findAllByWheelDrive(WheelDriveEntity wheelDrive);

    List<CarEntity> findByHorsepowerBetween(Integer min, Integer max);          // Change to Range (Not used)
    List<CarEntity> findByEngineGreaterThan(Double engine);                     // Change to Range (Not used)
    List<CarEntity> findByFuelConsumptionGreaterThan(Double fuelConsumption);   // Change to Range (Not used)

    // SORTING
    List<CarEntity> findAllByOrderByYear();                                     // All cars?
    List<CarEntity> findAllByOrderByEngine();                                   // All cars?
    List<CarEntity> findAllByOrderByHorsepower();                               // All cars?
    List<CarEntity> findAllByOrderByPrice();                                    // All cars?
    List<CarEntity> findAllByOrderByRating();                                   // All cars?

    // FILTERING IN RANGE
    List<CarEntity> findAllByYearGreaterThanEqualAndYearIsLessThanEqual(Integer from, Integer to);
    List<CarEntity> findAllByPriceGreaterThanEqualAndPriceIsLessThanEqual(Double from, Double to);
    List<CarEntity> findAllByRatingGreaterThanEqualAndRatingIsLessThanEqual(Double from, Double to);
}
