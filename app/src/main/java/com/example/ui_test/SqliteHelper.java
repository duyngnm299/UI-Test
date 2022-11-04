package com.example.ui_test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteHelper extends SQLiteOpenHelper {

    //DATABASE NAME
    public static final String DATABASE_NAME = "usersManager";

    //DATABASE VERSION
    public static final int DATABASE_VERSION = 1;

    //TABLE NAME
    public static final String TABLE_USERS = "users";

    //TABLE USERS COLUMNS
    //ID COLUMN @primaryKey
    public static final String KEY_ID = "id";


    public static final String KEY_NAME = "name";

    //COLUMN user name
    public static final String KEY_USER_NAME = "username";

    //COLUMN email
    public static final String KEY_EMAIL = "email";

    public static final String KEY_CHUC_VU = "chucVu";


    //COLUMN password
    public static final String KEY_PASSWORD = "password";

    //SQL for creating users table
    public static final String SQL_TABLE_USERS = " CREATE TABLE " + TABLE_USERS
            + " ( "
            + KEY_ID + " INTEGER PRIMARY KEY, "
            + KEY_NAME + " TEXT, "
            + KEY_USER_NAME + " TEXT, "
            + KEY_EMAIL + " TEXT, "
            + KEY_PASSWORD + " TEXT, "
            + KEY_CHUC_VU + " TEXT"
            + " ) ";


    public SqliteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Create Table when oncreate gets called
        sqLiteDatabase.execSQL(SQL_TABLE_USERS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //drop table to create new one if database version updated
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_USERS);
    }

    //using this method we can add users to user table
    public void addUser(User user) {

        //get writable database
        SQLiteDatabase db = this.getWritableDatabase();

        //create content values to insert
        ContentValues values = new ContentValues();


        values.put(KEY_NAME, user.getName());

        //Put username in @values
        values.put(KEY_USER_NAME, user.getUserName());

        values.put(KEY_CHUC_VU, user.getChucVu());


        //Put email in @values
        values.put(KEY_EMAIL, user.getEmail());

        //Put password in @values
        values.put(KEY_PASSWORD, user.getPassword());

        // insert row
        db.insert(TABLE_USERS, null, values);
    }
    public void updateUser(String username,User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, user.getName());
        values.put(KEY_EMAIL, user.getEmail());
        values.put(KEY_CHUC_VU, user.getChucVu());
        values.put(KEY_USER_NAME, user.getUserName());
        values.put(KEY_PASSWORD, user.getPassword());
        // updating row
        db.update(TABLE_USERS, values, KEY_USER_NAME + " = ?",
                new String[]{username});
        db.close();
    }

    public void updatePassword(String username,User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PASSWORD, user.getPassword());
        // updating row
        db.update(TABLE_USERS, values, KEY_USER_NAME + " = ?",
                new String[]{username});
        db.close();
    }
    public User Authenticate(User user) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS,// Selecting Table
                new String[]{KEY_ID, KEY_NAME, KEY_CHUC_VU, KEY_USER_NAME, KEY_PASSWORD},//Selecting columns want to query
                KEY_USER_NAME + "=?",
                new String[]{user.getUserName()},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            //if cursor has value then in user database there is user associated with this given email
            User user1 = new User(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));

            //Match both passwords check they are same or not
            if (user.password.equalsIgnoreCase(user1.password)) {
                return user1;
            }
        }
        return null;
    }

    public boolean isUsernameExists(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS,// Selecting Table
                new String[]{KEY_ID, KEY_NAME, KEY_EMAIL, KEY_CHUC_VU, KEY_USER_NAME, KEY_PASSWORD},//Selecting columns want to query
                KEY_USER_NAME + "=?",
                new String[]{username},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            //if cursor has value then in user database there is user associated with this given email so return true
            return true;
        }

        //if email does not exist return false
        return false;
    }

    public User getUser(String username) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USERS, null, KEY_USER_NAME + " = ?", new String[] { username },null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        User us = new User();
        us.setId(cursor.getString(0));
        us.setName(cursor.getString(1));
        us.setUserName(cursor.getString(2));
        us.setEmail(cursor.getString(3));
        us.setPassword(cursor.getString(4));
        us.setChucVu(cursor.getString(5));
        return us;
    }

}
