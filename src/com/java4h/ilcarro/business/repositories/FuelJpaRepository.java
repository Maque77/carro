package com.java4h.ilcarro.business.repositories;

import com.java4h.ilcarro.business.entities.FuelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelJpaRepository extends JpaRepository<FuelEntity, String> {

}
