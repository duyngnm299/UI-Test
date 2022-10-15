package com.example.ui_test;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class ProfileActivity extends AppCompatActivity {

    User user;
    ImageView btnBack, btnSave, profile_avatar;
    EditText profile_name, profile_email, profile_username;
    TextView profile_pw, profile_chucvu;
    SqliteHelper db = new SqliteHelper(this);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        AnhXa();
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        user = db.getUser(username);
        String usnn = user.getUserName();

        profile_avatar.setImageResource(R.drawable.ic_user);
        profile_name.setText(user.getName());
        profile_email.setText(user.getEmail());
        profile_chucvu.setText(user.getChucVu());
        profile_username.setText(user.getUserName());
        profile_pw.setText(user.getPassword());


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ProfileActivity.this, SettingsActivity.class);
                intent.putExtra("username", usnn);
                startActivity(intent);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, "Đã lưu thay đổi!", Toast.LENGTH_SHORT).show();
                db.updateUser(usnn, new User(profile_name.getText().toString(), profile_email.getText().toString(), profile_chucvu.getText().toString(), profile_username.getText().toString(), profile_pw.getText().toString()));
                Intent intent = new Intent(ProfileActivity.this, SettingsActivity.class);
                intent.putExtra("username", usnn);
                startActivity(intent);


            }
        });
    }

    private void AnhXa() {
        btnBack = (ImageView) findViewById(R.id.profile_back);
        btnSave = (ImageView) findViewById(R.id.profile_save);
        profile_avatar = (ImageView) findViewById(R.id.profile_avatar);

        profile_name = (EditText) findViewById(R.id.profile_name);
        profile_email = (EditText) findViewById(R.id.profile_email);
        profile_chucvu = (TextView) findViewById(R.id.profile_chucvu);
        profile_username = (EditText) findViewById(R.id.profile_username);
        profile_pw = (TextView) findViewById(R.id.profile_pw);



    }
}
