package com.java4h.ilcarro.business.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java4h.ilcarro.business.entities.CarCommentEntity;
import com.java4h.ilcarro.business.entities.CarEntity;

public interface CarCommentJpaRepository extends JpaRepository<CarCommentEntity, Integer> {

    List<CarCommentEntity> findByReceiver(CarEntity receiver);

}
