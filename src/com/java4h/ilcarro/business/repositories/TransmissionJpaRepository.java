package com.java4h.ilcarro.business.repositories;

import com.java4h.ilcarro.business.entities.TransmissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransmissionJpaRepository extends JpaRepository<TransmissionEntity, String> {
}
