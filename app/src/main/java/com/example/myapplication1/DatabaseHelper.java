package com.example.myapplication1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "FitnesDb.db";
    private static final int SCHEMA = 1;

    static final String COLUMN_ID = "_id";
    static final String COLUMN_TraininDate = "TrainingDate";
    static final String COLUMN_PULSE = "Pulse";
    static final String COLUMN_WEIGHT = "Weight";
    static final String COLUMN_USERID = "UserId";
    private static String DB_PATH;
    private Context myContext;

    public String TableName = "UserMetrics";

    DatabaseHelper(Context context) {
        super(context, DB_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TableName + " (" + COLUMN_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_TraininDate
                + " TEXT, " + COLUMN_USERID + " INTEGER, "
                + COLUMN_WEIGHT + " INTEGER, "
                + COLUMN_PULSE + " INTEGER);");

        sqLiteDatabase.execSQL("INSERT INTO "+ TableName +" (" + COLUMN_TraininDate
                + ", " + COLUMN_USERID  + ", " + COLUMN_WEIGHT +
                ", " + COLUMN_PULSE +
                ") VALUES ('2022/03/21 21:10:31', 0, 65, 75);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public SQLiteDatabase open() {
        SQLiteDatabase database = getWritableDatabase();
        return database;
    }

}
