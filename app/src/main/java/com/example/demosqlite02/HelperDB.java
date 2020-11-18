package com.example.demosqlite02;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HelperDB extends SQLiteOpenHelper {

    public HelperDB(@Nullable Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME);
        onCreate(db);
    }

    public long insertRecord(String product_name, String image, String brand, String model, String serialnumber, String price, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Constants.C_PRODUCT_NAME, product_name);
        values.put(Constants.C_IMAGE, image);
        values.put(Constants.C_BRAND, brand);
        values.put(Constants.C_MODEL, model);
        values.put(Constants.C_SERIALNUMBER, serialnumber);
        values.put(Constants.C_PRICE, price);
        values.put(Constants.C_DESCRIPTION, description);

        long id = db.insert(Constants.TABLE_NAME, null, values);
        db.close();
        return id;
    }
}
