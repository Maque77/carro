package com.java4h.ilcarro.business.repositories;

import com.java4h.ilcarro.business.entities.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagesJpaRepository extends JpaRepository<ImageEntity, Integer> {
}
