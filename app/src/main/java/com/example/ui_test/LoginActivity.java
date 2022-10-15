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
    Button btnLogin;
    TextView clickforregister;
    EditText lg_username, lg_password;
    SqliteHelper db = new SqliteHelper(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        connect();
        Intent intent = getIntent();
        String login_name = intent.getStringExtra("name");
        String login_email = intent.getStringExtra("email");
        String login_username = intent.getStringExtra("username");
        String login_password = intent.getStringExtra("pw");


        lg_username.setText(login_username);
        lg_password.setText(login_password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = lg_username.getText().toString();
                String pw = lg_password.getText().toString();
                User currentUser = db.Authenticate(new User(null, null, null, username, pw));
                if (currentUser != null) {
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("pw", pw);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Tên đăng nhập hoặc mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
                }
            }
        });
        clickforregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void connect() {
        btnLogin = (Button) findViewById(R.id.btn_login);
        clickforregister = (TextView) findViewById(R.id.clickforregister);
        lg_username = (EditText) findViewById(R.id.lg_username);
        lg_password = (EditText) findViewById(R.id.lg_password);

    }
}
