package com.java4h.ilcarro.business.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"brandType"})

@Entity
@Table(name = "brands")
public class BrandEntity {

    @Id
    @Column(length = 100)
    private String brandType;

    @OneToMany(mappedBy = "brand")
    private Set<ModelEntity> models = new HashSet<>();

    // ----------------------------------------------------------------------
    // CONSTRUCTORS:

    public BrandEntity(String brand) {
        this.brandType = brand;
    }

}
