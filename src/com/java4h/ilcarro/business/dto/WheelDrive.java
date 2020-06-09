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

public class WheelDrive {

    private String wheelDriveType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WheelDrive that = (WheelDrive) o;
        return Objects.equals(wheelDriveType, that.wheelDriveType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wheelDriveType);
    }

    @Override
    public String toString() {
        return "WheelDrive{" +
                "wheelDriveType='" + wheelDriveType + '\'' +
                '}';
    }
}
