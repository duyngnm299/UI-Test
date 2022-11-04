package com.example.ui_test;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
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
    private final List<SinhVien> sinhVienList410 = new ArrayList<SinhVien>();
    RelativeLayout header_main410;
    SinhVienAdapter adapter410;
    LinearLayout menu410;
    ListView lvSinhVien410;
    FloatingActionButton btnThem410;
    EditText edt_search410;
    ImageView btn_search410;
    TextView countSV410;
    User user410;
    SinhVien sinhVien410;

    int vitri = -1;
    DatabaseHandler db410 = new DatabaseHandler(this);
    SqliteHelper dbus410 = new SqliteHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Intent intent1 = getIntent();
        String username410 = intent1.getStringExtra("username");
        user410 = dbus410.getUser(username410);
        String usn410 = user410.getUserName();

        db410.createDefaultNotesIfNeed();
        List<SinhVien> list = db410.getAllStudents();
        sinhVienList410.addAll(list);
        AnhXa();

        String count = db410.rowCount();

        countSV410.setText(count);
//        updateSinhVien();

        adapter410 = new SinhVienAdapter(this, R.layout.activity_dong_sinh_vien, this.sinhVienList410);
        this.lvSinhVien410.setAdapter(adapter410);

        lvSinhVien410.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                vitri = i + 1;

                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("username", usn410);
                intent.putExtra("avatar", sinhVienList410.get(i).getAvatar());
                intent.putExtra("name", sinhVienList410.get(i).getTen());
                intent.putExtra("diachi", sinhVienList410.get(i).getDiachi());
                intent.putExtra("masv", sinhVienList410.get(i).getMaSV());
                intent.putExtra("email", sinhVienList410.get(i).getEmail());
                intent.putExtra("sdt", sinhVienList410.get(i).getSdt());
                intent.putExtra("lopsh", sinhVienList410.get(i).getLopSH());
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
        btnThem410.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddSinhVienActivity.class);
                intent.putExtra("username", usn410);
                startActivity(intent);
            }
        });

        menu410.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                intent.putExtra("username", usn410);
                startActivity(intent);
            }
        });
        edt_search410.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                final List<SinhVien> sinhVienList410 = new ArrayList<SinhVien>();
                List<SinhVien> list = db410.searchSV(edt_search410.getText().toString());
                sinhVienList410.addAll(list);
                adapter410 = new SinhVienAdapter(MainActivity.this, R.layout.activity_dong_sinh_vien, sinhVienList410);
                lvSinhVien410.setAdapter(adapter410);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        btn_search410.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final List<SinhVien> sinhVienList410 = new ArrayList<SinhVien>();
                List<SinhVien> list = db410.searchSV(edt_search410.getText().toString());
                sinhVienList410.addAll(list);
                adapter410 = new SinhVienAdapter(MainActivity.this, R.layout.activity_dong_sinh_vien, sinhVienList410);
                lvSinhVien410.setAdapter(adapter410);


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
        btnThem410 = (FloatingActionButton) findViewById(R.id.btnThem);

        lvSinhVien410 = (ListView) findViewById(R.id.listViewSV);

        menu410 = (LinearLayout) findViewById(R.id.menuWrapper);

        header_main410 = (RelativeLayout) findViewById(R.id.header_main);

        edt_search410 = (EditText) findViewById(R.id.edt_search);
        btn_search410 = (ImageView) findViewById(R.id.btn_search);

        countSV410 = (TextView) findViewById(R.id.countSV);
    }

}