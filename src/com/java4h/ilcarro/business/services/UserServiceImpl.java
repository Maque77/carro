package com.java4h.ilcarro.business.services;

import com.java4h.ilcarro.business.dto.*;
import com.java4h.ilcarro.business.entities.UserEntity;
import com.java4h.ilcarro.business.repositories.CommentJpaRepository;
import com.java4h.ilcarro.business.repositories.UserJpaRepository;
import com.java4h.ilcarro.security.dto.AuthPair;
import com.java4h.ilcarro.security.dto.SingUpBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

//    @Autowired
//    public UserServiceImpl(UserJpaRepository userJpaRepository,
//                           CommentJpaRepository commentJpaRepository) {
//    }
    
    @Autowired UserJpaRepository userRepo; //TODO combine @Autowired

    @Override
    public String singUp(SingUpBody singUpBody) { // TODO rename to Register... + addUser
        return null;
    }

    @Override
    public String singIn(AuthPair authPair) { // TODO duplicate method createAuthenticationToken(@RequestBody JWTRequest authenticationRequest)
        return null;
    }
    
    @Override
	public UserEntity getCurrentUser() {
    	
	String	login = SecurityContextHolder.getContext().getAuthentication().getName();
		return userRepo.checkById(login, true);
	}

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public List<User> getUsersByForm() {
        return null;
    }

    @Override
    public List<Car> getAllCars() {
        return null;
    }

    @Override
    public List<Car> getCarsByForm() {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public Car getCarByRegistrationNumber(String registrationNumber) {
        return null;
    }

    @Override
    public boolean singOut() {
        return false;
    }

    @Override
    public User editUser(User correctUser) {
        return null;
    }

    @Override
    public boolean deleteUser(String email) {
        return false;
    }

    @Override
    public boolean changePassword() {
        return false;
    }

    @Override
    public Car addUserCar(Car car) {
        return null;
    }

    @Override
    public List<Car> getUserCars(String email) {
        return null;
    }

    @Override
    public Car editCar(Car correctCar) {
        return null;
    }

    @Override
    public boolean deleteCar(String registrationNumber) {
        return false;
    }

    @Override
    public Car changeStatusCar(String registrationNumber) {
        return null;
    }

    @Override
    public List<Car> getRentUserCar(String email) {
        return null;
    }

    @Override
    public Basket getBasket(String email) {
        return null;
    }

    @Override
    public boolean addCarToBasket(CarForBasket carForBasket) {
        return false;
    }

    @Override
    public boolean deleteCarInBasket(CarForBasket carForBasket) {
        return false;
    }

    @Override
    public List<_Comment> getUserComments(String email) {
        return null;
    }

    @Override
    public List<_Comment> getCarComments(String registrationNumber) {
        return null;
    }

    @Override
    public _Comment getComment(Integer commentId) {
        return null;
    }

    @Override
    public _Comment editComment(_Comment editComment) {
        return null;
    }

    @Override
    public boolean addCommentUser(_UserComment comment) {
        return false;
    }

    @Override
    public boolean addCommentCar(CarComment comment) {
        return false;
    }

    @Override
    public boolean deleteComment(Integer commentId) {
        return false;
    }

    @Override
    public List<_Comment> getNews(String email) {
        return null;
    }
}
