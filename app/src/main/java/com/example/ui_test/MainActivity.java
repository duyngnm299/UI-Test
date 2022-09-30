package com.example.ui_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


import android.os.Bundle;
import android.widget.ListView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvSinhVien;
    ArrayList<SinhVien> sinhVienArrayList;
    SinhVienAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();



        adapter = new SinhVienAdapter(this, R.layout.activity_dong_sinh_vien, sinhVienArrayList);
        lvSinhVien.setAdapter(adapter);
    }
    private void AnhXa() {
        lvSinhVien = (ListView) findViewById(R.id.listViewSV);
        sinhVienArrayList = new ArrayList<>();
        sinhVienArrayList.add(new SinhVien("Nguyễn Ngọc Mạnh Duy", "1811505310410", R.drawable.ic_user));
        sinhVienArrayList.add(new SinhVien("Nguyễn Văn A", "1811505310415", R.drawable.us));
        sinhVienArrayList.add(new SinhVien("Nguyễn Văn B", "1811505310416", R.drawable.us1));


    }
}