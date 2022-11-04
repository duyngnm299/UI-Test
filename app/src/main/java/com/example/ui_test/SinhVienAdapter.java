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
    private Context context410;
    private int layout410;
    private List<SinhVien> sinhVienList410;

    public SinhVienAdapter(Context context410, int layout410, List<SinhVien> sinhVienList410) {
        this.context410 = context410;
        this.layout410 = layout410;
        this.sinhVienList410 = sinhVienList410;
    }

    @Override
    public int getCount() {
        return sinhVienList410.size();
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
    public View getView(int i, View view410, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context410.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view410 = inflater.inflate(layout410, null);
        TextView tvTen410 = (TextView) view410.findViewById(R.id.tvName);
        TextView tvMaSV410 = (TextView) view410.findViewById(R.id.tvMaSV);
        ImageView avatar410 = (ImageView) view410.findViewById(R.id.avatar);

        SinhVien sinhVien410 = sinhVienList410.get(i);
        tvTen410.setText(sinhVien410.getTen());
        tvMaSV410.setText(sinhVien410.getMaSV());
        avatar410.setImageResource(sinhVien410.getAvatar());

        return view410;
    }
}
