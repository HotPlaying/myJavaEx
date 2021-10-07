package com.test.experiment.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangrd
 * @date 2020/9/22 19:51
 * @description
 */
@Data
@NoArgsConstructor
@Builder
public class User {
    private String uuid;
    private String account;
    private String name;
    private String password;

    private String type1;
    private String type2;
    private String type3;
    private String type4;
    private String type5;
    private String type6;
    private String type7;
    private String type8;
    private String type9;
    private String type10;

    public static List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("40288a0a7b7afb9e017b7afdb1d60033", "913", "LamTengHou", "4297F44B13955235245B2497399D7A93"));
        userList.add(new User("40288a0a7b7afb9e017b7afdb2300035", "2448", "MakKaTim,Tim", "55511808BAF7F301B5270D7334A4CEC0"));
        userList.add(new User("40288a0a7b7afb9e017b7afdb2710042", "371", "LeiChiKuong", "4297F44B13955235245B2497399D7A93"));
        userList.add(new User("40288a0a7b7afb9e017b7afdb2760044", "1300", "ChanChanSeng", "55511808BAF7F301B5270D7334A4CEC0"));
        return userList;
    }

    public User(String uuid, String account, String name, String password) {
        this.uuid = uuid;
        this.account = account;
        this.name = name;
        this.password = password;
    }
}
