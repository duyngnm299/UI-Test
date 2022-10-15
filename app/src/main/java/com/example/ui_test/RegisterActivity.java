package com.example.ui_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Button btnRegister;
    ImageView backforlogin;
    TextView tvSpinner;
    EditText dk_name, dk_email, dk_userName, dk_password, dk_repassword;
    SqliteHelper db = new SqliteHelper(this);
    private Spinner spinner;
    String selected;
    private static final String[] paths = {"Giảng viên", "Phòng CTSV", "Phòng đào tạo"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        connect();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(RegisterActivity.this,
                android.R.layout.simple_spinner_item,paths);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = dk_name.getText().toString();
                String email = dk_email.getText().toString();
                String chucVu = tvSpinner.getText().toString();
                String userName = dk_userName.getText().toString();
                String pass = dk_password.getText().toString();
                String cfpass = dk_repassword.getText().toString();

                if (db.isUsernameExists(userName) == true) {
                    Toast.makeText(RegisterActivity.this, "Tên đăng nhập đã tồn tại!", Toast.LENGTH_SHORT).show();
                } else if ( name.isEmpty() || email.isEmpty() || userName.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                } else if (pass.length() < 8) {
                    Toast.makeText(RegisterActivity.this, "Mật khẩu phải có ít nhất 8 kí tự!", Toast.LENGTH_SHORT).show();
                }
                else if (pass.equals(cfpass) ){
                    db.addUser(new User(name, email, chucVu, userName, pass));
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("email", email);
                    intent.putExtra("username", userName);
                    intent.putExtra("pw", pass);
                    startActivity(intent);
                    Toast.makeText(RegisterActivity.this, "Đăng kí thành công!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(RegisterActivity.this, "Mật khẩu không trùng khớp!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        backforlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);

                startActivity(intent);
            }
        });
    }

    private void connect() {
        spinner = (Spinner)findViewById(R.id.spinner);
        tvSpinner = (TextView) findViewById(R.id.tvSpinner);
        btnRegister = (Button) findViewById(R.id.btn_register);
        backforlogin = (ImageView) findViewById(R.id.backforlogin);
        dk_userName = (EditText) findViewById(R.id.dk_userName);
        dk_name = (EditText) findViewById(R.id.dk_name);
        dk_email = (EditText) findViewById(R.id.dk_email);
        dk_password = (EditText) findViewById(R.id.dk_password);
        dk_repassword = (EditText) findViewById(R.id.dk_repassword);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                selected = spinner.getSelectedItem().toString();
                spinner.setSelection(0);
                tvSpinner.setText(selected);
                break;
            case 1:
                selected = spinner.getSelectedItem().toString();
                spinner.setSelection(1);
                tvSpinner.setText(selected);
                break;
            case 2:
                selected = spinner.getSelectedItem().toString();
                spinner.setSelection(2);
                tvSpinner.setText(selected);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
