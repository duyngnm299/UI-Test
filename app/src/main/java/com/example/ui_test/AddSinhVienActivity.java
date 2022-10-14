package com.example.ui_test;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddSinhVienActivity extends AppCompatActivity {
    User user;
    ImageView btn_Add_Back, btn_Save;
    EditText add_name, add_address, add_maSV, add_Email, add_SDT, add_lopSH;
    DatabaseHandler db = new DatabaseHandler(this);
    SqliteHelper dbus = new SqliteHelper(this);


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_sinh_vien);
        AnhXa();

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        user = dbus.getUser(username);
        String usn = user.getUserName();

        btn_Add_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddSinhVienActivity.this, MainActivity.class);
                intent.putExtra("username", usn);
                startActivity(intent);
            }
        });

        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = add_name.getText().toString();
                String address = add_address.getText().toString();
                String maSV = add_maSV.getText().toString();
                String email = add_Email.getText().toString();
                String sdt = add_SDT.getText().toString();
                String lopSH = add_lopSH.getText().toString();
                db.addStudent(new SinhVien(name, address, maSV, R.drawable.us, email, sdt, lopSH));
                Toast.makeText(AddSinhVienActivity.this, "Đã thêm!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddSinhVienActivity.this, MainActivity.class);
                intent.putExtra("username", usn);
                startActivity(intent);
            }
        });

    }
    private void AnhXa() {
        btn_Add_Back = (ImageView) findViewById(R.id.btn_Add_Back);
        btn_Save = (ImageView) findViewById(R.id.btnSave);

        add_name = (EditText) findViewById(R.id.add_name);
        add_address = (EditText) findViewById(R.id.add_address);
        add_maSV = (EditText) findViewById(R.id.add_maSV);
        add_Email = (EditText) findViewById(R.id.add_Email);
        add_SDT = (EditText) findViewById(R.id.add_SDT);
        add_lopSH = (EditText) findViewById(R.id.add_lopSH);

    }

}
