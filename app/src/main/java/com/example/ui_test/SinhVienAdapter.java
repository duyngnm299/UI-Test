package com.example.ui_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<SinhVien> sinhVienList;

    public SinhVienAdapter(Context context, int layout, List<SinhVien> sinhVienList) {
        this.context = context;
        this.layout = layout;
        this.sinhVienList = sinhVienList;
    }

    @Override
    public int getCount() {
        return sinhVienList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        TextView tvTen = (TextView) view.findViewById(R.id.tvName);
        TextView tvMaSV = (TextView) view.findViewById(R.id.tvMaSV);
        ImageView avatar = (ImageView) view.findViewById(R.id.avatar);

        SinhVien sinhVien = sinhVienList.get(i);
        tvTen.setText(sinhVien.getTen());
        tvMaSV.setText(sinhVien.getMaSV());
        avatar.setImageResource(sinhVien.getAvatar());

        return view;
    }
}
