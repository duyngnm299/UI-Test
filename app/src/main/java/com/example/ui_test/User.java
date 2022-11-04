package com.example.ui_test;

public class User {
    public String id410;
    public String name410;
    public String userName410;
    public String chucVu410;
    public String email410;
    public String password410;



    public User() {}

    public User(String password410) {
        this.password410 = password410;
    }

    public User(String name410, String email410, String chucVu410, String userName410, String password410) {
        this.name410 = name410;
        this.email410 = email410;
        this.chucVu410 = chucVu410;
        this.userName410 = userName410;
        this.password410 = password410;
    }
    public User(String id410, String name410, String email410, String chucVu410, String userName410, String password410) {
        this.id410 = id410;
        this.name410 = name410;
        this.email410 = email410;
        this.chucVu410 = chucVu410;
        this.userName410 = userName410;
        this.password410 = password410;
    }

    public String getChucVu() {
        return chucVu410;
    }

    public void setChucVu(String chucVu410) {
        this.chucVu410 = chucVu410;
    }

    public String getId() {
        return id410;
    }

    public void setId(String id410) {
        this.id410 = id410;
    }

    public String getName() {
        return name410;
    }

    public void setName(String name410) {
        this.name410 = name410;
    }

    public String getUserName() {
        return userName410;
    }

    public void setUserName(String userName410) {
        this.userName410 = userName410;
    }

    public String getEmail() {
        return email410;
    }

    public void setEmail(String email410) {
        this.email410 = email410;
    }

    public String getPassword() {
        return password410;
    }

    public void setPassword(String password) {
        this.password410 = password410;
    }
}
