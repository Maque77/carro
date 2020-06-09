package com.java4h.ilcarro.business.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"registrationNumber"})

@Entity
@Table(name = "cars")
public class CarEntity{


    @Id
    @Column(length = 100)
    private String registrationNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "location_id",
            foreignKey = @ForeignKey(name = "fk_car_location"),
            nullable = false
    )
    private LocationEntity location;

    @ManyToOne
    @JoinColumn(
            name = "model_type",
            foreignKey = @ForeignKey(name = "fk_car_model"),
            nullable = false
    )
    private ModelEntity model;

    @ManyToOne
    @JoinColumn(
            name = "transmission_type",
            foreignKey = @ForeignKey(name = "fk_car_transmission"),
            nullable = false
    )
    private TransmissionEntity transmission;

    @ManyToOne
    @JoinColumn(
            name="fuel_type",
            foreignKey = @ForeignKey(name = "fk_car_fuel"),
            nullable = false
    )
    private FuelEntity fuel;

    @ManyToOne
    @JoinColumn(
            name="wd_type",
            foreignKey = @ForeignKey(name = "fk_car_wd"),
            nullable = false
    )
    private WheelDriveEntity wheelDrive;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name="jt_cars_images",
            joinColumns = @JoinColumn( name="car_registration_number"),
            inverseJoinColumns = @JoinColumn( name="image_id")
    )
    private Set<ImageEntity> images = new HashSet<>();

    @ManyToOne
    @JoinColumn(
            foreignKey = @ForeignKey(name = "fk_car_owner"),
            nullable = false
    )
    private UserEntity user;
   
    @ManyToMany
    private Set<UserEntity> usersInterested = new HashSet<>();

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Double engine;

    @Column(nullable = false)
    private Integer horsepower;

    private Integer doors;
    private Integer seats;

    @Column(nullable = false)
    private Double fuelConsumption;

    private String features;            // Combined with "About" by Alexander?

    @Column(nullable = false)
    private Double price;

    private Double rating;
    
    @OneToMany(mappedBy = "receiver")
    private Set<CarCommentEntity> commentsReceived = new HashSet<>();

}
