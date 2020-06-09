package com.java4h.ilcarro.business.repositories;

import com.java4h.ilcarro.business.dto.Car;
import com.java4h.ilcarro.business.entities.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationJpaRepository extends JpaRepository<LocationEntity, Integer> {
    List<LocationEntity> findAllByCountry(String country);
    List<LocationEntity> findAllByCountryAndCity(String country, String city);

}
