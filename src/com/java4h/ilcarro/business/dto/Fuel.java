package com.java4h.ilcarro.business.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Fuel {

    private String fuelType;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fuel fuel = (Fuel) o;
        return Objects.equals(fuelType, fuel.fuelType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fuelType);
    }

    @Override
    public String toString() {
        return "Fuel{" +
                "fuelType='" + fuelType + '\'' +
                '}';
    }
}
