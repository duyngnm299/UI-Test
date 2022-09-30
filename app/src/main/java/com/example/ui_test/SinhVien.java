package com.example.ui_test;

public class SinhVien {
    private String ten;
    private String maSV;
    private int hinh;

    public SinhVien(String ten, String maSV, int hinh) {
        this.ten = ten;
        this.maSV = maSV;
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
