package com.example.ui_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin410;
    TextView clickforregister410;
    EditText lg_username410, lg_password410;
    SqliteHelper db410 = new SqliteHelper(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        connect();
        Intent intent = getIntent();
        String login_name410 = intent.getStringExtra("name");
        String login_email410 = intent.getStringExtra("email");
        String login_username410 = intent.getStringExtra("username");
        String login_password410 = intent.getStringExtra("pw");


        lg_username410.setText(login_username410);
        lg_password410.setText(login_password410);

        btnLogin410.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username410 = lg_username410.getText().toString();
                String pw410 = lg_password410.getText().toString();
                User currentUser410 = db410.Authenticate(new User(null, null, null, username410, pw410));
                if (currentUser410 != null) {
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("username", username410);
                    intent.putExtra("pw", pw410);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Tên đăng nhập hoặc mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
                }
            }
        });
        clickforregister410.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void connect() {
        btnLogin410 = (Button) findViewById(R.id.btn_login);
        clickforregister410 = (TextView) findViewById(R.id.clickforregister);
        lg_username410 = (EditText) findViewById(R.id.lg_username);
        lg_password410 = (EditText) findViewById(R.id.lg_password);

    }
}
