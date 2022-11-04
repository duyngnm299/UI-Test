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
    Button btnRegister410;
    ImageView backforlogin410;
    TextView tvSpinner410;
    EditText dk_name410, dk_email410, dk_userName410, dk_password410, dk_repassword410;
    SqliteHelper db410 = new SqliteHelper(this);
    private Spinner spinner410;
    String selected410;
    private static final String[] paths410 = {"Giảng viên", "Phòng CTSV", "Phòng đào tạo"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        connect();
        ArrayAdapter<String> adapter410 = new ArrayAdapter<String>(RegisterActivity.this,
                android.R.layout.simple_spinner_item,paths410);
        adapter410.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner410.setAdapter(adapter410);
        spinner410.setOnItemSelectedListener(this);


        btnRegister410.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name410 = dk_name410.getText().toString();
                String email410 = dk_email410.getText().toString();
                String chucVu410 = tvSpinner410.getText().toString();
                String userName410 = dk_userName410.getText().toString();
                String pass410 = dk_password410.getText().toString();
                String cfpass410 = dk_repassword410.getText().toString();

                if (db410.isUsernameExists(userName410) == true) {
                    Toast.makeText(RegisterActivity.this, "Tên đăng nhập đã tồn tại!", Toast.LENGTH_SHORT).show();
                } else if ( name410.isEmpty() || email410.isEmpty() || userName410.isEmpty() || pass410.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                } else if (pass410.length() < 8) {
                    Toast.makeText(RegisterActivity.this, "Mật khẩu phải có ít nhất 8 kí tự!", Toast.LENGTH_SHORT).show();
                }
                else if (pass410.equals(cfpass410) ){
                    db410.addUser(new User(name410, email410, chucVu410, userName410, pass410));
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    intent.putExtra("name", name410);
                    intent.putExtra("email", email410);
                    intent.putExtra("username", userName410);
                    intent.putExtra("pw", pass410);
                    startActivity(intent);
                    Toast.makeText(RegisterActivity.this, "Đăng kí thành công!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(RegisterActivity.this, "Mật khẩu không trùng khớp!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        backforlogin410.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);

                startActivity(intent);
            }
        });
    }

    private void connect() {
        spinner410 = (Spinner)findViewById(R.id.spinner);
        tvSpinner410 = (TextView) findViewById(R.id.tvSpinner);
        btnRegister410 = (Button) findViewById(R.id.btn_register);
        backforlogin410 = (ImageView) findViewById(R.id.backforlogin);
        dk_userName410 = (EditText) findViewById(R.id.dk_userName);
        dk_name410 = (EditText) findViewById(R.id.dk_name);
        dk_email410 = (EditText) findViewById(R.id.dk_email);
        dk_password410 = (EditText) findViewById(R.id.dk_password);
        dk_repassword410 = (EditText) findViewById(R.id.dk_repassword);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                selected410 = spinner410.getSelectedItem().toString();
                spinner410.setSelection(0);
                tvSpinner410.setText(selected410);
                break;
            case 1:
                selected410 = spinner410.getSelectedItem().toString();
                spinner410.setSelection(1);
                tvSpinner410.setText(selected410);
                break;
            case 2:
                selected410 = spinner410.getSelectedItem().toString();
                spinner410.setSelection(2);
                tvSpinner410.setText(selected410);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
