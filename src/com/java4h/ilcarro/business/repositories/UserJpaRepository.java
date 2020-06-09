package com.java4h.ilcarro.business.repositories;

import com.java4h.ilcarro.business.entities.UserEntity;
import com.java4h.ilcarro.common.CustomizedJpaRepository;

import java.util.List;

public interface UserJpaRepository extends CustomizedJpaRepository<UserEntity, String> {

    List<UserEntity> findByLastNameUser(String lastName);
    List<UserEntity> findByFirstNameUserOrLastNameUser(String firstNameUser, String lastNameUser);
    List<UserEntity> findByFirstNameUserAndLastNameUser(String firstNameUser, String lastNameUser);
    List<UserEntity> findByEmailStartingWith(String email);
    List<UserEntity> findByPhoneNumber(String phoneNumber);
}
