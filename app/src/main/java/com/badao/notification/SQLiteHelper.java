package com.badao.notification;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "notification.db";
    private static int DATABASE_VERSION = 1;

    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION );
    }
    protected SQLiteDatabase sqlRead = getReadableDatabase();
    protected SQLiteDatabase sqlWrite = getWritableDatabase();

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String notificationDB = "CREATE TABLE IF NOT EXISTS notifications (\n" +
                "  id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "  title  TEXT NOT NULL,\n" +
                "  content TEXT NOT NULL,\n" +
                "  created_at VARCHAR(255) NOT NULL\n" +
                ");\n";
        sqLiteDatabase.execSQL(notificationDB);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
