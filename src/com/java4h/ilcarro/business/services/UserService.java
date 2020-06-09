package com.java4h.ilcarro.business.services;

import com.java4h.ilcarro.business.dto.*;
import com.java4h.ilcarro.business.entities.UserEntity;
import com.java4h.ilcarro.security.dto.AuthPair;
import com.java4h.ilcarro.security.dto.SingUpBody;

import java.util.List;

public interface UserService {

    String singUp(SingUpBody singUpBody);
    String singIn(AuthPair authPair);

    List<User> getAllUser();
    List<User> getUsersByForm();
    List<Car> getAllCars();
    List<Car> getCarsByForm();
    User getUserByEmail(String email);
    Car getCarByRegistrationNumber(String registrationNumber);

    boolean singOut();
    User editUser(User correctUser);
    boolean deleteUser(String email);
    boolean changePassword(); //TODO

    Car addUserCar(Car car);
    List<Car> getUserCars(String email);
    Car editCar(Car correctCar);
    boolean deleteCar(String registrationNumber);

    Car changeStatusCar(String registrationNumber);
    List<Car> getRentUserCar(String email);

    Basket getBasket(String email);
    boolean addCarToBasket(CarForBasket carForBasket);
    boolean deleteCarInBasket(CarForBasket carForBasket);

    List<_Comment> getUserComments(String email);
    List<_Comment> getCarComments(String registrationNumber);
    _Comment getComment(Integer commentId);
    _Comment editComment(_Comment editComment);
    boolean addCommentUser(_UserComment comment);
    boolean addCommentCar(CarComment comment);
    boolean deleteComment(Integer commentId);
    List<_Comment> getNews(String email);
	UserEntity getCurrentUser();

}
