package com.java4h.ilcarro.business.utilites;
/*
 * Created by "Mark Tsimerman" on 5/22/2020
 */

import com.java4h.ilcarro.business.dto.*;
import com.java4h.ilcarro.business.entities.*;
import com.java4h.ilcarro.business.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class ModelMapper {

    @Autowired
    ModelJpaRepository modelJpaRepository;

    @Autowired
    TransmissionJpaRepository transmissionJpaRepository;

    @Autowired
    BrandJpaRepository brandJpaRepository;

    @Autowired
    BodyTypeJpaRepository bodyTypeRepo;

    @Autowired
    FuelJpaRepository fuelRepo;

    @Autowired
    WheelDriveJpaRepository wdRepo;

    @Autowired
    LocationJpaRepository locationRepo;
    
    @Autowired
    MessageJpaRepository messageJpaRepository;

    @Autowired
    CarCommentJpaRepository carCommentJpaRepository;

    @Autowired
    UserCommentJpaRepository userCommentJpaRepository;
    
    
    public CarCommentEntity convertToEntity(Comment comment, CarEntity receiver) {
    	return CarCommentEntity.builder()
    			.datetime(comment.getDatetime())
    			.sender(comment.getSender())
    			.receiver(receiver)
    			.text(comment.getText())
    			.build();
    }
    
    public Comment convertToDto(CarCommentEntity entity){
    	return Comment.builder()
    			.datetime(entity.getDatetime())
    			.sender(entity.getSender())
    			.text(entity.getText())
    			.build();
    }

    public UserCommentEntity convertToEntity(Comment comment, UserEntity receiver) {
    	return UserCommentEntity.builder()
    			.datetime(comment.getDatetime())
    			.sender(comment.getSender())
    			.receiver(receiver)
    			.text(comment.getText())
    			.build();
    }
    
    public Comment convertToDto(UserCommentEntity entity){
    	return Comment.builder()
    			.datetime(entity.getDatetime())
    			.sender(entity.getSender())
    			.text(entity.getText())
    			.build();
    }
    
    public MessageEntity convertToEntity(Message message, UserEntity receiver) {
    	return MessageEntity.builder()
    			.datetime(message.getDatetime())
    			.sender(message.getSender())
    			.receiver(receiver)
    			.text(message.getText())
    			.readed(message.getReaded())
    			.invisibleFor(message.getInvisibleFor())
    			.build();
    }
    
    public Message convertToDto(MessageEntity entity){
    	return Message.builder()
    			.datetime(entity.getDatetime())
    			.sender(entity.getSender())
    			.text(entity.getText())
    			.readed(entity.isReaded())
    			.invisibleFor(entity.getInvisibleFor())
    			.build();
    }
    
///////////////////

    public Car convertToDto(CarEntity entity){
        return Car.builder()
                .registrationNumber(    entity.getRegistrationNumber())
                .location(              convertToDto(entity.getLocation()))
                .model(                 convertToDto(entity.getModel()))
                .transmission(          entity.getTransmission().getTransmissionType())
                .fuel(                  entity.getFuel().getFuelType())
                .wheelDrive(            entity.getWheelDrive().getWheelDriveType())
                .year(                  entity.getYear())
                .engine(                entity.getEngine())
                .horsepower(            entity.getHorsepower())
                .doors(                 entity.getDoors())
                .seats(                 entity.getSeats())
                .fuelConsumption(       entity.getFuelConsumption())
                .features(              entity.getFeatures())
                .images(                entity.getImages().stream()
                                            .collect(Collectors.toMap(i -> i.getImageId(), i -> i.getImageUrl())))
                .price(                 entity.getPrice())
                .rating(                entity.getRating())
                .build();
    }

    public CarEntity convertToEntity(Car carDto, UserEntity owner){
        CarEntity carEntity = new CarEntity();

        carEntity.setRegistrationNumber(    carDto.getRegistrationNumber());
        carEntity.setModel(                 generateModel(carDto.getModel()));
        carEntity.setLocation(              convertToEntity(carDto.getLocation()));
        carEntity.setTransmission(          checkTransmission(carDto.getTransmission()));
        carEntity.setFuel(                  checkFuel(carDto.getFuel()));
        carEntity.setWheelDrive(            checkWheelDrive(carDto.getWheelDrive()));
        carEntity.setUser(                  owner);
        carEntity.setYear(                  carDto.getYear());
        carEntity.setEngine(                carDto.getEngine());
        carEntity.setHorsepower(            carDto.getHorsepower());
        carEntity.setDoors(                 carDto.getDoors());
        carEntity.setSeats(                 carDto.getSeats());
        carEntity.setFuelConsumption(       carDto.getFuelConsumption());
        carEntity.setFeatures(              carDto.getFeatures());
        carEntity.setPrice(                 carDto.getPrice());
        carEntity.setRating(                0.);

        return carEntity;
    }

    public LocationEntity convertToEntity(Location location){
        return new LocationEntity(location);
    }

    public Location convertToDto(LocationEntity entity){
        return new Location(
                entity.getCountry(),
                entity.getCity(),
                entity.getStreet(),
                entity.getState()
        );
    }

    public Model convertToDto (ModelEntity entity){
        return new Model(
                entity.getModelType(),
                entity.getBrand().getBrandType(),
                entity.getBodyType().getBodyType()
        );
    }

    // -------------------------------------------------------------------------------


    private ModelEntity generateModel(Model modelDto){
        BrandEntity brand = brandJpaRepository
                .findById(modelDto.getBrand())
                .orElseGet(() -> brandJpaRepository.save(new BrandEntity(modelDto.getBrand())));

        BodyTypeEntity bodyType = bodyTypeRepo
                .findById(modelDto.getBodyType())
                .orElseThrow(() -> new RuntimeException("Body type doesn't exists"));

        return modelJpaRepository.findById(modelDto.getModelType())
                .orElseGet(() -> modelJpaRepository.save(new ModelEntity(modelDto.getModelType(), brand, bodyType)));
    }

    private TransmissionEntity checkTransmission(String transmissionId){
        return transmissionJpaRepository
                .findById(transmissionId)
                .orElseThrow(() -> new RuntimeException("Transmission type doesn't exists"));
    }

    private FuelEntity checkFuel(String fuelId){
        return fuelRepo
                .findById(fuelId)
                .orElseThrow(() -> new RuntimeException("Fuel type doesn't exists"));
    }

    private WheelDriveEntity checkWheelDrive(String wheelDriveId){
        return wdRepo
                .findById(wheelDriveId)
                .orElseThrow(() -> new RuntimeException("Wheel Drive type doesn't exists"));
    }
}
