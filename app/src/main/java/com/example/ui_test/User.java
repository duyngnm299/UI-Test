package com.example.ui_test;

public class User {
    public String id;
    public String name;
    public String userName;
    public String chucVu;
    public String email;
    public String password;



    public User() {}

    public User(String password) {
        this.password = password;
    }

    public User(String name, String email, String chucVu, String userName, String password) {
        this.name = name;
        this.email = email;
        this.chucVu = chucVu;
        this.userName = userName;
        this.password = password;
    }
    public User(String id, String name, String email, String chucVu, String userName, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.chucVu = chucVu;
        this.userName = userName;
        this.password = password;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
