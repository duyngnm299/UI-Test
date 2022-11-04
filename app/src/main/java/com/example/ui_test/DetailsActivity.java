package com.example.ui_test;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
public class DetailsActivity extends AppCompatActivity {

    User user410;
    ImageView btnBack410, btnSave410, btnDelete410;
    ImageView details_avatar410;
    TextView details_name410, details_address410, details_maSV410, details_Email410, details_SDT410, details_lopSH410;

    DatabaseHandler db410 = new DatabaseHandler(this);
    SqliteHelper dbus410 = new SqliteHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);
        AnhXa();
        showSinhVien();

        Intent intent = getIntent();
        String username410 = intent.getStringExtra("username");
        user410 = dbus410.getUser(username410);
        String usn410 = user410.getUserName();


        btnSave410 = (ImageView) findViewById(R.id.btnSave);
        btnDelete410 = (ImageView) findViewById(R.id.btnDelete);

        btnBack410 = (ImageView) findViewById(R.id.btnBack);
        btnBack410.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
                intent.putExtra("username", usn410);
                startActivity(intent);
            }
        });
        btnSave410.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog("Xác nhận lưu ", "Bạn có muốn lưu thay đổi này ?", R.drawable.ic_baseline_saved_24, "save");
            }
        });

        btnDelete410.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name410 = details_name410.getText().toString();

                openDialog("Xác nhận xóa ", "Bạn có chắc rằng mình muốn xóa " + name410 + " ?", R.drawable.ic_baseline_deleted_24, "delete");
            }
        });
    }
    private void showSinhVien() {
        AnhXa();
        Intent intent = getIntent();
        int avatar410 = intent.getIntExtra("avatar", 0);
        String name410 = intent.getStringExtra("name");
        String diaChi410 = intent.getStringExtra("diachi");
        String maSV410 = intent.getStringExtra("masv");
        String email410 = intent.getStringExtra("email");
        String sdt410 = intent.getStringExtra("sdt");
        String lopSH410 = intent.getStringExtra("lopsh");
        String index410 = intent.getStringExtra("index");
        details_avatar410.setImageResource(avatar410);
        details_name410.setText(name410);
        details_address410.setText(diaChi410);
        details_maSV410.setText(maSV410);
        details_Email410.setText(email410);
        details_SDT410.setText(sdt410);
        details_lopSH410.setText(lopSH410);
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
        String name410 = intent.getStringExtra("name");


        Toast.makeText(this, "Đã xóa " + name410 + " !", Toast.LENGTH_SHORT).show();
        db410.deleteStudent(name410);
    }

    private void AnhXa() {
        details_avatar410 = (ImageView) findViewById(R.id.details_avatar);
        details_name410 = (TextView) findViewById(R.id.details_name);
        details_address410 = (TextView) findViewById(R.id.details_address);
        details_maSV410 = (TextView) findViewById(R.id.details_maSV);
        details_Email410 = (TextView) findViewById(R.id.details_Email);
        details_SDT410 = (TextView) findViewById(R.id.details_SDT);
        details_lopSH410 = (TextView) findViewById(R.id.details_lopSH);


    }
    public void openDialog(String title,String message, int icon, String action) {
        Intent intent = getIntent();
        String username410 = intent.getStringExtra("username");
        user410 = dbus410.getUser(username410);
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
                        if (action == "delete") {
                            deleteSinhVien();
                            Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
                            intent.putExtra("username", usn410);
                            startActivity(intent);
                        } else if (action == "save") {
                            updateSinhVien();
                            Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
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