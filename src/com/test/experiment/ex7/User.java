package com.test.experiment.ex7;

/**
 * @author tangrd
 * @date 2020/9/22 19:51
 * @description
 */
public class User {
    private String uuid;
    private String userid;
    private String username;
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


    public User(String uuid, String userid, String username, String password) {
        this.uuid = uuid;
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

    public User() {}

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
