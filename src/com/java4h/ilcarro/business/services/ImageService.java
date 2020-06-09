package com.java4h.ilcarro.business.services;
/*
 * Created by "Mark Tsimerman" on 5/24/2020
 */

import com.java4h.ilcarro.business.dto.Car;
import com.java4h.ilcarro.business.entities.CarEntity;

import java.util.Set;

public interface ImageService {
    Car addPicturesToCar(String carId, Set<byte[]> images);

    boolean deletePictureById(int imageId);

    void deletePicturesByCar(CarEntity carEntity);
}
