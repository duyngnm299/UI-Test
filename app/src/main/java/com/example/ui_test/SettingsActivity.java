package com.example.ui_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    User user;
    LinearLayout home;
    TextView profile, change_pw, logout;
    SqliteHelper db = new SqliteHelper(this);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        AnhXa();
        Intent intent1 = getIntent();
        String username = intent1.getStringExtra("username");
        user = db.getUser(username);
        String usn = user.getUserName();
        String pw = user.getPassword();

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                intent.putExtra("username", usn);
                startActivity(intent);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SettingsActivity.this, ProfileActivity.class);
                intent.putExtra("username", usn);
                startActivity(intent);
            }
        });

        change_pw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SettingsActivity.this, ChangePasswordActivity.class);
                intent.putExtra("username", usn);
                intent.putExtra("pw", pw);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingsActivity.this, "Đã đăng xuất!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SettingsActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }


    private void AnhXa() {
        profile = (TextView) findViewById(R.id.profile);
        change_pw = (TextView) findViewById(R.id.changePassword);
        logout = (TextView) findViewById(R.id.logout);
        home = (LinearLayout) findViewById(R.id.homeWrapper);
    }
}