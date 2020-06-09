package com.java4h.ilcarro.business.entities;

import com.java4h.ilcarro.business.dto.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"email"})

@Entity
@Table(name = "users")
public class UserEntity{

    @Id
    @Column(length = 100)
    private String email;

    @Column(nullable = false)
    private String firstNameUser;

    @Column(nullable = false)
    private String lastNameUser;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private LocalDate birthDate;
    private byte[] avatar;

    @OneToMany(mappedBy = "user")
    private Set<CarEntity> cars = new HashSet<>();

	@OneToMany(mappedBy = "receiver")
    private Set<UserCommentEntity> commentsReceived = new HashSet<>();

	@OneToMany(mappedBy = "receiver")
    private Set<MessageEntity> messagesReceived = new HashSet<>();

    @ManyToMany(mappedBy = "usersInterested")
    private Set<CarEntity> basket = new TreeSet<>();

    // ----------------------------------------------------------------------
    // CONSTRUCTORS:

    public UserEntity(User user) {
        this.firstNameUser = user.getFirstNameUser();
        this.lastNameUser = user.getLastNameUser();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
        this.birthDate = user.getBirthDate();
        this.avatar = user.getAvatar();
    }

}
