package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'RITIKA', 'nv67@gmail.com','ABC123','9967453089', 90000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'PRANJAL', 'ag790@gmail.com','BCC1258','9745902659', 140000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'SAUMYA', 'yk900@gmail.com','DEF8896','7856209878', 29000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1258,'RAHUL', 'rk321@gmail.com','DDC7752','9055782980', 58000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'RASHIKA', 'rg967@gmail.com','AQW3669','8067453980', 70500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'NIKHIL', 'nik0@gmail.com','POP8855','9806458907', 8500)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'SAUMYA', 'ssw32@gmail.com','BVV1207','8895640215', 40800)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'SHRUTI', 'sh78@gmail.com','YUI4522','9985021539', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'JAYA', 'jju90@gmail.com','IOI6582','9309565238', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'ROY', 'rae45@gmail.com','POI5450','8292591201', 9900)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'SANGAM', 'ss232@gmail.com','BOI2656','9015641200', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'JEETESH', 'jeet56@gmail.com','BVB1203','9995641999', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1122,'AMAN', 'ak89@gmail.com','BBT5566','9119541001', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(9512,'PANKAJ', 'pp09@gmail.com','GGH2236','6254642205', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7530,'NEERJA ', 'nn6@gmail.com','TGT6692','6893641266', 1010)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}