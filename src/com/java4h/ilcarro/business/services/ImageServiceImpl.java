package com.java4h.ilcarro.business.services;
/*
 * Created by "Mark Tsimerman" on 5/24/2020
 */

import com.java4h.ilcarro.business.dto.Car;
import com.java4h.ilcarro.business.entities.CarEntity;
import com.java4h.ilcarro.business.entities.ImageEntity;
import com.java4h.ilcarro.business.repositories.CarJpaRepository;
import com.java4h.ilcarro.business.repositories.ImagesJpaRepository;
import com.java4h.ilcarro.business.utilites.ModelMapper;
import com.java4h.ilcarro.common.exceptions.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImagesJpaRepository imagesRepo;

    @Autowired
    CarJpaRepository carRepo;

    @Autowired
    ModelMapper modelMapper;

    @Transactional
    @Override
    public Car addPicturesToCar(String registrationNumber, Set<byte[]> carImages) {
        CarEntity carEntity = carRepo
                .findById(registrationNumber)
                .orElseThrow(() -> new IdNotFoundException("Can't add picture. Car with registration number " + registrationNumber + " not found"));

        // TODO: HERE IS CONTINUE OF IMAGE SERVICE STUB
        HashSet<ImageEntity> images = new HashSet<>();
        images.add(new ImageEntity(registrationNumber + "_image1.jpg"));
        images.add(new ImageEntity(registrationNumber + "_image2.jpg"));
        images.add(new ImageEntity(registrationNumber + "_image3.jpg"));

        // TODO: save to filesystem

        imagesRepo.saveAll(images);
        carEntity.setImages(images);
        carRepo.save(carEntity);
        return modelMapper.convertToDto(carEntity);
    }

    @Transactional
    @Override
    public boolean deletePictureById(int imageId){
        // TODO: delete image byId STUB
        CarEntity carEntity = carRepo.findById("5535570").orElse(null);
        Map<Integer, ImageEntity> target = carEntity.getImages().stream()
                .collect(Collectors.toMap(x -> x.getImageId(), x -> x));

        carEntity.getImages().remove(target.get(imageId));
        carRepo.save(carEntity);
        imagesRepo.deleteById(imageId);
        // TODO: Delete from filesystem
        return true;
    }

    @Override
    public void deletePicturesByCar(CarEntity carEntity){
        imagesRepo.deleteAll(carEntity.getImages());
        // TODO: delete from filesystem
    }
}
