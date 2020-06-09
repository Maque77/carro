package com.java4h.ilcarro.business.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Transmission {
    private String typeTransmission;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transmission that = (Transmission) o;
        return Objects.equals(typeTransmission, that.typeTransmission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeTransmission);
    }

    @Override
    public String toString() {
        return "Transmission{" +
                "typeTransmission='" + typeTransmission + '\'' +
                '}';
    }
}
