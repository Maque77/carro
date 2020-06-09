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
public class BodyType {

    private String bodyType;

    public BodyType(BodyType bodyType) {
    }

    //    private Set<Model> models = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BodyType bodyType1 = (BodyType) o;
        return Objects.equals(bodyType, bodyType1.bodyType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bodyType);
    }

    @Override
    public String toString() {
        return "BodyType{" +
                "bodyType='" + bodyType + '\'' +
                '}';
    }

}
