package com.tyc.JavaMonolithicExample.repository.entity;


public class Test {
    public static void main(String[] args) {
        User user = new User();
        user.setUserGender(EUserGender.MALE);

        System.out.println(EUserGender.valueOf("MALE").toString().toLowerCase());
    }
}
