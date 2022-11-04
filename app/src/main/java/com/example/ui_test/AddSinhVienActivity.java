package com.example.ui_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddSinhVienActivity extends AppCompatActivity {
    User user410;
    ImageView btn_Add_Back410, btn_Save410;
    EditText add_name410, add_address410, add_maSV410, add_Email410, add_SDT410, add_lopSH410;
    DatabaseHandler db410 = new DatabaseHandler(this);
    SqliteHelper dbus410 = new SqliteHelper(this);


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_sinh_vien);
        AnhXa();

        Intent intent = getIntent();
        String username410 = intent.getStringExtra("username");
        user410 = dbus410.getUser(username410);
        String usn410 = user410.getUserName();

        btn_Add_Back410.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddSinhVienActivity.this, MainActivity.class);
                intent.putExtra("username", usn410);
                startActivity(intent);
            }
        });

        btn_Save410.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name410 = add_name410.getText().toString();
                String address410 = add_address410.getText().toString();
                String maSV410 = add_maSV410.getText().toString();
                String email410 = add_Email410.getText().toString();
                String sdt410 = add_SDT410.getText().toString();
                String lopSH410 = add_lopSH410.getText().toString();
                db410.addStudent(new SinhVien(name410, address410, maSV410, R.drawable.us, email410, sdt410, lopSH410));
                Toast.makeText(AddSinhVienActivity.this, "Đã thêm!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddSinhVienActivity.this, MainActivity.class);
                intent.putExtra("username", usn410);
                startActivity(intent);
            }
        });

    }
    private void AnhXa() {
        btn_Add_Back410 = (ImageView) findViewById(R.id.btn_Add_Back);
        btn_Save410 = (ImageView) findViewById(R.id.btnSave);

        add_name410 = (EditText) findViewById(R.id.add_name);
        add_address410 = (EditText) findViewById(R.id.add_address);
        add_maSV410 = (EditText) findViewById(R.id.add_maSV);
        add_Email410 = (EditText) findViewById(R.id.add_Email);
        add_SDT410 = (EditText) findViewById(R.id.add_SDT);
        add_lopSH410 = (EditText) findViewById(R.id.add_lopSH);

    }

}
