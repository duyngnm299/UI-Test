package com.example.ui_test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {
    User user;
    ImageView btnBack, btnSave, btnDelete;
    ImageView details_avatar;
    TextView details_name, details_address, details_maSV, details_Email, details_SDT, details_lopSH;

    DatabaseHandler db = new DatabaseHandler(this);
    SqliteHelper dbus = new SqliteHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);
        AnhXa();
        showSinhVien();

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        user = dbus.getUser(username);
        String usn = user.getUserName();


        btnSave = (ImageView) findViewById(R.id.btnSave);
        btnDelete = (ImageView) findViewById(R.id.btnDelete);

        btnBack = (ImageView) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
                intent.putExtra("username", usn);
                startActivity(intent);
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog("Xác nhận lưu ", "Bạn có muốn lưu thay đổi này ?", R.drawable.ic_baseline_saved_24, "save");
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = details_name.getText().toString();

                openDialog("Xác nhận xóa ", "Bạn có chắc rằng mình muốn xóa " + name + " ?", R.drawable.ic_baseline_deleted_24, "delete");
            }
        });
    }
    private void showSinhVien() {
        AnhXa();
        Intent intent = getIntent();
        int avatar = intent.getIntExtra("avatar", 0);
        String name = intent.getStringExtra("name");
        String diaChi = intent.getStringExtra("diachi");
        String maSV = intent.getStringExtra("masv");
        String email = intent.getStringExtra("email");
        String sdt = intent.getStringExtra("sdt");
        String lopSH = intent.getStringExtra("lopsh");
        String index = intent.getStringExtra("index");
        details_avatar.setImageResource(avatar);
        details_name.setText(name);
        details_address.setText(diaChi);
        details_maSV.setText(maSV);
        details_Email.setText(email);
        details_SDT.setText(sdt);
        details_lopSH.setText(lopSH);
    }

    private void updateSinhVien() {

        AnhXa();


        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        Toast.makeText(this, "Đã lưu thay đổi!", Toast.LENGTH_SHORT).show();
        db.updateStudent(name, details_name.getText().toString(), details_address.getText().toString(), details_maSV.getText().toString(), details_Email.getText().toString(), details_SDT.getText().toString(), details_lopSH.getText().toString());

    }

    private void deleteSinhVien() {
        AnhXa();
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");


        Toast.makeText(this, "Đã xóa " + name + " !", Toast.LENGTH_SHORT).show();
        db.deleteStudent(name);
    }

    private void AnhXa() {
        details_avatar = (ImageView) findViewById(R.id.details_avatar);
        details_name = (TextView) findViewById(R.id.details_name);
        details_address = (TextView) findViewById(R.id.details_address);
        details_maSV = (TextView) findViewById(R.id.details_maSV);
        details_Email = (TextView) findViewById(R.id.details_Email);
        details_SDT = (TextView) findViewById(R.id.details_SDT);
        details_lopSH = (TextView) findViewById(R.id.details_lopSH);


    }
    public void openDialog(String title,String message, int icon, String action) {
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        user = dbus.getUser(username);
        String usn = user.getUserName();

        AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(
                this);

        alertDialog2.setTitle(title);

        alertDialog2.setMessage(message);

        alertDialog2.setIcon(icon);


        alertDialog2.setPositiveButton("XÁC NHẬN",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog
                        if (action == "delete") {
                            deleteSinhVien();
                            Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
                            intent.putExtra("username", usn);
                            startActivity(intent);
                        } else if (action == "save") {
                            updateSinhVien();
                            Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
                            intent.putExtra("username", usn);
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


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}