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

    User user410;
    ImageView btnBack410, btnSave410, profile_avatar410;
    EditText profile_name410, profile_email410, profile_username410;
    TextView profile_pw410, profile_chucvu410;
    SqliteHelper db410 = new SqliteHelper(this);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        AnhXa();
        Intent intent = getIntent();
        String username410 = intent.getStringExtra("username");
        user410 = db410.getUser(username410);
        String usnn410 = user410.getUserName();

        profile_avatar410.setImageResource(R.drawable.ic_user);
        profile_name410.setText(user410.getName());
        profile_email410.setText(user410.getEmail());
        profile_chucvu410.setText(user410.getChucVu());
        profile_username410.setText(user410.getUserName());
        profile_pw410.setText(user410.getPassword());


        btnBack410.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ProfileActivity.this, SettingsActivity.class);
                intent.putExtra("username", usnn410);
                startActivity(intent);
            }
        });

        btnSave410.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, "Đã lưu thay đổi!", Toast.LENGTH_SHORT).show();
                db410.updateUser(usnn410, new User(profile_name410.getText().toString(), profile_email410.getText().toString(), profile_chucvu410.getText().toString(), profile_username410.getText().toString(), profile_pw410.getText().toString()));
                Intent intent = new Intent(ProfileActivity.this, SettingsActivity.class);
                intent.putExtra("username", usnn410);
                startActivity(intent);


            }
        });
    }

    private void AnhXa() {
        btnBack410 = (ImageView) findViewById(R.id.profile_back);
        btnSave410 = (ImageView) findViewById(R.id.profile_save);
        profile_avatar410 = (ImageView) findViewById(R.id.profile_avatar);

        profile_name410 = (EditText) findViewById(R.id.profile_name);
        profile_email410 = (EditText) findViewById(R.id.profile_email);
        profile_chucvu410 = (TextView) findViewById(R.id.profile_chucvu);
        profile_username410 = (EditText) findViewById(R.id.profile_username);
        profile_pw410 = (TextView) findViewById(R.id.profile_pw);



    }
}
