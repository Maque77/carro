package com.java4h.ilcarro.business.entities;

import com.java4h.ilcarro.business.dto.Location;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"locationId"})

@Entity
@Table(name = "locations")
public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer locationId;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String street;

    private String state;

    @OneToOne(mappedBy = "location")
    private CarEntity car;

    // ----------------------------------------------------------------------
    // CONSTRUCTORS:

    public LocationEntity(Location location) {
        this.country = location.getCountry();
        this.city = location.getCity();
        this.street = location.getStreet();
        this.state = location.getState();
    }

}
