package com.java4h.ilcarro.business.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"transmissionType"})

@Entity
@Table(name = "transmissions")
public class TransmissionEntity {

    @Id
    @Column(
            length = 100,
            name = "transmission_type")
    private String transmissionType;

    @OneToMany(mappedBy = "transmission")
    private Set<CarEntity> cars = new HashSet<>();

}
