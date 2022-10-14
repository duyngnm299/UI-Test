package com.example.ui_test;

import java.io.Serializable;

public class SinhVien implements Serializable {
    public int id;
    public String ten;
    public String diachi;
    public String maSV;
    public int avatar;
    public String email;
    public String sdt;
    public String lopSH;

    public SinhVien() {}

    public SinhVien(String ten, String diachi, String maSV, int avatar, String email, String sdt, String lopSH) {
        this.ten = ten;
        this.diachi = diachi;
        this.maSV = maSV;
        this.avatar = avatar;
        this.email = email;
        this.sdt = sdt;
        this.lopSH = lopSH;
    }
    public SinhVien(int id, String ten, String diachi, String maSV, int avatar, String email, String sdt, String lopSH) {
        this.id = id;
        this.ten = ten;
        this.diachi = diachi;
        this.maSV = maSV;
        this.avatar = avatar;
        this.email = email;
        this.sdt = sdt;
        this.lopSH = lopSH;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getLopSH() {
        return lopSH;
    }

    public void setLopSH(String lopSH) {
        this.lopSH = lopSH;
    }
}
