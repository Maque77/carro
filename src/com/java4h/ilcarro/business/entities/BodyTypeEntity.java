package com.java4h.ilcarro.business.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"bodyType"})

@Entity
@Table(name = "body_types")
public class BodyTypeEntity {

    @Id
    @Column(
            length = 100,
            name = "body_type")
    private String bodyType;

    @OneToMany(mappedBy = "bodyType")
    private Set<ModelEntity> models = new HashSet<>();

}
