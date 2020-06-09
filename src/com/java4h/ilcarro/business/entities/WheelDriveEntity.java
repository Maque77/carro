package com.java4h.ilcarro.business.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"wheelDriveType"})

@Entity
@Table(name = "wheel_drive_types")
public class WheelDriveEntity {

    @Id
    @Column(
            length = 100,
            name = "wheel_drive_type"
    )
    private String wheelDriveType;

    @OneToMany(mappedBy = "wheelDrive")
    private Set<CarEntity> cars = new HashSet<>();

}
