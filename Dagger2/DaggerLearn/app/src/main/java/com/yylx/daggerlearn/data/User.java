package com.yylx.daggerlearn.data;

import javax.inject.Inject;

/**
 * Created by zqj on 2016/5/31 16:38.
 */
public class User {

    private String name;
    private int age;
    private String password;

    @Inject
    public User() {

    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "," + password + "," + age;
    }
}
