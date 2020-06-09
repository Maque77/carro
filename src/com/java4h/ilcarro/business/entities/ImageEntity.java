package com.java4h.ilcarro.business.entities;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode

@Entity
@Table(name = "images")
public class ImageEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imageId;

    private String imageUrl;

    // ----------------------------------------------------------------------
    // CONSTRUCTORS:

    public ImageEntity(String imageUrl){
        this.imageUrl = imageUrl;
    }

}
