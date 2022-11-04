package com.example.ui_test;

import java.io.Serializable;

public class SinhVien implements Serializable {
    public int id410;
    public String ten410;
    public String diachi410;
    public String maSV410;
    public int avatar410;
    public String email410;
    public String sdt410;
    public String lopSH410;

    public SinhVien() {}

    public SinhVien(String ten410, String diachi410, String maSV410, int avatar410, String email410, String sdt410, String lopSH410) {
        this.ten410 = ten410;
        this.diachi410 = diachi410;
        this.maSV410 = maSV410;
        this.avatar410 = avatar410;
        this.email410 = email410;
        this.sdt410 = sdt410;
        this.lopSH410 = lopSH410;
    }
    public SinhVien(int id410, String ten410, String diachi410, String maSV410, int avatar410, String email410, String sdt410, String lopSH410) {
        this.id410 = id410;
        this.ten410 = ten410;
        this.diachi410 = diachi410;
        this.maSV410 = maSV410;
        this.avatar410 = avatar410;
        this.email410= email410;
        this.sdt410 = sdt410;
        this.lopSH410 = lopSH410;
    }



    public int getId() {
        return id410;
    }

    public void setId(int id410) {
        this.id410 = id410;
    }

    public String getTen() {
        return ten410;
    }

    public void setTen(String ten410) {
        this.ten410 = ten410;
    }

    public String getDiachi() {
        return diachi410;
    }

    public void setDiachi(String diachi410) {
        this.diachi410 = diachi410;
    }

    public String getMaSV() {
        return maSV410;
    }

    public void setMaSV(String maSV410) {
        this.maSV410 = maSV410;
    }

    public int getAvatar() {
        return avatar410;
    }

    public void setAvatar(int avatar410) {
        this.avatar410 = avatar410;
    }

    public String getEmail() {
        return email410;
    }

    public void setEmail(String email410) {
        this.email410 = email410;
    }

    public String getSdt() {
        return sdt410;
    }

    public void setSdt(String sdt410) {
        this.sdt410 = sdt410;
    }

    public String getLopSH() {
        return lopSH410;
    }

    public void setLopSH(String lopSH410) {
        this.lopSH410 = lopSH410;
    }
}
