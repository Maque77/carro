package com.java4h.ilcarro.business.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class User {

    private String email;
    private String firstNameUser;
    private String lastNameUser;
    private String phoneNumber;
    private LocalDate birthDate;
    private byte[] avatar;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) &&
                Objects.equals(firstNameUser, user.firstNameUser) &&
                Objects.equals(lastNameUser, user.lastNameUser) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(birthDate, user.birthDate) &&
                Arrays.equals(avatar, user.avatar);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(email, firstNameUser, lastNameUser, phoneNumber, birthDate);
        result = 31 * result + Arrays.hashCode(avatar);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", firstNameUser='" + firstNameUser + '\'' +
                ", lastNameUser='" + lastNameUser + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthDate=" + birthDate +
                ", avatar=" + Arrays.toString(avatar) +
                '}';
    }
}
