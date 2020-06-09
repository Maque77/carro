package com.java4h.ilcarro.business.repositories;

import com.java4h.ilcarro.business.entities.ModelEntity;
import com.java4h.ilcarro.business.entities.BodyTypeEntity;
import com.java4h.ilcarro.business.entities.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelJpaRepository extends JpaRepository<ModelEntity, String> {
    List<ModelEntity> findByBrand(BrandEntity brandEntity);
    List<ModelEntity> findByBodyType(BodyTypeEntity bodyTypeEntity);
}
