package com.tyc.JavaMonolithicExample.repository.entity;

import lombok.Data;

public enum EUserGender {
    FEMALE("Female"), MALE("Male"), OTHER("Other");

    private String gender;
    EUserGender(String gender) {
        this.gender = gender;
    }
}
