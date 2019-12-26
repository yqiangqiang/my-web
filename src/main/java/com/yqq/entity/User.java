package com.yqq.entity;

/**
 * Created by yanqiangqiang on 2018/12/10.
 */
public class User {

    private String id;

    private String userName;

    private String password;

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return id+"-----"+userName+"-------"+password;
    }
}
