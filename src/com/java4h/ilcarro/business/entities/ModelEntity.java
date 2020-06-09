package com.java4h.ilcarro.business.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"modelType"})

@Entity
@Table(name = "models")
public class ModelEntity{

    @Id
    @Column(length = 100)
    private String modelType;

    @ManyToOne
    @JoinColumn(
            name = "brand_name",
            foreignKey = @ForeignKey(name = "fk_model_brand"),
            nullable = false
    )
    private BrandEntity brand;

    @ManyToOne
    @JoinColumn(
            name = "body_type",
            foreignKey = @ForeignKey(name = "fk_model_body_type"),
            nullable = false
    )
    private BodyTypeEntity bodyType;

    // TODO: add cascadeType?
    @OneToMany(mappedBy = "model")
    private Set<CarEntity> cars = new HashSet<>();

    // ----------------------------------------------------------------------
    // CONSTRUCTORS:

    public ModelEntity(String modelType, BrandEntity brand, BodyTypeEntity bodyType){
        this.modelType = modelType;
        this.brand = brand;
        this.bodyType = bodyType;
    }

}
