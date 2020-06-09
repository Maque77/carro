package com.java4h.ilcarro.business.repositories;

import com.java4h.ilcarro.business.entities.BasketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketJpaRepository extends JpaRepository<BasketEntity, Integer> {
}
