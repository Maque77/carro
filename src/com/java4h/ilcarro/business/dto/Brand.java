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

public class Brand {

    private String brandType;
//    private Set<Model> models = new HashSet<>();  ?

    @Override
    public String toString() {
        return "Brand{" +
                "brandType='" + brandType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return Objects.equals(brandType, brand.brandType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandType);
    }
}
