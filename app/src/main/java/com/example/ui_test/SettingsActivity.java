package com.example.ui_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    User user410;
    LinearLayout home410;
    TextView profile410, change_pw410, logout410;
    SqliteHelper db410 = new SqliteHelper(this);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        AnhXa();
        Intent intent1 = getIntent();
        String username410 = intent1.getStringExtra("username");
        user410 = db410.getUser(username410);
        String usn410 = user410.getUserName();
        String pw410 = user410.getPassword();

        home410.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                intent.putExtra("username", usn410);
                startActivity(intent);
            }
        });
        profile410.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SettingsActivity.this, ProfileActivity.class);
                intent.putExtra("username", usn410);
                startActivity(intent);
            }
        });

        change_pw410.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SettingsActivity.this, ChangePasswordActivity.class);
                intent.putExtra("username", usn410);
                intent.putExtra("pw", pw410);
                startActivity(intent);
            }
        });

        logout410.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingsActivity.this, "Đã đăng xuất!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SettingsActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }


    private void AnhXa() {
        profile410 = (TextView) findViewById(R.id.profile);
        change_pw410 = (TextView) findViewById(R.id.changePassword);
        logout410 = (TextView) findViewById(R.id.logout);
        home410 = (LinearLayout) findViewById(R.id.homeWrapper);
    }
}