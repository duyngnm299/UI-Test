package com.example.ui_test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Set;

public class ChangePasswordActivity extends AppCompatActivity {
    User user410;
    ImageView back_btn410;
    EditText current_pw410, newpw410, renewpw410;
    Button btn_cpw410;
    SqliteHelper db410 = new SqliteHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        AnhXa();
        Intent intent1 = getIntent();
        String username410 = intent1.getStringExtra("username");
        user410 = db410.getUser(username410);
        String usn410 = user410.getUserName();
        String pw410 = user410.getPassword();
//        String crpw = current_pw.getText().toString();
//        String npw = newpw.getText().toString();
//        String rnpw = renewpw.getText().toString();

        back_btn410.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChangePasswordActivity.this, SettingsActivity.class);
                intent.putExtra("username", usn410);
                startActivity(intent);
            }
        });

        btn_cpw410.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!pw410.equals(current_pw410.getText().toString())) {
                    Toast.makeText(ChangePasswordActivity.this, "Mật khẩu hiện tại không chính xác!", Toast.LENGTH_SHORT).show();
                } else if (newpw410.getText().toString().isEmpty() || renewpw410.getText().toString().isEmpty() || !newpw410.getText().toString().equals(renewpw410.getText().toString())) {
                    Toast.makeText(ChangePasswordActivity.this, "Mật khẩu không khớp!", Toast.LENGTH_SHORT).show();
                } else if (newpw410.getText().toString().length() < 8  || renewpw410.getText().toString().length() < 8) {
                    Toast.makeText(ChangePasswordActivity.this, "Mật khẩu phải có ít nhất 8 kí tự!", Toast.LENGTH_SHORT).show();
                }
                else {
                    openDialog("Xác nhận thay đổi", "Bạn có chắc chắn muốn lưu thay đổi này?", R.drawable.ic_baseline_saved_24, "submit");
                }
            }
        });
    }

    private void AnhXa() {
        current_pw410 = (EditText) findViewById(R.id.current_pw);
        newpw410 = (EditText) findViewById(R.id.newpw);
        renewpw410 = (EditText) findViewById(R.id.renewpw);
        btn_cpw410 = (Button) findViewById(R.id.btn_cpw);
        back_btn410 = (ImageView) findViewById(R.id.back_btn);

    }

    public void openDialog(String title,String message, int icon, String action) {
        Intent intent = getIntent();
        String username410 = intent.getStringExtra("username");
        user410 = db410.getUser(username410);
        String usn410 = user410.getUserName();

        AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(
                this);

        alertDialog2.setTitle(title);

        alertDialog2.setMessage(message);

        alertDialog2.setIcon(icon);


        alertDialog2.setPositiveButton("XÁC NHẬN",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        // Write your code here to execute after dialog
                        if (action == "submit") {
                                db410.updatePassword(username410, new User(newpw410.getText().toString()));
                                Toast.makeText(ChangePasswordActivity.this, "Đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(ChangePasswordActivity.this, SettingsActivity.class);
                                intent.putExtra("username", usn410);
                                startActivity(intent);
                        }
                    }
                });

        alertDialog2.setNegativeButton("HỦY",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        alertDialog2.show();
    }
}