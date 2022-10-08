package com.tyc.JavaMonolithicExample.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "tbluser")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String telephone;
    @Enumerated(EnumType.STRING)
    private EUserGender userGender;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private EUserType userType = EUserType.USER;


}
