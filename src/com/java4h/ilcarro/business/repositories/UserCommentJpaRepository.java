package com.java4h.ilcarro.business.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java4h.ilcarro.business.entities.UserCommentEntity;
import com.java4h.ilcarro.business.entities.UserEntity;

public interface UserCommentJpaRepository extends JpaRepository<UserCommentEntity, Integer> {

    List<UserCommentEntity> findByReceiver(UserEntity receiver);

}
