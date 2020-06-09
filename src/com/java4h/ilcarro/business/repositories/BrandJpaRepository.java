package com.java4h.ilcarro.business.repositories;

import com.java4h.ilcarro.business.entities.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandJpaRepository extends JpaRepository<BrandEntity, String> {

}
