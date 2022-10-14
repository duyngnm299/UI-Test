package com.example.ui_test;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final List<SinhVien> sinhVienList = new ArrayList<SinhVien>();
    RelativeLayout header_main;
    SinhVienAdapter adapter;
    LinearLayout menu;
    ListView lvSinhVien;
    FloatingActionButton btnThem;
    User user;
    int vitri = -1;
    DatabaseHandler db = new DatabaseHandler(this);
    SqliteHelper dbus = new SqliteHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent1 = getIntent();
        String username = intent1.getStringExtra("username");
        user = dbus.getUser(username);
        String usn = user.getUserName();

        db.createDefaultNotesIfNeed();
        List<SinhVien> list = db.getAllStudents();
        sinhVienList.addAll(list);
        AnhXa();

//        updateSinhVien();

        adapter = new SinhVienAdapter(this, R.layout.activity_dong_sinh_vien, this.sinhVienList);
        this.lvSinhVien.setAdapter(adapter);

        lvSinhVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                vitri = i + 1;
//                Toast.makeText(MainActivity.this, "a" + vitri, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("username", usn);
                intent.putExtra("avatar", sinhVienList.get(i).getAvatar());
                intent.putExtra("name", sinhVienList.get(i).getTen());
                intent.putExtra("diachi", sinhVienList.get(i).getDiachi());
                intent.putExtra("masv", sinhVienList.get(i).getMaSV());
                intent.putExtra("email", sinhVienList.get(i).getEmail());
                intent.putExtra("sdt", sinhVienList.get(i).getSdt());
                intent.putExtra("lopsh", sinhVienList.get(i).getLopSH());
                intent.putExtra("index", vitri);
                startActivity(intent);
            }
        });

//        lvSinhVien.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//            }
//        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddSinhVienActivity.class);
                intent.putExtra("username", usn);
                startActivity(intent);
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                intent.putExtra("username", usn);
                startActivity(intent);
            }
        });
    }

//    private void updateSinhVien() {
//        Intent intent = getIntent();
//        String update_name = intent.getStringExtra("update_name");
//        String update_address = intent.getStringExtra("update_address");
//        String update_maSV = intent.getStringExtra("update_maSV");
//        String update_email = intent.getStringExtra("update_email");
//        String update_sdt = intent.getStringExtra("update_sdt");
//        String update_lopSH = intent.getStringExtra("update_lopSH");
//        int index = intent.getIntExtra("index", -1);
//        Toast.makeText(this, "a"+index, Toast.LENGTH_SHORT).show();
////        db.getStudent(vitri);
//        db.updateStudent(String.valueOf(index), update_name, update_address, update_maSV, update_email, update_sdt, update_lopSH);
////        adapter.notifyDataSetChanged();
//
//        db.getAllStudents();
//    }


    private void AnhXa() {
        btnThem = (FloatingActionButton) findViewById(R.id.btnThem);

        lvSinhVien = (ListView) findViewById(R.id.listViewSV);

        menu = (LinearLayout) findViewById(R.id.menuWrapper);

        header_main = (RelativeLayout) findViewById(R.id.header_main);
    }

}