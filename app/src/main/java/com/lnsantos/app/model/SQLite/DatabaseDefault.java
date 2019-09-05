package com.lnsantos.app.model.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lnsantos.app.model.domain.User;
import com.lnsantos.app.model.utils.Constant;

public class DatabaseDefault extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "shope";
    static final Integer DATABASE_VERSION = 1;

    private static String tableUser = "USER";
    private static String id = "ID";
    private static String name = "NAME";
    private static String lastname = "LAST_NAME";
    private static String email = "EMAIL";
    private static String password = "PASSWORD";

    private static final String TABLE_USER = "CREATE TABLE " + tableUser + "( " + id + " INTERGER PRIMARY KEY AUTO_INCREMENT, "
            + name + " TEXT, " + lastname + " TEXT, " + email + " TEXT, " + password + "TEXT ) ;";

    private Constant constant;
    private SQLiteDatabase db;
    private Context context;

    public DatabaseDefault(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = getWritableDatabase();
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Boolean newUser(User c){
        ContentValues cv = new ContentValues();
        cv.put(name,c.getName());
        cv.put(lastname,c.getLastname());
        cv.put(email,c.getEmail());
        cv.put(password,c.getPassword());
        return db.insert(tableUser,null,cv) > 0;
    }
}
