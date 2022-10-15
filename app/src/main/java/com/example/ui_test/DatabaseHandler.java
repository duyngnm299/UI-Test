package com.example.ui_test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "QuaLiSinhVien";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "SinhVien";
    private static final String KEY_ID = "id" ;
    private static final String KEY_NAME = "name";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_ID_STUDENT = "id_student";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PHONE_NUMBER = "phone_number";
    private static final String KEY_CLASS = "class";
    private static final String KEY_AVATAR = "avatar";







    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String script = "CREATE TABLE " + TABLE_NAME + " ("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_NAME + " TEXT,"
                + KEY_ADDRESS + " TEXT,"
                + KEY_ID_STUDENT + " TEXT,"
                + KEY_AVATAR + " INTEGER,"
                + KEY_EMAIL + " TEXT,"
                + KEY_PHONE_NUMBER + " TEXT,"
                + KEY_CLASS + " TEXT)";
        // Execute Script.
        db.execSQL(script);

//        String create_students_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)", TABLE_NAME, KEY_ID, KEY_NAME, KEY_ADDRESS, KEY_ID_STUDENT, KEY_AVATAR, KEY_EMAIL, KEY_PHONE_NUMBER, KEY_CLASS );
//        db.execSQL(create_students_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_students_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_students_table);

        onCreate(db);
    }

    public void createDefaultNotesIfNeed()  {
        int count = this.getNotesCount();
        if(count == 0 ) {
            SinhVien sinhVien1 = new SinhVien("Nguyễn Ngọc Mạnh Duy","Quang Nam, Viet Nam", "1811505310410", R.drawable.ic_user, "manhduy2992000@mail.com", "0962729658", "18T4");
            SinhVien sinhVien2 = new SinhVien("Nguyễn Ngọc Xuân","Quang Nam, Viet Nam", "1811505310415", R.drawable.us, "nngxuan@mail.com", "0382270397", "18T4");
            SinhVien sinhVien3 = new SinhVien("Lê Thị Phượng","Quang Nam, Viet Nam", "1811505310430", R.drawable.us1, "ltphuong@mail.com", "0332630696", "18T4");
            SinhVien sinhVien4 = new SinhVien("Nguyễn Lê Thanh Tuyền","Quang Nam, Viet Nam", "1811505310433", R.drawable.us2, "nlttuyen@mail.com", "0367554998", "18T4");
            SinhVien sinhVien5 = new SinhVien("Võ Duy Khôi","Quang Nam, Viet Nam", "1811505310418", R.drawable.us3, "vduykhoi@mail.com", "0366998153", "18T4");
            SinhVien sinhVien6 = new SinhVien("Nguyễn Thị Lệ Thủy","Quang Nam, Viet Nam", "1811505310431", R.drawable.us4, "ntlt0505@mail.com", "0333894247", "18T4");
            SinhVien sinhVien7 = new SinhVien("Nguyễn Văn Tân","Quang Nam, Viet Nam", "1811505310429", R.drawable.us5, "vantan12@mail.com", "0912659793", "18T4");
            SinhVien sinhVien8 = new SinhVien("Nguyễn Văn Tú","Quang Nam, Viet Nam", "1811505310435", R.drawable.us, "nvtu15@mail.com", "0905096687", "18T4");
            SinhVien sinhVien9 = new SinhVien("Văn Thị Hoa","Quang Nam, Viet Nam", "1811505310417", R.drawable.us1, "vthoa13@mail.com", "0336325892", "18T4");
            SinhVien sinhVien10 = new SinhVien("Nguyễn Cảm","Quang Nam, Viet Nam", "1811505310405", R.drawable.us2, "ngcam123@mail.com", "0937156480", "18T4");

            this.addStudent(sinhVien1);
            this.addStudent(sinhVien2);
            this.addStudent(sinhVien3);
            this.addStudent(sinhVien4);
            this.addStudent(sinhVien5);
            this.addStudent(sinhVien6);
            this.addStudent(sinhVien7);
            this.addStudent(sinhVien8);
            this.addStudent(sinhVien9);
            this.addStudent(sinhVien10);
        }
    }

    public void addStudent(SinhVien sinhVien) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, sinhVien.getTen());
        values.put(KEY_ADDRESS, sinhVien.getDiachi());
        values.put(KEY_ID_STUDENT, sinhVien.getMaSV());
        values.put(KEY_AVATAR, sinhVien.getAvatar());
        values.put(KEY_EMAIL, sinhVien.getEmail());
        values.put(KEY_PHONE_NUMBER, sinhVien.getSdt());
        values.put(KEY_CLASS, sinhVien.getLopSH());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public SinhVien getStudent(String name) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null, KEY_NAME + " = ?", new String[] { name },null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        SinhVien sinhVien = new SinhVien();
        sinhVien.setId(Integer.parseInt(cursor.getString(0)));
        sinhVien.setTen(cursor.getString(1));
        sinhVien.setDiachi(cursor.getString(2));
        sinhVien.setMaSV(cursor.getString(3));
        sinhVien.setAvatar(Integer.parseInt(cursor.getString(4)));
        sinhVien.setEmail(cursor.getString(5));
        sinhVien.setSdt(cursor.getString(6));
        sinhVien.setLopSH(cursor.getString(7));
        return sinhVien;
    }

    public List<SinhVien> getAllStudents() {
        List<SinhVien>  sinhVienList = new ArrayList<SinhVien>();
        String query = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToFirst();

        if (cursor.moveToFirst()) {
            do {
                SinhVien sinhVien = new SinhVien();
                sinhVien.setId(Integer.parseInt(cursor.getString(0)));
                sinhVien.setTen(cursor.getString(1));
                sinhVien.setDiachi(cursor.getString(2));
                sinhVien.setMaSV(cursor.getString(3));
                sinhVien.setAvatar(Integer.parseInt(cursor.getString(4)));
                sinhVien.setEmail(cursor.getString(5));
                sinhVien.setSdt(cursor.getString(6));
                sinhVien.setLopSH(cursor.getString(7));
//                ;
                // Adding note to list
                sinhVienList.add(sinhVien);
            } while (cursor.moveToNext());
        }


//        while(cursor.isAfterLast() == false) {
//            SinhVien sinhVien = new SinhVien(cursor.getString(0),cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getString(4) , cursor.getString(5), cursor.getString(6));
//            sinhVienList.add(sinhVien);
//            cursor.moveToNext();
//        }
        return sinhVienList;
    }


    public int getNotesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();

        // return count
        return count;
    }

    public String rowCount() {
        String count;
        String countQuery = "SELECT COUNT(id) FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        if (cursor.moveToFirst()) {

            count = String.valueOf(cursor.getInt(0));
        }
        else {
            count = "0";
        }
        db.close();
        return count;


    }

    public void updateStudent(String nameUpdate, String name, String address, String maSV, String email, String SDT, String lopSH) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_ADDRESS, address);
        values.put(KEY_ID_STUDENT, maSV);

        values.put(KEY_EMAIL, email);
        values.put(KEY_PHONE_NUMBER, SDT);
        values.put(KEY_CLASS, lopSH);

        db.update(TABLE_NAME, values, KEY_NAME + " = ?", new String[] { nameUpdate });
        db.close();
    }
    public void deleteStudent(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_NAME + " = ?", new String[] { name });
        db.close();
    }

    public List<SinhVien> searchSV(String name) {
        List<SinhVien>  sinhVienList = new ArrayList<SinhVien>();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_NAME + " like '%"+name+"%'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToFirst();

        if (cursor.moveToFirst()) {
            do {
                SinhVien sinhVien = new SinhVien();
                sinhVien.setId(Integer.parseInt(cursor.getString(0)));
                sinhVien.setTen(cursor.getString(1));
                sinhVien.setDiachi(cursor.getString(2));
                sinhVien.setMaSV(cursor.getString(3));
                sinhVien.setAvatar(Integer.parseInt(cursor.getString(4)));
                sinhVien.setEmail(cursor.getString(5));
                sinhVien.setSdt(cursor.getString(6));
                sinhVien.setLopSH(cursor.getString(7));
//                ;
                // Adding note to list
                sinhVienList.add(sinhVien);
            } while (cursor.moveToNext());
        }
        return sinhVienList;
    }

}