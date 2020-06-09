package com.java4h.ilcarro.business.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"fuelType"})

@Entity
@Table(name = "fuel_types")
public class FuelEntity {

    @Id
    @Column(
            length = 100,
            name = "fuel_type")
    private String fuelType;

    @OneToMany(mappedBy = "fuel")
    private Set<CarEntity> cars = new HashSet<>();

}
