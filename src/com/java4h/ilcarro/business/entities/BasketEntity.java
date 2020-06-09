package com.java4h.ilcarro.business.entities;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"basketId"})

@Entity
@Table(name = "baskets")
public class BasketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer basketId;

    private LocalDateTime createdDate;

    @OneToMany
    @JoinTable(
            name="jt_baskets_cars",
            joinColumns = @JoinColumn( name="basket_id"),
            inverseJoinColumns = @JoinColumn( name="car_id")
    )
    private Set<CarEntity> cars = new HashSet<>();

    @PrePersist
    public void prePersist() {
        this.createdDate = LocalDateTime.now();
    }

    // ----------------------------------------------------------------------
    // CONSTRUCTORS:

    public BasketEntity(Set<CarEntity> cars){
        this.cars = cars;
    }

}
